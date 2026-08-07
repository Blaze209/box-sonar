package com.pspdfkit.document.download;

import android.content.Context;
import android.net.Uri;
import com.pspdfkit.document.download.source.AssetDownloadSource;
import com.pspdfkit.document.download.source.ContentResolverDownloadSource;
import com.pspdfkit.document.download.source.DownloadSource;
import com.pspdfkit.document.download.source.URLDownloadSource;
import com.pspdfkit.internal.uw;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class DownloadRequest {
    public final File outputFile;
    public final boolean overwriteExisting;
    public final DownloadSource source;
    final boolean useTemporaryOutputFile;

    private DownloadRequest(DownloadSource downloadSource, File file, boolean z, boolean z2) {
        uw.a(downloadSource, "source", null);
        uw.a(file, "outputFile", null);
        this.source = downloadSource;
        this.outputFile = file;
        this.overwriteExisting = z;
        this.useTemporaryOutputFile = z2;
    }

    public String toString() {
        return "DownloadRequest{source=" + this.source + ", outputFile=" + this.outputFile + ", overwriteExisting=" + this.overwriteExisting + ", useTemporaryOutputFile=" + this.useTemporaryOutputFile + AbstractJsonLexerKt.END_OBJ;
    }

    public static final class Builder {
        private final Context appContext;
        private File outputFile;
        private DownloadSource source;
        private boolean overwriteExisting = false;
        private boolean useTemporaryOutputFile = true;

        public Builder(Context context) {
            this.appContext = context.getApplicationContext();
        }

        public DownloadRequest build() {
            if (this.source == null) {
                throw new IllegalStateException("Can't create DownloadRequest: source is missing.");
            }
            if (this.outputFile == null) {
                outputFolder(this.appContext.getFilesDir());
            }
            return new DownloadRequest(this.source, this.outputFile, this.overwriteExisting, this.useTemporaryOutputFile);
        }

        public Builder outputFile(File file) {
            uw.a(file, "outputFile", null);
            this.outputFile = file;
            return this;
        }

        public Builder outputFolder(File file) {
            this.outputFile = new File(file, System.currentTimeMillis() + ".pdf");
            return this;
        }

        public Builder overwriteExisting(boolean z) {
            this.overwriteExisting = z;
            return this;
        }

        public Builder source(DownloadSource downloadSource) {
            uw.a(downloadSource, "source", null);
            this.source = downloadSource;
            return this;
        }

        public Builder uri(Uri uri) {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                this.source = new ContentResolverDownloadSource(this.appContext, uri);
                return this;
            }
            if (uri.toString().startsWith("file://android_asset/")) {
                this.source = new AssetDownloadSource(this.appContext, uri.getPath().substring(1));
                return this;
            }
            if (!"http".equalsIgnoreCase(uri.getScheme()) && !"https".equalsIgnoreCase(uri.getScheme())) {
                throw new IllegalArgumentException("The provided Uri is not supported: " + uri.toString() + "\nPlease consult Javadoc for the supported Uri schemes and types.");
            }
            try {
                this.source = new URLDownloadSource(new URL(uri.toString()));
                return this;
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException("The provided URL was malformed: " + uri.toString(), e);
            }
        }

        public Builder useTemporaryOutputFile(boolean z) {
            this.useTemporaryOutputFile = z;
            return this;
        }

        public Builder uri(String str) {
            uri(Uri.parse(str));
            return this;
        }
    }
}
