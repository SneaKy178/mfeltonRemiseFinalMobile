package com.tpfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tpfinal.api.CitoyenPost;
import com.tpfinal.model.Citoyen;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubscribeActivity extends AppCompatActivity {

    EditText myPrenom, myNom, myCourriel, myPassword, myNassm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);


        Intent intent = getIntent();
        String nassm = intent.getStringExtra("nassm");


        myPrenom = findViewById(R.id.myPrenomSubScribe);
        myNom = findViewById(R.id.myNomSubscribe);
        myCourriel = findViewById(R.id.myCourrielSubscribe);
        myPassword = findViewById(R.id.myPasswordSubscribe);
        myNassm = findViewById(R.id.myNassmSubscribe);

        myNassm.setText(nassm.toUpperCase());

    }

    public void subscribe(View view){
        Citoyen citoyen = new Citoyen();
        citoyen.setPrenom(myPrenom.getText().toString());
        citoyen.setNom(myNom.getText().toString());
        citoyen.setCourriel(myCourriel.getText().toString());
        citoyen.setPassword(myPassword.getText().toString());
        citoyen.setNassm(myNassm.getText().toString());
        citoyen.setIsMineur("FALSE");
        citoyen.setIsParentOuTuteur("FALSE");
        Log.i("citoyen", citoyen.toString());
        post(citoyen);
    }


    private void post(Citoyen citoyen) {
//        Retrofit.Builder builder = new Retrofit.Builder()
//                .baseUrl("http://10.0.2.2:9090/")
//                .addConverterFactory(GsonConverterFactory.create());
//
//        Retrofit retrofit = builder.build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:9090/").addConverterFactory(GsonConverterFactory.create())
                .build();

        CitoyenPost post = retrofit.create(CitoyenPost.class);
        Call<Citoyen> call = post.subscribeCitoyen(citoyen);

        call.enqueue(new Callback<Citoyen>() {
            @Override
            public void onResponse(Call<Citoyen> call, Response<Citoyen> response) {
                Intent intent = new Intent(SubscribeActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Citoyen> call, Throwable t) {
                Log.i("post","le citoyen ne s'est pas creer");
            }
        });
    }
}