package com.box.android.data.persistence;

import androidx.room.migration.Migration;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxDatabase_AutoMigration_38_39_Impl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/box/android/data/persistence/BoxDatabase_AutoMigration_38_39_Impl;", "Landroidx/room/migration/Migration;", "<init>", "()V", "migrate", "", "connection", "Landroidx/sqlite/SQLiteConnection;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxDatabase_AutoMigration_38_39_Impl extends Migration {
    public BoxDatabase_AutoMigration_38_39_Impl() {
        super(38, 39);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SQLiteConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `offline_state` (`item_id` TEXT NOT NULL, `item_type` TEXT NOT NULL, `is_user_saved` INTEGER NOT NULL, `is_user_removed` INTEGER NOT NULL, `started_date` INTEGER, `completed_date` INTEGER, `sha1` TEXT, PRIMARY KEY(`item_id`, `item_type`))");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_offline_state_is_user_saved` ON `offline_state` (`is_user_saved`)");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_offline_state_item_type` ON `offline_state` (`item_type`)");
    }
}
