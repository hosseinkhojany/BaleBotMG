package james_gosling.projects.balebotmg.telegrambots.meta.api.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import james_gosling.projects.balebotmg.telegrambots.meta.api.interfaces.BotApiObject;
import james_gosling.projects.balebotmg.telegrambots.meta.api.objects.PhotoSize;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * This object represents an audio file
 */
public class Audio implements BotApiObject {

    private static final String FILEID_FIELD = "file_id";
    private static final String FILEUNIQUEID_FIELD = "file_unique_id";
    private static final String DURATION_FIELD = "duration";
    private static final String MIMETYPE_FIELD = "mime_type";
    private static final String FILESIZE_FIELD = "file_size";
    private static final String TITLE_FIELD = "title";
    private static final String PERFORMER_FIELD = "performer";
    private static final String THUMB_FIELD = "thumb";

    @JsonProperty(FILEID_FIELD)
    private String fileId; ///< Identifier for this file, which can be used to download or reuse the file
    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots.
     * Can't be used to download or reuse the file.
     */
    @JsonProperty(FILEUNIQUEID_FIELD)
    private String fileUniqueId;
    @JsonProperty(DURATION_FIELD)
    private Integer duration; ///< Integer	Duration of the audio in seconds as defined by sender
    @JsonProperty(MIMETYPE_FIELD)
    private String mimeType; ///< Optional. MIME type of the file as defined by sender
    @JsonProperty(FILESIZE_FIELD)
    private Integer fileSize; ///< Optional. File size
    @JsonProperty(TITLE_FIELD)
    private String title; ///< Optional. Title of the audio as defined by sender or by audio tags
    @JsonProperty(PERFORMER_FIELD)
    private String performer; ///< Optional. Performer of the audio as defined by sender or by audio tags
    @JsonProperty(THUMB_FIELD)
    private PhotoSize thumb; ///< Optional. Thumbnail of the album cover to which the music file belongs

    public Audio() {
        super();
    }

    public String getFileId() {
        return fileId;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getMimeType() {
        return mimeType;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public String getTitle() {
        return title;
    }

    public String getPerformer() {
        return performer;
    }

    public PhotoSize getThumb() {
        return thumb;
    }

    public String getFileUniqueId() {
        return fileUniqueId;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "fileId='" + fileId + '\'' +
                ", duration=" + duration +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                ", title='" + title + '\'' +
                ", performer='" + performer + '\'' +
                ", thumb=" + thumb +
                ", fileUniqueId=" + fileUniqueId +
                '}';
    }
}
