package com.box.android.data.persistence;

import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxDatabase_AutoMigration_26_27_Impl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/box/android/data/persistence/BoxDatabase_AutoMigration_26_27_Impl;", "Landroidx/room/migration/Migration;", "<init>", "()V", "migrate", "", "connection", "Landroidx/sqlite/SQLiteConnection;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxDatabase_AutoMigration_26_27_Impl extends Migration {
    public BoxDatabase_AutoMigration_26_27_Impl() {
        super(26, 27);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SQLiteConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `_new_job` (`id` TEXT NOT NULL, `job_type` TEXT NOT NULL, `input_data` BLOB NOT NULL, `status` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `start_date` INTEGER, `earliest_start_date` INTEGER NOT NULL, `auto_retry_count` INTEGER NOT NULL, `manual_retry_count` INTEGER NOT NULL, `running_info` BLOB, `error_info` TEXT, `parentID` TEXT, `rootID` TEXT NOT NULL, `sortKey` TEXT NOT NULL DEFAULT '', `log_data` BLOB, PRIMARY KEY(`id`), FOREIGN KEY(`rootID`) REFERENCES `job`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`parentID`) REFERENCES `job`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        SQLite.execSQL(connection, "INSERT INTO `_new_job` (`id`,`job_type`,`input_data`,`status`,`created_at`,`start_date`,`earliest_start_date`,`auto_retry_count`,`manual_retry_count`,`running_info`,`error_info`,`parentID`,`rootID`,`sortKey`) SELECT `id`,`job_type`,`input_data`,`status`,`created_at`,`start_date`,`earliest_start_date`,`auto_retry_count`,`manual_retry_count`,`running_info`,`error_info`,`parentID`,`rootID`,`sortKey` FROM `job`");
        SQLite.execSQL(connection, "DROP TABLE `job`");
        SQLite.execSQL(connection, "ALTER TABLE `_new_job` RENAME TO `job`");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_job_status` ON `job` (`status`)");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_job_created_at` ON `job` (`created_at`)");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_job_status_created_at` ON `job` (`status`, `created_at`)");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_job_sortKey` ON `job` (`sortKey`)");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_job_parentID` ON `job` (`parentID`)");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_job_rootID` ON `job` (`rootID`)");
        DBUtil.foreignKeyCheck(connection, "job");
    }
}
