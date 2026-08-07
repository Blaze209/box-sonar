package expo.modules.nativeelementsexpo.promptinput;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TriggerHandling.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lexpo/modules/nativeelementsexpo/promptinput/TriggerConfig;", "", FirebaseAnalytics.Param.CHARACTER, "", "maxRange", "", "<init>", "(CI)V", "getCharacter", "()C", "getMaxRange", "()I", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class TriggerConfig {
    public static final int $stable = 0;
    private final char character;
    private final int maxRange;

    public static /* synthetic */ TriggerConfig copy$default(TriggerConfig triggerConfig, char c, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            c = triggerConfig.character;
        }
        if ((i2 & 2) != 0) {
            i = triggerConfig.maxRange;
        }
        return triggerConfig.copy(c, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final char getCharacter() {
        return this.character;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMaxRange() {
        return this.maxRange;
    }

    public final TriggerConfig copy(char character, int maxRange) {
        return new TriggerConfig(character, maxRange);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TriggerConfig)) {
            return false;
        }
        TriggerConfig triggerConfig = (TriggerConfig) other;
        return this.character == triggerConfig.character && this.maxRange == triggerConfig.maxRange;
    }

    public int hashCode() {
        return (Character.hashCode(this.character) * 31) + Integer.hashCode(this.maxRange);
    }

    public String toString() {
        return "TriggerConfig(character=" + this.character + ", maxRange=" + this.maxRange + ")";
    }

    public TriggerConfig(char c, int i) {
        this.character = c;
        this.maxRange = i;
    }

    public /* synthetic */ TriggerConfig(char c, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(c, (i2 & 2) != 0 ? 100 : i);
    }

    public final char getCharacter() {
        return this.character;
    }

    public final int getMaxRange() {
        return this.maxRange;
    }
}
