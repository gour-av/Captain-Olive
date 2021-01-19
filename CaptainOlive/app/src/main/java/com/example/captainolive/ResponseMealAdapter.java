package com.example.captainolive;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.captainolive.response.MealsItem;

import java.util.ArrayList;
import java.util.List;

public class ResponseMealAdapter extends RecyclerView.Adapter<ResponseMealViewHolder> {
private ArrayList<MealsItem> responseMealArrayList;
    public onClickListener onClickListener;

    public ResponseMealAdapter(ArrayList<MealsItem> modelList,onClickListener onClickListener) {
        this.responseMealArrayList = new ArrayList<MealsItem>();
            responseMealArrayList.addAll(modelList);
          this.onClickListener = onClickListener;
    }
    public void updateDataSet(List<MealsItem> modelList) {
        responseMealArrayList.clear();
        responseMealArrayList.addAll(modelList);
    }


    @NonNull
    @Override
    public ResponseMealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_layout, parent, false);
        return new ResponseMealViewHolder(view/*,onClickListener*/);
    }

    @Override
    public void onBindViewHolder(@NonNull ResponseMealViewHolder holder, int position) {
      final MealsItem modelList = responseMealArrayList.get(position);
        holder.setData(modelList);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          onClickListener.onClick(modelList);
            }
        });
    }

    @Override
    public int getItemCount() {
        return responseMealArrayList.size();
    }
    public interface onClickListener{
        void onClick(MealsItem responseMeal);
    }
}
