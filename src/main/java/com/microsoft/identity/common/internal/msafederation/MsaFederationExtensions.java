package com.microsoft.identity.common.internal.msafederation;

import com.microsoft.identity.common.internal.msafederation.google.SignInWithGoogleCredential;
import com.microsoft.identity.common.java.commands.parameters.BrokerInteractiveTokenCommandParameters;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MsaFederationExtensions.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005*\u00020\u0003\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b¨\u0006\t"}, d2 = {"getIdProviderExtraQueryParamForAuthorization", "", "", "Lcom/microsoft/identity/common/internal/msafederation/google/SignInWithGoogleCredential;", "getIdProviderHeadersForAuthorization", "", "isSignInWithGoogleFlow", "", "Lcom/microsoft/identity/common/java/commands/parameters/BrokerInteractiveTokenCommandParameters;", "common_distRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MsaFederationExtensions {
    public static final Map<String, String> getIdProviderHeadersForAuthorization(SignInWithGoogleCredential signInWithGoogleCredential) {
        Intrinsics.checkNotNullParameter(signInWithGoogleCredential, "<this>");
        return MapsKt.mapOf(TuplesKt.to(MsaFederationConstants.MSA_ID_TOKEN_HEADER_KEY, signInWithGoogleCredential.getIdToken$common_distRelease()));
    }

    public static final Map.Entry<String, String> getIdProviderExtraQueryParamForAuthorization(SignInWithGoogleCredential signInWithGoogleCredential) {
        Intrinsics.checkNotNullParameter(signInWithGoogleCredential, "<this>");
        return new AbstractMap.SimpleEntry(MsaFederationConstants.MSA_ID_PROVIDER_EXTRA_QUERY_PARAM_KEY, signInWithGoogleCredential.getSignInProviderName().getIdProviderName());
    }

    public static final boolean isSignInWithGoogleFlow(BrokerInteractiveTokenCommandParameters brokerInteractiveTokenCommandParameters) {
        Intrinsics.checkNotNullParameter(brokerInteractiveTokenCommandParameters, "<this>");
        HashMap<String, String> requestHeaders = brokerInteractiveTokenCommandParameters.getRequestHeaders();
        if (requestHeaders != null) {
            return requestHeaders.containsKey(MsaFederationConstants.MSA_ID_TOKEN_HEADER_KEY);
        }
        return false;
    }
}
