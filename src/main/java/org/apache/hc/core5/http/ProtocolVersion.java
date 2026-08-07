package org.apache.hc.core5.http;

import java.io.Serializable;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Tokenizer;

/* JADX INFO: loaded from: classes5.dex */
public class ProtocolVersion implements Serializable {
    private static final long serialVersionUID = 8950662842175091068L;
    private final int major;
    private final int minor;
    private final String protocol;

    public ProtocolVersion(String str, int i, int i2) {
        this.protocol = (String) Args.notNull(str, "Protocol name");
        this.major = Args.notNegative(i, "Protocol minor version");
        this.minor = Args.notNegative(i2, "Protocol minor version");
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int hashCode() {
        return this.minor ^ (this.protocol.hashCode() ^ (this.major * 100000));
    }

    public final boolean equals(int i, int i2) {
        return this.major == i && this.minor == i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProtocolVersion)) {
            return false;
        }
        ProtocolVersion protocolVersion = (ProtocolVersion) obj;
        return this.protocol.equals(protocolVersion.protocol) && this.major == protocolVersion.major && this.minor == protocolVersion.minor;
    }

    public String format() {
        return this.protocol + '/' + this.major + '.' + this.minor;
    }

    public boolean isComparable(ProtocolVersion protocolVersion) {
        return protocolVersion != null && this.protocol.equals(protocolVersion.protocol);
    }

    public int compareToVersion(ProtocolVersion protocolVersion) {
        Args.notNull(protocolVersion, "Protocol version");
        Args.check(this.protocol.equals(protocolVersion.protocol), "Versions for different protocols cannot be compared: %s %s", this, protocolVersion);
        int major = getMajor() - protocolVersion.getMajor();
        return major == 0 ? getMinor() - protocolVersion.getMinor() : major;
    }

    public final boolean greaterEquals(ProtocolVersion protocolVersion) {
        return isComparable(protocolVersion) && compareToVersion(protocolVersion) >= 0;
    }

    public final boolean lessEquals(ProtocolVersion protocolVersion) {
        return isComparable(protocolVersion) && compareToVersion(protocolVersion) <= 0;
    }

    public static ProtocolVersion parse(CharSequence charSequence, Tokenizer.Cursor cursor, Tokenizer.Delimiter delimiter) throws ParseException {
        return ProtocolVersionParser.INSTANCE.parse(charSequence, cursor, delimiter);
    }

    public static ProtocolVersion parse(String str) throws ParseException {
        if (str == null) {
            return null;
        }
        Tokenizer.Cursor cursor = new Tokenizer.Cursor(0, str.length());
        ProtocolVersion protocolVersion = ProtocolVersionParser.INSTANCE.parse(str, cursor, (Tokenizer.Delimiter) null);
        Tokenizer.INSTANCE.skipWhiteSpace(str, cursor);
        if (cursor.atEnd()) {
            return protocolVersion;
        }
        throw new ParseException("Invalid protocol version; trailing content");
    }

    public String toString() {
        return format();
    }
}
