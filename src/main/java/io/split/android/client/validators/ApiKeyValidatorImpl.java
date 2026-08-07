package io.split.android.client.validators;

import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class ApiKeyValidatorImpl implements ApiKeyValidator {
    @Override // io.split.android.client.validators.ApiKeyValidator
    public ValidationErrorInfo validate(String sdkKey) {
        if (sdkKey == null) {
            return new ValidationErrorInfo(200, "you passed a null sdkKey, the sdkKey must be a non-empty string");
        }
        if (Utils.isNullOrEmpty(sdkKey.trim())) {
            return new ValidationErrorInfo(200, "you passed an empty sdkKey, sdkKey must be a non-empty string");
        }
        return null;
    }
}
