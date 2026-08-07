package com.box.android.activities.login;

import android.animation.TimeInterpolator;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.box.android.R;
import com.box.android.application.BoxBaseApplication;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.coreservices.modelcontroller.messages.BoxAppRestrictionsMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxUserAuthenticationMessage;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.observability.ObservabilitySettingsManager;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes9.dex */
public class StartScreenActivity extends Hilt_StartScreenActivity {
    private static final int BOX_LOGO_TAP_COUNT_TO_TRIGGER = 10;
    private static final int DIALOG_ID_SMALL_SCREEN_WARNING = 1;
    private static final String EXTRA_START_TIME = "start time";
    private static final String EXTRA_TAG = "tag";
    private int boxLogoTapCounter;
    private boolean mAuthWasSuccessful;
    private BroadcastReceiver mControllerReceiver;
    private LocalBroadcastManager mLocalBroadcastManager;

    @Inject
    protected ObservabilitySettingsManager mObservabilityManager;
    private long mStartTime;
    private String mTag;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected boolean requiresAuthToken() {
        return false;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected boolean shouldValidateRestrictions() {
        return false;
    }

    @Override // com.box.android.activities.analytics.AnalyticsStartScreenActivity, com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        setRequestedOrientation(1);
        if (getIntent() != null) {
            this.mTag = getIntent().getStringExtra("tag");
        }
        if (bundle == null) {
            this.mStartTime = System.currentTimeMillis();
        } else {
            this.mTag = bundle.getString("tag");
            this.mStartTime = bundle.getLong(EXTRA_START_TIME, System.currentTimeMillis());
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BoxUserAuthenticationMessage.ACTION_AUTHENTICATE_USER);
        intentFilter.addAction(BoxAppRestrictionsMessage.ACTION_APP_RESTRICTIONS_CHANGED);
        this.mControllerReceiver = new MAMBroadcastReceiver() { // from class: com.box.android.activities.login.StartScreenActivity.1
            @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
            public void onMAMReceive(Context context, Intent intent) {
                if (intent instanceof BoxUserAuthenticationMessage) {
                    StartScreenActivity.this.onAuthenticated((BoxUserAuthenticationMessage) intent);
                } else if (intent instanceof BoxAppRestrictionsMessage) {
                    StartScreenActivity.this.setResult(202, intent);
                    StartScreenActivity.this.finish();
                }
            }
        };
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        this.mLocalBroadcastManager = localBroadcastManager;
        localBroadcastManager.registerReceiver(this.mControllerReceiver, intentFilter);
        findViewById(R.id.newToBoxButton).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.login.StartScreenActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StartScreenActivity.this.mBoxSession.setUseWelcomeTour(false);
                StartScreenActivity.this.mBoxSession.setUseRegisterWebview(true);
                StartScreenActivity.newStartScreenEventsBuilder().setCtaPageLocation("body").setCtaTarget(BoxAnalyticsParams.PAGE_NAME_ALL_FILES).logEvent(BoxAnalyticsParams.EVENT_SIGN_UP_CTA_CLICKED);
                StartScreenActivity.this.mBoxSession.startAuthenticationUI(BoxAnalyticsParams.FLOW_WELCOME, BoxAnalyticsParams.PAGE_NAME_WELCOME);
                StartScreenActivity.this.mAuthWasSuccessful = true;
                StartScreenActivity.this.finish();
            }
        });
        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.login.StartScreenActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StartScreenActivity.this.mBoxSession.setUseWelcomeTour(false);
                StartScreenActivity.this.mBoxSession.setUseRegisterWebview(false);
                StartScreenActivity.newStartScreenEventsBuilder().setCtaPageLocation("body").setCtaTarget(BoxAnalyticsParams.PAGE_NAME_ALL_FILES).logEvent(BoxAnalyticsParams.EVENT_LOG_IN_CTA_CLICKED);
                StartScreenActivity.this.mBoxSession.startAuthenticationUI(BoxAnalyticsParams.FLOW_WELCOME, BoxAnalyticsParams.PAGE_NAME_WELCOME);
                StartScreenActivity.this.mAuthWasSuccessful = true;
                StartScreenActivity.this.finish();
            }
        });
        if (shouldShowSmallScreenWarning()) {
            showSmallScreenWarning();
        }
        findViewById(R.id.root).post(new Runnable() { // from class: com.box.android.activities.login.StartScreenActivity.4
            @Override // java.lang.Runnable
            public void run() {
                StartScreenActivity.this.showEnterAnimation();
            }
        });
        findViewById(R.id.logo).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.login.StartScreenActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBoxCreate$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBoxCreate$0(View view) {
        int i = this.boxLogoTapCounter + 1;
        this.boxLogoTapCounter = i;
        if (i == 10) {
            showDiagnosisDialog();
        }
    }

    private void showDiagnosisDialog() {
        this.mObservabilityManager.showDefaultDiagnosisModelDialog(this, "Start screen", new ObservabilitySettingsManager.ObservabilityModeListener() { // from class: com.box.android.activities.login.StartScreenActivity$$ExternalSyntheticLambda0
            @Override // com.box.android.observability.ObservabilitySettingsManager.ObservabilityModeListener
            public final void onHandled() {
                this.f$0.authenticateFromExternalLink();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEnterAnimation() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this, R.layout.start_screen_activity_animated);
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.setInterpolator((TimeInterpolator) new AccelerateDecelerateInterpolator());
        autoTransition.setDuration(500L);
        autoTransition.addListener(new Transition.TransitionListener() { // from class: com.box.android.activities.login.StartScreenActivity.5
            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                if (BuildConfigProvider.INSTANCE.isDebugBuild()) {
                    View viewFindViewById = StartScreenActivity.this.findViewById(R.id.configurationOptionsButton);
                    viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.login.StartScreenActivity.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            try {
                                StartScreenActivity.this.startActivityForResult(new Intent(StartScreenActivity.this, Class.forName("com.box.android.activities.ConfigurationOptionsActivity")), 226);
                            } catch (ClassNotFoundException unused) {
                                BoxLogUtils.e("ConfigurationOptionsActivity not found");
                            }
                        }
                    });
                    viewFindViewById.setVisibility(0);
                }
            }
        });
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.root);
        TransitionManager.beginDelayedTransition(constraintLayout, autoTransition);
        constraintSet.applyTo(constraintLayout);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(R.layout.start_screen_activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BoxAmplitudeAnalytics.EventPropertyBuilder newStartScreenEventsBuilder() {
        BoxAmplitudeAnalytics.EventPropertyBuilder eventPropertyBuilderCreateEventBuilder = BoxAmplitudeAnalytics.createEventBuilder();
        eventPropertyBuilderCreateEventBuilder.setFlow(BoxAnalyticsParams.FLOW_WELCOME);
        return eventPropertyBuilderCreateEventBuilder;
    }

    @Override // com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity
    public boolean amplitudeSetCurrentPage() {
        BoxAmplitudeAnalytics.EventPropertyBuilder eventPropertyBuilderCreateEventBuilder = BoxAmplitudeAnalytics.createEventBuilder();
        eventPropertyBuilderCreateEventBuilder.setFlow(BoxAnalyticsParams.FLOW_WELCOME);
        amplitudeSetCurrentPageAndLog(eventPropertyBuilderCreateEventBuilder, BoxAnalyticsParams.PAGE_NAME_WELCOME);
        return true;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxResume() {
        super.onBoxResume();
        if (hasAuthentication()) {
            finish();
        }
    }

    protected void onAuthenticated(BoxUserAuthenticationMessage boxUserAuthenticationMessage) {
        if (boxUserAuthenticationMessage.wasSuccessful()) {
            this.mAuthWasSuccessful = true;
            setResult(-1, boxUserAuthenticationMessage);
            finish();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        if (!this.mAuthWasSuccessful && !hasAuthentication()) {
            BoxAuthentication.getInstance().onAuthenticationFailure(null, null);
        }
        if (this.mStartTime > 0) {
            newStartScreenEventsBuilder().setTimeOnPage(System.currentTimeMillis() - this.mStartTime).logEvent(BoxAnalyticsParams.EVENT_WELCOME_PAGE_EXITED);
        }
        super.finish();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle bundle) {
        bundle.putString("tag", this.mTag);
        bundle.putLong(EXTRA_START_TIME, this.mStartTime);
        super.onMAMSaveInstanceState(bundle);
    }

    public static Intent getInstance(String str) {
        Intent intent = new Intent(BoxBaseApplication.getInstance(), (Class<?>) StartScreenActivity.class);
        intent.setFlags(805306368);
        intent.putExtra("tag", str);
        return intent;
    }

    public static Intent getInstance(Context context) {
        return new Intent(context, (Class<?>) StartScreenActivity.class);
    }

    public static Intent getInstance(String str, String str2, boolean z) {
        return getInstance(str);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        super.onMAMDestroy();
        LocalBroadcastManager localBroadcastManager = this.mLocalBroadcastManager;
        if (localBroadcastManager != null) {
            localBroadcastManager.unregisterReceiver(this.mControllerReceiver);
        }
    }

    private boolean shouldShowSmallScreenWarning() {
        return (getResources().getConfiguration().screenLayout & 15) == 1;
    }

    private void showSmallScreenWarning() {
        showDialog(1, null);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i, Bundle bundle) {
        if (i != 1) {
            return null;
        }
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this);
        materialAlertDialogBuilder.setMessage(R.string.small_screen_warning_message);
        materialAlertDialogBuilder.setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.box.android.activities.login.StartScreenActivity.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        return materialAlertDialogBuilder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void authenticateFromExternalLink() {
        this.mBoxSession.setTriggeredByExternalLink();
        authenticate();
    }
}
