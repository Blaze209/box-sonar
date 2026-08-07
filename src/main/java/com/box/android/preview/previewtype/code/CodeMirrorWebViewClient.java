package com.box.android.preview.previewtype.code;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CodePreviewLoader.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/box/android/preview/previewtype/code/CodeMirrorWebViewClient;", "Landroid/webkit/WebViewClient;", "isDarkMode", "", "fileExtension", "", "<init>", "(ZLjava/lang/String;)V", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CodeMirrorWebViewClient extends WebViewClient {
    public static final int $stable = 8;
    private final String fileExtension;
    private final boolean isDarkMode;

    public CodeMirrorWebViewClient(boolean z, String fileExtension) {
        Intrinsics.checkNotNullParameter(fileExtension, "fileExtension");
        this.isDarkMode = z;
        this.fileExtension = fileExtension;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        if (view != null) {
            view.evaluateJavascript("javascript:configureCodeMirror(" + this.isDarkMode + ", '" + this.fileExtension + "');", null);
        }
    }
}
