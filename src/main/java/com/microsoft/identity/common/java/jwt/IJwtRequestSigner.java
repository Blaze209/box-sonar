package com.microsoft.identity.common.java.jwt;

import com.microsoft.identity.common.java.authorities.Authority;
import com.microsoft.identity.common.java.exception.ClientException;
import java.security.cert.CertificateEncodingException;

/* JADX INFO: loaded from: classes14.dex */
public interface IJwtRequestSigner {
    String getSignedJwt(JwtRequestBody jwtRequestBody, Authority authority) throws ClientException, CertificateEncodingException;
}
