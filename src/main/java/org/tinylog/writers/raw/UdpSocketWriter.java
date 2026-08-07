package org.tinylog.writers.raw;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Map;
import org.tinylog.core.LogEntry;

/* JADX INFO: loaded from: classes5.dex */
public class UdpSocketWriter extends AbstractSocketWriter {
    private DatagramSocket datagramSocket;

    @Override // org.tinylog.writers.Writer
    public void flush() throws Exception {
    }

    public UdpSocketWriter(Map<String, String> map) throws IOException {
        super(map);
        this.datagramSocket = new DatagramSocket();
    }

    @Override // org.tinylog.writers.Writer
    public void write(LogEntry logEntry) throws IOException {
        byte[] message = formatMessage(logEntry);
        this.datagramSocket.send(new DatagramPacket(message, message.length, getInetAddress(), getPort()));
    }

    @Override // org.tinylog.writers.Writer
    public void close() throws Exception {
        this.datagramSocket.close();
    }
}
