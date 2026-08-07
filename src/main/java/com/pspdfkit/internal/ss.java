package com.pspdfkit.internal;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ss extends DefaultItemAnimator {
    @Override // androidx.recyclerview.widget.SimpleItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder viewHolder) {
        viewHolder.getClass();
        return true;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder viewHolder, List<? extends Object> list) {
        viewHolder.getClass();
        list.getClass();
        return true;
    }
}
