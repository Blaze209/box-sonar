package org.apache.hc.core5.http.nio;

import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes5.dex */
public interface FileContentDecoder extends ContentDecoder {
    long transfer(FileChannel fileChannel, long j, long j2) throws IOException;
}
