package expo.modules.ui;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\tJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001e\u0010\u0003\u001a\u00028\u00008\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lexpo/modules/ui/GenericEventPayload1;", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/records/Record;", "value", "<init>", "(Ljava/lang/Object;)V", "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Object;)Lexpo/modules/ui/GenericEventPayload1;", "equals", "", "other", "", "hashCode", "", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class GenericEventPayload1<T> implements Record {
    public static final int $stable = 0;
    private final T value;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GenericEventPayload1 copy$default(GenericEventPayload1 genericEventPayload1, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = genericEventPayload1.value;
        }
        return genericEventPayload1.copy(obj);
    }

    @Field
    public static /* synthetic */ void getValue$annotations() {
    }

    public final T component1() {
        return this.value;
    }

    public final GenericEventPayload1<T> copy(T value) {
        return new GenericEventPayload1<>(value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GenericEventPayload1) && Intrinsics.areEqual(this.value, ((GenericEventPayload1) other).value);
    }

    public int hashCode() {
        T t = this.value;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    public String toString() {
        return "GenericEventPayload1(value=" + this.value + ")";
    }

    public GenericEventPayload1(T t) {
        this.value = t;
    }

    public final T getValue() {
        return this.value;
    }
}
