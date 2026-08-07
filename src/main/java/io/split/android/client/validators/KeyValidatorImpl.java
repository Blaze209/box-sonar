package io.split.android.client.validators;

import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class KeyValidatorImpl implements KeyValidator {
    private final int MAX_MATCHING_KEY_LENGTH = ValidationConfig.getInstance().getMaximumKeyLength();
    private final int MAX_BUCKETING_KEY_LENGTH = ValidationConfig.getInstance().getMaximumKeyLength();

    @Override // io.split.android.client.validators.KeyValidator
    public ValidationErrorInfo validate(String matchingKey, String bucketingKey) {
        if (matchingKey == null) {
            return new ValidationErrorInfo(200, "you passed a null key, matching key must be a non-empty string");
        }
        if (Utils.isNullOrEmpty(matchingKey.trim())) {
            return new ValidationErrorInfo(200, "you passed an empty string, matching key must be a non-empty string");
        }
        if (matchingKey.length() > this.MAX_MATCHING_KEY_LENGTH) {
            return new ValidationErrorInfo(200, "matching key too long - must be " + this.MAX_MATCHING_KEY_LENGTH + " characters or less");
        }
        if (bucketingKey == null) {
            return null;
        }
        if (Utils.isNullOrEmpty(bucketingKey.trim())) {
            return new ValidationErrorInfo(200, "you passed an empty string, bucketing key must be null or a non-empty string");
        }
        if (bucketingKey.length() > this.MAX_BUCKETING_KEY_LENGTH) {
            return new ValidationErrorInfo(200, "bucketing key too long - must be " + this.MAX_MATCHING_KEY_LENGTH + " characters or less");
        }
        return null;
    }
}
