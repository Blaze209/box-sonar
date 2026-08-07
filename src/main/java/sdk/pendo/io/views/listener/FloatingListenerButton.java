package sdk.pendo.io.views.listener;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.MotionEventCompat;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.o6.a;
import sdk.pendo.io.s7.e1;
import sdk.pendo.io.s7.h0;
import sdk.pendo.io.s7.y0;
import sdk.pendo.io.x5.b;
import sdk.pendo.io.x5.c;

/* JADX INFO: loaded from: classes5.dex */
public final class FloatingListenerButton extends AppCompatImageButton implements View.OnClickListener {
    private static final int BUTTON_STATE_CHANGE_TIMEOUT = 1000;
    private static final int FIRST_STATE_SHOW_NUMBER_THREE = 1;
    private static final int FLASH_STATE = 4;
    private static final int FLOATING_BUTTON_ELEVATION = 0;
    private static final int INVALID_POINTER_ID = -1;
    private static final int LIMBO_STATE = 5;
    private static final long MAX_CLICK_DURATION = 250;
    private static final int PRE_FLASH_TIMEOUT = 200;
    private static final int PRE_PROGRESS_BAR_TIMEOUT = 500;
    public static final String SCREEN_SEND_MODE_TAG = "screenSend";
    private static final int SECOND_STATE_SHOW_NUMBER_TWO = 2;
    private static final String TAG = "FloatingListenerButton";
    private static final String TEST_MODE_TAG = "testMode";
    private static final int THIRD_STATE_SHOW_NUMBER_ONE = 3;
    private static float sLastTouchX;
    private static float sLastTouchY;
    private AccessibilityManager mAccessibilityManager;
    private int mActivePointerId;
    private Handler mAnimationTimeoutHandler;
    private boolean mButtonClicked;
    private Rect mDisplayRect;
    private AtomicInteger mDrawableResource;
    private Runnable mFinishedRunnable;
    private Runnable mFlashRunnable;
    private long mPressStartTime;
    private float mPressedX;
    private float mPressedY;
    private Runnable mShowFirstButtonRunnable;
    private Runnable mShowSecondButtonRunnable;
    private Rect mViewRealRect;
    private c testModeDialog;
    private static final float MAX_CLICK_DISTANCE = e1.a(15.0f);
    private static final Object LOCK = new Object();
    private static float sPosX = -1.0f;
    private static float sPosY = -1.0f;
    private static boolean sMovedOrTookScreenshot = false;
    private static int sLastButtonState = 1;
    private static volatile AtomicInteger sButtonState = new AtomicInteger(1);
    private static boolean sFinishedAnimation = false;
    private static WeakReference<b> sDialogFragment = null;

    public static final class Builder {
        private int mGravity = 81;
        private FrameLayout.LayoutParams mParams;

        public Builder() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            this.mParams = layoutParams;
            layoutParams.gravity = this.mGravity;
        }

