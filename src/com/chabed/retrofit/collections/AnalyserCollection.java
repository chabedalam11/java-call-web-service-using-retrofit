package com.chabed.retrofit.collections;

import com.chabed.retrofit.model.Analyser;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;




public class AnalyserCollection {
    @SerializedName("data")
    @Expose
    public List<Analyser> data;
}
