package org.tinylog.writers.raw;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;
import org.tinylog.core.LogEntry;

/* JADX INFO: loaded from: classes5.dex */
public class TcpSocketWriter extends AbstractSocketWriter {
    private Socket socket;

    public TcpSocketWriter(Map<String, String> map) throws IOException {
        super(map);
        this.socket = new Socket(getInetAddress(), getPort());
    }

    @Override // org.tinylog.writers.Writer
    public void write(LogEntry logEntry) throws IOException {
        this.socket.getOutputStream().write(formatMessage(logEntry));
    }

    @Override // org.tinylog.writers.Writer
    public void flush() throws Exception {
        this.socket.getOutputStream().flush();
    }

    @Override // org.tinylog.writers.Writer
    public void close() throws Exception {
        this.socket.close();
    }
}
