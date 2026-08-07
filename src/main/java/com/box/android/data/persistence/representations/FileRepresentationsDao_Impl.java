package com.box.android.data.persistence.representations;

import androidx.core.provider.FontsContractCompat;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.box.android.data.persistence.localItems.ItemIdConverter;
import com.box.android.data.persistence.localItems.ItemIdRemoteIdConverter;
import com.box.android.domain.models.ItemId;
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

/* JADX INFO: compiled from: FileRepresentationsDao_Impl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0010J \u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/persistence/representations/FileRepresentationsDao_Impl;", "Lcom/box/android/data/persistence/representations/FileRepresentationsDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfRepresentationsItemEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/box/android/data/persistence/representations/RepresentationsItemEntity;", "__itemIdConverter", "Lcom/box/android/data/persistence/localItems/ItemIdConverter;", "__itemIdRemoteIdConverter", "Lcom/box/android/data/persistence/localItems/ItemIdRemoteIdConverter;", "insertRepresentation", "", "representationItemEntity", "(Lcom/box/android/data/persistence/representations/RepresentationsItemEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRepresentationsForFile", "fileId", "Lcom/box/android/domain/models/ItemId$Remote;", "sha1", "", "(Lcom/box/android/domain/models/ItemId$Remote;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileRepresentationsDao_Impl implements FileRepresentationsDao {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<RepresentationsItemEntity> __insertAdapterOfRepresentationsItemEntity;
    private final ItemIdConverter __itemIdConverter;
    private final ItemIdRemoteIdConverter __itemIdRemoteIdConverter;

    public FileRepresentationsDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__itemIdConverter = new ItemIdConverter();
        this.__itemIdRemoteIdConverter = new ItemIdRemoteIdConverter();
        this.__db = __db;
        this.__insertAdapterOfRepresentationsItemEntity = new EntityInsertAdapter<RepresentationsItemEntity>() { // from class: com.box.android.data.persistence.representations.FileRepresentationsDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `file_representations` (`file_id`,`sha1`,`json_response`) VALUES (?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, RepresentationsItemEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                String string = FileRepresentationsDao_Impl.this.__itemIdConverter.toString(entity.getFileId());
                if (string == null) {
                    statement.mo10943bindNull(1);
                } else {
                    statement.mo10944bindText(1, string);
                }
                statement.mo10944bindText(2, entity.getSha1());
                statement.mo10944bindText(3, entity.getResponseJson());
            }
        };
    }

    @Override // com.box.android.data.persistence.representations.FileRepresentationsDao
    public Object insertRepresentation(final RepresentationsItemEntity representationsItemEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.representations.FileRepresentationsDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileRepresentationsDao_Impl.insertRepresentation$lambda$0(this.f$0, representationsItemEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertRepresentation$lambda$0(FileRepresentationsDao_Impl fileRepresentationsDao_Impl, RepresentationsItemEntity representationsItemEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        fileRepresentationsDao_Impl.__insertAdapterOfRepresentationsItemEntity.insert(_connection, representationsItemEntity);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.representations.FileRepresentationsDao
    public Object getRepresentationsForFile(final ItemId.Remote remote, final String str, Continuation<? super RepresentationsItemEntity> continuation) {
        final String str2 = "SELECT * from file_representations where file_id = ? and sha1 = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.representations.FileRepresentationsDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileRepresentationsDao_Impl.getRepresentationsForFile$lambda$0(str2, this, remote, str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RepresentationsItemEntity getRepresentationsForFile$lambda$0(String str, FileRepresentationsDao_Impl fileRepresentationsDao_Impl, ItemId.Remote remote, String str2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            String string = fileRepresentationsDao_Impl.__itemIdConverter.toString(remote);
            if (string == null) {
                sQLiteStatementPrepare.mo10943bindNull(1);
            } else {
                sQLiteStatementPrepare.mo10944bindText(1, string);
            }
            sQLiteStatementPrepare.mo10944bindText(2, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, FontsContractCompat.Columns.FILE_ID);
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sha1");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "json_response");
            RepresentationsItemEntity representationsItemEntity = null;
            ItemId.Remote remoteFromString = null;
            if (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (text != null) {
                    remoteFromString = fileRepresentationsDao_Impl.__itemIdRemoteIdConverter.fromString(text);
                }
                if (remoteFromString == null) {
                    throw new IllegalStateException("Expected NON-NULL 'com.box.android.domain.models.ItemId.Remote', but it was NULL.".toString());
                }
                representationsItemEntity = new RepresentationsItemEntity(remoteFromString, sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3));
            }
            sQLiteStatementPrepare.close();
            return representationsItemEntity;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: compiled from: FileRepresentationsDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/persistence/representations/FileRepresentationsDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
