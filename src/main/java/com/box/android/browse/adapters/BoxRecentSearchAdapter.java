package com.box.android.browse.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.box.android.browse.R;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class BoxRecentSearchAdapter extends ArrayAdapter<String> {
    List<String> mHistory;
    BoxRecentSearchListener mListener;

    public interface BoxRecentSearchListener {
        void onCloseClicked(int i);
    }

    public BoxRecentSearchAdapter(Context context, List<String> list, BoxRecentSearchListener boxRecentSearchListener) {
        super(context, R.layout.box_browsesdk_search_recent_item, list);
        this.mHistory = list;
        this.mListener = boxRecentSearchListener;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.box_browsesdk_search_recent_item, viewGroup, false);
        }
        ((TextView) view.findViewById(R.id.text)).setText(this.mHistory.get(i));
        ((ImageView) view.findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.browse.adapters.BoxRecentSearchAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BoxRecentSearchAdapter.this.mListener.onCloseClicked(i);
            }
        });
        return view;
    }
}
