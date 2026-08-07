package com.box.android.base.presentation.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentContainerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TouchInterceptorViewGroup.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\nJ\u0012\u0010\f\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000eH\u0016R*\u0010\f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/box/android/base/presentation/views/TouchInterceptorViewGroup;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onInterceptTouchEvent", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "", "getOnInterceptTouchEvent", "()Lkotlin/jvm/functions/Function1;", "setOnInterceptTouchEvent", "(Lkotlin/jvm/functions/Function1;)V", "fragmentContainerView", "Landroidx/fragment/app/FragmentContainerView;", "getFragmentContainerView", "()Landroidx/fragment/app/FragmentContainerView;", "setFragmentContainerView", "(Landroidx/fragment/app/FragmentContainerView;)V", "addFragmentContainerView", "id", "", "motionEvent", "dispatchTouchEvent", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TouchInterceptorViewGroup extends FrameLayout {
    public static final int $stable = 8;
    public FragmentContainerView fragmentContainerView;
    private Function1<? super MotionEvent, Unit> onInterceptTouchEvent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouchInterceptorViewGroup(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouchInterceptorViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouchInterceptorViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final Function1<MotionEvent, Unit> getOnInterceptTouchEvent() {
        return this.onInterceptTouchEvent;
    }

    public final void setOnInterceptTouchEvent(Function1<? super MotionEvent, Unit> function1) {
        this.onInterceptTouchEvent = function1;
    }

    public final FragmentContainerView getFragmentContainerView() {
        FragmentContainerView fragmentContainerView = this.fragmentContainerView;
        if (fragmentContainerView != null) {
            return fragmentContainerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fragmentContainerView");
        return null;
    }

    public final void setFragmentContainerView(FragmentContainerView fragmentContainerView) {
        Intrinsics.checkNotNullParameter(fragmentContainerView, "<set-?>");
        this.fragmentContainerView = fragmentContainerView;
    }

    public final void addFragmentContainerView(int id) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        FragmentContainerView fragmentContainerView = new FragmentContainerView(context);
        fragmentContainerView.setId(id);
        setFragmentContainerView(fragmentContainerView);
        addView(fragmentContainerView);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Function1<? super MotionEvent, Unit> function1 = this.onInterceptTouchEvent;
        if (function1 != null) {
            function1.invoke(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        Integer numValueOf = motionEvent != null ? Integer.valueOf(motionEvent.getActionMasked()) : null;
        if (numValueOf != null && numValueOf.intValue() == 5) {
            ViewParent parent2 = getParent();
            if (parent2 != null) {
                parent2.requestDisallowInterceptTouchEvent(true);
            }
        } else if (((numValueOf != null && numValueOf.intValue() == 1) || (numValueOf != null && numValueOf.intValue() == 3)) && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
