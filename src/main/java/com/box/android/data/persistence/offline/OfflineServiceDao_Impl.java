package com.box.android.data.persistence.offline;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.box.android.data.persistence.localItems.ItemTypeConverter;
import com.box.android.domain.models.item.ItemType;
import external.sdk.pendo.io.mozilla.javascript.Token;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: OfflineServiceDao_Impl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0010J \u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001eJ\u0014\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\"H\u0016J \u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\"2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ \u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\u0018\u0010'\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010(J\u001e\u0010)\u001a\u00020*2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\u001e\u0010+\u001a\u00020*2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\u000e\u0010,\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010-J\u001e\u0010.\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/box/android/data/persistence/offline/OfflineServiceDao_Impl;", "Lcom/box/android/data/persistence/offline/OfflineServiceDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfOfflineStateEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/box/android/data/persistence/offline/OfflineStateEntity;", "__itemTypeConverter", "Lcom/box/android/data/persistence/localItems/ItemTypeConverter;", "__updateAdapterOfOfflineStateEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", SemanticAttributes.FaasDocumentOperationValues.INSERT, "", "entity", "(Lcom/box/android/data/persistence/offline/OfflineStateEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAll", "entities", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "upsert", "getState", "itemId", "", "itemType", "Lcom/box/android/domain/models/item/ItemType;", "(Ljava/lang/String;Lcom/box/android/domain/models/item/ItemType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOfflinedItemIds", "(Lcom/box/android/domain/models/item/ItemType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "countOfflinedItems", "", "observeOfflinedItems", "Lkotlinx/coroutines/flow/Flow;", "observeState", "getCompletedDate", "", "getStartedDate", "getFileSha1", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "existsAndUserRemoved", "", "existsAndUserSaved", "deleteAllStates", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByItemIdAndType", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OfflineServiceDao_Impl implements OfflineServiceDao {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<OfflineStateEntity> __insertAdapterOfOfflineStateEntity;
    private final ItemTypeConverter __itemTypeConverter;
    private final EntityDeleteOrUpdateAdapter<OfflineStateEntity> __updateAdapterOfOfflineStateEntity;

    public OfflineServiceDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__itemTypeConverter = new ItemTypeConverter();
        this.__db = __db;
        this.__insertAdapterOfOfflineStateEntity = new EntityInsertAdapter<OfflineStateEntity>() { // from class: com.box.android.data.persistence.offline.OfflineServiceDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `offline_state` (`item_id`,`item_type`,`is_user_saved`,`is_user_removed`,`started_date`,`completed_date`,`sha1`) VALUES (?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, OfflineStateEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo10944bindText(1, entity.getItemId());
                String string = OfflineServiceDao_Impl.this.__itemTypeConverter.toString(entity.getItemType());
                if (string == null) {
                    statement.mo10943bindNull(2);
                } else {
                    statement.mo10944bindText(2, string);
                }
                statement.mo10942bindLong(3, entity.isUserSaved() ? 1L : 0L);
                statement.mo10942bindLong(4, entity.isUserRemoved() ? 1L : 0L);
                Long startedDate = entity.getStartedDate();
                if (startedDate == null) {
                    statement.mo10943bindNull(5);
                } else {
                    statement.mo10942bindLong(5, startedDate.longValue());
                }
                Long completedDate = entity.getCompletedDate();
                if (completedDate == null) {
                    statement.mo10943bindNull(6);
                } else {
                    statement.mo10942bindLong(6, completedDate.longValue());
                }
                String sha1 = entity.getSha1();
                if (sha1 == null) {
                    statement.mo10943bindNull(7);
                } else {
                    statement.mo10944bindText(7, sha1);
                }
            }
        };
        this.__updateAdapterOfOfflineStateEntity = new EntityDeleteOrUpdateAdapter<OfflineStateEntity>() { // from class: com.box.android.data.persistence.offline.OfflineServiceDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "UPDATE OR ABORT `offline_state` SET `item_id` = ?,`item_type` = ?,`is_user_saved` = ?,`is_user_removed` = ?,`started_date` = ?,`completed_date` = ?,`sha1` = ? WHERE `item_id` = ? AND `item_type` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, OfflineStateEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo10944bindText(1, entity.getItemId());
                String string = OfflineServiceDao_Impl.this.__itemTypeConverter.toString(entity.getItemType());
                if (string == null) {
                    statement.mo10943bindNull(2);
                } else {
                    statement.mo10944bindText(2, string);
                }
                statement.mo10942bindLong(3, entity.isUserSaved() ? 1L : 0L);
                statement.mo10942bindLong(4, entity.isUserRemoved() ? 1L : 0L);
                Long startedDate = entity.getStartedDate();
                if (startedDate == null) {
                    statement.mo10943bindNull(5);
                } else {
                    statement.mo10942bindLong(5, startedDate.longValue());
                }
                Long completedDate = entity.getCompletedDate();
                if (completedDate == null) {
                    statement.mo10943bindNull(6);
                } else {
                    statement.mo10942bindLong(6, completedDate.longValue());
                }
                String sha1 = entity.getSha1();
                if (sha1 == null) {
                    statement.mo10943bindNull(7);
                } else {
                    statement.mo10944bindText(7, sha1);
                }
                statement.mo10944bindText(8, entity.getItemId());
                String string2 = OfflineServiceDao_Impl.this.__itemTypeConverter.toString(entity.getItemType());
                if (string2 == null) {
                    statement.mo10943bindNull(9);
                } else {
                    statement.mo10944bindText(9, string2);
                }
            }
        };
    }

    @Override // com.box.android.data.persistence.offline.OfflineServiceDao
    public Object insert(final OfflineStateEntity offlineStateEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.offline.OfflineServiceDao_Impl$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OfflineServiceDao_Impl.insert$lambda$0(this.f$0, offlineStateEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insert$lambda$0(OfflineServiceDao_Impl offlineServiceDao_Impl, OfflineStateEntity offlineStateEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        offlineServiceDao_Impl.__insertAdapterOfOfflineStateEntity.insert(_connection, offlineStateEntity);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.offline.OfflineServiceDao
    public Object insertAll(final List<OfflineStateEntity> list, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.offline.OfflineServiceDao_Impl$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OfflineServiceDao_Impl.insertAll$lambda$0(this.f$0, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertAll$lambda$0(OfflineServiceDao_Impl offlineServiceDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        offlineServiceDao_Impl.__insertAdapterOfOfflineStateEntity.insert(_connection, list);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.offline.OfflineServiceDao
    public Object update(final OfflineStateEntity offlineStateEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.offline.OfflineServiceDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OfflineServiceDao_Impl.update$lambda$0(this.f$0, offlineStateEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit update$lambda$0(OfflineServiceDao_Impl offlineServiceDao_Impl, OfflineStateEntity offlineStateEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        offlineServiceDao_Impl.__updateAdapterOfOfflineStateEntity.handle(_connection, offlineStateEntity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineServiceDao_Impl$upsert$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineServiceDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineServiceDao_Impl$upsert$2", f = "OfflineServiceDao_Impl.kt", i = {}, l = {Token.TARGET}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C13772 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ OfflineStateEntity $entity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13772(OfflineStateEntity offlineStateEntity, Continuation<? super C13772> continuation) {
            super(1, continuation);
            this.$entity = offlineStateEntity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return OfflineServiceDao_Impl.this.new C13772(this.$entity, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C13772) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (OfflineServiceDao_Impl.super.upsert(this.$entity, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.box.android.data.persistence.offline.OfflineServiceDao
    public Object upsert(OfflineStateEntity offlineStateEntity, Continuation<? super Unit> continuation) {
        Object objPerformInTransactionSuspending = DBUtil.performInTransactionSuspending(this.__db, new C13772(offlineStateEntity, null), continuation);
        return objPerformInTransactionSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformInTransactionSuspending : Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.offline.OfflineServiceDao
    public Object getState(final String str, final ItemType itemType, Continuation<? super OfflineStateEntity> continuation) {
        final String str2 = "\n            SELECT * FROM offline_state\n            WHERE item_id = ?\n            AND item_type = ?\n    ";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.offline.OfflineServiceDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OfflineServiceDao_Impl.getState$lambda$0(str2, str, this, itemType, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflineStateEntity getState$lambda$0(String str, String str2, OfflineServiceDao_Impl offlineServiceDao_Impl, ItemType itemType, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10944bindText(1, str2);
            String string = offlineServiceDao_Impl.__itemTypeConverter.toString(itemType);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(2);
            } else {
                sQLiteStatementPrepare.mo10944bindText(2, string);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "item_id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "item_type");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "is_user_saved");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "is_user_removed");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "started_date");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "completed_date");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sha1");
            OfflineStateEntity offlineStateEntity = null;
            if (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                ItemType itemTypeFromString = offlineServiceDao_Impl.__itemTypeConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2));
                if (itemTypeFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.models.item.ItemType', but it was NULL.".toString());
                }
                offlineStateEntity = new OfflineStateEntity(text, itemTypeFromString, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6)), sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7));
            }
            sQLiteStatementPrepare.close();
            return offlineStateEntity;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.offline.OfflineServiceDao
    public Object getOfflinedItemIds(final ItemType itemType, Continuation<? super List<String>> continuation) {
        final String str = "\n        SELECT item_id FROM offline_state\n        WHERE is_user_saved = 1\n        AND item_type = ?\n    ";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.offline.OfflineServiceDao_Impl$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OfflineServiceDao_Impl.getOfflinedItemIds$lambda$0(str, this, itemType, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getOfflinedItemIds$lambda$0(String str, OfflineServiceDao_Impl offlineServiceDao_Impl, ItemType itemType, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = offlineServiceDao_Impl.__itemTypeConverter.toString(itemType);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(sQLiteStatementPrepare.getText(0));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.offline.OfflineServiceDao
    public Object countOfflinedItems(final ItemType itemType, Continuation<? super Integer> continuation) {
        final String str = "\n        SELECT COUNT(*) FROM offline_state\n        WHERE is_user_saved = 1\n        AND item_type = ?\n    ";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.offline.OfflineServiceDao_Impl$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(OfflineServiceDao_Impl.countOfflinedItems$lambda$0(str, this, itemType, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int countOfflinedItems$lambda$0(String str, OfflineServiceDao_Impl offlineServiceDao_Impl, ItemType itemType, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = offlineServiceDao_Impl.__itemTypeConverter.toString(itemType);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            return sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.offline.OfflineServiceDao
    public Flow<List<OfflineStateEntity>> observeOfflinedItems() {
        final String str = "SELECT * FROM offline_state WHERE is_user_saved = 1";
        return FlowUtil.createFlow(this.__db, false, new String[]{"offline_state"}, new Function1() { // from class: com.box.android.data.persistence.offline.OfflineServiceDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OfflineServiceDao_Impl.observeOfflinedItems$lambda$0(str, this, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List observeOfflinedItems$lambda$0(String str, OfflineServiceDao_Impl offlineServiceDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "item_id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "item_type");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "is_user_saved");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "is_user_removed");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "started_date");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "completed_date");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sha1");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                ItemType itemTypeFromString = offlineServiceDao_Impl.__itemTypeConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2));
                if (itemTypeFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.models.item.ItemType', but it was NULL.".toString());
                }
                boolean z = true;
                boolean z2 = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3)) != 0;
                if (((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4)) == 0) {
                    z = false;
                }
                arrayList.add(new OfflineStateEntity(text, itemTypeFromString, z2, z, sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6)), sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7)));
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.offline.OfflineServiceDao
    public Flow<OfflineStateEntity> observeState(final String itemId, final ItemType itemType) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        final String str = "\n        SELECT * FROM offline_state\n        WHERE item_id = ?\n        AND item_type = ?\n    ";
        return FlowUtil.createFlow(this.__db, false, new String[]{"offline_state"}, new Function1() { // from class: com.box.android.data.persistence.offline.OfflineServiceDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OfflineServiceDao_Impl.observeState$lambda$0(str, itemId, this, itemType, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflineStateEntity observeState$lambda$0(String str, String str2, OfflineServiceDao_Impl offlineServiceDao_Impl, ItemType itemType, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10944bindText(1, str2);
            String string = offlineServiceDao_Impl.__itemTypeConverter.toString(itemType);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(2);
            } else {
                sQLiteStatementPrepare.mo10944bindText(2, string);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "item_id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "item_type");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "is_user_saved");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "is_user_removed");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "started_date");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "completed_date");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sha1");
            OfflineStateEntity offlineStateEntity = null;
            if (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                ItemType itemTypeFromString = offlineServiceDao_Impl.__itemTypeConverter.fromString(sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2));
                if (itemTypeFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.models.item.ItemType', but it was NULL.".toString());
                }
                offlineStateEntity = new OfflineStateEntity(text, itemTypeFromString, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6)), sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7));
            }
            sQLiteStatementPrepare.close();
            return offlineStateEntity;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.offline.OfflineServiceDao
    public Object getCompletedDate(final String str, final ItemType itemType, Continuation<? super Long> continuation) {
        final String str2 = "\n        SELECT completed_date FROM offline_state\n        WHERE item_id = ?\n        AND item_type = ?\n    ";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.offline.OfflineServiceDao_Impl$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OfflineServiceDao_Impl.getCompletedDate$lambda$0(str2, str, this, itemType, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long getCompletedDate$lambda$0(String str, String str2, OfflineServiceDao_Impl offlineServiceDao_Impl, ItemType itemType, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10944bindText(1, str2);
            String string = offlineServiceDao_Impl.__itemTypeConverter.toString(itemType);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(2);
            } else {
                sQLiteStatementPrepare.mo10944bindText(2, string);
            }
            Long lValueOf = null;
            if (sQLiteStatementPrepare.step() && !sQLiteStatementPrepare.isNull(0)) {
                lValueOf = Long.valueOf(sQLiteStatementPrepare.getLong(0));
            }
            return lValueOf;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.offline.OfflineServiceDao
    public Object getStartedDate(final String str, final ItemType itemType, Continuation<? super Long> continuation) {
        final String str2 = "\n        SELECT started_date FROM offline_state\n        WHERE item_id = ?\n        AND item_type = ?\n    ";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.offline.OfflineServiceDao_Impl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OfflineServiceDao_Impl.getStartedDate$lambda$0(str2, str, this, itemType, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long getStartedDate$lambda$0(String str, String str2, OfflineServiceDao_Impl offlineServiceDao_Impl, ItemType itemType, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10944bindText(1, str2);
            String string = offlineServiceDao_Impl.__itemTypeConverter.toString(itemType);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(2);
            } else {
                sQLiteStatementPrepare.mo10944bindText(2, string);
            }
            Long lValueOf = null;
            if (sQLiteStatementPrepare.step() && !sQLiteStatementPrepare.isNull(0)) {
                lValueOf = Long.valueOf(sQLiteStatementPrepare.getLong(0));
            }
            return lValueOf;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.offline.OfflineServiceDao
    public Object getFileSha1(final String str, Continuation<? super String> continuation) {
        final String str2 = "\n        SELECT sha1 FROM offline_state\n        WHERE item_id = ?\n        AND item_type = 'file'\n    ";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.offline.OfflineServiceDao_Impl$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OfflineServiceDao_Impl.getFileSha1$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getFileSha1$lambda$0(String str, String str2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10944bindText(1, str2);
            String text = null;
            if (sQLiteStatementPrepare.step() && !sQLiteStatementPrepare.isNull(0)) {
                text = sQLiteStatementPrepare.getText(0);
            }
            return text;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.offline.OfflineServiceDao
    public Object existsAndUserRemoved(final String str, final ItemType itemType, Continuation<? super Boolean> continuation) {
        final String str2 = "\n        SELECT EXISTS(\n            SELECT 1 FROM offline_state\n            WHERE item_id = ?\n            AND item_type = ?\n            AND is_user_removed = 1\n        )\n    ";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.offline.OfflineServiceDao_Impl$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(OfflineServiceDao_Impl.existsAndUserRemoved$lambda$0(str2, str, this, itemType, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean existsAndUserRemoved$lambda$0(String str, String str2, OfflineServiceDao_Impl offlineServiceDao_Impl, ItemType itemType, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10944bindText(1, str2);
            String string = offlineServiceDao_Impl.__itemTypeConverter.toString(itemType);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(2);
            } else {
                sQLiteStatementPrepare.mo10944bindText(2, string);
            }
            boolean z = false;
            if (sQLiteStatementPrepare.step()) {
                z = ((int) sQLiteStatementPrepare.getLong(0)) != 0;
            }
            return z;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.offline.OfflineServiceDao
    public Object existsAndUserSaved(final String str, final ItemType itemType, Continuation<? super Boolean> continuation) {
        final String str2 = "\n        SELECT EXISTS(\n            SELECT 1 FROM offline_state\n            WHERE item_id = ?\n            AND item_type = ?\n            AND is_user_saved = 1\n        )\n    ";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.offline.OfflineServiceDao_Impl$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(OfflineServiceDao_Impl.existsAndUserSaved$lambda$0(str2, str, this, itemType, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean existsAndUserSaved$lambda$0(String str, String str2, OfflineServiceDao_Impl offlineServiceDao_Impl, ItemType itemType, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10944bindText(1, str2);
            String string = offlineServiceDao_Impl.__itemTypeConverter.toString(itemType);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(2);
            } else {
                sQLiteStatementPrepare.mo10944bindText(2, string);
            }
            boolean z = false;
            if (sQLiteStatementPrepare.step()) {
                z = ((int) sQLiteStatementPrepare.getLong(0)) != 0;
            }
            return z;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.offline.OfflineServiceDao
    public Object deleteAllStates(Continuation<? super Unit> continuation) {
        final String str = "DELETE FROM offline_state";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.offline.OfflineServiceDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OfflineServiceDao_Impl.deleteAllStates$lambda$0(str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteAllStates$lambda$0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.offline.OfflineServiceDao
    public Object deleteByItemIdAndType(final String str, final ItemType itemType, Continuation<? super Unit> continuation) {
        final String str2 = "\n        DELETE FROM offline_state\n        WHERE item_id = ?\n        AND item_type = ?\n    ";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.offline.OfflineServiceDao_Impl$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OfflineServiceDao_Impl.deleteByItemIdAndType$lambda$0(str2, str, this, itemType, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteByItemIdAndType$lambda$0(String str, String str2, OfflineServiceDao_Impl offlineServiceDao_Impl, ItemType itemType, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10944bindText(1, str2);
            String string = offlineServiceDao_Impl.__itemTypeConverter.toString(itemType);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(2);
            } else {
                sQLiteStatementPrepare.mo10944bindText(2, string);
            }
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: compiled from: OfflineServiceDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/persistence/offline/OfflineServiceDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
