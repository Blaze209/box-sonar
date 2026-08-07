package org.jose4j.jwt.consumer;

import org.jose4j.jwt.MalformedClaimException;

/* JADX INFO: loaded from: classes5.dex */
public class ErrorCodeValidatorAdapter implements ErrorCodeValidator {
    private Validator validator;

    public ErrorCodeValidatorAdapter(Validator validator) {
        this.validator = validator;
    }

    @Override // org.jose4j.jwt.consumer.ErrorCodeValidator
    public ErrorCodeValidator.Error validate(JwtContext jwtContext) throws MalformedClaimException {
        String strValidate = this.validator.validate(jwtContext);
        if (strValidate == null) {
            return null;
        }
        return new ErrorCodeValidator.Error(17, strValidate);
    }
}
