package ar.com.rys.z2020.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import java.util.Calendar;




import ar.com.rys.z2020.R;
import cn.iwgang.countdownview.CountdownView;


//http://www.technotalkative.com/android-bullets-in-listview/

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);


        Calendar today = Calendar.getInstance();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 30);


        long timeTo = cal.getTimeInMillis()-today.getTimeInMillis();


        CountdownView mCvCountdownView = root.findViewById(R.id.cv_countdownView);
        mCvCountdownView.start(timeTo); // Millisecond

        HomeAdapter nAdapter = new HomeAdapter(root.getContext(), R.layout.fragment_home_list_item);


        //ListView listView = root.findViewById(R.id.listView);
        //listView.setAdapter(nAdapter);


        return root;
    }


}