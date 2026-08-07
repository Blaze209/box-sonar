package com.pspdfkit.document.files;

import com.pspdfkit.annotations.FileAnnotation;
import io.reactivex.rxjava3.core.Completable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public interface EmbeddedFile {
    FileAnnotation getAnnotation();

    byte[] getFileData() throws IOException;

    String getFileDescription();

    String getFileName();

    long getFileSize();

    String getId();

    Date getModificationDate();

    void writeToStream(OutputStream outputStream) throws IOException;

    Completable writeToStreamAsync(OutputStream outputStream);
}
