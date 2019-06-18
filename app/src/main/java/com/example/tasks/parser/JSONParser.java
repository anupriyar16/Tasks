package com.example.tasks.parser;

import android.support.annotation.NonNull;
import android.util.Log;



import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.FormBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class JSONParser {

    private static final String MAIN_URL = "https://script.googleusercontent.com/macros/echo?user_content_key=nRMhVr92LjB73VzMb51Pqd1rT5JMHKdSLMh-XIaGhufzZ-Ug_QAcYm4-YstMdWgZ7PrW5xJDchVgniZ7wmffjdO0RsW-7OjjOJmA1Yb3SEsKFZqtv3DaNYcMrmhZHmUMWojr9NvTBuBLhyHCd5hHa1GhPSVukpSQTydEwAEXFXgt_wltjJcH3XHUaaPC1fv5o9XyvOto09QuWI89K6KjOu0SP2F-BdwUBM3V5_69NfEQRaq_Wb2d-AqKfT5mISRk9JbIjv3JvrqcS8WIJ3ZeHV9NugmLQHW95y7FLqOV0Tk27B8Rh4QJTQ&lib=MnrE7b2I2PjfH799VodkCPiQjIVyBAxva";

    public static final String TAG = "TAG";

    private static final String KEY_USER_ID = "user_id";

    private static Response response;

    public static JSONObject getDataFromWeb() {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(MAIN_URL)
                    .build();
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        } catch (@NonNull IOException | JSONException e) {
            Log.e(TAG, "" + e.getLocalizedMessage());
        }
        return null;
    }

    public static JSONObject getDataById(int userId) {

        try {
            OkHttpClient client = new OkHttpClient();

            FormBody.Builder formBody = new FormBody.Builder()
                    .add(KEY_USER_ID, Integer.toString(userId));
            //.build();

            RequestBody formbody=formBody.build();

            Request request = new Request.Builder()
                    .url(MAIN_URL)
                    .post(formbody)
                    .build();

            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());

        } catch (IOException | JSONException e) {
            Log.e(TAG, "" + e.getLocalizedMessage());
        }
        return null;
    }
}