package james_gosling.projects.balebotmg.telegrambots.meta.generics;

import james_gosling.projects.balebotmg.telegrambots.meta.exceptions.TelegramApiRequestException;
import james_gosling.projects.balebotmg.telegrambots.meta.generics.WebhookBot;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * Webhook interface
 */
public interface Webhook {
    void startServer() throws TelegramApiRequestException;
    void registerWebhook(WebhookBot callback);
    void setInternalUrl(String internalUrl);
    void setKeyStore(String keyStore, String keyStorePassword) throws TelegramApiRequestException;
}
