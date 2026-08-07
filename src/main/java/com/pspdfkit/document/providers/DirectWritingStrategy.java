package com.pspdfkit.document.providers;

import java.io.IOException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/pspdfkit/document/providers/DirectWritingStrategy;", "Lcom/pspdfkit/document/providers/WritingStrategy;", "<init>", "()V", "adapter", "Lcom/pspdfkit/document/providers/OutputStreamAdapter;", "prepare", "", "write", "data", "", "finishWriting", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DirectWritingStrategy implements WritingStrategy {
    public static final int $stable = 8;
    private OutputStreamAdapter adapter;

    @Override // com.pspdfkit.document.providers.WritingStrategy
    public void finishWriting() throws IOException {
        OutputStreamAdapter outputStreamAdapter = this.adapter;
        if (outputStreamAdapter == null) {
            throw new IllegalStateException("finishWriting() was called before prepare().");
        }
        if (outputStreamAdapter != null) {
            outputStreamAdapter.finishWritingToDataProvider();
        }
        this.adapter = null;
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
        OutputStreamAdapter outputStreamAdapter = this.adapter;
        if (outputStreamAdapter == null) {
            throw new IllegalStateException("write() was called before prepare().");
        }
        if (outputStreamAdapter != null) {
            outputStreamAdapter.writeToDataProvider(data);
        }
    }
}
