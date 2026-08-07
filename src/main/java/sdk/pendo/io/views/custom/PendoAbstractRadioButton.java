package sdk.pendo.io.views.custom;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.box.android.domain.metrics.hubs.HubsObservability;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.i0.a;
import sdk.pendo.io.i0.b;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.e1;
import sdk.pendo.io.s7.p;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 i2\u00020\u00012\u00020\u0002:\u0001iB\u0013\b\u0016\u0012\b\u0010a\u001a\u0004\u0018\u00010`¢\u0006\u0004\bb\u0010cB\u001d\b\u0016\u0012\b\u0010a\u001a\u0004\u0018\u00010`\u0012\b\u0010e\u001a\u0004\u0018\u00010d¢\u0006\u0004\bb\u0010fB%\b\u0016\u0012\b\u0010a\u001a\u0004\u0018\u00010`\u0012\b\u0010e\u001a\u0004\u0018\u00010d\u0012\u0006\u0010g\u001a\u00020\b¢\u0006\u0004\bb\u0010hJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\bH\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\bH\u0016J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\bH\u0016J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\bH\u0016J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J&\u0010+\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\bR\u0014\u0010,\u001a\u00020\u00148\u0002X\u0082D¢\u0006\u0006\n\u0004\b,\u0010-R$\u0010\u001d\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001d\u0010/\u001a\u0004\b0\u00101R$\u00102\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b2\u0010/\u001a\u0004\b3\u00101R(\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010.\u001a\u0004\u0018\u00010\u001a8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001b\u00104\u001a\u0004\b5\u00106R$\u0010\u001f\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001f\u00107\u001a\u0004\b8\u00109R$\u0010:\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b:\u00107\u001a\u0004\b;\u00109R$\u0010!\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b8\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\b!\u00107\u001a\u0004\b<\u00109R$\u0010=\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b8\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\b=\u00107\u001a\u0004\b>\u00109R$\u0010?\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b8\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\b?\u00107\u001a\u0004\b@\u00109R$\u0010A\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b8\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\bA\u00107\u001a\u0004\bB\u00109R$\u0010C\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b8\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\bC\u00107\u001a\u0004\bD\u00109R$\u0010E\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b8\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\bE\u00107\u001a\u0004\bF\u00109R$\u0010G\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bG\u0010/\u001a\u0004\bH\u00101R$\u0010I\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bI\u0010/\u001a\u0004\bJ\u00101R$\u0010K\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b8\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\bK\u00107\u001a\u0004\bL\u00109R$\u0010M\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b8\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\bM\u00107\u001a\u0004\bN\u00109R$\u0010O\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u00148\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bO\u0010-\u001a\u0004\bP\u0010QR$\u0010R\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u00148\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bR\u0010-\u001a\u0004\bS\u0010QR$\u0010(\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b(\u00107\u001a\u0004\bT\u00109R$\u0010U\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bU\u00107\u001a\u0004\bV\u00109R\u001e\u0010Z\u001a\u0004\u0018\u00010\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\bW\u0010Q\"\u0004\bX\u0010YR\u001c\u0010\\\u001a\u00020[8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_¨\u0006j"}, d2 = {"Lsdk/pendo/io/views/custom/PendoAbstractRadioButton;", "Landroidx/appcompat/widget/AppCompatRadioButton;", "Lsdk/pendo/io/views/custom/PendoCheckableCustomView;", "", "init", "Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "", "color", "setDefaultBackgroundColor", "setCheckedBackgroundColor", "setDefaultTextColor", "setCheckedTextColor", "setSelectedIconColor", "", "size", "setDefaultTextSize", "setSelectedTextSize", "setUnselectedIconColor", "", HubsObservability.HUB_ASSET_ICON, "setSelectedIcon", "setUnselectedIcon", "setIconSize", "setSelectedIconSize", "", "cornerRadii", "setCornerRadii", "cornerRadius", "setCornerRadius", "strokeWidth", "setStrokeWidth", "strokeColor", "setStrokeColor", "setSelectedStrokeWidth", "setSelectedStrokeColor", "setSelectedCornerRadius", "Lsdk/pendo/io/i0/a;", "defaultIcon", "iconSize", "iconColor", "Lsdk/pendo/io/i0/b;", "getIconDrawable", "TAG", "Ljava/lang/String;", "<set-?>", "F", "getCornerRadius", "()F", "selectedCornerRadius", "getSelectedCornerRadius", "[F", "getCornerRadii", "()[F", "I", "getStrokeWidth", "()I", "selectedStrokeWidth", "getSelectedStrokeWidth", "getStrokeColor", "selectedStrokeColor", "getSelectedStrokeColor", "defaultBackgroundColor", "getDefaultBackgroundColor", "checkedBackgroundColor", "getCheckedBackgroundColor", "defaultTextColor", "getDefaultTextColor", "checkedTextColor", "getCheckedTextColor", "defaultTextSize", "getDefaultTextSize", "selectedTextSize", "getSelectedTextSize", "selectedIconColor", "getSelectedIconColor", "unselectedIconColor", "getUnselectedIconColor", "selectedIcon", "getSelectedIcon", "()Ljava/lang/String;", "unselectedIcon", "getUnselectedIcon", "getIconSize", "selectedIconSize", "getSelectedIconSize", "getResponseId", "setResponseId", "(Ljava/lang/String;)V", "responseId", "", "isRtl", "()Z", "setRtl", "(Z)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public abstract class PendoAbstractRadioButton extends AppCompatRadioButton implements PendoCheckableCustomView {
    public static final String ICON_NONE = "none";
    private final String TAG;
    private int checkedBackgroundColor;
    private int checkedTextColor;
    private float[] cornerRadii;
    private float cornerRadius;
    private int defaultBackgroundColor;
    private int defaultTextColor;
    private float defaultTextSize;
    private int iconSize;
    private float selectedCornerRadius;
    private String selectedIcon;
    private int selectedIconColor;
    private int selectedIconSize;
    private int selectedStrokeColor;
    private int selectedStrokeWidth;
    private float selectedTextSize;
    private int strokeColor;
    private int strokeWidth;
    private String unselectedIcon;
    private int unselectedIconColor;

    public PendoAbstractRadioButton(Context context) {
        super(context);
        this.TAG = "PendoAbstractRadioButton";
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

    public final b getIconDrawable(String icon, a defaultIcon, int iconSize, int iconColor) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(defaultIcon, "defaultIcon");
        a aVarA = p.a(p.a(icon), defaultIcon);
        Context context = getContext();
        if (aVarA != null) {
            defaultIcon = aVarA;
        }
        b bVarA = p.a(context, iconSize, iconColor, defaultIcon);
        Intrinsics.checkNotNullExpressionValue(bVarA, "createIconDrawable(...)");
        return bVarA;
    }

    public final int getIconSize() {
        return this.iconSize;
    }

    public abstract String getResponseId();

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

    public abstract boolean isRtl();

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        try {
            try {
                super.onRestoreInstanceState(state);
            } catch (Exception e) {
                PendoLogger.e(e, this.TAG + " - Pendo Radio Button state may not be correct as a result of onRestoreInstanceState error", new Object[0]);
            }
        } catch (Exception unused) {
            super.onRestoreInstanceState(onSaveInstanceState());
        }
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

    public abstract void setResponseId(String str);

    public abstract void setRtl(boolean z);

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

    public PendoAbstractRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "PendoAbstractRadioButton";
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

    public PendoAbstractRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "PendoAbstractRadioButton";
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
