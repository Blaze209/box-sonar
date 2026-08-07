package com.yubico.yubikit.android.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.microsoft.intune.mam.client.app.MAMActivity;
import com.yubico.yubikit.android.R;
import com.yubico.yubikit.android.YubiKitManager;
import com.yubico.yubikit.android.transport.nfc.NfcConfiguration;
import com.yubico.yubikit.android.transport.nfc.NfcNotAvailable;
import com.yubico.yubikit.android.transport.nfc.NfcYubiKeyDevice;
import com.yubico.yubikit.android.transport.nfc.NfcYubiKeyManager;
import com.yubico.yubikit.android.transport.usb.UsbConfiguration;
import com.yubico.yubikit.android.transport.usb.UsbYubiKeyDevice;
import com.yubico.yubikit.core.YubiKeyDevice;
import com.yubico.yubikit.core.application.CommandState;
import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Pair;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import javax.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes3.dex */
public class YubiKeyPromptActivity extends MAMActivity {
    public static final String ARG_ACTION_CLASS = "ACTION_CLASS";
    public static final String ARG_ALLOW_NFC = "ALLOW_NFC";
    public static final String ARG_ALLOW_USB = "ALLOW_USB";
    public static final String ARG_CANCEL_BUTTON_ID = "CANCEL_BUTTON_ID";
    public static final String ARG_CONTENT_VIEW_ID = "CONTENT_VIEW_ID";
    public static final String ARG_ENABLE_NFC_BUTTON_ID = "ENABLE_NFC_BUTTON_ID";
    public static final String ARG_HELP_TEXT_VIEW_ID = "HELP_TEXT_VIEW_ID";
    public static final String ARG_TITLE_ID = "TITLE_ID";
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) YubiKeyPromptActivity.class);
    private YubiKeyPromptAction action;
    private boolean allowNfc;
    private boolean allowUsb;
    protected Button cancelButton;
    protected Button enableNfcButton;
    protected TextView helpTextView;
    private YubiKitManager yubiKit;
    private final MyCommandState commandState = new MyCommandState();
    private boolean hasNfc = true;
    private int usbSessionCounter = 0;
    private boolean isDone = false;

    public static Intent createIntent(Context context, Class<? extends YubiKeyPromptAction> cls, int i) {
        Intent intentCreateIntent = createIntent(context, cls);
        intentCreateIntent.putExtra(ARG_TITLE_ID, i);
        return intentCreateIntent;
    }

    public static Intent createIntent(Context context, Class<? extends YubiKeyPromptAction> cls) {
        Intent intent = new Intent(context, (Class<?>) YubiKeyPromptActivity.class);
        intent.putExtra(ARG_ACTION_CLASS, cls);
        return intent;
    }

    protected YubiKitManager getYubiKitManager() {
        return this.yubiKit;
    }

    protected CommandState getCommandState() {
        return this.commandState;
    }

    protected boolean isNfcEnabled() {
        return this.hasNfc;
    }

    protected void onYubiKeyDevice(YubiKeyDevice yubiKeyDevice, final Runnable runnable) {
        this.action.onYubiKey(yubiKeyDevice, getIntent().getExtras(), this.commandState, new Callback() { // from class: com.yubico.yubikit.android.ui.YubiKeyPromptActivity$$ExternalSyntheticLambda8
            @Override // com.yubico.yubikit.core.util.Callback
            public final void invoke(Object obj) {
                this.f$0.m14417xda7cc33f(runnable, (Pair) obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$onYubiKeyDevice$1$com-yubico-yubikit-android-ui-YubiKeyPromptActivity, reason: not valid java name */
    /* synthetic */ void m14417xda7cc33f(Runnable runnable, Pair pair) {
        if (((Integer) pair.first).intValue() == 101) {
            if (this.commandState.awaitingTouch) {
                runOnUiThread(new Runnable() { // from class: com.yubico.yubikit.android.ui.YubiKeyPromptActivity$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m14416x4d4211be();
                    }
                });
                this.commandState.awaitingTouch = false;
            }
        } else {
            provideResult(((Integer) pair.first).intValue(), (Intent) pair.second);
        }
        runnable.run();
    }

    /* JADX INFO: renamed from: lambda$onYubiKeyDevice$0$com-yubico-yubikit-android-ui-YubiKeyPromptActivity, reason: not valid java name */
    /* synthetic */ void m14416x4d4211be() {
        this.helpTextView.setText(this.hasNfc ? R.string.yubikit_prompt_plug_in_or_tap : R.string.yubikit_prompt_plug_in);
    }

    protected void provideResult(int i, Intent intent) {
        setResult(i, intent);
        this.isDone = true;
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(@Nullable Bundle bundle) {
        Class cls;
        super.onMAMCreate(bundle);
        Bundle bundle2 = (Bundle) Objects.requireNonNull(getIntent().getExtras());
        this.allowUsb = bundle2.getBoolean(ARG_ALLOW_USB, true);
        this.allowNfc = bundle2.getBoolean(ARG_ALLOW_NFC, true);
        if (Build.VERSION.SDK_INT >= 33) {
            cls = (Class) bundle2.getSerializable(ARG_ACTION_CLASS, Class.class);
        } else {
            cls = (Class) bundle2.getSerializable(ARG_ACTION_CLASS);
        }
        if (cls != null) {
            try {
                if (YubiKeyPromptAction.class.isAssignableFrom(cls)) {
                    this.action = (YubiKeyPromptAction) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    setContentView(bundle2.getInt(ARG_CONTENT_VIEW_ID, R.layout.yubikit_yubikey_prompt_content));
                    if (bundle2.containsKey(ARG_TITLE_ID)) {
                        setTitle(bundle2.getInt(ARG_TITLE_ID));
                    }
                    TextView textView = (TextView) findViewById(R.id.yubikit_prompt_title);
                    if (textView != null) {
                        textView.setText(getTitle());
                    }
                    this.helpTextView = (TextView) findViewById(bundle2.getInt(ARG_HELP_TEXT_VIEW_ID, R.id.yubikit_prompt_help_text_view));
                    Button button = (Button) findViewById(bundle2.getInt(ARG_CANCEL_BUTTON_ID, R.id.yubikit_prompt_cancel_btn));
                    this.cancelButton = button;
                    button.setFocusable(false);
                    this.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.yubico.yubikit.android.ui.YubiKeyPromptActivity$$ExternalSyntheticLambda5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.m14407xbc7af142(view);
                        }
                    });
                    YubiKitManager yubiKitManager = new YubiKitManager(this);
                    this.yubiKit = yubiKitManager;
                    if (this.allowUsb) {
                        yubiKitManager.startUsbDiscovery(new UsbConfiguration(), new Callback() { // from class: com.yubico.yubikit.android.ui.YubiKeyPromptActivity$$ExternalSyntheticLambda6
                            @Override // com.yubico.yubikit.core.util.Callback
                            public final void invoke(Object obj) {
                                this.f$0.m14411xf165b746((UsbYubiKeyDevice) obj);
                            }
                        });
                    }
                    if (this.allowNfc) {
                        Button button2 = (Button) findViewById(bundle2.getInt(ARG_ENABLE_NFC_BUTTON_ID, R.id.yubikit_prompt_enable_nfc_btn));
                        this.enableNfcButton = button2;
                        button2.setFocusable(false);
                        this.enableNfcButton.setOnClickListener(new View.OnClickListener() { // from class: com.yubico.yubikit.android.ui.YubiKeyPromptActivity$$ExternalSyntheticLambda7
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                this.f$0.m14412x7ea068c7(view);
                            }
                        });
                        return;
                    }
                    return;
                }
            } catch (IllegalAccessException | IllegalStateException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                com.yubico.yubikit.core.internal.Logger.error(logger, "Unable to instantiate ConnectionAction", e);
                finish();
            }
        }
        throw new IllegalStateException("Missing or invalid ConnectionAction class");
    }

    /* JADX INFO: renamed from: lambda$onCreate$2$com-yubico-yubikit-android-ui-YubiKeyPromptActivity, reason: not valid java name */
    /* synthetic */ void m14407xbc7af142(View view) {
        this.commandState.cancel();
        setResult(0);
        finish();
    }

    /* JADX INFO: renamed from: lambda$onCreate$6$com-yubico-yubikit-android-ui-YubiKeyPromptActivity, reason: not valid java name */
    /* synthetic */ void m14411xf165b746(UsbYubiKeyDevice usbYubiKeyDevice) {
        this.usbSessionCounter++;
        usbYubiKeyDevice.setOnClosed(new Runnable() { // from class: com.yubico.yubikit.android.ui.YubiKeyPromptActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m14409xd6f05444();
            }
        });
        runOnUiThread(new Runnable() { // from class: com.yubico.yubikit.android.ui.YubiKeyPromptActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m14410x642b05c5();
            }
        });
        onYubiKeyDevice(usbYubiKeyDevice, new YubiKeyPromptActivity$$ExternalSyntheticLambda11(this));
    }

    /* JADX INFO: renamed from: lambda$onCreate$4$com-yubico-yubikit-android-ui-YubiKeyPromptActivity, reason: not valid java name */
    /* synthetic */ void m14409xd6f05444() {
        int i = this.usbSessionCounter - 1;
        this.usbSessionCounter = i;
        if (i == 0) {
            runOnUiThread(new Runnable() { // from class: com.yubico.yubikit.android.ui.YubiKeyPromptActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m14408x49b5a2c3();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onCreate$3$com-yubico-yubikit-android-ui-YubiKeyPromptActivity, reason: not valid java name */
    /* synthetic */ void m14408x49b5a2c3() {
        this.helpTextView.setText(this.hasNfc ? R.string.yubikit_prompt_plug_in_or_tap : R.string.yubikit_prompt_plug_in);
    }

    /* JADX INFO: renamed from: lambda$onCreate$5$com-yubico-yubikit-android-ui-YubiKeyPromptActivity, reason: not valid java name */
    /* synthetic */ void m14410x642b05c5() {
        this.helpTextView.setText(R.string.yubikit_prompt_wait);
    }

    /* JADX INFO: renamed from: lambda$onCreate$7$com-yubico-yubikit-android-ui-YubiKeyPromptActivity, reason: not valid java name */
    /* synthetic */ void m14412x7ea068c7(View view) {
        startActivity(new Intent(NfcYubiKeyManager.NFC_SETTINGS_ACTION));
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMResume() {
        super.onMAMResume();
        if (this.allowNfc) {
            this.enableNfcButton.setVisibility(8);
            try {
                this.yubiKit.startNfcDiscovery(new NfcConfiguration(), this, new Callback() { // from class: com.yubico.yubikit.android.ui.YubiKeyPromptActivity$$ExternalSyntheticLambda4
                    @Override // com.yubico.yubikit.core.util.Callback
                    public final void invoke(Object obj) {
                        this.f$0.m14413x87bcc236((NfcYubiKeyDevice) obj);
                    }
                });
            } catch (NfcNotAvailable e) {
                this.hasNfc = false;
                this.helpTextView.setText(R.string.yubikit_prompt_plug_in);
                if (e.isDisabled()) {
                    this.enableNfcButton.setVisibility(0);
                }
            }
        }
    }

    /* JADX INFO: renamed from: lambda$onResume$10$com-yubico-yubikit-android-ui-YubiKeyPromptActivity, reason: not valid java name */
    /* synthetic */ void m14413x87bcc236(final NfcYubiKeyDevice nfcYubiKeyDevice) {
        onYubiKeyDevice(nfcYubiKeyDevice, new Runnable() { // from class: com.yubico.yubikit.android.ui.YubiKeyPromptActivity$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m14415xb61f043a(nfcYubiKeyDevice);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onResume$8$com-yubico-yubikit-android-ui-YubiKeyPromptActivity, reason: not valid java name */
    /* synthetic */ void m14414x28e452b9() {
        this.helpTextView.setText(R.string.yubikit_prompt_remove);
    }

    /* JADX INFO: renamed from: lambda$onResume$9$com-yubico-yubikit-android-ui-YubiKeyPromptActivity, reason: not valid java name */
    /* synthetic */ void m14415xb61f043a(NfcYubiKeyDevice nfcYubiKeyDevice) {
        runOnUiThread(new Runnable() { // from class: com.yubico.yubikit.android.ui.YubiKeyPromptActivity$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m14414x28e452b9();
            }
        });
        nfcYubiKeyDevice.remove(new YubiKeyPromptActivity$$ExternalSyntheticLambda11(this));
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMPause() {
        if (this.allowNfc) {
            this.yubiKit.stopNfcDiscovery(this);
        }
        super.onMAMPause();
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        if (this.allowUsb) {
            this.yubiKit.stopUsbDiscovery();
        }
        super.onMAMDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishIfDone() {
        if (this.isDone) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class MyCommandState extends CommandState {
        boolean awaitingTouch;

        private MyCommandState() {
            this.awaitingTouch = false;
        }

        @Override // com.yubico.yubikit.core.application.CommandState
        public void onKeepAliveStatus(byte b) {
            if (this.awaitingTouch || b != 2) {
                return;
            }
            this.awaitingTouch = true;
            YubiKeyPromptActivity.this.runOnUiThread(new Runnable() { // from class: com.yubico.yubikit.android.ui.YubiKeyPromptActivity$MyCommandState$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m14418x84bc17b0();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onKeepAliveStatus$0$com-yubico-yubikit-android-ui-YubiKeyPromptActivity$MyCommandState, reason: not valid java name */
        /* synthetic */ void m14418x84bc17b0() {
            YubiKeyPromptActivity.this.helpTextView.setText(R.string.yubikit_prompt_uv);
        }
    }
}
