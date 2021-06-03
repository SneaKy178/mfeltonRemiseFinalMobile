package com.tpfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tpfinal.api.CitoyenPost;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VerifyNassmAcitivity extends AppCompatActivity {

    EditText myNassm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_nassm_acitivity);

        myNassm = findViewById(R.id.myNassmVerify);

    }


    public void verifyNassm(View view) {
        get(myNassm.getText().toString());

    }

    public void get(String nassm) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:9393/").addConverterFactory(GsonConverterFactory.create())
                .build();


        CitoyenPost get = retrofit.create(CitoyenPost.class);
        Call<Boolean> call = get.verifyNassm(nassm);

        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if ( response.body().toString().equals("true") || response.body().toString().equals("TRUE") )   {
                    Intent intent = new Intent(VerifyNassmAcitivity.this, SubscribeActivity.class);
                    intent.putExtra("nassm",myNassm.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(VerifyNassmAcitivity.this,"Votre nassm est invalide", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Log.i("ministere api", "call au ministere ne marche pas");
            }
        });





    }
}