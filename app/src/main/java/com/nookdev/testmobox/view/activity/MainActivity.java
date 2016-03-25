package com.nookdev.testmobox.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.nookdev.testmobox.model.CurrencyExchangeAdapter;
import com.nookdev.testmobox.model.network.ApiManager;
import com.nookdev.testmobox.model.pojo.ApiResponse;

import org.parceler.Parcels;

import nookdev.com.moboxtest.R;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity {
    private Subscription mSubscription;
    private CurrencyExchangeAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        mRecyclerView = (RecyclerView) findViewById(R.id.activity_main_list);
        initList();
        updateData();

    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mSubscription !=null&&!mSubscription.isUnsubscribed())
            mSubscription.unsubscribe();
    }

    private void initList(){
        mAdapter = new CurrencyExchangeAdapter();
        mAdapter.setSelectItemCallback(selectedItem -> {
            Parcelable parcel = Parcels.wrap(selectedItem);
            Intent intent = new Intent(this,DetailsActivity.class);
            intent.putExtra(ApiResponse.BUNDLE_TAG,parcel);
            startActivity(intent);
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }


    private void updateData(){
        mSubscription = ApiManager.getCurrencyRatesCall().getRates()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(apiResponses -> mAdapter.update(apiResponses)
                ,err -> {
                            err.printStackTrace();
                            Toast.makeText(MainActivity.this,err.getMessage(),Toast.LENGTH_SHORT).show();
                        });
    }

}
