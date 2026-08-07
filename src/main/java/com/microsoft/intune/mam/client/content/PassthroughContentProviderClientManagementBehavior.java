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
public class PassthroughContentProviderClientManagementBehavior implements ContentProviderClientManagementBehavior {
    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public ContentProviderResult[] applyBatch(ContentProviderClient contentProviderClient, ArrayList<ContentProviderOperation> arrayList) throws RemoteException, OperationApplicationException {
        return contentProviderClient.applyBatch(arrayList);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public ContentProviderResult[] applyBatch(ContentProviderClient contentProviderClient, String str, ArrayList<ContentProviderOperation> arrayList) throws RemoteException, OperationApplicationException {
        return contentProviderClient.applyBatch(str, arrayList);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public int bulkInsert(ContentProviderClient contentProviderClient, Uri uri, ContentValues[] contentValuesArr) throws RemoteException {
        return contentProviderClient.bulkInsert(uri, contentValuesArr);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public Bundle call(ContentProviderClient contentProviderClient, String str, String str2, Bundle bundle) throws RemoteException {
        return contentProviderClient.call(str, str2, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public Bundle call(ContentProviderClient contentProviderClient, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        return contentProviderClient.call(str, str2, str3, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public int delete(ContentProviderClient contentProviderClient, Uri uri, String str, String[] strArr) throws RemoteException {
        return contentProviderClient.delete(uri, str, strArr);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public int delete(ContentProviderClient contentProviderClient, Uri uri, Bundle bundle) throws RemoteException {
        return contentProviderClient.delete(uri, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public String[] getStreamTypes(ContentProviderClient contentProviderClient, Uri uri, String str) throws RemoteException {
        return contentProviderClient.getStreamTypes(uri, str);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public String getType(ContentProviderClient contentProviderClient, Uri uri) throws RemoteException {
        return contentProviderClient.getType(uri);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public Uri insert(ContentProviderClient contentProviderClient, Uri uri, ContentValues contentValues) throws RemoteException {
        return contentProviderClient.insert(uri, contentValues);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public Uri insert(ContentProviderClient contentProviderClient, Uri uri, ContentValues contentValues, Bundle bundle) throws RemoteException {
        return contentProviderClient.insert(uri, contentValues, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public AssetFileDescriptor openAssetFile(ContentProviderClient contentProviderClient, Uri uri, String str, CancellationSignal cancellationSignal) throws RemoteException, FileNotFoundException {
        return contentProviderClient.openAssetFile(uri, str, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public AssetFileDescriptor openAssetFile(ContentProviderClient contentProviderClient, Uri uri, String str) throws RemoteException, FileNotFoundException {
        return contentProviderClient.openAssetFile(uri, str);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public ParcelFileDescriptor openFile(ContentProviderClient contentProviderClient, Uri uri, String str, CancellationSignal cancellationSignal) throws RemoteException, FileNotFoundException {
        return contentProviderClient.openFile(uri, str, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public ParcelFileDescriptor openFile(ContentProviderClient contentProviderClient, Uri uri, String str) throws RemoteException, FileNotFoundException {
        return contentProviderClient.openFile(uri, str);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public AssetFileDescriptor openTypedAssetFile(ContentProviderClient contentProviderClient, Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws RemoteException, FileNotFoundException {
        return contentProviderClient.openTypedAssetFileDescriptor(uri, str, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public AssetFileDescriptor openTypedAssetFileDescriptor(ContentProviderClient contentProviderClient, Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws RemoteException, FileNotFoundException {
        return contentProviderClient.openTypedAssetFileDescriptor(uri, str, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public AssetFileDescriptor openTypedAssetFileDescriptor(ContentProviderClient contentProviderClient, Uri uri, String str, Bundle bundle) throws RemoteException, FileNotFoundException {
        return contentProviderClient.openTypedAssetFileDescriptor(uri, str, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public Cursor query(ContentProviderClient contentProviderClient, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) throws RemoteException {
        return contentProviderClient.query(uri, strArr, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public Cursor query(ContentProviderClient contentProviderClient, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) throws RemoteException {
        return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public Cursor query(ContentProviderClient contentProviderClient, Uri uri, String[] strArr, String str, String[] strArr2, String str2) throws RemoteException {
        return contentProviderClient.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public boolean refresh(ContentProviderClient contentProviderClient, Uri uri, Bundle bundle, CancellationSignal cancellationSignal) throws RemoteException {
        return contentProviderClient.refresh(uri, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public int update(ContentProviderClient contentProviderClient, Uri uri, ContentValues contentValues, String str, String[] strArr) throws RemoteException {
        return contentProviderClient.update(uri, contentValues, str, strArr);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior
    public int update(ContentProviderClient contentProviderClient, Uri uri, ContentValues contentValues, Bundle bundle) throws RemoteException {
        return contentProviderClient.update(uri, contentValues, bundle);
    }
}
