package androidx.compose.foundation.pager;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollableAreaKt;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.data.api.models.annotations.Location;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.reflect.KProperty0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: LazyLayoutPager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aå\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$21\u0010%\u001a-\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010&¢\u0006\u0002\b)¢\u0006\u0002\b*H\u0001¢\u0006\u0004\b+\u0010,\u001a\u0081\u0001\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010\u0004\u001a\u00020\u000521\u0010%\u001a-\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010&¢\u0006\u0002\b)¢\u0006\u0002\b*2#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00120.H\u0003¢\u0006\u0002\u00101\u001a\u0014\u00102\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u00063"}, d2 = {"Pager", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", Location.TYPE_PAGE, "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Pager-eLwUrMk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;IFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "rememberPagerItemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "pageCount", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "dragDirectionDetector", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutPagerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Pager_eLwUrMk$lambda$5(Modifier modifier, PagerState pagerState, PaddingValues paddingValues, boolean z, Orientation orientation, TargetedFlingBehavior targetedFlingBehavior, boolean z2, OverscrollEffect overscrollEffect, int i, float f, PageSize pageSize, NestedScrollConnection nestedScrollConnection, Function1 function1, Alignment.Horizontal horizontal, Alignment.Vertical vertical, SnapPosition snapPosition, Function4 function4, int i2, int i3, int i4, Composer composer, int i5) {
        m1504PagereLwUrMk(modifier, pagerState, paddingValues, z, orientation, targetedFlingBehavior, z2, overscrollEffect, i, f, pageSize, nestedScrollConnection, function1, horizontal, vertical, snapPosition, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0135  */
    /* JADX WARN: Code duplicated, block: B:102:0x013a  */
    /* JADX WARN: Code duplicated, block: B:105:0x0140  */
    /* JADX WARN: Code duplicated, block: B:108:0x0149  */
    /* JADX WARN: Code duplicated, block: B:110:0x014e  */
    /* JADX WARN: Code duplicated, block: B:113:0x0154  */
    /* JADX WARN: Code duplicated, block: B:115:0x015c  */
    /* JADX WARN: Code duplicated, block: B:116:0x015f  */
    /* JADX WARN: Code duplicated, block: B:118:0x0164  */
    /* JADX WARN: Code duplicated, block: B:121:0x016c  */
    /* JADX WARN: Code duplicated, block: B:123:0x0172  */
    /* JADX WARN: Code duplicated, block: B:124:0x0175  */
    /* JADX WARN: Code duplicated, block: B:128:0x017f  */
    /* JADX WARN: Code duplicated, block: B:130:0x0185  */
    /* JADX WARN: Code duplicated, block: B:131:0x0188  */
    /* JADX WARN: Code duplicated, block: B:139:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:143:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:144:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:146:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:147:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:150:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:152:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:153:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:155:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:158:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:159:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:164:0x020c  */
    /* JADX WARN: Code duplicated, block: B:167:0x025f  */
    /* JADX WARN: Code duplicated, block: B:170:0x027a  */
    /* JADX WARN: Code duplicated, block: B:171:0x027d  */
    /* JADX WARN: Code duplicated, block: B:176:0x028c  */
    /* JADX WARN: Code duplicated, block: B:179:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:180:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:183:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:184:0x0301  */
    /* JADX WARN: Code duplicated, block: B:187:0x0308  */
    /* JADX WARN: Code duplicated, block: B:188:0x030b  */
    /* JADX WARN: Code duplicated, block: B:195:0x031f  */
    /* JADX WARN: Code duplicated, block: B:198:0x0353  */
    /* JADX WARN: Code duplicated, block: B:199:0x0356  */
    /* JADX WARN: Code duplicated, block: B:204:0x036a  */
    /* JADX WARN: Code duplicated, block: B:207:0x0379  */
    /* JADX WARN: Code duplicated, block: B:208:0x039d  */
    /* JADX WARN: Code duplicated, block: B:211:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:212:0x03e5  */
    /* JADX WARN: Code duplicated, block: B:215:0x0427  */
    /* JADX WARN: Code duplicated, block: B:217:0x042d  */
    /* JADX WARN: Code duplicated, block: B:220:0x043c  */
    /* JADX WARN: Code duplicated, block: B:222:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:78:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:79:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:83:0x0108  */
    /* JADX WARN: Code duplicated, block: B:85:0x010e  */
    /* JADX WARN: Code duplicated, block: B:86:0x0111  */
    /* JADX WARN: Code duplicated, block: B:88:0x0116  */
    /* JADX WARN: Code duplicated, block: B:91:0x011c  */
    /* JADX WARN: Code duplicated, block: B:93:0x0122  */
    /* JADX WARN: Code duplicated, block: B:94:0x0125  */
    /* JADX WARN: Code duplicated, block: B:98:0x012d  */
    /* JADX INFO: renamed from: Pager-eLwUrMk, reason: not valid java name */
    public static final void m1504PagereLwUrMk(final Modifier modifier, final PagerState pagerState, final PaddingValues paddingValues, final boolean z, final Orientation orientation, final TargetedFlingBehavior targetedFlingBehavior, final boolean z2, final OverscrollEffect overscrollEffect, int i, float f, final PageSize pageSize, NestedScrollConnection nestedScrollConnection, final Function1<? super Integer, ? extends Object> function1, final Alignment.Horizontal horizontal, final Alignment.Vertical vertical, final SnapPosition snapPosition, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        int i6;
        float f2;
        int i7;
        int i8;
        int i9;
        boolean z3;
        PagerState pagerState2;
        NestedScrollConnection nestedScrollConnection2;
        Composer composer2;
        final int i10;
        final float f3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        float fM9687constructorimpl;
        boolean z4;
        int i12;
        boolean z5;
        Object objRememberedValue;
        int i13;
        int i14;
        int i15;
        Object objRememberedValue2;
        boolean z6;
        Object objRememberedValue3;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        Object objRememberedValue4;
        BringIntoViewSpec bringIntoViewSpec;
        boolean z11;
        boolean zChanged;
        Object objRememberedValue5;
        Modifier.Companion companionLazyLayoutBeyondBoundsModifier;
        boolean z12;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        Composer composerStartRestartGroup = composer.startRestartGroup(-572816025);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Pager)N(modifier,state,contentPadding,reverseLayout,orientation,flingBehavior,userScrollEnabled,overscrollEffect,beyondViewportPageCount,pageSpacing:c#ui.unit.Dp,pageSize,pageNestedScrollConnection,key,horizontalAlignment,verticalAlignment,snapPosition,pageContent)109@5362L39,109@5277L124,113@5428L24,129@6071L19,116@5486L615,132@6127L70,135@6239L82,137@6381L7,139@6430L121,164@7268L301,159@7099L1450:LazyLayoutPager.kt#g6yjnt");
        if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(pagerState) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i5 |= composerStartRestartGroup.changed(paddingValues) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i5 |= composerStartRestartGroup.changed(orientation.ordinal()) ? 16384 : 8192;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i5 |= composerStartRestartGroup.changed(targetedFlingBehavior) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i5 |= composerStartRestartGroup.changed(z2) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i5 |= composerStartRestartGroup.changed(overscrollEffect) ? 8388608 : 4194304;
        }
        int i21 = i4 & 256;
        if (i21 == 0) {
            if ((i2 & 100663296) == 0) {
                i5 |= composerStartRestartGroup.changed(i) ? 67108864 : 33554432;
            }
            i6 = i4 & 512;
            if (i6 != 0) {
                i5 |= 805306368;
                f2 = f;
            } else {
                f2 = f;
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i7 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i7 = 268435456;
                    }
                    i5 |= i7;
                }
            }
            if ((i3 & 6) == 0) {
                if (composerStartRestartGroup.changed(pageSize)) {
                    i20 = 4;
                } else {
                    i20 = 2;
                }
                i8 = i3 | i20;
            } else {
                i8 = i3;
            }
            if ((i3 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(nestedScrollConnection)) {
                    i19 = 32;
                } else {
                    i19 = 16;
                }
                i8 |= i19;
            }
            if ((i3 & 384) != 0) {
                i8 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
            }
            if ((i3 & 3072) != 0) {
                i8 |= composerStartRestartGroup.changed(horizontal) ? 2048 : 1024;
            }
            if ((i3 & 24576) != 0) {
                if (composerStartRestartGroup.changed(vertical)) {
                    i18 = 16384;
                } else {
                    i18 = 8192;
                }
                i8 |= i18;
            }
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(snapPosition)) {
                    i17 = 131072;
                } else {
                    i17 = 65536;
                }
                i8 |= i17;
            }
            if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i8 |= i16;
            }
            i9 = i8;
            if ((i5 & 306783379) == 306783378 || (599187 & i9) != 599186) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                pagerState2 = pagerState;
                nestedScrollConnection2 = nestedScrollConnection;
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                i10 = i;
                f3 = f2;
            } else {
                if (i21 != 0) {
                    i11 = 0;
                } else {
                    i11 = i;
                }
                if (i6 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl = f2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-572816025, i5, i9, "androidx.compose.foundation.pager.Pager (LazyLayoutPager.kt:102)");
                }
                if (i11 >= 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (!z4) {
                    InlineClassHelperKt.throwIllegalArgumentException("beyondViewportPageCount should be greater than or equal to 0, you selected " + i11);
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720319826, "CC(remember):LazyLayoutPager.kt#9igjgp");
                i12 = i5 & 112;
                if (i12 == 32) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Integer.valueOf(pagerState.getPageCount());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i22 = i5 >> 3;
                i13 = i22 & 14;
                int i23 = i9 >> 15;
                i14 = i5;
                i15 = i11;
                Function0<PagerLazyLayoutItemProvider> function0RememberPagerItemProviderLambda = rememberPagerItemProviderLambda(pagerState, function4, function1, function0, composerStartRestartGroup, i13 | (i23 & 112) | (i9 & 896));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720297158, "CC(remember):LazyLayoutPager.kt#9igjgp");
                if (i12 == 32) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z6 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Integer.valueOf(pagerState.getPageCount());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i24 = i14 >> 9;
                int i25 = i9 << 15;
                LazyLayoutMeasurePolicy lazyLayoutMeasurePolicyM1520rememberPagerMeasurePolicy8u0NR3k = PagerMeasurePolicyKt.m1520rememberPagerMeasurePolicy8u0NR3k(function0RememberPagerItemProviderLambda, pagerState, paddingValues, z, orientation, i15, fM9687constructorimpl, pageSize, horizontal, vertical, snapPosition, coroutineScope, (Function0) objRememberedValue3, composerStartRestartGroup, (i14 & 65520) | (i24 & 458752) | (i24 & 3670016) | ((i9 << 21) & 29360128) | (i25 & 234881024) | (i25 & C.ENCODING_PCM_DOUBLE), i23 & 14);
                pagerState2 = pagerState;
                float f4 = fM9687constructorimpl;
                if (orientation == Orientation.Vertical) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                LazyLayoutSemanticState lazyLayoutSemanticStateRememberPagerSemanticState = PagerSemanticsKt.rememberPagerSemanticState(pagerState2, z7, composerStartRestartGroup, i13);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720291719, "CC(remember):LazyLayoutPager.kt#9igjgp");
                if (i12 == 32) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if ((i14 & 458752) == 131072) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                z10 = z8 | z9;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!z10 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new PagerWrapperFlingBehavior(targetedFlingBehavior, pagerState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                PagerWrapperFlingBehavior pagerWrapperFlingBehavior = (PagerWrapperFlingBehavior) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<BringIntoViewSpec> localBringIntoViewSpec = BringIntoViewSpec_androidKt.getLocalBringIntoViewSpec();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localBringIntoViewSpec);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                bringIntoViewSpec = (BringIntoViewSpec) objConsume;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720285568, "CC(remember):LazyLayoutPager.kt#9igjgp");
                if (i12 == 32) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                zChanged = z11 | composerStartRestartGroup.changed(bringIntoViewSpec);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new PagerBringIntoViewSpec(pagerState2, bringIntoViewSpec);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                PagerBringIntoViewSpec pagerBringIntoViewSpec = (PagerBringIntoViewSpec) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z2) {
                    composerStartRestartGroup.startReplaceGroup(-853822717);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "147@6714L167");
                    companionLazyLayoutBeyondBoundsModifier = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.INSTANCE, PagerBeyondBoundsModifierKt.rememberPagerBeyondBoundsState(pagerState2, i15, composerStartRestartGroup, ((i14 >> 21) & 112) | i13), pagerState2.getBeyondBoundsInfo(), z, orientation);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-853392933);
                    composerStartRestartGroup.endReplaceGroup();
                    companionLazyLayoutBeyondBoundsModifier = Modifier.INSTANCE;
                }
                Modifier modifierLazyLayoutSemantics = LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(pagerState2.getRemeasurementModifier()).then(pagerState2.getAwaitLayoutModifier()), function0RememberPagerItemProviderLambda, lazyLayoutSemanticStateRememberPagerSemanticState, orientation, z2, z, composerStartRestartGroup, ((i14 << 6) & 458752) | (i22 & 7168) | ((i14 >> 6) & 57344));
                if (orientation == Orientation.Vertical) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                Modifier modifierDragDirectionDetector = dragDirectionDetector(ScrollableAreaKt.scrollableArea(PagerKt.pagerSemantics(modifierLazyLayoutSemantics, pagerState2, z12, coroutineScope, z2).then(companionLazyLayoutBeyondBoundsModifier), pagerState2, orientation, overscrollEffect, z2, z, pagerWrapperFlingBehavior, pagerState2.getInternalInteractionSource(), pagerBringIntoViewSpec), pagerState2);
                nestedScrollConnection2 = nestedScrollConnection;
                LazyLayoutKt.LazyLayout(function0RememberPagerItemProviderLambda, NestedScrollModifierKt.nestedScroll$default(modifierDragDirectionDetector, nestedScrollConnection2, null, 2, null), pagerState2.getPrefetchState(), lazyLayoutMeasurePolicyM1520rememberPagerMeasurePolicy8u0NR3k, composerStartRestartGroup, 0, 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f3 = f4;
                i10 = i15;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final NestedScrollConnection nestedScrollConnection3 = nestedScrollConnection2;
                final PagerState pagerState3 = pagerState2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LazyLayoutPagerKt.Pager_eLwUrMk$lambda$5(modifier, pagerState3, paddingValues, z, orientation, targetedFlingBehavior, z2, overscrollEffect, i10, f3, pageSize, nestedScrollConnection3, function1, horizontal, vertical, snapPosition, function4, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 100663296;
        i6 = i4 & 512;
        if (i6 != 0) {
            i5 |= 805306368;
            f2 = f;
        } else {
            f2 = f;
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i7 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i7 = 268435456;
                }
                i5 |= i7;
            }
        }
        if ((i3 & 6) == 0) {
            if (composerStartRestartGroup.changed(pageSize)) {
                i20 = 4;
            } else {
                i20 = 2;
            }
            i8 = i3 | i20;
        } else {
            i8 = i3;
        }
        if ((i3 & 48) == 0) {
            if (composerStartRestartGroup.changedInstance(nestedScrollConnection)) {
                i19 = 32;
            } else {
                i19 = 16;
            }
            i8 |= i19;
        }
        if ((i3 & 384) != 0) {
            i8 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i3 & 3072) != 0) {
            i8 |= composerStartRestartGroup.changed(horizontal) ? 2048 : 1024;
        }
        if ((i3 & 24576) != 0) {
            if (composerStartRestartGroup.changed(vertical)) {
                i18 = 16384;
            } else {
                i18 = 8192;
            }
            i8 |= i18;
        }
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changed(snapPosition)) {
                i17 = 131072;
            } else {
                i17 = 65536;
            }
            i8 |= i17;
        }
        if ((i3 & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i16 = 1048576;
            } else {
                i16 = 524288;
            }
            i8 |= i16;
        }
        i9 = i8;
        if ((i5 & 306783379) == 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
            pagerState2 = pagerState;
            nestedScrollConnection2 = nestedScrollConnection;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            i10 = i;
            f3 = f2;
        } else {
            if (i21 != 0) {
                i11 = 0;
            } else {
                i11 = i;
            }
            if (i6 != 0) {
                fM9687constructorimpl = Dp.m9687constructorimpl(0);
            } else {
                fM9687constructorimpl = f2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-572816025, i5, i9, "androidx.compose.foundation.pager.Pager (LazyLayoutPager.kt:102)");
            }
            if (i11 >= 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                InlineClassHelperKt.throwIllegalArgumentException("beyondViewportPageCount should be greater than or equal to 0, you selected " + i11);
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720319826, "CC(remember):LazyLayoutPager.kt#9igjgp");
            i12 = i5 & 112;
            if (i12 == 32) {
                z5 = true;
            } else {
                z5 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z5) {
                objRememberedValue = new Function0() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(pagerState.getPageCount());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(pagerState.getPageCount());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function0 function2 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i26 = i5 >> 3;
            i13 = i26 & 14;
            int i27 = i9 >> 15;
            i14 = i5;
            i15 = i11;
            Function0<PagerLazyLayoutItemProvider> function0RememberPagerItemProviderLambda2 = rememberPagerItemProviderLambda(pagerState, function4, function1, function2, composerStartRestartGroup, i13 | (i27 & 112) | (i9 & 896));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720297158, "CC(remember):LazyLayoutPager.kt#9igjgp");
            if (i12 == 32) {
                z6 = true;
            } else {
                z6 = false;
            }
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!z6) {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(pagerState.getPageCount());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(pagerState.getPageCount());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i28 = i14 >> 9;
            int i29 = i9 << 15;
            LazyLayoutMeasurePolicy lazyLayoutMeasurePolicyM1520rememberPagerMeasurePolicy8u0NR3k2 = PagerMeasurePolicyKt.m1520rememberPagerMeasurePolicy8u0NR3k(function0RememberPagerItemProviderLambda2, pagerState, paddingValues, z, orientation, i15, fM9687constructorimpl, pageSize, horizontal, vertical, snapPosition, coroutineScope2, (Function0) objRememberedValue3, composerStartRestartGroup, (i14 & 65520) | (i28 & 458752) | (i28 & 3670016) | ((i9 << 21) & 29360128) | (i29 & 234881024) | (i29 & C.ENCODING_PCM_DOUBLE), i27 & 14);
            pagerState2 = pagerState;
            float f5 = fM9687constructorimpl;
            if (orientation == Orientation.Vertical) {
                z7 = true;
            } else {
                z7 = false;
            }
            LazyLayoutSemanticState lazyLayoutSemanticStateRememberPagerSemanticState2 = PagerSemanticsKt.rememberPagerSemanticState(pagerState2, z7, composerStartRestartGroup, i13);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720291719, "CC(remember):LazyLayoutPager.kt#9igjgp");
            if (i12 == 32) {
                z8 = true;
            } else {
                z8 = false;
            }
            if ((i14 & 458752) == 131072) {
                z9 = true;
            } else {
                z9 = false;
            }
            z10 = z8 | z9;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!z10) {
                objRememberedValue4 = new PagerWrapperFlingBehavior(targetedFlingBehavior, pagerState2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new PagerWrapperFlingBehavior(targetedFlingBehavior, pagerState2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            PagerWrapperFlingBehavior pagerWrapperFlingBehavior2 = (PagerWrapperFlingBehavior) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<BringIntoViewSpec> localBringIntoViewSpec2 = BringIntoViewSpec_androidKt.getLocalBringIntoViewSpec();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localBringIntoViewSpec2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            bringIntoViewSpec = (BringIntoViewSpec) objConsume2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720285568, "CC(remember):LazyLayoutPager.kt#9igjgp");
            if (i12 == 32) {
                z11 = true;
            } else {
                z11 = false;
            }
            zChanged = z11 | composerStartRestartGroup.changed(bringIntoViewSpec);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue5 = new PagerBringIntoViewSpec(pagerState2, bringIntoViewSpec);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new PagerBringIntoViewSpec(pagerState2, bringIntoViewSpec);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            PagerBringIntoViewSpec pagerBringIntoViewSpec2 = (PagerBringIntoViewSpec) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (z2) {
                composerStartRestartGroup.startReplaceGroup(-853822717);
                ComposerKt.sourceInformation(composerStartRestartGroup, "147@6714L167");
                companionLazyLayoutBeyondBoundsModifier = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.INSTANCE, PagerBeyondBoundsModifierKt.rememberPagerBeyondBoundsState(pagerState2, i15, composerStartRestartGroup, ((i14 >> 21) & 112) | i13), pagerState2.getBeyondBoundsInfo(), z, orientation);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-853392933);
                composerStartRestartGroup.endReplaceGroup();
                companionLazyLayoutBeyondBoundsModifier = Modifier.INSTANCE;
            }
            Modifier modifierLazyLayoutSemantics2 = LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(pagerState2.getRemeasurementModifier()).then(pagerState2.getAwaitLayoutModifier()), function0RememberPagerItemProviderLambda2, lazyLayoutSemanticStateRememberPagerSemanticState2, orientation, z2, z, composerStartRestartGroup, ((i14 << 6) & 458752) | (i26 & 7168) | ((i14 >> 6) & 57344));
            if (orientation == Orientation.Vertical) {
                z12 = true;
            } else {
                z12 = false;
            }
            Modifier modifierDragDirectionDetector2 = dragDirectionDetector(ScrollableAreaKt.scrollableArea(PagerKt.pagerSemantics(modifierLazyLayoutSemantics2, pagerState2, z12, coroutineScope2, z2).then(companionLazyLayoutBeyondBoundsModifier), pagerState2, orientation, overscrollEffect, z2, z, pagerWrapperFlingBehavior2, pagerState2.getInternalInteractionSource(), pagerBringIntoViewSpec2), pagerState2);
            nestedScrollConnection2 = nestedScrollConnection;
            LazyLayoutKt.LazyLayout(function0RememberPagerItemProviderLambda2, NestedScrollModifierKt.nestedScroll$default(modifierDragDirectionDetector2, nestedScrollConnection2, null, 2, null), pagerState2.getPrefetchState(), lazyLayoutMeasurePolicyM1520rememberPagerMeasurePolicy8u0NR3k2, composerStartRestartGroup, 0, 0);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f3 = f5;
            i10 = i15;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final NestedScrollConnection nestedScrollConnection4 = nestedScrollConnection2;
            final PagerState pagerState4 = pagerState2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LazyLayoutPagerKt.Pager_eLwUrMk$lambda$5(modifier, pagerState4, paddingValues, z, orientation, targetedFlingBehavior, z2, overscrollEffect, i10, f3, pageSize, nestedScrollConnection4, function1, horizontal, vertical, snapPosition, function4, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final Function0<PagerLazyLayoutItemProvider> rememberPagerItemProviderLambda(final PagerState pagerState, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Function1<? super Integer, ? extends Object> function1, final Function0<Integer> function0, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1052364153, "C(rememberPagerItemProviderLambda)N(state,pageContent,key,pageCount)258@10763L33,259@10817L25,260@10854L742:LazyLayoutPager.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1052364153, i, -1, "androidx.compose.foundation.pager.rememberPagerItemProviderLambda (LazyLayoutPager.kt:257)");
        }
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composer, (i >> 3) & 14);
        final State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function1, composer, (i >> 6) & 14);
        ComposerKt.sourceInformationMarkerStart(composer, 2004647903, "CC(remember):LazyLayoutPager.kt#9igjgp");
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer.changed(pagerState)) || (i & 6) == 4) | composer.changed(stateRememberUpdatedState) | composer.changed(stateRememberUpdatedState2) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(function0)) || (i & 3072) == 2048);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            final State stateDerivedStateOf = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new Function0() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LazyLayoutPagerKt.rememberPagerItemProviderLambda$lambda$0$0(stateRememberUpdatedState, stateRememberUpdatedState2, function0);
                }
            });
            final State stateDerivedStateOf2 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new Function0() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LazyLayoutPagerKt.rememberPagerItemProviderLambda$lambda$0$1(stateDerivedStateOf, pagerState);
                }
            });
            objRememberedValue = (KProperty0) new PropertyReference0Impl(stateDerivedStateOf2) { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$1
                @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                public Object get() {
                    return ((State) this.receiver).getValue();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        KProperty0 kProperty0 = (KProperty0) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return kProperty0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagerLayoutIntervalContent rememberPagerItemProviderLambda$lambda$0$0(State state, State state2, Function0 function0) {
        return new PagerLayoutIntervalContent((Function4) state.getValue(), (Function1) state2.getValue(), ((Number) function0.invoke()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagerLazyLayoutItemProvider rememberPagerItemProviderLambda$lambda$0$1(State state, PagerState pagerState) {
        PagerLayoutIntervalContent pagerLayoutIntervalContent = (PagerLayoutIntervalContent) state.getValue();
        return new PagerLazyLayoutItemProvider(pagerState, pagerLayoutIntervalContent, new NearestRangeKeyIndexMap(pagerState.getNearestRange$foundation(), pagerLayoutIntervalContent));
    }

    private static final Modifier dragDirectionDetector(Modifier modifier, final PagerState pagerState) {
        return modifier.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, pagerState, new PointerInputEventHandler() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt.dragDirectionDetector.1

            /* JADX INFO: renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: LazyLayoutPager.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1", f = "LazyLayoutPager.kt", i = {}, l = {285}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C00271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PagerState $state;
                final /* synthetic */ PointerInputScope $this_pointerInput;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00271(PointerInputScope pointerInputScope, PagerState pagerState, Continuation<? super C00271> continuation) {
                    super(2, continuation);
                    this.$this_pointerInput = pointerInputScope;
                    this.$state = pagerState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00271(this.$this_pointerInput, this.$state, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00271) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: LazyLayoutPager.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1", f = "LazyLayoutPager.kt", i = {0, 1, 1, 1}, l = {287, 291}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "downEvent", "upEventOrCancellation"}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 1)
                static final class C00281 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ PagerState $state;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00281(PagerState pagerState, Continuation<? super C00281> continuation) {
                        super(2, continuation);
                        this.$state = pagerState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C00281 c00281 = new C00281(this.$state, continuation);
                        c00281.L$0 = obj;
                        return c00281;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return ((C00281) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Code duplicated, block: B:20:0x007e  */
                    /* JADX WARN: Code duplicated, block: B:23:0x008b A[LOOP:0: B:19:0x007c->B:23:0x008b, LOOP_END] */
                    /* JADX WARN: Code duplicated, block: B:27:0x008e A[SYNTHETIC] */
                    /* JADX WARN: Code duplicated, block: B:28:0x0058 A[EDGE_INSN: B:28:0x0058->B:14:0x0058 BREAK  A[LOOP:0: B:19:0x007c->B:23:0x008b], SYNTHETIC] */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x006b -> B:18:0x006e). Please report as a decompilation issue!!! */
                    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                        */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                        /*
                            r10 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r1 = r10.label
                            r2 = 2
                            r3 = 0
                            r4 = 1
                            if (r1 == 0) goto L2f
                            if (r1 == r4) goto L27
                            if (r1 != r2) goto L1f
                            java.lang.Object r1 = r10.L$2
                            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
                            java.lang.Object r4 = r10.L$1
                            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                            java.lang.Object r5 = r10.L$0
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                            kotlin.ResultKt.throwOnFailure(r11)
                            goto L6e
                        L1f:
                            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                            r10.<init>(r11)
                            throw r10
                        L27:
                            java.lang.Object r1 = r10.L$0
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                            kotlin.ResultKt.throwOnFailure(r11)
                            goto L47
                        L2f:
                            kotlin.ResultKt.throwOnFailure(r11)
                            java.lang.Object r11 = r10.L$0
                            r1 = r11
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                            androidx.compose.ui.input.pointer.PointerEventPass r11 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                            r5 = r10
                            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                            r10.L$0 = r1
                            r10.label = r4
                            java.lang.Object r11 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r1, r3, r11, r5)
                            if (r11 != r0) goto L47
                            goto L6d
                        L47:
                            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
                            androidx.compose.foundation.pager.PagerState r4 = r10.$state
                            androidx.compose.ui.geometry.Offset$Companion r5 = androidx.compose.ui.geometry.Offset.INSTANCE
                            long r5 = r5.m6585getZeroF1C5BW0()
                            r4.m1528setUpDownDifferencek4lQ0M$foundation(r5)
                            r4 = 0
                            r5 = r1
                            r1 = r4
                            r4 = r11
                        L58:
                            if (r1 != 0) goto L9a
                            androidx.compose.ui.input.pointer.PointerEventPass r11 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                            r6 = r10
                            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                            r10.L$0 = r5
                            r10.L$1 = r4
                            r10.L$2 = r1
                            r10.label = r2
                            java.lang.Object r11 = r5.awaitPointerEvent(r11, r6)
                            if (r11 != r0) goto L6e
                        L6d:
                            return r0
                        L6e:
                            androidx.compose.ui.input.pointer.PointerEvent r11 = (androidx.compose.ui.input.pointer.PointerEvent) r11
                            java.util.List r6 = r11.getChanges()
                            r7 = r6
                            java.util.Collection r7 = (java.util.Collection) r7
                            int r7 = r7.size()
                            r8 = r3
                        L7c:
                            if (r8 >= r7) goto L8e
                            java.lang.Object r9 = r6.get(r8)
                            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
                            boolean r9 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r9)
                            if (r9 != 0) goto L8b
                            goto L58
                        L8b:
                            int r8 = r8 + 1
                            goto L7c
                        L8e:
                            java.util.List r11 = r11.getChanges()
                            java.lang.Object r11 = r11.get(r3)
                            r1 = r11
                            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
                            goto L58
                        L9a:
                            androidx.compose.foundation.pager.PagerState r10 = r10.$state
                            long r0 = r1.getPosition()
                            long r2 = r4.getPosition()
                            long r0 = androidx.compose.ui.geometry.Offset.m6573minusMKHz9U(r0, r2)
                            r10.m1528setUpDownDifferencek4lQ0M$foundation(r0)
                            kotlin.Unit r10 = kotlin.Unit.INSTANCE
                            return r10
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.LazyLayoutPagerKt.AnonymousClass1.C00271.C00281.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (ForEachGestureKt.awaitEachGesture(this.$this_pointerInput, new C00281(this.$state, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C00271(pointerInputScope, pagerState, null), continuation);
                return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
            }
        }));
    }
}
