package com.example.user.mynewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void SendMessage(View view)
    {
        TextView textView=(TextView)findViewById(R.id.textView);
        EditText editText=(EditText)findViewById(R.id.editText);
        textView.setText("Velcom"+editText.getText());

    }
}
