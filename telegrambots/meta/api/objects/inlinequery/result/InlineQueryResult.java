package james_gosling.projects.balebotmg.telegrambots.meta.api.objects.inlinequery.result;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import james_gosling.projects.balebotmg.telegrambots.meta.api.interfaces.InputBotApiObject;
import james_gosling.projects.balebotmg.telegrambots.meta.api.interfaces.Validable;
import james_gosling.projects.balebotmg.telegrambots.meta.api.objects.inlinequery.result.serialization.InlineQueryResultDeserializer;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * This object represents one result of an inline query.
 */
@JsonDeserialize(using = InlineQueryResultDeserializer.class)
public interface InlineQueryResult extends InputBotApiObject, Validable {
}
