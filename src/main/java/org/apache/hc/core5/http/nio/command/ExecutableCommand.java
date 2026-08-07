package org.apache.hc.core5.http.nio.command;

import org.apache.hc.core5.concurrent.CancellableDependency;
import org.apache.hc.core5.reactor.Command;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ExecutableCommand implements Command {
    public abstract void failed(Exception exc);

    public abstract CancellableDependency getCancellableDependency();
}
