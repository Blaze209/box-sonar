package com.pspdfkit.document.providers;

import com.pspdfkit.internal.uw;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class OutputStreamAdapter extends OutputStream {
    private final WritableDataProvider dataProvider;
    private boolean startedWritingToDataProvider;
    private boolean startedWritingToStrategy;
    private final WritingStrategy writingStrategy;

    public static class Builder {
        private final WritableDataProvider dataProvider;
        private WritingStrategy writingStrategy = new DirectWritingStrategy();

        private Builder(WritableDataProvider writableDataProvider) {
            this.dataProvider = writableDataProvider;
        }

        public static Builder fromDataProvider(WritableDataProvider writableDataProvider) {
            uw.a(writableDataProvider, "dataProvider", null);
            if (writableDataProvider.canWrite()) {
                return new Builder(writableDataProvider);
            }
            throw new IllegalArgumentException("The passed data provider needs to return true for canWrite().");
        }

        public OutputStreamAdapter build() {
            return new OutputStreamAdapter(this.dataProvider, this.writingStrategy);
        }

        public Builder withWritingStrategy(WritingStrategy writingStrategy) {
            uw.a(writingStrategy, "writingStrategy", null);
            this.writingStrategy = writingStrategy;
            return this;
        }
    }

    private OutputStreamAdapter(WritableDataProvider writableDataProvider, WritingStrategy writingStrategy) {
        this.startedWritingToStrategy = false;
        this.startedWritingToDataProvider = false;
        this.dataProvider = writableDataProvider;
        this.writingStrategy = writingStrategy;
    }

    private void checkOperationSucceeded(boolean z) throws IOException {
        if (!z) {
            throw new IOException("Writing was cancelled by the DataProvider.");
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.startedWritingToStrategy) {
            this.writingStrategy.finishWriting();
            this.startedWritingToStrategy = false;
        }
    }

    public void finishWritingToDataProvider() throws IOException {
        if (this.startedWritingToDataProvider) {
            checkOperationSucceeded(this.dataProvider.finishWrite());
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public void writeToDataProvider(byte[] bArr) throws IOException {
        if (!this.dataProvider.canWrite()) {
            throw new IllegalStateException("DataProvider returned false for canWrite().");
        }
        if (!this.startedWritingToDataProvider) {
            checkOperationSucceeded(this.dataProvider.startWrite(WritableDataProvider.WriteMode.REWRITE_FILE));
            this.startedWritingToDataProvider = true;
        }
        checkOperationSucceeded(this.dataProvider.write(bArr));
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        if (!this.startedWritingToStrategy) {
            this.writingStrategy.prepare(this);
            this.startedWritingToStrategy = true;
        }
        this.writingStrategy.write(bArr);
    }
}
