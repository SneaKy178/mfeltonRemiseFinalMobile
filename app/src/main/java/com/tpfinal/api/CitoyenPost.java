package com.tpfinal.api;

import com.tpfinal.model.Citoyen;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CitoyenPost {

    @POST("citoyen")
    Call<Citoyen> subscribeCitoyen(@Body Citoyen citoyen);

    @GET("ministere/{nassm}")
    Call<Boolean> verifyNassm(@Path("nassm") String nasssm);


}
