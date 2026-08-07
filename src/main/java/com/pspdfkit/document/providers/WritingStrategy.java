package com.pspdfkit.document.providers;

import java.io.IOException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/pspdfkit/document/providers/WritingStrategy;", "", "prepare", "", "adapter", "Lcom/pspdfkit/document/providers/OutputStreamAdapter;", "write", "data", "", "finishWriting", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface WritingStrategy {
    void finishWriting() throws IOException;

    void prepare(OutputStreamAdapter adapter);

    void write(byte[] data) throws IOException;
}
