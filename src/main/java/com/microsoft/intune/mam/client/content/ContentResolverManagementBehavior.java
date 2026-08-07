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
public interface ContentResolverManagementBehavior {
    ContentProviderClient acquireContentProviderClient(ContentResolver contentResolver, Uri uri);

    ContentProviderClient acquireContentProviderClient(ContentResolver contentResolver, String str);

    ContentProviderClient acquireUnstableContentProviderClient(ContentResolver contentResolver, Uri uri);

    ContentProviderClient acquireUnstableContentProviderClient(ContentResolver contentResolver, String str);

    ContentProviderResult[] applyBatch(ContentResolver contentResolver, String str, ArrayList<ContentProviderOperation> arrayList) throws RemoteException, OperationApplicationException;

    int bulkInsert(ContentResolver contentResolver, Uri uri, ContentValues[] contentValuesArr);

    Bundle call(ContentResolver contentResolver, Uri uri, String str, String str2, Bundle bundle);

    Bundle call(ContentResolver contentResolver, String str, String str2, String str3, Bundle bundle);

    int delete(ContentResolver contentResolver, Uri uri, Bundle bundle);

    int delete(ContentResolver contentResolver, Uri uri, String str, String[] strArr);

    String[] getStreamTypes(ContentResolver contentResolver, Uri uri, String str);

    String getType(ContentResolver contentResolver, Uri uri);

    Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues);

    Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle);

    Bitmap loadThumbnail(ContentResolver contentResolver, Uri uri, Size size, CancellationSignal cancellationSignal) throws IOException;

    AssetFileDescriptor openAssetFile(ContentResolver contentResolver, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException;

    AssetFileDescriptor openAssetFileDescriptor(ContentResolver contentResolver, Uri uri, String str) throws FileNotFoundException;

    AssetFileDescriptor openAssetFileDescriptor(ContentResolver contentResolver, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException;

    ParcelFileDescriptor openFile(ContentResolver contentResolver, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException;

    ParcelFileDescriptor openFileDescriptor(ContentResolver contentResolver, Uri uri, String str) throws FileNotFoundException;

    ParcelFileDescriptor openFileDescriptor(ContentResolver contentResolver, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException;

    InputStream openInputStream(ContentResolver contentResolver, Uri uri) throws FileNotFoundException;

    OutputStream openOutputStream(ContentResolver contentResolver, Uri uri) throws FileNotFoundException;

    OutputStream openOutputStream(ContentResolver contentResolver, Uri uri, String str) throws FileNotFoundException;

    AssetFileDescriptor openTypedAssetFile(ContentResolver contentResolver, Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException;

    AssetFileDescriptor openTypedAssetFileDescriptor(ContentResolver contentResolver, Uri uri, String str, Bundle bundle) throws FileNotFoundException;

    AssetFileDescriptor openTypedAssetFileDescriptor(ContentResolver contentResolver, Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException;

    Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal);

    Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

    boolean refresh(ContentResolver contentResolver, Uri uri, Bundle bundle, CancellationSignal cancellationSignal);

    int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle);

    int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr);
}
