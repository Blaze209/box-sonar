package com.apollographql.apollo3.cache.normalized.sql.internal.json;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.j256.ormlite.field.FieldType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Records.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/Records;", "", FieldType.FOREIGN_ID_FIELD_SUFFIX, "", "key", "", "record", "(JLjava/lang/String;Ljava/lang/String;)V", "get_id", "()J", "getKey", "()Ljava/lang/String;", "getRecord", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "apollo-normalized-cache-sqlite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class Records {
    private final long _id;
    private final String key;
    private final String record;

    public static /* synthetic */ Records copy$default(Records records, long j, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = records._id;
        }
        if ((i & 2) != 0) {
            str = records.key;
        }
        if ((i & 4) != 0) {
            str2 = records.record;
        }
        return records.copy(j, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long get_id() {
        return this._id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRecord() {
        return this.record;
    }

    public final Records copy(long _id, String key, String record) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(record, "record");
        return new Records(_id, key, record);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Records)) {
            return false;
        }
        Records records = (Records) other;
        return this._id == records._id && Intrinsics.areEqual(this.key, records.key) && Intrinsics.areEqual(this.record, records.record);
    }

    public int hashCode() {
        return (((Long.hashCode(this._id) * 31) + this.key.hashCode()) * 31) + this.record.hashCode();
    }

    public Records(long j, String key, String record) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(record, "record");
        this._id = j;
        this.key = key;
        this.record = record;
    }

    public final long get_id() {
        return this._id;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getRecord() {
        return this.record;
    }

    public String toString() {
        return StringsKt.trimMargin$default("\n  |Records [\n  |  _id: " + this._id + "\n  |  key: " + this.key + "\n  |  record: " + this.record + "\n  |]\n  ", null, 1, null);
    }
}
