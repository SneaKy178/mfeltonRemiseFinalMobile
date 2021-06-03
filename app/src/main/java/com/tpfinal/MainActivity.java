package com.tpfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.tpfinal.api.LoginAPI;

import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    EditText editTextCourriel;
    EditText editTextPassword;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCourriel = findViewById(R.id.myCourriel);
        editTextPassword = findViewById(R.id.myPassword);
    }


    public void getCitoyen(View view){
        try{
            LoginAPI callAPI = new LoginAPI(getApplicationContext());
            String courriel = URLEncoder.encode(editTextCourriel.getText().toString(),"UTF-8");
            String passsword = URLEncoder.encode(editTextPassword.getText().toString(),"UTF-8");
            callAPI.execute("http://10.0.2.2:9090/citoyen/" + courriel + "/" + passsword);

            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(editTextCourriel.getWindowToken(),0);
            manager.hideSoftInputFromWindow(editTextPassword.getWindowToken(),0);

            editTextCourriel.setText("");
            editTextPassword.setText("");


        }catch (Exception e){
            Log.i("ButtonError",e.getMessage());
        }

        }



    public void goToSubscribe(View view){
        Intent intent = new Intent(this, VerifyNassmAcitivity.class);
        startActivity(intent);
    }
}