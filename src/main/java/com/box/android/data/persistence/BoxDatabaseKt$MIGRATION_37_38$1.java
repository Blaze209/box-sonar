package com.box.android.data.persistence;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.Data;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: BoxDatabase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/box/android/data/persistence/BoxDatabaseKt$MIGRATION_37_38$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxDatabaseKt$MIGRATION_37_38$1 extends Migration {
    BoxDatabaseKt$MIGRATION_37_38$1() {
        super(37, 38);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        String strJoinToString$default = ArraysKt.joinToString$default(Data.EMPTY.toByteArray(), (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.box.android.data.persistence.BoxDatabaseKt$MIGRATION_37_38$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoxDatabaseKt$MIGRATION_37_38$1.migrate$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
        database.execSQL("CREATE TABLE IF NOT EXISTS `job_temp` (`id` TEXT NOT NULL, `job_type` TEXT NOT NULL, `input_data` BLOB NOT NULL, `status` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `start_date` INTEGER, `earliest_start_date` INTEGER NOT NULL, `auto_retry_count` INTEGER NOT NULL, `manual_retry_count` INTEGER NOT NULL, `running_info` BLOB, `error_info` TEXT, `parentID` TEXT, `rootID` TEXT NOT NULL, `sortKey` TEXT NOT NULL DEFAULT '', `log_data` BLOB NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`rootID`) REFERENCES `job`(`id`) ON DELETE CASCADE, FOREIGN KEY(`parentID`) REFERENCES `job`(`id`) ON DELETE CASCADE)");
        database.execSQL("INSERT INTO job_temp (id, job_type, input_data, status, created_at, start_date, earliest_start_date, auto_retry_count, manual_retry_count, running_info, error_info, parentID, rootID, sortKey, log_data) SELECT id, job_type, input_data, status, created_at, start_date, earliest_start_date, auto_retry_count, manual_retry_count, running_info, error_info, parentID, rootID, sortKey, IFNULL(log_data, X'" + strJoinToString$default + "') FROM job");
        database.execSQL("DROP TABLE job");
        database.execSQL("ALTER TABLE job_temp RENAME TO job");
        database.execSQL("CREATE INDEX IF NOT EXISTS index_job_status ON job (status)");
        database.execSQL("CREATE INDEX IF NOT EXISTS index_job_created_at ON job (created_at)");
        database.execSQL("CREATE INDEX IF NOT EXISTS index_job_status_created_at ON job (status, created_at)");
        database.execSQL("CREATE INDEX IF NOT EXISTS index_job_sortKey ON job (sortKey)");
        database.execSQL("CREATE INDEX IF NOT EXISTS index_job_parentID ON job (parentID)");
        database.execSQL("CREATE INDEX IF NOT EXISTS index_job_rootID ON job (rootID)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence migrate$lambda$0(byte b) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
