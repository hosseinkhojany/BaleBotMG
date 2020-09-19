package james_gosling.projects.balebotmg.telegrambots.meta.api.objects.passport;

import com.fasterxml.jackson.annotation.JsonProperty;
import james_gosling.projects.balebotmg.telegrambots.meta.api.interfaces.BotApiObject;
import james_gosling.projects.balebotmg.telegrambots.meta.api.objects.passport.EncryptedCredentials;
import james_gosling.projects.balebotmg.telegrambots.meta.api.objects.passport.EncryptedPassportElement;

import java.util.List;

/**
 * @author Ruben Bermudez
 * @version 4.0.0
 * Contains information about Telegram Passport data shared with the bot by the user.
 */
public class PassportData implements BotApiObject {
    private static final String DATA_FIELD = "data";
    private static final String CREDENTIALS_FIELD = "credentials";

    @JsonProperty(DATA_FIELD)
    private List<EncryptedPassportElement> data; ///< Array with information about documents and other Telegram Passport data that was shared with the bot
    @JsonProperty(CREDENTIALS_FIELD)
    private EncryptedCredentials credentials; ///< Array with information about documents and other Telegram Passport data shared with the bot.

    public PassportData() {
    }

    public PassportData(List<EncryptedPassportElement> data, EncryptedCredentials credentials) {
        this.data = data;
        this.credentials = credentials;
    }

    public List<EncryptedPassportElement> getData() {
        return data;
    }

    public EncryptedCredentials getCredentials() {
        return credentials;
    }

    @Override
    public String toString() {
        return "PassportData{" +
                "data=" + data +
                ", credentials=" + credentials +
                '}';
    }
}
