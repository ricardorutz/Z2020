package ar.com.rys.z2020.ui.slideshow;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import org.osmdroid.views.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.impl.OnItemClickListener;
import com.yanzhenjie.album.widget.divider.Api21ItemDivider;
import com.yanzhenjie.album.widget.divider.Divider;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;


import java.util.ArrayList;
import java.util.Collections;

import ar.com.rys.z2020.R;

public class SlideshowFragment extends Fragment {



    private SlideshowAdapter mAdapter;
    private ArrayList<AlbumFile> mAlbumFiles = new ArrayList<>();


    public  static String[] imagesString = {
            String.valueOf(R.drawable.trasa_bsas),
            String.valueOf(R.drawable.trasa_sma),
            String.valueOf(R.drawable.trasa_wedro),

    };



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        super.onCreate(savedInstanceState);

        ArrayList<String> imageList = new ArrayList<>();
        Collections.addAll(imageList, imagesString);

        imageList.forEach(p -> {

            AlbumFile al = new AlbumFile();
            al.setMediaType(AlbumFile.TYPE_IMAGE);
            al.setPath(p);
            mAlbumFiles.add(al);

        });


        final Context context = this.getContext();

        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);

        //recyclerView.getChildItemId(root.findViewById(R.id.textView3));

        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
        Divider divider = new Api21ItemDivider(Color.TRANSPARENT, 10, 10);
        recyclerView.addItemDecoration(divider);

        mAdapter = new SlideshowAdapter(context, new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                previewImage(position);
            }
        }, mAlbumFiles);
        recyclerView.setAdapter(mAdapter);







        return root;
    }


    private void previewImage(int position) {
        if (mAlbumFiles == null || mAlbumFiles.size() == 0) {
            //Toast.makeText(this, R.string.no_selected, Toast.LENGTH_LONG).show();
        } else {
            Album.galleryAlbum(this)
                    .checkable(false)
                    .checkedList(mAlbumFiles)
                    .currentPosition(position)
                    /*
                    .widget(
                            Widget.newDarkBuilder(this)
                                    .title(mToolbar.getTitle().toString())
                                    .build()
                    )
                    */
                    .onResult(new Action<ArrayList<AlbumFile>>() {
                        @Override
                        public void onAction(@NonNull ArrayList<AlbumFile> result) {
                            mAlbumFiles = result;
                            mAdapter.notifyDataSetChanged(mAlbumFiles);
                            // mTvMessage.setVisibility(result.size() > 0 ? View.VISIBLE : View.GONE);
                        }
                    })
                    .start();
        }
    }
}