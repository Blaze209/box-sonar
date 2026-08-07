package io.split.android.client.validators;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ValidationErrorInfo {
    public static final int ERROR_SOME = 200;
    static final int MAX_WARNING_CODE = 102;
    static final int MIN_WARNING_CODE = 100;
    public static final int WARNING_SPLIT_NAME_SHOULD_BE_TRIMMED = 100;
    public static final int WARNING_TRAFFIC_TYPE_HAS_UPPERCASE_CHARS = 101;
    public static final int WARNING_TRAFFIC_TYPE_WITHOUT_SPLIT_IN_ENVIRONMENT = 102;
    private Integer mError;
    private String mErrorMessage;
    private Map<Integer, String> mWarnings;

    ValidationErrorInfo(int code, String message) {
        this(code, message, false);
    }

    ValidationErrorInfo(int code, String message, boolean isWarning) {
        this.mError = null;
        HashMap map = new HashMap();
        this.mWarnings = map;
        if (!isWarning) {
            this.mError = Integer.valueOf(code);
            this.mErrorMessage = message;
        } else {
            map.put(Integer.valueOf(code), message);
        }
    }

    public Integer getError() {
        return this.mError;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public Map<Integer, String> getWarnings() {
        return this.mWarnings;
    }

    public boolean isError() {
        return this.mError != null;
    }

    public void addWarning(int code, String message) {
        if (message != null) {
            this.mWarnings.put(Integer.valueOf(code), message);
        }
    }

    public boolean hasWarning(int code) {
        return this.mWarnings.get(Integer.valueOf(code)) != null;
    }
}
