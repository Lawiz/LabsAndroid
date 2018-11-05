package com.example.user.lab4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.View;

import java.io.File;
import java.io.IOException;


public class CustomDialog extends DialogFragment {

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("File nod found.")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Do you wont a crate it?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            new File(Environment.getExternalStorageDirectory(), Consts.FILE_NAME).createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                })
                .setNegativeButton("Cansel", null)
                .create();
    }

}
