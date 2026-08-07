package io.split.android.client.validators;

import java.util.Collection;

/* JADX INFO: loaded from: classes4.dex */
public class AttributesValidatorImpl implements AttributesValidator {
    @Override // io.split.android.client.validators.AttributesValidator
    public boolean isValid(Object attribute) {
        return (attribute instanceof String) || (attribute instanceof Boolean) || (attribute instanceof Integer) || (attribute instanceof Long) || (attribute instanceof Float) || (attribute instanceof Double) || (attribute instanceof Collection);
    }
}
