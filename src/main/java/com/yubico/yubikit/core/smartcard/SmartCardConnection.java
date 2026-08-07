package com.yubico.yubikit.core.smartcard;

import com.yubico.yubikit.core.Transport;
import com.yubico.yubikit.core.YubiKeyConnection;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface SmartCardConnection extends YubiKeyConnection {
    byte[] getAtr();

    Transport getTransport();

    boolean isExtendedLengthApduSupported();

    byte[] sendAndReceive(byte[] bArr) throws IOException;
}
