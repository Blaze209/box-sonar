package com.box.android.data.persistence.logging;

import androidx.core.provider.FontsContractCompat;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.amplitude.api.AmplitudeClient;
import com.box.android.domain.configuration.SplitConfiguration;
import com.box.android.domain.models.observability.ApdexScore;
import com.box.androidsdk.content.auth.OAuthActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: MetricsDao_Impl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0015H\u0096@¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0015H\u0096@¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/box/android/data/persistence/logging/MetricsDao_Impl;", "Lcom/box/android/data/persistence/logging/MetricsDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfMetricsEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/box/android/data/persistence/logging/MetricsEntity;", "__categoryConverter", "Lcom/box/android/data/persistence/logging/CategoryConverter;", "__apdexScoreConverter", "Lcom/box/android/data/persistence/logging/ApdexScoreConverter;", "__deleteAdapterOfMetricsEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "insertLog", "", "metricsEntity", "(Lcom/box/android/data/persistence/logging/MetricsEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMetrics", "metricsEntityList", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllLogs", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCount", "", "deleteMetricsByUserId", OAuthActivity.USER_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMetricsByUserIdNotNullOrEmpty", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MetricsDao_Impl implements MetricsDao {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ApdexScoreConverter __apdexScoreConverter;
    private final CategoryConverter __categoryConverter;
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<MetricsEntity> __deleteAdapterOfMetricsEntity;
    private final EntityInsertAdapter<MetricsEntity> __insertAdapterOfMetricsEntity;

    public MetricsDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__categoryConverter = new CategoryConverter();
        this.__apdexScoreConverter = new ApdexScoreConverter();
        this.__db = __db;
        this.__insertAdapterOfMetricsEntity = new EntityInsertAdapter<MetricsEntity>() { // from class: com.box.android.data.persistence.logging.MetricsDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR ABORT INTO `metricsLogs` (`category`,`event_type`,`user_id`,`az_name`,`enterprise_id`,`message`,`formattedmessage`,`file_id`,`method_file`,`method_name`,`method_line`,`timestamp`,`app_version`,`api_key`,`human_readable_device_model`,`os`,`platform`,`status`,`duration`,`num_items`,`count`,`type`,`milestone`,`subtype`,`failed`,`value`,`is_recoverable`,`job_manager_version`,`num_of_automatic_retries`,`num_of_manual_retries`,`completion_status`,`fail_reason`,`error_code`,`size_raw`,`size`,`folder_id`,`job`,`code`,`time_to_start`,`rate`,`total_time`,`bytes_uploaded`,`number_of_parallel_chunks`,`secondary_measurement`,`magnitude`,`score`,`is_new_version_upload`,`is_user_triggered_job`,`id`,`item_state`,`source_tab`,`ui_source`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,nullif(?, 0),?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, MetricsEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo10944bindText(1, MetricsDao_Impl.this.__categoryConverter.toString(entity.getCategory()));
                statement.mo10944bindText(2, entity.getEventType());
                statement.mo10944bindText(3, entity.getUserId());
                statement.mo10944bindText(4, entity.getUsername());
                statement.mo10944bindText(5, entity.getEnterpriseId());
                String message = entity.getMessage();
                if (message == null) {
                    statement.mo10943bindNull(6);
                } else {
                    statement.mo10944bindText(6, message);
                }
                String formattedMessage = entity.getFormattedMessage();
                if (formattedMessage == null) {
                    statement.mo10943bindNull(7);
                } else {
                    statement.mo10944bindText(7, formattedMessage);
                }
                String fileId = entity.getFileId();
                if (fileId == null) {
                    statement.mo10943bindNull(8);
                } else {
                    statement.mo10944bindText(8, fileId);
                }
                String fileName = entity.getFileName();
                if (fileName == null) {
                    statement.mo10943bindNull(9);
                } else {
                    statement.mo10944bindText(9, fileName);
                }
                String methodName = entity.getMethodName();
                if (methodName == null) {
                    statement.mo10943bindNull(10);
                } else {
                    statement.mo10944bindText(10, methodName);
                }
                Integer methodLine = entity.getMethodLine();
                if (methodLine == null) {
                    statement.mo10943bindNull(11);
                } else {
                    statement.mo10942bindLong(11, methodLine.intValue());
                }
                statement.mo10942bindLong(12, entity.getTimestamp());
                statement.mo10944bindText(13, entity.getAppVersion());
                statement.mo10944bindText(14, entity.getAppId());
                String deviceModel = entity.getDeviceModel();
                if (deviceModel == null) {
                    statement.mo10943bindNull(15);
                } else {
                    statement.mo10944bindText(15, deviceModel);
                }
                String osVersion = entity.getOsVersion();
                if (osVersion == null) {
                    statement.mo10943bindNull(16);
                } else {
                    statement.mo10944bindText(16, osVersion);
                }
                statement.mo10944bindText(17, entity.getPlatform());
                String status = entity.getStatus();
                if (status == null) {
                    statement.mo10943bindNull(18);
                } else {
                    statement.mo10944bindText(18, status);
                }
                Long duration = entity.getDuration();
                if (duration == null) {
                    statement.mo10943bindNull(19);
                } else {
                    statement.mo10942bindLong(19, duration.longValue());
                }
                Integer numItems = entity.getNumItems();
                if (numItems == null) {
                    statement.mo10943bindNull(20);
                } else {
                    statement.mo10942bindLong(20, numItems.intValue());
                }
                statement.mo10942bindLong(21, entity.getCount());
                String type = entity.getType();
                if (type == null) {
                    statement.mo10943bindNull(22);
                } else {
                    statement.mo10944bindText(22, type);
                }
                String milestone = entity.getMilestone();
                if (milestone == null) {
                    statement.mo10943bindNull(23);
                } else {
                    statement.mo10944bindText(23, milestone);
                }
                String subtype = entity.getSubtype();
                if (subtype == null) {
                    statement.mo10943bindNull(24);
                } else {
                    statement.mo10944bindText(24, subtype);
                }
                Boolean failed = entity.getFailed();
                Integer numValueOf = failed != null ? Integer.valueOf(failed.booleanValue() ? 1 : 0) : null;
                if (numValueOf == null) {
                    statement.mo10943bindNull(25);
                } else {
                    statement.mo10942bindLong(25, numValueOf.intValue());
                }
                String value = entity.getValue();
                if (value == null) {
                    statement.mo10943bindNull(26);
                } else {
                    statement.mo10944bindText(26, value);
                }
                Boolean boolIsRecoverable = entity.isRecoverable();
                Integer numValueOf2 = boolIsRecoverable != null ? Integer.valueOf(boolIsRecoverable.booleanValue() ? 1 : 0) : null;
                if (numValueOf2 == null) {
                    statement.mo10943bindNull(27);
                } else {
                    statement.mo10942bindLong(27, numValueOf2.intValue());
                }
                String jobManagerVersion = entity.getJobManagerVersion();
                if (jobManagerVersion == null) {
                    statement.mo10943bindNull(28);
                } else {
                    statement.mo10944bindText(28, jobManagerVersion);
                }
                Integer numberOfAutomaticRetries = entity.getNumberOfAutomaticRetries();
                if (numberOfAutomaticRetries == null) {
                    statement.mo10943bindNull(29);
                } else {
                    statement.mo10942bindLong(29, numberOfAutomaticRetries.intValue());
                }
                Integer numberOfManualRetries = entity.getNumberOfManualRetries();
                if (numberOfManualRetries == null) {
                    statement.mo10943bindNull(30);
                } else {
                    statement.mo10942bindLong(30, numberOfManualRetries.intValue());
                }
                String completionStatusString = entity.getCompletionStatusString();
                if (completionStatusString == null) {
                    statement.mo10943bindNull(31);
                } else {
                    statement.mo10944bindText(31, completionStatusString);
                }
                String failReason = entity.getFailReason();
                if (failReason == null) {
                    statement.mo10943bindNull(32);
                } else {
                    statement.mo10944bindText(32, failReason);
                }
                Integer errorCode = entity.getErrorCode();
                if (errorCode == null) {
                    statement.mo10943bindNull(33);
                } else {
                    statement.mo10942bindLong(33, errorCode.intValue());
                }
                Double sizeKB = entity.getSizeKB();
                if (sizeKB == null) {
                    statement.mo10943bindNull(34);
                } else {
                    statement.mo10941bindDouble(34, sizeKB.doubleValue());
                }
                String sizeBucket = entity.getSizeBucket();
                if (sizeBucket == null) {
                    statement.mo10943bindNull(35);
                } else {
                    statement.mo10944bindText(35, sizeBucket);
                }
                String folderId = entity.getFolderId();
                if (folderId == null) {
                    statement.mo10943bindNull(36);
                } else {
                    statement.mo10944bindText(36, folderId);
                }
                String testJobName = entity.getTestJobName();
                if (testJobName == null) {
                    statement.mo10943bindNull(37);
                } else {
                    statement.mo10944bindText(37, testJobName);
                }
                String testName = entity.getTestName();
                if (testName == null) {
                    statement.mo10943bindNull(38);
                } else {
                    statement.mo10944bindText(38, testName);
                }
                Long timeToStart = entity.getTimeToStart();
                if (timeToStart == null) {
                    statement.mo10943bindNull(39);
                } else {
                    statement.mo10942bindLong(39, timeToStart.longValue());
                }
                Long rate = entity.getRate();
                if (rate == null) {
                    statement.mo10943bindNull(40);
                } else {
                    statement.mo10942bindLong(40, rate.longValue());
                }
                Long totalTime = entity.getTotalTime();
                if (totalTime == null) {
                    statement.mo10943bindNull(41);
                } else {
                    statement.mo10942bindLong(41, totalTime.longValue());
                }
                Long bytesUploaded = entity.getBytesUploaded();
                if (bytesUploaded == null) {
                    statement.mo10943bindNull(42);
                } else {
                    statement.mo10942bindLong(42, bytesUploaded.longValue());
                }
                Integer numOfParallelChunks = entity.getNumOfParallelChunks();
                if (numOfParallelChunks == null) {
                    statement.mo10943bindNull(43);
                } else {
                    statement.mo10942bindLong(43, numOfParallelChunks.intValue());
                }
                Double secondaryMeasurement = entity.getSecondaryMeasurement();
                if (secondaryMeasurement == null) {
                    statement.mo10943bindNull(44);
                } else {
                    statement.mo10941bindDouble(44, secondaryMeasurement.doubleValue());
                }
                Double magnitude = entity.getMagnitude();
                if (magnitude == null) {
                    statement.mo10943bindNull(45);
                } else {
                    statement.mo10941bindDouble(45, magnitude.doubleValue());
                }
                ApdexScore score = entity.getScore();
                Double dValueOf = score == null ? null : Double.valueOf(MetricsDao_Impl.this.__apdexScoreConverter.toDouble(score));
                if (dValueOf == null) {
                    statement.mo10943bindNull(46);
                } else {
                    statement.mo10941bindDouble(46, dValueOf.doubleValue());
                }
                Boolean boolIsNewVersionUpload = entity.isNewVersionUpload();
                Integer numValueOf3 = boolIsNewVersionUpload != null ? Integer.valueOf(boolIsNewVersionUpload.booleanValue() ? 1 : 0) : null;
                if (numValueOf3 == null) {
                    statement.mo10943bindNull(47);
                } else {
                    statement.mo10942bindLong(47, numValueOf3.intValue());
                }
                Boolean boolIsUserTriggeredJob = entity.isUserTriggeredJob();
                Integer numValueOf4 = boolIsUserTriggeredJob != null ? Integer.valueOf(boolIsUserTriggeredJob.booleanValue() ? 1 : 0) : null;
                if (numValueOf4 == null) {
                    statement.mo10943bindNull(48);
                } else {
                    statement.mo10942bindLong(48, numValueOf4.intValue());
                }
                statement.mo10942bindLong(49, entity.getId());
                String itemState = entity.getItemState();
                if (itemState == null) {
                    statement.mo10943bindNull(50);
                } else {
                    statement.mo10944bindText(50, itemState);
                }
                String sourceTab = entity.getSourceTab();
                if (sourceTab == null) {
                    statement.mo10943bindNull(51);
                } else {
                    statement.mo10944bindText(51, sourceTab);
                }
                String uiSource = entity.getUiSource();
                if (uiSource == null) {
                    statement.mo10943bindNull(52);
                } else {
                    statement.mo10944bindText(52, uiSource);
                }
            }
        };
        this.__deleteAdapterOfMetricsEntity = new EntityDeleteOrUpdateAdapter<MetricsEntity>() { // from class: com.box.android.data.persistence.logging.MetricsDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "DELETE FROM `metricsLogs` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, MetricsEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo10942bindLong(1, entity.getId());
            }
        };
    }

    @Override // com.box.android.data.persistence.logging.MetricsDao
    public Object insertLog(final MetricsEntity metricsEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.logging.MetricsDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MetricsDao_Impl.insertLog$lambda$0(this.f$0, metricsEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertLog$lambda$0(MetricsDao_Impl metricsDao_Impl, MetricsEntity metricsEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        metricsDao_Impl.__insertAdapterOfMetricsEntity.insert(_connection, metricsEntity);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.logging.MetricsDao
    public Object deleteMetrics(final List<MetricsEntity> list, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.logging.MetricsDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MetricsDao_Impl.deleteMetrics$lambda$0(this.f$0, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteMetrics$lambda$0(MetricsDao_Impl metricsDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        metricsDao_Impl.__deleteAdapterOfMetricsEntity.handleMultiple(_connection, list);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.logging.MetricsDao
    public Object getAllLogs(Continuation<? super List<MetricsEntity>> continuation) {
        final String str = "SELECT * FROM metricsLogs";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.logging.MetricsDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MetricsDao_Impl.getAllLogs$lambda$0(str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllLogs$lambda$0(String str, MetricsDao_Impl metricsDao_Impl, SQLiteConnection _connection) throws Throwable {
        SQLiteStatement sQLiteStatement;
        Boolean boolValueOf;
        Boolean boolValueOf2;
        Boolean boolValueOf3;
        Boolean boolValueOf4;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "category");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "event_type");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, AmplitudeClient.USER_ID_KEY);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "az_name");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "enterprise_id");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "message");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "formattedmessage");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, FontsContractCompat.Columns.FILE_ID);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "method_file");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "method_name");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "method_line");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "timestamp");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, SplitConfiguration.SPLIT_ATTRIBUTE_APP_VERSION_KEY);
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "api_key");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "human_readable_device_model");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "os");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "platform");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "status");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "duration");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "num_items");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "count");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "milestone");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "subtype");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, TelemetryEventStrings.Value.FAILED);
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "value");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "is_recoverable");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "job_manager_version");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "num_of_automatic_retries");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "num_of_manual_retries");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "completion_status");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "fail_reason");
            int columnIndexOrThrow33 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, AuthenticationConstants.OAuth2.ERROR_CODE);
            int columnIndexOrThrow34 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "size_raw");
            int columnIndexOrThrow35 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "size");
            int columnIndexOrThrow36 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "folder_id");
            int columnIndexOrThrow37 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "job");
            int columnIndexOrThrow38 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "code");
            int columnIndexOrThrow39 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "time_to_start");
            int columnIndexOrThrow40 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "rate");
            int columnIndexOrThrow41 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "total_time");
            int columnIndexOrThrow42 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "bytes_uploaded");
            int columnIndexOrThrow43 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "number_of_parallel_chunks");
            int columnIndexOrThrow44 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "secondary_measurement");
            int columnIndexOrThrow45 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "magnitude");
            int columnIndexOrThrow46 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, FirebaseAnalytics.Param.SCORE);
            int columnIndexOrThrow47 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "is_new_version_upload");
            int columnIndexOrThrow48 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "is_user_triggered_job");
            int columnIndexOrThrow49 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow50 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "item_state");
            int columnIndexOrThrow51 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "source_tab");
            int columnIndexOrThrow52 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "ui_source");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                ArrayList arrayList2 = arrayList;
                int i = columnIndexOrThrow;
                MetricsCategory metricsCategoryFromString = metricsDao_Impl.__categoryConverter.fromString(sQLiteStatementPrepare.getText(columnIndexOrThrow));
                if (metricsCategoryFromString == null) {
                    sQLiteStatement = sQLiteStatementPrepare;
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.`data`.persistence.logging.MetricsCategory', but it was NULL.".toString());
                }
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8);
                String text8 = sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9);
                String text9 = sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow10);
                Integer numValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11));
                long j = sQLiteStatementPrepare.getLong(columnIndexOrThrow12);
                String text10 = sQLiteStatementPrepare.getText(columnIndexOrThrow13);
                int i2 = columnIndexOrThrow14;
                String text11 = sQLiteStatementPrepare.getText(i2);
                int i3 = columnIndexOrThrow15;
                String text12 = sQLiteStatementPrepare.isNull(i3) ? null : sQLiteStatementPrepare.getText(i3);
                int i4 = columnIndexOrThrow16;
                String text13 = sQLiteStatementPrepare.isNull(i4) ? null : sQLiteStatementPrepare.getText(i4);
                int i5 = columnIndexOrThrow17;
                String text14 = sQLiteStatementPrepare.getText(i5);
                columnIndexOrThrow17 = i5;
                int i6 = columnIndexOrThrow18;
                String text15 = sQLiteStatementPrepare.isNull(i6) ? null : sQLiteStatementPrepare.getText(i6);
                columnIndexOrThrow18 = i6;
                int i7 = columnIndexOrThrow19;
                Long lValueOf = sQLiteStatementPrepare.isNull(i7) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i7));
                columnIndexOrThrow19 = i7;
                int i8 = columnIndexOrThrow20;
                Integer numValueOf2 = sQLiteStatementPrepare.isNull(i8) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i8));
                int i9 = columnIndexOrThrow21;
                int i10 = columnIndexOrThrow4;
                int i11 = (int) sQLiteStatementPrepare.getLong(i9);
                int i12 = columnIndexOrThrow22;
                String text16 = sQLiteStatementPrepare.isNull(i12) ? null : sQLiteStatementPrepare.getText(i12);
                int i13 = columnIndexOrThrow23;
                String text17 = sQLiteStatementPrepare.isNull(i13) ? null : sQLiteStatementPrepare.getText(i13);
                columnIndexOrThrow23 = i13;
                int i14 = columnIndexOrThrow24;
                String text18 = sQLiteStatementPrepare.isNull(i14) ? null : sQLiteStatementPrepare.getText(i14);
                columnIndexOrThrow24 = i14;
                int i15 = columnIndexOrThrow25;
                Integer numValueOf3 = sQLiteStatementPrepare.isNull(i15) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i15));
                if (numValueOf3 != null) {
                    boolValueOf = Boolean.valueOf(numValueOf3.intValue() != 0);
                } else {
                    boolValueOf = null;
                }
                int i16 = columnIndexOrThrow26;
                String text19 = sQLiteStatementPrepare.isNull(i16) ? null : sQLiteStatementPrepare.getText(i16);
                int i17 = columnIndexOrThrow27;
                Integer numValueOf4 = sQLiteStatementPrepare.isNull(i17) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i17));
                if (numValueOf4 != null) {
                    boolValueOf2 = Boolean.valueOf(numValueOf4.intValue() != 0);
                } else {
                    boolValueOf2 = null;
                }
                int i18 = columnIndexOrThrow28;
                String text20 = sQLiteStatementPrepare.isNull(i18) ? null : sQLiteStatementPrepare.getText(i18);
                int i19 = columnIndexOrThrow29;
                Integer numValueOf5 = sQLiteStatementPrepare.isNull(i19) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i19));
                int i20 = columnIndexOrThrow30;
                Integer numValueOf6 = sQLiteStatementPrepare.isNull(i20) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i20));
                int i21 = columnIndexOrThrow31;
                String text21 = sQLiteStatementPrepare.isNull(i21) ? null : sQLiteStatementPrepare.getText(i21);
                int i22 = columnIndexOrThrow32;
                String text22 = sQLiteStatementPrepare.isNull(i22) ? null : sQLiteStatementPrepare.getText(i22);
                columnIndexOrThrow31 = i21;
                int i23 = columnIndexOrThrow33;
                Integer numValueOf7 = sQLiteStatementPrepare.isNull(i23) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i23));
                int i24 = columnIndexOrThrow34;
                Double dValueOf = sQLiteStatementPrepare.isNull(i24) ? null : Double.valueOf(sQLiteStatementPrepare.getDouble(i24));
                int i25 = columnIndexOrThrow35;
                String text23 = sQLiteStatementPrepare.isNull(i25) ? null : sQLiteStatementPrepare.getText(i25);
                int i26 = columnIndexOrThrow36;
                String text24 = sQLiteStatementPrepare.isNull(i26) ? null : sQLiteStatementPrepare.getText(i26);
                columnIndexOrThrow36 = i26;
                int i27 = columnIndexOrThrow37;
                String text25 = sQLiteStatementPrepare.isNull(i27) ? null : sQLiteStatementPrepare.getText(i27);
                columnIndexOrThrow37 = i27;
                int i28 = columnIndexOrThrow38;
                String text26 = sQLiteStatementPrepare.isNull(i28) ? null : sQLiteStatementPrepare.getText(i28);
                columnIndexOrThrow38 = i28;
                int i29 = columnIndexOrThrow39;
                Long lValueOf2 = sQLiteStatementPrepare.isNull(i29) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i29));
                columnIndexOrThrow39 = i29;
                int i30 = columnIndexOrThrow40;
                Long lValueOf3 = sQLiteStatementPrepare.isNull(i30) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i30));
                columnIndexOrThrow40 = i30;
                int i31 = columnIndexOrThrow41;
                Long lValueOf4 = sQLiteStatementPrepare.isNull(i31) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i31));
                columnIndexOrThrow41 = i31;
                int i32 = columnIndexOrThrow42;
                Long lValueOf5 = sQLiteStatementPrepare.isNull(i32) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i32));
                columnIndexOrThrow42 = i32;
                int i33 = columnIndexOrThrow43;
                Integer numValueOf8 = sQLiteStatementPrepare.isNull(i33) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i33));
                int i34 = columnIndexOrThrow44;
                Double dValueOf2 = sQLiteStatementPrepare.isNull(i34) ? null : Double.valueOf(sQLiteStatementPrepare.getDouble(i34));
                int i35 = columnIndexOrThrow45;
                Double dValueOf3 = sQLiteStatementPrepare.isNull(i35) ? null : Double.valueOf(sQLiteStatementPrepare.getDouble(i35));
                columnIndexOrThrow46 = columnIndexOrThrow46;
                Double dValueOf4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow46) ? null : Double.valueOf(sQLiteStatementPrepare.getDouble(columnIndexOrThrow46));
                ApdexScore apdexScoreFromDouble = dValueOf4 == null ? null : metricsDao_Impl.__apdexScoreConverter.fromDouble(dValueOf4.doubleValue());
                int i36 = columnIndexOrThrow47;
                Integer numValueOf9 = sQLiteStatementPrepare.isNull(i36) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i36));
                if (numValueOf9 != null) {
                    boolValueOf3 = Boolean.valueOf(numValueOf9.intValue() != 0);
                } else {
                    boolValueOf3 = null;
                }
                int i37 = columnIndexOrThrow48;
                Integer numValueOf10 = sQLiteStatementPrepare.isNull(i37) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i37));
                if (numValueOf10 != null) {
                    boolValueOf4 = Boolean.valueOf(numValueOf10.intValue() != 0);
                } else {
                    boolValueOf4 = null;
                }
                int i38 = columnIndexOrThrow49;
                long j2 = sQLiteStatementPrepare.getLong(i38);
                int i39 = columnIndexOrThrow50;
                String text27 = sQLiteStatementPrepare.isNull(i39) ? null : sQLiteStatementPrepare.getText(i39);
                int i40 = columnIndexOrThrow51;
                String text28 = sQLiteStatementPrepare.isNull(i40) ? null : sQLiteStatementPrepare.getText(i40);
                columnIndexOrThrow51 = i40;
                int i41 = columnIndexOrThrow52;
                columnIndexOrThrow52 = i41;
                sQLiteStatement = sQLiteStatementPrepare;
                try {
                    arrayList2.add(new MetricsEntity(metricsCategoryFromString, text, text2, text3, text4, text5, text6, text7, text8, text9, numValueOf, j, text10, text11, text12, text13, text14, text15, lValueOf, numValueOf2, i11, text16, text17, text18, boolValueOf, text19, boolValueOf2, text20, numValueOf5, numValueOf6, text21, text22, numValueOf7, dValueOf, text23, text24, text25, text26, lValueOf2, lValueOf3, lValueOf4, lValueOf5, numValueOf8, dValueOf2, dValueOf3, apdexScoreFromDouble, boolValueOf3, boolValueOf4, j2, text27, text28, sQLiteStatementPrepare.isNull(i41) ? null : sQLiteStatementPrepare.getText(i41)));
                    sQLiteStatementPrepare = sQLiteStatement;
                    columnIndexOrThrow14 = i2;
                    columnIndexOrThrow16 = i4;
                    arrayList = arrayList2;
                    columnIndexOrThrow47 = i36;
                    columnIndexOrThrow48 = i37;
                    columnIndexOrThrow49 = i38;
                    columnIndexOrThrow50 = i39;
                    columnIndexOrThrow4 = i10;
                    columnIndexOrThrow21 = i9;
                    columnIndexOrThrow25 = i15;
                    columnIndexOrThrow27 = i17;
                    columnIndexOrThrow29 = i19;
                    columnIndexOrThrow30 = i20;
                    columnIndexOrThrow32 = i22;
                    columnIndexOrThrow33 = i23;
                    columnIndexOrThrow34 = i24;
                    columnIndexOrThrow35 = i25;
                    columnIndexOrThrow43 = i33;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow2 = columnIndexOrThrow2;
                    columnIndexOrThrow26 = i16;
                    columnIndexOrThrow44 = i34;
                    columnIndexOrThrow3 = columnIndexOrThrow3;
                    columnIndexOrThrow15 = i3;
                    columnIndexOrThrow20 = i8;
                    columnIndexOrThrow22 = i12;
                    columnIndexOrThrow28 = i18;
                    columnIndexOrThrow45 = i35;
                } catch (Throwable th) {
                    th = th;
                }
                th = th;
                sQLiteStatement.close();
                throw th;
            }
            SQLiteStatement sQLiteStatement2 = sQLiteStatementPrepare;
            ArrayList arrayList3 = arrayList;
            sQLiteStatement2.close();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            sQLiteStatement = sQLiteStatementPrepare;
        }
    }

    @Override // com.box.android.data.persistence.logging.MetricsDao
    public Object getCount(Continuation<? super Integer> continuation) {
        final String str = "SELECT COUNT(*) FROM metricsLogs";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.logging.MetricsDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(MetricsDao_Impl.getCount$lambda$0(str, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getCount$lambda$0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            return sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.logging.MetricsDao
    public Object deleteMetricsByUserId(final String str, Continuation<? super Unit> continuation) {
        final String str2 = "DELETE FROM metricsLogs WHERE user_id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.logging.MetricsDao_Impl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MetricsDao_Impl.deleteMetricsByUserId$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteMetricsByUserId$lambda$0(String str, String str2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10944bindText(1, str2);
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.logging.MetricsDao
    public Object deleteMetricsByUserIdNotNullOrEmpty(Continuation<? super Unit> continuation) {
        final String str = "DELETE FROM metricsLogs WHERE user_id != '' AND user_id IS NOT NULL";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.logging.MetricsDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MetricsDao_Impl.deleteMetricsByUserIdNotNullOrEmpty$lambda$0(str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteMetricsByUserIdNotNullOrEmpty$lambda$0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: compiled from: MetricsDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/persistence/logging/MetricsDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<KClass<?>> getRequiredConverters() {
            return CollectionsKt.emptyList();
        }
    }
}
