package com.yubico.yubikit.android.transport.nfc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import com.yubico.yubikit.core.util.Callback;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class NfcYubiKeyManager {
    public static final String NFC_SETTINGS_ACTION = "android.settings.NFC_SETTINGS";
    private final NfcAdapter adapter;
    private final Context context;
    private final NfcDispatcher dispatcher;

    @Nullable
    private ExecutorService executorService = null;

    public NfcYubiKeyManager(Context context, @Nullable NfcDispatcher nfcDispatcher) throws NfcNotAvailable {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(context);
        this.adapter = defaultAdapter;
        if (defaultAdapter == null) {
            throw new NfcNotAvailable("NFC unavailable on this device", false);
        }
        this.dispatcher = nfcDispatcher == null ? new NfcReaderDispatcher(defaultAdapter) : nfcDispatcher;
        this.context = context;
    }

    public void enable(Activity activity, final NfcConfiguration nfcConfiguration, final Callback<? super NfcYubiKeyDevice> callback) throws NfcNotAvailable {
        if (checkAvailability(nfcConfiguration.isHandleUnavailableNfc())) {
            final ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
            this.dispatcher.enable(activity, nfcConfiguration, new NfcDispatcher.OnTagHandler() { // from class: com.yubico.yubikit.android.transport.nfc.NfcYubiKeyManager$$ExternalSyntheticLambda0
                @Override // com.yubico.yubikit.android.transport.nfc.NfcDispatcher.OnTagHandler
                public final void onTag(Tag tag) {
                    callback.invoke(new NfcYubiKeyDevice(tag, nfcConfiguration.getTimeout(), executorServiceNewSingleThreadExecutor));
                }
            });
            this.executorService = executorServiceNewSingleThreadExecutor;
        }
    }

    public void disable(Activity activity) {
        ExecutorService executorService = this.executorService;
        if (executorService != null) {
            executorService.shutdown();
            this.executorService = null;
        }
        this.dispatcher.disable(activity);
    }

    private boolean checkAvailability(boolean z) throws NfcNotAvailable {
        if (this.adapter.isEnabled()) {
            return true;
        }
        if (z) {
            this.context.startActivity(new Intent(NFC_SETTINGS_ACTION));
            return false;
        }
        throw new NfcNotAvailable("Please activate NFC_TRANSPORT", true);
    }
}
