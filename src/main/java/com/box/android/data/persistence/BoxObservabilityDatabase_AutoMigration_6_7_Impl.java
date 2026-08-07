package com.box.android.data.persistence;

import androidx.room.migration.Migration;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxObservabilityDatabase_AutoMigration_6_7_Impl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/box/android/data/persistence/BoxObservabilityDatabase_AutoMigration_6_7_Impl;", "Landroidx/room/migration/Migration;", "<init>", "()V", "migrate", "", "connection", "Landroidx/sqlite/SQLiteConnection;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxObservabilityDatabase_AutoMigration_6_7_Impl extends Migration {
    public BoxObservabilityDatabase_AutoMigration_6_7_Impl() {
        super(6, 7);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SQLiteConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        SQLite.execSQL(connection, "ALTER TABLE `metricsLogs` ADD COLUMN `source_tab` TEXT DEFAULT NULL");
        SQLite.execSQL(connection, "ALTER TABLE `metricsLogs` ADD COLUMN `ui_source` TEXT DEFAULT NULL");
    }
}
