package com.microsoft.identity.common.internal.providers.oauth2;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.webkit.WebView;
import androidx.credentials.CreatePublicKeyCredentialResponse;
import androidx.credentials.Credential;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.PublicKeyCredential;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.metrics.Gen204FileActivityEventLogger;
import com.microsoft.identity.common.internal.ui.webview.AzureActiveDirectoryWebViewClient;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryEnvironment;
import com.microsoft.identity.common.logging.Logger;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: compiled from: PasskeyWebListener.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J)\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ)\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ0\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J(\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\f2\u0006\u0010\u001e\u001a\u00020\u001aH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/microsoft/identity/common/internal/providers/oauth2/PasskeyWebListener;", "Landroidx/webkit/WebViewCompat$WebMessageListener;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "credentialManagerHandler", "Lcom/microsoft/identity/common/internal/providers/oauth2/CredentialManagerHandler;", "(Lkotlinx/coroutines/CoroutineScope;Lcom/microsoft/identity/common/internal/providers/oauth2/CredentialManagerHandler;)V", "havePendingRequest", "Ljava/util/concurrent/atomic/AtomicBoolean;", "handleCreateFlow", "", "message", "", Gen204FileActivityEventLogger.ACTION_REPLY, "Lcom/microsoft/identity/common/internal/providers/oauth2/PasskeyReplyChannel;", "(Lcom/microsoft/identity/common/internal/providers/oauth2/CredentialManagerHandler;Ljava/lang/String;Lcom/microsoft/identity/common/internal/providers/oauth2/PasskeyReplyChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleGetFlow", "onPostMessage", "view", "Landroid/webkit/WebView;", "Landroidx/webkit/WebMessageCompat;", "sourceOrigin", "Landroid/net/Uri;", "isMainFrame", "", "replyProxy", "Landroidx/webkit/JavaScriptReplyProxy;", "onRequest", "webAuthNMessage", "Lcom/microsoft/identity/common/internal/providers/oauth2/PasskeyWebListener$WebAuthNMessage;", "javaScriptReplyProxy", "parseMessage", "messageData", "Companion", "WebAuthNMessage", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PasskeyWebListener implements WebViewCompat.WebMessageListener {
    public static final String CREATE_UNIQUE_KEY = "create";
    public static final String GET_UNIQUE_KEY = "get";
    private static final String INTERFACE_NAME = "__webauthn_interface__";
    public static final String REQUEST_KEY = "request";
    public static final String TAG = "PasskeyWebListener";
    public static final String TYPE_KEY = "type";
    private static final String WEB_AUTHN_INTERFACE_JS_MINIFIED = "\n            var __webauthn_interface__,__webauthn_hooks__;!function(e){__webauthn_interface__.addEventListener(\"message\",(function(e){console.log(e.data);var n=JSON.parse(e.data);\"get\"===n.type?o(n):\"create\"===n.type?l(n):console.log(\"Incorrect response format for reply: \"+n.type)}));var n=null,t=null,r=null,a=null;function o(e){if(null!==n&&null!==r){if(\"success\"!=e.status){var o=r;return n=null,r=null,void o(new DOMException(e.data.domExceptionMessage,e.data.domExceptionName))}var s=u(e.data),i=n;n=null,r=null,i(s)}else console.log(\"Reply failure: Resolve: \"+t+\" and reject: \"+a)}function s(e){var n=e.length%4;return Uint8Array.from(atob(e.replace(/-/g,\"+\").replace(/_/g,\"/\").padEnd(e.length+(0===n?0:4-n),\"=\")),(function(e){return e.charCodeAt(0)})).buffer}function i(e){return btoa(Array.from(new Uint8Array(e),(function(e){return String.fromCharCode(e)})).join(\"\")).replace(/\\+/g,\"-\").replace(/\\//g,\"_\").replace(/=+$/,\"\")}function l(e){if(null!==t&&null!==a){if(\"success\"!=e.status){var n=a;return t=null,a=null,void n(new DOMException(e.data.domExceptionMessage,e.data.domExceptionName))}var r=u(e.data),o=t;t=null,a=null,o(r)}else console.log(\"Reply failure: Resolve: \"+t+\" and reject: \"+a)}function u(e){return e.rawId=s(e.rawId),e.response.clientDataJSON=s(e.response.clientDataJSON),e.response.hasOwnProperty(\"attestationObject\")&&(e.response.attestationObject=s(e.response.attestationObject)),e.response.hasOwnProperty(\"authenticatorData\")&&(e.response.authenticatorData=s(e.response.authenticatorData)),e.response.hasOwnProperty(\"signature\")&&(e.response.signature=s(e.response.signature)),e.response.hasOwnProperty(\"userHandle\")&&(e.response.userHandle=s(e.response.userHandle)),e.getClientExtensionResults=function(){return{}},e.response.getTransports=function(){return e.response.hasOwnProperty(\"transports\")?e.response.transports:[]},e}e.create=function(n){if(!(\"publicKey\"in n))return e.originalCreateFunction(n);var r=new Promise((function(e,n){t=e,a=n})),o=n.publicKey;if(o.hasOwnProperty(\"challenge\")){var s=i(o.challenge);o.challenge=s}if(o.hasOwnProperty(\"user\")&&o.user.hasOwnProperty(\"id\")){var l=i(o.user.id);o.user.id=l}if(o.hasOwnProperty(\"excludeCredentials\")&&Array.isArray(o.excludeCredentials)&&o.excludeCredentials.length>0)for(var u=0;u<o.excludeCredentials.length;u++){var c=o.excludeCredentials[u];c&&c.hasOwnProperty(\"id\")&&(c.id=i(c.id))}var p={type:\"create\",request:o},_=JSON.stringify(p);return __webauthn_interface__.postMessage(_),r},e.get=function(t){if(!(\"publicKey\"in t))return e.originalGetFunction(t);var a=new Promise((function(e,t){n=e,r=t})),o=t.publicKey;if(o.hasOwnProperty(\"challenge\")){var s=i(o.challenge);o.challenge=s}var l={type:\"get\",request:o},u=JSON.stringify(l);return __webauthn_interface__.postMessage(u),a},e.onReplyGet=o,e.CM_base64url_decode=s,e.CM_base64url_encode=i,e.onReplyCreate=l}(__webauthn_hooks__||(__webauthn_hooks__={})),__webauthn_hooks__.originalGetFunction=navigator.credentials.get,__webauthn_hooks__.originalCreateFunction=navigator.credentials.create,navigator.credentials.get=__webauthn_hooks__.get,navigator.credentials.create=__webauthn_hooks__.create,window.PublicKeyCredential=function(){},window.PublicKeyCredential.isUserVerifyingPlatformAuthenticatorAvailable=function(){return Promise.resolve(!0)};\n         ";
    private final CoroutineScope coroutineScope;
    private final CredentialManagerHandler credentialManagerHandler;
    private final AtomicBoolean havePendingRequest;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> ALLOWED_ORIGIN_RULES_PRODUCTION = SetsKt.setOf((Object[]) new String[]{"https://login.microsoft.com", "https://account.live.com", "https://mysignins.microsoft.com", "https://mysignins.azure.us", "https://mysignins.microsoft.scloud", "https://mysignins.eaglex.ic.gov", "https://login.microsoftonline.us", "https://login.microsoftonline.microsoft.scloud", "https://login.microsoftonline.eaglex.ic.gov"});
    private static final Set<String> ALLOWED_ORIGIN_PRE_PRODUCTION = SetsKt.setOf((Object[]) new String[]{"https://account.live-int.com", AzureActiveDirectoryEnvironment.PREPRODUCTION_CLOUD_URL, "https://mysignins-ppe.microsoft.com"});

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener$handleCreateFlow$1, reason: invalid class name */
    /* JADX INFO: compiled from: PasskeyWebListener.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener", f = "PasskeyWebListener.kt", i = {0}, l = {209}, m = "handleCreateFlow", n = {Gen204FileActivityEventLogger.ACTION_REPLY}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PasskeyWebListener.this.handleCreateFlow(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener$handleGetFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PasskeyWebListener.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener", f = "PasskeyWebListener.kt", i = {0}, l = {179}, m = "handleGetFlow", n = {Gen204FileActivityEventLogger.ACTION_REPLY}, s = {"L$0"})
    static final class C18171 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C18171(Continuation<? super C18171> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PasskeyWebListener.this.handleGetFlow(null, null, null, this);
        }
    }

    @JvmStatic
    public static final boolean hook(WebView webView, Activity activity, AzureActiveDirectoryWebViewClient azureActiveDirectoryWebViewClient) {
        return INSTANCE.hook(webView, activity, azureActiveDirectoryWebViewClient);
    }

    public PasskeyWebListener(CoroutineScope coroutineScope, CredentialManagerHandler credentialManagerHandler) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(credentialManagerHandler, "credentialManagerHandler");
        this.coroutineScope = coroutineScope;
        this.credentialManagerHandler = credentialManagerHandler;
        this.havePendingRequest = new AtomicBoolean(false);
    }

    @Override // androidx.webkit.WebViewCompat.WebMessageListener
    public void onPostMessage(WebView view, WebMessageCompat message, Uri sourceOrigin, boolean isMainFrame, JavaScriptReplyProxy replyProxy) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(sourceOrigin, "sourceOrigin");
        Intrinsics.checkNotNullParameter(replyProxy, "replyProxy");
        WebAuthNMessage message2 = parseMessage(message.getData(), replyProxy);
        if (message2 != null) {
            onRequest(message2, sourceOrigin, isMainFrame, replyProxy);
        }
    }

    private final void onRequest(WebAuthNMessage webAuthNMessage, Uri sourceOrigin, boolean isMainFrame, JavaScriptReplyProxy javaScriptReplyProxy) {
        Logger.info("PasskeyWebListener:onRequest", "Received WebAuthN request of type: " + webAuthNMessage.getType() + " from origin: " + sourceOrigin);
        PasskeyReplyChannel passkeyReplyChannel = new PasskeyReplyChannel(javaScriptReplyProxy, webAuthNMessage.getType(), null, 4, null);
        if (this.havePendingRequest.get()) {
            passkeyReplyChannel.postError(new ClientException(ClientException.REQUEST_IN_PROGRESS, "A WebAuthN request is already in progress."));
            return;
        }
        this.havePendingRequest.set(true);
        if (!isMainFrame) {
            passkeyReplyChannel.postError(new ClientException(ClientException.UNSUPPORTED_OPERATION, "WebAuthN requests from iframes are not supported."));
            this.havePendingRequest.set(false);
            return;
        }
        String type = webAuthNMessage.getType();
        if (Intrinsics.areEqual(type, CREATE_UNIQUE_KEY)) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C18181(webAuthNMessage, passkeyReplyChannel, null), 3, null);
        } else if (Intrinsics.areEqual(type, GET_UNIQUE_KEY)) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass2(webAuthNMessage, passkeyReplyChannel, null), 3, null);
        } else {
            passkeyReplyChannel.postError(new ClientException(ClientException.UNSUPPORTED_OPERATION, "Unsupported WebAuthN request type: " + webAuthNMessage.getType()));
            this.havePendingRequest.set(false);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener$onRequest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PasskeyWebListener.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener$onRequest$1", f = "PasskeyWebListener.kt", i = {}, l = {138}, m = "invokeSuspend", n = {}, s = {})
    static final class C18181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PasskeyReplyChannel $passkeyReplyChannel;
        final /* synthetic */ WebAuthNMessage $webAuthNMessage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18181(WebAuthNMessage webAuthNMessage, PasskeyReplyChannel passkeyReplyChannel, Continuation<? super C18181> continuation) {
            super(2, continuation);
            this.$webAuthNMessage = webAuthNMessage;
            this.$passkeyReplyChannel = passkeyReplyChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PasskeyWebListener.this.new C18181(this.$webAuthNMessage, this.$passkeyReplyChannel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18181) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PasskeyWebListener passkeyWebListener = PasskeyWebListener.this;
                this.label = 1;
                if (passkeyWebListener.handleCreateFlow(passkeyWebListener.credentialManagerHandler, this.$webAuthNMessage.getRequest(), this.$passkeyReplyChannel, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            PasskeyWebListener.this.havePendingRequest.set(false);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener$onRequest$2, reason: invalid class name */
    /* JADX INFO: compiled from: PasskeyWebListener.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener$onRequest$2", f = "PasskeyWebListener.kt", i = {}, l = {Token.DOTQUERY}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PasskeyReplyChannel $passkeyReplyChannel;
        final /* synthetic */ WebAuthNMessage $webAuthNMessage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(WebAuthNMessage webAuthNMessage, PasskeyReplyChannel passkeyReplyChannel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$webAuthNMessage = webAuthNMessage;
            this.$passkeyReplyChannel = passkeyReplyChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PasskeyWebListener.this.new AnonymousClass2(this.$webAuthNMessage, this.$passkeyReplyChannel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PasskeyWebListener passkeyWebListener = PasskeyWebListener.this;
                this.label = 1;
                if (passkeyWebListener.handleGetFlow(passkeyWebListener.credentialManagerHandler, this.$webAuthNMessage.getRequest(), this.$passkeyReplyChannel, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            PasskeyWebListener.this.havePendingRequest.set(false);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object handleGetFlow(CredentialManagerHandler credentialManagerHandler, String str, PasskeyReplyChannel passkeyReplyChannel, Continuation<? super Unit> continuation) {
        C18171 c18171;
        Object objM14780constructorimpl;
        if (continuation instanceof C18171) {
            c18171 = (C18171) continuation;
            if ((c18171.label & Integer.MIN_VALUE) != 0) {
                c18171.label -= Integer.MIN_VALUE;
            } else {
                c18171 = new C18171(continuation);
            }
        } else {
            c18171 = new C18171(continuation);
        }
        Object passkey = c18171.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c18171.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(passkey);
                Result.Companion companion = Result.INSTANCE;
                PasskeyWebListener passkeyWebListener = this;
                c18171.L$0 = passkeyReplyChannel;
                c18171.label = 1;
                passkey = credentialManagerHandler.getPasskey(str, c18171);
                if (passkey == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                passkeyReplyChannel = (PasskeyReplyChannel) c18171.L$0;
                ResultKt.throwOnFailure(passkey);
            }
            objM14780constructorimpl = Result.m14780constructorimpl((GetCredentialResponse) passkey);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m14787isSuccessimpl(objM14780constructorimpl)) {
            Credential credential = ((GetCredentialResponse) objM14780constructorimpl).getCredential();
            PublicKeyCredential publicKeyCredential = credential instanceof PublicKeyCredential ? (PublicKeyCredential) credential : null;
            if (publicKeyCredential != null) {
                passkeyReplyChannel.postSuccess(publicKeyCredential.getAuthenticationResponseJson());
            } else {
                passkeyReplyChannel.postError(new ClientException(ClientException.UNSUPPORTED_OPERATION, "Retrieved credential is not a PublicKeyCredential."));
            }
        }
        Throwable thM14783exceptionOrNullimpl = Result.m14783exceptionOrNullimpl(objM14780constructorimpl);
        if (thM14783exceptionOrNullimpl != null) {
            passkeyReplyChannel.postError(thM14783exceptionOrNullimpl);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object handleCreateFlow(CredentialManagerHandler credentialManagerHandler, String str, PasskeyReplyChannel passkeyReplyChannel, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object objM14780constructorimpl;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objCreatePasskey = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objCreatePasskey);
                Result.Companion companion = Result.INSTANCE;
                PasskeyWebListener passkeyWebListener = this;
                anonymousClass1.L$0 = passkeyReplyChannel;
                anonymousClass1.label = 1;
                objCreatePasskey = credentialManagerHandler.createPasskey(str, anonymousClass1);
                if (objCreatePasskey == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                passkeyReplyChannel = (PasskeyReplyChannel) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objCreatePasskey);
            }
            objM14780constructorimpl = Result.m14780constructorimpl((CreatePublicKeyCredentialResponse) objCreatePasskey);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m14787isSuccessimpl(objM14780constructorimpl)) {
            passkeyReplyChannel.postSuccess(((CreatePublicKeyCredentialResponse) objM14780constructorimpl).getRegistrationResponseJson());
        }
        Throwable thM14783exceptionOrNullimpl = Result.m14783exceptionOrNullimpl(objM14780constructorimpl);
        if (thM14783exceptionOrNullimpl != null) {
            passkeyReplyChannel.postError(thM14783exceptionOrNullimpl);
        }
        return Unit.INSTANCE;
    }

    private final WebAuthNMessage parseMessage(String messageData, JavaScriptReplyProxy javaScriptReplyProxy) {
        Object objM14780constructorimpl;
        PasskeyReplyChannel passkeyReplyChannel = new PasskeyReplyChannel(javaScriptReplyProxy, null, null, 6, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            PasskeyWebListener passkeyWebListener = this;
            String str = messageData;
            if (str == null || StringsKt.isBlank(str)) {
                throw new ClientException(ClientException.MISSING_PARAMETER, "Message data is null or blank");
            }
            JSONObject jSONObject = new JSONObject(messageData);
            String it = jSONObject.optString("type");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (StringsKt.isBlank(it)) {
                it = null;
            }
            String it2 = jSONObject.optString("request");
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            if (StringsKt.isBlank(it2)) {
                it2 = null;
            }
            if (it == null) {
                throw new ClientException(ClientException.MISSING_PARAMETER, "Missing required key: type");
            }
            if (it2 != null) {
                objM14780constructorimpl = Result.m14780constructorimpl(new WebAuthNMessage(it, it2));
                Throwable thM14783exceptionOrNullimpl = Result.m14783exceptionOrNullimpl(objM14780constructorimpl);
                if (thM14783exceptionOrNullimpl != null) {
                    passkeyReplyChannel.postError(thM14783exceptionOrNullimpl);
                }
                return (WebAuthNMessage) (Result.m14786isFailureimpl(objM14780constructorimpl) ? null : objM14780constructorimpl);
            }
            throw new ClientException(ClientException.MISSING_PARAMETER, "Missing required key: request");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: compiled from: PasskeyWebListener.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/microsoft/identity/common/internal/providers/oauth2/PasskeyWebListener$WebAuthNMessage;", "", "type", "", "request", "(Ljava/lang/String;Ljava/lang/String;)V", "getRequest", "()Ljava/lang/String;", "getType", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final /* data */ class WebAuthNMessage {
        private final String request;
        private final String type;

        public static /* synthetic */ WebAuthNMessage copy$default(WebAuthNMessage webAuthNMessage, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = webAuthNMessage.type;
            }
            if ((i & 2) != 0) {
                str2 = webAuthNMessage.request;
            }
            return webAuthNMessage.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getRequest() {
            return this.request;
        }

        public final WebAuthNMessage copy(String type, String request) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(request, "request");
            return new WebAuthNMessage(type, request);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WebAuthNMessage)) {
                return false;
            }
            WebAuthNMessage webAuthNMessage = (WebAuthNMessage) other;
            return Intrinsics.areEqual(this.type, webAuthNMessage.type) && Intrinsics.areEqual(this.request, webAuthNMessage.request);
        }

        public int hashCode() {
            return (this.type.hashCode() * 31) + this.request.hashCode();
        }

        public String toString() {
            return "WebAuthNMessage(type=" + this.type + ", request=" + this.request + ')';
        }

        public WebAuthNMessage(String type, String request) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(request, "request");
            this.type = type;
            this.request = request;
        }

        public final String getRequest() {
            return this.request;
        }

        public final String getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: PasskeyWebListener.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/microsoft/identity/common/internal/providers/oauth2/PasskeyWebListener$Companion;", "", "()V", "ALLOWED_ORIGIN_PRE_PRODUCTION", "", "", "ALLOWED_ORIGIN_RULES_PRODUCTION", "CREATE_UNIQUE_KEY", "GET_UNIQUE_KEY", "INTERFACE_NAME", "REQUEST_KEY", "TAG", "TYPE_KEY", "WEB_AUTHN_INTERFACE_JS_MINIFIED", "getAllowedOriginRules", "hook", "", "webView", "Landroid/webkit/WebView;", "activity", "Landroid/app/Activity;", "webClient", "Lcom/microsoft/identity/common/internal/ui/webview/AzureActiveDirectoryWebViewClient;", "loadJsBridgeScript", "context", "Landroid/content/Context;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final Set<String> getAllowedOriginRules() {
            return CollectionsKt.toSet(CollectionsKt.toMutableSet(PasskeyWebListener.ALLOWED_ORIGIN_RULES_PRODUCTION));
        }

        @JvmStatic
        public final boolean hook(WebView webView, Activity activity, AzureActiveDirectoryWebViewClient webClient) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(webClient, "webClient");
            if (WebViewFeature.isFeatureSupported("WEB_MESSAGE_LISTENER")) {
                Logger.verbose("PasskeyWebListener:hook", "WEB_MESSAGE_LISTENER is supported on this WebView.");
                WebViewCompat.addWebMessageListener(webView, PasskeyWebListener.INTERFACE_NAME, getAllowedOriginRules(), new PasskeyWebListener(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), new CredentialManagerHandler(activity)));
                Logger.info("PasskeyWebListener:hook", "PasskeyWebListener successfully hooked into WebView.");
                webClient.addOnPageStartedScript(PasskeyWebListener.TAG, PasskeyWebListener.WEB_AUTHN_INTERFACE_JS_MINIFIED, getAllowedOriginRules());
                return true;
            }
            Logger.warn("PasskeyWebListener:hook", "WEB_MESSAGE_LISTENER not supported on this device/WebView.");
            return false;
        }

        private final String loadJsBridgeScript(Context context) {
            try {
                InputStream inputStreamOpen = context.getAssets().open("js-bridge.js");
                Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "context.assets.open(\"js-bridge.js\")");
                Reader inputStreamReader = new InputStreamReader(inputStreamOpen, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    String text = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    return text;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedReader, th);
                        throw th2;
                    }
                }
            } catch (Exception e) {
                Logger.warn(PasskeyWebListener.TAG, "Failed to load js-bridge.js from assets, falling back to minified version: " + e.getMessage());
                return PasskeyWebListener.WEB_AUTHN_INTERFACE_JS_MINIFIED;
            }
        }
    }
}
