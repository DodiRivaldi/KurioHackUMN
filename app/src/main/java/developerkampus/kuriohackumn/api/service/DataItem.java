package developerkampus.kuriohackumn.api.service;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dodi Rivaldi on 26/11/2016.
 */

public class DataItem {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("excerpt")
    private String excerpt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }
}
