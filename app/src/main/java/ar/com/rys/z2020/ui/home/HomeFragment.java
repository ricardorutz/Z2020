package ar.com.rys.z2020.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import java.util.ArrayList;
import java.util.List;


import ar.com.rys.z2020.R;

//http://www.technotalkative.com/android-bullets-in-listview/

public class HomeFragment extends Fragment {

    ArrayList<String> listCountry;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        prepareList();

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(
                root.getContext(), R.layout.list_item, listCountry);


        List<Integer> resList = new ArrayList();
        resList.add(R.drawable.ic_menu_home);
        resList.add(R.drawable.ic_calendar_alt_solid);
        resList.add(R.drawable.ic_cloud_sun_rain_solid);
        resList.add(R.drawable.ic_cloud_sun_rain_solid);
        resList.add(R.drawable.ic_cloud_sun_rain_solid);
        resList.add(R.drawable.ic_cloud_sun_rain_solid);
        resList.add(R.drawable.ic_cloud_sun_rain_solid);
        resList.add(R.drawable.ic_cloud_sun_rain_solid);
        resList.add(R.drawable.ic_cloud_sun_rain_solid);
        resList.add(R.drawable.ic_cloud_sun_rain_solid);
        resList.add(R.drawable.ic_cloud_sun_rain_solid);
        resList.add(R.drawable.ic_calendar_alt_solid);
        resList.add(R.drawable.ic_calendar_alt_solid);
        resList.add(R.drawable.ic_calendar_alt_solid);
        resList.add(R.drawable.ic_calendar_alt_solid);
        resList.add(R.drawable.ic_calendar_alt_solid);
        resList.add(R.drawable.ic_calendar_alt_solid);
        resList.add(R.drawable.ic_menu_home);
        resList.add(R.drawable.ic_menu_home);
        resList.add(R.drawable.ic_menu_home);
        resList.add(R.drawable.ic_menu_home);
        resList.add(R.drawable.ic_menu_home);
        resList.add(R.drawable.ic_menu_home);
        resList.add(R.drawable.ic_menu_home);





        NotificationsAdapter nAdapter = new NotificationsAdapter(root.getContext(), R.layout.list_item, listCountry, resList);


        ListView listView = root.findViewById(R.id.listView);
        listView.setAdapter(nAdapter);


        return root;
    }

    public void prepareList()
    {
        listCountry = new ArrayList<String>();
        listCountry.add("India");
        listCountry.add("Brazil");
        listCountry.add("Canada");
        listCountry.add("China");
        listCountry.add("France");
        listCountry.add("Germany");
        listCountry.add("Iran");
        listCountry.add("Italy");
        listCountry.add("Japan");
        listCountry.add("Korea");
        listCountry.add("Mexico");
        listCountry.add("Netherlands");
        listCountry.add("Portugal");
        listCountry.add("Russia");
        listCountry.add("Saudi Arabia");
        listCountry.add("Spain");
        listCountry.add("Turkey");
        listCountry.add("United Kingdom");
        listCountry.add("United States");
    }
}