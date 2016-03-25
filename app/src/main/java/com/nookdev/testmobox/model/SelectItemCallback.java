package com.nookdev.testmobox.model;


import com.nookdev.testmobox.model.pojo.ApiResponse;

public interface SelectItemCallback {
    void onItemSelected(ApiResponse selectedItem);
}
