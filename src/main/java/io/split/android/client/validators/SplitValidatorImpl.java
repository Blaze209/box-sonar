package io.split.android.client.validators;

import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class SplitValidatorImpl implements SplitValidator {
    @Override // io.split.android.client.validators.SplitValidator
    public ValidationErrorInfo validateName(String name) {
        if (name == null) {
            return new ValidationErrorInfo(200, "you passed a null feature flag name, flag name must be a non-empty string");
        }
        if (Utils.isNullOrEmpty(name.trim())) {
            return new ValidationErrorInfo(200, "you passed an empty feature flag name, flag name must be a non-empty string");
        }
        if (name.trim().length() != name.length()) {
            return new ValidationErrorInfo(100, "feature flag name '" + name + "' has extra whitespace, trimming", true);
        }
        return null;
    }

    @Override // io.split.android.client.validators.SplitValidator
    public String splitNotFoundMessage(String splitName) {
        return "split: you passed '" + splitName + "' that does not exist in this environment, please double check what feature flags exist in the Split user interface.";
    }
}
