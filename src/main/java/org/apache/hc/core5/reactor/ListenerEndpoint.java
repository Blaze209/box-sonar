package org.apache.hc.core5.reactor;

import java.net.SocketAddress;
import org.apache.hc.core5.io.ModalCloseable;

/* JADX INFO: loaded from: classes5.dex */
public interface ListenerEndpoint extends ModalCloseable {
    SocketAddress getAddress();

    boolean isClosed();
}
