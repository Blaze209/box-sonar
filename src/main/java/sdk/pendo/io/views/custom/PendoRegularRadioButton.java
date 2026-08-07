package sdk.pendo.io.views.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import com.box.android.domain.metrics.hubs.HubsObservability;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.R;
import sdk.pendo.io.i0.a;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.z5.b;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u0001:\u00016B\u0013\b\u0016\u0012\b\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100B\u001d\b\u0016\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u0012\b\u00102\u001a\u0004\u0018\u000101¢\u0006\u0004\b/\u00103B%\b\u0016\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u0012\b\u00102\u001a\u0004\u0018\u000101\u0012\u0006\u00104\u001a\u00020\f¢\u0006\u0004\b/\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J*\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\fR$\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R\u0016\u0010\u0018\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010%¨\u00067"}, d2 = {"Lsdk/pendo/io/views/custom/PendoRegularRadioButton;", "Lsdk/pendo/io/views/custom/PendoAbstractRadioButton;", "", "init", "setPaddingDependOnGravityAndDirection", "", "checked", "setButtonViewAppearance", "", HubsObservability.HUB_ASSET_ICON, "Lsdk/pendo/io/i0/a;", "defaultIcon", "", "iconSize", "iconColor", "Lsdk/pendo/io/views/custom/MarginDrawable;", "createIconDrawable", "Landroid/graphics/Canvas;", "canvas", "onDraw", "gravity", "setGravity", "setChecked", "renderView", "paddingBetween", "setPaddingBetween", "responseId", "Ljava/lang/String;", "getResponseId", "()Ljava/lang/String;", "setResponseId", "(Ljava/lang/String;)V", "isRtl", "Z", "()Z", "setRtl", "(Z)V", "I", "selectedDrawable", "Lsdk/pendo/io/views/custom/MarginDrawable;", "unSelectedDrawable", "Landroid/graphics/drawable/GradientDrawable;", "backgroundDrawable", "Landroid/graphics/drawable/GradientDrawable;", "buttonGravity", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class PendoRegularRadioButton extends PendoAbstractRadioButton {
    private static final a DEFAULT_SELECTED_ICON = b.icon_dot_circled;
    private static final a DEFAULT_UNSELECTED_ICON = b.icon_circle_empty;
    private GradientDrawable backgroundDrawable;
    private int buttonGravity;
    private boolean isRtl;
    private int paddingBetween;
    private String responseId;
    private MarginDrawable selectedDrawable;
    private MarginDrawable unSelectedDrawable;

    public PendoRegularRadioButton(Context context) {
        super(context);
        this.buttonGravity = 17;
        init();
    }

    private final MarginDrawable createIconDrawable(String icon, a defaultIcon, int iconSize, int iconColor) {
        return new MarginDrawable.Builder(getIconDrawable(icon, defaultIcon, iconSize, iconColor)).setTopMargin(getPaddingTop()).setBottomMargin(getPaddingBottom()).setLeftMargin(getIsRtl() ? this.paddingBetween : getPaddingLeft()).setRightMargin(getIsRtl() ? getPaddingLeft() : this.paddingBetween).build();
    }

    private final void init() {
        setGravity(this.buttonGravity);
        setClickable(true);
        setButtonDrawable((Drawable) null);
        setContentDescription(getContext().getString(R.string.pnd_radio_button_accessibility_description));
    }

    private final void setButtonViewAppearance(boolean checked) {
        float defaultTextSize;
        try {
            if (checked) {
                GradientDrawable gradientDrawable = this.backgroundDrawable;
                if (gradientDrawable != null) {
                    gradientDrawable.setColor(getCheckedBackgroundColor());
                }
                setTextColor(getCheckedTextColor());
                defaultTextSize = getSelectedTextSize();
            } else {
                GradientDrawable gradientDrawable2 = this.backgroundDrawable;
                if (gradientDrawable2 != null) {
                    gradientDrawable2.setColor(getDefaultBackgroundColor());
                }
                setTextColor(getDefaultTextColor());
                defaultTextSize = getDefaultTextSize();
            }
            setTextSize(2, defaultTextSize);
            setBackground(this.backgroundDrawable);
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
    }

    private final void setPaddingDependOnGravityAndDirection() {
        if (this.buttonGravity == 17) {
            setPaddingRelative(0, getPaddingTop(), 0, getPaddingBottom());
        } else {
            MarginDrawable marginDrawable = this.selectedDrawable;
            setPaddingRelative(marginDrawable != null ? marginDrawable.getIntrinsicWidth() : getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    @Override // sdk.pendo.io.views.custom.PendoAbstractRadioButton
    public String getResponseId() {
        return this.responseId;
    }

    @Override // sdk.pendo.io.views.custom.PendoAbstractRadioButton
    /* JADX INFO: renamed from: isRtl, reason: from getter */
    public boolean getIsRtl() {
        return this.isRtl;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        MarginDrawable marginDrawable = isChecked() ? this.selectedDrawable : this.unSelectedDrawable;
        if (marginDrawable != null) {
            int intrinsicHeight = marginDrawable.getIntrinsicHeight();
            int intrinsicWidth = marginDrawable.getIntrinsicWidth();
            int height = (getHeight() - intrinsicHeight) / 2;
            int i = intrinsicHeight + height;
            if (getIsRtl()) {
                width = getWidth() - intrinsicWidth;
                intrinsicWidth = getWidth();
            } else {
                width = 0;
            }
            marginDrawable.setBounds(width, height, intrinsicWidth, i);
            marginDrawable.draw(canvas);
        }
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void renderView() {
        if (!Intrinsics.areEqual("none", getUnselectedIcon()) && !Intrinsics.areEqual("none", getSelectedIcon())) {
            this.selectedDrawable = createIconDrawable(getSelectedIcon(), DEFAULT_SELECTED_ICON, getSelectedIconSize(), getSelectedIconColor());
            this.unSelectedDrawable = createIconDrawable(getUnselectedIcon(), DEFAULT_UNSELECTED_ICON, getIconSize(), getUnselectedIconColor());
            setPaddingDependOnGravityAndDirection();
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.backgroundDrawable = gradientDrawable;
        gradientDrawable.setStroke(getStrokeWidth(), getStrokeColor());
        if (getCornerRadii() != null) {
            gradientDrawable.setCornerRadii(getCornerRadii());
        } else {
            gradientDrawable.setCornerRadius(getCornerRadius());
        }
        setButtonViewAppearance(isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean checked) {
        setButtonViewAppearance(checked);
        super.setChecked(checked);
    }

    @Override // android.widget.TextView
    public void setGravity(int gravity) {
        this.buttonGravity = gravity;
        super.setGravity(gravity);
    }

    public final void setPaddingBetween(int paddingBetween) {
        this.paddingBetween = paddingBetween;
    }

    @Override // sdk.pendo.io.views.custom.PendoAbstractRadioButton
    public void setResponseId(String str) {
        this.responseId = str;
    }

    @Override // sdk.pendo.io.views.custom.PendoAbstractRadioButton
    public void setRtl(boolean z) {
        this.isRtl = z;
    }

    public PendoRegularRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.buttonGravity = 17;
        init();
    }

    public PendoRegularRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.buttonGravity = 17;
        init();
    }
}
