package com.yubico.yubikit.android.ui;

import android.content.Intent;
import android.os.Bundle;
import com.yubico.yubikit.core.YubiKeyDevice;
import com.yubico.yubikit.core.application.CommandState;
import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Pair;

/* JADX INFO: loaded from: classes3.dex */
public abstract class YubiKeyPromptAction {
    public static final Pair<Integer, Intent> CONTINUE = new Pair<>(101, new Intent());
    public static final int RESULT_CONTINUE = 101;

    abstract void onYubiKey(YubiKeyDevice yubiKeyDevice, Bundle bundle, CommandState commandState, Callback<Pair<Integer, Intent>> callback);
}
