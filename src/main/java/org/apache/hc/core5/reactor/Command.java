package org.apache.hc.core5.reactor;

import org.apache.hc.core5.concurrent.Cancellable;

/* JADX INFO: loaded from: classes5.dex */
public interface Command extends Cancellable {

    public enum Priority {
        NORMAL,
        IMMEDIATE
    }
}
