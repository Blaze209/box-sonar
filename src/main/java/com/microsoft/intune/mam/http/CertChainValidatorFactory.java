package com.microsoft.intune.mam.http;

import com.microsoft.intune.mam.client.identity.MAMIdentity;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public interface CertChainValidatorFactory {
    CertChainValidator getValidator(MAMIdentity mAMIdentity, URL url);

    @Deprecated
    CertChainValidator getValidator(String str, URL url);
}
