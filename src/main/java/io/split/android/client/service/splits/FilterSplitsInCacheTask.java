package io.split.android.client.service.splits;

import io.split.android.client.SplitFilter;
import io.split.android.client.dtos.Split;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.splits.PersistentSplitsStorage;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class FilterSplitsInCacheTask implements SplitTask {
    private static final String PREFIX_SEPARATOR = "__";
    private final List<SplitFilter> mSplitsFilter;
    private final String mSplitsFilterQueryStringFromConfig;
    private final PersistentSplitsStorage mSplitsStorage;

    public FilterSplitsInCacheTask(PersistentSplitsStorage splitsStorage, List<SplitFilter> splitsFilter, String splitsFilterQueryString) {
        this.mSplitsStorage = (PersistentSplitsStorage) Utils.checkNotNull(splitsStorage);
        this.mSplitsFilter = (List) Utils.checkNotNull(splitsFilter);
        this.mSplitsFilterQueryStringFromConfig = splitsFilterQueryString;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        if (!queryStringHasChanged()) {
            return SplitTaskExecutionInfo.success(SplitTaskType.FILTER_SPLITS_CACHE);
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        for (SplitFilter splitFilter : this.mSplitsFilter) {
            int i = AnonymousClass1.$SwitchMap$io$split$android$client$SplitFilter$Type[splitFilter.getType().ordinal()];
            if (i == 1) {
                hashSet3.addAll(splitFilter.getValues());
            } else if (i == 2) {
                hashSet.addAll(splitFilter.getValues());
            } else if (i == 3) {
                hashSet2.addAll(splitFilter.getValues());
            } else {
                Logger.e("Unknown filter type: " + splitFilter.getType().toString());
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Split split : this.mSplitsStorage.getAll()) {
            String str = split.name;
            if (!hashSet3.isEmpty()) {
                if (split.sets != null) {
                    Iterator<String> it = split.sets.iterator();
                    do {
                        if (it.hasNext()) {
                        }
                    } while (!hashSet3.contains(it.next()));
                }
                arrayList.add(str);
                break;
            }
            String prefix = getPrefix(str);
            if (!hashSet.contains(split.name) && (prefix == null || !hashSet2.contains(prefix))) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            this.mSplitsStorage.delete(arrayList);
        }
        return SplitTaskExecutionInfo.success(SplitTaskType.FILTER_SPLITS_CACHE);
    }

    /* JADX INFO: renamed from: io.split.android.client.service.splits.FilterSplitsInCacheTask$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$SplitFilter$Type;

        static {
            int[] iArr = new int[SplitFilter.Type.values().length];
            $SwitchMap$io$split$android$client$SplitFilter$Type = iArr;
            try {
                iArr[SplitFilter.Type.BY_SET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$SplitFilter$Type[SplitFilter.Type.BY_NAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$SplitFilter$Type[SplitFilter.Type.BY_PREFIX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private String getPrefix(String splitName) {
        int iIndexOf = splitName.indexOf(PREFIX_SEPARATOR);
        if (iIndexOf < 1) {
            return null;
        }
        return splitName.substring(0, iIndexOf);
    }

    private boolean queryStringHasChanged() {
        return !sanitizeString(this.mSplitsStorage.getFilterQueryString()).equals(sanitizeString(this.mSplitsFilterQueryStringFromConfig));
    }

    private static String sanitizeString(String string) {
        return string != null ? string : "";
    }
}
