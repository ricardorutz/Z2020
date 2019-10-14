package ar.com.rys.z2020.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;




import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;




import ar.com.rys.z2020.R;
import cn.iwgang.countdownview.CountdownView;


//http://www.technotalkative.com/android-bullets-in-listview/

public class HomeFragment extends Fragment {

    List<Integer> listOfTexts;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        listOfTexts = prepareList();

        ArrayAdapter arrayAdapter = new ArrayAdapter<Integer>(
                root.getContext(), R.layout.fragment_home_list_item, listOfTexts);

        Calendar today = Calendar.getInstance();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 30);



        long timeTo = cal.getTimeInMillis()-today.getTimeInMillis();


        CountdownView mCvCountdownView = root.findViewById(R.id.cv_countdownView);
        mCvCountdownView.start(timeTo); // Millisecond

        HomeAdapter nAdapter = new HomeAdapter(root.getContext(), R.layout.fragment_home_list_item, listOfTexts);


        ListView listView = root.findViewById(R.id.listView);
        listView.setAdapter(nAdapter);


        return root;
    }

    public List<Integer> prepareList()
    {

        if(listOfTexts==null){
            listOfTexts = new ArrayList<Integer>();
            listOfTexts.add(R.string.home_item_mayor);
            listOfTexts.add(R.string.home_item_termin);
            listOfTexts.add(R.string.home_item_temperature);
            listOfTexts.add(R.string.home_item_temperature_bsas);
            listOfTexts.add(R.string.home_item_temperature_sma);

        }

        return  listOfTexts;

    }
}