package com.box.android.data.persistence.comment;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.box.android.data.persistence.DateToLongConverter;
import com.box.android.data.persistence.annotations.CommentEntity;
import com.box.android.data.persistence.annotations.FileActivityStatusConverter;
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

/* JADX INFO: compiled from: CommentDao_Impl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/persistence/comment/CommentDao_Impl;", "Lcom/box/android/data/persistence/comment/CommentDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfCommentEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/box/android/data/persistence/annotations/CommentEntity;", "__dateToLongConverter", "Lcom/box/android/data/persistence/DateToLongConverter;", "__fileActivityStatusConverter", "Lcom/box/android/data/persistence/annotations/FileActivityStatusConverter;", "insertComment", "", "commentEntity", "(Lcom/box/android/data/persistence/annotations/CommentEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteComment", "commentId", "", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommentDao_Impl implements CommentDao {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DateToLongConverter __dateToLongConverter;
    private final RoomDatabase __db;
    private final FileActivityStatusConverter __fileActivityStatusConverter;
    private final EntityInsertAdapter<CommentEntity> __insertAdapterOfCommentEntity;

    public CommentDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__dateToLongConverter = new DateToLongConverter();
        this.__fileActivityStatusConverter = new FileActivityStatusConverter();
        this.__db = __db;
        this.__insertAdapterOfCommentEntity = new EntityInsertAdapter<CommentEntity>() { // from class: com.box.android.data.persistence.comment.CommentDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `comments` (`comment_id`,`created_at`,`file_id`,`json_data`,`network_fetched_at`,`total_reply_count`,`status`,`parent_id`) VALUES (?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, CommentEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo10944bindText(1, entity.getCommentId());
                Long lDateToTimestamp = CommentDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getCreatedAt());
                if (lDateToTimestamp == null) {
                    statement.mo10943bindNull(2);
                } else {
                    statement.mo10942bindLong(2, lDateToTimestamp.longValue());
                }
                statement.mo10944bindText(3, entity.getFileId());
                statement.mo10940bindBlob(4, entity.getJsonData());
                Long lDateToTimestamp2 = CommentDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getNetworkFetchedAt());
                if (lDateToTimestamp2 == null) {
                    statement.mo10943bindNull(5);
                } else {
                    statement.mo10942bindLong(5, lDateToTimestamp2.longValue());
                }
                statement.mo10942bindLong(6, entity.getTotalReplyCount());
                statement.mo10944bindText(7, CommentDao_Impl.this.__fileActivityStatusConverter.toString(entity.getStatus()));
                String parentFileActivityId = entity.getParentFileActivityId();
                if (parentFileActivityId == null) {
                    statement.mo10943bindNull(8);
                } else {
                    statement.mo10944bindText(8, parentFileActivityId);
                }
            }
        };
    }

    @Override // com.box.android.data.persistence.comment.CommentDao
    public Object insertComment(final CommentEntity commentEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.comment.CommentDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CommentDao_Impl.insertComment$lambda$0(this.f$0, commentEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertComment$lambda$0(CommentDao_Impl commentDao_Impl, CommentEntity commentEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        commentDao_Impl.__insertAdapterOfCommentEntity.insert(_connection, commentEntity);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.comment.CommentDao
    public void deleteComment(final String commentId) {
        Intrinsics.checkNotNullParameter(commentId, "commentId");
        final String str = "DELETE FROM comments where comment_id = ?";
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.comment.CommentDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CommentDao_Impl.deleteComment$lambda$0(str, commentId, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteComment$lambda$0(String str, String str2, SQLiteConnection _connection) {
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

    /* JADX INFO: compiled from: CommentDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/persistence/comment/CommentDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
