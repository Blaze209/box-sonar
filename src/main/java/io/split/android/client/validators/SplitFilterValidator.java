package io.split.android.client.validators;

import io.split.android.client.FlagSetsFilter;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public interface SplitFilterValidator {
    ValidationResult cleanup(String method, List<String> values);

    boolean isValid(String value);

    Set<String> items(String method, List<String> values, FlagSetsFilter flagSetsFilter);

    public static class ValidationResult {
        private final int mInvalidValueCount;
        private final List<String> mValues;

        public ValidationResult(List<String> values, int invalidValueCount) {
            this.mValues = values;
            this.mInvalidValueCount = invalidValueCount;
        }

        public List<String> getValues() {
            return this.mValues;
        }

        public int getInvalidValueCount() {
            return this.mInvalidValueCount;
        }
    }
}
