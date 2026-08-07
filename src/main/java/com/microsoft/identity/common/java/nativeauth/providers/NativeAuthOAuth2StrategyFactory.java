package com.microsoft.identity.common.java.nativeauth.providers;

import com.microsoft.identity.common.java.nativeauth.providers.interactors.JITInteractor;
import com.microsoft.identity.common.java.nativeauth.providers.interactors.ResetPasswordInteractor;
import com.microsoft.identity.common.java.nativeauth.providers.interactors.SignInInteractor;
import com.microsoft.identity.common.java.nativeauth.providers.interactors.SignUpInteractor;
import com.microsoft.identity.common.java.net.UrlConnectionHttpClient;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeAuthOAuth2StrategyFactory.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2StrategyFactory;", "", "()V", "Companion", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NativeAuthOAuth2StrategyFactory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: NativeAuthOAuth2StrategyFactory.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2StrategyFactory$Companion;", "", "()V", "createStrategy", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Strategy;", "config", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Configuration;", "strategyParameters", "Lcom/microsoft/identity/common/java/providers/oauth2/OAuth2StrategyParameters;", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NativeAuthOAuth2Strategy createStrategy(NativeAuthOAuth2Configuration config, OAuth2StrategyParameters strategyParameters) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(strategyParameters, "strategyParameters");
            UrlConnectionHttpClient defaultInstance = UrlConnectionHttpClient.getDefaultInstance();
            Intrinsics.checkNotNullExpressionValue(defaultInstance, "getDefaultInstance()");
            SignInInteractor signInInteractor = new SignInInteractor(defaultInstance, new NativeAuthRequestProvider(config), new NativeAuthResponseHandler());
            UrlConnectionHttpClient defaultInstance2 = UrlConnectionHttpClient.getDefaultInstance();
            Intrinsics.checkNotNullExpressionValue(defaultInstance2, "getDefaultInstance()");
            SignUpInteractor signUpInteractor = new SignUpInteractor(defaultInstance2, new NativeAuthRequestProvider(config), new NativeAuthResponseHandler());
            UrlConnectionHttpClient defaultInstance3 = UrlConnectionHttpClient.getDefaultInstance();
            Intrinsics.checkNotNullExpressionValue(defaultInstance3, "getDefaultInstance()");
            ResetPasswordInteractor resetPasswordInteractor = new ResetPasswordInteractor(defaultInstance3, new NativeAuthRequestProvider(config), new NativeAuthResponseHandler());
            UrlConnectionHttpClient defaultInstance4 = UrlConnectionHttpClient.getDefaultInstance();
            Intrinsics.checkNotNullExpressionValue(defaultInstance4, "getDefaultInstance()");
            return new NativeAuthOAuth2Strategy(strategyParameters, config, signInInteractor, signUpInteractor, resetPasswordInteractor, new JITInteractor(defaultInstance4, new NativeAuthRequestProvider(config), new NativeAuthResponseHandler()));
        }
    }
}
