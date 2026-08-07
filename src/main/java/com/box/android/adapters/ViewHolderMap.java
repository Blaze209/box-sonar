package com.box.android.adapters;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public class ViewHolderMap extends RecyclerView.ViewHolder {
    private final View mParentView;
    private final HashMap<Integer, View> map;

    public ViewHolderMap(View view) {
        super(view);
        this.map = new HashMap<>();
        this.mParentView = view;
    }

    public View getView(int i) {
        if (i < 1) {
            return null;
        }
        if (!this.map.containsKey(Integer.valueOf(i))) {
            this.map.put(Integer.valueOf(i), this.mParentView.findViewById(i));
        }
        return this.map.get(Integer.valueOf(i));
    }

    public <T extends View> T getView(int i, Class<T> cls) {
        View view = getView(i);
        if (view == null) {
            return null;
        }
        return cls.cast(view);
    }

    public View getParentView() {
        return this.mParentView;
    }
}
