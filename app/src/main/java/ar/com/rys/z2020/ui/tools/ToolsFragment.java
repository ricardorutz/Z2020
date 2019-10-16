package ar.com.rys.z2020.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.time.Duration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ar.com.rys.z2020.R;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.utils.DateUtils;

import org.joda.time.LocalDate;
import org.joda.time.Period;

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);


        //DateRange dateRange = new DateRange(start, end);

        CalendarView calendarView = root.findViewById(R.id.calendarView);
        calendarView.setSelectedDates(getSelectedDays());

        //calendarView.setSelectionMode(CalendarSelectionMode.Range);
        //calendarView.set

        toolsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    private List<Calendar> getSelectedDays() {

        Calendar calStart = Calendar.getInstance();
        calStart.set(Calendar.YEAR, 2019);
        calStart.set(Calendar.MONTH, Calendar.DECEMBER);
        calStart.set(Calendar.DAY_OF_MONTH, 30);

        Calendar calEnd = Calendar.getInstance();
        calEnd.set(Calendar.YEAR, 2020);
        calEnd.set(Calendar.MONTH, Calendar.JANUARY);
        calEnd.set(Calendar.DAY_OF_MONTH, 16);

        LocalDate endDate = LocalDate.fromCalendarFields(calEnd);
        LocalDate startDate = LocalDate.fromCalendarFields(calStart);

        Period diff = Period.fieldDifference(startDate, endDate);

        //Period diff = Period.between(endofCentury, now);

        System.out.printf("Difference is %d years, %d months and %d days old",
                diff.getYears(), diff.getMonths(), diff.getDays());

        int dayCount = diff.getDays();

        int cout2 = diff.getMonths();




        List<Calendar> calendars = new ArrayList<>();
/*
        Calendar calStartForView = Calendar.getInstance();
        calStartForView.set(Calendar.YEAR, 2019);
        calStartForView.set(Calendar.MONTH, Calendar.DECEMBER);
        calStartForView.set(Calendar.DAY_OF_MONTH, 30);

        calendars.add(calStartForView);

 */

        for (int i = 0; i < dayCount; i++) {
            Calendar calendar = calStart;
            calendar.add(Calendar.DAY_OF_MONTH, i);
            calendars.add(calendar);
        }

        return calendars;
    }
}