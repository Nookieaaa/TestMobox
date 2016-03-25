package com.nookdev.testmobox.view.activity;


import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nookdev.testmobox.model.TimerReceiver;
import com.nookdev.testmobox.model.TimerService;

public abstract class BaseActivity extends AppCompatActivity{
    TimerReceiver mTimerReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTimerReceiver = new TimerReceiver(getSupportFragmentManager());
    }

    @Override
    protected void onStart() {
        super.onStart();
        startService(getServiceIntent(true));
        registerReceiver(mTimerReceiver,new IntentFilter(TimerService.BROADCAST_ACTION));
    }


    @Override
    protected void onStop() {
        super.onStop();
        startService(getServiceIntent(false));
        unregisterReceiver(mTimerReceiver);
    }

    private Intent getServiceIntent(boolean start){
        Intent intent = new Intent(this, TimerService.class);
        intent.putExtra(TimerService.PARAM_CODE, start ? TimerService.CODE_START : TimerService.CODE_STOP);
        return intent;
    }
}
