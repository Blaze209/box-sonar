package expo.modules.kotlin.records.formatters;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ValueOrSkip.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0003\u0004\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/records/formatters/ValueOrSkip;", ExifInterface.GPS_DIRECTION_TRUE, "", "Value", "Skip", "Lexpo/modules/kotlin/records/formatters/ValueOrSkip$Skip;", "Lexpo/modules/kotlin/records/formatters/ValueOrSkip$Value;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ValueOrSkip<T> {

    /* JADX INFO: compiled from: ValueOrSkip.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lexpo/modules/kotlin/records/formatters/ValueOrSkip$Value;", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/records/formatters/ValueOrSkip;", "value", "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Object;)Lexpo/modules/kotlin/records/formatters/ValueOrSkip$Value;", "equals", "", "other", "", "hashCode", "", "toString", "", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Value<T> implements ValueOrSkip<T> {
        public static final int $stable = 0;
        private final T value;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Value copy$default(Value value, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = value.value;
            }
            return value.copy(obj);
        }

        public final T component1() {
            return this.value;
        }

        public final Value<T> copy(T value) {
            return new Value<>(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Value) && Intrinsics.areEqual(this.value, ((Value) other).value);
        }

        public int hashCode() {
            T t = this.value;
            if (t == null) {
                return 0;
            }
            return t.hashCode();
        }

        public String toString() {
            return "Value(value=" + this.value + ")";
        }

        public Value(T t) {
            this.value = t;
        }

        public final T getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: ValueOrSkip.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lexpo/modules/kotlin/records/formatters/ValueOrSkip$Skip;", "Lexpo/modules/kotlin/records/formatters/ValueOrSkip;", "", "<init>", "()V", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Skip implements ValueOrSkip {
        public static final int $stable = 0;
        public static final Skip INSTANCE = new Skip();

        private Skip() {
        }
    }
}
