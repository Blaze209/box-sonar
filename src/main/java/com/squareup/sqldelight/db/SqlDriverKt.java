package com.squareup.sqldelight.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SqlDriver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n¢\u0006\u0002\u0010\u000b\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\t\"\u00020\f¢\u0006\u0002\u0010\r\u001a\n\u0010\u000e\u001a\u00020\f*\u00020\n¨\u0006\u000f"}, d2 = {"migrateWithCallbacks", "", "Lcom/squareup/sqldelight/db/SqlDriver$Schema;", "driver", "Lcom/squareup/sqldelight/db/SqlDriver;", "oldVersion", "", "newVersion", "callbacks", "", "Lcom/squareup/sqldelight/db/AfterVersion;", "(Lcom/squareup/sqldelight/db/SqlDriver$Schema;Lcom/squareup/sqldelight/db/SqlDriver;II[Lcom/squareup/sqldelight/db/AfterVersion;)V", "Lcom/squareup/sqldelight/db/AfterVersionWithDriver;", "(Lcom/squareup/sqldelight/db/SqlDriver$Schema;Lcom/squareup/sqldelight/db/SqlDriver;II[Lcom/squareup/sqldelight/db/AfterVersionWithDriver;)V", "toAfterVersionWithDriver", "runtime"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class SqlDriverKt {
    public static final AfterVersionWithDriver toAfterVersionWithDriver(final AfterVersion afterVersion) {
        Intrinsics.checkNotNullParameter(afterVersion, "<this>");
        return new AfterVersionWithDriver(afterVersion.getAfterVersion(), new Function1<SqlDriver, Unit>() { // from class: com.squareup.sqldelight.db.SqlDriverKt.toAfterVersionWithDriver.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlDriver sqlDriver) {
                invoke2(sqlDriver);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlDriver it) {
                Intrinsics.checkNotNullParameter(it, "it");
                afterVersion.getBlock$runtime().invoke();
            }
        });
    }

    public static final void migrateWithCallbacks(SqlDriver.Schema schema, SqlDriver driver, int i, int i2, AfterVersion... callbacks) {
        Intrinsics.checkNotNullParameter(schema, "<this>");
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        ArrayList arrayList = new ArrayList(callbacks.length);
        for (AfterVersion afterVersion : callbacks) {
            arrayList.add(toAfterVersionWithDriver(afterVersion));
        }
        Object[] array = arrayList.toArray(new AfterVersionWithDriver[0]);
        if (array != null) {
            AfterVersionWithDriver[] afterVersionWithDriverArr = (AfterVersionWithDriver[]) array;
            migrateWithCallbacks(schema, driver, i, i2, (AfterVersionWithDriver[]) Arrays.copyOf(afterVersionWithDriverArr, afterVersionWithDriverArr.length));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final void migrateWithCallbacks(SqlDriver.Schema schema, SqlDriver driver, int i, int i2, AfterVersionWithDriver... callbacks) {
        Intrinsics.checkNotNullParameter(schema, "<this>");
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        ArrayList arrayList = new ArrayList();
        for (AfterVersionWithDriver afterVersionWithDriver : callbacks) {
            int afterVersion = afterVersionWithDriver.getAfterVersion();
            if (i <= afterVersion && afterVersion < i2) {
                arrayList.add(afterVersionWithDriver);
            }
        }
        for (AfterVersionWithDriver afterVersionWithDriver2 : CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.squareup.sqldelight.db.SqlDriverKt$migrateWithCallbacks$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((AfterVersionWithDriver) t).getAfterVersion()), Integer.valueOf(((AfterVersionWithDriver) t2).getAfterVersion()));
            }
        })) {
            schema.migrate(driver, i, afterVersionWithDriver2.getAfterVersion() + 1);
            afterVersionWithDriver2.getBlock$runtime().invoke(driver);
            i = afterVersionWithDriver2.getAfterVersion() + 1;
        }
        if (i < i2) {
            schema.migrate(driver, i, i2);
        }
    }
}