        public static void removeActiveInstances() {
            synchronized (FloatingListenerButton.LOCK) {
                for (final Activity activity : sdk.pendo.io.d6.c.h().f()) {
                    if (activity != null) {
                        activity.runOnUiThread(new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton.Builder.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
                                    FloatingListenerButton floatingListenerButton = viewGroup != null ? (FloatingListenerButton) viewGroup.findViewWithTag(activity.getString(sdk.pendo.io.R.string.pnd_pairing_button_name_tag)) : null;
                                    if (floatingListenerButton != null) {
                                        viewGroup.removeView(floatingListenerButton);
                                    }
                                } catch (Exception e) {
                                    PendoLogger.w(e, "Error in removing the pairing button", new Object[0]);
                                }
                            }
                        });
                    }
                }
            }
        }

        public FloatingListenerButton create() {
            final Activity activityA = sdk.pendo.io.d6.c.h().a();
            if (activityA == null) {
                return null;
            }
            final ViewGroup viewGroup = (ViewGroup) activityA.findViewById(R.id.content);
            activityA.runOnUiThread(new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton.Builder.2
                @Override // java.lang.Runnable
                public void run() {
                    Activity activity;
                    int i;
                    FloatingListenerButton floatingListenerButton = new FloatingListenerButton(activityA);
                    floatingListenerButton.setTag(activityA.getString(sdk.pendo.io.R.string.pnd_pairing_button_name_tag));
                    floatingListenerButton.setContentDescription(activityA.getString(sdk.pendo.io.R.string.pnd_capture_button_accessibility_description));
                    if (!a.d().n()) {
                        if (a.d().s()) {
                            if (a.q().booleanValue()) {
                                activity = activityA;
                                i = sdk.pendo.io.R.string.pnd_test_mode_connected_button_accessibility_description;
                            } else {
                                activity = activityA;
                                i = sdk.pendo.io.R.string.pnd_test_mode_disconnected_button_accessibility_description;
                            }
                        }
                        floatingListenerButton.setVisibility(0);
                        Builder builder = Builder.this;
                        builder.mParams.gravity = builder.mGravity;
                        builder.withMargins(0, 0, 0, 16);
                        viewGroup.addView(floatingListenerButton, Builder.this.mParams);
                    }
                    if (a.q().booleanValue()) {
                        activity = activityA;
                        i = sdk.pendo.io.R.string.pnd_paired_connected_button_accessibility_description;
                    } else {
                        activity = activityA;
                        i = sdk.pendo.io.R.string.pnd_paired_disconnected_button_accessibility_description;
                    }
                    floatingListenerButton.setContentDescription(activity.getString(i));
                    floatingListenerButton.setVisibility(0);
                    Builder builder2 = Builder.this;
                    builder2.mParams.gravity = builder2.mGravity;
                    builder2.withMargins(0, 0, 0, 16);
                    viewGroup.addView(floatingListenerButton, Builder.this.mParams);
                }
            });
            return null;
        }

        public Builder withMargins(int i, int i2, int i3, int i4) {
            this.mParams.setMargins(e1.a(i), e1.a(i2), e1.a(i3), e1.a(i4));
            return this;
        }
    }

    public FloatingListenerButton(Context context) {
        super(context);
        this.testModeDialog = null;
        this.mActivePointerId = -1;
        this.mButtonClicked = false;
        this.mDrawableResource = new AtomicInteger(-1);
        this.mDisplayRect = new Rect();
        this.mViewRealRect = new Rect();
        init();
    }

    private boolean captureButtonRequired() {
        return a.d().f();
    }

    public static void clearDialogFragment() {
        WeakReference<b> weakReference = sDialogFragment;
        if (weakReference != null && weakReference.get() != null) {
            sDialogFragment.get().getDialog().dismiss();
        }
        sDialogFragment = null;
    }

    public static b getProgressDialog() {
        WeakReference<b> weakReference = sDialogFragment;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleReadyToCapture() {
        PendoLogger.i("Sending view to Pendo.", new Object[0]);
        this.mButtonClicked = false;
        sFinishedAnimation = true;
        h0.a();
    }

    private void init() {
        int i;
        try {
            this.mAccessibilityManager = (AccessibilityManager) PendoInternal.o().getSystemService("accessibility");
            this.mButtonClicked = false;
            sFinishedAnimation = false;
            sButtonState.set(1);
            if (a.d().n()) {
                i = a.q().booleanValue() ? sdk.pendo.io.R.drawable.pnd_pair_connected : sdk.pendo.io.R.drawable.pnd_pair;
            } else {
                if (!a.d().s()) {
                    if (a.d().h()) {
                        i = a.q().booleanValue() ? sdk.pendo.io.R.drawable.pendo_debug_icon : sdk.pendo.io.R.drawable.pendo_debug_offline_icon;
                    } else {
                        setImageResource(sdk.pendo.io.R.drawable.pnd_camcam);
                        setContentDescription(getContext().getString(sdk.pendo.io.R.string.pnd_capture_mode_accessibility_description));
                    }
                    setId(sdk.pendo.io.R.id.pnd_pairingButton);
                    this.mAnimationTimeoutHandler = new Handler();
                    this.mShowSecondButtonRunnable = new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FloatingListenerButton.sButtonState.set(2);
                            FloatingListenerButton.this.invalidate();
                        }
                    };
                    this.mShowFirstButtonRunnable = new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton.2
                        @Override // java.lang.Runnable
                        public void run() {
                            FloatingListenerButton.sButtonState.set(3);
                            FloatingListenerButton.this.invalidate();
                        }
                    };
                    this.mFlashRunnable = new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton.3
                        @Override // java.lang.Runnable
                        public void run() {
                            FloatingListenerButton.sButtonState.set(4);
                            FloatingListenerButton.this.invalidate();
                        }
                    };
                    this.mFinishedRunnable = new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton.4
                        @Override // java.lang.Runnable
                        public void run() {
                            FloatingListenerButton.this.handleReadyToCapture();
                        }
                    };
                    setBackgroundColor(0);
                    setOnClickListener(this);
                    setClickable(true);
                    invalidate();
                }
                i = a.q().booleanValue() ? sdk.pendo.io.R.drawable.pnd_test_mode_connected : sdk.pendo.io.R.drawable.pnd_test_mode;
            }
            setImageResource(i);
            setId(sdk.pendo.io.R.id.pnd_pairingButton);
            this.mAnimationTimeoutHandler = new Handler();
            this.mShowSecondButtonRunnable = new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton.1
                @Override // java.lang.Runnable
                public void run() {
                    FloatingListenerButton.sButtonState.set(2);
                    FloatingListenerButton.this.invalidate();
                }
            };
            this.mShowFirstButtonRunnable = new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton.2
                @Override // java.lang.Runnable
                public void run() {
                    FloatingListenerButton.sButtonState.set(3);
                    FloatingListenerButton.this.invalidate();
                }
            };
            this.mFlashRunnable = new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton.3
                @Override // java.lang.Runnable
                public void run() {
                    FloatingListenerButton.sButtonState.set(4);
                    FloatingListenerButton.this.invalidate();
                }
            };
            this.mFinishedRunnable = new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton.4
                @Override // java.lang.Runnable
                public void run() {
                    FloatingListenerButton.this.handleReadyToCapture();
                }
            };
            setBackgroundColor(0);
            setOnClickListener(this);
            setClickable(true);
            invalidate();
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
            Toast.makeText(getContext(), getResources().getString(sdk.pendo.io.R.string.pnd_pairing_error_occurred), 1).show();
        }
    }

    private void resetPosition() {
        sPosX = getX();
        sPosY = getY();
    }

    public static void setProgressDialog(b bVar) {
        sDialogFragment = new WeakReference<>(bVar);
    }

    public void flashFinished() {
        this.mAnimationTimeoutHandler.postDelayed(new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m16873x2040654e();
            }
        }, 500L);
    }

    /* JADX INFO: renamed from: lambda$flashFinished$0$sdk-pendo-io-views-listener-FloatingListenerButton, reason: not valid java name */
    /* synthetic */ void m16873x2040654e() {
        if (sdk.pendo.io.d6.c.h().a() == null) {
            return;
        }
        Builder.removeActiveInstances();
        h0.a(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        sFinishedAnimation = false;
        if (sMovedOrTookScreenshot) {
            PendoLogger.i("Not sending view.", new Object[0]);
            sMovedOrTookScreenshot = false;
        } else {
            this.mButtonClicked = true;
            invalidate();
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0204 A[PHI: r1
      0x0204: PHI (r1v60 int) = (r1v48 int), (r1v50 int), (r1v52 int), (r1v70 int), (r1v72 int) binds: [B:99:0x0202, B:95:0x01f3, B:91:0x01e4, B:53:0x012d, B:50:0x011f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Handler handler;
        Runnable runnable;
        int i;
        Context context;
        int i2;
        if (sPosX > getResources().getDisplayMetrics().widthPixels || sPosY > getResources().getDisplayMetrics().heightPixels) {
            resetPosition();
        }
        try {
            getWindowVisibleDisplayFrame(this.mDisplayRect);
        } catch (Exception e) {
            PendoLogger.d(e, "Attempt to read from field mVisibleInsets on a null attachInfo of the view in question.", new Object[0]);
        }
        getGlobalVisibleRect(this.mViewRealRect);
        float f = sPosX;
        if (f < this.mDisplayRect.left || f + getWidth() > this.mDisplayRect.right) {
            sPosX = getX();
        } else {
            setX(sPosX);
        }
        Rect rect = this.mViewRealRect;
        if (rect.bottom - rect.top < getHeight()) {
            float f2 = sPosY;
            int height = getHeight();
            Rect rect2 = this.mViewRealRect;
            sPosY = f2 - (height - (rect2.bottom - rect2.top));
        }
        float f3 = sPosY;
        if (f3 < this.mDisplayRect.top || f3 + getHeight() > this.mDisplayRect.bottom) {
            sPosY = !sMovedOrTookScreenshot ? getY() - getBottom() : getY();
        } else {
            setY(sPosY);
        }
        if (sdk.pendo.io.p6.b.c() == null || captureButtonRequired()) {
            if (sFinishedAnimation) {
                sFinishedAnimation = false;
                this.mButtonClicked = false;
            } else if (!this.mButtonClicked && captureButtonRequired()) {
                int andSet = this.mDrawableResource.getAndSet(sdk.pendo.io.R.drawable.pnd_camcam);
                int i3 = sdk.pendo.io.R.drawable.pnd_camcam;
                if (andSet != i3) {
                    setImageResource(i3);
                    context = getContext();
                    i2 = sdk.pendo.io.R.string.pnd_capture_mode_accessibility_description;
                    setContentDescription(context.getString(i2));
                }
            } else if (this.mButtonClicked && captureButtonRequired()) {
                int i4 = sButtonState.get();
                long j = 1000;
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 != 4) {
                                if (i4 != 5) {
                                    PendoLogger.d("Unknown state: " + sButtonState.get(), new Object[0]);
                                } else {
                                    int i5 = sLastButtonState;
                                    if (i5 == 1) {
                                        int andSet2 = this.mDrawableResource.getAndSet(sdk.pendo.io.R.drawable.pnd_three3);
                                        i = sdk.pendo.io.R.drawable.pnd_three3;
                                        if (andSet2 != i) {
                                            setImageResource(i);
                                        }
                                    } else if (i5 == 2) {
                                        int andSet3 = this.mDrawableResource.getAndSet(sdk.pendo.io.R.drawable.pnd_two2);
                                        i = sdk.pendo.io.R.drawable.pnd_two2;
                                        if (andSet3 != i) {
                                            setImageResource(i);
                                        }
                                    } else if (i5 == 3) {
                                        int andSet4 = this.mDrawableResource.getAndSet(sdk.pendo.io.R.drawable.pnd_one1);
                                        i = sdk.pendo.io.R.drawable.pnd_one1;
                                        if (andSet4 != i) {
                                            setImageResource(i);
                                        }
                                    }
                                }
                            } else if (sButtonState.getAndIncrement() == 4) {
                                sLastButtonState = 4;
                                sFinishedAnimation = true;
                                this.mButtonClicked = false;
                                PendoLogger.d("Floating Button - DONE STATE", new Object[0]);
                                handler = this.mAnimationTimeoutHandler;
                                runnable = this.mFinishedRunnable;
                                j = 200;
                                handler.postDelayed(runnable, j);
                            }
                        } else if (sButtonState.getAndIncrement() == 3) {
                            sLastButtonState = 3;
                            PendoLogger.d("Floating Button - ONE STATE", new Object[0]);
                            sButtonState.set(5);
                            int andSet5 = this.mDrawableResource.getAndSet(sdk.pendo.io.R.drawable.pnd_one1);
                            int i6 = sdk.pendo.io.R.drawable.pnd_one1;
                            if (andSet5 != i6) {
                                setImageResource(i6);
                            }
                            handler = this.mAnimationTimeoutHandler;
                            runnable = this.mFlashRunnable;
                            handler.postDelayed(runnable, j);
                        }
                    } else if (sButtonState.getAndIncrement() == 2) {
                        PendoLogger.d("Floating Button - TWO STATE", new Object[0]);
                        sLastButtonState = 2;
                        sButtonState.set(5);
                        int andSet6 = this.mDrawableResource.getAndSet(sdk.pendo.io.R.drawable.pnd_two2);
                        int i7 = sdk.pendo.io.R.drawable.pnd_two2;
                        if (andSet6 != i7) {
                            setImageResource(i7);
                        }
                        setScaleType(ImageView.ScaleType.FIT_CENTER);
                        handler = this.mAnimationTimeoutHandler;
                        runnable = this.mShowFirstButtonRunnable;
                        handler.postDelayed(runnable, j);
                    }
                } else if (sButtonState.getAndIncrement() == 1) {
                    PendoLogger.d("Floating Button - THREE STATE", new Object[0]);
                    sLastButtonState = 1;
                    sButtonState.set(5);
                    int andSet7 = this.mDrawableResource.getAndSet(sdk.pendo.io.R.drawable.pnd_three3);
                    int i8 = sdk.pendo.io.R.drawable.pnd_three3;
                    if (andSet7 != i8) {
                        setImageResource(i8);
                    }
                    handler = this.mAnimationTimeoutHandler;
                    runnable = this.mShowSecondButtonRunnable;
                    handler.postDelayed(runnable, j);
                }
            }
        } else if (a.d().s()) {
            if (a.q().booleanValue()) {
                int andSet8 = this.mDrawableResource.getAndSet(sdk.pendo.io.R.drawable.pnd_test_mode_connected);
                int i9 = sdk.pendo.io.R.drawable.pnd_test_mode_connected;
                if (andSet8 != i9) {
                    setImageResource(i9);
                    context = PendoInternal.o();
                    i2 = sdk.pendo.io.R.string.pnd_test_mode_accessibility_description;
                    setContentDescription(context.getString(i2));
                }
            } else {
                int andSet9 = this.mDrawableResource.getAndSet(sdk.pendo.io.R.drawable.pnd_test_mode);
                int i10 = sdk.pendo.io.R.drawable.pnd_test_mode;
                if (andSet9 != i10) {
                    setImageResource(i10);
                    context = PendoInternal.o();
                    i2 = sdk.pendo.io.R.string.pnd_test_mode_disconnected_button_accessibility_description;
                    setContentDescription(context.getString(i2));
                }
            }
        } else if (a.d().h()) {
            if (a.q().booleanValue()) {
                int andSet10 = this.mDrawableResource.getAndSet(sdk.pendo.io.R.drawable.pendo_debug_icon);
                i = sdk.pendo.io.R.drawable.pendo_debug_icon;
                if (andSet10 != i) {
                    setImageResource(i);
                }
            } else {
                int andSet11 = this.mDrawableResource.getAndSet(sdk.pendo.io.R.drawable.pendo_debug_offline_icon);
                i = sdk.pendo.io.R.drawable.pendo_debug_offline_icon;
                if (andSet11 != i) {
                    setImageResource(i);
                }
            }
        } else if (a.q().booleanValue()) {
            int andSet12 = this.mDrawableResource.getAndSet(sdk.pendo.io.R.drawable.pnd_pair_connected);
            int i11 = sdk.pendo.io.R.drawable.pnd_pair_connected;
            if (andSet12 != i11) {
                setImageResource(i11);
                context = PendoInternal.o();
                i2 = sdk.pendo.io.R.string.pnd_paired_connected_button_accessibility_description;
                setContentDescription(context.getString(i2));
            }
        } else {
            int andSet13 = this.mDrawableResource.getAndSet(sdk.pendo.io.R.drawable.pnd_pair);
            int i12 = sdk.pendo.io.R.drawable.pnd_pair;
            if (andSet13 != i12) {
                setImageResource(i12);
                context = PendoInternal.o();
                i2 = sdk.pendo.io.R.string.pnd_paired_disconnected_button_accessibility_description;
                setContentDescription(context.getString(i2));
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (this.mAccessibilityManager.isTouchExplorationEnabled() && motionEvent.getPointerCount() == 1) {
            return onTouchEvent(sdk.pendo.io.s7.b.a(motionEvent));
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Activity activityA;
        try {
            int i = 0;
            if (!e1.a(motionEvent).booleanValue()) {
                PendoLogger.d("FloatingListenerButton onTouchEvent -> Skipping event with invalid pointer index", new Object[0]);
                return super.onTouchEvent(motionEvent);
            }
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        float f = rawX - sLastTouchX;
                        float f2 = rawY - sLastTouchY;
                        sPosX += f;
                        sPosY += f2;
                        invalidate();
                        sLastTouchX = rawX;
                        sLastTouchY = rawY;
                        sMovedOrTookScreenshot = true;
                    } else if (actionMasked != 3) {
                        if (actionMasked != 6) {
                            PendoLogger.d("Unknown action: " + actionMasked, new Object[0]);
                        } else {
                            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                            if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
                                i = actionIndex == 0 ? 1 : 0;
                                sLastTouchX = motionEvent.getRawX();
                                sLastTouchY = motionEvent.getRawY();
                            }
                        }
                    }
                    return super.onTouchEvent(motionEvent);
                }
                if (System.currentTimeMillis() - this.mPressStartTime < MAX_CLICK_DURATION && y0.a(this.mPressedX, this.mPressedY, motionEvent.getX(), motionEvent.getY()) < MAX_CLICK_DISTANCE) {
                    if ((a.d().s() || a.d().n() || a.d().h()) && (activityA = sdk.pendo.io.d6.c.h().a()) != null && activityA.getFragmentManager() != null) {
                        c cVarA = c.a();
                        this.testModeDialog = cVarA;
                        cVarA.show(activityA.getFragmentManager(), TEST_MODE_TAG);
                    }
                    sMovedOrTookScreenshot = false;
                    performClick();
                }
                this.mActivePointerId = -1;
                return super.onTouchEvent(motionEvent);
            }
            sLastTouchX = rawX;
            sLastTouchY = rawY;
            this.mPressStartTime = System.currentTimeMillis();
            this.mPressedX = motionEvent.getX();
            this.mPressedY = motionEvent.getY();
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, i);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            PendoLogger.e(TAG, "error processing motion event: " + motionEvent.getAction(), e);
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(0.0f);
    }
}
