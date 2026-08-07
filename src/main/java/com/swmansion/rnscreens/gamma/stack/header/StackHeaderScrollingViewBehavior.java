package com.swmansion.rnscreens.gamma.stack.header;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHeaderScrollingViewBehavior.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B?\u00126\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0004\b\u000b\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016R>\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderScrollingViewBehavior;", "Lcom/google/android/material/appbar/AppBarLayout$ScrollingViewBehavior;", "onDependencyChanged", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "contentTop", "Landroid/view/View;", "dependency", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "onDependentViewChanged", "", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StackHeaderScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
    private final Function2<Integer, View, Unit> onDependencyChanged;

    /* JADX WARN: Multi-variable type inference failed */
    public StackHeaderScrollingViewBehavior(Function2<? super Integer, ? super View, Unit> onDependencyChanged) {
        Intrinsics.checkNotNullParameter(onDependencyChanged, "onDependencyChanged");
        this.onDependencyChanged = onDependencyChanged;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        boolean zOnDependentViewChanged = super.onDependentViewChanged(parent, child, dependency);
        this.onDependencyChanged.invoke(Integer.valueOf(child.getTop()), dependency);
        return zOnDependentViewChanged;
    }
}
