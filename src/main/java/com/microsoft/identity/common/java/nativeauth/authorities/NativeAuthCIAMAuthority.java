package com.microsoft.identity.common.java.nativeauth.authorities;

import com.microsoft.identity.common.java.authorities.Authority;
import com.microsoft.identity.common.java.authorities.CIAMAuthority;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthOAuth2Configuration;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthOAuth2Strategy;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthOAuth2StrategyFactory;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeAuthCIAMAuthority.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J(\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\u00032\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/authorities/NativeAuthCIAMAuthority;", "Lcom/microsoft/identity/common/java/authorities/CIAMAuthority;", "authorityUrl", "", "clientId", "(Ljava/lang/String;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "createNativeAuthOAuth2Configuration", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Configuration;", "challengeTypes", "", NativeAuthPublicClientApplicationConfiguration.NativeAuthSerializedNames.CAPABILITIES, "createOAuth2Strategy", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Strategy;", "parameters", "Lcom/microsoft/identity/common/java/providers/oauth2/OAuth2StrategyParameters;", "getCapabilities", "getChallengeTypesWithDefault", "Companion", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NativeAuthCIAMAuthority extends CIAMAuthority {
    private static final boolean NATIVE_AUTH_USE_OPENID_CONFIGURATION = false;
    private final String authorityUrl;
    private final String clientId;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "NativeAuthCIAMAuthority";

    public final String getClientId() {
        return this.clientId;
    }

    /* JADX INFO: compiled from: NativeAuthCIAMAuthority.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/authorities/NativeAuthCIAMAuthority$Companion;", "", "()V", "NATIVE_AUTH_USE_OPENID_CONFIGURATION", "", "TAG", "", "kotlin.jvm.PlatformType", "getAuthorityFromAuthorityUrl", "Lcom/microsoft/identity/common/java/nativeauth/authorities/NativeAuthCIAMAuthority;", "authorityUrl", "clientId", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NativeAuthCIAMAuthority getAuthorityFromAuthorityUrl(String authorityUrl, String clientId) throws Exception {
            Intrinsics.checkNotNullParameter(authorityUrl, "authorityUrl");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Authority authorityFromAuthorityUrl = Authority.getAuthorityFromAuthorityUrl(authorityUrl);
            if (authorityFromAuthorityUrl instanceof NativeAuthCIAMAuthority) {
                return (NativeAuthCIAMAuthority) authorityFromAuthorityUrl;
            }
            if (authorityFromAuthorityUrl instanceof CIAMAuthority) {
                String string = ((CIAMAuthority) authorityFromAuthorityUrl).getAuthorityUri().toString();
                Intrinsics.checkNotNullExpressionValue(string, "authority.authorityUri.toString()");
                return new NativeAuthCIAMAuthority(string, clientId);
            }
            throw new ClientException("native_auth_invalid_ciam_authority");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAuthCIAMAuthority(String authorityUrl, String clientId) {
        super(authorityUrl);
        Intrinsics.checkNotNullParameter(authorityUrl, "authorityUrl");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        this.authorityUrl = authorityUrl;
        this.clientId = clientId;
        this.mAuthorityTypeString = Authority.AAD_NA;
        this.mAuthorityUrlString = authorityUrl;
    }

    private final NativeAuthOAuth2Configuration createNativeAuthOAuth2Configuration(List<String> challengeTypes, List<String> capabilities) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, null, TAG2 + ".createNativeAuthOAuth2Configuration");
        URL authorityURL = getAuthorityURL();
        Intrinsics.checkNotNullExpressionValue(authorityURL, "this.authorityURL");
        return new NativeAuthOAuth2Configuration(authorityURL, this.clientId, getChallengeTypesWithDefault(challengeTypes), getCapabilities(capabilities), false, null, 48, null);
    }

    private final String getChallengeTypesWithDefault(List<String> challengeTypes) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, null, TAG2 + ".getChallengeTypesWithDefault");
        if (challengeTypes == null) {
            challengeTypes = CollectionsKt.emptyList();
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.distinct(CollectionsKt.plus((Collection) challengeTypes, (Iterable) CollectionsKt.listOf("redirect"))), " ", null, null, 0, null, null, 62, null);
        Logger.info(TAG2, "Challenge Types used = " + strJoinToString$default);
        return strJoinToString$default;
    }

    private final String getCapabilities(List<String> capabilities) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, null, TAG2 + ".getCapabilities");
        if (capabilities == null) {
            capabilities = CollectionsKt.emptyList();
        }
        return CollectionsKt.joinToString$default(CollectionsKt.distinct(capabilities), " ", null, null, 0, null, null, 62, null);
    }

    @Override // com.microsoft.identity.common.java.authorities.CIAMAuthority, com.microsoft.identity.common.java.authorities.Authority
    public NativeAuthOAuth2Strategy createOAuth2Strategy(OAuth2StrategyParameters parameters) throws ClientException {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        NativeAuthOAuth2Configuration nativeAuthOAuth2ConfigurationCreateNativeAuthOAuth2Configuration = createNativeAuthOAuth2Configuration(parameters.mChallengeTypes, parameters.mCapabilities);
        parameters.setUsingOpenIdConfiguration(false);
        return NativeAuthOAuth2StrategyFactory.INSTANCE.createStrategy(nativeAuthOAuth2ConfigurationCreateNativeAuthOAuth2Configuration, parameters);
    }
}
