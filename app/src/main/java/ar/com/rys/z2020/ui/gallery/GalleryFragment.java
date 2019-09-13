package ar.com.rys.z2020.ui.gallery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import ar.com.rys.z2020.R;

public class GalleryFragment extends Fragment {

    private ImageView ivImageViewFromUrl;
    private GridView gridView;

    public  static Image[] images = {
            new Image("Falls",R.drawable.falls),
            new Image("Flag",R.drawable.flag),
            new Image("HuaHum",R.drawable.huahum),
            new Image("River",R.drawable.river),
            new Image("River",R.drawable.river),
            new Image("River",R.drawable.river),
            new Image("HuaHum",R.drawable.huahum),
            new Image("HuaHum",R.drawable.huahum),
            new Image("HuaHum",R.drawable.huahum),
            new Image("HuaHum",R.drawable.huahum),
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        super.onCreate(savedInstanceState);

        gridView = root.findViewById(R.id.gridView);

        final Context context = this.getContext();

        final ImageAdapter movieAdapter = new ImageAdapter(context, images);
        gridView.setAdapter(movieAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("INFO", ",MSJ RYSIO");


                /*
                final Image image = images[position];
                ImageView imageView = root.findViewById(R.id.imageview_cover_art);
                Picasso.get()
                        .load(image.getImageUrl())
                        .placeholder(R.drawable.ic_placeholder)
                        .error(R.drawable.ic_error)
                        .resize(300, 500)
                        .onlyScaleDown()
                        .into(imageView);

                 */



                Log.i("INFO", ",MSJ RYSIO");



            }
        });










        return root;
    }
}