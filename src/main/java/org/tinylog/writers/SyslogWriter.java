package org.tinylog.writers;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import org.tinylog.core.LogEntry;
import org.tinylog.writers.raw.AbstractSocketWriter;
import org.tinylog.writers.raw.TcpSocketWriter;
import org.tinylog.writers.raw.UdpSocketWriter;

/* JADX INFO: loaded from: classes5.dex */
public final class SyslogWriter extends AbstractFormatPatternWriter {
    private final AbstractSocketWriter socketWriter;

    public SyslogWriter(Map<String, String> map) throws IOException, IllegalArgumentException {
        super(map);
        String stringValue = getStringValue("protocol");
        if (stringValue == null || stringValue.toUpperCase(Locale.ROOT).equals("UDP")) {
            this.socketWriter = new UdpSocketWriter(map);
        } else {
            if (stringValue.toUpperCase(Locale.ROOT).equals("TCP")) {
                this.socketWriter = new TcpSocketWriter(map);
                return;
            }
            throw new IllegalArgumentException("Invalid protocol");
        }
    }

    @Override // org.tinylog.writers.Writer
    public void write(LogEntry logEntry) throws Exception {
        this.socketWriter.write(logEntry);
    }

    @Override // org.tinylog.writers.Writer
    public void flush() throws Exception {
        this.socketWriter.flush();
    }

    @Override // org.tinylog.writers.Writer
    public void close() throws Exception {
        this.socketWriter.close();
    }
}
