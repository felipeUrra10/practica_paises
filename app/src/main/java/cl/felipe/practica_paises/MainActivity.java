package cl.felipe.practica_paises;

import androidx.appcompat.app.AppCompatActivity;
import com.loopj.android.http.*;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private static final String URL="https://restcountries.eu/rest/v2/all";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        processOnline();//LLAMAR AL METODO
    }

    public void processOnline(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) { //Transformation bye a String
                String data = new String(responseBody);
                Log.d("INFO", data);
                processPaises(data);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    private void processPaises(String data) {
        try {
            JSONArray root = new JSONArray(data);
            JSONObject resp = root.getJSONObject(data.indexOf(0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}