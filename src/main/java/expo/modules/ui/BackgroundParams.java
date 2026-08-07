package expo.modules.ui;

import android.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModifierRegistry.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lexpo/modules/ui/BackgroundParams;", "Lexpo/modules/kotlin/records/Record;", "color", "Landroid/graphics/Color;", "<init>", "(Landroid/graphics/Color;)V", "getColor$annotations", "()V", "getColor", "()Landroid/graphics/Color;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class BackgroundParams implements Record {
    public static final int $stable = 8;
    private final Color color;

    /* JADX WARN: Multi-variable type inference failed */
    public BackgroundParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BackgroundParams copy$default(BackgroundParams backgroundParams, Color color, int i, Object obj) {
        if ((i & 1) != 0) {
            color = backgroundParams.color;
        }
        return backgroundParams.copy(color);
    }

    @Field
    public static /* synthetic */ void getColor$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    public final BackgroundParams copy(Color color) {
        return new BackgroundParams(color);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BackgroundParams) && Intrinsics.areEqual(this.color, ((BackgroundParams) other).color);
    }

    public int hashCode() {
        Color color = this.color;
        if (color == null) {
            return 0;
        }
        return color.hashCode();
    }

    public String toString() {
        return "BackgroundParams(color=" + this.color + ")";
    }

    public BackgroundParams(Color color) {
        this.color = color;
    }

    public /* synthetic */ BackgroundParams(Color color, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : color);
    }

    public final Color getColor() {
        return this.color;
    }
}
