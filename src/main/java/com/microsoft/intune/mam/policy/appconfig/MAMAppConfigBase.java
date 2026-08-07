package com.microsoft.intune.mam.policy.appconfig;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMAppConfigBase {
    List<Boolean> getAllBooleansForKey(String str);

    List<Double> getAllDoublesForKey(String str);

    List<Long> getAllIntegersForKey(String str);

    List<String> getAllStringsForKey(String str);

    List<Map<String, String>> getFullData();

    boolean hasConflict(String str);
}
