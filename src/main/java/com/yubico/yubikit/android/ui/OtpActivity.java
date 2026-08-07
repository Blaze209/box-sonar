package com.yubico.yubikit.android.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.yubico.yubikit.android.R;
import com.yubico.yubikit.android.transport.nfc.NfcYubiKeyDevice;
import com.yubico.yubikit.android.transport.usb.UsbConfiguration;
import com.yubico.yubikit.android.transport.usb.UsbYubiKeyDevice;
import com.yubico.yubikit.core.YubiKeyDevice;
import com.yubico.yubikit.core.application.CommandState;
import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.NdefUtils;
import com.yubico.yubikit.core.util.Pair;
import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class OtpActivity extends YubiKeyPromptActivity {
    public static final String EXTRA_ERROR = "error";
    public static final String EXTRA_OTP = "otp";
    public static final int RESULT_ERROR = 1;
    private OtpKeyListener keyListener;
    private int usbSessionCounter = 0;

    @Override // com.yubico.yubikit.android.ui.YubiKeyPromptActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(@Nullable Bundle bundle) {
        getIntent().putExtra(YubiKeyPromptActivity.ARG_ACTION_CLASS, YubiKeyNdefAction.class);
        getIntent().putExtra(YubiKeyPromptActivity.ARG_ALLOW_USB, false);
        super.onMAMCreate(bundle);
        getYubiKitManager().startUsbDiscovery(new UsbConfiguration().handlePermissions(false), new Callback() { // from class: com.yubico.yubikit.android.ui.OtpActivity$$ExternalSyntheticLambda2
            @Override // com.yubico.yubikit.core.util.Callback
            public final void invoke(Object obj) {
                this.f$0.m14405lambda$onCreate$3$comyubicoyubikitandroiduiOtpActivity((UsbYubiKeyDevice) obj);
            }
        });
        this.keyListener = new OtpKeyListener(new OtpKeyListener.OtpListener() { // from class: com.yubico.yubikit.android.ui.OtpActivity.1
            @Override // com.yubico.yubikit.android.ui.OtpKeyListener.OtpListener
            public void onCaptureStarted() {
                OtpActivity.this.helpTextView.setText(R.string.yubikit_prompt_wait);
            }

            @Override // com.yubico.yubikit.android.ui.OtpKeyListener.OtpListener
            public void onCaptureComplete(String str) {
                Intent intent = new Intent();
                intent.putExtra(OtpActivity.EXTRA_OTP, str);
                OtpActivity.this.setResult(-1, intent);
                OtpActivity.this.finish();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onCreate$3$com-yubico-yubikit-android-ui-OtpActivity, reason: not valid java name */
    /* synthetic */ void m14405lambda$onCreate$3$comyubicoyubikitandroiduiOtpActivity(UsbYubiKeyDevice usbYubiKeyDevice) {
        this.usbSessionCounter++;
        usbYubiKeyDevice.setOnClosed(new Runnable() { // from class: com.yubico.yubikit.android.ui.OtpActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m14403lambda$onCreate$1$comyubicoyubikitandroiduiOtpActivity();
            }
        });
        runOnUiThread(new Runnable() { // from class: com.yubico.yubikit.android.ui.OtpActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m14404lambda$onCreate$2$comyubicoyubikitandroiduiOtpActivity();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onCreate$1$com-yubico-yubikit-android-ui-OtpActivity, reason: not valid java name */
    /* synthetic */ void m14403lambda$onCreate$1$comyubicoyubikitandroiduiOtpActivity() {
        int i = this.usbSessionCounter - 1;
        this.usbSessionCounter = i;
        if (i == 0) {
            runOnUiThread(new Runnable() { // from class: com.yubico.yubikit.android.ui.OtpActivity$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m14402lambda$onCreate$0$comyubicoyubikitandroiduiOtpActivity();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-yubico-yubikit-android-ui-OtpActivity, reason: not valid java name */
    /* synthetic */ void m14402lambda$onCreate$0$comyubicoyubikitandroiduiOtpActivity() {
        this.helpTextView.setText(isNfcEnabled() ? R.string.yubikit_prompt_plug_in_or_tap : R.string.yubikit_prompt_plug_in);
    }

    /* JADX INFO: renamed from: lambda$onCreate$2$com-yubico-yubikit-android-ui-OtpActivity, reason: not valid java name */
    /* synthetic */ void m14404lambda$onCreate$2$comyubicoyubikitandroiduiOtpActivity() {
        this.helpTextView.setText(R.string.yubikit_otp_touch);
    }

    @Override // com.yubico.yubikit.android.ui.YubiKeyPromptActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        getYubiKitManager().stopUsbDiscovery();
        super.onMAMDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.keyListener.onKeyEvent(keyEvent);
    }

    static class YubiKeyNdefAction extends YubiKeyPromptAction {
        YubiKeyNdefAction() {
        }

        @Override // com.yubico.yubikit.android.ui.YubiKeyPromptAction
        void onYubiKey(YubiKeyDevice yubiKeyDevice, Bundle bundle, CommandState commandState, Callback<Pair<Integer, Intent>> callback) {
            if (yubiKeyDevice instanceof NfcYubiKeyDevice) {
                Intent intent = new Intent();
                try {
                    intent.putExtra(OtpActivity.EXTRA_OTP, NdefUtils.getNdefPayload(((NfcYubiKeyDevice) yubiKeyDevice).readNdef()));
                    callback.invoke(new Pair<>(-1, intent));
                } catch (IOException e) {
                    intent.putExtra("error", e);
                    callback.invoke(new Pair<>(1, intent));
                }
            }
        }
    }
}
