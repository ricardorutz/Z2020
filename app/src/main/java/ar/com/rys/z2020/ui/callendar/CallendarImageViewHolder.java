package ar.com.rys.z2020.ui.callendar;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yanzhenjie.album.widget.divider.Api21ItemDivider;
import com.yanzhenjie.album.widget.divider.Divider;

import java.util.List;

import ar.com.rys.z2020.R;

public class CallendarImageViewHolder extends RecyclerView.ViewHolder {

    private View itemView;
    private TextView textViewTitle;
    private  RecyclerView recyclerView;
    private CallendarDetailsAdapter mAdapter;

    public CallendarImageViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        this.textViewTitle = itemView.findViewById(R.id.text_callendar_view_title);
        this.recyclerView = itemView.findViewById(R.id.recycler_callendar_view_list);
    }

    public void setData(List<CallendarResourceData> data, String title) {
        this.textViewTitle.setText(title);

        recyclerView.setLayoutManager(new GridLayoutManager(itemView.getContext(), 7));

        Divider divider = new Api21ItemDivider(Color.BLACK, 5, 5);
        recyclerView.addItemDecoration(divider);

        mAdapter = new CallendarDetailsAdapter(itemView.getContext(), data);

        recyclerView.setAdapter(mAdapter);

    }


}