package androidx.compose.material3.carousel;

import androidx.collection.FloatFloatPair;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.unit.IntOffset;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: MultiAspectCarousel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a+\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000eH\u0007\u001a\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u001d\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010\u0016\u001a\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010H\u0002¨\u0006\u001b"}, d2 = {"MultiAspectCarouselScope", "", "content", "Lkotlin/Function1;", "Landroidx/compose/material3/carousel/MultiAspectCarouselScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "MultiAspectCarouselItemDrawInfo", "Landroidx/compose/material3/carousel/MultiAspectCarouselItemDrawInfo;", FirebaseAnalytics.Param.INDEX, "", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "getParallax", "", "Landroidx/compose/material3/carousel/MultiAspectCarouselContainerState;", "itemState", "Landroidx/compose/material3/carousel/MultiAspectCarouselItemInfoState;", "getMask", "Landroidx/collection/FloatFloatPair;", "(Landroidx/compose/material3/carousel/MultiAspectCarouselContainerState;Landroidx/compose/material3/carousel/MultiAspectCarouselItemInfoState;)J", "getMinSize", "getMaskIntensity", "mainAxisSize", "crossAxisSize", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MultiAspectCarouselKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiAspectCarouselScope$lambda$1(Function3 function3, int i, Composer composer, int i2) {
        MultiAspectCarouselScope(function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void MultiAspectCarouselScope(final Function3<? super MultiAspectCarouselScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(901366131);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MultiAspectCarouselScope)N(content)65@2907L43,66@2961L9:MultiAspectCarousel.kt#dcf9yb");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(901366131, i2, -1, "androidx.compose.material3.carousel.MultiAspectCarouselScope (MultiAspectCarousel.kt:64)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1370538498, "CC(remember):MultiAspectCarousel.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new MultiAspectCarouselScopeImpl();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            function3.invoke((MultiAspectCarouselScopeImpl) objRememberedValue, composerStartRestartGroup, Integer.valueOf(((i2 << 3) & 112) | 6));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.MultiAspectCarouselKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MultiAspectCarouselKt.MultiAspectCarouselScope$lambda$1(function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final MultiAspectCarouselItemDrawInfo MultiAspectCarouselItemDrawInfo(final int i, final LazyListState lazyListState) {
        return new MultiAspectCarouselItemDrawInfoImpl(i, new MultiAspectCarouselContainerState() { // from class: androidx.compose.material3.carousel.MultiAspectCarouselKt.MultiAspectCarouselItemDrawInfo.1
            @Override // androidx.compose.material3.carousel.MultiAspectCarouselContainerState
            public float getViewportEndOffset() {
                return lazyListState.getLayoutInfo().getViewportEndOffset();
            }

            @Override // androidx.compose.material3.carousel.MultiAspectCarouselContainerState
            public float getViewportStartOffset() {
                return lazyListState.getLayoutInfo().getViewportStartOffset();
            }

            @Override // androidx.compose.material3.carousel.MultiAspectCarouselContainerState
            public Orientation getOrientation() {
                return lazyListState.getLayoutInfo().getOrientation();
            }
        }, new MultiAspectCarouselItemInfoState() { // from class: androidx.compose.material3.carousel.MultiAspectCarouselKt.MultiAspectCarouselItemDrawInfo.2
            private final LazyListItemInfo getInfo() {
                LazyListItemInfo lazyListItemInfo;
                List<LazyListItemInfo> visibleItemsInfo = lazyListState.getLayoutInfo().getVisibleItemsInfo();
                int i2 = i;
                int size = visibleItemsInfo.size();
                for (int i3 = 0; i3 < size; i3++) {
                    lazyListItemInfo = visibleItemsInfo.get(i3);
                    if (lazyListItemInfo.getIndex() == i2) {
                        return lazyListItemInfo;
                    }
                }
                lazyListItemInfo = null;
                return lazyListItemInfo;
            }

            @Override // androidx.compose.material3.carousel.MultiAspectCarouselItemInfoState
            public boolean isVisible() {
                return getInfo() != null;
            }

            @Override // androidx.compose.material3.carousel.MultiAspectCarouselItemInfoState
            public float getCrossAxisSize() {
                long jMo1336getViewportSizeYbymL2g;
                if (lazyListState.getLayoutInfo().getOrientation() == Orientation.Horizontal) {
                    jMo1336getViewportSizeYbymL2g = lazyListState.getLayoutInfo().mo1336getViewportSizeYbymL2g() & 4294967295L;
                } else {
                    jMo1336getViewportSizeYbymL2g = lazyListState.getLayoutInfo().mo1336getViewportSizeYbymL2g() >> 32;
                }
                return (int) jMo1336getViewportSizeYbymL2g;
            }

            @Override // androidx.compose.material3.carousel.MultiAspectCarouselItemInfoState
            public float getMainAxisSize() {
                LazyListItemInfo info = getInfo();
                if (info != null) {
                    return info.getSize();
                }
                return 0.0f;
            }

            @Override // androidx.compose.material3.carousel.MultiAspectCarouselItemInfoState
            public float getOffset() {
                LazyListItemInfo info = getInfo();
                if (info != null) {
                    return info.getOffset();
                }
                return 0.0f;
            }
        });
    }

    public static final MultiAspectCarouselItemDrawInfo MultiAspectCarouselItemDrawInfo(final int i, final LazyGridState lazyGridState) {
        return new MultiAspectCarouselItemDrawInfoImpl(i, new MultiAspectCarouselContainerState() { // from class: androidx.compose.material3.carousel.MultiAspectCarouselKt.MultiAspectCarouselItemDrawInfo.3
            @Override // androidx.compose.material3.carousel.MultiAspectCarouselContainerState
            public float getViewportEndOffset() {
                return lazyGridState.getLayoutInfo().getViewportEndOffset();
            }

            @Override // androidx.compose.material3.carousel.MultiAspectCarouselContainerState
            public float getViewportStartOffset() {
                return lazyGridState.getLayoutInfo().getViewportStartOffset();
            }

            @Override // androidx.compose.material3.carousel.MultiAspectCarouselContainerState
            public Orientation getOrientation() {
                return lazyGridState.getLayoutInfo().getOrientation();
            }
        }, new MultiAspectCarouselItemInfoState() { // from class: androidx.compose.material3.carousel.MultiAspectCarouselKt.MultiAspectCarouselItemDrawInfo.4
            private final LazyGridItemInfo getInfo() {
                LazyGridItemInfo lazyGridItemInfo;
                List<LazyGridItemInfo> visibleItemsInfo = lazyGridState.getLayoutInfo().getVisibleItemsInfo();
                int i2 = i;
                int size = visibleItemsInfo.size();
                for (int i3 = 0; i3 < size; i3++) {
                    lazyGridItemInfo = visibleItemsInfo.get(i3);
                    if (lazyGridItemInfo.getIndex() == i2) {
                        return lazyGridItemInfo;
                    }
                }
                lazyGridItemInfo = null;
                return lazyGridItemInfo;
            }

            private final boolean isHorizontal() {
                return lazyGridState.getLayoutInfo().getOrientation() == Orientation.Horizontal;
            }

            @Override // androidx.compose.material3.carousel.MultiAspectCarouselItemInfoState
            public boolean isVisible() {
                return getInfo() != null;
            }

            @Override // androidx.compose.material3.carousel.MultiAspectCarouselItemInfoState
            public float getCrossAxisSize() {
                LazyGridItemInfo info = getInfo();
                if (info == null) {
                    return 0.0f;
                }
                long jMo1372getSizeYbymL2g = info.mo1372getSizeYbymL2g();
                return (int) (isHorizontal() ? jMo1372getSizeYbymL2g & 4294967295L : jMo1372getSizeYbymL2g >> 32);
            }

            @Override // androidx.compose.material3.carousel.MultiAspectCarouselItemInfoState
            public float getMainAxisSize() {
                LazyGridItemInfo info = getInfo();
                if (info == null) {
                    return 0.0f;
                }
                long jMo1372getSizeYbymL2g = info.mo1372getSizeYbymL2g();
                return (int) (isHorizontal() ? jMo1372getSizeYbymL2g >> 32 : jMo1372getSizeYbymL2g & 4294967295L);
            }

            @Override // androidx.compose.material3.carousel.MultiAspectCarouselItemInfoState
            public float getOffset() {
                LazyGridItemInfo info = getInfo();
                if (info == null) {
                    return 0.0f;
                }
                long jMo1371getOffsetnOccac = info.mo1371getOffsetnOccac();
                return isHorizontal() ? IntOffset.m9815getXimpl(jMo1371getOffsetnOccac) : IntOffset.m9816getYimpl(jMo1371getOffsetnOccac);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float getParallax(MultiAspectCarouselContainerState multiAspectCarouselContainerState, MultiAspectCarouselItemInfoState multiAspectCarouselItemInfoState) {
        if (!multiAspectCarouselItemInfoState.isVisible()) {
            return 0.0f;
        }
        float mainAxisSize = multiAspectCarouselItemInfoState.getMainAxisSize();
        float crossAxisSize = multiAspectCarouselItemInfoState.getCrossAxisSize();
        float offset = multiAspectCarouselItemInfoState.getOffset();
        float maskIntensity = getMaskIntensity(mainAxisSize, crossAxisSize) * mainAxisSize;
        if (offset < multiAspectCarouselContainerState.getViewportStartOffset()) {
            return StrategyKt.lerp(0.0f, maskIntensity, 0.0f, mainAxisSize, multiAspectCarouselContainerState.getViewportStartOffset() - offset);
        }
        if (offset > multiAspectCarouselContainerState.getViewportEndOffset() - mainAxisSize) {
            return -StrategyKt.lerp(0.0f, maskIntensity, 0.0f, mainAxisSize, -((multiAspectCarouselContainerState.getViewportEndOffset() - offset) - mainAxisSize));
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long getMask(MultiAspectCarouselContainerState multiAspectCarouselContainerState, MultiAspectCarouselItemInfoState multiAspectCarouselItemInfoState) {
        if (!multiAspectCarouselItemInfoState.isVisible()) {
            return FloatFloatPair.m315constructorimpl(0.0f, 0.0f);
        }
        float mainAxisSize = multiAspectCarouselItemInfoState.getMainAxisSize();
        float crossAxisSize = multiAspectCarouselItemInfoState.getCrossAxisSize();
        float offset = multiAspectCarouselItemInfoState.getOffset();
        float maskIntensity = getMaskIntensity(mainAxisSize, crossAxisSize);
        if (offset < multiAspectCarouselContainerState.getViewportStartOffset()) {
            return FloatFloatPair.m315constructorimpl(StrategyKt.lerp(0.0f, (1.0f - maskIntensity) * mainAxisSize, 0.0f, mainAxisSize, multiAspectCarouselContainerState.getViewportStartOffset() - offset), mainAxisSize);
        }
        if (offset > multiAspectCarouselContainerState.getViewportEndOffset() - mainAxisSize) {
            return FloatFloatPair.m315constructorimpl(0.0f, StrategyKt.lerp(mainAxisSize, maskIntensity * mainAxisSize, 0.0f, mainAxisSize, -((multiAspectCarouselContainerState.getViewportEndOffset() - offset) - mainAxisSize)));
        }
        return FloatFloatPair.m315constructorimpl(0.0f, mainAxisSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float getMinSize(MultiAspectCarouselItemInfoState multiAspectCarouselItemInfoState) {
        if (!multiAspectCarouselItemInfoState.isVisible()) {
            return 0.0f;
        }
        return multiAspectCarouselItemInfoState.getMainAxisSize() * (1.0f - getMaskIntensity(multiAspectCarouselItemInfoState.getMainAxisSize(), multiAspectCarouselItemInfoState.getCrossAxisSize()));
    }

    private static final float getMaskIntensity(float f, float f2) {
        float f3 = f / f2;
        if (f3 > 1.7777778f) {
            return 0.5f;
        }
        if (f3 < 1.7777778f && f3 > 1.0f) {
            return StrategyKt.lerp(0.33333334f, 0.5f, 1.0f, 1.7777778f, f3);
        }
        if (f3 >= 1.0f || f3 <= 0.5625f) {
            return 0.25f;
        }
        return StrategyKt.lerp(0.25f, 0.33333334f, 0.5625f, 1.0f, f3);
    }
}
