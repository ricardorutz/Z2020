package ar.com.rys.z2020.ui.trasy;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.impl.OnItemClickListener;

import ar.com.rys.z2020.R;

public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final OnItemClickListener mItemClickListener;
    private ImageView trasyImageView;
    private TextView trasyTextView;
    //private TextView mTvDuration;

    ImageViewHolder(View itemView, OnItemClickListener itemClickListener) {
        super(itemView);
        this.mItemClickListener = itemClickListener;
        this.trasyImageView = itemView.findViewById(R.id.iv_trasy_content_maps_image);
        this.trasyTextView = itemView.findViewById(R.id.tv_trasy_content_maps_title);
        //this.mTvDuration = itemView.findViewById(R.id.textView_maps);
        //this.mTvDuration.setVisibility(View.VISIBLE);
        itemView.setOnClickListener(this);
    }

    public void setData(AlbumFile albumFile, String title) {
        Album.getAlbumConfig().
                getAlbumLoader().
                load(trasyImageView, albumFile);
        this.trasyTextView.setText(title);
    }

    @Override
    public void onClick(View v) {
        if (mItemClickListener != null) {
            mItemClickListener.onItemClick(v, getAdapterPosition());
        }
    }
}