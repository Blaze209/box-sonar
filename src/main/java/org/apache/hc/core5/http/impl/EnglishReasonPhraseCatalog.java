package org.apache.hc.core5.http.impl;

import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Locale;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ReasonPhraseCatalog;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class EnglishReasonPhraseCatalog implements ReasonPhraseCatalog {
    public static final EnglishReasonPhraseCatalog INSTANCE = new EnglishReasonPhraseCatalog();
    private static final String[][] REASON_PHRASES = {null, new String[4], new String[27], new String[9], new String[52], new String[12]};

    static {
        setReason(200, SemanticAttributes.OtelStatusCodeValues.OK);
        setReason(201, "Created");
        setReason(202, "Accepted");
        setReason(204, "No Content");
        setReason(301, "Moved Permanently");
        setReason(302, "Moved Temporarily");
        setReason(304, "Not Modified");
        setReason(400, "Bad Request");
        setReason(401, "Unauthorized");
        setReason(403, "Forbidden");
        setReason(404, "Not Found");
        setReason(500, "Internal Server Error");
        setReason(501, "Not Implemented");
        setReason(502, "Bad Gateway");
        setReason(503, "Service Unavailable");
        setReason(100, "Continue");
        setReason(307, "Temporary Redirect");
        setReason(405, "Method Not Allowed");
        setReason(409, "Conflict");
        setReason(412, "Precondition Failed");
        setReason(413, "Request Too Long");
        setReason(414, "Request-URI Too Long");
        setReason(415, "Unsupported Media Type");
        setReason(300, "Multiple Choices");
        setReason(303, "See Other");
        setReason(305, "Use Proxy");
        setReason(402, "Payment Required");
        setReason(406, "Not Acceptable");
        setReason(407, "Proxy Authentication Required");
        setReason(408, "Request Timeout");
        setReason(101, "Switching Protocols");
        setReason(203, "Non Authoritative Information");
        setReason(205, "Reset Content");
        setReason(206, "Partial Content");
        setReason(504, "Gateway Timeout");
        setReason(505, "Http Version Not Supported");
        setReason(410, "Gone");
        setReason(411, "Length Required");
        setReason(416, "Requested Range Not Satisfiable");
        setReason(417, "Expectation Failed");
        setReason(421, "Misdirected Request");
        setReason(102, "Processing");
        setReason(207, "Multi-Status");
        setReason(208, "Already Reported");
        setReason(226, "IM Used");
        setReason(422, "Unprocessable Content");
        setReason(419, "Insufficient Space On Resource");
        setReason(420, "Method Failure");
        setReason(423, "Locked");
        setReason(507, "Insufficient Storage");
        setReason(508, "Loop Detected");
        setReason(510, "Not Extended");
        setReason(424, "Failed Dependency");
        setReason(425, "Too Early");
        setReason(HttpStatus.SC_UPGRADE_REQUIRED, "Upgrade Required");
        setReason(HttpStatus.SC_PRECONDITION_REQUIRED, "Precondition Required");
        setReason(429, "Too Many Requests");
        setReason(HttpStatus.SC_REQUEST_HEADER_FIELDS_TOO_LARGE, "Request Header Fields Too Large");
        setReason(511, "Network Authentication Required");
        setReason(103, "Early Hints");
        setReason(308, "Permanent Redirect");
        setReason(HttpStatus.SC_UNAVAILABLE_FOR_LEGAL_REASONS, "Unavailable For Legal Reasons");
        setReason(506, "Variant Also Negotiates");
    }

    protected EnglishReasonPhraseCatalog() {
    }

    @Override // org.apache.hc.core5.http.ReasonPhraseCatalog
    public String getReason(int i, Locale locale) {
        Args.checkRange(i, 100, 599, "Unknown category for status code");
        int i2 = i / 100;
        int i3 = i - (i2 * 100);
        String[] strArr = REASON_PHRASES[i2];
        if (strArr.length > i3) {
            return strArr[i3];
        }
        return null;
    }

    private static void setReason(int i, String str) {
        int i2 = i / 100;
        REASON_PHRASES[i2][i - (i2 * 100)] = str;
    }
}
