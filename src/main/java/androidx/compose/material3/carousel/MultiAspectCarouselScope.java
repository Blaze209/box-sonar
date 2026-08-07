package androidx.compose.material3.carousel;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

/* JADX INFO: compiled from: MultiAspectCarousel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J)\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¢\u0006\u0002\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/material3/carousel/MultiAspectCarouselScope;", "", "maskClip", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "multiAspectItemDrawInfo", "Landroidx/compose/material3/carousel/MultiAspectCarouselItemDrawInfo;", "maskBorder", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/carousel/MultiAspectCarouselItemDrawInfo;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MultiAspectCarouselScope {
    Modifier maskBorder(Modifier modifier, BorderStroke borderStroke, Shape shape, MultiAspectCarouselItemDrawInfo multiAspectCarouselItemDrawInfo, Composer composer, int i);

    Modifier maskClip(Modifier modifier, Shape shape, MultiAspectCarouselItemDrawInfo multiAspectCarouselItemDrawInfo);
}
