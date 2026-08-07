package com.box.android.base.presentation.utilities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity;
import com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivityKt;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.coreservices.utilities.intune.IntuneAuthManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.metrics.msal.MsalObservability;
import com.box.android.domain.metrics.msal.PolicyBlockedReason;
import com.box.android.domain.services.IAuthenticationService;
import com.box.androidsdk.content.utils.BoxLogUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: IntuneAuthMAMListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0019\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0082@¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u00172\u000e\u0010\u001e\u001a\n\u0018\u00010\u001fj\u0004\u0018\u0001` H\u0016J\b\u0010!\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/box/android/base/presentation/utilities/IntuneAuthMAMListener;", "Lcom/box/android/coreservices/utilities/intune/IntuneAuthManager$MAMListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "intuneAuthManager", "Lcom/box/android/coreservices/utilities/intune/IntuneAuthManager;", "appIntentService", "Lcom/box/android/coreservices/services/IntentServices;", "authRequestService", "Lcom/box/android/domain/services/IAuthenticationService;", "msalObservability", "Lcom/box/android/domain/metrics/msal/MsalObservability;", BoxIntuneMAMAuthActivityKt.IS_MSAL_AUTH_EXTRA, "", BoxIntuneMAMAuthActivityKt.CODE_CHALLENGE_EXTRA, "", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/box/android/coreservices/utilities/intune/IntuneAuthManager;Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/domain/services/IAuthenticationService;Lcom/box/android/domain/metrics/msal/MsalObservability;ZLjava/lang/String;Lcom/box/android/domain/configuration/FeatureFlips;Lkotlinx/coroutines/CoroutineDispatcher;)V", "onSuccess", "", "tokenId", "handleSsoFlow", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleEnrollmentFlow", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "isActivityValid", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IntuneAuthMAMListener implements IntuneAuthManager.MAMListener {
    public static final int $stable = 8;
    private final AppCompatActivity activity;
    private final IntentServices appIntentService;
    private final IAuthenticationService authRequestService;
    private final String codeChallenge;
    private final FeatureFlips featureFlips;
    private final IntuneAuthManager intuneAuthManager;
    private final CoroutineDispatcher ioDispatcher;
    private final boolean isMSALAuth;
    private final MsalObservability msalObservability;

    /* JADX INFO: renamed from: com.box.android.base.presentation.utilities.IntuneAuthMAMListener$handleEnrollmentFlow$1, reason: invalid class name */
    /* JADX INFO: compiled from: IntuneAuthMAMListener.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.utilities.IntuneAuthMAMListener", f = "IntuneAuthMAMListener.kt", i = {}, l = {120}, m = "handleEnrollmentFlow", n = {}, s = {}, v = 1)
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
            return IntuneAuthMAMListener.this.handleEnrollmentFlow(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.utilities.IntuneAuthMAMListener$handleSsoFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IntuneAuthMAMListener.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.utilities.IntuneAuthMAMListener", f = "IntuneAuthMAMListener.kt", i = {0}, l = {74}, m = "handleSsoFlow", n = {"tokenId"}, s = {"L$0"}, v = 1)
    static final class C09341 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09341(Continuation<? super C09341> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IntuneAuthMAMListener.this.handleSsoFlow(null, this);
        }
    }

    public IntuneAuthMAMListener(AppCompatActivity activity, IntuneAuthManager intuneAuthManager, IntentServices appIntentService, IAuthenticationService authRequestService, MsalObservability msalObservability, boolean z, String str, FeatureFlips featureFlips, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intuneAuthManager, "intuneAuthManager");
        Intrinsics.checkNotNullParameter(appIntentService, "appIntentService");
        Intrinsics.checkNotNullParameter(authRequestService, "authRequestService");
        Intrinsics.checkNotNullParameter(msalObservability, "msalObservability");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.activity = activity;
        this.intuneAuthManager = intuneAuthManager;
        this.appIntentService = appIntentService;
        this.authRequestService = authRequestService;
        this.msalObservability = msalObservability;
        this.isMSALAuth = z;
        this.codeChallenge = str;
        this.featureFlips = featureFlips;
        this.ioDispatcher = ioDispatcher;
    }

    public /* synthetic */ IntuneAuthMAMListener(AppCompatActivity appCompatActivity, IntuneAuthManager intuneAuthManager, IntentServices intentServices, IAuthenticationService iAuthenticationService, MsalObservability msalObservability, boolean z, String str, FeatureFlips featureFlips, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appCompatActivity, intuneAuthManager, intentServices, iAuthenticationService, msalObservability, z, str, featureFlips, (i & 256) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    @Override // com.box.android.coreservices.utilities.intune.IntuneAuthManager.MAMListener
    public void onSuccess(String tokenId) {
        if (isActivityValid()) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.activity), null, null, new C09351(tokenId, null), 3, null);
        } else {
            BoxLogUtils.w("IntuneAuthMAMListener", "Activity no longer valid, ignoring success callback");
        }
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.utilities.IntuneAuthMAMListener$onSuccess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IntuneAuthMAMListener.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.utilities.IntuneAuthMAMListener$onSuccess$1", f = "IntuneAuthMAMListener.kt", i = {}, l = {59, 62}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $tokenId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09351(String str, Continuation<? super C09351> continuation) {
            super(2, continuation);
            this.$tokenId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IntuneAuthMAMListener.this.new C09351(this.$tokenId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09351) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
        
            if (r4.this$0.handleSsoFlow(r4.$tokenId, r4) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
        
            if (r4.this$0.handleEnrollmentFlow(r4) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0043, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1b
                if (r1 == r3) goto L17
                if (r1 != r2) goto Lf
                goto L17
            Lf:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L17:
                kotlin.ResultKt.throwOnFailure(r5)
                goto L44
            L1b:
                kotlin.ResultKt.throwOnFailure(r5)
                com.box.android.base.presentation.utilities.IntuneAuthMAMListener r5 = com.box.android.base.presentation.utilities.IntuneAuthMAMListener.this
                boolean r5 = com.box.android.base.presentation.utilities.IntuneAuthMAMListener.access$isMSALAuth$p(r5)
                if (r5 == 0) goto L36
                com.box.android.base.presentation.utilities.IntuneAuthMAMListener r5 = com.box.android.base.presentation.utilities.IntuneAuthMAMListener.this
                java.lang.String r1 = r4.$tokenId
                r2 = r4
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r4.label = r3
                java.lang.Object r4 = com.box.android.base.presentation.utilities.IntuneAuthMAMListener.access$handleSsoFlow(r5, r1, r2)
                if (r4 != r0) goto L44
                goto L43
            L36:
                com.box.android.base.presentation.utilities.IntuneAuthMAMListener r5 = com.box.android.base.presentation.utilities.IntuneAuthMAMListener.this
                r1 = r4
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r4.label = r2
                java.lang.Object r4 = com.box.android.base.presentation.utilities.IntuneAuthMAMListener.access$handleEnrollmentFlow(r5, r1)
                if (r4 != r0) goto L44
            L43:
                return r0
            L44:
                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.base.presentation.utilities.IntuneAuthMAMListener.C09351.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object handleSsoFlow(String str, Continuation<? super Unit> continuation) {
        C09341 c09341;
        if (continuation instanceof C09341) {
            c09341 = (C09341) continuation;
            if ((c09341.label & Integer.MIN_VALUE) != 0) {
                c09341.label -= Integer.MIN_VALUE;
            } else {
                c09341 = new C09341(continuation);
            }
        } else {
            c09341 = new C09341(continuation);
        }
        Object objWithContext = c09341.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09341.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithContext);
            BoxLogUtils.i("IntuneAuthMAMListener", "SSO flow: completing Box authentication");
            CoroutineDispatcher coroutineDispatcher = this.ioDispatcher;
            IntuneAuthMAMListener$handleSsoFlow$msalAccessCode$1 intuneAuthMAMListener$handleSsoFlow$msalAccessCode$1 = new IntuneAuthMAMListener$handleSsoFlow$msalAccessCode$1(str, this, null);
            c09341.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c09341.label = 1;
            objWithContext = BuildersKt.withContext(coroutineDispatcher, intuneAuthMAMListener$handleSsoFlow$msalAccessCode$1, c09341);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        String str2 = (String) objWithContext;
        if (!isActivityValid()) {
            BoxLogUtils.w("IntuneAuthMAMListener", "Activity destroyed during SSO flow, aborting");
            return Unit.INSTANCE;
        }
        if (str2 != null) {
            this.intuneAuthManager.setLoginNeeded(false);
            Intent intent = new Intent();
            intent.putExtra(BoxIntuneMAMAuthActivityKt.MSAL_ACCESS_CODE_EXTRA, str2);
            this.activity.setResult(-1, intent);
            this.activity.finish();
        } else {
            BoxLogUtils.e("IntuneAuthMAMListener", "Failed to get MSAL access code, finishing");
            this.activity.setResult(0);
            this.activity.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object handleEnrollmentFlow(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
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
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithContext);
            BoxLogUtils.i("IntuneAuthMAMListener", "Enrollment flow: checking policies after MSAL auth");
            CoroutineDispatcher coroutineDispatcher = this.ioDispatcher;
            IntuneAuthMAMListener$handleEnrollmentFlow$isManaged$1 intuneAuthMAMListener$handleEnrollmentFlow$isManaged$1 = new IntuneAuthMAMListener$handleEnrollmentFlow$isManaged$1(this, null);
            anonymousClass1.label = 1;
            objWithContext = BuildersKt.withContext(coroutineDispatcher, intuneAuthMAMListener$handleEnrollmentFlow$isManaged$1, anonymousClass1);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        boolean zBooleanValue = ((Boolean) objWithContext).booleanValue();
        if (!isActivityValid()) {
            BoxLogUtils.w("IntuneAuthMAMListener", "Activity destroyed during enrollment flow, aborting");
            return Unit.INSTANCE;
        }
        if (!zBooleanValue) {
            BoxLogUtils.w("IntuneAuthMAMListener", "User authenticated but has no policies, showing blocking screen");
            this.msalObservability.logMsalPolicyBlocked(PolicyBlockedReason.NO_POLICIES_AFTER_ENROLLMENT);
            AppCompatActivity appCompatActivity = this.activity;
            BoxIntuneMAMAuthActivity boxIntuneMAMAuthActivity = appCompatActivity instanceof BoxIntuneMAMAuthActivity ? (BoxIntuneMAMAuthActivity) appCompatActivity : null;
            if (boxIntuneMAMAuthActivity != null) {
                boxIntuneMAMAuthActivity.showBlockingScreen();
            }
            return Unit.INSTANCE;
        }
        BoxLogUtils.i("IntuneAuthMAMListener", "User has policies, proceeding to main app");
        this.intuneAuthManager.setLoginNeeded(false);
        Intent intentNavigationActivityIntent$default = IntentServices.navigationActivityIntent$default(this.appIntentService, this.activity, this.featureFlips.getMainScreenRedesign().getEnabled(), null, 4, null);
        intentNavigationActivityIntent$default.setFlags(67108864);
        this.activity.setResult(-1, intentNavigationActivityIntent$default);
        this.activity.startActivity(intentNavigationActivityIntent$default);
        this.activity.finish();
        return Unit.INSTANCE;
    }

    @Override // com.box.android.coreservices.utilities.intune.IntuneAuthManager.MAMListener
    public void onError(Exception exception) {
        BoxLogUtils.e("IntuneAuthMAMListener", "MSAL auth error: " + (exception != null ? exception.getMessage() : null));
        if (this.isMSALAuth) {
            this.intuneAuthManager.signOutUser();
        }
        if (!isActivityValid()) {
            BoxLogUtils.w("IntuneAuthMAMListener", "Activity no longer valid, ignoring error callback");
        } else {
            this.activity.setResult(0);
            this.activity.finish();
        }
    }

    private final boolean isActivityValid() {
        return (this.activity.isFinishing() || this.activity.isDestroyed() || !this.activity.getLifecycleRegistry().getState().isAtLeast(Lifecycle.State.CREATED)) ? false : true;
    }
}
