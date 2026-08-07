package com.pspdfkit.document.files;

import android.net.Uri;
import com.box.android.common.utilities.BoxCommonConstants;
import com.pspdfkit.document.providers.ContentResolverDataProvider;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.internal.rq;
import com.pspdfkit.internal.uw;

/* JADX INFO: loaded from: classes3.dex */
public class EmbeddedFileSource {
    private final DataProvider fileDataProvider;
    private final String fileDescription;
    private String fileName;
    private long fileSize;

    public EmbeddedFileSource(DataProvider dataProvider, String str, String str2) {
        this.fileName = "";
        this.fileSize = -1L;
        uw.a(dataProvider, "fileDataProvider", null);
        uw.a(str, BoxCommonConstants.EXTRA_FILE_NAME, null);
        this.fileDataProvider = dataProvider;
        this.fileSize = dataProvider.getSize();
        this.fileName = str;
        this.fileDescription = str2;
    }

    public DataProvider getDataProvider() {
        return this.fileDataProvider;
    }

    public String getFileDescription() {
        return this.fileDescription;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public EmbeddedFileSource(Uri uri, String str, String str2) {
        this(new ContentResolverDataProvider(uri), str, str2);
    }

    public EmbeddedFileSource(byte[] bArr, String str, String str2) {
        this(new rq(bArr), str, str2);
    }
}
