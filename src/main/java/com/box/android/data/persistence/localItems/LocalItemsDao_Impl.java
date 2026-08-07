package com.box.android.data.persistence.localItems;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.box.android.data.jobs.CreateFolderJob;
import com.box.android.data.persistence.DateToLongConverter;
import com.box.android.domain.localrepo.sqlitetables.BoxItemSQLData;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
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

/* JADX INFO: compiled from: LocalItemsDao_Impl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 52\u00020\u0001:\u00015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0018J\u0018\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001f\u001a\u00020 H\u0096@¢\u0006\u0002\u0010!J \u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010'J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0)2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010*J\u0018\u0010+\u001a\u0004\u0018\u00010$2\u0006\u0010,\u001a\u00020 H\u0096@¢\u0006\u0002\u0010!J\u0018\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100.2\u0006\u0010,\u001a\u00020 H\u0016J \u0010/\u001a\u0004\u0018\u00010\u00102\u0006\u00100\u001a\u00020$2\u0006\u00101\u001a\u000202H\u0096@¢\u0006\u0002\u00103J\u0016\u00104\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0096@¢\u0006\u0002\u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/box/android/data/persistence/localItems/LocalItemsDao_Impl;", "Lcom/box/android/data/persistence/localItems/LocalItemsDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfLocalItemEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/box/android/data/persistence/localItems/LocalItemEntity;", "__itemIdConverter", "Lcom/box/android/data/persistence/localItems/ItemIdConverter;", "__itemTypeConverter", "Lcom/box/android/data/persistence/localItems/ItemTypeConverter;", "__dateToLongConverter", "Lcom/box/android/data/persistence/DateToLongConverter;", "__insertAdapterOfLocalIdToServerIdRelationEntity", "Lcom/box/android/data/persistence/localItems/LocalIdToServerIdRelationEntity;", "__updateAdapterOfLocalItemEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__itemIdLocalIdConverter", "Lcom/box/android/data/persistence/localItems/ItemIdLocalIdConverter;", "insertLocalItem", "", "localItemEntity", "(Lcom/box/android/data/persistence/localItems/LocalItemEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertOrUpdateLocalIdToServerId", "", "localIdToServerIdRelationEntity", "(Lcom/box/android/data/persistence/localItems/LocalIdToServerIdRelationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLocalItem", "getLocalItemById", "itemId", "Lcom/box/android/domain/models/ItemId$Local;", "(Lcom/box/android/domain/models/ItemId$Local;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalItemByName", "name", "", "parentID", "Lcom/box/android/domain/models/ItemId;", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalItemsByParentId", "", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getServerId", "localId", "observeLocalIdToServerIdRelation", "Lkotlinx/coroutines/flow/Flow;", "getLocalIdToServerIdRelation", "serverId", "type", "Lcom/box/android/domain/models/item/ItemType;", "(Ljava/lang/String;Lcom/box/android/domain/models/item/ItemType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLocalItem", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LocalItemsDao_Impl implements LocalItemsDao {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DateToLongConverter __dateToLongConverter;
    private final RoomDatabase __db;
    private final EntityInsertAdapter<LocalIdToServerIdRelationEntity> __insertAdapterOfLocalIdToServerIdRelationEntity;
    private final EntityInsertAdapter<LocalItemEntity> __insertAdapterOfLocalItemEntity;
    private final ItemIdConverter __itemIdConverter;
    private final ItemIdLocalIdConverter __itemIdLocalIdConverter;
    private final ItemTypeConverter __itemTypeConverter;
    private final EntityDeleteOrUpdateAdapter<LocalItemEntity> __updateAdapterOfLocalItemEntity;

    public LocalItemsDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__itemIdConverter = new ItemIdConverter();
        this.__itemTypeConverter = new ItemTypeConverter();
        this.__dateToLongConverter = new DateToLongConverter();
        this.__itemIdLocalIdConverter = new ItemIdLocalIdConverter();
        this.__db = __db;
        this.__insertAdapterOfLocalItemEntity = new EntityInsertAdapter<LocalItemEntity>() { // from class: com.box.android.data.persistence.localItems.LocalItemsDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR ABORT INTO `local_item` (`local_id`,`type`,`content_url`,`name`,`parent_id`,`created_at`,`content_modified_at`,`local_file_sha1`) VALUES (?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, LocalItemEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                String string = LocalItemsDao_Impl.this.__itemIdConverter.toString(entity.getItemId());
                if (string == null) {
                    statement.mo10943bindNull(1);
                } else {
                    statement.mo10944bindText(1, string);
                }
                String string2 = LocalItemsDao_Impl.this.__itemTypeConverter.toString(entity.getItemType());
                if (string2 == null) {
                    statement.mo10943bindNull(2);
                } else {
                    statement.mo10944bindText(2, string2);
                }
                String contentUrl = entity.getContentUrl();
                if (contentUrl == null) {
                    statement.mo10943bindNull(3);
                } else {
                    statement.mo10944bindText(3, contentUrl);
                }
                statement.mo10944bindText(4, entity.getName());
                String string3 = LocalItemsDao_Impl.this.__itemIdConverter.toString(entity.getParentId());
                if (string3 == null) {
                    statement.mo10943bindNull(5);
                } else {
                    statement.mo10944bindText(5, string3);
                }
                Long lDateToTimestamp = LocalItemsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getCreatedAt());
                if (lDateToTimestamp == null) {
                    statement.mo10943bindNull(6);
                } else {
                    statement.mo10942bindLong(6, lDateToTimestamp.longValue());
                }
                Long lDateToTimestamp2 = LocalItemsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getContentModifiedAt());
                if (lDateToTimestamp2 == null) {
                    statement.mo10943bindNull(7);
                } else {
                    statement.mo10942bindLong(7, lDateToTimestamp2.longValue());
                }
                String localFileSha1 = entity.getLocalFileSha1();
                if (localFileSha1 == null) {
                    statement.mo10943bindNull(8);
                } else {
                    statement.mo10944bindText(8, localFileSha1);
                }
            }
        };
        this.__insertAdapterOfLocalIdToServerIdRelationEntity = new EntityInsertAdapter<LocalIdToServerIdRelationEntity>() { // from class: com.box.android.data.persistence.localItems.LocalItemsDao_Impl.2
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `local_id_to_server_id` (`local_id`,`type`,`server_id`) VALUES (?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, LocalIdToServerIdRelationEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                String string = LocalItemsDao_Impl.this.__itemIdConverter.toString(entity.getLocalId());
                if (string == null) {
                    statement.mo10943bindNull(1);
                } else {
                    statement.mo10944bindText(1, string);
                }
                String string2 = LocalItemsDao_Impl.this.__itemTypeConverter.toString(entity.getType());
                if (string2 == null) {
                    statement.mo10943bindNull(2);
                } else {
                    statement.mo10944bindText(2, string2);
                }
                statement.mo10944bindText(3, entity.getServerId());
            }
        };
        this.__updateAdapterOfLocalItemEntity = new EntityDeleteOrUpdateAdapter<LocalItemEntity>() { // from class: com.box.android.data.persistence.localItems.LocalItemsDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "UPDATE OR ABORT `local_item` SET `local_id` = ?,`type` = ?,`content_url` = ?,`name` = ?,`parent_id` = ?,`created_at` = ?,`content_modified_at` = ?,`local_file_sha1` = ? WHERE `local_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, LocalItemEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                String string = LocalItemsDao_Impl.this.__itemIdConverter.toString(entity.getItemId());
                if (string == null) {
                    statement.mo10943bindNull(1);
                } else {
                    statement.mo10944bindText(1, string);
                }
                String string2 = LocalItemsDao_Impl.this.__itemTypeConverter.toString(entity.getItemType());
                if (string2 == null) {
                    statement.mo10943bindNull(2);
                } else {
                    statement.mo10944bindText(2, string2);
                }
                String contentUrl = entity.getContentUrl();
                if (contentUrl == null) {
                    statement.mo10943bindNull(3);
                } else {
                    statement.mo10944bindText(3, contentUrl);
                }
                statement.mo10944bindText(4, entity.getName());
                String string3 = LocalItemsDao_Impl.this.__itemIdConverter.toString(entity.getParentId());
                if (string3 == null) {
                    statement.mo10943bindNull(5);
                } else {
                    statement.mo10944bindText(5, string3);
                }
                Long lDateToTimestamp = LocalItemsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getCreatedAt());
                if (lDateToTimestamp == null) {
                    statement.mo10943bindNull(6);
                } else {
                    statement.mo10942bindLong(6, lDateToTimestamp.longValue());
                }
                Long lDateToTimestamp2 = LocalItemsDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getContentModifiedAt());
                if (lDateToTimestamp2 == null) {
                    statement.mo10943bindNull(7);
                } else {
                    statement.mo10942bindLong(7, lDateToTimestamp2.longValue());
                }
                String localFileSha1 = entity.getLocalFileSha1();
                if (localFileSha1 == null) {
                    statement.mo10943bindNull(8);
                } else {
                    statement.mo10944bindText(8, localFileSha1);
                }
                String string4 = LocalItemsDao_Impl.this.__itemIdConverter.toString(entity.getItemId());
                if (string4 == null) {
                    statement.mo10943bindNull(9);
                } else {
                    statement.mo10944bindText(9, string4);
                }
            }
        };
    }

    @Override // com.box.android.data.persistence.localItems.LocalItemsDao
    public /* bridge */ Object insertOrUpdateLocalItem(LocalItemEntity localItemEntity, Continuation<? super Unit> continuation) {
        return super.insertOrUpdateLocalItem(localItemEntity, continuation);
    }

    @Override // com.box.android.data.persistence.localItems.LocalItemsDao
    public Object insertLocalItem(final LocalItemEntity localItemEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.localItems.LocalItemsDao_Impl$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocalItemsDao_Impl.insertLocalItem$lambda$0(this.f$0, localItemEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertLocalItem$lambda$0(LocalItemsDao_Impl localItemsDao_Impl, LocalItemEntity localItemEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        localItemsDao_Impl.__insertAdapterOfLocalItemEntity.insert(_connection, localItemEntity);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.localItems.LocalItemsDao
    public Object insertOrUpdateLocalIdToServerId(final LocalIdToServerIdRelationEntity localIdToServerIdRelationEntity, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.localItems.LocalItemsDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(LocalItemsDao_Impl.insertOrUpdateLocalIdToServerId$lambda$0(this.f$0, localIdToServerIdRelationEntity, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insertOrUpdateLocalIdToServerId$lambda$0(LocalItemsDao_Impl localItemsDao_Impl, LocalIdToServerIdRelationEntity localIdToServerIdRelationEntity, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return localItemsDao_Impl.__insertAdapterOfLocalIdToServerIdRelationEntity.insertAndReturnId(_connection, localIdToServerIdRelationEntity);
    }

    @Override // com.box.android.data.persistence.localItems.LocalItemsDao
    public Object updateLocalItem(final LocalItemEntity localItemEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.localItems.LocalItemsDao_Impl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocalItemsDao_Impl.updateLocalItem$lambda$0(this.f$0, localItemEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateLocalItem$lambda$0(LocalItemsDao_Impl localItemsDao_Impl, LocalItemEntity localItemEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        localItemsDao_Impl.__updateAdapterOfLocalItemEntity.handle(_connection, localItemEntity);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.localItems.LocalItemsDao
    public Object getLocalItemById(final ItemId.Local local, Continuation<? super LocalItemEntity> continuation) {
        final String str = "SELECT * FROM local_item where local_id = ?";
        return DBUtil.performSuspending(this.__db, true, true, new Function1() { // from class: com.box.android.data.persistence.localItems.LocalItemsDao_Impl$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocalItemsDao_Impl.getLocalItemById$lambda$0(str, this, local, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocalItemEntity getLocalItemById$lambda$0(String str, LocalItemsDao_Impl localItemsDao_Impl, ItemId.Local local, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = localItemsDao_Impl.__itemIdConverter.toString(local);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, CreateFolderJob.LOCAL_ID);
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content_url");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, BoxItemSQLData.COL_PARENT_ID);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "created_at");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content_modified_at");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "local_file_sha1");
            LocalItemEntity localItemEntity = null;
            if (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow);
                ItemId.Local localFromString = text == null ? null : localItemsDao_Impl.__itemIdLocalIdConverter.fromString(text);
                if (localFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.models.ItemId.Local', but it was NULL.".toString());
                }
                ItemType itemTypeFromString = localItemsDao_Impl.__itemTypeConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2));
                if (itemTypeFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.models.item.ItemType', but it was NULL.".toString());
                }
                String text2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                ItemId itemIdFromString = text4 == null ? null : localItemsDao_Impl.__itemIdConverter.fromString(text4);
                Date dateFromTimestamp = localItemsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6)));
                if (dateFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                localItemEntity = new LocalItemEntity(localFromString, itemTypeFromString, text2, text3, itemIdFromString, dateFromTimestamp, localItemsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow7))), sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8));
            }
            sQLiteStatementPrepare.close();
            return localItemEntity;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.localItems.LocalItemsDao
    public Object getLocalItemByName(final String str, final ItemId itemId, Continuation<? super LocalItemEntity> continuation) {
        final String str2 = "SELECT * FROM local_item where name = ? AND parent_id = ?";
        return DBUtil.performSuspending(this.__db, true, true, new Function1() { // from class: com.box.android.data.persistence.localItems.LocalItemsDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocalItemsDao_Impl.getLocalItemByName$lambda$0(str2, str, this, itemId, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocalItemEntity getLocalItemByName$lambda$0(String str, String str2, LocalItemsDao_Impl localItemsDao_Impl, ItemId itemId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10944bindText(1, str2);
            String string = localItemsDao_Impl.__itemIdConverter.toString(itemId);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(2);
            } else {
                sQLiteStatementPrepare.mo10944bindText(2, string);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, CreateFolderJob.LOCAL_ID);
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content_url");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, BoxItemSQLData.COL_PARENT_ID);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "created_at");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content_modified_at");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "local_file_sha1");
            LocalItemEntity localItemEntity = null;
            if (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow);
                ItemId.Local localFromString = text == null ? null : localItemsDao_Impl.__itemIdLocalIdConverter.fromString(text);
                if (localFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.models.ItemId.Local', but it was NULL.".toString());
                }
                ItemType itemTypeFromString = localItemsDao_Impl.__itemTypeConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2));
                if (itemTypeFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.models.item.ItemType', but it was NULL.".toString());
                }
                String text2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                ItemId itemIdFromString = text4 == null ? null : localItemsDao_Impl.__itemIdConverter.fromString(text4);
                Date dateFromTimestamp = localItemsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6)));
                if (dateFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                localItemEntity = new LocalItemEntity(localFromString, itemTypeFromString, text2, text3, itemIdFromString, dateFromTimestamp, localItemsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow7))), sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8));
            }
            sQLiteStatementPrepare.close();
            return localItemEntity;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.localItems.LocalItemsDao
    public Object getLocalItemsByParentId(final ItemId itemId, Continuation<? super List<LocalItemEntity>> continuation) {
        final String str = "SELECT * FROM local_item where parent_id = ?";
        return DBUtil.performSuspending(this.__db, true, true, new Function1() { // from class: com.box.android.data.persistence.localItems.LocalItemsDao_Impl$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocalItemsDao_Impl.getLocalItemsByParentId$lambda$0(str, this, itemId, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getLocalItemsByParentId$lambda$0(String str, LocalItemsDao_Impl localItemsDao_Impl, ItemId itemId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = localItemsDao_Impl.__itemIdConverter.toString(itemId);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, CreateFolderJob.LOCAL_ID);
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content_url");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, BoxItemSQLData.COL_PARENT_ID);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "created_at");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content_modified_at");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "local_file_sha1");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow);
                ItemId.Local localFromString = text == null ? null : localItemsDao_Impl.__itemIdLocalIdConverter.fromString(text);
                if (localFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.models.ItemId.Local', but it was NULL.".toString());
                }
                ItemType itemTypeFromString = localItemsDao_Impl.__itemTypeConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2));
                if (itemTypeFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.models.item.ItemType', but it was NULL.".toString());
                }
                String text2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                ItemId itemIdFromString = text4 == null ? null : localItemsDao_Impl.__itemIdConverter.fromString(text4);
                Date dateFromTimestamp = localItemsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6)));
                if (dateFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                arrayList.add(new LocalItemEntity(localFromString, itemTypeFromString, text2, text3, itemIdFromString, dateFromTimestamp, localItemsDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow7))), sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8)));
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.localItems.LocalItemsDao
    public Object getServerId(final ItemId.Local local, Continuation<? super String> continuation) {
        final String str = "SELECT server_id FROM local_id_to_server_id where local_id = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.localItems.LocalItemsDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocalItemsDao_Impl.getServerId$lambda$0(str, this, local, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getServerId$lambda$0(String str, LocalItemsDao_Impl localItemsDao_Impl, ItemId.Local local, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = localItemsDao_Impl.__itemIdConverter.toString(local);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            String text = null;
            if (sQLiteStatementPrepare.step() && !sQLiteStatementPrepare.isNull(0)) {
                text = sQLiteStatementPrepare.getText(0);
            }
            return text;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.localItems.LocalItemsDao
    public Flow<LocalIdToServerIdRelationEntity> observeLocalIdToServerIdRelation(final ItemId.Local localId) {
        Intrinsics.checkNotNullParameter(localId, "localId");
        final String str = "SELECT * FROM local_id_to_server_id where local_id = ?";
        return FlowUtil.createFlow(this.__db, false, new String[]{"local_id_to_server_id"}, new Function1() { // from class: com.box.android.data.persistence.localItems.LocalItemsDao_Impl$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocalItemsDao_Impl.observeLocalIdToServerIdRelation$lambda$0(str, this, localId, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
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
    public static final LocalIdToServerIdRelationEntity observeLocalIdToServerIdRelation$lambda$0(String str, LocalItemsDao_Impl localItemsDao_Impl, ItemId.Local local, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = localItemsDao_Impl.__itemIdConverter.toString(local);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, CreateFolderJob.LOCAL_ID);
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "server_id");
            LocalIdToServerIdRelationEntity localIdToServerIdRelationEntity = null;
            String text = null;
            if (sQLiteStatementPrepare.step()) {
                String text2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow);
                ItemId.Local localFromString = text2 == null ? null : localItemsDao_Impl.__itemIdLocalIdConverter.fromString(text2);
                if (localFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.models.ItemId.Local', but it was NULL.".toString());
                }
                if (!sQLiteStatementPrepare.isNull(columnIndexOrThrow2)) {
                    text = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                }
                ItemType itemTypeFromString = localItemsDao_Impl.__itemTypeConverter.fromString(text);
                if (itemTypeFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.models.item.ItemType', but it was NULL.".toString());
                }
                localIdToServerIdRelationEntity = new LocalIdToServerIdRelationEntity(localFromString, itemTypeFromString, sQLiteStatementPrepare.getText(columnIndexOrThrow3));
            }
            sQLiteStatementPrepare.close();
            return localIdToServerIdRelationEntity;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.localItems.LocalItemsDao
    public Object getLocalIdToServerIdRelation(final String str, final ItemType itemType, Continuation<? super LocalIdToServerIdRelationEntity> continuation) {
        final String str2 = "SELECT * FROM local_id_to_server_id where type = ? AND server_id = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.localItems.LocalItemsDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocalItemsDao_Impl.getLocalIdToServerIdRelation$lambda$0(str2, this, itemType, str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
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
    public static final LocalIdToServerIdRelationEntity getLocalIdToServerIdRelation$lambda$0(String str, LocalItemsDao_Impl localItemsDao_Impl, ItemType itemType, String str2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = localItemsDao_Impl.__itemTypeConverter.toString(itemType);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            sQLiteStatementPrepare.mo10944bindText(2, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, CreateFolderJob.LOCAL_ID);
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "server_id");
            LocalIdToServerIdRelationEntity localIdToServerIdRelationEntity = null;
            String text = null;
            if (sQLiteStatementPrepare.step()) {
                String text2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow);
                ItemId.Local localFromString = text2 == null ? null : localItemsDao_Impl.__itemIdLocalIdConverter.fromString(text2);
                if (localFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.models.ItemId.Local', but it was NULL.".toString());
                }
                if (!sQLiteStatementPrepare.isNull(columnIndexOrThrow2)) {
                    text = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                }
                ItemType itemTypeFromString = localItemsDao_Impl.__itemTypeConverter.fromString(text);
                if (itemTypeFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.models.item.ItemType', but it was NULL.".toString());
                }
                localIdToServerIdRelationEntity = new LocalIdToServerIdRelationEntity(localFromString, itemTypeFromString, sQLiteStatementPrepare.getText(columnIndexOrThrow3));
            }
            sQLiteStatementPrepare.close();
            return localIdToServerIdRelationEntity;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.localItems.LocalItemsDao
    public Object deleteLocalItem(final ItemId.Local local, Continuation<? super Unit> continuation) {
        final String str = "DELETE FROM local_item where local_id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.localItems.LocalItemsDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocalItemsDao_Impl.deleteLocalItem$lambda$0(str, this, local, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteLocalItem$lambda$0(String str, LocalItemsDao_Impl localItemsDao_Impl, ItemId.Local local, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = localItemsDao_Impl.__itemIdConverter.toString(local);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: compiled from: LocalItemsDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/persistence/localItems/LocalItemsDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
