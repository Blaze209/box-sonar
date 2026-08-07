package com.box.android.data.persistence.annotations;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.box.android.data.persistence.DateToLongConverter;
import java.util.ArrayList;
import java.util.Date;
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
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: AnnotationsDao_Impl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/box/android/data/persistence/annotations/AnnotationsDao_Impl;", "Lcom/box/android/data/persistence/annotations/AnnotationsDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfAnnotationEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/box/android/data/persistence/annotations/AnnotationEntity;", "__dateToLongConverter", "Lcom/box/android/data/persistence/DateToLongConverter;", "__fileActivityStatusConverter", "Lcom/box/android/data/persistence/annotations/FileActivityStatusConverter;", "__updateAdapterOfAnnotationEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "insertAnnotation", "", "annotationEntity", "(Lcom/box/android/data/persistence/annotations/AnnotationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAnnotation", "getAnnotationForFileVersionId", "Lkotlinx/coroutines/flow/Flow;", "", "fileVersionId", "", "deleteAnnotations", "", "fetchedBefore", "Ljava/util/Date;", "(Ljava/util/Date;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAnnotation", "annotationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnnotationsDao_Impl implements AnnotationsDao {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DateToLongConverter __dateToLongConverter;
    private final RoomDatabase __db;
    private final FileActivityStatusConverter __fileActivityStatusConverter;
    private final EntityInsertAdapter<AnnotationEntity> __insertAdapterOfAnnotationEntity;
    private final EntityDeleteOrUpdateAdapter<AnnotationEntity> __updateAdapterOfAnnotationEntity;

    public AnnotationsDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__dateToLongConverter = new DateToLongConverter();
        this.__fileActivityStatusConverter = new FileActivityStatusConverter();
        this.__db = __db;
        this.__insertAdapterOfAnnotationEntity = new EntityInsertAdapter<AnnotationEntity>() { // from class: com.box.android.data.persistence.annotations.AnnotationsDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `annotations` (`annotation_id`,`file_version_id`,`file_version_number`,`created_at`,`created_by_json_data`,`modified_at`,`modified_by_json_data`,`description_json_data`,`location_json_data`,`target_json_data`,`permissions_json_data`,`network_fetched_at`,`total_reply_count`,`status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, AnnotationEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo10944bindText(1, entity.getAnnotationId());
                statement.mo10944bindText(2, entity.getFileVersionId());
                statement.mo10942bindLong(3, entity.getFileVersionNumber());
                Long lDateToTimestamp = AnnotationsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getCreatedAt());
                if (lDateToTimestamp == null) {
                    statement.mo10943bindNull(4);
                } else {
                    statement.mo10942bindLong(4, lDateToTimestamp.longValue());
                }
                statement.mo10940bindBlob(5, entity.getCreatedByJsonData());
                Long lDateToTimestamp2 = AnnotationsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getModifiedAt());
                if (lDateToTimestamp2 == null) {
                    statement.mo10943bindNull(6);
                } else {
                    statement.mo10942bindLong(6, lDateToTimestamp2.longValue());
                }
                statement.mo10940bindBlob(7, entity.getModifiedByJsonData());
                statement.mo10940bindBlob(8, entity.getDescriptionJsonData());
                statement.mo10940bindBlob(9, entity.getLocationJsonData());
                statement.mo10940bindBlob(10, entity.getTargetJsonData());
                statement.mo10940bindBlob(11, entity.getPermissionsJsonData());
                Long lDateToTimestamp3 = AnnotationsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getNetworkFetchedAt());
                if (lDateToTimestamp3 == null) {
                    statement.mo10943bindNull(12);
                } else {
                    statement.mo10942bindLong(12, lDateToTimestamp3.longValue());
                }
                statement.mo10942bindLong(13, entity.getTotalReplyCount());
                statement.mo10944bindText(14, AnnotationsDao_Impl.this.__fileActivityStatusConverter.toString(entity.getStatus()));
            }
        };
        this.__updateAdapterOfAnnotationEntity = new EntityDeleteOrUpdateAdapter<AnnotationEntity>() { // from class: com.box.android.data.persistence.annotations.AnnotationsDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "UPDATE OR ABORT `annotations` SET `annotation_id` = ?,`file_version_id` = ?,`file_version_number` = ?,`created_at` = ?,`created_by_json_data` = ?,`modified_at` = ?,`modified_by_json_data` = ?,`description_json_data` = ?,`location_json_data` = ?,`target_json_data` = ?,`permissions_json_data` = ?,`network_fetched_at` = ?,`total_reply_count` = ?,`status` = ? WHERE `annotation_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, AnnotationEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo10944bindText(1, entity.getAnnotationId());
                statement.mo10944bindText(2, entity.getFileVersionId());
                statement.mo10942bindLong(3, entity.getFileVersionNumber());
                Long lDateToTimestamp = AnnotationsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getCreatedAt());
                if (lDateToTimestamp == null) {
                    statement.mo10943bindNull(4);
                } else {
                    statement.mo10942bindLong(4, lDateToTimestamp.longValue());
                }
                statement.mo10940bindBlob(5, entity.getCreatedByJsonData());
                Long lDateToTimestamp2 = AnnotationsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getModifiedAt());
                if (lDateToTimestamp2 == null) {
                    statement.mo10943bindNull(6);
                } else {
                    statement.mo10942bindLong(6, lDateToTimestamp2.longValue());
                }
                statement.mo10940bindBlob(7, entity.getModifiedByJsonData());
                statement.mo10940bindBlob(8, entity.getDescriptionJsonData());
                statement.mo10940bindBlob(9, entity.getLocationJsonData());
                statement.mo10940bindBlob(10, entity.getTargetJsonData());
                statement.mo10940bindBlob(11, entity.getPermissionsJsonData());
                Long lDateToTimestamp3 = AnnotationsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getNetworkFetchedAt());
                if (lDateToTimestamp3 == null) {
                    statement.mo10943bindNull(12);
                } else {
                    statement.mo10942bindLong(12, lDateToTimestamp3.longValue());
                }
                statement.mo10942bindLong(13, entity.getTotalReplyCount());
                statement.mo10944bindText(14, AnnotationsDao_Impl.this.__fileActivityStatusConverter.toString(entity.getStatus()));
                statement.mo10944bindText(15, entity.getAnnotationId());
            }
        };
    }

    @Override // com.box.android.data.persistence.annotations.AnnotationsDao
    public Object insertAnnotation(final AnnotationEntity annotationEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.annotations.AnnotationsDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AnnotationsDao_Impl.insertAnnotation$lambda$0(this.f$0, annotationEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertAnnotation$lambda$0(AnnotationsDao_Impl annotationsDao_Impl, AnnotationEntity annotationEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        annotationsDao_Impl.__insertAdapterOfAnnotationEntity.insert(_connection, annotationEntity);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.annotations.AnnotationsDao
    public Object updateAnnotation(final AnnotationEntity annotationEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.annotations.AnnotationsDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AnnotationsDao_Impl.updateAnnotation$lambda$0(this.f$0, annotationEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateAnnotation$lambda$0(AnnotationsDao_Impl annotationsDao_Impl, AnnotationEntity annotationEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        annotationsDao_Impl.__updateAdapterOfAnnotationEntity.handle(_connection, annotationEntity);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.annotations.AnnotationsDao
    public Flow<List<AnnotationEntity>> getAnnotationForFileVersionId(final String fileVersionId) {
        Intrinsics.checkNotNullParameter(fileVersionId, "fileVersionId");
        final String str = "SELECT * FROM annotations WHERE file_version_id = ?";
        return FlowUtil.createFlow(this.__db, false, new String[]{"annotations"}, new Function1() { // from class: com.box.android.data.persistence.annotations.AnnotationsDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AnnotationsDao_Impl.getAnnotationForFileVersionId$lambda$0(str, fileVersionId, this, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAnnotationForFileVersionId$lambda$0(String str, String str2, AnnotationsDao_Impl annotationsDao_Impl, SQLiteConnection _connection) throws Throwable {
        SQLiteStatement sQLiteStatement;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10944bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "annotation_id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "file_version_id");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "file_version_number");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "created_at");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "created_by_json_data");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "modified_at");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "modified_by_json_data");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "description_json_data");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "location_json_data");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "target_json_data");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "permissions_json_data");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "network_fetched_at");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "total_reply_count");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "status");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                int i = columnIndexOrThrow;
                int i2 = columnIndexOrThrow2;
                int i3 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                Date dateFromTimestamp = annotationsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow4)));
                if (dateFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                byte[] blob = sQLiteStatementPrepare.getBlob(columnIndexOrThrow5);
                Date dateFromTimestamp2 = annotationsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6)));
                if (dateFromTimestamp2 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                byte[] blob2 = sQLiteStatementPrepare.getBlob(columnIndexOrThrow7);
                byte[] blob3 = sQLiteStatementPrepare.getBlob(columnIndexOrThrow8);
                byte[] blob4 = sQLiteStatementPrepare.getBlob(columnIndexOrThrow9);
                byte[] blob5 = sQLiteStatementPrepare.getBlob(columnIndexOrThrow10);
                byte[] blob6 = sQLiteStatementPrepare.getBlob(columnIndexOrThrow11);
                Date dateFromTimestamp3 = annotationsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow12)));
                if (dateFromTimestamp3 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                int i4 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow13);
                int i5 = columnIndexOrThrow14;
                sQLiteStatement = sQLiteStatementPrepare;
                try {
                    FileActivityStatus fileActivityStatusFromString = annotationsDao_Impl.__fileActivityStatusConverter.fromString(sQLiteStatementPrepare.getText(i5));
                    if (fileActivityStatusFromString == null) {
                        throw new IllegalStateException("Expected NON-NULL 'com.box.android.`data`.persistence.annotations.FileActivityStatus', but it was NULL.".toString());
                    }
                    arrayList.add(new AnnotationEntity(text, text2, i3, dateFromTimestamp, blob, dateFromTimestamp2, blob2, blob3, blob4, blob5, blob6, dateFromTimestamp3, i4, fileActivityStatusFromString));
                    sQLiteStatementPrepare = sQLiteStatement;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow14 = i5;
                    columnIndexOrThrow2 = i2;
                } catch (Throwable th) {
                    th = th;
                    sQLiteStatement.close();
                    throw th;
                }
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            sQLiteStatement = sQLiteStatementPrepare;
        }
    }

    @Override // com.box.android.data.persistence.annotations.AnnotationsDao
    public Object deleteAnnotations(final Date date, final String str, Continuation<? super Integer> continuation) {
        final String str2 = "DELETE FROM annotations WHERE network_fetched_at < ? AND file_version_id = ?";
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.annotations.AnnotationsDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(AnnotationsDao_Impl.deleteAnnotations$lambda$0(str2, this, date, str, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int deleteAnnotations$lambda$0(String str, AnnotationsDao_Impl annotationsDao_Impl, Date date, String str2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            Long lDateToTimestamp = annotationsDao_Impl.__dateToLongConverter.dateToTimestamp(date);
            if (lDateToTimestamp == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10942bindLong(1, lDateToTimestamp.longValue());
            }
            sQLiteStatementPrepare.mo10944bindText(2, str2);
            sQLiteStatementPrepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(_connection);
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.annotations.AnnotationsDao
    public Object deleteAnnotation(final String str, Continuation<? super Unit> continuation) {
        final String str2 = "DELETE FROM annotations where annotation_id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.annotations.AnnotationsDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AnnotationsDao_Impl.deleteAnnotation$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteAnnotation$lambda$0(String str, String str2, SQLiteConnection _connection) {
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

    /* JADX INFO: compiled from: AnnotationsDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/persistence/annotations/AnnotationsDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
