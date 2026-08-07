package io.split.android.client.validators;

/* JADX INFO: loaded from: classes4.dex */
public interface SplitValidator {
    String splitNotFoundMessage(String splitName);

    ValidationErrorInfo validateName(String name);
}
