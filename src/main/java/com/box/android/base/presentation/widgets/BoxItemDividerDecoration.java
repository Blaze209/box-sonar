package com.box.android.base.presentation.widgets;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.base.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxItemDividerDecoration.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005R\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bJ \u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/box/android/base/presentation/widgets/BoxItemDividerDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "resources", "Landroid/content/res/Resources;", "theme", "Landroid/content/res/Resources$Theme;", "<init>", "(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;)V", "drawable", "Landroid/graphics/drawable/Drawable;", "leftMargin", "", "rightMargin", "(Landroid/graphics/drawable/Drawable;II)V", "mDivider", "mLeftMargin", "mRightMargin", "mSkipLeadingPositions", "setSkipLeadingPositions", "", "count", "onDrawOver", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxItemDividerDecoration extends RecyclerView.ItemDecoration {
    public static final int $stable = 8;
    private Drawable mDivider;
    private int mLeftMargin;
    private int mRightMargin;
    private int mSkipLeadingPositions;

    public BoxItemDividerDecoration(Resources resources, Resources.Theme theme) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(theme, "theme");
        this.mSkipLeadingPositions = 1;
        Drawable drawable = resources.getDrawable(R.drawable.box_browsesdk_item_divider, theme);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(...)");
        this.mDivider = drawable;
        this.mLeftMargin = resources.getDimensionPixelSize(R.dimen.box_browsesdk_list_item_divider_margin_left);
        this.mRightMargin = 0;
    }

    public BoxItemDividerDecoration(Drawable drawable, int i, int i2) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.mSkipLeadingPositions = 1;
        this.mDivider = drawable;
        this.mLeftMargin = i;
        this.mRightMargin = i2;
    }

    public final void setSkipLeadingPositions(int count) {
        this.mSkipLeadingPositions = count;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int paddingLeft = this.mLeftMargin + parent.getPaddingLeft();
        int width = parent.getWidth() - (parent.getPaddingRight() + this.mRightMargin);
        int childCount = parent.getChildCount() - 1;
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            if (parent.getChildAdapterPosition(childAt) >= this.mSkipLeadingPositions) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                this.mDivider.setBounds(paddingLeft, (childAt.getBottom() + layoutParams2.bottomMargin) - this.mDivider.getIntrinsicHeight(), width, childAt.getBottom() + layoutParams2.bottomMargin);
                this.mDivider.draw(c);
            }
        }
    }
}
