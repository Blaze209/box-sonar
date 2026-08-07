package com.box.android.domain.models.observability;

import androidx.exifinterface.media.ExifInterface;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DiagnosisModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/box/android/domain/models/observability/DiagnosisMode;", "", "<init>", "(Ljava/lang/String;I)V", "INFO", "DEBUG", "VERBOSE", "Util", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum DiagnosisMode {
    INFO,
    DEBUG,
    VERBOSE;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<DiagnosisMode> getEntries() {
        return $ENTRIES;
    }

    /* JADX INFO: compiled from: DiagnosisModel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/domain/models/observability/DiagnosisMode$Util;", "", "<init>", "()V", "getMode", "Lcom/box/android/domain/models/observability/DiagnosisMode;", "input", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Util {
        public static final Util INSTANCE = new Util();

        private Util() {
        }

        @JvmStatic
        public static final DiagnosisMode getMode(char input) {
            String strValueOf = String.valueOf(input);
            Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            if (Intrinsics.areEqual(upperCase, "D")) {
                return DiagnosisMode.DEBUG;
            }
            return Intrinsics.areEqual(upperCase, ExifInterface.GPS_MEASUREMENT_INTERRUPTED) ? DiagnosisMode.VERBOSE : DiagnosisMode.INFO;
        }
    }
}
