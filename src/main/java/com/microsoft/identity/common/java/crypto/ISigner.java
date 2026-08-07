package com.microsoft.identity.common.java.crypto;

import com.microsoft.identity.common.java.exception.ClientException;
import java.security.PrivateKey;

/* JADX INFO: loaded from: classes14.dex */
public interface ISigner {
    byte[] sign(PrivateKey privateKey, String str, byte[] bArr) throws ClientException;
}
