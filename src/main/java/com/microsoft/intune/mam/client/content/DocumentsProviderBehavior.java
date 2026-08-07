package com.microsoft.intune.mam.client.content;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentSender;
import android.content.OperationApplicationException;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public interface DocumentsProviderBehavior extends ContentProviderBehaviorJellyBean {
    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    ContentProviderResult[] applyBatch(String str, ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException;

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException;

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    ContentProviderResult[] applyBatchMAM(String str, ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException;

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    ContentProviderResult[] applyBatchMAM(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException;

    void attachInfo(HookedDocumentsProvider hookedDocumentsProvider, Context context, ProviderInfo providerInfo);

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    void attachInfoMAM(Context context, ProviderInfo providerInfo);

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    int bulkInsert(Uri uri, ContentValues[] contentValuesArr);

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    int bulkInsertMAM(Uri uri, ContentValues[] contentValuesArr);

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    Bundle call(String str, String str2, Bundle bundle);

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    Bundle call(String str, String str2, String str3, Bundle bundle);

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    Bundle callMAM(String str, String str2, Bundle bundle);

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    Bundle callMAM(String str, String str2, String str3, Bundle bundle);

    String copyDocument(String str, String str2) throws FileNotFoundException;

    String copyDocumentMAM(String str, String str2) throws FileNotFoundException;

    String createDocument(String str, String str2, String str3) throws FileNotFoundException;

    String createDocumentMAM(String str, String str2, String str3) throws FileNotFoundException;

    IntentSender createWebLinkIntent(String str, Bundle bundle) throws FileNotFoundException;

    IntentSender createWebLinkIntentMAM(String str, Bundle bundle) throws FileNotFoundException;

    void deleteDocument(String str) throws FileNotFoundException;

    void deleteDocumentMAM(String str) throws FileNotFoundException;

    void ejectRoot(String str);

    void ejectRootMAM(String str);

    Object findDocumentPath(String str, String str2) throws FileNotFoundException;

    Object findDocumentPathMAM(String str, String str2) throws FileNotFoundException;

    String moveDocument(String str, String str2, String str3) throws FileNotFoundException;

    String moveDocumentMAM(String str, String str2, String str3) throws FileNotFoundException;

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    AssetFileDescriptor openAssetFileMAM(Uri uri, String str) throws FileNotFoundException;

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    AssetFileDescriptor openAssetFileMAM(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException;

    ParcelFileDescriptor openDocument(String str, String str2, CancellationSignal cancellationSignal) throws FileNotFoundException;

    AssetFileDescriptor openDocumentThumbnail(String str, Point point, CancellationSignal cancellationSignal) throws FileNotFoundException;

    AssetFileDescriptor openDocumentThumbnailMAM(String str, Point point, CancellationSignal cancellationSignal) throws FileNotFoundException;

    AssetFileDescriptor openTypedDocument(String str, String str2, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException;

    AssetFileDescriptor openTypedDocumentMAM(String str, String str2, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException;

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

    Cursor queryChildDocuments(String str, String[] strArr, Bundle bundle) throws FileNotFoundException;

    Cursor queryChildDocuments(String str, String[] strArr, String str2) throws FileNotFoundException;

    Cursor queryChildDocumentsMAM(String str, String[] strArr, Bundle bundle) throws FileNotFoundException;

    Cursor queryDocument(String str, String[] strArr) throws FileNotFoundException;

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

    Cursor queryRecentDocuments(String str, String[] strArr) throws FileNotFoundException;

    Cursor queryRecentDocumentsMAM(String str, String[] strArr) throws FileNotFoundException;

    Cursor queryRoots(String[] strArr) throws FileNotFoundException;

    Cursor querySearchDocuments(String str, String str2, String[] strArr) throws FileNotFoundException;

    Cursor querySearchDocumentsMAM(String str, String str2, String[] strArr) throws FileNotFoundException;

    void removeDocument(String str, String str2) throws FileNotFoundException;

    void removeDocumentMAM(String str, String str2) throws FileNotFoundException;
}
