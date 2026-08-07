package expo.modules.ui;

import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.carousel.CarouselDefaults;
import androidx.compose.material3.carousel.CarouselItemScope;
import androidx.compose.material3.carousel.CarouselKt;
import androidx.compose.material3.carousel.CarouselState;
import androidx.compose.material3.carousel.CarouselStateKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Dp;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.types.Either;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CarouselView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u001a\u0019\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f\"\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"paddingValuesFromEither", "Landroidx/compose/foundation/layout/PaddingValues;", "either", "Lexpo/modules/kotlin/types/Either;", "", "Lexpo/modules/ui/PaddingValuesRecord;", "DEFAULT_MIN_SMALL_ITEM_WIDTH", "DEFAULT_MAX_SMALL_ITEM_WIDTH", "DEFAULT_PREFERRED_ITEM_WIDTH", "DEFAULT_ITEM_WIDTH", "CarouselContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/CarouselProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/CarouselProps;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CarouselViewKt {
    public static final float DEFAULT_ITEM_WIDTH = 200.0f;
    public static final float DEFAULT_MAX_SMALL_ITEM_WIDTH = 56.0f;
    public static final float DEFAULT_MIN_SMALL_ITEM_WIDTH = 40.0f;
    public static final float DEFAULT_PREFERRED_ITEM_WIDTH = 200.0f;

    /* JADX INFO: compiled from: CarouselView.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[FlingBehaviorType.values().length];
            try {
                iArr[FlingBehaviorType.SINGLE_ADVANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FlingBehaviorType.NO_SNAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CarouselVariant.values().length];
            try {
                iArr2[CarouselVariant.MULTI_BROWSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[CarouselVariant.UNCONSTRAINED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CarouselContent$lambda$2(FunctionalComposableScope functionalComposableScope, CarouselProps carouselProps, int i, Composer composer, int i2) {
        CarouselContent(functionalComposableScope, carouselProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void CarouselContent(FunctionalComposableScope functionalComposableScope, CarouselProps carouselProps, Composer composer, final int i) {
        int i2;
        CarouselState carouselState;
        int i3;
        TargetedFlingBehavior targetedFlingBehaviorSingleAdvanceFlingBehavior;
        final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
        final CarouselProps props = carouselProps;
        Intrinsics.checkNotNullParameter(functionalComposableScope2, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2027398043);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CarouselContent)97@3450L13,97@3425L38:CarouselView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope2) : composerStartRestartGroup.changedInstance(functionalComposableScope2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2027398043, i2, -1, "expo.modules.ui.CarouselContent (CarouselView.kt:84)");
            }
            CarouselVariant variant = props.getVariant();
            if (variant == null) {
                variant = CarouselVariant.MULTI_BROWSE;
            }
            if (props.getModifiers() == null) {
                CollectionsKt.emptyList();
            }
            Float itemSpacing = props.getItemSpacing();
            float fM9687constructorimpl = Dp.m9687constructorimpl(itemSpacing != null ? itemSpacing.floatValue() : 0.0f);
            Float minSmallItemWidth = props.getMinSmallItemWidth();
            float fM9687constructorimpl2 = Dp.m9687constructorimpl(minSmallItemWidth != null ? minSmallItemWidth.floatValue() : 40.0f);
            Dp dpM9685boximpl = Dp.m9685boximpl(fM9687constructorimpl2);
            Float maxSmallItemWidth = props.getMaxSmallItemWidth();
            float fM9701unboximpl = ((Dp) RangesKt.coerceAtLeast(dpM9685boximpl, Dp.m9685boximpl(Dp.m9687constructorimpl(maxSmallItemWidth != null ? maxSmallItemWidth.floatValue() : 56.0f)))).m9701unboximpl();
            Float preferredItemWidth = props.getPreferredItemWidth();
            float fM9687constructorimpl3 = Dp.m9687constructorimpl(preferredItemWidth != null ? preferredItemWidth.floatValue() : 200.0f);
            Float itemWidth = props.getItemWidth();
            float fM9687constructorimpl4 = Dp.m9687constructorimpl(itemWidth != null ? itemWidth.floatValue() : 200.0f);
            FlingBehaviorType flingBehavior = props.getFlingBehavior();
            if (flingBehavior == null) {
                flingBehavior = FlingBehaviorType.SINGLE_ADVANCE;
            }
            PaddingValues paddingValuesPaddingValuesFromEither = paddingValuesFromEither(props.getContentPadding());
            composerStartRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselView.kt#9igjgp");
            boolean z = (i2 & 14) == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changedInstance(functionalComposableScope2));
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.CarouselViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(CarouselViewKt.CarouselContent$lambda$1$lambda$0(functionalComposableScope2));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            CarouselState carouselStateRememberCarouselState = CarouselStateKt.rememberCarouselState(0, (Function0) objRememberedValue, composerStartRestartGroup, 6, 0);
            int i4 = WhenMappings.$EnumSwitchMapping$0[flingBehavior.ordinal()];
            if (i4 == 1) {
                composerStartRestartGroup.startReplaceGroup(1585667734);
                ComposerKt.sourceInformation(composerStartRestartGroup, "100@3594L49");
                carouselState = carouselStateRememberCarouselState;
                i3 = 1;
                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState, null, composerStartRestartGroup, (CarouselDefaults.$stable << 6) | CarouselState.$stable, 2);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (i4 != 2) {
                    composerStartRestartGroup.startReplaceGroup(1585665206);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(1585670906);
                ComposerKt.sourceInformation(composerStartRestartGroup, "101@3694L21");
                TargetedFlingBehavior targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, CarouselDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
                carouselState = carouselStateRememberCarouselState;
                targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehaviorNoSnapFlingBehavior;
                i3 = 1;
            }
            int i5 = WhenMappings.$EnumSwitchMapping$1[variant.ordinal()];
            if (i5 == i3) {
                composerStartRestartGroup.startReplaceGroup(1585705732);
                ComposerKt.sourceInformation(composerStartRestartGroup, "135@4782L31");
                functionalComposableScope2 = functionalComposableScope;
                props = carouselProps;
                CarouselContent$MultiBrowseCarouselComposable(carouselState, fM9687constructorimpl3, props, functionalComposableScope2, fM9687constructorimpl, targetedFlingBehaviorSingleAdvanceFlingBehavior, fM9687constructorimpl2, fM9701unboximpl, paddingValuesPaddingValuesFromEither, composerStartRestartGroup, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (i5 != 2) {
                    composerStartRestartGroup.startReplaceGroup(1585704164);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(1585707942);
                ComposerKt.sourceInformation(composerStartRestartGroup, "136@4851L33");
                CarouselContent$UnconstrainedCarouselComposable(carouselState, fM9687constructorimpl4, props, functionalComposableScope2, fM9687constructorimpl, targetedFlingBehaviorSingleAdvanceFlingBehavior, paddingValuesPaddingValuesFromEither, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                functionalComposableScope2 = functionalComposableScope;
                props = carouselProps;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.CarouselViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CarouselViewKt.CarouselContent$lambda$2(functionalComposableScope2, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int CarouselContent$lambda$1$lambda$0(FunctionalComposableScope functionalComposableScope) {
        return functionalComposableScope.getView().getChildCount();
    }

    private static final void CarouselContent$MultiBrowseCarouselComposable(CarouselState carouselState, float f, CarouselProps carouselProps, final FunctionalComposableScope functionalComposableScope, float f2, TargetedFlingBehavior targetedFlingBehavior, float f3, float f4, PaddingValues paddingValues, Composer composer, int i) {
        composer.startReplaceGroup(-789139939);
        ComposerKt.sourceInformation(composer, "C(MultiBrowseCarouselComposable)109@3920L83,115@4209L62,106@3779L492:CarouselView.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-789139939, i, -1, "expo.modules.ui.CarouselContent.MultiBrowseCarouselComposable (CarouselView.kt:105)");
        }
        CarouselKt.m4876HorizontalMultiBrowseCarousel3tcCNu0(carouselState, f, ModifierRegistry.INSTANCE.applyModifiers(carouselProps.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composer, (ComposableScope.$stable << 6) | (AppContext.$stable << 3)), f2, targetedFlingBehavior, false, f3, f4, paddingValues, ComposableLambdaKt.rememberComposableLambda(734104852, true, new Function4<CarouselItemScope, Integer, Composer, Integer, Unit>() { // from class: expo.modules.ui.CarouselViewKt$CarouselContent$MultiBrowseCarouselComposable$1
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(CarouselItemScope carouselItemScope, Integer num, Composer composer2, Integer num2) {
                invoke(carouselItemScope, num.intValue(), composer2, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(CarouselItemScope HorizontalMultiBrowseCarousel, int i2, Composer composer2, int i3) {
                Intrinsics.checkNotNullParameter(HorizontalMultiBrowseCarousel, "$this$HorizontalMultiBrowseCarousel");
                ComposerKt.sourceInformation(composer2, "C116@4230L35:CarouselView.kt#v15e7d");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(734104852, i3, -1, "expo.modules.ui.CarouselContent.MultiBrowseCarouselComposable.<anonymous> (CarouselView.kt:116)");
                }
                functionalComposableScope.Child(new ComposableScope(null, null, null, null, 15, null), i2, composer2, ComposableScope.$stable | (i3 & 112) | (FunctionalComposableScope.$stable << 6));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, CarouselState.$stable | 805306368, 32);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    private static final void CarouselContent$UnconstrainedCarouselComposable(CarouselState carouselState, float f, CarouselProps carouselProps, final FunctionalComposableScope functionalComposableScope, float f2, TargetedFlingBehavior targetedFlingBehavior, PaddingValues paddingValues, Composer composer, int i) {
        composer.startReplaceGroup(2012040727);
        ComposerKt.sourceInformation(composer, "C(UnconstrainedCarouselComposable)125@4460L83,129@4659L62,122@4337L384:CarouselView.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2012040727, i, -1, "expo.modules.ui.CarouselContent.UnconstrainedCarouselComposable (CarouselView.kt:121)");
        }
        CarouselKt.m4877HorizontalUncontainedCarouselVUP9l70(carouselState, f, ModifierRegistry.INSTANCE.applyModifiers(carouselProps.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composer, (AppContext.$stable << 3) | (ComposableScope.$stable << 6)), f2, targetedFlingBehavior, false, paddingValues, ComposableLambdaKt.rememberComposableLambda(-205865497, true, new Function4<CarouselItemScope, Integer, Composer, Integer, Unit>() { // from class: expo.modules.ui.CarouselViewKt$CarouselContent$UnconstrainedCarouselComposable$1
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(CarouselItemScope carouselItemScope, Integer num, Composer composer2, Integer num2) {
                invoke(carouselItemScope, num.intValue(), composer2, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(CarouselItemScope HorizontalUncontainedCarousel, int i2, Composer composer2, int i3) {
                Intrinsics.checkNotNullParameter(HorizontalUncontainedCarousel, "$this$HorizontalUncontainedCarousel");
                ComposerKt.sourceInformation(composer2, "C130@4680L35:CarouselView.kt#v15e7d");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-205865497, i3, -1, "expo.modules.ui.CarouselContent.UnconstrainedCarouselComposable.<anonymous> (CarouselView.kt:130)");
                }
                functionalComposableScope.Child(new ComposableScope(null, null, null, null, 15, null), i2, composer2, ComposableScope.$stable | (i3 & 112) | (FunctionalComposableScope.$stable << 6));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, CarouselState.$stable | 12582912, 32);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    public static final PaddingValues paddingValuesFromEither(Either<Float, PaddingValuesRecord> either) {
        if (either == null) {
            return PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(0));
        }
        if (either.isFirstType(Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            return PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(either.getFirstType(Reflection.getOrCreateKotlinClass(Float.TYPE)).floatValue()));
        }
        if (either.isSecondType(Reflection.getOrCreateKotlinClass(PaddingValuesRecord.class))) {
            return either.getSecondType(Reflection.getOrCreateKotlinClass(PaddingValuesRecord.class)).toPaddingValues();
        }
        throw new IllegalStateException();
    }
}
