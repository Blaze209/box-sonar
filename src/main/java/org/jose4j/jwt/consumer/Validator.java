package org.jose4j.jwt.consumer;

import org.jose4j.jwt.MalformedClaimException;

/* JADX INFO: loaded from: classes5.dex */
public interface Validator {
    String validate(JwtContext jwtContext) throws MalformedClaimException;
}
