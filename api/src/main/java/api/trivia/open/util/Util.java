package api.trivia.open.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Util {

    public static String toPrettyFormat(String json) {
        JsonObject jsonObj = JsonParser.parseString(json).getAsJsonObject();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        return gson.toJson(jsonObj);
    }


}
