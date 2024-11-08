package com.example.statemanagementextended;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView counterTextView, invisibleTextView;
    private EditText editText;
    private CheckBox checkBox;
    private Switch switchbox;
    private int counter = 0;
    private boolean checkBl = false;
    private boolean switchBl = false;
    private String edittextStr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        counterTextView = findViewById(R.id.textView);
        invisibleTextView = findViewById(R.id.textView2);
        editText = findViewById(R.id.editTextText);
        checkBox = findViewById(R.id.checkBox);
        switchbox = findViewById(R.id.switch1);

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter");
            checkBl = savedInstanceState.getBoolean("check");
            switchBl = savedInstanceState.getBoolean("switch");
            edittextStr = savedInstanceState.getString("editText");
        }
        updateCounter();
        updateinvisibleText();
        updateDarkThemeSwitch();

        button.setOnClickListener(v->{
            counter++;
            updateCounter();
        });
        switchbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchBl = !switchBl;
                updateDarkThemeSwitch();
            }
        });
        checkBox.setOnClickListener(v->{
            checkBl = !checkBl;
            updateinvisibleText();
        });
        invisibleTextView.setOnClickListener(v->{
            edittextStr = editText.getText().toString();
            Toast.makeText(MainActivity.this, edittextStr, Toast.LENGTH_SHORT);
        });

    }
    @Override
    protected void onSaveInstanceState(Bundle saveState) {
        super.onSaveInstanceState(saveState);
        saveState.putInt("counter", counter);
        saveState.putBoolean("switch", switchBl);
        saveState.putBoolean("check", checkBl);
        saveState.putString("editText", edittextStr);
    }

    private void updateCounter() {
        counterTextView.setText("Licznik: " + counter);
    }

    private void updateinvisibleText() {
        if (!checkBl) {
            invisibleTextView.setVisibility(View.GONE);
        } else {
            invisibleTextView.setVisibility(View.VISIBLE);
        }
    }
    private void updateDarkThemeSwitch() {
        if (switchBl){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else if (!switchBl){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}