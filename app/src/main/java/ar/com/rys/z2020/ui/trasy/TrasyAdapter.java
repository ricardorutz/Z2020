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
package ar.com.rys.z2020.ui.trasy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.impl.OnItemClickListener;

import java.util.List;

import ar.com.rys.z2020.R;

/**
 * <p>Image adapter.</p>
 * Created by Yan Zhenjie on 2016/10/30.
 */
public class TrasyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private OnItemClickListener mItemClickListener;

    private List<TrasyResourceData> trasyResourceDataList;

    public TrasyAdapter(Context context, OnItemClickListener onItemClickListener, List<TrasyResourceData> mAlbumFiles) {
        this.mInflater = LayoutInflater.from(context);
        this.mItemClickListener = onItemClickListener;
        this.trasyResourceDataList = mAlbumFiles;
    }

    public void notifyDataSetChanged(List<TrasyResourceData> imagePathList) {
        this.trasyResourceDataList = imagePathList;
        super.notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return AlbumFile.TYPE_IMAGE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case AlbumFile.TYPE_IMAGE: {
                return new ImageViewHolder(mInflater.inflate(R.layout.fragment_trasy_item_content_maps_image, parent, false), mItemClickListener);
            }
            default: {
                throw new AssertionError("This should not be the case.");
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((ImageViewHolder) holder).setData(trasyResourceDataList.get(position).getAlbumFile(), trasyResourceDataList.get(position).getImageTitle());

    }

    @Override
    public int getItemCount() {

        return trasyResourceDataList == null ? 0 : trasyResourceDataList.size();

    }


}
