package io.split.android.client.validators;

import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class ValidationMessageLoggerImpl implements ValidationMessageLogger {
    @Override // io.split.android.client.validators.ValidationMessageLogger
    public void log(ValidationErrorInfo errorInfo, String tag) {
        if (errorInfo.isError() && errorInfo.getErrorMessage() != null) {
            e(errorInfo, tag);
        } else {
            w(errorInfo, tag);
        }
    }

    @Override // io.split.android.client.validators.ValidationMessageLogger
    public void e(ValidationErrorInfo errorInfo, String tag) {
        e(tag, errorInfo.getErrorMessage());
    }

    @Override // io.split.android.client.validators.ValidationMessageLogger
    public void w(ValidationErrorInfo errorInfo, String tag) {
        Iterator it = new ArrayList(errorInfo.getWarnings().values()).iterator();
        while (it.hasNext()) {
            w(tag, (String) it.next());
        }
    }

    @Override // io.split.android.client.validators.ValidationMessageLogger
    public void e(String message, String tag) {
        logError(message, tag);
    }

    @Override // io.split.android.client.validators.ValidationMessageLogger
    public void w(String message, String tag) {
        logWarning(message, tag);
    }

    private void logError(String message, String tag) {
        Logger.e(sanitizeTag(tag) + ": " + message);
    }

    private void logWarning(String message, String tag) {
        Logger.w(sanitizeTag(tag) + ": " + message);
    }

    private String sanitizeTag(String tag) {
        return tag != null ? tag : "";
    }
}
