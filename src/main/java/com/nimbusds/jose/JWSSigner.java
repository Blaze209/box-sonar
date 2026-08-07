package com.nimbusds.jose;

import com.nimbusds.jose.util.Base64URL;

/* JADX INFO: loaded from: classes3.dex */
public interface JWSSigner extends JWSProvider {
    Base64URL sign(JWSHeader jWSHeader, byte[] bArr) throws JOSEException;
}
