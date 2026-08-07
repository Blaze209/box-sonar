package com.geniusscansdk.core;

import android.content.Context;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.geniusscansdk.R;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import java.io.IOException;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: LicenseKeyApi.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0003\u0011\u0012\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ&\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/geniusscansdk/core/LicenseKeyApi;", "", "baseUrl", "", "<init>", "(Ljava/lang/String;)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getLicenseKey", "Lkotlin/Result;", "Lcom/geniusscansdk/core/LicenseKeyApi$Response;", "baseLicenseKey", SerializedNames.PARAMS, "Lcom/geniusscansdk/core/LicenseKeyApi$QueryParams;", "getLicenseKey-0E7RQCE", "(Ljava/lang/String;Lcom/geniusscansdk/core/LicenseKeyApi$QueryParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "QueryParams", "Response", "HttpException", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LicenseKeyApi {
    private final String baseUrl;

    public LicenseKeyApi(String baseUrl) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        this.baseUrl = baseUrl;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LicenseKeyApi(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.license_key_api_url);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this(string);
    }

    /* JADX INFO: compiled from: LicenseKeyApi.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JU\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lcom/geniusscansdk/core/LicenseKeyApi$QueryParams;", "", "deviceId", "", RemoteConfigConstants.RequestFieldKey.APP_VERSION, "sdkVersion", "osVersion", "framework", "integrationMode", "keyRefresh", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getAppVersion", "getSdkVersion", "getOsVersion", "getFramework", "getIntegrationMode", "getKeyRefresh", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class QueryParams {
        private final String appVersion;
        private final String deviceId;
        private final String framework;
        private final String integrationMode;
        private final String keyRefresh;
        private final String osVersion;
        private final String sdkVersion;

        public static /* synthetic */ QueryParams copy$default(QueryParams queryParams, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
            if ((i & 1) != 0) {
                str = queryParams.deviceId;
            }
            if ((i & 2) != 0) {
                str2 = queryParams.appVersion;
            }
            if ((i & 4) != 0) {
                str3 = queryParams.sdkVersion;
            }
            if ((i & 8) != 0) {
                str4 = queryParams.osVersion;
            }
            if ((i & 16) != 0) {
                str5 = queryParams.framework;
            }
            if ((i & 32) != 0) {
                str6 = queryParams.integrationMode;
            }
            if ((i & 64) != 0) {
                str7 = queryParams.keyRefresh;
            }
            String str8 = str6;
            String str9 = str7;
            String str10 = str5;
            String str11 = str3;
            return queryParams.copy(str, str2, str11, str4, str10, str8, str9);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceId() {
            return this.deviceId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getAppVersion() {
            return this.appVersion;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSdkVersion() {
            return this.sdkVersion;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getOsVersion() {
            return this.osVersion;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getFramework() {
            return this.framework;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getIntegrationMode() {
            return this.integrationMode;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getKeyRefresh() {
            return this.keyRefresh;
        }

        public final QueryParams copy(String deviceId, String appVersion, String sdkVersion, String osVersion, String framework, String integrationMode, String keyRefresh) {
            Intrinsics.checkNotNullParameter(deviceId, "deviceId");
            Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
            Intrinsics.checkNotNullParameter(osVersion, "osVersion");
            Intrinsics.checkNotNullParameter(framework, "framework");
            return new QueryParams(deviceId, appVersion, sdkVersion, osVersion, framework, integrationMode, keyRefresh);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QueryParams)) {
                return false;
            }
            QueryParams queryParams = (QueryParams) other;
            return Intrinsics.areEqual(this.deviceId, queryParams.deviceId) && Intrinsics.areEqual(this.appVersion, queryParams.appVersion) && Intrinsics.areEqual(this.sdkVersion, queryParams.sdkVersion) && Intrinsics.areEqual(this.osVersion, queryParams.osVersion) && Intrinsics.areEqual(this.framework, queryParams.framework) && Intrinsics.areEqual(this.integrationMode, queryParams.integrationMode) && Intrinsics.areEqual(this.keyRefresh, queryParams.keyRefresh);
        }

        public int hashCode() {
            int iHashCode = this.deviceId.hashCode() * 31;
            String str = this.appVersion;
            int iHashCode2 = (((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.sdkVersion.hashCode()) * 31) + this.osVersion.hashCode()) * 31) + this.framework.hashCode()) * 31;
            String str2 = this.integrationMode;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.keyRefresh;
            return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "QueryParams(deviceId=" + this.deviceId + ", appVersion=" + this.appVersion + ", sdkVersion=" + this.sdkVersion + ", osVersion=" + this.osVersion + ", framework=" + this.framework + ", integrationMode=" + this.integrationMode + ", keyRefresh=" + this.keyRefresh + ")";
        }

        public QueryParams(String deviceId, String str, String sdkVersion, String osVersion, String framework, String str2, String str3) {
            Intrinsics.checkNotNullParameter(deviceId, "deviceId");
            Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
            Intrinsics.checkNotNullParameter(osVersion, "osVersion");
            Intrinsics.checkNotNullParameter(framework, "framework");
            this.deviceId = deviceId;
            this.appVersion = str;
            this.sdkVersion = sdkVersion;
            this.osVersion = osVersion;
            this.framework = framework;
            this.integrationMode = str2;
            this.keyRefresh = str3;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final String getAppVersion() {
            return this.appVersion;
        }

        public final String getSdkVersion() {
            return this.sdkVersion;
        }

        public final String getOsVersion() {
            return this.osVersion;
        }

        public final String getFramework() {
            return this.framework;
        }

        public final String getIntegrationMode() {
            return this.integrationMode;
        }

        public final String getKeyRefresh() {
            return this.keyRefresh;
        }
    }

    /* JADX INFO: compiled from: LicenseKeyApi.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/geniusscansdk/core/LicenseKeyApi$Response;", "", "key", "", "expirationDate", "Ljava/util/Date;", "<init>", "(Ljava/lang/String;Ljava/util/Date;)V", "getKey", "()Ljava/lang/String;", "getExpirationDate", "()Ljava/util/Date;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("expiration_date")
        private final Date expirationDate;

        @SerializedName("key")
        private final String key;

        public static /* synthetic */ Response copy$default(Response response, String str, Date date, int i, Object obj) {
            if ((i & 1) != 0) {
                str = response.key;
            }
            if ((i & 2) != 0) {
                date = response.expirationDate;
            }
            return response.copy(str, date);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Date getExpirationDate() {
            return this.expirationDate;
        }

        public final Response copy(String key, Date expirationDate) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(expirationDate, "expirationDate");
            return new Response(key, expirationDate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return Intrinsics.areEqual(this.key, response.key) && Intrinsics.areEqual(this.expirationDate, response.expirationDate);
        }

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.expirationDate.hashCode();
        }

        public String toString() {
            return "Response(key=" + this.key + ", expirationDate=" + this.expirationDate + ")";
        }

        public Response(String key, Date expirationDate) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(expirationDate, "expirationDate");
            this.key = key;
            this.expirationDate = expirationDate;
        }

        public final String getKey() {
            return this.key;
        }

        public final Date getExpirationDate() {
            return this.expirationDate;
        }
    }

    /* JADX INFO: compiled from: LicenseKeyApi.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/geniusscansdk/core/LicenseKeyApi$HttpException;", "Ljava/io/IOException;", "errorCode", "", "<init>", "(I)V", "getErrorCode", "()I", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HttpException extends IOException {
        private final int errorCode;

        public HttpException(int i) {
            super("HTTP error: " + i);
            this.errorCode = i;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getLicenseKey-0E7RQCE, reason: not valid java name */
    public final Object m13557getLicenseKey0E7RQCE(String str, QueryParams queryParams, Continuation<? super Result<Response>> continuation) {
        LicenseKeyApi$getLicenseKey$1 licenseKeyApi$getLicenseKey$1;
        if (continuation instanceof LicenseKeyApi$getLicenseKey$1) {
            licenseKeyApi$getLicenseKey$1 = (LicenseKeyApi$getLicenseKey$1) continuation;
            if ((licenseKeyApi$getLicenseKey$1.label & Integer.MIN_VALUE) != 0) {
                licenseKeyApi$getLicenseKey$1.label -= Integer.MIN_VALUE;
            } else {
                licenseKeyApi$getLicenseKey$1 = new LicenseKeyApi$getLicenseKey$1(this, continuation);
            }
        } else {
            licenseKeyApi$getLicenseKey$1 = new LicenseKeyApi$getLicenseKey$1(this, continuation);
        }
        Object objWithContext = licenseKeyApi$getLicenseKey$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = licenseKeyApi$getLicenseKey$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithContext);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            LicenseKeyApi$getLicenseKey$2 licenseKeyApi$getLicenseKey$2 = new LicenseKeyApi$getLicenseKey$2(queryParams, this, str, null);
            licenseKeyApi$getLicenseKey$1.label = 1;
            objWithContext = BuildersKt.withContext(io2, licenseKeyApi$getLicenseKey$2, licenseKeyApi$getLicenseKey$1);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        return ((Result) objWithContext).getValue();
    }
}
