package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import android.app.Activity;
import android.webkit.ClientCertRequest;
import com.microsoft.identity.common.R;
import com.microsoft.identity.common.internal.ui.webview.ISendResultCallback;
import com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper;
import com.microsoft.identity.common.logging.Logger;

/* JADX INFO: loaded from: classes14.dex */
public class UsbSmartcardCertBasedAuthChallengeHandler extends AbstractSmartcardCertBasedAuthChallengeHandler<AbstractUsbSmartcardCertBasedAuthManager> {
    public UsbSmartcardCertBasedAuthChallengeHandler(Activity activity, AbstractUsbSmartcardCertBasedAuthManager abstractUsbSmartcardCertBasedAuthManager, IDialogHolder iDialogHolder, ICertBasedAuthTelemetryHelper iCertBasedAuthTelemetryHelper) {
        super(activity, abstractUsbSmartcardCertBasedAuthManager, iDialogHolder, iCertBasedAuthTelemetryHelper, "UsbSmartcardCertBasedAuthChallengeHandler");
        ((AbstractUsbSmartcardCertBasedAuthManager) this.mCbaManager).setConnectionCallback(new IConnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.UsbSmartcardCertBasedAuthChallengeHandler.1
            @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IConnectionCallback
            public void onCreateConnection() {
                UsbSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.dismissDialog();
            }
        });
        ((AbstractUsbSmartcardCertBasedAuthManager) this.mCbaManager).setDisconnectionCallback(new IDisconnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.UsbSmartcardCertBasedAuthChallengeHandler.2
            @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDisconnectionCallback
            public void onClosedConnection() {
                if (UsbSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.isDialogShowing()) {
                    UsbSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.onUnexpectedUnplug();
                    if (UsbSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.isSmartcardRemovalPromptDialogShowing()) {
                        return;
                    }
                    UsbSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.showErrorDialog(R.string.smartcard_early_unplug_dialog_title, R.string.smartcard_early_unplug_dialog_message);
                    Logger.verbose(UsbSmartcardCertBasedAuthChallengeHandler.this.TAG, "Smartcard was disconnected while dialog was still displayed.");
                }
            }
        });
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    protected void prepForNextUserInteraction(IDisconnectionCallback iDisconnectionCallback) {
        iDisconnectionCallback.onClosedConnection();
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    protected void indicateDisconnectionError(String str) {
        String str2 = this.TAG + ":" + str;
        this.mDialogHolder.showErrorDialog(R.string.smartcard_early_unplug_dialog_title, R.string.smartcard_early_unplug_dialog_message);
        Logger.verbose(str2, "Smartcard was disconnected while dialog was still displayed.");
        ((AbstractUsbSmartcardCertBasedAuthManager) this.mCbaManager).clearDisconnectionCallback();
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    protected SmartcardPinDialog.PositiveButtonListener getSmartcardPinDialogPositiveButtonListener(final ICertDetails iCertDetails, final ClientCertRequest clientCertRequest) {
        final String str = this.TAG + ":getSmartcardPinDialogPositiveButtonListener";
        return new SmartcardPinDialog.PositiveButtonListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.UsbSmartcardCertBasedAuthChallengeHandler.3
            @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardPinDialog.PositiveButtonListener
            public void onClick(final char[] cArr) {
                ((AbstractUsbSmartcardCertBasedAuthManager) UsbSmartcardCertBasedAuthChallengeHandler.this.mCbaManager).requestDeviceSession(new AbstractSmartcardCertBasedAuthManager.ISessionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.UsbSmartcardCertBasedAuthChallengeHandler.3.1
                    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager.ISessionCallback
                    public void onGetSession(ISmartcardSession iSmartcardSession) throws Exception {
                        UsbSmartcardCertBasedAuthChallengeHandler.this.tryUsingSmartcardWithPin(cArr, iCertDetails, clientCertRequest, iSmartcardSession);
                        UsbSmartcardCertBasedAuthChallengeHandler.this.clearPin(cArr);
                    }

                    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager.ISessionCallback
                    public void onException(Exception exc) {
                        UsbSmartcardCertBasedAuthChallengeHandler.this.indicateGeneralException(str, exc);
                        UsbSmartcardCertBasedAuthChallengeHandler.this.clearAllManagerCallbacks();
                        clientCertRequest.cancel();
                        UsbSmartcardCertBasedAuthChallengeHandler.this.clearPin(cArr);
                    }
                });
            }
        };
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    protected void setPinDialogForIncorrectAttempt(ICertDetails iCertDetails, ClientCertRequest clientCertRequest) {
        this.mDialogHolder.setPinDialogErrorMode();
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    public void promptSmartcardRemovalForResult(final ISendResultCallback iSendResultCallback) {
        if (((AbstractUsbSmartcardCertBasedAuthManager) this.mCbaManager).isDeviceConnected() && !((AbstractUsbSmartcardCertBasedAuthManager) this.mCbaManager).isUsbDeviceInitiallyPluggedIn()) {
            ((AbstractUsbSmartcardCertBasedAuthManager) this.mCbaManager).setDisconnectionCallback(new IDisconnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.UsbSmartcardCertBasedAuthChallengeHandler.4
                @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDisconnectionCallback
                public void onClosedConnection() {
                    UsbSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.dismissDialog();
                    iSendResultCallback.onResultReady();
                }
            });
            this.mDialogHolder.showSmartcardRemovalPromptDialog(new IDismissCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.UsbSmartcardCertBasedAuthChallengeHandler.5
                @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDismissCallback
                public void onDismiss() {
                    iSendResultCallback.onResultReady();
                }
            });
        } else {
            iSendResultCallback.onResultReady();
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    protected void clearAllManagerCallbacks() {
        ((AbstractUsbSmartcardCertBasedAuthManager) this.mCbaManager).clearConnectionCallback();
        ((AbstractUsbSmartcardCertBasedAuthManager) this.mCbaManager).clearDisconnectionCallback();
    }
}
