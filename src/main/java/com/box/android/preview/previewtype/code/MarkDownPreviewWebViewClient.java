package com.box.android.preview.previewtype.code;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.box.androidsdk.content.utils.BoxLogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: CodePreviewLoader.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/previewtype/code/MarkDownPreviewWebViewClient;", "Landroid/webkit/WebViewClient;", "mdCode", "", "<init>", "(Ljava/lang/String;)V", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "shouldOverrideUrlLoading", "", "request", "Landroid/webkit/WebResourceRequest;", "escapeMarkdownContent", "content", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MarkDownPreviewWebViewClient extends WebViewClient {
    public static final int $stable = 8;
    private final String mdCode;

    public MarkDownPreviewWebViewClient(String mdCode) {
        Intrinsics.checkNotNullParameter(mdCode, "mdCode");
        this.mdCode = mdCode;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        String strEscapeMarkdownContent = escapeMarkdownContent(this.mdCode);
        if (view != null) {
            view.evaluateJavascript("javascript:renderMarkdownContent('" + strEscapeMarkdownContent + "');", null);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (view == null) {
            return true;
        }
        try {
            Context context = view.getContext();
            if (context == null) {
                return true;
            }
            context.startActivity(new Intent("android.intent.action.VIEW", request.getUrl()));
            return true;
        } catch (Exception e) {
            BoxLogUtils.e("BoxPreviewCodeFragment", "shouldOverrideUrlLoading", e);
            return true;
        }
    }

    private final String escapeMarkdownContent(String content) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(content, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), StringUtils.CR, "\\r", false, 4, (Object) null), "\"", "\\\"", false, 4, (Object) null), "'", "\\'", false, 4, (Object) null);
    }
}
