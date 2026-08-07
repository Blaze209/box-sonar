package org.apache.hc.core5.http.nio.command;

import org.apache.hc.core5.http.RequestNotExecutedException;
import org.apache.hc.core5.reactor.Command;
import org.apache.hc.core5.reactor.IOSession;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public final class CommandSupport {
    public static void failCommands(IOSession iOSession, Exception exc) {
        Args.notNull(iOSession, "I/O session");
        while (true) {
            Command commandPoll = iOSession.poll();
            if (commandPoll == null) {
                return;
            }
            if (commandPoll instanceof ExecutableCommand) {
                ((ExecutableCommand) commandPoll).failed(exc);
            } else {
                commandPoll.cancel();
            }
        }
    }

    public static void cancelCommands(IOSession iOSession) {
        Args.notNull(iOSession, "I/O session");
        while (true) {
            Command commandPoll = iOSession.poll();
            if (commandPoll == null) {
                return;
            }
            if (commandPoll instanceof ExecutableCommand) {
                if (!iOSession.isOpen()) {
                    ((ExecutableCommand) commandPoll).failed(new RequestNotExecutedException());
                } else {
                    commandPoll.cancel();
                }
            } else {
                commandPoll.cancel();
            }
        }
    }
}
