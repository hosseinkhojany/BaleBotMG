package james_gosling.projects.balebotmg.telegrambots.meta.api.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

import james_gosling.projects.balebotmg.telegrambots.meta.api.methods.BotApiMethod;
import james_gosling.projects.balebotmg.telegrambots.meta.api.objects.File;
import james_gosling.projects.balebotmg.telegrambots.meta.api.objects.ApiResponse;
import james_gosling.projects.balebotmg.telegrambots.meta.exceptions.TelegramApiRequestException;
import james_gosling.projects.balebotmg.telegrambots.meta.exceptions.TelegramApiValidationException;

import java.io.IOException;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * Use this method to get basic info about a file and prepare it for downloading.
 * For the moment, bots can download files of up to 20MB in size.
 * On success, a File object is returned.
 * The file can then be downloaded via the link https://api.telegram.org/file/bot<token>/<file_path>,
 * where <file_path> is taken from the response.
 * It is guaranteed that the link will be valid for at least 1 hour.
 * When the link expires, a new one can be requested by calling getFile again.
 */
public class GetFile extends BotApiMethod<File> {
    public static final String PATH = "getFile";

    private static final String FILEID_FIELD = "file_id";

    @JsonProperty(FILEID_FIELD)
    private String fileId; ///< File identifier to get info about

    public GetFile() {
        super();
    }

    public String getFileId() {
        return fileId;
    }

    public GetFile setFileId(String fileId) {
        this.fileId = fileId;
        return this;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (fileId == null) {
            throw new TelegramApiValidationException("FileId can't be empty", this);
        }
    }

    @Override
    public String getMethod() {
        return PATH;
    }

    @Override
    public File deserializeResponse(String answer) throws TelegramApiRequestException {
        try {
            ApiResponse<File> result = OBJECT_MAPPER.readValue(answer,
                    new TypeReference<ApiResponse<File>>(){});
            if (result.getOk()) {
                return result.getResult();
            } else {
                throw new TelegramApiRequestException("Error getting file", result);
            }
        } catch (IOException e) {
            throw new TelegramApiRequestException("Unable to deserialize response", e);
        }
    }

    @Override
    public String toString() {
        return "GetFile{" +
                "fileId='" + fileId + '\'' +
                '}';
    }
}
