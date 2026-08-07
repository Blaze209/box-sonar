package com.pspdfkit.ui.toolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.e9;
import com.pspdfkit.internal.vm;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ContextualToolbarMenuItem extends AppCompatImageButton implements View.OnLayoutChangeListener {
    private static final int INDICATOR_ARROW_SIZE_DP = 6;
    private static final int INDICATOR_ARROW_SIZE_PADDING_DP = 7;
    private static final boolean useRoundRectForSelectionIndication = true;
    private boolean closeSubmenuOnSubmenuItemClick;
    private ContextualToolbarMenuItem defaultSelectedMenuItem;
    private boolean displayOutsideOfSubmenuIfPossible;
    private Drawable icon;
    private int iconColor;
    private int iconColorActivated;
    private boolean isSelectable;
    private boolean isSelected;
    private boolean isTextItemFirstFromEnd;
    private Path leftIndicatorArrow;
    private boolean openSubmenuOnClick;
    private Position position;
    private int requestedVisibility;
    private Path rightIndicatorArrow;
    private boolean showColorIndicatorCircle;
    private final StyleCircleIndicatorIconDrawer styleIndicatorDrawer;
    private List<ContextualToolbarMenuItem> subMenuItems;
    private final Paint submenuIndicatorPaint;
    private SubmenuIndicatorPosition submenuIndicatorPosition;
    private String title;
    private boolean useAlternateBackground;
    private boolean useTint;

    public enum Position {
        START,
        END
    }

    public class StyleCircleIndicatorIconDrawer {
        private static final float CIRCLE_ICON_AREA_PERCENTAGE = 0.4f;
        private static final float MAX_SIZE_VALUE_PT = 40.0f;
        private static final int MIN_RADIUS_DP = 4;
        private static final float MIN_SIZE_VALUE_PT = 10.0f;
        private Drawable styleIndicatorIconCircleDrawable;
        private Drawable styleIndicatorIconRingDrawable;

        private StyleCircleIndicatorIconDrawer() {
            this.styleIndicatorIconRingDrawable = null;
            this.styleIndicatorIconCircleDrawable = null;
        }

        public Drawable appendStyleIndicatorCircleToDrawable(Drawable drawable, int i) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, this.styleIndicatorIconCircleDrawable});
            int i2 = (int) (ContextualToolbarMenuItem.this.getContext().getResources().getDisplayMetrics().density * 2.0f);
            int i3 = (-i) - i2;
            int intrinsicWidth = ((int) ((drawable.getIntrinsicWidth() - (i * 2)) * 0.6f)) + i + i2;
            layerDrawable.setLayerInset(1, i3, i3, intrinsicWidth, intrinsicWidth);
            return layerDrawable;
        }

        public Drawable appendStyleIndicatorRingToDrawable(Drawable drawable) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, this.styleIndicatorIconRingDrawable});
            int i = (int) (ContextualToolbarMenuItem.this.getContext().getResources().getDisplayMetrics().density * 1.0f);
            int i2 = -i;
            int intrinsicWidth = ((int) (drawable.getIntrinsicWidth() * 0.6f)) + i;
            layerDrawable.setLayerInset(1, i2, i2, intrinsicWidth, intrinsicWidth);
            return layerDrawable;
        }

        public void clearResources() {
            this.styleIndicatorIconCircleDrawable = null;
            this.styleIndicatorIconRingDrawable = null;
        }

        public void generateStyleIndicatorDrawables(int i, int i2, float f, int i3) {
            float fMax = (((Math.max(10.0f, Math.min(f, 40.0f)) - 10.0f) / 30.0f) * (((int) (((i3 * 0.4f) / 2.0f) / ContextualToolbarMenuItem.this.getContext().getResources().getDisplayMetrics().density)) - 4)) + 4.0f;
            float f2 = fMax - 1.0f;
            this.styleIndicatorIconRingDrawable = new e9(ContextualToolbarMenuItem.this.getContext(), i2, i2, f2, f2, 1.0f);
            this.styleIndicatorIconCircleDrawable = new e9(ContextualToolbarMenuItem.this.getContext(), i, i, fMax - 2.0f, fMax - 3.0f, 1.0f);
        }
    }

    public enum SubmenuIndicatorPosition {
        NONE,
        BOTTOM_LEFT,
        BOTTOM_RIGHT
    }

    private ContextualToolbarMenuItem(Context context, int i, int i2, int i3, Position position, boolean z) {
        super(context);
        this.position = Position.END;
        this.openSubmenuOnClick = true;
        this.closeSubmenuOnSubmenuItemClick = true;
        this.useAlternateBackground = false;
        this.useTint = true;
        this.isSelected = false;
        Paint paint = new Paint();
        this.submenuIndicatorPaint = paint;
        this.submenuIndicatorPosition = SubmenuIndicatorPosition.NONE;
        this.displayOutsideOfSubmenuIfPossible = false;
        this.showColorIndicatorCircle = false;
        this.styleIndicatorDrawer = new StyleCircleIndicatorIconDrawer();
        setId(i);
        this.iconColor = i2;
        this.iconColorActivated = i3;
        this.position = position;
        this.isSelectable = z;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.selectableItemBackgroundBorderless});
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        ViewCompat.setBackground(this, drawable);
        setScaleType(ImageView.ScaleType.CENTER);
        addOnLayoutChangeListener(this);
        paint.setStyle(Paint.Style.FILL);
        calculateSubmenuIndicatorSizes();
    }

    private void calculateSubmenuIndicatorSizes() {
        int iA = a80.a(getContext(), 6);
        int iA2 = a80.a(getContext(), 7);
        Path path = new Path();
        this.leftIndicatorArrow = path;
        path.moveTo(0.0f, getHeight());
        this.leftIndicatorArrow.lineTo(0.0f, getHeight() - iA);
        this.leftIndicatorArrow.lineTo(iA, getHeight());
        this.leftIndicatorArrow.lineTo(0.0f, getHeight());
        float f = iA2;
        float f2 = -iA2;
        this.leftIndicatorArrow.offset(f, f2);
        Path path2 = new Path();
        this.rightIndicatorArrow = path2;
        path2.moveTo(getWidth(), getHeight());
        this.rightIndicatorArrow.lineTo(getWidth(), getHeight() - iA);
        this.rightIndicatorArrow.lineTo(getWidth() - iA, getHeight());
        this.rightIndicatorArrow.lineTo(getWidth(), getHeight());
        this.rightIndicatorArrow.offset(f2, f2);
        invalidate();
    }

    public static ContextualToolbarMenuItem createGroupItem(int i, Position position, boolean z, List<ContextualToolbarMenuItem> list, ContextualToolbarMenuItem contextualToolbarMenuItem) {
        ContextualToolbarMenuItem contextualToolbarMenuItem2 = new ContextualToolbarMenuItem(contextualToolbarMenuItem.getContext(), i, contextualToolbarMenuItem.iconColor, contextualToolbarMenuItem.iconColorActivated, position, z);
        contextualToolbarMenuItem2.setSubMenuItems(list, contextualToolbarMenuItem);
        return contextualToolbarMenuItem2;
    }

    public static ContextualToolbarMenuItem createSingleItem(Context context, int i, Drawable drawable, String str, int i2, int i3, Position position, boolean z) {
        ContextualToolbarMenuItem contextualToolbarMenuItem = new ContextualToolbarMenuItem(context, i, i2, i3, position, z);
        contextualToolbarMenuItem.setIcon(drawable);
        contextualToolbarMenuItem.setTitle(str);
        return contextualToolbarMenuItem;
    }

    public static ContextualToolbarMenuItem createSingleTextItem(Context context, int i, Position position) {
        return new ContextualToolbarMenuItem(context, i, position);
    }

    private Path getSubmenuIndicatorPath() {
        if (!hasSubmenu()) {
            return null;
        }
        int iOrdinal = this.submenuIndicatorPosition.ordinal();
        if (iOrdinal == 1) {
            return this.leftIndicatorArrow;
        }
        if (iOrdinal != 2) {
            return null;
        }
        return this.rightIndicatorArrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: updateIcon, reason: merged with bridge method [inline-methods] */
    public void lambda$setSelected$0() {
        if (this.icon == null) {
            return;
        }
        this.submenuIndicatorPaint.setColor(this.iconColor);
        this.submenuIndicatorPaint.setAlpha(isEnabled() ? 255 : 128);
        Drawable drawableMutate = this.icon.mutate();
        if (this.showColorIndicatorCircle) {
            drawableMutate = this.styleIndicatorDrawer.appendStyleIndicatorRingToDrawable(drawableMutate);
        }
        Drawable drawableAppendStyleIndicatorCircleToDrawable = drawableMutate;
        if (isSelected()) {
            drawableAppendStyleIndicatorCircleToDrawable = (getWidth() <= 0 || getHeight() <= 0) ? new vm(getContext(), drawableAppendStyleIndicatorCircleToDrawable, this.iconColor) : new vm(getContext(), drawableAppendStyleIndicatorCircleToDrawable, this.iconColorActivated, new Size(getWidth(), getHeight()), getSubmenuIndicatorPath(), this.submenuIndicatorPaint, this.useTint);
        } else if (this.useTint) {
            DrawableCompat.setTint(drawableAppendStyleIndicatorCircleToDrawable, this.iconColor);
        } else {
            DrawableCompat.setTintList(drawableAppendStyleIndicatorCircleToDrawable, null);
        }
        if (this.showColorIndicatorCircle) {
            drawableAppendStyleIndicatorCircleToDrawable = this.styleIndicatorDrawer.appendStyleIndicatorCircleToDrawable(drawableAppendStyleIndicatorCircleToDrawable, (drawableAppendStyleIndicatorCircleToDrawable.getIntrinsicWidth() - this.icon.getIntrinsicWidth()) / 2);
        }
        drawableAppendStyleIndicatorCircleToDrawable.setAlpha(isEnabled() ? 255 : 128);
        setImageDrawable(drawableAppendStyleIndicatorCircleToDrawable);
    }

    public void adaptSubmenuIndicatorToParentPosition(ToolbarCoordinatorLayout.LayoutParams.Position position) {
        if (position == ToolbarCoordinatorLayout.LayoutParams.Position.TOP || position == ToolbarCoordinatorLayout.LayoutParams.Position.LEFT) {
            this.submenuIndicatorPosition = SubmenuIndicatorPosition.BOTTOM_RIGHT;
        } else if (position == ToolbarCoordinatorLayout.LayoutParams.Position.RIGHT) {
            this.submenuIndicatorPosition = SubmenuIndicatorPosition.BOTTOM_LEFT;
        } else {
            this.submenuIndicatorPosition = SubmenuIndicatorPosition.NONE;
        }
        calculateSubmenuIndicatorSizes();
    }

    public ContextualToolbarMenuItem getDefaultSelectedMenuItem() {
        return this.defaultSelectedMenuItem;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getIconColor() {
        return this.iconColor;
    }

    public int getIconColorActivated() {
        return this.iconColorActivated;
    }

    public Position getPosition() {
        return this.position;
    }

    public int getRequestedVisibility() {
        return this.requestedVisibility;
    }

    public List<ContextualToolbarMenuItem> getSubMenuItems() {
        return this.subMenuItems;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean getUseAlternateBackground() {
        return this.useAlternateBackground;
    }

    public boolean hasSubmenu() {
        return (getSubMenuItems() == null || getSubMenuItems().isEmpty()) ? false : true;
    }

    public void hideColorIndicatorCircle() {
        this.styleIndicatorDrawer.clearResources();
        this.showColorIndicatorCircle = false;
        lambda$setSelected$0();
    }

    public boolean isSelectable() {
        return this.isSelectable;
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.isSelected;
    }

    public boolean isTextItemFirstFromEnd() {
        return this.isTextItemFirstFromEnd;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        SubmenuIndicatorPosition submenuIndicatorPosition;
        super.onDraw(canvas);
        if (!hasSubmenu() || isSelected() || (submenuIndicatorPosition = this.submenuIndicatorPosition) == SubmenuIndicatorPosition.NONE) {
            return;
        }
        if (submenuIndicatorPosition == SubmenuIndicatorPosition.BOTTOM_LEFT) {
            canvas.drawPath(this.leftIndicatorArrow, this.submenuIndicatorPaint);
        } else {
            canvas.drawPath(this.rightIndicatorArrow, this.submenuIndicatorPaint);
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        calculateSubmenuIndicatorSizes();
    }

    public void setCloseSubmenuOnItemClick(boolean z) {
        this.closeSubmenuOnSubmenuItemClick = z;
    }

    public void setDefaultSelectedMenuItem(ContextualToolbarMenuItem contextualToolbarMenuItem) {
        this.defaultSelectedMenuItem = contextualToolbarMenuItem;
        if (contextualToolbarMenuItem != null) {
            this.icon = contextualToolbarMenuItem.icon;
            this.useTint = contextualToolbarMenuItem.useTint;
            this.iconColor = contextualToolbarMenuItem.iconColor;
            this.iconColorActivated = contextualToolbarMenuItem.iconColorActivated;
            String str = contextualToolbarMenuItem.title;
            if (str != null) {
                setTitle(str);
            }
            lambda$setSelected$0();
        }
    }

    public void setDisplayOutsideOfSubmenuIfPossible(boolean z) {
        this.displayOutsideOfSubmenuIfPossible = z;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        lambda$setSelected$0();
    }

    public void setIcon(Drawable drawable) {
        this.icon = drawable;
        lambda$setSelected$0();
    }

    public void setIconColor(int i) {
        this.iconColor = i;
        lambda$setSelected$0();
    }

    public void setIconColorActivated(int i) {
        this.iconColorActivated = i;
        lambda$setSelected$0();
    }

    public void setOpenSubmenuOnClick(boolean z) {
        this.openSubmenuOnClick = z;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setRequestedVisibility(int i) {
        this.requestedVisibility = i;
    }

    public void setSelectable(boolean z) {
        if (this.isSelectable && !z) {
            setSelected(false);
        }
        this.isSelectable = z;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean z) {
        if (this.isSelectable) {
            this.isSelected = z;
            postDelayed(new Runnable() { // from class: com.pspdfkit.ui.toolbar.ContextualToolbarMenuItem$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setSelected$0();
                }
            }, 100L);
        }
    }

    public void setSubMenuItems(List<ContextualToolbarMenuItem> list, ContextualToolbarMenuItem contextualToolbarMenuItem) {
        this.subMenuItems = list;
        setDefaultSelectedMenuItem(contextualToolbarMenuItem);
    }

    public void setTextItemFirstFromEnd(boolean z) {
        this.isTextItemFirstFromEnd = z;
    }

    public void setTintingEnabled(boolean z) {
        this.useTint = z;
        lambda$setSelected$0();
    }

    public void setTitle(String str) {
        this.title = str;
        setContentDescription(str);
        TooltipCompat.setTooltipText(this, str);
    }

    public void setUseAlternateBackground(boolean z) {
        this.useAlternateBackground = z;
    }

    public boolean shouldCloseSubmenuOnItemClick(ContextualToolbarMenuItem contextualToolbarMenuItem) {
        List<ContextualToolbarMenuItem> list = this.subMenuItems;
        return list == null || !list.contains(contextualToolbarMenuItem) || this.closeSubmenuOnSubmenuItemClick;
    }

    public boolean shouldDisplayOutsideOfSubmenuIfPossible() {
        return this.displayOutsideOfSubmenuIfPossible;
    }

    public boolean shouldOpenSubmenuOnClick() {
        return this.openSubmenuOnClick;
    }

    public void showColorIndicatorCircle(int i, float f) {
        Drawable drawable = this.icon;
        if (drawable == null) {
            this.showColorIndicatorCircle = false;
            return;
        }
        this.styleIndicatorDrawer.generateStyleIndicatorDrawables(i, this.iconColor, f, drawable.getIntrinsicHeight());
        this.showColorIndicatorCircle = true;
        lambda$setSelected$0();
    }

    private ContextualToolbarMenuItem(Context context, int i, Position position) {
        super(context);
        this.position = Position.END;
        this.openSubmenuOnClick = true;
        this.closeSubmenuOnSubmenuItemClick = true;
        this.useAlternateBackground = false;
        this.useTint = true;
        this.isSelected = false;
        this.submenuIndicatorPaint = new Paint();
        this.submenuIndicatorPosition = SubmenuIndicatorPosition.NONE;
        this.displayOutsideOfSubmenuIfPossible = false;
        this.showColorIndicatorCircle = false;
        this.styleIndicatorDrawer = new StyleCircleIndicatorIconDrawer();
        setId(i);
        this.position = position;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.selectableItemBackgroundBorderless});
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        ViewCompat.setBackground(this, drawable);
        setScaleType(ImageView.ScaleType.CENTER);
    }
}
