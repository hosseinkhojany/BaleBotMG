package james_gosling.projects.balebotmg.telegrambots.meta.api.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import james_gosling.projects.balebotmg.telegrambots.meta.api.interfaces.BotApiObject;
import james_gosling.projects.balebotmg.telegrambots.meta.api.objects.PhotoSize;

import java.util.List;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * @brief This object represent a user's profile pictures.
 * @date 22 of June of 2015
 */
public class UserProfilePhotos implements BotApiObject {

    private static final String TOTALCOUNT_FIELD = "total_count";
    private static final String PHOTOS_FIELD = "photos";

    @JsonProperty(TOTALCOUNT_FIELD)
    private Integer totalCount; ///< Total number of profile pictures the target user has
    @JsonProperty(PHOTOS_FIELD)
    private List<List<james_gosling.projects.balebotmg.telegrambots.meta.api.objects.PhotoSize>> photos; ///< Requested profile pictures (in up to 4 sizes each)

    public UserProfilePhotos() {
        super();
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public List<List<PhotoSize>> getPhotos() {
        return photos;
    }

    @Override
    public String toString() {
        return "UserProfilePhotos{" +
                "totalCount=" + totalCount +
                ", photos=" + photos +
                '}';
    }
}
