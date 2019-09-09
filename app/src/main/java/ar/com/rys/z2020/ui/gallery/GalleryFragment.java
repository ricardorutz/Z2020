package ar.com.rys.z2020.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import ar.com.rys.z2020.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private ImageView ivImageViewFromUrl;
    private GridView gridView;

    private Image[] movies = {
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

/*
        galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        ivImageViewFromUrl = root.findViewById(R.id.iv_image_from_url);
        Picasso.get().load(R.drawable.puma).into(ivImageViewFromUrl);
*/
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        gridView = root.findViewById(R.id.gridview);

        final MovieAdapter movieAdapter = new MovieAdapter(this.getContext(), movies);
        gridView.setAdapter(movieAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {


                // This tells the GridView to redraw itself
                // in turn calling your MovieAdapter's getView method again for each cell
                movieAdapter.notifyDataSetChanged();
            }

        });






        return root;
    }
}