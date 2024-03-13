package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("LifeCycle", "onCreate"); // Logging onCreate

        // Using anonymous class
        Button button1 = findViewById(R.id.Button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // The following is executed whenever the button1 is clicked
                TextView textView1 = findViewById(R.id.FirstTextView);
                textView1.setText("HOHO");
                Log.d("MainActivity", "A button is clicked");
            }
        });
        // Using anonymous class is the alternative of the following:
        // Creating a named class that implements View.OnClickListener
        // Instantiate the object, and then pass it to button.setOnClickListener
//        Button1Class b1 = new Button1Class();
//        button1.setOnClickListener( b1 );

        // Explicit Intent Demo
        Button buttonToSubactivity = findViewById(R.id.GoToSubactivityButton);
        buttonToSubactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("MAINACTIVITY", "Wow!");
                startActivity(intent);
            }
        });

        // Implicit Intent Demo
        Button mapButton = findViewById(R.id.OpenMapButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Build the URI
                Uri.Builder uriBuilder = new Uri.Builder();
                uriBuilder.scheme("geo").opaquePart("0.0").appendQueryParameter("q", "SUTD");
                Uri URL = uriBuilder.build();

                // Implicit Intent
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(URL); // Set the resource

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LifeCycle", "onStart");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LifeCycle", "onRestart");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LifeCycle", "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LifeCycle", "onDestroy");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LifeCycle", "onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LifeCycle", "onResume");

    }
}