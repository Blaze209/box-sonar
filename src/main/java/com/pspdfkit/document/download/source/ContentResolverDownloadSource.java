package com.pspdfkit.document.download.source;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import com.pspdfkit.utils.PdfLog;
import java.io.IOException;
import java.io.InputStream;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ContentResolverDownloadSource implements DownloadSource {
    private static final String LOG_TAG = "Nutri.ConResDownloadSrc";
    private final Context applicationContext;
    private final Uri uri;

    public ContentResolverDownloadSource(Context context, Uri uri) {
        if (!"content".equalsIgnoreCase(uri.getScheme())) {
            throw new IllegalArgumentException("This class can't handle Uris that don't use the content:// scheme.");
        }
        this.applicationContext = context.getApplicationContext();
        this.uri = uri;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    @Override // com.pspdfkit.document.download.source.DownloadSource
    public long getLength() {
        long statSize;
        Cursor cursorQuery;
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = MAMContentResolverManagement.openFileDescriptor(this.applicationContext.getContentResolver(), this.uri, "r");
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                statSize = parcelFileDescriptorOpenFileDescriptor.getStatSize();
                parcelFileDescriptorOpenFileDescriptor.close();
                if (statSize == -1) {
                    statSize = -1;
                }
            } else {
                statSize = -1;
            }
        } catch (IOException unused) {
            PdfLog.i(LOG_TAG, "File descriptor could not be successfully accessed. Retrying through content provider.", new Object[0]);
        }
        if (statSize == -1 && (cursorQuery = MAMContentResolverManagement.query(this.applicationContext.getContentResolver(), this.uri, new String[]{"_size"}, null, null, null)) != null) {
            if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                statSize = cursorQuery.getLong(0);
            }
            cursorQuery.close();
        }
        return statSize;
    }

    public Uri getUri() {
        return this.uri;
    }

    @Override // com.pspdfkit.document.download.source.DownloadSource
    public InputStream open() throws IOException {
        return MAMContentResolverManagement.openInputStream(this.applicationContext.getContentResolver(), this.uri);
    }

    public String toString() {
        return "ContentResolverDownloadSource{uri=" + this.uri + AbstractJsonLexerKt.END_OBJ;
    }
}
