package com.microsoft.identity.common.internal.msafederation.google;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.internal.msafederation.MsaFederatedCredential;
import com.microsoft.identity.common.internal.msafederation.MsaFederatedSignInProviderName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignInWithGoogleCredential.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\u0004HÀ\u0003¢\u0006\u0002\b\tJ\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/microsoft/identity/common/internal/msafederation/google/SignInWithGoogleCredential;", "Lcom/microsoft/identity/common/internal/msafederation/MsaFederatedCredential;", "Ljava/io/Serializable;", "idToken", "", "(Ljava/lang/String;)V", "getIdToken$common_distRelease", "()Ljava/lang/String;", "component1", "component1$common_distRelease", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SignInWithGoogleCredential extends MsaFederatedCredential implements Serializable {

    @SerializedName("idToken")
    private final String idToken;

    public static /* synthetic */ SignInWithGoogleCredential copy$default(SignInWithGoogleCredential signInWithGoogleCredential, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = signInWithGoogleCredential.idToken;
        }
        return signInWithGoogleCredential.copy(str);
    }

    /* JADX INFO: renamed from: component1$common_distRelease, reason: from getter */
    public final String getIdToken() {
        return this.idToken;
    }

    public final SignInWithGoogleCredential copy(String idToken) {
        Intrinsics.checkNotNullParameter(idToken, "idToken");
        return new SignInWithGoogleCredential(idToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SignInWithGoogleCredential) && Intrinsics.areEqual(this.idToken, ((SignInWithGoogleCredential) other).idToken);
    }

    public int hashCode() {
        return this.idToken.hashCode();
    }

    public String toString() {
        return "SignInWithGoogleCredential(idToken=" + this.idToken + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignInWithGoogleCredential(String idToken) {
        super(MsaFederatedSignInProviderName.GOOGLE);
        Intrinsics.checkNotNullParameter(idToken, "idToken");
        this.idToken = idToken;
    }

    public final String getIdToken$common_distRelease() {
        return this.idToken;
    }
}
