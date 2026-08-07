package com.microsoft.intune.mam.client.content;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes3.dex */
public interface FileProviderBehavior extends ContentProviderBehavior {
    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    int delete(Uri uri, String str, String[] strArr);

    int deleteMAM(Uri uri, String str, String[] strArr);

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    Uri insert(Uri uri, ContentValues contentValues);

    Uri insertMAM(Uri uri, ContentValues contentValues);

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    void setFileProvider(HookedFileProvider hookedFileProvider);

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    int update(Uri uri, ContentValues contentValues, String str, String[] strArr);

    int updateMAM(Uri uri, ContentValues contentValues, String str, String[] strArr);
}
