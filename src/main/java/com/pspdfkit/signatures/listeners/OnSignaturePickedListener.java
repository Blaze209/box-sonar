package com.pspdfkit.signatures.listeners;

import com.pspdfkit.signatures.Signature;
import com.pspdfkit.ui.signatures.SignatureUiData;

/* JADX INFO: loaded from: classes3.dex */
public interface OnSignaturePickedListener {
    void onDismiss();

    default void onSignatureCreated(Signature signature, boolean z) {
    }

    void onSignaturePicked(Signature signature);

    default void onSignatureUiDataCollected(Signature signature, SignatureUiData signatureUiData) {
    }
}
