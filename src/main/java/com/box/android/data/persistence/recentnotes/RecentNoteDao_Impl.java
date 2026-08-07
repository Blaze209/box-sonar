package com.box.android.data.persistence.recentnotes;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
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
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: RecentNoteDao_Impl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0096@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/persistence/recentnotes/RecentNoteDao_Impl;", "Lcom/box/android/data/persistence/recentnotes/RecentNoteDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfRecentNoteEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/box/android/data/persistence/recentnotes/RecentNoteEntity;", "upsertAll", "", "entities", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsert", "entity", "(Lcom/box/android/data/persistence/recentnotes/RecentNoteEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeAll", "Lkotlinx/coroutines/flow/Flow;", "deleteAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentNoteDao_Impl implements RecentNoteDao {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<RecentNoteEntity> __insertAdapterOfRecentNoteEntity;

    public RecentNoteDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfRecentNoteEntity = new EntityInsertAdapter<RecentNoteEntity>() { // from class: com.box.android.data.persistence.recentnotes.RecentNoteDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `recent_notes` (`item_id`,`interacted_at`,`interaction_type`,`interaction_shared_link`) VALUES (?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, RecentNoteEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo10944bindText(1, entity.getItemId());
                Long interactedAt = entity.getInteractedAt();
                if (interactedAt == null) {
                    statement.mo10943bindNull(2);
                } else {
                    statement.mo10942bindLong(2, interactedAt.longValue());
                }
                String interactionType = entity.getInteractionType();
                if (interactionType == null) {
                    statement.mo10943bindNull(3);
                } else {
                    statement.mo10944bindText(3, interactionType);
                }
                String interactionSharedLink = entity.getInteractionSharedLink();
                if (interactionSharedLink == null) {
                    statement.mo10943bindNull(4);
                } else {
                    statement.mo10944bindText(4, interactionSharedLink);
                }
            }
        };
    }

    @Override // com.box.android.data.persistence.recentnotes.RecentNoteDao
    public Object upsertAll(final List<RecentNoteEntity> list, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.recentnotes.RecentNoteDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecentNoteDao_Impl.upsertAll$lambda$0(this.f$0, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upsertAll$lambda$0(RecentNoteDao_Impl recentNoteDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        recentNoteDao_Impl.__insertAdapterOfRecentNoteEntity.insert(_connection, list);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.recentnotes.RecentNoteDao
    public Object upsert(final RecentNoteEntity recentNoteEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.recentnotes.RecentNoteDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecentNoteDao_Impl.upsert$lambda$0(this.f$0, recentNoteEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upsert$lambda$0(RecentNoteDao_Impl recentNoteDao_Impl, RecentNoteEntity recentNoteEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        recentNoteDao_Impl.__insertAdapterOfRecentNoteEntity.insert(_connection, recentNoteEntity);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.recentnotes.RecentNoteDao
    public Flow<List<RecentNoteEntity>> observeAll() {
        final String str = "SELECT * FROM recent_notes ORDER BY interacted_at DESC";
        return FlowUtil.createFlow(this.__db, false, new String[]{"recent_notes"}, new Function1() { // from class: com.box.android.data.persistence.recentnotes.RecentNoteDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecentNoteDao_Impl.observeAll$lambda$0(str, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List observeAll$lambda$0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "item_id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interacted_at");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interaction_type");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interaction_shared_link");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = null;
                Long lValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow2));
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                if (!sQLiteStatementPrepare.isNull(columnIndexOrThrow4)) {
                    text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                }
                arrayList.add(new RecentNoteEntity(text, lValueOf, text3, text2));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.recentnotes.RecentNoteDao
    public Object deleteAll(Continuation<? super Unit> continuation) {
        final String str = "DELETE FROM recent_notes";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.recentnotes.RecentNoteDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecentNoteDao_Impl.deleteAll$lambda$0(str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteAll$lambda$0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: compiled from: RecentNoteDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/persistence/recentnotes/RecentNoteDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
