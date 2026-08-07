package com.microsoft.intune.mam.client.content;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedFileProvider extends HookedContentProvider {
    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    void attachInfoReal(Context context, ProviderInfo providerInfo);

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    int deleteMAM(Uri uri, String str, String[] strArr);

    int deleteReal(Uri uri, String str, String[] strArr);

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    Uri insertMAM(Uri uri, ContentValues contentValues);

    Uri insertReal(Uri uri, ContentValues contentValues);

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    ParcelFileDescriptor openFileMAM(Uri uri, String str) throws FileNotFoundException;

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    ParcelFileDescriptor openFileReal(Uri uri, String str) throws FileNotFoundException;

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    Cursor queryReal(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    int updateMAM(Uri uri, ContentValues contentValues, String str, String[] strArr);

    int updateReal(Uri uri, ContentValues contentValues, String str, String[] strArr);
}
