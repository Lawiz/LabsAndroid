package com.example.user.lab3;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;


public class MainActivity extends AppCompatActivity {
    TextView textViewAbsolute;
    TextView textViewNameView;
    TextView textViewPathView;
    TextView textViewReadWriteView;
    TextView textViewExtenalView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         textViewAbsolute=(TextView)findViewById(R.id.AbsoluteView);
         textViewNameView=(TextView)findViewById(R.id.NameView);
         textViewPathView=(TextView)findViewById(R.id.PathView);
         textViewReadWriteView=(TextView)findViewById(R.id.ReadWriteView);
         textViewExtenalView=(TextView)findViewById(R.id.ExternalView);
    }
    //global variabls

    AppCompatActivity activity=new AppCompatActivity();
    Environment environment=new Environment();
    //TextView for out info


    public void SetViewValues(File file)
    {
        textViewAbsolute.setText(file.getAbsolutePath().toString());
        textViewNameView.setText(file.getName().toString());
        textViewPathView.setText(file.getPath().toString());
        textViewReadWriteView.setText(String.valueOf(file.canRead())+"/"+String.valueOf(file.canRead()));

    }
    public boolean  IsExistExternalView(File file)
    {
        String state=Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state))
        {
            Log.d("lab3","mounted");
        }
        else {
            Log.d("lab3",state);
        }
        // check exist extarnal stoarage for read
        if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(state))
        {
            Log.d("lab3","read only");
            Toast.makeText(this,"Sorry, your divice have not extrnal storage",Toast.LENGTH_SHORT).show();
            return true;
        }
        else
        {
            Log.d("lab3",state);
            SetViewValues(file);

            return false;
        }
    }
    public void GetFilesDir(View view)
    {
           try {
                    SetViewValues(getFilesDir());
                }
            catch (Exception ex)
            {
                Toast.makeText(this ,ex.getMessage(),Toast.LENGTH_SHORT).show();
            }


    }
    public void GetCachDir(View view)
    {
        IsExistExternalView(getCacheDir());
    }

    public void GetExternalFilesDir(View view)
    {
        IsExistExternalView(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS));

    }
    public void GetExternalCachDir(View view)
    {
        IsExistExternalView(getExternalCacheDir());
    }
    public void GetExternalStorageDirect(View view)
    {
        IsExistExternalView(Environment.getExternalStorageDirectory());
    }
    public void GetExternalStoragepublicDericroy(View view)
    {
        IsExistExternalView(Environment.getExternalStorageDirectory());
    }
}
