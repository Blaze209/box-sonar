package com.pspdfkit.signatures.storage;

import com.pspdfkit.signatures.Signature;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface SignatureStorage {
    void addSignature(Signature signature) throws Exception;

    void addSignatures(List<Signature> list) throws Exception;

    void clear() throws Exception;

    List<Signature> getSignatures() throws Exception;

    void removeSignature(Signature signature) throws Exception;

    void removeSignatures(List<Signature> list) throws Exception;
}
