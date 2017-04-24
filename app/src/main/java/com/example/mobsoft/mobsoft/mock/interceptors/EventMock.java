package com.example.mobsoft.mobsoft.mock.interceptors;

import android.net.Uri;

import com.example.mobsoft.mobsoft.network.NetworkConfig;
import com.example.mobsoft.mobsoft.repository.MemoryRepository;
import com.example.mobsoft.mobsoft.utils.GsonHelper;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.mobsoft.mobsoft.mock.interceptors.MockHelper.makeResponse;

/**
 * Created by mobsoft on 2017. 04. 24..
 */

public class EventMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "Events") && request.method().equals("POST")) {
            responseString = "";
            responseCode = 200;
        }else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "Events") && request.method().equals("Get")) {
            MemoryRepository memoryRepository = new MemoryRepository();
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(memoryRepository.getAllEvents());
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}
