package io.split.android.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
class FilterGrouper {
    FilterGrouper() {
    }

    Map<SplitFilter.Type, SplitFilter> group(List<SplitFilter> filters) {
        HashMap map = new HashMap();
        for (SplitFilter splitFilter : filters) {
            List arrayList = (List) map.get(splitFilter.getType());
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(splitFilter.getType(), arrayList);
            }
            arrayList.addAll(splitFilter.getValues());
        }
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (((List) entry.getValue()).size() > 0) {
                map2.put((SplitFilter.Type) entry.getKey(), new SplitFilter((SplitFilter.Type) entry.getKey(), (List) entry.getValue()));
            }
        }
        return map2;
    }
}
