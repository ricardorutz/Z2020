/*
 * Copyright 2016 Yan Zhenjie.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ar.com.rys.z2020.ui.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ar.com.rys.z2020.R;


public class WeatherDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private List<WeatherResourceData> weatherResourceDataList;

    public WeatherDetailsAdapter(Context context, List<WeatherResourceData> weatherFiles) {
        this.mInflater = LayoutInflater.from(context);
        this.weatherResourceDataList = weatherFiles;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new WeatherDetailsViewHolder(mInflater.inflate(R.layout.fragment_weather_item_content_image, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((WeatherDetailsViewHolder) holder).setData(weatherResourceDataList.get(position));

    }

    @Override
    public int getItemCount() {

        return weatherResourceDataList == null ? 0 : weatherResourceDataList.size();

    }


}
