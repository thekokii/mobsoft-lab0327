package com.example.mobsoft.mobsoft.network.login;

/**
 * Created by mobsoft on 2017. 04. 24..
 */

import com.example.mobsoft.mobsoft.model.Credentials;



import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LoginApi {

    /**
     * Sends login credentials.
     *
     * @param credentials Credentials of user
     * @return Call<Void>
     */

    @POST("login")
    Call<Void> loginPost(
            @Body Credentials credentials
    );


}