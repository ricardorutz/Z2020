package ar.com.rys.z2020.ui.weather;

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

import com.yanzhenjie.album.widget.divider.Api21ItemDivider;
import com.yanzhenjie.album.widget.divider.Divider;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import ar.com.rys.z2020.R;

public class WeatherFragment extends Fragment {

    private WeatherAdapter mAdapter;
    private List<WeatherResourceData> allResourcesData = new ArrayList<>();


    public  static Integer[] imagesString = {
            R.drawable.ic_cloud_sun_solid,
            R.drawable.ic_cloud_sun_rain_solid,
            R.drawable.ic_cloud_sun_rain_solid,
            R.drawable.ic_cloud_sun_rain_solid,
            R.drawable.ic_cloud_sun_rain_solid,
            R.drawable.ic_cloud_sun_rain_solid,
            R.drawable.ic_cloud_sun_rain_solid,
            R.drawable.ic_cloud_sun_rain_solid,
            R.drawable.ic_cloud_sun_rain_solid,
            R.drawable.ic_cloud_sun_rain_solid,
    };


    public  static int[] namesAndNumberOfDates = {
            R.string.date_1,
            R.string.date_2,
            R.string.date_3,
            R.string.date_4,
            R.string.date_5,
            R.string.date_6,
            R.string.date_7,
            R.string.date_8,
            R.string.date_9,
            R.string.date_10
    };


    private void loadData(){

        if(CollectionUtils.isEmpty(allResourcesData)){
            for (int i = 0; i<imagesString.length; i++){
                WeatherResourceData trasyResourceData = new WeatherResourceData();
                trasyResourceData.setImagesResource(imagesString[i]);
                trasyResourceData.setDateNameAndNumber(getString(namesAndNumberOfDates[i]));
                allResourcesData.add(trasyResourceData);
            }
        }

    }



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_weather, container, false);

        super.onCreate(savedInstanceState);

        loadData();


        final Context context = this.getContext();

        RecyclerView recyclerView = root.findViewById(R.id.recycler_weather_view);


        recyclerView.setLayoutManager(new GridLayoutManager(context, 3));


        Divider divider = new Api21ItemDivider(Color.BLACK, 5, 5);
        recyclerView.addItemDecoration(divider);

        mAdapter = new WeatherAdapter(context, allResourcesData);

        recyclerView.setAdapter(mAdapter);

        return root;
    }

}