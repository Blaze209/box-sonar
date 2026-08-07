package com.bumptech.glide.integration.compose;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GlideImage.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\u0010\u0007J$\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0016R\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bumptech/glide/integration/compose/StateTrackingListener;", "Lcom/bumptech/glide/integration/compose/RequestListener;", "state", "Landroidx/compose/runtime/MutableState;", "Lcom/bumptech/glide/integration/compose/RequestState;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;)V", "getPainter", "()Landroidx/compose/runtime/MutableState;", "getState", "onStateChanged", "", "model", "", "requestState", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class StateTrackingListener implements RequestListener {
    private final MutableState<Painter> painter;
    private final MutableState<RequestState> state;

    public StateTrackingListener(MutableState<RequestState> state, MutableState<Painter> painter) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(painter, "painter");
        this.state = state;
        this.painter = painter;
    }

    public final MutableState<RequestState> getState() {
        return this.state;
    }

    public final MutableState<Painter> getPainter() {
        return this.painter;
    }

    @Override // com.bumptech.glide.integration.compose.RequestListener
    public void onStateChanged(Object model, Painter painter, RequestState requestState) {
        Intrinsics.checkNotNullParameter(requestState, "requestState");
        this.state.setValue(requestState);
        this.painter.setValue(painter);
    }
}
