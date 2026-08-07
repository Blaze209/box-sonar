package com.microsoft.intune.mam.client.content;

import android.content.ContentProvider;
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
import com.microsoft.intune.mam.client.app.MAMComponents;
import com.microsoft.intune.mam.client.identity.ExternalIdentityUtils;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MAMContentProvider extends ContentProvider implements HookedContentProvider {
    private ContentProviderBehavior mBehavior;
    final ContentProviderBehaviorJellyBean mBehaviorJellyBean;

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final ContentProvider asContentProvider() {
        return this;
    }

    public MAMContentProvider() {
        ContentProviderBehaviorJellyBean contentProviderBehaviorJellyBean = (ContentProviderBehaviorJellyBean) MAMComponents.get(ContentProviderBehaviorJellyBean.class);
        this.mBehaviorJellyBean = contentProviderBehaviorJellyBean;
        ContentProviderBehavior contentProviderBehavior = contentProviderBehaviorJellyBean == null ? (ContentProviderBehavior) MAMComponents.get(ContentProviderBehavior.class) : contentProviderBehaviorJellyBean;
        this.mBehavior = contentProviderBehavior;
        contentProviderBehavior.setContentProvider(this);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        MAMComponents.initialize(context);
        ContentProviderBehavior contentProviderBehavior = (ContentProviderBehavior) MAMComponents.get(ContentProviderBehaviorJellyBean.class);
        this.mBehavior = contentProviderBehavior;
        contentProviderBehavior.setContentProvider(this);
        this.mBehavior.attachInfo(context, providerInfo);
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

    @Override // android.content.ContentProvider
    public final Bundle call(String str, String str2, Bundle bundle) {
        return this.mBehavior.call(str, str2, bundle);
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String str, String str2, String str3, Bundle bundle) {
        return this.mBehavior.call(str, str2, str3, bundle);
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return this.mBehavior.delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, Bundle bundle) {
        return this.mBehavior.delete(uri, bundle);
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        return this.mBehavior.insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues, Bundle bundle) {
        return this.mBehavior.insert(uri, contentValues, bundle);
    }

    @Override // android.content.ContentProvider
    public final AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        return this.mBehavior.openAssetFile(uri, str);
    }

    @Override // android.content.ContentProvider
    public final AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mBehaviorJellyBean.openAssetFile(uri, str, cancellationSignal);
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return this.mBehavior.openFile(uri, str);
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mBehaviorJellyBean.openFile(uri, str, cancellationSignal);
    }

    @Override // android.content.ContentProvider
    public final AssetFileDescriptor openTypedAssetFile(Uri uri, String str, Bundle bundle) throws FileNotFoundException {
        return this.mBehavior.openTypedAssetFile(uri, str, bundle);
    }

    @Override // android.content.ContentProvider
    public final AssetFileDescriptor openTypedAssetFile(Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mBehaviorJellyBean.openTypedAssetFile(uri, str, bundle, cancellationSignal);
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.mBehavior.query(uri, strArr, str, strArr2, str2);
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return this.mBehaviorJellyBean.query(uri, strArr, str, strArr2, str2, cancellationSignal);
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) {
        return this.mBehaviorJellyBean.query(uri, strArr, bundle, cancellationSignal);
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.mBehavior.update(uri, contentValues, str, strArr);
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, Bundle bundle) {
        return this.mBehavior.update(uri, contentValues, bundle);
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

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final Cursor queryReal(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return super.query(uri, strArr, str, strArr2, str2, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final Cursor queryReal(Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) {
        return super.query(uri, strArr, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final int updateReal(Uri uri, ContentValues contentValues, Bundle bundle) {
        return super.update(uri, contentValues, bundle);
    }

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

    public Bundle callMAM(String str, String str2, Bundle bundle) {
        return this.mBehavior.callMAM(str, str2, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Bundle callMAM(String str, String str2, String str3, Bundle bundle) {
        return this.mBehavior.callMAM(str, str2, str3, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public int deleteMAM(Uri uri, Bundle bundle) {
        return this.mBehavior.deleteMAM(uri, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Uri insertMAM(Uri uri, ContentValues contentValues, Bundle bundle) {
        return this.mBehavior.insertMAM(uri, contentValues, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public AssetFileDescriptor openAssetFileMAM(Uri uri, String str) throws FileNotFoundException {
        return this.mBehavior.openAssetFileMAM(uri, str);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public AssetFileDescriptor openAssetFileMAM(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mBehaviorJellyBean.openAssetFileMAM(uri, str, cancellationSignal);
    }

    public ParcelFileDescriptor openFileMAM(Uri uri, String str) throws FileNotFoundException {
        return this.mBehavior.openFileMAM(uri, str);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public ParcelFileDescriptor openFileMAM(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mBehaviorJellyBean.openFileMAM(uri, str, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public AssetFileDescriptor openTypedAssetFileMAM(Uri uri, String str, Bundle bundle) throws FileNotFoundException {
        return this.mBehavior.openTypedAssetFileMAM(uri, str, bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public AssetFileDescriptor openTypedAssetFileMAM(Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mBehaviorJellyBean.openTypedAssetFileMAM(uri, str, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return this.mBehaviorJellyBean.queryMAM(uri, strArr, str, strArr2, str2, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Cursor queryMAM(Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) {
        return this.mBehaviorJellyBean.queryMAM(uri, strArr, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public int updateMAM(Uri uri, ContentValues contentValues, Bundle bundle) {
        return this.mBehavior.updateMAM(uri, contentValues, bundle);
    }

    @Deprecated
    public final boolean isProvideContentAllowed(String str) {
        return this.mBehavior.isProvideContentAllowed(str);
    }

    @Deprecated
    public static boolean isProvideContentAllowed(ContentProvider contentProvider, String str) {
        if (contentProvider instanceof MAMContentProvider) {
            return ((MAMContentProvider) contentProvider).isProvideContentAllowed(str);
        }
        return true;
    }

    public final boolean isProvideContentAllowedForOID(String str) {
        return this.mBehavior.isProvideContentAllowed(ExternalIdentityUtils.identityFromOID(str));
    }

    public static boolean isProvideContentAllowedForOid(ContentProvider contentProvider, String str) {
        if (contentProvider instanceof MAMContentProvider) {
            return ((MAMContentProvider) contentProvider).isProvideContentAllowedForOID(str);
        }
        return true;
    }
}
