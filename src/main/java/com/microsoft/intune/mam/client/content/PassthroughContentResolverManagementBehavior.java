package com.microsoft.intune.mam.client.content;

import android.content.ContentProviderClient;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Size;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class PassthroughContentResolverManagementBehavior implements ContentResolverManagementBehavior {
    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public ContentProviderResult[] applyBatch(ContentResolver contentResolver, String str, ArrayList<ContentProviderOperation> arrayList) throws RemoteException, OperationApplicationException {
        return contentResolver.applyBatch(str, arrayList);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public int bulkInsert(ContentResolver contentResolver, Uri uri, ContentValues[] contentValuesArr) {
        return contentResolver.bulkInsert(uri, contentValuesArr);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public Bundle call(ContentResolver contentResolver, Uri uri, String str, String str2, Bundle bundle) {
        return contentResolver.call(uri, str, str2, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public Bundle call(ContentResolver contentResolver, String str, String str2, String str3, Bundle bundle) {
        return contentResolver.call(str, str2, str3, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public int delete(ContentResolver contentResolver, Uri uri, String str, String[] strArr) {
        return contentResolver.delete(uri, str, strArr);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public int delete(ContentResolver contentResolver, Uri uri, Bundle bundle) {
        return contentResolver.delete(uri, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public String[] getStreamTypes(ContentResolver contentResolver, Uri uri, String str) {
        return contentResolver.getStreamTypes(uri, str);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public String getType(ContentResolver contentResolver, Uri uri) {
        return contentResolver.getType(uri);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public Bitmap loadThumbnail(ContentResolver contentResolver, Uri uri, Size size, CancellationSignal cancellationSignal) throws IOException {
        return contentResolver.loadThumbnail(uri, size, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        return contentResolver.insert(uri, contentValues);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle) {
        return contentResolver.insert(uri, contentValues, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public AssetFileDescriptor openAssetFile(ContentResolver contentResolver, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return contentResolver.openAssetFile(uri, str, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public AssetFileDescriptor openAssetFileDescriptor(ContentResolver contentResolver, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return contentResolver.openAssetFileDescriptor(uri, str, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public AssetFileDescriptor openAssetFileDescriptor(ContentResolver contentResolver, Uri uri, String str) throws FileNotFoundException {
        return contentResolver.openAssetFileDescriptor(uri, str);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public ParcelFileDescriptor openFile(ContentResolver contentResolver, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return contentResolver.openFile(uri, str, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public ParcelFileDescriptor openFileDescriptor(ContentResolver contentResolver, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return contentResolver.openFileDescriptor(uri, str, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public ParcelFileDescriptor openFileDescriptor(ContentResolver contentResolver, Uri uri, String str) throws FileNotFoundException {
        return contentResolver.openFileDescriptor(uri, str);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public InputStream openInputStream(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
        return contentResolver.openInputStream(uri);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public OutputStream openOutputStream(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
        return contentResolver.openOutputStream(uri);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public OutputStream openOutputStream(ContentResolver contentResolver, Uri uri, String str) throws FileNotFoundException {
        return contentResolver.openOutputStream(uri, str);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public AssetFileDescriptor openTypedAssetFile(ContentResolver contentResolver, Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return contentResolver.openTypedAssetFile(uri, str, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public AssetFileDescriptor openTypedAssetFileDescriptor(ContentResolver contentResolver, Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return contentResolver.openTypedAssetFileDescriptor(uri, str, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public AssetFileDescriptor openTypedAssetFileDescriptor(ContentResolver contentResolver, Uri uri, String str, Bundle bundle) throws FileNotFoundException {
        return contentResolver.openTypedAssetFileDescriptor(uri, str, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) {
        return contentResolver.query(uri, strArr, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return contentResolver.query(uri, strArr, str, strArr2, str2, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return contentResolver.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public boolean refresh(ContentResolver contentResolver, Uri uri, Bundle bundle, CancellationSignal cancellationSignal) {
        return contentResolver.refresh(uri, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return contentResolver.update(uri, contentValues, str, strArr);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle) {
        return contentResolver.update(uri, contentValues, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public ContentProviderClient acquireContentProviderClient(ContentResolver contentResolver, Uri uri) {
        return contentResolver.acquireContentProviderClient(uri);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public ContentProviderClient acquireContentProviderClient(ContentResolver contentResolver, String str) {
        return contentResolver.acquireContentProviderClient(str);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public ContentProviderClient acquireUnstableContentProviderClient(ContentResolver contentResolver, Uri uri) {
        return contentResolver.acquireUnstableContentProviderClient(uri);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior
    public ContentProviderClient acquireUnstableContentProviderClient(ContentResolver contentResolver, String str) {
        return contentResolver.acquireUnstableContentProviderClient(str);
    }
}
