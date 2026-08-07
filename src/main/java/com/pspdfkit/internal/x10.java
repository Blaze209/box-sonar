package com.pspdfkit.internal;

import com.pspdfkit.signatures.Signature;
import com.pspdfkit.signatures.listeners.OnSignaturePickedListener;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface x10 extends OnSignaturePickedListener {
    void onSignaturesDeleted(List<Signature> list);
}
