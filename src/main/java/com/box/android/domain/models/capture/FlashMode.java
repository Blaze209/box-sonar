package com.box.android.domain.models.capture;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import external.sdk.pendo.io.mozilla.javascript.ES6Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FlashMode.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\u0000J\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/models/capture/FlashMode;", "", "stringValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStringValue", "()Ljava/lang/String;", "AUTO", "ON", "OFF", ES6Iterator.NEXT_METHOD, "intValue", "", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum FlashMode {
    AUTO("auto"),
    ON("on"),
    OFF("off");

    private final String stringValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<FlashMode> getEntries() {
        return $ENTRIES;
    }

    FlashMode(String str) {
        this.stringValue = str;
    }

    public final String getStringValue() {
        return this.stringValue;
    }

    /* JADX INFO: compiled from: FlashMode.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/box/android/domain/models/capture/FlashMode$Companion;", "", "<init>", "()V", TypedValues.TransitionType.S_FROM, "Lcom/box/android/domain/models/capture/FlashMode;", "findValue", "", "ordinal", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:10:0x002c  */
        /* JADX WARN: Code duplicated, block: B:12:0x002f A[RETURN] */
        public final FlashMode from(String findValue) {
            Intrinsics.checkNotNullParameter(findValue, "findValue");
            for (FlashMode flashMode : FlashMode.values()) {
                String stringValue = flashMode.getStringValue();
                String lowerCase = findValue.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(stringValue, lowerCase)) {
                    if (flashMode == null) {
                        return FlashMode.AUTO;
                    }
                    return flashMode;
                }
            }
            flashMode = null;
            if (flashMode == null) {
                return FlashMode.AUTO;
            }
            return flashMode;
        }

        public final FlashMode from(int ordinal) {
            return FlashMode.values()[ordinal];
        }
    }

    public final FlashMode next() {
        FlashMode[] flashModeArrValues = values();
        return flashModeArrValues[(ordinal() + 1) % flashModeArrValues.length];
    }

    public final int intValue() {
        return ordinal();
    }
}
