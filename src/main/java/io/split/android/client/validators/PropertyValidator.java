package io.split.android.client.validators;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface PropertyValidator {
    Result validate(Map<String, Object> properties, String validationTag);

    public static class Result {
        private final String mErrorMessage;
        private final boolean mIsValid;
        private final int mSizeInBytes;
        private final Map<String, Object> mValidatedProperties;

        private Result(boolean isValid, Map<String, Object> properties, int sizeInBytes, String errorMessage) {
            this.mIsValid = isValid;
            this.mValidatedProperties = properties;
            this.mSizeInBytes = sizeInBytes;
            this.mErrorMessage = errorMessage;
        }

        public boolean isValid() {
            return this.mIsValid;
        }

        public Map<String, Object> getProperties() {
            return this.mValidatedProperties;
        }

        public int getSizeInBytes() {
            return this.mSizeInBytes;
        }

        public String getErrorMessage() {
            return this.mErrorMessage;
        }

        public static Result valid(Map<String, Object> properties, int sizeInBytes) {
            return new Result(true, properties, sizeInBytes, null);
        }

        public static Result invalid(String errorMessage, int sizeInBytes) {
            return new Result(false, null, sizeInBytes, errorMessage);
        }
    }
}
