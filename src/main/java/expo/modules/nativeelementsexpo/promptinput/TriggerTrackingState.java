package expo.modules.nativeelementsexpo.promptinput;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TriggerHandling.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/nativeelementsexpo/promptinput/TriggerTrackingState;", "", "<init>", "()V", "Idle", "Tracking", "Lexpo/modules/nativeelementsexpo/promptinput/TriggerTrackingState$Idle;", "Lexpo/modules/nativeelementsexpo/promptinput/TriggerTrackingState$Tracking;", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class TriggerTrackingState {
    public static final int $stable = 0;

    public /* synthetic */ TriggerTrackingState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: TriggerHandling.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/nativeelementsexpo/promptinput/TriggerTrackingState$Idle;", "Lexpo/modules/nativeelementsexpo/promptinput/TriggerTrackingState;", "<init>", "()V", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Idle extends TriggerTrackingState {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super(null);
        }
    }

    private TriggerTrackingState() {
    }

    /* JADX INFO: compiled from: TriggerHandling.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lexpo/modules/nativeelementsexpo/promptinput/TriggerTrackingState$Tracking;", "Lexpo/modules/nativeelementsexpo/promptinput/TriggerTrackingState;", "trigger", "", "anchorOffset", "", "<init>", "(CI)V", "getTrigger", "()C", "getAnchorOffset", "()I", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Tracking extends TriggerTrackingState {
        public static final int $stable = 0;
        private final int anchorOffset;
        private final char trigger;

        public static /* synthetic */ Tracking copy$default(Tracking tracking, char c, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                c = tracking.trigger;
            }
            if ((i2 & 2) != 0) {
                i = tracking.anchorOffset;
            }
            return tracking.copy(c, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final char getTrigger() {
            return this.trigger;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getAnchorOffset() {
            return this.anchorOffset;
        }

        public final Tracking copy(char trigger, int anchorOffset) {
            return new Tracking(trigger, anchorOffset);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Tracking)) {
                return false;
            }
            Tracking tracking = (Tracking) other;
            return this.trigger == tracking.trigger && this.anchorOffset == tracking.anchorOffset;
        }

        public int hashCode() {
            return (Character.hashCode(this.trigger) * 31) + Integer.hashCode(this.anchorOffset);
        }

        public String toString() {
            return "Tracking(trigger=" + this.trigger + ", anchorOffset=" + this.anchorOffset + ")";
        }

        public Tracking(char c, int i) {
            super(null);
            this.trigger = c;
            this.anchorOffset = i;
        }

        public final int getAnchorOffset() {
            return this.anchorOffset;
        }

        public final char getTrigger() {
            return this.trigger;
        }
    }
}
