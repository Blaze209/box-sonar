package com.pspdfkit.document.download.source;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.pspdfkit.internal.uw;
import com.pspdfkit.utils.PdfLog;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class AssetDownloadSource implements DownloadSource {
    private static final String LOG_TAG = "Nutri.AssetDownloadSrc";
    private final Context applicationContext;
    private final String assetPath;

    public AssetDownloadSource(Context context, String str) {
        uw.a(context, "context", null);
        uw.a(str, "assetPath", null);
        this.applicationContext = context.getApplicationContext();
        this.assetPath = str;
    }

    public String getAssetPath() {
        return this.assetPath;
    }

    @Override // com.pspdfkit.document.download.source.DownloadSource
    public long getLength() {
        try {
            return ((AssetManager.AssetInputStream) this.applicationContext.getAssets().open(this.assetPath)).available();
        } catch (Exception unused) {
            PdfLog.i(LOG_TAG, "Failed to get the AssetInputStream and ignored the exception. Returning UNKNOWN_DOWNLOAD_SIZE instead.", new Object[0]);
            return -1L;
        }
    }

    @Override // com.pspdfkit.document.download.source.DownloadSource
    public InputStream open() throws IOException {
        return this.applicationContext.getAssets().open(this.assetPath);
    }

    public String toString() {
        return "AssetDownloadSource: " + new Uri.Builder().scheme("file").authority("android_asset").path(this.assetPath).toString();
    }
}
