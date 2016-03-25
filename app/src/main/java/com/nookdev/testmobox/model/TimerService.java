package com.nookdev.testmobox.model;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TimerService extends Service {
    public static final int DIALOG_INTERVAL_MINUTES = 2;
    public static final int CODE_START = 1;
    public static final int CODE_STOP = 2;

    public final static String BROADCAST_ACTION = "nookdev.com.moboxtest";

    public static final String EXTRA_TIME = "TIME";
    public static final String PARAM_CODE = "CODE";

    Subscription mSubscription;
    boolean mRunning = false;

    public TimerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        int code = intent.getIntExtra(PARAM_CODE,CODE_STOP);

        if (code==CODE_START){
            setRunning(true);
        }
        else {
            setRunning(false);
        }

        return super.onStartCommand(intent, flags, startId);
    }

    private void initSubscription(){
        mSubscription = Observable.interval(DIALOG_INTERVAL_MINUTES, TimeUnit.MINUTES)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(num->{
                    long time = System.currentTimeMillis();
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    String timeString = sdf.format(new Date(time));

                    Intent intent = new Intent(BROADCAST_ACTION);
                    intent.putExtra(EXTRA_TIME,timeString);
                    sendBroadcast(intent);
                });
    }

    public boolean isRunning() {
        return mRunning;
    }

    public void setRunning(boolean running) {
        mRunning = running;
        if(!mRunning)
            mSubscription.unsubscribe();
        else
            initSubscription();
    }
}
