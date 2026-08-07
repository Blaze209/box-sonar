package io.split.android.client.service.workmanager.splits;

import io.split.android.client.FlagSetsFilterImpl;
import io.split.android.client.SplitFilter;
import io.split.android.client.service.splits.SplitChangeProcessor;

/* JADX INFO: loaded from: classes4.dex */
class SplitChangeProcessorProvider {
    SplitChangeProcessorProvider() {
    }

    SplitChangeProcessor provideSplitChangeProcessor(String filterType, String[] filterValues) {
        SplitFilter splitFilterBuildFilter = SplitsSyncWorkerFilterBuilder.buildFilter(filterType, filterValues);
        return new SplitChangeProcessor(splitFilterBuildFilter, (splitFilterBuildFilter == null || splitFilterBuildFilter.getType() != SplitFilter.Type.BY_SET) ? null : new FlagSetsFilterImpl(splitFilterBuildFilter.getValues()));
    }
}
