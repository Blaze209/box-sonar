package com.microsoft.intune.mam.client.app.offline;

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
import com.microsoft.intune.mam.client.MAMInfo;
import com.microsoft.intune.mam.client.content.DocumentsProviderBehavior;
import com.microsoft.intune.mam.client.content.HookedContentProvider;
import com.microsoft.intune.mam.client.content.HookedDocumentsProvider;
import com.microsoft.intune.mam.client.identity.IdentityParamConverter;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
final class OfflineDocumentsProviderBehavior implements DocumentsProviderBehavior {
    HookedDocumentsProvider mDocumentsProvider;
    private final IdentityParamConverter mIdentityParamConverter;

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public boolean isProvideContentAllowed(MAMIdentity mAMIdentity) {
        return true;
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public void setContentProvider(HookedContentProvider hookedContentProvider) {
    }

    OfflineDocumentsProviderBehavior(IdentityParamConverter identityParamConverter) {
        this.mIdentityParamConverter = identityParamConverter;
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public void attachInfo(HookedDocumentsProvider hookedDocumentsProvider, Context context, ProviderInfo providerInfo) {
        this.mDocumentsProvider = hookedDocumentsProvider;
        hookedDocumentsProvider.attachInfoMAM(context, providerInfo);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior, com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        checkBlocked();
        return this.mDocumentsProvider.applyBatchMAM(arrayList);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior, com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public ContentProviderResult[] applyBatch(String str, ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        checkBlocked();
        return this.mDocumentsProvider.applyBatchMAM(str, arrayList);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior, com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        checkBlocked();
        return this.mDocumentsProvider.bulkInsertMAM(uri, contentValuesArr);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior, com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public Bundle call(String str, String str2, Bundle bundle) {
        checkBlocked();
        return this.mDocumentsProvider.callMAM(str, str2, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior, com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public Bundle call(String str, String str2, String str3, Bundle bundle) {
        checkBlocked();
        return this.mDocumentsProvider.callMAM(str, str2, str3, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior, com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        checkBlocked();
        return this.mDocumentsProvider.queryMAM(uri, strArr, str, strArr2, str2, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        this.mDocumentsProvider.attachInfoMAM(context, providerInfo);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public int delete(Uri uri, String str, String[] strArr) {
        return this.mDocumentsProvider.deleteMAM(uri, str, strArr);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public int delete(Uri uri, Bundle bundle) {
        return this.mDocumentsProvider.deleteMAM(uri, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.mDocumentsProvider.insertMAM(uri, contentValues);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public Uri insert(Uri uri, ContentValues contentValues, Bundle bundle) {
        return this.mDocumentsProvider.insertMAM(uri, contentValues, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        return this.mDocumentsProvider.openAssetFileMAM(uri, str);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return this.mDocumentsProvider.openFileMAM(uri, str);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public AssetFileDescriptor openTypedAssetFile(Uri uri, String str, Bundle bundle) throws FileNotFoundException {
        return this.mDocumentsProvider.openTypedAssetFileMAM(uri, str, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.mDocumentsProvider.queryMAM(uri, strArr, str, strArr2, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public Cursor query(Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) {
        return this.mDocumentsProvider.queryMAM(uri, strArr, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.mDocumentsProvider.updateMAM(uri, contentValues, str, strArr);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public int update(Uri uri, ContentValues contentValues, Bundle bundle) {
        return this.mDocumentsProvider.updateMAM(uri, contentValues, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior, com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public ContentProviderResult[] applyBatchMAM(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        return this.mDocumentsProvider.applyBatchReal(arrayList);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior, com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public ContentProviderResult[] applyBatchMAM(String str, ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        return this.mDocumentsProvider.applyBatchReal(str, arrayList);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior, com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public void attachInfoMAM(Context context, ProviderInfo providerInfo) {
        this.mDocumentsProvider.attachInfoReal(context, providerInfo);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior, com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public int bulkInsertMAM(Uri uri, ContentValues[] contentValuesArr) {
        return this.mDocumentsProvider.bulkInsertReal(uri, contentValuesArr);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior, com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public Bundle callMAM(String str, String str2, Bundle bundle) {
        return this.mDocumentsProvider.callReal(str, str2, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior, com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public Bundle callMAM(String str, String str2, String str3, Bundle bundle) {
        return this.mDocumentsProvider.callReal(str, str2, str3, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public int deleteMAM(Uri uri, Bundle bundle) {
        return this.mDocumentsProvider.deleteReal(uri, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public Uri insertMAM(Uri uri, ContentValues contentValues, Bundle bundle) {
        return this.mDocumentsProvider.insertReal(uri, contentValues, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior, com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public AssetFileDescriptor openAssetFileMAM(Uri uri, String str) throws FileNotFoundException {
        return this.mDocumentsProvider.openAssetFileReal(uri, str);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior, com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    public AssetFileDescriptor openAssetFileMAM(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mDocumentsProvider.openAssetFileReal(uri, str, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior, com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    public Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return this.mDocumentsProvider.queryReal(uri, strArr, str, strArr2, str2, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public Cursor queryChildDocumentsMAM(String str, String[] strArr, Bundle bundle) throws FileNotFoundException {
        return this.mDocumentsProvider.queryChildDocumentsReal(str, strArr, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    public Cursor queryMAM(Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) {
        return this.mDocumentsProvider.queryReal(uri, strArr, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public int updateMAM(Uri uri, ContentValues contentValues, Bundle bundle) {
        return this.mDocumentsProvider.updateReal(uri, contentValues, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public String createDocument(String str, String str2, String str3) throws FileNotFoundException {
        checkBlocked();
        return this.mDocumentsProvider.createDocumentMAM(str, str2, str3);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public void deleteDocument(String str) throws FileNotFoundException {
        checkBlocked();
        this.mDocumentsProvider.deleteDocumentMAM(str);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public ParcelFileDescriptor openDocument(String str, String str2, CancellationSignal cancellationSignal) throws FileNotFoundException {
        checkBlocked();
        return this.mDocumentsProvider.openDocumentMAM(str, str2, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public AssetFileDescriptor openDocumentThumbnail(String str, Point point, CancellationSignal cancellationSignal) throws FileNotFoundException {
        checkBlocked();
        return this.mDocumentsProvider.openDocumentThumbnailMAM(str, point, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public Cursor queryChildDocuments(String str, String[] strArr, String str2) throws FileNotFoundException {
        checkBlocked();
        return this.mDocumentsProvider.queryChildDocumentsMAM(str, strArr, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public Cursor queryChildDocuments(String str, String[] strArr, Bundle bundle) throws FileNotFoundException {
        checkBlocked();
        return this.mDocumentsProvider.queryChildDocumentsMAM(str, strArr, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public Cursor queryDocument(String str, String[] strArr) throws FileNotFoundException {
        checkBlocked();
        return this.mDocumentsProvider.queryDocumentMAM(str, strArr);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public Cursor queryRecentDocuments(String str, String[] strArr) throws FileNotFoundException {
        checkBlocked();
        return this.mDocumentsProvider.queryRecentDocumentsMAM(str, strArr);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public Cursor queryRoots(String[] strArr) throws FileNotFoundException {
        checkBlocked();
        return this.mDocumentsProvider.queryRootsMAM(strArr);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public Cursor querySearchDocuments(String str, String str2, String[] strArr) throws FileNotFoundException {
        checkBlocked();
        return this.mDocumentsProvider.querySearchDocumentsMAM(str, str2, strArr);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mDocumentsProvider.openAssetFileMAM(uri, str, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    public ParcelFileDescriptor openFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mDocumentsProvider.openFileMAM(uri, str, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    public AssetFileDescriptor openTypedAssetFile(Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mDocumentsProvider.openTypedAssetFileMAM(uri, str, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public String createDocumentMAM(String str, String str2, String str3) throws FileNotFoundException {
        return this.mDocumentsProvider.createDocumentReal(str, str2, str3);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public void deleteDocumentMAM(String str) throws FileNotFoundException {
        this.mDocumentsProvider.deleteDocumentReal(str);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public AssetFileDescriptor openDocumentThumbnailMAM(String str, Point point, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mDocumentsProvider.openDocumentThumbnailReal(str, point, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public Cursor queryRecentDocumentsMAM(String str, String[] strArr) throws FileNotFoundException {
        return this.mDocumentsProvider.queryRecentDocumentsReal(str, strArr);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public Cursor querySearchDocumentsMAM(String str, String str2, String[] strArr) throws FileNotFoundException {
        return this.mDocumentsProvider.querySearchDocumentsReal(str, str2, strArr);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    public ParcelFileDescriptor openFileMAM(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mDocumentsProvider.openFileReal(uri, str, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    public AssetFileDescriptor openTypedAssetFileMAM(Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mDocumentsProvider.openTypedAssetFileReal(uri, str, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public ParcelFileDescriptor openFileMAM(Uri uri, String str) throws FileNotFoundException {
        return this.mDocumentsProvider.openFileReal(uri, str);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public AssetFileDescriptor openTypedAssetFileMAM(Uri uri, String str, Bundle bundle) throws FileNotFoundException {
        return this.mDocumentsProvider.openTypedAssetFileReal(uri, str, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public AssetFileDescriptor openTypedDocument(String str, String str2, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mDocumentsProvider.openTypedDocumentMAM(str, str2, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public AssetFileDescriptor openTypedDocumentMAM(String str, String str2, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mDocumentsProvider.openTypedDocumentReal(str, str2, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public void removeDocument(String str, String str2) throws FileNotFoundException {
        this.mDocumentsProvider.removeDocumentMAM(str, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public void ejectRoot(String str) {
        checkBlocked();
        this.mDocumentsProvider.ejectRootMAM(str);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public IntentSender createWebLinkIntent(String str, Bundle bundle) throws FileNotFoundException {
        checkBlocked();
        return this.mDocumentsProvider.createWebLinkIntentMAM(str, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public Object findDocumentPath(String str, String str2) throws FileNotFoundException {
        checkBlocked();
        return this.mDocumentsProvider.findDocumentPathMAM(str, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public void ejectRootMAM(String str) {
        this.mDocumentsProvider.ejectRootReal(str);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public IntentSender createWebLinkIntentMAM(String str, Bundle bundle) throws FileNotFoundException {
        return this.mDocumentsProvider.createWebLinkIntentReal(str, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public Object findDocumentPathMAM(String str, String str2) throws FileNotFoundException {
        return this.mDocumentsProvider.findDocumentPathReal(str, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public void removeDocumentMAM(String str, String str2) throws FileNotFoundException {
        this.mDocumentsProvider.removeDocumentReal(str, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public String copyDocument(String str, String str2) throws FileNotFoundException {
        return this.mDocumentsProvider.copyDocumentMAM(str, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public String copyDocumentMAM(String str, String str2) throws FileNotFoundException {
        return this.mDocumentsProvider.copyDocumentReal(str, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public String moveDocument(String str, String str2, String str3) throws FileNotFoundException {
        return this.mDocumentsProvider.moveDocumentMAM(str, str2, str3);
    }

    @Override // com.microsoft.intune.mam.client.content.DocumentsProviderBehavior
    public String moveDocumentMAM(String str, String str2, String str3) throws FileNotFoundException {
        return this.mDocumentsProvider.moveDocumentReal(str, str2, str3);
    }

    private void checkBlocked() {
        if (MAMInfo.isPolicyRequired()) {
            throw new SecurityException();
        }
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    @Deprecated
    public boolean isProvideContentAllowed(String str) {
        return isProvideContentAllowed(this.mIdentityParamConverter.fromUpnParam(str));
    }
}
