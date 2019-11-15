package ar.com.rys.z2020.ui.callendar;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yanzhenjie.album.widget.divider.Api21ItemDivider;
import com.yanzhenjie.album.widget.divider.Divider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.rys.z2020.R;

public class CallendarFragment extends Fragment {

    private CallendarAdapter mAdapter;
    private Map<String, List<CallendarResourceData>> allData = new HashMap<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_callendar, container, false);

        super.onCreate(savedInstanceState);

        CallendarStaticDataDeclaration w = new CallendarStaticDataDeclaration(getContext());

        final Context context = this.getContext();

        final TextView textView = root.findViewById(R.id.textViewCalendar);
        textView.setText(R.string.home_item_termin);
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_calendar_alt_solid, 0, 0, 0);


        RecyclerView recyclerView = root.findViewById(R.id.recycler_callendar_view);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));


        Divider divider = new Api21ItemDivider(Color.BLACK, 5, 5);
        recyclerView.addItemDecoration(divider);

        mAdapter = new CallendarAdapter(context, w.getMap());

        recyclerView.setAdapter(mAdapter);

        return root;
    }

}