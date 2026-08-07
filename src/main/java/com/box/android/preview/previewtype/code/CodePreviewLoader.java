package com.box.android.preview.previewtype.code;

import android.text.Html;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CodePreviewLoader.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/previewtype/code/CodePreviewLoader;", "", "codeContent", "", "fileExtension", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "initWebView", "Landroid/webkit/WebView;", "webView", "isDarkModeEnabled", "", "getBackgroundColor", "", "isDarkMode", "loadContent", "", "loadMarkdownPage", "loadCodePage", "isMarkdown", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CodePreviewLoader {
    public static final int $stable = 0;
    private final String codeContent;
    private final String fileExtension;

    public CodePreviewLoader(String codeContent, String fileExtension) {
        Intrinsics.checkNotNullParameter(codeContent, "codeContent");
        Intrinsics.checkNotNullParameter(fileExtension, "fileExtension");
        this.codeContent = codeContent;
        this.fileExtension = fileExtension;
    }

    public final WebView initWebView(WebView webView) throws IOException {
        Intrinsics.checkNotNullParameter(webView, "webView");
        boolean zIsDarkModeEnabled = isDarkModeEnabled(webView);
        webView.setBackgroundColor(getBackgroundColor(zIsDarkModeEnabled));
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccess(false);
        settings.setDomStorageEnabled(false);
        settings.setCacheMode(2);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(isMarkdown() ? new MarkDownPreviewWebViewClient(this.codeContent) : new CodeMirrorWebViewClient(zIsDarkModeEnabled, this.fileExtension));
        loadContent(webView);
        return webView;
    }

    private final boolean isDarkModeEnabled(WebView webView) {
        return (webView.getContext().getResources().getConfiguration().uiMode & 48) == 32;
    }

    private final int getBackgroundColor(boolean isDarkMode) {
        Color.Companion companion = Color.INSTANCE;
        return ColorKt.m6868toArgb8_81llA(isDarkMode ? companion.m6849getTransparent0d7_KjU() : companion.m6851getWhite0d7_KjU());
    }

    public final void loadContent(WebView webView) throws IOException {
        Intrinsics.checkNotNullParameter(webView, "webView");
        if (isMarkdown()) {
            loadMarkdownPage(webView);
        } else {
            loadCodePage(webView);
        }
    }

    private final void loadMarkdownPage(WebView webView) throws IOException {
        InputStream inputStreamOpen = webView.getContext().getAssets().open("showdown/index.html");
        Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
        Reader inputStreamReader = new InputStreamReader(inputStreamOpen, Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            String text = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            webView.loadDataWithBaseURL("file:///android_asset/", text, "text/html", "UTF-8", null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedReader, th);
                throw th2;
            }
        }
    }

    private final void loadCodePage(WebView webView) throws IOException {
        InputStream inputStreamOpen = webView.getContext().getAssets().open("codemirror/index.html");
        Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
        Reader inputStreamReader = new InputStreamReader(inputStreamOpen, Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            String text = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            String strEscapeHtml = Html.escapeHtml(this.codeContent);
            Intrinsics.checkNotNullExpressionValue(strEscapeHtml, "escapeHtml(...)");
            webView.loadDataWithBaseURL("file:///android_asset/", StringsKt.replace$default(text, "%%%CONTENT%%%", strEscapeHtml, false, 4, (Object) null), "text/html", "UTF-8", null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedReader, th);
                throw th2;
            }
        }
    }

    private final boolean isMarkdown() {
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"md", "markdown"});
        String lowerCase = this.fileExtension.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return listListOf.contains(lowerCase);
    }
}
