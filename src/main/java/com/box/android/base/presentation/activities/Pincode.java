package com.box.android.base.presentation.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.work.PeriodicWorkRequest;
import com.box.android.base.R;
import com.box.android.base.presentation.presenters.BiometricsPresenter;
import com.box.android.base.vm.BiometricsVM;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.modelcontroller.messages.BoxPincodeMessage;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalStatics;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public class Pincode extends Hilt_Pincode {
    public static final long DEFAULT_PAUSE_DELAY = 300;
    public static final int MAX_TRIES = 2;
    private static final long PIN_CODE_IGNORE_DURATION = 60000;
    public static final String PIN_CODE_IGNORE_DURATION_PREFS_KEY = "pinCodeIgnoreDuration";
    public static final String PIN_CODE_PREFS_KEY = "pinCode";
    public static final String PIN_FAILURE_START_TIME_PREFS_KEY = "pinFailureStartTime";
    public static final String TIMES_FAILED_PREFS_KEY = "timesPinFailed";
    public static final int TIME_BETWEEN_TRIES = 900000;
    private static Map<String, Long> mPinCodeIgnoreStartTimes = new HashMap();
    private BiometricsVM mBiometricsVM;
    private EditText mPinCodeBox;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected boolean requiresPinCode() {
        return false;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(R.layout.layout_pincode);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        final BiometricsPresenter biometricsPresenter = new BiometricsPresenter(this);
        final ImageButton imageButton = (ImageButton) findViewById(R.id.fingerprint_button);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.base.presentation.activities.Pincode$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBoxCreate$0(biometricsPresenter, view);
            }
        });
        BiometricsVM biometricsVM = (BiometricsVM) new ViewModelProvider(this).get(BiometricsVM.class);
        this.mBiometricsVM = biometricsVM;
        biometricsVM.getHasPassedBiometrics().observe(this, new Observer() { // from class: com.box.android.base.presentation.activities.Pincode$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$onBoxCreate$1(imageButton, (BiometricsVM.BiometricResponse) obj);
            }
        });
        this.mBiometricsVM.checkBiometric(biometricsPresenter);
        EditText editText = (EditText) findViewById(R.id.pincodeBox);
        this.mPinCodeBox = editText;
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.box.android.base.presentation.activities.Pincode.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && i != 0) {
                    return false;
                }
                if (keyEvent != null && keyEvent.getAction() != 0) {
                    return false;
                }
                Pincode.this.submitPinCode();
                return true;
            }
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) { // from class: com.box.android.base.presentation.activities.Pincode.2
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.HOME");
                intent.setFlags(268435456);
                Pincode.this.startActivity(intent);
                Pincode.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBoxCreate$0(BiometricsPresenter biometricsPresenter, View view) {
        this.mBiometricsVM.checkBiometric(biometricsPresenter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBoxCreate$1(ImageButton imageButton, BiometricsVM.BiometricResponse biometricResponse) {
        if (biometricResponse != null) {
            imageButton.setVisibility(biometricResponse.isEnabled() ? 0 : 8);
            if (biometricResponse.getPassed() == null || !biometricResponse.getPassed().booleanValue()) {
                return;
            }
            handlePassPincode();
        }
    }

    private void handlePassPincode() {
        updatePinCodeSuccess();
        startIgnorePeriod(this.mUserContextManager);
        finish();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxResume() {
        super.onBoxResume();
        if (!CreatePincodeActivity.userHasSetPincode(this.mUserContextManager) || !shouldShow(this.mUserContextManager)) {
            finish();
        } else {
            resetPin();
        }
    }

    private void resetPin() {
        this.mPinCodeBox.setText("");
        this.mPinCodeBox.requestFocus();
    }

    public static void startPinCodeActivity(Context context) {
        Intent intent = new Intent();
        intent.setClass(ApplicationProvider.application, Pincode.class);
        intent.setFlags(805306368);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitPinCode() {
        String string = this.mPinCodeBox.getText().toString();
        BoxUser userInfo = getUserInfo();
        if (userInfo == null) {
            finish();
            authenticate();
            return;
        }
        String login = userInfo.getLogin();
        if (StringUtils.trimToEmpty(this.mGlobalSettings.getDecryptedToken(getPinHash(this.mUserContextManager))).equals(string)) {
            handlePassPincode();
        } else if (CreatePincodeActivity.createPinHash(string, login, CreatePincodeActivity.EncryptionType.WITH_MD5).equals(getPinHash(this.mUserContextManager))) {
            setPinHash(CreatePincodeActivity.createPinHash(string, login, CreatePincodeActivity.EncryptionType.WITH_KEYSTORE));
            handlePassPincode();
        } else {
            updatePinCodeFailure();
            resetPin();
        }
    }

    public void setPinHash(String str) {
        this.mUserContextManager.getUserSharedPrefs().edit().putString(PIN_CODE_PREFS_KEY, str).commit();
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.box.android.base.presentation.activities.Pincode$3] */
    private void updatePinCodeFailure() {
        int i = getUserSharedPrefs().getLong(PIN_FAILURE_START_TIME_PREFS_KEY, 0L) >= System.currentTimeMillis() - PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS ? getUserSharedPrefs().getInt(TIMES_FAILED_PREFS_KEY, 0) : 0;
        if (i == 0) {
            getUserSharedPrefs().edit().putLong(PIN_FAILURE_START_TIME_PREFS_KEY, System.currentTimeMillis()).commit();
        }
        int i2 = i + 1;
        if (i2 == 2) {
            createWarningDialog(CommonBoxUtil.LS(R.string.You_have_one_more_attempt_before_you_are_logged_out)).show();
        } else {
            createWarningDialog(CommonBoxUtil.LS(R.string.The_pass_code_you_have_entered_is_incorrect)).show();
        }
        if (i2 > 2) {
            showSpinner(CommonBoxUtil.LS(R.string.Please_wait_clearing_user_information));
            new Thread() { // from class: com.box.android.base.presentation.activities.Pincode.3
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    BoxLogUtils.e(IUserContextManager.LOGOUT_ALL_USERS, "User surpassed Pincode failure attempt limit.");
                    Pincode.this.mUserContextManager.destroyAllUsers();
                    Pincode.this.finish();
                }
            }.start();
        } else {
            getUserSharedPrefs().edit().putInt(TIMES_FAILED_PREFS_KEY, i2).commit();
        }
    }

    private void updatePinCodeSuccess() {
        getUserSharedPrefs().edit().putLong(PIN_FAILURE_START_TIME_PREFS_KEY, 0L).commit();
        getUserSharedPrefs().edit().putInt(TIMES_FAILED_PREFS_KEY, 0).commit();
        broadcastPinCodeSuccess();
    }

    private void broadcastPinCodeSuccess() {
        LocalBroadcastManager.getInstance(this).sendBroadcast(new BoxPincodeMessage(getUserInfo().getUserId(), true));
    }

    public static String getPinHash(IUserContextManager iUserContextManager) {
        return iUserContextManager.getUserSharedPrefs().getString(PIN_CODE_PREFS_KEY, null);
    }

    public static boolean shouldShow(IUserContextManager iUserContextManager) {
        return CreatePincodeActivity.userHasSetPincode(iUserContextManager) && (((getPincodeIgnoreStartTime(iUserContextManager) > 1L ? 1 : (getPincodeIgnoreStartTime(iUserContextManager) == 1L ? 0 : -1)) < 0) || ((getPincodeIgnoreStartTime(iUserContextManager) > (SystemClock.elapsedRealtime() - getPincodeIgnoreDuration(iUserContextManager)) ? 1 : (getPincodeIgnoreStartTime(iUserContextManager) == (SystemClock.elapsedRealtime() - getPincodeIgnoreDuration(iUserContextManager)) ? 0 : -1)) < 0)) && !CoreServiceUtils.getIsPinRequiredByMAMPolicy();
    }

    private static long getPincodeIgnoreStartTime(IUserContextManager iUserContextManager) {
        Long l = mPinCodeIgnoreStartTimes.get(iUserContextManager.getCurrentContextId());
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    private static boolean getEnableWaitForIgnorePeriod(IUserContextManager iUserContextManager) {
        return ((ILocalStatics) iUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_STATIC_VARIABLE)).getPincodeUserIgnorePeriodSet().contains(iUserContextManager.getCurrentContextId());
    }

    public static void enableWaitForIgnorePeriod(boolean z, IUserContextManager iUserContextManager) {
        if (z) {
            ((ILocalStatics) iUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_STATIC_VARIABLE)).getPincodeUserIgnorePeriodSet().add(iUserContextManager.getCurrentContextId());
        } else {
            ((ILocalStatics) iUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_STATIC_VARIABLE)).getPincodeUserIgnorePeriodSet().remove(iUserContextManager.getCurrentContextId());
        }
    }

    public static boolean shouldWaitForIgnorePeriod(IUserContextManager iUserContextManager) {
        return getEnableWaitForIgnorePeriod(iUserContextManager);
    }

    public static void startIgnorePeriod(IUserContextManager iUserContextManager) {
        mPinCodeIgnoreStartTimes.put(iUserContextManager.getCurrentContextId(), Long.valueOf(SystemClock.elapsedRealtime()));
    }

    private Dialog createWarningDialog(String str) {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this, R.style.Theme_Box_Dialog_Alert);
        materialAlertDialogBuilder.setIcon(android.R.drawable.ic_dialog_info);
        materialAlertDialogBuilder.setMessage((CharSequence) str);
        materialAlertDialogBuilder.setPositiveButton((CharSequence) CommonBoxUtil.LS(R.string.button_ok), new DialogInterface.OnClickListener() { // from class: com.box.android.base.presentation.activities.Pincode.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return materialAlertDialogBuilder.create();
    }

    public static long getPincodeIgnoreDuration(IUserContextManager iUserContextManager) {
        if (BoxAccountManager.isPasscodeAdminRequired(iUserContextManager.getUserSharedPrefs())) {
            return BoxAccountManager.getRequiredPasscodeLockInterval(iUserContextManager.getUserSharedPrefs());
        }
        return iUserContextManager.getUserSharedPrefs().getLong(PIN_CODE_IGNORE_DURATION_PREFS_KEY, 60000L);
    }

    public static void setPincodeIgnoreDuration(long j, IUserContextManager iUserContextManager) {
        iUserContextManager.getUserSharedPrefs().edit().putLong(PIN_CODE_IGNORE_DURATION_PREFS_KEY, j).commit();
    }
}
