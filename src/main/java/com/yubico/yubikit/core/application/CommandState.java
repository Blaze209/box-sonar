package com.yubico.yubikit.core.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes3.dex */
public class CommandState {
    public static final byte STATUS_PROCESSING = 1;
    public static final byte STATUS_UPNEEDED = 2;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) CommandState.class);
    private boolean cancelled = false;

    public void onKeepAliveStatus(byte b) {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "received keepalive status: {}", Byte.valueOf(b));
    }

    public final synchronized void cancel() {
        this.cancelled = true;
    }

    public final synchronized boolean waitForCancel(long j) {
        if (!this.cancelled && j > 0) {
            try {
                wait(j);
            } catch (InterruptedException unused) {
                com.yubico.yubikit.core.internal.Logger.debug(logger, "Thread interrupted, cancelling command");
                this.cancelled = true;
                Thread.currentThread().interrupt();
            }
        }
        return this.cancelled;
    }
}
