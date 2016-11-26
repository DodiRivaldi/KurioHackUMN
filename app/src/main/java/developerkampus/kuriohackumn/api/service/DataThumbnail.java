package developerkampus.kuriohackumn.api.service;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dodi Rivaldi on 26/11/2016.
 */

public class DataThumbnail {
    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
