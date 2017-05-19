package com.zaurkandokhov.stormy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zaurkandokhov.stormy.R;
import com.zaurkandokhov.stormy.weather.Day;

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.DayViewHolder> {

    private Day[] mDays;
    private Context mContext;

    public DayAdapter(Context context, Day[] days) {
        mContext = context;
        mDays = days;
    }

    @Override
    public DayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.daily_list_item, parent, false);
        DayViewHolder viewHolder = new DayViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DayViewHolder holder, int position) {
        holder.bindDay(mDays[position]);
    }

    @Override
    public int getItemCount() {
        return mDays.length;
    }

    public class DayViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public String mSummary;
        public ImageView mIconImageView;
        public TextView mTemperatureMinLabel;
        public TextView mTemperatureMaxLabel;
        public TextView mDayLabel;

        public DayViewHolder(View itemView) {
            super(itemView);

            mIconImageView = (ImageView) itemView.findViewById(R.id.iconImageView);
            mTemperatureMinLabel = (TextView) itemView.findViewById(R.id.temperatureMinLabel);
            mTemperatureMaxLabel = (TextView) itemView.findViewById(R.id.temperatureMaxLabel);
            mDayLabel = (TextView) itemView.findViewById(R.id.dayNameLabel);

            itemView.setOnClickListener(this);
        }

        public void bindDay(Day day) {
            mSummary = day.getSummary();
            mIconImageView.setImageResource(day.getIconId());
            mTemperatureMinLabel.setText(day.getTemperatureMin() + "");
            mTemperatureMaxLabel.setText(day.getTemperatureMax() + "");
            mDayLabel.setText(day.getDayOfTheWeek());
        }

        @Override
        public void onClick(View v) {
            String dayOfTheWeek = mDayLabel.getText().toString();
            String temperatureMin = mTemperatureMinLabel.getText().toString();
            String temperatureMax = mTemperatureMaxLabel.getText().toString();
            String message = String.format("On %s the temperature will be %s-%s and it will be %s",
                    dayOfTheWeek,
                    temperatureMin,
                    temperatureMax,
                    mSummary);
            Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
        }
    }
}
