package com.apollographql.apollo3.cache.normalized.sql.internal.json;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RecordForKey.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/RecordForKey;", "", "key", "", "record", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getRecord", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "apollo-normalized-cache-sqlite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class RecordForKey {
    private final String key;
    private final String record;

    public static /* synthetic */ RecordForKey copy$default(RecordForKey recordForKey, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recordForKey.key;
        }
        if ((i & 2) != 0) {
            str2 = recordForKey.record;
        }
        return recordForKey.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRecord() {
        return this.record;
    }

    public final RecordForKey copy(String key, String record) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(record, "record");
        return new RecordForKey(key, record);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecordForKey)) {
            return false;
        }
        RecordForKey recordForKey = (RecordForKey) other;
        return Intrinsics.areEqual(this.key, recordForKey.key) && Intrinsics.areEqual(this.record, recordForKey.record);
    }

    public int hashCode() {
        return (this.key.hashCode() * 31) + this.record.hashCode();
    }

    public RecordForKey(String key, String record) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(record, "record");
        this.key = key;
        this.record = record;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getRecord() {
        return this.record;
    }

    public String toString() {
        return StringsKt.trimMargin$default("\n  |RecordForKey [\n  |  key: " + this.key + "\n  |  record: " + this.record + "\n  |]\n  ", null, 1, null);
    }
}
