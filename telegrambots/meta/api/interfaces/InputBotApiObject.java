package james_gosling.projects.balebotmg.telegrambots.meta.api.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import james_gosling.projects.balebotmg.telegrambots.meta.api.interfaces.BotApiObject;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * An object used in the Bots API to answer updates
 *
 * @deprecated Please, use BotApiObject directly
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Deprecated
public interface InputBotApiObject extends BotApiObject {
}
