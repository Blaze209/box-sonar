package com.yubico.yubikit.android.ui;

import android.content.Intent;
import android.os.Bundle;
import com.yubico.yubikit.core.YubiKeyConnection;
import com.yubico.yubikit.core.YubiKeyDevice;
import com.yubico.yubikit.core.application.CommandState;
import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Pair;
import com.yubico.yubikit.core.util.Result;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes3.dex */
public abstract class YubiKeyPromptConnectionAction<T extends YubiKeyConnection> extends YubiKeyPromptAction {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) YubiKeyPromptConnectionAction.class);
    final Class<T> connectionType;

    protected abstract Pair<Integer, Intent> onYubiKeyConnection(T t, Bundle bundle, CommandState commandState);

    protected YubiKeyPromptConnectionAction(Class<T> cls) {
        this.connectionType = cls;
    }

    @Override // com.yubico.yubikit.android.ui.YubiKeyPromptAction
    final void onYubiKey(YubiKeyDevice yubiKeyDevice, final Bundle bundle, final CommandState commandState, final Callback<Pair<Integer, Intent>> callback) {
        if (yubiKeyDevice.supportsConnection(this.connectionType)) {
            yubiKeyDevice.requestConnection(this.connectionType, new Callback() { // from class: com.yubico.yubikit.android.ui.YubiKeyPromptConnectionAction$$ExternalSyntheticLambda0
                @Override // com.yubico.yubikit.core.util.Callback
                public final void invoke(Object obj) {
                    this.f$0.m14419x4cdcea6d(callback, bundle, commandState, (Result) obj);
                }
            });
        } else {
            com.yubico.yubikit.core.internal.Logger.debug(logger, "Connected YubiKey does not support desired connection type");
            callback.invoke(CONTINUE);
        }
    }

    /* JADX INFO: renamed from: lambda$onYubiKey$0$com-yubico-yubikit-android-ui-YubiKeyPromptConnectionAction, reason: not valid java name */
    /* synthetic */ void m14419x4cdcea6d(Callback callback, Bundle bundle, CommandState commandState, Result result) {
        try {
            callback.invoke(onYubiKeyConnection((YubiKeyConnection) result.getValue(), bundle, commandState));
        } catch (IOException e) {
            onError(e);
        }
    }

    protected void onError(Exception exc) {
        com.yubico.yubikit.core.internal.Logger.error(logger, "Error connecting to YubiKey", exc);
    }
}
