package io.split.android.client;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.microsoft.identity.client.internal.MsalUtils;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes4.dex */
public class FilterBuilder {
    private final FilterGrouper mFilterGrouper;
    private final List<SplitFilter> mFilters;

    public FilterBuilder(List<SplitFilter> filters) {
        this(new FilterGrouper(), filters);
    }

    FilterBuilder(FilterGrouper filterGrouper, List<SplitFilter> filters) {
        this.mFilters = new ArrayList();
        this.mFilterGrouper = (FilterGrouper) Utils.checkNotNull(filterGrouper);
        addFilters(filters);
    }

    public String buildQueryString() {
        if (this.mFilters.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (SplitFilter splitFilter : getGroupedFilter().values()) {
            SplitFilter.Type type = splitFilter.getType();
            TreeSet treeSet = new TreeSet(splitFilter.getValues());
            if (treeSet.size() < splitFilter.getValues().size()) {
                Logger.w("Warning: Some duplicated values for " + type.toString() + " filter  were removed.");
            }
            if (treeSet.size() != 0) {
                validateFilterSize(type, treeSet.size());
                sb.append(MsalUtils.QUERY_STRING_DELIMITER);
                sb.append(type.queryStringField());
                sb.append(SimpleComparison.EQUAL_TO_OPERATION);
                sb.append(String.join(",", treeSet));
            }
        }
        return sb.toString();
    }

    public Map<SplitFilter.Type, SplitFilter> getGroupedFilter() {
        TreeMap treeMap = new TreeMap(new SplitFilterTypeComparator());
        treeMap.putAll(this.mFilterGrouper.group(this.mFilters));
        return treeMap;
    }

    private void addFilters(List<SplitFilter> filters) {
        if (filters == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        boolean z = false;
        for (SplitFilter splitFilter : filters) {
            if (splitFilter != null) {
                hashSet.add(splitFilter.getType());
                if (splitFilter.getType() == SplitFilter.Type.BY_SET) {
                    if (!z) {
                        this.mFilters.clear();
                        z = true;
                    }
                    this.mFilters.add(splitFilter);
                }
                if (!z) {
                    this.mFilters.add(splitFilter);
                }
            }
        }
        if (!hashSet.contains(SplitFilter.Type.BY_SET) || hashSet.size() <= 1) {
            return;
        }
        Logger.e("SDK Config: The Set filter is exclusive and cannot be used simultaneously with names or prefix filters. Ignoring names and prefixes");
    }

    private void validateFilterSize(SplitFilter.Type type, int size) {
        if (size > type.maxValuesCount()) {
            throw new IllegalArgumentException("Error: " + type.maxValuesCount() + " different feature flag " + type.queryStringField() + " can be specified at most. You passed " + size + ". Please consider reducing the amount or using prefixes to target specific groups of feature flags.");
        }
    }

    private static class SplitFilterTypeComparator implements Comparator<SplitFilter.Type> {
        private SplitFilterTypeComparator() {
        }

        @Override // java.util.Comparator
        public int compare(SplitFilter.Type o1, SplitFilter.Type o2) {
            return o1.compareTo(o2);
        }
    }
}
