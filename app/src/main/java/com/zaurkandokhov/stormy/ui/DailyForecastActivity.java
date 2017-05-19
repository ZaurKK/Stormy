package com.zaurkandokhov.stormy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zaurkandokhov.stormy.R;
import com.zaurkandokhov.stormy.adapters.DayAdapter;
import com.zaurkandokhov.stormy.weather.Day;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DailyForecastActivity extends AppCompatActivity {

    private Day[] mDays;

    @BindView(R.id.emptyLabel) TextView mEmptyLabel;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
        mDays = Arrays.copyOf(parcelables, parcelables.length, Day[].class);

        if (mDays.length > 0)
            mEmptyLabel.setVisibility(View.INVISIBLE);

        DayAdapter adapter = new DayAdapter(this, mDays);
        mRecyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true);
    }

/*
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String dayOfTheWeek = mDays[position].getDayOfTheWeek();
        String minTemp = mDays[position].getTemperatureMin() + "";
        String maxTemp = mDays[position].getTemperatureMax() + "";
        String conditions = mDays[position].getSummary();
        String message = String.format("On %s the temperature will be between %s-%s and it will be %s",
                dayOfTheWeek,
                minTemp,
                maxTemp,
                conditions);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
*/
}
