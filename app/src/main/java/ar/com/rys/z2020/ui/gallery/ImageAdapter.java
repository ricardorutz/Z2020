package ar.com.rys.z2020.ui.gallery;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ar.com.rys.z2020.R;

public class ImageAdapter extends BaseAdapter {

        private final Context mContext;
        private final Image[] images;

        public ImageAdapter(Context context, Image[] images) {
            this.mContext = context;
            this.images = images;
        }
        @Override
        public int getCount() {
            return images.length;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Image image = images[position];
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.movie_layout, null);
        }
        final ImageView imageView = convertView.findViewById(R.id.imageview_cover_art);

        final TextView nameTextView = convertView.findViewById(R.id.textview_movie_name);


        Picasso.get()
                .load(image.getImageUrl())
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error)
                .resize(300, 500)
                .onlyScaleDown()
                .into(imageView);

        nameTextView.setText(image.getName());

        return convertView;
    }


}
