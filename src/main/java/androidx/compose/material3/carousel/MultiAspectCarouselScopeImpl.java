package androidx.compose.material3.carousel;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

/* JADX INFO: compiled from: MultiAspectCarousel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017J)\u0010\n\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/material3/carousel/MultiAspectCarouselScopeImpl;", "Landroidx/compose/material3/carousel/MultiAspectCarouselScope;", "<init>", "()V", "maskClip", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "multiAspectItemDrawInfo", "Landroidx/compose/material3/carousel/MultiAspectCarouselItemDrawInfo;", "maskBorder", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/carousel/MultiAspectCarouselItemDrawInfo;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MultiAspectCarouselScopeImpl implements MultiAspectCarouselScope {
    @Override // androidx.compose.material3.carousel.MultiAspectCarouselScope
    public Modifier maskClip(Modifier modifier, Shape shape, MultiAspectCarouselItemDrawInfo multiAspectCarouselItemDrawInfo) {
        return modifier.then(new MaskParallaxNodeElement(shape, multiAspectCarouselItemDrawInfo));
    }

    @Override // androidx.compose.material3.carousel.MultiAspectCarouselScope
    public Modifier maskBorder(Modifier modifier, BorderStroke borderStroke, Shape shape, MultiAspectCarouselItemDrawInfo multiAspectCarouselItemDrawInfo, Composer composer, int i) {
        composer.startReplaceGroup(1191696812);
        ComposerKt.sourceInformation(composer, "C(maskBorder)N(border,shape,multiAspectItemDrawInfo)239@9661L77:MultiAspectCarousel.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1191696812, i, -1, "androidx.compose.material3.carousel.MultiAspectCarouselScopeImpl.maskBorder (MultiAspectCarousel.kt:237)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1535624935, "CC(remember):MultiAspectCarousel.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new MaskShape(shape, multiAspectCarouselItemDrawInfo);
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierBorder = BorderKt.border(modifier, borderStroke, (MaskShape) objRememberedValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierBorder;
    }
}
