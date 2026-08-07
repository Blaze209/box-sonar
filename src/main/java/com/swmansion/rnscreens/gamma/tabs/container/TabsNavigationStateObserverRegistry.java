package com.swmansion.rnscreens.gamma.tabs.container;

import com.box.android.observability.DiagnosisParams;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabsNavigationStateObserverRegistry.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\rJ&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014J\u001e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dJ\u001c\u0010\u001e\u001a\u00020\r2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0 H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateObserverRegistry;", "", "<init>", "()V", "observers", "", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateObserver;", "isEmitting", "", "add", "observer", "remove", DiagnosisParams.CLEAR_ON_LOGOUT, "", "emitOnNavigationStateUpdate", "navState", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationState;", "isRepeated", "hasTriggeredSpecialEffect", "actionOrigin", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsActionOrigin;", "emitOnNavigationStateUpdateRejected", "currentNavState", "rejectedRequest", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateUpdateRequest;", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateRejectionReason;", "emitOnNavigationStateUpdatePrevented", "preventedScreenKey", "", "emitSignal", "emitBlock", "Lkotlin/Function1;", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabsNavigationStateObserverRegistry {
    private boolean isEmitting;
    private final List<TabsNavigationStateObserver> observers = new ArrayList();

    public final boolean add(TabsNavigationStateObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.isEmitting || this.observers.contains(observer)) {
            return false;
        }
        this.observers.add(observer);
        return true;
    }

    public final boolean remove(TabsNavigationStateObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.isEmitting) {
            return false;
        }
        return this.observers.remove(observer);
    }

    public final void clear() {
        if (this.isEmitting) {
            throw new IllegalStateException("[RNScreens] TabsNavigationStateObserverRegistry.clear during emission".toString());
        }
        this.observers.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit emitOnNavigationStateUpdate$lambda$1(TabsNavigationState tabsNavigationState, boolean z, boolean z2, TabsActionOrigin tabsActionOrigin, TabsNavigationStateObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        observer.onNavigationStateUpdate(tabsNavigationState, z, z2, tabsActionOrigin);
        return Unit.INSTANCE;
    }

    public final void emitOnNavigationStateUpdate(final TabsNavigationState navState, final boolean isRepeated, final boolean hasTriggeredSpecialEffect, final TabsActionOrigin actionOrigin) {
        Intrinsics.checkNotNullParameter(navState, "navState");
        Intrinsics.checkNotNullParameter(actionOrigin, "actionOrigin");
        emitSignal(new Function1() { // from class: com.swmansion.rnscreens.gamma.tabs.container.TabsNavigationStateObserverRegistry$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TabsNavigationStateObserverRegistry.emitOnNavigationStateUpdate$lambda$1(navState, isRepeated, hasTriggeredSpecialEffect, actionOrigin, (TabsNavigationStateObserver) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit emitOnNavigationStateUpdateRejected$lambda$2(TabsNavigationState tabsNavigationState, TabsNavigationStateUpdateRequest tabsNavigationStateUpdateRequest, TabsNavigationStateRejectionReason tabsNavigationStateRejectionReason, TabsNavigationStateObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        observer.onNavigationStateUpdateRejected(tabsNavigationState, tabsNavigationStateUpdateRequest, tabsNavigationStateRejectionReason);
        return Unit.INSTANCE;
    }

    public final void emitOnNavigationStateUpdateRejected(final TabsNavigationState currentNavState, final TabsNavigationStateUpdateRequest rejectedRequest, final TabsNavigationStateRejectionReason reason) {
        Intrinsics.checkNotNullParameter(currentNavState, "currentNavState");
        Intrinsics.checkNotNullParameter(rejectedRequest, "rejectedRequest");
        Intrinsics.checkNotNullParameter(reason, "reason");
        emitSignal(new Function1() { // from class: com.swmansion.rnscreens.gamma.tabs.container.TabsNavigationStateObserverRegistry$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TabsNavigationStateObserverRegistry.emitOnNavigationStateUpdateRejected$lambda$2(currentNavState, rejectedRequest, reason, (TabsNavigationStateObserver) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit emitOnNavigationStateUpdatePrevented$lambda$3(TabsNavigationState tabsNavigationState, String str, TabsNavigationStateObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        observer.onNavigationStateUpdatePrevented(tabsNavigationState, str);
        return Unit.INSTANCE;
    }

    public final void emitOnNavigationStateUpdatePrevented(final TabsNavigationState currentNavState, final String preventedScreenKey) {
        Intrinsics.checkNotNullParameter(currentNavState, "currentNavState");
        Intrinsics.checkNotNullParameter(preventedScreenKey, "preventedScreenKey");
        emitSignal(new Function1() { // from class: com.swmansion.rnscreens.gamma.tabs.container.TabsNavigationStateObserverRegistry$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TabsNavigationStateObserverRegistry.emitOnNavigationStateUpdatePrevented$lambda$3(currentNavState, preventedScreenKey, (TabsNavigationStateObserver) obj);
            }
        });
    }

    private final void emitSignal(Function1<? super TabsNavigationStateObserver, Unit> emitBlock) {
        if (this.isEmitting) {
            throw new IllegalStateException("[RNScreens] Recursive emission on TabsNavigationStateObserverRegistry".toString());
        }
        this.isEmitting = true;
        try {
            Iterator<T> it = this.observers.iterator();
            while (it.hasNext()) {
                emitBlock.invoke((TabsNavigationStateObserver) it.next());
            }
            this.isEmitting = false;
        } catch (Throwable th) {
            this.isEmitting = false;
            throw th;
        }
    }
}
