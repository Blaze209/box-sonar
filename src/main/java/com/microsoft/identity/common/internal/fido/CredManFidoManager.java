package com.microsoft.identity.common.internal.fido;

import android.content.Context;
import android.os.Build;
import androidx.credentials.Credential;
import androidx.credentials.CredentialManager;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.GetPublicKeyCredentialOption;
import androidx.credentials.PublicKeyCredential;
import androidx.credentials.exceptions.NoCredentialException;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightsManager;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.logging.Logger;
import io.opentelemetry.api.trace.Span;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: CredManFidoManager.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005JA\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/microsoft/identity/common/internal/fido/CredManFidoManager;", "Lcom/microsoft/identity/common/internal/fido/IFidoManager;", "context", "Landroid/content/Context;", "legacyManager", "(Landroid/content/Context;Lcom/microsoft/identity/common/internal/fido/IFidoManager;)V", "getContext", "()Landroid/content/Context;", "credentialManager", "Landroidx/credentials/CredentialManager;", "authenticate", "", ClientData.KEY_CHALLENGE, "relyingPartyIdentifier", "allowedCredentials", "", "userVerificationPolicy", "span", "Lio/opentelemetry/api/trace/Span;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lio/opentelemetry/api/trace/Span;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CredManFidoManager implements IFidoManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = String.valueOf(Reflection.getOrCreateKotlinClass(CredManFidoManager.class).getSimpleName());
    private final Context context;
    private final CredentialManager credentialManager;
    private final IFidoManager legacyManager;

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.fido.CredManFidoManager$authenticate$1, reason: invalid class name */
    /* JADX INFO: compiled from: CredManFidoManager.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.common.internal.fido.CredManFidoManager", f = "CredManFidoManager.kt", i = {0, 0, 0, 0, 0, 0}, l = {91, 102}, m = "authenticate", n = {"this", ClientData.KEY_CHALLENGE, "relyingPartyIdentifier", "allowedCredentials", "userVerificationPolicy", "span"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CredManFidoManager.this.authenticate(null, null, null, null, null, this);
        }
    }

    public CredManFidoManager(Context context, IFidoManager iFidoManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.legacyManager = iFidoManager;
        this.credentialManager = CredentialManager.INSTANCE.create(context);
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: compiled from: CredManFidoManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/identity/common/internal/fido/CredManFidoManager$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return CredManFidoManager.TAG;
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0120  */
    /* JADX WARN: Code duplicated, block: B:41:0x0144 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x0145  */
    /* JADX WARN: Code duplicated, block: B:7:0x0022  */
    @Override // com.microsoft.identity.common.internal.fido.IFidoManager
    public Object authenticate(String str, String str2, List<String> list, String str3, Span span, Continuation<? super String> continuation) throws NoCredentialException {
        AnonymousClass1 anonymousClass1;
        NoCredentialException e;
        IFidoManager iFidoManager;
        Object objAuthenticate;
        CredManFidoManager credManFidoManager = this;
        String str4 = str;
        String str5 = str2;
        List<String> list2 = list;
        String str6 = str3;
        Span span2 = span;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = credManFidoManager.new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = credManFidoManager.new AnonymousClass1(continuation);
        }
        Object credential = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(credential);
            StringBuilder sb = new StringBuilder();
            String str7 = TAG;
            String string = sb.append(str7).append(":authenticate").toString();
            span2.setAttribute(AttributeName.fido_manager.name(), str7);
            GetCredentialRequest getCredentialRequest = new GetCredentialRequest(CollectionsKt.listOf(new GetPublicKeyCredentialOption(WebAuthnJsonUtil.INSTANCE.createJsonAuthRequest(str4, str5, list2, str6), (byte[]) null, (Set) null, 6, (DefaultConstructorMarker) null)), null, false, null, credManFidoManager.legacyManager != null && CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.ENABLE_LEGACY_FIDO_SECURITY_KEY_LOGIC) && Build.VERSION.SDK_INT < 34, 14, null);
            try {
                Logger.info(string, "Calling Credential Manager with a GetCredentialRequest.");
                CredentialManager credentialManager = credManFidoManager.credentialManager;
                Context context = credManFidoManager.context;
                anonymousClass1.L$0 = credManFidoManager;
                anonymousClass1.L$1 = str4;
                anonymousClass1.L$2 = str5;
                anonymousClass1.L$3 = list2;
                anonymousClass1.L$4 = str6;
                anonymousClass1.L$5 = span2;
                anonymousClass1.label = 1;
                credential = credentialManager.getCredential(context, getCredentialRequest, anonymousClass1);
                if (credential == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (NoCredentialException e2) {
                e = e2;
                iFidoManager = credManFidoManager.legacyManager;
                if (iFidoManager != null) {
                    anonymousClass1.L$0 = null;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.L$2 = null;
                    anonymousClass1.L$3 = null;
                    anonymousClass1.L$4 = null;
                    anonymousClass1.L$5 = null;
                    anonymousClass1.label = 2;
                    objAuthenticate = iFidoManager.authenticate(str4, str5, list2, str6, span2, anonymousClass1);
                    if (objAuthenticate != coroutine_suspended) {
                        return objAuthenticate;
                    }
                } else {
                    throw e;
                }
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(credential);
                return credential;
            }
            Span span3 = (Span) anonymousClass1.L$5;
            String str8 = (String) anonymousClass1.L$4;
            List<String> list3 = (List) anonymousClass1.L$3;
            String str9 = (String) anonymousClass1.L$2;
            String str10 = (String) anonymousClass1.L$1;
            CredManFidoManager credManFidoManager2 = (CredManFidoManager) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(credential);
                span2 = span3;
                credManFidoManager = credManFidoManager2;
                str6 = str8;
                str4 = str10;
                list2 = list3;
                str5 = str9;
            } catch (NoCredentialException e3) {
                e = e3;
                span2 = span3;
                credManFidoManager = credManFidoManager2;
                str6 = str8;
                str4 = str10;
                list2 = list3;
                str5 = str9;
                iFidoManager = credManFidoManager.legacyManager;
                if (iFidoManager != null) {
                    anonymousClass1.L$0 = null;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.L$2 = null;
                    anonymousClass1.L$3 = null;
                    anonymousClass1.L$4 = null;
                    anonymousClass1.L$5 = null;
                    anonymousClass1.label = 2;
                    objAuthenticate = iFidoManager.authenticate(str4, str5, list2, str6, span2, anonymousClass1);
                    if (objAuthenticate != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objAuthenticate;
                }
                throw e;
            }
        }
        Credential credential2 = ((GetCredentialResponse) credential).getCredential();
        Intrinsics.checkNotNull(credential2, "null cannot be cast to non-null type androidx.credentials.PublicKeyCredential");
        return WebAuthnJsonUtil.INSTANCE.extractAuthenticatorAssertionResponseJson(((PublicKeyCredential) credential2).getAuthenticationResponseJson());
    }
}
