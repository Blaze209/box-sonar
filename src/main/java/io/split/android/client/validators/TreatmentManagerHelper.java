package io.split.android.client.validators;

import io.split.android.client.SplitResult;
import io.split.android.grammar.Treatments;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
class TreatmentManagerHelper {
    TreatmentManagerHelper() {
    }

    static <T> Map<String, T> controlTreatmentsForSplitsWithConfig(SplitValidator splitValidator, ValidationMessageLogger validationLogger, List<String> splits, String validationTag, TreatmentManagerImpl.ResultTransformer<T> resultTransformer) {
        HashMap map = new HashMap();
        for (String str : splits) {
            if (!isInvalidSplit(splitValidator, validationTag, validationLogger, str)) {
                map.put(str.trim(), resultTransformer.transform(new SplitResult(Treatments.CONTROL)));
            }
        }
        return map;
    }

    private static boolean isInvalidSplit(SplitValidator validator, String validationTag, ValidationMessageLogger logger, String split) {
        ValidationErrorInfo validationErrorInfoValidateName;
        if (validator == null || (validationErrorInfoValidateName = validator.validateName(split)) == null) {
            return false;
        }
        if (validationErrorInfoValidateName.isError()) {
            if (logger == null) {
                return true;
            }
            logger.e(validationErrorInfoValidateName, validationTag);
            return true;
        }
        if (logger == null) {
            return false;
        }
        logger.w(validationErrorInfoValidateName, validationTag);
        return false;
    }
}
