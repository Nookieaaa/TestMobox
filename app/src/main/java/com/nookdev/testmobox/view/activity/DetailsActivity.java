package com.nookdev.testmobox.view.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.nookdev.testmobox.model.pojo.ApiResponse;

import org.parceler.Parcels;

import nookdev.com.moboxtest.R;
import nookdev.com.moboxtest.databinding.ActivityDetailsBinding;


public class DetailsActivity extends BaseActivity {

    ApiResponse mApiResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent!=null&&intent.hasExtra(ApiResponse.BUNDLE_TAG)){
             mApiResponse = Parcels.unwrap(intent.getParcelableExtra(ApiResponse.BUNDLE_TAG));
        }

        ActivityDetailsBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_details);
        binding.setModel(mApiResponse);
    }
}
