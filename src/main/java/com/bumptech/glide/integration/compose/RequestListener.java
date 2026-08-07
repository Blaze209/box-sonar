package com.bumptech.glide.integration.compose;

import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;

/* JADX INFO: compiled from: GlideModifier.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/bumptech/glide/integration/compose/RequestListener;", "", "onStateChanged", "", "model", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "requestState", "Lcom/bumptech/glide/integration/compose/RequestState;", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface RequestListener {
    void onStateChanged(Object model, Painter painter, RequestState requestState);
}
