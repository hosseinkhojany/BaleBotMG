package james_gosling.projects.balebotmg.telegrambots.meta.api.objects.replykeyboard;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import james_gosling.projects.balebotmg.telegrambots.meta.api.interfaces.BotApiObject;
import james_gosling.projects.balebotmg.telegrambots.meta.api.interfaces.InputBotApiObject;
import james_gosling.projects.balebotmg.telegrambots.meta.api.interfaces.Validable;
import james_gosling.projects.balebotmg.telegrambots.meta.api.objects.replykeyboard.serialization.KeyboardDeserializer;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * Reply keyboard abstract type
 */
@JsonDeserialize(using = KeyboardDeserializer.class)
public interface ReplyKeyboard extends InputBotApiObject, BotApiObject, Validable {
}
