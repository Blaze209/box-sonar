package com.microsoft.intune.mam.client.content;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public interface ContentProviderBehavior {
    ContentProviderResult[] applyBatch(String str, ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException;

    ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException;

    ContentProviderResult[] applyBatchMAM(String str, ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException;

    ContentProviderResult[] applyBatchMAM(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException;

    void attachInfo(Context context, ProviderInfo providerInfo);

    void attachInfoMAM(Context context, ProviderInfo providerInfo);

    int bulkInsert(Uri uri, ContentValues[] contentValuesArr);

    int bulkInsertMAM(Uri uri, ContentValues[] contentValuesArr);

    Bundle call(String str, String str2, Bundle bundle);

    Bundle call(String str, String str2, String str3, Bundle bundle);

    Bundle callMAM(String str, String str2, Bundle bundle);

    Bundle callMAM(String str, String str2, String str3, Bundle bundle);

    int delete(Uri uri, Bundle bundle);

    int delete(Uri uri, String str, String[] strArr);

    int deleteMAM(Uri uri, Bundle bundle);

    Uri insert(Uri uri, ContentValues contentValues);

    Uri insert(Uri uri, ContentValues contentValues, Bundle bundle);

    Uri insertMAM(Uri uri, ContentValues contentValues, Bundle bundle);

    boolean isProvideContentAllowed(MAMIdentity mAMIdentity);

    @Deprecated
    boolean isProvideContentAllowed(String str);

    AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException;

    AssetFileDescriptor openAssetFileMAM(Uri uri, String str) throws FileNotFoundException;

    ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException;

    ParcelFileDescriptor openFileMAM(Uri uri, String str) throws FileNotFoundException;

    AssetFileDescriptor openTypedAssetFile(Uri uri, String str, Bundle bundle) throws FileNotFoundException;

    AssetFileDescriptor openTypedAssetFileMAM(Uri uri, String str, Bundle bundle) throws FileNotFoundException;

    Cursor query(Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal);

    Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    void setContentProvider(HookedContentProvider hookedContentProvider);

    int update(Uri uri, ContentValues contentValues, Bundle bundle);

    int update(Uri uri, ContentValues contentValues, String str, String[] strArr);

    int updateMAM(Uri uri, ContentValues contentValues, Bundle bundle);
}
