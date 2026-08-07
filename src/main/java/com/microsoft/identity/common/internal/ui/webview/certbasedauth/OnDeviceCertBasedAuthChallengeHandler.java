package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import android.app.Activity;
import android.security.KeyChain;
import android.security.KeyChainAliasCallback;
import android.security.KeyChainException;
import android.webkit.ClientCertRequest;
import com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper;
import com.microsoft.identity.common.logging.Logger;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes14.dex */
public class OnDeviceCertBasedAuthChallengeHandler extends AbstractCertBasedAuthChallengeHandler {
    private static final String ECDSA_CONSTANT = "ECDSA";
    private static final String TAG = "OnDeviceCertBasedAuthChallengeHandler";
    private final Activity mActivity;

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractCertBasedAuthChallengeHandler
    public void cleanUp() {
    }

    public OnDeviceCertBasedAuthChallengeHandler(Activity activity, ICertBasedAuthTelemetryHelper iCertBasedAuthTelemetryHelper) {
        this.mActivity = activity;
        this.mTelemetryHelper = iCertBasedAuthTelemetryHelper;
        this.mTelemetryHelper.setCertBasedAuthChallengeHandler(TAG);
        this.mIsCertBasedAuthProceeding = false;
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.challengehandlers.IChallengeHandler
    public Void processChallenge(final ClientCertRequest clientCertRequest) {
        final String str = TAG + ":processChallenge";
        Logger.info(str, printRequestDetails(clientCertRequest));
        KeyChain.choosePrivateKeyAlias(this.mActivity, new KeyChainAliasCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.OnDeviceCertBasedAuthChallengeHandler.1
            @Override // android.security.KeyChainAliasCallback
            public void alias(String str2) {
                if (str2 == null) {
                    Logger.info(str, "No certificate chosen by user, cancelling the TLS request.");
                    OnDeviceCertBasedAuthChallengeHandler.this.mTelemetryHelper.setResultFailure("No certificate chosen by user, cancelling the TLS request.");
                    clientCertRequest.cancel();
                    return;
                }
                try {
                    X509Certificate[] certificateChain = KeyChain.getCertificateChain(OnDeviceCertBasedAuthChallengeHandler.this.mActivity.getApplicationContext(), str2);
                    if (certificateChain != null && certificateChain.length > 0) {
                        OnDeviceCertBasedAuthChallengeHandler.this.mTelemetryHelper.setPublicKeyAlgoType(certificateChain[0].getPublicKey().getAlgorithm());
                    }
                    PrivateKey privateKey = KeyChain.getPrivateKey(OnDeviceCertBasedAuthChallengeHandler.this.mActivity, str2);
                    Logger.info(str, "Certificate is chosen by user, proceed with TLS request.");
                    OnDeviceCertBasedAuthChallengeHandler.this.mIsCertBasedAuthProceeding = true;
                    clientCertRequest.proceed(privateKey, certificateChain);
                } catch (KeyChainException e) {
                    Logger.errorPII(str, "KeyChain exception", e);
                    OnDeviceCertBasedAuthChallengeHandler.this.mTelemetryHelper.setResultFailure(e);
                    OnDeviceCertBasedAuthChallengeHandler.this.mTelemetryHelper.setResultFailure("ClientCertRequest unexpectedly cancelled.");
                    clientCertRequest.cancel();
                } catch (InterruptedException e2) {
                    Logger.errorPII(str, "InterruptedException exception", e2);
                    OnDeviceCertBasedAuthChallengeHandler.this.mTelemetryHelper.setResultFailure(e2);
                    OnDeviceCertBasedAuthChallengeHandler.this.mTelemetryHelper.setResultFailure("ClientCertRequest unexpectedly cancelled.");
                    clientCertRequest.cancel();
                }
            }
        }, mapKeyTypes(clientCertRequest.getKeyTypes()), clientCertRequest.getPrincipals(), clientCertRequest.getHost(), clientCertRequest.getPort(), null);
        return null;
    }

    private String printRequestDetails(ClientCertRequest clientCertRequest) {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Processing CBA challenge.");
        if (clientCertRequest.getKeyTypes() != null) {
            sb.append("\nKey Types: ");
            for (String str : clientCertRequest.getKeyTypes()) {
                sb.append(str).append(", ");
            }
        }
        if (clientCertRequest.getPrincipals() != null) {
            sb.append("\nPrincipals: ");
            for (Principal principal : clientCertRequest.getPrincipals()) {
                sb.append(principal.getName()).append(", ");
            }
        }
        sb.append("\nHost: ").append(clientCertRequest.getHost()).append("\nPort: ").append(clientCertRequest.getPort());
        return sb.toString();
    }

    public static String[] mapKeyTypes(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(ECDSA_CONSTANT)) {
                strArr[i] = "EC";
                return strArr;
            }
        }
        return strArr;
    }
}
