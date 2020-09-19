package james_gosling.projects.balebotmg.telegrambots.meta.api.objects.media;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import james_gosling.projects.balebotmg.telegrambots.meta.api.objects.media.InputMedia;
import james_gosling.projects.balebotmg.telegrambots.meta.exceptions.TelegramApiValidationException;

/**
 * @author Ruben Bermudez
 * @version 3.5
 *
 * Represents a photo.
 */
@SuppressWarnings("unused")
@JsonDeserialize
public class InputMediaPhoto extends InputMedia<InputMediaPhoto> {
    private static final String TYPE = "photo";

    public InputMediaPhoto() {
        super();
    }

    public InputMediaPhoto(String media, String caption) {
        super(media, caption);
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        super.validate();
    }

    @Override
    public String toString() {
        return "InputMediaPhoto{} " + super.toString();
    }
}
