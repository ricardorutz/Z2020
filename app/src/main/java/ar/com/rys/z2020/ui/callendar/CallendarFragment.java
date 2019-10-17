package ar.com.rys.z2020.ui.callendar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ar.com.rys.z2020.R;

import com.applandeo.materialcalendarview.CalendarView;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class CallendarFragment extends Fragment {

    private CallendarViewModel toolsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        toolsViewModel = ViewModelProviders.of(this).get(CallendarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_callendar, container, false);
        final TextView textView = root.findViewById(R.id.textViewCalendar);
        textView.setText(R.string.home_item_termin);
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_calendar_alt_solid, 0, 0, 0);

        CalendarView calendarView = root.findViewById(R.id.calendarView);
        calendarView.setSelectedDates(getSelectedDays());

        Calendar calStart = getInitCalendar();

        Calendar calEnd = Calendar.getInstance();
        calEnd.set(Calendar.YEAR, 2020);
        calEnd.set(Calendar.MONTH, Calendar.JANUARY);
        calEnd.set(Calendar.DAY_OF_MONTH, 31);

        calendarView.setMinimumDate(calStart);
        calendarView.setMaximumDate(calEnd);

        return root;
    }

    private List<Calendar> getSelectedDays() {



        List<Calendar> calendars = new ArrayList<>();

        DateTime start = new DateTime(2019, 12, 30, 0, 0, 0, 0);
        DateTime end = new DateTime(2020, 1, 8, 0, 0, 0, 0);

        Days days = Days.daysBetween(start, end);

        int qtyDays = days.getDays();


        for (int i = 0; i < qtyDays; i++) {

            Calendar calendar = getInitCalendar();
            calendar.add(Calendar.DAY_OF_MONTH, i);
            calendars.add(calendar);

        }

        return calendars;
    }


    public Calendar getInitCalendar(){

        Calendar calStart = Calendar.getInstance();
        calStart.set(Calendar.YEAR, 2019);
        calStart.set(Calendar.MONTH, Calendar.DECEMBER);
        calStart.set(Calendar.DAY_OF_MONTH, 30);

        return  calStart;

    }



}