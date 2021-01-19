package com.example.captainolive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.captainolive.api.ApiClient;
import com.example.captainolive.api.Network;
import com.example.captainolive.response.MealsItem;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodItems extends AppCompatActivity {
    private TextView strMeals, str_area, str_Instructions,  You_tube;
    private TextView str_Category;
    private ImageView str_meal_Thumb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_items);
        initViews();
    }

    private void initViews() {
        strMeals = findViewById(R.id.str_meals);
        str_Category = findViewById(R.id.str_category);
        str_area = findViewById(R.id.str_area);
        str_Instructions = findViewById(R.id.str_Instructions);
        str_meal_Thumb = findViewById(R.id.strMeals_thumb);
        You_tube = findViewById(R.id.str_tube);
        Intent intent = getIntent();
        Bundle mealBundle = intent.getBundleExtra("bundle");
        MealsItem mealsItem = (MealsItem) mealBundle.getSerializable("meal");
        String meal_str = "";
        String category_str = "";
        String area_str = "";
        String Instructions_str = "";
        String thumb_str = "";
        meal_str = mealsItem.getStrMeal();
        category_str = mealsItem.getStrCategory();
        area_str = mealsItem.getStrArea();
        Instructions_str = mealsItem.getStrInstructions();
        thumb_str = mealsItem.getStrMealThumb();
        Glide.with(str_meal_Thumb).load(mealsItem.getStrMealThumb()).into(str_meal_Thumb);
        final String video_url = mealsItem.getStrYoutube();
        You_tube.setText(video_url);
        You_tube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent youtubeIntent = new Intent(FoodItems.this, VideoActivity.class);
                youtubeIntent.putExtra("youtubeurl",video_url);
                startActivity(youtubeIntent);
            }
        });

        strMeals.setText(meal_str);
        str_area.setText(area_str);
        str_Category.setText(category_str);

        str_Instructions.setText(Instructions_str);


    }
}