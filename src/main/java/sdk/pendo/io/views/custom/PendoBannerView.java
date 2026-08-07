package sdk.pendo.io.views.custom;

import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.GuideTapOnManager;
import sdk.pendo.io.actions.PendoBannerGuideManager;
import sdk.pendo.io.b.a;
import sdk.pendo.io.d8.b;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.o5.d;
import sdk.pendo.io.s7.e1;
import sdk.pendo.io.s7.v0;
import sdk.pendo.io.x6.g;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0007J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0017J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J0\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0014J\u0018\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nH\u0014J\u0018\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\nH\u0017J\b\u0010'\u001a\u00020\u0017H\u0016J\b\u0010(\u001a\u00020\u0017H\u0016¨\u0006*"}, d2 = {"Lsdk/pendo/io/views/custom/PendoBannerView;", "Lsdk/pendo/io/views/custom/PendoFloatingVisualGuideView;", "context", "Landroid/content/Context;", "builder", "Lsdk/pendo/io/actions/PendoBannerGuideManager$Builder;", "(Landroid/content/Context;Lsdk/pendo/io/actions/PendoBannerGuideManager$Builder;)V", "checkForManualScreenOrientation", "", "width", "", "height", "consumeTouchEventIfOnPendoView", "event", "Landroid/view/MotionEvent;", "getBannerChildMeasureSpec", "myWidth", "getMaxWidthByCalculation", "guideViewRight", "guideViewLeft", "getViewGroupToTraverse", "Landroid/view/ViewGroup;", "initializeView", "", "onDetachedFromWindow", "onHoverEvent", "onLayout", "changed", CmcdData.STREAM_TYPE_LIVE, "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "removeFromParent", "show", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PendoBannerView extends PendoFloatingVisualGuideView {
    private static final String TAG = "PendoBannerView";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PendoBannerView(Context context, PendoBannerGuideManager.Builder builder) {
        PendoFloatingVisualGuideView.OnFloatingGuideListener onFloatingGuideListener;
        super(context, builder);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(builder, "builder");
        try {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
            this.mRootView.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
            if (accessibilityNodeInfoObtain != null && !accessibilityNodeInfoObtain.isVisibleToUser() && (onFloatingGuideListener = this.mFloatingGuideListener) != null) {
                onFloatingGuideListener.onShowFailed(this);
            }
            this.mAnchorViewWeakRef = new WeakReference<>(this.mRootView);
            View rootView = builder.getRootView();
            if (rootView != null && rootView.getViewTreeObserver().isAlive()) {
                rootView.addOnAttachStateChangeListener(this.mAnchorViewAttachedStateListener);
            }
            v0.b(builder.getPaneTitle(), new Function1<String, Unit>() { // from class: sdk.pendo.io.views.custom.PendoBannerView.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ViewCompat.setAccessibilityPaneTitle(PendoBannerView.this, it);
                }
            });
            View view = this.mGuideView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) view).setDescendantFocusability(131072);
        } catch (Exception e) {
            PendoLogger.w(e, e.getMessage(), "PendoBannerView init");
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0028 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x002a A[RETURN] */
    public final boolean checkForManualScreenOrientation(int width, int height) {
        try {
            Display display = getContext().getDisplay();
            Integer numValueOf = display != null ? Integer.valueOf(display.getRotation()) : null;
            if (numValueOf != null && numValueOf.intValue() == 1) {
                if (width < height) {
                    return true;
                }
            } else if (numValueOf != null && numValueOf.intValue() == 3) {
                if (width < height) {
                    return true;
                }
            }
            if (numValueOf == null || numValueOf.intValue() != 0) {
                if (numValueOf == null || numValueOf.intValue() != 2) {
                    return false;
                }
            }
            return height < width;
        } catch (Exception unused) {
            PendoLogger.w(TAG, "checkForScreenRotationDimensions failed, returning original values");
            return false;
        }
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView
    public boolean consumeTouchEventIfOnPendoView(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (isAttached() && isShown()) {
            Boolean boolA = e1.a(event, this.mGuideView, this.mWindowMarginX, this.mWindowMarginY);
            Intrinsics.checkNotNull(boolA);
            if (boolA.booleanValue()) {
                return true;
            }
            touchOutsideOfFloatingGuide();
        }
        return false;
    }

    public final int getBannerChildMeasureSpec(int myWidth) {
        int layoutMaxWidth;
        View view = this.mGuideView;
        if (view != null) {
            Class<?> cls = view.getClass();
            if (Intrinsics.areEqual(cls, PendoScrollView.class)) {
                layoutMaxWidth = ((PendoScrollView) view).getLayoutMaxWidth();
            } else if (Intrinsics.areEqual(cls, PendoLinearLayout.class)) {
                layoutMaxWidth = ((PendoLinearLayout) view).getLayoutMaxWidth();
            } else {
                PendoLogger.w(TAG, "Can't resolve the banner's view class");
                layoutMaxWidth = myWidth;
            }
        } else {
            layoutMaxWidth = myWidth;
        }
        return View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(myWidth, layoutMaxWidth), 1073741824);
    }

    public final int getMaxWidthByCalculation(int guideViewRight, int guideViewLeft) {
        int layoutMaxWidth;
        View view = this.mGuideView;
        if (view == null) {
            return 0;
        }
        if (view instanceof PendoLinearLayout) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type sdk.pendo.io.views.custom.PendoLinearLayout");
            layoutMaxWidth = ((PendoLinearLayout) view).getLayoutMaxWidth();
        } else {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type sdk.pendo.io.views.custom.PendoScrollView");
            layoutMaxWidth = ((PendoScrollView) view).getLayoutMaxWidth();
        }
        if (layoutMaxWidth == Integer.MAX_VALUE) {
            return 0;
        }
        return ((guideViewRight - guideViewLeft) - layoutMaxWidth) / 2;
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView
    public ViewGroup getViewGroupToTraverse() {
        View view = this.mGuideView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) view;
        View childAt = viewGroup.getChildAt(0);
        ViewGroup viewGroup2 = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
        return viewGroup2 == null ? viewGroup : viewGroup2;
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView
    protected void initializeView() {
        View view;
        if (!isAttached() || this.mInitialized || (view = this.mGuideView) == null) {
            return;
        }
        this.mInitialized = true;
        if (this.mDrawable != null) {
            this.mGuideView.setPadding(view.getPaddingLeft() + this.mBorderPadding, this.mGuideView.getPaddingTop() + this.mBorderPadding, this.mGuideView.getPaddingRight() + this.mBorderPadding, this.mGuideView.getPaddingBottom() + this.mBorderPadding);
        }
        addView(this.mGuideView, new ViewGroup.LayoutParams(-2, -2));
        setVisibility(4);
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PendoLogger.d(TAG, "EVENT -> PendoBannerView onDetachedFromWindow, rescan current screen");
        PendoInternal.z().onGlobalLayoutChangeEvent(g.ON_SCREEN_CHANGED);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Boolean boolA = e1.a(event, this.mGuideView, this.mWindowMarginX, this.mWindowMarginY);
        Intrinsics.checkNotNullExpressionValue(boolA, "isClickTouchOrHoverInsideView(...)");
        if (boolA.booleanValue()) {
            return true;
        }
        return super.onHoverEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int measuredHeight;
        int measuredHeight2;
        try {
            if (this.mGuideView == null) {
                return;
            }
            Insets insetsD = b.d(this);
            int i = l + this.mFloatingGuideMarginLeftPx + insetsD.left;
            int i2 = (r - this.mFloatingGuideMarginRightPx) - insetsD.right;
            int maxWidthByCalculation = getMaxWidthByCalculation(i2, i);
            int i3 = i + maxWidthByCalculation;
            int i4 = i2 - maxWidthByCalculation;
            int i5 = this.mGravity;
            if (i5 == 2) {
                measuredHeight = t + this.mFloatingGuideMarginTopPx;
                measuredHeight2 = measuredHeight + this.mGuideView.getMeasuredHeight();
            } else if (i5 != 3) {
                int i6 = (b + (this.mFloatingGuideMarginTopPx - this.mFloatingGuideMarginBottomPx)) / 2;
                int measuredHeight3 = this.mGuideView.getMeasuredHeight() / 2;
                measuredHeight = i6 - measuredHeight3;
                measuredHeight2 = i6 + measuredHeight3;
            } else {
                measuredHeight2 = b - this.mFloatingGuideMarginBottomPx;
                measuredHeight = measuredHeight2 - this.mGuideView.getMeasuredHeight();
            }
            this.mGuideView.layout(i3, measuredHeight, i4, measuredHeight2);
        } catch (Exception e) {
            PendoLogger.w(e, e.getMessage(), "PendoBannerView onLayout");
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (checkForManualScreenOrientation(size, size2)) {
            PendoLogger.d(TAG, "Orientation change was not detected alone.");
            removeFromParent();
            return;
        }
        int i = 0;
        if (mode == 0) {
            size = 0;
        }
        if (mode2 == 0) {
            size2 = 0;
        }
        View view = this.mGuideView;
        if (view == null) {
            i = size;
        } else if (view.getVisibility() != 8) {
            Insets insetsD = b.d(this);
            int i2 = this.mGravity;
            int i3 = i2 == 2 ? insetsD.top : 0;
            i = i2 == 3 ? insetsD.bottom : 0;
            View view2 = this.mGuideView;
            view2.setPadding(view2.getPaddingLeft(), this.mBorderPadding + i3, this.mGuideView.getPaddingRight(), this.mBorderPadding + i);
            this.mGuideView.measure(getBannerChildMeasureSpec((((size - this.mFloatingGuideMarginRightPx) - this.mFloatingGuideMarginLeftPx) - insetsD.left) - insetsD.right), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
            if (mode2 != 1073741824) {
                size2 = this.mGuideView.getMeasuredHeight() + this.mFloatingGuideMarginTopPx + this.mFloatingGuideMarginBottomPx;
            }
            i = size;
        } else {
            size2 = 0;
        }
        setMeasuredDimension(i, size2);
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView, android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        View view;
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        try {
            if (visibility == 0) {
                d dVar = this.mDrawable;
                if (dVar != null && (view = this.mGuideView) != null) {
                    view.setBackground(dVar);
                }
                a.a(this.mGuideView);
            } else {
                Context context = getContext();
                Activity activity = context instanceof Activity ? (Activity) context : null;
                if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                    PendoLogger.d(TAG, "onVisibilityChanged to invisible/gone, removing the banner from view");
                    removeFromParent();
                }
            }
        } catch (Exception e) {
            PendoLogger.w(e, "PendoBannerView onVisibilityChanged", e.getMessage());
        }
        super.onVisibilityChanged(changedView, visibility);
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView
    public void removeFromParent() {
        ViewParent parent = getParent();
        if (parent != null && isAttached() && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView
    public synchronized void show() {
        super.show();
        GuideTapOnManager.resetTapOn();
    }
}
