package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    public static final String sharedPrefFile = "com.example.android.week9" ;
    public static final String KEY = "MyKey" ;
    SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);


        Intent intentData = getIntent();
        String value = intentData.getStringExtra("MAINACTIVITY");

        TextView tv = findViewById(R.id.SubactivitySecondTextView);
        tv.setText(value);

        Button backToHomeButton = findViewById(R.id.BackToHomeButton);
        backToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        EditText editTextView = findViewById(R.id.EditTextView);
        String userInput = editTextView.getText().toString();

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putString(KEY, userInput);
        preferencesEditor.apply();
    }
}
