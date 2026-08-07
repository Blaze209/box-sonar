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
import com.box.android.activities.urlsinterceptor.WebUrlsInterceptorActivity;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.data.jobs.CreateFolderJob;
import com.box.android.data.persistence.annotations.AnnotationsDao;
import com.box.android.data.persistence.annotations.AnnotationsDao_Impl;
import com.box.android.data.persistence.annotations.FileActivityDao;
import com.box.android.data.persistence.annotations.FileActivityDao_Impl;
import com.box.android.data.persistence.capture.CaptureHistoryDao;
import com.box.android.data.persistence.capture.CaptureHistoryDao_Impl;
import com.box.android.data.persistence.comment.CommentDao;
import com.box.android.data.persistence.comment.CommentDao_Impl;
import com.box.android.data.persistence.inboxnotifications.InboxNotificationDao;
import com.box.android.data.persistence.inboxnotifications.InboxNotificationDao_Impl;
import com.box.android.data.persistence.jobs.JobsDao;
import com.box.android.data.persistence.jobs.JobsDao_Impl;
import com.box.android.data.persistence.localItems.LocalItemsDao;
import com.box.android.data.persistence.localItems.LocalItemsDao_Impl;
import com.box.android.data.persistence.offline.OfflineServiceDao;
import com.box.android.data.persistence.offline.OfflineServiceDao_Impl;
import com.box.android.data.persistence.recentnotes.RecentNoteDao;
import com.box.android.data.persistence.recentnotes.RecentNoteDao_Impl;
import com.box.android.data.persistence.representations.FileRepresentationsDao;
import com.box.android.data.persistence.representations.FileRepresentationsDao_Impl;
import com.box.android.data.persistence.sharedlink.SharedLinkCredentialsDao;
import com.box.android.data.persistence.sharedlink.SharedLinkCredentialsDao_Impl;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.localrepo.sqlitetables.BoxItemSQLData;
import com.box.androidsdk.content.models.BoxOrder;
import com.box.androidsdk.content.requests.BoxRequestsSearch;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: BoxDatabase_Impl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\b\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020\"H\u0016J\"\u0010#\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030%\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030%0&0$H\u0014J\u0016\u0010'\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020)0%0(H\u0016J*\u0010*\u001a\b\u0012\u0004\u0012\u00020+0&2\u001a\u0010,\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020)0%\u0012\u0004\u0012\u00020)0$H\u0016J\b\u0010-\u001a\u00020\u0006H\u0016J\b\u0010.\u001a\u00020\bH\u0016J\b\u0010/\u001a\u00020\nH\u0016J\b\u00100\u001a\u00020\fH\u0016J\b\u00101\u001a\u00020\u000eH\u0016J\b\u00102\u001a\u00020\u0010H\u0016J\b\u00103\u001a\u00020\u0012H\u0016J\b\u00104\u001a\u00020\u0014H\u0016J\b\u00105\u001a\u00020\u0016H\u0016J\b\u00106\u001a\u00020\u0018H\u0016J\b\u00107\u001a\u00020\u001aH\u0016J\b\u00108\u001a\u00020\u001cH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/box/android/data/persistence/BoxDatabase_Impl;", "Lcom/box/android/data/persistence/BoxDatabase;", "<init>", "()V", "_annotationsDao", "Lkotlin/Lazy;", "Lcom/box/android/data/persistence/annotations/AnnotationsDao;", "_commentDao", "Lcom/box/android/data/persistence/comment/CommentDao;", "_fileActivityDao", "Lcom/box/android/data/persistence/annotations/FileActivityDao;", "_scannedDocumentPageDao", "Lcom/box/android/data/persistence/ScannedDocumentPageDao;", "_captureHistoryDao", "Lcom/box/android/data/persistence/capture/CaptureHistoryDao;", "_fileRepresentationsDao", "Lcom/box/android/data/persistence/representations/FileRepresentationsDao;", "_jobsDao", "Lcom/box/android/data/persistence/jobs/JobsDao;", "_localItemsDao", "Lcom/box/android/data/persistence/localItems/LocalItemsDao;", "_sharedLinkCredentialsDao", "Lcom/box/android/data/persistence/sharedlink/SharedLinkCredentialsDao;", "_offlineServiceDao", "Lcom/box/android/data/persistence/offline/OfflineServiceDao;", "_inboxNotificationDao", "Lcom/box/android/data/persistence/inboxnotifications/InboxNotificationDao;", "_recentNoteDao", "Lcom/box/android/data/persistence/recentnotes/RecentNoteDao;", "createOpenDelegate", "Landroidx/room/RoomOpenDelegate;", "createInvalidationTracker", "Landroidx/room/InvalidationTracker;", "clearAllTables", "", "getRequiredTypeConverterClasses", "", "Lkotlin/reflect/KClass;", "", "getRequiredAutoMigrationSpecClasses", "", "Landroidx/room/migration/AutoMigrationSpec;", "createAutoMigrations", "Landroidx/room/migration/Migration;", "autoMigrationSpecs", "annotationsDao", "commentDao", "fileActivityDao", "scannedDocumentPagesDao", "captureHistoryDao", "fileRepresentationsDao", "jobsDao", "localItemsDao", "sharedLinkCredentialsDao", "offlineServiceDao", "inboxNotificationDao", "recentNoteDao", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxDatabase_Impl extends BoxDatabase {
    private final Lazy<AnnotationsDao> _annotationsDao = LazyKt.lazy(new Function0() { // from class: com.box.android.data.persistence.BoxDatabase_Impl$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BoxDatabase_Impl._annotationsDao$lambda$0(this.f$0);
        }
    });
    private final Lazy<CommentDao> _commentDao = LazyKt.lazy(new Function0() { // from class: com.box.android.data.persistence.BoxDatabase_Impl$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BoxDatabase_Impl._commentDao$lambda$0(this.f$0);
        }
    });
    private final Lazy<FileActivityDao> _fileActivityDao = LazyKt.lazy(new Function0() { // from class: com.box.android.data.persistence.BoxDatabase_Impl$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BoxDatabase_Impl._fileActivityDao$lambda$0(this.f$0);
        }
    });
    private final Lazy<ScannedDocumentPageDao> _scannedDocumentPageDao = LazyKt.lazy(new Function0() { // from class: com.box.android.data.persistence.BoxDatabase_Impl$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BoxDatabase_Impl._scannedDocumentPageDao$lambda$0(this.f$0);
        }
    });
    private final Lazy<CaptureHistoryDao> _captureHistoryDao = LazyKt.lazy(new Function0() { // from class: com.box.android.data.persistence.BoxDatabase_Impl$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BoxDatabase_Impl._captureHistoryDao$lambda$0(this.f$0);
        }
    });
    private final Lazy<FileRepresentationsDao> _fileRepresentationsDao = LazyKt.lazy(new Function0() { // from class: com.box.android.data.persistence.BoxDatabase_Impl$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BoxDatabase_Impl._fileRepresentationsDao$lambda$0(this.f$0);
        }
    });
    private final Lazy<JobsDao> _jobsDao = LazyKt.lazy(new Function0() { // from class: com.box.android.data.persistence.BoxDatabase_Impl$$ExternalSyntheticLambda10
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BoxDatabase_Impl._jobsDao$lambda$0(this.f$0);
        }
    });
    private final Lazy<LocalItemsDao> _localItemsDao = LazyKt.lazy(new Function0() { // from class: com.box.android.data.persistence.BoxDatabase_Impl$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BoxDatabase_Impl._localItemsDao$lambda$0(this.f$0);
        }
    });
    private final Lazy<SharedLinkCredentialsDao> _sharedLinkCredentialsDao = LazyKt.lazy(new Function0() { // from class: com.box.android.data.persistence.BoxDatabase_Impl$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BoxDatabase_Impl._sharedLinkCredentialsDao$lambda$0(this.f$0);
        }
    });
    private final Lazy<OfflineServiceDao> _offlineServiceDao = LazyKt.lazy(new Function0() { // from class: com.box.android.data.persistence.BoxDatabase_Impl$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BoxDatabase_Impl._offlineServiceDao$lambda$0(this.f$0);
        }
    });
    private final Lazy<InboxNotificationDao> _inboxNotificationDao = LazyKt.lazy(new Function0() { // from class: com.box.android.data.persistence.BoxDatabase_Impl$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BoxDatabase_Impl._inboxNotificationDao$lambda$0(this.f$0);
        }
    });
    private final Lazy<RecentNoteDao> _recentNoteDao = LazyKt.lazy(new Function0() { // from class: com.box.android.data.persistence.BoxDatabase_Impl$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BoxDatabase_Impl._recentNoteDao$lambda$0(this.f$0);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotationsDao_Impl _annotationsDao$lambda$0(BoxDatabase_Impl boxDatabase_Impl) {
        return new AnnotationsDao_Impl(boxDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CommentDao_Impl _commentDao$lambda$0(BoxDatabase_Impl boxDatabase_Impl) {
        return new CommentDao_Impl(boxDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileActivityDao_Impl _fileActivityDao$lambda$0(BoxDatabase_Impl boxDatabase_Impl) {
        return new FileActivityDao_Impl(boxDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScannedDocumentPageDao_Impl _scannedDocumentPageDao$lambda$0(BoxDatabase_Impl boxDatabase_Impl) {
        return new ScannedDocumentPageDao_Impl(boxDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CaptureHistoryDao_Impl _captureHistoryDao$lambda$0(BoxDatabase_Impl boxDatabase_Impl) {
        return new CaptureHistoryDao_Impl(boxDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileRepresentationsDao_Impl _fileRepresentationsDao$lambda$0(BoxDatabase_Impl boxDatabase_Impl) {
        return new FileRepresentationsDao_Impl(boxDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JobsDao_Impl _jobsDao$lambda$0(BoxDatabase_Impl boxDatabase_Impl) {
        return new JobsDao_Impl(boxDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocalItemsDao_Impl _localItemsDao$lambda$0(BoxDatabase_Impl boxDatabase_Impl) {
        return new LocalItemsDao_Impl(boxDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedLinkCredentialsDao_Impl _sharedLinkCredentialsDao$lambda$0(BoxDatabase_Impl boxDatabase_Impl) {
        return new SharedLinkCredentialsDao_Impl(boxDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflineServiceDao_Impl _offlineServiceDao$lambda$0(BoxDatabase_Impl boxDatabase_Impl) {
        return new OfflineServiceDao_Impl(boxDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InboxNotificationDao_Impl _inboxNotificationDao$lambda$0(BoxDatabase_Impl boxDatabase_Impl) {
        return new InboxNotificationDao_Impl(boxDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecentNoteDao_Impl _recentNoteDao$lambda$0(BoxDatabase_Impl boxDatabase_Impl) {
        return new RecentNoteDao_Impl(boxDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.room.RoomDatabase
    public RoomOpenDelegate createOpenDelegate() {
        return new RoomOpenDelegate() { // from class: com.box.android.data.persistence.BoxDatabase_Impl$createOpenDelegate$_openDelegate$1
            @Override // androidx.room.RoomOpenDelegate
            public void onCreate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onPostMigrate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            {
                super(41, "453008be2ae10636c2e45915abd2affc", "625009866e1cad7a244e06e6500d255e");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void createAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `annotations` (`annotation_id` TEXT NOT NULL, `file_version_id` TEXT NOT NULL, `file_version_number` INTEGER NOT NULL, `created_at` INTEGER NOT NULL, `created_by_json_data` BLOB NOT NULL, `modified_at` INTEGER NOT NULL, `modified_by_json_data` BLOB NOT NULL, `description_json_data` BLOB NOT NULL, `location_json_data` BLOB NOT NULL, `target_json_data` BLOB NOT NULL, `permissions_json_data` BLOB NOT NULL, `network_fetched_at` INTEGER NOT NULL, `total_reply_count` INTEGER NOT NULL DEFAULT 0, `status` TEXT NOT NULL DEFAULT 'open', PRIMARY KEY(`annotation_id`))");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_annotations_file_version_id` ON `annotations` (`file_version_id`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_annotations_network_fetched_at` ON `annotations` (`network_fetched_at`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `comments` (`comment_id` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `file_id` TEXT NOT NULL, `json_data` BLOB NOT NULL, `network_fetched_at` INTEGER NOT NULL, `total_reply_count` INTEGER NOT NULL DEFAULT 0, `status` TEXT NOT NULL DEFAULT 'open', `parent_id` TEXT, PRIMARY KEY(`comment_id`))");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_comments_parent_id` ON `comments` (`parent_id`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `file_activity` (`activity_id` TEXT NOT NULL, `type` TEXT NOT NULL, `file_id` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `network_fetched_at` INTEGER NOT NULL, `order_number` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`activity_id`))");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_file_activity_file_id_network_fetched_at` ON `file_activity` (`file_id`, `network_fetched_at`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `grouped_file_versions` (`start_id` TEXT NOT NULL, `end_id` TEXT NOT NULL, `file_id` TEXT NOT NULL, `created_by_json_data` BLOB NOT NULL, `network_fetched_at` INTEGER NOT NULL, PRIMARY KEY(`start_id`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `file_versions` (`version_id` TEXT NOT NULL, `file_id` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `number` INTEGER NOT NULL, `network_fetched_at` INTEGER NOT NULL, PRIMARY KEY(`version_id`))");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_file_versions_file_id_created_at` ON `file_versions` (`file_id`, `created_at`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `scanned_document_pages` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `original_file` TEXT NOT NULL, `enhanced_file` TEXT NOT NULL, `filter_type` TEXT NOT NULL, `distortion_correction` INTEGER NOT NULL, `rotation_angle` INTEGER NOT NULL, `version` INTEGER NOT NULL, `created_at` INTEGER NOT NULL, `quad_x1` REAL, `quad_y1` REAL, `quad_x2` REAL, `quad_y2` REAL, `quad_x3` REAL, `quad_y3` REAL, `quad_x4` REAL, `quad_y4` REAL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `captureHistory` (`local_item_id` TEXT NOT NULL, `content_created_at` INTEGER NOT NULL, `last_updated` INTEGER NOT NULL, PRIMARY KEY(`local_item_id`), FOREIGN KEY(`local_item_id`) REFERENCES `local_item`(`local_id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `file_representations` (`file_id` TEXT NOT NULL, `sha1` TEXT NOT NULL, `json_response` TEXT NOT NULL, PRIMARY KEY(`file_id`, `sha1`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `job` (`id` TEXT NOT NULL, `job_type` TEXT NOT NULL, `input_data` BLOB NOT NULL, `status` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `start_date` INTEGER, `earliest_start_date` INTEGER NOT NULL, `auto_retry_count` INTEGER NOT NULL, `manual_retry_count` INTEGER NOT NULL, `running_info` BLOB, `error_info` TEXT, `parentID` TEXT, `rootID` TEXT NOT NULL, `sortKey` TEXT NOT NULL DEFAULT '', `log_data` BLOB NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`rootID`) REFERENCES `job`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`parentID`) REFERENCES `job`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_job_status` ON `job` (`status`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_job_created_at` ON `job` (`created_at`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_job_status_created_at` ON `job` (`status`, `created_at`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_job_sortKey` ON `job` (`sortKey`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_job_parentID` ON `job` (`parentID`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_job_rootID` ON `job` (`rootID`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `job_dependency` (`successor` TEXT NOT NULL, `predecessor` TEXT NOT NULL, PRIMARY KEY(`successor`, `predecessor`), FOREIGN KEY(`successor`) REFERENCES `job`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`predecessor`) REFERENCES `job`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_job_dependency_predecessor` ON `job_dependency` (`predecessor`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_job_dependency_successor` ON `job_dependency` (`successor`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `job_id_to_work_id` (`job_id` TEXT NOT NULL, `work_id` TEXT NOT NULL, PRIMARY KEY(`job_id`, `work_id`), FOREIGN KEY(`job_id`) REFERENCES `job`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_job_id_to_work_id_work_id` ON `job_id_to_work_id` (`work_id`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `local_id_to_server_id` (`local_id` TEXT NOT NULL, `type` TEXT NOT NULL, `server_id` TEXT NOT NULL, PRIMARY KEY(`local_id`), FOREIGN KEY(`local_id`) REFERENCES `local_item`(`local_id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_local_id_to_server_id_type_server_id` ON `local_id_to_server_id` (`type`, `server_id`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `local_item` (`local_id` TEXT NOT NULL, `type` TEXT NOT NULL, `content_url` TEXT, `name` TEXT NOT NULL, `parent_id` TEXT, `created_at` INTEGER NOT NULL, `content_modified_at` INTEGER, `local_file_sha1` TEXT, PRIMARY KEY(`local_id`))");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_local_item_parent_id_name` ON `local_item` (`parent_id`, `name`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_local_item_parent_id_created_at` ON `local_item` (`parent_id`, `created_at`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `job_to_tag` (`tag` TEXT NOT NULL, `job_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `job_id`), FOREIGN KEY(`job_id`) REFERENCES `job`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_job_to_tag_job_id` ON `job_to_tag` (`job_id`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_job_to_tag_tag` ON `job_to_tag` (`tag`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `sharedlink_credentials` (`file_id` TEXT NOT NULL, `url` TEXT NOT NULL, `password` TEXT, PRIMARY KEY(`file_id`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `offline_state` (`item_id` TEXT NOT NULL, `item_type` TEXT NOT NULL, `is_user_saved` INTEGER NOT NULL, `is_user_removed` INTEGER NOT NULL, `started_date` INTEGER, `completed_date` INTEGER, `sha1` TEXT, PRIMARY KEY(`item_id`, `item_type`))");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_offline_state_is_user_saved` ON `offline_state` (`is_user_saved`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_offline_state_item_type` ON `offline_state` (`item_type`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `inbox_notifications` (`notification_id` TEXT NOT NULL, `type` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `is_seen` INTEGER NOT NULL, `is_read` INTEGER NOT NULL, `json_data` BLOB NOT NULL, `network_fetched_at` INTEGER NOT NULL, `source` TEXT NOT NULL, PRIMARY KEY(`notification_id`))");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_inbox_notifications_created_at` ON `inbox_notifications` (`created_at`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_inbox_notifications_is_seen` ON `inbox_notifications` (`is_seen`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_inbox_notifications_is_read` ON `inbox_notifications` (`is_read`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_inbox_notifications_network_fetched_at` ON `inbox_notifications` (`network_fetched_at`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `recent_notes` (`item_id` TEXT NOT NULL, `interacted_at` INTEGER, `interaction_type` TEXT, `interaction_shared_link` TEXT, PRIMARY KEY(`item_id`))");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_recent_notes_interacted_at` ON `recent_notes` (`interacted_at`)");
                SQLite.execSQL(connection, RoomMasterTable.CREATE_QUERY);
                SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '453008be2ae10636c2e45915abd2affc')");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void dropAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `annotations`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `comments`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `file_activity`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `grouped_file_versions`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `file_versions`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `scanned_document_pages`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `captureHistory`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `file_representations`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `job`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `job_dependency`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `job_id_to_work_id`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `local_id_to_server_id`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `local_item`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `job_to_tag`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `sharedlink_credentials`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `offline_state`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `inbox_notifications`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `recent_notes`");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onOpen(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "PRAGMA foreign_keys = ON");
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
                linkedHashMap.put("annotation_id", new TableInfo.Column("annotation_id", "TEXT", true, 1, null, 1));
                linkedHashMap.put("file_version_id", new TableInfo.Column("file_version_id", "TEXT", true, 0, null, 1));
                linkedHashMap.put("file_version_number", new TableInfo.Column("file_version_number", "INTEGER", true, 0, null, 1));
                linkedHashMap.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, 1));
                linkedHashMap.put("created_by_json_data", new TableInfo.Column("created_by_json_data", "BLOB", true, 0, null, 1));
                linkedHashMap.put("modified_at", new TableInfo.Column("modified_at", "INTEGER", true, 0, null, 1));
                linkedHashMap.put("modified_by_json_data", new TableInfo.Column("modified_by_json_data", "BLOB", true, 0, null, 1));
                linkedHashMap.put("description_json_data", new TableInfo.Column("description_json_data", "BLOB", true, 0, null, 1));
                linkedHashMap.put("location_json_data", new TableInfo.Column("location_json_data", "BLOB", true, 0, null, 1));
                linkedHashMap.put("target_json_data", new TableInfo.Column("target_json_data", "BLOB", true, 0, null, 1));
                linkedHashMap.put("permissions_json_data", new TableInfo.Column("permissions_json_data", "BLOB", true, 0, null, 1));
                linkedHashMap.put("network_fetched_at", new TableInfo.Column("network_fetched_at", "INTEGER", true, 0, null, 1));
                linkedHashMap.put("total_reply_count", new TableInfo.Column("total_reply_count", "INTEGER", true, 0, "0", 1));
                linkedHashMap.put("status", new TableInfo.Column("status", "TEXT", true, 0, "'open'", 1));
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                linkedHashSet2.add(new TableInfo.Index("index_annotations_file_version_id", false, CollectionsKt.listOf("file_version_id"), CollectionsKt.listOf(BoxOrder.DIRECTION_ASCENDING)));
                linkedHashSet2.add(new TableInfo.Index("index_annotations_network_fetched_at", false, CollectionsKt.listOf("network_fetched_at"), CollectionsKt.listOf(BoxOrder.DIRECTION_ASCENDING)));
                TableInfo tableInfo = new TableInfo("annotations", linkedHashMap, linkedHashSet, linkedHashSet2);
                TableInfo tableInfo2 = TableInfo.INSTANCE.read(connection, "annotations");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenDelegate.ValidationResult(false, "annotations(com.box.android.data.persistence.annotations.AnnotationEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("comment_id", new TableInfo.Column("comment_id", "TEXT", true, 1, null, 1));
                linkedHashMap2.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, 1));
                linkedHashMap2.put(FontsContractCompat.Columns.FILE_ID, new TableInfo.Column(FontsContractCompat.Columns.FILE_ID, "TEXT", true, 0, null, 1));
                linkedHashMap2.put("json_data", new TableInfo.Column("json_data", "BLOB", true, 0, null, 1));
                linkedHashMap2.put("network_fetched_at", new TableInfo.Column("network_fetched_at", "INTEGER", true, 0, null, 1));
                linkedHashMap2.put("total_reply_count", new TableInfo.Column("total_reply_count", "INTEGER", true, 0, "0", 1));
                linkedHashMap2.put("status", new TableInfo.Column("status", "TEXT", true, 0, "'open'", 1));
                linkedHashMap2.put(BoxItemSQLData.COL_PARENT_ID, new TableInfo.Column(BoxItemSQLData.COL_PARENT_ID, "TEXT", false, 0, null, 1));
                LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                LinkedHashSet linkedHashSet4 = new LinkedHashSet();
                linkedHashSet4.add(new TableInfo.Index("index_comments_parent_id", false, CollectionsKt.listOf(BoxItemSQLData.COL_PARENT_ID), CollectionsKt.listOf(BoxOrder.DIRECTION_ASCENDING)));
                TableInfo tableInfo3 = new TableInfo(BoxRequestsSearch.Search.CONTENT_TYPE_COMMENTS, linkedHashMap2, linkedHashSet3, linkedHashSet4);
                TableInfo tableInfo4 = TableInfo.INSTANCE.read(connection, BoxRequestsSearch.Search.CONTENT_TYPE_COMMENTS);
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenDelegate.ValidationResult(false, "comments(com.box.android.data.persistence.annotations.CommentEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                linkedHashMap3.put(WebUrlsInterceptorActivity.ACTIVITY_ID_QUERY, new TableInfo.Column(WebUrlsInterceptorActivity.ACTIVITY_ID_QUERY, "TEXT", true, 1, null, 1));
                linkedHashMap3.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, 1));
                linkedHashMap3.put(FontsContractCompat.Columns.FILE_ID, new TableInfo.Column(FontsContractCompat.Columns.FILE_ID, "TEXT", true, 0, null, 1));
                linkedHashMap3.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, 1));
                linkedHashMap3.put("network_fetched_at", new TableInfo.Column("network_fetched_at", "INTEGER", true, 0, null, 1));
                linkedHashMap3.put("order_number", new TableInfo.Column("order_number", "INTEGER", true, 0, "0", 1));
                LinkedHashSet linkedHashSet5 = new LinkedHashSet();
                LinkedHashSet linkedHashSet6 = new LinkedHashSet();
                linkedHashSet6.add(new TableInfo.Index("index_file_activity_file_id_network_fetched_at", false, CollectionsKt.listOf((Object[]) new String[]{FontsContractCompat.Columns.FILE_ID, "network_fetched_at"}), CollectionsKt.listOf((Object[]) new String[]{BoxOrder.DIRECTION_ASCENDING, BoxOrder.DIRECTION_ASCENDING})));
                TableInfo tableInfo5 = new TableInfo("file_activity", linkedHashMap3, linkedHashSet5, linkedHashSet6);
                TableInfo tableInfo6 = TableInfo.INSTANCE.read(connection, "file_activity");
                if (!tableInfo5.equals(tableInfo6)) {
                    return new RoomOpenDelegate.ValidationResult(false, "file_activity(com.box.android.data.persistence.annotations.FileActivityEntity).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
                }
                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                linkedHashMap4.put("start_id", new TableInfo.Column("start_id", "TEXT", true, 1, null, 1));
                linkedHashMap4.put("end_id", new TableInfo.Column("end_id", "TEXT", true, 0, null, 1));
                linkedHashMap4.put(FontsContractCompat.Columns.FILE_ID, new TableInfo.Column(FontsContractCompat.Columns.FILE_ID, "TEXT", true, 0, null, 1));
                linkedHashMap4.put("created_by_json_data", new TableInfo.Column("created_by_json_data", "BLOB", true, 0, null, 1));
                linkedHashMap4.put("network_fetched_at", new TableInfo.Column("network_fetched_at", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo7 = new TableInfo("grouped_file_versions", linkedHashMap4, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo8 = TableInfo.INSTANCE.read(connection, "grouped_file_versions");
                if (!tableInfo7.equals(tableInfo8)) {
                    return new RoomOpenDelegate.ValidationResult(false, "grouped_file_versions(com.box.android.data.persistence.annotations.GroupedFileVersionsEntity).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
                }
                LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                linkedHashMap5.put("version_id", new TableInfo.Column("version_id", "TEXT", true, 1, null, 1));
                linkedHashMap5.put(FontsContractCompat.Columns.FILE_ID, new TableInfo.Column(FontsContractCompat.Columns.FILE_ID, "TEXT", true, 0, null, 1));
                linkedHashMap5.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, 1));
                linkedHashMap5.put("number", new TableInfo.Column("number", "INTEGER", true, 0, null, 1));
                linkedHashMap5.put("network_fetched_at", new TableInfo.Column("network_fetched_at", "INTEGER", true, 0, null, 1));
                LinkedHashSet linkedHashSet7 = new LinkedHashSet();
                LinkedHashSet linkedHashSet8 = new LinkedHashSet();
                linkedHashSet8.add(new TableInfo.Index("index_file_versions_file_id_created_at", false, CollectionsKt.listOf((Object[]) new String[]{FontsContractCompat.Columns.FILE_ID, "created_at"}), CollectionsKt.listOf((Object[]) new String[]{BoxOrder.DIRECTION_ASCENDING, BoxOrder.DIRECTION_ASCENDING})));
                TableInfo tableInfo9 = new TableInfo("file_versions", linkedHashMap5, linkedHashSet7, linkedHashSet8);
                TableInfo tableInfo10 = TableInfo.INSTANCE.read(connection, "file_versions");
                if (!tableInfo9.equals(tableInfo10)) {
                    return new RoomOpenDelegate.ValidationResult(false, "file_versions(com.box.android.data.persistence.annotations.FileVersionEntity).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfo10);
                }
                LinkedHashMap linkedHashMap6 = new LinkedHashMap();
                linkedHashMap6.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap6.put("original_file", new TableInfo.Column("original_file", "TEXT", true, 0, null, 1));
                linkedHashMap6.put("enhanced_file", new TableInfo.Column("enhanced_file", "TEXT", true, 0, null, 1));
                linkedHashMap6.put(BoxAmplitudeAnalytics.SearchEventPropertyBuilder.SEARCH_FILTER_TYPE, new TableInfo.Column(BoxAmplitudeAnalytics.SearchEventPropertyBuilder.SEARCH_FILTER_TYPE, "TEXT", true, 0, null, 1));
                linkedHashMap6.put("distortion_correction", new TableInfo.Column("distortion_correction", "INTEGER", true, 0, null, 1));
                linkedHashMap6.put("rotation_angle", new TableInfo.Column("rotation_angle", "INTEGER", true, 0, null, 1));
                linkedHashMap6.put("version", new TableInfo.Column("version", "INTEGER", true, 0, null, 1));
                linkedHashMap6.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, 1));
                linkedHashMap6.put("quad_x1", new TableInfo.Column("quad_x1", "REAL", false, 0, null, 1));
                linkedHashMap6.put("quad_y1", new TableInfo.Column("quad_y1", "REAL", false, 0, null, 1));
                linkedHashMap6.put("quad_x2", new TableInfo.Column("quad_x2", "REAL", false, 0, null, 1));
                linkedHashMap6.put("quad_y2", new TableInfo.Column("quad_y2", "REAL", false, 0, null, 1));
                linkedHashMap6.put("quad_x3", new TableInfo.Column("quad_x3", "REAL", false, 0, null, 1));
                linkedHashMap6.put("quad_y3", new TableInfo.Column("quad_y3", "REAL", false, 0, null, 1));
                linkedHashMap6.put("quad_x4", new TableInfo.Column("quad_x4", "REAL", false, 0, null, 1));
                linkedHashMap6.put("quad_y4", new TableInfo.Column("quad_y4", "REAL", false, 0, null, 1));
                TableInfo tableInfo11 = new TableInfo("scanned_document_pages", linkedHashMap6, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo12 = TableInfo.INSTANCE.read(connection, "scanned_document_pages");
                if (!tableInfo11.equals(tableInfo12)) {
                    return new RoomOpenDelegate.ValidationResult(false, "scanned_document_pages(com.box.android.data.persistence.ScannedDocumentPageEntity).\n Expected:\n" + tableInfo11 + "\n Found:\n" + tableInfo12);
                }
                LinkedHashMap linkedHashMap7 = new LinkedHashMap();
                linkedHashMap7.put("local_item_id", new TableInfo.Column("local_item_id", "TEXT", true, 1, null, 1));
                linkedHashMap7.put("content_created_at", new TableInfo.Column("content_created_at", "INTEGER", true, 0, null, 1));
                linkedHashMap7.put("last_updated", new TableInfo.Column("last_updated", "INTEGER", true, 0, null, 1));
                LinkedHashSet linkedHashSet9 = new LinkedHashSet();
                linkedHashSet9.add(new TableInfo.ForeignKey("local_item", "CASCADE", "NO ACTION", CollectionsKt.listOf("local_item_id"), CollectionsKt.listOf(CreateFolderJob.LOCAL_ID)));
                TableInfo tableInfo13 = new TableInfo("captureHistory", linkedHashMap7, linkedHashSet9, new LinkedHashSet());
                TableInfo tableInfo14 = TableInfo.INSTANCE.read(connection, "captureHistory");
                if (!tableInfo13.equals(tableInfo14)) {
                    return new RoomOpenDelegate.ValidationResult(false, "captureHistory(com.box.android.data.persistence.capture.CaptureHistoryItemEntity).\n Expected:\n" + tableInfo13 + "\n Found:\n" + tableInfo14);
                }
                LinkedHashMap linkedHashMap8 = new LinkedHashMap();
                linkedHashMap8.put(FontsContractCompat.Columns.FILE_ID, new TableInfo.Column(FontsContractCompat.Columns.FILE_ID, "TEXT", true, 1, null, 1));
                linkedHashMap8.put("sha1", new TableInfo.Column("sha1", "TEXT", true, 2, null, 1));
                linkedHashMap8.put("json_response", new TableInfo.Column("json_response", "TEXT", true, 0, null, 1));
                TableInfo tableInfo15 = new TableInfo("file_representations", linkedHashMap8, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo16 = TableInfo.INSTANCE.read(connection, "file_representations");
                if (!tableInfo15.equals(tableInfo16)) {
                    return new RoomOpenDelegate.ValidationResult(false, "file_representations(com.box.android.data.persistence.representations.RepresentationsItemEntity).\n Expected:\n" + tableInfo15 + "\n Found:\n" + tableInfo16);
                }
                LinkedHashMap linkedHashMap9 = new LinkedHashMap();
                linkedHashMap9.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                linkedHashMap9.put("job_type", new TableInfo.Column("job_type", "TEXT", true, 0, null, 1));
                linkedHashMap9.put("input_data", new TableInfo.Column("input_data", "BLOB", true, 0, null, 1));
                linkedHashMap9.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, 1));
                linkedHashMap9.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, 1));
                linkedHashMap9.put(FirebaseAnalytics.Param.START_DATE, new TableInfo.Column(FirebaseAnalytics.Param.START_DATE, "INTEGER", false, 0, null, 1));
                linkedHashMap9.put("earliest_start_date", new TableInfo.Column("earliest_start_date", "INTEGER", true, 0, null, 1));
                linkedHashMap9.put("auto_retry_count", new TableInfo.Column("auto_retry_count", "INTEGER", true, 0, null, 1));
                linkedHashMap9.put("manual_retry_count", new TableInfo.Column("manual_retry_count", "INTEGER", true, 0, null, 1));
                linkedHashMap9.put("running_info", new TableInfo.Column("running_info", "BLOB", false, 0, null, 1));
                linkedHashMap9.put("error_info", new TableInfo.Column("error_info", "TEXT", false, 0, null, 1));
                linkedHashMap9.put("parentID", new TableInfo.Column("parentID", "TEXT", false, 0, null, 1));
                linkedHashMap9.put("rootID", new TableInfo.Column("rootID", "TEXT", true, 0, null, 1));
                linkedHashMap9.put("sortKey", new TableInfo.Column("sortKey", "TEXT", true, 0, "''", 1));
                linkedHashMap9.put("log_data", new TableInfo.Column("log_data", "BLOB", true, 0, null, 1));
                LinkedHashSet linkedHashSet10 = new LinkedHashSet();
                linkedHashSet10.add(new TableInfo.ForeignKey("job", "CASCADE", "NO ACTION", CollectionsKt.listOf("rootID"), CollectionsKt.listOf("id")));
                linkedHashSet10.add(new TableInfo.ForeignKey("job", "CASCADE", "NO ACTION", CollectionsKt.listOf("parentID"), CollectionsKt.listOf("id")));
                LinkedHashSet linkedHashSet11 = new LinkedHashSet();
                linkedHashSet11.add(new TableInfo.Index("index_job_status", false, CollectionsKt.listOf("status"), CollectionsKt.listOf(BoxOrder.DIRECTION_ASCENDING)));
                linkedHashSet11.add(new TableInfo.Index("index_job_created_at", false, CollectionsKt.listOf("created_at"), CollectionsKt.listOf(BoxOrder.DIRECTION_ASCENDING)));
                linkedHashSet11.add(new TableInfo.Index("index_job_status_created_at", false, CollectionsKt.listOf((Object[]) new String[]{"status", "created_at"}), CollectionsKt.listOf((Object[]) new String[]{BoxOrder.DIRECTION_ASCENDING, BoxOrder.DIRECTION_ASCENDING})));
                linkedHashSet11.add(new TableInfo.Index("index_job_sortKey", false, CollectionsKt.listOf("sortKey"), CollectionsKt.listOf(BoxOrder.DIRECTION_ASCENDING)));
                linkedHashSet11.add(new TableInfo.Index("index_job_parentID", false, CollectionsKt.listOf("parentID"), CollectionsKt.listOf(BoxOrder.DIRECTION_ASCENDING)));
                linkedHashSet11.add(new TableInfo.Index("index_job_rootID", false, CollectionsKt.listOf("rootID"), CollectionsKt.listOf(BoxOrder.DIRECTION_ASCENDING)));
                TableInfo tableInfo17 = new TableInfo("job", linkedHashMap9, linkedHashSet10, linkedHashSet11);
                TableInfo tableInfo18 = TableInfo.INSTANCE.read(connection, "job");
                if (!tableInfo17.equals(tableInfo18)) {
                    return new RoomOpenDelegate.ValidationResult(false, "job(com.box.android.data.persistence.jobs.JobEntity).\n Expected:\n" + tableInfo17 + "\n Found:\n" + tableInfo18);
                }
                LinkedHashMap linkedHashMap10 = new LinkedHashMap();
                linkedHashMap10.put("successor", new TableInfo.Column("successor", "TEXT", true, 1, null, 1));
                linkedHashMap10.put("predecessor", new TableInfo.Column("predecessor", "TEXT", true, 2, null, 1));
                LinkedHashSet linkedHashSet12 = new LinkedHashSet();
                linkedHashSet12.add(new TableInfo.ForeignKey("job", "CASCADE", "NO ACTION", CollectionsKt.listOf("successor"), CollectionsKt.listOf("id")));
                linkedHashSet12.add(new TableInfo.ForeignKey("job", "CASCADE", "NO ACTION", CollectionsKt.listOf("predecessor"), CollectionsKt.listOf("id")));
                LinkedHashSet linkedHashSet13 = new LinkedHashSet();
                linkedHashSet13.add(new TableInfo.Index("index_job_dependency_predecessor", false, CollectionsKt.listOf("predecessor"), CollectionsKt.listOf(BoxOrder.DIRECTION_ASCENDING)));
                linkedHashSet13.add(new TableInfo.Index("index_job_dependency_successor", false, CollectionsKt.listOf("successor"), CollectionsKt.listOf(BoxOrder.DIRECTION_ASCENDING)));
                TableInfo tableInfo19 = new TableInfo("job_dependency", linkedHashMap10, linkedHashSet12, linkedHashSet13);
                TableInfo tableInfo20 = TableInfo.INSTANCE.read(connection, "job_dependency");
                if (!tableInfo19.equals(tableInfo20)) {
                    return new RoomOpenDelegate.ValidationResult(false, "job_dependency(com.box.android.data.persistence.jobs.JobDependencyRelation).\n Expected:\n" + tableInfo19 + "\n Found:\n" + tableInfo20);
                }
                LinkedHashMap linkedHashMap11 = new LinkedHashMap();
                linkedHashMap11.put("job_id", new TableInfo.Column("job_id", "TEXT", true, 1, null, 1));
                linkedHashMap11.put("work_id", new TableInfo.Column("work_id", "TEXT", true, 2, null, 1));
                LinkedHashSet linkedHashSet14 = new LinkedHashSet();
                linkedHashSet14.add(new TableInfo.ForeignKey("job", "CASCADE", "NO ACTION", CollectionsKt.listOf("job_id"), CollectionsKt.listOf("id")));
                LinkedHashSet linkedHashSet15 = new LinkedHashSet();
                linkedHashSet15.add(new TableInfo.Index("index_job_id_to_work_id_work_id", true, CollectionsKt.listOf("work_id"), CollectionsKt.listOf(BoxOrder.DIRECTION_ASCENDING)));
                TableInfo tableInfo21 = new TableInfo("job_id_to_work_id", linkedHashMap11, linkedHashSet14, linkedHashSet15);
                TableInfo tableInfo22 = TableInfo.INSTANCE.read(connection, "job_id_to_work_id");
                if (!tableInfo21.equals(tableInfo22)) {
                    return new RoomOpenDelegate.ValidationResult(false, "job_id_to_work_id(com.box.android.data.persistence.jobs.JobIdToWorkIdRelation).\n Expected:\n" + tableInfo21 + "\n Found:\n" + tableInfo22);
                }
                LinkedHashMap linkedHashMap12 = new LinkedHashMap();
                linkedHashMap12.put(CreateFolderJob.LOCAL_ID, new TableInfo.Column(CreateFolderJob.LOCAL_ID, "TEXT", true, 1, null, 1));
                linkedHashMap12.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, 1));
                linkedHashMap12.put("server_id", new TableInfo.Column("server_id", "TEXT", true, 0, null, 1));
                LinkedHashSet linkedHashSet16 = new LinkedHashSet();
                linkedHashSet16.add(new TableInfo.ForeignKey("local_item", "CASCADE", "NO ACTION", CollectionsKt.listOf(CreateFolderJob.LOCAL_ID), CollectionsKt.listOf(CreateFolderJob.LOCAL_ID)));
                LinkedHashSet linkedHashSet17 = new LinkedHashSet();
                linkedHashSet17.add(new TableInfo.Index("index_local_id_to_server_id_type_server_id", true, CollectionsKt.listOf((Object[]) new String[]{"type", "server_id"}), CollectionsKt.listOf((Object[]) new String[]{BoxOrder.DIRECTION_ASCENDING, BoxOrder.DIRECTION_ASCENDING})));
                TableInfo tableInfo23 = new TableInfo("local_id_to_server_id", linkedHashMap12, linkedHashSet16, linkedHashSet17);
                TableInfo tableInfo24 = TableInfo.INSTANCE.read(connection, "local_id_to_server_id");
                if (!tableInfo23.equals(tableInfo24)) {
                    return new RoomOpenDelegate.ValidationResult(false, "local_id_to_server_id(com.box.android.data.persistence.localItems.LocalIdToServerIdRelationEntity).\n Expected:\n" + tableInfo23 + "\n Found:\n" + tableInfo24);
                }
                LinkedHashMap linkedHashMap13 = new LinkedHashMap();
                linkedHashMap13.put(CreateFolderJob.LOCAL_ID, new TableInfo.Column(CreateFolderJob.LOCAL_ID, "TEXT", true, 1, null, 1));
                linkedHashMap13.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, 1));
                linkedHashMap13.put("content_url", new TableInfo.Column("content_url", "TEXT", false, 0, null, 1));
                linkedHashMap13.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                linkedHashMap13.put(BoxItemSQLData.COL_PARENT_ID, new TableInfo.Column(BoxItemSQLData.COL_PARENT_ID, "TEXT", false, 0, null, 1));
                linkedHashMap13.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, 1));
                linkedHashMap13.put("content_modified_at", new TableInfo.Column("content_modified_at", "INTEGER", false, 0, null, 1));
                linkedHashMap13.put("local_file_sha1", new TableInfo.Column("local_file_sha1", "TEXT", false, 0, null, 1));
                LinkedHashSet linkedHashSet18 = new LinkedHashSet();
                LinkedHashSet linkedHashSet19 = new LinkedHashSet();
                linkedHashSet19.add(new TableInfo.Index("index_local_item_parent_id_name", false, CollectionsKt.listOf((Object[]) new String[]{BoxItemSQLData.COL_PARENT_ID, "name"}), CollectionsKt.listOf((Object[]) new String[]{BoxOrder.DIRECTION_ASCENDING, BoxOrder.DIRECTION_ASCENDING})));
                linkedHashSet19.add(new TableInfo.Index("index_local_item_parent_id_created_at", false, CollectionsKt.listOf((Object[]) new String[]{BoxItemSQLData.COL_PARENT_ID, "created_at"}), CollectionsKt.listOf((Object[]) new String[]{BoxOrder.DIRECTION_ASCENDING, BoxOrder.DIRECTION_ASCENDING})));
                TableInfo tableInfo25 = new TableInfo("local_item", linkedHashMap13, linkedHashSet18, linkedHashSet19);
                TableInfo tableInfo26 = TableInfo.INSTANCE.read(connection, "local_item");
                if (!tableInfo25.equals(tableInfo26)) {
                    return new RoomOpenDelegate.ValidationResult(false, "local_item(com.box.android.data.persistence.localItems.LocalItemEntity).\n Expected:\n" + tableInfo25 + "\n Found:\n" + tableInfo26);
                }
                LinkedHashMap linkedHashMap14 = new LinkedHashMap();
                linkedHashMap14.put("tag", new TableInfo.Column("tag", "TEXT", true, 1, null, 1));
                linkedHashMap14.put("job_id", new TableInfo.Column("job_id", "TEXT", true, 2, null, 1));
                LinkedHashSet linkedHashSet20 = new LinkedHashSet();
                linkedHashSet20.add(new TableInfo.ForeignKey("job", "CASCADE", "NO ACTION", CollectionsKt.listOf("job_id"), CollectionsKt.listOf("id")));
                LinkedHashSet linkedHashSet21 = new LinkedHashSet();
                linkedHashSet21.add(new TableInfo.Index("index_job_to_tag_job_id", false, CollectionsKt.listOf("job_id"), CollectionsKt.listOf(BoxOrder.DIRECTION_ASCENDING)));
                linkedHashSet21.add(new TableInfo.Index("index_job_to_tag_tag", false, CollectionsKt.listOf("tag"), CollectionsKt.listOf(BoxOrder.DIRECTION_ASCENDING)));
                TableInfo tableInfo27 = new TableInfo("job_to_tag", linkedHashMap14, linkedHashSet20, linkedHashSet21);
                TableInfo tableInfo28 = TableInfo.INSTANCE.read(connection, "job_to_tag");
                if (!tableInfo27.equals(tableInfo28)) {
                    return new RoomOpenDelegate.ValidationResult(false, "job_to_tag(com.box.android.data.persistence.jobs.JobToTagRelation).\n Expected:\n" + tableInfo27 + "\n Found:\n" + tableInfo28);
                }
                LinkedHashMap linkedHashMap15 = new LinkedHashMap();
                linkedHashMap15.put(FontsContractCompat.Columns.FILE_ID, new TableInfo.Column(FontsContractCompat.Columns.FILE_ID, "TEXT", true, 1, null, 1));
                linkedHashMap15.put("url", new TableInfo.Column("url", "TEXT", true, 0, null, 1));
                linkedHashMap15.put("password", new TableInfo.Column("password", "TEXT", false, 0, null, 1));
                TableInfo tableInfo29 = new TableInfo("sharedlink_credentials", linkedHashMap15, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo30 = TableInfo.INSTANCE.read(connection, "sharedlink_credentials");
                if (!tableInfo29.equals(tableInfo30)) {
                    return new RoomOpenDelegate.ValidationResult(false, "sharedlink_credentials(com.box.android.data.persistence.sharedlink.SharedlinkCredentialEntity).\n Expected:\n" + tableInfo29 + "\n Found:\n" + tableInfo30);
                }
                LinkedHashMap linkedHashMap16 = new LinkedHashMap();
                linkedHashMap16.put("item_id", new TableInfo.Column("item_id", "TEXT", true, 1, null, 1));
                linkedHashMap16.put("item_type", new TableInfo.Column("item_type", "TEXT", true, 2, null, 1));
                linkedHashMap16.put("is_user_saved", new TableInfo.Column("is_user_saved", "INTEGER", true, 0, null, 1));
                linkedHashMap16.put("is_user_removed", new TableInfo.Column("is_user_removed", "INTEGER", true, 0, null, 1));
                linkedHashMap16.put("started_date", new TableInfo.Column("started_date", "INTEGER", false, 0, null, 1));
                linkedHashMap16.put("completed_date", new TableInfo.Column("completed_date", "INTEGER", false, 0, null, 1));
                linkedHashMap16.put("sha1", new TableInfo.Column("sha1", "TEXT", false, 0, null, 1));
                LinkedHashSet linkedHashSet22 = new LinkedHashSet();
                LinkedHashSet linkedHashSet23 = new LinkedHashSet();
                linkedHashSet23.add(new TableInfo.Index("index_offline_state_is_user_saved", false, CollectionsKt.listOf("is_user_saved"), CollectionsKt.listOf(BoxOrder.DIRECTION_ASCENDING)));
                linkedHashSet23.add(new TableInfo.Index("index_offline_state_item_type", false, CollectionsKt.listOf("item_type"), CollectionsKt.listOf(BoxOrder.DIRECTION_ASCENDING)));
                TableInfo tableInfo31 = new TableInfo("offline_state", linkedHashMap16, linkedHashSet22, linkedHashSet23);
                TableInfo tableInfo32 = TableInfo.INSTANCE.read(connection, "offline_state");
                if (!tableInfo31.equals(tableInfo32)) {
                    return new RoomOpenDelegate.ValidationResult(false, "offline_state(com.box.android.data.persistence.offline.OfflineStateEntity).\n Expected:\n" + tableInfo31 + "\n Found:\n" + tableInfo32);
                }
                LinkedHashMap linkedHashMap17 = new LinkedHashMap();
                linkedHashMap17.put(IntentConstants.EXTRA_REDIRECT_ON_FAILURE_URL, new TableInfo.Column(IntentConstants.EXTRA_REDIRECT_ON_FAILURE_URL, "TEXT", true, 1, null, 1));
                linkedHashMap17.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, 1));
                linkedHashMap17.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, 1));
                linkedHashMap17.put("is_seen", new TableInfo.Column("is_seen", "INTEGER", true, 0, null, 1));
                linkedHashMap17.put("is_read", new TableInfo.Column("is_read", "INTEGER", true, 0, null, 1));
                linkedHashMap17.put("json_data", new TableInfo.Column("json_data", "BLOB", true, 0, null, 1));
                linkedHashMap17.put("network_fetched_at", new TableInfo.Column("network_fetched_at", "INTEGER", true, 0, null, 1));
                linkedHashMap17.put("source", new TableInfo.Column("source", "TEXT", true, 0, null, 1));
                LinkedHashSet linkedHashSet24 = new LinkedHashSet();
                LinkedHashSet linkedHashSet25 = new LinkedHashSet();
                linkedHashSet25.add(new TableInfo.Index("index_inbox_notifications_created_at", false, CollectionsKt.listOf("created_at"), CollectionsKt.listOf(BoxOrder.DIRECTION_ASCENDING)));
                linkedHashSet25.add(new TableInfo.Index("index_inbox_notifications_is_seen", false, CollectionsKt.listOf("is_seen"), CollectionsKt.listOf(BoxOrder.DIRECTION_ASCENDING)));
                linkedHashSet25.add(new TableInfo.Index("index_inbox_notifications_is_read", false, CollectionsKt.listOf("is_read"), CollectionsKt.listOf(BoxOrder.DIRECTION_ASCENDING)));
                linkedHashSet25.add(new TableInfo.Index("index_inbox_notifications_network_fetched_at", false, CollectionsKt.listOf("network_fetched_at"), CollectionsKt.listOf(BoxOrder.DIRECTION_ASCENDING)));
                TableInfo tableInfo33 = new TableInfo("inbox_notifications", linkedHashMap17, linkedHashSet24, linkedHashSet25);
                TableInfo tableInfo34 = TableInfo.INSTANCE.read(connection, "inbox_notifications");
                if (!tableInfo33.equals(tableInfo34)) {
                    return new RoomOpenDelegate.ValidationResult(false, "inbox_notifications(com.box.android.data.persistence.inboxnotifications.InboxNotificationEntity).\n Expected:\n" + tableInfo33 + "\n Found:\n" + tableInfo34);
                }
                LinkedHashMap linkedHashMap18 = new LinkedHashMap();
                linkedHashMap18.put("item_id", new TableInfo.Column("item_id", "TEXT", true, 1, null, 1));
                linkedHashMap18.put("interacted_at", new TableInfo.Column("interacted_at", "INTEGER", false, 0, null, 1));
                linkedHashMap18.put("interaction_type", new TableInfo.Column("interaction_type", "TEXT", false, 0, null, 1));
                linkedHashMap18.put("interaction_shared_link", new TableInfo.Column("interaction_shared_link", "TEXT", false, 0, null, 1));
                LinkedHashSet linkedHashSet26 = new LinkedHashSet();
                LinkedHashSet linkedHashSet27 = new LinkedHashSet();
                linkedHashSet27.add(new TableInfo.Index("index_recent_notes_interacted_at", false, CollectionsKt.listOf("interacted_at"), CollectionsKt.listOf(BoxOrder.DIRECTION_ASCENDING)));
                TableInfo tableInfo35 = new TableInfo("recent_notes", linkedHashMap18, linkedHashSet26, linkedHashSet27);
                TableInfo tableInfo36 = TableInfo.INSTANCE.read(connection, "recent_notes");
                if (!tableInfo35.equals(tableInfo36)) {
                    return new RoomOpenDelegate.ValidationResult(false, "recent_notes(com.box.android.data.persistence.recentnotes.RecentNoteEntity).\n Expected:\n" + tableInfo35 + "\n Found:\n" + tableInfo36);
                }
                return new RoomOpenDelegate.ValidationResult(true, null);
            }
        };
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new LinkedHashMap(), new LinkedHashMap(), "annotations", BoxRequestsSearch.Search.CONTENT_TYPE_COMMENTS, "file_activity", "grouped_file_versions", "file_versions", "scanned_document_pages", "captureHistory", "file_representations", "job", "job_dependency", "job_id_to_work_id", "local_id_to_server_id", "local_item", "job_to_tag", "sharedlink_credentials", "offline_state", "inbox_notifications", "recent_notes");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.performClear(true, "annotations", BoxRequestsSearch.Search.CONTENT_TYPE_COMMENTS, "file_activity", "grouped_file_versions", "file_versions", "scanned_document_pages", "captureHistory", "file_representations", "job", "job_dependency", "job_id_to_work_id", "local_id_to_server_id", "local_item", "job_to_tag", "sharedlink_credentials", "offline_state", "inbox_notifications", "recent_notes");
    }

    @Override // androidx.room.RoomDatabase
    protected Map<KClass<?>, List<KClass<?>>> getRequiredTypeConverterClasses() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(AnnotationsDao.class), AnnotationsDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(CommentDao.class), CommentDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(FileActivityDao.class), FileActivityDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(ScannedDocumentPageDao.class), ScannedDocumentPageDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(CaptureHistoryDao.class), CaptureHistoryDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(FileRepresentationsDao.class), FileRepresentationsDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(JobsDao.class), JobsDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(LocalItemsDao.class), LocalItemsDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(SharedLinkCredentialsDao.class), SharedLinkCredentialsDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(OfflineServiceDao.class), OfflineServiceDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(InboxNotificationDao.class), InboxNotificationDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(RecentNoteDao.class), RecentNoteDao_Impl.INSTANCE.getRequiredConverters());
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
        arrayList.add(new BoxDatabase_AutoMigration_26_27_Impl());
        arrayList.add(new BoxDatabase_AutoMigration_27_28_Impl());
        arrayList.add(new BoxDatabase_AutoMigration_28_29_Impl());
        arrayList.add(new BoxDatabase_AutoMigration_29_30_Impl());
        arrayList.add(new BoxDatabase_AutoMigration_30_31_Impl());
        arrayList.add(new BoxDatabase_AutoMigration_31_32_Impl());
        arrayList.add(new BoxDatabase_AutoMigration_32_33_Impl());
        arrayList.add(new BoxDatabase_AutoMigration_33_34_Impl());
        arrayList.add(new BoxDatabase_AutoMigration_35_36_Impl());
        arrayList.add(new BoxDatabase_AutoMigration_36_37_Impl());
        arrayList.add(new BoxDatabase_AutoMigration_38_39_Impl());
        arrayList.add(new BoxDatabase_AutoMigration_40_41_Impl());
        return arrayList;
    }

    @Override // com.box.android.data.persistence.BoxDatabase
    public AnnotationsDao annotationsDao() {
        return this._annotationsDao.getValue();
    }

    @Override // com.box.android.data.persistence.BoxDatabase
    public CommentDao commentDao() {
        return this._commentDao.getValue();
    }

    @Override // com.box.android.data.persistence.BoxDatabase
    public FileActivityDao fileActivityDao() {
        return this._fileActivityDao.getValue();
    }

    @Override // com.box.android.data.persistence.BoxDatabase
    public ScannedDocumentPageDao scannedDocumentPagesDao() {
        return this._scannedDocumentPageDao.getValue();
    }

    @Override // com.box.android.data.persistence.BoxDatabase
    public CaptureHistoryDao captureHistoryDao() {
        return this._captureHistoryDao.getValue();
    }

    @Override // com.box.android.data.persistence.BoxDatabase
    public FileRepresentationsDao fileRepresentationsDao() {
        return this._fileRepresentationsDao.getValue();
    }

    @Override // com.box.android.data.persistence.BoxDatabase
    public JobsDao jobsDao() {
        return this._jobsDao.getValue();
    }

    @Override // com.box.android.data.persistence.BoxDatabase
    public LocalItemsDao localItemsDao() {
        return this._localItemsDao.getValue();
    }

    @Override // com.box.android.data.persistence.BoxDatabase
    public SharedLinkCredentialsDao sharedLinkCredentialsDao() {
        return this._sharedLinkCredentialsDao.getValue();
    }

    @Override // com.box.android.data.persistence.BoxDatabase
    public OfflineServiceDao offlineServiceDao() {
        return this._offlineServiceDao.getValue();
    }

    @Override // com.box.android.data.persistence.BoxDatabase
    public InboxNotificationDao inboxNotificationDao() {
        return this._inboxNotificationDao.getValue();
    }

    @Override // com.box.android.data.persistence.BoxDatabase
    public RecentNoteDao recentNoteDao() {
        return this._recentNoteDao.getValue();
    }
}
