package com.bumptech.glide.integration.compose;

import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;

/* JADX INFO: compiled from: GlideImage.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bumptech/glide/integration/compose/GlideSubcompositionScope;", "", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "state", "Lcom/bumptech/glide/integration/compose/RequestState;", "getState", "()Lcom/bumptech/glide/integration/compose/RequestState;", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface GlideSubcompositionScope {
    Painter getPainter();

    RequestState getState();
}
