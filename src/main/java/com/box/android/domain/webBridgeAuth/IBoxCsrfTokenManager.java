package com.box.android.domain.webBridgeAuth;

import kotlin.Metadata;

/* JADX INFO: compiled from: IBoxCsrfTokenManager.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/webBridgeAuth/IBoxCsrfTokenManager;", "", "createSessionFor", "", "cookieKey", "", "url", "verifyTokenFor", "csrfToken", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IBoxCsrfTokenManager {
    boolean createSessionFor(String cookieKey, String url);

    boolean verifyTokenFor(String url, String csrfToken);
}
