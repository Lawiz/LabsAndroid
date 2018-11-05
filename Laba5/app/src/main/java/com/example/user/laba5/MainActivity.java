package com.example.user.laba5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText EditSetKey;
    private EditText EditSetValue;
    private EditText EditGetKey;
    private EditText EditGetValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get controls
        EditGetKey=(EditText)findViewById(R.id.EditGetKey);
        EditSetKey=(EditText)findViewById(R.id.EditSetKey);
        EditSetValue=(EditText)findViewById(R.id.EditSetValue);
        EditGetValue=(EditText)findViewById(R.id.EditGetValue);

    }
}
