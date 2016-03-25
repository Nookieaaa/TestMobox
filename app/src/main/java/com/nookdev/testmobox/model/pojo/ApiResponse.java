package com.nookdev.testmobox.model.pojo;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import nookdev.com.moboxtest.BR;

@Parcel
public class ApiResponse extends BaseObservable {
    public static final String BUNDLE_TAG = "RESPONSE";

    @Bindable
    @SerializedName("ccy")
    @Expose
    public String currency;
    @SerializedName("base_ccy")
    @Expose
    public String nationalCurrency;
    @Bindable
    @SerializedName("buy")
    @Expose
    public double buy;
    @Bindable
    @SerializedName("sale")
    @Expose
    public double sale;

    public ApiResponse() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
        notifyPropertyChanged(BR.currency);
    }

    public String getNationalCurrency() {
        return nationalCurrency;
    }

    public void setNationalCurrency(String nationalCurrency) {
        this.nationalCurrency = nationalCurrency;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
        notifyPropertyChanged(BR.buy);
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
        notifyPropertyChanged(BR.sale);
    }
}
