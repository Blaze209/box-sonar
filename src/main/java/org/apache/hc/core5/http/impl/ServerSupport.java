package org.apache.hc.core5.http.impl;

import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.MethodNotSupportedException;
import org.apache.hc.core5.http.MisdirectedRequestException;
import org.apache.hc.core5.http.NotImplementedException;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.http.RequestHeaderFieldsTooLargeException;
import org.apache.hc.core5.http.UnsupportedHttpVersionException;

/* JADX INFO: loaded from: classes5.dex */
public class ServerSupport {
    public static String toErrorMessage(Exception exc) {
        String message = exc.getMessage();
        return message != null ? message : exc.toString();
    }

    public static int toStatusCode(Exception exc) {
        if (exc instanceof MethodNotSupportedException) {
            return 501;
        }
        if (exc instanceof UnsupportedHttpVersionException) {
            return 505;
        }
        if (exc instanceof NotImplementedException) {
            return 501;
        }
        if (exc instanceof RequestHeaderFieldsTooLargeException) {
            return HttpStatus.SC_REQUEST_HEADER_FIELDS_TOO_LARGE;
        }
        if (exc instanceof MisdirectedRequestException) {
            return 421;
        }
        return exc instanceof ProtocolException ? 400 : 500;
    }
}
