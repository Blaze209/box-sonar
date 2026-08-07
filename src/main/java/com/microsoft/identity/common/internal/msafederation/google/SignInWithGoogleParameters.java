package com.microsoft.identity.common.internal.msafederation.google;

import android.app.Activity;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.internal.msafederation.MsaFederatedSignInParameters;
import com.microsoft.identity.common.internal.msafederation.MsaFederatedSignInProviderName;
import com.microsoft.identity.common.internal.msafederation.MsaFederationConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignInWithGoogleParameters.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0014J\u000e\u0010\u0015\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0016J\u000e\u0010\u0017\u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\b\u0018J'\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/microsoft/identity/common/internal/msafederation/google/SignInWithGoogleParameters;", "Lcom/microsoft/identity/common/internal/msafederation/MsaFederatedSignInParameters;", "activity", "Landroid/app/Activity;", "serverClientId", "", "useBottomSheet", "", "(Landroid/app/Activity;Ljava/lang/String;Z)V", "getActivity$common_distRelease", "()Landroid/app/Activity;", "providerName", "Lcom/microsoft/identity/common/internal/msafederation/MsaFederatedSignInProviderName;", "getProviderName", "()Lcom/microsoft/identity/common/internal/msafederation/MsaFederatedSignInProviderName;", "getServerClientId$common_distRelease", "()Ljava/lang/String;", "getUseBottomSheet$common_distRelease", "()Z", "component1", "component1$common_distRelease", "component2", "component2$common_distRelease", "component3", "component3$common_distRelease", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SignInWithGoogleParameters extends MsaFederatedSignInParameters {
    private final Activity activity;
    private final String serverClientId;
    private final boolean useBottomSheet;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SignInWithGoogleParameters(Activity activity) {
        this(activity, null, false, 6, null);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SignInWithGoogleParameters(Activity activity, String serverClientId) {
        this(activity, serverClientId, false, 4, null);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
    }

    public static /* synthetic */ SignInWithGoogleParameters copy$default(SignInWithGoogleParameters signInWithGoogleParameters, Activity activity, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            activity = signInWithGoogleParameters.activity;
        }
        if ((i & 2) != 0) {
            str = signInWithGoogleParameters.serverClientId;
        }
        if ((i & 4) != 0) {
            z = signInWithGoogleParameters.useBottomSheet;
        }
        return signInWithGoogleParameters.copy(activity, str, z);
    }

    /* JADX INFO: renamed from: component1$common_distRelease, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    /* JADX INFO: renamed from: component2$common_distRelease, reason: from getter */
    public final String getServerClientId() {
        return this.serverClientId;
    }

    /* JADX INFO: renamed from: component3$common_distRelease, reason: from getter */
    public final boolean getUseBottomSheet() {
        return this.useBottomSheet;
    }

    public final SignInWithGoogleParameters copy(Activity activity, String serverClientId, boolean useBottomSheet) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
        return new SignInWithGoogleParameters(activity, serverClientId, useBottomSheet);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignInWithGoogleParameters)) {
            return false;
        }
        SignInWithGoogleParameters signInWithGoogleParameters = (SignInWithGoogleParameters) other;
        return Intrinsics.areEqual(this.activity, signInWithGoogleParameters.activity) && Intrinsics.areEqual(this.serverClientId, signInWithGoogleParameters.serverClientId) && this.useBottomSheet == signInWithGoogleParameters.useBottomSheet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int iHashCode = ((this.activity.hashCode() * 31) + this.serverClientId.hashCode()) * 31;
        boolean z = this.useBottomSheet;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        return iHashCode + r2;
    }

    public String toString() {
        return "SignInWithGoogleParameters(activity=" + this.activity + ", serverClientId=" + this.serverClientId + ", useBottomSheet=" + this.useBottomSheet + ')';
    }

    public final Activity getActivity$common_distRelease() {
        return this.activity;
    }

    public /* synthetic */ SignInWithGoogleParameters(Activity activity, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, (i & 2) != 0 ? MsaFederationConstants.GOOGLE_MSA_SERVER_CLIENT_ID : str, (i & 4) != 0 ? false : z);
    }

    public final String getServerClientId$common_distRelease() {
        return this.serverClientId;
    }

    public final boolean getUseBottomSheet$common_distRelease() {
        return this.useBottomSheet;
    }

    public SignInWithGoogleParameters(Activity activity, String serverClientId, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
        this.activity = activity;
        this.serverClientId = serverClientId;
        this.useBottomSheet = z;
    }

    @Override // com.microsoft.identity.common.internal.msafederation.MsaFederatedSignInParameters
    public MsaFederatedSignInProviderName getProviderName() {
        return MsaFederatedSignInProviderName.GOOGLE;
    }
}
