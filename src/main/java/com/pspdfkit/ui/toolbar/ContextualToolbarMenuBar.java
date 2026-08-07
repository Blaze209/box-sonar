package com.pspdfkit.ui.toolbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.core.view.ViewCompat;
import com.microsoft.intune.mam.client.view.MAMViewGroup;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.un;
import com.pspdfkit.internal.x40;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ContextualToolbarMenuBar extends MAMViewGroup {
    static final int BORDER_STROKE_WIDTH_DP = 1;
    static final int CORNER_RADIUS_DP = 16;
    private static final int ITEM_SIZE_NOT_CALCULATED = 0;
    public static final int MENU_BAR_ITEM_MARGIN_DP = 5;
    public static final int MENU_BAR_ROW_SIZE_DP = 58;
    public static final int MENU_BAR_SIDE_PADDING_DP = 5;
    public static final int MENU_BAR_TEXT_ITEM_END_PADDING_DP = 16;
    private static final int MENU_ITEM_FADE_ANIMATION_MS = 100;
    private static final int PREDICTED_MAX_ITEMS_END = 6;
    private static final int PREDICTED_MAX_ITEMS_START = 2;
    public static final int TOOLBAR_ITEM_SIZE_DP = 48;
    private final Rect alternateBackgroundRect;
    private int backgroundColor;
    private int borderColor;
    private int borderStrokeWidthPx;
    private int cornerRadiusPx;
    private final View horizontalBottomBorder;
    private final boolean isStylusConnected;
    private boolean isSubmenu;
    private int itemMarginPx;
    private int itemSizePx;
    private final List<ContextualToolbarMenuItem> itemsEnd;
    private final List<ContextualToolbarMenuItem> itemsStart;
    private int menuBarSidePaddingPx;
    private int menuTextItemBarEndPaddingPx;
    private int toolbarRowSize;

    public static class FadeInOutMenuItemsCompletableOnSubscribe implements CompletableOnSubscribe {
        private final long duration;
        private final boolean fadeIn;
        private int itemsToFade;
        private final List<ContextualToolbarMenuItem> menuItems;
        private CompletableEmitter subscriber;

        public FadeInOutMenuItemsCompletableOnSubscribe(List<ContextualToolbarMenuItem> list, long j, boolean z) {
            this.menuItems = list;
            this.duration = j;
            this.fadeIn = z;
            this.itemsToFade = list.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dequeueAndFinish() {
            CompletableEmitter completableEmitter = this.subscriber;
            if (completableEmitter != null) {
                int i = this.itemsToFade - 1;
                this.itemsToFade = i;
                if (i == 0) {
                    completableEmitter.onComplete();
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.CompletableOnSubscribe
        public void subscribe(CompletableEmitter completableEmitter) throws Exception {
            CompletableEmitter completableEmitter2 = this.subscriber;
            if (completableEmitter2 != null) {
                completableEmitter2.onComplete();
            }
            if (this.menuItems.isEmpty()) {
                completableEmitter.onComplete();
                return;
            }
            this.subscriber = completableEmitter;
            for (final ContextualToolbarMenuItem contextualToolbarMenuItem : this.menuItems) {
                float f = 1.0f;
                ViewPropertyAnimator viewPropertyAnimatorScaleX = contextualToolbarMenuItem.animate().scaleX(this.fadeIn ? 1.0f : 0.0f);
                if (!this.fadeIn) {
                    f = 0.0f;
                }
                viewPropertyAnimatorScaleX.scaleY(f).setDuration(this.duration).setInterpolator(new DecelerateInterpolator()).setListener(new AnimatorListenerAdapter() { // from class: com.pspdfkit.ui.toolbar.ContextualToolbarMenuBar.FadeInOutMenuItemsCompletableOnSubscribe.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        FadeInOutMenuItemsCompletableOnSubscribe.this.dequeueAndFinish();
                        contextualToolbarMenuItem.animate().setListener(null);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        FadeInOutMenuItemsCompletableOnSubscribe.this.dequeueAndFinish();
                        contextualToolbarMenuItem.animate().setListener(null);
                    }
                }).start();
            }
        }
    }

    public enum MenuItemPosition {
        START,
        END
    }

    public ContextualToolbarMenuBar(Context context) {
        super(context);
        this.horizontalBottomBorder = new View(getContext());
        this.itemsStart = new ArrayList(2);
        this.itemsEnd = new ArrayList(6);
        this.backgroundColor = -16776961;
        this.borderColor = -16776961;
        this.isSubmenu = false;
        this.itemSizePx = 0;
        this.itemMarginPx = 0;
        this.cornerRadiusPx = 0;
        this.borderStrokeWidthPx = 0;
        this.menuBarSidePaddingPx = 0;
        this.menuTextItemBarEndPaddingPx = 0;
        this.toolbarRowSize = 0;
        this.isStylusConnected = x40.a();
        this.alternateBackgroundRect = new Rect();
        init(context);
    }

    private int calculateRequiredMenuItemsSize(int i) {
        if (i == 0) {
            return 0;
        }
        int sidePadding = getSidePadding();
        int i2 = this.itemSizePx;
        int i3 = this.itemMarginPx;
        return ((((i2 + i3) * i) + sidePadding) - i3) + getSidePadding();
    }

    private int countItemsToLayout(List<ContextualToolbarMenuItem> list) {
        Iterator<ContextualToolbarMenuItem> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getVisibility() != 8) {
                i++;
            }
        }
        return i;
    }

    public static int estimateItemCapacity(Context context, int i) {
        int iA = a80.a(context, 5) * 2;
        int iA2 = (int) un.a(context, 1, 5);
        return (int) Math.floor(((double) ((i - iA) + iA2)) / ((double) (((int) un.a(context, 1, 48)) + iA2)));
    }

    private Completable fadeInItems(List<ContextualToolbarMenuItem> list, boolean z) {
        return Completable.create(new FadeInOutMenuItemsCompletableOnSubscribe(list, z ? 100L : 0L, true));
    }

    private Completable fadeOutItems(List<ContextualToolbarMenuItem> list, boolean z) {
        return Completable.create(new FadeInOutMenuItemsCompletableOnSubscribe(list, z ? 100L : 0L, false));
    }

    private ToolbarCoordinatorLayout.LayoutParams.Position getPosition() {
        return getPositionFromParent(getParent());
    }

    private ToolbarCoordinatorLayout.LayoutParams.Position getPositionFromParent(ViewParent viewParent) {
        ToolbarCoordinatorLayout.LayoutParams.Position position = ToolbarCoordinatorLayout.LayoutParams.Position.TOP;
        if (viewParent instanceof ContextualToolbar) {
            ToolbarCoordinatorLayout.LayoutParams layoutParams = (ToolbarCoordinatorLayout.LayoutParams) ((ContextualToolbar) viewParent).getLayoutParams();
            if (layoutParams != null) {
                ToolbarCoordinatorLayout.LayoutParams.Position position2 = layoutParams.forcedPosition;
                return position2 != null ? position2 : layoutParams.position;
            }
        } else {
            if (viewParent instanceof ContextualToolbarSubMenu) {
                return ((ContextualToolbarSubMenu) viewParent).getPosition();
            }
            if ((viewParent instanceof HorizontalScrollView) || (viewParent instanceof ScrollView)) {
                return getPositionFromParent(viewParent.getParent());
            }
        }
        return position;
    }

    private int getSidePadding() {
        return this.menuBarSidePaddingPx;
    }

    private void init(Context context) {
        this.cornerRadiusPx = a80.a(context, 16);
        this.itemSizePx = (int) un.a(context, 1, 48);
        this.itemMarginPx = (int) un.a(context, 1, 5);
        this.horizontalBottomBorder.setVisibility(8);
        this.borderStrokeWidthPx = a80.a(getContext(), 1);
        this.menuBarSidePaddingPx = a80.a(getContext(), 5);
        this.menuTextItemBarEndPaddingPx = a80.a(getContext(), 16);
        this.toolbarRowSize = a80.a(getContext(), 58);
    }

    private boolean isHorizontal() {
        return getWidth() >= getHeight();
    }

    private void roundCornersIfVertical() {
        ToolbarCoordinatorLayout.LayoutParams.Position position = getPosition();
        if (this.isSubmenu) {
            super.setBackgroundColor(0);
        } else if (!isHorizontal() || this.isSubmenu) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(this.cornerRadiusPx);
            gradientDrawable.setColor(this.backgroundColor);
            gradientDrawable.setStroke(this.borderStrokeWidthPx, this.borderColor);
            ViewCompat.setBackground(this, gradientDrawable);
        } else {
            super.setBackgroundColor(this.backgroundColor);
            this.horizontalBottomBorder.setBackgroundColor(this.borderColor);
        }
        Iterator<ContextualToolbarMenuItem> it = getMenuItems().iterator();
        while (it.hasNext()) {
            it.next().adaptSubmenuIndicatorToParentPosition(position);
        }
    }

    public int getCornerRadiusPx() {
        return this.cornerRadiusPx;
    }

    public List<ContextualToolbarMenuItem> getMenuItems() {
        ArrayList arrayList = new ArrayList(this.itemsEnd.size() + this.itemsStart.size());
        arrayList.addAll(this.itemsStart);
        arrayList.addAll(this.itemsEnd);
        return arrayList;
    }

    public int getScrollableMenuBarSize(int i) {
        double d = this.itemSizePx + this.itemMarginPx;
        double dRound = ((((double) ((int) Math.round(((double) (i - getSidePadding())) / d))) - 0.25d) * d) + ((double) getSidePadding());
        if (dRound > i) {
            dRound -= d;
        }
        return (int) dRound;
    }

    public int getToolbarRowSize() {
        return this.toolbarRowSize;
    }

    public Size getTotalChildrenSize() {
        int iCountItemsToLayout = countItemsToLayout(this.itemsStart);
        int iCountItemsToLayout2 = countItemsToLayout(this.itemsEnd);
        int iCalculateRequiredMenuItemsSize = calculateRequiredMenuItemsSize(iCountItemsToLayout);
        int iCalculateRequiredMenuItemsSize2 = calculateRequiredMenuItemsSize(iCountItemsToLayout2);
        return getPosition() == ToolbarCoordinatorLayout.LayoutParams.Position.TOP ? new Size(iCalculateRequiredMenuItemsSize + iCalculateRequiredMenuItemsSize2, getToolbarRowSize()) : new Size(getToolbarRowSize(), iCalculateRequiredMenuItemsSize + iCalculateRequiredMenuItemsSize2);
    }

    public Completable hideMenuItems(boolean z) {
        return fadeOutItems(getMenuItems(), z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            roundCornersIfVertical();
        }
        boolean zIsHorizontal = isHorizontal();
        int sidePadding = getSidePadding();
        int iMax = zIsHorizontal ? sidePadding : Math.max((getWidth() - this.itemSizePx) / 2, 0);
        int iMax2 = zIsHorizontal ? Math.max((getHeight() - this.itemSizePx) / 2, 0) : sidePadding;
        for (ContextualToolbarMenuItem contextualToolbarMenuItem : this.itemsStart) {
            if (contextualToolbarMenuItem.getVisibility() != 8) {
                int i5 = this.itemSizePx;
                contextualToolbarMenuItem.layout(iMax, iMax2, iMax + i5, i5 + iMax2);
                int i6 = this.itemSizePx;
                if (zIsHorizontal) {
                    iMax += i6 + this.itemMarginPx;
                } else {
                    iMax2 += i6 + this.itemMarginPx;
                }
            }
        }
        int width = getWidth();
        if (zIsHorizontal) {
            iMax = (width - sidePadding) - this.itemSizePx;
        } else {
            iMax2 = (getHeight() - sidePadding) - this.itemSizePx;
        }
        this.alternateBackgroundRect.right = getWidth() - this.borderStrokeWidthPx;
        this.alternateBackgroundRect.bottom = getHeight() - this.borderStrokeWidthPx;
        removeView(this.horizontalBottomBorder);
        boolean z2 = false;
        for (int size = this.itemsEnd.size() - 1; size >= 0; size--) {
            ContextualToolbarMenuItem contextualToolbarMenuItem2 = this.itemsEnd.get(size);
            if (contextualToolbarMenuItem2.getVisibility() != 8) {
                if (contextualToolbarMenuItem2.getUseAlternateBackground()) {
                    this.alternateBackgroundRect.top = iMax2 - sidePadding;
                    z2 = true;
                }
                if (contextualToolbarMenuItem2.isTextItemFirstFromEnd() && isHorizontal()) {
                    iMax = (width - this.menuTextItemBarEndPaddingPx) - this.itemSizePx;
                }
                int i7 = this.itemSizePx;
                contextualToolbarMenuItem2.layout(iMax, iMax2, iMax + i7, i7 + iMax2);
                int i8 = this.itemSizePx;
                if (zIsHorizontal) {
                    iMax -= i8 + this.itemMarginPx;
                } else {
                    iMax2 -= i8 + this.itemMarginPx;
                }
            }
        }
        if (z2) {
            this.horizontalBottomBorder.setVisibility(8);
        } else {
            if (!zIsHorizontal || this.isSubmenu) {
                return;
            }
            addView(this.horizontalBottomBorder, 0);
            this.horizontalBottomBorder.layout(0, getHeight() - this.borderStrokeWidthPx, getWidth(), getHeight());
            this.horizontalBottomBorder.setVisibility(0);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Size totalChildrenSize = getTotalChildrenSize();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(size, totalChildrenSize.getWidth());
        } else if (mode == 0) {
            size = totalChildrenSize.getWidth();
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(size2, totalChildrenSize.getHeight());
        } else if (mode2 == 0) {
            size2 = totalChildrenSize.getHeight();
        }
        setMeasuredDimension(size, size2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.itemSizePx, 1073741824);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(iMakeMeasureSpec, iMakeMeasureSpec);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.backgroundColor = i;
        roundCornersIfVertical();
    }

    public void setBorderAndBackgroundColor(int i, int i2) {
        setBorderColor(i);
        setBackgroundColor(i2);
    }

    public void setBorderColor(int i) {
        this.borderColor = i;
    }

    public void setIsSubmenu(boolean z) {
        this.isSubmenu = z;
        requestLayout();
    }

    public void setMenuItems(List<ContextualToolbarMenuItem> list) {
        List<ContextualToolbarMenuItem> menuItems = getMenuItems();
        this.itemsStart.clear();
        this.itemsEnd.clear();
        for (ContextualToolbarMenuItem contextualToolbarMenuItem : list) {
            if (contextualToolbarMenuItem.getPosition() == ContextualToolbarMenuItem.Position.START) {
                this.itemsStart.add(contextualToolbarMenuItem);
            } else {
                this.itemsEnd.add(contextualToolbarMenuItem);
            }
        }
        for (ContextualToolbarMenuItem contextualToolbarMenuItem2 : menuItems) {
            removeView(contextualToolbarMenuItem2);
            contextualToolbarMenuItem2.setScaleX(1.0f);
            contextualToolbarMenuItem2.setScaleY(1.0f);
        }
        for (ContextualToolbarMenuItem contextualToolbarMenuItem3 : list) {
            if (contextualToolbarMenuItem3.getParent() != null) {
                ((ViewGroup) contextualToolbarMenuItem3.getParent()).removeView(contextualToolbarMenuItem3);
            }
            contextualToolbarMenuItem3.setScaleX(0.0f);
            contextualToolbarMenuItem3.setScaleY(0.0f);
            addView(contextualToolbarMenuItem3);
        }
    }

    public Completable showMenuItems(boolean z) {
        return fadeInItems(getMenuItems(), z);
    }

    public ContextualToolbarMenuBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.horizontalBottomBorder = new View(getContext());
        this.itemsStart = new ArrayList(2);
        this.itemsEnd = new ArrayList(6);
        this.backgroundColor = -16776961;
        this.borderColor = -16776961;
        this.isSubmenu = false;
        this.itemSizePx = 0;
        this.itemMarginPx = 0;
        this.cornerRadiusPx = 0;
        this.borderStrokeWidthPx = 0;
        this.menuBarSidePaddingPx = 0;
        this.menuTextItemBarEndPaddingPx = 0;
        this.toolbarRowSize = 0;
        this.isStylusConnected = x40.a();
        this.alternateBackgroundRect = new Rect();
        init(context);
    }

    public ContextualToolbarMenuBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.horizontalBottomBorder = new View(getContext());
        this.itemsStart = new ArrayList(2);
        this.itemsEnd = new ArrayList(6);
        this.backgroundColor = -16776961;
        this.borderColor = -16776961;
        this.isSubmenu = false;
        this.itemSizePx = 0;
        this.itemMarginPx = 0;
        this.cornerRadiusPx = 0;
        this.borderStrokeWidthPx = 0;
        this.menuBarSidePaddingPx = 0;
        this.menuTextItemBarEndPaddingPx = 0;
        this.toolbarRowSize = 0;
        this.isStylusConnected = x40.a();
        this.alternateBackgroundRect = new Rect();
        init(context);
    }
}
