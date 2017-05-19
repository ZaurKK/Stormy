package com.zaurkandokhov.stormy.weather;

import com.zaurkandokhov.stormy.R;

public class Forecast {
    private Current mCurrent;
    private Hour[] mHour;
    private Day[] mDay;

    public Current getCurrent() {
        return mCurrent;
    }

    public void setCurrent(Current current) {
        mCurrent = current;
    }

    public Hour[] getHour() {
        return mHour;
    }

    public void setHour(Hour[] hour) {
        mHour = hour;
    }

    public Day[] getDay() {
        return mDay;
    }

    public void setDay(Day[] day) {
        mDay = day;
    }

    public static int getIconId(String iconString) {
        int iconId = R.drawable.clear_day;
        switch (iconString) {
            case "clear-day":
                iconId = R.drawable.clear_day;
                break;
            case "clear-night":
                iconId = R.drawable.clear_night;
                break;
            case "rain":
                iconId = R.drawable.rain;
                break;
            case "snow":
                iconId = R.drawable.snow;
                break;
            case "sleet":
                iconId = R.drawable.sleet;
                break;
            case "wind":
                iconId = R.drawable.wind;
                break;
            case "fog":
                iconId = R.drawable.fog;
                break;
            case "cloudy":
                iconId = R.drawable.cloudy;
                break;
            case "partly-cloudy-day":
                iconId = R.drawable.partly_cloudy;
                break;
            case "partly-cloudy-night":
                iconId = R.drawable.cloudy_night;
                break;
        }

        return iconId;
    }

    public static int fahrenheitToCelsius(double fahrenheit) {
        return (int) Math.round((fahrenheit - 32) * 5.0 / 8.0);
    }
}
