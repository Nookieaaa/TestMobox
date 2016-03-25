package com.nookdev.testmobox.model;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;


public class CurrencyExchangeViewHolder extends RecyclerView.ViewHolder {
    private ViewDataBinding mViewDataBinding;

    public CurrencyExchangeViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        mViewDataBinding = binding;
        mViewDataBinding.executePendingBindings();
    }

    public ViewDataBinding getViewDataBinding(){
        return mViewDataBinding;
    }
}
