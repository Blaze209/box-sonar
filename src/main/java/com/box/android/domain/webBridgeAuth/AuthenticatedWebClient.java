package com.box.android.domain.webBridgeAuth;

import android.net.Uri;
import android.webkit.WebViewClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AuthenticatedWebClient.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00050\u0007H&J\u001e\u0010\t\u001a\u00020\u00052\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f0\u0007H&J\u001e\u0010\r\u001a\u00020\u00052\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00050\u0007H&¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/webBridgeAuth/AuthenticatedWebClient;", "Landroid/webkit/WebViewClient;", "<init>", "()V", "onPageFinished", "", "onFinished", "Lkotlin/Function1;", "", "onShouldOverrideUrlLoading", "shouldOverride", "Landroid/net/Uri;", "", "onReceivedError", "onError", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AuthenticatedWebClient extends WebViewClient {
    public abstract void onPageFinished(Function1<? super String, Unit> onFinished);

    public abstract void onReceivedError(Function1<? super String, Unit> onError);

    public abstract void onShouldOverrideUrlLoading(Function1<? super Uri, Boolean> shouldOverride);
}
