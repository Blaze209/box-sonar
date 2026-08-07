package com.pspdfkit.internal.views.utils.recyclerview;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes3.dex */
public class AutoSpanGridLayoutManager extends GridLayoutManager {
    public final int a;
    public final int b;
    public int c;

    public AutoSpanGridLayoutManager(Context context, int i) {
        super(context, 1);
        this.c = 0;
        this.a = 3;
        if (i > 0 && i != this.b) {
            this.b = i;
            this.c = 0;
        }
        setOrientation(1);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int width = (getWidth() - getPaddingRight()) - getPaddingLeft();
        if (this.b > 0 && this.c != width) {
            setSpanCount(Math.max(this.a, ((getWidth() - getPaddingRight()) - getPaddingLeft()) / this.b));
            this.c = width;
        }
        super.onLayoutChildren(recycler, state);
    }
}
