package com.microsoft.identity.common.migration;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
class MigrationOperationResult implements IMigrationOperationResult {
    private int mCountOfFailedRecords;
    private int mCountOfTotalRecords;
    private Map<String, Integer> mFailures = new HashMap();

    MigrationOperationResult() {
    }

    @Override // com.microsoft.identity.common.migration.IMigrationOperationResult
    public int getCountOfTotalRecords() {
        return this.mCountOfTotalRecords;
    }

    public void setCountOfTotalRecords(int i) {
        this.mCountOfTotalRecords = i;
    }

    @Override // com.microsoft.identity.common.migration.IMigrationOperationResult
    public int getCountOfFailedRecords() {
        return this.mCountOfFailedRecords;
    }

    @Override // com.microsoft.identity.common.migration.IMigrationOperationResult
    public Map<String, Integer> getFailures() {
        return this.mFailures;
    }

    void addFailure(Exception exc) {
        String strCreateExceptionKey = createExceptionKey(exc);
        Integer num = this.mFailures.get(strCreateExceptionKey);
        if (num == null) {
            this.mFailures.put(strCreateExceptionKey, 1);
        } else {
            this.mFailures.put(strCreateExceptionKey, Integer.valueOf(num.intValue() + 1));
        }
        this.mCountOfFailedRecords++;
    }

    private static String createExceptionKey(Exception exc) {
        return exc.getClass().getSimpleName() + "::" + exc.getMessage();
    }
}
