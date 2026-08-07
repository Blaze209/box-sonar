package org.tinylog.writers.raw;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Map;
import org.tinylog.Level;
import org.tinylog.core.LogEntry;
import org.tinylog.writers.AbstractFormatPatternWriter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractSocketWriter extends AbstractFormatPatternWriter {
    private static final String DEFAULT_FACILITY = "USER";
    private static final String DEFAULT_HOST_NAME = "localhost";
    private static final int DEFAULT_PORT_NUMBER = 514;
    private static final String DEFAULT_SEVERITY = "INFORMATIONAL";
    private static final int FACILITY_CODE_SHIFT = 3;
    private final Charset charset;
    private final String identification;
    private final InetAddress inetAddress;
    private final int port;

    public AbstractSocketWriter(Map<String, String> map) throws UnknownHostException {
        super(map);
        getStringValue("host");
        this.inetAddress = InetAddress.getByName("localhost");
        String stringValue = getStringValue("port");
        if (stringValue == null) {
            this.port = DEFAULT_PORT_NUMBER;
        } else {
            this.port = Integer.parseInt(stringValue);
        }
        this.charset = super.getCharset();
        String stringValue2 = getStringValue("identification");
        if (stringValue2 == null) {
            this.identification = "";
        } else {
            this.identification = stringValue2;
        }
    }

    public final InetAddress getInetAddress() {
        return this.inetAddress;
    }

    public final int getPort() {
        return this.port;
    }

    public int getCode(Level level) {
        String stringValue = getStringValue("facility");
        String stringValue2 = getStringValue("severity");
        if (stringValue == null) {
            stringValue = DEFAULT_FACILITY;
        }
        int code = SyslogFacility.valueOf(stringValue).getCode();
        if (stringValue2 == null) {
            if (level != null) {
                stringValue2 = SyslogSeverity.getSeverity(level).name();
            } else {
                stringValue2 = DEFAULT_SEVERITY;
            }
        }
        return (code << 3) + SyslogSeverity.valueOf(stringValue2).getCode();
    }

    public byte[] formatMessage(LogEntry logEntry) {
        return (SimpleComparison.LESS_THAN_OPERATION + getCode(logEntry.getLevel()) + SimpleComparison.GREATER_THAN_OPERATION + this.identification + ": " + render(logEntry)).getBytes(this.charset);
    }
}
