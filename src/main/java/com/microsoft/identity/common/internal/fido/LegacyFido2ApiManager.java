package com.microsoft.identity.common.internal.fido;

import android.app.PendingIntent;
import android.content.Context;
import androidx.activity.result.ActivityResultLauncher;
import com.google.android.gms.fido.fido2.Fido2ApiClient;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.logging.Logger;
import com.pspdfkit.BuildConfig;
import io.opentelemetry.api.trace.Span;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: LegacyFido2ApiManager.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JA\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J@\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001d2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\u0010\b\u0002\u0010!\u001a\n\u0018\u00010\"j\u0004\u0018\u0001`#H\u0002R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/microsoft/identity/common/internal/fido/LegacyFido2ApiManager;", "Lcom/microsoft/identity/common/internal/fido/IFidoManager;", "context", "Landroid/content/Context;", BuildConfig.FLAVOR, "Lcom/microsoft/identity/common/internal/providers/oauth2/WebViewAuthorizationFragment;", "(Landroid/content/Context;Lcom/microsoft/identity/common/internal/providers/oauth2/WebViewAuthorizationFragment;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getFragment", "()Lcom/microsoft/identity/common/internal/providers/oauth2/WebViewAuthorizationFragment;", "legacyApi", "Lcom/google/android/gms/fido/fido2/Fido2ApiClient;", "authenticate", ClientData.KEY_CHALLENGE, "relyingPartyIdentifier", "allowedCredentials", "", "userVerificationPolicy", "span", "Lio/opentelemetry/api/trace/Span;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lio/opentelemetry/api/trace/Span;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAndThrowException", "", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "methodTag", "errorCode", "message", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LegacyFido2ApiManager implements IFidoManager {
    private final String TAG;
    private final Context context;
    private final WebViewAuthorizationFragment fragment;
    private final Fido2ApiClient legacyApi;

    public LegacyFido2ApiManager(Context context, WebViewAuthorizationFragment fragment) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.context = context;
        this.fragment = fragment;
        this.TAG = String.valueOf(Reflection.getOrCreateKotlinClass(LegacyFido2ApiManager.class).getSimpleName());
        this.legacyApi = new Fido2ApiClient(context);
    }

    public final Context getContext() {
        return this.context;
    }

    public final WebViewAuthorizationFragment getFragment() {
        return this.fragment;
    }

    public final String getTAG() {
        return this.TAG;
    }

    static /* synthetic */ void createAndThrowException$default(LegacyFido2ApiManager legacyFido2ApiManager, CancellableContinuation cancellableContinuation, String str, String str2, String str3, Exception exc, int i, Object obj) {
        if ((i & 16) != 0) {
            exc = null;
        }
        legacyFido2ApiManager.createAndThrowException(cancellableContinuation, str, str2, str3, exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createAndThrowException(CancellableContinuation<? super String> continuation, String methodTag, String errorCode, String message, Exception exception) {
        LegacyFido2ApiException legacyFido2ApiException;
        if (exception != null) {
            legacyFido2ApiException = new LegacyFido2ApiException(errorCode, message, exception);
        } else {
            legacyFido2ApiException = new LegacyFido2ApiException(errorCode, message);
        }
        LegacyFido2ApiException legacyFido2ApiException2 = legacyFido2ApiException;
        Logger.error(methodTag, message, legacyFido2ApiException2);
        if (continuation.isActive()) {
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m14780constructorimpl(ResultKt.createFailure(legacyFido2ApiException2)));
        }
    }

    @Override // com.microsoft.identity.common.internal.fido.IFidoManager
    public Object authenticate(String str, String str2, List<String> list, String str3, Span span, Continuation<? super String> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final String str4 = getTAG() + ":authenticate";
        span.setAttribute(AttributeName.fido_manager.name(), getTAG());
        com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialRequestOptions.Builder builder = new com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialRequestOptions.Builder();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptionsBuild = builder.setChallenge(bytes).setRpId(str2).build();
        Intrinsics.checkNotNullExpressionValue(publicKeyCredentialRequestOptionsBuild, "Builder()\n            .s…ier)\n            .build()");
        Logger.info(str4, "Calling the legacy FIDO2 API with public key credential options to get a PendingIntent.");
        Task<PendingIntent> signPendingIntent = this.legacyApi.getSignPendingIntent(publicKeyCredentialRequestOptionsBuild);
        Intrinsics.checkNotNullExpressionValue(signPendingIntent, "legacyApi.getSignPendingIntent(requestOptions)");
        signPendingIntent.addOnSuccessListener(new OnSuccessListener() { // from class: com.microsoft.identity.common.internal.fido.LegacyFido2ApiManager$authenticate$2$1
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(PendingIntent pendingIntent) {
                if (pendingIntent != null) {
                    Logger.info(str4, "Launching the legacy FIDO2 API PendingIntent.");
                    ActivityResultLauncher<LegacyFido2ApiObject> fidoLauncher = this.getFragment().getFidoLauncher();
                    if (fidoLauncher != null) {
                        final CancellableContinuation<String> cancellableContinuation = cancellableContinuationImpl2;
                        Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.microsoft.identity.common.internal.fido.LegacyFido2ApiManager$authenticate$2$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(String str5) {
                                invoke2(str5);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String assertion) {
                                Intrinsics.checkNotNullParameter(assertion, "assertion");
                                if (cancellableContinuation.isActive()) {
                                    CancellableContinuation<String> cancellableContinuation2 = cancellableContinuation;
                                    Result.Companion companion = Result.INSTANCE;
                                    cancellableContinuation2.resumeWith(Result.m14780constructorimpl(assertion));
                                }
                            }
                        };
                        final CancellableContinuation<String> cancellableContinuation2 = cancellableContinuationImpl2;
                        fidoLauncher.launch(new LegacyFido2ApiObject(function1, new Function1<LegacyFido2ApiException, Unit>() { // from class: com.microsoft.identity.common.internal.fido.LegacyFido2ApiManager$authenticate$2$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LegacyFido2ApiException legacyFido2ApiException) {
                                invoke2(legacyFido2ApiException);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LegacyFido2ApiException exception) {
                                Intrinsics.checkNotNullParameter(exception, "exception");
                                if (cancellableContinuation2.isActive()) {
                                    CancellableContinuation<String> cancellableContinuation3 = cancellableContinuation2;
                                    Result.Companion companion = Result.INSTANCE;
                                    cancellableContinuation3.resumeWith(Result.m14780constructorimpl(ResultKt.createFailure(exception)));
                                }
                            }
                        }, pendingIntent));
                        return;
                    }
                    LegacyFido2ApiManager.createAndThrowException$default(this, cancellableContinuationImpl2, str4, "null_object", "fidoLauncher is null, which indicates that the legacy FIDO2 API is being used where it shouldn't be.", null, 16, null);
                    return;
                }
                LegacyFido2ApiManager.createAndThrowException$default(this, cancellableContinuationImpl2, str4, "null_object", "Returned PendingIntent from legacy API is null.", null, 16, null);
            }
        });
        signPendingIntent.addOnFailureListener(new OnFailureListener() { // from class: com.microsoft.identity.common.internal.fido.LegacyFido2ApiManager$authenticate$2$2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                this.this$0.createAndThrowException(cancellableContinuationImpl2, str4, "get_pending_intent_error", "Failed to get a PendingIntent from the legacy FIDO2 API.", exception);
            }
        });
        signPendingIntent.addOnCanceledListener(new OnCanceledListener() { // from class: com.microsoft.identity.common.internal.fido.LegacyFido2ApiManager$authenticate$2$3
            @Override // com.google.android.gms.tasks.OnCanceledListener
            public final void onCanceled() {
                LegacyFido2ApiManager.createAndThrowException$default(this.this$0, cancellableContinuationImpl2, str4, "get_pending_intent_canceled", "The operation to get a PendingIntent from the legacy FIDO2 API was canceled.", null, 16, null);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
