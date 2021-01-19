package com.example.captainolive.response;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class ResponseMeal implements Serializable {

	@SerializedName("meals")
	private List<MealsItem> meals;

	public List<MealsItem> getMeals(){
		return meals;
	}

	@Override
 	public String toString(){
		return 
			"ResponseMeal{" + 
			"meals = '" + meals + '\'' + 
			"}";
		}
}