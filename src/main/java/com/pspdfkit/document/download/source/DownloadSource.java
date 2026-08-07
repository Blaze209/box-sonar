package com.pspdfkit.document.download.source;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface DownloadSource {
    public static final long UNKNOWN_DOWNLOAD_SIZE = -1;

    long getLength();

    InputStream open() throws IOException;
}
