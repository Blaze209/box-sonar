package com.box.android.auth;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.services.IAuthenticationCredentialsProvider;
import com.microsoft.identity.common.java.dto.Credential;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthenticationCredentialsProvider.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/auth/AuthenticationCredentialsProvider;", "Lcom/box/android/domain/services/IAuthenticationCredentialsProvider;", "clientId", "", Credential.SerializedNames.SECRET, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "getSecret", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AuthenticationCredentialsProvider implements IAuthenticationCredentialsProvider {
    public static final int $stable = 0;
    private final String clientId;
    private final String secret;

    public static /* synthetic */ AuthenticationCredentialsProvider copy$default(AuthenticationCredentialsProvider authenticationCredentialsProvider, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authenticationCredentialsProvider.clientId;
        }
        if ((i & 2) != 0) {
            str2 = authenticationCredentialsProvider.secret;
        }
        return authenticationCredentialsProvider.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSecret() {
        return this.secret;
    }

    public final AuthenticationCredentialsProvider copy(String clientId, String secret) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(secret, "secret");
        return new AuthenticationCredentialsProvider(clientId, secret);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthenticationCredentialsProvider)) {
            return false;
        }
        AuthenticationCredentialsProvider authenticationCredentialsProvider = (AuthenticationCredentialsProvider) other;
        return Intrinsics.areEqual(this.clientId, authenticationCredentialsProvider.clientId) && Intrinsics.areEqual(this.secret, authenticationCredentialsProvider.secret);
    }

    public int hashCode() {
        return (this.clientId.hashCode() * 31) + this.secret.hashCode();
    }

    public String toString() {
        return "AuthenticationCredentialsProvider(clientId=" + this.clientId + ", secret=" + this.secret + ")";
    }

    @Inject
    public AuthenticationCredentialsProvider(String clientId, String secret) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(secret, "secret");
        this.clientId = clientId;
        this.secret = secret;
    }

    @Override // com.box.android.domain.services.IAuthenticationCredentialsProvider
    public String getClientId() {
        return this.clientId;
    }

    @Override // com.box.android.domain.services.IAuthenticationCredentialsProvider
    public String getSecret() {
        return this.secret;
    }
}
