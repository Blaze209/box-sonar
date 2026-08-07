package com.nimbusds.jose.crypto;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.crypto.impl.HMAC;
import com.nimbusds.jose.crypto.impl.MACProvider;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jose.shaded.jcip.ThreadSafe;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.StandardCharset;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes3.dex */
@ThreadSafe
public class MACSigner extends MACProvider implements JWSSigner {
    public MACSigner(byte[] bArr) throws KeyLengthException {
        super(bArr);
    }

    public MACSigner(String str) throws KeyLengthException {
        this(str.getBytes(StandardCharset.UTF_8));
    }

    public MACSigner(SecretKey secretKey) throws KeyLengthException {
        super(secretKey);
    }

    public MACSigner(OctetSequenceKey octetSequenceKey) throws KeyLengthException {
        this(octetSequenceKey.toByteArray());
    }

    @Override // com.nimbusds.jose.JWSSigner
    public Base64URL sign(JWSHeader jWSHeader, byte[] bArr) throws JOSEException {
        ensureSecretLengthSatisfiesAlgorithm(jWSHeader.getAlgorithm());
        return Base64URL.encode(HMAC.compute(getJCAAlgorithmName(jWSHeader.getAlgorithm()), getSecretKey(), bArr, getJCAContext().getProvider()));
    }
}
