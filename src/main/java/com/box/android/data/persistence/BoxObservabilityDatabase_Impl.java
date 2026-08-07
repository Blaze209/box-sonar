package com.box.android.data.persistence;

import androidx.core.provider.FontsContractCompat;
import androidx.room.InvalidationTracker;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.amplitude.api.AmplitudeClient;
import com.box.android.data.persistence.logging.MetricsDao;
import com.box.android.data.persistence.logging.MetricsDao_Impl;
import com.box.android.domain.configuration.SplitConfiguration;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: BoxObservabilityDatabase_Impl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u00100\u000eH\u0014J\u0016\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f0\u0012H\u0016J*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u001a\u0010\u0016\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f\u0012\u0004\u0012\u00020\u00130\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/persistence/BoxObservabilityDatabase_Impl;", "Lcom/box/android/data/persistence/BoxObservabilityDatabase;", "<init>", "()V", "_metricsDao", "Lkotlin/Lazy;", "Lcom/box/android/data/persistence/logging/MetricsDao;", "createOpenDelegate", "Landroidx/room/RoomOpenDelegate;", "createInvalidationTracker", "Landroidx/room/InvalidationTracker;", "clearAllTables", "", "getRequiredTypeConverterClasses", "", "Lkotlin/reflect/KClass;", "", "getRequiredAutoMigrationSpecClasses", "", "Landroidx/room/migration/AutoMigrationSpec;", "createAutoMigrations", "Landroidx/room/migration/Migration;", "autoMigrationSpecs", "metricsLogDao", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxObservabilityDatabase_Impl extends BoxObservabilityDatabase {
    private final Lazy<MetricsDao> _metricsDao = LazyKt.lazy(new Function0() { // from class: com.box.android.data.persistence.BoxObservabilityDatabase_Impl$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BoxObservabilityDatabase_Impl._metricsDao$lambda$0(this.f$0);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final MetricsDao_Impl _metricsDao$lambda$0(BoxObservabilityDatabase_Impl boxObservabilityDatabase_Impl) {
        return new MetricsDao_Impl(boxObservabilityDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.room.RoomDatabase
    public RoomOpenDelegate createOpenDelegate() {
        return new RoomOpenDelegate() { // from class: com.box.android.data.persistence.BoxObservabilityDatabase_Impl$createOpenDelegate$_openDelegate$1
            @Override // androidx.room.RoomOpenDelegate
            public void onCreate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onPostMigrate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            {
                super(7, "d95b60590b4f5829a86c9def3243159e", "3c8a1f4204c04869f763492a81183f03");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void createAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `metricsLogs` (`category` TEXT NOT NULL, `event_type` TEXT NOT NULL, `user_id` TEXT NOT NULL, `az_name` TEXT NOT NULL, `enterprise_id` TEXT NOT NULL, `message` TEXT, `formattedmessage` TEXT, `file_id` TEXT, `method_file` TEXT, `method_name` TEXT, `method_line` INTEGER, `timestamp` INTEGER NOT NULL, `app_version` TEXT NOT NULL, `api_key` TEXT NOT NULL, `human_readable_device_model` TEXT, `os` TEXT, `platform` TEXT NOT NULL, `status` TEXT, `duration` INTEGER, `num_items` INTEGER, `count` INTEGER NOT NULL, `type` TEXT, `milestone` TEXT, `subtype` TEXT, `failed` INTEGER, `value` TEXT, `is_recoverable` INTEGER, `job_manager_version` TEXT, `num_of_automatic_retries` INTEGER, `num_of_manual_retries` INTEGER, `completion_status` TEXT, `fail_reason` TEXT, `error_code` INTEGER, `size_raw` REAL, `size` TEXT, `folder_id` TEXT, `job` TEXT, `code` TEXT, `time_to_start` INTEGER, `rate` INTEGER, `total_time` INTEGER, `bytes_uploaded` INTEGER, `number_of_parallel_chunks` INTEGER, `secondary_measurement` REAL, `magnitude` REAL, `score` REAL, `is_new_version_upload` INTEGER, `is_user_triggered_job` INTEGER, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `item_state` TEXT, `source_tab` TEXT, `ui_source` TEXT)");
                SQLite.execSQL(connection, RoomMasterTable.CREATE_QUERY);
                SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'd95b60590b4f5829a86c9def3243159e')");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void dropAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `metricsLogs`");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onOpen(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                this.this$0.internalInitInvalidationTracker(connection);
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onPreMigrate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                DBUtil.dropFtsSyncTriggers(connection);
            }

            @Override // androidx.room.RoomOpenDelegate
            public RoomOpenDelegate.ValidationResult onValidateSchema(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, 1));
                linkedHashMap.put("event_type", new TableInfo.Column("event_type", "TEXT", true, 0, null, 1));
                linkedHashMap.put(AmplitudeClient.USER_ID_KEY, new TableInfo.Column(AmplitudeClient.USER_ID_KEY, "TEXT", true, 0, null, 1));
                linkedHashMap.put("az_name", new TableInfo.Column("az_name", "TEXT", true, 0, null, 1));
                linkedHashMap.put("enterprise_id", new TableInfo.Column("enterprise_id", "TEXT", true, 0, null, 1));
                linkedHashMap.put("message", new TableInfo.Column("message", "TEXT", false, 0, null, 1));
                linkedHashMap.put("formattedmessage", new TableInfo.Column("formattedmessage", "TEXT", false, 0, null, 1));
                linkedHashMap.put(FontsContractCompat.Columns.FILE_ID, new TableInfo.Column(FontsContractCompat.Columns.FILE_ID, "TEXT", false, 0, null, 1));
                linkedHashMap.put("method_file", new TableInfo.Column("method_file", "TEXT", false, 0, null, 1));
                linkedHashMap.put("method_name", new TableInfo.Column("method_name", "TEXT", false, 0, null, 1));
                linkedHashMap.put("method_line", new TableInfo.Column("method_line", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
                linkedHashMap.put(SplitConfiguration.SPLIT_ATTRIBUTE_APP_VERSION_KEY, new TableInfo.Column(SplitConfiguration.SPLIT_ATTRIBUTE_APP_VERSION_KEY, "TEXT", true, 0, null, 1));
                linkedHashMap.put("api_key", new TableInfo.Column("api_key", "TEXT", true, 0, null, 1));
                linkedHashMap.put("human_readable_device_model", new TableInfo.Column("human_readable_device_model", "TEXT", false, 0, null, 1));
                linkedHashMap.put("os", new TableInfo.Column("os", "TEXT", false, 0, null, 1));
                linkedHashMap.put("platform", new TableInfo.Column("platform", "TEXT", true, 0, null, 1));
                linkedHashMap.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, 1));
                linkedHashMap.put("duration", new TableInfo.Column("duration", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("num_items", new TableInfo.Column("num_items", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("count", new TableInfo.Column("count", "INTEGER", true, 0, null, 1));
                linkedHashMap.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, 1));
                linkedHashMap.put("milestone", new TableInfo.Column("milestone", "TEXT", false, 0, null, 1));
                linkedHashMap.put("subtype", new TableInfo.Column("subtype", "TEXT", false, 0, null, 1));
                linkedHashMap.put(TelemetryEventStrings.Value.FAILED, new TableInfo.Column(TelemetryEventStrings.Value.FAILED, "INTEGER", false, 0, null, 1));
                linkedHashMap.put("value", new TableInfo.Column("value", "TEXT", false, 0, null, 1));
                linkedHashMap.put("is_recoverable", new TableInfo.Column("is_recoverable", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("job_manager_version", new TableInfo.Column("job_manager_version", "TEXT", false, 0, null, 1));
                linkedHashMap.put("num_of_automatic_retries", new TableInfo.Column("num_of_automatic_retries", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("num_of_manual_retries", new TableInfo.Column("num_of_manual_retries", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("completion_status", new TableInfo.Column("completion_status", "TEXT", false, 0, null, 1));
                linkedHashMap.put("fail_reason", new TableInfo.Column("fail_reason", "TEXT", false, 0, null, 1));
                linkedHashMap.put(AuthenticationConstants.OAuth2.ERROR_CODE, new TableInfo.Column(AuthenticationConstants.OAuth2.ERROR_CODE, "INTEGER", false, 0, null, 1));
                linkedHashMap.put("size_raw", new TableInfo.Column("size_raw", "REAL", false, 0, null, 1));
                linkedHashMap.put("size", new TableInfo.Column("size", "TEXT", false, 0, null, 1));
                linkedHashMap.put("folder_id", new TableInfo.Column("folder_id", "TEXT", false, 0, null, 1));
                linkedHashMap.put("job", new TableInfo.Column("job", "TEXT", false, 0, null, 1));
                linkedHashMap.put("code", new TableInfo.Column("code", "TEXT", false, 0, null, 1));
                linkedHashMap.put("time_to_start", new TableInfo.Column("time_to_start", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("rate", new TableInfo.Column("rate", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("total_time", new TableInfo.Column("total_time", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("bytes_uploaded", new TableInfo.Column("bytes_uploaded", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("number_of_parallel_chunks", new TableInfo.Column("number_of_parallel_chunks", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("secondary_measurement", new TableInfo.Column("secondary_measurement", "REAL", false, 0, null, 1));
                linkedHashMap.put("magnitude", new TableInfo.Column("magnitude", "REAL", false, 0, null, 1));
                linkedHashMap.put(FirebaseAnalytics.Param.SCORE, new TableInfo.Column(FirebaseAnalytics.Param.SCORE, "REAL", false, 0, null, 1));
                linkedHashMap.put("is_new_version_upload", new TableInfo.Column("is_new_version_upload", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("is_user_triggered_job", new TableInfo.Column("is_user_triggered_job", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap.put("item_state", new TableInfo.Column("item_state", "TEXT", false, 0, null, 1));
                linkedHashMap.put("source_tab", new TableInfo.Column("source_tab", "TEXT", false, 0, null, 1));
                linkedHashMap.put("ui_source", new TableInfo.Column("ui_source", "TEXT", false, 0, null, 1));
                TableInfo tableInfo = new TableInfo("metricsLogs", linkedHashMap, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo2 = TableInfo.INSTANCE.read(connection, "metricsLogs");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenDelegate.ValidationResult(false, "metricsLogs(com.box.android.data.persistence.logging.MetricsEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                return new RoomOpenDelegate.ValidationResult(true, null);
            }
        };
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new LinkedHashMap(), new LinkedHashMap(), "metricsLogs");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.performClear(false, "metricsLogs");
    }

    @Override // androidx.room.RoomDatabase
    protected Map<KClass<?>, List<KClass<?>>> getRequiredTypeConverterClasses() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(MetricsDao.class), MetricsDao_Impl.INSTANCE.getRequiredConverters());
        return linkedHashMap;
    }

    @Override // androidx.room.RoomDatabase
    public Set<KClass<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecClasses() {
        return new LinkedHashSet();
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> createAutoMigrations(Map<KClass<? extends AutoMigrationSpec>, ? extends AutoMigrationSpec> autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BoxObservabilityDatabase_AutoMigration_1_2_Impl());
        arrayList.add(new BoxObservabilityDatabase_AutoMigration_2_3_Impl());
        arrayList.add(new BoxObservabilityDatabase_AutoMigration_3_4_Impl());
        arrayList.add(new BoxObservabilityDatabase_AutoMigration_4_5_Impl());
        arrayList.add(new BoxObservabilityDatabase_AutoMigration_5_6_Impl());
        arrayList.add(new BoxObservabilityDatabase_AutoMigration_6_7_Impl());
        return arrayList;
    }

    @Override // com.box.android.data.persistence.BoxObservabilityDatabase
    public MetricsDao metricsLogDao() {
        return this._metricsDao.getValue();
    }
}
