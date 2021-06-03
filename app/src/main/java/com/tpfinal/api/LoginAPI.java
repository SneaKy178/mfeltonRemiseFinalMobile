package com.tpfinal.api;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.picasso.Picasso;
import com.tpfinal.CitoyenInfosActivity;
import com.tpfinal.model.Citoyen;
import com.tpfinal.model.Permis;

public class LoginAPI extends AsyncTask<String,Void,String> {

    Context context;


    public LoginAPI(Context c) {
        this.context = c;
    }


    @Override
    protected String doInBackground(String... urls) {
        String result = "";
        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL(urls[0]);
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);

            int data = reader.read();
            while (data != -1) {
                char current = (char) data;
                result += current;
                data = reader.read();
            }


        } catch (Exception e) {
            e.printStackTrace();
            Log.i("Error", e.getMessage());
        }
        return result;
    }

    @Override
    protected void onPostExecute(String str) {
        super.onPostExecute(str);
        try {
            JSONObject jsonObject = new JSONObject(str);
            String permisJson = jsonObject.getString("permis");
            Citoyen citoyen = parseCitoyenJson(str);
            Permis permis = parsePermisJson(permisJson);

            Intent intent = new Intent(context, CitoyenInfosActivity.class);
            intent.putExtra("citoyen", citoyen);
            intent.putExtra("permis", permis);

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(intent);


        } catch (Exception e) {
            e.printStackTrace();
            Log.i("JSONError", e.getMessage());
        }
    }


    private Citoyen parseCitoyenJson(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, new TypeReference<Citoyen>(){});
    }

    private Permis parsePermisJson(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, new TypeReference<Permis>(){});
    }

}
