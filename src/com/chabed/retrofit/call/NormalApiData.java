package com.chabed.retrofit.call;

import java.util.List;

import com.chabed.retrofit.collections.AnalyserCollection;
import com.chabed.retrofit.init.TestWebserviceUtil;
import com.chabed.retrofit.interfaces.TestApi;
import com.chabed.retrofit.model.Analyser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NormalApiData {
	
	
	TestApi testApi = TestWebserviceUtil.webserviceInitialize();
	
	
	public  void getInformation(){
        Call<AnalyserCollection> getInfo = testApi.getAnalyser();
        getInfo.enqueue(new Callback<AnalyserCollection>() {
            @Override
            public void onResponse(Call<AnalyserCollection> call, Response<AnalyserCollection> response) {
                List<Analyser> info = response.body().data;
                System.out.println("info == "+info);
                    for(int i =0; i<info.size(); i++){
                        String usrname = info.get(i).getAnalyserId().toString()+"\t"+info.get(i).getAnalyserName().toString();
                        System.out.println(usrname);
                        
                        }
            }

            @Override
            public void onFailure(Call<AnalyserCollection> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
	
	
	
	
	public static void main(String[] args) {
		
		new NormalApiData().getInformation();
		
	}
	
}


