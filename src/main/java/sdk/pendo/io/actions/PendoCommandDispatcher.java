package sdk.pendo.io.actions;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import sdk.pendo.io.actions.handlers.PendoGlobalCommandHandler;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.k3.o;
import sdk.pendo.io.n3.a;
import sdk.pendo.io.q3.e;
import sdk.pendo.io.t6.d;

/* JADX INFO: loaded from: classes4.dex */
public final class PendoCommandDispatcher {
    private static volatile PendoCommandDispatcher INSTANCE = null;
    public static final String PENDO_COMMAND_ANALYTICS_SOURCE = "analyticsSource";
    private static final Object mLock = new Object();
    private static final HashSet<String> sOncePerSessionCommands = new HashSet<>();

    public static final class PredefinedCommands {
        public static final String SOURCE_ID_BACK_BUTTON = "backButton";
        public static final PendoCommand BACK_PRESSED = new PendoCommand.Builder(PendoCommandAction.PendoCommandGlobalAction.DISMISS_GUIDE, PendoCommandEventType.UserEventType.TAP_ON).setCommandId("onBackPressed-command-id").setSourceId(SOURCE_ID_BACK_BUTTON).setDestinationId(PendoGlobalCommandHandler.PENDO_GLOBAL_COMMAND_DEST).build();

        private PredefinedCommands() {
        }
    }

    private PendoCommandDispatcher() {
        PendoGlobalCommandHandler.getInstance();
    }

    static List<PendoCommand> filterCommandsByEventType(List<PendoCommand> list, PendoCommandEventType pendoCommandEventType) {
        LinkedList linkedList = new LinkedList();
        if (!list.isEmpty()) {
            for (PendoCommand pendoCommand : list) {
                if (isInScope(pendoCommand) && isMatchEventType(pendoCommand, pendoCommandEventType)) {
                    linkedList.add(pendoCommand);
                }
            }
        }
        return linkedList;
    }

    public static synchronized PendoCommandDispatcher getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PendoCommandDispatcher();
        }
        return INSTANCE;
    }

    private static boolean isInScope(PendoCommand pendoCommand) {
        if (pendoCommand.scope != PendoCommand.PendoCommandScope.ONCE_PER_SESSION) {
            return true;
        }
        synchronized (mLock) {
            HashSet<String> hashSet = sOncePerSessionCommands;
            if (hashSet.contains(pendoCommand.commandId)) {
                return false;
            }
            hashSet.add(pendoCommand.commandId);
            return true;
        }
    }

    private static boolean isMatchEventType(PendoCommand pendoCommand, PendoCommandEventType pendoCommandEventType) {
        PendoCommandEventType pendoCommandEventType2 = PendoCommandEventType.PENDO_COMMAND_EVENT_TYPE_ANY;
        return pendoCommandEventType.equals(pendoCommandEventType2) || pendoCommand.eventType.equals(pendoCommandEventType2) || pendoCommandEventType.equals(pendoCommand.eventType);
    }

    public void dispatchCommand(PendoCommand pendoCommand, boolean z) {
        dispatchCommands(Collections.singletonList(pendoCommand), pendoCommand.eventType, z);
    }

    public void dispatchCommands(List<PendoCommand> list, PendoCommandEventType pendoCommandEventType, boolean z) {
        List<PendoCommand> listFilterCommandsByEventType = filterCommandsByEventType(list, pendoCommandEventType);
        if (listFilterCommandsByEventType.isEmpty()) {
            return;
        }
        j.a((Iterable) listFilterCommandsByEventType).a(z ? a.a() : sdk.pendo.io.i4.a.d()).a((o) d.a(new e() { // from class: sdk.pendo.io.actions.PendoCommandDispatcher$$ExternalSyntheticLambda1
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                PendoCommandsEventBus.getInstance().send((PendoCommand) obj);
            }
        }, "PendoCommandDispatcher dispatchCommands commands observer"));
    }

    public void dispatchCommandsIOThread(List<PendoCommand> list, PendoCommandEventType pendoCommandEventType) {
        List<PendoCommand> listFilterCommandsByEventType = filterCommandsByEventType(list, pendoCommandEventType);
        if (listFilterCommandsByEventType.isEmpty()) {
            return;
        }
        j.a((Iterable) listFilterCommandsByEventType).b(sdk.pendo.io.i4.a.b()).a(sdk.pendo.io.i4.a.d()).a((o) d.a(new e() { // from class: sdk.pendo.io.actions.PendoCommandDispatcher$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                PendoCommandsEventBus.getInstance().send((PendoCommand) obj);
            }
        }, "PendoCommandDispatcher dispatchCommands commands observer"));
    }

    public void init() {
    }
}
