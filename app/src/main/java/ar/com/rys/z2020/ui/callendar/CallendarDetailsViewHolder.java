package ar.com.rys.z2020.ui.callendar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import ar.com.rys.z2020.R;

public class CallendarDetailsViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewDate;

    CallendarDetailsViewHolder(View itemView) {
        super(itemView);
        this.textViewDate = itemView.findViewById(R.id.text_view_callendar);
    }

    public void setData(CallendarResourceData data) {
        this.textViewDate.setText(data.getDateNameAndNumber());
    }


}