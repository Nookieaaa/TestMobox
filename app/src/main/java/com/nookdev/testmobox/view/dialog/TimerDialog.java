package com.nookdev.testmobox.view.dialog;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import nookdev.com.moboxtest.R;

public class TimerDialog extends DialogFragment {
    public static final String TAG = TimerDialog.class.getName();
    private String mTimeString;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                .setTitle(R.string.dialog_timer_title)
                .setMessage(mTimeString)
                .setPositiveButton(R.string.ok, (dialog, which) -> {
                    dismiss();
                });
        return builder.create();
    }

    public void setTimeString(String timeString){
        mTimeString = timeString;
    }

    public void setMessage(String message){
        try{
            AlertDialog dialog = (AlertDialog)getDialog();
            dialog.setMessage(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
