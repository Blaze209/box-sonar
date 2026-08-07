package com.box.android.data.api.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.java.jwt.AbstractJwtRequest;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClientSettingsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/data/api/models/JWTAuthInfo;", "", "publicKeyId", "", "privateKey", "passphrase", AbstractJwtRequest.ClaimNames.ASSERTION, "Lcom/box/android/data/api/models/JWTAssertion;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/JWTAssertion;)V", "getPublicKeyId", "()Ljava/lang/String;", "getPrivateKey", "getPassphrase", "getAssertion", "()Lcom/box/android/data/api/models/JWTAssertion;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class JWTAuthInfo {
    private final JWTAssertion assertion;
    private final String passphrase;
    private final String privateKey;
    private final String publicKeyId;

    public static /* synthetic */ JWTAuthInfo copy$default(JWTAuthInfo jWTAuthInfo, String str, String str2, String str3, JWTAssertion jWTAssertion, int i, Object obj) {
        if ((i & 1) != 0) {
            str = jWTAuthInfo.publicKeyId;
        }
        if ((i & 2) != 0) {
            str2 = jWTAuthInfo.privateKey;
        }
        if ((i & 4) != 0) {
            str3 = jWTAuthInfo.passphrase;
        }
        if ((i & 8) != 0) {
            jWTAssertion = jWTAuthInfo.assertion;
        }
        return jWTAuthInfo.copy(str, str2, str3, jWTAssertion);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPublicKeyId() {
        return this.publicKeyId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPrivateKey() {
        return this.privateKey;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPassphrase() {
        return this.passphrase;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final JWTAssertion getAssertion() {
        return this.assertion;
    }

    public final JWTAuthInfo copy(@Json(name = "jwt_key_kid") String publicKeyId, @Json(name = "jwt_private_key") String privateKey, @Json(name = "jwt_private_key_passphrase") String passphrase, @Json(name = "jwt_assertion") JWTAssertion assertion) {
        Intrinsics.checkNotNullParameter(publicKeyId, "publicKeyId");
        Intrinsics.checkNotNullParameter(privateKey, "privateKey");
        Intrinsics.checkNotNullParameter(passphrase, "passphrase");
        Intrinsics.checkNotNullParameter(assertion, "assertion");
        return new JWTAuthInfo(publicKeyId, privateKey, passphrase, assertion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JWTAuthInfo)) {
            return false;
        }
        JWTAuthInfo jWTAuthInfo = (JWTAuthInfo) other;
        return Intrinsics.areEqual(this.publicKeyId, jWTAuthInfo.publicKeyId) && Intrinsics.areEqual(this.privateKey, jWTAuthInfo.privateKey) && Intrinsics.areEqual(this.passphrase, jWTAuthInfo.passphrase) && Intrinsics.areEqual(this.assertion, jWTAuthInfo.assertion);
    }

    public int hashCode() {
        return (((((this.publicKeyId.hashCode() * 31) + this.privateKey.hashCode()) * 31) + this.passphrase.hashCode()) * 31) + this.assertion.hashCode();
    }

    public String toString() {
        return "JWTAuthInfo(publicKeyId=" + this.publicKeyId + ", privateKey=" + this.privateKey + ", passphrase=" + this.passphrase + ", assertion=" + this.assertion + ")";
    }

    public JWTAuthInfo(@Json(name = "jwt_key_kid") String publicKeyId, @Json(name = "jwt_private_key") String privateKey, @Json(name = "jwt_private_key_passphrase") String passphrase, @Json(name = "jwt_assertion") JWTAssertion assertion) {
        Intrinsics.checkNotNullParameter(publicKeyId, "publicKeyId");
        Intrinsics.checkNotNullParameter(privateKey, "privateKey");
        Intrinsics.checkNotNullParameter(passphrase, "passphrase");
        Intrinsics.checkNotNullParameter(assertion, "assertion");
        this.publicKeyId = publicKeyId;
        this.privateKey = privateKey;
        this.passphrase = passphrase;
        this.assertion = assertion;
    }

    public final String getPublicKeyId() {
        return this.publicKeyId;
    }

    public final String getPrivateKey() {
        return this.privateKey;
    }

    public final String getPassphrase() {
        return this.passphrase;
    }

    public final JWTAssertion getAssertion() {
        return this.assertion;
    }
}
