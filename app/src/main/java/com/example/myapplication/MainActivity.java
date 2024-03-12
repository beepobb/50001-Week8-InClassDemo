package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

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

        Button button1 = findViewById(R.id.Button1);
        Log.d("MainActivity", "First Messsage");

        // Using anonymous class
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
    }

    class Button1Class implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView textView1 = findViewById(R.id.FirstTextView);
            textView1.setText("HOHO");
        }
    }
}