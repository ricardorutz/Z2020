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
package ar.com.rys.z2020.ui.callendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import ar.com.rys.z2020.R;


public class CallendarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private LinkedHashMap<String, List<CallendarResourceData>> allData;

    public CallendarAdapter(Context context, LinkedHashMap<String, List<CallendarResourceData>> allData) {
        this.mInflater = LayoutInflater.from(context);
        this.allData = allData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new CallendarImageViewHolder(mInflater.inflate(R.layout.fragment_callendar_main_content, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        List<String> keyList = new ArrayList<String>(allData.keySet());

        ((CallendarImageViewHolder) holder).setData(allData.get(keyList.get(position)), keyList.get(position));

    }

    @Override
    public int getItemCount() {

        return allData == null ? 0 : allData.size();

    }


}