package com.tpfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tpfinal.model.Citoyen;
import com.tpfinal.model.Permis;

public class CitoyenInfosActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citoyen_infos);

        imageView = findViewById(R.id.myQrCodeImage);
        textView = findViewById(R.id.infosCitoyen);

        Intent intent = getIntent();
        Citoyen citoyen = (Citoyen) intent.getSerializableExtra("citoyen");
        Permis permis = (Permis) intent.getSerializableExtra("permis");

        textView.setText("Voici votre code qr " + citoyen.getPrenom() + " " + citoyen.getNom());

                    Picasso.with(this)
                     .load("http://10.0.2.2:9090/citoyen/qrcode/" + citoyen.getNassm())
                     .resize(800,800)
                     .into(imageView);

    }

    public void goBack(View view) {
        Intent intent = new Intent(this,CitoyenInfosActivity.class);
        startActivity(intent);
    }
}