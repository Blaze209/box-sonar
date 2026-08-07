package com.box.android.base.compose;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Scrollbar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\u001aW\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001aK\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001aS\u0010\u0019\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e²\u0006\n\u0010\u0016\u001a\u00020\u0014X\u008a\u0084\u0002"}, d2 = {"scrollbar", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "horizontal", "", "thickness", "Landroidx/compose/ui/unit/Dp;", "knobCornerRadius", "trackCornerRadius", "knobColor", "Landroidx/compose/ui/graphics/Color;", "trackColor", "scrollbar-eCwULMo", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;ZFFFJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "drawTrack", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "alignEnd", "paddingPx", "", "thicknessPx", "alpha", "drawTrack-NQfcU-E", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JZZFFFF)V", "drawKnob", "knobPosition", "knobSize", "drawKnob-XIun1Us", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JZZFFFFF)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ScrollbarKt {
    /* JADX INFO: renamed from: scrollbar-eCwULMo, reason: not valid java name */
    public static final Modifier m11661scrollbareCwULMo(Modifier scrollbar, final LazyListState state, boolean z, float f, float f2, float f3, long j, long j2, Composer composer, int i, int i2) {
        Composer composer2;
        Intrinsics.checkNotNullParameter(scrollbar, "$this$scrollbar");
        Intrinsics.checkNotNullParameter(state, "state");
        ComposerKt.sourceInformationMarkerStart(composer, -1483985475, "C(scrollbar)N(state,horizontal,thickness:c#ui.unit.Dp,knobCornerRadius:c#ui.unit.Dp,trackCornerRadius:c#ui.unit.Dp,knobColor:c#ui.graphics.Color,trackColor:c#ui.graphics.Color)63@3461L6,64@3538L6,97@5010L181,102@5220L6,103@5269L6,105@5314L2743:Scrollbar.kt#vejmn0");
        boolean z2 = (i2 & 2) != 0 ? false : z;
        float fM9687constructorimpl = (i2 & 4) != 0 ? Dp.m9687constructorimpl(4) : f;
        final float fM9687constructorimpl2 = (i2 & 8) != 0 ? Dp.m9687constructorimpl(1) : f2;
        float fM9687constructorimpl3 = (i2 & 16) != 0 ? Dp.m9687constructorimpl(2) : f3;
        long jM6813copywmQWz5c$default = (i2 & 32) != 0 ? Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, 6).m11513getContentSecondary0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null) : j;
        long jM11498getAppBackground0d7_KjU = (i2 & 64) != 0 ? BoxTheme.INSTANCE.getColors(composer, 6).m11498getAppBackground0d7_KjU() : j2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1483985475, i, -1, "com.box.android.base.compose.scrollbar (Scrollbar.kt:65)");
        }
        float f4 = 0;
        float fM9687constructorimpl4 = Dp.m9687constructorimpl(f4);
        if (Dp.m9686compareTo0680j_4(fM9687constructorimpl, Dp.m9687constructorimpl(f4)) <= 0) {
            throw new IllegalStateException("Thickness must be a positive integer.".toString());
        }
        if (Dp.m9686compareTo0680j_4(fM9687constructorimpl2, Dp.m9687constructorimpl(f4)) < 0) {
            throw new IllegalStateException("Knob corner radius must be greater than or equal to 0.".toString());
        }
        if (Dp.m9686compareTo0680j_4(fM9687constructorimpl3, Dp.m9687constructorimpl(f4)) < 0) {
            throw new IllegalStateException("Track corner radius must be greater than or equal to 0.".toString());
        }
        Float fValueOf = Float.valueOf(1.0f);
        fValueOf.floatValue();
        if (!state.isScrollInProgress()) {
            fValueOf = null;
        }
        float fFloatValue = fValueOf != null ? fValueOf.floatValue() : 0.0f;
        Integer num = 150;
        num.intValue();
        num = state.isScrollInProgress() ? 150 : null;
        int iIntValue = num != null ? num.intValue() : 500;
        Integer num2 = 0;
        num2.intValue();
        num2 = state.isScrollInProgress() ? 0 : null;
        final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(fFloatValue, AnimationSpecKt.tween$default(iIntValue, num2 != null ? num2.intValue() : 1000, null, 4, null), 0.0f, "", null, composer, 3072, 20);
        final float fM11638toPx8Feqmps = ComposeUtilsKt.m11638toPx8Feqmps(fM9687constructorimpl4, composer, 6);
        final float fM11638toPx8Feqmps2 = ComposeUtilsKt.m11638toPx8Feqmps(fM9687constructorimpl, composer, (i >> 9) & 14);
        ComposerKt.sourceInformationMarkerStart(composer, -180830508, "CC(remember):Scrollbar.kt#9igjgp");
        boolean zChanged = ((((i & 896) ^ 384) > 256 && composer.changed(z2)) || (i & 384) == 256) | ((((i & 112) ^ 48) > 32 && composer.changed(state)) || (i & 48) == 32) | composer.changed(stateAnimateFloatAsState) | composer.changed(fM11638toPx8Feqmps) | ((((29360128 & i) ^ 12582912) > 8388608 && composer.changed(jM11498getAppBackground0d7_KjU)) || (i & 12582912) == 8388608) | composer.changed(fM11638toPx8Feqmps2) | ((((458752 & i) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072 && composer.changed(fM9687constructorimpl3)) || (i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | ((((3670016 & i) ^ 1572864) > 1048576 && composer.changed(jM6813copywmQWz5c$default)) || (i & 1572864) == 1048576) | ((((57344 & i) ^ 24576) > 16384 && composer.changed(fM9687constructorimpl2)) || (i & 24576) == 16384);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            final Float f5 = null;
            final boolean z3 = true;
            final boolean z4 = z2;
            final long j3 = jM6813copywmQWz5c$default;
            composer2 = composer;
            final float f6 = fM9687constructorimpl3;
            final long j4 = jM11498getAppBackground0d7_KjU;
            Function1 function1 = new Function1() { // from class: com.box.android.base.compose.ScrollbarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ScrollbarKt.scrollbar_eCwULMo$lambda$12$0(state, z4, fM11638toPx8Feqmps, f5, j4, z3, fM11638toPx8Feqmps2, f6, j3, fM9687constructorimpl2, stateAnimateFloatAsState, (ContentDrawScope) obj);
                }
            };
            composer2.updateRememberedValue(function1);
            objRememberedValue = function1;
        } else {
            composer2 = composer;
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        Modifier modifierDrawWithContent = DrawModifierKt.drawWithContent(scrollbar, (Function1) objRememberedValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return modifierDrawWithContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit scrollbar_eCwULMo$lambda$12$0(LazyListState lazyListState, boolean z, float f, Float f2, long j, boolean z2, float f3, float f4, long j2, float f5, State state, ContentDrawScope drawWithContent) {
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        drawWithContent.drawContent();
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt.firstOrNull((List) lazyListState.getLayoutInfo().getVisibleItemsInfo());
        if (lazyListItemInfo != null && (lazyListState.isScrollInProgress() || scrollbar_eCwULMo$lambda$11(state) > 0.0f)) {
            long j3 = drawWithContent.mo7395getSizeNHjbRc();
            float fIntBitsToFloat = Float.intBitsToFloat((int) (z ? j3 >> 32 : j3 & 4294967295L)) - (2 * f);
            int size = lazyListItemInfo.getSize();
            int totalItemsCount = lazyListState.getLayoutInfo().getTotalItemsCount() * size;
            int firstVisibleItemIndex = (lazyListState.getFirstVisibleItemIndex() * size) + lazyListState.getFirstVisibleItemScrollOffset();
            float f6 = totalItemsCount;
            float f7 = ((fIntBitsToFloat / f6) * firstVisibleItemIndex) + f;
            float fFloatValue = f2 != null ? f2.floatValue() * fIntBitsToFloat : (fIntBitsToFloat * fIntBitsToFloat) / f6;
            ContentDrawScope contentDrawScope = drawWithContent;
            m11660drawTrackNQfcUE(contentDrawScope, j, z, z2, f, f3, scrollbar_eCwULMo$lambda$11(state), f4);
            m11659drawKnobXIun1Us(contentDrawScope, j2, z, z2, f7, fFloatValue, f3, scrollbar_eCwULMo$lambda$11(state), f5);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawTrack-NQfcU-E, reason: not valid java name */
    private static final void m11660drawTrackNQfcUE(DrawScope drawScope, long j, boolean z, boolean z2, float f, float f2, float f3, float f4) {
        long jM6561constructorimpl;
        long jM6629constructorimpl;
        if (z && z2) {
            jM6561constructorimpl = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() & 4294967295L)) - f2)) & 4294967295L));
        } else if (z && !z2) {
            jM6561constructorimpl = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
        } else if (z2) {
            jM6561constructorimpl = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() >> 32)) - f2)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L));
        } else {
            jM6561constructorimpl = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L));
        }
        if (z) {
            jM6629constructorimpl = Size.m6629constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() >> 32)) - (2 * f))) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
        } else {
            jM6629constructorimpl = Size.m6629constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() & 4294967295L)) - (2 * f))) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32));
        }
        DrawScope.m7391drawRoundRectuAw5IA$default(drawScope, j, jM6561constructorimpl, jM6629constructorimpl, CornerRadius.m6523constructorimpl((((long) Float.floatToRawIntBits(drawScope.mo754toPx0680j_4(f4))) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(drawScope.mo754toPx0680j_4(f4))))), null, f3, null, 0, 208, null);
    }

    /* JADX INFO: renamed from: drawKnob-XIun1Us, reason: not valid java name */
    private static final void m11659drawKnobXIun1Us(DrawScope drawScope, long j, boolean z, boolean z2, float f, float f2, float f3, float f4, float f5) {
        long jM6561constructorimpl;
        long jM6629constructorimpl;
        if (z && z2) {
            float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() & 4294967295L)) - f3;
            jM6561constructorimpl = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L));
        } else if (z && !z2) {
            jM6561constructorimpl = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
        } else if (z2) {
            jM6561constructorimpl = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() >> 32)) - f3)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L));
        } else {
            jM6561constructorimpl = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L));
        }
        if (z) {
            jM6629constructorimpl = Size.m6629constructorimpl((((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L));
        } else {
            jM6629constructorimpl = Size.m6629constructorimpl((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
        }
        float f6 = drawScope.mo754toPx0680j_4(f5);
        float f7 = drawScope.mo754toPx0680j_4(f5);
        DrawScope.m7391drawRoundRectuAw5IA$default(drawScope, j, jM6561constructorimpl, jM6629constructorimpl, CornerRadius.m6523constructorimpl((((long) Float.floatToRawIntBits(f6)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(f7)))), null, f4, null, 0, 208, null);
    }

    private static final float scrollbar_eCwULMo$lambda$11(State<Float> state) {
        return state.getValue().floatValue();
    }
}
