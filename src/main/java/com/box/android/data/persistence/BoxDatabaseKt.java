package com.box.android.data.persistence;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxDatabase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b9\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003\"\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0003\"\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0003\"\u0011\u0010\u000e\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0003\"\u0011\u0010\u0010\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0003\"\u0011\u0010\u0012\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0003\"\u0011\u0010\u0014\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0003\"\u0011\u0010\u0016\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0003\"\u0011\u0010\u0018\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0003\"\u0011\u0010\u001a\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0003\"\u0011\u0010\u001c\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0003\"\u0011\u0010\u001e\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0003\"\u0011\u0010 \u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0003\"\u0011\u0010\"\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0003\"\u0011\u0010$\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0003\"\u0011\u0010&\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0003\"\u0011\u0010(\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0003\"\u0011\u0010*\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0003\"\u0011\u0010,\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0003\"\u0011\u0010.\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0003\"\u0011\u00100\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0003\"\u0011\u00102\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0003\"\u0011\u00104\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0003\"\u0011\u00106\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0003\"\u0011\u00108\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0003¨\u0006:"}, d2 = {"MIGRATION_1_2", "Landroidx/room/migration/Migration;", "getMIGRATION_1_2", "()Landroidx/room/migration/Migration;", "MIGRATION_2_3", "getMIGRATION_2_3", "MIGRATION_3_4", "getMIGRATION_3_4", "MIGRATION_4_5", "getMIGRATION_4_5", "MIGRATION_5_6", "getMIGRATION_5_6", "MIGRATION_6_7", "getMIGRATION_6_7", "MIGRATION_7_8", "getMIGRATION_7_8", "MIGRATION_8_9", "getMIGRATION_8_9", "MIGRATION_9_10", "getMIGRATION_9_10", "MIGRATION_10_11", "getMIGRATION_10_11", "MIGRATION_11_12", "getMIGRATION_11_12", "MIGRATION_12_13", "getMIGRATION_12_13", "MIGRATION_13_14", "getMIGRATION_13_14", "MIGRATION_14_15", "getMIGRATION_14_15", "MIGRATION_15_16", "getMIGRATION_15_16", "MIGRATION_16_17", "getMIGRATION_16_17", "MIGRATION_17_18", "getMIGRATION_17_18", "MIGRATION_18_19", "getMIGRATION_18_19", "MIGRATION_19_20", "getMIGRATION_19_20", "MIGRATION_20_21", "getMIGRATION_20_21", "MIGRATION_21_22", "getMIGRATION_21_22", "MIGRATION_22_23", "getMIGRATION_22_23", "MIGRATION_23_24", "getMIGRATION_23_24", "MIGRATION_24_25", "getMIGRATION_24_25", "MIGRATION_25_26", "getMIGRATION_25_26", "MIGRATION_34_35", "getMIGRATION_34_35", "MIGRATION_37_38", "getMIGRATION_37_38", "MIGRATION_39_40", "getMIGRATION_39_40", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxDatabaseKt {
    private static final Migration MIGRATION_1_2 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_1_2$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `annotations` (`annotation_id` TEXT NOT NULL, `file_version_id` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `created_by_json_data` BLOB NOT NULL, `modified_at` INTEGER NOT NULL, `modified_by_json_data` BLOB NOT NULL, `description_json_data` BLOB, `location_json_data` BLOB NOT NULL, `target_json_data` BLOB NOT NULL, `permissions_json_data` BLOB NOT NULL, `network_fetched_at` INTEGER NOT NULL, PRIMARY KEY(`annotation_id`))");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_annotations_file_version_id` ON `annotations` (`file_version_id`)");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_annotations_network_fetched_at` ON `annotations` (`network_fetched_at`)");
        }
    };
    private static final Migration MIGRATION_2_3 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_2_3$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `comments` (`comment_id` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `file_id` TEXT NOT NULL, `is_reply` INTEGER NOT NULL, `json_data` BLOB NOT NULL, `network_fetched_at` INTEGER NOT NULL, PRIMARY KEY(`comment_id`))");
            database.execSQL("CREATE TABLE IF NOT EXISTS `file_activity` (`activity_id` TEXT NOT NULL, `type` TEXT NOT NULL, `file_id` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `network_fetched_at` INTEGER NOT NULL, PRIMARY KEY(`activity_id`))");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_file_activity_file_id_network_fetched_at` ON `file_activity` (`file_id`, `network_fetched_at`)");
            database.execSQL("CREATE TABLE IF NOT EXISTS `grouped_file_versions` (`start_id` TEXT NOT NULL, `end_id` TEXT NOT NULL, `file_id` TEXT NOT NULL, `created_by_json_data` BLOB NOT NULL, `network_fetched_at` INTEGER NOT NULL, PRIMARY KEY(`start_id`))");
            database.execSQL("CREATE TABLE IF NOT EXISTS `file_versions` (`version_id` TEXT NOT NULL, `file_id` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `number` INTEGER NOT NULL, `network_fetched_at` INTEGER NOT NULL, PRIMARY KEY(`version_id`))");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_file_versions_file_id_created_at` ON `file_versions` (`file_id`, `created_at`)");
        }
    };
    private static final Migration MIGRATION_3_4 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_3_4$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("DROP TABLE annotations");
            database.execSQL("CREATE TABLE IF NOT EXISTS `annotations` (`annotation_id` TEXT NOT NULL, `file_version_id` TEXT NOT NULL, `file_version_number` INTEGER NOT NULL,`created_at` INTEGER NOT NULL, `created_by_json_data` BLOB NOT NULL, `modified_at` INTEGER NOT NULL, `modified_by_json_data` BLOB NOT NULL, `description_json_data` BLOB, `location_json_data` BLOB NOT NULL, `target_json_data` BLOB NOT NULL, `permissions_json_data` BLOB NOT NULL, `network_fetched_at` INTEGER NOT NULL, PRIMARY KEY(`annotation_id`))");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_annotations_file_version_id` ON `annotations` (`file_version_id`)");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_annotations_network_fetched_at` ON `annotations` (`network_fetched_at`)");
        }
    };
    private static final Migration MIGRATION_4_5 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_4_5$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("DROP TABLE comments");
            database.execSQL("CREATE TABLE IF NOT EXISTS `comments` (`comment_id` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `file_id` TEXT NOT NULL, `json_data` BLOB NOT NULL, `network_fetched_at` INTEGER NOT NULL, PRIMARY KEY(`comment_id`))");
        }
    };
    private static final Migration MIGRATION_5_6 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_5_6$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `collectionItemsFetched` (`collection_id` TEXT NOT NULL, `network_fetched_at` INTEGER NOT NULL, PRIMARY KEY(`collection_id`))");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_collectionItemsFetched_network_fetched_at` ON `collectionItemsFetched` (`network_fetched_at`)");
        }
    };
    private static final Migration MIGRATION_6_7 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_6_7$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `metricsLogs` (`event_type` TEXT NOT NULL, `user_id` TEXT NOT NULL, `az_name` TEXT NOT NULL, `enterprise_id` TEXT NOT NULL, `message` TEXT NOT NULL, `formattedmessage` TEXT NOT NULL, `method_file` TEXT NOT NULL, `method_name` TEXT NOT NULL, `method_line` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `app_version` TEXT NOT NULL, `api_key` TEXT NOT NULL, `human_readable_device_model` TEXT, `os` TEXT, `category` TEXT NOT NULL, `platform` TEXT NOT NULL, PRIMARY KEY(`timestamp`))");
        }
    };
    private static final Migration MIGRATION_7_8 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_7_8$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("ALTER TABLE metricsLogs ADD COLUMN status TEXT");
            database.execSQL("ALTER TABLE metricsLogs ADD COLUMN duration INTEGER");
        }
    };
    private static final Migration MIGRATION_8_9 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_8_9$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `captureHistory` (`file_id` TEXT NOT NULL, 'last_updated' INTEGER NOT NULL, PRIMARY KEY(`file_id`))");
        }
    };
    private static final Migration MIGRATION_9_10 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_9_10$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `scanned_document_pages` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `original_file` TEXT NOT NULL, `enhanced_file` TEXT NOT NULL, `filter_type` TEXT NOT NULL, `quad_x1` REAL, `quad_y1` REAL, `quad_x2` REAL, `quad_y2` REAL, `quad_x3` REAL, `quad_y3` REAL, `quad_x4` REAL, `quad_y4` REAL, `distortion_correction` INTEGER NOT NULL, `version` INTEGER NOT NULL,`created_at` INTEGER NOT NULL) ");
        }
    };
    private static final Migration MIGRATION_10_11 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_10_11$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `job` (`id` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `job_type` TEXT NOT NULL, `input_data` BLOB NOT NULL, `start_date` INTEGER, `earliest_start_date` INTEGER NOT NULL, `status` TEXT NOT NULL, `auto_retry_count` INTEGER NOT NULL,`running_info` BLOB,`error_info` BLOB,PRIMARY KEY(`id`))");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_job_status` ON `job` (`status`)");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_job_created_at` ON `job` (`created_at`)");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_job_status_created_at` ON `job` (`status`, `created_at`)");
            database.execSQL("CREATE TABLE IF NOT EXISTS `job_dependency` (`successor` TEXT NOT NULL, `predecessor` TEXT NOT NULL, PRIMARY KEY(`successor`, `predecessor`), FOREIGN KEY(`successor`) REFERENCES `job`(`id`) ON DELETE CASCADE, FOREIGN KEY(`predecessor`) REFERENCES `job`(`id`) ON DELETE CASCADE)");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_job_dependency_predecessor` ON `job_dependency` (`predecessor`)");
            database.execSQL("CREATE TABLE IF NOT EXISTS `job_id_to_work_id` (`job_id` TEXT NOT NULL, `work_id` TEXT NOT NULL, PRIMARY KEY(`job_id`, `work_id`), FOREIGN KEY(`job_id`) REFERENCES `job`(`id`) ON DELETE CASCADE)");
            database.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_job_id_to_work_id_work_id` ON `job_id_to_work_id` (`work_id`)");
            database.execSQL("CREATE TABLE IF NOT EXISTS `local_item` (`local_id` TEXT NOT NULL, `type` TEXT NOT NULL, `content_url` TEXT, `name` TEXT NOT NULL, `parent_id` TEXT NOT NULL, `created_at` INTEGER NOT NULL, PRIMARY KEY(`local_id`, `type`))");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_local_item_parent_id_name` ON `local_item` (`parent_id`, `name`)");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_local_item_parent_id_created_at` ON `local_item` (`parent_id`, `created_at`)");
            database.execSQL("CREATE TABLE IF NOT EXISTS `local_id_to_server_id` (`local_id` TEXT NOT NULL, `type` TEXT NOT NULL, `server_id` TEXT NOT NULL, PRIMARY KEY(`local_id`, `type`), FOREIGN KEY(`local_id`, `type`) REFERENCES `local_item`(`local_id`, `type`) ON DELETE CASCADE)");
            database.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_local_id_to_server_id_type_server_id` ON `local_id_to_server_id` (`type`, `server_id`)");
            database.execSQL("CREATE TABLE IF NOT EXISTS `job_to_tag` (`tag` TEXT NOT NULL, `job_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `job_id`), FOREIGN KEY(`job_id`) REFERENCES `job`(`id`) ON DELETE CASCADE)");
        }
    };
    private static final Migration MIGRATION_11_12 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_11_12$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("ALTER TABLE `scanned_document_pages` ADD COLUMN rotation_angle INTEGER NOT NULL DEFAULT 0");
        }
    };
    private static final Migration MIGRATION_12_13 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_12_13$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `new_local_item` (`local_id` TEXT NOT NULL, `type` TEXT NOT NULL, `content_url` TEXT, `name` TEXT NOT NULL, `parent_id` TEXT, `created_at` INTEGER NOT NULL, `content_modified_at` INTEGER, PRIMARY KEY(`local_id`))");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_new_local_item_parent_id_name` ON `new_local_item` (`parent_id`, `name`)");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_new_local_item_parent_id_created_at` ON `new_local_item` (`parent_id`, `created_at`)");
            database.execSQL("INSERT INTO `new_local_item` (local_id, type, content_url, name, parent_id, created_at) SELECT local_id, type, content_url, name, parent_id, created_at FROM local_item");
            database.execSQL("DROP TABLE `local_item`");
            database.execSQL("ALTER TABLE `new_local_item` RENAME TO `local_item`");
            database.execSQL("CREATE TABLE IF NOT EXISTS `new_local_id_to_server_id` (`local_id` TEXT NOT NULL, `type` TEXT NOT NULL, `server_id` TEXT NOT NULL, PRIMARY KEY(`local_id`), FOREIGN KEY(`local_id`) REFERENCES `local_item`(`local_id`) ON DELETE CASCADE)");
            database.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_new_local_id_to_server_id_type_server_id` ON `new_local_id_to_server_id` (`type`, `server_id`)");
            database.execSQL("INSERT INTO `new_local_id_to_server_id` (local_id, type, server_id) SELECT local_id, type, server_id FROM local_id_to_server_id");
            database.execSQL("DROP TABLE `local_id_to_server_id`");
            database.execSQL("ALTER TABLE `new_local_id_to_server_id` RENAME TO `local_id_to_server_id`");
        }
    };
    private static final Migration MIGRATION_13_14 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_13_14$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("DROP TABLE `captureHistory`");
            database.execSQL("CREATE TABLE IF NOT EXISTS `captureHistory` (`local_item_id` TEXT NOT NULL, 'last_updated' INTEGER NOT NULL, PRIMARY KEY(`local_item_id`))");
        }
    };
    private static final Migration MIGRATION_14_15 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_14_15$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("DROP TABLE `captureHistory`");
            database.execSQL("CREATE TABLE IF NOT EXISTS `captureHistory` (`local_item_id` TEXT NOT NULL, 'last_updated' INTEGER NOT NULL, PRIMARY KEY(`local_item_id`), FOREIGN KEY(`local_item_id`) REFERENCES `local_item`(`local_id`) ON DELETE CASCADE)");
        }
    };
    private static final Migration MIGRATION_15_16 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_15_16$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("DROP TABLE `job`");
            database.execSQL("CREATE TABLE IF NOT EXISTS `job` (`id` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `job_type` TEXT NOT NULL, `input_data` BLOB NOT NULL, `start_date` INTEGER, `earliest_start_date` INTEGER NOT NULL, `status` TEXT NOT NULL, `auto_retry_count` INTEGER NOT NULL,`running_info` BLOB,`error_info` TEXT,PRIMARY KEY(`id`))");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_job_status` ON `job` (`status`)");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_job_created_at` ON `job` (`created_at`)");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_job_status_created_at` ON `job` (`status`, `created_at`)");
        }
    };
    private static final Migration MIGRATION_16_17 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_16_17$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("DROP TABLE `captureHistory`");
            database.execSQL("CREATE TABLE IF NOT EXISTS `captureHistory` (`local_item_id` TEXT NOT NULL, 'last_updated' INTEGER NOT NULL, 'content_created_at' INTEGER NOT NULL, PRIMARY KEY(`local_item_id`), FOREIGN KEY(`local_item_id`) REFERENCES `local_item`(`local_id`) ON DELETE CASCADE)");
        }
    };
    private static final Migration MIGRATION_17_18 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_17_18$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `metricsLogsTmp` (`id` INTEGER NOT NULL, `event_type` TEXT NOT NULL, `user_id` TEXT NOT NULL, `az_name` TEXT NOT NULL, `enterprise_id` TEXT NOT NULL, `message` TEXT, `formattedmessage` TEXT, `method_file` TEXT, `method_name` TEXT, `method_line` INTEGER, `timestamp` INTEGER NOT NULL, `app_version` TEXT NOT NULL, `api_key` TEXT NOT NULL, `human_readable_device_model` TEXT, `os` TEXT, `category` TEXT NOT NULL, `platform` TEXT NOT NULL, `status` TEXT, `duration` INTEGER, `type` TEXT, `failed` INTEGER, `value` TEXT, `fail_reason` TEXT, `error_code` INTEGER, `size` REAL, PRIMARY KEY(`id`))");
            database.execSQL("INSERT INTO metricsLogsTmp(event_type, user_id, az_name, enterprise_id, message, formattedmessage, method_file, method_name, method_line, timestamp, app_version, api_key, human_readable_device_model, os, category, platform, status, duration) SELECT event_type, user_id, az_name, enterprise_id, message, formattedmessage, method_file, method_name, method_line, timestamp, app_version, api_key, human_readable_device_model, os, category, platform, status, duration FROM metricsLogs");
            database.execSQL("DROP TABLE metricsLogs");
            database.execSQL("ALTER TABLE metricsLogsTmp RENAME TO metricsLogs");
        }
    };
    private static final Migration MIGRATION_18_19 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_18_19$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("ALTER TABLE metricsLogs ADD COLUMN file_id TEXT");
            database.execSQL("ALTER TABLE metricsLogs ADD COLUMN count INTEGER NOT NULL DEFAULT 1");
        }
    };
    private static final Migration MIGRATION_19_20 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_19_20$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("ALTER TABLE metricsLogs ADD COLUMN folder_id TEXT");
        }
    };
    private static final Migration MIGRATION_20_21 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_20_21$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("ALTER TABLE metricsLogs ADD COLUMN job TEXT");
            database.execSQL("ALTER TABLE metricsLogs ADD COLUMN code TEXT");
        }
    };
    private static final Migration MIGRATION_21_22 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_21_22$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("DROP TABLE metricsLogs");
            database.execSQL("CREATE TABLE IF NOT EXISTS `metricsLogs` (`id` INTEGER NOT NULL, `event_type` TEXT NOT NULL, `user_id` TEXT NOT NULL, `az_name` TEXT NOT NULL, `enterprise_id` TEXT NOT NULL, `message` TEXT, `formattedmessage` TEXT, `method_file` TEXT, `method_name` TEXT, `method_line` INTEGER, `timestamp` INTEGER NOT NULL, `app_version` TEXT NOT NULL, `api_key` TEXT NOT NULL, `human_readable_device_model` TEXT, `os` TEXT, `category` TEXT NOT NULL, `platform` TEXT NOT NULL, `status` TEXT, `duration` INTEGER, `type` TEXT, `failed` INTEGER, `value` TEXT, `fail_reason` TEXT, `error_code` INTEGER, `size_raw` REAL, `size` TEXT,`file_id` TEXT,`count` INTEGER NOT NULL,`folder_id` TEXT,`job` TEXT,`code` TEXT,PRIMARY KEY(`id`))");
        }
    };
    private static final Migration MIGRATION_22_23 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_22_23$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("DROP TABLE metricsLogs");
            database.execSQL("CREATE TABLE IF NOT EXISTS `metricsLogs` (`id` INTEGER NOT NULL, `event_type` TEXT NOT NULL, `user_id` TEXT NOT NULL, `az_name` TEXT NOT NULL, `enterprise_id` TEXT NOT NULL, `message` TEXT, `formattedmessage` TEXT, `method_file` TEXT, `method_name` TEXT, `method_line` INTEGER, `timestamp` INTEGER NOT NULL, `app_version` TEXT NOT NULL, `api_key` TEXT NOT NULL, `human_readable_device_model` TEXT, `os` TEXT, `category` TEXT NOT NULL, `platform` TEXT NOT NULL, `status` TEXT, `duration` INTEGER, `type` TEXT, `failed` INTEGER, `value` TEXT, `fail_reason` TEXT, `error_code` INTEGER, `size_raw` REAL, `size` TEXT,`is_recoverable` INTEGER,`job_manager_version` TEXT,`num_of_automatic_retries` INTEGER,`num_of_manual_retries` INTEGER,`file_id` TEXT,`count` INTEGER NOT NULL,`folder_id` TEXT,`job` TEXT,`code` TEXT,PRIMARY KEY(`id`))");
            database.execSQL("ALTER TABLE job ADD COLUMN manual_retry_count INTEGER NOT NULL DEFAULT 0");
        }
    };
    private static final Migration MIGRATION_23_24 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_23_24$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("ALTER TABLE metricsLogs ADD COLUMN num_items INTEGER");
        }
    };
    private static final Migration MIGRATION_24_25 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_24_25$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("DROP TABLE collections");
            database.execSQL("DROP TABLE collectionItemRelations");
            database.execSQL("DROP TABLE collectionItemsFetched");
        }
    };
    private static final Migration MIGRATION_25_26 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_25_26$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("ALTER TABLE job ADD COLUMN parentID TEXT");
            database.execSQL("ALTER TABLE job ADD COLUMN rootID TEXT NOT NULL DEFAULT ''");
            database.execSQL("ALTER TABLE job ADD COLUMN sortKey TEXT NOT NULL DEFAULT ''");
            database.execSQL("CREATE INDEX IF NOT EXISTS index_job_sortKey ON job (sortKey)");
            database.execSQL("UPDATE job SET sortKey = (created_at || id) where sortKey = ''");
            database.execSQL("UPDATE job SET rootID = id where rootID = ''");
            database.execSQL("CREATE INDEX IF NOT EXISTS index_job_to_tag_job_id ON job_to_tag (job_id)");
            database.execSQL("CREATE INDEX IF NOT EXISTS index_job_to_tag_tag ON job_to_tag (tag)");
            database.execSQL("CREATE INDEX IF NOT EXISTS index_job_dependency_successor ON job_dependency (successor)");
        }
    };
    private static final Migration MIGRATION_34_35 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_34_35$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("DROP TABLE metricsLogs");
        }
    };
    private static final Migration MIGRATION_37_38 = new BoxDatabaseKt$MIGRATION_37_38$1();
    private static final Migration MIGRATION_39_40 = new Migration() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_39_40$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `inbox_notifications` (`notification_id` TEXT NOT NULL, `type` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `is_seen` INTEGER NOT NULL, `is_read` INTEGER NOT NULL, `json_data` BLOB NOT NULL, `network_fetched_at` INTEGER NOT NULL, `source` TEXT NOT NULL, PRIMARY KEY(`notification_id`))");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_inbox_notifications_created_at` ON `inbox_notifications` (`created_at`)");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_inbox_notifications_is_seen` ON `inbox_notifications` (`is_seen`)");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_inbox_notifications_is_read` ON `inbox_notifications` (`is_read`)");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_inbox_notifications_network_fetched_at` ON `inbox_notifications` (`network_fetched_at`)");
        }
    };

    public static final Migration getMIGRATION_1_2() {
        return MIGRATION_1_2;
    }

    public static final Migration getMIGRATION_2_3() {
        return MIGRATION_2_3;
    }

    public static final Migration getMIGRATION_3_4() {
        return MIGRATION_3_4;
    }

    public static final Migration getMIGRATION_4_5() {
        return MIGRATION_4_5;
    }

    public static final Migration getMIGRATION_5_6() {
        return MIGRATION_5_6;
    }

    public static final Migration getMIGRATION_6_7() {
        return MIGRATION_6_7;
    }

    public static final Migration getMIGRATION_7_8() {
        return MIGRATION_7_8;
    }

    public static final Migration getMIGRATION_8_9() {
        return MIGRATION_8_9;
    }

    public static final Migration getMIGRATION_9_10() {
        return MIGRATION_9_10;
    }

    public static final Migration getMIGRATION_10_11() {
        return MIGRATION_10_11;
    }

    public static final Migration getMIGRATION_11_12() {
        return MIGRATION_11_12;
    }

    public static final Migration getMIGRATION_12_13() {
        return MIGRATION_12_13;
    }

    public static final Migration getMIGRATION_13_14() {
        return MIGRATION_13_14;
    }

    public static final Migration getMIGRATION_14_15() {
        return MIGRATION_14_15;
    }

    public static final Migration getMIGRATION_15_16() {
        return MIGRATION_15_16;
    }

    public static final Migration getMIGRATION_16_17() {
        return MIGRATION_16_17;
    }

    public static final Migration getMIGRATION_17_18() {
        return MIGRATION_17_18;
    }

    public static final Migration getMIGRATION_18_19() {
        return MIGRATION_18_19;
    }

    public static final Migration getMIGRATION_19_20() {
        return MIGRATION_19_20;
    }

    public static final Migration getMIGRATION_20_21() {
        return MIGRATION_20_21;
    }

    public static final Migration getMIGRATION_21_22() {
        return MIGRATION_21_22;
    }

    public static final Migration getMIGRATION_22_23() {
        return MIGRATION_22_23;
    }

    public static final Migration getMIGRATION_23_24() {
        return MIGRATION_23_24;
    }

    public static final Migration getMIGRATION_24_25() {
        return MIGRATION_24_25;
    }

    public static final Migration getMIGRATION_25_26() {
        return MIGRATION_25_26;
    }

    public static final Migration getMIGRATION_34_35() {
        return MIGRATION_34_35;
    }

    public static final Migration getMIGRATION_37_38() {
        return MIGRATION_37_38;
    }

    public static final Migration getMIGRATION_39_40() {
        return MIGRATION_39_40;
    }
}
