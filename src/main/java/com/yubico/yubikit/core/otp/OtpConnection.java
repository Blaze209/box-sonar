package com.yubico.yubikit.core.otp;

import com.yubico.yubikit.core.YubiKeyConnection;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface OtpConnection extends YubiKeyConnection {
    public static final int FEATURE_REPORT_SIZE = 8;

    void receive(byte[] bArr) throws IOException;

    void send(byte[] bArr) throws IOException;
}
