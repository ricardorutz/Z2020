package ar.com.rys.z2020.ui.weather;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import ar.com.rys.z2020.R;

public class WeatherViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageViewWeatherIcon;
    private TextView textViewDate;
    private TextView textViewFutureTemperature;
    private  TextView textViewHistoricTemperature;

    WeatherViewHolder(View itemView) {
        super(itemView);
        this.imageViewWeatherIcon = itemView.findViewById(R.id.imageViewWeatherIcon);
        this.textViewDate = itemView.findViewById(R.id.textViewSma);
        this.textViewFutureTemperature = itemView.findViewById(R.id.textViewFutureTemperature);
        this.textViewHistoricTemperature = itemView.findViewById(R.id.textViewHistoricTemperature);
    }

    public void setData(WeatherResourceData data) {
        this.textViewDate.setText(data.getDateNameAndNumber());
        this.imageViewWeatherIcon.setImageResource(Integer.parseInt(data.getImagesResource()));
        this.textViewFutureTemperature.setText(data.getTemperature());
        this.textViewHistoricTemperature.setText(data.getHistoricTemperature());
    }


}