package sdk.pendo.io.views.custom;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.box.android.domain.metrics.hubs.HubsObservability;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.i0.a;
import sdk.pendo.io.s7.e1;
import sdk.pendo.io.s7.p;
import sdk.pendo.io.z5.b;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001^B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ*\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u00105\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u00020CH\u0016J\u000e\u0010E\u001a\u00020C2\u0006\u0010F\u001a\u00020GJ\u0010\u0010H\u001a\u00020C2\u0006\u0010I\u001a\u00020\nH\u0016J\u0010\u0010J\u001a\u00020C2\u0006\u0010I\u001a\u00020\nH\u0016J\u0012\u0010K\u001a\u00020C2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010L\u001a\u00020C2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010M\u001a\u00020C2\u0006\u0010I\u001a\u00020\nH\u0016J\u0010\u0010N\u001a\u00020C2\u0006\u0010I\u001a\u00020\nH\u0016J\u0010\u0010O\u001a\u00020C2\u0006\u0010P\u001a\u00020\u0016H\u0016J\u0010\u0010Q\u001a\u00020C2\u0006\u0010P\u001a\u00020\nH\u0016J\u0010\u0010R\u001a\u00020C2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010S\u001a\u00020C2\u0006\u0010T\u001a\u00020&H\u0016J\u0010\u0010U\u001a\u00020C2\u0006\u0010I\u001a\u00020\nH\u0016J\u0010\u0010V\u001a\u00020C2\u0006\u0010P\u001a\u00020\nH\u0016J\u0010\u0010W\u001a\u00020C2\u0006\u00105\u001a\u00020\nH\u0016J\u0010\u0010X\u001a\u00020C2\u0006\u00107\u001a\u00020\nH\u0016J\u0010\u0010Y\u001a\u00020C2\u0006\u0010P\u001a\u00020\u0016H\u0016J\u0010\u0010Z\u001a\u00020C2\u0006\u00105\u001a\u00020\nH\u0016J\u0010\u0010[\u001a\u00020C2\u0006\u00107\u001a\u00020\nH\u0016J\u0010\u0010\\\u001a\u00020C2\u0006\u0010T\u001a\u00020&H\u0016J\u0010\u0010]\u001a\u00020C2\u0006\u0010I\u001a\u00020\nH\u0016R \u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n8\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n8\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n8\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000fR \u0010\u001c\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n8\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000fR\u001e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u001e\u0010 \u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000fR\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u001e\u0010'\u001a\u00020&2\u0006\u0010\f\u001a\u00020&@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R \u0010*\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n8\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u000fR\u0010\u0010,\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u000fR \u0010/\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n8\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u000fR\u001e\u00101\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u000fR\u001e\u00103\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0019R \u00105\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n8\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u000fR\u001e\u00107\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u000fR\u0010\u00109\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010:\u001a\u00020&2\u0006\u0010\f\u001a\u00020&@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010)R \u0010<\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n8\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u000fR\u0010\u0010>\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lsdk/pendo/io/views/custom/PendoCarouselIndicatorView;", "Landroid/view/View;", "Lsdk/pendo/io/views/custom/PendoCheckableCustomView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "checkedBackgroundColor", "getCheckedBackgroundColor", "()I", "checkedTextColor", "getCheckedTextColor", "", "cornerRadii", "getCornerRadii", "()[F", "", "cornerRadius", "getCornerRadius", "()F", "defaultBackgroundColor", "getDefaultBackgroundColor", "defaultTextColor", "getDefaultTextColor", "defaultTextSize", "getDefaultTextSize", "iconSize", "getIconSize", "selectedBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "selectedCornerRadius", "getSelectedCornerRadius", "", "selectedIcon", "getSelectedIcon", "()Ljava/lang/String;", "selectedIconColor", "getSelectedIconColor", "selectedIconDrawable", "selectedIconSize", "getSelectedIconSize", "selectedStrokeColor", "getSelectedStrokeColor", "selectedStrokeWidth", "getSelectedStrokeWidth", "selectedTextSize", "getSelectedTextSize", "strokeColor", "getStrokeColor", "strokeWidth", "getStrokeWidth", "unselectedBackgroundDrawable", "unselectedIcon", "getUnselectedIcon", "unselectedIconColor", "getUnselectedIconColor", "unselectedIconDrawable", "createDrawable", "Landroid/graphics/drawable/GradientDrawable;", "backgroundColor", "init", "", "renderView", "setChecked", "checked", "", "setCheckedBackgroundColor", "color", "setCheckedTextColor", "setCornerRadii", "setCornerRadius", "setDefaultBackgroundColor", "setDefaultTextColor", "setDefaultTextSize", "size", "setIconSize", "setSelectedCornerRadius", "setSelectedIcon", HubsObservability.HUB_ASSET_ICON, "setSelectedIconColor", "setSelectedIconSize", "setSelectedStrokeColor", "setSelectedStrokeWidth", "setSelectedTextSize", "setStrokeColor", "setStrokeWidth", "setUnselectedIcon", "setUnselectedIconColor", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PendoCarouselIndicatorView extends View implements PendoCheckableCustomView {
    private static final String ICON_NONE = "none";
    private int checkedBackgroundColor;
    private int checkedTextColor;
    private float[] cornerRadii;
    private float cornerRadius;
    private int defaultBackgroundColor;
    private int defaultTextColor;
    private float defaultTextSize;
    private int iconSize;
    private Drawable selectedBackgroundDrawable;
    private float selectedCornerRadius;
    private String selectedIcon;
    private int selectedIconColor;
    private Drawable selectedIconDrawable;
    private int selectedIconSize;
    private int selectedStrokeColor;
    private int selectedStrokeWidth;
    private float selectedTextSize;
    private int strokeColor;
    private int strokeWidth;
    private Drawable unselectedBackgroundDrawable;
    private String unselectedIcon;
    private int unselectedIconColor;
    private Drawable unselectedIconDrawable;
    private static final a DEFAULT_UNSELECTED_ICON = b.icon_circle_empty;
    private static final a DEFAULT_SELECTED_ICON = b.icon_circle;

    public PendoCarouselIndicatorView(Context context) {
        super(context);
        this.strokeColor = -1;
        this.selectedStrokeColor = -1;
        this.defaultBackgroundColor = -1;
        this.checkedBackgroundColor = -1;
        this.defaultTextColor = -16777216;
        this.checkedTextColor = -16777216;
        this.defaultTextSize = e1.b(16.0f);
        this.selectedTextSize = e1.b(16.0f);
        this.selectedIconColor = -16777216;
        this.unselectedIconColor = -16777216;
        this.selectedIcon = "none";
        this.unselectedIcon = "none";
        this.iconSize = e1.a(32.0f);
        this.selectedIconSize = e1.a(32.0f);
        init();
    }

    private final GradientDrawable createDrawable(int backgroundColor, int strokeWidth, int strokeColor, float cornerRadius) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(cornerRadius);
        gradientDrawable.setStroke(strokeWidth, strokeColor);
        gradientDrawable.setColor(backgroundColor);
        return gradientDrawable;
    }

    private final void init() {
    }

    public final int getCheckedBackgroundColor() {
        return this.checkedBackgroundColor;
    }

    public final int getCheckedTextColor() {
        return this.checkedTextColor;
    }

    public final float[] getCornerRadii() {
        return this.cornerRadii;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final int getDefaultBackgroundColor() {
        return this.defaultBackgroundColor;
    }

    public final int getDefaultTextColor() {
        return this.defaultTextColor;
    }

    public final float getDefaultTextSize() {
        return this.defaultTextSize;
    }

    public final int getIconSize() {
        return this.iconSize;
    }

    public final float getSelectedCornerRadius() {
        return this.selectedCornerRadius;
    }

    public final String getSelectedIcon() {
        return this.selectedIcon;
    }

    public final int getSelectedIconColor() {
        return this.selectedIconColor;
    }

    public final int getSelectedIconSize() {
        return this.selectedIconSize;
    }

    public final int getSelectedStrokeColor() {
        return this.selectedStrokeColor;
    }

    public final int getSelectedStrokeWidth() {
        return this.selectedStrokeWidth;
    }

    public final float getSelectedTextSize() {
        return this.selectedTextSize;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final int getStrokeWidth() {
        return this.strokeWidth;
    }

    public final String getUnselectedIcon() {
        return this.unselectedIcon;
    }

    public final int getUnselectedIconColor() {
        return this.unselectedIconColor;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void renderView() {
        if (Intrinsics.areEqual("none", this.unselectedIcon) || Intrinsics.areEqual("none", this.selectedIcon)) {
            this.unselectedBackgroundDrawable = createDrawable(this.defaultBackgroundColor, this.strokeWidth, this.strokeColor, this.cornerRadius);
            this.selectedBackgroundDrawable = createDrawable(this.checkedBackgroundColor, this.selectedStrokeWidth, this.selectedStrokeColor, this.selectedCornerRadius);
        } else {
            a aVarA = p.a(p.a(this.unselectedIcon), DEFAULT_UNSELECTED_ICON);
            Intrinsics.checkNotNull(aVarA);
            a aVarA2 = p.a(p.a(this.selectedIcon), DEFAULT_SELECTED_ICON);
            Intrinsics.checkNotNull(aVarA2);
            Context context = getContext();
            int height = getHeight();
            int i = this.unselectedIconColor;
            this.unselectedIconDrawable = p.a(context, height, i, Color.alpha(i), aVarA);
            Context context2 = getContext();
            int height2 = getHeight();
            int i2 = this.selectedIconColor;
            this.selectedIconDrawable = p.a(context2, height2, i2, Color.alpha(i2), aVarA2);
        }
        setChecked(false);
    }

    public final void setChecked(boolean checked) {
        Drawable drawable;
        if (checked) {
            drawable = this.selectedIconDrawable;
            if (drawable == null) {
                drawable = this.selectedBackgroundDrawable;
            }
        } else {
            drawable = this.unselectedIconDrawable;
            if (drawable == null) {
                drawable = this.unselectedBackgroundDrawable;
            }
        }
        setBackground(drawable);
    }

    @Override // sdk.pendo.io.views.custom.PendoCheckableCustomView
    public void setCheckedBackgroundColor(int color) {
        this.checkedBackgroundColor = color;
    }

    @Override // sdk.pendo.io.views.custom.PendoCheckableCustomView
    public void setCheckedTextColor(int color) {
        this.checkedTextColor = color;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setCornerRadii(float[] cornerRadii) {
        this.cornerRadii = cornerRadii;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setCornerRadius(float cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    @Override // sdk.pendo.io.views.custom.PendoCheckableCustomView
    public void setDefaultBackgroundColor(int color) {
        this.defaultBackgroundColor = color;
    }

    @Override // sdk.pendo.io.views.custom.PendoCheckableCustomView
    public void setDefaultTextColor(int color) {
        this.defaultTextColor = color;
    }

    @Override // sdk.pendo.io.views.custom.PendoCheckableCustomView
    public void setDefaultTextSize(float size) {
        this.defaultTextSize = size;
    }

    @Override // sdk.pendo.io.views.custom.PendoCheckableCustomView
    public void setIconSize(int size) {
        this.iconSize = size;
    }

    @Override // sdk.pendo.io.views.custom.PendoCheckableCustomView
    public void setSelectedCornerRadius(float cornerRadius) {
        this.selectedCornerRadius = cornerRadius;
    }

    @Override // sdk.pendo.io.views.custom.PendoCheckableCustomView
    public void setSelectedIcon(String icon) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.selectedIcon = icon;
    }

    @Override // sdk.pendo.io.views.custom.PendoCheckableCustomView
    public void setSelectedIconColor(int color) {
        this.selectedIconColor = color;
    }

    @Override // sdk.pendo.io.views.custom.PendoCheckableCustomView
    public void setSelectedIconSize(int size) {
        this.selectedIconSize = size;
    }

    @Override // sdk.pendo.io.views.custom.PendoCheckableCustomView
    public void setSelectedStrokeColor(int strokeColor) {
        this.selectedStrokeColor = strokeColor;
    }

    @Override // sdk.pendo.io.views.custom.PendoCheckableCustomView
    public void setSelectedStrokeWidth(int strokeWidth) {
        this.selectedStrokeWidth = strokeWidth;
    }

    @Override // sdk.pendo.io.views.custom.PendoCheckableCustomView
    public void setSelectedTextSize(float size) {
        this.selectedTextSize = size;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    @Override // sdk.pendo.io.views.custom.PendoCheckableCustomView
    public void setUnselectedIcon(String icon) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.unselectedIcon = icon;
    }

    @Override // sdk.pendo.io.views.custom.PendoCheckableCustomView
    public void setUnselectedIconColor(int color) {
        this.unselectedIconColor = color;
    }

    public PendoCarouselIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.strokeColor = -1;
        this.selectedStrokeColor = -1;
        this.defaultBackgroundColor = -1;
        this.checkedBackgroundColor = -1;
        this.defaultTextColor = -16777216;
        this.checkedTextColor = -16777216;
        this.defaultTextSize = e1.b(16.0f);
        this.selectedTextSize = e1.b(16.0f);
        this.selectedIconColor = -16777216;
        this.unselectedIconColor = -16777216;
        this.selectedIcon = "none";
        this.unselectedIcon = "none";
        this.iconSize = e1.a(32.0f);
        this.selectedIconSize = e1.a(32.0f);
        init();
    }

    public PendoCarouselIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.strokeColor = -1;
        this.selectedStrokeColor = -1;
        this.defaultBackgroundColor = -1;
        this.checkedBackgroundColor = -1;
        this.defaultTextColor = -16777216;
        this.checkedTextColor = -16777216;
        this.defaultTextSize = e1.b(16.0f);
        this.selectedTextSize = e1.b(16.0f);
        this.selectedIconColor = -16777216;
        this.unselectedIconColor = -16777216;
        this.selectedIcon = "none";
        this.unselectedIcon = "none";
        this.iconSize = e1.a(32.0f);
        this.selectedIconSize = e1.a(32.0f);
        init();
    }
}
