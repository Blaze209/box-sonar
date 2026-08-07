package com.microsoft.intune.mam.client.content;

import android.content.ContentProviderClient;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public interface ContentProviderClientManagementBehavior {
    ContentProviderResult[] applyBatch(ContentProviderClient contentProviderClient, String str, ArrayList<ContentProviderOperation> arrayList) throws RemoteException, OperationApplicationException;

    ContentProviderResult[] applyBatch(ContentProviderClient contentProviderClient, ArrayList<ContentProviderOperation> arrayList) throws RemoteException, OperationApplicationException;

    int bulkInsert(ContentProviderClient contentProviderClient, Uri uri, ContentValues[] contentValuesArr) throws RemoteException;

    Bundle call(ContentProviderClient contentProviderClient, String str, String str2, Bundle bundle) throws RemoteException;

    Bundle call(ContentProviderClient contentProviderClient, String str, String str2, String str3, Bundle bundle) throws RemoteException;

    int delete(ContentProviderClient contentProviderClient, Uri uri, Bundle bundle) throws RemoteException;

    int delete(ContentProviderClient contentProviderClient, Uri uri, String str, String[] strArr) throws RemoteException;

    String[] getStreamTypes(ContentProviderClient contentProviderClient, Uri uri, String str) throws RemoteException;

    String getType(ContentProviderClient contentProviderClient, Uri uri) throws RemoteException;

    Uri insert(ContentProviderClient contentProviderClient, Uri uri, ContentValues contentValues) throws RemoteException;

    Uri insert(ContentProviderClient contentProviderClient, Uri uri, ContentValues contentValues, Bundle bundle) throws RemoteException;

    AssetFileDescriptor openAssetFile(ContentProviderClient contentProviderClient, Uri uri, String str) throws RemoteException, FileNotFoundException;

    AssetFileDescriptor openAssetFile(ContentProviderClient contentProviderClient, Uri uri, String str, CancellationSignal cancellationSignal) throws RemoteException, FileNotFoundException;

    ParcelFileDescriptor openFile(ContentProviderClient contentProviderClient, Uri uri, String str) throws RemoteException, FileNotFoundException;

    ParcelFileDescriptor openFile(ContentProviderClient contentProviderClient, Uri uri, String str, CancellationSignal cancellationSignal) throws RemoteException, FileNotFoundException;

    AssetFileDescriptor openTypedAssetFile(ContentProviderClient contentProviderClient, Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws RemoteException, FileNotFoundException;

    AssetFileDescriptor openTypedAssetFileDescriptor(ContentProviderClient contentProviderClient, Uri uri, String str, Bundle bundle) throws RemoteException, FileNotFoundException;

    AssetFileDescriptor openTypedAssetFileDescriptor(ContentProviderClient contentProviderClient, Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws RemoteException, FileNotFoundException;

    Cursor query(ContentProviderClient contentProviderClient, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) throws RemoteException;

    Cursor query(ContentProviderClient contentProviderClient, Uri uri, String[] strArr, String str, String[] strArr2, String str2) throws RemoteException;

    Cursor query(ContentProviderClient contentProviderClient, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) throws RemoteException;

    boolean refresh(ContentProviderClient contentProviderClient, Uri uri, Bundle bundle, CancellationSignal cancellationSignal) throws RemoteException;

    int update(ContentProviderClient contentProviderClient, Uri uri, ContentValues contentValues, Bundle bundle) throws RemoteException;

    int update(ContentProviderClient contentProviderClient, Uri uri, ContentValues contentValues, String str, String[] strArr) throws RemoteException;
}
