package com.box.android.data.persistence.capture;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.box.android.data.persistence.DateToLongConverter;
import com.box.android.data.persistence.localItems.ItemIdConverter;
import com.box.android.data.persistence.localItems.ItemIdLocalIdConverter;
import com.box.android.domain.models.ItemId;
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

/* JADX INFO: compiled from: CaptureHistoryDao_Impl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u001d0\u001cH\u0016J\u001e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/box/android/data/persistence/capture/CaptureHistoryDao_Impl;", "Lcom/box/android/data/persistence/capture/CaptureHistoryDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfCaptureHistoryItemEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/box/android/data/persistence/capture/CaptureHistoryItemEntity;", "__itemIdConverter", "Lcom/box/android/data/persistence/localItems/ItemIdConverter;", "__dateToLongConverter", "Lcom/box/android/data/persistence/DateToLongConverter;", "__updateAdapterOfCaptureHistoryItemEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__itemIdLocalIdConverter", "Lcom/box/android/data/persistence/localItems/ItemIdLocalIdConverter;", "insertCaptureHistoryItem", "", "captureHistoryItemEntity", "(Lcom/box/android/data/persistence/capture/CaptureHistoryItemEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCaptureHistoryItem", "getLocalIdForServerId", "Lcom/box/android/domain/models/ItemId$Local;", "serverId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCaptureHistory", "Lkotlinx/coroutines/flow/Flow;", "", "updateLastUpdatedDate", "itemId", "currentDate", "Ljava/util/Date;", "(Lcom/box/android/domain/models/ItemId$Local;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCaptureHistoryForId", "(Lcom/box/android/domain/models/ItemId$Local;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "truncateDb", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CaptureHistoryDao_Impl implements CaptureHistoryDao {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DateToLongConverter __dateToLongConverter;
    private final RoomDatabase __db;
    private final EntityInsertAdapter<CaptureHistoryItemEntity> __insertAdapterOfCaptureHistoryItemEntity;
    private final ItemIdConverter __itemIdConverter;
    private final ItemIdLocalIdConverter __itemIdLocalIdConverter;
    private final EntityDeleteOrUpdateAdapter<CaptureHistoryItemEntity> __updateAdapterOfCaptureHistoryItemEntity;

    public CaptureHistoryDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__itemIdConverter = new ItemIdConverter();
        this.__dateToLongConverter = new DateToLongConverter();
        this.__itemIdLocalIdConverter = new ItemIdLocalIdConverter();
        this.__db = __db;
        this.__insertAdapterOfCaptureHistoryItemEntity = new EntityInsertAdapter<CaptureHistoryItemEntity>() { // from class: com.box.android.data.persistence.capture.CaptureHistoryDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `captureHistory` (`local_item_id`,`content_created_at`,`last_updated`) VALUES (?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, CaptureHistoryItemEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                String string = CaptureHistoryDao_Impl.this.__itemIdConverter.toString(entity.getLocalItemId());
                if (string == null) {
                    statement.mo10943bindNull(1);
                } else {
                    statement.mo10944bindText(1, string);
                }
                Long lDateToTimestamp = CaptureHistoryDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getContentCreatedAt());
                if (lDateToTimestamp == null) {
                    statement.mo10943bindNull(2);
                } else {
                    statement.mo10942bindLong(2, lDateToTimestamp.longValue());
                }
                Long lDateToTimestamp2 = CaptureHistoryDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getLastUpdated());
                if (lDateToTimestamp2 == null) {
                    statement.mo10943bindNull(3);
                } else {
                    statement.mo10942bindLong(3, lDateToTimestamp2.longValue());
                }
            }
        };
        this.__updateAdapterOfCaptureHistoryItemEntity = new EntityDeleteOrUpdateAdapter<CaptureHistoryItemEntity>() { // from class: com.box.android.data.persistence.capture.CaptureHistoryDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "UPDATE OR ABORT `captureHistory` SET `local_item_id` = ?,`content_created_at` = ?,`last_updated` = ? WHERE `local_item_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, CaptureHistoryItemEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                String string = CaptureHistoryDao_Impl.this.__itemIdConverter.toString(entity.getLocalItemId());
                if (string == null) {
                    statement.mo10943bindNull(1);
                } else {
                    statement.mo10944bindText(1, string);
                }
                Long lDateToTimestamp = CaptureHistoryDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getContentCreatedAt());
                if (lDateToTimestamp == null) {
                    statement.mo10943bindNull(2);
                } else {
                    statement.mo10942bindLong(2, lDateToTimestamp.longValue());
                }
                Long lDateToTimestamp2 = CaptureHistoryDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getLastUpdated());
                if (lDateToTimestamp2 == null) {
                    statement.mo10943bindNull(3);
                } else {
                    statement.mo10942bindLong(3, lDateToTimestamp2.longValue());
                }
                String string2 = CaptureHistoryDao_Impl.this.__itemIdConverter.toString(entity.getLocalItemId());
                if (string2 == null) {
                    statement.mo10943bindNull(4);
                } else {
                    statement.mo10944bindText(4, string2);
                }
            }
        };
    }

    @Override // com.box.android.data.persistence.capture.CaptureHistoryDao
    public Object insertCaptureHistoryItem(final CaptureHistoryItemEntity captureHistoryItemEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.capture.CaptureHistoryDao_Impl$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CaptureHistoryDao_Impl.insertCaptureHistoryItem$lambda$0(this.f$0, captureHistoryItemEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertCaptureHistoryItem$lambda$0(CaptureHistoryDao_Impl captureHistoryDao_Impl, CaptureHistoryItemEntity captureHistoryItemEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        captureHistoryDao_Impl.__insertAdapterOfCaptureHistoryItemEntity.insert(_connection, captureHistoryItemEntity);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.capture.CaptureHistoryDao
    public Object updateCaptureHistoryItem(final CaptureHistoryItemEntity captureHistoryItemEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.capture.CaptureHistoryDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CaptureHistoryDao_Impl.updateCaptureHistoryItem$lambda$0(this.f$0, captureHistoryItemEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateCaptureHistoryItem$lambda$0(CaptureHistoryDao_Impl captureHistoryDao_Impl, CaptureHistoryItemEntity captureHistoryItemEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        captureHistoryDao_Impl.__updateAdapterOfCaptureHistoryItemEntity.handle(_connection, captureHistoryItemEntity);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.capture.CaptureHistoryDao
    public Object getLocalIdForServerId(final String str, Continuation<? super ItemId.Local> continuation) {
        final String str2 = "SELECT local_id FROM local_id_to_server_id where server_id = ? and local_id in (SELECT local_item_id from captureHistory)";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.capture.CaptureHistoryDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CaptureHistoryDao_Impl.getLocalIdForServerId$lambda$0(str2, str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ItemId.Local getLocalIdForServerId$lambda$0(String str, String str2, CaptureHistoryDao_Impl captureHistoryDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10944bindText(1, str2);
            ItemId.Local localFromString = null;
            if (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.isNull(0) ? null : sQLiteStatementPrepare.getText(0);
                if (text != null) {
                    localFromString = captureHistoryDao_Impl.__itemIdLocalIdConverter.fromString(text);
                }
            }
            return localFromString;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.capture.CaptureHistoryDao
    public Flow<List<CaptureHistoryItemEntity>> getCaptureHistory() {
        final String str = "SELECT * from captureHistory";
        return FlowUtil.createFlow(this.__db, false, new String[]{"captureHistory"}, new Function1() { // from class: com.box.android.data.persistence.capture.CaptureHistoryDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CaptureHistoryDao_Impl.getCaptureHistory$lambda$0(str, this, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getCaptureHistory$lambda$0(String str, CaptureHistoryDao_Impl captureHistoryDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "local_item_id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content_created_at");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "last_updated");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                Long lValueOf = null;
                String text = sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow);
                ItemId.Local localFromString = text == null ? null : captureHistoryDao_Impl.__itemIdLocalIdConverter.fromString(text);
                if (localFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.models.ItemId.Local', but it was NULL.".toString());
                }
                Date dateFromTimestamp = captureHistoryDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow2)));
                if (dateFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                if (!sQLiteStatementPrepare.isNull(columnIndexOrThrow3)) {
                    lValueOf = Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow3));
                }
                Date dateFromTimestamp2 = captureHistoryDao_Impl.__dateToLongConverter.fromTimestamp(lValueOf);
                if (dateFromTimestamp2 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                arrayList.add(new CaptureHistoryItemEntity(localFromString, dateFromTimestamp, dateFromTimestamp2));
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.capture.CaptureHistoryDao
    public Object updateLastUpdatedDate(final ItemId.Local local, final Date date, Continuation<? super Unit> continuation) {
        final String str = "UPDATE captureHistory SET last_updated = ? WHERE local_item_id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.capture.CaptureHistoryDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CaptureHistoryDao_Impl.updateLastUpdatedDate$lambda$0(str, this, date, local, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateLastUpdatedDate$lambda$0(String str, CaptureHistoryDao_Impl captureHistoryDao_Impl, Date date, ItemId.Local local, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            Long lDateToTimestamp = captureHistoryDao_Impl.__dateToLongConverter.dateToTimestamp(date);
            if (lDateToTimestamp == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10942bindLong(1, lDateToTimestamp.longValue());
            }
            String string = captureHistoryDao_Impl.__itemIdConverter.toString(local);
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

    @Override // com.box.android.data.persistence.capture.CaptureHistoryDao
    public Object deleteCaptureHistoryForId(final ItemId.Local local, Continuation<? super Unit> continuation) {
        final String str = "DELETE from captureHistory where local_item_id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.capture.CaptureHistoryDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CaptureHistoryDao_Impl.deleteCaptureHistoryForId$lambda$0(str, this, local, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteCaptureHistoryForId$lambda$0(String str, CaptureHistoryDao_Impl captureHistoryDao_Impl, ItemId.Local local, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = captureHistoryDao_Impl.__itemIdConverter.toString(local);
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

    @Override // com.box.android.data.persistence.capture.CaptureHistoryDao
    public Object truncateDb(Continuation<? super Unit> continuation) {
        final String str = "DELETE FROM captureHistory WHERE local_item_id IN (SELECT local_item_id FROM captureHistory ORDER BY content_created_at DESC LIMIT -1 OFFSET 2000)";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.capture.CaptureHistoryDao_Impl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CaptureHistoryDao_Impl.truncateDb$lambda$0(str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit truncateDb$lambda$0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: compiled from: CaptureHistoryDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/persistence/capture/CaptureHistoryDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
