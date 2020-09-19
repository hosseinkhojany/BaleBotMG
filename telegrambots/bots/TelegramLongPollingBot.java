package james_gosling.projects.balebotmg.telegrambots.bots;

import james_gosling.projects.balebotmg.telegrambots.meta.ApiContext;
import james_gosling.projects.balebotmg.telegrambots.meta.exceptions.TelegramApiRequestException;
import james_gosling.projects.balebotmg.telegrambots.meta.generics.LongPollingBot;
import james_gosling.projects.balebotmg.telegrambots.util.WebhookUtils;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * Base abstract class for a bot that will get updates using
 * <a href="https://core.telegram.org/bots/api#getupdates">long-polling</a> method
 */
public abstract class TelegramLongPollingBot extends DefaultAbsSender implements LongPollingBot {
    public TelegramLongPollingBot() {
        this(ApiContext.getInstance(DefaultBotOptions.class));
    }

    public TelegramLongPollingBot(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public void clearWebhook() throws TelegramApiRequestException {
      WebhookUtils.clearWebhook(this);
    }

    @Override
    public void onClosing() {
        exe.shutdown();
    }
}