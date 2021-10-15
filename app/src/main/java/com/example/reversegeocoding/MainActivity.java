package com.example.reversegeocoding;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    String address="";
    String city="";
    String  addr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText lat=findViewById(R.id.latitude);
        EditText lon=findViewById(R.id.longitude);
        Button get = findViewById(R.id.getLoc);
        TextView addr= (TextView) findViewById(R.id.addr);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double latVal = Double.parseDouble(lat.getText().toString());
                Double lonVal = Double.parseDouble(lon.getText().toString());
                try{
                    Geocoder geocoder =new Geocoder(MainActivity.this, Locale.getDefault());
                    List<Address> ad = geocoder.getFromLocation(latVal,lonVal,2);
                    address = ad.get(0).getAddressLine(0);
                    city = ad.get(0).getLocality();
                    Toast.makeText(getApplicationContext(),address + "\n" +city +"\n",Toast.LENGTH_LONG ).show();
                    addr.setText(address +" "+ city);
                }
                catch (Exception e){
                    e.printStackTrace();  //Latitude: 9.524. Longitude: 77.855 --> Mepco
                }
            }
        });
    }
}