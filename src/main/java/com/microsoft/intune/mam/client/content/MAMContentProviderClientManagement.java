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
import com.microsoft.intune.mam.client.CachedBehaviorProvider;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMContentProviderClientManagement {
    private static CachedBehaviorProvider<ContentProviderClientManagementBehavior> sCachedBehavior = new CachedBehaviorProvider<>(ContentProviderClientManagementBehavior.class);

    public static ContentProviderResult[] applyBatch(ContentProviderClient contentProviderClient, ArrayList<ContentProviderOperation> arrayList) throws RemoteException, OperationApplicationException {
        return getBehavior().applyBatch(contentProviderClient, arrayList);
    }

    public static ContentProviderResult[] applyBatch(ContentProviderClient contentProviderClient, String str, ArrayList<ContentProviderOperation> arrayList) throws RemoteException, OperationApplicationException {
        return getBehavior().applyBatch(contentProviderClient, str, arrayList);
    }

    public static int bulkInsert(ContentProviderClient contentProviderClient, Uri uri, ContentValues[] contentValuesArr) throws RemoteException {
        return getBehavior().bulkInsert(contentProviderClient, uri, contentValuesArr);
    }

    public static Bundle call(ContentProviderClient contentProviderClient, String str, String str2, Bundle bundle) throws RemoteException {
        return getBehavior().call(contentProviderClient, str, str2, bundle);
    }

    public static Bundle call(ContentProviderClient contentProviderClient, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        return getBehavior().call(contentProviderClient, str, str2, str3, bundle);
    }

    public static int delete(ContentProviderClient contentProviderClient, Uri uri, String str, String[] strArr) throws RemoteException {
        return getBehavior().delete(contentProviderClient, uri, str, strArr);
    }

    public static int delete(ContentProviderClient contentProviderClient, Uri uri, Bundle bundle) throws RemoteException {
        return getBehavior().delete(contentProviderClient, uri, bundle);
    }

    public static String[] getStreamTypes(ContentProviderClient contentProviderClient, Uri uri, String str) throws RemoteException {
        return getBehavior().getStreamTypes(contentProviderClient, uri, str);
    }

    public static String getType(ContentProviderClient contentProviderClient, Uri uri) throws RemoteException {
        return getBehavior().getType(contentProviderClient, uri);
    }

    public static Uri insert(ContentProviderClient contentProviderClient, Uri uri, ContentValues contentValues) throws RemoteException {
        return getBehavior().insert(contentProviderClient, uri, contentValues);
    }

    public static Uri insert(ContentProviderClient contentProviderClient, Uri uri, ContentValues contentValues, Bundle bundle) throws RemoteException {
        return getBehavior().insert(contentProviderClient, uri, contentValues, bundle);
    }

    public static AssetFileDescriptor openAssetFile(ContentProviderClient contentProviderClient, Uri uri, String str, CancellationSignal cancellationSignal) throws RemoteException, FileNotFoundException {
        return getBehavior().openAssetFile(contentProviderClient, uri, str, cancellationSignal);
    }

    public static AssetFileDescriptor openAssetFile(ContentProviderClient contentProviderClient, Uri uri, String str) throws RemoteException, FileNotFoundException {
        return getBehavior().openAssetFile(contentProviderClient, uri, str);
    }

    public static ParcelFileDescriptor openFile(ContentProviderClient contentProviderClient, Uri uri, String str, CancellationSignal cancellationSignal) throws RemoteException, FileNotFoundException {
        return getBehavior().openFile(contentProviderClient, uri, str, cancellationSignal);
    }

    public static ParcelFileDescriptor openFile(ContentProviderClient contentProviderClient, Uri uri, String str) throws RemoteException, FileNotFoundException {
        return getBehavior().openFile(contentProviderClient, uri, str);
    }

    public static AssetFileDescriptor openTypedAssetFile(ContentProviderClient contentProviderClient, Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws RemoteException, FileNotFoundException {
        return getBehavior().openTypedAssetFile(contentProviderClient, uri, str, bundle, cancellationSignal);
    }

    public static AssetFileDescriptor openTypedAssetFileDescriptor(ContentProviderClient contentProviderClient, Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws RemoteException, FileNotFoundException {
        return getBehavior().openTypedAssetFileDescriptor(contentProviderClient, uri, str, bundle, cancellationSignal);
    }

    public static AssetFileDescriptor openTypedAssetFileDescriptor(ContentProviderClient contentProviderClient, Uri uri, String str, Bundle bundle) throws RemoteException, FileNotFoundException {
        return getBehavior().openTypedAssetFileDescriptor(contentProviderClient, uri, str, bundle);
    }

    public static Cursor query(ContentProviderClient contentProviderClient, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) throws RemoteException {
        return getBehavior().query(contentProviderClient, uri, strArr, bundle, cancellationSignal);
    }

    public static Cursor query(ContentProviderClient contentProviderClient, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) throws RemoteException {
        return getBehavior().query(contentProviderClient, uri, strArr, str, strArr2, str2, cancellationSignal);
    }

    public static Cursor query(ContentProviderClient contentProviderClient, Uri uri, String[] strArr, String str, String[] strArr2, String str2) throws RemoteException {
        return getBehavior().query(contentProviderClient, uri, strArr, str, strArr2, str2);
    }

    public static boolean refresh(ContentProviderClient contentProviderClient, Uri uri, Bundle bundle, CancellationSignal cancellationSignal) throws RemoteException {
        return getBehavior().refresh(contentProviderClient, uri, bundle, cancellationSignal);
    }

    public static int update(ContentProviderClient contentProviderClient, Uri uri, ContentValues contentValues, String str, String[] strArr) throws RemoteException {
        return getBehavior().update(contentProviderClient, uri, contentValues, str, strArr);
    }

    public static int update(ContentProviderClient contentProviderClient, Uri uri, ContentValues contentValues, Bundle bundle) throws RemoteException {
        return getBehavior().update(contentProviderClient, uri, contentValues, bundle);
    }

    private static ContentProviderClientManagementBehavior getBehavior() {
        return sCachedBehavior.get();
    }

    private MAMContentProviderClientManagement() {
    }
}
