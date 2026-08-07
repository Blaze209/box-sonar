package org.apache.hc.core5.http.message;

import java.io.Serializable;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public final class StatusLine implements Serializable {
    private static final long serialVersionUID = -2443303766890459269L;
    private final ProtocolVersion protoVersion;
    private final String reasonPhrase;
    private final StatusClass statusClass;
    private final int statusCode;

    public StatusLine(HttpResponse httpResponse) {
        Args.notNull(httpResponse, "Response");
        this.protoVersion = httpResponse.getVersion() != null ? httpResponse.getVersion() : HttpVersion.HTTP_1_1;
        int code = httpResponse.getCode();
        this.statusCode = code;
        this.statusClass = StatusClass.from(code);
        this.reasonPhrase = httpResponse.getReasonPhrase();
    }

    public StatusLine(ProtocolVersion protocolVersion, int i, String str) {
        int iNotNegative = Args.notNegative(i, "Status code");
        this.statusCode = iNotNegative;
        this.statusClass = StatusClass.from(iNotNegative);
        this.protoVersion = protocolVersion == null ? HttpVersion.HTTP_1_1 : protocolVersion;
        this.reasonPhrase = str;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public StatusClass getStatusClass() {
        return this.statusClass;
    }

    public boolean isInformational() {
        return getStatusClass() == StatusClass.INFORMATIONAL;
    }

    public boolean isSuccessful() {
        return getStatusClass() == StatusClass.SUCCESSFUL;
    }

    public boolean isRedirection() {
        return getStatusClass() == StatusClass.REDIRECTION;
    }

    public boolean isClientError() {
        return getStatusClass() == StatusClass.CLIENT_ERROR;
    }

    public boolean isServerError() {
        return getStatusClass() == StatusClass.SERVER_ERROR;
    }

    public boolean isError() {
        return isClientError() || isServerError();
    }

    public ProtocolVersion getProtocolVersion() {
        return this.protoVersion;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.protoVersion).append(" ").append(this.statusCode).append(" ");
        String str = this.reasonPhrase;
        if (str != null) {
            sb.append(str);
        }
        return sb.toString();
    }

    public enum StatusClass {
        INFORMATIONAL,
        SUCCESSFUL,
        REDIRECTION,
        CLIENT_ERROR,
        SERVER_ERROR,
        OTHER;

        public static StatusClass from(int i) {
            int i2 = i / 100;
            if (i2 == 1) {
                return INFORMATIONAL;
            }
            if (i2 == 2) {
                return SUCCESSFUL;
            }
            if (i2 == 3) {
                return REDIRECTION;
            }
            if (i2 == 4) {
                return CLIENT_ERROR;
            }
            if (i2 == 5) {
                return SERVER_ERROR;
            }
            return OTHER;
        }
    }
}
