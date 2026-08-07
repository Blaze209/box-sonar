package com.box.android.data.persistence.sharedlink;

import androidx.core.provider.FontsContractCompat;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
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

/* JADX INFO: compiled from: SharedLinkCredentialsDao_Impl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/persistence/sharedlink/SharedLinkCredentialsDao_Impl;", "Lcom/box/android/data/persistence/sharedlink/SharedLinkCredentialsDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfSharedlinkCredentialEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/box/android/data/persistence/sharedlink/SharedlinkCredentialEntity;", "insertSharedLinkCredentials", "", "sharedlinkCredential", "(Lcom/box/android/data/persistence/sharedlink/SharedlinkCredentialEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSharedLinkCredential", "fileId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SharedLinkCredentialsDao_Impl implements SharedLinkCredentialsDao {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<SharedlinkCredentialEntity> __insertAdapterOfSharedlinkCredentialEntity;

    public SharedLinkCredentialsDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfSharedlinkCredentialEntity = new EntityInsertAdapter<SharedlinkCredentialEntity>() { // from class: com.box.android.data.persistence.sharedlink.SharedLinkCredentialsDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `sharedlink_credentials` (`file_id`,`url`,`password`) VALUES (?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, SharedlinkCredentialEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo10944bindText(1, entity.getFileId());
                statement.mo10944bindText(2, entity.getUrl());
                String password = entity.getPassword();
                if (password == null) {
                    statement.mo10943bindNull(3);
                } else {
                    statement.mo10944bindText(3, password);
                }
            }
        };
    }

    @Override // com.box.android.data.persistence.sharedlink.SharedLinkCredentialsDao
    public Object insertSharedLinkCredentials(final SharedlinkCredentialEntity sharedlinkCredentialEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.sharedlink.SharedLinkCredentialsDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SharedLinkCredentialsDao_Impl.insertSharedLinkCredentials$lambda$0(this.f$0, sharedlinkCredentialEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertSharedLinkCredentials$lambda$0(SharedLinkCredentialsDao_Impl sharedLinkCredentialsDao_Impl, SharedlinkCredentialEntity sharedlinkCredentialEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        sharedLinkCredentialsDao_Impl.__insertAdapterOfSharedlinkCredentialEntity.insert(_connection, sharedlinkCredentialEntity);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.persistence.sharedlink.SharedLinkCredentialsDao
    public Object getSharedLinkCredential(final String str, Continuation<? super SharedlinkCredentialEntity> continuation) {
        final String str2 = "SELECT * FROM sharedlink_credentials where file_id = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.sharedlink.SharedLinkCredentialsDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SharedLinkCredentialsDao_Impl.getSharedLinkCredential$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedlinkCredentialEntity getSharedLinkCredential$lambda$0(String str, String str2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10944bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, FontsContractCompat.Columns.FILE_ID);
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "url");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "password");
            SharedlinkCredentialEntity sharedlinkCredentialEntity = null;
            String text = null;
            if (sQLiteStatementPrepare.step()) {
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                if (!sQLiteStatementPrepare.isNull(columnIndexOrThrow3)) {
                    text = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                }
                sharedlinkCredentialEntity = new SharedlinkCredentialEntity(text2, text3, text);
            }
            return sharedlinkCredentialEntity;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: compiled from: SharedLinkCredentialsDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/persistence/sharedlink/SharedLinkCredentialsDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
