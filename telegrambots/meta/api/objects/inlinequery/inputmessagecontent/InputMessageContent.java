package james_gosling.projects.balebotmg.telegrambots.meta.api.objects.inlinequery.inputmessagecontent;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import james_gosling.projects.balebotmg.telegrambots.meta.api.interfaces.InputBotApiObject;
import james_gosling.projects.balebotmg.telegrambots.meta.api.interfaces.Validable;
import james_gosling.projects.balebotmg.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.serialization.InputMessageContentDeserializer;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * This object represents the content of a message to be sent as a result of an inline
 * query.
 */
@JsonDeserialize(using = InputMessageContentDeserializer.class)
public interface InputMessageContent extends InputBotApiObject, Validable {
}
