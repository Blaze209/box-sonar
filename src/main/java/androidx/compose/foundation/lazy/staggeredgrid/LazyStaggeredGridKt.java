package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollableAreaKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyStaggeredGrid.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"LazyStaggeredGrid", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyStaggeredGrid-w41Enmo", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;FFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyStaggeredGridKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyStaggeredGrid_w41Enmo$lambda$0(LazyStaggeredGridState lazyStaggeredGridState, Orientation orientation, LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider, Modifier modifier, PaddingValues paddingValues, boolean z, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, float f, float f2, Function1 function1, int i, int i2, int i3, Composer composer, int i4) {
        m1469LazyStaggeredGridw41Enmo(lazyStaggeredGridState, orientation, lazyGridStaggeredGridSlotsProvider, modifier, paddingValues, z, flingBehavior, z2, overscrollEffect, f, f2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x012d  */
    /* JADX WARN: Code duplicated, block: B:102:0x0131  */
    /* JADX WARN: Code duplicated, block: B:104:0x013b  */
    /* JADX WARN: Code duplicated, block: B:105:0x013e  */
    /* JADX WARN: Code duplicated, block: B:107:0x0143  */
    /* JADX WARN: Code duplicated, block: B:110:0x014d  */
    /* JADX WARN: Code duplicated, block: B:112:0x0153  */
    /* JADX WARN: Code duplicated, block: B:113:0x0156  */
    /* JADX WARN: Code duplicated, block: B:117:0x016a  */
    /* JADX WARN: Code duplicated, block: B:121:0x0173  */
    /* JADX WARN: Code duplicated, block: B:124:0x017d  */
    /* JADX WARN: Code duplicated, block: B:126:0x018c  */
    /* JADX WARN: Code duplicated, block: B:134:0x01ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:135:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:136:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:138:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:139:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:141:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:144:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:145:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:148:0x01da  */
    /* JADX WARN: Code duplicated, block: B:151:0x01df  */
    /* JADX WARN: Code duplicated, block: B:152:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:154:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:155:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:159:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:162:0x022c  */
    /* JADX WARN: Code duplicated, block: B:165:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:166:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:169:0x033f  */
    /* JADX WARN: Code duplicated, block: B:171:0x034f  */
    /* JADX WARN: Code duplicated, block: B:174:0x0362  */
    /* JADX WARN: Code duplicated, block: B:176:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0079  */
    /* JADX WARN: Code duplicated, block: B:41:0x007c  */
    /* JADX WARN: Code duplicated, block: B:43:0x0080  */
    /* JADX WARN: Code duplicated, block: B:45:0x0088  */
    /* JADX WARN: Code duplicated, block: B:46:0x008b  */
    /* JADX WARN: Code duplicated, block: B:51:0x0098  */
    /* JADX WARN: Code duplicated, block: B:52:0x009d  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:74:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:84:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:88:0x0105  */
    /* JADX WARN: Code duplicated, block: B:89:0x0108  */
    /* JADX WARN: Code duplicated, block: B:91:0x010c  */
    /* JADX WARN: Code duplicated, block: B:93:0x0116  */
    /* JADX WARN: Code duplicated, block: B:94:0x0119  */
    /* JADX WARN: Code duplicated, block: B:99:0x0126  */
    /* JADX INFO: renamed from: LazyStaggeredGrid-w41Enmo, reason: not valid java name */
    public static final void m1469LazyStaggeredGridw41Enmo(final LazyStaggeredGridState lazyStaggeredGridState, final Orientation orientation, final LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider, Modifier modifier, PaddingValues paddingValues, boolean z, FlingBehavior flingBehavior, boolean z2, final OverscrollEffect overscrollEffect, float f, float f2, final Function1<? super LazyStaggeredGridScope, Unit> function1, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        PaddingValues paddingValues2;
        int i6;
        int i7;
        boolean z3;
        int i8;
        FlingBehavior flingBehavior2;
        int i9;
        boolean z4;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z5;
        final float f3;
        final FlingBehavior flingBehavior3;
        Composer composer2;
        final boolean z6;
        final PaddingValues paddingValues3;
        final boolean z7;
        final Modifier modifier3;
        final float f4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        PaddingValues paddingValuesM1211PaddingValues0680j_4;
        int i18;
        boolean z8;
        float fM9687constructorimpl;
        Modifier modifier4;
        FlingBehavior flingBehavior4;
        PaddingValues paddingValues4;
        boolean z9;
        int i19;
        Object objRememberedValue;
        boolean z10;
        Modifier.Companion companionLazyLayoutBeyondBoundsModifier;
        int i20;
        int i21;
        int i22;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1904835166);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyStaggeredGrid)N(state,orientation,slots,modifier,contentPadding,reverseLayout,flingBehavior,userScrollEnabled,overscrollEffect,mainAxisSpacing:c#ui.unit.Dp,crossAxisSpacing:c#ui.unit.Dp,content)63@2868L55,64@2949L24,65@3021L7,67@3061L311,79@3397L60,98@4044L302,93@3875L1116:LazyStaggeredGrid.kt#fzvcnm");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(lazyStaggeredGridState) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(orientation.ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= (i & 512) == 0 ? composerStartRestartGroup.changed(lazyGridStaggeredGridSlotsProvider) : composerStartRestartGroup.changedInstance(lazyGridStaggeredGridSlotsProvider) ? 256 : 128;
        }
        int i23 = i3 & 8;
        if (i23 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((i & 24576) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 32;
                if (i7 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    z3 = z;
                } else {
                    z3 = z;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(z3)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                        i4 |= i8;
                    }
                }
                if ((i & 1572864) == 0) {
                    flingBehavior2 = flingBehavior;
                    if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(flingBehavior2)) {
                        i22 = 524288;
                    } else {
                        i22 = 1048576;
                    }
                    i4 |= i22;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                i9 = i3 & 128;
                if (i9 != 0) {
                    i4 |= 12582912;
                    z4 = z2;
                } else {
                    z4 = z2;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(z4)) {
                            i10 = 8388608;
                        } else {
                            i10 = 4194304;
                        }
                        i4 |= i10;
                    }
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(overscrollEffect)) {
                        i21 = 67108864;
                    } else {
                        i21 = 33554432;
                    }
                    i4 |= i21;
                }
                i11 = i3 & 512;
                if (i11 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i12 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i12 = 268435456;
                        }
                        i4 |= i12;
                    }
                    i13 = i3 & 1024;
                    if (i13 != 0) {
                        i14 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changed(f2)) {
                            i15 = 4;
                        } else {
                            i15 = 2;
                        }
                        i14 = i2 | i15;
                    } else {
                        i14 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i20 = 32;
                        } else {
                            i20 = 16;
                        }
                        i14 |= i20;
                    }
                    i16 = i14;
                    i17 = i4;
                    if ((i17 & 306783379) == 306783378 || (i16 & 19) != 18) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i17 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "51@2361L15");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i23 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                paddingValuesM1211PaddingValues0680j_4 = PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(0));
                            } else {
                                paddingValuesM1211PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if ((i3 & 64) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i18 = i17 & (-3670017);
                            } else {
                                i18 = i17;
                            }
                            z8 = i9 == 0 ? z4 : true;
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                f2 = Dp.m9687constructorimpl(0);
                            } else {
                                f2 = f2;
                            }
                            modifier4 = companion;
                            flingBehavior4 = flingBehavior2;
                            paddingValues4 = paddingValuesM1211PaddingValues0680j_4;
                            z9 = z3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i18 = (i3 & 64) != 0 ? i17 & (-3670017) : i17;
                            flingBehavior4 = flingBehavior2;
                            z8 = z4;
                            paddingValues4 = paddingValues2;
                            fM9687constructorimpl = f;
                            z9 = z3;
                            modifier4 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1904835166, i18, i16, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:62)");
                        }
                        i19 = i18 & 14;
                        Function0<LazyStaggeredGridItemProvider> function0RememberStaggeredGridItemProviderLambda = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(lazyStaggeredGridState, function1, composerStartRestartGroup, (i16 & 112) | i19);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<GraphicsContext> localGraphicsContext = CompositionLocalsKt.getLocalGraphicsContext();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localGraphicsContext);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i24 = i18 >> 6;
                        int i25 = i18 >> 12;
                        int i26 = ((i18 << 18) & 234881024) | (i24 & 7168) | (i24 & 896) | i19 | ((i18 << 9) & 57344) | (i25 & 458752) | ((i16 << 18) & 3670016);
                        int i27 = i18;
                        z10 = z9;
                        float f5 = fM9687constructorimpl;
                        float f6 = f2;
                        LazyLayoutMeasurePolicy lazyLayoutMeasurePolicyM1481rememberStaggeredGridMeasurePolicyqKj4JfE = LazyStaggeredGridMeasurePolicyKt.m1481rememberStaggeredGridMeasurePolicyqKj4JfE(lazyStaggeredGridState, function0RememberStaggeredGridItemProviderLambda, paddingValues4, z10, orientation, f5, f6, (CoroutineScope) objRememberedValue, lazyGridStaggeredGridSlotsProvider, (GraphicsContext) objConsume, composerStartRestartGroup, i26);
                        PaddingValues paddingValues5 = paddingValues4;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(lazyStaggeredGridState, z10, composerStartRestartGroup, (i25 & 112) | i19);
                        if (z8) {
                            composerStartRestartGroup.startReplaceGroup(-1834596342);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "84@3600L57");
                            companionLazyLayoutBeyondBoundsModifier = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.INSTANCE, LazyStaggeredGridBeyondBoundsModifierKt.rememberLazyStaggeredGridBeyondBoundsState(lazyStaggeredGridState, composerStartRestartGroup, i19), lazyStaggeredGridState.getBeyondBoundsInfo(), z10, orientation);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1834291488);
                            composerStartRestartGroup.endReplaceGroup();
                            companionLazyLayoutBeyondBoundsModifier = Modifier.INSTANCE;
                        }
                        boolean z11 = z8;
                        FlingBehavior flingBehavior5 = flingBehavior4;
                        LazyLayoutKt.LazyLayout(function0RememberStaggeredGridItemProviderLambda, ScrollableAreaKt.scrollableArea$default(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier4.then(lazyStaggeredGridState.getRemeasurementModifier()).then(lazyStaggeredGridState.getAwaitLayoutModifier()), function0RememberStaggeredGridItemProviderLambda, lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState, orientation, z11, z10, composerStartRestartGroup, (i27 & 458752) | ((i27 << 6) & 7168) | ((i27 >> 9) & 57344)).then(companionLazyLayoutBeyondBoundsModifier).then(lazyStaggeredGridState.getItemAnimator$foundation().getModifier()), lazyStaggeredGridState, orientation, overscrollEffect, z11, z10, flingBehavior5, lazyStaggeredGridState.getMutableInteractionSource(), null, 128, null), lazyStaggeredGridState.getPrefetchState(), lazyLayoutMeasurePolicyM1481rememberStaggeredGridMeasurePolicyqKj4JfE, composerStartRestartGroup, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2 = composerStartRestartGroup;
                        flingBehavior3 = flingBehavior5;
                        modifier3 = modifier4;
                        z6 = z8;
                        paddingValues3 = paddingValues5;
                        f4 = f5;
                        f3 = f6;
                        z7 = z10;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        f3 = f2;
                        flingBehavior3 = flingBehavior2;
                        composer2 = composerStartRestartGroup;
                        z6 = z4;
                        paddingValues3 = paddingValues2;
                        z7 = z3;
                        modifier3 = modifier2;
                        f4 = f;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return LazyStaggeredGridKt.LazyStaggeredGrid_w41Enmo$lambda$0(lazyStaggeredGridState, orientation, lazyGridStaggeredGridSlotsProvider, modifier3, paddingValues3, z7, flingBehavior3, z6, overscrollEffect, f4, f3, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 805306368;
                i13 = i3 & 1024;
                if (i13 != 0) {
                    i14 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i15 = 4;
                    } else {
                        i15 = 2;
                    }
                    i14 = i2 | i15;
                } else {
                    i14 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i20 = 32;
                    } else {
                        i20 = 16;
                    }
                    i14 |= i20;
                }
                i16 = i14;
                i17 = i4;
                if ((i17 & 306783379) == 306783378) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i17 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "51@2361L15");
                    if ((i & 1) != 0) {
                        if (i23 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            paddingValuesM1211PaddingValues0680j_4 = PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(0));
                        } else {
                            paddingValuesM1211PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if ((i3 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i18 = i17 & (-3670017);
                        } else {
                            i18 = i17;
                        }
                        if (i9 == 0) {
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f2 = Dp.m9687constructorimpl(0);
                        } else {
                            f2 = f2;
                        }
                        modifier4 = companion;
                        flingBehavior4 = flingBehavior2;
                        paddingValues4 = paddingValuesM1211PaddingValues0680j_4;
                        z9 = z3;
                    } else {
                        if (i23 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            paddingValuesM1211PaddingValues0680j_4 = PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(0));
                        } else {
                            paddingValuesM1211PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if ((i3 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i18 = i17 & (-3670017);
                        } else {
                            i18 = i17;
                        }
                        if (i9 == 0) {
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f2 = Dp.m9687constructorimpl(0);
                        } else {
                            f2 = f2;
                        }
                        modifier4 = companion;
                        flingBehavior4 = flingBehavior2;
                        paddingValues4 = paddingValuesM1211PaddingValues0680j_4;
                        z9 = z3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1904835166, i18, i16, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:62)");
                    }
                    i19 = i18 & 14;
                    Function0<LazyStaggeredGridItemProvider> function0RememberStaggeredGridItemProviderLambda2 = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(lazyStaggeredGridState, function1, composerStartRestartGroup, (i16 & 112) | i19);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<GraphicsContext> localGraphicsContext2 = CompositionLocalsKt.getLocalGraphicsContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localGraphicsContext2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i28 = i18 >> 6;
                    int i29 = i18 >> 12;
                    int i210 = ((i18 << 18) & 234881024) | (i28 & 7168) | (i28 & 896) | i19 | ((i18 << 9) & 57344) | (i29 & 458752) | ((i16 << 18) & 3670016);
                    int i211 = i18;
                    z10 = z9;
                    float f7 = fM9687constructorimpl;
                    float f8 = f2;
                    LazyLayoutMeasurePolicy lazyLayoutMeasurePolicyM1481rememberStaggeredGridMeasurePolicyqKj4JfE2 = LazyStaggeredGridMeasurePolicyKt.m1481rememberStaggeredGridMeasurePolicyqKj4JfE(lazyStaggeredGridState, function0RememberStaggeredGridItemProviderLambda2, paddingValues4, z10, orientation, f7, f8, (CoroutineScope) objRememberedValue, lazyGridStaggeredGridSlotsProvider, (GraphicsContext) objConsume2, composerStartRestartGroup, i210);
                    PaddingValues paddingValues6 = paddingValues4;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState2 = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(lazyStaggeredGridState, z10, composerStartRestartGroup, (i29 & 112) | i19);
                    if (z8) {
                        composerStartRestartGroup.startReplaceGroup(-1834596342);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "84@3600L57");
                        companionLazyLayoutBeyondBoundsModifier = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.INSTANCE, LazyStaggeredGridBeyondBoundsModifierKt.rememberLazyStaggeredGridBeyondBoundsState(lazyStaggeredGridState, composerStartRestartGroup, i19), lazyStaggeredGridState.getBeyondBoundsInfo(), z10, orientation);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1834291488);
                        composerStartRestartGroup.endReplaceGroup();
                        companionLazyLayoutBeyondBoundsModifier = Modifier.INSTANCE;
                    }
                    boolean z12 = z8;
                    FlingBehavior flingBehavior6 = flingBehavior4;
                    LazyLayoutKt.LazyLayout(function0RememberStaggeredGridItemProviderLambda2, ScrollableAreaKt.scrollableArea$default(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier4.then(lazyStaggeredGridState.getRemeasurementModifier()).then(lazyStaggeredGridState.getAwaitLayoutModifier()), function0RememberStaggeredGridItemProviderLambda2, lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState2, orientation, z12, z10, composerStartRestartGroup, (i211 & 458752) | ((i211 << 6) & 7168) | ((i211 >> 9) & 57344)).then(companionLazyLayoutBeyondBoundsModifier).then(lazyStaggeredGridState.getItemAnimator$foundation().getModifier()), lazyStaggeredGridState, orientation, overscrollEffect, z12, z10, flingBehavior6, lazyStaggeredGridState.getMutableInteractionSource(), null, 128, null), lazyStaggeredGridState.getPrefetchState(), lazyLayoutMeasurePolicyM1481rememberStaggeredGridMeasurePolicyqKj4JfE2, composerStartRestartGroup, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = composerStartRestartGroup;
                    flingBehavior3 = flingBehavior6;
                    modifier3 = modifier4;
                    z6 = z8;
                    paddingValues3 = paddingValues6;
                    f4 = f7;
                    f3 = f8;
                    z7 = z10;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f3 = f2;
                    flingBehavior3 = flingBehavior2;
                    composer2 = composerStartRestartGroup;
                    z6 = z4;
                    paddingValues3 = paddingValues2;
                    z7 = z3;
                    modifier3 = modifier2;
                    f4 = f;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LazyStaggeredGridKt.LazyStaggeredGrid_w41Enmo$lambda$0(lazyStaggeredGridState, orientation, lazyGridStaggeredGridSlotsProvider, modifier3, paddingValues3, z7, flingBehavior3, z6, overscrollEffect, f4, f3, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            paddingValues2 = paddingValues;
            i7 = i3 & 32;
            if (i7 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z3 = z;
            } else {
                z3 = z;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i4 |= i8;
                }
            }
            if ((i & 1572864) == 0) {
                flingBehavior2 = flingBehavior;
                if ((i3 & 64) == 0) {
                    i22 = 524288;
                } else {
                    i22 = 524288;
                }
                i4 |= i22;
            } else {
                flingBehavior2 = flingBehavior;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i4 |= 12582912;
                z4 = z2;
            } else {
                z4 = z2;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z4)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(overscrollEffect)) {
                    i21 = 67108864;
                } else {
                    i21 = 33554432;
                }
                i4 |= i21;
            }
            i11 = i3 & 512;
            if (i11 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i12 = 268435456;
                    }
                    i4 |= i12;
                }
                i13 = i3 & 1024;
                if (i13 != 0) {
                    i14 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i15 = 4;
                    } else {
                        i15 = 2;
                    }
                    i14 = i2 | i15;
                } else {
                    i14 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i20 = 32;
                    } else {
                        i20 = 16;
                    }
                    i14 |= i20;
                }
                i16 = i14;
                i17 = i4;
                if ((i17 & 306783379) == 306783378) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i17 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "51@2361L15");
                    if ((i & 1) != 0) {
                        if (i23 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            paddingValuesM1211PaddingValues0680j_4 = PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(0));
                        } else {
                            paddingValuesM1211PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if ((i3 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i18 = i17 & (-3670017);
                        } else {
                            i18 = i17;
                        }
                        if (i9 == 0) {
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f2 = Dp.m9687constructorimpl(0);
                        } else {
                            f2 = f2;
                        }
                        modifier4 = companion;
                        flingBehavior4 = flingBehavior2;
                        paddingValues4 = paddingValuesM1211PaddingValues0680j_4;
                        z9 = z3;
                    } else {
                        if (i23 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            paddingValuesM1211PaddingValues0680j_4 = PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(0));
                        } else {
                            paddingValuesM1211PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if ((i3 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i18 = i17 & (-3670017);
                        } else {
                            i18 = i17;
                        }
                        if (i9 == 0) {
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f2 = Dp.m9687constructorimpl(0);
                        } else {
                            f2 = f2;
                        }
                        modifier4 = companion;
                        flingBehavior4 = flingBehavior2;
                        paddingValues4 = paddingValuesM1211PaddingValues0680j_4;
                        z9 = z3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1904835166, i18, i16, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:62)");
                    }
                    i19 = i18 & 14;
                    Function0<LazyStaggeredGridItemProvider> function0RememberStaggeredGridItemProviderLambda3 = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(lazyStaggeredGridState, function1, composerStartRestartGroup, (i16 & 112) | i19);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<GraphicsContext> localGraphicsContext3 = CompositionLocalsKt.getLocalGraphicsContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localGraphicsContext3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i212 = i18 >> 6;
                    int i213 = i18 >> 12;
                    int i214 = ((i18 << 18) & 234881024) | (i212 & 7168) | (i212 & 896) | i19 | ((i18 << 9) & 57344) | (i213 & 458752) | ((i16 << 18) & 3670016);
                    int i215 = i18;
                    z10 = z9;
                    float f9 = fM9687constructorimpl;
                    float f10 = f2;
                    LazyLayoutMeasurePolicy lazyLayoutMeasurePolicyM1481rememberStaggeredGridMeasurePolicyqKj4JfE3 = LazyStaggeredGridMeasurePolicyKt.m1481rememberStaggeredGridMeasurePolicyqKj4JfE(lazyStaggeredGridState, function0RememberStaggeredGridItemProviderLambda3, paddingValues4, z10, orientation, f9, f10, (CoroutineScope) objRememberedValue, lazyGridStaggeredGridSlotsProvider, (GraphicsContext) objConsume3, composerStartRestartGroup, i214);
                    PaddingValues paddingValues7 = paddingValues4;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState3 = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(lazyStaggeredGridState, z10, composerStartRestartGroup, (i213 & 112) | i19);
                    if (z8) {
                        composerStartRestartGroup.startReplaceGroup(-1834596342);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "84@3600L57");
                        companionLazyLayoutBeyondBoundsModifier = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.INSTANCE, LazyStaggeredGridBeyondBoundsModifierKt.rememberLazyStaggeredGridBeyondBoundsState(lazyStaggeredGridState, composerStartRestartGroup, i19), lazyStaggeredGridState.getBeyondBoundsInfo(), z10, orientation);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1834291488);
                        composerStartRestartGroup.endReplaceGroup();
                        companionLazyLayoutBeyondBoundsModifier = Modifier.INSTANCE;
                    }
                    boolean z13 = z8;
                    FlingBehavior flingBehavior7 = flingBehavior4;
                    LazyLayoutKt.LazyLayout(function0RememberStaggeredGridItemProviderLambda3, ScrollableAreaKt.scrollableArea$default(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier4.then(lazyStaggeredGridState.getRemeasurementModifier()).then(lazyStaggeredGridState.getAwaitLayoutModifier()), function0RememberStaggeredGridItemProviderLambda3, lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState3, orientation, z13, z10, composerStartRestartGroup, (i215 & 458752) | ((i215 << 6) & 7168) | ((i215 >> 9) & 57344)).then(companionLazyLayoutBeyondBoundsModifier).then(lazyStaggeredGridState.getItemAnimator$foundation().getModifier()), lazyStaggeredGridState, orientation, overscrollEffect, z13, z10, flingBehavior7, lazyStaggeredGridState.getMutableInteractionSource(), null, 128, null), lazyStaggeredGridState.getPrefetchState(), lazyLayoutMeasurePolicyM1481rememberStaggeredGridMeasurePolicyqKj4JfE3, composerStartRestartGroup, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = composerStartRestartGroup;
                    flingBehavior3 = flingBehavior7;
                    modifier3 = modifier4;
                    z6 = z8;
                    paddingValues3 = paddingValues7;
                    f4 = f9;
                    f3 = f10;
                    z7 = z10;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f3 = f2;
                    flingBehavior3 = flingBehavior2;
                    composer2 = composerStartRestartGroup;
                    z6 = z4;
                    paddingValues3 = paddingValues2;
                    z7 = z3;
                    modifier3 = modifier2;
                    f4 = f;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LazyStaggeredGridKt.LazyStaggeredGrid_w41Enmo$lambda$0(lazyStaggeredGridState, orientation, lazyGridStaggeredGridSlotsProvider, modifier3, paddingValues3, z7, flingBehavior3, z6, overscrollEffect, f4, f3, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            i13 = i3 & 1024;
            if (i13 != 0) {
                i14 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i15 = 4;
                } else {
                    i15 = 2;
                }
                i14 = i2 | i15;
            } else {
                i14 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i20 = 32;
                } else {
                    i20 = 16;
                }
                i14 |= i20;
            }
            i16 = i14;
            i17 = i4;
            if ((i17 & 306783379) == 306783378) {
                z5 = true;
            } else {
                z5 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i17 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "51@2361L15");
                if ((i & 1) != 0) {
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        paddingValuesM1211PaddingValues0680j_4 = PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(0));
                    } else {
                        paddingValuesM1211PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if ((i3 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i18 = i17 & (-3670017);
                    } else {
                        i18 = i17;
                    }
                    if (i9 == 0) {
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f2 = Dp.m9687constructorimpl(0);
                    } else {
                        f2 = f2;
                    }
                    modifier4 = companion;
                    flingBehavior4 = flingBehavior2;
                    paddingValues4 = paddingValuesM1211PaddingValues0680j_4;
                    z9 = z3;
                } else {
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        paddingValuesM1211PaddingValues0680j_4 = PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(0));
                    } else {
                        paddingValuesM1211PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if ((i3 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i18 = i17 & (-3670017);
                    } else {
                        i18 = i17;
                    }
                    if (i9 == 0) {
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f2 = Dp.m9687constructorimpl(0);
                    } else {
                        f2 = f2;
                    }
                    modifier4 = companion;
                    flingBehavior4 = flingBehavior2;
                    paddingValues4 = paddingValuesM1211PaddingValues0680j_4;
                    z9 = z3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1904835166, i18, i16, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:62)");
                }
                i19 = i18 & 14;
                Function0<LazyStaggeredGridItemProvider> function0RememberStaggeredGridItemProviderLambda4 = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(lazyStaggeredGridState, function1, composerStartRestartGroup, (i16 & 112) | i19);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<GraphicsContext> localGraphicsContext4 = CompositionLocalsKt.getLocalGraphicsContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume4 = composerStartRestartGroup.consume(localGraphicsContext4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i216 = i18 >> 6;
                int i217 = i18 >> 12;
                int i218 = ((i18 << 18) & 234881024) | (i216 & 7168) | (i216 & 896) | i19 | ((i18 << 9) & 57344) | (i217 & 458752) | ((i16 << 18) & 3670016);
                int i219 = i18;
                z10 = z9;
                float f11 = fM9687constructorimpl;
                float f12 = f2;
                LazyLayoutMeasurePolicy lazyLayoutMeasurePolicyM1481rememberStaggeredGridMeasurePolicyqKj4JfE4 = LazyStaggeredGridMeasurePolicyKt.m1481rememberStaggeredGridMeasurePolicyqKj4JfE(lazyStaggeredGridState, function0RememberStaggeredGridItemProviderLambda4, paddingValues4, z10, orientation, f11, f12, (CoroutineScope) objRememberedValue, lazyGridStaggeredGridSlotsProvider, (GraphicsContext) objConsume4, composerStartRestartGroup, i218);
                PaddingValues paddingValues8 = paddingValues4;
                LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState4 = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(lazyStaggeredGridState, z10, composerStartRestartGroup, (i217 & 112) | i19);
                if (z8) {
                    composerStartRestartGroup.startReplaceGroup(-1834596342);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "84@3600L57");
                    companionLazyLayoutBeyondBoundsModifier = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.INSTANCE, LazyStaggeredGridBeyondBoundsModifierKt.rememberLazyStaggeredGridBeyondBoundsState(lazyStaggeredGridState, composerStartRestartGroup, i19), lazyStaggeredGridState.getBeyondBoundsInfo(), z10, orientation);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1834291488);
                    composerStartRestartGroup.endReplaceGroup();
                    companionLazyLayoutBeyondBoundsModifier = Modifier.INSTANCE;
                }
                boolean z14 = z8;
                FlingBehavior flingBehavior8 = flingBehavior4;
                LazyLayoutKt.LazyLayout(function0RememberStaggeredGridItemProviderLambda4, ScrollableAreaKt.scrollableArea$default(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier4.then(lazyStaggeredGridState.getRemeasurementModifier()).then(lazyStaggeredGridState.getAwaitLayoutModifier()), function0RememberStaggeredGridItemProviderLambda4, lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState4, orientation, z14, z10, composerStartRestartGroup, (i219 & 458752) | ((i219 << 6) & 7168) | ((i219 >> 9) & 57344)).then(companionLazyLayoutBeyondBoundsModifier).then(lazyStaggeredGridState.getItemAnimator$foundation().getModifier()), lazyStaggeredGridState, orientation, overscrollEffect, z14, z10, flingBehavior8, lazyStaggeredGridState.getMutableInteractionSource(), null, 128, null), lazyStaggeredGridState.getPrefetchState(), lazyLayoutMeasurePolicyM1481rememberStaggeredGridMeasurePolicyqKj4JfE4, composerStartRestartGroup, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = composerStartRestartGroup;
                flingBehavior3 = flingBehavior8;
                modifier3 = modifier4;
                z6 = z8;
                paddingValues3 = paddingValues8;
                f4 = f11;
                f3 = f12;
                z7 = z10;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                f3 = f2;
                flingBehavior3 = flingBehavior2;
                composer2 = composerStartRestartGroup;
                z6 = z4;
                paddingValues3 = paddingValues2;
                z7 = z3;
                modifier3 = modifier2;
                f4 = f;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LazyStaggeredGridKt.LazyStaggeredGrid_w41Enmo$lambda$0(lazyStaggeredGridState, orientation, lazyGridStaggeredGridSlotsProvider, modifier3, paddingValues3, z7, flingBehavior3, z6, overscrollEffect, f4, f3, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        modifier2 = modifier;
        i5 = i3 & 16;
        if (i5 != 0) {
            if ((i & 24576) == 0) {
                paddingValues2 = paddingValues;
                if (composerStartRestartGroup.changed(paddingValues2)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i4 |= i6;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z3 = z;
            } else {
                z3 = z;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i4 |= i8;
                }
            }
            if ((i & 1572864) == 0) {
                flingBehavior2 = flingBehavior;
                if ((i3 & 64) == 0) {
                    i22 = 524288;
                } else {
                    i22 = 524288;
                }
                i4 |= i22;
            } else {
                flingBehavior2 = flingBehavior;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i4 |= 12582912;
                z4 = z2;
            } else {
                z4 = z2;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z4)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(overscrollEffect)) {
                    i21 = 67108864;
                } else {
                    i21 = 33554432;
                }
                i4 |= i21;
            }
            i11 = i3 & 512;
            if (i11 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i12 = 268435456;
                    }
                    i4 |= i12;
                }
                i13 = i3 & 1024;
                if (i13 != 0) {
                    i14 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i15 = 4;
                    } else {
                        i15 = 2;
                    }
                    i14 = i2 | i15;
                } else {
                    i14 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i20 = 32;
                    } else {
                        i20 = 16;
                    }
                    i14 |= i20;
                }
                i16 = i14;
                i17 = i4;
                if ((i17 & 306783379) == 306783378) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i17 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "51@2361L15");
                    if ((i & 1) != 0) {
                        if (i23 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            paddingValuesM1211PaddingValues0680j_4 = PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(0));
                        } else {
                            paddingValuesM1211PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if ((i3 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i18 = i17 & (-3670017);
                        } else {
                            i18 = i17;
                        }
                        if (i9 == 0) {
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f2 = Dp.m9687constructorimpl(0);
                        } else {
                            f2 = f2;
                        }
                        modifier4 = companion;
                        flingBehavior4 = flingBehavior2;
                        paddingValues4 = paddingValuesM1211PaddingValues0680j_4;
                        z9 = z3;
                    } else {
                        if (i23 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            paddingValuesM1211PaddingValues0680j_4 = PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(0));
                        } else {
                            paddingValuesM1211PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if ((i3 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i18 = i17 & (-3670017);
                        } else {
                            i18 = i17;
                        }
                        if (i9 == 0) {
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f2 = Dp.m9687constructorimpl(0);
                        } else {
                            f2 = f2;
                        }
                        modifier4 = companion;
                        flingBehavior4 = flingBehavior2;
                        paddingValues4 = paddingValuesM1211PaddingValues0680j_4;
                        z9 = z3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1904835166, i18, i16, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:62)");
                    }
                    i19 = i18 & 14;
                    Function0<LazyStaggeredGridItemProvider> function0RememberStaggeredGridItemProviderLambda5 = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(lazyStaggeredGridState, function1, composerStartRestartGroup, (i16 & 112) | i19);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<GraphicsContext> localGraphicsContext5 = CompositionLocalsKt.getLocalGraphicsContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume5 = composerStartRestartGroup.consume(localGraphicsContext5);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i2110 = i18 >> 6;
                    int i2111 = i18 >> 12;
                    int i2112 = ((i18 << 18) & 234881024) | (i2110 & 7168) | (i2110 & 896) | i19 | ((i18 << 9) & 57344) | (i2111 & 458752) | ((i16 << 18) & 3670016);
                    int i2113 = i18;
                    z10 = z9;
                    float f13 = fM9687constructorimpl;
                    float f14 = f2;
                    LazyLayoutMeasurePolicy lazyLayoutMeasurePolicyM1481rememberStaggeredGridMeasurePolicyqKj4JfE5 = LazyStaggeredGridMeasurePolicyKt.m1481rememberStaggeredGridMeasurePolicyqKj4JfE(lazyStaggeredGridState, function0RememberStaggeredGridItemProviderLambda5, paddingValues4, z10, orientation, f13, f14, (CoroutineScope) objRememberedValue, lazyGridStaggeredGridSlotsProvider, (GraphicsContext) objConsume5, composerStartRestartGroup, i2112);
                    PaddingValues paddingValues9 = paddingValues4;
                    LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState5 = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(lazyStaggeredGridState, z10, composerStartRestartGroup, (i2111 & 112) | i19);
                    if (z8) {
                        composerStartRestartGroup.startReplaceGroup(-1834596342);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "84@3600L57");
                        companionLazyLayoutBeyondBoundsModifier = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.INSTANCE, LazyStaggeredGridBeyondBoundsModifierKt.rememberLazyStaggeredGridBeyondBoundsState(lazyStaggeredGridState, composerStartRestartGroup, i19), lazyStaggeredGridState.getBeyondBoundsInfo(), z10, orientation);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1834291488);
                        composerStartRestartGroup.endReplaceGroup();
                        companionLazyLayoutBeyondBoundsModifier = Modifier.INSTANCE;
                    }
                    boolean z15 = z8;
                    FlingBehavior flingBehavior9 = flingBehavior4;
                    LazyLayoutKt.LazyLayout(function0RememberStaggeredGridItemProviderLambda5, ScrollableAreaKt.scrollableArea$default(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier4.then(lazyStaggeredGridState.getRemeasurementModifier()).then(lazyStaggeredGridState.getAwaitLayoutModifier()), function0RememberStaggeredGridItemProviderLambda5, lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState5, orientation, z15, z10, composerStartRestartGroup, (i2113 & 458752) | ((i2113 << 6) & 7168) | ((i2113 >> 9) & 57344)).then(companionLazyLayoutBeyondBoundsModifier).then(lazyStaggeredGridState.getItemAnimator$foundation().getModifier()), lazyStaggeredGridState, orientation, overscrollEffect, z15, z10, flingBehavior9, lazyStaggeredGridState.getMutableInteractionSource(), null, 128, null), lazyStaggeredGridState.getPrefetchState(), lazyLayoutMeasurePolicyM1481rememberStaggeredGridMeasurePolicyqKj4JfE5, composerStartRestartGroup, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = composerStartRestartGroup;
                    flingBehavior3 = flingBehavior9;
                    modifier3 = modifier4;
                    z6 = z8;
                    paddingValues3 = paddingValues9;
                    f4 = f13;
                    f3 = f14;
                    z7 = z10;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f3 = f2;
                    flingBehavior3 = flingBehavior2;
                    composer2 = composerStartRestartGroup;
                    z6 = z4;
                    paddingValues3 = paddingValues2;
                    z7 = z3;
                    modifier3 = modifier2;
                    f4 = f;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LazyStaggeredGridKt.LazyStaggeredGrid_w41Enmo$lambda$0(lazyStaggeredGridState, orientation, lazyGridStaggeredGridSlotsProvider, modifier3, paddingValues3, z7, flingBehavior3, z6, overscrollEffect, f4, f3, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            i13 = i3 & 1024;
            if (i13 != 0) {
                i14 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i15 = 4;
                } else {
                    i15 = 2;
                }
                i14 = i2 | i15;
            } else {
                i14 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i20 = 32;
                } else {
                    i20 = 16;
                }
                i14 |= i20;
            }
            i16 = i14;
            i17 = i4;
            if ((i17 & 306783379) == 306783378) {
                z5 = true;
            } else {
                z5 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i17 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "51@2361L15");
                if ((i & 1) != 0) {
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        paddingValuesM1211PaddingValues0680j_4 = PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(0));
                    } else {
                        paddingValuesM1211PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if ((i3 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i18 = i17 & (-3670017);
                    } else {
                        i18 = i17;
                    }
                    if (i9 == 0) {
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f2 = Dp.m9687constructorimpl(0);
                    } else {
                        f2 = f2;
                    }
                    modifier4 = companion;
                    flingBehavior4 = flingBehavior2;
                    paddingValues4 = paddingValuesM1211PaddingValues0680j_4;
                    z9 = z3;
                } else {
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        paddingValuesM1211PaddingValues0680j_4 = PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(0));
                    } else {
                        paddingValuesM1211PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if ((i3 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i18 = i17 & (-3670017);
                    } else {
                        i18 = i17;
                    }
                    if (i9 == 0) {
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f2 = Dp.m9687constructorimpl(0);
                    } else {
                        f2 = f2;
                    }
                    modifier4 = companion;
                    flingBehavior4 = flingBehavior2;
                    paddingValues4 = paddingValuesM1211PaddingValues0680j_4;
                    z9 = z3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1904835166, i18, i16, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:62)");
                }
                i19 = i18 & 14;
                Function0<LazyStaggeredGridItemProvider> function0RememberStaggeredGridItemProviderLambda6 = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(lazyStaggeredGridState, function1, composerStartRestartGroup, (i16 & 112) | i19);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<GraphicsContext> localGraphicsContext6 = CompositionLocalsKt.getLocalGraphicsContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume6 = composerStartRestartGroup.consume(localGraphicsContext6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i2114 = i18 >> 6;
                int i2115 = i18 >> 12;
                int i2116 = ((i18 << 18) & 234881024) | (i2114 & 7168) | (i2114 & 896) | i19 | ((i18 << 9) & 57344) | (i2115 & 458752) | ((i16 << 18) & 3670016);
                int i2117 = i18;
                z10 = z9;
                float f15 = fM9687constructorimpl;
                float f16 = f2;
                LazyLayoutMeasurePolicy lazyLayoutMeasurePolicyM1481rememberStaggeredGridMeasurePolicyqKj4JfE6 = LazyStaggeredGridMeasurePolicyKt.m1481rememberStaggeredGridMeasurePolicyqKj4JfE(lazyStaggeredGridState, function0RememberStaggeredGridItemProviderLambda6, paddingValues4, z10, orientation, f15, f16, (CoroutineScope) objRememberedValue, lazyGridStaggeredGridSlotsProvider, (GraphicsContext) objConsume6, composerStartRestartGroup, i2116);
                PaddingValues paddingValues10 = paddingValues4;
                LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState6 = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(lazyStaggeredGridState, z10, composerStartRestartGroup, (i2115 & 112) | i19);
                if (z8) {
                    composerStartRestartGroup.startReplaceGroup(-1834596342);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "84@3600L57");
                    companionLazyLayoutBeyondBoundsModifier = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.INSTANCE, LazyStaggeredGridBeyondBoundsModifierKt.rememberLazyStaggeredGridBeyondBoundsState(lazyStaggeredGridState, composerStartRestartGroup, i19), lazyStaggeredGridState.getBeyondBoundsInfo(), z10, orientation);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1834291488);
                    composerStartRestartGroup.endReplaceGroup();
                    companionLazyLayoutBeyondBoundsModifier = Modifier.INSTANCE;
                }
                boolean z16 = z8;
                FlingBehavior flingBehavior10 = flingBehavior4;
                LazyLayoutKt.LazyLayout(function0RememberStaggeredGridItemProviderLambda6, ScrollableAreaKt.scrollableArea$default(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier4.then(lazyStaggeredGridState.getRemeasurementModifier()).then(lazyStaggeredGridState.getAwaitLayoutModifier()), function0RememberStaggeredGridItemProviderLambda6, lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState6, orientation, z16, z10, composerStartRestartGroup, (i2117 & 458752) | ((i2117 << 6) & 7168) | ((i2117 >> 9) & 57344)).then(companionLazyLayoutBeyondBoundsModifier).then(lazyStaggeredGridState.getItemAnimator$foundation().getModifier()), lazyStaggeredGridState, orientation, overscrollEffect, z16, z10, flingBehavior10, lazyStaggeredGridState.getMutableInteractionSource(), null, 128, null), lazyStaggeredGridState.getPrefetchState(), lazyLayoutMeasurePolicyM1481rememberStaggeredGridMeasurePolicyqKj4JfE6, composerStartRestartGroup, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = composerStartRestartGroup;
                flingBehavior3 = flingBehavior10;
                modifier3 = modifier4;
                z6 = z8;
                paddingValues3 = paddingValues10;
                f4 = f15;
                f3 = f16;
                z7 = z10;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                f3 = f2;
                flingBehavior3 = flingBehavior2;
                composer2 = composerStartRestartGroup;
                z6 = z4;
                paddingValues3 = paddingValues2;
                z7 = z3;
                modifier3 = modifier2;
                f4 = f;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LazyStaggeredGridKt.LazyStaggeredGrid_w41Enmo$lambda$0(lazyStaggeredGridState, orientation, lazyGridStaggeredGridSlotsProvider, modifier3, paddingValues3, z7, flingBehavior3, z6, overscrollEffect, f4, f3, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        paddingValues2 = paddingValues;
        i7 = i3 & 32;
        if (i7 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z3 = z;
        } else {
            z3 = z;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i4 |= i8;
            }
        }
        if ((i & 1572864) == 0) {
            flingBehavior2 = flingBehavior;
            if ((i3 & 64) == 0) {
                i22 = 524288;
            } else {
                i22 = 524288;
            }
            i4 |= i22;
        } else {
            flingBehavior2 = flingBehavior;
        }
        i9 = i3 & 128;
        if (i9 != 0) {
            i4 |= 12582912;
            z4 = z2;
        } else {
            z4 = z2;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(z4)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i4 |= i10;
            }
        }
        if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changed(overscrollEffect)) {
                i21 = 67108864;
            } else {
                i21 = 33554432;
            }
            i4 |= i21;
        }
        i11 = i3 & 512;
        if (i11 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i12 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i12 = 268435456;
                }
                i4 |= i12;
            }
            i13 = i3 & 1024;
            if (i13 != 0) {
                i14 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i15 = 4;
                } else {
                    i15 = 2;
                }
                i14 = i2 | i15;
            } else {
                i14 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i20 = 32;
                } else {
                    i20 = 16;
                }
                i14 |= i20;
            }
            i16 = i14;
            i17 = i4;
            if ((i17 & 306783379) == 306783378) {
                z5 = true;
            } else {
                z5 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i17 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "51@2361L15");
                if ((i & 1) != 0) {
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        paddingValuesM1211PaddingValues0680j_4 = PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(0));
                    } else {
                        paddingValuesM1211PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if ((i3 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i18 = i17 & (-3670017);
                    } else {
                        i18 = i17;
                    }
                    if (i9 == 0) {
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f2 = Dp.m9687constructorimpl(0);
                    } else {
                        f2 = f2;
                    }
                    modifier4 = companion;
                    flingBehavior4 = flingBehavior2;
                    paddingValues4 = paddingValuesM1211PaddingValues0680j_4;
                    z9 = z3;
                } else {
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        paddingValuesM1211PaddingValues0680j_4 = PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(0));
                    } else {
                        paddingValuesM1211PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if ((i3 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i18 = i17 & (-3670017);
                    } else {
                        i18 = i17;
                    }
                    if (i9 == 0) {
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f2 = Dp.m9687constructorimpl(0);
                    } else {
                        f2 = f2;
                    }
                    modifier4 = companion;
                    flingBehavior4 = flingBehavior2;
                    paddingValues4 = paddingValuesM1211PaddingValues0680j_4;
                    z9 = z3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1904835166, i18, i16, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:62)");
                }
                i19 = i18 & 14;
                Function0<LazyStaggeredGridItemProvider> function0RememberStaggeredGridItemProviderLambda7 = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(lazyStaggeredGridState, function1, composerStartRestartGroup, (i16 & 112) | i19);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<GraphicsContext> localGraphicsContext7 = CompositionLocalsKt.getLocalGraphicsContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localGraphicsContext7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i2118 = i18 >> 6;
                int i2119 = i18 >> 12;
                int i21110 = ((i18 << 18) & 234881024) | (i2118 & 7168) | (i2118 & 896) | i19 | ((i18 << 9) & 57344) | (i2119 & 458752) | ((i16 << 18) & 3670016);
                int i21111 = i18;
                z10 = z9;
                float f17 = fM9687constructorimpl;
                float f18 = f2;
                LazyLayoutMeasurePolicy lazyLayoutMeasurePolicyM1481rememberStaggeredGridMeasurePolicyqKj4JfE7 = LazyStaggeredGridMeasurePolicyKt.m1481rememberStaggeredGridMeasurePolicyqKj4JfE(lazyStaggeredGridState, function0RememberStaggeredGridItemProviderLambda7, paddingValues4, z10, orientation, f17, f18, (CoroutineScope) objRememberedValue, lazyGridStaggeredGridSlotsProvider, (GraphicsContext) objConsume7, composerStartRestartGroup, i21110);
                PaddingValues paddingValues11 = paddingValues4;
                LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState7 = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(lazyStaggeredGridState, z10, composerStartRestartGroup, (i2119 & 112) | i19);
                if (z8) {
                    composerStartRestartGroup.startReplaceGroup(-1834596342);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "84@3600L57");
                    companionLazyLayoutBeyondBoundsModifier = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.INSTANCE, LazyStaggeredGridBeyondBoundsModifierKt.rememberLazyStaggeredGridBeyondBoundsState(lazyStaggeredGridState, composerStartRestartGroup, i19), lazyStaggeredGridState.getBeyondBoundsInfo(), z10, orientation);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1834291488);
                    composerStartRestartGroup.endReplaceGroup();
                    companionLazyLayoutBeyondBoundsModifier = Modifier.INSTANCE;
                }
                boolean z17 = z8;
                FlingBehavior flingBehavior11 = flingBehavior4;
                LazyLayoutKt.LazyLayout(function0RememberStaggeredGridItemProviderLambda7, ScrollableAreaKt.scrollableArea$default(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier4.then(lazyStaggeredGridState.getRemeasurementModifier()).then(lazyStaggeredGridState.getAwaitLayoutModifier()), function0RememberStaggeredGridItemProviderLambda7, lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState7, orientation, z17, z10, composerStartRestartGroup, (i21111 & 458752) | ((i21111 << 6) & 7168) | ((i21111 >> 9) & 57344)).then(companionLazyLayoutBeyondBoundsModifier).then(lazyStaggeredGridState.getItemAnimator$foundation().getModifier()), lazyStaggeredGridState, orientation, overscrollEffect, z17, z10, flingBehavior11, lazyStaggeredGridState.getMutableInteractionSource(), null, 128, null), lazyStaggeredGridState.getPrefetchState(), lazyLayoutMeasurePolicyM1481rememberStaggeredGridMeasurePolicyqKj4JfE7, composerStartRestartGroup, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = composerStartRestartGroup;
                flingBehavior3 = flingBehavior11;
                modifier3 = modifier4;
                z6 = z8;
                paddingValues3 = paddingValues11;
                f4 = f17;
                f3 = f18;
                z7 = z10;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                f3 = f2;
                flingBehavior3 = flingBehavior2;
                composer2 = composerStartRestartGroup;
                z6 = z4;
                paddingValues3 = paddingValues2;
                z7 = z3;
                modifier3 = modifier2;
                f4 = f;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LazyStaggeredGridKt.LazyStaggeredGrid_w41Enmo$lambda$0(lazyStaggeredGridState, orientation, lazyGridStaggeredGridSlotsProvider, modifier3, paddingValues3, z7, flingBehavior3, z6, overscrollEffect, f4, f3, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 805306368;
        i13 = i3 & 1024;
        if (i13 != 0) {
            i14 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changed(f2)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i14 = i2 | i15;
        } else {
            i14 = i2;
        }
        if ((i2 & 48) == 0) {
            if (composerStartRestartGroup.changedInstance(function1)) {
                i20 = 32;
            } else {
                i20 = 16;
            }
            i14 |= i20;
        }
        i16 = i14;
        i17 = i4;
        if ((i17 & 306783379) == 306783378) {
            z5 = true;
        } else {
            z5 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i17 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "51@2361L15");
            if ((i & 1) != 0) {
                if (i23 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    paddingValuesM1211PaddingValues0680j_4 = PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(0));
                } else {
                    paddingValuesM1211PaddingValues0680j_4 = paddingValues2;
                }
                if (i7 != 0) {
                    z3 = false;
                }
                if ((i3 & 64) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i18 = i17 & (-3670017);
                } else {
                    i18 = i17;
                }
                if (i9 == 0) {
                }
                if (i11 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl = f;
                }
                if (i13 != 0) {
                    f2 = Dp.m9687constructorimpl(0);
                } else {
                    f2 = f2;
                }
                modifier4 = companion;
                flingBehavior4 = flingBehavior2;
                paddingValues4 = paddingValuesM1211PaddingValues0680j_4;
                z9 = z3;
            } else {
                if (i23 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    paddingValuesM1211PaddingValues0680j_4 = PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(0));
                } else {
                    paddingValuesM1211PaddingValues0680j_4 = paddingValues2;
                }
                if (i7 != 0) {
                    z3 = false;
                }
                if ((i3 & 64) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i18 = i17 & (-3670017);
                } else {
                    i18 = i17;
                }
                if (i9 == 0) {
                }
                if (i11 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl = f;
                }
                if (i13 != 0) {
                    f2 = Dp.m9687constructorimpl(0);
                } else {
                    f2 = f2;
                }
                modifier4 = companion;
                flingBehavior4 = flingBehavior2;
                paddingValues4 = paddingValuesM1211PaddingValues0680j_4;
                z9 = z3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1904835166, i18, i16, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:62)");
            }
            i19 = i18 & 14;
            Function0<LazyStaggeredGridItemProvider> function0RememberStaggeredGridItemProviderLambda8 = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(lazyStaggeredGridState, function1, composerStartRestartGroup, (i16 & 112) | i19);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<GraphicsContext> localGraphicsContext8 = CompositionLocalsKt.getLocalGraphicsContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume8 = composerStartRestartGroup.consume(localGraphicsContext8);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i21112 = i18 >> 6;
            int i21113 = i18 >> 12;
            int i21114 = ((i18 << 18) & 234881024) | (i21112 & 7168) | (i21112 & 896) | i19 | ((i18 << 9) & 57344) | (i21113 & 458752) | ((i16 << 18) & 3670016);
            int i21115 = i18;
            z10 = z9;
            float f19 = fM9687constructorimpl;
            float f110 = f2;
            LazyLayoutMeasurePolicy lazyLayoutMeasurePolicyM1481rememberStaggeredGridMeasurePolicyqKj4JfE8 = LazyStaggeredGridMeasurePolicyKt.m1481rememberStaggeredGridMeasurePolicyqKj4JfE(lazyStaggeredGridState, function0RememberStaggeredGridItemProviderLambda8, paddingValues4, z10, orientation, f19, f110, (CoroutineScope) objRememberedValue, lazyGridStaggeredGridSlotsProvider, (GraphicsContext) objConsume8, composerStartRestartGroup, i21114);
            PaddingValues paddingValues12 = paddingValues4;
            LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState8 = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(lazyStaggeredGridState, z10, composerStartRestartGroup, (i21113 & 112) | i19);
            if (z8) {
                composerStartRestartGroup.startReplaceGroup(-1834596342);
                ComposerKt.sourceInformation(composerStartRestartGroup, "84@3600L57");
                companionLazyLayoutBeyondBoundsModifier = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.INSTANCE, LazyStaggeredGridBeyondBoundsModifierKt.rememberLazyStaggeredGridBeyondBoundsState(lazyStaggeredGridState, composerStartRestartGroup, i19), lazyStaggeredGridState.getBeyondBoundsInfo(), z10, orientation);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1834291488);
                composerStartRestartGroup.endReplaceGroup();
                companionLazyLayoutBeyondBoundsModifier = Modifier.INSTANCE;
            }
            boolean z18 = z8;
            FlingBehavior flingBehavior12 = flingBehavior4;
            LazyLayoutKt.LazyLayout(function0RememberStaggeredGridItemProviderLambda8, ScrollableAreaKt.scrollableArea$default(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier4.then(lazyStaggeredGridState.getRemeasurementModifier()).then(lazyStaggeredGridState.getAwaitLayoutModifier()), function0RememberStaggeredGridItemProviderLambda8, lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState8, orientation, z18, z10, composerStartRestartGroup, (i21115 & 458752) | ((i21115 << 6) & 7168) | ((i21115 >> 9) & 57344)).then(companionLazyLayoutBeyondBoundsModifier).then(lazyStaggeredGridState.getItemAnimator$foundation().getModifier()), lazyStaggeredGridState, orientation, overscrollEffect, z18, z10, flingBehavior12, lazyStaggeredGridState.getMutableInteractionSource(), null, 128, null), lazyStaggeredGridState.getPrefetchState(), lazyLayoutMeasurePolicyM1481rememberStaggeredGridMeasurePolicyqKj4JfE8, composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer2 = composerStartRestartGroup;
            flingBehavior3 = flingBehavior12;
            modifier3 = modifier4;
            z6 = z8;
            paddingValues3 = paddingValues12;
            f4 = f19;
            f3 = f110;
            z7 = z10;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            f3 = f2;
            flingBehavior3 = flingBehavior2;
            composer2 = composerStartRestartGroup;
            z6 = z4;
            paddingValues3 = paddingValues2;
            z7 = z3;
            modifier3 = modifier2;
            f4 = f;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LazyStaggeredGridKt.LazyStaggeredGrid_w41Enmo$lambda$0(lazyStaggeredGridState, orientation, lazyGridStaggeredGridSlotsProvider, modifier3, paddingValues3, z7, flingBehavior3, z6, overscrollEffect, f4, f3, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
