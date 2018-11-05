package com.example.user.lab4;


import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.example.user.lab4.R.layout.dialog;

public class MainActivity extends AppCompatActivity {

    private EditText EditSurname;
    private EditText EditName;
    private TextView ViewFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //checck file exist
        if(!IsFileExist(Consts.FILE_NAME))
        {
            showDialog();
            openText();

        }


        //get controls
        EditSurname=(EditText)findViewById(R.id.EditSurname);
        EditName=(EditText)findViewById(R.id.EditName);
        ViewFile=(TextView)findViewById(R.id.ViewFile);
    }

    //event handler send button onClick
    public void SendButton(View view)
    {
        saveText(view);
        openText();
    }
    private boolean IsFileExist(String FileName)
    {
        File file=new File(getFilesDir(),FileName);
        if(file.exists()){
            Log.d("Laba4", "file"+FileName+"is exist");
            return true;
        }
        else {
            Log.d("Laba4", "file"+FileName+"is not exist");
            return false;
        }
    }
    public static void CreateFile(String FileName)
    {
        try {
            new File(Environment.getExternalStorageDirectory(), FileName).createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveText(View view){

        FileOutputStream fos = null;
        try {
            String text = EditName.getText().toString()+";"+EditSurname.getText().toString()+"\r\n";

            fos = openFileOutput(Consts.FILE_NAME, MODE_APPEND);
            fos.write(text.getBytes());
            Toast.makeText(this, "Save file", Toast.LENGTH_SHORT).show();
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
    public void openText(){

        FileInputStream fin = null;
        TextView textView = (TextView) findViewById(R.id.ViewFile);
        try {
            fin = openFileInput(Consts.FILE_NAME);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String (bytes);
            textView.setText(text);
        }
        catch(IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{

            try{
                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void showDialog() {

        CustomDialog dialog = new CustomDialog();
        dialog.show(getSupportFragmentManager(), "dialog");
    }


}
