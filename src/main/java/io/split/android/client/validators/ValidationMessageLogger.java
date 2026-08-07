package io.split.android.client.validators;

/* JADX INFO: loaded from: classes4.dex */
public interface ValidationMessageLogger {
    void e(ValidationErrorInfo errorInfo, String tag);

    void e(String message, String tag);

    void log(ValidationErrorInfo errorInfo, String tag);

    void w(ValidationErrorInfo errorInfo, String tag);

    void w(String message, String tag);
}
