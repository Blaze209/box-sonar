package com.nimbusds.jose.crypto;

import com.nimbusds.jose.CriticalHeaderParamsAware;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.impl.CriticalHeaderParamsDeferral;
import com.nimbusds.jose.crypto.impl.HMAC;
import com.nimbusds.jose.crypto.impl.MACProvider;
import com.nimbusds.jose.crypto.utils.ConstantTimeUtils;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jose.shaded.jcip.ThreadSafe;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.StandardCharset;
import java.util.Set;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes3.dex */
@ThreadSafe
public class MACVerifier extends MACProvider implements JWSVerifier, CriticalHeaderParamsAware {
    private final CriticalHeaderParamsDeferral critPolicy;

    public MACVerifier(byte[] bArr) throws JOSEException {
        super(bArr);
        this.critPolicy = new CriticalHeaderParamsDeferral();
    }

    public MACVerifier(String str) throws JOSEException {
        this(str.getBytes(StandardCharset.UTF_8));
    }

    public MACVerifier(SecretKey secretKey) throws JOSEException {
        this(secretKey, (Set<String>) null);
    }

    public MACVerifier(OctetSequenceKey octetSequenceKey) throws JOSEException {
        this(octetSequenceKey.toByteArray());
    }

    public MACVerifier(byte[] bArr, Set<String> set) throws JOSEException {
        super(bArr);
        CriticalHeaderParamsDeferral criticalHeaderParamsDeferral = new CriticalHeaderParamsDeferral();
        this.critPolicy = criticalHeaderParamsDeferral;
        criticalHeaderParamsDeferral.setDeferredCriticalHeaderParams(set);
    }

    public MACVerifier(SecretKey secretKey, Set<String> set) throws JOSEException {
        super(secretKey);
        CriticalHeaderParamsDeferral criticalHeaderParamsDeferral = new CriticalHeaderParamsDeferral();
        this.critPolicy = criticalHeaderParamsDeferral;
        criticalHeaderParamsDeferral.setDeferredCriticalHeaderParams(set);
    }

    public MACVerifier(OctetSequenceKey octetSequenceKey, Set<String> set) throws JOSEException {
        this(octetSequenceKey.toByteArray(), set);
    }

    @Override // com.nimbusds.jose.CriticalHeaderParamsAware
    public Set<String> getProcessedCriticalHeaderParams() {
        return this.critPolicy.getProcessedCriticalHeaderParams();
    }

    @Override // com.nimbusds.jose.CriticalHeaderParamsAware
    public Set<String> getDeferredCriticalHeaderParams() {
        return this.critPolicy.getProcessedCriticalHeaderParams();
    }

    @Override // com.nimbusds.jose.JWSVerifier
    public boolean verify(JWSHeader jWSHeader, byte[] bArr, Base64URL base64URL) throws JOSEException {
        ensureSecretLengthSatisfiesAlgorithm(jWSHeader.getAlgorithm());
        if (this.critPolicy.headerPasses(jWSHeader)) {
            return ConstantTimeUtils.areEqual(HMAC.compute(getJCAAlgorithmName(jWSHeader.getAlgorithm()), getSecretKey(), bArr, getJCAContext().getProvider()), base64URL.decode());
        }
        return false;
    }
}
