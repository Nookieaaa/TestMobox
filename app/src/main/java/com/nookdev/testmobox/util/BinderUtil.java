package com.nookdev.testmobox.util;


import android.databinding.BindingAdapter;
import android.support.design.BuildConfig;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public final class BinderUtil {
    static final String USD_IMG_SMALL = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Double-barred_dollar_sign.svg/100px-Double-barred_dollar_sign.svg.png";
    static final String RUB_IMG_SMALL = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/Ruble_sign.svg/125px-Ruble_sign.svg.png";
    static final String BTC_IMG_SMALL = "http://makets.fabrikamaek.ru/catalog_img/448526/sign/white_250.jpg";
    static final String EUR_IMG_SMALL = "http://colibris.ua/img/raznoe/valuta_znaki/euro.jpg";

    private BinderUtil(){

    }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String currency) {
        if(currency==null)
            return;
        String imageUrl = getImageUrl(currency);
        Picasso picasso = Picasso.with(imageView.getContext());
        if(BuildConfig.DEBUG) {
                picasso.setLoggingEnabled(true);
                picasso.setIndicatorsEnabled(true);
            }
        picasso.load(imageUrl).centerInside().fit().into(imageView);
    }

    private static String getImageUrl(String currency){
        String url = "";
        switch (currency){
            case "USD":
                url = USD_IMG_SMALL;
                break;
            case "EUR":
                url = EUR_IMG_SMALL;
                break;
            case "RUR":
                url = RUB_IMG_SMALL;
                break;
            case "BTC":
                url = BTC_IMG_SMALL;
                break;
            default:
                url = USD_IMG_SMALL;
        }
        return url;
    }
}
