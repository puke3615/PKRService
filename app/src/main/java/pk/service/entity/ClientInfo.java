package pk.service.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @version 16/4/4
 * @user zijiao
 * @Mark
 */
public class ClientInfo extends BaseData {

    private Data data;

    public Data getData() {
        if (data == null) {
            data = new Data();
        }
        return data;
    }


    public static class Data {
        @SerializedName("createTime")
        public long time;
        @SerializedName("description")
        public String intro;
        @SerializedName("href")
        public String link;
        public long id;
        @SerializedName("picture")
        public String image;
        public String name;
    }

}
