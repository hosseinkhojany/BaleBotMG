package james_gosling.projects.balebotmg.telegrambots;

import james_gosling.projects.balebotmg.telegrambots.meta.generics.BotSession;
import james_gosling.projects.balebotmg.telegrambots.meta.generics.Webhook;
import james_gosling.projects.balebotmg.telegrambots.meta.ApiContext;
import james_gosling.projects.balebotmg.telegrambots.updatesreceivers.DefaultBotSession;
import james_gosling.projects.balebotmg.telegrambots.updatesreceivers.DefaultWebhook;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * Initialization of ApiContext
 */
public final class ApiContextInitializer {
    private ApiContextInitializer() {
    }

    public static void init() {
        ApiContext.register(BotSession.class, DefaultBotSession.class);
        ApiContext.register(Webhook.class, DefaultWebhook.class);
    }
}
