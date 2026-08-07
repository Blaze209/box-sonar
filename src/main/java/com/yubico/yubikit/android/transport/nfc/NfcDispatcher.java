package com.yubico.yubikit.android.transport.nfc;

import android.app.Activity;
import android.nfc.Tag;

/* JADX INFO: loaded from: classes3.dex */
public interface NfcDispatcher {

    public interface OnTagHandler {
        void onTag(Tag tag);
    }

    void disable(Activity activity);

    void enable(Activity activity, NfcConfiguration nfcConfiguration, OnTagHandler onTagHandler);
}
