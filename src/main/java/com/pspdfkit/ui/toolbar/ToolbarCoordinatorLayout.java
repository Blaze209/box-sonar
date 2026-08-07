package com.pspdfkit.ui.toolbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.microsoft.intune.mam.client.view.MAMViewGroup;
import com.pspdfkit.R;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.gk;
import com.pspdfkit.internal.i0;
import com.pspdfkit.internal.ip;
import com.pspdfkit.internal.un;
import com.pspdfkit.internal.z50;
import com.pspdfkit.utils.PdfLog;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public class ToolbarCoordinatorLayout extends MAMViewGroup implements ToolbarCoordinatorLayoutController {
    private static final int DRAG_TARGET_ALPHA_MAX = 150;
    private static final int DRAG_TARGET_ALPHA_MIN = 30;
    private static final String LOG_TAG = "Nutri.TBarrCoordinateLay";
    private static final long TOOLBARS_FADE_DURATION_MS = 300;
    private boolean composeManagedContentPadding;
    private ContextualToolbar currentContextualToolbar;
    private float detachedToolbarTranslationX;
    private float detachedToolbarTranslationY;
    private Paint dragTargetPaint;
    private float lastTouchX;
    private float lastTouchY;
    private final RectF leftToolbarRect;
    private OnContextualToolbarLifecycleListener lifecycleListener;
    private final int[] location;
    private OnContextualToolbarMovementListener movementListener;
    private OnContextualToolbarPositionListener positionListener;
    private long possiblePositionsAnimationStartTime;
    private boolean possiblePositionsShouldStartAnimation;
    private final RectF rightToolbarRect;
    private Paint statusBarPaint;
    private final RectF toolbarLayoutRect;
    private int toolbarSizePx;
    private final RectF topToolbarRect;
    private final int verticalToolbarHorizontalMargin;
    private final int verticalToolbarVerticalMargin;
    private final Rect windowInsets;

    public interface OnContextualToolbarLifecycleListener {
        void onDisplayContextualToolbar(ContextualToolbar contextualToolbar);

        void onPrepareContextualToolbar(ContextualToolbar contextualToolbar);

        void onRemoveContextualToolbar(ContextualToolbar contextualToolbar);
    }

    public interface OnContextualToolbarMovementListener {
        void onAttachContextualToolbar(ContextualToolbar contextualToolbar);

        void onDetachContextualToolbar(ContextualToolbar contextualToolbar);

        void onDragContextualToolbar(ContextualToolbar contextualToolbar, int i, int i2);
    }

    public interface OnContextualToolbarPositionListener {
        void onContextualToolbarPositionChanged(ContextualToolbar contextualToolbar, LayoutParams.Position position, LayoutParams.Position position2);
    }

    public ToolbarCoordinatorLayout(Context context) {
        super(context);
        this.leftToolbarRect = new RectF();
        this.topToolbarRect = new RectF();
        this.rightToolbarRect = new RectF();
        this.verticalToolbarHorizontalMargin = getResources().getDimensionPixelSize(R.dimen.pspdf__vertical_toolbar_horizontal_margin);
        this.verticalToolbarVerticalMargin = getResources().getDimensionPixelSize(R.dimen.pspdf__vertical_toolbar_vertical_margin);
        this.toolbarLayoutRect = new RectF();
        this.windowInsets = new Rect();
        this.currentContextualToolbar = null;
        this.composeManagedContentPadding = false;
        this.possiblePositionsShouldStartAnimation = false;
        this.location = new int[2];
        init(context, null, 0, 0);
    }

    private void adjustContentViewTopPadding(boolean z) {
        Toolbar toolbarFindMainToolbar;
        ViewGroup viewGroup;
        View viewFindViewById;
        if (this.composeManagedContentPadding || (toolbarFindMainToolbar = findMainToolbar()) == null || toolbarFindMainToolbar.getVisibility() != 8 || (viewGroup = (ViewGroup) getParent()) == null || (viewFindViewById = viewGroup.findViewById(R.id.pspdf__activity_content)) == null) {
            return;
        }
        viewFindViewById.setPadding(viewFindViewById.getPaddingLeft(), z ? this.toolbarSizePx : 0, viewFindViewById.getPaddingRight(), viewFindViewById.getPaddingBottom());
    }

    private void adjustRectForContextualToolbar(ContextualToolbar<?> contextualToolbar, LayoutParams.Position position, RectF rectF) {
        int submenuSizePx = contextualToolbar.getSubmenuSizePx();
        int iOrdinal = position.ordinal();
        if (iOrdinal == 0) {
            rectF.bottom += submenuSizePx;
        } else if (iOrdinal == 1) {
            rectF.right += submenuSizePx;
        } else {
            if (iOrdinal != 2) {
                return;
            }
            rectF.left -= submenuSizePx;
        }
    }

    private void calculateToolbarRects() {
        RectF rectF = this.topToolbarRect;
        Rect rect = this.windowInsets;
        int i = rect.left;
        rectF.set(i, rect.top, i + getAvailableWidth(), this.windowInsets.top + this.toolbarSizePx);
        RectF rectF2 = this.leftToolbarRect;
        Rect rect2 = this.windowInsets;
        int i2 = rect2.left + this.verticalToolbarHorizontalMargin;
        int i3 = rect2.top;
        int i4 = this.toolbarSizePx;
        rectF2.set(i2, i3 + i4 + this.verticalToolbarVerticalMargin, i2 + i4, ((i3 + getAvailableHeight()) - this.toolbarSizePx) - this.verticalToolbarVerticalMargin);
        RectF rectF3 = this.rightToolbarRect;
        int availableWidth = (this.windowInsets.left + getAvailableWidth()) - this.verticalToolbarHorizontalMargin;
        int i5 = this.toolbarSizePx;
        Rect rect3 = this.windowInsets;
        rectF3.set(availableWidth - i5, rect3.top + i5 + this.verticalToolbarVerticalMargin, (rect3.left + getAvailableWidth()) - this.verticalToolbarHorizontalMargin, ((this.windowInsets.top + getAvailableHeight()) - this.toolbarSizePx) - this.verticalToolbarVerticalMargin);
    }

    private boolean canToolbarFitVertically(ContextualToolbar contextualToolbar) {
        if (contextualToolbar.getChildCount() == 0) {
            return true;
        }
        return getAvailableHeight() >= ((this.verticalToolbarVerticalMargin + this.toolbarSizePx) * 2) + a80.a(getContext(), 288);
    }

    private boolean correctToolbarPositionIfNecessary(ContextualToolbar contextualToolbar) {
        LayoutParams layoutParams = (LayoutParams) contextualToolbar.getLayoutParams();
        LayoutParams.Position position = layoutParams.position;
        LayoutParams.Position position2 = layoutParams.forcedPosition;
        if (!layoutParams.allowedPositions.contains(position) && !layoutParams.allowedPositions.isEmpty()) {
            PdfLog.w(LOG_TAG, "Requested toolbar position: " + layoutParams.position + " is not allowed, make sure it is included in `allowedPositions` inside LayoutParams. Switching to the first allowed position within the set.", new Object[0]);
            layoutParams.position = ((LayoutParams.Position[]) layoutParams.allowedPositions.toArray(new LayoutParams.Position[1]))[0];
            layoutParams.forcedPosition = null;
        } else if (layoutParams.allowedPositions.isEmpty()) {
            StringBuilder sb = new StringBuilder("The allowedPositions property is empty. If you'd like to disable dragging of the toolbar, use ContextualToolbar#setDraggable(false) instead. Switching to the default toolbar position: ");
            LayoutParams.Position position3 = LayoutParams.DEFAULT_POSITION;
            PdfLog.w(LOG_TAG, sb.append(position3).append(".").toString(), new Object[0]);
            layoutParams.position = position3;
            layoutParams.forcedPosition = null;
        } else if (canToolbarFitVertically(contextualToolbar)) {
            layoutParams.forcedPosition = null;
            if (position2 != null && layoutParams.allowedPositions.size() > 1) {
                contextualToolbar.setDraggable(true);
            }
        } else {
            PdfLog.d(LOG_TAG, "The toolbar doesn't fit to the side of the screen so it's pinned to the top. Later on, if there's enough vertical space it will be brought to the side again to the originally requested position.", new Object[0]);
            layoutParams.forcedPosition = LayoutParams.Position.TOP;
        }
        contextualToolbar.setDraggable(layoutParams.forcedPosition == null && layoutParams.allowedPositions.size() > 1 && contextualToolbar.isDraggable());
        if (position == layoutParams.position && position2 == layoutParams.forcedPosition) {
            return false;
        }
        contextualToolbar.setLayoutParams(layoutParams);
        return true;
    }

    private void correctWindowInsetsTopForCurrentPosition() {
        int iC = gk.c(a80.a((View) this));
        getLocationInWindow(this.location);
        int iMax = Math.max(0, iC - this.location[1]);
        Rect rect = this.windowInsets;
        if (iMax != rect.top) {
            rect.top = iMax;
            calculateToolbarRects();
        }
    }

    private Toolbar findMainToolbar() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof Toolbar) {
                return (Toolbar) childAt;
            }
        }
        return null;
    }

    private int getAvailableHeight() {
        int height = getHeight();
        Rect rect = this.windowInsets;
        return (height - rect.top) - rect.bottom;
    }

    private int getAvailableWidth() {
        int width = getWidth();
        Rect rect = this.windowInsets;
        return (width - rect.left) - rect.right;
    }

    private LayoutParams.Position getChildPosition(View view) {
        if (!(view instanceof ContextualToolbar)) {
            return LayoutParams.DEFAULT_POSITION;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        LayoutParams.Position position = layoutParams.forcedPosition;
        return position != null ? position : layoutParams.position;
    }

    private View getCurrentToolbarOnTop() {
        ContextualToolbar contextualToolbar = this.currentContextualToolbar;
        if (contextualToolbar != null && contextualToolbar.getPosition() == LayoutParams.Position.TOP && this.currentContextualToolbar.isAttached()) {
            return this.currentContextualToolbar;
        }
        Toolbar toolbarFindMainToolbar = findMainToolbar();
        if (toolbarFindMainToolbar == null || toolbarFindMainToolbar.getVisibility() != 0) {
            return null;
        }
        return toolbarFindMainToolbar;
    }

    private RectF getRectByPosition(LayoutParams.Position position) {
        int iOrdinal = position.ordinal();
        if (iOrdinal != 1) {
            return iOrdinal != 2 ? this.topToolbarRect : this.rightToolbarRect;
        }
        return this.leftToolbarRect;
    }

    private void init(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.elevation}, i, i2);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, context.getResources().getDimensionPixelOffset(R.dimen.pspdf__toolbar_elevation));
        typedArrayObtainStyledAttributes.recycle();
        ViewCompat.setElevation(this, dimensionPixelOffset);
        TypedArray typedArrayObtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__ToolbarCoordinatorLayout, R.attr.pspdf__toolbarCoordinatorLayoutStyle, R.style.PSPDFKit_ToolbarCoordinatorLayout);
        int color = typedArrayObtainStyledAttributes2.getColor(R.styleable.pspdf__ToolbarCoordinatorLayout_pspdf__dragTargetColor, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
        this.toolbarSizePx = typedArrayObtainStyledAttributes2.getDimensionPixelSize(R.styleable.pspdf__ToolbarCoordinatorLayout_pspdf__contextualToolbarHeight, (int) un.a(context, 1, 58));
        typedArrayObtainStyledAttributes2.recycle();
        Paint paint = new Paint();
        this.dragTargetPaint = paint;
        paint.setColor(color);
        this.statusBarPaint = new Paint();
        TypedArray typedArrayObtainStyledAttributes3 = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.statusBarColor});
        int color2 = typedArrayObtainStyledAttributes3.getColor(0, ContextCompat.getColor(context, R.color.pspdf__onPrimaryContainerLight));
        typedArrayObtainStyledAttributes3.recycle();
        this.statusBarPaint.setColor(color2);
        setClipChildren(false);
        setClipToPadding(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onContextualToolbarPositionChanged$1(ContextualToolbar contextualToolbar, LayoutParams.Position position, LayoutParams.Position position2) {
        OnContextualToolbarPositionListener onContextualToolbarPositionListener = this.positionListener;
        if (onContextualToolbarPositionListener != null) {
            onContextualToolbarPositionListener.onContextualToolbarPositionChanged(contextualToolbar, position, position2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toggleMainToolbarVisibility$0(ValueAnimator valueAnimator) {
        invalidate();
    }

    private void moveCurrentToolbar(float f, float f2) {
        ContextualToolbar contextualToolbar = this.currentContextualToolbar;
        if (contextualToolbar != null && !contextualToolbar.isAttached()) {
            float f3 = this.detachedToolbarTranslationX + f;
            this.detachedToolbarTranslationX = f3;
            this.detachedToolbarTranslationY += f2;
            this.currentContextualToolbar.setTranslationX(f3);
            this.currentContextualToolbar.setTranslationY(this.detachedToolbarTranslationY);
            OnContextualToolbarMovementListener onContextualToolbarMovementListener = this.movementListener;
            if (onContextualToolbarMovementListener != null) {
                onContextualToolbarMovementListener.onDragContextualToolbar(this.currentContextualToolbar, (int) this.detachedToolbarTranslationX, (int) this.detachedToolbarTranslationY);
            }
        }
        invalidate();
    }

    private void refreshMainToolbarFocusability() {
        ContextualToolbar currentlyDisplayedContextualToolbar = getCurrentlyDisplayedContextualToolbar();
        Toolbar toolbarFindMainToolbar = findMainToolbar();
        if (toolbarFindMainToolbar != null) {
            if (currentlyDisplayedContextualToolbar == null || currentlyDisplayedContextualToolbar.getPosition() != LayoutParams.Position.TOP) {
                toolbarFindMainToolbar.setFocusable(true);
                toolbarFindMainToolbar.setFocusableInTouchMode(true);
                toolbarFindMainToolbar.setDescendantFocusability(131072);
            } else {
                toolbarFindMainToolbar.setFocusable(false);
                toolbarFindMainToolbar.clearFocus();
                toolbarFindMainToolbar.setDescendantFocusability(393216);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeToolbar(ContextualToolbar contextualToolbar) {
        if (contextualToolbar.getParent() == null) {
            return;
        }
        contextualToolbar.animate().setListener(null);
        OnContextualToolbarLifecycleListener onContextualToolbarLifecycleListener = this.lifecycleListener;
        if (onContextualToolbarLifecycleListener != null) {
            onContextualToolbarLifecycleListener.onRemoveContextualToolbar(contextualToolbar);
        }
        contextualToolbar.setToolbarCoordinatorController(null);
        removeView(contextualToolbar);
        adjustContentViewTopPadding(false);
        refreshMainToolbarFocusability();
    }

    private void setToolbarPositionOnAttach(ContextualToolbar contextualToolbar) {
        LayoutParams layoutParams = (LayoutParams) contextualToolbar.getLayoutParams();
        PointF pointF = new PointF(this.lastTouchX, this.lastTouchY);
        float fA = ip.a(pointF, this.topToolbarRect);
        float fA2 = ip.a(pointF, this.leftToolbarRect);
        float fA3 = ip.a(pointF, this.rightToolbarRect);
        EnumSet<LayoutParams.Position> enumSet = layoutParams.allowedPositions;
        LayoutParams.Position position = LayoutParams.Position.TOP;
        if (!enumSet.contains(position) || fA > fA3 || fA > fA2) {
            EnumSet<LayoutParams.Position> enumSet2 = layoutParams.allowedPositions;
            LayoutParams.Position position2 = LayoutParams.Position.RIGHT;
            if (!enumSet2.contains(position2) || fA3 > fA2) {
                EnumSet<LayoutParams.Position> enumSet3 = layoutParams.allowedPositions;
                LayoutParams.Position position3 = LayoutParams.Position.LEFT;
                if (enumSet3.contains(position3)) {
                    layoutParams.position = position3;
                } else {
                    layoutParams.position = LayoutParams.DEFAULT_POSITION;
                }
            } else {
                layoutParams.position = position2;
            }
        } else {
            layoutParams.position = position;
        }
        contextualToolbar.setLayoutParams(layoutParams);
        correctToolbarPositionIfNecessary(contextualToolbar);
        i0 i0VarA = ar.a();
        Bundle bundleA = z50.a(i0VarA);
        bundleA.putString("value", layoutParams.position.name());
        i0VarA.a(Analytics.Event.MOVE_TOOLBAR, bundleA);
    }

    private void updateToolbarInsets(Rect rect) {
        if (this.windowInsets.equals(rect)) {
            return;
        }
        this.windowInsets.set(rect);
        int iC = gk.c(a80.a((View) this));
        Rect rect2 = this.windowInsets;
        rect2.top = Math.max(rect2.top, iC);
        calculateToolbarRects();
        requestLayout();
    }

    @Override // com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayoutController
    public void attachContextualToolbar() {
        ContextualToolbar contextualToolbar = this.currentContextualToolbar;
        if (contextualToolbar == null) {
            return;
        }
        contextualToolbar.setAttached(true);
        this.currentContextualToolbar.setTranslationX(0.0f);
        this.currentContextualToolbar.setTranslationY(0.0f);
        setToolbarPositionOnAttach(this.currentContextualToolbar);
        OnContextualToolbarMovementListener onContextualToolbarMovementListener = this.movementListener;
        if (onContextualToolbarMovementListener != null) {
            onContextualToolbarMovementListener.onAttachContextualToolbar(this.currentContextualToolbar);
        }
        this.possiblePositionsShouldStartAnimation = true;
        invalidate();
        refreshMainToolbarFocusability();
    }

    @Override // com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayoutController
    public void detachContextualToolbar() {
        ContextualToolbar contextualToolbar = this.currentContextualToolbar;
        if (contextualToolbar == null) {
            return;
        }
        contextualToolbar.setAttached(false);
        this.detachedToolbarTranslationX = 0.0f;
        this.detachedToolbarTranslationY = 0.0f;
        OnContextualToolbarMovementListener onContextualToolbarMovementListener = this.movementListener;
        if (onContextualToolbarMovementListener != null) {
            onContextualToolbarMovementListener.onDetachContextualToolbar(this.currentContextualToolbar);
        }
        this.possiblePositionsShouldStartAnimation = true;
        invalidate();
        refreshMainToolbarFocusability();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        View currentToolbarOnTop;
        Canvas canvas2;
        super.dispatchDraw(canvas);
        PointF pointF = new PointF(this.lastTouchX, this.lastTouchY);
        float fA = ip.a(pointF, this.topToolbarRect) + 0.01f;
        float fA2 = ip.a(pointF, this.leftToolbarRect) + 0.01f;
        float fA3 = ip.a(pointF, this.rightToolbarRect) + 0.01f;
        float f = fA2 + fA + fA3;
        if (this.currentContextualToolbar != null) {
            if (this.possiblePositionsShouldStartAnimation) {
                this.possiblePositionsShouldStartAnimation = false;
                this.possiblePositionsAnimationStartTime = System.currentTimeMillis();
            }
            LayoutParams layoutParams = (LayoutParams) this.currentContextualToolbar.getLayoutParams();
            if (layoutParams.allowedPositions.isEmpty()) {
                return;
            }
            boolean zIsAttached = this.currentContextualToolbar.isAttached();
            long jCurrentTimeMillis = System.currentTimeMillis() - this.possiblePositionsAnimationStartTime;
            float f2 = jCurrentTimeMillis > 300 ? 1.0f : jCurrentTimeMillis / 300.0f;
            if (zIsAttached) {
                f2 = 1.0f - f2;
            }
            float f3 = f2;
            this.dragTargetPaint.setAlpha((int) ((150.0f - ((fA / f) * 120.0f)) * f3));
            if (layoutParams.allowedPositions.contains(LayoutParams.Position.TOP)) {
                if (this.windowInsets.top > 0) {
                    canvas2 = canvas;
                    canvas2.drawRect(0.0f, 0.0f, getWidth(), this.windowInsets.top, this.dragTargetPaint);
                } else {
                    canvas2 = canvas;
                }
                canvas2.drawRect(this.topToolbarRect, this.dragTargetPaint);
            } else {
                canvas2 = canvas;
            }
            if (canToolbarFitVertically(this.currentContextualToolbar)) {
                int iA = a80.a(getContext(), 16);
                if (layoutParams.allowedPositions.contains(LayoutParams.Position.LEFT)) {
                    this.dragTargetPaint.setAlpha((int) ((150.0f - ((fA2 / f) * 120.0f)) * f3));
                    float f4 = iA;
                    canvas2.drawRoundRect(this.leftToolbarRect, f4, f4, this.dragTargetPaint);
                }
                if (layoutParams.allowedPositions.contains(LayoutParams.Position.RIGHT)) {
                    this.dragTargetPaint.setAlpha((int) ((150.0f - ((fA3 / f) * 120.0f)) * f3));
                    float f5 = iA;
                    canvas2.drawRoundRect(this.rightToolbarRect, f5, f5, this.dragTargetPaint);
                }
            }
            if ((f3 < 1.0f && !zIsAttached) || (f3 > 0.0f && zIsAttached)) {
                postInvalidate();
            }
        }
        if (this.windowInsets.top <= 0 || (currentToolbarOnTop = getCurrentToolbarOnTop()) == null || currentToolbarOnTop.getY() <= 0.0f) {
            return;
        }
        canvas.drawRect(0.0f, 0.0f, getWidth(), currentToolbarOnTop.getY(), this.statusBarPaint);
    }

    @Override // com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayoutController
    public void displayContextualToolbar(final ContextualToolbar contextualToolbar, boolean z) {
        ContextualToolbar contextualToolbar2 = this.currentContextualToolbar;
        if (contextualToolbar2 == null || contextualToolbar2 != contextualToolbar) {
            removeContextualToolbar(false);
            this.currentContextualToolbar = contextualToolbar;
            contextualToolbar.setToolbarCoordinatorController(this);
            OnContextualToolbarLifecycleListener onContextualToolbarLifecycleListener = this.lifecycleListener;
            if (onContextualToolbarLifecycleListener != null) {
                onContextualToolbarLifecycleListener.onPrepareContextualToolbar(contextualToolbar);
            }
            if (contextualToolbar.getParent() != null) {
                removeToolbar(contextualToolbar);
            }
            contextualToolbar.setAlpha(0.0f);
            addView(contextualToolbar);
            adjustContentViewTopPadding(true);
            if (correctToolbarPositionIfNecessary(contextualToolbar)) {
                requestLayout();
            }
            contextualToolbar.animate().alpha(1.0f).setDuration(z ? 300L : 0L).setListener(new AnimatorListenerAdapter() { // from class: com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    contextualToolbar.animate().setListener(null);
                    ToolbarCoordinatorLayout toolbarCoordinatorLayout = ToolbarCoordinatorLayout.this;
                    OnContextualToolbarLifecycleListener onContextualToolbarLifecycleListener2 = toolbarCoordinatorLayout.lifecycleListener;
                    if (onContextualToolbarLifecycleListener2 != null) {
                        ContextualToolbar contextualToolbar3 = toolbarCoordinatorLayout.currentContextualToolbar;
                        ContextualToolbar contextualToolbar4 = contextualToolbar;
                        if (contextualToolbar3 == contextualToolbar4) {
                            onContextualToolbarLifecycleListener2.onDisplayContextualToolbar(contextualToolbar4);
                        }
                    }
                }
            }).start();
            refreshMainToolbarFocusability();
        }
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        updateToolbarInsets(rect);
        if (!isLaidOut()) {
            return false;
        }
        correctWindowInsetsTopForCurrentPosition();
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(LayoutParams.DEFAULT_POSITION, LayoutParams.DEFAULT_ALLOWED_POSITIONS);
    }

    public int getContextualToolbarSizePx() {
        return this.toolbarSizePx;
    }

    public ContextualToolbar getCurrentlyDisplayedContextualToolbar() {
        return this.currentContextualToolbar;
    }

    public int getToolbarInset() {
        View viewFindMainToolbar = findMainToolbar();
        if (viewFindMainToolbar == null) {
            viewFindMainToolbar = this.currentContextualToolbar;
        }
        if (viewFindMainToolbar != null) {
            return (int) getRectByPosition(getChildPosition(viewFindMainToolbar)).bottom;
        }
        return 0;
    }

    public boolean isDisplayingContextualToolbar() {
        return this.currentContextualToolbar != null;
    }

    @Override // com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayoutController
    public void onContextualToolbarChanged(ContextualToolbar contextualToolbar) {
        OnContextualToolbarLifecycleListener onContextualToolbarLifecycleListener = this.lifecycleListener;
        if (onContextualToolbarLifecycleListener != null) {
            onContextualToolbarLifecycleListener.onPrepareContextualToolbar(contextualToolbar);
        }
    }

    @Override // com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayoutController
    public void onContextualToolbarPositionChanged(final ContextualToolbar contextualToolbar, final LayoutParams.Position position, final LayoutParams.Position position2) {
        if (this.positionListener != null) {
            postOnAnimation(new Runnable() { // from class: com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onContextualToolbarPositionChanged$1(contextualToolbar, position, position2);
                }
            });
        }
        refreshMainToolbarFocusability();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 2) {
            moveCurrentToolbar(motionEvent.getX() - this.lastTouchX, motionEvent.getY() - this.lastTouchY);
        }
        this.lastTouchX = motionEvent.getX();
        this.lastTouchY = motionEvent.getY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            correctWindowInsetsTopForCurrentPosition();
        }
        ContextualToolbar contextualToolbar = this.currentContextualToolbar;
        if (contextualToolbar != null) {
            correctToolbarPositionIfNecessary(contextualToolbar);
        }
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            LayoutParams.Position childPosition = getChildPosition(childAt);
            this.toolbarLayoutRect.set(getRectByPosition(childPosition));
            if (childAt instanceof ContextualToolbar) {
                adjustRectForContextualToolbar((ContextualToolbar) childAt, childPosition, this.toolbarLayoutRect);
            }
            RectF rectF = this.toolbarLayoutRect;
            childAt.layout((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.topToolbarRect.isEmpty() || this.leftToolbarRect.isEmpty() || this.rightToolbarRect.isEmpty()) {
            calculateToolbarRects();
        }
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            LayoutParams.Position childPosition = getChildPosition(childAt);
            this.toolbarLayoutRect.set(getRectByPosition(childPosition));
            if (childAt instanceof ContextualToolbar) {
                adjustRectForContextualToolbar((ContextualToolbar) childAt, childPosition, this.toolbarLayoutRect);
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec((int) this.toolbarLayoutRect.width(), 1073741824), View.MeasureSpec.makeMeasureSpec((int) this.toolbarLayoutRect.height(), 1073741824));
        }
    }

    @Override // com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayoutController
    public void removeContextualToolbar(boolean z) {
        final ContextualToolbar contextualToolbar = this.currentContextualToolbar;
        if (contextualToolbar == null) {
            return;
        }
        this.currentContextualToolbar = null;
        if (z) {
            contextualToolbar.animate().alpha(0.0f).setDuration(z ? 300L : 0L).setListener(new AnimatorListenerAdapter() { // from class: com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ToolbarCoordinatorLayout.this.removeToolbar(contextualToolbar);
                }
            }).start();
        } else {
            removeToolbar(contextualToolbar);
        }
    }

    public void setContentViewTopPadding(int i) {
        View viewFindViewById;
        this.composeManagedContentPadding = true;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null || (viewFindViewById = viewGroup.findViewById(R.id.pspdf__activity_content)) == null) {
            return;
        }
        viewFindViewById.setPadding(viewFindViewById.getPaddingLeft(), i, viewFindViewById.getPaddingRight(), viewFindViewById.getPaddingBottom());
    }

    public void setDragTargetColor(int i) {
        this.dragTargetPaint.setColor(i);
    }

    public void setMainToolbarEnabled(boolean z) {
        Toolbar toolbarFindMainToolbar = findMainToolbar();
        if (toolbarFindMainToolbar != null) {
            toolbarFindMainToolbar.setVisibility(z ? 0 : 8);
        }
    }

    public void setOnContextualToolbarLifecycleListener(OnContextualToolbarLifecycleListener onContextualToolbarLifecycleListener) {
        this.lifecycleListener = onContextualToolbarLifecycleListener;
    }

    public void setOnContextualToolbarMovementListener(OnContextualToolbarMovementListener onContextualToolbarMovementListener) {
        this.movementListener = onContextualToolbarMovementListener;
    }

    public void setOnContextualToolbarPositionListener(OnContextualToolbarPositionListener onContextualToolbarPositionListener) {
        this.positionListener = onContextualToolbarPositionListener;
    }

    public void toggleMainToolbarVisibility(final boolean z, long j, long j2) {
        final Toolbar toolbarFindMainToolbar = findMainToolbar();
        if (toolbarFindMainToolbar != null) {
            toolbarFindMainToolbar.animate().cancel();
            if (z) {
                toolbarFindMainToolbar.setVisibility(0);
            }
            toolbarFindMainToolbar.animate().setStartDelay(j).setInterpolator(z ? new DecelerateInterpolator(1.5f) : new AccelerateInterpolator(1.5f)).translationY(z ? 0.0f : -(toolbarFindMainToolbar.getHeight() + this.windowInsets.top)).setDuration(j2).setUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$toggleMainToolbarVisibility$0(valueAnimator);
                }
            }).setListener(new AnimatorListenerAdapter() { // from class: com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (!z) {
                        toolbarFindMainToolbar.setVisibility(8);
                    }
                    toolbarFindMainToolbar.animate().setListener(null);
                }
            }).start();
        }
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        private static final EnumSet<Position> DEFAULT_ALLOWED_POSITIONS;
        public static final Position DEFAULT_POSITION;
        public EnumSet<Position> allowedPositions;
        public Position forcedPosition;
        public Position position;

        public enum Position {
            TOP,
            LEFT,
            RIGHT
        }

        static {
            Position position = Position.TOP;
            DEFAULT_POSITION = position;
            DEFAULT_ALLOWED_POSITIONS = EnumSet.of(position);
        }

        public LayoutParams(Position position, EnumSet<Position> enumSet) {
            super(-2, -2);
            this.forcedPosition = null;
            this.position = position;
            this.allowedPositions = enumSet;
        }

        public LayoutParams(Position position) {
            super(-2, -2);
            this.forcedPosition = null;
            this.allowedPositions = DEFAULT_ALLOWED_POSITIONS;
            this.position = position;
        }
    }

    public ToolbarCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.leftToolbarRect = new RectF();
        this.topToolbarRect = new RectF();
        this.rightToolbarRect = new RectF();
        this.verticalToolbarHorizontalMargin = getResources().getDimensionPixelSize(R.dimen.pspdf__vertical_toolbar_horizontal_margin);
        this.verticalToolbarVerticalMargin = getResources().getDimensionPixelSize(R.dimen.pspdf__vertical_toolbar_vertical_margin);
        this.toolbarLayoutRect = new RectF();
        this.windowInsets = new Rect();
        this.currentContextualToolbar = null;
        this.composeManagedContentPadding = false;
        this.possiblePositionsShouldStartAnimation = false;
        this.location = new int[2];
        init(context, attributeSet, 0, 0);
    }

    public ToolbarCoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.leftToolbarRect = new RectF();
        this.topToolbarRect = new RectF();
        this.rightToolbarRect = new RectF();
        this.verticalToolbarHorizontalMargin = getResources().getDimensionPixelSize(R.dimen.pspdf__vertical_toolbar_horizontal_margin);
        this.verticalToolbarVerticalMargin = getResources().getDimensionPixelSize(R.dimen.pspdf__vertical_toolbar_vertical_margin);
        this.toolbarLayoutRect = new RectF();
        this.windowInsets = new Rect();
        this.currentContextualToolbar = null;
        this.composeManagedContentPadding = false;
        this.possiblePositionsShouldStartAnimation = false;
        this.location = new int[2];
        init(context, attributeSet, i, 0);
    }

    public ToolbarCoordinatorLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.leftToolbarRect = new RectF();
        this.topToolbarRect = new RectF();
        this.rightToolbarRect = new RectF();
        this.verticalToolbarHorizontalMargin = getResources().getDimensionPixelSize(R.dimen.pspdf__vertical_toolbar_horizontal_margin);
        this.verticalToolbarVerticalMargin = getResources().getDimensionPixelSize(R.dimen.pspdf__vertical_toolbar_vertical_margin);
        this.toolbarLayoutRect = new RectF();
        this.windowInsets = new Rect();
        this.currentContextualToolbar = null;
        this.composeManagedContentPadding = false;
        this.possiblePositionsShouldStartAnimation = false;
        this.location = new int[2];
        init(context, attributeSet, i, i2);
    }
}
