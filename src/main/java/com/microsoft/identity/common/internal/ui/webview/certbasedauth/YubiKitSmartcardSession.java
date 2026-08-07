package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import com.microsoft.identity.common.logging.Logger;
import com.yubico.yubikit.core.application.BadResponseException;
import com.yubico.yubikit.core.smartcard.ApduException;
import com.yubico.yubikit.piv.InvalidPinException;
import com.yubico.yubikit.piv.PivSession;
import com.yubico.yubikit.piv.Slot;
import com.yubico.yubikit.piv.jca.PivPrivateKey;
import com.yubico.yubikit.piv.jca.PivProvider;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class YubiKitSmartcardSession implements ISmartcardSession {
    private static final short APDU_EXCEPTION_ERROR_CODE_FILE_NOT_FOUND = 27266;
    private static final String TAG = "YubiKitSmartcardSession";
    private static final String YUBIKEY_PROVIDER = "YKPiv";
    private final PivSession piv;

    public YubiKitSmartcardSession(PivSession pivSession) {
        this.piv = pivSession;
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.ISmartcardSession
    public List<ICertDetails> getCertDetailsList() throws BadResponseException, IOException, ApduException {
        ArrayList arrayList = new ArrayList();
        getAndPutCertDetailsInList(Slot.AUTHENTICATION, this.piv, arrayList);
        getAndPutCertDetailsInList(Slot.SIGNATURE, this.piv, arrayList);
        getAndPutCertDetailsInList(Slot.KEY_MANAGEMENT, this.piv, arrayList);
        getAndPutCertDetailsInList(Slot.CARD_AUTH, this.piv, arrayList);
        return arrayList;
    }

    private void getAndPutCertDetailsInList(Slot slot, PivSession pivSession, List<ICertDetails> list) throws BadResponseException, IOException, ApduException {
        String str = TAG + ":getAndPutCertDetailsInList";
        try {
            list.add(new YubiKitCertDetails(pivSession.getCertificate(slot), slot));
        } catch (ApduException e) {
            if (e.getSw() == 27266) {
                Logger.verbose(str, slot + " slot is empty.");
                return;
            }
            throw e;
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.ISmartcardSession
    public boolean verifyPin(char[] cArr) throws IOException, ApduException {
        String str = TAG + ":verifyPin";
        try {
            this.piv.verifyPin(cArr);
            return true;
        } catch (InvalidPinException unused) {
            Logger.info(str, "Incorrect PIN entered.");
            return false;
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.ISmartcardSession
    public int getPinAttemptsRemaining() throws IOException, ApduException {
        return this.piv.getPinAttempts();
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.ISmartcardSession
    public PrivateKey getKeyForAuth(ICertDetails iCertDetails, char[] cArr) throws Exception {
        String str = TAG + ":getKeyForAuth";
        if (!(iCertDetails instanceof YubiKitCertDetails)) {
            throw new Exception("certDetails is not of type YubiKitCertDetails.");
        }
        KeyStore keyStore = KeyStore.getInstance(YUBIKEY_PROVIDER, new PivProvider(this.piv));
        keyStore.load(null);
        Key key = keyStore.getKey(((YubiKitCertDetails) iCertDetails).getSlot().getStringAlias(), cArr);
        if (!(key instanceof PivPrivateKey)) {
            Logger.error(str, "Private key retrieved from YKPiv keystore is not of type PivPrivateKey.", null);
            throw new Exception("Private key retrieved from YKPiv keystore is not of type PivPrivateKey.");
        }
        return (PivPrivateKey) key;
    }
}
