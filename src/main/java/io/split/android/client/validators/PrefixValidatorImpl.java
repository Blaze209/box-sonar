package io.split.android.client.validators;

/* JADX INFO: loaded from: classes4.dex */
public class PrefixValidatorImpl implements PrefixValidator {
    private static final String PREFIX_REGEX = "^[a-zA-Z0-9_]{1,80}$";

    @Override // io.split.android.client.validators.PrefixValidator
    public ValidationErrorInfo validate(String prefix) {
        if (prefix == null) {
            return new ValidationErrorInfo(200, "You passed a null prefix, prefix must be a non-empty string");
        }
        if (prefix.trim().isEmpty()) {
            return new ValidationErrorInfo(200, "You passed an empty prefix, prefix must be a non-empty string");
        }
        if (prefix.trim().matches(PREFIX_REGEX)) {
            return null;
        }
        return new ValidationErrorInfo(200, "Prefix can only contain alphanumeric characters and underscore, and must be 80 characters or less");
    }
}
