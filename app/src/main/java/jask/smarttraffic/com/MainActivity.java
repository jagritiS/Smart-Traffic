package jask.smarttraffic.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import jask.smarttraffic.com.locationPicker.MapsActivity;

public class MainActivity extends AppCompatActivity {
   // private EditText mLocationEditText;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

    }
    public void openLocation(View view) {
        if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
            startActivity(new Intent(this,MapsActivity.class));
            //correcct password
        }else {
            //wrong password
            Toast.makeText(getApplicationContext(),"Something wrong ",Toast.LENGTH_SHORT).show();
        }

        int var1 = username.toString().compareTo( "admin" );
        int var2 = password.toString().compareTo("admin");
        System.out.println("var 1 value is "+var1);
        System.out.println("var 2 value s "+var2);
        if(var1 == 0 && var2 == 0){

        }
        /*if(username.toString().equals("admin") && password.toString().equals("admin")){
            System.out.println("this is test ");

        }*/
        else{
            System.out.println("this is not test ");

        }




    }
    public void grids(View view){
        Intent intent = new Intent(MainActivity.this,ParkingsActivity.class);
        startActivity(intent);
    }
}
