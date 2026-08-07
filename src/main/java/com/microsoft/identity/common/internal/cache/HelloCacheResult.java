package com.microsoft.identity.common.internal.cache;

import com.microsoft.identity.common.logging.Logger;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: HelloCacheResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\r\u0010\u0011\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/microsoft/identity/common/internal/cache/HelloCacheResult;", "", "negotiatedProtocolVersion", "", "error", "timeStamp", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "getError", "()Ljava/lang/String;", "getNegotiatedProtocolVersion", "getTimeStamp$common_distRelease", "()J", "isError", "", "isHandShakeError", "isSuccess", "serialize", "serialize$common_distRelease", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HelloCacheResult {
    private static final String ERROR_CACHE_VALUE_FORMAT = "E,%s,%d";
    private static final String ERROR_PREFIX = "E";
    private static final String HANDSHAKE_ERROR = "handshake_error";
    private static final String SEPARATOR = ",";
    private static final String SUCCESS_CACHE_VALUE_FORMAT = "S,%s,%d";
    private static final String SUCCESS_PREFIX = "S";
    private final String error;
    private final String negotiatedProtocolVersion;
    private final long timeStamp;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "HelloCacheResult";

    public HelloCacheResult(String str, String str2, long j) {
        this.negotiatedProtocolVersion = str;
        this.error = str2;
        this.timeStamp = j;
        String str3 = str;
        String str4 = str2;
        if (!((str4 == null || str4.length() == 0) ^ (str3 == null || str3.length() == 0))) {
            throw new IllegalStateException("Either both parameters provided or none provided.");
        }
    }

    public final String getNegotiatedProtocolVersion() {
        return this.negotiatedProtocolVersion;
    }

    public final String getError() {
        return this.error;
    }

    /* JADX INFO: renamed from: getTimeStamp$common_distRelease, reason: from getter */
    public final long getTimeStamp() {
        return this.timeStamp;
    }

    /* JADX INFO: compiled from: HelloCacheResult.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0015\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0013J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\r\u0010\u0014\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0015J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0017\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/microsoft/identity/common/internal/cache/HelloCacheResult$Companion;", "", "()V", "ERROR_CACHE_VALUE_FORMAT", "", "ERROR_PREFIX", "HANDSHAKE_ERROR", "SEPARATOR", "SUCCESS_CACHE_VALUE_FORMAT", "SUCCESS_PREFIX", "TAG", "kotlin.jvm.PlatformType", "createError", "Lcom/microsoft/identity/common/internal/cache/HelloCacheResult;", "error", "timeStamp", "", "createFromNegotiatedProtocolVersion", "negotiatedProtocolVersion", "createFromNegotiatedProtocolVersion$common_distRelease", "createHandshakeError", "createHandshakeError$common_distRelease", "deserialize", "value", "deserialize$common_distRelease", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HelloCacheResult deserialize$common_distRelease(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            String str = HelloCacheResult.TAG + ":deserialize";
            List listSplit$default = StringsKt.split$default((CharSequence) value, new String[]{","}, false, 0, 6, (Object) null);
            if (listSplit$default.size() != 3) {
                Logger.warn(str, "Legacy or Invalid cache entry. " + value);
                return null;
            }
            try {
                long j = Long.parseLong((String) listSplit$default.get(2));
                if (Intrinsics.areEqual(listSplit$default.get(0), "E")) {
                    return createError((String) listSplit$default.get(1), j);
                }
                return createFromNegotiatedProtocolVersion((String) listSplit$default.get(1), j);
            } catch (NumberFormatException e) {
                Logger.error(str, "Invalid cache entry. " + value, e);
                return null;
            }
        }

        public final HelloCacheResult createFromNegotiatedProtocolVersion$common_distRelease(String negotiatedProtocolVersion) {
            Intrinsics.checkNotNullParameter(negotiatedProtocolVersion, "negotiatedProtocolVersion");
            return createFromNegotiatedProtocolVersion(negotiatedProtocolVersion, System.currentTimeMillis());
        }

        public final HelloCacheResult createHandshakeError$common_distRelease() {
            return createError(HelloCacheResult.HANDSHAKE_ERROR, System.currentTimeMillis());
        }

        private final HelloCacheResult createFromNegotiatedProtocolVersion(String negotiatedProtocolVersion, long timeStamp) {
            return new HelloCacheResult(negotiatedProtocolVersion, null, timeStamp);
        }

        private final HelloCacheResult createError(String error, long timeStamp) {
            return new HelloCacheResult(null, error, timeStamp);
        }
    }

    public final boolean isHandShakeError() {
        return isError() && Intrinsics.areEqual(this.error, HANDSHAKE_ERROR);
    }

    public final boolean isSuccess() {
        String str = this.negotiatedProtocolVersion;
        return !(str == null || str.length() == 0);
    }

    public final boolean isError() {
        String str = this.error;
        return !(str == null || str.length() == 0);
    }

    public final String serialize$common_distRelease() {
        String str = this.error;
        if (str != null && str.length() != 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str2 = String.format(ERROR_CACHE_VALUE_FORMAT, Arrays.copyOf(new Object[]{this.error, Long.valueOf(this.timeStamp)}, 2));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            return str2;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String str3 = String.format(SUCCESS_CACHE_VALUE_FORMAT, Arrays.copyOf(new Object[]{this.negotiatedProtocolVersion, Long.valueOf(this.timeStamp)}, 2));
        Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
        return str3;
    }
}
