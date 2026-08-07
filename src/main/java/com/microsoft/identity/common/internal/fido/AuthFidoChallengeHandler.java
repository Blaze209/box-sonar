package com.microsoft.identity.common.internal.fido;

import android.webkit.WebView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microsoft.identity.common.internal.platform.AndroidPlatformUtil;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.IChallengeHandler;
import com.microsoft.identity.common.java.constants.FidoConstants;
import com.microsoft.identity.common.java.jwt.AbstractJwtRequest;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.BaggageExtension;
import com.microsoft.identity.common.java.opentelemetry.OTelUtility;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.opentelemetry.SpanName;
import com.microsoft.identity.common.logging.Logger;
import io.opentelemetry.api.baggage.Baggage;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AuthFidoChallengeHandler.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001!B)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\"\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eJD\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u00152\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000eR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/microsoft/identity/common/internal/fido/AuthFidoChallengeHandler;", "Lcom/microsoft/identity/common/internal/ui/webview/challengehandlers/IChallengeHandler;", "Lcom/microsoft/identity/common/internal/fido/FidoChallenge;", "Ljava/lang/Void;", "fidoManager", "Lcom/microsoft/identity/common/internal/fido/IFidoManager;", "webView", "Landroid/webkit/WebView;", "oTelContext", "Lio/opentelemetry/context/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lcom/microsoft/identity/common/internal/fido/IFidoManager;Landroid/webkit/WebView;Lio/opentelemetry/context/Context;Landroidx/lifecycle/LifecycleOwner;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getErrorAssertion", "errorMessage", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "processChallenge", "fidoChallenge", "respondToChallenge", "", "submitUrl", AbstractJwtRequest.ClaimNames.ASSERTION, "context", "span", "Lio/opentelemetry/api/trace/Span;", "respondToChallengeWithError", "methodTag", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AuthFidoChallengeHandler implements IChallengeHandler<FidoChallenge, Void> {
    private static final ArrayList<AttributeName> parentAttributeNames = CollectionsKt.arrayListOf(AttributeName.correlation_id, AttributeName.tenant_id, AttributeName.account_type, AttributeName.calling_package_name);
    private final String TAG;
    private final IFidoManager fidoManager;
    private final LifecycleOwner lifecycleOwner;
    private final Context oTelContext;
    private final WebView webView;

    public AuthFidoChallengeHandler(IFidoManager fidoManager, WebView webView, Context context, LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(fidoManager, "fidoManager");
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.fidoManager = fidoManager;
        this.webView = webView;
        this.oTelContext = context;
        this.lifecycleOwner = lifecycleOwner;
        this.TAG = String.valueOf(Reflection.getOrCreateKotlinClass(AuthFidoChallengeHandler.class).getSimpleName());
    }

    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.challengehandlers.IChallengeHandler
    public Void processChallenge(FidoChallenge fidoChallenge) {
        Span spanCreateSpan;
        Intrinsics.checkNotNullParameter(fidoChallenge, "fidoChallenge");
        String str = this.TAG + ":processChallenge";
        Logger.info(str, "Processing FIDO challenge.");
        Context context = this.oTelContext;
        if (context != null) {
            spanCreateSpan = OTelUtility.createSpanFromParent(SpanName.Fido.name(), SpanExtension.fromContext(context).getSpanContext());
            Baggage baggageFromContext = BaggageExtension.fromContext(this.oTelContext);
            for (AttributeName attributeName : parentAttributeNames) {
                String entryValue = baggageFromContext.getEntryValue(attributeName.name());
                if (entryValue != null) {
                    spanCreateSpan.setAttribute(attributeName.name(), entryValue);
                }
            }
        } else {
            spanCreateSpan = OTelUtility.createSpan(SpanName.Fido.name());
        }
        Span span = spanCreateSpan;
        span.setAttribute(AttributeName.fido_challenge_handler.name(), this.TAG);
        Logger.info(str, "Is app in work profile?: " + AndroidPlatformUtil.isInManagedProfile(this.webView.getContext()));
        String orThrow = fidoChallenge.getSubmitUrl().getOrThrow();
        String orThrow2 = fidoChallenge.getContext().getOrThrow();
        try {
            String orThrow3 = fidoChallenge.getChallenge().getOrThrow();
            String orThrow4 = fidoChallenge.getRelyingPartyIdentifier().getOrThrow();
            String orThrow5 = fidoChallenge.getUserVerificationPolicy().getOrThrow();
            List<String> orThrow6 = fidoChallenge.getAllowedCredentials().getOrThrow();
            fidoChallenge.getVersion().getOrThrow();
            fidoChallenge.getKeyTypes().getOrThrow();
            LifecycleOwner lifecycleOwner = this.lifecycleOwner;
            if (lifecycleOwner != null) {
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new AnonymousClass2(orThrow3, orThrow4, orThrow6, orThrow5, span, orThrow, orThrow2, str, null), 3, null);
                return null;
            }
            respondToChallengeWithError$default(this, orThrow, orThrow2, span, "Cannot get lifecycle owner needed for FIDO API calls.", null, str, 16, null);
            return null;
        } catch (Exception e) {
            respondToChallengeWithError(orThrow, orThrow2, span, String.valueOf(e.getMessage()), e, str);
            return null;
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.fido.AuthFidoChallengeHandler$processChallenge$2, reason: invalid class name */
    /* JADX INFO: compiled from: AuthFidoChallengeHandler.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.common.internal.fido.AuthFidoChallengeHandler$processChallenge$2", f = "AuthFidoChallengeHandler.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $allowedCredentials;
        final /* synthetic */ String $authChallenge;
        final /* synthetic */ String $context;
        final /* synthetic */ String $methodTag;
        final /* synthetic */ String $relyingPartyIdentifier;
        final /* synthetic */ Span $span;
        final /* synthetic */ String $submitUrl;
        final /* synthetic */ String $userVerificationPolicy;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, String str2, List<String> list, String str3, Span span, String str4, String str5, String str6, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$authChallenge = str;
            this.$relyingPartyIdentifier = str2;
            this.$allowedCredentials = list;
            this.$userVerificationPolicy = str3;
            this.$span = span;
            this.$submitUrl = str4;
            this.$context = str5;
            this.$methodTag = str6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AuthFidoChallengeHandler.this.new AnonymousClass2(this.$authChallenge, this.$relyingPartyIdentifier, this.$allowedCredentials, this.$userVerificationPolicy, this.$span, this.$submitUrl, this.$context, this.$methodTag, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = AuthFidoChallengeHandler.this.fidoManager.authenticate(this.$authChallenge, this.$relyingPartyIdentifier, this.$allowedCredentials, this.$userVerificationPolicy, this.$span, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$span.setStatus(StatusCode.OK);
                AuthFidoChallengeHandler.this.respondToChallenge(this.$submitUrl, (String) obj, this.$context, this.$span);
            } catch (CancellationException e) {
                AuthFidoChallengeHandler.this.respondToChallengeWithError(this.$submitUrl, this.$context, this.$span, "Coroutine job of FIDO API calls cancelled.", e, this.$methodTag);
            } catch (Exception e2) {
                AuthFidoChallengeHandler.this.respondToChallengeWithError(this.$submitUrl, this.$context, this.$span, String.valueOf(e2.getMessage()), e2, this.$methodTag);
            }
            return Unit.INSTANCE;
        }
    }

    public final void respondToChallenge(final String submitUrl, String assertion, String context, Span span) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(submitUrl, "submitUrl");
        Intrinsics.checkNotNullParameter(assertion, "assertion");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(span, "span");
        final String str3 = this.TAG + ":respondToChallenge";
        span.end();
        List listSplit$default = StringsKt.split$default((CharSequence) context, new String[]{" "}, false, 0, 6, (Object) null);
        if (listSplit$default.size() == 2) {
            str = (String) listSplit$default.get(0);
            str2 = (String) listSplit$default.get(1);
        } else {
            str = (String) listSplit$default.get(0);
            str2 = "";
        }
        final Map mapMapOf = MapsKt.mapOf(TuplesKt.to(FidoConstants.PASSKEY_RESPONSE_ASSERTION_HEADER, assertion), TuplesKt.to(FidoConstants.PASSKEY_RESPONSE_CONTEXT_HEADER, str), TuplesKt.to(FidoConstants.PASSKEY_RESPONSE_FLOWTOKEN_HEADER, str2));
        this.webView.post(new Runnable() { // from class: com.microsoft.identity.common.internal.fido.AuthFidoChallengeHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AuthFidoChallengeHandler.respondToChallenge$lambda$2(str3, this, submitUrl, mapMapOf);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void respondToChallenge$lambda$2(String methodTag, AuthFidoChallengeHandler this$0, String submitUrl, Map header) {
        Intrinsics.checkNotNullParameter(methodTag, "$methodTag");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(submitUrl, "$submitUrl");
        Intrinsics.checkNotNullParameter(header, "$header");
        Logger.info(methodTag, "Responding to Fido challenge.");
        this$0.webView.loadUrl(submitUrl, header);
    }

    public static /* synthetic */ void respondToChallengeWithError$default(AuthFidoChallengeHandler authFidoChallengeHandler, String str, String str2, Span span, String str3, Exception exc, String str4, int i, Object obj) {
        if ((i & 16) != 0) {
            exc = null;
        }
        Exception exc2 = exc;
        if ((i & 32) != 0) {
            str4 = authFidoChallengeHandler.TAG + ":respondToChallengeWithError";
        }
        authFidoChallengeHandler.respondToChallengeWithError(str, str2, span, str3, exc2, str4);
    }

    public final void respondToChallengeWithError(String submitUrl, String context, Span span, String errorMessage, Exception exception, String methodTag) {
        Intrinsics.checkNotNullParameter(submitUrl, "submitUrl");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(span, "span");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        Exception exc = exception;
        Logger.error(methodTag, errorMessage, exc);
        if (exception != null) {
            span.recordException(exc);
            span.setStatus(StatusCode.ERROR);
        } else {
            span.setStatus(StatusCode.ERROR, errorMessage);
        }
        respondToChallenge(submitUrl, getErrorAssertion(errorMessage, exception), context, span);
    }

    static /* synthetic */ String getErrorAssertion$default(AuthFidoChallengeHandler authFidoChallengeHandler, String str, Exception exc, int i, Object obj) {
        if ((i & 2) != 0) {
            exc = null;
        }
        return authFidoChallengeHandler.getErrorAssertion(str, exc);
    }

    private final String getErrorAssertion(String errorMessage, Exception exception) {
        if (exception != null) {
            return FidoConstants.PASSKEY_PROTOCOL_ERROR_PREFIX_STRING + exception.getClass().getName() + ": " + exception.getMessage();
        }
        return FidoConstants.PASSKEY_PROTOCOL_ERROR_PREFIX_STRING + errorMessage;
    }
}
