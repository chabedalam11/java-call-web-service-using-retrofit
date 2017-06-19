package com.chabed.retrofit.model;

import java.io.Serializable;



public class Analyser implements Serializable {

   
	private static final long serialVersionUID = 1L;
	
	String analyserId;
    String analyserName;


    public String getAnalyserId() {
        return analyserId;
    }

    public void setAnalyserId(String analyserId) {
        this.analyserId = analyserId;
    }

    public String getAnalyserName() {
        return analyserName;
    }

    public void setAnalyserName(String analyserName) {
        this.analyserName = analyserName;
    }

    @Override
    public String toString() {
        return analyserName;
    }
}
