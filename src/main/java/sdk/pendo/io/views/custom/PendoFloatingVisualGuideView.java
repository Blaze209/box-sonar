package sdk.pendo.io.views.custom;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.graphics.Insets;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.microsoft.intune.mam.client.view.MAMViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import sdk.pendo.io.R;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.PendoCommandsEventBus;
import sdk.pendo.io.actions.PendoFloatingVisualGuideManager;
import sdk.pendo.io.actions.VisualGuideBase;
import sdk.pendo.io.actions.VisualGuidesManager;
import sdk.pendo.io.actions.handlers.PendoGlobalCommandHandler;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.o5.b;
import sdk.pendo.io.o5.d;
import sdk.pendo.io.q3.e;
import sdk.pendo.io.q4.a;
import sdk.pendo.io.s7.e1;
import sdk.pendo.io.s7.w0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PendoFloatingVisualGuideView extends MAMViewGroup implements b {
    protected static final List<Integer> GRAVITY_LIST = new ArrayList(Arrays.asList(0, 1, 2, 3, 4));
    private static final String TAG = "PendoFloatingVisualGuideView";
    protected AccessibilityManager mAccessibilityManager;
    private boolean mAccessibilityNeeded;
    protected final View.OnAttachStateChangeListener mAnchorViewAttachedStateListener;
    protected WeakReference<View> mAnchorViewWeakRef;
    protected boolean mAttached;
    protected final int mBorderPadding;
    protected final PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks mCloseCallback;
    private final AtomicBoolean mClosed;
    private long mDisplayDuration;
    protected final Rect mDrawRect;
    protected final d mDrawable;
    protected final String mFloatingGuideId;
    public OnFloatingGuideListener mFloatingGuideListener;
    protected final int mFloatingGuideMarginBottomPx;
    protected final int mFloatingGuideMarginLeftPx;
    protected final int mFloatingGuideMarginRightPx;
    protected final int mFloatingGuideMarginTopPx;
    protected int mGravity;
    protected View mGuideView;
    protected boolean mInitialized;
    protected final View mRootView;
    protected Rect mScreenRect;
    protected Rect mScreenRectWithoutMargins;
    protected final boolean mSeeThrough;
    protected long mStartTime;
    protected final int mTopRule;
    protected final boolean mTouchPassThrough;
    private final AtomicBoolean mWasShown;
    protected int mWindowMarginX;
    protected int mWindowMarginY;

    public interface OnFloatingGuideListener {
        void onShowFailed(PendoFloatingVisualGuideView pendoFloatingVisualGuideView);
    }

    protected PendoFloatingVisualGuideView(Context context, PendoFloatingVisualGuideManager.Builder builder) {
        super(context);
        this.mScreenRect = new Rect();
        this.mDisplayDuration = 0L;
        this.mStartTime = 0L;
        this.mWasShown = new AtomicBoolean(false);
        this.mClosed = new AtomicBoolean(false);
        this.mAccessibilityNeeded = false;
        this.mAnchorViewAttachedStateListener = new View.OnAttachStateChangeListener() { // from class: sdk.pendo.io.views.custom.PendoFloatingVisualGuideView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                PendoFloatingVisualGuideView.this.removeViewListeners(view);
                PendoFloatingVisualGuideView pendoFloatingVisualGuideView = PendoFloatingVisualGuideView.this;
                PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks floatingGuideViewCallbacks = pendoFloatingVisualGuideView.mCloseCallback;
                if (floatingGuideViewCallbacks != null) {
                    floatingGuideViewCallbacks.onClosing(true, pendoFloatingVisualGuideView.mDisplayDuration, pendoFloatingVisualGuideView.mWasShown.get());
                }
                PendoFloatingVisualGuideView pendoFloatingVisualGuideView2 = PendoFloatingVisualGuideView.this;
                if (!pendoFloatingVisualGuideView2.mAttached) {
                    PendoLogger.w("PendoFloatingVisualGuideView not attached", new Object[0]);
                    return;
                }
                Activity activity = (Activity) pendoFloatingVisualGuideView2.getContext();
                if (activity != null) {
                    if (activity.isFinishing()) {
                        PendoLogger.w("PendoFloatingVisualGuideView skipped because activity is finishing...", new Object[0]);
                    } else {
                        if (activity.isDestroyed()) {
                            return;
                        }
                        PendoFloatingVisualGuideView.this.onClose(false, false, true);
                    }
                }
            }
        };
        this.mAccessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        setId(R.id.pnd_containerId);
        this.mFloatingGuideId = builder.getId();
        this.mGravity = builder.getGravity();
        this.mTopRule = builder.getActionbarSize();
        this.mTouchPassThrough = builder.getIsTouchPassThrough();
        this.mSeeThrough = builder.getIsSeeThrough();
        this.mCloseCallback = builder.getCloseCallback();
        this.mBorderPadding = builder.getStrokeWidth();
        this.mFloatingGuideMarginTopPx = builder.getMarginTopPx();
        this.mFloatingGuideMarginLeftPx = builder.getMarginLeftPx();
        this.mFloatingGuideMarginRightPx = builder.getMarginRightPx();
        this.mFloatingGuideMarginBottomPx = builder.getMarginBottomPx();
        this.mRootView = builder.getRootView();
        setClipChildren(false);
        setClipToPadding(false);
        this.mDrawRect = new Rect();
        this.mDrawable = builder.getCustomView() != null ? new d(builder.getStrokeWidth(), builder.getBgColor(), builder.getStrokeColor(), builder.getFrameRadius()) : null;
        View customView = builder.getCustomView();
        this.mGuideView = customView;
        customView.setVisibility(4);
        setVisibility(4);
        setupAccessibilityIfNeeded();
        PendoCommandsEventBus.getInstance().subscribe(a.a(this).a(sdk.pendo.io.k3.a.BUFFER), PendoCommand.createFilter(VisualGuideBase.DISMISS_VISIBLE_GUIDES, PendoGlobalCommandHandler.PENDO_GLOBAL_COMMAND_DEST, PendoCommandAction.PendoCommandGlobalAction.DISMISS_GUIDE, PendoCommandEventType.SdkEventType.HOST_APP_DEVELOPER_CALL, PendoCommand.PendoCommandScope.PENDO_COMMAND_SCOPE_ANY), new e() { // from class: sdk.pendo.io.views.custom.PendoFloatingVisualGuideView$$ExternalSyntheticLambda1
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                this.f$0.m16862x5a64021e((PendoCommand) obj);
            }
        });
    }

    static /* synthetic */ void lambda$setupAccessibilityIfNeeded$1(View view, boolean z) {
        if (!z || view == null) {
            return;
        }
        view.performAccessibilityAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_ACCESSIBILITY_FOCUS.getId(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onClose(boolean z, boolean z2, boolean z3) {
        if (this.mClosed.getAndSet(true)) {
            return;
        }
        if (isAttached()) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.mDisplayDuration = jCurrentTimeMillis;
            PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks floatingGuideViewCallbacks = this.mCloseCallback;
            if (floatingGuideViewCallbacks != null) {
                floatingGuideViewCallbacks.onClosing(z, jCurrentTimeMillis, this.mWasShown.get());
            }
        }
    }

    private void removeOnAttachStateObserver(View view) {
        WeakReference<View> weakReference;
        if (view != null && (weakReference = this.mAnchorViewWeakRef) != null) {
            view = weakReference.get();
        }
        if (view != null) {
            view.removeOnAttachStateChangeListener(this.mAnchorViewAttachedStateListener);
        } else {
            PendoLogger.e("PendoFloatingVisualGuideView removeOnAttachStateObserver failed", new Object[0]);
        }
    }

    private void requestFocusForAccessibilityIfNeeded() {
        if (this.mAccessibilityNeeded) {
            this.mAccessibilityNeeded = false;
            try {
                this.mGuideView.sendAccessibilityEvent(128);
                this.mGuideView.postDelayed(new Runnable() { // from class: sdk.pendo.io.views.custom.PendoFloatingVisualGuideView$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m16863xbf415ba2();
                    }
                }, 200L);
            } catch (Exception e) {
                PendoLogger.w(e, e.getMessage(), "PendoFloatingVisualGuideView requestFocusForAccessibilityIfNeeded");
            }
        }
    }

    private void setfloatingGuideContentFocusableForAccessibility() {
        try {
            this.mGuideView.setFocusableInTouchMode(true);
            this.mGuideView.setFocusable(true);
            if (this.mGuideView instanceof ViewGroup) {
                ViewGroup viewGroupToTraverse = getViewGroupToTraverse();
                if (w0.a(viewGroupToTraverse)) {
                    for (int i = 0; i < viewGroupToTraverse.getChildCount(); i++) {
                        View childAt = viewGroupToTraverse.getChildAt(i);
                        if (childAt != null) {
                            childAt.setFocusable(true);
                        }
                    }
                }
            }
        } catch (Exception e) {
            PendoLogger.w(e, e.getMessage(), "PendoFloatingVisualGuideView setfloatingGuideContentFocusableForAccessibility");
        }
    }

    private void setupAccessibilityIfNeeded() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        if (accessibilityManager == null || !accessibilityManager.isEnabled() || this.mGuideView == null) {
            return;
        }
        this.mAccessibilityNeeded = true;
        try {
            setfloatingGuideContentFocusableForAccessibility();
            WeakReference<View> weakReference = this.mAnchorViewWeakRef;
            if (weakReference != null && weakReference.get() != null) {
                ViewCompat.setAccessibilityDelegate(this.mGuideView, new AccessibilityDelegateCompat() { // from class: sdk.pendo.io.views.custom.PendoFloatingVisualGuideView.2
                    @Override // androidx.core.view.AccessibilityDelegateCompat
                    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                        accessibilityNodeInfoCompat.setTraversalBefore(PendoFloatingVisualGuideView.this.mAnchorViewWeakRef.get());
                    }
                });
            }
            this.mGuideView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: sdk.pendo.io.views.custom.PendoFloatingVisualGuideView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    PendoFloatingVisualGuideView.lambda$setupAccessibilityIfNeeded$1(view, z);
                }
            });
        } catch (Exception e) {
            PendoLogger.w(e, e.getMessage(), "PendoFloatingVisualGuideView setupAccessibilityIfNeeded");
        }
    }

    public abstract boolean consumeTouchEventIfOnPendoView(MotionEvent motionEvent);

    public String getFloatingGuideId() {
        return this.mFloatingGuideId;
    }

    protected abstract ViewGroup getViewGroupToTraverse();

    protected void initializeView() {
        View view;
        if (!isAttached() || this.mInitialized || (view = this.mGuideView) == null) {
            return;
        }
        this.mInitialized = true;
        d dVar = this.mDrawable;
        if (dVar != null) {
            view.setBackground(dVar);
            View view2 = this.mGuideView;
            view2.setPadding(view2.getPaddingLeft() + this.mBorderPadding, this.mGuideView.getPaddingTop() + this.mBorderPadding, this.mGuideView.getPaddingRight() + this.mBorderPadding, this.mGuideView.getPaddingBottom() + this.mBorderPadding);
        }
        updateScreenRectIgnoringMargins();
        addView(this.mGuideView, new ViewGroup.LayoutParams(-2, -2));
        setVisibility(4);
    }

    public boolean isAttached() {
        return this.mAttached;
    }

    /* JADX INFO: renamed from: lambda$new$0$sdk-pendo-io-views-custom-PendoFloatingVisualGuideView, reason: not valid java name */
    /* synthetic */ void m16862x5a64021e(PendoCommand pendoCommand) {
        PendoLogger.d(pendoCommand.toString(), new Object[0]);
        onClose(false, false, true);
    }

    /* JADX INFO: renamed from: lambda$requestFocusForAccessibilityIfNeeded$2$sdk-pendo-io-views-custom-PendoFloatingVisualGuideView, reason: not valid java name */
    /* synthetic */ void m16863xbf415ba2() {
        try {
            View view = this.mGuideView;
            if (view != null) {
                view.setFocusableInTouchMode(true);
                this.mGuideView.setFocusable(true);
                this.mGuideView.requestFocus();
            }
        } catch (Exception e) {
            PendoLogger.e("PendoFloatingVisualGuideView- postDelayed - " + e.getMessage(), e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttached = true;
        View view = this.mRootView;
        if (view != null) {
            try {
                Rect rectA = e1.a(view);
                this.mScreenRect = rectA;
                int i = rectA.left;
                if (i > 0) {
                    this.mWindowMarginX = i;
                }
                int i2 = rectA.top;
                if (i2 > 0) {
                    this.mWindowMarginY = i2;
                }
                PendoLogger.d(TAG, "onAttachedToWindow, window margins are - marginX - " + this.mWindowMarginX + ", marginY - " + this.mWindowMarginY);
            } catch (Exception e) {
                PendoLogger.d(e, "PendoFloatingVisualGuideView Attempt to read from field mVisibleInsets on a null attachInfo of the view in question.", new Object[0]);
            }
        } else {
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getRectSize(this.mScreenRect);
            }
        }
        initializeView();
        show();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks floatingGuideViewCallbacks = this.mCloseCallback;
        if (floatingGuideViewCallbacks != null) {
            floatingGuideViewCallbacks.onDetach();
        }
        this.mAttached = false;
        removeListeners();
        this.mAnchorViewWeakRef = null;
        this.mGuideView = null;
        setOnFloatingGuideListener(null);
        VisualGuidesManager.getInstance().setIsAnyGuideDisplayed(false);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mAttached) {
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            return consumeTouchEventIfOnPendoView(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (view == this && i == 0) {
            requestFocusForAccessibilityIfNeeded();
        }
    }

    public abstract void removeFromParent();

    protected void removeListeners() {
        this.mFloatingGuideListener = null;
        WeakReference<View> weakReference = this.mAnchorViewWeakRef;
        if (weakReference != null) {
            removeViewListeners(weakReference.get());
        }
    }

    protected void removeViewListeners(View view) {
        removeOnAttachStateObserver(view);
    }

    public void setFloatingGuideVisible() {
        View view = this.mGuideView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void setOnFloatingGuideListener(OnFloatingGuideListener onFloatingGuideListener) {
        this.mFloatingGuideListener = onFloatingGuideListener;
    }

    public synchronized void show() {
        if (!isAttached()) {
            PendoLogger.e("PendoFloatingVisualGuideView  not attached!", new Object[0]);
            return;
        }
        setVisibility(0);
        this.mStartTime = System.currentTimeMillis();
        this.mCloseCallback.onReadyForShow(this);
    }

    protected synchronized void touchOutsideOfFloatingGuide() {
        PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks floatingGuideViewCallbacks = this.mCloseCallback;
        if (floatingGuideViewCallbacks != null) {
            floatingGuideViewCallbacks.onTouchOutside();
        }
    }

    protected void updateScreenRectIgnoringMargins() {
        this.mScreenRectWithoutMargins = new Rect();
        if (this.mScreenRect == null) {
            return;
        }
        Insets insetsD = sdk.pendo.io.d8.b.d(this);
        Rect rect = this.mScreenRectWithoutMargins;
        Rect rect2 = this.mScreenRect;
        rect.top = rect2.top + this.mFloatingGuideMarginTopPx + insetsD.top;
        rect.left = rect2.left + this.mFloatingGuideMarginLeftPx + insetsD.left;
        rect.right = (rect2.right - this.mFloatingGuideMarginRightPx) - insetsD.right;
        rect.bottom = (rect2.bottom - this.mFloatingGuideMarginBottomPx) - insetsD.bottom;
    }
}
