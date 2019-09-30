package ar.com.rys.z2020.ui.gallery;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumConfig;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.api.widget.Widget;
import com.yanzhenjie.album.impl.OnItemClickListener;
import com.yanzhenjie.album.widget.divider.Api21ItemDivider;
import com.yanzhenjie.album.widget.divider.Divider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import ar.com.rys.z2020.R;

public class GalleryFragment extends Fragment {

    private Adapter mAdapter;
    private ArrayList<AlbumFile> mAlbumFiles = new ArrayList<>();


    public  static String[] imagesString = {
            String.valueOf(R.drawable.falls),
            String.valueOf(R.drawable.flag),
            String.valueOf(R.drawable.huahum),
            String.valueOf(R.drawable.river),
            String.valueOf(R.drawable.river),
            String.valueOf(R.drawable.river),
            String.valueOf(R.drawable.huahum),
            String.valueOf(R.drawable.huahum),
            String.valueOf(R.drawable.huahum),
            String.valueOf(R.drawable.huahum),
    };



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_gallery, container, false);

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

        recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
        Divider divider = new Api21ItemDivider(Color.TRANSPARENT, 10, 10);
        recyclerView.addItemDecoration(divider);

        mAdapter = new Adapter(context, new OnItemClickListener() {
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