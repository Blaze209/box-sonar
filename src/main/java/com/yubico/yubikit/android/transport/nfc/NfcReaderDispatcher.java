package com.yubico.yubikit.android.transport.nfc;

import android.app.Activity;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class NfcReaderDispatcher implements NfcDispatcher {
    private final NfcAdapter adapter;

    public NfcReaderDispatcher(NfcAdapter nfcAdapter) {
        this.adapter = nfcAdapter;
    }

    @Override // com.yubico.yubikit.android.transport.nfc.NfcDispatcher
    public void enable(Activity activity, NfcConfiguration nfcConfiguration, NfcDispatcher.OnTagHandler onTagHandler) {
        disableReaderMode(activity);
        enableReaderMode(activity, nfcConfiguration, onTagHandler);
    }

    @Override // com.yubico.yubikit.android.transport.nfc.NfcDispatcher
    public void disable(Activity activity) {
        disableReaderMode(activity);
    }

    private void enableReaderMode(Activity activity, NfcConfiguration nfcConfiguration, final NfcDispatcher.OnTagHandler onTagHandler) {
        Bundle bundle = new Bundle();
        bundle.putInt("presence", 50);
        int i = nfcConfiguration.isDisableNfcDiscoverySound() ? 259 : 3;
        if (nfcConfiguration.isSkipNdefCheck()) {
            i |= 128;
        }
        NfcAdapter nfcAdapter = this.adapter;
        Objects.requireNonNull(onTagHandler);
        nfcAdapter.enableReaderMode(activity, new NfcAdapter.ReaderCallback() { // from class: com.yubico.yubikit.android.transport.nfc.NfcReaderDispatcher$$ExternalSyntheticLambda0
            @Override // android.nfc.NfcAdapter.ReaderCallback
            public final void onTagDiscovered(Tag tag) {
                onTagHandler.onTag(tag);
            }
        }, i, bundle);
    }

    private void disableReaderMode(Activity activity) {
        this.adapter.disableReaderMode(activity);
    }
}
