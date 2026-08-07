package com.microsoft.identity.common.internal.msafederation.google;

import android.app.Activity;
import com.microsoft.identity.common.internal.msafederation.IMsaFederatedSignInProvider;
import com.microsoft.identity.common.internal.msafederation.MsaFederatedSignInProviderFactory;
import com.microsoft.identity.common.java.util.ResultFuture;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: SignInWithGoogleApi.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/microsoft/identity/common/internal/msafederation/google/SignInWithGoogleApi;", "", "federatedSignInProviderFactory", "Lcom/microsoft/identity/common/internal/msafederation/MsaFederatedSignInProviderFactory;", "(Lcom/microsoft/identity/common/internal/msafederation/MsaFederatedSignInProviderFactory;)V", "signIn", "Lcom/microsoft/identity/common/internal/msafederation/google/SignInWithGoogleCredential;", "signInWithGoogleParameters", "Lcom/microsoft/identity/common/internal/msafederation/google/SignInWithGoogleParameters;", "(Lcom/microsoft/identity/common/internal/msafederation/google/SignInWithGoogleParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signInAsync", "Lcom/microsoft/identity/common/java/util/ResultFuture;", "signInSync", "signOut", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SignInWithGoogleApi {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "SignInWithGoogleApi";
    private static volatile SignInWithGoogleApi instance;
    private final MsaFederatedSignInProviderFactory federatedSignInProviderFactory;

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.msafederation.google.SignInWithGoogleApi$signIn$1, reason: invalid class name */
    /* JADX INFO: compiled from: SignInWithGoogleApi.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.common.internal.msafederation.google.SignInWithGoogleApi", f = "SignInWithGoogleApi.kt", i = {}, l = {71}, m = "signIn", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SignInWithGoogleApi.this.signIn(null, this);
        }
    }

    @JvmStatic
    public static final SignInWithGoogleApi getInstance() {
        return INSTANCE.getInstance();
    }

    @JvmStatic
    public static final void setInstance(SignInWithGoogleApi signInWithGoogleApi) {
        INSTANCE.setInstance(signInWithGoogleApi);
    }

    public SignInWithGoogleApi(MsaFederatedSignInProviderFactory federatedSignInProviderFactory) {
        Intrinsics.checkNotNullParameter(federatedSignInProviderFactory, "federatedSignInProviderFactory");
        this.federatedSignInProviderFactory = federatedSignInProviderFactory;
    }

    /* JADX INFO: compiled from: SignInWithGoogleApi.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/microsoft/identity/common/internal/msafederation/google/SignInWithGoogleApi$Companion;", "", "()V", "TAG", "", "instance", "Lcom/microsoft/identity/common/internal/msafederation/google/SignInWithGoogleApi;", "getInstance", "setInstance", "", "api", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SignInWithGoogleApi getInstance() {
            SignInWithGoogleApi signInWithGoogleApi;
            SignInWithGoogleApi signInWithGoogleApi2 = SignInWithGoogleApi.instance;
            if (signInWithGoogleApi2 != null) {
                return signInWithGoogleApi2;
            }
            synchronized (this) {
                signInWithGoogleApi = SignInWithGoogleApi.instance;
                if (signInWithGoogleApi == null) {
                    signInWithGoogleApi = new SignInWithGoogleApi(MsaFederatedSignInProviderFactory.INSTANCE);
                    Companion companion = SignInWithGoogleApi.INSTANCE;
                    SignInWithGoogleApi.instance = signInWithGoogleApi;
                }
            }
            return signInWithGoogleApi;
        }

        @JvmStatic
        public final void setInstance(SignInWithGoogleApi api) {
            Intrinsics.checkNotNullParameter(api, "api");
            SignInWithGoogleApi.instance = api;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object signIn(SignInWithGoogleParameters signInWithGoogleParameters, Continuation<? super SignInWithGoogleCredential> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Object objMo13844signInIoAF18A;
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
            IMsaFederatedSignInProvider provider = this.federatedSignInProviderFactory.getProvider(signInWithGoogleParameters);
            anonymousClass1.label = 1;
            objMo13844signInIoAF18A = provider.mo13844signInIoAF18A(anonymousClass1);
            if (objMo13844signInIoAF18A == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objMo13844signInIoAF18A = ((Result) obj).getValue();
        }
        Throwable thM14783exceptionOrNullimpl = Result.m14783exceptionOrNullimpl(objMo13844signInIoAF18A);
        if (thM14783exceptionOrNullimpl == null) {
            return (SignInWithGoogleCredential) objMo13844signInIoAF18A;
        }
        throw thM14783exceptionOrNullimpl;
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.msafederation.google.SignInWithGoogleApi$signInSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SignInWithGoogleApi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/common/internal/msafederation/google/SignInWithGoogleCredential;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.common.internal.msafederation.google.SignInWithGoogleApi$signInSync$1", f = "SignInWithGoogleApi.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
    static final class C18151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SignInWithGoogleCredential>, Object> {
        final /* synthetic */ SignInWithGoogleParameters $signInWithGoogleParameters;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18151(SignInWithGoogleParameters signInWithGoogleParameters, Continuation<? super C18151> continuation) {
            super(2, continuation);
            this.$signInWithGoogleParameters = signInWithGoogleParameters;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignInWithGoogleApi.this.new C18151(this.$signInWithGoogleParameters, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SignInWithGoogleCredential> continuation) {
            return ((C18151) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objSignIn = SignInWithGoogleApi.this.signIn(this.$signInWithGoogleParameters, this);
            return objSignIn == coroutine_suspended ? coroutine_suspended : objSignIn;
        }
    }

    public final SignInWithGoogleCredential signInSync(SignInWithGoogleParameters signInWithGoogleParameters) {
        Intrinsics.checkNotNullParameter(signInWithGoogleParameters, "signInWithGoogleParameters");
        return (SignInWithGoogleCredential) BuildersKt__BuildersKt.runBlocking$default(null, new C18151(signInWithGoogleParameters, null), 1, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.msafederation.google.SignInWithGoogleApi$signInAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SignInWithGoogleApi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.common.internal.msafederation.google.SignInWithGoogleApi$signInAsync$1", f = "SignInWithGoogleApi.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
    static final class C18141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ResultFuture<SignInWithGoogleCredential> $future;
        final /* synthetic */ SignInWithGoogleParameters $signInWithGoogleParameters;
        Object L$0;
        int label;
        final /* synthetic */ SignInWithGoogleApi this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18141(ResultFuture<SignInWithGoogleCredential> resultFuture, SignInWithGoogleApi signInWithGoogleApi, SignInWithGoogleParameters signInWithGoogleParameters, Continuation<? super C18141> continuation) {
            super(2, continuation);
            this.$future = resultFuture;
            this.this$0 = signInWithGoogleApi;
            this.$signInWithGoogleParameters = signInWithGoogleParameters;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C18141(this.$future, this.this$0, this.$signInWithGoogleParameters, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ResultFuture resultFuture;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ResultFuture<SignInWithGoogleCredential> resultFuture2 = this.$future;
                    this.L$0 = resultFuture2;
                    this.label = 1;
                    Object objSignIn = this.this$0.signIn(this.$signInWithGoogleParameters, this);
                    if (objSignIn == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    resultFuture = resultFuture2;
                    obj = objSignIn;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    resultFuture = (ResultFuture) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                resultFuture.setResult(obj);
            } catch (Exception e) {
                this.$future.setException(e);
            }
            return Unit.INSTANCE;
        }
    }

    public final ResultFuture<SignInWithGoogleCredential> signInAsync(SignInWithGoogleParameters signInWithGoogleParameters) {
        Intrinsics.checkNotNullParameter(signInWithGoogleParameters, "signInWithGoogleParameters");
        ResultFuture<SignInWithGoogleCredential> resultFuture = new ResultFuture<>();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C18141(resultFuture, this, signInWithGoogleParameters, null), 3, null);
        return resultFuture;
    }

    public final Object signOut(Activity activity, Continuation<? super Unit> continuation) {
        Object objSignOut = this.federatedSignInProviderFactory.getProvider(new SignInWithGoogleParameters(activity, null, false, 6, null)).signOut(continuation);
        return objSignOut == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSignOut : Unit.INSTANCE;
    }
}
