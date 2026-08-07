package com.box.android.data.persistence;

import androidx.room.migration.Migration;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxDatabase_AutoMigration_30_31_Impl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/box/android/data/persistence/BoxDatabase_AutoMigration_30_31_Impl;", "Landroidx/room/migration/Migration;", "<init>", "()V", "migrate", "", "connection", "Landroidx/sqlite/SQLiteConnection;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxDatabase_AutoMigration_30_31_Impl extends Migration {
    public BoxDatabase_AutoMigration_30_31_Impl() {
        super(30, 31);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SQLiteConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        SQLite.execSQL(connection, "ALTER TABLE `annotations` ADD COLUMN `total_reply_count` INTEGER NOT NULL DEFAULT 0");
        SQLite.execSQL(connection, "ALTER TABLE `annotations` ADD COLUMN `status` TEXT NOT NULL DEFAULT 'open'");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `_new_comments` (`comment_id` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `file_id` TEXT NOT NULL, `json_data` BLOB NOT NULL, `network_fetched_at` INTEGER NOT NULL, `total_reply_count` INTEGER NOT NULL DEFAULT 0, `status` TEXT NOT NULL DEFAULT 'open', `parent_id` TEXT, PRIMARY KEY(`comment_id`))");
        SQLite.execSQL(connection, "INSERT INTO `_new_comments` (`comment_id`,`created_at`,`file_id`,`json_data`,`network_fetched_at`) SELECT `comment_id`,`created_at`,`file_id`,`json_data`,`network_fetched_at` FROM `comments`");
        SQLite.execSQL(connection, "DROP TABLE `comments`");
        SQLite.execSQL(connection, "ALTER TABLE `_new_comments` RENAME TO `comments`");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_comments_parent_id` ON `comments` (`parent_id`)");
    }
}
