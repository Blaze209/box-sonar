package com.box.android.base.presentation.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.box.android.base.R;
import com.box.android.base.presentation.views.KeyboardListeningEditText;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.coreservices.utilities.BoxKeyManager;
import com.box.android.domain.identity.Crypto;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxLogUtils;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public class CreatePincodeActivity extends Hilt_CreatePincodeActivity implements KeyboardListeningEditText.KeyboardListener {
    public static final String EXTRA_DISABLE_PIN_CODES = "disablePin";
    public static final String EXTRA_MESSAGE = "messagePincode";
    private static final int PIN_CODE_LENGTH = 4;
    private static boolean mIsShowing = false;
    private BoxUser mBoxUser;
    private EditText mPinCodeBox;
    private TextView mPinCodeInstruction;
    private boolean oldPinSuccess = false;
    private String newPinCode = null;
    private boolean disablePinCode = false;
    private final TextWatcher submitTextWatcher = new TextWatcher() { // from class: com.box.android.base.presentation.activities.CreatePincodeActivity.4
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            CreatePincodeActivity.this.findViewById(R.id.btnOK).setEnabled(editable.toString().length() >= 4);
        }
    };

    public enum EncryptionType {
        WITH_MD5,
        WITH_KEYSTORE
    }

    @Override // com.box.android.base.presentation.views.KeyboardListeningEditText.KeyboardListener
    public void onKeyboardOpened() {
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected boolean requiresAuthToken() {
        return true;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected boolean requiresPinCode() {
        return true;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(R.layout.layout_create_pincode);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        mIsShowing = true;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxInitialize(Bundle bundle) {
        super.onBoxInitialize(bundle);
        this.mBoxUser = getUserInfo();
        this.mPinCodeInstruction = (TextView) findViewById(R.id.pincodeInstruction);
        EditText editText = (EditText) findViewById(R.id.pincodeBox);
        this.mPinCodeBox = editText;
        editText.addTextChangedListener(this.submitTextWatcher);
        String stringExtra = getIntent().getStringExtra(EXTRA_MESSAGE);
        if (stringExtra != null) {
            ((TextView) findViewById(R.id.pincodeMessage)).setText(stringExtra);
        } else {
            findViewById(R.id.pincodeMessage).setVisibility(8);
        }
        final Button button = (Button) findViewById(R.id.btnOK);
        button.setEnabled(!TextUtils.isEmpty(stringExtra) && stringExtra.length() >= 4);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.base.presentation.activities.CreatePincodeActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CreatePincodeActivity.this.submitPinCode();
            }
        });
        this.mPinCodeBox.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.box.android.base.presentation.activities.CreatePincodeActivity.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && i != 0) {
                    return false;
                }
                if (keyEvent != null && keyEvent.getAction() != 0) {
                    return keyEvent.getAction() == 1;
                }
                if (CreatePincodeActivity.this.mPinCodeBox.getText().length() >= 4) {
                    button.callOnClick();
                }
                return true;
            }
        });
        findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.base.presentation.activities.CreatePincodeActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CreatePincodeActivity.this.setResult(0);
                CreatePincodeActivity.this.finish();
            }
        });
        boolean booleanExtra = getIntent().getBooleanExtra(EXTRA_DISABLE_PIN_CODES, false);
        this.disablePinCode = booleanExtra;
        if (booleanExtra) {
            updatePinCodeInstruction(R.string.Enter_pass_code_to_disable);
        } else if (userHasSetPincode(this.mUserContextManager)) {
            updatePinCodeInstruction(R.string.Enter_old_pass_code);
        } else {
            updatePinCodeInstruction(R.string.Enter_new_pass_code);
        }
    }

    private void updatePinCodeInstruction(int i) {
        this.mPinCodeInstruction.setText(CommonBoxUtil.LS(i));
        this.mPinCodeInstruction.invalidate();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            onKeyboardClosed();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            setRequestedOrientation(1);
        }
    }

    public static void startActivity() {
        Intent intentCreateIntent = createIntent(ApplicationProvider.application);
        intentCreateIntent.setFlags(268435456);
        ApplicationProvider.application.startActivity(intentCreateIntent);
    }

    public static Intent createIntent(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, CreatePincodeActivity.class);
        return intent;
    }

    public static void startActivity(String str) {
        Intent intent = new Intent();
        intent.setClass(ApplicationProvider.application, CreatePincodeActivity.class);
        intent.setFlags(268435456);
        intent.putExtra(EXTRA_MESSAGE, str);
        ApplicationProvider.application.startActivity(intent);
    }

    public static Intent createDisablePinCodeIntent(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, CreatePincodeActivity.class);
        intent.putExtra(EXTRA_DISABLE_PIN_CODES, true);
        return intent;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxResume() {
        super.onBoxResume();
        resetPin();
    }

    private void resetPin() {
        this.mPinCodeBox.setText("");
        this.mPinCodeBox.requestFocus();
    }

    private void updatePinCodeFailure() {
        resetPin();
        this.mNotificationServices.displayDialog(CommonBoxUtil.LS(R.string.The_pass_code_you_have_entered_is_incorrect));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitPinCode() {
        String string = this.mPinCodeBox.getText().toString();
        if (this.disablePinCode) {
            if (StringUtils.trimToEmpty(this.mGlobalSettings.getDecryptedToken(getPinHash())).equals(string) || createPinHash(string, this.mBoxUser.getLogin(), EncryptionType.WITH_MD5).equals(getPinHash())) {
                clearPinCodeInformation(this.mUserContextManager);
                setResult(-1);
                finish();
                return;
            }
            updatePinCodeFailure();
            return;
        }
        if (userHasSetPincode(this.mUserContextManager) && !this.oldPinSuccess) {
            if (createPinHash(string, this.mBoxUser.getLogin(), EncryptionType.WITH_MD5).equals(getPinHash())) {
                setPinHash(createPinHash(this.newPinCode, this.mBoxUser.getLogin(), EncryptionType.WITH_KEYSTORE));
                this.oldPinSuccess = true;
                updatePinCodeInstruction(R.string.Enter_new_pass_code);
                findViewById(R.id.btnOK).setEnabled(false);
            } else if (StringUtils.trimToEmpty(this.mGlobalSettings.getDecryptedToken(getPinHash())).equals(string)) {
                this.oldPinSuccess = true;
                updatePinCodeInstruction(R.string.Enter_new_pass_code);
                findViewById(R.id.btnOK).setEnabled(false);
            } else {
                updatePinCodeFailure();
            }
            resetPin();
            return;
        }
        String str = this.newPinCode;
        if (str == null) {
            if (string.length() >= 4) {
                this.newPinCode = string;
                updatePinCodeInstruction(R.string.Re_enter_pass_code);
                findViewById(R.id.pincodeMessage).setVisibility(8);
            }
            resetPin();
            return;
        }
        if (str.equals(string)) {
            setPinHash(createPinHash(this.newPinCode, this.mBoxUser.getLogin(), EncryptionType.WITH_KEYSTORE));
            this.mNotificationServices.displayDialog(R.string.Pass_code_successfully_created);
            Pincode.startIgnorePeriod(this.mUserContextManager);
            setResult(-1);
            finish();
            return;
        }
        this.mNotificationServices.displayDialog(CommonBoxUtil.LS(R.string.Your_passcodes_do_not_match));
        updatePinCodeInstruction(R.string.Enter_new_pass_code);
        this.newPinCode = null;
        if (this.mPinCodeBox.requestFocus()) {
            getWindow().setSoftInputMode(5);
        }
        resetPin();
    }

    public String getPinHash() {
        return this.mUserContextManager.getUserSharedPrefs().getString(Pincode.PIN_CODE_PREFS_KEY, null);
    }

    public static String createPinHash(String str, String str2, EncryptionType encryptionType) {
        String strEncrypt;
        String userSalt = getUserSalt(str2);
        if (encryptionType == EncryptionType.WITH_MD5) {
            strEncrypt = Crypto.md5(str2 + userSalt + str);
        } else {
            strEncrypt = BoxKeyManager.encrypt(str);
        }
        if (strEncrypt == null) {
            BoxLogUtils.e("CreatePincodeActivity", String.format("Failed to create pin hash with %s (result is null). Pincode will not be set!", encryptionType.name()));
        }
        return strEncrypt;
    }

    public void setPinHash(String str) {
        this.mUserContextManager.getUserSharedPrefs().edit().putString(Pincode.PIN_CODE_PREFS_KEY, str).commit();
    }

    public static String getUserSalt(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        stringBuffer.append(length);
        int i = 0;
        int i2 = 1;
        while (i < length) {
            stringBuffer.append(str.charAt(i));
            i2++;
            i += i2;
        }
        return stringBuffer.toString();
    }

    public static void clearPinCodeInformation(IUserContextManager iUserContextManager) {
        SharedPreferences.Editor editorEdit = iUserContextManager.getUserSharedPrefs().edit();
        editorEdit.remove(Pincode.PIN_CODE_PREFS_KEY).commit();
        editorEdit.remove(Pincode.PIN_FAILURE_START_TIME_PREFS_KEY).commit();
        editorEdit.remove(Pincode.TIMES_FAILED_PREFS_KEY).commit();
    }

    public static boolean userHasSetPincode(IUserContextManager iUserContextManager) {
        return iUserContextManager.getUserSharedPrefs().getString(Pincode.PIN_CODE_PREFS_KEY, null) != null;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        if (BoxAccountManager.isPasscodeAdminRequired(getUserSharedPrefs()) && !userHasSetPincode(this.mUserContextManager)) {
            startActivity(CommonBoxUtil.LS(R.string.Your_administrator_has_required_a_passcode_be_set));
        }
        mIsShowing = false;
        super.onMAMDestroy();
    }

    public static boolean getIsShowing() {
        return mIsShowing;
    }

    @Override // com.box.android.base.presentation.views.KeyboardListeningEditText.KeyboardListener
    public void onKeyboardClosed() {
        if (this.mPinCodeInstruction.getText().equals(CommonBoxUtil.LS(R.string.Enter_new_pass_code))) {
            ((TextView) findViewById(R.id.pincodeMessage)).setText(CommonBoxUtil.LS(R.string.Invalid_Passcode));
        } else {
            ((TextView) findViewById(R.id.pincodeMessage)).setText(CommonBoxUtil.LS(R.string.Your_passcodes_do_not_match));
        }
        findViewById(R.id.pincodeMessage).setVisibility(0);
    }
}
