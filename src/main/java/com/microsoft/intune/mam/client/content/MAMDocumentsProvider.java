package com.microsoft.intune.mam.client.content;

import android.content.ContentProvider;
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
import android.provider.DocumentsContract;
import android.provider.DocumentsProvider;
import com.microsoft.intune.mam.client.app.MAMComponents;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MAMDocumentsProvider extends DocumentsProvider implements HookedDocumentsProvider {
    private final DocumentsProviderBehavior mBehavior = (DocumentsProviderBehavior) MAMComponents.get(DocumentsProviderBehavior.class);

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public ContentProvider asContentProvider() {
        return this;
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public final DocumentsProvider asDocumentsProvider() {
        return this;
    }

    @Override // android.provider.DocumentsProvider, android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        this.mBehavior.attachInfo(this, context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public final ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        return this.mBehavior.applyBatch(arrayList);
    }

    @Override // android.content.ContentProvider
    public final ContentProviderResult[] applyBatch(String str, ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        return this.mBehavior.applyBatch(str, arrayList);
    }

    @Override // android.content.ContentProvider
    public final int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        return this.mBehavior.bulkInsert(uri, contentValuesArr);
    }

    @Override // android.provider.DocumentsProvider, android.content.ContentProvider
    public final Bundle call(String str, String str2, Bundle bundle) {
        return this.mBehavior.call(str, str2, bundle);
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String str, String str2, String str3, Bundle bundle) {
        return this.mBehavior.call(str, str2, str3, bundle);
    }

    @Override // android.provider.DocumentsProvider
    public final String createDocument(String str, String str2, String str3) throws FileNotFoundException {
        return this.mBehavior.createDocument(str, str2, str3);
    }

    @Override // android.provider.DocumentsProvider
    public final void deleteDocument(String str) throws FileNotFoundException {
        this.mBehavior.deleteDocument(str);
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, Bundle bundle) {
        return this.mBehavior.delete(uri, bundle);
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues, Bundle bundle) {
        return this.mBehavior.insert(uri, contentValues, bundle);
    }

    @Override // android.provider.DocumentsProvider
    public final ParcelFileDescriptor openDocument(String str, String str2, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mBehavior.openDocument(str, str2, cancellationSignal);
    }

    @Override // android.provider.DocumentsProvider
    public final AssetFileDescriptor openDocumentThumbnail(String str, Point point, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mBehavior.openDocumentThumbnail(str, point, cancellationSignal);
    }

    @Override // android.provider.DocumentsProvider, android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return this.mBehavior.query(uri, strArr, str, strArr2, str2, cancellationSignal);
    }

    @Override // android.provider.DocumentsProvider
    public final Cursor queryChildDocuments(String str, String[] strArr, String str2) throws FileNotFoundException {
        return this.mBehavior.queryChildDocuments(str, strArr, str2);
    }

    @Override // android.provider.DocumentsProvider
    public final Cursor queryChildDocuments(String str, String[] strArr, Bundle bundle) throws FileNotFoundException {
        return this.mBehavior.queryChildDocuments(str, strArr, bundle);
    }

    @Override // android.provider.DocumentsProvider
    public final Cursor queryDocument(String str, String[] strArr) throws FileNotFoundException {
        return this.mBehavior.queryDocument(str, strArr);
    }

    @Override // android.provider.DocumentsProvider
    public final Cursor queryRecentDocuments(String str, String[] strArr) throws FileNotFoundException {
        return this.mBehavior.queryRecentDocuments(str, strArr);
    }

    @Override // android.provider.DocumentsProvider
    public final Cursor queryRoots(String[] strArr) throws FileNotFoundException {
        return this.mBehavior.queryRoots(strArr);
    }

    @Override // android.provider.DocumentsProvider
    public final Cursor querySearchDocuments(String str, String str2, String[] strArr) throws FileNotFoundException {
        return this.mBehavior.querySearchDocuments(str, str2, strArr);
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, Bundle bundle) {
        return this.mBehavior.update(uri, contentValues, bundle);
    }

    @Override // android.provider.DocumentsProvider
    public final void ejectRoot(String str) {
        this.mBehavior.ejectRoot(str);
    }

    @Override // android.provider.DocumentsProvider
    public IntentSender createWebLinkIntent(String str, Bundle bundle) throws FileNotFoundException {
        return this.mBehavior.createWebLinkIntent(str, bundle);
    }

    @Override // android.provider.DocumentsProvider
    public final DocumentsContract.Path findDocumentPath(String str, String str2) throws FileNotFoundException {
        return (DocumentsContract.Path) this.mBehavior.findDocumentPath(str, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final void attachInfoReal(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final ContentProviderResult[] applyBatchReal(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        return super.applyBatch(arrayList);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final ContentProviderResult[] applyBatchReal(String str, ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        return super.applyBatch(str, arrayList);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final int bulkInsertReal(Uri uri, ContentValues[] contentValuesArr) {
        return super.bulkInsert(uri, contentValuesArr);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final Bundle callReal(String str, String str2, Bundle bundle) {
        return super.call(str, str2, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final Bundle callReal(String str, String str2, String str3, Bundle bundle) {
        return super.call(str, str2, str3, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public final String createDocumentReal(String str, String str2, String str3) throws FileNotFoundException {
        return super.createDocument(str, str2, str3);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public final void deleteDocumentReal(String str) throws FileNotFoundException {
        super.deleteDocument(str);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final int deleteReal(Uri uri, Bundle bundle) {
        return super.delete(uri, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final Uri insertReal(Uri uri, ContentValues contentValues, Bundle bundle) {
        return super.insert(uri, contentValues, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final AssetFileDescriptor openAssetFileReal(Uri uri, String str) throws FileNotFoundException {
        return super.openAssetFile(uri, str);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final AssetFileDescriptor openAssetFileReal(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return super.openAssetFile(uri, str, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public final AssetFileDescriptor openDocumentThumbnailReal(String str, Point point, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return super.openDocumentThumbnail(str, point, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final Cursor queryReal(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return super.query(uri, strArr, str, strArr2, str2, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final Cursor queryReal(Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) {
        return super.query(uri, strArr, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public final Cursor queryChildDocumentsReal(String str, String[] strArr, Bundle bundle) throws FileNotFoundException {
        return super.queryChildDocuments(str, strArr, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public final Cursor queryRecentDocumentsReal(String str, String[] strArr) throws FileNotFoundException {
        return super.queryRecentDocuments(str, strArr);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public final Cursor querySearchDocumentsReal(String str, String str2, String[] strArr) throws FileNotFoundException {
        return super.querySearchDocuments(str, str2, strArr);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final ParcelFileDescriptor openFileReal(Uri uri, String str) throws FileNotFoundException {
        return super.openFile(uri, str);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final ParcelFileDescriptor openFileReal(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return super.openFile(uri, str, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final AssetFileDescriptor openTypedAssetFileReal(Uri uri, String str, Bundle bundle) throws FileNotFoundException {
        return super.openTypedAssetFile(uri, str, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final AssetFileDescriptor openTypedAssetFileReal(Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return super.openTypedAssetFile(uri, str, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public final void ejectRootReal(String str) {
        super.ejectRoot(str);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public final IntentSender createWebLinkIntentReal(String str, Bundle bundle) throws FileNotFoundException {
        return super.createWebLinkIntent(str, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public final DocumentsContract.Path findDocumentPathReal(String str, String str2) throws FileNotFoundException {
        return super.findDocumentPath(str, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final int updateReal(Uri uri, ContentValues contentValues, Bundle bundle) {
        return super.update(uri, contentValues, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public void attachInfoMAM(Context context, ProviderInfo providerInfo) {
        this.mBehavior.attachInfoMAM(context, providerInfo);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public ContentProviderResult[] applyBatchMAM(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        return this.mBehavior.applyBatchMAM(arrayList);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public ContentProviderResult[] applyBatchMAM(String str, ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        return this.mBehavior.applyBatchMAM(str, arrayList);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public int bulkInsertMAM(Uri uri, ContentValues[] contentValuesArr) {
        return this.mBehavior.bulkInsertMAM(uri, contentValuesArr);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Bundle callMAM(String str, String str2, Bundle bundle) {
        return this.mBehavior.callMAM(str, str2, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Bundle callMAM(String str, String str2, String str3, Bundle bundle) {
        return this.mBehavior.callMAM(str, str2, str3, bundle);
    }

    public String createDocumentMAM(String str, String str2, String str3) throws FileNotFoundException {
        return this.mBehavior.createDocumentMAM(str, str2, str3);
    }

    public void deleteDocumentMAM(String str) throws FileNotFoundException {
        this.mBehavior.deleteDocumentMAM(str);
    }

    public AssetFileDescriptor openDocumentThumbnailMAM(String str, Point point, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mBehavior.openDocumentThumbnailMAM(str, point, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return this.mBehavior.queryMAM(uri, strArr, str, strArr2, str2, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Cursor queryMAM(Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) {
        return this.mBehavior.queryMAM(uri, strArr, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public Cursor queryChildDocumentsMAM(String str, String[] strArr, Bundle bundle) throws FileNotFoundException {
        return this.mBehavior.queryChildDocumentsMAM(str, strArr, bundle);
    }

    public Cursor queryRecentDocumentsMAM(String str, String[] strArr) throws FileNotFoundException {
        return this.mBehavior.queryRecentDocumentsMAM(str, strArr);
    }

    public Cursor querySearchDocumentsMAM(String str, String str2, String[] strArr) throws FileNotFoundException {
        return this.mBehavior.querySearchDocumentsMAM(str, str2, strArr);
    }

    @Override // android.provider.DocumentsProvider
    public String copyDocument(String str, String str2) throws FileNotFoundException {
        return this.mBehavior.copyDocument(str, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public String copyDocumentMAM(String str, String str2) throws FileNotFoundException {
        return this.mBehavior.copyDocumentMAM(str, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public final String copyDocumentReal(String str, String str2) throws FileNotFoundException {
        return super.copyDocument(str, str2);
    }

    @Override // android.provider.DocumentsProvider
    public AssetFileDescriptor openTypedDocument(String str, String str2, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mBehavior.openTypedDocument(str, str2, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public AssetFileDescriptor openTypedDocumentMAM(String str, String str2, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mBehavior.openTypedDocumentMAM(str, str2, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public final AssetFileDescriptor openTypedDocumentReal(String str, String str2, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return super.openTypedDocument(str, str2, bundle, cancellationSignal);
    }

    @Override // android.provider.DocumentsProvider
    public String moveDocument(String str, String str2, String str3) throws FileNotFoundException {
        return this.mBehavior.moveDocument(str, str2, str3);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public String moveDocumentMAM(String str, String str2, String str3) throws FileNotFoundException {
        return this.mBehavior.moveDocumentMAM(str, str2, str3);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public final String moveDocumentReal(String str, String str2, String str3) throws FileNotFoundException {
        return super.moveDocument(str, str2, str3);
    }

    @Override // android.provider.DocumentsProvider
    public void removeDocument(String str, String str2) throws FileNotFoundException {
        this.mBehavior.removeDocument(str, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public void removeDocumentMAM(String str, String str2) throws FileNotFoundException {
        this.mBehavior.removeDocumentMAM(str, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public final void removeDocumentReal(String str, String str2) throws FileNotFoundException {
        super.removeDocument(str, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final AssetFileDescriptor openAssetFileMAM(Uri uri, String str) throws FileNotFoundException {
        return this.mBehavior.openAssetFileMAM(uri, str);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final AssetFileDescriptor openAssetFileMAM(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mBehavior.openAssetFileMAM(uri, str, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final ParcelFileDescriptor openFileMAM(Uri uri, String str) throws FileNotFoundException {
        return this.mBehavior.openFile(uri, str);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final ParcelFileDescriptor openFileMAM(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mBehavior.openFile(uri, str, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final AssetFileDescriptor openTypedAssetFileMAM(Uri uri, String str, Bundle bundle) throws FileNotFoundException {
        return this.mBehavior.openTypedAssetFile(uri, str, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final AssetFileDescriptor openTypedAssetFileMAM(Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mBehavior.openTypedAssetFile(uri, str, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public int deleteMAM(Uri uri, String str, String[] strArr) {
        return super.delete(uri, str, strArr);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public int deleteMAM(Uri uri, Bundle bundle) {
        return this.mBehavior.deleteMAM(uri, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Uri insertMAM(Uri uri, ContentValues contentValues) {
        return super.insert(uri, contentValues);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Uri insertMAM(Uri uri, ContentValues contentValues, Bundle bundle) {
        return this.mBehavior.insertMAM(uri, contentValues, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return super.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public int updateMAM(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return super.update(uri, contentValues, str, strArr);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public int updateMAM(Uri uri, ContentValues contentValues, Bundle bundle) {
        return this.mBehavior.updateMAM(uri, contentValues, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public void ejectRootMAM(String str) {
        this.mBehavior.ejectRootMAM(str);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public IntentSender createWebLinkIntentMAM(String str, Bundle bundle) throws FileNotFoundException {
        return this.mBehavior.createWebLinkIntentMAM(str, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public DocumentsContract.Path findDocumentPathMAM(String str, String str2) throws FileNotFoundException {
        return (DocumentsContract.Path) this.mBehavior.findDocumentPathMAM(str, str2);
    }
}
