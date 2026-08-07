package org.jose4j.jwt.consumer;

import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.NumericDate;
import org.jose4j.lang.Maths;

/* JADX INFO: loaded from: classes5.dex */
public class NumericDateValidator implements ErrorCodeValidator {
    private static final ErrorCodeValidator.Error MISSING_EXP = new ErrorCodeValidator.Error(2, "No Expiration Time (exp) claim present.");
    private static final ErrorCodeValidator.Error MISSING_IAT = new ErrorCodeValidator.Error(3, "No Issued At (iat) claim present.");
    private static final ErrorCodeValidator.Error MISSING_NBF = new ErrorCodeValidator.Error(4, "No Not Before (nbf) claim present.");
    private Integer iatAllowedSecondsInTheFuture;
    private Integer iatAllowedSecondsInThePast;
    private boolean requireExp;
    private boolean requireIat;
    private boolean requireNbf;
    private NumericDate staticEvaluationTime;
    private int allowedClockSkewSeconds = 0;
    private int maxFutureValidityInMinutes = 0;

    public void setRequireExp(boolean z) {
        this.requireExp = z;
    }

    public void setRequireIat(boolean z) {
        this.requireIat = z;
    }

    public void setRequireNbf(boolean z) {
        this.requireNbf = z;
    }

    public void setEvaluationTime(NumericDate numericDate) {
        this.staticEvaluationTime = numericDate;
    }

    public void setAllowedClockSkewSeconds(int i) {
        this.allowedClockSkewSeconds = i;
    }

    public void setMaxFutureValidityInMinutes(int i) {
        this.maxFutureValidityInMinutes = i;
    }

    public void setIatAllowedSecondsInTheFuture(int i) {
        this.iatAllowedSecondsInTheFuture = Integer.valueOf(i);
    }

    public void setIatAllowedSecondsInThePast(int i) {
        this.iatAllowedSecondsInThePast = Integer.valueOf(i);
    }

    @Override // org.jose4j.jwt.consumer.ErrorCodeValidator
    public ErrorCodeValidator.Error validate(JwtContext jwtContext) throws MalformedClaimException {
        JwtClaims jwtClaims = jwtContext.getJwtClaims();
        NumericDate expirationTime = jwtClaims.getExpirationTime();
        NumericDate issuedAt = jwtClaims.getIssuedAt();
        NumericDate notBefore = jwtClaims.getNotBefore();
        if (this.requireExp && expirationTime == null) {
            return MISSING_EXP;
        }
        if (this.requireIat && issuedAt == null) {
            return MISSING_IAT;
        }
        if (this.requireNbf && notBefore == null) {
            return MISSING_NBF;
        }
        NumericDate numericDateNow = this.staticEvaluationTime;
        if (numericDateNow == null) {
            numericDateNow = NumericDate.now();
        }
        if (expirationTime != null) {
            if (Maths.subtract(numericDateNow.getValue(), this.allowedClockSkewSeconds) >= expirationTime.getValue()) {
                return new ErrorCodeValidator.Error(1, "The JWT is no longer valid - the evaluation time " + numericDateNow + " is on or after the Expiration Time (exp=" + expirationTime + ") claim value" + skewMessage());
            }
            if (issuedAt != null && expirationTime.isBefore(issuedAt)) {
                return new ErrorCodeValidator.Error(17, "The Expiration Time (exp=" + expirationTime + ") claim value cannot be before the Issued At (iat=" + issuedAt + ") claim value.");
            }
            if (notBefore != null && expirationTime.isBefore(notBefore)) {
                return new ErrorCodeValidator.Error(17, "The Expiration Time (exp=" + expirationTime + ") claim value cannot be before the Not Before (nbf=" + notBefore + ") claim value.");
            }
            if (this.maxFutureValidityInMinutes > 0 && Maths.subtract(Maths.subtract(expirationTime.getValue(), this.allowedClockSkewSeconds), numericDateNow.getValue()) > ((long) this.maxFutureValidityInMinutes) * 60) {
                return new ErrorCodeValidator.Error(5, "The Expiration Time (exp=" + expirationTime + ") claim value cannot be more than " + this.maxFutureValidityInMinutes + " minutes in the future relative to the evaluation time " + numericDateNow + skewMessage());
            }
        }
        if (notBefore != null && Maths.add(numericDateNow.getValue(), this.allowedClockSkewSeconds) < notBefore.getValue()) {
            return new ErrorCodeValidator.Error(6, "The JWT is not yet valid as the evaluation time " + numericDateNow + " is before the Not Before (nbf=" + notBefore + ") claim time" + skewMessage());
        }
        if (issuedAt == null) {
            return null;
        }
        if (this.iatAllowedSecondsInTheFuture != null && Maths.subtract(Maths.subtract(issuedAt.getValue(), numericDateNow.getValue()), this.allowedClockSkewSeconds) > this.iatAllowedSecondsInTheFuture.intValue()) {
            return new ErrorCodeValidator.Error(23, "iat " + issuedAt + " is more than " + this.iatAllowedSecondsInTheFuture + " second(s) ahead of now " + numericDateNow + skewMessage());
        }
        if (this.iatAllowedSecondsInThePast == null || Maths.subtract(Maths.subtract(numericDateNow.getValue(), issuedAt.getValue()), this.allowedClockSkewSeconds) <= this.iatAllowedSecondsInThePast.intValue()) {
            return null;
        }
        return new ErrorCodeValidator.Error(24, "As of now " + numericDateNow + " iat " + issuedAt + " is more than " + this.iatAllowedSecondsInThePast + " second(s) in the past" + skewMessage());
    }

    private String skewMessage() {
        if (this.allowedClockSkewSeconds > 0) {
            return " (even when providing " + this.allowedClockSkewSeconds + " seconds of leeway to account for clock skew).";
        }
        return ".";
    }
}
