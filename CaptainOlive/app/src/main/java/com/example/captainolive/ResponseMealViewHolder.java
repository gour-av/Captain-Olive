package com.example.captainolive;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.captainolive.response.MealsItem;
import com.example.captainolive.response.ResponseMeal;

public class ResponseMealViewHolder extends RecyclerView.ViewHolder {
    private TextView MealType;
    public ResponseMealViewHolder(@NonNull View itemView) {
        super(itemView);
        MealType = itemView.findViewById(R.id.mtvTitle);
    }

    public void setData(MealsItem modelList) {
        MealType.setText( modelList.getStrMeal());
    }
}
