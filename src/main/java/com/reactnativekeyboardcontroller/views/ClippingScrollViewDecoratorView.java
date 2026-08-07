package com.reactnativekeyboardcontroller.views;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;
import com.reactnativekeyboardcontroller.extensions.FloatKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClippingScrollViewDecoratorView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0014J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/reactnativekeyboardcontroller/views/ClippingScrollViewDecoratorView;", "Lcom/facebook/react/views/view/ReactViewGroup;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "<init>", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "getReactContext", "()Lcom/facebook/react/uimanager/ThemedReactContext;", "insetBottom", "", "insetTop", "appliedTopInsetPx", "", "onAttachedToWindow", "", "setContentInsetBottom", "value", "setContentInsetTop", "setApplyWorkaroundForContentInsetHitTestBug", "", "decorateScrollView", "findScrollView", "Landroid/widget/ScrollView;", "view", "Landroid/view/View;", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClippingScrollViewDecoratorView extends ReactViewGroup {
    private int appliedTopInsetPx;
    private double insetBottom;
    private double insetTop;
    private final ThemedReactContext reactContext;

    public final void setApplyWorkaroundForContentInsetHitTestBug(boolean value) {
    }

    public final ThemedReactContext getReactContext() {
        return this.reactContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClippingScrollViewDecoratorView(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        decorateScrollView();
    }

    public final void setContentInsetBottom(double value) {
        this.insetBottom = value;
        decorateScrollView();
    }

    public final void setContentInsetTop(double value) {
        this.insetTop = value;
        decorateScrollView();
    }

    private final void decorateScrollView() {
        ScrollView scrollViewFindScrollView = findScrollView(this);
        if (scrollViewFindScrollView == null) {
            return;
        }
        scrollViewFindScrollView.setClipToPadding(false);
        int px = (int) FloatKt.getPx((float) this.insetTop);
        View childAt = scrollViewFindScrollView.getChildAt(0);
        ViewGroup viewGroup = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setTranslationY(px);
        scrollViewFindScrollView.setPadding(scrollViewFindScrollView.getPaddingLeft(), scrollViewFindScrollView.getPaddingTop(), scrollViewFindScrollView.getPaddingRight(), (int) FloatKt.getPx((float) (this.insetBottom + this.insetTop)));
        int i = px - this.appliedTopInsetPx;
        if (i != 0) {
            scrollViewFindScrollView.scrollBy(0, i);
        }
        this.appliedTopInsetPx = px;
    }

    private final ScrollView findScrollView(View view) {
        if (view instanceof ScrollView) {
            return (ScrollView) view;
        }
        ScrollView scrollViewFindScrollView = null;
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount() || scrollViewFindScrollView != null) {
                    break;
                }
                scrollViewFindScrollView = findScrollView(viewGroup.getChildAt(i));
                i++;
            }
        }
        return scrollViewFindScrollView;
    }
}
