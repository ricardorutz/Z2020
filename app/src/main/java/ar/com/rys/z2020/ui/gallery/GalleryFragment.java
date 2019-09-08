package ar.com.rys.z2020.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.InputStream;

import ar.com.rys.z2020.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private ImageView ivImageViewFromUrl;
    final String URL ="Aquí colocamos la url de la imagen a mostrar";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);


        ivImageViewFromUrl = root.findViewById(R.id.iv_image_from_url);
        //Picasso.with(getApplicationContext()).load(URL).into(ivImageViewFromUrl);

        //int gallery_falls = R.drawable.gallery_falls;



        //InputStream iStream =getResources().openRawResource(gallery_falls);

        //File f = new File("path-to-file/file.png");
        //Picasso.with(getApplicationContext()).load(f).into(ivImageViewFromUrl);

        Picasso.get().load(R.drawable.puma).into(ivImageViewFromUrl);


        /*
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        */
        return root;
    }
}