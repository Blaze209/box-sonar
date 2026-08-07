package org.tinylog.runtime;

import java.time.Instant;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public interface Timestamp {
    long calcDifferenceInNanoseconds(Timestamp timestamp);

    Date toDate();

    Instant toInstant();

    java.sql.Timestamp toSqlTimestamp();
}
