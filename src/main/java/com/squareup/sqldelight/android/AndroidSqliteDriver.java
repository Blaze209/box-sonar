package com.squareup.sqldelight.android;

import android.content.Context;
import android.util.LruCache;
import androidx.exifinterface.media.ExifInterface;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.box.androidsdk.content.BoxApiMetadata;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.squareup.sqldelight.Transacter;
import com.squareup.sqldelight.db.AfterVersion;
import com.squareup.sqldelight.db.AfterVersionWithDriver;
import com.squareup.sqldelight.db.SqlCursor;
import com.squareup.sqldelight.db.SqlDriver;
import com.squareup.sqldelight.db.SqlDriverKt;
import com.squareup.sqldelight.db.SqlPreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: compiled from: AndroidSqliteDriver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001d\u0018\u00002\u00020\u0001:\u00029:B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BK\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013B\u0019\b\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0016B'\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0017J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\n %*\u0004\u0018\u00010!0!H\u0016J_\u0010&\u001a\u0002H'\"\u0004\b\u0000\u0010'2\b\u0010(\u001a\u0004\u0018\u00010\u00102\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0019\u0010,\u001a\u0015\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020#\u0018\u00010-¢\u0006\u0002\b/2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u0002H'0-¢\u0006\u0002\b/H\u0002¢\u0006\u0002\u00101JB\u0010&\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010\u00102\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\u00102\u0019\u0010,\u001a\u0015\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020#\u0018\u00010-¢\u0006\u0002\b/H\u0016¢\u0006\u0002\u00104JB\u00105\u001a\u0002062\b\u0010(\u001a\u0004\u0018\u00010\u00102\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\u00102\u0019\u0010,\u001a\u0015\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020#\u0018\u00010-¢\u0006\u0002\b/H\u0016¢\u0006\u0002\u00107J\b\u00108\u001a\u00020!H\u0016R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/squareup/sqldelight/android/AndroidSqliteDriver;", "Lcom/squareup/sqldelight/db/SqlDriver;", "openHelper", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "(Landroidx/sqlite/db/SupportSQLiteOpenHelper;)V", BoxApiMetadata.BOX_API_METADATA_SCHEMA, "Lcom/squareup/sqldelight/db/SqlDriver$Schema;", "context", "Landroid/content/Context;", "name", "", "factory", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "cacheSize", "", "useNoBackupDirectory", "", "(Lcom/squareup/sqldelight/db/SqlDriver$Schema;Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;IZ)V", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "(Landroidx/sqlite/db/SupportSQLiteDatabase;I)V", "(Landroidx/sqlite/db/SupportSQLiteOpenHelper;Landroidx/sqlite/db/SupportSQLiteDatabase;I)V", "getDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "database$delegate", "Lkotlin/Lazy;", "statements", "com/squareup/sqldelight/android/AndroidSqliteDriver$statements$1", "Lcom/squareup/sqldelight/android/AndroidSqliteDriver$statements$1;", "transactions", "Ljava/lang/ThreadLocal;", "Lcom/squareup/sqldelight/Transacter$Transaction;", HeaderElements.CLOSE, "", "currentTransaction", "kotlin.jvm.PlatformType", "execute", ExifInterface.GPS_DIRECTION_TRUE, "identifier", "createStatement", "Lkotlin/Function0;", "Lcom/squareup/sqldelight/android/AndroidStatement;", "binders", "Lkotlin/Function1;", "Lcom/squareup/sqldelight/db/SqlPreparedStatement;", "Lkotlin/ExtensionFunctionType;", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "(Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "sql", "parameters", "(Ljava/lang/Integer;Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "executeQuery", "Lcom/squareup/sqldelight/db/SqlCursor;", "(Ljava/lang/Integer;Ljava/lang/String;ILkotlin/jvm/functions/Function1;)Lcom/squareup/sqldelight/db/SqlCursor;", "newTransaction", "Callback", "Transaction", "sqldelight-android-driver_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AndroidSqliteDriver implements SqlDriver {
    private final int cacheSize;

    /* JADX INFO: renamed from: database$delegate, reason: from kotlin metadata */
    private final Lazy database;
    private final SupportSQLiteOpenHelper openHelper;
    private final AndroidSqliteDriver$statements$1 statements;
    private final ThreadLocal<Transacter.Transaction> transactions;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AndroidSqliteDriver(SupportSQLiteDatabase database) {
        this(database, 0, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(database, "database");
    }

    public /* synthetic */ AndroidSqliteDriver(SupportSQLiteOpenHelper supportSQLiteOpenHelper, SupportSQLiteDatabase supportSQLiteDatabase, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(supportSQLiteOpenHelper, supportSQLiteDatabase, i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AndroidSqliteDriver(SqlDriver.Schema schema, Context context) {
        this(schema, context, null, null, null, 0, false, 124, null);
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AndroidSqliteDriver(SqlDriver.Schema schema, Context context, String str) {
        this(schema, context, str, null, null, 0, false, 120, null);
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AndroidSqliteDriver(SqlDriver.Schema schema, Context context, String str, SupportSQLiteOpenHelper.Factory factory) {
        this(schema, context, str, factory, null, 0, false, 112, null);
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(factory, "factory");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AndroidSqliteDriver(SqlDriver.Schema schema, Context context, String str, SupportSQLiteOpenHelper.Factory factory, SupportSQLiteOpenHelper.Callback callback) {
        this(schema, context, str, factory, callback, 0, false, 96, null);
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AndroidSqliteDriver(SqlDriver.Schema schema, Context context, String str, SupportSQLiteOpenHelper.Factory factory, SupportSQLiteOpenHelper.Callback callback, int i) {
        this(schema, context, str, factory, callback, i, false, 64, null);
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [com.squareup.sqldelight.android.AndroidSqliteDriver$statements$1] */
    private AndroidSqliteDriver(SupportSQLiteOpenHelper supportSQLiteOpenHelper, final SupportSQLiteDatabase supportSQLiteDatabase, final int i) {
        this.openHelper = supportSQLiteOpenHelper;
        this.cacheSize = i;
        if (!((supportSQLiteOpenHelper != null) ^ (supportSQLiteDatabase != null))) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        this.transactions = new ThreadLocal<>();
        this.database = LazyKt.lazy(new Function0<SupportSQLiteDatabase>() { // from class: com.squareup.sqldelight.android.AndroidSqliteDriver$database$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SupportSQLiteDatabase invoke() {
                SupportSQLiteOpenHelper supportSQLiteOpenHelper2 = this.this$0.openHelper;
                SupportSQLiteDatabase writableDatabase = supportSQLiteOpenHelper2 == null ? null : supportSQLiteOpenHelper2.getWritableDatabase();
                if (writableDatabase != null) {
                    return writableDatabase;
                }
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                Intrinsics.checkNotNull(supportSQLiteDatabase2);
                return supportSQLiteDatabase2;
            }
        });
        this.statements = new LruCache<Integer, AndroidStatement>(i) { // from class: com.squareup.sqldelight.android.AndroidSqliteDriver$statements$1
            @Override // android.util.LruCache
            public /* bridge */ /* synthetic */ void entryRemoved(boolean z, Integer num, AndroidStatement androidStatement, AndroidStatement androidStatement2) {
                entryRemoved(z, num.intValue(), androidStatement, androidStatement2);
            }

            protected void entryRemoved(boolean evicted, int key, AndroidStatement oldValue, AndroidStatement newValue) {
                Intrinsics.checkNotNullParameter(oldValue, "oldValue");
                if (evicted) {
                    oldValue.close();
                }
            }
        };
    }

    /* synthetic */ AndroidSqliteDriver(SupportSQLiteOpenHelper supportSQLiteOpenHelper, SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : supportSQLiteOpenHelper, (i2 & 2) != 0 ? null : supportSQLiteDatabase, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SupportSQLiteDatabase getDatabase() {
        return (SupportSQLiteDatabase) this.database.getValue();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AndroidSqliteDriver(SupportSQLiteOpenHelper openHelper) {
        this(openHelper, (SupportSQLiteDatabase) null, AndroidSqliteDriverKt.DEFAULT_CACHE_SIZE);
        Intrinsics.checkNotNullParameter(openHelper, "openHelper");
    }

    public /* synthetic */ AndroidSqliteDriver(SqlDriver.Schema schema, Context context, String str, FrameworkSQLiteOpenHelperFactory frameworkSQLiteOpenHelperFactory, Callback callback, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(schema, context, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? new FrameworkSQLiteOpenHelperFactory() : frameworkSQLiteOpenHelperFactory, (i2 & 16) != 0 ? new Callback(schema) : callback, (i2 & 32) != 0 ? AndroidSqliteDriverKt.DEFAULT_CACHE_SIZE : i, (i2 & 64) != 0 ? false : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AndroidSqliteDriver(SqlDriver.Schema schema, Context context, String str, SupportSQLiteOpenHelper.Factory factory, SupportSQLiteOpenHelper.Callback callback, int i, boolean z) {
        this(factory.create(SupportSQLiteOpenHelper.Configuration.builder(context).callback(callback).name(str).noBackupDirectory(z).build()), (SupportSQLiteDatabase) null, i);
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    public /* synthetic */ AndroidSqliteDriver(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(supportSQLiteDatabase, (i2 & 2) != 0 ? AndroidSqliteDriverKt.DEFAULT_CACHE_SIZE : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AndroidSqliteDriver(SupportSQLiteDatabase database, int i) {
        this((SupportSQLiteOpenHelper) null, database, i);
        Intrinsics.checkNotNullParameter(database, "database");
    }

    @Override // com.squareup.sqldelight.db.SqlDriver
    public Transacter.Transaction newTransaction() {
        Transacter.Transaction transaction = this.transactions.get();
        Transaction transaction2 = new Transaction(this, transaction);
        this.transactions.set(transaction2);
        if (transaction == null) {
            getDatabase().beginTransactionNonExclusive();
        }
        return transaction2;
    }

    @Override // com.squareup.sqldelight.db.SqlDriver
    public Transacter.Transaction currentTransaction() {
        return this.transactions.get();
    }

    /* JADX INFO: compiled from: AndroidSqliteDriver.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/squareup/sqldelight/android/AndroidSqliteDriver$Transaction;", "Lcom/squareup/sqldelight/Transacter$Transaction;", "enclosingTransaction", "(Lcom/squareup/sqldelight/android/AndroidSqliteDriver;Lcom/squareup/sqldelight/Transacter$Transaction;)V", "getEnclosingTransaction", "()Lcom/squareup/sqldelight/Transacter$Transaction;", "endTransaction", "", "successful", "", "sqldelight-android-driver_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class Transaction extends Transacter.Transaction {
        private final Transacter.Transaction enclosingTransaction;
        final /* synthetic */ AndroidSqliteDriver this$0;

        public Transaction(AndroidSqliteDriver this$0, Transacter.Transaction transaction) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            this.enclosingTransaction = transaction;
        }

        @Override // com.squareup.sqldelight.Transacter.Transaction
        protected Transacter.Transaction getEnclosingTransaction() {
            return this.enclosingTransaction;
        }

        @Override // com.squareup.sqldelight.Transacter.Transaction
        protected void endTransaction(boolean successful) {
            if (getEnclosingTransaction() == null) {
                if (successful) {
                    this.this$0.getDatabase().setTransactionSuccessful();
                    this.this$0.getDatabase().endTransaction();
                } else {
                    this.this$0.getDatabase().endTransaction();
                }
            }
            this.this$0.transactions.set(getEnclosingTransaction());
        }
    }

    private final <T> T execute(Integer identifier, Function0<? extends AndroidStatement> createStatement, Function1<? super SqlPreparedStatement, Unit> binders, Function1<? super AndroidStatement, ? extends T> result) {
        AndroidStatement androidStatementRemove = identifier != null ? remove(identifier) : null;
        if (androidStatementRemove == null) {
            androidStatementRemove = createStatement.invoke();
        }
        if (binders != null) {
            try {
                binders.invoke(androidStatementRemove);
            } finally {
                if (identifier != null) {
                    AndroidStatement androidStatementPut = put(identifier, androidStatementRemove);
                    if (androidStatementPut != null) {
                        androidStatementPut.close();
                    }
                } else {
                    androidStatementRemove.close();
                }
            }
        }
        T tInvoke = result.invoke(androidStatementRemove);
        return tInvoke;
    }

    /* JADX INFO: renamed from: com.squareup.sqldelight.android.AndroidSqliteDriver$execute$2, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidSqliteDriver.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<AndroidStatement, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1, AndroidStatement.class, "execute", "execute()V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AndroidStatement androidStatement) {
            invoke2(androidStatement);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AndroidStatement p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            p0.mo14351execute();
        }
    }

    @Override // com.squareup.sqldelight.db.SqlDriver
    public void execute(Integer identifier, final String sql, int parameters, Function1<? super SqlPreparedStatement, Unit> binders) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        execute(identifier, new Function0<AndroidStatement>() { // from class: com.squareup.sqldelight.android.AndroidSqliteDriver.execute.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AndroidStatement invoke() {
                SupportSQLiteStatement supportSQLiteStatementCompileStatement = AndroidSqliteDriver.this.getDatabase().compileStatement(sql);
                Intrinsics.checkNotNullExpressionValue(supportSQLiteStatementCompileStatement, "database.compileStatement(sql)");
                return new AndroidPreparedStatement(supportSQLiteStatementCompileStatement);
            }
        }, binders, AnonymousClass2.INSTANCE);
    }

    /* JADX INFO: renamed from: com.squareup.sqldelight.android.AndroidSqliteDriver$executeQuery$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidSqliteDriver.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* synthetic */ class C18712 extends FunctionReferenceImpl implements Function1<AndroidStatement, SqlCursor> {
        public static final C18712 INSTANCE = new C18712();

        C18712() {
            super(1, AndroidStatement.class, "executeQuery", "executeQuery()Lcom/squareup/sqldelight/db/SqlCursor;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final SqlCursor invoke(AndroidStatement p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return p0.executeQuery();
        }
    }

    @Override // com.squareup.sqldelight.db.SqlDriver
    public SqlCursor executeQuery(Integer identifier, final String sql, final int parameters, Function1<? super SqlPreparedStatement, Unit> binders) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        return (SqlCursor) execute(identifier, new Function0<AndroidStatement>() { // from class: com.squareup.sqldelight.android.AndroidSqliteDriver.executeQuery.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AndroidStatement invoke() {
                return new AndroidQuery(sql, this.getDatabase(), parameters);
            }
        }, binders, C18712.INSTANCE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Unit unit;
        evictAll();
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.openHelper;
        if (supportSQLiteOpenHelper == null) {
            unit = null;
        } else {
            supportSQLiteOpenHelper.close();
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            getDatabase().close();
        }
    }

    /* JADX INFO: compiled from: AndroidSqliteDriver.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0002\u0010\bB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0006\"\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0018\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/squareup/sqldelight/android/AndroidSqliteDriver$Callback;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", BoxApiMetadata.BOX_API_METADATA_SCHEMA, "Lcom/squareup/sqldelight/db/SqlDriver$Schema;", "(Lcom/squareup/sqldelight/db/SqlDriver$Schema;)V", "callbacks", "", "Lcom/squareup/sqldelight/db/AfterVersion;", "(Lcom/squareup/sqldelight/db/SqlDriver$Schema;[Lcom/squareup/sqldelight/db/AfterVersion;)V", "Lcom/squareup/sqldelight/db/AfterVersionWithDriver;", "(Lcom/squareup/sqldelight/db/SqlDriver$Schema;[Lcom/squareup/sqldelight/db/AfterVersionWithDriver;)V", "[Lcom/squareup/sqldelight/db/AfterVersionWithDriver;", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "onUpgrade", "oldVersion", "", "newVersion", "sqldelight-android-driver_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class Callback extends SupportSQLiteOpenHelper.Callback {
        private final AfterVersionWithDriver[] callbacks;
        private final SqlDriver.Schema schema;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Callback(SqlDriver.Schema schema, AfterVersionWithDriver... callbacks) {
            super(schema.getVersion());
            Intrinsics.checkNotNullParameter(schema, "schema");
            Intrinsics.checkNotNullParameter(callbacks, "callbacks");
            this.schema = schema;
            this.callbacks = callbacks;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public void onCreate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            this.schema.create(new AndroidSqliteDriver((SupportSQLiteOpenHelper) null, db, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public void onUpgrade(SupportSQLiteDatabase db, int oldVersion, int newVersion) {
            Intrinsics.checkNotNullParameter(db, "db");
            int i = 1;
            SupportSQLiteOpenHelper supportSQLiteOpenHelper = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            if (!(this.callbacks.length == 0)) {
                SqlDriver.Schema schema = this.schema;
                AndroidSqliteDriver androidSqliteDriver = new AndroidSqliteDriver(supportSQLiteOpenHelper, db, i, (DefaultConstructorMarker) (objArr3 == true ? 1 : 0));
                AfterVersionWithDriver[] afterVersionWithDriverArr = this.callbacks;
                SqlDriverKt.migrateWithCallbacks(schema, androidSqliteDriver, oldVersion, newVersion, (AfterVersionWithDriver[]) Arrays.copyOf(afterVersionWithDriverArr, afterVersionWithDriverArr.length));
                return;
            }
            this.schema.migrate(new AndroidSqliteDriver((SupportSQLiteOpenHelper) (objArr2 == true ? 1 : 0), db, i, (DefaultConstructorMarker) (objArr == true ? 1 : 0)), oldVersion, newVersion);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Callback(SqlDriver.Schema schema) {
            Intrinsics.checkNotNullParameter(schema, "schema");
            AfterVersionWithDriver[] afterVersionWithDriverArr = new AfterVersionWithDriver[0];
            this(schema, (AfterVersionWithDriver[]) Arrays.copyOf(afterVersionWithDriverArr, afterVersionWithDriverArr.length));
        }

        public Callback(SqlDriver.Schema schema, AfterVersion... callbacks) {
            Intrinsics.checkNotNullParameter(schema, "schema");
            Intrinsics.checkNotNullParameter(callbacks, "callbacks");
            ArrayList arrayList = new ArrayList(callbacks.length);
            for (AfterVersion afterVersion : callbacks) {
                arrayList.add(SqlDriverKt.toAfterVersionWithDriver(afterVersion));
            }
            Object[] array = arrayList.toArray(new AfterVersionWithDriver[0]);
            if (array != null) {
                AfterVersionWithDriver[] afterVersionWithDriverArr = (AfterVersionWithDriver[]) array;
                this(schema, (AfterVersionWithDriver[]) Arrays.copyOf(afterVersionWithDriverArr, afterVersionWithDriverArr.length));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }
}
