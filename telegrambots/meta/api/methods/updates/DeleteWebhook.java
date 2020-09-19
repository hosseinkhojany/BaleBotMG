package james_gosling.projects.balebotmg.telegrambots.meta.api.methods.updates;

import com.fasterxml.jackson.core.type.TypeReference;

import james_gosling.projects.balebotmg.telegrambots.meta.api.methods.BotApiMethod;
import james_gosling.projects.balebotmg.telegrambots.meta.api.objects.ApiResponse;
import james_gosling.projects.balebotmg.telegrambots.meta.exceptions.TelegramApiRequestException;
import james_gosling.projects.balebotmg.telegrambots.meta.exceptions.TelegramApiValidationException;

import java.io.IOException;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * Use this method to receive incoming updates using long polling (wiki). An Array of Update
 * objects is returned.
 */
public class DeleteWebhook extends BotApiMethod<Boolean>{
    public static final String PATH = "deleteWebhook";

    public DeleteWebhook() {
        super();
    }

    @Override
    public String getMethod() {
        return PATH;
    }

    @Override
    public Boolean deserializeResponse(String answer) throws
            TelegramApiRequestException {
        try {
            ApiResponse<Boolean> result = OBJECT_MAPPER.readValue(answer,
                    new TypeReference<ApiResponse<Boolean>>(){});
            if (result.getOk()) {
                return result.getResult();
            } else {
                throw new TelegramApiRequestException("Error deleting webhook", result);
            }
        } catch (IOException e) {
            throw new TelegramApiRequestException("Unable to deserialize response", e);
        }
    }

    @Override
    public void validate() throws TelegramApiValidationException {
    }

    @Override
    public String toString() {
        return "DeleteWebhook{}";
    }
}
