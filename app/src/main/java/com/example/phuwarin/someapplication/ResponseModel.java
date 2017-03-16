package com.example.phuwarin.someapplication;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Phuwarin on 3/16/2017.
 */

public class ResponseModel {
    @SerializedName("result") private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
