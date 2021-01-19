package com.example.captainolive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.captainolive.api.ApiClient;
import com.example.captainolive.api.Network;
import com.example.captainolive.response.MealsItem;
import com.example.captainolive.response.ResponseMeal;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFoodActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ResponseMealAdapter responseMealAdapter;
    private AutoCompleteTextView Search_bar;
    private Button Search_Food;
    private String Pass;
    private List<MealsItem> responseMeals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_food);
        initViews();
        setRecyclerAdapter();
    }

    private void setRecyclerAdapter() {
        responseMealAdapter = new ResponseMealAdapter((ArrayList<MealsItem>) responseMeals, new ResponseMealAdapter.onClickListener() {
            @Override
            public void onClick(MealsItem responseMeal) {
                Intent intent = new Intent(SearchFoodActivity.this,FoodItems.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("meal",responseMeal);
                intent.putExtra("bundle",bundle);
                startActivity(intent);

            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(responseMealAdapter);
    }

    private void initViews() {
        Search_bar = findViewById(R.id.atv_search_bar);
        mRecyclerView = findViewById(R.id.recycler_view);
        Search_Food = findViewById(R.id.btn_search);
        Search_Food.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Pass = Search_bar.getText().toString();
                ApiClient apiClient = Network.getInstance().create(ApiClient.class);
                Call<ResponseMeal> call = apiClient.responseMeal(Pass);
                call.enqueue(new Callback<ResponseMeal>() {
                    @Override
                    public void onResponse(Call<ResponseMeal> call, Response<ResponseMeal> response) {
                        if (response.code()==HttpURLConnection.HTTP_OK){
                            responseMeals = response.body().getMeals();
                              responseMealAdapter.updateDataSet(responseMeals);
                              responseMealAdapter.notifyDataSetChanged();






                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseMeal> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Failed"+t.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }


}