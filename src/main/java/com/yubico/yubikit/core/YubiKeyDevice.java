package com.yubico.yubikit.core;

import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface YubiKeyDevice {
    Transport getTransport();

    <T extends YubiKeyConnection> T openConnection(Class<T> cls) throws IOException;

    <T extends YubiKeyConnection> void requestConnection(Class<T> cls, Callback<Result<T, IOException>> callback);

    boolean supportsConnection(Class<? extends YubiKeyConnection> cls);
}
