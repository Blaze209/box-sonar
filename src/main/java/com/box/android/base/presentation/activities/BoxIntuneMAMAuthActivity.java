package com.box.android.base.presentation.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.media3.common.C;
import com.box.android.base.R;
import com.box.android.base.presentation.utilities.IntuneAuthMAMListener;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.coreservices.utilities.intune.IntuneAuthManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.metrics.msal.MsalObservability;
import com.box.android.domain.metrics.msal.PolicyBlockedReason;
import com.box.android.domain.services.IAuthenticationService;
import com.pspdfkit.ui.toolbar.ContextualToolbar;
import dagger.hilt.android.AndroidEntryPoint;
import dagger.hilt.android.migration.OptionalInject;
import dagger.hilt.android.migration.OptionalInjectCheck;
import external.sdk.pendo.io.mozilla.javascript.Token;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: BoxIntuneMAMAuthActivity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0014J\b\u00102\u001a\u00020/H\u0002J\u0006\u00103\u001a\u00020/J\b\u00104\u001a\u00020/H\u0002J\b\u00105\u001a\u00020/H\u0002J\b\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020/H\u0002J\b\u00109\u001a\u00020/H\u0002J\u0010\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020+H\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/box/android/base/presentation/activities/BoxIntuneMAMAuthActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "intuneAuthManager", "Lcom/box/android/coreservices/utilities/intune/IntuneAuthManager;", "getIntuneAuthManager", "()Lcom/box/android/coreservices/utilities/intune/IntuneAuthManager;", "setIntuneAuthManager", "(Lcom/box/android/coreservices/utilities/intune/IntuneAuthManager;)V", "appIntentService", "Lcom/box/android/coreservices/services/IntentServices;", "getAppIntentService", "()Lcom/box/android/coreservices/services/IntentServices;", "setAppIntentService", "(Lcom/box/android/coreservices/services/IntentServices;)V", "authRequestService", "Lcom/box/android/domain/services/IAuthenticationService;", "getAuthRequestService", "()Lcom/box/android/domain/services/IAuthenticationService;", "setAuthRequestService", "(Lcom/box/android/domain/services/IAuthenticationService;)V", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "setUserContextManager", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "msalObservability", "Lcom/box/android/domain/metrics/msal/MsalObservability;", "getMsalObservability", "()Lcom/box/android/domain/metrics/msal/MsalObservability;", "setMsalObservability", "(Lcom/box/android/domain/metrics/msal/MsalObservability;)V", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "getFeatureFlips", "()Lcom/box/android/domain/configuration/FeatureFlips;", "setFeatureFlips", "(Lcom/box/android/domain/configuration/FeatureFlips;)V", BoxIntuneMAMAuthActivityKt.USER_EMAIL_EXTRA, "", BoxIntuneMAMAuthActivityKt.IS_MSAL_AUTH_EXTRA, "", BoxIntuneMAMAuthActivityKt.CODE_CHALLENGE_EXTRA, BoxIntuneMAMAuthActivityKt.SHOW_BLOCKING_UI_EXTRA, "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "startAutomaticEnrollment", "showBlockingScreen", "setupClickListeners", "startIntuneLogin", "createIntuneAuthListener", "Lcom/box/android/base/presentation/utilities/IntuneAuthMAMListener;", "performLogout", "openLearnMoreUrl", "setButtonsEnabled", "enabled", "Companion", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
@OptionalInject
public final class BoxIntuneMAMAuthActivity extends Hilt_BoxIntuneMAMAuthActivity {

    @Inject
    public IntentServices appIntentService;

    @Inject
    public IAuthenticationService authRequestService;
    private String codeChallenge;

    @Inject
    public FeatureFlips featureFlips;

    @Inject
    public IntuneAuthManager intuneAuthManager;
    private boolean isMSALAuth;

    @Inject
    public MsalObservability msalObservability;
    private boolean showBlockingUI;

    @Inject
    public IUserContextManager userContextManager;
    private String userEmail;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final Intent getIntent(Context context, String str, boolean z, String str2, boolean z2) {
        return INSTANCE.getIntent(context, str, z, str2, z2);
    }

    @JvmStatic
    public static final void startActivity(Context context, String str, boolean z, String str2, boolean z2) {
        INSTANCE.startActivity(context, str, z, str2, z2);
    }

