package org.jose4j.jwt.consumer;

import org.jose4j.jwt.MalformedClaimException;

/* JADX INFO: loaded from: classes5.dex */
public class JtiValidator implements ErrorCodeValidator {
    private static final ErrorCodeValidator.Error MISSING_JTI = new ErrorCodeValidator.Error(13, "The JWT ID (jti) claim is not present.");
    private boolean requireJti;

    public JtiValidator(boolean z) {
        this.requireJti = z;
    }

    @Override // org.jose4j.jwt.consumer.ErrorCodeValidator
    public ErrorCodeValidator.Error validate(JwtContext jwtContext) throws MalformedClaimException {
        if (jwtContext.getJwtClaims().getJwtId() == null && this.requireJti) {
            return MISSING_JTI;
        }
        return null;
    }
}
