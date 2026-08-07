package io.split.android.client.service.workmanager.splits;

import io.split.android.client.SplitFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class SplitsSyncWorkerFilterBuilder {
    SplitsSyncWorkerFilterBuilder() {
    }

    static SplitFilter buildFilter(String filterType, String[] filterValues) {
        if (filterType == null) {
            return null;
        }
        List arrayList = new ArrayList();
        if (filterValues != null) {
            arrayList = Arrays.asList(filterValues);
        }
        if (SplitFilter.Type.BY_NAME.queryStringField().equals(filterType)) {
            return SplitFilter.byName(arrayList);
        }
        if (SplitFilter.Type.BY_SET.queryStringField().equals(filterType)) {
            return SplitFilter.bySet(arrayList);
        }
        return null;
    }
}
