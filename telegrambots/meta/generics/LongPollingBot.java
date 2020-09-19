package james_gosling.projects.balebotmg.telegrambots.meta.generics;

import james_gosling.projects.balebotmg.telegrambots.meta.api.objects.Update;
import james_gosling.projects.balebotmg.telegrambots.meta.exceptions.TelegramApiRequestException;
import james_gosling.projects.balebotmg.telegrambots.meta.generics.BotOptions;

import java.util.List;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * @brief Callback to handle updates.
 * @date 20 of June of 2015
 */
public interface LongPollingBot {
    /**
     * This method is called when receiving updates via GetUpdates method
     * @param update Update received
     */
    void onUpdateReceived(Update update);

    /**
     * This method is called when receiving updates via GetUpdates method.
     * If not reimplemented - it just sends updates by one into {@link #onUpdateReceived(Update)}
     * @param updates list of Update received
     */
    default void onUpdatesReceived(List<Update> updates) {
        updates.forEach(this::onUpdateReceived);
    }

    /**
     * Return bot username of this bot
     */
    String getBotUsername();

    /**
     * Return bot token to access Telegram API
     */
    String getBotToken();

    /**
     * Gets options for current bot
     * @return BotOptions object with options information
     */
    BotOptions getOptions();

    /**
     * Clear current webhook (if present) calling setWebhook method with empty url.
     */
    void clearWebhook() throws TelegramApiRequestException;

    /**
     * Called when the BotSession is being closed
     */
    default void onClosing() {
    }
}
