package com.squareup.sqldelight.logs;

import com.squareup.sqldelight.Transacter;
import com.squareup.sqldelight.db.SqlCursor;
import com.squareup.sqldelight.db.SqlDriver;
import com.squareup.sqldelight.db.SqlPreparedStatement;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: compiled from: LogSqliteDriver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016JB\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\r2\u0019\u0010\u0010\u001a\u0015\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\b\u0012H\u0016¢\u0006\u0002\u0010\u0013JB\u0010\u0014\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\r2\u0019\u0010\u0010\u001a\u0015\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\b\u0012H\u0016¢\u0006\u0002\u0010\u0016J#\u0010\u0017\u001a\u00020\u00062\u0019\u0010\u0010\u001a\u0015\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\b\u0012H\u0002J\b\u0010\u0018\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/squareup/sqldelight/logs/LogSqliteDriver;", "Lcom/squareup/sqldelight/db/SqlDriver;", "sqlDriver", "logger", "Lkotlin/Function1;", "", "", "(Lcom/squareup/sqldelight/db/SqlDriver;Lkotlin/jvm/functions/Function1;)V", HeaderElements.CLOSE, "currentTransaction", "Lcom/squareup/sqldelight/Transacter$Transaction;", "execute", "identifier", "", "sql", "parameters", "binders", "Lcom/squareup/sqldelight/db/SqlPreparedStatement;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Integer;Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "executeQuery", "Lcom/squareup/sqldelight/db/SqlCursor;", "(Ljava/lang/Integer;Ljava/lang/String;ILkotlin/jvm/functions/Function1;)Lcom/squareup/sqldelight/db/SqlCursor;", "logParameters", "newTransaction", "runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LogSqliteDriver implements SqlDriver {
    private final Function1<String, Unit> logger;
    private final SqlDriver sqlDriver;

    /* JADX WARN: Multi-variable type inference failed */
    public LogSqliteDriver(SqlDriver sqlDriver, Function1<? super String, Unit> logger) {
        Intrinsics.checkNotNullParameter(sqlDriver, "sqlDriver");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.sqlDriver = sqlDriver;
        this.logger = logger;
    }

    @Override // com.squareup.sqldelight.db.SqlDriver
    public Transacter.Transaction currentTransaction() {
        return this.sqlDriver.currentTransaction();
    }

    @Override // com.squareup.sqldelight.db.SqlDriver
    public void execute(Integer identifier, String sql, int parameters, Function1<? super SqlPreparedStatement, Unit> binders) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        this.logger.invoke(Intrinsics.stringPlus("EXECUTE\n ", sql));
        logParameters(binders);
        this.sqlDriver.execute(identifier, sql, parameters, binders);
    }

    @Override // com.squareup.sqldelight.db.SqlDriver
    public SqlCursor executeQuery(Integer identifier, String sql, int parameters, Function1<? super SqlPreparedStatement, Unit> binders) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        this.logger.invoke(Intrinsics.stringPlus("QUERY\n ", sql));
        logParameters(binders);
        return this.sqlDriver.executeQuery(identifier, sql, parameters, binders);
    }

    @Override // com.squareup.sqldelight.db.SqlDriver
    public Transacter.Transaction newTransaction() {
        this.logger.invoke("TRANSACTION BEGIN");
        Transacter.Transaction transactionNewTransaction = this.sqlDriver.newTransaction();
        transactionNewTransaction.afterCommit(new Function0<Unit>() { // from class: com.squareup.sqldelight.logs.LogSqliteDriver.newTransaction.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LogSqliteDriver.this.logger.invoke("TRANSACTION COMMIT");
            }
        });
        transactionNewTransaction.afterRollback(new Function0<Unit>() { // from class: com.squareup.sqldelight.logs.LogSqliteDriver.newTransaction.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LogSqliteDriver.this.logger.invoke("TRANSACTION ROLLBACK");
            }
        });
        return transactionNewTransaction;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.logger.invoke("CLOSE CONNECTION");
        this.sqlDriver.close();
    }

    private final void logParameters(Function1<? super SqlPreparedStatement, Unit> binders) {
        if (binders == null) {
            return;
        }
        StatementParameterInterceptor statementParameterInterceptor = new StatementParameterInterceptor();
        binders.invoke(statementParameterInterceptor);
        List<Object> andClearParameters = statementParameterInterceptor.getAndClearParameters();
        if (andClearParameters.isEmpty()) {
            return;
        }
        this.logger.invoke(Intrinsics.stringPlus(" ", andClearParameters));
    }
}
