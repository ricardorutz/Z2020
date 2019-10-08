package ar.com.rys.z2020.ui.slideshow;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.impl.OnItemClickListener;
import com.yanzhenjie.album.widget.divider.Api21ItemDivider;
import com.yanzhenjie.album.widget.divider.Divider;


import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;

import java.util.List;

import ar.com.rys.z2020.R;

public class TrasyFragment extends Fragment {



    private TrasyAdapter mAdapter;
    //private ArrayList<AlbumFile> mAlbumFiles = new ArrayList<>();
    private List<TrasyResourceData> allResourcesData = new ArrayList<>();


    public  static Integer[] imagesString = {
            R.drawable.trasa_w_bsas,
            R.drawable.trasa_w_sma,
            R.drawable.trasa_wedrowki,
    };

    public  static int[] titles = {
            R.string.trasa_bsas,
            R.string.trasa_sma,
            R.string.trasa_wedro,
    };


    private void loadData(){

        if(CollectionUtils.isEmpty(allResourcesData)){
            for (int i = 0; i<imagesString.length; i++){
                TrasyResourceData trasyResourceData = new TrasyResourceData();
                trasyResourceData.setImagesResource(imagesString[i]);
                trasyResourceData.setImageTitle(getString(titles[i]));
                allResourcesData.add(trasyResourceData);
            }
        }

    }



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_trasy, container, false);

        super.onCreate(savedInstanceState);

        loadData();


        final Context context = this.getContext();

        RecyclerView recyclerView = root.findViewById(R.id.recycler_maps_view);


        //recyclerView.setLayoutManager(new GridLayoutManager(context, 1));

        LinearLayoutManager linear = new LinearLayoutManager(context);
        linear.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linear);

        //Divider divider = new Api21ItemDivider(Color.TRANSPARENT, 10, 10);
        Divider divider = new Api21ItemDivider(Color.TRANSPARENT, 10, 100);
        recyclerView.addItemDecoration(divider);

        mAdapter = new TrasyAdapter(context, new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                previewImage(position);
            }
        }, allResourcesData);

        recyclerView.setAdapter(mAdapter);

        return root;
    }

    private ArrayList<AlbumFile> getAlbumFiles(){

        ArrayList<AlbumFile> mAlbumFiles = new ArrayList<>();

        allResourcesData.forEach(p->{
            mAlbumFiles.add(p.getAlbumFile());
        });

        return mAlbumFiles;

    }


    private void previewImage(int position) {
        if (allResourcesData == null || allResourcesData.size() == 0) {
            //Toast.makeText(this, R.string.no_selected, Toast.LENGTH_LONG).show();
        } else {
            Album.galleryAlbum(this)
                    .checkable(false)
                    .checkedList(getAlbumFiles())
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
                            /*
                            mAlbumFiles = result;
                            mAdapter.notifyDataSetChanged(mAlbumFiles);

                             */
                        }
                    })
                    .start();
        }
    }
}