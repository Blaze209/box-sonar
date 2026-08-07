package com.pspdfkit.internal;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes3.dex */
public final class tx extends RecyclerView.ItemDecoration {
    public final Drawable a;

    public tx(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, new int[]{R.attr.listDivider});
        this.a = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (this.a != null && recyclerView.getChildAdapterPosition(view) >= 1) {
            if (!(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
                throw new IllegalStateException("DividerItemDecoration can only be used with a LinearLayoutManager.");
            }
            int orientation = ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation();
            Drawable drawable = this.a;
            if (orientation == 1) {
                rect.top = drawable.getIntrinsicHeight();
            } else {
                rect.left = drawable.getIntrinsicWidth();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.a == null) {
            super.onDrawOver(canvas, recyclerView, state);
            return;
        }
        if (!(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            throw new IllegalStateException("DividerItemDecoration can only be used with a LinearLayoutManager.");
        }
        int i = 1;
        if (((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation() != 1) {
            int paddingTop = recyclerView.getPaddingTop();
            int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            int childCount = recyclerView.getChildCount();
            while (i < childCount) {
                View childAt = recyclerView.getChildAt(i);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                int intrinsicWidth = this.a.getIntrinsicWidth();
                int left = childAt.getLeft() - layoutParams.leftMargin;
                this.a.setBounds(left, paddingTop, intrinsicWidth + left, height);
                this.a.draw(canvas);
                i++;
            }
            return;
        }
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount2 = recyclerView.getChildCount();
        if (childCount2 == 1) {
            int bottom = recyclerView.getChildAt(0).getBottom();
            this.a.setBounds(paddingLeft, bottom - this.a.getIntrinsicHeight(), width, bottom);
            this.a.draw(canvas);
            return;
        }
        while (i < childCount2) {
            View childAt2 = recyclerView.getChildAt(i);
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) childAt2.getLayoutParams();
            int intrinsicHeight = this.a.getIntrinsicHeight();
            int top = childAt2.getTop() - layoutParams2.topMargin;
            this.a.setBounds(paddingLeft, top, width, top + intrinsicHeight);
            this.a.draw(canvas);
            if (i == childCount2 - 1) {
                int bottom2 = childAt2.getBottom();
                this.a.setBounds(paddingLeft, bottom2 - intrinsicHeight, width, bottom2);
                this.a.draw(canvas);
            }
            i++;
        }
    }
}
