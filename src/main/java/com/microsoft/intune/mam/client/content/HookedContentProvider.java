package com.microsoft.intune.mam.client.content;

import android.content.ContentProvider;
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
import com.microsoft.intune.mam.client.app.MAMIdentityRequirementListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedContentProvider extends MAMIdentityRequirementListener {
    ContentProviderResult[] applyBatchMAM(String str, ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException;

    ContentProviderResult[] applyBatchMAM(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException;

    ContentProviderResult[] applyBatchReal(String str, ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException;

    ContentProviderResult[] applyBatchReal(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException;

    ContentProvider asContentProvider();

    void attachInfoMAM(Context context, ProviderInfo providerInfo);

    void attachInfoReal(Context context, ProviderInfo providerInfo);

    int bulkInsertMAM(Uri uri, ContentValues[] contentValuesArr);

    int bulkInsertReal(Uri uri, ContentValues[] contentValuesArr);

    Bundle callMAM(String str, String str2, Bundle bundle);

    Bundle callMAM(String str, String str2, String str3, Bundle bundle);

    Bundle callReal(String str, String str2, Bundle bundle);

    Bundle callReal(String str, String str2, String str3, Bundle bundle);

    int deleteMAM(Uri uri, Bundle bundle);

    int deleteMAM(Uri uri, String str, String[] strArr);

    int deleteReal(Uri uri, Bundle bundle);

    Uri insertMAM(Uri uri, ContentValues contentValues);

    Uri insertMAM(Uri uri, ContentValues contentValues, Bundle bundle);

    Uri insertReal(Uri uri, ContentValues contentValues, Bundle bundle);

    AssetFileDescriptor openAssetFileMAM(Uri uri, String str) throws FileNotFoundException;

    AssetFileDescriptor openAssetFileMAM(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException;

    AssetFileDescriptor openAssetFileReal(Uri uri, String str) throws FileNotFoundException;

    AssetFileDescriptor openAssetFileReal(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException;

    ParcelFileDescriptor openFileMAM(Uri uri, String str) throws FileNotFoundException;

    ParcelFileDescriptor openFileMAM(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException;

    ParcelFileDescriptor openFileReal(Uri uri, String str) throws FileNotFoundException;

    ParcelFileDescriptor openFileReal(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException;

    AssetFileDescriptor openTypedAssetFileMAM(Uri uri, String str, Bundle bundle) throws FileNotFoundException;

    AssetFileDescriptor openTypedAssetFileMAM(Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException;

    AssetFileDescriptor openTypedAssetFileReal(Uri uri, String str, Bundle bundle) throws FileNotFoundException;

    AssetFileDescriptor openTypedAssetFileReal(Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException;

    Cursor queryMAM(Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal);

    Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

    Cursor queryReal(Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal);

    Cursor queryReal(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

    int updateMAM(Uri uri, ContentValues contentValues, Bundle bundle);

    int updateMAM(Uri uri, ContentValues contentValues, String str, String[] strArr);

    int updateReal(Uri uri, ContentValues contentValues, Bundle bundle);
}
