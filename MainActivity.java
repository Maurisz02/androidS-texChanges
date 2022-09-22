package com.example.texchanges;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout layout;
    private EditText editText;
    private Button nagyButton;
    private Button kisButton;
    private Button szinButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        nagyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText().toString().toUpperCase());
            }
        });

        kisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText().toString().toLowerCase());
            }
        });

        szinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rnd = new Random();
                int r = rnd.nextInt(256);
                int g = rnd.nextInt(256);
                int b = rnd.nextInt(256);

                textView.setBackgroundColor(Color.rgb(r,g,b));
            }
        });

    }

    private void init(){
        layout = findViewById(R.id.layoutA);
        editText = findViewById(R.id.editText);
        nagyButton = findViewById(R.id.nagyButton);
        kisButton = findViewById(R.id.kisButton);
        szinButton = findViewById(R.id.szinButton);
        textView = findViewById(R.id.textView);
    }
}