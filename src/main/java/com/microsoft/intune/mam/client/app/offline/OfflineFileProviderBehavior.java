package com.microsoft.intune.mam.client.app.offline;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import com.microsoft.intune.mam.client.content.FileProviderBehaviorJellyBean;
import com.microsoft.intune.mam.client.content.HookedFileProvider;
import com.microsoft.intune.mam.client.identity.IdentityParamConverter;

/* JADX INFO: loaded from: classes3.dex */
final class OfflineFileProviderBehavior extends OfflineContentProviderBehavior implements FileProviderBehaviorJellyBean {
    HookedFileProvider mFileProvider;

    OfflineFileProviderBehavior(IdentityParamConverter identityParamConverter) {
        super(identityParamConverter);
    }

    @Override // com.microsoft.intune.mam.client.content.FileProviderBehavior
    public void setFileProvider(HookedFileProvider hookedFileProvider) {
        this.mFileProvider = hookedFileProvider;
        super.setContentProvider(hookedFileProvider);
    }

    @Override // com.microsoft.intune.mam.client.app.offline.OfflineContentProviderBehavior, com.microsoft.intune.mam.client.content.ContentProviderBehavior
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        this.mFileProvider.attachInfoReal(context, providerInfo);
        super.attachInfo(context, providerInfo);
    }

    @Override // com.microsoft.intune.mam.client.app.offline.OfflineContentProviderBehavior, com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean
    public Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return this.mFileProvider.queryReal(uri, strArr, str, strArr2, str2, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.FileProviderBehavior
    public int deleteMAM(Uri uri, String str, String[] strArr) {
        return this.mFileProvider.deleteReal(uri, str, strArr);
    }

    @Override // com.microsoft.intune.mam.client.content.FileProviderBehavior
    public Uri insertMAM(Uri uri, ContentValues contentValues) {
        return this.mFileProvider.insertReal(uri, contentValues);
    }

    @Override // com.microsoft.intune.mam.client.content.FileProviderBehavior
    public Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.mFileProvider.queryReal(uri, strArr, str, strArr2, str2);
    }

    @Override // com.microsoft.intune.mam.client.content.FileProviderBehavior
    public int updateMAM(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.mFileProvider.updateReal(uri, contentValues, str, strArr);
    }
}
