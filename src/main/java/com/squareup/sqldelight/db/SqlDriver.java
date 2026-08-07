package com.squareup.sqldelight.db;

import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.squareup.sqldelight.Transacter;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SqlDriver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0015J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&JD\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u001b\b\u0002\u0010\f\u001a\u0015\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r¢\u0006\u0002\b\u000fH&¢\u0006\u0002\u0010\u0010JD\u0010\u0011\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u001b\b\u0002\u0010\f\u001a\u0015\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r¢\u0006\u0002\b\u000fH&¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0004H&¨\u0006\u0016"}, d2 = {"Lcom/squareup/sqldelight/db/SqlDriver;", "Ljava/io/Closeable;", "Lcom/squareup/sqldelight/db/Closeable;", "currentTransaction", "Lcom/squareup/sqldelight/Transacter$Transaction;", "execute", "", "identifier", "", "sql", "", "parameters", "binders", "Lkotlin/Function1;", "Lcom/squareup/sqldelight/db/SqlPreparedStatement;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Integer;Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "executeQuery", "Lcom/squareup/sqldelight/db/SqlCursor;", "(Ljava/lang/Integer;Ljava/lang/String;ILkotlin/jvm/functions/Function1;)Lcom/squareup/sqldelight/db/SqlCursor;", "newTransaction", "Schema", "runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface SqlDriver extends Closeable {

    /* JADX INFO: compiled from: SqlDriver.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/squareup/sqldelight/db/SqlDriver$Schema;", "", "version", "", "getVersion", "()I", PasskeyWebListener.CREATE_UNIQUE_KEY, "", "driver", "Lcom/squareup/sqldelight/db/SqlDriver;", "migrate", "oldVersion", "newVersion", "runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Schema {
        void create(SqlDriver driver);

        int getVersion();

        void migrate(SqlDriver driver, int oldVersion, int newVersion);
    }

    Transacter.Transaction currentTransaction();

    void execute(Integer identifier, String sql, int parameters, Function1<? super SqlPreparedStatement, Unit> binders);

    SqlCursor executeQuery(Integer identifier, String sql, int parameters, Function1<? super SqlPreparedStatement, Unit> binders);

    Transacter.Transaction newTransaction();

    /* JADX INFO: compiled from: SqlDriver.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SqlCursor executeQuery$default(SqlDriver sqlDriver, Integer num, String str, int i, Function1 function1, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: executeQuery");
            }
            if ((i2 & 8) != 0) {
                function1 = null;
            }
            return sqlDriver.executeQuery(num, str, i, function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void execute$default(SqlDriver sqlDriver, Integer num, String str, int i, Function1 function1, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
            }
            if ((i2 & 8) != 0) {
                function1 = null;
            }
            sqlDriver.execute(num, str, i, function1);
        }
    }
}
