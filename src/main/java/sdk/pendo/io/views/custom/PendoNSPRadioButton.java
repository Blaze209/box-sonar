package sdk.pendo.io.views.custom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.i0.a;
import sdk.pendo.io.s7.p;
import sdk.pendo.io.z5.b;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001'B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ*\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0016J\u0010\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\fH\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lsdk/pendo/io/views/custom/PendoNSPRadioButton;", "Lsdk/pendo/io/views/custom/PendoAbstractRadioButton;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isRtl", "", "()Z", "setRtl", "(Z)V", "responseId", "", "getResponseId", "()Ljava/lang/String;", "setResponseId", "(Ljava/lang/String;)V", "selectedBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "selectedIconDrawable", "unselectedBackgroundDrawable", "unselectedIconDrawable", "createDrawable", "Landroid/graphics/drawable/GradientDrawable;", "backgroundColor", "strokeWidth", "strokeColor", "cornerRadius", "", "init", "", "renderView", "setChecked", "checked", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PendoNSPRadioButton extends PendoAbstractRadioButton {
    private static final a DEFAULT_ICON = b.icon_star;
    private static final String ICON_NONE = "none";
    private boolean isRtl;
    private String responseId;
    private Drawable selectedBackgroundDrawable;
    private Drawable selectedIconDrawable;
    private Drawable unselectedBackgroundDrawable;
    private Drawable unselectedIconDrawable;

    public PendoNSPRadioButton(Context context) {
        super(context);
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
        setGravity(17);
        setClickable(true);
        setButtonDrawable((Drawable) null);
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

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void renderView() {
        if (Intrinsics.areEqual("none", getUnselectedIcon()) || Intrinsics.areEqual("none", getSelectedIcon())) {
            this.unselectedBackgroundDrawable = createDrawable(getDefaultBackgroundColor(), getStrokeWidth(), getStrokeColor(), getCornerRadius());
            this.selectedBackgroundDrawable = createDrawable(getCheckedBackgroundColor(), getSelectedStrokeWidth(), getSelectedStrokeColor(), getSelectedCornerRadius());
        } else {
            char cA = p.a(getUnselectedIcon());
            a aVar = DEFAULT_ICON;
            a aVarA = p.a(cA, aVar);
            a aVarA2 = p.a(p.a(getSelectedIcon()), aVar);
            Context context = getContext();
            int height = getHeight();
            int unselectedIconColor = getUnselectedIconColor();
            if (aVarA == null) {
                aVarA = aVar;
            }
            this.unselectedIconDrawable = p.a(context, height, unselectedIconColor, aVarA);
            Context context2 = getContext();
            int height2 = getHeight();
            int selectedIconColor = getSelectedIconColor();
            if (aVarA2 != null) {
                aVar = aVarA2;
            }
            this.selectedIconDrawable = p.a(context2, height2, selectedIconColor, aVar);
        }
        setTextSize(2, getDefaultTextSize());
        setChecked(false);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean checked) {
        int defaultTextColor;
        if (checked) {
            Drawable drawable = this.selectedIconDrawable;
            if (drawable == null) {
                drawable = this.selectedBackgroundDrawable;
            }
            setBackground(drawable);
            defaultTextColor = getCheckedTextColor();
        } else {
            Drawable drawable2 = this.unselectedIconDrawable;
            if (drawable2 == null) {
                drawable2 = this.unselectedBackgroundDrawable;
            }
            setBackground(drawable2);
            defaultTextColor = getDefaultTextColor();
        }
        setTextColor(defaultTextColor);
        super.setChecked(checked);
    }

    @Override // sdk.pendo.io.views.custom.PendoAbstractRadioButton
    public void setResponseId(String str) {
        this.responseId = str;
    }

    @Override // sdk.pendo.io.views.custom.PendoAbstractRadioButton
    public void setRtl(boolean z) {
        this.isRtl = z;
    }

    public PendoNSPRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PendoNSPRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
