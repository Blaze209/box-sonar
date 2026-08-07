package io.opentelemetry.sdk.trace.data;

import io.opentelemetry.api.trace.StatusCode;

/* JADX INFO: loaded from: classes4.dex */
abstract class ImmutableStatusData implements StatusData {
    static final StatusData OK = createInternal(StatusCode.OK, "");
    static final StatusData UNSET = createInternal(StatusCode.UNSET, "");
    static final StatusData ERROR = createInternal(StatusCode.ERROR, "");

    ImmutableStatusData() {
    }

    /* JADX INFO: renamed from: io.opentelemetry.sdk.trace.data.ImmutableStatusData$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$opentelemetry$api$trace$StatusCode;

        static {
            int[] iArr = new int[StatusCode.values().length];
            $SwitchMap$io$opentelemetry$api$trace$StatusCode = iArr;
            try {
                iArr[StatusCode.UNSET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$trace$StatusCode[StatusCode.OK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$trace$StatusCode[StatusCode.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static StatusData create(StatusCode statusCode, String str) {
        if (str == null || str.isEmpty()) {
            int i = AnonymousClass1.$SwitchMap$io$opentelemetry$api$trace$StatusCode[statusCode.ordinal()];
            if (i == 1) {
                return StatusData.unset();
            }
            if (i == 2) {
                return StatusData.ok();
            }
            if (i == 3) {
                return StatusData.error();
            }
        }
        return createInternal(statusCode, str);
    }

    private static StatusData createInternal(StatusCode statusCode, String str) {
        return new AutoValue_ImmutableStatusData(statusCode, str);
    }
}
