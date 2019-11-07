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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.rys.z2020.R;

public class WeatherFragment extends Fragment {

    private WeatherAdapter mAdapter;
    private Map<String, List<WeatherResourceData>> allData = new HashMap<>();


/*
    private void loadData(){

        if(CollectionUtils.isEmpty(allResourcesData)){
            for (int i = 0; i<
                    imagesString.length; i++){
                WeatherResourceData weatherResourceData = new WeatherResourceData();
                weatherResourceData.setImagesResource(imagesString[i]);
                weatherResourceData.setDateNameAndNumber(getString(namesAndNumberOfDates[i]));
                weatherResourceData.setTemperature(getString(temperatures[i]));
                weatherResourceData.setHistoricTemperature(getString(historic_temperatures[i]));
                allResourcesData.add(weatherResourceData);
            }
        }

    }

 */



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_weather, container, false);

        super.onCreate(savedInstanceState);

        WeatherStaticDataDeclaration w = new WeatherStaticDataDeclaration(getContext());

        w.loadData();

        //loadData();


        final Context context = this.getContext();
/*
        RecyclerView recyclerViewBsAs = root.findViewById(R.id.recycler_weather_view_bsas);
        recyclerViewBsAs.setLayoutManager(new GridLayoutManager(context, 3));


        Divider dividerBsAs = new Api21ItemDivider(Color.BLACK, 5, 5);
        recyclerViewBsAs.addItemDecoration(dividerBsAs);

        mAdapter = new WeatherAdapter(context, allResourcesData);

        recyclerViewBsAs.setAdapter(mAdapter);

 */






        RecyclerView recyclerView = root.findViewById(R.id.recycler_weather_view);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 3));


        Divider divider = new Api21ItemDivider(Color.BLACK, 5, 5);
        recyclerView.addItemDecoration(divider);

        mAdapter = new WeatherAdapter(context, w.getAllResourcesData());

        recyclerView.setAdapter(mAdapter);

        return root;
    }

}