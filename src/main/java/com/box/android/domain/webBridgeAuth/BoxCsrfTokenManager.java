package com.box.android.domain.webBridgeAuth;

import android.webkit.CookieManager;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxCsrfTokenManager.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/domain/webBridgeAuth/BoxCsrfTokenManager;", "Lcom/box/android/domain/webBridgeAuth/IBoxCsrfTokenManager;", "cookieManager", "Landroid/webkit/CookieManager;", "getRandomUUID", "Lkotlin/Function0;", "", "<init>", "(Landroid/webkit/CookieManager;Lkotlin/jvm/functions/Function0;)V", "tokens", "", "verifyTokenFor", "", "url", "csrfToken", "createSessionFor", "cookieKey", "setCsrfTokenInCookies", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxCsrfTokenManager implements IBoxCsrfTokenManager {
    private final CookieManager cookieManager;
    private final Function0<String> getRandomUUID;
    private final Map<String, String> tokens;

    public BoxCsrfTokenManager(CookieManager cookieManager, Function0<String> getRandomUUID) {
        Intrinsics.checkNotNullParameter(cookieManager, "cookieManager");
        Intrinsics.checkNotNullParameter(getRandomUUID, "getRandomUUID");
        this.cookieManager = cookieManager;
        this.getRandomUUID = getRandomUUID;
        this.tokens = new LinkedHashMap();
    }

    @Override // com.box.android.domain.webBridgeAuth.IBoxCsrfTokenManager
    public boolean verifyTokenFor(String url, String csrfToken) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(csrfToken, "csrfToken");
        return Intrinsics.areEqual(this.tokens.get(url), csrfToken);
    }

    @Override // com.box.android.domain.webBridgeAuth.IBoxCsrfTokenManager
    public boolean createSessionFor(String cookieKey, String url) {
        Intrinsics.checkNotNullParameter(cookieKey, "cookieKey");
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            String strInvoke = this.getRandomUUID.invoke();
            this.tokens.put(url, strInvoke);
            setCsrfTokenInCookies(cookieKey, strInvoke, url);
            return true;
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Failed to create session for URL: " + url, e);
            return false;
        }
    }

    private final void setCsrfTokenInCookies(String cookieKey, String csrfToken, String url) {
        this.cookieManager.setAcceptCookie(true);
        this.cookieManager.setCookie(url, cookieKey + SimpleComparison.EQUAL_TO_OPERATION + csrfToken);
        this.cookieManager.flush();
    }
}
