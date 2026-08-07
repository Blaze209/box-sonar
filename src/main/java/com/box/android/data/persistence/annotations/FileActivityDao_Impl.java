package com.box.android.data.persistence.annotations;

import androidx.collection.ArrayMap;
import androidx.core.provider.FontsContractCompat;
import androidx.paging.DataSource;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.coroutines.FlowUtil;
import androidx.room.paging.LimitOffsetDataSource;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.box.android.activities.urlsinterceptor.WebUrlsInterceptorActivity;
import com.box.android.data.persistence.DateToLongConverter;
import com.box.android.domain.localrepo.sqlitetables.BoxItemSQLData;
import com.box.androidsdk.content.requests.BoxRequestsSearch;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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

/* JADX INFO: compiled from: FileActivityDao_Impl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 @2\u00020\u0001:\u0001@B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u001cJ\u001c\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e2\u0006\u0010!\u001a\u00020\"H\u0016J\u001c\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0%0$2\u0006\u0010!\u001a\u00020\"H\u0016J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020'0%2\u0006\u0010(\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0016J\u001e\u0010+\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010,\u001a\u00020-H\u0096@¢\u0006\u0002\u0010.J\u001e\u0010/\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010,\u001a\u00020-H\u0096@¢\u0006\u0002\u0010.J\u001e\u00100\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010,\u001a\u00020-H\u0096@¢\u0006\u0002\u0010.J\u001e\u00101\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010,\u001a\u00020-H\u0096@¢\u0006\u0002\u0010.J\u001e\u00102\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010,\u001a\u00020-H\u0096@¢\u0006\u0002\u0010.J\u000e\u00103\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u00104J\u000e\u00105\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u00104J&\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u0002082\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010'0:H\u0002J&\u0010;\u001a\u00020\u00142\u0006\u00107\u001a\u0002082\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010<0:H\u0002J&\u0010=\u001a\u00020\u00142\u0006\u00107\u001a\u0002082\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010\u000e0:H\u0002J&\u0010>\u001a\u00020\u00142\u0006\u00107\u001a\u0002082\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010?0:H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/box/android/data/persistence/annotations/FileActivityDao_Impl;", "Lcom/box/android/data/persistence/annotations/FileActivityDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfFileActivityEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/box/android/data/persistence/annotations/FileActivityEntity;", "__activityTypeConverter", "Lcom/box/android/data/persistence/annotations/ActivityTypeConverter;", "__dateToLongConverter", "Lcom/box/android/data/persistence/DateToLongConverter;", "__insertAdapterOfFileVersionEntity", "Lcom/box/android/data/persistence/annotations/FileVersionEntity;", "__insertAdapterOfGroupedFileVersionsEntity", "Lcom/box/android/data/persistence/annotations/GroupedFileVersionsEntity;", "__fileActivityStatusConverter", "Lcom/box/android/data/persistence/annotations/FileActivityStatusConverter;", "insertActivity", "", "activityEntity", "(Lcom/box/android/data/persistence/annotations/FileActivityEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertFileVersion", "fileVersionEntity", "(Lcom/box/android/data/persistence/annotations/FileVersionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertGroupedVersion", "groupedFileVersionsEntity", "(Lcom/box/android/data/persistence/annotations/GroupedFileVersionsEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActivities", "Landroidx/paging/DataSource$Factory;", "", "Lcom/box/android/data/persistence/annotations/FileActivityEntities;", "fileId", "", "getActivitiesV2", "Lkotlinx/coroutines/flow/Flow;", "", "getRepliesForFileActivity", "Lcom/box/android/data/persistence/annotations/CommentEntity;", "activityId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementOrderNumber", "deleteComments", "fetchedBefore", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteReplies", "deleteAnnotations", "deleteVersions", "deleteFileActivities", "cleanupAnnotations", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanupComments", "__fetchRelationshipcommentsAscomBoxAndroidDataPersistenceAnnotationsCommentEntity", "_connection", "Landroidx/sqlite/SQLiteConnection;", "_map", "Landroidx/collection/ArrayMap;", "__fetchRelationshipannotationsAscomBoxAndroidDataPersistenceAnnotationsAnnotationEntity", "Lcom/box/android/data/persistence/annotations/AnnotationEntity;", "__fetchRelationshipfileVersionsAscomBoxAndroidDataPersistenceAnnotationsFileVersionEntity", "__fetchRelationshipgroupedFileVersionsAscomBoxAndroidDataPersistenceAnnotationsGroupedFileVersionEntities", "Lcom/box/android/data/persistence/annotations/GroupedFileVersionEntities;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileActivityDao_Impl implements FileActivityDao {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ActivityTypeConverter __activityTypeConverter;
    private final DateToLongConverter __dateToLongConverter;
    private final RoomDatabase __db;
    private final FileActivityStatusConverter __fileActivityStatusConverter;
    private final EntityInsertAdapter<FileActivityEntity> __insertAdapterOfFileActivityEntity;
    private final EntityInsertAdapter<FileVersionEntity> __insertAdapterOfFileVersionEntity;
    private final EntityInsertAdapter<GroupedFileVersionsEntity> __insertAdapterOfGroupedFileVersionsEntity;

    public FileActivityDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__activityTypeConverter = new ActivityTypeConverter();
        this.__dateToLongConverter = new DateToLongConverter();
        this.__fileActivityStatusConverter = new FileActivityStatusConverter();
        this.__db = __db;
        this.__insertAdapterOfFileActivityEntity = new EntityInsertAdapter<FileActivityEntity>() { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `file_activity` (`activity_id`,`type`,`file_id`,`created_at`,`network_fetched_at`,`order_number`) VALUES (?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, FileActivityEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo10944bindText(1, entity.getActivityId());
                String string = FileActivityDao_Impl.this.__activityTypeConverter.toString(entity.getType());
                if (string == null) {
                    statement.mo10943bindNull(2);
                } else {
                    statement.mo10944bindText(2, string);
                }
                statement.mo10944bindText(3, entity.getFileId());
                Long lDateToTimestamp = FileActivityDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getCreatedAt());
                if (lDateToTimestamp == null) {
                    statement.mo10943bindNull(4);
                } else {
                    statement.mo10942bindLong(4, lDateToTimestamp.longValue());
                }
                Long lDateToTimestamp2 = FileActivityDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getNetworkFetchedAt());
                if (lDateToTimestamp2 == null) {
                    statement.mo10943bindNull(5);
                } else {
                    statement.mo10942bindLong(5, lDateToTimestamp2.longValue());
                }
                statement.mo10942bindLong(6, entity.getOrder());
            }
        };
        this.__insertAdapterOfFileVersionEntity = new EntityInsertAdapter<FileVersionEntity>() { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl.2
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `file_versions` (`version_id`,`file_id`,`created_at`,`number`,`network_fetched_at`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, FileVersionEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo10944bindText(1, entity.getVersionId());
                statement.mo10944bindText(2, entity.getFileId());
                Long lDateToTimestamp = FileActivityDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getCreatedAt());
                if (lDateToTimestamp == null) {
                    statement.mo10943bindNull(3);
                } else {
                    statement.mo10942bindLong(3, lDateToTimestamp.longValue());
                }
                statement.mo10942bindLong(4, entity.getNumber());
                Long lDateToTimestamp2 = FileActivityDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getNetworkFetchedAt());
                if (lDateToTimestamp2 == null) {
                    statement.mo10943bindNull(5);
                } else {
                    statement.mo10942bindLong(5, lDateToTimestamp2.longValue());
                }
            }
        };
        this.__insertAdapterOfGroupedFileVersionsEntity = new EntityInsertAdapter<GroupedFileVersionsEntity>() { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl.3
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `grouped_file_versions` (`start_id`,`end_id`,`file_id`,`created_by_json_data`,`network_fetched_at`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, GroupedFileVersionsEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo10944bindText(1, entity.getStartId());
                statement.mo10944bindText(2, entity.getEndId());
                statement.mo10944bindText(3, entity.getFileId());
                statement.mo10940bindBlob(4, entity.getCreatedByJsonData());
                Long lDateToTimestamp = FileActivityDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getNetworkFetchedAt());
                if (lDateToTimestamp == null) {
                    statement.mo10943bindNull(5);
                } else {
                    statement.mo10942bindLong(5, lDateToTimestamp.longValue());
                }
            }
        };
    }

    @Override // com.box.android.data.persistence.annotations.FileActivityDao
    public Object insertActivity(final FileActivityEntity fileActivityEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileActivityDao_Impl.insertActivity$lambda$0(this.f$0, fileActivityEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertActivity$lambda$0(FileActivityDao_Impl fileActivityDao_Impl, FileActivityEntity fileActivityEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        fileActivityDao_Impl.__insertAdapterOfFileActivityEntity.insert(_connection, fileActivityEntity);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.annotations.FileActivityDao
    public Object insertFileVersion(final FileVersionEntity fileVersionEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileActivityDao_Impl.insertFileVersion$lambda$0(this.f$0, fileVersionEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertFileVersion$lambda$0(FileActivityDao_Impl fileActivityDao_Impl, FileVersionEntity fileVersionEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        fileActivityDao_Impl.__insertAdapterOfFileVersionEntity.insert(_connection, fileVersionEntity);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.annotations.FileActivityDao
    public Object insertGroupedVersion(final GroupedFileVersionsEntity groupedFileVersionsEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileActivityDao_Impl.insertGroupedVersion$lambda$0(this.f$0, groupedFileVersionsEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertGroupedVersion$lambda$0(FileActivityDao_Impl fileActivityDao_Impl, GroupedFileVersionsEntity groupedFileVersionsEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        fileActivityDao_Impl.__insertAdapterOfGroupedFileVersionsEntity.insert(_connection, groupedFileVersionsEntity);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.annotations.FileActivityDao
    public DataSource.Factory<Integer, FileActivityEntities> getActivities(String fileId) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.INSTANCE.acquire("select * from file_activity where file_id = ? order by order_number DESC", 1);
        roomSQLiteQueryAcquire.bindText(1, fileId);
        return new DataSource.Factory<Integer, FileActivityEntities>() { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl.getActivities.1
            @Override // androidx.paging.DataSource.Factory
            public DataSource<Integer, FileActivityEntities> create() {
                final SQLiteConnection sQLiteConnection = DBUtil.toSQLiteConnection(FileActivityDao_Impl.this.__db.getOpenHelper().getWritableDatabase());
                final RoomDatabase roomDatabase = FileActivityDao_Impl.this.__db;
                final String[] strArr = {BoxRequestsSearch.Search.CONTENT_TYPE_COMMENTS, "annotations", "file_versions", "grouped_file_versions", "file_activity"};
                final RoomSQLiteQuery roomSQLiteQuery = roomSQLiteQueryAcquire;
                final FileActivityDao_Impl fileActivityDao_Impl = FileActivityDao_Impl.this;
                return new LimitOffsetDataSource<FileActivityEntities>(roomSQLiteQuery, roomDatabase, strArr) { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl$getActivities$1$create$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // androidx.room.paging.LimitOffsetDataSource
                    protected List<FileActivityEntities> convertRows(SQLiteStatement statement) {
                        String str;
                        FileActivityDao_Impl$getActivities$1$create$1 fileActivityDao_Impl$getActivities$1$create$1 = this;
                        Intrinsics.checkNotNullParameter(statement, "statement");
                        int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(statement, WebUrlsInterceptorActivity.ACTIVITY_ID_QUERY);
                        int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(statement, "type");
                        int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(statement, FontsContractCompat.Columns.FILE_ID);
                        int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(statement, "created_at");
                        int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(statement, "network_fetched_at");
                        int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(statement, "order_number");
                        ArrayMap arrayMap = new ArrayMap();
                        ArrayMap arrayMap2 = new ArrayMap();
                        ArrayMap arrayMap3 = new ArrayMap();
                        while (true) {
                            str = null;
                            if (!statement.step()) {
                                break;
                            }
                            arrayMap.put(statement.getText(columnIndexOrThrow), null);
                            arrayMap2.put(statement.getText(columnIndexOrThrow), null);
                            arrayMap3.put(statement.getText(columnIndexOrThrow), null);
                        }
                        statement.reset();
                        fileActivityDao_Impl.__fetchRelationshipcommentsAscomBoxAndroidDataPersistenceAnnotationsCommentEntity(sQLiteConnection, arrayMap);
                        fileActivityDao_Impl.__fetchRelationshipannotationsAscomBoxAndroidDataPersistenceAnnotationsAnnotationEntity(sQLiteConnection, arrayMap2);
                        fileActivityDao_Impl.__fetchRelationshipgroupedFileVersionsAscomBoxAndroidDataPersistenceAnnotationsGroupedFileVersionEntities(sQLiteConnection, arrayMap3);
                        ArrayList arrayList = new ArrayList();
                        while (statement.step()) {
                            String text = statement.getText(columnIndexOrThrow);
                            FileActivityType fileActivityTypeFromString = fileActivityDao_Impl.__activityTypeConverter.fromString(statement.isNull(columnIndexOrThrow2) ? str : statement.getText(columnIndexOrThrow2));
                            if (fileActivityTypeFromString == null) {
                                throw new IllegalStateException("Expected NON-NULL 'com.box.android.`data`.persistence.annotations.FileActivityType', but it was NULL.".toString());
                            }
                            String text2 = statement.getText(columnIndexOrThrow3);
                            Date dateFromTimestamp = fileActivityDao_Impl.__dateToLongConverter.fromTimestamp(statement.isNull(columnIndexOrThrow4) ? str : Long.valueOf(statement.getLong(columnIndexOrThrow4)));
                            if (dateFromTimestamp != null) {
                                Date dateFromTimestamp2 = fileActivityDao_Impl.__dateToLongConverter.fromTimestamp(statement.isNull(columnIndexOrThrow5) ? str : Long.valueOf(statement.getLong(columnIndexOrThrow5)));
                                if (dateFromTimestamp2 == null) {
                                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                                }
                                arrayList.add(new FileActivityEntities(new FileActivityEntity(text, fileActivityTypeFromString, text2, dateFromTimestamp, dateFromTimestamp2, (int) statement.getLong(columnIndexOrThrow6)), (CommentEntity) arrayMap.get(statement.getText(columnIndexOrThrow)), (AnnotationEntity) arrayMap2.get(statement.getText(columnIndexOrThrow)), (GroupedFileVersionEntities) arrayMap3.get(statement.getText(columnIndexOrThrow))));
                                str = null;
                                fileActivityDao_Impl$getActivities$1$create$1 = this;
                            } else {
                                throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                            }
                        }
                        return arrayList;
                    }
                };
            }
        };
    }

    @Override // com.box.android.data.persistence.annotations.FileActivityDao
    public Flow<List<FileActivityEntities>> getActivitiesV2(final String fileId) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        final String str = "select * from file_activity where file_id = ? order by order_number DESC";
        return FlowUtil.createFlow(this.__db, true, new String[]{BoxRequestsSearch.Search.CONTENT_TYPE_COMMENTS, "annotations", "file_versions", "grouped_file_versions", "file_activity"}, new Function1() { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileActivityDao_Impl.getActivitiesV2$lambda$0(str, fileId, this, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final List getActivitiesV2$lambda$0(String str, String str2, FileActivityDao_Impl fileActivityDao_Impl, SQLiteConnection _connection) {
        String str3;
        FileActivityDao_Impl fileActivityDao_Impl2 = fileActivityDao_Impl;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10944bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, WebUrlsInterceptorActivity.ACTIVITY_ID_QUERY);
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, FontsContractCompat.Columns.FILE_ID);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "created_at");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "network_fetched_at");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "order_number");
            ArrayMap<String, CommentEntity> arrayMap = new ArrayMap<>();
            ArrayMap<String, AnnotationEntity> arrayMap2 = new ArrayMap<>();
            ArrayMap<String, GroupedFileVersionEntities> arrayMap3 = new ArrayMap<>();
            while (true) {
                str3 = null;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
            }
            sQLiteStatementPrepare.reset();
            fileActivityDao_Impl2.__fetchRelationshipcommentsAscomBoxAndroidDataPersistenceAnnotationsCommentEntity(_connection, arrayMap);
            fileActivityDao_Impl2.__fetchRelationshipannotationsAscomBoxAndroidDataPersistenceAnnotationsAnnotationEntity(_connection, arrayMap2);
            fileActivityDao_Impl2.__fetchRelationshipgroupedFileVersionsAscomBoxAndroidDataPersistenceAnnotationsGroupedFileVersionEntities(_connection, arrayMap3);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                FileActivityType fileActivityTypeFromString = fileActivityDao_Impl2.__activityTypeConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? str3 : sQLiteStatementPrepare.getText(columnIndexOrThrow2));
                if (fileActivityTypeFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.`data`.persistence.annotations.FileActivityType', but it was NULL.".toString());
                }
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                Date dateFromTimestamp = fileActivityDao_Impl2.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? str3 : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow4)));
                if (dateFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                Date dateFromTimestamp2 = fileActivityDao_Impl2.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? str3 : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                if (dateFromTimestamp2 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                arrayList.add(new FileActivityEntities(new FileActivityEntity(text, fileActivityTypeFromString, text2, dateFromTimestamp, dateFromTimestamp2, (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)), arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                fileActivityDao_Impl2 = fileActivityDao_Impl;
                str3 = null;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.annotations.FileActivityDao
    public Object getRepliesForFileActivity(final String str, Continuation<? super List<CommentEntity>> continuation) {
        final String str2 = "select * from comments where parent_id = ? order by created_at";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileActivityDao_Impl.getRepliesForFileActivity$lambda$0(str2, str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getRepliesForFileActivity$lambda$0(String str, String str2, FileActivityDao_Impl fileActivityDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10944bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "comment_id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "created_at");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, FontsContractCompat.Columns.FILE_ID);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "json_data");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "network_fetched_at");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "total_reply_count");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "status");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, BoxItemSQLData.COL_PARENT_ID);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                Date dateFromTimestamp = fileActivityDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow2)));
                if (dateFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                byte[] blob = sQLiteStatementPrepare.getBlob(columnIndexOrThrow4);
                int i = columnIndexOrThrow;
                Date dateFromTimestamp2 = fileActivityDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                if (dateFromTimestamp2 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                int i2 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                FileActivityStatus fileActivityStatusFromString = fileActivityDao_Impl.__fileActivityStatusConverter.fromString(sQLiteStatementPrepare.getText(columnIndexOrThrow7));
                if (fileActivityStatusFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.`data`.persistence.annotations.FileActivityStatus', but it was NULL.".toString());
                }
                arrayList.add(new CommentEntity(text, dateFromTimestamp, text2, blob, dateFromTimestamp2, i2, fileActivityStatusFromString, sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8)));
                columnIndexOrThrow = i;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.annotations.FileActivityDao
    public int incrementOrderNumber(final String fileId) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        final String str = "UPDATE file_activity SET order_number = order_number + 1 where file_id = ?";
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(FileActivityDao_Impl.incrementOrderNumber$lambda$0(str, fileId, (SQLiteConnection) obj));
            }
        })).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int incrementOrderNumber$lambda$0(String str, String str2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10944bindText(1, str2);
            sQLiteStatementPrepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(_connection);
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.annotations.FileActivityDao
    public Object deleteComments(final String str, final Date date, Continuation<? super Unit> continuation) {
        final String str2 = "DELETE FROM comments WHERE comment_id IN (SELECT comment_id from comments INNER JOIN file_activity ON activity_id = comment_id WHERE file_activity.file_id = ? AND file_activity.type = \"comment\"  AND  file_activity.network_fetched_at < ?)";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileActivityDao_Impl.deleteComments$lambda$0(str2, str, this, date, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteComments$lambda$0(String str, String str2, FileActivityDao_Impl fileActivityDao_Impl, Date date, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10944bindText(1, str2);
            Long lDateToTimestamp = fileActivityDao_Impl.__dateToLongConverter.dateToTimestamp(date);
            if (lDateToTimestamp == null) {
                sQLiteStatementPrepare.mo10943bindNull(2);
            } else {
                sQLiteStatementPrepare.mo10942bindLong(2, lDateToTimestamp.longValue());
            }
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.annotations.FileActivityDao
    public Object deleteReplies(final String str, final Date date, Continuation<? super Unit> continuation) {
        final String str2 = "DELETE FROM comments WHERE network_fetched_at < ? AND parent_id IN (SELECT activity_id FROM file_activity WHERE file_activity.file_id = ?)";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileActivityDao_Impl.deleteReplies$lambda$0(str2, this, date, str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteReplies$lambda$0(String str, FileActivityDao_Impl fileActivityDao_Impl, Date date, String str2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            Long lDateToTimestamp = fileActivityDao_Impl.__dateToLongConverter.dateToTimestamp(date);
            if (lDateToTimestamp == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10942bindLong(1, lDateToTimestamp.longValue());
            }
            sQLiteStatementPrepare.mo10944bindText(2, str2);
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.annotations.FileActivityDao
    public Object deleteAnnotations(final String str, final Date date, Continuation<? super Unit> continuation) {
        final String str2 = "DELETE FROM annotations WHERE annotation_id IN (SELECT annotation_id from annotations INNER JOIN file_activity ON activity_id = annotation_id WHERE file_activity.file_id = ? AND file_activity.type = \"annotation\" AND file_activity.network_fetched_at < ?)";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileActivityDao_Impl.deleteAnnotations$lambda$0(str2, str, this, date, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteAnnotations$lambda$0(String str, String str2, FileActivityDao_Impl fileActivityDao_Impl, Date date, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10944bindText(1, str2);
            Long lDateToTimestamp = fileActivityDao_Impl.__dateToLongConverter.dateToTimestamp(date);
            if (lDateToTimestamp == null) {
                sQLiteStatementPrepare.mo10943bindNull(2);
            } else {
                sQLiteStatementPrepare.mo10942bindLong(2, lDateToTimestamp.longValue());
            }
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.annotations.FileActivityDao
    public Object deleteVersions(final String str, final Date date, Continuation<? super Unit> continuation) {
        final String str2 = "DELETE FROM grouped_file_versions WHERE start_id IN (SELECT start_id from grouped_file_versions INNER JOIN file_activity ON activity_id = start_id WHERE file_activity.file_id = ? AND file_activity.type = \"versions\" AND file_activity.network_fetched_at < ?)";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileActivityDao_Impl.deleteVersions$lambda$0(str2, str, this, date, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteVersions$lambda$0(String str, String str2, FileActivityDao_Impl fileActivityDao_Impl, Date date, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10944bindText(1, str2);
            Long lDateToTimestamp = fileActivityDao_Impl.__dateToLongConverter.dateToTimestamp(date);
            if (lDateToTimestamp == null) {
                sQLiteStatementPrepare.mo10943bindNull(2);
            } else {
                sQLiteStatementPrepare.mo10942bindLong(2, lDateToTimestamp.longValue());
            }
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.annotations.FileActivityDao
    public Object deleteFileActivities(final String str, final Date date, Continuation<? super Unit> continuation) {
        final String str2 = "DELETE from file_activity WHERE file_id = ? AND network_fetched_at < ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileActivityDao_Impl.deleteFileActivities$lambda$0(str2, str, this, date, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteFileActivities$lambda$0(String str, String str2, FileActivityDao_Impl fileActivityDao_Impl, Date date, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10944bindText(1, str2);
            Long lDateToTimestamp = fileActivityDao_Impl.__dateToLongConverter.dateToTimestamp(date);
            if (lDateToTimestamp == null) {
                sQLiteStatementPrepare.mo10943bindNull(2);
            } else {
                sQLiteStatementPrepare.mo10942bindLong(2, lDateToTimestamp.longValue());
            }
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.annotations.FileActivityDao
    public Object cleanupAnnotations(Continuation<? super Unit> continuation) {
        final String str = "delete from file_activity where activity_id not in (select activity_id from file_activity, annotations where file_activity.activity_id = annotations.annotation_id)and type = \"annotation\"";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileActivityDao_Impl.cleanupAnnotations$lambda$0(str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cleanupAnnotations$lambda$0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.annotations.FileActivityDao
    public Object cleanupComments(Continuation<? super Unit> continuation) {
        final String str = "delete from file_activity where activity_id not in (select activity_id from file_activity, comments where file_activity.activity_id = comments.comment_id)and type = \"comment\"";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileActivityDao_Impl.cleanupComments$lambda$0(str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cleanupComments$lambda$0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void __fetchRelationshipcommentsAscomBoxAndroidDataPersistenceAnnotationsCommentEntity(final SQLiteConnection _connection, ArrayMap<String, CommentEntity> _map) {
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FileActivityDao_Impl.__fetchRelationshipcommentsAscomBoxAndroidDataPersistenceAnnotationsCommentEntity$lambda$0(this.f$0, _connection, (ArrayMap) obj);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `comment_id`,`created_at`,`file_id`,`json_data`,`network_fetched_at`,`total_reply_count`,`status`,`parent_id` FROM `comments` WHERE `comment_id` IN (");
        StringUtil.appendPlaceholders(sb, setKeySet.size());
        sb.append(")");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(string);
        Iterator<String> it = setKeySet.iterator();
        int i = 1;
        while (it.hasNext()) {
            sQLiteStatementPrepare.mo10944bindText(i, it.next());
            i++;
        }
        try {
            int columnIndex = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "comment_id");
            if (columnIndex != -1) {
                while (sQLiteStatementPrepare.step()) {
                    String text = sQLiteStatementPrepare.getText(columnIndex);
                    if (_map.containsKey(text)) {
                        String text2 = sQLiteStatementPrepare.getText(0);
                        Date dateFromTimestamp = this.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(1) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(1)));
                        if (dateFromTimestamp == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                        }
                        String text3 = sQLiteStatementPrepare.getText(2);
                        byte[] blob = sQLiteStatementPrepare.getBlob(3);
                        Date dateFromTimestamp2 = this.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(4) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(4)));
                        if (dateFromTimestamp2 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                        }
                        int i2 = (int) sQLiteStatementPrepare.getLong(5);
                        FileActivityStatus fileActivityStatusFromString = this.__fileActivityStatusConverter.fromString(sQLiteStatementPrepare.getText(6));
                        if (fileActivityStatusFromString == null) {
                            throw new IllegalStateException("Expected NON-NULL 'com.box.android.`data`.persistence.annotations.FileActivityStatus', but it was NULL.".toString());
                        }
                        _map.put(text, new CommentEntity(text2, dateFromTimestamp, text3, blob, dateFromTimestamp2, i2, fileActivityStatusFromString, sQLiteStatementPrepare.isNull(7) ? null : sQLiteStatementPrepare.getText(7)));
                    }
                }
                sQLiteStatementPrepare.close();
                return;
            }
            sQLiteStatementPrepare.close();
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __fetchRelationshipcommentsAscomBoxAndroidDataPersistenceAnnotationsCommentEntity$lambda$0(FileActivityDao_Impl fileActivityDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        Intrinsics.checkNotNullParameter(_tmpMap, "_tmpMap");
        fileActivityDao_Impl.__fetchRelationshipcommentsAscomBoxAndroidDataPersistenceAnnotationsCommentEntity(sQLiteConnection, _tmpMap);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void __fetchRelationshipannotationsAscomBoxAndroidDataPersistenceAnnotationsAnnotationEntity(final SQLiteConnection _connection, ArrayMap<String, AnnotationEntity> _map) {
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        int i = 0;
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FileActivityDao_Impl.__fetchRelationshipannotationsAscomBoxAndroidDataPersistenceAnnotationsAnnotationEntity$lambda$0(this.f$0, _connection, (ArrayMap) obj);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `annotation_id`,`file_version_id`,`file_version_number`,`created_at`,`created_by_json_data`,`modified_at`,`modified_by_json_data`,`description_json_data`,`location_json_data`,`target_json_data`,`permissions_json_data`,`network_fetched_at`,`total_reply_count`,`status` FROM `annotations` WHERE `annotation_id` IN (");
        StringUtil.appendPlaceholders(sb, setKeySet.size());
        sb.append(")");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(string);
        Iterator<String> it = setKeySet.iterator();
        int i2 = 1;
        int i3 = 1;
        while (it.hasNext()) {
            sQLiteStatementPrepare.mo10944bindText(i3, it.next());
            i3++;
        }
        try {
            int columnIndex = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "annotation_id");
            if (columnIndex != -1) {
                while (sQLiteStatementPrepare.step()) {
                    String text = sQLiteStatementPrepare.getText(columnIndex);
                    if (_map.containsKey(text)) {
                        String text2 = sQLiteStatementPrepare.getText(i);
                        String text3 = sQLiteStatementPrepare.getText(i2);
                        int i4 = (int) sQLiteStatementPrepare.getLong(2);
                        Long lValueOf = null;
                        Date dateFromTimestamp = this.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(3) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(3)));
                        if (dateFromTimestamp == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                        }
                        byte[] blob = sQLiteStatementPrepare.getBlob(4);
                        Date dateFromTimestamp2 = this.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(5)));
                        if (dateFromTimestamp2 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                        }
                        byte[] blob2 = sQLiteStatementPrepare.getBlob(6);
                        byte[] blob3 = sQLiteStatementPrepare.getBlob(7);
                        byte[] blob4 = sQLiteStatementPrepare.getBlob(8);
                        byte[] blob5 = sQLiteStatementPrepare.getBlob(9);
                        byte[] blob6 = sQLiteStatementPrepare.getBlob(10);
                        if (!sQLiteStatementPrepare.isNull(11)) {
                            lValueOf = Long.valueOf(sQLiteStatementPrepare.getLong(11));
                        }
                        Date dateFromTimestamp3 = this.__dateToLongConverter.fromTimestamp(lValueOf);
                        if (dateFromTimestamp3 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                        }
                        int i5 = (int) sQLiteStatementPrepare.getLong(12);
                        FileActivityStatus fileActivityStatusFromString = this.__fileActivityStatusConverter.fromString(sQLiteStatementPrepare.getText(13));
                        if (fileActivityStatusFromString == null) {
                            throw new IllegalStateException("Expected NON-NULL 'com.box.android.`data`.persistence.annotations.FileActivityStatus', but it was NULL.".toString());
                        }
                        _map.put(text, new AnnotationEntity(text2, text3, i4, dateFromTimestamp, blob, dateFromTimestamp2, blob2, blob3, blob4, blob5, blob6, dateFromTimestamp3, i5, fileActivityStatusFromString));
                        i2 = 1;
                        i = 0;
                    }
                }
                sQLiteStatementPrepare.close();
                return;
            }
            sQLiteStatementPrepare.close();
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __fetchRelationshipannotationsAscomBoxAndroidDataPersistenceAnnotationsAnnotationEntity$lambda$0(FileActivityDao_Impl fileActivityDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        Intrinsics.checkNotNullParameter(_tmpMap, "_tmpMap");
        fileActivityDao_Impl.__fetchRelationshipannotationsAscomBoxAndroidDataPersistenceAnnotationsAnnotationEntity(sQLiteConnection, _tmpMap);
        return Unit.INSTANCE;
    }

    private final void __fetchRelationshipfileVersionsAscomBoxAndroidDataPersistenceAnnotationsFileVersionEntity(final SQLiteConnection _connection, ArrayMap<String, FileVersionEntity> _map) {
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FileActivityDao_Impl.__fetchRelationshipfileVersionsAscomBoxAndroidDataPersistenceAnnotationsFileVersionEntity$lambda$0(this.f$0, _connection, (ArrayMap) obj);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `version_id`,`file_id`,`created_at`,`number`,`network_fetched_at` FROM `file_versions` WHERE `version_id` IN (");
        StringUtil.appendPlaceholders(sb, setKeySet.size());
        sb.append(")");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(string);
        Iterator<String> it = setKeySet.iterator();
        int i = 1;
        while (it.hasNext()) {
            sQLiteStatementPrepare.mo10944bindText(i, it.next());
            i++;
        }
        try {
            int columnIndex = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "version_id");
            if (columnIndex != -1) {
                while (sQLiteStatementPrepare.step()) {
                    String text = sQLiteStatementPrepare.getText(columnIndex);
                    if (_map.containsKey(text)) {
                        String text2 = sQLiteStatementPrepare.getText(0);
                        String text3 = sQLiteStatementPrepare.getText(1);
                        Long lValueOf = null;
                        Date dateFromTimestamp = this.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(2) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(2)));
                        if (dateFromTimestamp == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                        }
                        int i2 = (int) sQLiteStatementPrepare.getLong(3);
                        if (!sQLiteStatementPrepare.isNull(4)) {
                            lValueOf = Long.valueOf(sQLiteStatementPrepare.getLong(4));
                        }
                        Date dateFromTimestamp2 = this.__dateToLongConverter.fromTimestamp(lValueOf);
                        if (dateFromTimestamp2 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                        }
                        _map.put(text, new FileVersionEntity(text2, text3, dateFromTimestamp, i2, dateFromTimestamp2));
                    }
                }
                sQLiteStatementPrepare.close();
                return;
            }
            sQLiteStatementPrepare.close();
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __fetchRelationshipfileVersionsAscomBoxAndroidDataPersistenceAnnotationsFileVersionEntity$lambda$0(FileActivityDao_Impl fileActivityDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        Intrinsics.checkNotNullParameter(_tmpMap, "_tmpMap");
        fileActivityDao_Impl.__fetchRelationshipfileVersionsAscomBoxAndroidDataPersistenceAnnotationsFileVersionEntity(sQLiteConnection, _tmpMap);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void __fetchRelationshipgroupedFileVersionsAscomBoxAndroidDataPersistenceAnnotationsGroupedFileVersionEntities(final SQLiteConnection _connection, ArrayMap<String, GroupedFileVersionEntities> _map) {
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: com.box.android.data.persistence.annotations.FileActivityDao_Impl$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FileActivityDao_Impl.__fetchRelationshipgroupedFileVersionsAscomBoxAndroidDataPersistenceAnnotationsGroupedFileVersionEntities$lambda$0(this.f$0, _connection, (ArrayMap) obj);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `start_id`,`end_id`,`file_id`,`created_by_json_data`,`network_fetched_at` FROM `grouped_file_versions` WHERE `start_id` IN (");
        StringUtil.appendPlaceholders(sb, setKeySet.size());
        sb.append(")");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(string);
        Iterator<String> it = setKeySet.iterator();
        int i = 1;
        while (it.hasNext()) {
            sQLiteStatementPrepare.mo10944bindText(i, it.next());
            i++;
        }
        try {
            int columnIndex = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "start_id");
            if (columnIndex != -1) {
                ArrayMap<String, FileVersionEntity> arrayMap = new ArrayMap<>();
                ArrayMap<String, FileVersionEntity> arrayMap2 = new ArrayMap<>();
                while (sQLiteStatementPrepare.step()) {
                    arrayMap.put(sQLiteStatementPrepare.getText(0), null);
                    arrayMap2.put(sQLiteStatementPrepare.getText(1), null);
                }
                sQLiteStatementPrepare.reset();
                __fetchRelationshipfileVersionsAscomBoxAndroidDataPersistenceAnnotationsFileVersionEntity(_connection, arrayMap);
                __fetchRelationshipfileVersionsAscomBoxAndroidDataPersistenceAnnotationsFileVersionEntity(_connection, arrayMap2);
                while (sQLiteStatementPrepare.step()) {
                    String text = sQLiteStatementPrepare.getText(columnIndex);
                    if (_map.containsKey(text)) {
                        String text2 = sQLiteStatementPrepare.getText(0);
                        String text3 = sQLiteStatementPrepare.getText(1);
                        String text4 = sQLiteStatementPrepare.getText(2);
                        byte[] blob = sQLiteStatementPrepare.getBlob(3);
                        Date dateFromTimestamp = this.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(4) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(4)));
                        if (dateFromTimestamp == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                        }
                        GroupedFileVersionsEntity groupedFileVersionsEntity = new GroupedFileVersionsEntity(text2, text3, text4, blob, dateFromTimestamp);
                        FileVersionEntity fileVersionEntity = arrayMap.get(sQLiteStatementPrepare.getText(0));
                        if (fileVersionEntity == null) {
                            throw new IllegalStateException("Relationship item 'startVersion' was expected to be NON-NULL but is NULL in @Relation involving a parent column named 'start_id' and entityColumn named 'version_id'.".toString());
                        }
                        FileVersionEntity fileVersionEntity2 = arrayMap2.get(sQLiteStatementPrepare.getText(1));
                        if (fileVersionEntity2 == null) {
                            throw new IllegalStateException("Relationship item 'endVersion' was expected to be NON-NULL but is NULL in @Relation involving a parent column named 'end_id' and entityColumn named 'version_id'.".toString());
                        }
                        _map.put(text, new GroupedFileVersionEntities(groupedFileVersionsEntity, fileVersionEntity, fileVersionEntity2));
                    }
                }
                sQLiteStatementPrepare.close();
                return;
            }
            sQLiteStatementPrepare.close();
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __fetchRelationshipgroupedFileVersionsAscomBoxAndroidDataPersistenceAnnotationsGroupedFileVersionEntities$lambda$0(FileActivityDao_Impl fileActivityDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        Intrinsics.checkNotNullParameter(_tmpMap, "_tmpMap");
        fileActivityDao_Impl.__fetchRelationshipgroupedFileVersionsAscomBoxAndroidDataPersistenceAnnotationsGroupedFileVersionEntities(sQLiteConnection, _tmpMap);
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: FileActivityDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/persistence/annotations/FileActivityDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
