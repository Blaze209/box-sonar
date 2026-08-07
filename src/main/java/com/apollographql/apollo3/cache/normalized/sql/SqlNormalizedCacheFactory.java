package com.apollographql.apollo3.cache.normalized.sql;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.apollographql.apollo3.cache.normalized.api.NormalizedCacheFactory;
import com.apollographql.apollo3.cache.normalized.sql.internal.FactoryHelpersKt;
import com.apollographql.apollo3.cache.normalized.sql.internal.FactoryImplementationsKt;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.squareup.sqldelight.android.AndroidSqliteDriver;
import com.squareup.sqldelight.db.SqlDriver;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SqlNormalizedCacheFactory.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B/\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u0013\b\u0016\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bB\r\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/sql/SqlNormalizedCacheFactory;", "Lcom/apollographql/apollo3/cache/normalized/api/NormalizedCacheFactory;", "context", "Landroid/content/Context;", "name", "", "factory", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "useNoBackupDirectory", "", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Z)V", "(Ljava/lang/String;)V", "driver", "Lcom/squareup/sqldelight/db/SqlDriver;", "(Lcom/squareup/sqldelight/db/SqlDriver;)V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/apollographql/apollo3/cache/normalized/sql/SqlNormalizedCache;", "apollo-normalized-cache-sqlite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SqlNormalizedCacheFactory extends NormalizedCacheFactory {
    private final SqlDriver driver;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SqlNormalizedCacheFactory(Context context) {
        this(context, null, null, false, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SqlNormalizedCacheFactory(Context context, String str) {
        this(context, str, null, false, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SqlNormalizedCacheFactory(Context context, String str, SupportSQLiteOpenHelper.Factory factory) {
        this(context, str, factory, false, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(factory, "factory");
    }

    public SqlNormalizedCacheFactory(SqlDriver driver) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        this.driver = driver;
    }

    public /* synthetic */ SqlNormalizedCacheFactory(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "apollo.db" : str);
    }

    public /* synthetic */ SqlNormalizedCacheFactory(Context context, String str, FrameworkSQLiteOpenHelperFactory frameworkSQLiteOpenHelperFactory, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? "apollo.db" : str, (i & 4) != 0 ? new FrameworkSQLiteOpenHelperFactory() : frameworkSQLiteOpenHelperFactory, (i & 8) != 0 ? false : z);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SqlNormalizedCacheFactory(Context context, String str, SupportSQLiteOpenHelper.Factory factory, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(factory, "factory");
        SqlDriver.Schema schema = FactoryHelpersKt.getSchema();
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this(new AndroidSqliteDriver(schema, applicationContext, str, factory, null, 0, z, 48, null));
    }

    public SqlNormalizedCacheFactory(String str) {
        this(FactoryImplementationsKt.createDriver(str, null, FactoryHelpersKt.getSchema()));
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.NormalizedCacheFactory
    public SqlNormalizedCache create() {
        return new SqlNormalizedCache(FactoryHelpersKt.createRecordDatabase(this.driver));
    }
}
