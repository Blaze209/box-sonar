package com.pspdfkit.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.R;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.g60;
import com.pspdfkit.internal.ho;
import com.pspdfkit.internal.i0;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.ky;
import com.pspdfkit.internal.m0;
import com.pspdfkit.internal.my;
import com.pspdfkit.internal.nv;
import com.pspdfkit.internal.q10;
import com.pspdfkit.internal.tr;
import com.pspdfkit.internal.uc;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.wg;
import com.pspdfkit.listeners.OnVisibilityChangedListener;
import com.pspdfkit.listeners.OnVisibilityChangedListenerManager;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Function;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class PdfReaderView extends FrameLayout implements PSPDFKitViews.PSPDFView, my {
    private static final String CSS_STYLE_PATH = wg.b("reader-view.css");
    private static final String HEAD_OPENING_TAG = "<head>";
    private static final String LOG_TAG = "Nutri.PdfReaderView";
    private static final String MIME_TYPE_HTML = "text/html";
    private FrameLayout container;
    private String cssStyle;
    private PdfDocument document;
    private boolean isDisplayed;
    private final OnVisibilityChangedListenerManager listeners;
    private ho loadingView;
    private Disposable reflowDocumentDisposable;
    private boolean reflowDocumentWhenLoaded;
    private String reflowedText;
    private int shadowHeightPx;
    private WebView webView;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.pspdfkit.ui.PdfReaderView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        String reflowedText;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.reflowedText);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.reflowedText = parcel.readString();
        }
    }

    public PdfReaderView(Context context) {
        super(context);
        this.listeners = new OnVisibilityChangedListenerManager();
        this.isDisplayed = false;
        this.reflowDocumentWhenLoaded = false;
        init();
    }

    private boolean canReaderViewBeDisplayed(boolean z) {
        if (!z || ar.b().a(NativeLicenseFeatures.READER_VIEW)) {
            return ar.b().a(NativeLicenseFeatures.READER_VIEW) && doesDeviceSupportReaderView(getContext());
        }
        throw new InvalidNutrientLicenseException("Your current license doesn't allow opening the reader view.");
    }

    private void init() {
        if (canReaderViewBeDisplayed(false)) {
            View viewInflate = View.inflate(getContext(), R.layout.pspdf__reader_view, this);
            getChildAt(0).setBackgroundColor(-1);
            this.container = (FrameLayout) viewInflate.findViewById(R.id.pspdf__reader_container);
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.pspdfkit.ui.PdfReaderView.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PdfReaderView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    PdfReaderView pdfReaderView = PdfReaderView.this;
                    pdfReaderView.setTranslationY(-pdfReaderView.getHeight());
                }
            });
            WebView webViewPrepareWebView = prepareWebView();
            this.webView = webViewPrepareWebView;
            webViewPrepareWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.container.addView(this.webView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadHtmlData$3(WebView webView) throws Throwable {
        webView.setWebViewClient(new WebViewClient() { // from class: com.pspdfkit.ui.PdfReaderView.2
            private boolean handleUri(Uri uri) {
                PdfReaderView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", uri));
                return true;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                return handleUri(Uri.parse(str));
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                return handleUri(webResourceRequest.getUrl());
            }
        });
        webView.loadDataWithBaseURL(null, this.reflowedText, MIME_TYPE_HTML, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$reflowDocument$0() throws Exception {
        String str = this.reflowedText;
        return str != null ? str : new ky(this.document, this).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableSource lambda$reflowDocument$1(String str) throws Throwable {
        return loadHtmlData(this.webView, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$reflowDocument$2() throws Throwable {
        ho hoVar = this.loadingView;
        hoVar.removeCallbacks(hoVar.c);
        hoVar.setVisibility(8);
    }

    private Completable loadHtmlData(final WebView webView, String str) {
        if (this.cssStyle == null) {
            try {
                this.cssStyle = new String(wg.a(getContext().getAssets().open(CSS_STYLE_PATH)), StandardCharsets.UTF_8);
            } catch (IOException unused) {
                throw new IllegalStateException(nv.a(new StringBuilder("Could not read shape CSS style ("), CSS_STYLE_PATH, ") from assets."));
            }
        }
        this.reflowedText = str.replaceFirst(HEAD_OPENING_TAG, "<head><style>" + this.cssStyle + "</style>");
        return Completable.fromAction(new Action() { // from class: com.pspdfkit.ui.PdfReaderView$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.lambda$loadHtmlData$3(webView);
            }
        }).subscribeOn(AndroidSchedulers.mainThread());
    }

    private WebView prepareWebView() {
        try {
            WebView webViewA = uc.a(getContext());
            WebSettings settings = webViewA.getSettings();
            webViewA.setId(R.id.pspdf__reader_wev_view);
            webViewA.setWebChromeClient(new WebChromeClient());
            settings.setDefaultTextEncodingName(StandardCharsets.UTF_8.name());
            settings.setCacheMode(2);
            settings.setJavaScriptEnabled(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
            settings.setDatabaseEnabled(false);
            settings.setGeolocationEnabled(false);
            settings.setDomStorageEnabled(false);
            return webViewA;
        } catch (Throwable th) {
            throw new NutrientException("Could not initialize PdfReaderView.", th);
        }
    }

    private boolean reflowDocument() {
        g60 g60VarC;
        if (this.webView == null || this.document == null) {
            return false;
        }
        Disposable disposable = this.reflowDocumentDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        Single singleFromCallable = Single.fromCallable(new Callable() { // from class: com.pspdfkit.ui.PdfReaderView$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$reflowDocument$0();
            }
        });
        synchronized (ar.class) {
            g60VarC = q10.c();
        }
        this.reflowDocumentDisposable = singleFromCallable.subscribeOn(((m0) g60VarC).a()).flatMapCompletable(new Function() { // from class: com.pspdfkit.ui.PdfReaderView$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$reflowDocument$1((String) obj);
            }
        }).doOnComplete(new Action() { // from class: com.pspdfkit.ui.PdfReaderView$$ExternalSyntheticLambda3
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.lambda$reflowDocument$2();
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe();
        return true;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void addOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener) {
        uw.a(onVisibilityChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.listeners.addOnVisibilityChangedListener(onVisibilityChangedListener);
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void clearDocument() {
        if (canReaderViewBeDisplayed(false) && this.document != null) {
            hide();
            WebView webView = this.webView;
            if (webView != null) {
                webView.destroy();
            }
            this.webView = null;
            this.loadingView = null;
            this.document = null;
            this.reflowedText = null;
        }
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        setPadding(rect.left, rect.top, rect.right, rect.bottom);
        return false;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public PSPDFKitViews.Type getPSPDFViewType() {
        return PSPDFKitViews.Type.VIEW_READER;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void hide() {
        if (canReaderViewBeDisplayed(true)) {
            Disposable disposable = this.reflowDocumentDisposable;
            if (disposable != null) {
                disposable.dispose();
            }
            this.reflowDocumentDisposable = null;
            if (this.isDisplayed) {
                this.isDisplayed = false;
                this.listeners.onHide(this);
                animate().translationY(-getHeight()).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter() { // from class: com.pspdfkit.ui.PdfReaderView.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (PdfReaderView.this.isDisplayed) {
                            return;
                        }
                        super.onAnimationEnd(animator);
                        PdfReaderView.this.setVisibility(4);
                    }
                });
            }
        }
    }

    @Override // com.pspdfkit.internal.my
    public boolean isCanceled() {
        Disposable disposable = this.reflowDocumentDisposable;
        return disposable == null || disposable.isDisposed();
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public boolean isDisplayed() {
        return this.isDisplayed;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.shadowHeightPx = tr.a(a80.a((View) this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        clearDocument();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() + this.shadowHeightPx);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.reflowedText = savedState.reflowedText;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.reflowedText = this.reflowedText;
        return savedState;
    }

    @Override // com.pspdfkit.internal.my
    public void progress(int i, int i2) {
        PdfLog.i(LOG_TAG, String.format(Locale.getDefault(), "Reflowing page %d of %d.", Integer.valueOf(i), Integer.valueOf(i2)), new Object[0]);
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void removeOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener) {
        uw.a(onVisibilityChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.listeners.removeOnVisibilityChangedListener(onVisibilityChangedListener);
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void setDocument(PdfDocument pdfDocument, PdfConfiguration pdfConfiguration) {
        uw.a(pdfDocument, "document", null);
        uw.a(pdfConfiguration, "configuration", null);
        if (canReaderViewBeDisplayed(false) && this.document == null) {
            this.document = pdfDocument;
            ho hoVar = new ho(getContext(), pdfConfiguration.getLoadingProgressDrawable(), pdfConfiguration.getBackgroundColor(), pdfConfiguration.isInvertColors(), pdfConfiguration.isToGrayscale());
            this.loadingView = hoVar;
            hoVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.container.addView(this.loadingView);
            String str = this.reflowedText;
            ho hoVar2 = this.loadingView;
            if (str == null) {
                hoVar2.a(0L);
            } else {
                hoVar2.removeCallbacks(hoVar2.c);
                hoVar2.setVisibility(8);
            }
            if (this.reflowDocumentWhenLoaded) {
                this.reflowDocumentWhenLoaded = false;
                reflowDocument();
            }
        }
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void show() {
        if (canReaderViewBeDisplayed(true) && !this.isDisplayed) {
            this.isDisplayed = true;
            if (!reflowDocument()) {
                this.reflowDocumentWhenLoaded = true;
            }
            this.listeners.onShow(this);
            setVisibility(0);
            animate().translationY(0.0f).setInterpolator(new DecelerateInterpolator()).setListener(null);
            i0 i0VarA = ar.a();
            i0VarA.getClass();
            i0VarA.b.onNext(new Pair<>(Analytics.Event.OPEN_READER_VIEW, new Bundle()));
        }
    }

    public static boolean doesDeviceSupportReaderView(Context context) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("doesDeviceSupportReaderView() may only be called from the main thread.");
        }
        if (context != null) {
            return uc.e(context);
        }
        throw new NullPointerException("context");
    }

    public PdfReaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.listeners = new OnVisibilityChangedListenerManager();
        this.isDisplayed = false;
        this.reflowDocumentWhenLoaded = false;
        init();
    }

    public PdfReaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.listeners = new OnVisibilityChangedListenerManager();
        this.isDisplayed = false;
        this.reflowDocumentWhenLoaded = false;
        init();
    }

    public PdfReaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.listeners = new OnVisibilityChangedListenerManager();
        this.isDisplayed = false;
        this.reflowDocumentWhenLoaded = false;
        init();
    }
}
