package sdk.pendo.io.actions;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import sdk.pendo.io.actions.handlers.PendoGlobalCommandHandler;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class GuidesActionsManager implements GuidesActionsManagerInterface {
    private static volatile GuidesActionsManager INSTANCE = null;
    private static final AtomicBoolean S_ACTIVITY_DESTROYED = new AtomicBoolean(false);
    private static final String TAG = "GuidesActionsManager";
    private final HashSet<String> mFullyDisplayedGuidesAfterAnimation = new HashSet<>();

    private GuidesActionsManager() {
    }

    public static synchronized GuidesActionsManagerInterface getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GuidesActionsManager();
        }
        return INSTANCE;
    }

    public static boolean isActivityDestroyed() {
        return S_ACTIVITY_DESTROYED.getAndSet(false);
    }

    @Override // sdk.pendo.io.actions.GuidesActionsManagerInterface
    public void dismissVisibleGuides() {
        if (!VisualGuidesManager.getInstance().isAnyGuideShowing()) {
            PendoLogger.d(TAG, "dismissingVisibleGuides ignored - no visible guides");
        } else {
            PendoLogger.d(TAG, "dismissing visible guides");
            PendoCommandDispatcher.getInstance().dispatchCommand(new PendoCommand.Builder(PendoCommandAction.PendoCommandGlobalAction.DISMISS_GUIDE, PendoCommandEventType.SdkEventType.HOST_APP_DEVELOPER_CALL).setSourceId(VisualGuideBase.DISMISS_VISIBLE_GUIDES).setDestinationId(PendoGlobalCommandHandler.PENDO_GLOBAL_COMMAND_DEST).build(), true);
        }
    }

    @Override // sdk.pendo.io.actions.GuidesActionsManagerInterface
    public void removeGuideFullyDisplayedAfterAnimation(String str) {
        this.mFullyDisplayedGuidesAfterAnimation.remove(str);
    }

    @Override // sdk.pendo.io.actions.GuidesActionsManagerInterface
    public void setGuideFullyDisplayedAfterAnimation(String str) {
        this.mFullyDisplayedGuidesAfterAnimation.add(str);
    }

    @Override // sdk.pendo.io.actions.GuidesActionsManagerInterface
    public boolean wasGuideFullyDisplayedAfterAnimation(String str) {
        return this.mFullyDisplayedGuidesAfterAnimation.contains(str);
    }
}
