package com.yubico.yubikit.android.transport.nfc;

import android.nfc.tech.IsoDep;
import com.yubico.yubikit.core.Transport;
import com.yubico.yubikit.core.smartcard.SmartCardConnection;
import com.yubico.yubikit.core.util.StringUtils;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes3.dex */
public class NfcSmartCardConnection implements SmartCardConnection {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) NfcSmartCardConnection.class);
    private final IsoDep card;

    NfcSmartCardConnection(IsoDep isoDep) {
        this.card = isoDep;
        com.yubico.yubikit.core.internal.Logger.debug(logger, "nfc connection opened");
    }

    @Override // com.yubico.yubikit.core.smartcard.SmartCardConnection
    public Transport getTransport() {
        return Transport.NFC;
    }

    @Override // com.yubico.yubikit.core.smartcard.SmartCardConnection
    public boolean isExtendedLengthApduSupported() {
        return this.card.isExtendedLengthApduSupported();
    }

    @Override // com.yubico.yubikit.core.smartcard.SmartCardConnection
    public byte[] sendAndReceive(byte[] bArr) throws IOException {
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.trace(logger2, "sent: {}", StringUtils.bytesToHex(bArr));
        byte[] bArrTransceive = this.card.transceive(bArr);
        com.yubico.yubikit.core.internal.Logger.trace(logger2, "received: {}", StringUtils.bytesToHex(bArrTransceive));
        return bArrTransceive;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.card.close();
        com.yubico.yubikit.core.internal.Logger.debug(logger, "nfc connection closed");
    }

    @Override // com.yubico.yubikit.core.smartcard.SmartCardConnection
    public byte[] getAtr() {
        byte[] historicalBytes = this.card.getHistoricalBytes();
        return historicalBytes != null ? (byte[]) historicalBytes.clone() : new byte[0];
    }
}
