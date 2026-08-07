package com.box.android.base.presentation.message;

import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxMessageDispatcher.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\b2\u0016\u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u001e\u0010\u000b\u001a\u00020\b2\u0016\u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u0012\u0010\f\u001a\u00020\b2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0007R$\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/base/presentation/message/BoxMessageDispatcher;", "", "<init>", "()V", "listeners", "", "Lkotlin/Function1;", "Lcom/box/android/coreservices/modelcontroller/messages/BoxMessage;", "", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeListener", "dispatch", "message", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxMessageDispatcher {
    public static final int $stable = 8;
    private final List<Function1<BoxMessage<?>, Unit>> listeners = new ArrayList();

    @Inject
    public BoxMessageDispatcher() {
    }

    public final void addListener(Function1<? super BoxMessage<?>, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void removeListener(Function1<? super BoxMessage<?>, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    public final void dispatch(BoxMessage<?> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(message);
        }
    }
}
