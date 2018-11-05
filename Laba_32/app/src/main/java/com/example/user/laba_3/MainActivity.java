package com.example.user.laba_3;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.os.Environment;

import java.io.File;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //global variabls

    AppCompatActivity activity=new AppCompatActivity();
    Environment environment=new Environment();
    //TextView for out info
    TextView textViewAbsolute=(TextView)findViewById(R.id.AbsoluteView);
    TextView textViewNameView=(TextView)findViewById(R.id.NameView);
    TextView textViewPathView=(TextView)findViewById(R.id.PathView);
    TextView textViewReadWriteView=(TextView)findViewById(R.id.ReadWriteView);
    TextView textViewExtenalView=(TextView)findViewById(R.id.ExternalView);

    private void SetViewValues(File file)
    {
        textViewAbsolute.setText(file.getAbsolutePath());
        textViewNameView.setText(file.getName());
        textViewPathView.setText(file.getPath());
        textViewReadWriteView.setText(file.canRead()+"/"+file.canWrite());

    }

    public void GetFilesDir(View view)
    {
        SetViewValues(activity.getFilesDir());
    }
    public void GetCachDir(View view)
    {
        SetViewValues(activity.getCacheDir());
    }

   public void GetExternalFilesDir(View view)
   {
       SetViewValues(activity.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS));

   }
   public void GetExternalCachDir(View view)
   {
       SetViewValues(activity.getExternalCacheDir());
   }
   public void GetExternalStorageDirect(View view)
   {
       SetViewValues(Environment.getExternalStorageDirectory());
   }
   public void GetExternalStoragepublicDericroy(View view)
   {
       SetViewValues(Environment.getExternalStorageDirectory());
   }
}
