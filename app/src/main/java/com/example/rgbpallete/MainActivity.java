package com.example.rgbpallete;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String RedHex;

    public void setRedHex(String value)
    {
        RedHex = value;
    }
    String GreenHex;

    public void setGreenHex(String value)
    {
        GreenHex = value;
    }
    String BlueHex;

    public void setBlueHex(String value)
    {
        BlueHex = value;
    }

    //odpowiada typowi kotrolki ktory zostal klikniety
    String WhatWasChanged = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText editHex = findViewById(R.id.editTextTextHex);

        SeekBar barRed = findViewById(R.id.seekBarRed);
        SeekBar barGreen = findViewById(R.id.seekBarGreen);
        SeekBar barBlue = findViewById(R.id.seekBarBlue);

        EditText editRed = findViewById(R.id.editTextTextR);
        EditText editGreen = findViewById(R.id.editTextTextG);
        EditText editBlue = findViewById(R.id.editTextTextB);


        RedHex ="00";
        GreenHex="00";
        BlueHex = "00";

        barRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                //to jest kontrolka ktora zmienia uzytkownik
                if(WhatWasChanged.equals(""))
                {
                    WhatWasChanged = "BarRed";
                    RedHex = String.format("%02x", progress);
                    UpdateHex();
                }
                //jezeli nie wejdzie w ifa to ma nic nie robic
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        barBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //to jest kontrolka ktora zmienia uzytkownik
                if(WhatWasChanged.equals(""))
                {
                    WhatWasChanged = "BarBlue";
                    BlueHex = String.format("%02x", progress);
                    UpdateHex();
                }
                //jezeli nie wejdzie w ifa to ma nic nie robic
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        barGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //to jest kontrolka ktora zmienia uzytkownik
                if(WhatWasChanged.equals(""))
                {
                    WhatWasChanged = "BarGreen";
                    GreenHex = String.format("%02x", progress);
                    UpdateHex();
                }
                //jezeli nie wejdzie w ifa to ma nic nie robic
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        editHex.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //to jest kontrolka ktora zmienia uzytkownik
                if(WhatWasChanged.equals("") && s.length() == 6)
                {

                    WhatWasChanged = "stringHex";
                    String buffor = s.toString();

                    RedHex = buffor.substring(0,2);
                    GreenHex = buffor.substring(2,4);
                    BlueHex = buffor.substring(4,6);

                    UpdateHex();



                }
                //jezeli nie wejdzie w ifa to ma nic nie robic
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editRed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //to jest kontrolka ktora zmienia uzytkownik
                if(WhatWasChanged.equals("") && (s.length() >= 1 && s.length() <= 3))
                {
                    WhatWasChanged = "stringRed";
                    RedHex = String.format("%02x", Integer.parseInt(s.toString()));
                    UpdateHex();
                }
                //jezeli nie wejdzie w ifa to ma nic nie robic
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editGreen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(WhatWasChanged.equals("") && (s.length() >= 1 && s.length() <= 3))
                {
                    WhatWasChanged = "stringGreen";
                    GreenHex = String.format("%02x", Integer.parseInt(s.toString()));
                    UpdateHex();
                }
                //jezeli nie wejdzie w ifa to ma nic nie robic
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editBlue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(WhatWasChanged.equals("") && (s.length() >= 1 && s.length() <= 3))
                {
                    WhatWasChanged = "stringBlue";
                    BlueHex = String.format("%02x", Integer.parseInt(s.toString()));
                    UpdateHex();
                }
                //jezeli nie wejdzie w ifa to ma nic nie robic
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public void UpdateHex()
    {
        EditText et = findViewById(R.id.editTextTextHex);
        et.setText(RedHex + GreenHex + BlueHex);

        //EditText RText = findViewById(R.id.editTextTextR);
        //RText.setText(RedHex);

        SeekBar barRed = findViewById(R.id.seekBarRed);
        barRed.setProgress(Integer.parseInt(RedHex, 16));

        SeekBar barGreen = findViewById(R.id.seekBarGreen);
        barGreen.setProgress(Integer.parseInt(GreenHex, 16));

        SeekBar barBlue = findViewById(R.id.seekBarBlue);
        barBlue.setProgress(Integer.parseInt(BlueHex, 16));

        EditText editRed = findViewById(R.id.editTextTextR);
        editRed.setText(String.valueOf(Integer.parseInt(RedHex, 16)));

        EditText editGreen = findViewById(R.id.editTextTextG);
        editGreen.setText(String.valueOf(Integer.parseInt(GreenHex, 16)));

        EditText editBlue = findViewById(R.id.editTextTextB);
        editBlue.setText(String.valueOf(Integer.parseInt(BlueHex, 16)));

        WhatWasChanged = "";
        setColor();
    }

    public void setColor()
    {
        TextView btn = findViewById(R.id.textView8);
        String collor = "#" + RedHex + GreenHex + BlueHex;
        btn.setBackgroundColor(Color.parseColor(collor));
    }
}