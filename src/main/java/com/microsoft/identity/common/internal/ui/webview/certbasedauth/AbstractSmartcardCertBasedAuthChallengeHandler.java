package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import android.app.Activity;
import android.webkit.ClientCertRequest;
import com.microsoft.identity.common.R;
import com.microsoft.identity.common.internal.ui.webview.ISendResultCallback;
import com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager;
import com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper;
import com.microsoft.identity.common.logging.Logger;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AbstractSmartcardCertBasedAuthChallengeHandler<T extends AbstractSmartcardCertBasedAuthManager> extends AbstractCertBasedAuthChallengeHandler {
    protected static final String MAX_ATTEMPTS_MESSAGE = "User has reached the maximum failed attempts allowed.";
    protected static final String NO_PIV_CERTS_FOUND_MESSAGE = "No PIV certificates found on smartcard device.";
    protected static final String USER_CANCEL_MESSAGE = "User canceled smartcard CBA flow.";
    protected final String TAG;
    protected final Activity mActivity;
    protected final T mCbaManager;
    protected final IDialogHolder mDialogHolder;

    protected abstract void clearAllManagerCallbacks();

    protected abstract SmartcardPinDialog.PositiveButtonListener getSmartcardPinDialogPositiveButtonListener(ICertDetails iCertDetails, ClientCertRequest clientCertRequest);

    protected abstract void indicateDisconnectionError(String str);

    protected abstract void prepForNextUserInteraction(IDisconnectionCallback iDisconnectionCallback);

    public abstract void promptSmartcardRemovalForResult(ISendResultCallback iSendResultCallback);

    protected abstract void setPinDialogForIncorrectAttempt(ICertDetails iCertDetails, ClientCertRequest clientCertRequest);

    public AbstractSmartcardCertBasedAuthChallengeHandler(Activity activity, T t, IDialogHolder iDialogHolder, ICertBasedAuthTelemetryHelper iCertBasedAuthTelemetryHelper, String str) {
        this.TAG = str;
        this.mActivity = activity;
        this.mIsCertBasedAuthProceeding = false;
        this.mCbaManager = t;
        this.mDialogHolder = iDialogHolder;
        this.mTelemetryHelper = iCertBasedAuthTelemetryHelper;
        this.mTelemetryHelper.setCertBasedAuthChallengeHandler(str);
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.challengehandlers.IChallengeHandler
    public Void processChallenge(final ClientCertRequest clientCertRequest) {
        final String str = this.TAG + ":processChallenge";
        this.mCbaManager.requestDeviceSession(new AbstractSmartcardCertBasedAuthManager.ISessionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler.1
            @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager.ISessionCallback
            public void onGetSession(ISmartcardSession iSmartcardSession) throws Exception {
                final int pinAttemptsRemaining = iSmartcardSession.getPinAttemptsRemaining();
                final List<ICertDetails> certDetailsList = iSmartcardSession.getCertDetailsList();
                AbstractSmartcardCertBasedAuthChallengeHandler.this.prepForNextUserInteraction(new IDisconnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler.1.1
                    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDisconnectionCallback
                    public void onClosedConnection() {
                        if (pinAttemptsRemaining == 0) {
                            AbstractSmartcardCertBasedAuthChallengeHandler.this.promptTooManyFailedPinAttempts(str);
                            clientCertRequest.cancel();
                        } else {
                            if (certDetailsList.isEmpty()) {
                                Logger.info(str, AbstractSmartcardCertBasedAuthChallengeHandler.NO_PIV_CERTS_FOUND_MESSAGE);
                                AbstractSmartcardCertBasedAuthChallengeHandler.this.mTelemetryHelper.setResultFailure(AbstractSmartcardCertBasedAuthChallengeHandler.NO_PIV_CERTS_FOUND_MESSAGE);
                                AbstractSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.showErrorDialog(R.string.smartcard_no_cert_dialog_title, R.string.smartcard_no_cert_dialog_message);
                                clientCertRequest.cancel();
                                return;
                            }
                            AbstractSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.showCertPickerDialog(certDetailsList, AbstractSmartcardCertBasedAuthChallengeHandler.this.getSmartcardCertPickerDialogPositiveButtonListener(clientCertRequest), AbstractSmartcardCertBasedAuthChallengeHandler.this.getGeneralCancelCbaCallback(clientCertRequest));
                        }
                    }
                });
            }

            @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager.ISessionCallback
            public void onException(final Exception exc) {
                clientCertRequest.cancel();
                AbstractSmartcardCertBasedAuthChallengeHandler.this.prepForNextUserInteraction(new IDisconnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler.1.2
                    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDisconnectionCallback
                    public void onClosedConnection() {
                        AbstractSmartcardCertBasedAuthChallengeHandler.this.indicateGeneralException(str, exc);
                    }
                });
            }
        });
        return null;
    }

    protected ICancelCbaCallback getGeneralCancelCbaCallback(final ClientCertRequest clientCertRequest) {
        return new ICancelCbaCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler.2
            @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.ICancelCbaCallback
            public void onCancel() {
                AbstractSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.dismissDialog();
                AbstractSmartcardCertBasedAuthChallengeHandler.this.mTelemetryHelper.setResultFailure(AbstractSmartcardCertBasedAuthChallengeHandler.USER_CANCEL_MESSAGE);
                clientCertRequest.cancel();
            }
        };
    }

    protected void promptTooManyFailedPinAttempts(String str) {
        Logger.info(str, MAX_ATTEMPTS_MESSAGE);
        this.mTelemetryHelper.setResultFailure(MAX_ATTEMPTS_MESSAGE);
        this.mDialogHolder.showErrorDialog(R.string.smartcard_max_attempt_dialog_title, R.string.smartcard_max_attempt_dialog_message);
    }

    protected void indicateGeneralException(String str, Exception exc) {
        Logger.error(str, exc.getMessage(), exc);
        this.mTelemetryHelper.setResultFailure(exc);
        this.mDialogHolder.showErrorDialog(R.string.smartcard_general_error_dialog_title, R.string.smartcard_general_error_dialog_message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SmartcardCertPickerDialog.PositiveButtonListener getSmartcardCertPickerDialogPositiveButtonListener(final ClientCertRequest clientCertRequest) {
        return new SmartcardCertPickerDialog.PositiveButtonListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler.3
            @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardCertPickerDialog.PositiveButtonListener
            public void onClick(ICertDetails iCertDetails) {
                AbstractSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.showPinDialog(AbstractSmartcardCertBasedAuthChallengeHandler.this.getSmartcardPinDialogPositiveButtonListener(iCertDetails, clientCertRequest), AbstractSmartcardCertBasedAuthChallengeHandler.this.getGeneralCancelCbaCallback(clientCertRequest));
            }
        };
    }

    protected void tryUsingSmartcardWithPin(char[] cArr, final ICertDetails iCertDetails, final ClientCertRequest clientCertRequest, ISmartcardSession iSmartcardSession) throws Exception {
        final String str = this.TAG + ":tryUsingSmartcardWithPin";
        if (iSmartcardSession.verifyPin(cArr)) {
            useSmartcardCertForAuth(iCertDetails, cArr, iSmartcardSession, clientCertRequest);
        } else {
            final int pinAttemptsRemaining = iSmartcardSession.getPinAttemptsRemaining();
            prepForNextUserInteraction(new IDisconnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler.4
                @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDisconnectionCallback
                public void onClosedConnection() {
                    if (pinAttemptsRemaining == 0) {
                        AbstractSmartcardCertBasedAuthChallengeHandler.this.promptTooManyFailedPinAttempts(str);
                        clientCertRequest.cancel();
                    } else {
                        AbstractSmartcardCertBasedAuthChallengeHandler.this.setPinDialogForIncorrectAttempt(iCertDetails, clientCertRequest);
                    }
                }
            });
        }
    }

    protected void useSmartcardCertForAuth(ICertDetails iCertDetails, char[] cArr, ISmartcardSession iSmartcardSession, ClientCertRequest clientCertRequest) throws Exception {
        this.mCbaManager.initBeforeProceedingWithRequest(this.mTelemetryHelper);
        PrivateKey keyForAuth = iSmartcardSession.getKeyForAuth(iCertDetails, cArr);
        X509Certificate[] x509CertificateArr = {iCertDetails.getCertificate()};
        this.mTelemetryHelper.setPublicKeyAlgoType(x509CertificateArr[0].getPublicKey().getAlgorithm());
        this.mDialogHolder.dismissDialog();
        this.mIsCertBasedAuthProceeding = true;
        clientCertRequest.proceed(keyForAuth, x509CertificateArr);
    }

    protected void clearPin(char[] cArr) {
        Arrays.fill(cArr, (char) 0);
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractCertBasedAuthChallengeHandler
    public void cleanUp() {
        this.mDialogHolder.dismissDialog();
        clearAllManagerCallbacks();
    }
}
