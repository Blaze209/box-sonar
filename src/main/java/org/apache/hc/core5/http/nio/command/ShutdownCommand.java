package org.apache.hc.core5.http.nio.command;

import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.reactor.Command;
import org.apache.hc.core5.reactor.IOSession;

/* JADX INFO: loaded from: classes5.dex */
public final class ShutdownCommand implements Command {
    private final CloseMode type;
    public static final ShutdownCommand GRACEFUL = new ShutdownCommand(CloseMode.GRACEFUL);
    public static final ShutdownCommand IMMEDIATE = new ShutdownCommand(CloseMode.IMMEDIATE);
    public static final Callback<IOSession> GRACEFUL_IMMEDIATE_CALLBACK = createIOSessionCallback(Command.Priority.IMMEDIATE);
    public static final Callback<IOSession> GRACEFUL_NORMAL_CALLBACK = createIOSessionCallback(Command.Priority.NORMAL);

    @Override // org.apache.hc.core5.concurrent.Cancellable
    public boolean cancel() {
        return true;
    }

    private static Callback<IOSession> createIOSessionCallback(final Command.Priority priority) {
        return new Callback() { // from class: org.apache.hc.core5.http.nio.command.ShutdownCommand$$ExternalSyntheticLambda0
            @Override // org.apache.hc.core5.function.Callback
            public final void execute(Object obj) {
                ((IOSession) obj).enqueue(ShutdownCommand.GRACEFUL, priority);
            }
        };
    }

    public ShutdownCommand(CloseMode closeMode) {
        this.type = closeMode;
    }

    public CloseMode getType() {
        return this.type;
    }

    public String toString() {
        return "Shutdown: " + this.type;
    }
}
