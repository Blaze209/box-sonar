package com.box.android.data.api.models.auth;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccessTokenDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0001\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JQ\u0010\u001d\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0003\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006$"}, d2 = {"Lcom/box/android/data/api/models/auth/AccessTokenDTO;", "", "accessToken", "", "expiresIn", "", "issuedTokenType", "refreshToken", "restrictedTo", "", "Lcom/box/android/data/api/models/auth/ScopeDTO;", "tokenType", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "getExpiresIn", "()J", "getIssuedTokenType", "getRefreshToken", "getRestrictedTo", "()Ljava/util/List;", "getTokenType", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AccessTokenDTO {
    private final String accessToken;
    private final long expiresIn;
    private final String issuedTokenType;
    private final String refreshToken;
    private final List<ScopeDTO> restrictedTo;
    private final String tokenType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AccessTokenDTO copy$default(AccessTokenDTO accessTokenDTO, String str, long j, String str2, String str3, List list, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = accessTokenDTO.accessToken;
        }
        if ((i & 2) != 0) {
            j = accessTokenDTO.expiresIn;
        }
        if ((i & 4) != 0) {
            str2 = accessTokenDTO.issuedTokenType;
        }
        if ((i & 8) != 0) {
            str3 = accessTokenDTO.refreshToken;
        }
        if ((i & 16) != 0) {
            list = accessTokenDTO.restrictedTo;
        }
        if ((i & 32) != 0) {
            str4 = accessTokenDTO.tokenType;
        }
        return accessTokenDTO.copy(str, j, str2, str3, list, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getExpiresIn() {
        return this.expiresIn;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getIssuedTokenType() {
        return this.issuedTokenType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final List<ScopeDTO> component5() {
        return this.restrictedTo;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTokenType() {
        return this.tokenType;
    }

    public final AccessTokenDTO copy(@Json(name = "access_token") String accessToken, @Json(name = "expires_in") long expiresIn, @Json(name = "issued_token_type") String issuedTokenType, @Json(name = "refresh_token") String refreshToken, @Json(name = "restricted_to") List<ScopeDTO> restrictedTo, @Json(name = "token_type") String tokenType) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(tokenType, "tokenType");
        return new AccessTokenDTO(accessToken, expiresIn, issuedTokenType, refreshToken, restrictedTo, tokenType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AccessTokenDTO)) {
            return false;
        }
        AccessTokenDTO accessTokenDTO = (AccessTokenDTO) other;
        return Intrinsics.areEqual(this.accessToken, accessTokenDTO.accessToken) && this.expiresIn == accessTokenDTO.expiresIn && Intrinsics.areEqual(this.issuedTokenType, accessTokenDTO.issuedTokenType) && Intrinsics.areEqual(this.refreshToken, accessTokenDTO.refreshToken) && Intrinsics.areEqual(this.restrictedTo, accessTokenDTO.restrictedTo) && Intrinsics.areEqual(this.tokenType, accessTokenDTO.tokenType);
    }

    public int hashCode() {
        int iHashCode = ((this.accessToken.hashCode() * 31) + Long.hashCode(this.expiresIn)) * 31;
        String str = this.issuedTokenType;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.refreshToken;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<ScopeDTO> list = this.restrictedTo;
        return ((iHashCode3 + (list != null ? list.hashCode() : 0)) * 31) + this.tokenType.hashCode();
    }

    public String toString() {
        return "AccessTokenDTO(accessToken=" + this.accessToken + ", expiresIn=" + this.expiresIn + ", issuedTokenType=" + this.issuedTokenType + ", refreshToken=" + this.refreshToken + ", restrictedTo=" + this.restrictedTo + ", tokenType=" + this.tokenType + ")";
    }

    public AccessTokenDTO(@Json(name = "access_token") String accessToken, @Json(name = "expires_in") long j, @Json(name = "issued_token_type") String str, @Json(name = "refresh_token") String str2, @Json(name = "restricted_to") List<ScopeDTO> list, @Json(name = "token_type") String tokenType) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(tokenType, "tokenType");
        this.accessToken = accessToken;
        this.expiresIn = j;
        this.issuedTokenType = str;
        this.refreshToken = str2;
        this.restrictedTo = list;
        this.tokenType = tokenType;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final long getExpiresIn() {
        return this.expiresIn;
    }

    public final String getIssuedTokenType() {
        return this.issuedTokenType;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final List<ScopeDTO> getRestrictedTo() {
        return this.restrictedTo;
    }

    public /* synthetic */ AccessTokenDTO(String str, long j, String str2, String str3, List list, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, str2, str3, list, (i & 32) != 0 ? "bearer" : str4);
    }

    public final String getTokenType() {
        return this.tokenType;
    }
}
