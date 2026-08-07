package com.microsoft.identity.common.migration;

import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public interface IMigrationOperationResult {
    int getCountOfFailedRecords();

    int getCountOfTotalRecords();

    Map<String, Integer> getFailures();
}
