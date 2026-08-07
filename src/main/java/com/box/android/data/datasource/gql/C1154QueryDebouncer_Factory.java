package com.box.android.data.datasource.gql;

/* JADX INFO: renamed from: com.box.android.data.datasource.gql.QueryDebouncer_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C1154QueryDebouncer_Factory {
    public QueryDebouncer get(int exclusionPeriod, DateProviding dateProvider) {
        return newInstance(exclusionPeriod, dateProvider);
    }

    public static C1154QueryDebouncer_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static QueryDebouncer newInstance(int exclusionPeriod, DateProviding dateProvider) {
        return new QueryDebouncer(exclusionPeriod, dateProvider);
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.gql.QueryDebouncer_Factory$InstanceHolder */
    private static final class InstanceHolder {
        static final C1154QueryDebouncer_Factory INSTANCE = new C1154QueryDebouncer_Factory();

        private InstanceHolder() {
        }
    }
}
