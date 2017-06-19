package com.chabed.retrofit.collections;

import com.chabed.retrofit.model.Color;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;




public class ColorCollection {
    @SerializedName("data")
    @Expose
    public List<Color> data;
}
