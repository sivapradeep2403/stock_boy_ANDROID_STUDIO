  package com.example.yahoo1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // TextView open_Main,high_Main;

    String open_price, high_price, low_price, closed_price, adjusted_price, volume_price, dividendAmount_price, splitCoefficient_price;

    EditText stockName;
    Button searchBtn;

    RecyclerView recyclerView_Main;
    AdapterClass adapterClass;
    List<ModelClass> modelClassList;

    ProgressBar progressBarMain;

    String ticker;
    String url="https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=RELIANCE.BSE&outputsize=full&apikey=:%20W515ALYY4KLF3JMS";


    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //recyclerView_Main.setVisibility(View.INVISIBLE);


        stockName = findViewById(R.id.stockName_Main);
        searchBtn = findViewById(R.id.search_btn);
        recyclerView_Main = findViewById(R.id.recyclerView_main);
        recyclerView_Main.setHasFixedSize(true);
        recyclerView_Main.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        progressBarMain=findViewById(R.id.progressBar);
        modelClassList = new ArrayList<ModelClass>();

        progressBarMain.setVisibility(View.INVISIBLE);
        requestQueue = Volley.newRequestQueue(MainActivity.this);




        stockName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView_Main.setVisibility(View.INVISIBLE);
                progressBarMain.setVisibility(View.INVISIBLE);
            }
        });







        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBarMain.setVisibility(View.VISIBLE);

                 ticker = stockName.getText().toString().toUpperCase();

                url = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol="+ticker+"&outputsize=full&apikey=:%20W515ALYY4KLF3JMS";

                parseJSON();
            }
        });

        //https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=RELIANCE.BSE&outputsize=full&apikey=:%20W515ALYY4KLF3JMS66666666666666666666666666666


    }


    private void parseJSON() {

              recyclerView_Main.setVisibility(View.VISIBLE);
      //  String url = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=RELIANCE.BSE&outputsize=full&apikey=:%20W515ALYY4KLF3JMS";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(JSONObject response) {

                try {

                    progressBarMain.setVisibility(View.INVISIBLE);

                    JSONObject jsonObject = response.getJSONObject("Time Series (Daily)");

                    Date myDate = new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24));
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String yesterday = dateFormat.format(myDate);

                    Toast.makeText(MainActivity.this, ticker+"  :  "+yesterday, Toast.LENGTH_LONG).show(); //------>YESTERDAY

                    JSONObject date = jsonObject.getJSONObject(yesterday);

                    open_price = date.getString("1. open");
                    high_price = date.getString("2. high");
                    low_price = date.getString("3. low");
                    closed_price = date.getString("4. close");
                    adjusted_price = date.getString("5. adjusted close");
                    volume_price = date.getString("6. volume");
                    dividendAmount_price = date.getString("7. dividend amount");
                    splitCoefficient_price = date.getString("8. split coefficient");


                    modelClassList.add(new ModelClass(open_price, high_price, low_price, closed_price, adjusted_price, volume_price, dividendAmount_price, splitCoefficient_price));


                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this,"HMMM.....SOMETHING NOT RIGHT !",Toast.LENGTH_LONG).show();
                }

                recyclerView_Main.setVisibility(View.VISIBLE);
                adapterClass = new AdapterClass(MainActivity.this, modelClassList);
                recyclerView_Main.setAdapter(adapterClass);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue.add(jsonObjectRequest);


    }
}








































