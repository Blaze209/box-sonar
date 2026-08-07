package expo.modules.ui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModifierRegistry.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n¨\u0006\u0018"}, d2 = {"Lexpo/modules/ui/AnimateContentSizeParams;", "Lexpo/modules/kotlin/records/Record;", "dampingRatio", "", "stiffness", "<init>", "(FF)V", "getDampingRatio$annotations", "()V", "getDampingRatio", "()F", "getStiffness$annotations", "getStiffness", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AnimateContentSizeParams implements Record {
    public static final int $stable = 0;
    private final float dampingRatio;
    private final float stiffness;

    /* JADX WARN: Illegal instructions before constructor call */
    public AnimateContentSizeParams() {
        float f = 0.0f;
        this(f, f, 3, null);
    }

    public static /* synthetic */ AnimateContentSizeParams copy$default(AnimateContentSizeParams animateContentSizeParams, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = animateContentSizeParams.dampingRatio;
        }
        if ((i & 2) != 0) {
            f2 = animateContentSizeParams.stiffness;
        }
        return animateContentSizeParams.copy(f, f2);
    }

    @Field
    public static /* synthetic */ void getDampingRatio$annotations() {
    }

    @Field
    public static /* synthetic */ void getStiffness$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getStiffness() {
        return this.stiffness;
    }

    public final AnimateContentSizeParams copy(float dampingRatio, float stiffness) {
        return new AnimateContentSizeParams(dampingRatio, stiffness);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimateContentSizeParams)) {
            return false;
        }
        AnimateContentSizeParams animateContentSizeParams = (AnimateContentSizeParams) other;
        return Float.compare(this.dampingRatio, animateContentSizeParams.dampingRatio) == 0 && Float.compare(this.stiffness, animateContentSizeParams.stiffness) == 0;
    }

    public int hashCode() {
        return (Float.hashCode(this.dampingRatio) * 31) + Float.hashCode(this.stiffness);
    }

    public String toString() {
        return "AnimateContentSizeParams(dampingRatio=" + this.dampingRatio + ", stiffness=" + this.stiffness + ")";
    }

    public AnimateContentSizeParams(float f, float f2) {
        this.dampingRatio = f;
        this.stiffness = f2;
    }

    public /* synthetic */ AnimateContentSizeParams(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? 1500.0f : f2);
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getStiffness() {
        return this.stiffness;
    }
}
