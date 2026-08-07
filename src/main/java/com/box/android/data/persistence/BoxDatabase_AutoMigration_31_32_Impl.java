package com.box.android.data.persistence;

import androidx.room.migration.Migration;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxDatabase_AutoMigration_31_32_Impl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/box/android/data/persistence/BoxDatabase_AutoMigration_31_32_Impl;", "Landroidx/room/migration/Migration;", "<init>", "()V", "migrate", "", "connection", "Landroidx/sqlite/SQLiteConnection;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxDatabase_AutoMigration_31_32_Impl extends Migration {
    public BoxDatabase_AutoMigration_31_32_Impl() {
        super(31, 32);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SQLiteConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `_new_annotations` (`annotation_id` TEXT NOT NULL, `file_version_id` TEXT NOT NULL, `file_version_number` INTEGER NOT NULL, `created_at` INTEGER NOT NULL, `created_by_json_data` BLOB NOT NULL, `modified_at` INTEGER NOT NULL, `modified_by_json_data` BLOB NOT NULL, `description_json_data` BLOB NOT NULL, `location_json_data` BLOB NOT NULL, `target_json_data` BLOB NOT NULL, `permissions_json_data` BLOB NOT NULL, `network_fetched_at` INTEGER NOT NULL, `total_reply_count` INTEGER NOT NULL DEFAULT 0, `status` TEXT NOT NULL DEFAULT 'open', PRIMARY KEY(`annotation_id`))");
        SQLite.execSQL(connection, "INSERT INTO `_new_annotations` (`annotation_id`,`file_version_id`,`file_version_number`,`created_at`,`created_by_json_data`,`modified_at`,`modified_by_json_data`,`description_json_data`,`location_json_data`,`target_json_data`,`permissions_json_data`,`network_fetched_at`,`total_reply_count`,`status`) SELECT `annotation_id`,`file_version_id`,`file_version_number`,`created_at`,`created_by_json_data`,`modified_at`,`modified_by_json_data`,`description_json_data`,`location_json_data`,`target_json_data`,`permissions_json_data`,`network_fetched_at`,`total_reply_count`,`status` FROM `annotations`");
        SQLite.execSQL(connection, "DROP TABLE `annotations`");
        SQLite.execSQL(connection, "ALTER TABLE `_new_annotations` RENAME TO `annotations`");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_annotations_file_version_id` ON `annotations` (`file_version_id`)");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_annotations_network_fetched_at` ON `annotations` (`network_fetched_at`)");
    }
}
