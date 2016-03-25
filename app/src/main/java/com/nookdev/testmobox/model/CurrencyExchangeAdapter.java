package com.nookdev.testmobox.model;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nookdev.testmobox.model.pojo.ApiResponse;

import java.util.List;

import nookdev.com.moboxtest.BR;
import nookdev.com.moboxtest.R;

public class CurrencyExchangeAdapter extends RecyclerView.Adapter<CurrencyExchangeViewHolder> {
    private SelectItemCallback mSelectItemCallback;



    private List<ApiResponse> mData;

    public CurrencyExchangeAdapter(){

    }

    public void update(List<ApiResponse> data){
        if(data.isEmpty())
            return;

        if (mData != null) {
            mData.clear();
            mData.addAll(data);
        }
        else {
            mData = data;
        }
        notifyItemRangeChanged(0,mData.size()-1);
    }


    @Override
    public CurrencyExchangeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding dataBinding = DataBindingUtil
                .inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.activity_main_list_item,
                        parent,
                        false);
        return new CurrencyExchangeViewHolder(dataBinding);
    }


    @Override
    public void onBindViewHolder(CurrencyExchangeViewHolder holder, int position) {
        ViewDataBinding dataBinding = holder.getViewDataBinding();
        holder.getViewDataBinding().getRoot().setOnClickListener(v -> {
            if(mSelectItemCallback!=null){
                ApiResponse item = mData.get(holder.getAdapterPosition());
                mSelectItemCallback.onItemSelected(item);
            }


        });
        dataBinding.setVariable(BR.rate,mData.get(holder.getAdapterPosition()));
    }


    @Override
    public int getItemCount() {
        return (null != mData ? mData.size() : 0);
    }

    public void setSelectItemCallback(SelectItemCallback selectItemCallback) {
        mSelectItemCallback = selectItemCallback;
    }
}
