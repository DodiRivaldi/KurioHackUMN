package developerkampus.kuriohackumn.api.service;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Dodi Rivaldi on 26/11/2016.
 */

public class Data {
    @SerializedName("data")
    private ArrayList<DataItem> listData = new ArrayList<>();

    public ArrayList<DataItem> getListData() {
        return listData;
    }

    public void setListData(ArrayList<DataItem> listData) {
        this.listData = listData;
    }
}
