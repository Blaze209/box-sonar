package io.split.android.client;

import io.split.android.client.utils.logger.Logger;
import io.split.android.client.validators.SplitValidator;
import io.split.android.client.validators.SplitValidatorImpl;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SyncConfig {
    private final List<SplitFilter> mFilters;
    private final int mInvalidValueCount;
    private final int mTotalValueCount;

    private SyncConfig(List<SplitFilter> filters, int invalidValueCount, int totalValueCount) {
        this.mFilters = filters;
        this.mInvalidValueCount = invalidValueCount;
        this.mTotalValueCount = totalValueCount;
    }

    public List<SplitFilter> getFilters() {
        return this.mFilters;
    }

    public int getInvalidValueCount() {
        return this.mInvalidValueCount;
    }

    public int getTotalValueCount() {
        return this.mTotalValueCount;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final List<SplitFilter> mBuilderFilters = new ArrayList();
        private int mInvalidValueCount = 0;
        private int mTotalValueCount = 0;
        private final SplitValidator mSplitValidator = new SplitValidatorImpl();

        public SyncConfig build() {
            ArrayList arrayList = new ArrayList();
            for (SplitFilter splitFilter : this.mBuilderFilters) {
                List<String> values = splitFilter.getValues();
                ArrayList arrayList2 = new ArrayList();
                for (String str : values) {
                    if (this.mSplitValidator.validateName(str) != null) {
                        Logger.w(String.format("Warning: Malformed %s value. Filter ignored: %s", splitFilter.getType().toString(), str));
                    } else {
                        arrayList2.add(str);
                    }
                }
                if (arrayList2.size() > 0) {
                    arrayList.add(new SplitFilter(splitFilter.getType(), arrayList2));
                }
            }
            return new SyncConfig(arrayList, this.mInvalidValueCount, this.mTotalValueCount);
        }

        public Builder addSplitFilter(SplitFilter filter) {
            if (filter == null) {
                throw new IllegalArgumentException("Filter can't be null");
            }
            this.mBuilderFilters.add(filter);
            this.mInvalidValueCount += filter.getInvalidValueCount();
            this.mTotalValueCount += filter.getTotalValueCount();
            return this;
        }
    }
}
