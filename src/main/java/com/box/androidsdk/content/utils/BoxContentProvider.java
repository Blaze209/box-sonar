package com.box.androidsdk.content.utils;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.box.androidsdk.content.BoxConfig;
import com.microsoft.intune.mam.client.content.MAMContentProvider;

/* JADX INFO: loaded from: classes13.dex */
public class BoxContentProvider extends MAMContentProvider {
    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public int deleteMAM(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Uri insertMAM(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public int updateMAM(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        BoxConfig.APPLICATION_CONTEXT = getContext();
        return true;
    }
}
