package james_gosling.projects.balebotmg.telegrambots.meta.api.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import james_gosling.projects.balebotmg.telegrambots.meta.api.interfaces.InputBotApiObject;
import james_gosling.projects.balebotmg.telegrambots.meta.api.interfaces.Validable;
import james_gosling.projects.balebotmg.telegrambots.meta.api.objects.InputFileSerializer;
import james_gosling.projects.balebotmg.telegrambots.meta.exceptions.TelegramApiValidationException;

import java.io.File;
import java.io.InputStream;

/**
 * @author Ruben Bermudez
 * @version 4.0.0
 *
 * Input file used to upload a file to Telegram server and use it afterwards
 */
@SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
@JsonSerialize(using = InputFileSerializer.class, as = String.class)
public class InputFile implements InputBotApiObject, Validable {

    private String attachName;

    @JsonIgnore
    private String mediaName; ///< Name of the media to upload
    @JsonIgnore
    private File newMediaFile; ///< New media file
    @JsonIgnore
    private InputStream newMediaStream; ///< New media stream
    @JsonIgnore
    private boolean isNew; ///< True if the file is new, false if it is a file_id

    public InputFile() {
        super();
    }

    public InputFile(String attachName) {
        this();
        setMedia(attachName);
    }

    /**
     * Constructor to set a new file
     *
     * @param mediaFile File to send
     * @param fileName Name of the file
     */
    public InputFile(File mediaFile, String fileName) {
        this();
        setMedia(mediaFile, fileName);
    }

    /**
     * Constructor to set a new file as stream
     *
     * @param mediaStream File to send
     * @param fileName Name of the file
     */
    public InputFile(InputStream mediaStream, String fileName) {
        this();
        setMedia(mediaStream, fileName);
    }

    /**
     * Use this setter to send new file.
     * @param mediaFile File to send
     * @param fileName Name of the file
     * @return This object
     */
    public InputFile setMedia(File mediaFile, String fileName) {
        this.newMediaFile = mediaFile;
        this.mediaName = fileName;
        this.attachName = "attach://" + fileName;
        this.isNew = true;
        return this;
    }

    /**
     * Use this setter to send new file as stream.
     * @param mediaStream File to send
     * @param fileName Name of the file
     * @return This object
     */
    public InputFile setMedia(InputStream mediaStream, String fileName) {
        this.newMediaStream = mediaStream;
        this.mediaName = fileName;
        this.attachName = "attach://" + fileName;
        this.isNew = true;
        return this;
    }

    public InputFile setMedia(String attachName) {
        this.attachName = attachName;
        this.isNew = false;
        return this;
    }

    public String getAttachName() {
        return attachName;
    }

    public String getMediaName() {
        return mediaName;
    }

    public File getNewMediaFile() {
        return newMediaFile;
    }

    public InputStream getNewMediaStream() {
        return newMediaStream;
    }

    public boolean isNew() {
        return isNew;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (isNew) {
            if (mediaName == null || mediaName.isEmpty()) {
                throw new TelegramApiValidationException("Media name can't be empty", this);
            }
            if (newMediaFile == null && newMediaStream == null) {
                throw new TelegramApiValidationException("Media can't be empty", this);
            }
        } else {
            if (attachName == null || attachName.isEmpty()) {
                throw new TelegramApiValidationException("File_id can't be empty", this);
            }
        }
    }
}