package com.pspdfkit.document.html;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.print.LayoutResultCallbackShim;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.WriteResultCallbackShim;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.PdfDocumentLoader;
import com.pspdfkit.document.processor.NewPage;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.s40;
import com.pspdfkit.internal.u40;
import com.pspdfkit.internal.uc;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.wg;
import com.pspdfkit.utils.Size;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class HtmlToPdfConverter {
    private static final int DEFAULT_DENSITY_DPI = 300;
    private static final String DEFAULT_WEB_VIEW_TITLE = "about:blank";
    private static final String INTERNAL_PAGE_SIZE_ID = "page_size";
    private static final String INTERNAL_RESOLUTION_ID = "resolution";
    private static final String MIME_TYPE_HTML = "text/html";
    private final String baseUrl;
    private final Context context;
    private String customTitle;
    private final String htmlString;
    private PageLoadingProgressListener pageLoadingProgressListener;
    private ResourceInterceptor resourceInterceptor;
    private final Uri sourceUri;
    private PrintAttributes.MediaSize mediaSize = pdfSizeToMediaSize(NewPage.PAGE_SIZE_A4);
    private int densityDpi = 300;
    private boolean isJavascriptEnabled = true;
    private long timeoutMs = 30000;

    public interface PageLoadingProgressListener {
        void onPageLoadingProgress(int i);
    }

    private HtmlToPdfConverter(Context context, Uri uri, String str, String str2) {
        if (!ar.b().a(NativeLicenseFeatures.WEBKIT_HTML_CONVERSION)) {
            throw new InvalidNutrientLicenseException("Your current license does not allow HTML-to-PDF conversion.");
        }
        uw.a(context, "context", null);
        this.context = context;
        if (uri != null) {
            this.sourceUri = uri.normalizeScheme();
            this.htmlString = null;
            this.baseUrl = null;
        } else {
            if (str == null) {
                throw new IllegalArgumentException("Either uri or htmlString must be set.");
            }
            this.sourceUri = Uri.EMPTY;
            this.htmlString = str;
            this.baseUrl = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createPdfFromPrintAdapter, reason: merged with bridge method [inline-methods] */
    public Completable lambda$convertToPdfAsync$5(final PrintDocumentAdapter printDocumentAdapter, final File file, final CancellationSignal cancellationSignal) {
        return Completable.create(new CompletableOnSubscribe() { // from class: com.pspdfkit.document.html.HtmlToPdfConverter$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.core.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) throws Throwable {
                this.f$0.lambda$createPdfFromPrintAdapter$11(printDocumentAdapter, file, cancellationSignal, completableEmitter);
            }
        });
    }

    @Deprecated
    public static HtmlToPdfConverter fromHTMLString(Context context, String str, String str2) {
        return new HtmlToPdfConverter(context, null, str, str2);
    }

    public static HtmlToPdfConverter fromHtmlString(Context context, String str, String str2) {
        return new HtmlToPdfConverter(context, null, str, str2);
    }

    public static HtmlToPdfConverter fromUri(Context context, Uri uri) {
        return new HtmlToPdfConverter(context, uri, null, null);
    }

    private Maybe<String> getDocumentTitle(final WebView webView) {
        return Maybe.defer(new Supplier() { // from class: com.pspdfkit.document.html.HtmlToPdfConverter$$ExternalSyntheticLambda6
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return this.f$0.lambda$getDocumentTitle$14(webView);
            }
        }).subscribeOn(AndroidSchedulers.mainThread());
    }

    private PrintAttributes getPrintAttributes() {
        PrintAttributes.Builder mediaSize = new PrintAttributes.Builder().setColorMode(2).setMediaSize(this.mediaSize);
        int i = this.densityDpi;
        return mediaSize.setResolution(new PrintAttributes.Resolution(INTERNAL_RESOLUTION_ID, INTERNAL_RESOLUTION_ID, i, i)).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SingleSource lambda$convertToPdfAsync$0() throws Throwable {
        File fileA = wg.a(this.context, "pdf");
        return fileA == null ? Single.error(new IOException("Failed to create output file.")) : Single.just(fileA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SingleSource lambda$convertToPdfAsync$1(File file) throws Throwable {
        return convertToPdfAsync(file).toSingleDefault(file);
    }

    static /* synthetic */ void lambda$convertToPdfAsync$2(WebView[] webViewArr, WebView webView) throws Throwable {
        webViewArr[0] = webView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SingleSource lambda$convertToPdfAsync$3(WebView webView) throws Throwable {
        return loadHtmlData(webView).toSingleDefault(webView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableSource lambda$convertToPdfAsync$6(File file, WebView[] webViewArr) throws Throwable {
        return performDocumentPostprocessing(file, webViewArr[0]);
    }

    static /* synthetic */ void lambda$convertToPdfAsync$7(WebView[] webViewArr) throws Throwable {
        WebView webView = webViewArr[0];
        if (webView != null) {
            webView.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createPdfFromPrintAdapter$11(final PrintDocumentAdapter printDocumentAdapter, final File file, final CancellationSignal cancellationSignal, final CompletableEmitter completableEmitter) throws Throwable {
        s40.a(new Runnable() { // from class: com.pspdfkit.document.html.HtmlToPdfConverter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createPdfFromPrintAdapter$10(printDocumentAdapter, file, cancellationSignal, completableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadHtmlData$9(WebView webView, CompletableEmitter completableEmitter) throws Throwable {
        webView.setWebViewClient(new WebViewClientImpl(this.context, this.sourceUri, this.resourceInterceptor, completableEmitter));
        String str = this.htmlString;
        if (str != null) {
            webView.loadDataWithBaseURL(this.baseUrl, str, MIME_TYPE_HTML, null, null);
        } else {
            webView.loadUrl(this.sourceUri.toString());
        }
    }

    static /* synthetic */ void lambda$performDocumentPostprocessing$12(String str, PdfDocument pdfDocument) throws Throwable {
        pdfDocument.getPdfMetadata().setTitle(str);
        pdfDocument.saveIfModified();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableSource lambda$performDocumentPostprocessing$13(File file, final String str) throws Throwable {
        return PdfDocumentLoader.openDocumentAsync(this.context, Uri.fromFile(file)).subscribeOn(Schedulers.io()).doOnSuccess(new Consumer() { // from class: com.pspdfkit.document.html.HtmlToPdfConverter$$ExternalSyntheticLambda8
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                HtmlToPdfConverter.lambda$performDocumentPostprocessing$12(str, (PdfDocument) obj);
            }
        }).ignoreElement();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SingleSource lambda$prepareWebView$8() throws Throwable {
        try {
            WebView webViewA = uc.a(this.context);
            WebSettings settings = webViewA.getSettings();
            PageLoadingProgressListener pageLoadingProgressListener = this.pageLoadingProgressListener;
            if (pageLoadingProgressListener != null) {
                webViewA.setWebChromeClient(new WebChromeClientImpl(pageLoadingProgressListener));
            }
            settings.setDefaultTextEncodingName(StandardCharsets.UTF_8.name());
            settings.setCacheMode(2);
            settings.setJavaScriptEnabled(this.isJavascriptEnabled);
            settings.setJavaScriptCanOpenWindowsAutomatically(this.isJavascriptEnabled);
            settings.setAllowUniversalAccessFromFileURLs(false);
            settings.setDatabaseEnabled(false);
            settings.setGeolocationEnabled(false);
            settings.setDomStorageEnabled(false);
            WebViewSettingsCustomizer webViewSettingsCustomizer = WebViewSecurityPolicy.INSTANCE.getWebViewSettingsCustomizer();
            if (webViewSettingsCustomizer != null) {
                webViewSettingsCustomizer.customize(settings);
            }
            return Single.just(webViewA);
        } catch (Throwable th) {
            throw new HtmlConversionException("Could not initialize HTML-to-PDF conversion.", th);
        }
    }

    private Completable loadHtmlData(final WebView webView) {
        return Completable.create(new CompletableOnSubscribe() { // from class: com.pspdfkit.document.html.HtmlToPdfConverter$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.core.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) throws Throwable {
                this.f$0.lambda$loadHtmlData$9(webView, completableEmitter);
            }
        });
    }

    private static PrintAttributes.MediaSize pdfSizeToMediaSize(Size size) {
        return new PrintAttributes.MediaSize(INTERNAL_PAGE_SIZE_ID, INTERNAL_PAGE_SIZE_ID, ptToMil(size.width), ptToMil(size.height));
    }

    private Completable performDocumentPostprocessing(final File file, WebView webView) {
        return getDocumentTitle(webView).onErrorComplete().flatMapCompletable(new Function() { // from class: com.pspdfkit.document.html.HtmlToPdfConverter$$ExternalSyntheticLambda5
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$performDocumentPostprocessing$13(file, (String) obj);
            }
        });
    }

    private Single<WebView> prepareWebView() {
        return Single.defer(new Supplier() { // from class: com.pspdfkit.document.html.HtmlToPdfConverter$$ExternalSyntheticLambda7
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return this.f$0.lambda$prepareWebView$8();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: printToFile, reason: merged with bridge method [inline-methods] */
    public void lambda$createPdfFromPrintAdapter$10(final PrintDocumentAdapter printDocumentAdapter, File file, final CancellationSignal cancellationSignal, final CompletableEmitter completableEmitter) {
        try {
            final ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(file, ParcelFileDescriptor.parseMode("w"));
            final WriteResultCallbackShim writeResultCallbackShim = new WriteResultCallbackShim() { // from class: com.pspdfkit.document.html.HtmlToPdfConverter.1
                @Override // android.print.PrintDocumentAdapter.WriteResultCallback
                public void onWriteFailed(CharSequence charSequence) {
                    super.onWriteFailed(charSequence);
                    CompletableEmitter completableEmitter2 = completableEmitter;
                    StringBuilder sb = new StringBuilder("Can't write PDF file. ");
                    Charset charset = u40.a;
                    completableEmitter2.tryOnError(new HtmlConversionException(sb.append(charSequence == null ? "" : charSequence.toString()).toString()));
                    HtmlToPdfConverter.this.tryClose(completableEmitter, parcelFileDescriptorOpen);
                }

                @Override // android.print.PrintDocumentAdapter.WriteResultCallback
                public void onWriteFinished(PageRange[] pageRangeArr) {
                    printDocumentAdapter.onFinish();
                    if (HtmlToPdfConverter.this.tryClose(completableEmitter, parcelFileDescriptorOpen)) {
                        completableEmitter.onComplete();
                    }
                }
            };
            LayoutResultCallbackShim layoutResultCallbackShim = new LayoutResultCallbackShim() { // from class: com.pspdfkit.document.html.HtmlToPdfConverter.2
                @Override // android.print.PrintDocumentAdapter.LayoutResultCallback
                public void onLayoutCancelled() {
                    super.onLayoutCancelled();
                    completableEmitter.tryOnError(new HtmlConversionException("HTML layout has been cancelled."));
                    HtmlToPdfConverter.this.tryClose(completableEmitter, parcelFileDescriptorOpen);
                }

                @Override // android.print.PrintDocumentAdapter.LayoutResultCallback
                public void onLayoutFailed(CharSequence charSequence) {
                    super.onLayoutFailed(charSequence);
                    CompletableEmitter completableEmitter2 = completableEmitter;
                    StringBuilder sb = new StringBuilder("Can't layout HTML. ");
                    Charset charset = u40.a;
                    completableEmitter2.tryOnError(new HtmlConversionException(sb.append(charSequence == null ? "" : charSequence.toString()).toString()));
                    HtmlToPdfConverter.this.tryClose(completableEmitter, parcelFileDescriptorOpen);
                }

                @Override // android.print.PrintDocumentAdapter.LayoutResultCallback
                public void onLayoutFinished(PrintDocumentInfo printDocumentInfo, boolean z) {
                    super.onLayoutFinished(printDocumentInfo, z);
                    if (completableEmitter.isDisposed()) {
                        HtmlToPdfConverter.this.tryClose(completableEmitter, parcelFileDescriptorOpen);
                    } else {
                        printDocumentAdapter.onWrite(new PageRange[]{PageRange.ALL_PAGES}, parcelFileDescriptorOpen, cancellationSignal, writeResultCallbackShim);
                    }
                }
            };
            printDocumentAdapter.onStart();
            printDocumentAdapter.onLayout(null, getPrintAttributes(), cancellationSignal, layoutResultCallbackShim, new Bundle());
        } catch (Throwable th) {
            completableEmitter.tryOnError(new HtmlConversionException("Unexpected error when performing HTML-to-PDF conversion.", th));
        }
    }

    private static int ptToMil(float f) {
        return Math.round(f * 0.013888889f * 1000.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tryClose(CompletableEmitter completableEmitter, ParcelFileDescriptor parcelFileDescriptor) {
        try {
            parcelFileDescriptor.close();
            return true;
        } catch (IOException e) {
            completableEmitter.tryOnError(new HtmlConversionException("Can't write PDF file.", e));
            return false;
        }
    }

    public Completable convertToPdfAsync(final File file) {
        uw.a(file, "outputFile", null);
        final CancellationSignal cancellationSignal = new CancellationSignal();
        final WebView[] webViewArr = new WebView[1];
        return prepareWebView().doOnSuccess(new Consumer() { // from class: com.pspdfkit.document.html.HtmlToPdfConverter$$ExternalSyntheticLambda9
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                HtmlToPdfConverter.lambda$convertToPdfAsync$2(webViewArr, (WebView) obj);
            }
        }).flatMap(new Function() { // from class: com.pspdfkit.document.html.HtmlToPdfConverter$$ExternalSyntheticLambda10
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$convertToPdfAsync$3((WebView) obj);
            }
        }).timeout(this.timeoutMs, TimeUnit.MILLISECONDS, Single.error(new HtmlConversionException("HTML loading timed out."))).map(new Function() { // from class: com.pspdfkit.document.html.HtmlToPdfConverter$$ExternalSyntheticLambda11
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return ((WebView) obj).createPrintDocumentAdapter(file.getName());
            }
        }).flatMapCompletable(new Function() { // from class: com.pspdfkit.document.html.HtmlToPdfConverter$$ExternalSyntheticLambda12
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$convertToPdfAsync$5(file, cancellationSignal, (PrintDocumentAdapter) obj);
            }
        }).doOnDispose(new Action() { // from class: com.pspdfkit.document.html.HtmlToPdfConverter$$ExternalSyntheticLambda13
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                cancellationSignal.cancel();
            }
        }).subscribeOn(AndroidSchedulers.mainThread()).andThen(Completable.defer(new Supplier() { // from class: com.pspdfkit.document.html.HtmlToPdfConverter$$ExternalSyntheticLambda14
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return this.f$0.lambda$convertToPdfAsync$6(file, webViewArr);
            }
        })).observeOn(AndroidSchedulers.mainThread()).doFinally(new Action() { // from class: com.pspdfkit.document.html.HtmlToPdfConverter$$ExternalSyntheticLambda15
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                HtmlToPdfConverter.lambda$convertToPdfAsync$7(webViewArr);
            }
        });
    }

    public HtmlToPdfConverter density(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("density cannot be less than or equal to zero.");
        }
        this.densityDpi = i;
        return this;
    }

    public HtmlToPdfConverter pageSize(Size size) {
        uw.a(size, "pageSize", null);
        this.mediaSize = pdfSizeToMediaSize(size);
        return this;
    }

    public HtmlToPdfConverter setJavaScriptEnabled(boolean z) {
        this.isJavascriptEnabled = z;
        return this;
    }

    public HtmlToPdfConverter setPageLoadingProgressListener(PageLoadingProgressListener pageLoadingProgressListener) {
        this.pageLoadingProgressListener = pageLoadingProgressListener;
        return this;
    }

    public HtmlToPdfConverter setResourceInterceptor(ResourceInterceptor resourceInterceptor) {
        this.resourceInterceptor = resourceInterceptor;
        return this;
    }

    public HtmlToPdfConverter timeout(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout cannot be less than or equal to zero.");
        }
        this.timeoutMs = j;
        return this;
    }

    public HtmlToPdfConverter title(String str) {
        this.customTitle = str;
        return this;
    }

    public static boolean doesDeviceSupportConversion(Context context) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("doesDeviceSupportConversion() may only be called from the main thread.");
        }
        if (context != null) {
            return uc.e(context);
        }
        throw new NullPointerException("context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MaybeSource lambda$getDocumentTitle$14(WebView webView) throws Throwable {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("getDocumentTitle() must be executed on the main thread.");
        }
        String title = this.customTitle;
        if (TextUtils.isEmpty(title) && webView != null) {
            title = webView.getTitle();
            if (DEFAULT_WEB_VIEW_TITLE.equals(title)) {
                title = null;
            }
        }
        return (title == null || TextUtils.isEmpty(title)) ? Maybe.empty() : Maybe.just(title);
    }

    public Single<File> convertToPdfAsync() {
        return Single.defer(new Supplier() { // from class: com.pspdfkit.document.html.HtmlToPdfConverter$$ExternalSyntheticLambda3
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return this.f$0.lambda$convertToPdfAsync$0();
            }
        }).subscribeOn(Schedulers.io()).flatMap(new Function() { // from class: com.pspdfkit.document.html.HtmlToPdfConverter$$ExternalSyntheticLambda4
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$convertToPdfAsync$1((File) obj);
            }
        });
    }
}
