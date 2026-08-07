package org.tinylog.runtime;

import java.time.Instant;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public final class LegacyTimestamp implements Timestamp {
    private static final long MILLISECOND_IN_NANOS = 1000000;
    private final Date date;

    public LegacyTimestamp() {
        this.date = new Date();
    }

    public LegacyTimestamp(long j) {
        this.date = new Date(j);
    }

    @Override // org.tinylog.runtime.Timestamp
    public Date toDate() {
        return this.date;
    }

    @Override // org.tinylog.runtime.Timestamp
    public Instant toInstant() {
        return this.date.toInstant();
    }

    @Override // org.tinylog.runtime.Timestamp
    public java.sql.Timestamp toSqlTimestamp() {
        return new java.sql.Timestamp(this.date.getTime());
    }

    @Override // org.tinylog.runtime.Timestamp
    public long calcDifferenceInNanoseconds(Timestamp timestamp) {
        return (this.date.getTime() - timestamp.toDate().getTime()) * 1000000;
    }
}
