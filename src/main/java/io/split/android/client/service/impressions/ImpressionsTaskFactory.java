package io.split.android.client.service.impressions;

import io.split.android.client.service.impressions.unique.SaveUniqueImpressionsTask;
import io.split.android.client.service.impressions.unique.UniqueKeysRecorderTask;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public interface ImpressionsTaskFactory {
    ImpressionsCountRecorderTask createImpressionsCountRecorderTask();

    ImpressionsRecorderTask createImpressionsRecorderTask();

    SaveImpressionsCountTask createSaveImpressionsCountTask(List<ImpressionsCountPerFeature> count);

    SaveUniqueImpressionsTask createSaveUniqueImpressionsTask(Map<String, Set<String>> uniqueImpressions);

    UniqueKeysRecorderTask createUniqueImpressionsRecorderTask();
}
