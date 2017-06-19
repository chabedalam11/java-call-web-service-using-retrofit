package com.chabed.retrofit.call;

import java.util.List;

import com.chabed.retrofit.collections.ColorCollection;
import com.chabed.retrofit.init.ClientAuthentication;
import com.chabed.retrofit.init.ServiceGenerator;
import com.chabed.retrofit.interfaces.UserService;
import com.chabed.retrofit.model.Color;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecureApiData {
	
	public void getSecureData(String token){
			UserService userService =
	        ServiceGenerator.createService(UserService.class, token);
			
			Call<ColorCollection> getInfo = userService.getColor();
			getInfo.enqueue(new Callback<ColorCollection>() {
			    @Override
			    public void onResponse(Call<ColorCollection> call, Response<ColorCollection> response) {
			
			        try{
			
			            List<Color> info = response.body().data;
			
			            if(info.size() > 0){
			            	System.out.println("API information");
			            	for(Color color: info){
			            		System.out.println(color.getUse()+"\t"+color.getShortDesc()+"\t"+color.getValueHex()+"\t"+color.getRgb());
			            	}
			                
			            }else {
			            	System.out.println("no data found ");
			            }
			
			        }catch (Exception e){
			        	System.out.println("list is empty");
			        }
			
			    }
			
			    @Override
			    public void onFailure(Call<ColorCollection> call, Throwable t) {
			        System.out.println("ERROR:: " + t.getMessage());
			        t.printStackTrace();
			    }
			});

	}
	
	
	public static void main(String[] args) {
		String token ="";
		try {
			token = new ClientAuthentication().getToken();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		new SecureApiData().getSecureData(token);
		
	}
	
}


