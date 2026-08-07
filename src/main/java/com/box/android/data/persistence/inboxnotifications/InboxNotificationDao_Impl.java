package com.box.android.data.persistence.inboxnotifications;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.data.persistence.DateToLongConverter;
import com.box.androidsdk.content.models.BoxIterator;
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

/* JADX INFO: compiled from: InboxNotificationDao_Impl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/box/android/data/persistence/inboxnotifications/InboxNotificationDao_Impl;", "Lcom/box/android/data/persistence/inboxnotifications/InboxNotificationDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfInboxNotificationEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/box/android/data/persistence/inboxnotifications/InboxNotificationEntity;", "__dateToLongConverter", "Lcom/box/android/data/persistence/DateToLongConverter;", "__notificationSourceConverter", "Lcom/box/android/data/persistence/inboxnotifications/NotificationSourceConverter;", "insertNotifications", "", "notifications", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getApiNotifications", BoxIterator.FIELD_LIMIT, "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateReadStatus", "notificationId", "", "isRead", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOldNotifications", "olderThanMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxNotificationDao_Impl implements InboxNotificationDao {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DateToLongConverter __dateToLongConverter;
    private final RoomDatabase __db;
    private final EntityInsertAdapter<InboxNotificationEntity> __insertAdapterOfInboxNotificationEntity;
    private final NotificationSourceConverter __notificationSourceConverter;

    public InboxNotificationDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__dateToLongConverter = new DateToLongConverter();
        this.__notificationSourceConverter = new NotificationSourceConverter();
        this.__db = __db;
        this.__insertAdapterOfInboxNotificationEntity = new EntityInsertAdapter<InboxNotificationEntity>() { // from class: com.box.android.data.persistence.inboxnotifications.InboxNotificationDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `inbox_notifications` (`notification_id`,`type`,`created_at`,`is_seen`,`is_read`,`json_data`,`network_fetched_at`,`source`) VALUES (?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, InboxNotificationEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo10944bindText(1, entity.getNotificationId());
                statement.mo10944bindText(2, entity.getType());
                Long lDateToTimestamp = InboxNotificationDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getCreatedAt());
                if (lDateToTimestamp == null) {
                    statement.mo10943bindNull(3);
                } else {
                    statement.mo10942bindLong(3, lDateToTimestamp.longValue());
                }
                statement.mo10942bindLong(4, entity.isSeen() ? 1L : 0L);
                statement.mo10942bindLong(5, entity.isRead() ? 1L : 0L);
                statement.mo10940bindBlob(6, entity.getJsonData());
                Long lDateToTimestamp2 = InboxNotificationDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getNetworkFetchedAt());
                if (lDateToTimestamp2 == null) {
                    statement.mo10943bindNull(7);
                } else {
                    statement.mo10942bindLong(7, lDateToTimestamp2.longValue());
                }
                statement.mo10944bindText(8, InboxNotificationDao_Impl.this.__notificationSourceConverter.fromNotificationSource(entity.getSource()));
            }
        };
    }

    @Override // com.box.android.data.persistence.inboxnotifications.InboxNotificationDao
    public Object insertNotifications(final List<InboxNotificationEntity> list, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.inboxnotifications.InboxNotificationDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InboxNotificationDao_Impl.insertNotifications$lambda$0(this.f$0, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertNotifications$lambda$0(InboxNotificationDao_Impl inboxNotificationDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        inboxNotificationDao_Impl.__insertAdapterOfInboxNotificationEntity.insert(_connection, list);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.inboxnotifications.InboxNotificationDao
    public Object getApiNotifications(final int i, Continuation<? super List<InboxNotificationEntity>> continuation) {
        final String str = "SELECT * FROM inbox_notifications WHERE source = 'API' ORDER BY created_at DESC LIMIT ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.inboxnotifications.InboxNotificationDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InboxNotificationDao_Impl.getApiNotifications$lambda$0(str, i, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getApiNotifications$lambda$0(String str, int i, InboxNotificationDao_Impl inboxNotificationDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10942bindLong(1, i);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, IntentConstants.EXTRA_REDIRECT_ON_FAILURE_URL);
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "created_at");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "is_seen");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "is_read");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "json_data");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "network_fetched_at");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "source");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                Date dateFromTimestamp = inboxNotificationDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow3)));
                if (dateFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4)) != 0;
                boolean z2 = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) != 0;
                byte[] blob = sQLiteStatementPrepare.getBlob(columnIndexOrThrow6);
                Date dateFromTimestamp2 = inboxNotificationDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow7)));
                if (dateFromTimestamp2 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                arrayList.add(new InboxNotificationEntity(text, text2, dateFromTimestamp, z, z2, blob, dateFromTimestamp2, inboxNotificationDao_Impl.__notificationSourceConverter.toNotificationSource(sQLiteStatementPrepare.getText(columnIndexOrThrow8))));
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.inboxnotifications.InboxNotificationDao
    public Object updateReadStatus(final String str, final boolean z, Continuation<? super Unit> continuation) {
        final String str2 = "UPDATE inbox_notifications SET is_read = ? WHERE notification_id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.inboxnotifications.InboxNotificationDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InboxNotificationDao_Impl.updateReadStatus$lambda$0(str2, z, str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateReadStatus$lambda$0(String str, boolean z, String str2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10942bindLong(1, z ? 1L : 0L);
            sQLiteStatementPrepare.mo10944bindText(2, str2);
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.inboxnotifications.InboxNotificationDao
    public Object deleteOldNotifications(final long j, Continuation<? super Unit> continuation) {
        final String str = "DELETE FROM inbox_notifications WHERE network_fetched_at < ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.inboxnotifications.InboxNotificationDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InboxNotificationDao_Impl.deleteOldNotifications$lambda$0(str, j, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteOldNotifications$lambda$0(String str, long j, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10942bindLong(1, j);
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: compiled from: InboxNotificationDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/persistence/inboxnotifications/InboxNotificationDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
