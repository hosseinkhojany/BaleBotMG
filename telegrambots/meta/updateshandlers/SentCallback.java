package james_gosling.projects.balebotmg.telegrambots.meta.updateshandlers;

import james_gosling.projects.balebotmg.telegrambots.meta.api.methods.BotApiMethod;
import james_gosling.projects.balebotmg.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.io.Serializable;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * @brief Callback to execute api method asynchronously
 * @date 10 of September of 2015
 */
public interface SentCallback<T extends Serializable> {
    /**
     * Called when the request is successful
     * @param method Method executed
     * @param response Answer from Telegram server
     */
    void onResult(BotApiMethod<T> method, T response);

    /**
     * Called when the request fails
     * @param method Method executed
     * @param apiException Answer from Telegram server (contains error information)
     */
    void onError(BotApiMethod<T> method, TelegramApiRequestException apiException);

    /**
     * Called when the http request throw an exception
     * @param method Method executed
     * @param exception Excepction thrown
     */
    void onException(BotApiMethod<T> method, Exception exception);
}