    public final IntuneAuthManager getIntuneAuthManager() {
        IntuneAuthManager intuneAuthManager = this.intuneAuthManager;
        if (intuneAuthManager != null) {
            return intuneAuthManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("intuneAuthManager");
        return null;
    }

    public final void setIntuneAuthManager(IntuneAuthManager intuneAuthManager) {
        Intrinsics.checkNotNullParameter(intuneAuthManager, "<set-?>");
        this.intuneAuthManager = intuneAuthManager;
    }

    public final IntentServices getAppIntentService() {
        IntentServices intentServices = this.appIntentService;
        if (intentServices != null) {
            return intentServices;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appIntentService");
        return null;
    }

    public final void setAppIntentService(IntentServices intentServices) {
        Intrinsics.checkNotNullParameter(intentServices, "<set-?>");
        this.appIntentService = intentServices;
    }

    public final IAuthenticationService getAuthRequestService() {
        IAuthenticationService iAuthenticationService = this.authRequestService;
        if (iAuthenticationService != null) {
            return iAuthenticationService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("authRequestService");
        return null;
    }

    public final void setAuthRequestService(IAuthenticationService iAuthenticationService) {
        Intrinsics.checkNotNullParameter(iAuthenticationService, "<set-?>");
        this.authRequestService = iAuthenticationService;
    }

    public final IUserContextManager getUserContextManager() {
        IUserContextManager iUserContextManager = this.userContextManager;
        if (iUserContextManager != null) {
            return iUserContextManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userContextManager");
        return null;
    }

    public final void setUserContextManager(IUserContextManager iUserContextManager) {
        Intrinsics.checkNotNullParameter(iUserContextManager, "<set-?>");
        this.userContextManager = iUserContextManager;
    }

    public final MsalObservability getMsalObservability() {
        MsalObservability msalObservability = this.msalObservability;
        if (msalObservability != null) {
            return msalObservability;
        }
        Intrinsics.throwUninitializedPropertyAccessException("msalObservability");
        return null;
    }

    public final void setMsalObservability(MsalObservability msalObservability) {
        Intrinsics.checkNotNullParameter(msalObservability, "<set-?>");
        this.msalObservability = msalObservability;
    }

    public final FeatureFlips getFeatureFlips() {
        FeatureFlips featureFlips = this.featureFlips;
        if (featureFlips != null) {
            return featureFlips;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlips");
        return null;
    }

    public final void setFeatureFlips(FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(featureFlips, "<set-?>");
        this.featureFlips = featureFlips;
    }

    /* JADX INFO: compiled from: BoxIntuneMAMAuthActivity.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\u000bH\u0007J<\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\u000bH\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/base/presentation/activities/BoxIntuneMAMAuthActivity$Companion;", "", "<init>", "()V", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", BoxIntuneMAMAuthActivityKt.USER_EMAIL_EXTRA, "", BoxIntuneMAMAuthActivityKt.IS_MSAL_AUTH_EXTRA, "", BoxIntuneMAMAuthActivityKt.CODE_CHALLENGE_EXTRA, BoxIntuneMAMAuthActivityKt.SHOW_BLOCKING_UI_EXTRA, "startActivity", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Intent getIntent$default(Companion companion, Context context, String str, boolean z, String str2, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            if ((i & 8) != 0) {
                str2 = null;
            }
            if ((i & 16) != 0) {
                z2 = false;
            }
            return companion.getIntent(context, str, z, str2, z2);
        }

        @JvmStatic
        public final Intent getIntent(Context context, String userEmail, boolean isMSALAuth, String codeChallenge, boolean showBlockingUI) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) BoxIntuneMAMAuthActivity.class);
            intent.addFlags(C.BUFFER_FLAG_LAST_SAMPLE);
            intent.putExtra(BoxIntuneMAMAuthActivityKt.USER_EMAIL_EXTRA, userEmail);
            intent.putExtra(BoxIntuneMAMAuthActivityKt.IS_MSAL_AUTH_EXTRA, isMSALAuth);
            intent.putExtra(BoxIntuneMAMAuthActivityKt.CODE_CHALLENGE_EXTRA, codeChallenge);
            intent.putExtra(BoxIntuneMAMAuthActivityKt.SHOW_BLOCKING_UI_EXTRA, showBlockingUI);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            return intent;
        }

        public static /* synthetic */ void startActivity$default(Companion companion, Context context, String str, boolean z, String str2, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            if ((i & 8) != 0) {
                str2 = null;
            }
            if ((i & 16) != 0) {
                z2 = false;
            }
            companion.startActivity(context, str, z, str2, z2);
        }

        @JvmStatic
        public final void startActivity(Context context, String userEmail, boolean isMSALAuth, String codeChallenge, boolean showBlockingUI) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = getIntent(context, userEmail, isMSALAuth, codeChallenge, showBlockingUI);
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                activity.startActivityForResult(intent, 1000);
            } else {
                context.startActivity(intent);
            }
        }
    }

    @Override // com.box.android.base.presentation.activities.Hilt_BoxIntuneMAMAuthActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        this.userEmail = getIntent().getStringExtra(BoxIntuneMAMAuthActivityKt.USER_EMAIL_EXTRA);
        this.isMSALAuth = getIntent().getBooleanExtra(BoxIntuneMAMAuthActivityKt.IS_MSAL_AUTH_EXTRA, false);
        this.codeChallenge = getIntent().getStringExtra(BoxIntuneMAMAuthActivityKt.CODE_CHALLENGE_EXTRA);
        this.showBlockingUI = getIntent().getBooleanExtra(BoxIntuneMAMAuthActivityKt.SHOW_BLOCKING_UI_EXTRA, false);
        if (OptionalInjectCheck.wasInjectedByHilt(this)) {
            if (this.showBlockingUI) {
                getMsalObservability().logMsalPolicyBlocked(PolicyBlockedReason.POLICY_REFRESH_OR_LOST);
                showBlockingScreen();
            } else {
                startAutomaticEnrollment();
            }
        }
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity$startAutomaticEnrollment$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxIntuneMAMAuthActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity$startAutomaticEnrollment$1", f = "BoxIntuneMAMAuthActivity.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09211(Continuation<? super C09211> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BoxIntuneMAMAuthActivity.this.new C09211(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09211) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity$startAutomaticEnrollment$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BoxIntuneMAMAuthActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity$startAutomaticEnrollment$1$1", f = "BoxIntuneMAMAuthActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ BoxIntuneMAMAuthActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01151(BoxIntuneMAMAuthActivity boxIntuneMAMAuthActivity, Continuation<? super C01151> continuation) {
                super(2, continuation);
                this.this$0 = boxIntuneMAMAuthActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01151(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01151) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                IntuneAuthManager intuneAuthManager = this.this$0.getIntuneAuthManager();
                BoxIntuneMAMAuthActivity boxIntuneMAMAuthActivity = this.this$0;
                intuneAuthManager.login(boxIntuneMAMAuthActivity, boxIntuneMAMAuthActivity.userEmail, this.this$0.createIntuneAuthListener());
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new C01151(BoxIntuneMAMAuthActivity.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final void startAutomaticEnrollment() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C09211(null), 3, null);
    }

    public final void showBlockingScreen() {
        setContentView(R.layout.activity_intune_mam_auth);
        setupClickListeners();
    }

    private final void setupClickListeners() {
        ((TextView) findViewById(R.id.connectIntuneButton)).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.startIntuneLogin();
            }
        });
        findViewById(R.id.logOutButton).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.performLogout();
            }
        });
        ((TextView) findViewById(R.id.learnMoreButton)).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.openLearnMoreUrl();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startIntuneLogin() {
        setButtonsEnabled(false);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C09221(null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity$startIntuneLogin$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxIntuneMAMAuthActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity$startIntuneLogin$1", f = "BoxIntuneMAMAuthActivity.kt", i = {}, l = {Token.LETEXPR}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09221(Continuation<? super C09221> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BoxIntuneMAMAuthActivity.this.new C09221(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09221) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity$startIntuneLogin$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BoxIntuneMAMAuthActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity$startIntuneLogin$1$1", f = "BoxIntuneMAMAuthActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ BoxIntuneMAMAuthActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01161(BoxIntuneMAMAuthActivity boxIntuneMAMAuthActivity, Continuation<? super C01161> continuation) {
                super(2, continuation);
                this.this$0 = boxIntuneMAMAuthActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01161(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                IntuneAuthManager intuneAuthManager = this.this$0.getIntuneAuthManager();
                BoxIntuneMAMAuthActivity boxIntuneMAMAuthActivity = this.this$0;
                intuneAuthManager.login(boxIntuneMAMAuthActivity, boxIntuneMAMAuthActivity.userEmail, this.this$0.createIntuneAuthListener());
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new C01161(BoxIntuneMAMAuthActivity.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IntuneAuthMAMListener createIntuneAuthListener() {
        return new IntuneAuthMAMListener(this, getIntuneAuthManager(), getAppIntentService(), getAuthRequestService(), getMsalObservability(), this.isMSALAuth, this.codeChallenge, getFeatureFlips(), null, 256, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performLogout() {
        setButtonsEnabled(false);
        getIntuneAuthManager().clearIntunePrefs();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity$performLogout$1, reason: invalid class name */
    /* JADX INFO: compiled from: BoxIntuneMAMAuthActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity$performLogout$1", f = "BoxIntuneMAMAuthActivity.kt", i = {}, l = {ContextualToolbar.DRAG_BUTTON_ALPHA}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BoxIntuneMAMAuthActivity.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity$performLogout$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BoxIntuneMAMAuthActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity$performLogout$1$1", f = "BoxIntuneMAMAuthActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ BoxIntuneMAMAuthActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01141(BoxIntuneMAMAuthActivity boxIntuneMAMAuthActivity, Continuation<? super C01141> continuation) {
                super(2, continuation);
                this.this$0 = boxIntuneMAMAuthActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01141(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getIntuneAuthManager().signOutUser();
                this.this$0.getUserContextManager().destroyAllUsers();
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new C01141(BoxIntuneMAMAuthActivity.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            BoxIntuneMAMAuthActivity.this.finish();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openLearnMoreUrl() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://support.box.com/hc/en-us/articles/15126803944467-Using-EMM-with-Box")));
    }

    private final void setButtonsEnabled(boolean enabled) {
        ((TextView) findViewById(R.id.connectIntuneButton)).setEnabled(enabled);
        findViewById(R.id.logOutButton).setEnabled(enabled);
        findViewById(R.id.learnMoreButton).setEnabled(enabled);
    }
}
