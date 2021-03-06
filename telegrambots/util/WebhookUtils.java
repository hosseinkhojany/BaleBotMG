package james_gosling.projects.balebotmg.telegrambots.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import james_gosling.projects.balebotmg.telegrambots.bots.DefaultAbsSender;
import james_gosling.projects.balebotmg.telegrambots.bots.DefaultBotOptions;
import james_gosling.projects.balebotmg.telegrambots.facilities.TelegramHttpClientBuilder;
import james_gosling.projects.balebotmg.telegrambots.meta.ApiConstants;
import james_gosling.projects.balebotmg.telegrambots.meta.api.methods.updates.DeleteWebhook;
import james_gosling.projects.balebotmg.telegrambots.meta.api.methods.updates.SetWebhook;
import james_gosling.projects.balebotmg.telegrambots.meta.exceptions.TelegramApiException;
import james_gosling.projects.balebotmg.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static james_gosling.projects.balebotmg.telegrambots.Constants.SOCKET_TIMEOUT;


public final class WebhookUtils {
  private WebhookUtils() {

  }

  public static void setWebhook(DefaultAbsSender bot, String url, String publicCertificatePath) throws TelegramApiRequestException {
    DefaultBotOptions botOptions = bot.getOptions();

    try (CloseableHttpClient httpclient = TelegramHttpClientBuilder.build(botOptions)) {
      String requestUrl = bot.getBaseUrl() + SetWebhook.PATH;

      RequestConfig requestConfig = botOptions.getRequestConfig();
      if (requestConfig == null) {
        requestConfig = RequestConfig.copy(RequestConfig.custom().build())
                .setSocketTimeout(SOCKET_TIMEOUT)
                .setConnectTimeout(SOCKET_TIMEOUT)
                .setConnectionRequestTimeout(SOCKET_TIMEOUT).build();
      }

      HttpPost httppost = new HttpPost(requestUrl);
      httppost.setConfig(requestConfig);
      MultipartEntityBuilder builder = MultipartEntityBuilder.create();
      builder.addTextBody(SetWebhook.URL_FIELD, url);
      if (botOptions.getMaxWebhookConnections() != null) {
        builder.addTextBody(SetWebhook.MAXCONNECTIONS_FIELD, botOptions.getMaxWebhookConnections().toString());
      }
      if (botOptions.getAllowedUpdates() != null) {
        builder.addTextBody(SetWebhook.ALLOWEDUPDATES_FIELD, new JSONArray(botOptions.getAllowedUpdates()).toString());
      }
      if (publicCertificatePath != null) {
        File certificate = new File(publicCertificatePath);
        if (certificate.exists()) {
          builder.addBinaryBody(SetWebhook.CERTIFICATE_FIELD, certificate, ContentType.TEXT_PLAIN, certificate.getName());
        }
      }
      HttpEntity multipart = builder.build();
      httppost.setEntity(multipart);
      try (CloseableHttpResponse response = httpclient.execute(httppost, botOptions.getHttpContext())) {
        String responseContent = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject(responseContent);
        if (!jsonObject.getBoolean(ApiConstants.RESPONSE_FIELD_OK)) {
          throw new TelegramApiRequestException("Error setting webhook", jsonObject);
        }
      }
    } catch (JSONException e) {
      throw new TelegramApiRequestException("Error deserializing setWebhook method response", e);
    } catch (IOException e) {
      throw new TelegramApiRequestException("Error executing setWebook method", e);
    }
  }

  public static void clearWebhook(DefaultAbsSender bot) throws TelegramApiRequestException {
    try {
      boolean result = bot.execute(new DeleteWebhook());
      if (!result) {
        throw new TelegramApiRequestException("Error removing old webhook");
      }
    } catch (TelegramApiException e) {
      throw new TelegramApiRequestException("Error removing old webhook", e);
    }
  }
}
