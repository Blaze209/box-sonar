package com.pspdfkit.internal;

import com.pspdfkit.signatures.Signature;
import com.pspdfkit.ui.signatures.SignatureUiData;

/* JADX INFO: loaded from: classes3.dex */
public interface sf {
    void onSignatureCreated(Signature signature, boolean z);

    void onSignatureUiDataCollected(Signature signature, SignatureUiData signatureUiData);
}
