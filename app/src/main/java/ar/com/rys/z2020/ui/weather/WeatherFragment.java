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

    private WeatherGeneralAdapter mAdapter;
    private Map<String, List<WeatherResourceData>> allData = new HashMap<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_weather, container, false);

        super.onCreate(savedInstanceState);

        WeatherStaticDataDeclaration w = new WeatherStaticDataDeclaration(getContext());

        final Context context = this.getContext();


        RecyclerView recyclerView = root.findViewById(R.id.recycler_weather_view);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));


        Divider divider = new Api21ItemDivider(Color.BLACK, 5, 5);
        recyclerView.addItemDecoration(divider);

        mAdapter = new WeatherGeneralAdapter(context, w.getMap());

        recyclerView.setAdapter(mAdapter);

        return root;
    }

}