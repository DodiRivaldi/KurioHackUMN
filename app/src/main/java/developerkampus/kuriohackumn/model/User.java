package developerkampus.kuriohackumn.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dodi Rivaldi on 26/11/2016.
 */

public class User {
    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
