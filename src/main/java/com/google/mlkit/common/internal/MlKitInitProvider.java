package com.google.mlkit.common.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.microsoft.intune.mam.client.content.MAMContentProvider;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.11.0 */
/* JADX INFO: loaded from: classes14.dex */
public class MlKitInitProvider extends MAMContentProvider {
    @Override // com.microsoft.intune.mam.client.content.MAMContentProvider, com.microsoft.intune.mam.client.content.HookedContentProvider
    public final void attachInfoMAM(Context context, ProviderInfo providerInfo) {
        Preconditions.checkState(!providerInfo.authority.equals("com.google.mlkit.common.mlkitinitprovider"), "Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        super.attachInfoMAM(context, providerInfo);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final int deleteMAM(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return null;
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final Uri insertMAM(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context context = getContext();
        if (context == null) {
            Log.i("MlKitInitProvider", "No context available. Manually call MlKit.initialize(), otherwise ML Kit will not be functional.");
            return false;
        }
        MlKitContext.zza(context);
        return false;
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final int updateMAM(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
