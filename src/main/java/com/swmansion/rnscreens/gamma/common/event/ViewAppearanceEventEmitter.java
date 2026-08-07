package com.swmansion.rnscreens.gamma.common.event;

import kotlin.Metadata;

/* JADX INFO: compiled from: ViewAppearanceEventEmitter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/swmansion/rnscreens/gamma/common/event/ViewAppearanceEventEmitter;", "", "emitOnWillAppear", "", "emitOnDidAppear", "emitOnWillDisappear", "emitOnDidDisappear", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ViewAppearanceEventEmitter {
    void emitOnDidAppear();

    void emitOnDidDisappear();

    void emitOnWillAppear();

    void emitOnWillDisappear();
}
