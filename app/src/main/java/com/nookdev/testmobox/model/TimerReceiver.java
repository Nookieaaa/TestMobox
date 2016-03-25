package com.nookdev.testmobox.model;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;

import com.nookdev.testmobox.view.dialog.TimerDialog;

public class TimerReceiver extends BroadcastReceiver {
    private FragmentManager mFragmentManager;
    private TimerDialog mTimerDialog;

    public TimerReceiver(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
        mTimerDialog = new TimerDialog();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String timeString = intent.getStringExtra(TimerService.EXTRA_TIME);
        if(mTimerDialog.isAdded()) {
            mTimerDialog.setMessage(timeString);
        }
        else{
            mTimerDialog.setTimeString(timeString);
            mTimerDialog.show(mFragmentManager, TimerDialog.TAG);
        }

    }
}
