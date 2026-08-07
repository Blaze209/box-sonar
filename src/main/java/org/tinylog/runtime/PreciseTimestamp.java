package org.tinylog.runtime;

import androidx.media3.common.C;
import java.time.Instant;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public final class PreciseTimestamp implements Timestamp {
    private static final long MILLISECOND_IN_NANOS = 1000000;
    private static final long SECOND_IN_MILLIS = 1000;
    private final Instant instant;

    public PreciseTimestamp() {
        this.instant = Instant.now();
    }

    public PreciseTimestamp(long j, long j2) {
        this.instant = Instant.ofEpochSecond(j / 1000, ((j % 1000) * 1000000) + j2);
    }

    @Override // org.tinylog.runtime.Timestamp
    public Date toDate() {
        return Date.from(this.instant);
    }

    @Override // org.tinylog.runtime.Timestamp
    public Instant toInstant() {
        return this.instant;
    }

    @Override // org.tinylog.runtime.Timestamp
    public java.sql.Timestamp toSqlTimestamp() {
        return java.sql.Timestamp.from(this.instant);
    }

    @Override // org.tinylog.runtime.Timestamp
    public long calcDifferenceInNanoseconds(Timestamp timestamp) {
        Instant instant = timestamp.toInstant();
        return (((this.instant.getEpochSecond() - instant.getEpochSecond()) * C.NANOS_PER_SECOND) - ((long) instant.getNano())) + ((long) this.instant.getNano());
    }
}
