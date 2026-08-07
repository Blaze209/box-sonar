package com.microsoft.intune.mam.client.app.offline;

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
import com.microsoft.intune.mam.client.MAMInfo;
import com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean;
import com.microsoft.intune.mam.client.content.HookedContentProvider;
import com.microsoft.intune.mam.client.identity.IdentityParamConverter;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
class OfflineContentProviderBehavior implements ContentProviderBehaviorJellyBean {
    HookedContentProvider mContentProvider;
    private final IdentityParamConverter mIdentityParamConverter;

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public boolean isProvideContentAllowed(MAMIdentity mAMIdentity) {
        return true;
    }

    OfflineContentProviderBehavior(IdentityParamConverter identityParamConverter) {
        this.mIdentityParamConverter = identityParamConverter;
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public void setContentProvider(HookedContentProvider hookedContentProvider) {
        this.mContentProvider = hookedContentProvider;
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        this.mContentProvider.attachInfoMAM(context, providerInfo);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        checkBlocked();
        return this.mContentProvider.applyBatchMAM(arrayList);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public ContentProviderResult[] applyBatch(String str, ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        checkBlocked();
        return this.mContentProvider.applyBatchMAM(str, arrayList);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        checkBlocked();
        return this.mContentProvider.bulkInsertMAM(uri, contentValuesArr);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public Bundle call(String str, String str2, Bundle bundle) {
        checkBlocked();
        return this.mContentProvider.callMAM(str, str2, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public Bundle call(String str, String str2, String str3, Bundle bundle) {
        checkBlocked();
        return this.mContentProvider.callMAM(str, str2, str3, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public int delete(Uri uri, String str, String[] strArr) {
        checkBlocked();
        return this.mContentProvider.deleteMAM(uri, str, strArr);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public int delete(Uri uri, Bundle bundle) {
        checkBlocked();
        return this.mContentProvider.deleteMAM(uri, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public Uri insert(Uri uri, ContentValues contentValues) {
        checkBlocked();
        return this.mContentProvider.insertMAM(uri, contentValues);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public Uri insert(Uri uri, ContentValues contentValues, Bundle bundle) {
        checkBlocked();
        return this.mContentProvider.insertMAM(uri, contentValues, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        checkBlocked();
        return this.mContentProvider.openAssetFileMAM(uri, str);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        checkBlocked();
        return this.mContentProvider.openAssetFileMAM(uri, str, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        checkBlocked();
        return this.mContentProvider.openFileMAM(uri, str);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    public ParcelFileDescriptor openFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        checkBlocked();
        return this.mContentProvider.openFileMAM(uri, str, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public AssetFileDescriptor openTypedAssetFile(Uri uri, String str, Bundle bundle) throws FileNotFoundException {
        checkBlocked();
        return this.mContentProvider.openTypedAssetFileMAM(uri, str, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    public AssetFileDescriptor openTypedAssetFile(Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        checkBlocked();
        return this.mContentProvider.openTypedAssetFileMAM(uri, str, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        checkBlocked();
        return this.mContentProvider.queryMAM(uri, strArr, str, strArr2, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public Cursor query(Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) {
        checkBlocked();
        return this.mContentProvider.queryMAM(uri, strArr, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        checkBlocked();
        return this.mContentProvider.queryMAM(uri, strArr, str, strArr2, str2, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        checkBlocked();
        return this.mContentProvider.updateMAM(uri, contentValues, str, strArr);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public int update(Uri uri, ContentValues contentValues, Bundle bundle) {
        checkBlocked();
        return this.mContentProvider.updateMAM(uri, contentValues, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public void attachInfoMAM(Context context, ProviderInfo providerInfo) {
        this.mContentProvider.attachInfoReal(context, providerInfo);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public ContentProviderResult[] applyBatchMAM(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        return this.mContentProvider.applyBatchReal(arrayList);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public ContentProviderResult[] applyBatchMAM(String str, ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        return this.mContentProvider.applyBatchReal(str, arrayList);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public int bulkInsertMAM(Uri uri, ContentValues[] contentValuesArr) {
        return this.mContentProvider.bulkInsertReal(uri, contentValuesArr);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public Bundle callMAM(String str, String str2, Bundle bundle) {
        return this.mContentProvider.callReal(str, str2, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public Bundle callMAM(String str, String str2, String str3, Bundle bundle) {
        return this.mContentProvider.callReal(str, str2, str3, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public int deleteMAM(Uri uri, Bundle bundle) {
        return this.mContentProvider.deleteReal(uri, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public Uri insertMAM(Uri uri, ContentValues contentValues, Bundle bundle) {
        return this.mContentProvider.insertReal(uri, contentValues, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public AssetFileDescriptor openAssetFileMAM(Uri uri, String str) throws FileNotFoundException {
        return this.mContentProvider.openAssetFileReal(uri, str);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    public AssetFileDescriptor openAssetFileMAM(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mContentProvider.openAssetFileReal(uri, str, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public ParcelFileDescriptor openFileMAM(Uri uri, String str) throws FileNotFoundException {
        return this.mContentProvider.openFileReal(uri, str);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    public ParcelFileDescriptor openFileMAM(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mContentProvider.openFileReal(uri, str, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public AssetFileDescriptor openTypedAssetFileMAM(Uri uri, String str, Bundle bundle) throws FileNotFoundException {
        return this.mContentProvider.openTypedAssetFileReal(uri, str, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    public AssetFileDescriptor openTypedAssetFileMAM(Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mContentProvider.openTypedAssetFileReal(uri, str, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    public Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return this.mContentProvider.queryReal(uri, strArr, str, strArr2, str2, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    public Cursor queryMAM(Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) {
        return this.mContentProvider.queryReal(uri, strArr, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public int updateMAM(Uri uri, ContentValues contentValues, Bundle bundle) {
        return this.mContentProvider.updateReal(uri, contentValues, bundle);
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
