package sdk.pendo.io.network.interfaces;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import io.split.android.client.service.ServiceConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.b0.c;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.l4.r;
import sdk.pendo.io.n4.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\bR$\u0010\u0007\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lsdk/pendo/io/network/interfaces/GetAuthToken;", "", "Lsdk/pendo/io/k3/j;", "Lsdk/pendo/io/l4/r;", "Lsdk/pendo/io/network/interfaces/GetAuthToken$GetAuthTokenResponse;", "getAccessTokenSigned", "()Lsdk/pendo/io/k3/j;", "accessTokenSigned", "GetAuthTokenResponse", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public interface GetAuthToken {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012 \b\u0002\u0010\u0005\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t¢\u0006\u0002\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010%\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007\u0018\u00010\u0006HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J£\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032 \b\u0002\u0010\u0005\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\tHÆ\u0001J\u0013\u0010-\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0011\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0016R.\u0010\u0005\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0016\u0010\r\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0016\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0016\u0010\u000f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016¨\u00062"}, d2 = {"Lsdk/pendo/io/network/interfaces/GetAuthToken$GetAuthTokenResponse;", "", "accessToken", "", ServiceConstants.WORKER_PARAM_API_KEY, "promotedMetadataFields", "", "", "disableAnonVisitorGenerator", "", "redirectionDatacenter", "redirectionHost", "redirectionKey", "synchronizedScreenDataScan", "isIgnoringAnonymousSessions", "useOnlyXamarinBridgeProvidedScreenId", Pendo.PendoOptions.USE_MODIFIED_SCREEN_DATA_FOR_NATIVE_TRANSIENT_UI_COMPONENT, "disableComposeWindowCallback", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZ)V", "getApiKey", "()Ljava/lang/String;", "getDisableAnonVisitorGenerator", "()Z", "getDisableComposeWindowCallback", "getPromotedMetadataFields", "()Ljava/util/Map;", "getRedirectionDatacenter", "getRedirectionHost", "getRedirectionKey", "getSynchronizedScreenDataScan", "getUseModifiedScreenDataForNativeTransientUIComponent", "getUseOnlyXamarinBridgeProvidedScreenId", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class GetAuthTokenResponse {
        public final String accessToken;

        @c(ServiceConstants.WORKER_PARAM_API_KEY)
        private final String apiKey;

        @c("disableMobileGenerateAnonVisitor")
        private final boolean disableAnonVisitorGenerator;

        @c("disableComposeWindowCallback")
        private final boolean disableComposeWindowCallback;

        @c("dropAnonymous")
        private final boolean isIgnoringAnonymousSessions;

        @c("promotedMetadataFields")
        private final Map<String, List<String>> promotedMetadataFields;

        @c("datacenter")
        private final String redirectionDatacenter;

        @c("host")
        private final String redirectionHost;

        @c("key")
        private final String redirectionKey;

        @c("synchronizedScreenDataScan")
        private final boolean synchronizedScreenDataScan;

        @c(Pendo.PendoOptions.USE_MODIFIED_SCREEN_DATA_FOR_NATIVE_TRANSIENT_UI_COMPONENT)
        private final boolean useModifiedScreenDataForNativeTransientUIComponent;

        @c("useXamarinProvidedScreenId")
        private final boolean useOnlyXamarinBridgeProvidedScreenId;

        public GetAuthTokenResponse() {
            this(null, null, null, false, null, null, null, false, false, false, false, false, 4095, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GetAuthTokenResponse copy$default(GetAuthTokenResponse getAuthTokenResponse, String str, String str2, Map map, boolean z, String str3, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = getAuthTokenResponse.accessToken;
            }
            if ((i & 2) != 0) {
                str2 = getAuthTokenResponse.apiKey;
            }
            if ((i & 4) != 0) {
                map = getAuthTokenResponse.promotedMetadataFields;
            }
            if ((i & 8) != 0) {
                z = getAuthTokenResponse.disableAnonVisitorGenerator;
            }
            if ((i & 16) != 0) {
                str3 = getAuthTokenResponse.redirectionDatacenter;
            }
            if ((i & 32) != 0) {
                str4 = getAuthTokenResponse.redirectionHost;
            }
            if ((i & 64) != 0) {
                str5 = getAuthTokenResponse.redirectionKey;
            }
            if ((i & 128) != 0) {
                z2 = getAuthTokenResponse.synchronizedScreenDataScan;
            }
            if ((i & 256) != 0) {
                z3 = getAuthTokenResponse.isIgnoringAnonymousSessions;
            }
            if ((i & 512) != 0) {
                z4 = getAuthTokenResponse.useOnlyXamarinBridgeProvidedScreenId;
            }
            if ((i & 1024) != 0) {
                z5 = getAuthTokenResponse.useModifiedScreenDataForNativeTransientUIComponent;
            }
            if ((i & 2048) != 0) {
                z6 = getAuthTokenResponse.disableComposeWindowCallback;
            }
            boolean z7 = z5;
            boolean z8 = z6;
            boolean z9 = z3;
            boolean z10 = z4;
            String str6 = str5;
            boolean z11 = z2;
            String str7 = str3;
            String str8 = str4;
            return getAuthTokenResponse.copy(str, str2, map, z, str7, str8, str6, z11, z9, z10, z7, z8);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAccessToken() {
            return this.accessToken;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final boolean getUseOnlyXamarinBridgeProvidedScreenId() {
            return this.useOnlyXamarinBridgeProvidedScreenId;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final boolean getUseModifiedScreenDataForNativeTransientUIComponent() {
            return this.useModifiedScreenDataForNativeTransientUIComponent;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final boolean getDisableComposeWindowCallback() {
            return this.disableComposeWindowCallback;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getApiKey() {
            return this.apiKey;
        }

        public final Map<String, List<String>> component3() {
            return this.promotedMetadataFields;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getDisableAnonVisitorGenerator() {
            return this.disableAnonVisitorGenerator;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getRedirectionDatacenter() {
            return this.redirectionDatacenter;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getRedirectionHost() {
            return this.redirectionHost;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getRedirectionKey() {
            return this.redirectionKey;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getSynchronizedScreenDataScan() {
            return this.synchronizedScreenDataScan;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getIsIgnoringAnonymousSessions() {
            return this.isIgnoringAnonymousSessions;
        }

        public final GetAuthTokenResponse copy(String accessToken, String apiKey, Map<String, ? extends List<String>> promotedMetadataFields, boolean disableAnonVisitorGenerator, String redirectionDatacenter, String redirectionHost, String redirectionKey, boolean synchronizedScreenDataScan, boolean isIgnoringAnonymousSessions, boolean useOnlyXamarinBridgeProvidedScreenId, boolean useModifiedScreenDataForNativeTransientUIComponent, boolean disableComposeWindowCallback) {
            return new GetAuthTokenResponse(accessToken, apiKey, promotedMetadataFields, disableAnonVisitorGenerator, redirectionDatacenter, redirectionHost, redirectionKey, synchronizedScreenDataScan, isIgnoringAnonymousSessions, useOnlyXamarinBridgeProvidedScreenId, useModifiedScreenDataForNativeTransientUIComponent, disableComposeWindowCallback);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GetAuthTokenResponse)) {
                return false;
            }
            GetAuthTokenResponse getAuthTokenResponse = (GetAuthTokenResponse) other;
            return Intrinsics.areEqual(this.accessToken, getAuthTokenResponse.accessToken) && Intrinsics.areEqual(this.apiKey, getAuthTokenResponse.apiKey) && Intrinsics.areEqual(this.promotedMetadataFields, getAuthTokenResponse.promotedMetadataFields) && this.disableAnonVisitorGenerator == getAuthTokenResponse.disableAnonVisitorGenerator && Intrinsics.areEqual(this.redirectionDatacenter, getAuthTokenResponse.redirectionDatacenter) && Intrinsics.areEqual(this.redirectionHost, getAuthTokenResponse.redirectionHost) && Intrinsics.areEqual(this.redirectionKey, getAuthTokenResponse.redirectionKey) && this.synchronizedScreenDataScan == getAuthTokenResponse.synchronizedScreenDataScan && this.isIgnoringAnonymousSessions == getAuthTokenResponse.isIgnoringAnonymousSessions && this.useOnlyXamarinBridgeProvidedScreenId == getAuthTokenResponse.useOnlyXamarinBridgeProvidedScreenId && this.useModifiedScreenDataForNativeTransientUIComponent == getAuthTokenResponse.useModifiedScreenDataForNativeTransientUIComponent && this.disableComposeWindowCallback == getAuthTokenResponse.disableComposeWindowCallback;
        }

        public final String getApiKey() {
            return this.apiKey;
        }

        public final boolean getDisableAnonVisitorGenerator() {
            return this.disableAnonVisitorGenerator;
        }

        public final boolean getDisableComposeWindowCallback() {
            return this.disableComposeWindowCallback;
        }

        public final Map<String, List<String>> getPromotedMetadataFields() {
            return this.promotedMetadataFields;
        }

        public final String getRedirectionDatacenter() {
            return this.redirectionDatacenter;
        }

        public final String getRedirectionHost() {
            return this.redirectionHost;
        }

        public final String getRedirectionKey() {
            return this.redirectionKey;
        }

        public final boolean getSynchronizedScreenDataScan() {
            return this.synchronizedScreenDataScan;
        }

        public final boolean getUseModifiedScreenDataForNativeTransientUIComponent() {
            return this.useModifiedScreenDataForNativeTransientUIComponent;
        }

        public final boolean getUseOnlyXamarinBridgeProvidedScreenId() {
            return this.useOnlyXamarinBridgeProvidedScreenId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v16, types: [int] */
        /* JADX WARN: Type inference failed for: r0v18, types: [int] */
        /* JADX WARN: Type inference failed for: r0v20, types: [int] */
        /* JADX WARN: Type inference failed for: r0v22, types: [int] */
        /* JADX WARN: Type inference failed for: r0v24, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9, types: [int] */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            String str = this.accessToken;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.apiKey;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Map<String, List<String>> map = this.promotedMetadataFields;
            int iHashCode3 = (iHashCode2 + (map == null ? 0 : map.hashCode())) * 31;
            boolean z = this.disableAnonVisitorGenerator;
            ?? r2 = z;
            if (z) {
                r2 = 1;
            }
            int i = (iHashCode3 + r2) * 31;
            String str3 = this.redirectionDatacenter;
            int iHashCode4 = (i + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.redirectionHost;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.redirectionKey;
            int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
            boolean z2 = this.synchronizedScreenDataScan;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i2 = (iHashCode6 + r1) * 31;
            boolean z3 = this.isIgnoringAnonymousSessions;
            ?? r3 = z3;
            if (z3) {
                r3 = 1;
            }
            int i3 = (i2 + r3) * 31;
            boolean z4 = this.useOnlyXamarinBridgeProvidedScreenId;
            ?? r4 = z4;
            if (z4) {
                r4 = 1;
            }
            int i4 = (i3 + r4) * 31;
            boolean z5 = this.useModifiedScreenDataForNativeTransientUIComponent;
            ?? r5 = z5;
            if (z5) {
                r5 = 1;
            }
            int i5 = (i4 + r5) * 31;
            boolean z6 = this.disableComposeWindowCallback;
            return i5 + (z6 ? 1 : z6);
        }

        public final boolean isIgnoringAnonymousSessions() {
            return this.isIgnoringAnonymousSessions;
        }

        public String toString() {
            return "GetAuthTokenResponse(accessToken=" + this.accessToken + ", apiKey=" + this.apiKey + ", promotedMetadataFields=" + this.promotedMetadataFields + ", disableAnonVisitorGenerator=" + this.disableAnonVisitorGenerator + ", redirectionDatacenter=" + this.redirectionDatacenter + ", redirectionHost=" + this.redirectionHost + ", redirectionKey=" + this.redirectionKey + ", synchronizedScreenDataScan=" + this.synchronizedScreenDataScan + ", isIgnoringAnonymousSessions=" + this.isIgnoringAnonymousSessions + ", useOnlyXamarinBridgeProvidedScreenId=" + this.useOnlyXamarinBridgeProvidedScreenId + ", useModifiedScreenDataForNativeTransientUIComponent=" + this.useModifiedScreenDataForNativeTransientUIComponent + ", disableComposeWindowCallback=" + this.disableComposeWindowCallback + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public GetAuthTokenResponse(String str, String str2, Map<String, ? extends List<String>> map, boolean z, String str3, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            this.accessToken = str;
            this.apiKey = str2;
            this.promotedMetadataFields = map;
            this.disableAnonVisitorGenerator = z;
            this.redirectionDatacenter = str3;
            this.redirectionHost = str4;
            this.redirectionKey = str5;
            this.synchronizedScreenDataScan = z2;
            this.isIgnoringAnonymousSessions = z3;
            this.useOnlyXamarinBridgeProvidedScreenId = z4;
            this.useModifiedScreenDataForNativeTransientUIComponent = z5;
            this.disableComposeWindowCallback = z6;
        }

        public /* synthetic */ GetAuthTokenResponse(String str, String str2, Map map, boolean z, String str3, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : map, (i & 8) != 0 ? true : z, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? false : z2, (i & 256) != 0 ? false : z3, (i & 512) != 0 ? false : z4, (i & 1024) != 0 ? false : z5, (i & 2048) != 0 ? false : z6);
        }
    }

    @f("v2/devices/getAccessTokenSigned")
    j<r<GetAuthTokenResponse>> getAccessTokenSigned();
}
