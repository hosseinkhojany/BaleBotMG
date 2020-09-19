package james_gosling.projects.balebotmg.telegrambots.facilities;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import james_gosling.projects.balebotmg.telegrambots.bots.DefaultBotOptions;
import james_gosling.projects.balebotmg.telegrambots.facilities.proxysocketfactorys.HttpConnectionSocketFactory;
import james_gosling.projects.balebotmg.telegrambots.facilities.proxysocketfactorys.HttpSSLConnectionSocketFactory;
import james_gosling.projects.balebotmg.telegrambots.facilities.proxysocketfactorys.SocksSSLConnectionSocketFactory;
import james_gosling.projects.balebotmg.telegrambots.facilities.proxysocketfactorys.SocksConnectionSocketFactory;

import java.util.concurrent.TimeUnit;

import james_gosling.projects.balebotmg.telegrambots.bots.DefaultBotOptions;

/**
 * Created by bvn13 on 17.04.2018.
 */
public class TelegramHttpClientBuilder {

    public static CloseableHttpClient build(DefaultBotOptions options) {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .setConnectionManager(createConnectionManager(options))
                .setConnectionTimeToLive(70, TimeUnit.SECONDS)
                .setMaxConnTotal(100);
        return httpClientBuilder.build();
    }

    private static HttpClientConnectionManager createConnectionManager(DefaultBotOptions options) {
        Registry<ConnectionSocketFactory> registry;
        switch (options.getProxyType()) {
            case NO_PROXY:
                return null;
            case HTTP:
                registry = RegistryBuilder.<ConnectionSocketFactory> create()
                        .register("http", new HttpConnectionSocketFactory())
                        .register("https", new HttpSSLConnectionSocketFactory(SSLContexts.createSystemDefault())).build();
                return new PoolingHttpClientConnectionManager(registry);
            case SOCKS4:
            case SOCKS5:
                registry = RegistryBuilder.<ConnectionSocketFactory> create()
                        .register("http", new SocksConnectionSocketFactory())
                        .register("https", new SocksSSLConnectionSocketFactory(SSLContexts.createSystemDefault()))
                        .build();
                return new PoolingHttpClientConnectionManager(registry);
        }
        return null;
    }

}
