package com.nimbusds.jose.proc;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEDecrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWEProvider;
import java.security.Key;

/* JADX INFO: loaded from: classes3.dex */
public interface JWEDecrypterFactory extends JWEProvider {
    JWEDecrypter createJWEDecrypter(JWEHeader jWEHeader, Key key) throws JOSEException;
}
