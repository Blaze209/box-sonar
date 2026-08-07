package com.pspdfkit.document.providers;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/pspdfkit/document/providers/TempFileWritingStrategy;", "Lcom/pspdfkit/document/providers/WritingStrategy;", "tempFile", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapter", "Lcom/pspdfkit/document/providers/OutputStreamAdapter;", "fileOutputStream", "Ljava/io/FileOutputStream;", "prepare", "", "write", "data", "", "finishWriting", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TempFileWritingStrategy implements WritingStrategy {
    private static final int BUFFER_SIZE = 4096;
    private OutputStreamAdapter adapter;
    private FileOutputStream fileOutputStream;
    private final File tempFile;
    public static final int $stable = 8;

    public TempFileWritingStrategy(File file) {
        file.getClass();
        this.tempFile = file;
    }

    @Override // com.pspdfkit.document.providers.WritingStrategy
    public void finishWriting() throws IOException {
        if (this.adapter == null) {
            throw new IllegalStateException("finishWriting() was called before prepare().");
        }
        FileOutputStream fileOutputStream = this.fileOutputStream;
        if (fileOutputStream == null) {
            throw new IllegalStateException("finishWriting() was called before write().");
        }
        if (fileOutputStream != null) {
            fileOutputStream.flush();
        }
        FileOutputStream fileOutputStream2 = this.fileOutputStream;
        if (fileOutputStream2 != null) {
            fileOutputStream2.close();
        }
        FileInputStream fileInputStream = new FileInputStream(this.tempFile);
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                OutputStreamAdapter outputStreamAdapter = this.adapter;
                if (i == 4096) {
                    if (outputStreamAdapter != null) {
                        outputStreamAdapter.writeToDataProvider(bArr);
                    }
                } else if (outputStreamAdapter != null) {
                    outputStreamAdapter.writeToDataProvider(Arrays.copyOf(bArr, i));
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileInputStream, null);
            OutputStreamAdapter outputStreamAdapter2 = this.adapter;
            if (outputStreamAdapter2 != null) {
                outputStreamAdapter2.finishWritingToDataProvider();
            }
            if (!this.tempFile.delete()) {
                throw new IOException("Couldn't delete temporary file.");
            }
            this.adapter = null;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileInputStream, th);
                throw th2;
            }
        }
    }

    @Override // com.pspdfkit.document.providers.WritingStrategy
    public void prepare(OutputStreamAdapter adapter) {
        adapter.getClass();
        if (this.adapter != null) {
            throw new IllegalStateException("prepare() was called twice.");
        }
        this.adapter = adapter;
    }

    @Override // com.pspdfkit.document.providers.WritingStrategy
    public void write(byte[] data) throws IOException {
        data.getClass();
        if (this.fileOutputStream == null) {
            this.fileOutputStream = new FileOutputStream(this.tempFile);
        }
        FileOutputStream fileOutputStream = this.fileOutputStream;
        if (fileOutputStream != null) {
            fileOutputStream.write(data);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TempFileWritingStrategy(Context context) throws IOException {
        context.getClass();
        File fileCreateTempFile = File.createTempFile("TFWS", null, context.getCacheDir());
        fileCreateTempFile.getClass();
        this(fileCreateTempFile);
    }
}
