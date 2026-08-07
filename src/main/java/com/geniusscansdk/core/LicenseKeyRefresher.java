package com.geniusscansdk.core;

import android.content.Context;
import android.os.Build;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.geniusscansdk.BuildConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LicenseKeyRefresher.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001a\u001b\u001cB3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003J&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/geniusscansdk/core/LicenseKeyRefresher;", "", RemoteConfigConstants.RequestFieldKey.APP_VERSION, "", "osVersion", "storage", "Lcom/geniusscansdk/core/LicenseKeyStorage;", "api", "Lcom/geniusscansdk/core/LicenseKeyApi;", "logger", "Lcom/geniusscansdk/core/Logger;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/geniusscansdk/core/LicenseKeyStorage;Lcom/geniusscansdk/core/LicenseKeyApi;Lcom/geniusscansdk/core/Logger;)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getCachedLicenseKey", "refresh", "Lkotlin/Result;", "licenseKey", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "Lcom/geniusscansdk/core/LicenseKeyRefresher$LicenseKeyRefreshReason;", "refresh-0E7RQCE", "(Ljava/lang/String;Lcom/geniusscansdk/core/LicenseKeyRefresher$LicenseKeyRefreshReason;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildParams", "Lcom/geniusscansdk/core/LicenseKeyApi$QueryParams;", "LicenseKeyRefreshReason", "TimestampedKey", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class LicenseKeyRefresher {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] RETRYABLE_ERROR_CODES = {408, 429, 502, 503, 504};
    private final LicenseKeyApi api;
    private final String appVersion;
    private final Logger logger;
    private final String osVersion;
    private final LicenseKeyStorage storage;

    public LicenseKeyRefresher(String str, String osVersion, LicenseKeyStorage storage, LicenseKeyApi api, Logger logger) {
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.appVersion = str;
        this.osVersion = osVersion;
        this.storage = storage;
        this.api = api;
        this.logger = logger;
    }

    public /* synthetic */ LicenseKeyRefresher(String str, String str2, LicenseKeyStorage licenseKeyStorage, LicenseKeyApi licenseKeyApi, Logger logger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, licenseKeyStorage, licenseKeyApi, (i & 16) != 0 ? GeniusScanSDK.getLogger() : logger);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LicenseKeyRefresher(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String appVersion = INSTANCE.getAppVersion(context);
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        this(appVersion, RELEASE, new LicenseKeyStorage(context), new LicenseKeyApi(context), null, 16, null);
    }

    /* JADX INFO: compiled from: LicenseKeyRefresher.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/geniusscansdk/core/LicenseKeyRefresher$LicenseKeyRefreshReason;", "", "apiValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getApiValue", "()Ljava/lang/String;", "INITIALIZATION", "SCAN_FLOW", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum LicenseKeyRefreshReason {
        INITIALIZATION("init"),
        SCAN_FLOW("scan_flow");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String apiValue;

        public static EnumEntries<LicenseKeyRefreshReason> getEntries() {
            return $ENTRIES;
        }

        LicenseKeyRefreshReason(String str) {
            this.apiValue = str;
        }

        public final String getApiValue() {
            return this.apiValue;
        }
    }

    /* JADX INFO: compiled from: LicenseKeyRefresher.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/geniusscansdk/core/LicenseKeyRefresher$TimestampedKey;", "", "key", "", "expirationDate", "Ljava/util/Date;", "<init>", "(Ljava/lang/String;Ljava/util/Date;)V", "getKey", "()Ljava/lang/String;", "getExpirationDate", "()Ljava/util/Date;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class TimestampedKey {
        private final Date expirationDate;
        private final String key;

        public static /* synthetic */ TimestampedKey copy$default(TimestampedKey timestampedKey, String str, Date date, int i, Object obj) {
            if ((i & 1) != 0) {
                str = timestampedKey.key;
            }
            if ((i & 2) != 0) {
                date = timestampedKey.expirationDate;
            }
            return timestampedKey.copy(str, date);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Date getExpirationDate() {
            return this.expirationDate;
        }

        public final TimestampedKey copy(String key, Date expirationDate) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(expirationDate, "expirationDate");
            return new TimestampedKey(key, expirationDate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TimestampedKey)) {
                return false;
            }
            TimestampedKey timestampedKey = (TimestampedKey) other;
            return Intrinsics.areEqual(this.key, timestampedKey.key) && Intrinsics.areEqual(this.expirationDate, timestampedKey.expirationDate);
        }

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.expirationDate.hashCode();
        }

        public String toString() {
            return "TimestampedKey(key=" + this.key + ", expirationDate=" + this.expirationDate + ")";
        }

        public TimestampedKey(String key, Date expirationDate) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(expirationDate, "expirationDate");
            this.key = key;
            this.expirationDate = expirationDate;
        }

        public final Date getExpirationDate() {
            return this.expirationDate;
        }

        public final String getKey() {
            return this.key;
        }
    }

    public final String getCachedLicenseKey() {
        TimestampedKey timestampedKeyFetchLicenseKey = this.storage.fetchLicenseKey();
        if (timestampedKeyFetchLicenseKey != null) {
            return timestampedKeyFetchLicenseKey.getKey();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: refresh-0E7RQCE, reason: not valid java name */
    public final Object m13558refresh0E7RQCE(String str, LicenseKeyRefreshReason licenseKeyRefreshReason, Continuation<? super Result<String>> continuation) {
        LicenseKeyRefresher$refresh$1 licenseKeyRefresher$refresh$1;
        Object objRetry$default;
        if (continuation instanceof LicenseKeyRefresher$refresh$1) {
            licenseKeyRefresher$refresh$1 = (LicenseKeyRefresher$refresh$1) continuation;
            if ((licenseKeyRefresher$refresh$1.label & Integer.MIN_VALUE) != 0) {
                licenseKeyRefresher$refresh$1.label -= Integer.MIN_VALUE;
            } else {
                licenseKeyRefresher$refresh$1 = new LicenseKeyRefresher$refresh$1(this, continuation);
            }
        } else {
            licenseKeyRefresher$refresh$1 = new LicenseKeyRefresher$refresh$1(this, continuation);
        }
        LicenseKeyRefresher$refresh$1 licenseKeyRefresher$refresh$2 = licenseKeyRefresher$refresh$1;
        Object obj = licenseKeyRefresher$refresh$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = licenseKeyRefresher$refresh$2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function1 function1 = new Function1() { // from class: com.geniusscansdk.core.LicenseKeyRefresher$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Boolean.valueOf(LicenseKeyRefresher.refresh_0E7RQCE$lambda$0((Throwable) obj2));
                }
            };
            LicenseKeyRefresher$refresh$3 licenseKeyRefresher$refresh$3 = new LicenseKeyRefresher$refresh$3(this, licenseKeyRefreshReason, str, null);
            licenseKeyRefresher$refresh$2.L$0 = this;
            licenseKeyRefresher$refresh$2.label = 1;
            objRetry$default = RetryKt.retry$default(0, function1, licenseKeyRefresher$refresh$3, licenseKeyRefresher$refresh$2, 1, null);
            if (objRetry$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (LicenseKeyRefresher) licenseKeyRefresher$refresh$2.L$0;
            ResultKt.throwOnFailure(obj);
            objRetry$default = ((Result) obj).getValue();
        }
        if (!Result.m14787isSuccessimpl(objRetry$default)) {
            return Result.m14780constructorimpl(objRetry$default);
        }
        Result.Companion companion = Result.INSTANCE;
        LicenseKeyApi.Response response = (LicenseKeyApi.Response) objRetry$default;
        TimestampedKey timestampedKey = new TimestampedKey(response.getKey(), response.getExpirationDate());
        this.storage.saveLicenseKey(timestampedKey);
        return Result.m14780constructorimpl(timestampedKey.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh_0E7RQCE$lambda$0(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !(it instanceof LicenseKeyApi.HttpException) || ArraysKt.contains(RETRYABLE_ERROR_CODES, ((LicenseKeyApi.HttpException) it).getErrorCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LicenseKeyApi.QueryParams buildParams(LicenseKeyRefreshReason reason) {
        return new LicenseKeyApi.QueryParams(this.storage.fetchDeviceId(), this.appVersion, BuildConfig.GSSDK_VERSION, this.osVersion, this.storage.fetchFramework(), this.storage.fetchIntegrationMode(), reason.getApiValue());
    }

    /* JADX INFO: compiled from: LicenseKeyRefresher.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/geniusscansdk/core/LicenseKeyRefresher$Companion;", "", "<init>", "()V", "RETRYABLE_ERROR_CODES", "", "getAppVersion", "", "context", "Landroid/content/Context;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getAppVersion(Context context) {
            return MAMPackageManagement.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        }
    }
}
