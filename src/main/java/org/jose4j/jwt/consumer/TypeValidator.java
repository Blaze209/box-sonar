package org.jose4j.jwt.consumer;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;
import org.jose4j.lang.UncheckedJoseException;

/* JADX INFO: loaded from: classes5.dex */
public class TypeValidator implements ErrorCodeValidator {
    private static final String APPLICATION_PRIMARY_TYPE = "application";
    private MimeType expectedType;
    private boolean requireType;

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.activation.MimeTypeParseException */
    public TypeValidator(boolean z, String str) {
        try {
            MimeType mediaType = toMediaType(str);
            this.expectedType = mediaType;
            if (mediaType.getSubType().equals("*")) {
                throw new MimeTypeParseException("cannot use wildcard in subtype");
            }
            this.requireType = z;
        } catch (MimeTypeParseException e) {
            throw new UncheckedJoseException("The given expected type '" + str + "' isn't a valid media type in this context.", e);
        }
    }

    @Override // org.jose4j.jwt.consumer.ErrorCodeValidator
    public ErrorCodeValidator.Error validate(JwtContext jwtContext) {
        return validate(jwtContext.getJoseObjects().get(0).getHeader("typ"));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.activation.MimeTypeParseException */
    ErrorCodeValidator.Error validate(String str) {
        if (str == null) {
            if (this.requireType) {
                return new ErrorCodeValidator.Error(21, "No typ header parameter present in the innermost JWS/JWE");
            }
            return null;
        }
        if (this.expectedType != null) {
            try {
                MimeType mediaType = toMediaType(str);
                if (!this.expectedType.match(mediaType) || mediaType.getSubType().equals("*")) {
                    StringBuilder sb = new StringBuilder("Invalid typ header parameter value '");
                    sb.append(str).append("'. Expecting '");
                    sb.append(this.expectedType).append("'");
                    if (this.expectedType.getPrimaryType().equals("application")) {
                        sb.append(" or just '").append(this.expectedType.getSubType()).append("'");
                    }
                    sb.append(".");
                    return new ErrorCodeValidator.Error(22, sb.toString());
                }
            } catch (MimeTypeParseException e) {
                return new ErrorCodeValidator.Error(22, "typ header parameter value '" + str + "' not parsable as a media type " + e);
            }
        }
        return null;
    }

    MimeType toMediaType(String str) throws MimeTypeParseException {
        return str.contains("/") ? new MimeType(str) : new MimeType("application", str);
    }
}
