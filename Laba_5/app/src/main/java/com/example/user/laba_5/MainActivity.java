package com.example.user.laba_5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText SetValue;
    private EditText GetValue;
    private EditText SetKey;
    private EditText GetKey;
    private Gson gson;

    private HashMap<String,String> HashMap;
    private String file="Laba.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set propirties
        SetValue=(EditText)findViewById(R.id.SetValueEditText);
        GetValue=(EditText)findViewById(R.id.GetValueEditText);
        SetKey=(EditText)findViewById(R.id.SetKeyEditView);
        GetKey=(EditText)findViewById(R.id.GetKeyEditText);
        HashMap=new HashMap<String,String>();
        gson=new Gson();

        Toast.makeText(this, IsFileExist(file), Toast.LENGTH_SHORT).show();

    }
    private String IsFileExist(String FileName)
    {  File file=new File(getFilesDir(),FileName);
        if(file.exists()){
            Log.d("Laba5", "file"+FileName+"is exist");

            return "File exist";
        }
        else {
            Log.d("Laba5", "file"+FileName+"is not exist");

            return "File not found,creature...";
        }
    }
    public void SaveButton(View view){

        HashMap.put(SetKey.getText().toString(),SetValue.getText().toString());
        saveText(file,gson.toJson(HashMap));
        Toast.makeText(this ,gson.toJson(HashMap),Toast.LENGTH_SHORT).show();
    }
    public void saveText(String fileName,String date){

        FileOutputStream fos = null;
        try {

            fos = openFileOutput(fileName, MODE_APPEND);
            fos.write(date.getBytes());
            Toast.makeText(this, "Save to file", Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            try{
                if(fos!=null)
                    fos.close();
            }
            catch(IOException ex){

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

}
