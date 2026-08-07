package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import android.app.Activity;
import android.webkit.ClientCertRequest;
import com.microsoft.identity.common.R;
import com.microsoft.identity.common.internal.ui.webview.ISendResultCallback;
import com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper;
import com.microsoft.identity.common.logging.Logger;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes14.dex */
public class NfcSmartcardCertBasedAuthChallengeHandler extends AbstractSmartcardCertBasedAuthChallengeHandler<AbstractNfcSmartcardCertBasedAuthManager> {
    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    protected void indicateDisconnectionError(String str) {
    }

    public NfcSmartcardCertBasedAuthChallengeHandler(Activity activity, AbstractNfcSmartcardCertBasedAuthManager abstractNfcSmartcardCertBasedAuthManager, IDialogHolder iDialogHolder, ICertBasedAuthTelemetryHelper iCertBasedAuthTelemetryHelper) {
        super(activity, abstractNfcSmartcardCertBasedAuthManager, iDialogHolder, iCertBasedAuthTelemetryHelper, "NfcSmartcardCertBasedAuthChallengeHandler");
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    protected void prepForNextUserInteraction(final IDisconnectionCallback iDisconnectionCallback) {
        if (!((AbstractNfcSmartcardCertBasedAuthManager) this.mCbaManager).isDeviceConnected()) {
            iDisconnectionCallback.onClosedConnection();
            return;
        }
        clearAllManagerCallbacks();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.mDialogHolder.showSmartcardRemovalPromptDialog(new IDismissCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.NfcSmartcardCertBasedAuthChallengeHandler.1
            @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDismissCallback
            public void onDismiss() {
                if (atomicBoolean.compareAndSet(false, true)) {
                    ((AbstractNfcSmartcardCertBasedAuthManager) NfcSmartcardCertBasedAuthChallengeHandler.this.mCbaManager).stopDiscovery(NfcSmartcardCertBasedAuthChallengeHandler.this.mActivity);
                    iDisconnectionCallback.onClosedConnection();
                }
            }
        });
        ((AbstractNfcSmartcardCertBasedAuthManager) this.mCbaManager).disconnect(new IDisconnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.NfcSmartcardCertBasedAuthChallengeHandler.2
            @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDisconnectionCallback
            public void onClosedConnection() {
                if (atomicBoolean.compareAndSet(false, true)) {
                    NfcSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.dismissDialog();
                    ((AbstractNfcSmartcardCertBasedAuthManager) NfcSmartcardCertBasedAuthChallengeHandler.this.mCbaManager).stopDiscovery(NfcSmartcardCertBasedAuthChallengeHandler.this.mActivity);
                    iDisconnectionCallback.onClosedConnection();
                }
            }
        });
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    protected SmartcardPinDialog.PositiveButtonListener getSmartcardPinDialogPositiveButtonListener(ICertDetails iCertDetails, ClientCertRequest clientCertRequest) {
        return new AnonymousClass3(clientCertRequest, this.TAG + ":getSmartcardPinDialogPositiveButtonListener", iCertDetails);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.ui.webview.certbasedauth.NfcSmartcardCertBasedAuthChallengeHandler$3, reason: invalid class name */
    class AnonymousClass3 implements SmartcardPinDialog.PositiveButtonListener {
        final /* synthetic */ ICertDetails val$certDetails;
        final /* synthetic */ String val$methodTag;
        final /* synthetic */ ClientCertRequest val$request;

        AnonymousClass3(ClientCertRequest clientCertRequest, String str, ICertDetails iCertDetails) {
            this.val$request = clientCertRequest;
            this.val$methodTag = str;
            this.val$certDetails = iCertDetails;
        }

        @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardPinDialog.PositiveButtonListener
        public void onClick(char[] cArr) {
            NfcSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.showSmartcardNfcPromptDialog(new ICancelCbaCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.NfcSmartcardCertBasedAuthChallengeHandler.3.1
                @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.ICancelCbaCallback
                public void onCancel() {
                    NfcSmartcardCertBasedAuthChallengeHandler.this.getGeneralCancelCbaCallback(AnonymousClass3.this.val$request).onCancel();
                    ((AbstractNfcSmartcardCertBasedAuthManager) NfcSmartcardCertBasedAuthChallengeHandler.this.mCbaManager).stopDiscovery(NfcSmartcardCertBasedAuthChallengeHandler.this.mActivity);
                }
            });
            ((AbstractNfcSmartcardCertBasedAuthManager) NfcSmartcardCertBasedAuthChallengeHandler.this.mCbaManager).setConnectionCallback(new AnonymousClass2(cArr));
            ((AbstractNfcSmartcardCertBasedAuthManager) NfcSmartcardCertBasedAuthChallengeHandler.this.mCbaManager).startDiscovery(NfcSmartcardCertBasedAuthChallengeHandler.this.mActivity);
        }

        /* JADX INFO: renamed from: com.microsoft.identity.common.internal.ui.webview.certbasedauth.NfcSmartcardCertBasedAuthChallengeHandler$3$2, reason: invalid class name */
        class AnonymousClass2 implements IConnectionCallback {
            final /* synthetic */ char[] val$pin;

            AnonymousClass2(char[] cArr) {
                this.val$pin = cArr;
            }

            @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IConnectionCallback
            public void onCreateConnection() {
                NfcSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.showSmartcardNfcLoadingDialog();
                if (((AbstractNfcSmartcardCertBasedAuthManager) NfcSmartcardCertBasedAuthChallengeHandler.this.mCbaManager).isDeviceChanged()) {
                    NfcSmartcardCertBasedAuthChallengeHandler.this.clearPin(this.val$pin);
                    AnonymousClass3.this.val$request.cancel();
                    NfcSmartcardCertBasedAuthChallengeHandler.this.prepForNextUserInteraction(new IDisconnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.NfcSmartcardCertBasedAuthChallengeHandler.3.2.1
                        @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDisconnectionCallback
                        public void onClosedConnection() {
                            Logger.info(AnonymousClass3.this.val$methodTag, "Device connected via NFC is different from initially connected device.");
                            NfcSmartcardCertBasedAuthChallengeHandler.this.mTelemetryHelper.setResultFailure("Device connected via NFC is different from initially connected device.");
                            NfcSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.showErrorDialog(R.string.smartcard_nfc_diff_connected_title, R.string.smartcard_nfc_diff_connected_message, R.string.smartcard_nfc_diff_connected_positive_button);
                        }
                    });
                    return;
                }
                ((AbstractNfcSmartcardCertBasedAuthManager) NfcSmartcardCertBasedAuthChallengeHandler.this.mCbaManager).requestDeviceSession(new AbstractSmartcardCertBasedAuthManager.ISessionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.NfcSmartcardCertBasedAuthChallengeHandler.3.2.2
                    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager.ISessionCallback
                    public void onGetSession(ISmartcardSession iSmartcardSession) throws Exception {
                        NfcSmartcardCertBasedAuthChallengeHandler.this.tryUsingSmartcardWithPin(AnonymousClass2.this.val$pin, AnonymousClass3.this.val$certDetails, AnonymousClass3.this.val$request, iSmartcardSession);
                        NfcSmartcardCertBasedAuthChallengeHandler.this.clearPin(AnonymousClass2.this.val$pin);
                    }

                    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager.ISessionCallback
                    public void onException(final Exception exc) {
                        NfcSmartcardCertBasedAuthChallengeHandler.this.clearPin(AnonymousClass2.this.val$pin);
                        AnonymousClass3.this.val$request.cancel();
                        NfcSmartcardCertBasedAuthChallengeHandler.this.prepForNextUserInteraction(new IDisconnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.NfcSmartcardCertBasedAuthChallengeHandler.3.2.2.1
                            @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDisconnectionCallback
                            public void onClosedConnection() {
                                NfcSmartcardCertBasedAuthChallengeHandler.this.indicateGeneralException(AnonymousClass3.this.val$methodTag, exc);
                            }
                        });
                    }
                });
            }
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    protected void setPinDialogForIncorrectAttempt(ICertDetails iCertDetails, ClientCertRequest clientCertRequest) {
        this.mDialogHolder.showPinDialog(getSmartcardPinDialogPositiveButtonListener(iCertDetails, clientCertRequest), getGeneralCancelCbaCallback(clientCertRequest));
        this.mDialogHolder.setPinDialogErrorMode();
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    public void promptSmartcardRemovalForResult(final ISendResultCallback iSendResultCallback) {
        if (((AbstractNfcSmartcardCertBasedAuthManager) this.mCbaManager).isDeviceConnected()) {
            prepForNextUserInteraction(new IDisconnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.NfcSmartcardCertBasedAuthChallengeHandler.4
                @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDisconnectionCallback
                public void onClosedConnection() {
                    iSendResultCallback.onResultReady();
                }
            });
        } else {
            iSendResultCallback.onResultReady();
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    protected void clearAllManagerCallbacks() {
        ((AbstractNfcSmartcardCertBasedAuthManager) this.mCbaManager).clearConnectionCallback();
    }
}
