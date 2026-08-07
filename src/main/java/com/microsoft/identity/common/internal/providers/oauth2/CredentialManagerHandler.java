package com.microsoft.identity.common.internal.providers.oauth2;

import android.app.Activity;
import android.content.Context;
import androidx.credentials.CreatePublicKeyCredentialRequest;
import androidx.credentials.CreatePublicKeyCredentialResponse;
import androidx.credentials.CredentialManager;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.GetPublicKeyCredentialOption;
import com.microsoft.identity.common.logging.Logger;
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

/* JADX INFO: compiled from: CredentialManagerHandler.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/microsoft/identity/common/internal/providers/oauth2/CredentialManagerHandler;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "mCredMan", "Landroidx/credentials/CredentialManager;", "createPasskey", "Landroidx/credentials/CreatePublicKeyCredentialResponse;", "request", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPasskey", "Landroidx/credentials/GetCredentialResponse;", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CredentialManagerHandler {
    public static final String TAG = "CredentialManagerHandler";
    private final Activity activity;
    private final CredentialManager mCredMan;

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.providers.oauth2.CredentialManagerHandler$createPasskey$1, reason: invalid class name */
    /* JADX INFO: compiled from: CredentialManagerHandler.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.common.internal.providers.oauth2.CredentialManagerHandler", f = "CredentialManagerHandler.kt", i = {0}, l = {58}, m = "createPasskey", n = {"methodTag"}, s = {"L$0"})
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
            return CredentialManagerHandler.this.createPasskey(null, this);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.providers.oauth2.CredentialManagerHandler$getPasskey$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CredentialManagerHandler.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.common.internal.providers.oauth2.CredentialManagerHandler", f = "CredentialManagerHandler.kt", i = {0}, l = {82}, m = "getPasskey", n = {"methodTag"}, s = {"L$0"})
    static final class C18161 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C18161(Continuation<? super C18161> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CredentialManagerHandler.this.getPasskey(null, this);
        }
    }

    public CredentialManagerHandler(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        CredentialManager.Companion companion = CredentialManager.INSTANCE;
        Context applicationContext = activity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
        this.mCredMan = companion.create(applicationContext);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object createPasskey(String str, Continuation<? super CreatePublicKeyCredentialResponse> continuation) {
        AnonymousClass1 anonymousClass1;
        String str2;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CreatePublicKeyCredentialRequest createPublicKeyCredentialRequest = new CreatePublicKeyCredentialRequest(str, null, false, null, false, 30, null);
            anonymousClass1.L$0 = "CredentialManagerHandler:createPasskey";
            anonymousClass1.label = 1;
            Object objCreateCredential = this.mCredMan.createCredential(this.activity, createPublicKeyCredentialRequest, anonymousClass1);
            if (objCreateCredential == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objCreateCredential;
            str2 = "CredentialManagerHandler:createPasskey";
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = (String) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.credentials.CreatePublicKeyCredentialResponse");
        CreatePublicKeyCredentialResponse createPublicKeyCredentialResponse = (CreatePublicKeyCredentialResponse) obj;
        Logger.info(str2, "Passkey created successfully.");
        return createPublicKeyCredentialResponse;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getPasskey(String str, Continuation<? super GetCredentialResponse> continuation) {
        C18161 c18161;
        String str2;
        if (continuation instanceof C18161) {
            c18161 = (C18161) continuation;
            if ((c18161.label & Integer.MIN_VALUE) != 0) {
                c18161.label -= Integer.MIN_VALUE;
            } else {
                c18161 = new C18161(continuation);
            }
        } else {
            c18161 = new C18161(continuation);
        }
        Object obj = c18161.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c18161.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GetCredentialRequest getCredentialRequest = new GetCredentialRequest(CollectionsKt.listOf(new GetPublicKeyCredentialOption(str, (byte[]) null, (Set) null, 6, (DefaultConstructorMarker) null)), null, false, null, false, 30, null);
            CredentialManager credentialManager = this.mCredMan;
            Activity activity = this.activity;
            c18161.L$0 = "CredentialManagerHandler:getPasskey";
            c18161.label = 1;
            Object credential = credentialManager.getCredential(activity, getCredentialRequest, c18161);
            if (credential == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = credential;
            str2 = "CredentialManagerHandler:getPasskey";
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = (String) c18161.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Logger.info(str2, "Passkey retrieved successfully.");
        return obj;
    }
}
