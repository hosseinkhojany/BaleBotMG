package james_gosling.projects.balebotmg.telegrambots.meta.api.methods.updates;

import com.fasterxml.jackson.core.type.TypeReference;

import james_gosling.projects.balebotmg.telegrambots.meta.api.methods.BotApiMethod;
import james_gosling.projects.balebotmg.telegrambots.meta.api.objects.WebhookInfo;
import james_gosling.projects.balebotmg.telegrambots.meta.api.objects.ApiResponse;
import james_gosling.projects.balebotmg.telegrambots.meta.exceptions.TelegramApiRequestException;
import james_gosling.projects.balebotmg.telegrambots.meta.exceptions.TelegramApiValidationException;

import java.io.IOException;

/**
 * @author Ruben Bermudez
 * @version 2.4
 * Use this method to get current webhook status.
 * Requires no parameters.
 * On success, returns a WebhookInfo object.
 * Will throw an error, if the bot is using getUpdates.
 */
public class GetWebhookInfo extends BotApiMethod<WebhookInfo> {
    public static final String PATH = "getwebhookinfo";

    public GetWebhookInfo() {
        super();
    }

    @Override
    public String toString() {
        return "GetWebhookInfo{}";
    }

    @Override
    public String getMethod() {
        return PATH;
    }

    @Override
    public WebhookInfo deserializeResponse(String answer) throws TelegramApiRequestException {
        try {
            ApiResponse<WebhookInfo> result = OBJECT_MAPPER.readValue(answer,
                    new TypeReference<ApiResponse<WebhookInfo>>() {
                    });
            if (result.getOk()) {
                return result.getResult();
            } else {
                throw new TelegramApiRequestException("Error getting webhook info", result);
            }
        } catch (IOException e2) {
            throw new TelegramApiRequestException("Unable to deserialize response", e2);
        }
    }

    @Override
    public void validate() throws TelegramApiValidationException {
    }
}
