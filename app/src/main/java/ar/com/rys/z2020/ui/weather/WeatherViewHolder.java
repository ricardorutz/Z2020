package ar.com.rys.z2020.ui.weather;

import android.graphics.drawable.Icon;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import ar.com.rys.z2020.R;

public class WeatherViewHolder extends RecyclerView.ViewHolder {

    private ImageView trasyImageView;
    private TextView trasyTextView;

    WeatherViewHolder(View itemView) {
        super(itemView);
        this.trasyImageView = itemView.findViewById(R.id.imageViewWeatherIcon);
        this.trasyTextView = itemView.findViewById(R.id.textViewDate);
    }

    public void setData(WeatherResourceData data) {
        this.trasyTextView.setText(data.getDateNameAndNumber());
        this.trasyImageView.setImageResource(Integer.parseInt(data.getImagesResource()));
    }


}