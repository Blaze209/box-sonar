package org.tinylog.writers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;
import org.tinylog.core.LogEntry;
import org.tinylog.writers.raw.ByteArrayWriter;

/* JADX INFO: loaded from: classes5.dex */
public final class FileWriter extends AbstractFormatPatternWriter {
    private final Charset charset;
    private final ByteArrayWriter writer;

    public FileWriter() throws IOException {
        this(Collections.emptyMap());
    }

    public FileWriter(Map<String, String> map) throws IOException {
        super(map);
        String fileName = getFileName();
        boolean booleanValue = getBooleanValue("append");
        boolean booleanValue2 = getBooleanValue("buffered");
        boolean booleanValue3 = getBooleanValue("writingthread");
        Charset charset = getCharset();
        this.charset = charset;
        this.writer = createByteArrayWriter(fileName, booleanValue, booleanValue2, !booleanValue3, false, charset);
    }

    @Override // org.tinylog.writers.Writer
    public void write(LogEntry logEntry) throws IOException {
        byte[] bytes = render(logEntry).getBytes(this.charset);
        this.writer.write(bytes, 0, bytes.length);
    }

    @Override // org.tinylog.writers.Writer
    public void flush() throws IOException {
        this.writer.flush();
    }

    @Override // org.tinylog.writers.Writer
    public void close() throws IOException {
        this.writer.close();
    }
}
