package com.box.android.auth;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.core.splashscreen.SplashScreen;
import com.box.android.R;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.coreservices.modelcontroller.messages.BoxUserAuthenticationMessage;
import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.utils.BoxLogUtils;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthenticationActivity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0017\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0001¢\u0006\u0002\b\u0013J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\b\u0017J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0011¢\u0006\u0002\b\u0019J\r\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\b\u001cJ\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020\fH\u0002J\u0012\u0010\"\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010$\u001a\u00020\fH\u0016J\b\u0010%\u001a\u00020\u001bH\u0014J\b\u0010&\u001a\u00020\u001bH\u0014J\b\u0010'\u001a\u00020\u001bH\u0014J\b\u0010(\u001a\u00020\u001bH\u0016R$\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010!\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/box/android/auth/AuthenticationActivity;", "Lcom/box/android/base/presentation/activities/BoxEntrypointActivity;", "<init>", "()V", "authCodeExchanger", "Lcom/box/android/auth/AuthCodeExchanger;", "getAuthCodeExchanger$box_generalProdRelease$annotations", "getAuthCodeExchanger$box_generalProdRelease", "()Lcom/box/android/auth/AuthCodeExchanger;", "setAuthCodeExchanger$box_generalProdRelease", "(Lcom/box/android/auth/AuthCodeExchanger;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onBoxCreate", "authenticateFromIntentOrFallback", "launchIntent", "Landroid/content/Intent;", "authenticateFromIntentOrFallback$box_generalProdRelease", "exchangeAuthCodeAndAuthenticate", BoxNoteConstants.NOTES_BUILDER_AUTH_CODE, "", "exchangeAuthCodeAndAuthenticate$box_generalProdRelease", "oauthUrlAuthority", "oauthUrlAuthority$box_generalProdRelease", "hasActiveUsers", "", "hasActiveUsers$box_generalProdRelease", "onAuthenticated", "message", "Lcom/box/android/coreservices/modelcontroller/messages/BoxUserAuthenticationMessage;", "launchMainActivity", "hasResume", "handleOnNewIntent", "intent", "onBoxResume", "authenticateOnResume", "cancelsLaunchIntoCapture", "shouldHandleCaptureLaunch", "amplitudeSetCurrentPage", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public class AuthenticationActivity extends Hilt_AuthenticationActivity {
    public static final String EXTRA_SWITCH_USER = "switch_user";
    private static final String TAG = "AuthenticationActivity";
    private AuthCodeExchanger authCodeExchanger = new AuthCodeExchanger();
    private boolean hasResume;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: AuthenticationActivity.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeepLinkAuthResolver.Decision.values().length];
            try {
                iArr[DeepLinkAuthResolver.Decision.FALLBACK_AUTHENTICATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeepLinkAuthResolver.Decision.IGNORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DeepLinkAuthResolver.Decision.EXCHANGE_AUTH_CODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getAuthCodeExchanger$box_generalProdRelease$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$0() {
        return true;
    }

    @Override // com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity
    public boolean amplitudeSetCurrentPage() {
        return false;
    }

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity
    protected boolean authenticateOnResume() {
        return false;
    }

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity
    protected boolean cancelsLaunchIntoCapture() {
        return false;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected boolean shouldHandleCaptureLaunch() {
        return false;
    }

    /* JADX INFO: compiled from: AuthenticationActivity.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/auth/AuthenticationActivity$Companion;", "", "<init>", "()V", "TAG", "", "EXTRA_SWITCH_USER", "createLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "createSwitchUserIntent", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent createLaunchIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, (Class<?>) AuthenticationActivity.class);
        }

        public final Intent createSwitchUserIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) AuthenticationActivity.class);
            intent.putExtra(AuthenticationActivity.EXTRA_SWITCH_USER, true);
            return intent;
        }
    }

    /* JADX INFO: renamed from: getAuthCodeExchanger$box_generalProdRelease, reason: from getter */
    public final AuthCodeExchanger getAuthCodeExchanger() {
        return this.authCodeExchanger;
    }

    public final void setAuthCodeExchanger$box_generalProdRelease(AuthCodeExchanger authCodeExchanger) {
        Intrinsics.checkNotNullParameter(authCodeExchanger, "<set-?>");
        this.authCodeExchanger = authCodeExchanger;
    }

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity, com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        SplashScreen.INSTANCE.installSplashScreen(this).setKeepOnScreenCondition(new SplashScreen.KeepOnScreenCondition() { // from class: com.box.android.auth.AuthenticationActivity$$ExternalSyntheticLambda2
            @Override // androidx.core.splashscreen.SplashScreen.KeepOnScreenCondition
            public final boolean shouldKeepOnScreen() {
                return AuthenticationActivity.onCreate$lambda$0();
            }
        });
    }

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity, com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle savedInstanceState) {
        super.onBoxCreate(savedInstanceState);
        authenticateFromIntentOrFallback$box_generalProdRelease(getIntent());
    }

    public final void authenticateFromIntentOrFallback$box_generalProdRelease(Intent launchIntent) {
        String strExtractAuthCode = DeepLinkAuthResolver.INSTANCE.extractAuthCode(launchIntent != null ? launchIntent.getData() : null);
        int i = WhenMappings.$EnumSwitchMapping$0[DeepLinkAuthResolver.INSTANCE.resolveDecision(strExtractAuthCode, hasActiveUsers$box_generalProdRelease(), this.mBoxAccountSettings.isEMMMode()).ordinal()];
        if (i == 1) {
            authenticate();
            return;
        }
        if (i == 2) {
            BoxLogUtils.d(TAG, "Ignoring deep-link auth_code (active users or EMM mode)");
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            if (strExtractAuthCode != null) {
                exchangeAuthCodeAndAuthenticate$box_generalProdRelease(strExtractAuthCode);
            }
        }
    }

    public final void exchangeAuthCodeAndAuthenticate$box_generalProdRelease(String authCode) {
        Intrinsics.checkNotNullParameter(authCode, "authCode");
        String strResolveDevpodAuthority = DeepLinkAuthResolver.INSTANCE.resolveDevpodAuthority(BuildConfigProvider.INSTANCE.isDebugBuild(), oauthUrlAuthority$box_generalProdRelease());
        AuthCodeExchanger authCodeExchanger = this.authCodeExchanger;
        CustomBoxSession mBoxSession = this.mBoxSession;
        Intrinsics.checkNotNullExpressionValue(mBoxSession, "mBoxSession");
        authCodeExchanger.exchange(mBoxSession, authCode, strResolveDevpodAuthority, new Function0() { // from class: com.box.android.auth.AuthenticationActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AuthenticationActivity.exchangeAuthCodeAndAuthenticate$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit exchangeAuthCodeAndAuthenticate$lambda$0(final AuthenticationActivity authenticationActivity) {
        authenticationActivity.runOnUiThread(new Runnable() { // from class: com.box.android.auth.AuthenticationActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.authenticate();
            }
        });
        return Unit.INSTANCE;
    }

    public String oauthUrlAuthority$box_generalProdRelease() {
        return BoxBaseApplication.getInstance().getConfigManager().getString(BoxConfigConstants.CONFIG_KEY_OAUTH_URL_AUTHORITY);
    }

    public final boolean hasActiveUsers$box_generalProdRelease() {
        DeepLinkAuthResolver deepLinkAuthResolver = DeepLinkAuthResolver.INSTANCE;
        IUserContextManager mUserContextManager = this.mUserContextManager;
        Intrinsics.checkNotNullExpressionValue(mUserContextManager, "mUserContextManager");
        return deepLinkAuthResolver.computeHasActiveUsers(mUserContextManager, BoxAuthentication.getInstance().getStoredAuthInfo(getApplicationContext()));
    }

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity
    protected void onAuthenticated(BoxUserAuthenticationMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.wasSuccessful()) {
            SharedPreferences userSharedPrefs = this.mUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.FTUX);
            if (userSharedPrefs.getLong(BoxCommonConstants.SHARED_PREF_FIRST_LOGIN_TIMESTAMP, 0L) == 0) {
                Intrinsics.checkNotNull(userSharedPrefs);
                SharedPreferences.Editor editorEdit = userSharedPrefs.edit();
                editorEdit.putLong(BoxCommonConstants.SHARED_PREF_FIRST_LOGIN_TIMESTAMP, System.currentTimeMillis());
                editorEdit.apply();
            }
            launchMainActivity();
            if (getIntent().getBooleanExtra(EXTRA_SWITCH_USER, false)) {
                String string = getString(R.string.x_logged_in, new Object[]{message.getPayload().getLogin()});
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                BoxPresentationUtils.displayToast(string, ApplicationProvider.getApplication().getApplicationContext());
            }
        }
    }

    private final void launchMainActivity() {
        IntentServices mIntentServices = this.mIntentServices;
        Intrinsics.checkNotNullExpressionValue(mIntentServices, "mIntentServices");
        Intent intentNavigationActivityIntent$default = IntentServices.navigationActivityIntent$default(mIntentServices, this, this.mFeatureFlips.getMainScreenRedesign().getEnabled(), null, 4, null);
        intentNavigationActivityIntent$default.setFlags(67108864);
        startActivity(intentNavigationActivityIntent$default);
        finish();
    }

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity, com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void handleOnNewIntent(Intent intent) {
        if (intent != null) {
            setIntent(intent);
        }
        authenticateFromIntentOrFallback$box_generalProdRelease(intent);
        this.hasResume = false;
    }

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity, com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxResume() {
        super.onBoxResume();
        if (this.mUserContextManager.hasValidUserId()) {
            launchMainActivity();
        } else if (this.hasResume) {
            finish();
        }
        this.hasResume = true;
    }
}
