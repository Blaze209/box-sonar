package com.bumptech.glide.integration.compose;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.ColorPainter;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GlideImage.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bumptech/glide/integration/compose/GlideSubcompositionScopeImpl;", "Lcom/bumptech/glide/integration/compose/GlideSubcompositionScope;", "maybePainter", "Landroidx/compose/ui/graphics/painter/Painter;", "state", "Lcom/bumptech/glide/integration/compose/RequestState;", "(Landroidx/compose/ui/graphics/painter/Painter;Lcom/bumptech/glide/integration/compose/RequestState;)V", "painter", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getState", "()Lcom/bumptech/glide/integration/compose/RequestState;", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GlideSubcompositionScopeImpl implements GlideSubcompositionScope {
    private final Painter painter;
    private final RequestState state;

    public GlideSubcompositionScopeImpl(ColorPainter colorPainter, RequestState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
        this.painter = colorPainter == null ? new ColorPainter(Color.INSTANCE.m6849getTransparent0d7_KjU(), null) : colorPainter;
    }

    @Override // com.bumptech.glide.integration.compose.GlideSubcompositionScope
    public RequestState getState() {
        return this.state;
    }

    @Override // com.bumptech.glide.integration.compose.GlideSubcompositionScope
    public Painter getPainter() {
        return this.painter;
    }
}
