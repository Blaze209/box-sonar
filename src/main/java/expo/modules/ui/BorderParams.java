package expo.modules.ui;

import android.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModifierRegistry.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lexpo/modules/ui/BorderParams;", "Lexpo/modules/kotlin/records/Record;", ViewProps.BORDER_WIDTH, "", ViewProps.BORDER_COLOR, "Landroid/graphics/Color;", "<init>", "(ILandroid/graphics/Color;)V", "getBorderWidth$annotations", "()V", "getBorderWidth", "()I", "getBorderColor$annotations", "getBorderColor", "()Landroid/graphics/Color;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class BorderParams implements Record {
    public static final int $stable = 8;
    private final Color borderColor;
    private final int borderWidth;

    /* JADX WARN: Multi-variable type inference failed */
    public BorderParams() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BorderParams copy$default(BorderParams borderParams, int i, Color color, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = borderParams.borderWidth;
        }
        if ((i2 & 2) != 0) {
            color = borderParams.borderColor;
        }
        return borderParams.copy(i, color);
    }

    @Field
    public static /* synthetic */ void getBorderColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getBorderWidth$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getBorderWidth() {
        return this.borderWidth;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Color getBorderColor() {
        return this.borderColor;
    }

    public final BorderParams copy(int borderWidth, Color borderColor) {
        return new BorderParams(borderWidth, borderColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BorderParams)) {
            return false;
        }
        BorderParams borderParams = (BorderParams) other;
        return this.borderWidth == borderParams.borderWidth && Intrinsics.areEqual(this.borderColor, borderParams.borderColor);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.borderWidth) * 31;
        Color color = this.borderColor;
        return iHashCode + (color == null ? 0 : color.hashCode());
    }

    public String toString() {
        return "BorderParams(borderWidth=" + this.borderWidth + ", borderColor=" + this.borderColor + ")";
    }

    public BorderParams(int i, Color color) {
        this.borderWidth = i;
        this.borderColor = color;
    }

    public /* synthetic */ BorderParams(int i, Color color, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i, (i2 & 2) != 0 ? null : color);
    }

    public final int getBorderWidth() {
        return this.borderWidth;
    }

    public final Color getBorderColor() {
        return this.borderColor;
    }
}
