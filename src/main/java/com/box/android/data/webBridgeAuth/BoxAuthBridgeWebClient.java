package com.box.android.data.webBridgeAuth;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.box.android.domain.services.AuthTokenService;
import com.box.android.domain.webBridgeAuth.AuthenticatedWebClient;
import com.box.android.domain.webBridgeAuth.IBoxCsrfTokenManager;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BoxAuthBridgeWebClient.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u001b\u001a\u00020\u000e2\u0014\u0010\u001c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u001e\u0010\u001d\u001a\u00020\u000e2\u0014\u0010\u001e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\rH\u0016J\u001e\u0010\u001f\u001a\u00020\u000e2\u0014\u0010 \u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u001c\u0010!\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\"\u0010&\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0018\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0003H\u0016J&\u0010\u001f\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0018\u0010,\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0003H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u00060"}, d2 = {"Lcom/box/android/data/webBridgeAuth/BoxAuthBridgeWebClient;", "Lcom/box/android/domain/webBridgeAuth/AuthenticatedWebClient;", "primaryUrl", "", "boxCsrfTokenManager", "Lcom/box/android/domain/webBridgeAuth/IBoxCsrfTokenManager;", "authTokenService", "Lcom/box/android/domain/services/AuthTokenService;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/webBridgeAuth/IBoxCsrfTokenManager;Lcom/box/android/domain/services/AuthTokenService;)V", "getPrimaryUrl", "()Ljava/lang/String;", "onPageFinishedListener", "Lkotlin/Function1;", "", "onShouldOverrideUrlLoadingListener", "Landroid/net/Uri;", "", "onReceivedErrorListener", "channel", "Landroid/webkit/WebMessagePort;", "webMessageCallback", "com/box/android/data/webBridgeAuth/BoxAuthBridgeWebClient$webMessageCallback$2$1", "getWebMessageCallback", "()Lcom/box/android/data/webBridgeAuth/BoxAuthBridgeWebClient$webMessageCallback$2$1;", "webMessageCallback$delegate", "Lkotlin/Lazy;", "onPageFinished", "onFinished", "onShouldOverrideUrlLoading", "shouldOverride", "onReceivedError", "onError", "shouldOverrideUrlLoading", "view", "Landroid/webkit/WebView;", "request", "Landroid/webkit/WebResourceRequest;", "onPageStarted", "url", "favicon", "Landroid/graphics/Bitmap;", "error", "Landroid/webkit/WebResourceError;", "connectToWebView", "responseWithAccessToken", "Lkotlinx/coroutines/Job;", "cb", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAuthBridgeWebClient extends AuthenticatedWebClient {
    private final AuthTokenService authTokenService;
    private final IBoxCsrfTokenManager boxCsrfTokenManager;
    private WebMessagePort channel;
    private Function1<? super String, Unit> onPageFinishedListener;
    private Function1<? super String, Unit> onReceivedErrorListener;
    private Function1<? super Uri, Boolean> onShouldOverrideUrlLoadingListener;
    private final String primaryUrl;

    /* JADX INFO: renamed from: webMessageCallback$delegate, reason: from kotlin metadata */
    private final Lazy webMessageCallback;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onShouldOverrideUrlLoadingListener$lambda$0(Uri uri) {
        return false;
    }

    public BoxAuthBridgeWebClient(String primaryUrl, IBoxCsrfTokenManager boxCsrfTokenManager, AuthTokenService authTokenService) {
        Intrinsics.checkNotNullParameter(primaryUrl, "primaryUrl");
        Intrinsics.checkNotNullParameter(boxCsrfTokenManager, "boxCsrfTokenManager");
        Intrinsics.checkNotNullParameter(authTokenService, "authTokenService");
        this.primaryUrl = primaryUrl;
        this.boxCsrfTokenManager = boxCsrfTokenManager;
        this.authTokenService = authTokenService;
        this.onShouldOverrideUrlLoadingListener = new Function1() { // from class: com.box.android.data.webBridgeAuth.BoxAuthBridgeWebClient$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(BoxAuthBridgeWebClient.onShouldOverrideUrlLoadingListener$lambda$0((Uri) obj));
            }
        };
        this.webMessageCallback = LazyKt.lazy(new Function0() { // from class: com.box.android.data.webBridgeAuth.BoxAuthBridgeWebClient$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BoxAuthBridgeWebClient.webMessageCallback_delegate$lambda$0(this.f$0);
            }
        });
    }

    public final String getPrimaryUrl() {
        return this.primaryUrl;
    }

    private final BoxAuthBridgeWebClient$webMessageCallback$2$1 getWebMessageCallback() {
        return (BoxAuthBridgeWebClient$webMessageCallback$2$1) this.webMessageCallback.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.box.android.data.webBridgeAuth.BoxAuthBridgeWebClient$webMessageCallback$2$1] */
    public static final BoxAuthBridgeWebClient$webMessageCallback$2$1 webMessageCallback_delegate$lambda$0(final BoxAuthBridgeWebClient boxAuthBridgeWebClient) {
        return new WebMessagePort.WebMessageCallback() { // from class: com.box.android.data.webBridgeAuth.BoxAuthBridgeWebClient$webMessageCallback$2$1
            @Override // android.webkit.WebMessagePort.WebMessageCallback
            public void onMessage(WebMessagePort port, WebMessage message) throws JSONException {
                Intrinsics.checkNotNullParameter(port, "port");
                Intrinsics.checkNotNullParameter(message, "message");
                JSONObject jSONObject = new JSONObject(message.getData());
                String string = jSONObject.getString("csrf_token");
                IBoxCsrfTokenManager iBoxCsrfTokenManager = this.this$0.boxCsrfTokenManager;
                String primaryUrl = this.this$0.getPrimaryUrl();
                Intrinsics.checkNotNull(string);
                if (iBoxCsrfTokenManager.verifyTokenFor(primaryUrl, string) && Intrinsics.areEqual(jSONObject.get("message"), "refreshAccessToken")) {
                    BoxAuthBridgeWebClient boxAuthBridgeWebClient2 = this.this$0;
                    String string2 = jSONObject.getString("cb");
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    boxAuthBridgeWebClient2.responseWithAccessToken(string2);
                }
            }
        };
    }

    @Override // com.box.android.domain.webBridgeAuth.AuthenticatedWebClient
    public void onPageFinished(Function1<? super String, Unit> onFinished) {
        Intrinsics.checkNotNullParameter(onFinished, "onFinished");
        this.onPageFinishedListener = onFinished;
    }

    @Override // com.box.android.domain.webBridgeAuth.AuthenticatedWebClient
    public void onShouldOverrideUrlLoading(Function1<? super Uri, Boolean> shouldOverride) {
        Intrinsics.checkNotNullParameter(shouldOverride, "shouldOverride");
        this.onShouldOverrideUrlLoadingListener = shouldOverride;
    }

    @Override // com.box.android.domain.webBridgeAuth.AuthenticatedWebClient
    public void onReceivedError(Function1<? super String, Unit> onError) {
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.onReceivedErrorListener = onError;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        if (request != null) {
            return this.onShouldOverrideUrlLoadingListener.invoke(request.getUrl()).booleanValue();
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) throws IOException {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        WebMessagePort webMessagePort = this.channel;
        if (webMessagePort != null) {
            webMessagePort.close();
        }
        this.channel = null;
        if (Intrinsics.areEqual(url, this.primaryUrl)) {
            connectToWebView(view, url);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        super.onPageFinished(view, url);
        Function1<? super String, Unit> function1 = this.onPageFinishedListener;
        if (function1 != null) {
            function1.invoke(url);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        Function1<? super String, Unit> function1 = this.onReceivedErrorListener;
        if (function1 != null) {
            function1.invoke(String.valueOf(error != null ? error.getDescription() : null));
        }
    }

    private final void connectToWebView(WebView view, String url) throws IOException {
        WebMessagePort[] webMessagePortArrCreateWebMessageChannel = view.createWebMessageChannel();
        Intrinsics.checkNotNullExpressionValue(webMessagePortArrCreateWebMessageChannel, "createWebMessageChannel(...)");
        if (webMessagePortArrCreateWebMessageChannel.length != 2) {
            return;
        }
        InputStream inputStreamOpen = view.getContext().getAssets().open("webBridgeAuth/bridgeScript.js");
        Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
        Reader inputStreamReader = new InputStreamReader(inputStreamOpen, Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            String text = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            view.evaluateJavascript(text, null);
            this.channel = webMessagePortArrCreateWebMessageChannel[0];
            view.postWebMessage(new WebMessage("boxNativeApp", new WebMessagePort[]{webMessagePortArrCreateWebMessageChannel[1]}), Uri.parse(url));
            WebMessagePort webMessagePort = this.channel;
            if (webMessagePort != null) {
                webMessagePort.setWebMessageCallback(getWebMessageCallback());
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedReader, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.webBridgeAuth.BoxAuthBridgeWebClient$responseWithAccessToken$1, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAuthBridgeWebClient.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.webBridgeAuth.BoxAuthBridgeWebClient$responseWithAccessToken$1", f = "BoxAuthBridgeWebClient.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $cb;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$cb = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BoxAuthBridgeWebClient.this.new AnonymousClass1(this.$cb, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws JSONException {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = BoxAuthBridgeWebClient.this.authTokenService.getAccessTokenWithExpiration(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Pair pair = (Pair) obj;
            if (pair == null) {
                return Unit.INSTANCE;
            }
            String str = (String) pair.component1();
            long jLongValue = ((Number) pair.component2()).longValue();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cb", this.$cb);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("accessToken", str);
            jSONObject2.put("expiresIn", jLongValue);
            Unit unit = Unit.INSTANCE;
            jSONObject.put(ReactNativeFeatureActivity.RESULT_EXTRA_KEY, jSONObject2);
            WebMessagePort webMessagePort = BoxAuthBridgeWebClient.this.channel;
            if (webMessagePort != null) {
                webMessagePort.postMessage(new WebMessage(jSONObject.toString()));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job responseWithAccessToken(String cb) {
        return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(cb, null), 3, null);
    }
}
