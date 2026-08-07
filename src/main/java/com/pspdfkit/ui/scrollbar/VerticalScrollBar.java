package com.pspdfkit.ui.scrollbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.microsoft.intune.mam.client.view.MAMViewGroup;
import com.pspdfkit.R;
import com.pspdfkit.configuration.page.PageScrollDirection;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.yz;
import com.pspdfkit.listeners.scrolling.DocumentScrollListener;
import com.pspdfkit.listeners.scrolling.ScrollState;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class VerticalScrollBar extends MAMViewGroup implements DocumentScrollListener {
    private int activePointerId;
    private boolean autoHide;
    private int currentPageIndex;
    private final AccelerateDecelerateInterpolator defaultInterpolator;
    private boolean dragging;
    private ViewPropertyAnimator hideAnimator;
    private Disposable hideHandleDisposable;
    private boolean ignoreEventsUntilIdle;
    private ScrollState lastKnownScrollState;
    private int lastReportedScrollPosition;
    private float lastTouchY;
    private OnPageChangeListener onPageChangeListener;
    private PageScrollDirection pageScrollDirection;
    private View scrollIndicatorView;
    private int totalPages;

    /* JADX INFO: renamed from: com.pspdfkit.ui.scrollbar.VerticalScrollBar$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$pspdfkit$listeners$scrolling$ScrollState;

        static {
            int[] iArr = new int[ScrollState.values().length];
            $SwitchMap$com$pspdfkit$listeners$scrolling$ScrollState = iArr;
            try {
                iArr[ScrollState.DRAGGED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pspdfkit$listeners$scrolling$ScrollState[ScrollState.SETTLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$pspdfkit$listeners$scrolling$ScrollState[ScrollState.IDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public interface OnPageChangeListener {
        void onPageChanged(VerticalScrollBar verticalScrollBar, int i);
    }

    public VerticalScrollBar(Context context) {
        super(context);
        this.defaultInterpolator = new AccelerateDecelerateInterpolator();
        this.pageScrollDirection = PageScrollDirection.VERTICAL;
        this.autoHide = true;
        this.activePointerId = -1;
        this.dragging = false;
        this.lastKnownScrollState = ScrollState.IDLE;
        this.lastReportedScrollPosition = -1;
        this.ignoreEventsUntilIdle = false;
        init();
    }

    private void calculateCurrentPageIndex(boolean z) {
        OnPageChangeListener onPageChangeListener;
        int iRound = Math.round((this.scrollIndicatorView.getTop() / (getHeight() - this.scrollIndicatorView.getHeight())) * (this.totalPages - 1));
        if (this.currentPageIndex != iRound) {
            this.currentPageIndex = iRound;
            if (!z || (onPageChangeListener = this.onPageChangeListener) == null) {
                return;
            }
            onPageChangeListener.onPageChanged(this, iRound);
        }
    }

    private void cancelHidingHandle() {
        yz.a(this.hideHandleDisposable);
        this.hideHandleDisposable = null;
    }

    private void init() {
        View viewOnCreateScrollIndicator = onCreateScrollIndicator();
        this.scrollIndicatorView = viewOnCreateScrollIndicator;
        if (viewOnCreateScrollIndicator == null) {
            throw new IllegalStateException("onCreateScrollIndicator() must return a non-null view.");
        }
        addView(viewOnCreateScrollIndicator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onHideScrollIndicator$0(View view) {
        view.setVisibility(8);
        this.hideAnimator = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleScrollIndicatorHiding$2() throws Throwable {
        onHideScrollIndicator(this.scrollIndicatorView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$snapHandleToLastReportedScrollPosition$1(float f) {
        this.scrollIndicatorView.setTranslationY(0.0f);
        moveDragHandleBy((int) f, false);
    }

    private void moveDragHandleBy(int i, boolean z) {
        if (i == 0) {
            return;
        }
        int top = this.scrollIndicatorView.getTop();
        int iMin = i > 0 ? Math.min(i, getHeight() - this.scrollIndicatorView.getBottom()) : Math.max(i, -top);
        View view = this.scrollIndicatorView;
        view.layout(0, top + iMin, view.getMeasuredWidth(), this.scrollIndicatorView.getMeasuredHeight() + top + iMin);
        calculateCurrentPageIndex(z);
    }

    private void scheduleScrollIndicatorHiding() {
        if (this.autoHide) {
            this.hideHandleDisposable = Completable.timer(1L, TimeUnit.SECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action() { // from class: com.pspdfkit.ui.scrollbar.VerticalScrollBar$$ExternalSyntheticLambda0
                @Override // io.reactivex.rxjava3.functions.Action
                public final void run() throws Throwable {
                    this.f$0.lambda$scheduleScrollIndicatorHiding$2();
                }
            });
        }
    }

    private void snapHandleToLastReportedScrollPosition() {
        final float top = this.lastReportedScrollPosition - this.scrollIndicatorView.getTop();
        this.scrollIndicatorView.animate().translationYBy(top).setDuration(100L).withEndAction(new Runnable() { // from class: com.pspdfkit.ui.scrollbar.VerticalScrollBar$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$snapHandleToLastReportedScrollPosition$1(top);
            }
        }).start();
    }

    public final void awakenScrollBar() {
        onShowScrollIndicator(this.scrollIndicatorView);
        scheduleScrollIndicatorHiding();
    }

    public View onCreateScrollIndicator() {
        return LayoutInflater.from(getContext()).inflate(R.layout.pspdf__vertical_scrollbar_indicator, (ViewGroup) this, false);
    }

    @Override // com.pspdfkit.listeners.scrolling.DocumentScrollListener
    public final void onDocumentScrolled(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.pageScrollDirection != PageScrollDirection.HORIZONTAL) {
            i = i2;
            i3 = i4;
            i5 = i6;
        }
        int i7 = i3 - i5;
        if (i7 > 0) {
            int measuredHeight = this.scrollIndicatorView.getMeasuredHeight();
            int iRound = Math.round((i / i7) * (getHeight() - measuredHeight));
            this.lastReportedScrollPosition = iRound;
            calculateCurrentPageIndex(false);
            if (this.dragging || this.ignoreEventsUntilIdle) {
                return;
            }
            View view = this.scrollIndicatorView;
            view.layout(0, iRound, view.getMeasuredWidth(), measuredHeight + iRound);
        }
    }

    public void onDocumentSet(PdfDocument pdfDocument) {
    }

    public void onHideScrollIndicator(final View view) {
        if (view.getVisibility() != 8) {
            ViewPropertyAnimator viewPropertyAnimatorWithEndAction = view.animate().translationX(view.getWidth()).alpha(0.0f).setDuration(100L).setInterpolator(this.defaultInterpolator).withEndAction(new Runnable() { // from class: com.pspdfkit.ui.scrollbar.VerticalScrollBar$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onHideScrollIndicator$0(view);
                }
            });
            this.hideAnimator = viewPropertyAnimatorWithEndAction;
            viewPropertyAnimatorWithEndAction.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            onHideScrollIndicator(this.scrollIndicatorView);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        measureChild(this.scrollIndicatorView, i, i2);
        setMeasuredDimension(this.scrollIndicatorView.getMeasuredWidth(), View.getDefaultSize(getSuggestedMinimumHeight(), i2));
    }

    public void onScrollIndicatorDragStarted(View view) {
        view.animate().alpha(0.6f).setDuration(50L).setInterpolator(this.defaultInterpolator).start();
    }

    public void onScrollIndicatorDragStopped(View view) {
        view.animate().alpha(1.0f).setDuration(50L).setInterpolator(this.defaultInterpolator).start();
    }

    @Override // com.pspdfkit.listeners.scrolling.DocumentScrollListener
    public final void onScrollStateChanged(ScrollState scrollState) {
        cancelHidingHandle();
        this.lastKnownScrollState = scrollState;
        if (this.dragging) {
            return;
        }
        int i = AnonymousClass1.$SwitchMap$com$pspdfkit$listeners$scrolling$ScrollState[scrollState.ordinal()];
        if (i == 1 || i == 2) {
            onShowScrollIndicator(this.scrollIndicatorView);
        } else {
            if (i != 3) {
                return;
            }
            this.ignoreEventsUntilIdle = false;
            scheduleScrollIndicatorHiding();
            snapHandleToLastReportedScrollPosition();
        }
    }

    public void onShowScrollIndicator(View view) {
        ViewPropertyAnimator viewPropertyAnimator = this.hideAnimator;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            this.hideAnimator = null;
        }
        if (view.getVisibility() != 0) {
            view.setVisibility(0);
            view.setAlpha(0.0f);
            view.setTranslationX(view.getWidth());
        } else if (view.getAlpha() == 0.0f && view.getTranslationX() == 0.0f) {
            return;
        }
        view.animate().translationX(0.0f).alpha(1.0f).setDuration(100L).setInterpolator(this.defaultInterpolator).start();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0048  */
    /* JADX WARN: Code duplicated, block: B:20:0x0050  */
    /* JADX WARN: Code duplicated, block: B:23:0x0058  */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ScrollState scrollState;
        ScrollState scrollState2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            int actionIndex = motionEvent.getActionIndex();
            float x = motionEvent.getX(actionIndex);
            float y = motionEvent.getY(actionIndex);
            if (this.scrollIndicatorView.getVisibility() != 0 || x < this.scrollIndicatorView.getLeft() || x >= this.scrollIndicatorView.getRight() || y < this.scrollIndicatorView.getTop() || y >= this.scrollIndicatorView.getBottom()) {
                this.dragging = false;
                return false;
            }
            cancelHidingHandle();
            onShowScrollIndicator(this.scrollIndicatorView);
            this.dragging = true;
            this.lastTouchY = y;
            this.activePointerId = motionEvent.getPointerId(0);
            onScrollIndicatorDragStarted(this.scrollIndicatorView);
        } else if (actionMasked == 1) {
            this.dragging = false;
            scrollState = this.lastKnownScrollState;
            scrollState2 = ScrollState.IDLE;
            this.ignoreEventsUntilIdle = scrollState != scrollState2;
            this.activePointerId = -1;
            if (scrollState == scrollState2) {
                snapHandleToLastReportedScrollPosition();
            }
            scheduleScrollIndicatorHiding();
            onScrollIndicatorDragStopped(this.scrollIndicatorView);
        } else if (actionMasked == 2) {
            float y2 = motionEvent.getY(motionEvent.findPointerIndex(this.activePointerId));
            float f = y2 - this.lastTouchY;
            this.lastTouchY = y2;
            moveDragHandleBy((int) f, true);
        } else if (actionMasked == 3) {
            this.dragging = false;
            scrollState = this.lastKnownScrollState;
            scrollState2 = ScrollState.IDLE;
            this.ignoreEventsUntilIdle = scrollState != scrollState2;
            this.activePointerId = -1;
            if (scrollState == scrollState2) {
                snapHandleToLastReportedScrollPosition();
            }
            scheduleScrollIndicatorHiding();
            onScrollIndicatorDragStopped(this.scrollIndicatorView);
        } else if (actionMasked == 6) {
            int actionIndex2 = motionEvent.getActionIndex();
            if (motionEvent.getPointerId(actionIndex2) == this.activePointerId) {
                int i = actionIndex2 == 0 ? 1 : 0;
                this.lastTouchY = motionEvent.getY(i);
                this.activePointerId = motionEvent.getPointerId(i);
            }
        }
        return true;
    }

    public void setAutoHide(boolean z) {
        this.autoHide = z;
    }

    public final void setDocument(PdfDocument pdfDocument) {
        if (pdfDocument == null) {
            throw new IllegalArgumentException("The set document may not be null.");
        }
        this.totalPages = pdfDocument.getPageCount();
        this.currentPageIndex = -1;
        this.lastReportedScrollPosition = -1;
        onDocumentSet(pdfDocument);
    }

    public final void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.onPageChangeListener = onPageChangeListener;
    }

    public final void setScrollDirection(PageScrollDirection pageScrollDirection) {
        uw.a(pageScrollDirection, "pageScrollDirection", null);
        this.pageScrollDirection = pageScrollDirection;
    }

    public VerticalScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.defaultInterpolator = new AccelerateDecelerateInterpolator();
        this.pageScrollDirection = PageScrollDirection.VERTICAL;
        this.autoHide = true;
        this.activePointerId = -1;
        this.dragging = false;
        this.lastKnownScrollState = ScrollState.IDLE;
        this.lastReportedScrollPosition = -1;
        this.ignoreEventsUntilIdle = false;
        init();
    }

    public VerticalScrollBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.defaultInterpolator = new AccelerateDecelerateInterpolator();
        this.pageScrollDirection = PageScrollDirection.VERTICAL;
        this.autoHide = true;
        this.activePointerId = -1;
        this.dragging = false;
        this.lastKnownScrollState = ScrollState.IDLE;
        this.lastReportedScrollPosition = -1;
        this.ignoreEventsUntilIdle = false;
        init();
    }
}
