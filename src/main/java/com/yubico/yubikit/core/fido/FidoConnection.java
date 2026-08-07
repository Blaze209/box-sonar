package com.yubico.yubikit.core.fido;

import com.yubico.yubikit.core.YubiKeyConnection;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface FidoConnection extends YubiKeyConnection {
    public static final int PACKET_SIZE = 64;

    void receive(byte[] bArr) throws IOException;

    void send(byte[] bArr) throws IOException;
}
