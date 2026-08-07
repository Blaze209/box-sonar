package com.j256.ormlite.misc;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes14.dex */
public class TransactionManager {
    private static final String SAVE_POINT_PREFIX = "ORMLITE";
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) TransactionManager.class);
    private static AtomicInteger savePointCounter = new AtomicInteger();
    private ConnectionSource connectionSource;

    public TransactionManager() {
    }

    public TransactionManager(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
        initialize();
    }

    public void initialize() {
        if (this.connectionSource == null) {
            throw new IllegalStateException("dataSource was not set on " + getClass().getSimpleName());
        }
    }

    public <T> T callInTransaction(Callable<T> callable) throws SQLException {
        return (T) callInTransaction(this.connectionSource, callable);
    }

    public static <T> T callInTransaction(ConnectionSource connectionSource, Callable<T> callable) throws SQLException {
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection();
        try {
            return (T) callInTransaction(readWriteConnection, connectionSource.saveSpecialConnection(readWriteConnection), connectionSource.getDatabaseType(), callable);
        } finally {
            connectionSource.clearSpecialConnection(readWriteConnection);
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public static <T> T callInTransaction(DatabaseConnection databaseConnection, DatabaseType databaseType, Callable<T> callable) throws SQLException {
        return (T) callInTransaction(databaseConnection, false, databaseType, callable);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0019 A[Catch: all -> 0x008a, TRY_LEAVE, TryCatch #4 {all -> 0x008a, blocks: (B:4:0x0009, B:8:0x0013, B:10:0x0019, B:17:0x002f, B:19:0x0048, B:20:0x0051), top: B:47:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0048 A[Catch: all -> 0x008a, TryCatch #4 {all -> 0x008a, blocks: (B:4:0x0009, B:8:0x0013, B:10:0x0019, B:17:0x002f, B:19:0x0048, B:20:0x0051), top: B:47:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0051 A[Catch: all -> 0x008a, TRY_LEAVE, TryCatch #4 {all -> 0x008a, blocks: (B:4:0x0009, B:8:0x0013, B:10:0x0019, B:17:0x002f, B:19:0x0048, B:20:0x0051), top: B:47:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0065 A[Catch: all -> 0x0073, Exception -> 0x0076, SQLException -> 0x0083, TRY_LEAVE, TryCatch #1 {SQLException -> 0x0083, blocks: (B:22:0x005f, B:24:0x0065), top: B:43:0x005f, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    /* JADX WARN: Code duplicated, block: B:45:0x001f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static <T> T callInTransaction(DatabaseConnection databaseConnection, boolean z, DatabaseType databaseType, Callable<T> callable) throws Throwable {
        Savepoint savePoint;
        boolean z2;
        boolean zIsAutoCommit;
        boolean z3 = false;
        if (z) {
            if (databaseConnection.isAutoCommitSupported()) {
                zIsAutoCommit = databaseConnection.isAutoCommit();
                if (zIsAutoCommit) {
                    databaseConnection.setAutoCommit(false);
                    logger.debug("had to set auto-commit to false");
                }
                z3 = zIsAutoCommit;
            }
            savePoint = databaseConnection.setSavePoint(SAVE_POINT_PREFIX + savePointCounter.incrementAndGet());
            if (savePoint == null) {
                logger.debug("started savePoint transaction");
            } else {
                logger.debug("started savePoint transaction {}", savePoint.getSavepointName());
            }
            z2 = z3;
            z3 = true;
            T tCall = callable.call();
            if (z3) {
                commit(databaseConnection, savePoint);
            }
            if (z2) {
                databaseConnection.setAutoCommit(true);
                logger.debug("restored auto-commit to true");
            }
            return tCall;
        }
        try {
            if (databaseType.isNestedSavePointsSupported()) {
                if (databaseConnection.isAutoCommitSupported()) {
                    zIsAutoCommit = databaseConnection.isAutoCommit();
                    if (zIsAutoCommit) {
                        try {
                            databaseConnection.setAutoCommit(false);
                            logger.debug("had to set auto-commit to false");
                        } catch (Throwable th) {
                            z3 = zIsAutoCommit;
                            th = th;
                        }
                    }
                    z3 = zIsAutoCommit;
                }
                savePoint = databaseConnection.setSavePoint(SAVE_POINT_PREFIX + savePointCounter.incrementAndGet());
                if (savePoint == null) {
                    logger.debug("started savePoint transaction");
                } else {
                    logger.debug("started savePoint transaction {}", savePoint.getSavepointName());
                }
                z2 = z3;
                z3 = true;
            } else {
                savePoint = null;
                z2 = false;
            }
            try {
                try {
                    try {
                        T tCall2 = callable.call();
                        if (z3) {
                            commit(databaseConnection, savePoint);
                        }
                        if (z2) {
                            databaseConnection.setAutoCommit(true);
                            logger.debug("restored auto-commit to true");
                        }
                        return tCall2;
                    } catch (SQLException e) {
                        if (z3) {
                            rollBack(databaseConnection, savePoint);
                        }
                        throw e;
                    }
                } catch (Exception e2) {
                    if (z3) {
                        rollBack(databaseConnection, savePoint);
                    }
                    throw SqlExceptionUtil.create("Transaction callable threw non-SQL exception", e2);
                }
            } catch (Throwable th2) {
                th = th2;
                z3 = z2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        if (z3) {
            databaseConnection.setAutoCommit(true);
            logger.debug("restored auto-commit to true");
        }
        throw th;
    }

    public void setConnectionSource(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
    }

    private static void commit(DatabaseConnection databaseConnection, Savepoint savepoint) throws SQLException {
        String savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.commit(savepoint);
        if (savepointName == null) {
            logger.debug("committed savePoint transaction");
        } else {
            logger.debug("committed savePoint transaction {}", savepointName);
        }
    }

    private static void rollBack(DatabaseConnection databaseConnection, Savepoint savepoint) throws SQLException {
        String savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.rollback(savepoint);
        if (savepointName == null) {
            logger.debug("rolled back savePoint transaction");
        } else {
            logger.debug("rolled back savePoint transaction {}", savepointName);
        }
    }
}
