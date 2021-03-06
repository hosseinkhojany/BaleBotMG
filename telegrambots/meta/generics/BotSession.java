package james_gosling.projects.balebotmg.telegrambots.meta.generics;

import james_gosling.projects.balebotmg.telegrambots.meta.generics.BotOptions;
import james_gosling.projects.balebotmg.telegrambots.meta.generics.LongPollingBot;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * Bot session interface
 */
public interface BotSession {
    void setOptions(BotOptions options);
    void setToken(String token);
    void setCallback(LongPollingBot callback);

    /**
     * Starts the bot
     */
    void start();

    /**
     * Stops the bot
     */
    void stop();

    /**
     * Check if the bot is running
     * @return True if the bot is running, false otherwise
     */
    boolean isRunning();
}
