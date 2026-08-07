package com.box.android.data.webBridgeAuth;

import com.box.android.domain.services.AuthTokenService;
import com.box.android.domain.webBridgeAuth.AuthenticatedWebClient;
import com.box.android.domain.webBridgeAuth.IBoxCsrfTokenManager;
import com.box.android.domain.webBridgeAuth.IBoxWebBridgeAuthenticator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxWebBridgeAuthenticator.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/webBridgeAuth/BoxWebBridgeAuthenticator;", "Lcom/box/android/domain/webBridgeAuth/IBoxWebBridgeAuthenticator;", "validator", "Lcom/box/android/domain/webBridgeAuth/IBoxCsrfTokenManager;", "authTokenService", "Lcom/box/android/domain/services/AuthTokenService;", "<init>", "(Lcom/box/android/domain/webBridgeAuth/IBoxCsrfTokenManager;Lcom/box/android/domain/services/AuthTokenService;)V", "getValidator", "()Lcom/box/android/domain/webBridgeAuth/IBoxCsrfTokenManager;", "getAuthTokenService", "()Lcom/box/android/domain/services/AuthTokenService;", "authenticate", "Lcom/box/android/domain/webBridgeAuth/AuthenticatedWebClient;", "url", "", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxWebBridgeAuthenticator implements IBoxWebBridgeAuthenticator {
    public static final String CSRF_TOKEN_NAME = "box-native-app-csrf-token";
    private final AuthTokenService authTokenService;
    private final IBoxCsrfTokenManager validator;

    @Inject
    public BoxWebBridgeAuthenticator(IBoxCsrfTokenManager validator, AuthTokenService authTokenService) {
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(authTokenService, "authTokenService");
        this.validator = validator;
        this.authTokenService = authTokenService;
    }

    public final AuthTokenService getAuthTokenService() {
        return this.authTokenService;
    }

    public final IBoxCsrfTokenManager getValidator() {
        return this.validator;
    }

    @Override // com.box.android.domain.webBridgeAuth.IBoxWebBridgeAuthenticator
    public AuthenticatedWebClient authenticate(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (!this.validator.createSessionFor(CSRF_TOKEN_NAME, url)) {
            throw new IllegalStateException("Failed to create authenticated session for URL: " + url);
        }
        return new BoxAuthBridgeWebClient(url, this.validator, this.authTokenService);
    }
}
