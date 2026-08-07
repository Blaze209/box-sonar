package com.pspdfkit.document.html;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/pspdfkit/document/html/WebViewSecurityPolicy;", "", "<init>", "()V", "webViewSettingsCustomizer", "Lcom/pspdfkit/document/html/WebViewSettingsCustomizer;", "getWebViewSettingsCustomizer", "()Lcom/pspdfkit/document/html/WebViewSettingsCustomizer;", "setWebViewSettingsCustomizer", "(Lcom/pspdfkit/document/html/WebViewSettingsCustomizer;)V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WebViewSecurityPolicy {
    private static WebViewSettingsCustomizer webViewSettingsCustomizer;
    public static final WebViewSecurityPolicy INSTANCE = new WebViewSecurityPolicy();
    public static final int $stable = 8;

    private WebViewSecurityPolicy() {
    }

    public final WebViewSettingsCustomizer getWebViewSettingsCustomizer() {
        return webViewSettingsCustomizer;
    }

    public final void setWebViewSettingsCustomizer(WebViewSettingsCustomizer webViewSettingsCustomizer2) {
        webViewSettingsCustomizer = webViewSettingsCustomizer2;
    }
}
