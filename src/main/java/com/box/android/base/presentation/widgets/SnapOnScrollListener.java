package com.box.android.base.presentation.widgets;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SnapOnScrollListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/presentation/widgets/SnapOnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "snapHelper", "Landroidx/recyclerview/widget/SnapHelper;", "onSnapPositionChanged", "Lkotlin/Function1;", "", "", "snapPosition", "<init>", "(Landroidx/recyclerview/widget/SnapHelper;Lkotlin/jvm/functions/Function1;I)V", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "notifySnapPositionChanged", "getSnapPosition", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SnapOnScrollListener extends RecyclerView.OnScrollListener {
    public static final int $stable = 8;
    private final Function1<Integer, Unit> onSnapPositionChanged;
    private final SnapHelper snapHelper;
    private int snapPosition;

    /* JADX WARN: Multi-variable type inference failed */
    public SnapOnScrollListener(SnapHelper snapHelper, Function1<? super Integer, Unit> onSnapPositionChanged, int i) {
        Intrinsics.checkNotNullParameter(snapHelper, "snapHelper");
        Intrinsics.checkNotNullParameter(onSnapPositionChanged, "onSnapPositionChanged");
        this.snapHelper = snapHelper;
        this.onSnapPositionChanged = onSnapPositionChanged;
        this.snapPosition = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (newState == 0) {
            notifySnapPositionChanged(recyclerView);
        }
    }

    private final void notifySnapPositionChanged(RecyclerView recyclerView) {
        int snapPosition = getSnapPosition(recyclerView);
        if (snapPosition != this.snapPosition) {
            this.onSnapPositionChanged.invoke(Integer.valueOf(snapPosition));
            this.snapPosition = snapPosition;
        }
    }

    private final int getSnapPosition(RecyclerView recyclerView) {
        View viewFindSnapView;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null || (viewFindSnapView = this.snapHelper.findSnapView(recyclerView.getLayoutManager())) == null) {
            return -1;
        }
        return layoutManager.getPosition(viewFindSnapView);
    }
}
