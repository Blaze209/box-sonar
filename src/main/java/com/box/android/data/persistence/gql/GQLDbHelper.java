package com.box.android.data.persistence.gql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.exifinterface.media.ExifInterface;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.data.user.UserData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLDbHelper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007J\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\nJ<\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00020\u00072!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u0002H\r0\u0010¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/persistence/gql/GQLDbHelper;", "", "userData", "Lcom/box/android/data/user/UserData;", "<init>", "(Lcom/box/android/data/user/UserData;)V", "extractFolderItemConnectionAsJsonString", "", "folderId", "batchExtractDbRowsAsJsonString", "", "rowCacheKeyList", "executeQueryOnGQLDb", ExifInterface.GPS_DIRECTION_TRUE, "query", "cursorAction", "Lkotlin/Function1;", "Landroid/database/Cursor;", "Lkotlin/ParameterName;", "name", "cursor", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLDbHelper {
    private static final String DB_PATH_PREFIX = ApplicationProvider.getApplication().getDataDir() + "/databases/";
    private final UserData userData;

    @Inject
    public GQLDbHelper(UserData userData) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        this.userData = userData;
    }

    public final String extractFolderItemConnectionAsJsonString(String folderId) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        return (String) executeQueryOnGQLDb("SELECT record\nFROM records\nWHERE `key` = 'Folder:" + folderId + ".itemConnection'", new Function1() { // from class: com.box.android.data.persistence.gql.GQLDbHelper$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GQLDbHelper.extractFolderItemConnectionAsJsonString$lambda$0((Cursor) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String extractFolderItemConnectionAsJsonString$lambda$0(Cursor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.moveToFirst()) {
            return it.getString(0);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence batchExtractDbRowsAsJsonString$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "'" + it + "'";
    }

    public final List<String> batchExtractDbRowsAsJsonString(List<String> rowCacheKeyList) {
        Intrinsics.checkNotNullParameter(rowCacheKeyList, "rowCacheKeyList");
        String str = "SELECT record\nFROM records\nWHERE records.`key` IN (" + CollectionsKt.joinToString$default(rowCacheKeyList, ",", null, null, 0, null, new Function1() { // from class: com.box.android.data.persistence.gql.GQLDbHelper$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GQLDbHelper.batchExtractDbRowsAsJsonString$lambda$0((String) obj);
            }
        }, 30, null) + ")";
        final ArrayList arrayList = new ArrayList();
        return (List) executeQueryOnGQLDb(str, new Function1() { // from class: com.box.android.data.persistence.gql.GQLDbHelper$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GQLDbHelper.batchExtractDbRowsAsJsonString$lambda$1(arrayList, (Cursor) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List batchExtractDbRowsAsJsonString$lambda$1(List list, Cursor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.moveToFirst()) {
            do {
                String string = it.getString(0);
                Intrinsics.checkNotNull(string);
                list.add(string);
            } while (it.moveToNext());
        }
        return list;
    }

    public final <T> T executeQueryOnGQLDb(String query, Function1<? super Cursor, ? extends T> cursorAction) throws IOException {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(cursorAction, "cursorAction");
        SQLiteDatabase sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(DB_PATH_PREFIX + this.userData.getBoxDbName(true), null, 0);
        SQLiteDatabase sQLiteDatabase = sQLiteDatabaseOpenDatabase;
        try {
            Cursor cursorRawQuery = sQLiteDatabaseOpenDatabase.rawQuery(query, null);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
            Cursor cursor = cursorRawQuery;
            try {
                T tInvoke = cursorAction.invoke(cursor);
                CloseableKt.closeFinally(cursor, null);
                CloseableKt.closeFinally(sQLiteDatabase, null);
                return tInvoke;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursor, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(sQLiteDatabase, th3);
                throw th4;
            }
        }
    }
}
