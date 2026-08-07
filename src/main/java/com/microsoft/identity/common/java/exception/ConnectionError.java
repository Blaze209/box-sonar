package com.microsoft.identity.common.java.exception;

import java.io.EOFException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConnectionError.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/microsoft/identity/common/java/exception/ConnectionError;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "compare", "", "throwable", "", "NO_NETWORK", "NETWORK_TEMPORARILY_UNAVAILABLE", "UNEXPECTED_EXCEPTION", "CONNECTION_TIMEOUT", "Companion", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum ConnectionError {
    NO_NETWORK("ce_no_network"),
    NETWORK_TEMPORARILY_UNAVAILABLE("ce_network_temporarily_unavailable"),
    UNEXPECTED_EXCEPTION("ce_unexpected_exception"),
    CONNECTION_TIMEOUT("ce_connection_timeout");


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String value;

    @JvmStatic
    public static final ClientException getClientException(Throwable th) {
        return INSTANCE.getClientException(th);
    }

    ConnectionError(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final boolean compare(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        if (throwable instanceof ClientException) {
            return Intrinsics.areEqual(this.value, ((ClientException) throwable).getSubErrorCode());
        }
        return false;
    }

    /* JADX INFO: compiled from: ConnectionError.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\t"}, d2 = {"Lcom/microsoft/identity/common/java/exception/ConnectionError$Companion;", "", "()V", "getClientException", "Lcom/microsoft/identity/common/java/exception/ClientException;", "cause", "", "getConnectionError", "Lcom/microsoft/identity/common/java/exception/ConnectionError;", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ClientException getClientException(Throwable cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            ClientException clientException = new ClientException("io_error", "An IO error occurred in the network layer: " + cause.getMessage(), cause);
            clientException.setSubErrorCode(getConnectionError(cause).getValue());
            return clientException;
        }

        private final ConnectionError getConnectionError(Throwable cause) {
            if (cause instanceof SocketTimeoutException) {
                return ConnectionError.CONNECTION_TIMEOUT;
            }
            if ((cause instanceof EOFException) || (cause instanceof SSLException) || (cause instanceof ConnectException)) {
                return ConnectionError.NETWORK_TEMPORARILY_UNAVAILABLE;
            }
            if ((cause instanceof UnknownHostException) || (cause instanceof SocketException)) {
                return ConnectionError.NO_NETWORK;
            }
            return ConnectionError.UNEXPECTED_EXCEPTION;
        }
    }
}
