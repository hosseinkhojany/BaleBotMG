package james_gosling.projects.balebotmg.telegrambots.meta.api.methods.commands;

import com.fasterxml.jackson.core.type.TypeReference;
import james_gosling.projects.balebotmg.telegrambots.meta.api.methods.BotApiMethod;
import james_gosling.projects.balebotmg.telegrambots.meta.api.objects.ApiResponse;
import james_gosling.projects.balebotmg.telegrambots.meta.api.objects.commands.BotCommand;
import james_gosling.projects.balebotmg.telegrambots.meta.exceptions.TelegramApiRequestException;
import james_gosling.projects.balebotmg.telegrambots.meta.exceptions.TelegramApiValidationException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Ruben Bermudez
 * @version 4.7
 * Use this method to get the current list of the bot's commands.
 * Requires no parameters.
 * Returns Array of BotCommand on success.
 */
public class GetMyCommands extends BotApiMethod<ArrayList<BotCommand>> {
    public static final String PATH = "getMyCommands";

    public GetMyCommands() {
        super();
    }

    @Override
    public String getMethod() {
        return PATH;
    }

    @Override
    public ArrayList<BotCommand> deserializeResponse(String answer) throws TelegramApiRequestException {
        try {
            ApiResponse<ArrayList<BotCommand>> result = OBJECT_MAPPER.readValue(answer,
                    new TypeReference<ApiResponse<ArrayList<BotCommand>>>(){});
            if (result.getOk()) {
                return result.getResult();
            } else {
                throw new TelegramApiRequestException("Error sending commands", result);
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
        return "GetMyCommands{}";
    }
}
