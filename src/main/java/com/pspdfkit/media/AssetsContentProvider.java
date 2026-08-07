package com.pspdfkit.media;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import com.microsoft.intune.mam.client.content.MAMContentProvider;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class AssetsContentProvider extends MAMContentProvider {
    private static final String CONTENT_PROVIDER_AUTHORITY_SUFFIX = ".pdf.assets";

    public static Uri getAuthority(Context context) {
        return new Uri.Builder().scheme("content").authority(context.getPackageName() + CONTENT_PROVIDER_AUTHORITY_SUFFIX).build();
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public int deleteMAM(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Uri insertMAM(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // com.microsoft.intune.mam.client.content.MAMContentProvider, com.microsoft.intune.mam.client.content.HookedContentProvider
    public AssetFileDescriptor openAssetFileMAM(Uri uri, String str) throws FileNotFoundException {
        String path = uri.getPath();
        if (path.startsWith("/")) {
            path = path.substring(1);
        }
        Context context = getContext();
        if (context == null) {
            throw new FileNotFoundException("AssetsContentProvider was not initialized.");
        }
        try {
            return context.getAssets().openFd(path);
        } catch (IOException e) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("Could not open asset at ".concat(path));
            fileNotFoundException.initCause(e);
            throw fileNotFoundException;
        }
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public int updateMAM(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
