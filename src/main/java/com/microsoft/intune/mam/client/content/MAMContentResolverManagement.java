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
import com.microsoft.intune.mam.client.CachedBehaviorProvider;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMContentResolverManagement {
    private static CachedBehaviorProvider<ContentResolverManagementBehavior> sCachedBehavior = new CachedBehaviorProvider<>(ContentResolverManagementBehavior.class);

    public static ContentProviderClient acquireContentProviderClient(ContentResolver contentResolver, Uri uri) {
        return getBehavior().acquireContentProviderClient(contentResolver, uri);
    }

    public static ContentProviderClient acquireContentProviderClient(ContentResolver contentResolver, String str) {
        return getBehavior().acquireContentProviderClient(contentResolver, str);
    }

    public static ContentProviderClient acquireUnstableContentProviderClient(ContentResolver contentResolver, Uri uri) {
        return getBehavior().acquireUnstableContentProviderClient(contentResolver, uri);
    }

    public static ContentProviderClient acquireUnstableContentProviderClient(ContentResolver contentResolver, String str) {
        return getBehavior().acquireUnstableContentProviderClient(contentResolver, str);
    }

    public static ContentProviderResult[] applyBatch(ContentResolver contentResolver, String str, ArrayList<ContentProviderOperation> arrayList) throws RemoteException, OperationApplicationException {
        return getBehavior().applyBatch(contentResolver, str, arrayList);
    }

    public static int bulkInsert(ContentResolver contentResolver, Uri uri, ContentValues[] contentValuesArr) {
        return getBehavior().bulkInsert(contentResolver, uri, contentValuesArr);
    }

    public static Bundle call(ContentResolver contentResolver, Uri uri, String str, String str2, Bundle bundle) {
        return getBehavior().call(contentResolver, uri, str, str2, bundle);
    }

    public static Bundle call(ContentResolver contentResolver, String str, String str2, String str3, Bundle bundle) {
        return getBehavior().call(contentResolver, str, str2, str3, bundle);
    }

    public static int delete(ContentResolver contentResolver, Uri uri, String str, String[] strArr) {
        return getBehavior().delete(contentResolver, uri, str, strArr);
    }

    public static int delete(ContentResolver contentResolver, Uri uri, Bundle bundle) {
        return getBehavior().delete(contentResolver, uri, bundle);
    }

    public static String[] getStreamTypes(ContentResolver contentResolver, Uri uri, String str) {
        return getBehavior().getStreamTypes(contentResolver, uri, str);
    }

    public static String getType(ContentResolver contentResolver, Uri uri) {
        return getBehavior().getType(contentResolver, uri);
    }

    public static Bitmap loadThumbnail(ContentResolver contentResolver, Uri uri, Size size, CancellationSignal cancellationSignal) throws IOException {
        return getBehavior().loadThumbnail(contentResolver, uri, size, cancellationSignal);
    }

    public static Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        return getBehavior().insert(contentResolver, uri, contentValues);
    }

    public static Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle) {
        return getBehavior().insert(contentResolver, uri, contentValues, bundle);
    }

    public static AssetFileDescriptor openAssetFile(ContentResolver contentResolver, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return getBehavior().openAssetFile(contentResolver, uri, str, cancellationSignal);
    }

    public static AssetFileDescriptor openAssetFileDescriptor(ContentResolver contentResolver, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return getBehavior().openAssetFileDescriptor(contentResolver, uri, str, cancellationSignal);
    }

    public static AssetFileDescriptor openAssetFileDescriptor(ContentResolver contentResolver, Uri uri, String str) throws FileNotFoundException {
        return getBehavior().openAssetFileDescriptor(contentResolver, uri, str);
    }

    public static ParcelFileDescriptor openFile(ContentResolver contentResolver, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return getBehavior().openFile(contentResolver, uri, str, cancellationSignal);
    }

    public static ParcelFileDescriptor openFileDescriptor(ContentResolver contentResolver, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return getBehavior().openFileDescriptor(contentResolver, uri, str, cancellationSignal);
    }

    public static ParcelFileDescriptor openFileDescriptor(ContentResolver contentResolver, Uri uri, String str) throws FileNotFoundException {
        return getBehavior().openFileDescriptor(contentResolver, uri, str);
    }

    public static InputStream openInputStream(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
        return getBehavior().openInputStream(contentResolver, uri);
    }

    public static OutputStream openOutputStream(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
        return getBehavior().openOutputStream(contentResolver, uri);
    }

    public static OutputStream openOutputStream(ContentResolver contentResolver, Uri uri, String str) throws FileNotFoundException {
        return getBehavior().openOutputStream(contentResolver, uri, str);
    }

    public static AssetFileDescriptor openTypedAssetFile(ContentResolver contentResolver, Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return getBehavior().openTypedAssetFile(contentResolver, uri, str, bundle, cancellationSignal);
    }

    public static AssetFileDescriptor openTypedAssetFileDescriptor(ContentResolver contentResolver, Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return getBehavior().openTypedAssetFileDescriptor(contentResolver, uri, str, bundle, cancellationSignal);
    }

    public static AssetFileDescriptor openTypedAssetFileDescriptor(ContentResolver contentResolver, Uri uri, String str, Bundle bundle) throws FileNotFoundException {
        return getBehavior().openTypedAssetFileDescriptor(contentResolver, uri, str, bundle);
    }

    public static Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) {
        return getBehavior().query(contentResolver, uri, strArr, bundle, cancellationSignal);
    }

    public static Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return getBehavior().query(contentResolver, uri, strArr, str, strArr2, str2, cancellationSignal);
    }

    public static Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return getBehavior().query(contentResolver, uri, strArr, str, strArr2, str2);
    }

    public static boolean refresh(ContentResolver contentResolver, Uri uri, Bundle bundle, CancellationSignal cancellationSignal) {
        return getBehavior().refresh(contentResolver, uri, bundle, cancellationSignal);
    }

    public static int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return getBehavior().update(contentResolver, uri, contentValues, str, strArr);
    }

    public static int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle) {
        return getBehavior().update(contentResolver, uri, contentValues, bundle);
    }

    private static ContentResolverManagementBehavior getBehavior() {
        return sCachedBehavior.get();
    }

    private MAMContentResolverManagement() {
    }
}
