package com.example.restservice.snippets;

import com.example.restservice.util.EscapeStringSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsonbuilder.JsonBuilder;
import org.jsonbuilder.implementations.gson.GsonAdapter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class JsonTest {

    @Test
    public void test() throws Exception {


//        {
//            "query" : {
//              "query_string" : {
//                 "query" : "3",
//                 "fields"  : ["_id"]
//              }
//            }
//        }

        List<String> fields = Arrays.asList("_id");

        JSONObject query_string = new JSONObject();
        query_string.put("query", "3");
        query_string.put("fields", new JSONArray(fields));

        JSONObject query = new JSONObject();
        query.put("query_string", query_string);

        JSONObject queryObj = new JSONObject();
        queryObj.put("query", query);

        System.out.println(queryObj.toString());
    }


    @Test
    public void testJson2() throws JSONException, JsonProcessingException {
//        https://github.com/HknL/JsonBuilder/wiki/JsonBuilder-WIKI#extended-examples
        String json = new JsonBuilder(new GsonAdapter())
                .object("query_string")
                .object("query", "3")
                .object("fields")
                .array(new String[]{"_id"})
                .up().up()
                .object("test", "xxx")
                .build().toString();

        System.out.println(json);

//        Gson gson = new GsonBuilder()
//                .setPrettyPrinting()
//                .disableHtmlEscaping()
//                .create();

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(String.class, new EscapeStringSerializer());
        Gson gson = builder.create();

        System.out.println(gson.toJson(json));

        ObjectMapper mapper = new ObjectMapper();
        // pretty print
        String jsonPretty = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
        System.out.println(jsonPretty);
    }

}