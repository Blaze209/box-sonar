package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a}\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u001e\b\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a}\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u001e\b\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u0014\u0010\u0012\u001a\u009b\u0001\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001e\b\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\b\b\u0002\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u009b\u0001\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001e\b\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\b\b\u0002\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u001e\u0010\u001c\u001ak\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0003¢\u0006\u0004\b \u0010!\u001a\u008b\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0003¢\u0006\u0004\b#\u0010$\u001a{\u0010%\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072,\u0010\t\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020'0&¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0003¢\u0006\u0004\b+\u0010!\u001a\u009d\u0001\u0010,\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032,\u0010\t\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020'0&¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0004\b-\u0010.\u001a\u0091\u0001\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001e\b\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b/\u00100\u001a\u0091\u0001\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001e\b\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b1\u00100\u001a\u008d\u0001\u00102\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072.\b\u0002\u0010\t\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020'0&¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b3\u0010\u0012\u001a\u0097\u0001\u00104\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192.\b\u0002\u0010\t\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020'0&¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b5\u00106¨\u00067"}, d2 = {"PrimaryTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "indicator", "Lkotlin/Function1;", "Landroidx/compose/material3/TabIndicatorScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "divider", "Lkotlin/Function0;", "tabs", "PrimaryTabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SecondaryTabRow", "SecondaryTabRow-pAZo6Ak", "PrimaryScrollableTabRow", "scrollState", "Landroidx/compose/foundation/ScrollState;", "edgePadding", "Landroidx/compose/ui/unit/Dp;", "minTabWidth", "PrimaryScrollableTabRow-cx2KkNY", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SecondaryScrollableTabRow", "SecondaryScrollableTabRow-cx2KkNY", "TabRowImpl", "TabRowImpl-DTcfvLk", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ScrollableTabRowImpl", "ScrollableTabRowImpl-xam5sdo", "(ILandroidx/compose/ui/Modifier;JJFFLandroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabRowWithSubcomposeImpl", "", "Landroidx/compose/material3/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "TabRowWithSubcomposeImpl-DTcfvLk", "ScrollableTabRowWithSubcomposeImpl", "ScrollableTabRowWithSubcomposeImpl-qhFBPw4", "(ILkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;II)V", "PrimaryScrollableTabRow-qhFBPw4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SecondaryScrollableTabRow-qhFBPw4", "TabRow", "TabRow-pAZo6Ak", "ScrollableTabRow", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TabRowKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrimaryScrollableTabRow_cx2KkNY$lambda$1(int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3 function3, Function2 function2, float f2, Function2 function4, int i2, int i3, Composer composer, int i4) {
        m4386PrimaryScrollableTabRowcx2KkNY(i, modifier, scrollState, j, j2, f, function3, function2, f2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrimaryScrollableTabRow_qhFBPw4$lambda$1(int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3 function3, Function2 function2, Function2 function4, int i2, int i3, Composer composer, int i4) {
        m4387PrimaryScrollableTabRowqhFBPw4(i, modifier, scrollState, j, j2, f, function3, function2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrimaryTabRow_pAZo6Ak$lambda$1(int i, Modifier modifier, long j, long j2, Function3 function3, Function2 function2, Function2 function4, int i2, int i3, Composer composer, int i4) {
        m4388PrimaryTabRowpAZo6Ak(i, modifier, j, j2, function3, function2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableTabRowImpl_xam5sdo$lambda$1(int i, Modifier modifier, long j, long j2, float f, float f2, ScrollState scrollState, Function3 function3, Function2 function2, Function2 function4, int i2, Composer composer, int i3) {
        m4390ScrollableTabRowImplxam5sdo(i, modifier, j, j2, f, f2, scrollState, function3, function2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$1(int i, Function3 function3, Modifier modifier, long j, long j2, float f, Function2 function2, Function2 function4, ScrollState scrollState, int i2, int i3, Composer composer, int i4) {
        m4391ScrollableTabRowWithSubcomposeImplqhFBPw4(i, function3, modifier, j, j2, f, function2, function4, scrollState, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableTabRow_sKfQg0A$lambda$1(int i, Modifier modifier, long j, long j2, float f, Function3 function3, Function2 function2, Function2 function4, int i2, int i3, Composer composer, int i4) {
        m4389ScrollableTabRowsKfQg0A(i, modifier, j, j2, f, function3, function2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SecondaryScrollableTabRow_cx2KkNY$lambda$1(int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3 function3, Function2 function2, float f2, Function2 function4, int i2, int i3, Composer composer, int i4) {
        m4392SecondaryScrollableTabRowcx2KkNY(i, modifier, scrollState, j, j2, f, function3, function2, f2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SecondaryScrollableTabRow_qhFBPw4$lambda$1(int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3 function3, Function2 function2, Function2 function4, int i2, int i3, Composer composer, int i4) {
        m4393SecondaryScrollableTabRowqhFBPw4(i, modifier, scrollState, j, j2, f, function3, function2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SecondaryTabRow_pAZo6Ak$lambda$1(int i, Modifier modifier, long j, long j2, Function3 function3, Function2 function2, Function2 function4, int i2, int i3, Composer composer, int i4) {
        m4394SecondaryTabRowpAZo6Ak(i, modifier, j, j2, function3, function2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabRowImpl_DTcfvLk$lambda$1(Modifier modifier, long j, long j2, Function3 function3, Function2 function2, Function2 function4, int i, Composer composer, int i2) {
        m4396TabRowImplDTcfvLk(modifier, j, j2, function3, function2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabRowWithSubcomposeImpl_DTcfvLk$lambda$1(Modifier modifier, long j, long j2, Function3 function3, Function2 function2, Function2 function4, int i, Composer composer, int i2) {
        m4397TabRowWithSubcomposeImplDTcfvLk(modifier, j, j2, function3, function2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabRow_pAZo6Ak$lambda$1(int i, Modifier modifier, long j, long j2, Function3 function3, Function2 function2, Function2 function4, int i2, int i3, Composer composer, int i4) {
        m4395TabRowpAZo6Ak(i, modifier, j, j2, function3, function2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrimaryTabRow_pAZo6Ak$lambda$0(int i, TabIndicatorScope tabIndicatorScope, Composer composer, int i2) {
        int i3;
        ComposerKt.sourceInformation(composer, "C155@7704L158:TabRow.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = ((i2 & 8) == 0 ? composer.changed(tabIndicatorScope) : composer.changedInstance(tabIndicatorScope) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if (!composer.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1338273762, i3, -1, "androidx.compose.material3.PrimaryTabRow.<anonymous> (TabRow.kt:155)");
            }
            TabRowDefaults.INSTANCE.m4372PrimaryIndicator10LGxhE(tabIndicatorScope.tabIndicatorOffset(Modifier.INSTANCE, i, true), Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM(), 0.0f, 0L, null, composer, 196656, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x012b  */
    /* JADX WARN: Code duplicated, block: B:102:0x012e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0140  */
    /* JADX WARN: Code duplicated, block: B:105:0x0143  */
    /* JADX WARN: Code duplicated, block: B:106:0x0154  */
    /* JADX WARN: Code duplicated, block: B:109:0x0167  */
    /* JADX WARN: Code duplicated, block: B:112:0x0181  */
    /* JADX WARN: Code duplicated, block: B:114:0x018c  */
    /* JADX WARN: Code duplicated, block: B:117:0x019d  */
    /* JADX WARN: Code duplicated, block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0061  */
    /* JADX WARN: Code duplicated, block: B:38:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0072  */
    /* JADX WARN: Code duplicated, block: B:45:0x0078  */
    /* JADX WARN: Code duplicated, block: B:46:0x007b  */
    /* JADX WARN: Code duplicated, block: B:48:0x007f  */
    /* JADX WARN: Code duplicated, block: B:50:0x0087  */
    /* JADX WARN: Code duplicated, block: B:51:0x008a  */
    /* JADX WARN: Code duplicated, block: B:56:0x0096  */
    /* JADX WARN: Code duplicated, block: B:57:0x0098  */
    /* JADX WARN: Code duplicated, block: B:59:0x009b  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:79:0x00da  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:91:0x0108 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x010a  */
    /* JADX WARN: Code duplicated, block: B:93:0x010f  */
    /* JADX WARN: Code duplicated, block: B:96:0x0116  */
    /* JADX WARN: Code duplicated, block: B:99:0x0122  */
    /* JADX INFO: renamed from: PrimaryTabRow-pAZo6Ak, reason: not valid java name */
    public static final void m4388PrimaryTabRowpAZo6Ak(final int i, Modifier modifier, long j, long j2, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3) {
        int i4;
        long primaryContainerColor;
        long j3;
        int i5;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function5;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function6;
        int i8;
        boolean z;
        Composer composer2;
        final Modifier modifier2;
        final long j4;
        final long j5;
        final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function7;
        final Function2<? super Composer, ? super Integer, Unit> function8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long primaryContentColor;
        ComposableLambda composableLambdaRememberComposableLambda;
        Modifier modifier3;
        long j6;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function9;
        Function2<? super Composer, ? super Integer, Unit> function2M3109getLambda$1429684928$material3;
        int i9;
        long j7;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1012974221);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PrimaryTabRow)N(selectedTabIndex,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,indicator,divider,tabs)163@7987L76:TabRow.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i11 = i3 & 2;
        if (i11 == 0) {
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                if ((i3 & 4) == 0) {
                    primaryContainerColor = j;
                    int i12 = composerStartRestartGroup.changed(primaryContainerColor) ? 256 : 128;
                    i4 |= i12;
                } else {
                    primaryContainerColor = j;
                }
                i4 |= i12;
            } else {
                primaryContainerColor = j;
            }
            if ((i2 & 3072) == 0) {
                if ((i3 & 8) == 0) {
                    j3 = j2;
                    int i13 = composerStartRestartGroup.changed(j3) ? 2048 : 1024;
                    i4 |= i13;
                } else {
                    j3 = j2;
                }
                i4 |= i13;
            } else {
                j3 = j2;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((i2 & 24576) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 32;
                if (i7 != 0) {
                    if ((196608 & i2) == 0) {
                        function6 = function2;
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                        i4 |= i8;
                    }
                    if ((1572864 & i2) != 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i4 |= i10;
                    }
                    if ((i4 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "152@7536L21,153@7600L19,154@7679L189");
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                primaryContentColor = j3;
                            }
                            if (i5 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1338273762, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function5;
                            }
                            if (i7 != 0) {
                                modifier3 = companion;
                                j7 = primaryContentColor;
                                j6 = primaryContainerColor;
                                function9 = composableLambdaRememberComposableLambda;
                                function2M3109getLambda$1429684928$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3109getLambda$1429684928$material3();
                                i9 = -1012974221;
                            } else {
                                modifier3 = companion;
                                j6 = primaryContainerColor;
                                function9 = composableLambdaRememberComposableLambda;
                                function2M3109getLambda$1429684928$material3 = function6;
                                i9 = -1012974221;
                                j7 = primaryContentColor;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                i4 &= -7169;
                            }
                            modifier3 = modifier;
                            function9 = function5;
                            function2M3109getLambda$1429684928$material3 = function6;
                            i9 = -1012974221;
                            j6 = primaryContainerColor;
                            j7 = j3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.PrimaryTabRow (TabRow.kt:162)");
                        }
                        composer2 = composerStartRestartGroup;
                        m4396TabRowImplDTcfvLk(modifier3, j6, j7, function9, function2M3109getLambda$1429684928$material3, function4, composer2, (i4 >> 3) & 524286);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        j4 = j6;
                        j5 = j7;
                        function7 = function9;
                        function8 = function2M3109getLambda$1429684928$material3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = modifier;
                        j4 = primaryContainerColor;
                        j5 = j3;
                        function7 = function5;
                        function8 = function6;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function6 = function2;
                if ((1572864 & i2) != 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((i4 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "152@7536L21,153@7600L19,154@7679L189");
                    if ((i2 & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1338273762, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            modifier3 = companion;
                            j7 = primaryContentColor;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3109getLambda$1429684928$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3109getLambda$1429684928$material3();
                            i9 = -1012974221;
                        } else {
                            modifier3 = companion;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3109getLambda$1429684928$material3 = function6;
                            i9 = -1012974221;
                            j7 = primaryContentColor;
                        }
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1338273762, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            modifier3 = companion;
                            j7 = primaryContentColor;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3109getLambda$1429684928$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3109getLambda$1429684928$material3();
                            i9 = -1012974221;
                        } else {
                            modifier3 = companion;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3109getLambda$1429684928$material3 = function6;
                            i9 = -1012974221;
                            j7 = primaryContentColor;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.PrimaryTabRow (TabRow.kt:162)");
                    }
                    composer2 = composerStartRestartGroup;
                    m4396TabRowImplDTcfvLk(modifier3, j6, j7, function9, function2M3109getLambda$1429684928$material3, function4, composer2, (i4 >> 3) & 524286);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j4 = j6;
                    j5 = j7;
                    function7 = function9;
                    function8 = function2M3109getLambda$1429684928$material3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    j4 = primaryContainerColor;
                    j5 = j3;
                    function7 = function5;
                    function8 = function6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            function5 = function3;
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((196608 & i2) == 0) {
                    function6 = function2;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i4 |= i8;
                }
                if ((1572864 & i2) != 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((i4 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "152@7536L21,153@7600L19,154@7679L189");
                    if ((i2 & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1338273762, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            modifier3 = companion;
                            j7 = primaryContentColor;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3109getLambda$1429684928$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3109getLambda$1429684928$material3();
                            i9 = -1012974221;
                        } else {
                            modifier3 = companion;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3109getLambda$1429684928$material3 = function6;
                            i9 = -1012974221;
                            j7 = primaryContentColor;
                        }
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1338273762, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            modifier3 = companion;
                            j7 = primaryContentColor;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3109getLambda$1429684928$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3109getLambda$1429684928$material3();
                            i9 = -1012974221;
                        } else {
                            modifier3 = companion;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3109getLambda$1429684928$material3 = function6;
                            i9 = -1012974221;
                            j7 = primaryContentColor;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.PrimaryTabRow (TabRow.kt:162)");
                    }
                    composer2 = composerStartRestartGroup;
                    m4396TabRowImplDTcfvLk(modifier3, j6, j7, function9, function2M3109getLambda$1429684928$material3, function4, composer2, (i4 >> 3) & 524286);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j4 = j6;
                    j5 = j7;
                    function7 = function9;
                    function8 = function2M3109getLambda$1429684928$material3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    j4 = primaryContainerColor;
                    j5 = j3;
                    function7 = function5;
                    function8 = function6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function6 = function2;
            if ((1572864 & i2) != 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i4 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "152@7536L21,153@7600L19,154@7679L189");
                if ((i2 & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1338273762, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        modifier3 = companion;
                        j7 = primaryContentColor;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3109getLambda$1429684928$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3109getLambda$1429684928$material3();
                        i9 = -1012974221;
                    } else {
                        modifier3 = companion;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3109getLambda$1429684928$material3 = function6;
                        i9 = -1012974221;
                        j7 = primaryContentColor;
                    }
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1338273762, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        modifier3 = companion;
                        j7 = primaryContentColor;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3109getLambda$1429684928$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3109getLambda$1429684928$material3();
                        i9 = -1012974221;
                    } else {
                        modifier3 = companion;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3109getLambda$1429684928$material3 = function6;
                        i9 = -1012974221;
                        j7 = primaryContentColor;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.PrimaryTabRow (TabRow.kt:162)");
                }
                composer2 = composerStartRestartGroup;
                m4396TabRowImplDTcfvLk(modifier3, j6, j7, function9, function2M3109getLambda$1429684928$material3, function4, composer2, (i4 >> 3) & 524286);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j4 = j6;
                j5 = j7;
                function7 = function9;
                function8 = function2M3109getLambda$1429684928$material3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                j4 = primaryContainerColor;
                j5 = j3;
                function7 = function5;
                function8 = function6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        if ((i2 & 384) == 0) {
            if ((i3 & 4) == 0) {
                primaryContainerColor = j;
                if (composerStartRestartGroup.changed(primaryContainerColor)) {
                }
                i4 |= i12;
            } else {
                primaryContainerColor = j;
            }
            i4 |= i12;
        } else {
            primaryContainerColor = j;
        }
        if ((i2 & 3072) == 0) {
            if ((i3 & 8) == 0) {
                j3 = j2;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i4 |= i13;
            } else {
                j3 = j2;
            }
            i4 |= i13;
        } else {
            j3 = j2;
        }
        i5 = i3 & 16;
        if (i5 != 0) {
            if ((i2 & 24576) == 0) {
                function5 = function3;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i4 |= i6;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((196608 & i2) == 0) {
                    function6 = function2;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i4 |= i8;
                }
                if ((1572864 & i2) != 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((i4 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "152@7536L21,153@7600L19,154@7679L189");
                    if ((i2 & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1338273762, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            modifier3 = companion;
                            j7 = primaryContentColor;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3109getLambda$1429684928$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3109getLambda$1429684928$material3();
                            i9 = -1012974221;
                        } else {
                            modifier3 = companion;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3109getLambda$1429684928$material3 = function6;
                            i9 = -1012974221;
                            j7 = primaryContentColor;
                        }
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1338273762, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            modifier3 = companion;
                            j7 = primaryContentColor;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3109getLambda$1429684928$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3109getLambda$1429684928$material3();
                            i9 = -1012974221;
                        } else {
                            modifier3 = companion;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3109getLambda$1429684928$material3 = function6;
                            i9 = -1012974221;
                            j7 = primaryContentColor;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.PrimaryTabRow (TabRow.kt:162)");
                    }
                    composer2 = composerStartRestartGroup;
                    m4396TabRowImplDTcfvLk(modifier3, j6, j7, function9, function2M3109getLambda$1429684928$material3, function4, composer2, (i4 >> 3) & 524286);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j4 = j6;
                    j5 = j7;
                    function7 = function9;
                    function8 = function2M3109getLambda$1429684928$material3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    j4 = primaryContainerColor;
                    j5 = j3;
                    function7 = function5;
                    function8 = function6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function6 = function2;
            if ((1572864 & i2) != 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i4 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "152@7536L21,153@7600L19,154@7679L189");
                if ((i2 & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1338273762, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        modifier3 = companion;
                        j7 = primaryContentColor;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3109getLambda$1429684928$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3109getLambda$1429684928$material3();
                        i9 = -1012974221;
                    } else {
                        modifier3 = companion;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3109getLambda$1429684928$material3 = function6;
                        i9 = -1012974221;
                        j7 = primaryContentColor;
                    }
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1338273762, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        modifier3 = companion;
                        j7 = primaryContentColor;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3109getLambda$1429684928$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3109getLambda$1429684928$material3();
                        i9 = -1012974221;
                    } else {
                        modifier3 = companion;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3109getLambda$1429684928$material3 = function6;
                        i9 = -1012974221;
                        j7 = primaryContentColor;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.PrimaryTabRow (TabRow.kt:162)");
                }
                composer2 = composerStartRestartGroup;
                m4396TabRowImplDTcfvLk(modifier3, j6, j7, function9, function2M3109getLambda$1429684928$material3, function4, composer2, (i4 >> 3) & 524286);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j4 = j6;
                j5 = j7;
                function7 = function9;
                function8 = function2M3109getLambda$1429684928$material3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                j4 = primaryContainerColor;
                j5 = j3;
                function7 = function5;
                function8 = function6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        function5 = function3;
        i7 = i3 & 32;
        if (i7 != 0) {
            if ((196608 & i2) == 0) {
                function6 = function2;
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i4 |= i8;
            }
            if ((1572864 & i2) != 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i4 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "152@7536L21,153@7600L19,154@7679L189");
                if ((i2 & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1338273762, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        modifier3 = companion;
                        j7 = primaryContentColor;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3109getLambda$1429684928$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3109getLambda$1429684928$material3();
                        i9 = -1012974221;
                    } else {
                        modifier3 = companion;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3109getLambda$1429684928$material3 = function6;
                        i9 = -1012974221;
                        j7 = primaryContentColor;
                    }
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1338273762, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        modifier3 = companion;
                        j7 = primaryContentColor;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3109getLambda$1429684928$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3109getLambda$1429684928$material3();
                        i9 = -1012974221;
                    } else {
                        modifier3 = companion;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3109getLambda$1429684928$material3 = function6;
                        i9 = -1012974221;
                        j7 = primaryContentColor;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.PrimaryTabRow (TabRow.kt:162)");
                }
                composer2 = composerStartRestartGroup;
                m4396TabRowImplDTcfvLk(modifier3, j6, j7, function9, function2M3109getLambda$1429684928$material3, function4, composer2, (i4 >> 3) & 524286);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j4 = j6;
                j5 = j7;
                function7 = function9;
                function8 = function2M3109getLambda$1429684928$material3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                j4 = primaryContainerColor;
                j5 = j3;
                function7 = function5;
                function8 = function6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function6 = function2;
        if ((1572864 & i2) != 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i10 = 1048576;
            } else {
                i10 = 524288;
            }
            i4 |= i10;
        }
        if ((i4 & 599187) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "152@7536L21,153@7600L19,154@7679L189");
            if ((i2 & 1) != 0) {
                if (i11 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i3 & 4) != 0) {
                    primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    primaryContentColor = j3;
                }
                if (i5 != 0) {
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1338273762, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    composableLambdaRememberComposableLambda = function5;
                }
                if (i7 != 0) {
                    modifier3 = companion;
                    j7 = primaryContentColor;
                    j6 = primaryContainerColor;
                    function9 = composableLambdaRememberComposableLambda;
                    function2M3109getLambda$1429684928$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3109getLambda$1429684928$material3();
                    i9 = -1012974221;
                } else {
                    modifier3 = companion;
                    j6 = primaryContainerColor;
                    function9 = composableLambdaRememberComposableLambda;
                    function2M3109getLambda$1429684928$material3 = function6;
                    i9 = -1012974221;
                    j7 = primaryContentColor;
                }
            } else {
                if (i11 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i3 & 4) != 0) {
                    primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    primaryContentColor = j3;
                }
                if (i5 != 0) {
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1338273762, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    composableLambdaRememberComposableLambda = function5;
                }
                if (i7 != 0) {
                    modifier3 = companion;
                    j7 = primaryContentColor;
                    j6 = primaryContainerColor;
                    function9 = composableLambdaRememberComposableLambda;
                    function2M3109getLambda$1429684928$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3109getLambda$1429684928$material3();
                    i9 = -1012974221;
                } else {
                    modifier3 = companion;
                    j6 = primaryContainerColor;
                    function9 = composableLambdaRememberComposableLambda;
                    function2M3109getLambda$1429684928$material3 = function6;
                    i9 = -1012974221;
                    j7 = primaryContentColor;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.PrimaryTabRow (TabRow.kt:162)");
            }
            composer2 = composerStartRestartGroup;
            m4396TabRowImplDTcfvLk(modifier3, j6, j7, function9, function2M3109getLambda$1429684928$material3, function4, composer2, (i4 >> 3) & 524286);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            j4 = j6;
            j5 = j7;
            function7 = function9;
            function8 = function2M3109getLambda$1429684928$material3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier2 = modifier;
            j4 = primaryContainerColor;
            j5 = j3;
            function7 = function5;
            function8 = function6;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SecondaryTabRow_pAZo6Ak$lambda$0(int i, TabIndicatorScope tabIndicatorScope, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C207@10603L121:TabRow.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i2 |= (i2 & 8) == 0 ? composer.changed(tabIndicatorScope) : composer.changedInstance(tabIndicatorScope) ? 4 : 2;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(959948692, i2, -1, "androidx.compose.material3.SecondaryTabRow.<anonymous> (TabRow.kt:207)");
            }
            TabRowDefaults.INSTANCE.m4373SecondaryIndicator9IZ8Weo(tabIndicatorScope.tabIndicatorOffset(Modifier.INSTANCE, i, false), 0.0f, 0L, composer, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x012b  */
    /* JADX WARN: Code duplicated, block: B:102:0x012e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0140  */
    /* JADX WARN: Code duplicated, block: B:105:0x0143  */
    /* JADX WARN: Code duplicated, block: B:106:0x0154  */
    /* JADX WARN: Code duplicated, block: B:109:0x0167  */
    /* JADX WARN: Code duplicated, block: B:112:0x0181  */
    /* JADX WARN: Code duplicated, block: B:114:0x018c  */
    /* JADX WARN: Code duplicated, block: B:117:0x019d  */
    /* JADX WARN: Code duplicated, block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0061  */
    /* JADX WARN: Code duplicated, block: B:38:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0072  */
    /* JADX WARN: Code duplicated, block: B:45:0x0078  */
    /* JADX WARN: Code duplicated, block: B:46:0x007b  */
    /* JADX WARN: Code duplicated, block: B:48:0x007f  */
    /* JADX WARN: Code duplicated, block: B:50:0x0087  */
    /* JADX WARN: Code duplicated, block: B:51:0x008a  */
    /* JADX WARN: Code duplicated, block: B:56:0x0096  */
    /* JADX WARN: Code duplicated, block: B:57:0x0098  */
    /* JADX WARN: Code duplicated, block: B:59:0x009b  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:79:0x00da  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:91:0x0108 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x010a  */
    /* JADX WARN: Code duplicated, block: B:93:0x010f  */
    /* JADX WARN: Code duplicated, block: B:96:0x0116  */
    /* JADX WARN: Code duplicated, block: B:99:0x0122  */
    /* JADX INFO: renamed from: SecondaryTabRow-pAZo6Ak, reason: not valid java name */
    public static final void m4394SecondaryTabRowpAZo6Ak(final int i, Modifier modifier, long j, long j2, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3) {
        int i4;
        long secondaryContainerColor;
        long j3;
        int i5;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function5;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function6;
        int i8;
        boolean z;
        Composer composer2;
        final Modifier modifier2;
        final long j4;
        final long j5;
        final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function7;
        final Function2<? super Composer, ? super Integer, Unit> function8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long secondaryContentColor;
        ComposableLambda composableLambdaRememberComposableLambda;
        Modifier modifier3;
        long j6;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function9;
        Function2<? super Composer, ? super Integer, Unit> function2M3112getLambda$463596174$material3;
        int i9;
        long j7;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(563434725);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SecondaryTabRow)N(selectedTabIndex,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,indicator,divider,tabs)214@10853L76:TabRow.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i11 = i3 & 2;
        if (i11 == 0) {
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                if ((i3 & 4) == 0) {
                    secondaryContainerColor = j;
                    int i12 = composerStartRestartGroup.changed(secondaryContainerColor) ? 256 : 128;
                    i4 |= i12;
                } else {
                    secondaryContainerColor = j;
                }
                i4 |= i12;
            } else {
                secondaryContainerColor = j;
            }
            if ((i2 & 3072) == 0) {
                if ((i3 & 8) == 0) {
                    j3 = j2;
                    int i13 = composerStartRestartGroup.changed(j3) ? 2048 : 1024;
                    i4 |= i13;
                } else {
                    j3 = j2;
                }
                i4 |= i13;
            } else {
                j3 = j2;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((i2 & 24576) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 32;
                if (i7 != 0) {
                    if ((196608 & i2) == 0) {
                        function6 = function2;
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                        i4 |= i8;
                    }
                    if ((1572864 & i2) != 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i4 |= i10;
                    }
                    if ((i4 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "203@10407L23,204@10473L21,206@10574L160");
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                secondaryContentColor = j3;
                            }
                            if (i5 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(959948692, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda18
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function5;
                            }
                            if (i7 != 0) {
                                modifier3 = companion;
                                j7 = secondaryContentColor;
                                j6 = secondaryContainerColor;
                                function9 = composableLambdaRememberComposableLambda;
                                function2M3112getLambda$463596174$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3112getLambda$463596174$material3();
                                i9 = 563434725;
                            } else {
                                modifier3 = companion;
                                j6 = secondaryContainerColor;
                                function9 = composableLambdaRememberComposableLambda;
                                function2M3112getLambda$463596174$material3 = function6;
                                i9 = 563434725;
                                j7 = secondaryContentColor;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                i4 &= -7169;
                            }
                            modifier3 = modifier;
                            function9 = function5;
                            function2M3112getLambda$463596174$material3 = function6;
                            i9 = 563434725;
                            j6 = secondaryContainerColor;
                            j7 = j3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.SecondaryTabRow (TabRow.kt:213)");
                        }
                        composer2 = composerStartRestartGroup;
                        m4396TabRowImplDTcfvLk(modifier3, j6, j7, function9, function2M3112getLambda$463596174$material3, function4, composer2, (i4 >> 3) & 524286);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        j4 = j6;
                        j5 = j7;
                        function7 = function9;
                        function8 = function2M3112getLambda$463596174$material3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = modifier;
                        j4 = secondaryContainerColor;
                        j5 = j3;
                        function7 = function5;
                        function8 = function6;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function6 = function2;
                if ((1572864 & i2) != 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((i4 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "203@10407L23,204@10473L21,206@10574L160");
                    if ((i2 & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            secondaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(959948692, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda18
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            modifier3 = companion;
                            j7 = secondaryContentColor;
                            j6 = secondaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3112getLambda$463596174$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3112getLambda$463596174$material3();
                            i9 = 563434725;
                        } else {
                            modifier3 = companion;
                            j6 = secondaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3112getLambda$463596174$material3 = function6;
                            i9 = 563434725;
                            j7 = secondaryContentColor;
                        }
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            secondaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(959948692, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda18
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            modifier3 = companion;
                            j7 = secondaryContentColor;
                            j6 = secondaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3112getLambda$463596174$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3112getLambda$463596174$material3();
                            i9 = 563434725;
                        } else {
                            modifier3 = companion;
                            j6 = secondaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3112getLambda$463596174$material3 = function6;
                            i9 = 563434725;
                            j7 = secondaryContentColor;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.SecondaryTabRow (TabRow.kt:213)");
                    }
                    composer2 = composerStartRestartGroup;
                    m4396TabRowImplDTcfvLk(modifier3, j6, j7, function9, function2M3112getLambda$463596174$material3, function4, composer2, (i4 >> 3) & 524286);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j4 = j6;
                    j5 = j7;
                    function7 = function9;
                    function8 = function2M3112getLambda$463596174$material3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    j4 = secondaryContainerColor;
                    j5 = j3;
                    function7 = function5;
                    function8 = function6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            function5 = function3;
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((196608 & i2) == 0) {
                    function6 = function2;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i4 |= i8;
                }
                if ((1572864 & i2) != 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((i4 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "203@10407L23,204@10473L21,206@10574L160");
                    if ((i2 & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            secondaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(959948692, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda18
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            modifier3 = companion;
                            j7 = secondaryContentColor;
                            j6 = secondaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3112getLambda$463596174$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3112getLambda$463596174$material3();
                            i9 = 563434725;
                        } else {
                            modifier3 = companion;
                            j6 = secondaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3112getLambda$463596174$material3 = function6;
                            i9 = 563434725;
                            j7 = secondaryContentColor;
                        }
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            secondaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(959948692, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda18
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            modifier3 = companion;
                            j7 = secondaryContentColor;
                            j6 = secondaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3112getLambda$463596174$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3112getLambda$463596174$material3();
                            i9 = 563434725;
                        } else {
                            modifier3 = companion;
                            j6 = secondaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3112getLambda$463596174$material3 = function6;
                            i9 = 563434725;
                            j7 = secondaryContentColor;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.SecondaryTabRow (TabRow.kt:213)");
                    }
                    composer2 = composerStartRestartGroup;
                    m4396TabRowImplDTcfvLk(modifier3, j6, j7, function9, function2M3112getLambda$463596174$material3, function4, composer2, (i4 >> 3) & 524286);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j4 = j6;
                    j5 = j7;
                    function7 = function9;
                    function8 = function2M3112getLambda$463596174$material3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    j4 = secondaryContainerColor;
                    j5 = j3;
                    function7 = function5;
                    function8 = function6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function6 = function2;
            if ((1572864 & i2) != 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i4 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "203@10407L23,204@10473L21,206@10574L160");
                if ((i2 & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        secondaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(959948692, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        modifier3 = companion;
                        j7 = secondaryContentColor;
                        j6 = secondaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3112getLambda$463596174$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3112getLambda$463596174$material3();
                        i9 = 563434725;
                    } else {
                        modifier3 = companion;
                        j6 = secondaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3112getLambda$463596174$material3 = function6;
                        i9 = 563434725;
                        j7 = secondaryContentColor;
                    }
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        secondaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(959948692, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        modifier3 = companion;
                        j7 = secondaryContentColor;
                        j6 = secondaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3112getLambda$463596174$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3112getLambda$463596174$material3();
                        i9 = 563434725;
                    } else {
                        modifier3 = companion;
                        j6 = secondaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3112getLambda$463596174$material3 = function6;
                        i9 = 563434725;
                        j7 = secondaryContentColor;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.SecondaryTabRow (TabRow.kt:213)");
                }
                composer2 = composerStartRestartGroup;
                m4396TabRowImplDTcfvLk(modifier3, j6, j7, function9, function2M3112getLambda$463596174$material3, function4, composer2, (i4 >> 3) & 524286);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j4 = j6;
                j5 = j7;
                function7 = function9;
                function8 = function2M3112getLambda$463596174$material3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                j4 = secondaryContainerColor;
                j5 = j3;
                function7 = function5;
                function8 = function6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        if ((i2 & 384) == 0) {
            if ((i3 & 4) == 0) {
                secondaryContainerColor = j;
                if (composerStartRestartGroup.changed(secondaryContainerColor)) {
                }
                i4 |= i12;
            } else {
                secondaryContainerColor = j;
            }
            i4 |= i12;
        } else {
            secondaryContainerColor = j;
        }
        if ((i2 & 3072) == 0) {
            if ((i3 & 8) == 0) {
                j3 = j2;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i4 |= i13;
            } else {
                j3 = j2;
            }
            i4 |= i13;
        } else {
            j3 = j2;
        }
        i5 = i3 & 16;
        if (i5 != 0) {
            if ((i2 & 24576) == 0) {
                function5 = function3;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i4 |= i6;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((196608 & i2) == 0) {
                    function6 = function2;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i4 |= i8;
                }
                if ((1572864 & i2) != 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((i4 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "203@10407L23,204@10473L21,206@10574L160");
                    if ((i2 & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            secondaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(959948692, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda18
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            modifier3 = companion;
                            j7 = secondaryContentColor;
                            j6 = secondaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3112getLambda$463596174$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3112getLambda$463596174$material3();
                            i9 = 563434725;
                        } else {
                            modifier3 = companion;
                            j6 = secondaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3112getLambda$463596174$material3 = function6;
                            i9 = 563434725;
                            j7 = secondaryContentColor;
                        }
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            secondaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(959948692, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda18
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            modifier3 = companion;
                            j7 = secondaryContentColor;
                            j6 = secondaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3112getLambda$463596174$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3112getLambda$463596174$material3();
                            i9 = 563434725;
                        } else {
                            modifier3 = companion;
                            j6 = secondaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3112getLambda$463596174$material3 = function6;
                            i9 = 563434725;
                            j7 = secondaryContentColor;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.SecondaryTabRow (TabRow.kt:213)");
                    }
                    composer2 = composerStartRestartGroup;
                    m4396TabRowImplDTcfvLk(modifier3, j6, j7, function9, function2M3112getLambda$463596174$material3, function4, composer2, (i4 >> 3) & 524286);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j4 = j6;
                    j5 = j7;
                    function7 = function9;
                    function8 = function2M3112getLambda$463596174$material3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    j4 = secondaryContainerColor;
                    j5 = j3;
                    function7 = function5;
                    function8 = function6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function6 = function2;
            if ((1572864 & i2) != 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i4 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "203@10407L23,204@10473L21,206@10574L160");
                if ((i2 & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        secondaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(959948692, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        modifier3 = companion;
                        j7 = secondaryContentColor;
                        j6 = secondaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3112getLambda$463596174$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3112getLambda$463596174$material3();
                        i9 = 563434725;
                    } else {
                        modifier3 = companion;
                        j6 = secondaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3112getLambda$463596174$material3 = function6;
                        i9 = 563434725;
                        j7 = secondaryContentColor;
                    }
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        secondaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(959948692, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        modifier3 = companion;
                        j7 = secondaryContentColor;
                        j6 = secondaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3112getLambda$463596174$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3112getLambda$463596174$material3();
                        i9 = 563434725;
                    } else {
                        modifier3 = companion;
                        j6 = secondaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3112getLambda$463596174$material3 = function6;
                        i9 = 563434725;
                        j7 = secondaryContentColor;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.SecondaryTabRow (TabRow.kt:213)");
                }
                composer2 = composerStartRestartGroup;
                m4396TabRowImplDTcfvLk(modifier3, j6, j7, function9, function2M3112getLambda$463596174$material3, function4, composer2, (i4 >> 3) & 524286);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j4 = j6;
                j5 = j7;
                function7 = function9;
                function8 = function2M3112getLambda$463596174$material3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                j4 = secondaryContainerColor;
                j5 = j3;
                function7 = function5;
                function8 = function6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        function5 = function3;
        i7 = i3 & 32;
        if (i7 != 0) {
            if ((196608 & i2) == 0) {
                function6 = function2;
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i4 |= i8;
            }
            if ((1572864 & i2) != 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i4 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "203@10407L23,204@10473L21,206@10574L160");
                if ((i2 & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        secondaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(959948692, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        modifier3 = companion;
                        j7 = secondaryContentColor;
                        j6 = secondaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3112getLambda$463596174$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3112getLambda$463596174$material3();
                        i9 = 563434725;
                    } else {
                        modifier3 = companion;
                        j6 = secondaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3112getLambda$463596174$material3 = function6;
                        i9 = 563434725;
                        j7 = secondaryContentColor;
                    }
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        secondaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(959948692, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        modifier3 = companion;
                        j7 = secondaryContentColor;
                        j6 = secondaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3112getLambda$463596174$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3112getLambda$463596174$material3();
                        i9 = 563434725;
                    } else {
                        modifier3 = companion;
                        j6 = secondaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3112getLambda$463596174$material3 = function6;
                        i9 = 563434725;
                        j7 = secondaryContentColor;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.SecondaryTabRow (TabRow.kt:213)");
                }
                composer2 = composerStartRestartGroup;
                m4396TabRowImplDTcfvLk(modifier3, j6, j7, function9, function2M3112getLambda$463596174$material3, function4, composer2, (i4 >> 3) & 524286);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j4 = j6;
                j5 = j7;
                function7 = function9;
                function8 = function2M3112getLambda$463596174$material3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                j4 = secondaryContainerColor;
                j5 = j3;
                function7 = function5;
                function8 = function6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function6 = function2;
        if ((1572864 & i2) != 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i10 = 1048576;
            } else {
                i10 = 524288;
            }
            i4 |= i10;
        }
        if ((i4 & 599187) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "203@10407L23,204@10473L21,206@10574L160");
            if ((i2 & 1) != 0) {
                if (i11 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i3 & 4) != 0) {
                    secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    secondaryContentColor = j3;
                }
                if (i5 != 0) {
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(959948692, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    composableLambdaRememberComposableLambda = function5;
                }
                if (i7 != 0) {
                    modifier3 = companion;
                    j7 = secondaryContentColor;
                    j6 = secondaryContainerColor;
                    function9 = composableLambdaRememberComposableLambda;
                    function2M3112getLambda$463596174$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3112getLambda$463596174$material3();
                    i9 = 563434725;
                } else {
                    modifier3 = companion;
                    j6 = secondaryContainerColor;
                    function9 = composableLambdaRememberComposableLambda;
                    function2M3112getLambda$463596174$material3 = function6;
                    i9 = 563434725;
                    j7 = secondaryContentColor;
                }
            } else {
                if (i11 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i3 & 4) != 0) {
                    secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    secondaryContentColor = j3;
                }
                if (i5 != 0) {
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(959948692, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    composableLambdaRememberComposableLambda = function5;
                }
                if (i7 != 0) {
                    modifier3 = companion;
                    j7 = secondaryContentColor;
                    j6 = secondaryContainerColor;
                    function9 = composableLambdaRememberComposableLambda;
                    function2M3112getLambda$463596174$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3112getLambda$463596174$material3();
                    i9 = 563434725;
                } else {
                    modifier3 = companion;
                    j6 = secondaryContainerColor;
                    function9 = composableLambdaRememberComposableLambda;
                    function2M3112getLambda$463596174$material3 = function6;
                    i9 = 563434725;
                    j7 = secondaryContentColor;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.SecondaryTabRow (TabRow.kt:213)");
            }
            composer2 = composerStartRestartGroup;
            m4396TabRowImplDTcfvLk(modifier3, j6, j7, function9, function2M3112getLambda$463596174$material3, function4, composer2, (i4 >> 3) & 524286);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            j4 = j6;
            j5 = j7;
            function7 = function9;
            function8 = function2M3112getLambda$463596174$material3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier2 = modifier;
            j4 = secondaryContainerColor;
            j5 = j3;
            function7 = function5;
            function8 = function6;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrimaryScrollableTabRow_cx2KkNY$lambda$0(int i, TabIndicatorScope tabIndicatorScope, Composer composer, int i2) {
        int i3;
        ComposerKt.sourceInformation(composer, "C261@13657L159:TabRow.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = ((i2 & 8) == 0 ? composer.changed(tabIndicatorScope) : composer.changedInstance(tabIndicatorScope) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if (!composer.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(835301263, i3, -1, "androidx.compose.material3.PrimaryScrollableTabRow.<anonymous> (TabRow.kt:261)");
            }
            TabRowDefaults.INSTANCE.m4372PrimaryIndicator10LGxhE(tabIndicatorScope.tabIndicatorOffset(Modifier.INSTANCE, i, true), Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM(), 0.0f, 0L, null, composer, 196656, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x011f  */
    /* JADX WARN: Code duplicated, block: B:102:0x0122  */
    /* JADX WARN: Code duplicated, block: B:106:0x0133  */
    /* JADX WARN: Code duplicated, block: B:107:0x0135  */
    /* JADX WARN: Code duplicated, block: B:110:0x013e  */
    /* JADX WARN: Code duplicated, block: B:112:0x014d  */
    /* JADX WARN: Code duplicated, block: B:125:0x017b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:126:0x017d  */
    /* JADX WARN: Code duplicated, block: B:127:0x0182  */
    /* JADX WARN: Code duplicated, block: B:130:0x018a  */
    /* JADX WARN: Code duplicated, block: B:131:0x0192  */
    /* JADX WARN: Code duplicated, block: B:134:0x0198  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:138:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:139:0x01af  */
    /* JADX WARN: Code duplicated, block: B:141:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:144:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:145:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:147:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:148:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:150:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:151:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:154:0x0203  */
    /* JADX WARN: Code duplicated, block: B:155:0x020f  */
    /* JADX WARN: Code duplicated, block: B:158:0x024a  */
    /* JADX WARN: Code duplicated, block: B:160:0x0257  */
    /* JADX WARN: Code duplicated, block: B:163:0x026c  */
    /* JADX WARN: Code duplicated, block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0063  */
    /* JADX WARN: Code duplicated, block: B:38:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:45:0x007a  */
    /* JADX WARN: Code duplicated, block: B:47:0x007e  */
    /* JADX WARN: Code duplicated, block: B:49:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:53:0x008f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0097  */
    /* JADX WARN: Code duplicated, block: B:57:0x0099  */
    /* JADX WARN: Code duplicated, block: B:59:0x009c  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:70:0x00be  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:80:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:93:0x0105  */
    /* JADX WARN: Code duplicated, block: B:94:0x0108  */
    /* JADX WARN: Code duplicated, block: B:99:0x0119  */
    /* JADX INFO: renamed from: PrimaryScrollableTabRow-cx2KkNY, reason: not valid java name */
    public static final void m4386PrimaryScrollableTabRowcx2KkNY(final int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, float f2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3) {
        int i4;
        ScrollState scrollState2;
        long j3;
        long j4;
        int i5;
        float f3;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function2M3113getLambda$773954579$material3;
        final ScrollState scrollState3;
        final long j5;
        final long j6;
        final float f4;
        final ComposableLambda composableLambdaRememberComposableLambda;
        final float f5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        ScrollState scrollStateRememberScrollState;
        long primaryContainerColor;
        long primaryContentColor;
        float fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
        int i13;
        float fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
        ScrollState scrollState4;
        long j7;
        float f6;
        long j8;
        int i14;
        Composer composerStartRestartGroup = composer.startRestartGroup(450849184);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PrimaryScrollableTabRow)N(selectedTabIndex,modifier,scrollState,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,indicator,divider,minTabWidth:c#ui.unit.Dp,tabs)270@14011L363:TabRow.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i15 = i3 & 2;
        if (i15 == 0) {
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                if ((i3 & 4) == 0) {
                    scrollState2 = scrollState;
                    int i16 = composerStartRestartGroup.changed(scrollState2) ? 256 : 128;
                    i4 |= i16;
                } else {
                    scrollState2 = scrollState;
                }
                i4 |= i16;
            } else {
                scrollState2 = scrollState;
            }
            if ((i2 & 3072) == 0) {
                if ((i3 & 8) == 0) {
                    j3 = j;
                    int i17 = composerStartRestartGroup.changed(j3) ? 2048 : 1024;
                    i4 |= i17;
                } else {
                    j3 = j;
                }
                i4 |= i17;
            } else {
                j3 = j;
            }
            if ((i2 & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    j4 = j2;
                    int i18 = composerStartRestartGroup.changed(j4) ? 16384 : 8192;
                    i4 |= i18;
                } else {
                    j4 = j2;
                }
                i4 |= i18;
            } else {
                j4 = j2;
            }
            i5 = i3 & 32;
            if (i5 != 0) {
                if ((196608 & i2) == 0) {
                    f3 = f;
                    if (composerStartRestartGroup.changed(f3)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 128;
                if (i9 != 0) {
                    if ((i2 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i10 = 8388608;
                        } else {
                            i10 = 4194304;
                        }
                        i4 |= i10;
                    }
                    i11 = i3 & 256;
                    if (i11 != 0) {
                        if ((i2 & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(f2)) {
                                i12 = 67108864;
                            } else {
                                i12 = 33554432;
                            }
                            i4 |= i12;
                        }
                        if ((i2 & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i14 = 268435456;
                            }
                            i4 |= i14;
                        }
                        if ((i4 & 306783379) != 306783378) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "255@13328L21,256@13394L21,257@13458L19,260@13628L198");
                            if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i15 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if ((i3 & 4) != 0) {
                                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                    i4 &= -897;
                                } else {
                                    scrollStateRememberScrollState = scrollState2;
                                }
                                if ((i3 & 8) != 0) {
                                    primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -7169;
                                } else {
                                    primaryContainerColor = j3;
                                }
                                if ((i3 & 16) != 0) {
                                    primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                                    i4 &= -57345;
                                } else {
                                    primaryContentColor = j4;
                                }
                                if (i5 != 0) {
                                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                                } else {
                                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                                }
                                if (i7 != 0) {
                                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                                            return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                        }
                                    }, composerStartRestartGroup, 54);
                                } else {
                                    composableLambdaRememberComposableLambda = function3;
                                }
                                if (i9 != 0) {
                                    function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                                } else {
                                    function2M3113getLambda$773954579$material3 = function2;
                                }
                                if (i11 != 0) {
                                    i13 = i4;
                                    long j9 = primaryContentColor;
                                    scrollState4 = scrollStateRememberScrollState;
                                    j7 = primaryContainerColor;
                                    fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                                    f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                    j8 = j9;
                                } else {
                                    i13 = i4;
                                    long j10 = primaryContentColor;
                                    fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                    scrollState4 = scrollStateRememberScrollState;
                                    j7 = primaryContainerColor;
                                    f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                    j8 = j10;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                if ((i3 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                long j11 = j4;
                                scrollState4 = scrollState2;
                                j8 = j11;
                                float f7 = f3;
                                i13 = i4;
                                j7 = j3;
                                f6 = f7;
                                companion = modifier;
                                composableLambdaRememberComposableLambda = function3;
                                function2M3113getLambda$773954579$material3 = function2;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(450849184, i13, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:269)");
                            }
                            int i19 = i13 >> 3;
                            int i20 = (i13 & 126) | (i19 & 896) | (i19 & 7168) | (i19 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                            int i21 = i13 << 3;
                            int i22 = i20 | (29360128 & i21) | (i21 & 234881024) | (1879048192 & i13);
                            Modifier modifier3 = companion;
                            m4390ScrollableTabRowImplxam5sdo(i, modifier3, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, function4, composerStartRestartGroup, i22);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                            long j12 = j7;
                            modifier2 = modifier3;
                            scrollState3 = scrollState4;
                            f4 = f6;
                            j6 = j8;
                            j5 = j12;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            function2M3113getLambda$773954579$material3 = function2;
                            scrollState3 = scrollState2;
                            j5 = j3;
                            j6 = j4;
                            f4 = f3;
                            composableLambdaRememberComposableLambda = function3;
                            f5 = f2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda30
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i4 |= 100663296;
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    if ((i4 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "255@13328L21,256@13394L21,257@13458L19,260@13628L198");
                        if ((i2 & 1) != 0) {
                            if (i15 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i4 &= -897;
                            } else {
                                scrollStateRememberScrollState = scrollState2;
                            }
                            if ((i3 & 8) != 0) {
                                primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                primaryContainerColor = j3;
                            }
                            if ((i3 & 16) != 0) {
                                primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                primaryContentColor = j4;
                            }
                            if (i5 != 0) {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                            } else {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function3;
                            }
                            if (i9 != 0) {
                                function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                            } else {
                                function2M3113getLambda$773954579$material3 = function2;
                            }
                            if (i11 != 0) {
                                i13 = i4;
                                long j13 = primaryContentColor;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = primaryContainerColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j13;
                            } else {
                                i13 = i4;
                                long j14 = primaryContentColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = primaryContainerColor;
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j14;
                            }
                        } else {
                            if (i15 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i4 &= -897;
                            } else {
                                scrollStateRememberScrollState = scrollState2;
                            }
                            if ((i3 & 8) != 0) {
                                primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                primaryContainerColor = j3;
                            }
                            if ((i3 & 16) != 0) {
                                primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                primaryContentColor = j4;
                            }
                            if (i5 != 0) {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                            } else {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function3;
                            }
                            if (i9 != 0) {
                                function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                            } else {
                                function2M3113getLambda$773954579$material3 = function2;
                            }
                            if (i11 != 0) {
                                i13 = i4;
                                long j15 = primaryContentColor;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = primaryContainerColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j15;
                            } else {
                                i13 = i4;
                                long j16 = primaryContentColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = primaryContainerColor;
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j16;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(450849184, i13, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:269)");
                        }
                        int i110 = i13 >> 3;
                        int i23 = (i13 & 126) | (i110 & 896) | (i110 & 7168) | (i110 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                        int i24 = i13 << 3;
                        int i25 = i23 | (29360128 & i24) | (i24 & 234881024) | (1879048192 & i13);
                        Modifier modifier4 = companion;
                        m4390ScrollableTabRowImplxam5sdo(i, modifier4, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, function4, composerStartRestartGroup, i25);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                        long j17 = j7;
                        modifier2 = modifier4;
                        scrollState3 = scrollState4;
                        f4 = f6;
                        j6 = j8;
                        j5 = j17;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        function2M3113getLambda$773954579$material3 = function2;
                        scrollState3 = scrollState2;
                        j5 = j3;
                        j6 = j4;
                        f4 = f3;
                        composableLambdaRememberComposableLambda = function3;
                        f5 = f2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 12582912;
                i11 = i3 & 256;
                if (i11 != 0) {
                    if ((i2 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(f2)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                        i4 |= i12;
                    }
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    if ((i4 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "255@13328L21,256@13394L21,257@13458L19,260@13628L198");
                        if ((i2 & 1) != 0) {
                            if (i15 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i4 &= -897;
                            } else {
                                scrollStateRememberScrollState = scrollState2;
                            }
                            if ((i3 & 8) != 0) {
                                primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                primaryContainerColor = j3;
                            }
                            if ((i3 & 16) != 0) {
                                primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                primaryContentColor = j4;
                            }
                            if (i5 != 0) {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                            } else {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function3;
                            }
                            if (i9 != 0) {
                                function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                            } else {
                                function2M3113getLambda$773954579$material3 = function2;
                            }
                            if (i11 != 0) {
                                i13 = i4;
                                long j18 = primaryContentColor;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = primaryContainerColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j18;
                            } else {
                                i13 = i4;
                                long j19 = primaryContentColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = primaryContainerColor;
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j19;
                            }
                        } else {
                            if (i15 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i4 &= -897;
                            } else {
                                scrollStateRememberScrollState = scrollState2;
                            }
                            if ((i3 & 8) != 0) {
                                primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                primaryContainerColor = j3;
                            }
                            if ((i3 & 16) != 0) {
                                primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                primaryContentColor = j4;
                            }
                            if (i5 != 0) {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                            } else {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function3;
                            }
                            if (i9 != 0) {
                                function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                            } else {
                                function2M3113getLambda$773954579$material3 = function2;
                            }
                            if (i11 != 0) {
                                i13 = i4;
                                long j110 = primaryContentColor;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = primaryContainerColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j110;
                            } else {
                                i13 = i4;
                                long j111 = primaryContentColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = primaryContainerColor;
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j111;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(450849184, i13, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:269)");
                        }
                        int i111 = i13 >> 3;
                        int i26 = (i13 & 126) | (i111 & 896) | (i111 & 7168) | (i111 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                        int i27 = i13 << 3;
                        int i28 = i26 | (29360128 & i27) | (i27 & 234881024) | (1879048192 & i13);
                        Modifier modifier5 = companion;
                        m4390ScrollableTabRowImplxam5sdo(i, modifier5, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, function4, composerStartRestartGroup, i28);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                        long j112 = j7;
                        modifier2 = modifier5;
                        scrollState3 = scrollState4;
                        f4 = f6;
                        j6 = j8;
                        j5 = j112;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        function2M3113getLambda$773954579$material3 = function2;
                        scrollState3 = scrollState2;
                        j5 = j3;
                        j6 = j4;
                        f4 = f3;
                        composableLambdaRememberComposableLambda = function3;
                        f5 = f2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 100663296;
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i4 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "255@13328L21,256@13394L21,257@13458L19,260@13628L198");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            primaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                        } else {
                            function2M3113getLambda$773954579$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j113 = primaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j113;
                        } else {
                            i13 = i4;
                            long j114 = primaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j114;
                        }
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            primaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                        } else {
                            function2M3113getLambda$773954579$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j115 = primaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j115;
                        } else {
                            i13 = i4;
                            long j116 = primaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j116;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(450849184, i13, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:269)");
                    }
                    int i112 = i13 >> 3;
                    int i29 = (i13 & 126) | (i112 & 896) | (i112 & 7168) | (i112 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                    int i210 = i13 << 3;
                    int i211 = i29 | (29360128 & i210) | (i210 & 234881024) | (1879048192 & i13);
                    Modifier modifier6 = companion;
                    m4390ScrollableTabRowImplxam5sdo(i, modifier6, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, function4, composerStartRestartGroup, i211);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                    long j117 = j7;
                    modifier2 = modifier6;
                    scrollState3 = scrollState4;
                    f4 = f6;
                    j6 = j8;
                    j5 = j117;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    function2M3113getLambda$773954579$material3 = function2;
                    scrollState3 = scrollState2;
                    j5 = j3;
                    j6 = j4;
                    f4 = f3;
                    composableLambdaRememberComposableLambda = function3;
                    f5 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            f3 = f;
            i7 = i3 & 64;
            if (i7 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i4 |= i8;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 256;
                if (i11 != 0) {
                    if ((i2 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(f2)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                        i4 |= i12;
                    }
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    if ((i4 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "255@13328L21,256@13394L21,257@13458L19,260@13628L198");
                        if ((i2 & 1) != 0) {
                            if (i15 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i4 &= -897;
                            } else {
                                scrollStateRememberScrollState = scrollState2;
                            }
                            if ((i3 & 8) != 0) {
                                primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                primaryContainerColor = j3;
                            }
                            if ((i3 & 16) != 0) {
                                primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                primaryContentColor = j4;
                            }
                            if (i5 != 0) {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                            } else {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function3;
                            }
                            if (i9 != 0) {
                                function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                            } else {
                                function2M3113getLambda$773954579$material3 = function2;
                            }
                            if (i11 != 0) {
                                i13 = i4;
                                long j118 = primaryContentColor;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = primaryContainerColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j118;
                            } else {
                                i13 = i4;
                                long j119 = primaryContentColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = primaryContainerColor;
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j119;
                            }
                        } else {
                            if (i15 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i4 &= -897;
                            } else {
                                scrollStateRememberScrollState = scrollState2;
                            }
                            if ((i3 & 8) != 0) {
                                primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                primaryContainerColor = j3;
                            }
                            if ((i3 & 16) != 0) {
                                primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                primaryContentColor = j4;
                            }
                            if (i5 != 0) {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                            } else {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function3;
                            }
                            if (i9 != 0) {
                                function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                            } else {
                                function2M3113getLambda$773954579$material3 = function2;
                            }
                            if (i11 != 0) {
                                i13 = i4;
                                long j1110 = primaryContentColor;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = primaryContainerColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j1110;
                            } else {
                                i13 = i4;
                                long j1111 = primaryContentColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = primaryContainerColor;
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j1111;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(450849184, i13, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:269)");
                        }
                        int i113 = i13 >> 3;
                        int i212 = (i13 & 126) | (i113 & 896) | (i113 & 7168) | (i113 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                        int i213 = i13 << 3;
                        int i214 = i212 | (29360128 & i213) | (i213 & 234881024) | (1879048192 & i13);
                        Modifier modifier7 = companion;
                        m4390ScrollableTabRowImplxam5sdo(i, modifier7, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, function4, composerStartRestartGroup, i214);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                        long j1112 = j7;
                        modifier2 = modifier7;
                        scrollState3 = scrollState4;
                        f4 = f6;
                        j6 = j8;
                        j5 = j1112;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        function2M3113getLambda$773954579$material3 = function2;
                        scrollState3 = scrollState2;
                        j5 = j3;
                        j6 = j4;
                        f4 = f3;
                        composableLambdaRememberComposableLambda = function3;
                        f5 = f2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 100663296;
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i4 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "255@13328L21,256@13394L21,257@13458L19,260@13628L198");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            primaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                        } else {
                            function2M3113getLambda$773954579$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j1113 = primaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j1113;
                        } else {
                            i13 = i4;
                            long j1114 = primaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j1114;
                        }
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            primaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                        } else {
                            function2M3113getLambda$773954579$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j1115 = primaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j1115;
                        } else {
                            i13 = i4;
                            long j1116 = primaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j1116;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(450849184, i13, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:269)");
                    }
                    int i114 = i13 >> 3;
                    int i215 = (i13 & 126) | (i114 & 896) | (i114 & 7168) | (i114 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                    int i216 = i13 << 3;
                    int i217 = i215 | (29360128 & i216) | (i216 & 234881024) | (1879048192 & i13);
                    Modifier modifier8 = companion;
                    m4390ScrollableTabRowImplxam5sdo(i, modifier8, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, function4, composerStartRestartGroup, i217);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                    long j1117 = j7;
                    modifier2 = modifier8;
                    scrollState3 = scrollState4;
                    f4 = f6;
                    j6 = j8;
                    j5 = j1117;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    function2M3113getLambda$773954579$material3 = function2;
                    scrollState3 = scrollState2;
                    j5 = j3;
                    j6 = j4;
                    f4 = f3;
                    composableLambdaRememberComposableLambda = function3;
                    f5 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 12582912;
            i11 = i3 & 256;
            if (i11 != 0) {
                if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i4 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "255@13328L21,256@13394L21,257@13458L19,260@13628L198");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            primaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                        } else {
                            function2M3113getLambda$773954579$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j1118 = primaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j1118;
                        } else {
                            i13 = i4;
                            long j1119 = primaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j1119;
                        }
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            primaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                        } else {
                            function2M3113getLambda$773954579$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j11110 = primaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j11110;
                        } else {
                            i13 = i4;
                            long j11111 = primaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j11111;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(450849184, i13, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:269)");
                    }
                    int i115 = i13 >> 3;
                    int i218 = (i13 & 126) | (i115 & 896) | (i115 & 7168) | (i115 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                    int i219 = i13 << 3;
                    int i2110 = i218 | (29360128 & i219) | (i219 & 234881024) | (1879048192 & i13);
                    Modifier modifier9 = companion;
                    m4390ScrollableTabRowImplxam5sdo(i, modifier9, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, function4, composerStartRestartGroup, i2110);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                    long j11112 = j7;
                    modifier2 = modifier9;
                    scrollState3 = scrollState4;
                    f4 = f6;
                    j6 = j8;
                    j5 = j11112;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    function2M3113getLambda$773954579$material3 = function2;
                    scrollState3 = scrollState2;
                    j5 = j3;
                    j6 = j4;
                    f4 = f3;
                    composableLambdaRememberComposableLambda = function3;
                    f5 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            if ((i4 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "255@13328L21,256@13394L21,257@13458L19,260@13628L198");
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -897;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContainerColor = j3;
                    }
                    if ((i3 & 16) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        primaryContentColor = j4;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                    } else {
                        function2M3113getLambda$773954579$material3 = function2;
                    }
                    if (i11 != 0) {
                        i13 = i4;
                        long j11113 = primaryContentColor;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = primaryContainerColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j11113;
                    } else {
                        i13 = i4;
                        long j11114 = primaryContentColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = primaryContainerColor;
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j11114;
                    }
                } else {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -897;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContainerColor = j3;
                    }
                    if ((i3 & 16) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        primaryContentColor = j4;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                    } else {
                        function2M3113getLambda$773954579$material3 = function2;
                    }
                    if (i11 != 0) {
                        i13 = i4;
                        long j11115 = primaryContentColor;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = primaryContainerColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j11115;
                    } else {
                        i13 = i4;
                        long j11116 = primaryContentColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = primaryContainerColor;
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j11116;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(450849184, i13, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:269)");
                }
                int i116 = i13 >> 3;
                int i2111 = (i13 & 126) | (i116 & 896) | (i116 & 7168) | (i116 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                int i2112 = i13 << 3;
                int i2113 = i2111 | (29360128 & i2112) | (i2112 & 234881024) | (1879048192 & i13);
                Modifier modifier10 = companion;
                m4390ScrollableTabRowImplxam5sdo(i, modifier10, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, function4, composerStartRestartGroup, i2113);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                long j11117 = j7;
                modifier2 = modifier10;
                scrollState3 = scrollState4;
                f4 = f6;
                j6 = j8;
                j5 = j11117;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                function2M3113getLambda$773954579$material3 = function2;
                scrollState3 = scrollState2;
                j5 = j3;
                j6 = j4;
                f4 = f3;
                composableLambdaRememberComposableLambda = function3;
                f5 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        if ((i2 & 384) == 0) {
            if ((i3 & 4) == 0) {
                scrollState2 = scrollState;
                if (composerStartRestartGroup.changed(scrollState2)) {
                }
                i4 |= i16;
            } else {
                scrollState2 = scrollState;
            }
            i4 |= i16;
        } else {
            scrollState2 = scrollState;
        }
        if ((i2 & 3072) == 0) {
            if ((i3 & 8) == 0) {
                j3 = j;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i4 |= i17;
            } else {
                j3 = j;
            }
            i4 |= i17;
        } else {
            j3 = j;
        }
        if ((i2 & 24576) == 0) {
            if ((i3 & 16) == 0) {
                j4 = j2;
                if (composerStartRestartGroup.changed(j4)) {
                }
                i4 |= i18;
            } else {
                j4 = j2;
            }
            i4 |= i18;
        } else {
            j4 = j2;
        }
        i5 = i3 & 32;
        if (i5 != 0) {
            if ((196608 & i2) == 0) {
                f3 = f;
                if (composerStartRestartGroup.changed(f3)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
            i7 = i3 & 64;
            if (i7 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i4 |= i8;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 256;
                if (i11 != 0) {
                    if ((i2 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(f2)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                        i4 |= i12;
                    }
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    if ((i4 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "255@13328L21,256@13394L21,257@13458L19,260@13628L198");
                        if ((i2 & 1) != 0) {
                            if (i15 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i4 &= -897;
                            } else {
                                scrollStateRememberScrollState = scrollState2;
                            }
                            if ((i3 & 8) != 0) {
                                primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                primaryContainerColor = j3;
                            }
                            if ((i3 & 16) != 0) {
                                primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                primaryContentColor = j4;
                            }
                            if (i5 != 0) {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                            } else {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function3;
                            }
                            if (i9 != 0) {
                                function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                            } else {
                                function2M3113getLambda$773954579$material3 = function2;
                            }
                            if (i11 != 0) {
                                i13 = i4;
                                long j11118 = primaryContentColor;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = primaryContainerColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j11118;
                            } else {
                                i13 = i4;
                                long j11119 = primaryContentColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = primaryContainerColor;
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j11119;
                            }
                        } else {
                            if (i15 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i4 &= -897;
                            } else {
                                scrollStateRememberScrollState = scrollState2;
                            }
                            if ((i3 & 8) != 0) {
                                primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                primaryContainerColor = j3;
                            }
                            if ((i3 & 16) != 0) {
                                primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                primaryContentColor = j4;
                            }
                            if (i5 != 0) {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                            } else {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function3;
                            }
                            if (i9 != 0) {
                                function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                            } else {
                                function2M3113getLambda$773954579$material3 = function2;
                            }
                            if (i11 != 0) {
                                i13 = i4;
                                long j111110 = primaryContentColor;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = primaryContainerColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j111110;
                            } else {
                                i13 = i4;
                                long j111111 = primaryContentColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = primaryContainerColor;
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j111111;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(450849184, i13, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:269)");
                        }
                        int i117 = i13 >> 3;
                        int i2114 = (i13 & 126) | (i117 & 896) | (i117 & 7168) | (i117 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                        int i2115 = i13 << 3;
                        int i2116 = i2114 | (29360128 & i2115) | (i2115 & 234881024) | (1879048192 & i13);
                        Modifier modifier11 = companion;
                        m4390ScrollableTabRowImplxam5sdo(i, modifier11, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, function4, composerStartRestartGroup, i2116);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                        long j111112 = j7;
                        modifier2 = modifier11;
                        scrollState3 = scrollState4;
                        f4 = f6;
                        j6 = j8;
                        j5 = j111112;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        function2M3113getLambda$773954579$material3 = function2;
                        scrollState3 = scrollState2;
                        j5 = j3;
                        j6 = j4;
                        f4 = f3;
                        composableLambdaRememberComposableLambda = function3;
                        f5 = f2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 100663296;
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i4 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "255@13328L21,256@13394L21,257@13458L19,260@13628L198");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            primaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                        } else {
                            function2M3113getLambda$773954579$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j111113 = primaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j111113;
                        } else {
                            i13 = i4;
                            long j111114 = primaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j111114;
                        }
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            primaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                        } else {
                            function2M3113getLambda$773954579$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j111115 = primaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j111115;
                        } else {
                            i13 = i4;
                            long j111116 = primaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j111116;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(450849184, i13, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:269)");
                    }
                    int i118 = i13 >> 3;
                    int i2117 = (i13 & 126) | (i118 & 896) | (i118 & 7168) | (i118 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                    int i2118 = i13 << 3;
                    int i2119 = i2117 | (29360128 & i2118) | (i2118 & 234881024) | (1879048192 & i13);
                    Modifier modifier12 = companion;
                    m4390ScrollableTabRowImplxam5sdo(i, modifier12, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, function4, composerStartRestartGroup, i2119);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                    long j111117 = j7;
                    modifier2 = modifier12;
                    scrollState3 = scrollState4;
                    f4 = f6;
                    j6 = j8;
                    j5 = j111117;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    function2M3113getLambda$773954579$material3 = function2;
                    scrollState3 = scrollState2;
                    j5 = j3;
                    j6 = j4;
                    f4 = f3;
                    composableLambdaRememberComposableLambda = function3;
                    f5 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 12582912;
            i11 = i3 & 256;
            if (i11 != 0) {
                if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i4 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "255@13328L21,256@13394L21,257@13458L19,260@13628L198");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            primaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                        } else {
                            function2M3113getLambda$773954579$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j111118 = primaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j111118;
                        } else {
                            i13 = i4;
                            long j111119 = primaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j111119;
                        }
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            primaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                        } else {
                            function2M3113getLambda$773954579$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j1111110 = primaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j1111110;
                        } else {
                            i13 = i4;
                            long j1111111 = primaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j1111111;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(450849184, i13, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:269)");
                    }
                    int i119 = i13 >> 3;
                    int i21110 = (i13 & 126) | (i119 & 896) | (i119 & 7168) | (i119 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                    int i21111 = i13 << 3;
                    int i21112 = i21110 | (29360128 & i21111) | (i21111 & 234881024) | (1879048192 & i13);
                    Modifier modifier13 = companion;
                    m4390ScrollableTabRowImplxam5sdo(i, modifier13, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, function4, composerStartRestartGroup, i21112);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                    long j1111112 = j7;
                    modifier2 = modifier13;
                    scrollState3 = scrollState4;
                    f4 = f6;
                    j6 = j8;
                    j5 = j1111112;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    function2M3113getLambda$773954579$material3 = function2;
                    scrollState3 = scrollState2;
                    j5 = j3;
                    j6 = j4;
                    f4 = f3;
                    composableLambdaRememberComposableLambda = function3;
                    f5 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            if ((i4 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "255@13328L21,256@13394L21,257@13458L19,260@13628L198");
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -897;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContainerColor = j3;
                    }
                    if ((i3 & 16) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        primaryContentColor = j4;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                    } else {
                        function2M3113getLambda$773954579$material3 = function2;
                    }
                    if (i11 != 0) {
                        i13 = i4;
                        long j1111113 = primaryContentColor;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = primaryContainerColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j1111113;
                    } else {
                        i13 = i4;
                        long j1111114 = primaryContentColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = primaryContainerColor;
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j1111114;
                    }
                } else {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -897;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContainerColor = j3;
                    }
                    if ((i3 & 16) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        primaryContentColor = j4;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                    } else {
                        function2M3113getLambda$773954579$material3 = function2;
                    }
                    if (i11 != 0) {
                        i13 = i4;
                        long j1111115 = primaryContentColor;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = primaryContainerColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j1111115;
                    } else {
                        i13 = i4;
                        long j1111116 = primaryContentColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = primaryContainerColor;
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j1111116;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(450849184, i13, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:269)");
                }
                int i1110 = i13 >> 3;
                int i21113 = (i13 & 126) | (i1110 & 896) | (i1110 & 7168) | (i1110 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                int i21114 = i13 << 3;
                int i21115 = i21113 | (29360128 & i21114) | (i21114 & 234881024) | (1879048192 & i13);
                Modifier modifier14 = companion;
                m4390ScrollableTabRowImplxam5sdo(i, modifier14, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, function4, composerStartRestartGroup, i21115);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                long j1111117 = j7;
                modifier2 = modifier14;
                scrollState3 = scrollState4;
                f4 = f6;
                j6 = j8;
                j5 = j1111117;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                function2M3113getLambda$773954579$material3 = function2;
                scrollState3 = scrollState2;
                j5 = j3;
                j6 = j4;
                f4 = f3;
                composableLambdaRememberComposableLambda = function3;
                f5 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        f3 = f;
        i7 = i3 & 64;
        if (i7 != 0) {
            i4 |= 1572864;
        } else if ((i2 & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i8 = 1048576;
            } else {
                i8 = 524288;
            }
            i4 |= i8;
        }
        i9 = i3 & 128;
        if (i9 != 0) {
            if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i4 |= i10;
            }
            i11 = i3 & 256;
            if (i11 != 0) {
                if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i4 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "255@13328L21,256@13394L21,257@13458L19,260@13628L198");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            primaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                        } else {
                            function2M3113getLambda$773954579$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j1111118 = primaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j1111118;
                        } else {
                            i13 = i4;
                            long j1111119 = primaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j1111119;
                        }
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            primaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                        } else {
                            function2M3113getLambda$773954579$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j11111110 = primaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j11111110;
                        } else {
                            i13 = i4;
                            long j11111111 = primaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = primaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j11111111;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(450849184, i13, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:269)");
                    }
                    int i1111 = i13 >> 3;
                    int i21116 = (i13 & 126) | (i1111 & 896) | (i1111 & 7168) | (i1111 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                    int i21117 = i13 << 3;
                    int i21118 = i21116 | (29360128 & i21117) | (i21117 & 234881024) | (1879048192 & i13);
                    Modifier modifier15 = companion;
                    m4390ScrollableTabRowImplxam5sdo(i, modifier15, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, function4, composerStartRestartGroup, i21118);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                    long j11111112 = j7;
                    modifier2 = modifier15;
                    scrollState3 = scrollState4;
                    f4 = f6;
                    j6 = j8;
                    j5 = j11111112;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    function2M3113getLambda$773954579$material3 = function2;
                    scrollState3 = scrollState2;
                    j5 = j3;
                    j6 = j4;
                    f4 = f3;
                    composableLambdaRememberComposableLambda = function3;
                    f5 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            if ((i4 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "255@13328L21,256@13394L21,257@13458L19,260@13628L198");
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -897;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContainerColor = j3;
                    }
                    if ((i3 & 16) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        primaryContentColor = j4;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                    } else {
                        function2M3113getLambda$773954579$material3 = function2;
                    }
                    if (i11 != 0) {
                        i13 = i4;
                        long j11111113 = primaryContentColor;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = primaryContainerColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j11111113;
                    } else {
                        i13 = i4;
                        long j11111114 = primaryContentColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = primaryContainerColor;
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j11111114;
                    }
                } else {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -897;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContainerColor = j3;
                    }
                    if ((i3 & 16) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        primaryContentColor = j4;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                    } else {
                        function2M3113getLambda$773954579$material3 = function2;
                    }
                    if (i11 != 0) {
                        i13 = i4;
                        long j11111115 = primaryContentColor;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = primaryContainerColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j11111115;
                    } else {
                        i13 = i4;
                        long j11111116 = primaryContentColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = primaryContainerColor;
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j11111116;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(450849184, i13, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:269)");
                }
                int i1112 = i13 >> 3;
                int i21119 = (i13 & 126) | (i1112 & 896) | (i1112 & 7168) | (i1112 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                int i211110 = i13 << 3;
                int i211111 = i21119 | (29360128 & i211110) | (i211110 & 234881024) | (1879048192 & i13);
                Modifier modifier16 = companion;
                m4390ScrollableTabRowImplxam5sdo(i, modifier16, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, function4, composerStartRestartGroup, i211111);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                long j11111117 = j7;
                modifier2 = modifier16;
                scrollState3 = scrollState4;
                f4 = f6;
                j6 = j8;
                j5 = j11111117;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                function2M3113getLambda$773954579$material3 = function2;
                scrollState3 = scrollState2;
                j5 = j3;
                j6 = j4;
                f4 = f3;
                composableLambdaRememberComposableLambda = function3;
                f5 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 12582912;
        i11 = i3 & 256;
        if (i11 != 0) {
            if ((i2 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i4 |= i12;
            }
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            if ((i4 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "255@13328L21,256@13394L21,257@13458L19,260@13628L198");
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -897;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContainerColor = j3;
                    }
                    if ((i3 & 16) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        primaryContentColor = j4;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                    } else {
                        function2M3113getLambda$773954579$material3 = function2;
                    }
                    if (i11 != 0) {
                        i13 = i4;
                        long j11111118 = primaryContentColor;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = primaryContainerColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j11111118;
                    } else {
                        i13 = i4;
                        long j11111119 = primaryContentColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = primaryContainerColor;
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j11111119;
                    }
                } else {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -897;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContainerColor = j3;
                    }
                    if ((i3 & 16) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        primaryContentColor = j4;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                    } else {
                        function2M3113getLambda$773954579$material3 = function2;
                    }
                    if (i11 != 0) {
                        i13 = i4;
                        long j111111110 = primaryContentColor;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = primaryContainerColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j111111110;
                    } else {
                        i13 = i4;
                        long j111111111 = primaryContentColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = primaryContainerColor;
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j111111111;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(450849184, i13, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:269)");
                }
                int i1113 = i13 >> 3;
                int i211112 = (i13 & 126) | (i1113 & 896) | (i1113 & 7168) | (i1113 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                int i211113 = i13 << 3;
                int i211114 = i211112 | (29360128 & i211113) | (i211113 & 234881024) | (1879048192 & i13);
                Modifier modifier17 = companion;
                m4390ScrollableTabRowImplxam5sdo(i, modifier17, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, function4, composerStartRestartGroup, i211114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                long j111111112 = j7;
                modifier2 = modifier17;
                scrollState3 = scrollState4;
                f4 = f6;
                j6 = j8;
                j5 = j111111112;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                function2M3113getLambda$773954579$material3 = function2;
                scrollState3 = scrollState2;
                j5 = j3;
                j6 = j4;
                f4 = f3;
                composableLambdaRememberComposableLambda = function3;
                f5 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 100663296;
        if ((i2 & 805306368) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i14 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i14 = 268435456;
            }
            i4 |= i14;
        }
        if ((i4 & 306783379) != 306783378) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "255@13328L21,256@13394L21,257@13458L19,260@13628L198");
            if ((i2 & 1) != 0) {
                if (i15 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i3 & 4) != 0) {
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    i4 &= -897;
                } else {
                    scrollStateRememberScrollState = scrollState2;
                }
                if ((i3 & 8) != 0) {
                    primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    primaryContainerColor = j3;
                }
                if ((i3 & 16) != 0) {
                    primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    primaryContentColor = j4;
                }
                if (i5 != 0) {
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                } else {
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                }
                if (i7 != 0) {
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    composableLambdaRememberComposableLambda = function3;
                }
                if (i9 != 0) {
                    function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                } else {
                    function2M3113getLambda$773954579$material3 = function2;
                }
                if (i11 != 0) {
                    i13 = i4;
                    long j111111113 = primaryContentColor;
                    scrollState4 = scrollStateRememberScrollState;
                    j7 = primaryContainerColor;
                    fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                    f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    j8 = j111111113;
                } else {
                    i13 = i4;
                    long j111111114 = primaryContentColor;
                    fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                    scrollState4 = scrollStateRememberScrollState;
                    j7 = primaryContainerColor;
                    f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    j8 = j111111114;
                }
            } else {
                if (i15 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i3 & 4) != 0) {
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    i4 &= -897;
                } else {
                    scrollStateRememberScrollState = scrollState2;
                }
                if ((i3 & 8) != 0) {
                    primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    primaryContainerColor = j3;
                }
                if ((i3 & 16) != 0) {
                    primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    primaryContentColor = j4;
                }
                if (i5 != 0) {
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                } else {
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                }
                if (i7 != 0) {
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    composableLambdaRememberComposableLambda = function3;
                }
                if (i9 != 0) {
                    function2M3113getLambda$773954579$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3113getLambda$773954579$material3();
                } else {
                    function2M3113getLambda$773954579$material3 = function2;
                }
                if (i11 != 0) {
                    i13 = i4;
                    long j111111115 = primaryContentColor;
                    scrollState4 = scrollStateRememberScrollState;
                    j7 = primaryContainerColor;
                    fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                    f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    j8 = j111111115;
                } else {
                    i13 = i4;
                    long j111111116 = primaryContentColor;
                    fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                    scrollState4 = scrollStateRememberScrollState;
                    j7 = primaryContainerColor;
                    f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    j8 = j111111116;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(450849184, i13, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:269)");
            }
            int i1114 = i13 >> 3;
            int i211115 = (i13 & 126) | (i1114 & 896) | (i1114 & 7168) | (i1114 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
            int i211116 = i13 << 3;
            int i211117 = i211115 | (29360128 & i211116) | (i211116 & 234881024) | (1879048192 & i13);
            Modifier modifier18 = companion;
            m4390ScrollableTabRowImplxam5sdo(i, modifier18, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, function4, composerStartRestartGroup, i211117);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
            long j111111117 = j7;
            modifier2 = modifier18;
            scrollState3 = scrollState4;
            f4 = f6;
            j6 = j8;
            j5 = j111111117;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            function2M3113getLambda$773954579$material3 = function2;
            scrollState3 = scrollState2;
            j5 = j3;
            j6 = j4;
            f4 = f3;
            composableLambdaRememberComposableLambda = function3;
            f5 = f2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, function2M3113getLambda$773954579$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SecondaryScrollableTabRow_cx2KkNY$lambda$0(int i, TabIndicatorScope tabIndicatorScope, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C332@17381L121:TabRow.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i2 |= (i2 & 8) == 0 ? composer.changed(tabIndicatorScope) : composer.changedInstance(tabIndicatorScope) ? 4 : 2;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(610355265, i2, -1, "androidx.compose.material3.SecondaryScrollableTabRow.<anonymous> (TabRow.kt:332)");
            }
            TabRowDefaults.INSTANCE.m4373SecondaryIndicator9IZ8Weo(tabIndicatorScope.tabIndicatorOffset(Modifier.INSTANCE, i, false), 0.0f, 0L, composer, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x011f  */
    /* JADX WARN: Code duplicated, block: B:102:0x0122  */
    /* JADX WARN: Code duplicated, block: B:106:0x0133  */
    /* JADX WARN: Code duplicated, block: B:107:0x0135  */
    /* JADX WARN: Code duplicated, block: B:110:0x013e  */
    /* JADX WARN: Code duplicated, block: B:112:0x014d  */
    /* JADX WARN: Code duplicated, block: B:125:0x017b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:126:0x017d  */
    /* JADX WARN: Code duplicated, block: B:127:0x0182  */
    /* JADX WARN: Code duplicated, block: B:130:0x018a  */
    /* JADX WARN: Code duplicated, block: B:131:0x0192  */
    /* JADX WARN: Code duplicated, block: B:134:0x0198  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:138:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:139:0x01af  */
    /* JADX WARN: Code duplicated, block: B:141:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:144:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:145:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:147:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:148:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:150:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:151:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:154:0x0203  */
    /* JADX WARN: Code duplicated, block: B:155:0x020f  */
    /* JADX WARN: Code duplicated, block: B:158:0x024a  */
    /* JADX WARN: Code duplicated, block: B:160:0x0257  */
    /* JADX WARN: Code duplicated, block: B:163:0x026c  */
    /* JADX WARN: Code duplicated, block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0063  */
    /* JADX WARN: Code duplicated, block: B:38:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:45:0x007a  */
    /* JADX WARN: Code duplicated, block: B:47:0x007e  */
    /* JADX WARN: Code duplicated, block: B:49:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:53:0x008f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0097  */
    /* JADX WARN: Code duplicated, block: B:57:0x0099  */
    /* JADX WARN: Code duplicated, block: B:59:0x009c  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:70:0x00be  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:80:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:93:0x0105  */
    /* JADX WARN: Code duplicated, block: B:94:0x0108  */
    /* JADX WARN: Code duplicated, block: B:99:0x0119  */
    /* JADX INFO: renamed from: SecondaryScrollableTabRow-cx2KkNY, reason: not valid java name */
    public static final void m4392SecondaryScrollableTabRowcx2KkNY(final int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, float f2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3) {
        int i4;
        ScrollState scrollState2;
        long j3;
        long j4;
        int i5;
        float f3;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> lambda$303717663$material3;
        final ScrollState scrollState3;
        final long j5;
        final long j6;
        final float f4;
        final ComposableLambda composableLambdaRememberComposableLambda;
        final float f5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        ScrollState scrollStateRememberScrollState;
        long secondaryContainerColor;
        long secondaryContentColor;
        float fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
        int i13;
        float fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
        ScrollState scrollState4;
        long j7;
        float f6;
        long j8;
        int i14;
        Composer composerStartRestartGroup = composer.startRestartGroup(519094802);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SecondaryScrollableTabRow)N(selectedTabIndex,modifier,scrollState,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,indicator,divider,minTabWidth:c#ui.unit.Dp,tabs)340@17697L363:TabRow.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i15 = i3 & 2;
        if (i15 == 0) {
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                if ((i3 & 4) == 0) {
                    scrollState2 = scrollState;
                    int i16 = composerStartRestartGroup.changed(scrollState2) ? 256 : 128;
                    i4 |= i16;
                } else {
                    scrollState2 = scrollState;
                }
                i4 |= i16;
            } else {
                scrollState2 = scrollState;
            }
            if ((i2 & 3072) == 0) {
                if ((i3 & 8) == 0) {
                    j3 = j;
                    int i17 = composerStartRestartGroup.changed(j3) ? 2048 : 1024;
                    i4 |= i17;
                } else {
                    j3 = j;
                }
                i4 |= i17;
            } else {
                j3 = j;
            }
            if ((i2 & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    j4 = j2;
                    int i18 = composerStartRestartGroup.changed(j4) ? 16384 : 8192;
                    i4 |= i18;
                } else {
                    j4 = j2;
                }
                i4 |= i18;
            } else {
                j4 = j2;
            }
            i5 = i3 & 32;
            if (i5 != 0) {
                if ((196608 & i2) == 0) {
                    f3 = f;
                    if (composerStartRestartGroup.changed(f3)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 128;
                if (i9 != 0) {
                    if ((i2 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i10 = 8388608;
                        } else {
                            i10 = 4194304;
                        }
                        i4 |= i10;
                    }
                    i11 = i3 & 256;
                    if (i11 != 0) {
                        if ((i2 & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(f2)) {
                                i12 = 67108864;
                            } else {
                                i12 = 33554432;
                            }
                            i4 |= i12;
                        }
                        if ((i2 & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i14 = 268435456;
                            }
                            i4 |= i14;
                        }
                        if ((i4 & 306783379) != 306783378) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "326@17048L21,327@17114L23,328@17180L21,331@17352L160");
                            if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i15 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if ((i3 & 4) != 0) {
                                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                    i4 &= -897;
                                } else {
                                    scrollStateRememberScrollState = scrollState2;
                                }
                                if ((i3 & 8) != 0) {
                                    secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -7169;
                                } else {
                                    secondaryContainerColor = j3;
                                }
                                if ((i3 & 16) != 0) {
                                    secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                                    i4 &= -57345;
                                } else {
                                    secondaryContentColor = j4;
                                }
                                if (i5 != 0) {
                                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                                } else {
                                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                                }
                                if (i7 != 0) {
                                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                                            return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                        }
                                    }, composerStartRestartGroup, 54);
                                } else {
                                    composableLambdaRememberComposableLambda = function3;
                                }
                                if (i9 != 0) {
                                    lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                                } else {
                                    lambda$303717663$material3 = function2;
                                }
                                if (i11 != 0) {
                                    i13 = i4;
                                    long j9 = secondaryContentColor;
                                    scrollState4 = scrollStateRememberScrollState;
                                    j7 = secondaryContainerColor;
                                    fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                                    f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                    j8 = j9;
                                } else {
                                    i13 = i4;
                                    long j10 = secondaryContentColor;
                                    fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                    scrollState4 = scrollStateRememberScrollState;
                                    j7 = secondaryContainerColor;
                                    f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                    j8 = j10;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                if ((i3 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                long j11 = j4;
                                scrollState4 = scrollState2;
                                j8 = j11;
                                float f7 = f3;
                                i13 = i4;
                                j7 = j3;
                                f6 = f7;
                                companion = modifier;
                                composableLambdaRememberComposableLambda = function3;
                                lambda$303717663$material3 = function2;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(519094802, i13, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:339)");
                            }
                            int i19 = i13 >> 3;
                            int i20 = (i13 & 126) | (i19 & 896) | (i19 & 7168) | (i19 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                            int i21 = i13 << 3;
                            int i22 = i20 | (29360128 & i21) | (i21 & 234881024) | (1879048192 & i13);
                            Modifier modifier3 = companion;
                            m4390ScrollableTabRowImplxam5sdo(i, modifier3, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, lambda$303717663$material3, function4, composerStartRestartGroup, i22);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                            long j12 = j7;
                            modifier2 = modifier3;
                            scrollState3 = scrollState4;
                            f4 = f6;
                            j6 = j8;
                            j5 = j12;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            lambda$303717663$material3 = function2;
                            scrollState3 = scrollState2;
                            j5 = j3;
                            j6 = j4;
                            f4 = f3;
                            composableLambdaRememberComposableLambda = function3;
                            f5 = f2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, lambda$303717663$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i4 |= 100663296;
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    if ((i4 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "326@17048L21,327@17114L23,328@17180L21,331@17352L160");
                        if ((i2 & 1) != 0) {
                            if (i15 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i4 &= -897;
                            } else {
                                scrollStateRememberScrollState = scrollState2;
                            }
                            if ((i3 & 8) != 0) {
                                secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                secondaryContainerColor = j3;
                            }
                            if ((i3 & 16) != 0) {
                                secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                secondaryContentColor = j4;
                            }
                            if (i5 != 0) {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                            } else {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function3;
                            }
                            if (i9 != 0) {
                                lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                            } else {
                                lambda$303717663$material3 = function2;
                            }
                            if (i11 != 0) {
                                i13 = i4;
                                long j13 = secondaryContentColor;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = secondaryContainerColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j13;
                            } else {
                                i13 = i4;
                                long j14 = secondaryContentColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = secondaryContainerColor;
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j14;
                            }
                        } else {
                            if (i15 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i4 &= -897;
                            } else {
                                scrollStateRememberScrollState = scrollState2;
                            }
                            if ((i3 & 8) != 0) {
                                secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                secondaryContainerColor = j3;
                            }
                            if ((i3 & 16) != 0) {
                                secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                secondaryContentColor = j4;
                            }
                            if (i5 != 0) {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                            } else {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function3;
                            }
                            if (i9 != 0) {
                                lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                            } else {
                                lambda$303717663$material3 = function2;
                            }
                            if (i11 != 0) {
                                i13 = i4;
                                long j15 = secondaryContentColor;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = secondaryContainerColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j15;
                            } else {
                                i13 = i4;
                                long j16 = secondaryContentColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = secondaryContainerColor;
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j16;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(519094802, i13, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:339)");
                        }
                        int i110 = i13 >> 3;
                        int i23 = (i13 & 126) | (i110 & 896) | (i110 & 7168) | (i110 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                        int i24 = i13 << 3;
                        int i25 = i23 | (29360128 & i24) | (i24 & 234881024) | (1879048192 & i13);
                        Modifier modifier4 = companion;
                        m4390ScrollableTabRowImplxam5sdo(i, modifier4, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, lambda$303717663$material3, function4, composerStartRestartGroup, i25);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                        long j17 = j7;
                        modifier2 = modifier4;
                        scrollState3 = scrollState4;
                        f4 = f6;
                        j6 = j8;
                        j5 = j17;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        lambda$303717663$material3 = function2;
                        scrollState3 = scrollState2;
                        j5 = j3;
                        j6 = j4;
                        f4 = f3;
                        composableLambdaRememberComposableLambda = function3;
                        f5 = f2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, lambda$303717663$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 12582912;
                i11 = i3 & 256;
                if (i11 != 0) {
                    if ((i2 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(f2)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                        i4 |= i12;
                    }
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    if ((i4 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "326@17048L21,327@17114L23,328@17180L21,331@17352L160");
                        if ((i2 & 1) != 0) {
                            if (i15 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i4 &= -897;
                            } else {
                                scrollStateRememberScrollState = scrollState2;
                            }
                            if ((i3 & 8) != 0) {
                                secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                secondaryContainerColor = j3;
                            }
                            if ((i3 & 16) != 0) {
                                secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                secondaryContentColor = j4;
                            }
                            if (i5 != 0) {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                            } else {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function3;
                            }
                            if (i9 != 0) {
                                lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                            } else {
                                lambda$303717663$material3 = function2;
                            }
                            if (i11 != 0) {
                                i13 = i4;
                                long j18 = secondaryContentColor;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = secondaryContainerColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j18;
                            } else {
                                i13 = i4;
                                long j19 = secondaryContentColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = secondaryContainerColor;
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j19;
                            }
                        } else {
                            if (i15 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i4 &= -897;
                            } else {
                                scrollStateRememberScrollState = scrollState2;
                            }
                            if ((i3 & 8) != 0) {
                                secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                secondaryContainerColor = j3;
                            }
                            if ((i3 & 16) != 0) {
                                secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                secondaryContentColor = j4;
                            }
                            if (i5 != 0) {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                            } else {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function3;
                            }
                            if (i9 != 0) {
                                lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                            } else {
                                lambda$303717663$material3 = function2;
                            }
                            if (i11 != 0) {
                                i13 = i4;
                                long j110 = secondaryContentColor;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = secondaryContainerColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j110;
                            } else {
                                i13 = i4;
                                long j111 = secondaryContentColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = secondaryContainerColor;
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j111;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(519094802, i13, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:339)");
                        }
                        int i111 = i13 >> 3;
                        int i26 = (i13 & 126) | (i111 & 896) | (i111 & 7168) | (i111 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                        int i27 = i13 << 3;
                        int i28 = i26 | (29360128 & i27) | (i27 & 234881024) | (1879048192 & i13);
                        Modifier modifier5 = companion;
                        m4390ScrollableTabRowImplxam5sdo(i, modifier5, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, lambda$303717663$material3, function4, composerStartRestartGroup, i28);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                        long j112 = j7;
                        modifier2 = modifier5;
                        scrollState3 = scrollState4;
                        f4 = f6;
                        j6 = j8;
                        j5 = j112;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        lambda$303717663$material3 = function2;
                        scrollState3 = scrollState2;
                        j5 = j3;
                        j6 = j4;
                        f4 = f3;
                        composableLambdaRememberComposableLambda = function3;
                        f5 = f2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, lambda$303717663$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 100663296;
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i4 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "326@17048L21,327@17114L23,328@17180L21,331@17352L160");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            secondaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            secondaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                        } else {
                            lambda$303717663$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j113 = secondaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j113;
                        } else {
                            i13 = i4;
                            long j114 = secondaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j114;
                        }
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            secondaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            secondaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                        } else {
                            lambda$303717663$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j115 = secondaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j115;
                        } else {
                            i13 = i4;
                            long j116 = secondaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j116;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(519094802, i13, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:339)");
                    }
                    int i112 = i13 >> 3;
                    int i29 = (i13 & 126) | (i112 & 896) | (i112 & 7168) | (i112 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                    int i210 = i13 << 3;
                    int i211 = i29 | (29360128 & i210) | (i210 & 234881024) | (1879048192 & i13);
                    Modifier modifier6 = companion;
                    m4390ScrollableTabRowImplxam5sdo(i, modifier6, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, lambda$303717663$material3, function4, composerStartRestartGroup, i211);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                    long j117 = j7;
                    modifier2 = modifier6;
                    scrollState3 = scrollState4;
                    f4 = f6;
                    j6 = j8;
                    j5 = j117;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    lambda$303717663$material3 = function2;
                    scrollState3 = scrollState2;
                    j5 = j3;
                    j6 = j4;
                    f4 = f3;
                    composableLambdaRememberComposableLambda = function3;
                    f5 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, lambda$303717663$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            f3 = f;
            i7 = i3 & 64;
            if (i7 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i4 |= i8;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 256;
                if (i11 != 0) {
                    if ((i2 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(f2)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                        i4 |= i12;
                    }
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    if ((i4 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "326@17048L21,327@17114L23,328@17180L21,331@17352L160");
                        if ((i2 & 1) != 0) {
                            if (i15 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i4 &= -897;
                            } else {
                                scrollStateRememberScrollState = scrollState2;
                            }
                            if ((i3 & 8) != 0) {
                                secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                secondaryContainerColor = j3;
                            }
                            if ((i3 & 16) != 0) {
                                secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                secondaryContentColor = j4;
                            }
                            if (i5 != 0) {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                            } else {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function3;
                            }
                            if (i9 != 0) {
                                lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                            } else {
                                lambda$303717663$material3 = function2;
                            }
                            if (i11 != 0) {
                                i13 = i4;
                                long j118 = secondaryContentColor;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = secondaryContainerColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j118;
                            } else {
                                i13 = i4;
                                long j119 = secondaryContentColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = secondaryContainerColor;
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j119;
                            }
                        } else {
                            if (i15 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i4 &= -897;
                            } else {
                                scrollStateRememberScrollState = scrollState2;
                            }
                            if ((i3 & 8) != 0) {
                                secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                secondaryContainerColor = j3;
                            }
                            if ((i3 & 16) != 0) {
                                secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                secondaryContentColor = j4;
                            }
                            if (i5 != 0) {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                            } else {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function3;
                            }
                            if (i9 != 0) {
                                lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                            } else {
                                lambda$303717663$material3 = function2;
                            }
                            if (i11 != 0) {
                                i13 = i4;
                                long j1110 = secondaryContentColor;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = secondaryContainerColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j1110;
                            } else {
                                i13 = i4;
                                long j1111 = secondaryContentColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = secondaryContainerColor;
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j1111;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(519094802, i13, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:339)");
                        }
                        int i113 = i13 >> 3;
                        int i212 = (i13 & 126) | (i113 & 896) | (i113 & 7168) | (i113 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                        int i213 = i13 << 3;
                        int i214 = i212 | (29360128 & i213) | (i213 & 234881024) | (1879048192 & i13);
                        Modifier modifier7 = companion;
                        m4390ScrollableTabRowImplxam5sdo(i, modifier7, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, lambda$303717663$material3, function4, composerStartRestartGroup, i214);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                        long j1112 = j7;
                        modifier2 = modifier7;
                        scrollState3 = scrollState4;
                        f4 = f6;
                        j6 = j8;
                        j5 = j1112;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        lambda$303717663$material3 = function2;
                        scrollState3 = scrollState2;
                        j5 = j3;
                        j6 = j4;
                        f4 = f3;
                        composableLambdaRememberComposableLambda = function3;
                        f5 = f2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, lambda$303717663$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 100663296;
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i4 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "326@17048L21,327@17114L23,328@17180L21,331@17352L160");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            secondaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            secondaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                        } else {
                            lambda$303717663$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j1113 = secondaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j1113;
                        } else {
                            i13 = i4;
                            long j1114 = secondaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j1114;
                        }
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            secondaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            secondaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                        } else {
                            lambda$303717663$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j1115 = secondaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j1115;
                        } else {
                            i13 = i4;
                            long j1116 = secondaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j1116;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(519094802, i13, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:339)");
                    }
                    int i114 = i13 >> 3;
                    int i215 = (i13 & 126) | (i114 & 896) | (i114 & 7168) | (i114 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                    int i216 = i13 << 3;
                    int i217 = i215 | (29360128 & i216) | (i216 & 234881024) | (1879048192 & i13);
                    Modifier modifier8 = companion;
                    m4390ScrollableTabRowImplxam5sdo(i, modifier8, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, lambda$303717663$material3, function4, composerStartRestartGroup, i217);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                    long j1117 = j7;
                    modifier2 = modifier8;
                    scrollState3 = scrollState4;
                    f4 = f6;
                    j6 = j8;
                    j5 = j1117;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    lambda$303717663$material3 = function2;
                    scrollState3 = scrollState2;
                    j5 = j3;
                    j6 = j4;
                    f4 = f3;
                    composableLambdaRememberComposableLambda = function3;
                    f5 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, lambda$303717663$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 12582912;
            i11 = i3 & 256;
            if (i11 != 0) {
                if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i4 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "326@17048L21,327@17114L23,328@17180L21,331@17352L160");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            secondaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            secondaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                        } else {
                            lambda$303717663$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j1118 = secondaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j1118;
                        } else {
                            i13 = i4;
                            long j1119 = secondaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j1119;
                        }
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            secondaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            secondaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                        } else {
                            lambda$303717663$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j11110 = secondaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j11110;
                        } else {
                            i13 = i4;
                            long j11111 = secondaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j11111;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(519094802, i13, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:339)");
                    }
                    int i115 = i13 >> 3;
                    int i218 = (i13 & 126) | (i115 & 896) | (i115 & 7168) | (i115 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                    int i219 = i13 << 3;
                    int i2110 = i218 | (29360128 & i219) | (i219 & 234881024) | (1879048192 & i13);
                    Modifier modifier9 = companion;
                    m4390ScrollableTabRowImplxam5sdo(i, modifier9, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, lambda$303717663$material3, function4, composerStartRestartGroup, i2110);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                    long j11112 = j7;
                    modifier2 = modifier9;
                    scrollState3 = scrollState4;
                    f4 = f6;
                    j6 = j8;
                    j5 = j11112;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    lambda$303717663$material3 = function2;
                    scrollState3 = scrollState2;
                    j5 = j3;
                    j6 = j4;
                    f4 = f3;
                    composableLambdaRememberComposableLambda = function3;
                    f5 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, lambda$303717663$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            if ((i4 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "326@17048L21,327@17114L23,328@17180L21,331@17352L160");
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -897;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if ((i3 & 8) != 0) {
                        secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        secondaryContainerColor = j3;
                    }
                    if ((i3 & 16) != 0) {
                        secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        secondaryContentColor = j4;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                    } else {
                        lambda$303717663$material3 = function2;
                    }
                    if (i11 != 0) {
                        i13 = i4;
                        long j11113 = secondaryContentColor;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = secondaryContainerColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j11113;
                    } else {
                        i13 = i4;
                        long j11114 = secondaryContentColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = secondaryContainerColor;
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j11114;
                    }
                } else {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -897;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if ((i3 & 8) != 0) {
                        secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        secondaryContainerColor = j3;
                    }
                    if ((i3 & 16) != 0) {
                        secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        secondaryContentColor = j4;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                    } else {
                        lambda$303717663$material3 = function2;
                    }
                    if (i11 != 0) {
                        i13 = i4;
                        long j11115 = secondaryContentColor;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = secondaryContainerColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j11115;
                    } else {
                        i13 = i4;
                        long j11116 = secondaryContentColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = secondaryContainerColor;
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j11116;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(519094802, i13, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:339)");
                }
                int i116 = i13 >> 3;
                int i2111 = (i13 & 126) | (i116 & 896) | (i116 & 7168) | (i116 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                int i2112 = i13 << 3;
                int i2113 = i2111 | (29360128 & i2112) | (i2112 & 234881024) | (1879048192 & i13);
                Modifier modifier10 = companion;
                m4390ScrollableTabRowImplxam5sdo(i, modifier10, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, lambda$303717663$material3, function4, composerStartRestartGroup, i2113);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                long j11117 = j7;
                modifier2 = modifier10;
                scrollState3 = scrollState4;
                f4 = f6;
                j6 = j8;
                j5 = j11117;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                lambda$303717663$material3 = function2;
                scrollState3 = scrollState2;
                j5 = j3;
                j6 = j4;
                f4 = f3;
                composableLambdaRememberComposableLambda = function3;
                f5 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, lambda$303717663$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        if ((i2 & 384) == 0) {
            if ((i3 & 4) == 0) {
                scrollState2 = scrollState;
                if (composerStartRestartGroup.changed(scrollState2)) {
                }
                i4 |= i16;
            } else {
                scrollState2 = scrollState;
            }
            i4 |= i16;
        } else {
            scrollState2 = scrollState;
        }
        if ((i2 & 3072) == 0) {
            if ((i3 & 8) == 0) {
                j3 = j;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i4 |= i17;
            } else {
                j3 = j;
            }
            i4 |= i17;
        } else {
            j3 = j;
        }
        if ((i2 & 24576) == 0) {
            if ((i3 & 16) == 0) {
                j4 = j2;
                if (composerStartRestartGroup.changed(j4)) {
                }
                i4 |= i18;
            } else {
                j4 = j2;
            }
            i4 |= i18;
        } else {
            j4 = j2;
        }
        i5 = i3 & 32;
        if (i5 != 0) {
            if ((196608 & i2) == 0) {
                f3 = f;
                if (composerStartRestartGroup.changed(f3)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
            i7 = i3 & 64;
            if (i7 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i4 |= i8;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 256;
                if (i11 != 0) {
                    if ((i2 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(f2)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                        i4 |= i12;
                    }
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    if ((i4 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "326@17048L21,327@17114L23,328@17180L21,331@17352L160");
                        if ((i2 & 1) != 0) {
                            if (i15 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i4 &= -897;
                            } else {
                                scrollStateRememberScrollState = scrollState2;
                            }
                            if ((i3 & 8) != 0) {
                                secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                secondaryContainerColor = j3;
                            }
                            if ((i3 & 16) != 0) {
                                secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                secondaryContentColor = j4;
                            }
                            if (i5 != 0) {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                            } else {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function3;
                            }
                            if (i9 != 0) {
                                lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                            } else {
                                lambda$303717663$material3 = function2;
                            }
                            if (i11 != 0) {
                                i13 = i4;
                                long j11118 = secondaryContentColor;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = secondaryContainerColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j11118;
                            } else {
                                i13 = i4;
                                long j11119 = secondaryContentColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = secondaryContainerColor;
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j11119;
                            }
                        } else {
                            if (i15 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i4 &= -897;
                            } else {
                                scrollStateRememberScrollState = scrollState2;
                            }
                            if ((i3 & 8) != 0) {
                                secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                secondaryContainerColor = j3;
                            }
                            if ((i3 & 16) != 0) {
                                secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                secondaryContentColor = j4;
                            }
                            if (i5 != 0) {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                            } else {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function3;
                            }
                            if (i9 != 0) {
                                lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                            } else {
                                lambda$303717663$material3 = function2;
                            }
                            if (i11 != 0) {
                                i13 = i4;
                                long j111110 = secondaryContentColor;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = secondaryContainerColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j111110;
                            } else {
                                i13 = i4;
                                long j111111 = secondaryContentColor;
                                fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                scrollState4 = scrollStateRememberScrollState;
                                j7 = secondaryContainerColor;
                                f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                j8 = j111111;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(519094802, i13, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:339)");
                        }
                        int i117 = i13 >> 3;
                        int i2114 = (i13 & 126) | (i117 & 896) | (i117 & 7168) | (i117 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                        int i2115 = i13 << 3;
                        int i2116 = i2114 | (29360128 & i2115) | (i2115 & 234881024) | (1879048192 & i13);
                        Modifier modifier11 = companion;
                        m4390ScrollableTabRowImplxam5sdo(i, modifier11, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, lambda$303717663$material3, function4, composerStartRestartGroup, i2116);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                        long j111112 = j7;
                        modifier2 = modifier11;
                        scrollState3 = scrollState4;
                        f4 = f6;
                        j6 = j8;
                        j5 = j111112;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        lambda$303717663$material3 = function2;
                        scrollState3 = scrollState2;
                        j5 = j3;
                        j6 = j4;
                        f4 = f3;
                        composableLambdaRememberComposableLambda = function3;
                        f5 = f2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, lambda$303717663$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 100663296;
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i4 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "326@17048L21,327@17114L23,328@17180L21,331@17352L160");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            secondaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            secondaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                        } else {
                            lambda$303717663$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j111113 = secondaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j111113;
                        } else {
                            i13 = i4;
                            long j111114 = secondaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j111114;
                        }
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            secondaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            secondaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                        } else {
                            lambda$303717663$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j111115 = secondaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j111115;
                        } else {
                            i13 = i4;
                            long j111116 = secondaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j111116;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(519094802, i13, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:339)");
                    }
                    int i118 = i13 >> 3;
                    int i2117 = (i13 & 126) | (i118 & 896) | (i118 & 7168) | (i118 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                    int i2118 = i13 << 3;
                    int i2119 = i2117 | (29360128 & i2118) | (i2118 & 234881024) | (1879048192 & i13);
                    Modifier modifier12 = companion;
                    m4390ScrollableTabRowImplxam5sdo(i, modifier12, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, lambda$303717663$material3, function4, composerStartRestartGroup, i2119);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                    long j111117 = j7;
                    modifier2 = modifier12;
                    scrollState3 = scrollState4;
                    f4 = f6;
                    j6 = j8;
                    j5 = j111117;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    lambda$303717663$material3 = function2;
                    scrollState3 = scrollState2;
                    j5 = j3;
                    j6 = j4;
                    f4 = f3;
                    composableLambdaRememberComposableLambda = function3;
                    f5 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, lambda$303717663$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 12582912;
            i11 = i3 & 256;
            if (i11 != 0) {
                if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i4 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "326@17048L21,327@17114L23,328@17180L21,331@17352L160");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            secondaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            secondaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                        } else {
                            lambda$303717663$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j111118 = secondaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j111118;
                        } else {
                            i13 = i4;
                            long j111119 = secondaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j111119;
                        }
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            secondaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            secondaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                        } else {
                            lambda$303717663$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j1111110 = secondaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j1111110;
                        } else {
                            i13 = i4;
                            long j1111111 = secondaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j1111111;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(519094802, i13, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:339)");
                    }
                    int i119 = i13 >> 3;
                    int i21110 = (i13 & 126) | (i119 & 896) | (i119 & 7168) | (i119 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                    int i21111 = i13 << 3;
                    int i21112 = i21110 | (29360128 & i21111) | (i21111 & 234881024) | (1879048192 & i13);
                    Modifier modifier13 = companion;
                    m4390ScrollableTabRowImplxam5sdo(i, modifier13, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, lambda$303717663$material3, function4, composerStartRestartGroup, i21112);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                    long j1111112 = j7;
                    modifier2 = modifier13;
                    scrollState3 = scrollState4;
                    f4 = f6;
                    j6 = j8;
                    j5 = j1111112;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    lambda$303717663$material3 = function2;
                    scrollState3 = scrollState2;
                    j5 = j3;
                    j6 = j4;
                    f4 = f3;
                    composableLambdaRememberComposableLambda = function3;
                    f5 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, lambda$303717663$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            if ((i4 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "326@17048L21,327@17114L23,328@17180L21,331@17352L160");
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -897;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if ((i3 & 8) != 0) {
                        secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        secondaryContainerColor = j3;
                    }
                    if ((i3 & 16) != 0) {
                        secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        secondaryContentColor = j4;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                    } else {
                        lambda$303717663$material3 = function2;
                    }
                    if (i11 != 0) {
                        i13 = i4;
                        long j1111113 = secondaryContentColor;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = secondaryContainerColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j1111113;
                    } else {
                        i13 = i4;
                        long j1111114 = secondaryContentColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = secondaryContainerColor;
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j1111114;
                    }
                } else {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -897;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if ((i3 & 8) != 0) {
                        secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        secondaryContainerColor = j3;
                    }
                    if ((i3 & 16) != 0) {
                        secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        secondaryContentColor = j4;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                    } else {
                        lambda$303717663$material3 = function2;
                    }
                    if (i11 != 0) {
                        i13 = i4;
                        long j1111115 = secondaryContentColor;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = secondaryContainerColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j1111115;
                    } else {
                        i13 = i4;
                        long j1111116 = secondaryContentColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = secondaryContainerColor;
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j1111116;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(519094802, i13, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:339)");
                }
                int i1110 = i13 >> 3;
                int i21113 = (i13 & 126) | (i1110 & 896) | (i1110 & 7168) | (i1110 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                int i21114 = i13 << 3;
                int i21115 = i21113 | (29360128 & i21114) | (i21114 & 234881024) | (1879048192 & i13);
                Modifier modifier14 = companion;
                m4390ScrollableTabRowImplxam5sdo(i, modifier14, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, lambda$303717663$material3, function4, composerStartRestartGroup, i21115);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                long j1111117 = j7;
                modifier2 = modifier14;
                scrollState3 = scrollState4;
                f4 = f6;
                j6 = j8;
                j5 = j1111117;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                lambda$303717663$material3 = function2;
                scrollState3 = scrollState2;
                j5 = j3;
                j6 = j4;
                f4 = f3;
                composableLambdaRememberComposableLambda = function3;
                f5 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, lambda$303717663$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        f3 = f;
        i7 = i3 & 64;
        if (i7 != 0) {
            i4 |= 1572864;
        } else if ((i2 & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i8 = 1048576;
            } else {
                i8 = 524288;
            }
            i4 |= i8;
        }
        i9 = i3 & 128;
        if (i9 != 0) {
            if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i4 |= i10;
            }
            i11 = i3 & 256;
            if (i11 != 0) {
                if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i4 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "326@17048L21,327@17114L23,328@17180L21,331@17352L160");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            secondaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            secondaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                        } else {
                            lambda$303717663$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j1111118 = secondaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j1111118;
                        } else {
                            i13 = i4;
                            long j1111119 = secondaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j1111119;
                        }
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -897;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if ((i3 & 8) != 0) {
                            secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            secondaryContainerColor = j3;
                        }
                        if ((i3 & 16) != 0) {
                            secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            secondaryContentColor = j4;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                        } else {
                            lambda$303717663$material3 = function2;
                        }
                        if (i11 != 0) {
                            i13 = i4;
                            long j11111110 = secondaryContentColor;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j11111110;
                        } else {
                            i13 = i4;
                            long j11111111 = secondaryContentColor;
                            fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                            scrollState4 = scrollStateRememberScrollState;
                            j7 = secondaryContainerColor;
                            f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j8 = j11111111;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(519094802, i13, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:339)");
                    }
                    int i1111 = i13 >> 3;
                    int i21116 = (i13 & 126) | (i1111 & 896) | (i1111 & 7168) | (i1111 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                    int i21117 = i13 << 3;
                    int i21118 = i21116 | (29360128 & i21117) | (i21117 & 234881024) | (1879048192 & i13);
                    Modifier modifier15 = companion;
                    m4390ScrollableTabRowImplxam5sdo(i, modifier15, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, lambda$303717663$material3, function4, composerStartRestartGroup, i21118);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                    long j11111112 = j7;
                    modifier2 = modifier15;
                    scrollState3 = scrollState4;
                    f4 = f6;
                    j6 = j8;
                    j5 = j11111112;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    lambda$303717663$material3 = function2;
                    scrollState3 = scrollState2;
                    j5 = j3;
                    j6 = j4;
                    f4 = f3;
                    composableLambdaRememberComposableLambda = function3;
                    f5 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, lambda$303717663$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            if ((i4 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "326@17048L21,327@17114L23,328@17180L21,331@17352L160");
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -897;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if ((i3 & 8) != 0) {
                        secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        secondaryContainerColor = j3;
                    }
                    if ((i3 & 16) != 0) {
                        secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        secondaryContentColor = j4;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                    } else {
                        lambda$303717663$material3 = function2;
                    }
                    if (i11 != 0) {
                        i13 = i4;
                        long j11111113 = secondaryContentColor;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = secondaryContainerColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j11111113;
                    } else {
                        i13 = i4;
                        long j11111114 = secondaryContentColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = secondaryContainerColor;
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j11111114;
                    }
                } else {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -897;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if ((i3 & 8) != 0) {
                        secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        secondaryContainerColor = j3;
                    }
                    if ((i3 & 16) != 0) {
                        secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        secondaryContentColor = j4;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                    } else {
                        lambda$303717663$material3 = function2;
                    }
                    if (i11 != 0) {
                        i13 = i4;
                        long j11111115 = secondaryContentColor;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = secondaryContainerColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j11111115;
                    } else {
                        i13 = i4;
                        long j11111116 = secondaryContentColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = secondaryContainerColor;
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j11111116;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(519094802, i13, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:339)");
                }
                int i1112 = i13 >> 3;
                int i21119 = (i13 & 126) | (i1112 & 896) | (i1112 & 7168) | (i1112 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                int i211110 = i13 << 3;
                int i211111 = i21119 | (29360128 & i211110) | (i211110 & 234881024) | (1879048192 & i13);
                Modifier modifier16 = companion;
                m4390ScrollableTabRowImplxam5sdo(i, modifier16, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, lambda$303717663$material3, function4, composerStartRestartGroup, i211111);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                long j11111117 = j7;
                modifier2 = modifier16;
                scrollState3 = scrollState4;
                f4 = f6;
                j6 = j8;
                j5 = j11111117;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                lambda$303717663$material3 = function2;
                scrollState3 = scrollState2;
                j5 = j3;
                j6 = j4;
                f4 = f3;
                composableLambdaRememberComposableLambda = function3;
                f5 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, lambda$303717663$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 12582912;
        i11 = i3 & 256;
        if (i11 != 0) {
            if ((i2 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i4 |= i12;
            }
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            if ((i4 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "326@17048L21,327@17114L23,328@17180L21,331@17352L160");
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -897;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if ((i3 & 8) != 0) {
                        secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        secondaryContainerColor = j3;
                    }
                    if ((i3 & 16) != 0) {
                        secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        secondaryContentColor = j4;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                    } else {
                        lambda$303717663$material3 = function2;
                    }
                    if (i11 != 0) {
                        i13 = i4;
                        long j11111118 = secondaryContentColor;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = secondaryContainerColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j11111118;
                    } else {
                        i13 = i4;
                        long j11111119 = secondaryContentColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = secondaryContainerColor;
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j11111119;
                    }
                } else {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -897;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if ((i3 & 8) != 0) {
                        secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        secondaryContainerColor = j3;
                    }
                    if ((i3 & 16) != 0) {
                        secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        secondaryContentColor = j4;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                    } else {
                        lambda$303717663$material3 = function2;
                    }
                    if (i11 != 0) {
                        i13 = i4;
                        long j111111110 = secondaryContentColor;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = secondaryContainerColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j111111110;
                    } else {
                        i13 = i4;
                        long j111111111 = secondaryContentColor;
                        fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                        scrollState4 = scrollStateRememberScrollState;
                        j7 = secondaryContainerColor;
                        f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        j8 = j111111111;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(519094802, i13, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:339)");
                }
                int i1113 = i13 >> 3;
                int i211112 = (i13 & 126) | (i1113 & 896) | (i1113 & 7168) | (i1113 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
                int i211113 = i13 << 3;
                int i211114 = i211112 | (29360128 & i211113) | (i211113 & 234881024) | (1879048192 & i13);
                Modifier modifier17 = companion;
                m4390ScrollableTabRowImplxam5sdo(i, modifier17, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, lambda$303717663$material3, function4, composerStartRestartGroup, i211114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
                long j111111112 = j7;
                modifier2 = modifier17;
                scrollState3 = scrollState4;
                f4 = f6;
                j6 = j8;
                j5 = j111111112;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                lambda$303717663$material3 = function2;
                scrollState3 = scrollState2;
                j5 = j3;
                j6 = j4;
                f4 = f3;
                composableLambdaRememberComposableLambda = function3;
                f5 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, lambda$303717663$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 100663296;
        if ((i2 & 805306368) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i14 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i14 = 268435456;
            }
            i4 |= i14;
        }
        if ((i4 & 306783379) != 306783378) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "326@17048L21,327@17114L23,328@17180L21,331@17352L160");
            if ((i2 & 1) != 0) {
                if (i15 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i3 & 4) != 0) {
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    i4 &= -897;
                } else {
                    scrollStateRememberScrollState = scrollState2;
                }
                if ((i3 & 8) != 0) {
                    secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    secondaryContainerColor = j3;
                }
                if ((i3 & 16) != 0) {
                    secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    secondaryContentColor = j4;
                }
                if (i5 != 0) {
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                } else {
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                }
                if (i7 != 0) {
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    composableLambdaRememberComposableLambda = function3;
                }
                if (i9 != 0) {
                    lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                } else {
                    lambda$303717663$material3 = function2;
                }
                if (i11 != 0) {
                    i13 = i4;
                    long j111111113 = secondaryContentColor;
                    scrollState4 = scrollStateRememberScrollState;
                    j7 = secondaryContainerColor;
                    fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                    f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    j8 = j111111113;
                } else {
                    i13 = i4;
                    long j111111114 = secondaryContentColor;
                    fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                    scrollState4 = scrollStateRememberScrollState;
                    j7 = secondaryContainerColor;
                    f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    j8 = j111111114;
                }
            } else {
                if (i15 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i3 & 4) != 0) {
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    i4 &= -897;
                } else {
                    scrollStateRememberScrollState = scrollState2;
                }
                if ((i3 & 8) != 0) {
                    secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    secondaryContainerColor = j3;
                }
                if ((i3 & 16) != 0) {
                    secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    secondaryContentColor = j4;
                }
                if (i5 != 0) {
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                } else {
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f3;
                }
                if (i7 != 0) {
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    composableLambdaRememberComposableLambda = function3;
                }
                if (i9 != 0) {
                    lambda$303717663$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
                } else {
                    lambda$303717663$material3 = function2;
                }
                if (i11 != 0) {
                    i13 = i4;
                    long j111111115 = secondaryContentColor;
                    scrollState4 = scrollStateRememberScrollState;
                    j7 = secondaryContainerColor;
                    fM4375getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM();
                    f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    j8 = j111111115;
                } else {
                    i13 = i4;
                    long j111111116 = secondaryContentColor;
                    fM4375getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                    scrollState4 = scrollStateRememberScrollState;
                    j7 = secondaryContainerColor;
                    f6 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    j8 = j111111116;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(519094802, i13, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:339)");
            }
            int i1114 = i13 >> 3;
            int i211115 = (i13 & 126) | (i1114 & 896) | (i1114 & 7168) | (i1114 & 57344) | ((i13 >> 9) & 458752) | ((i13 << 12) & 3670016);
            int i211116 = i13 << 3;
            int i211117 = i211115 | (29360128 & i211116) | (i211116 & 234881024) | (1879048192 & i13);
            Modifier modifier18 = companion;
            m4390ScrollableTabRowImplxam5sdo(i, modifier18, j7, j8, f6, fM4375getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, lambda$303717663$material3, function4, composerStartRestartGroup, i211117);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f5 = fM4375getScrollableTabRowMinTabWidthD9Ej5fM;
            long j111111117 = j7;
            modifier2 = modifier18;
            scrollState3 = scrollState4;
            f4 = f6;
            j6 = j8;
            j5 = j111111117;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            lambda$303717663$material3 = function2;
            scrollState3 = scrollState2;
            j5 = j3;
            j6 = j4;
            f4 = f3;
            composableLambdaRememberComposableLambda = function3;
            f5 = f2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$1(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, lambda$303717663$material3, f5, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: TabRowImpl-DTcfvLk, reason: not valid java name */
    private static final void m4396TabRowImplDTcfvLk(Modifier modifier, final long j, final long j2, final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer composer, final int i) {
        Modifier modifier2;
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1955286154);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabRowImpl)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,indicator,divider,tabs)403@19704L4058,399@19573L4189:TabRow.kt#uh7d8r");
        if ((i & 6) == 0) {
            modifier2 = modifier;
            i2 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function4) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1955286154, i2, -1, "androidx.compose.material3.TabRowImpl (TabRow.kt:398)");
            }
            int i3 = i2 << 3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4323SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, j, j2, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(830280655, true, new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.TabRowImpl_DTcfvLk$lambda$0(function4, function2, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, (i3 & 896) | 12582912 | (i3 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.TabRowImpl_DTcfvLk$lambda$1(modifier3, j, j2, function3, function2, function4, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabRowImpl_DTcfvLk$lambda$0(Function2 function2, Function2 function3, final Function3 function4, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C405@19859L11,406@19891L1219,440@21221L21,441@21255L2501,438@21120L2636:TabRow.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(830280655, i, -1, "androidx.compose.material3.TabRowImpl.<anonymous> (TabRow.kt:405)");
            }
            FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -964200398, "CC(remember):TabRow.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new TabRowKt$TabRowImpl$1$scope$1$1(finiteAnimationSpecValue);
                composer.updateRememberedValue(objRememberedValue);
            }
            final TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$1 = (TabRowKt$TabRowImpl$1$scope$1$1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            List listListOf = CollectionsKt.listOf((Object[]) new Function2[]{function2, function3, ComposableLambdaKt.rememberComposableLambda(-1333331860, true, new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.TabRowImpl_DTcfvLk$lambda$0$1(function4, tabRowKt$TabRowImpl$1$scope$1$1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54)});
            ComposerKt.sourceInformationMarkerStart(composer, -964155468, "CC(remember):TabRow.kt#9igjgp");
            TabRowKt$TabRowImpl$1$2$1 tabRowKt$TabRowImpl$1$2$1RememberedValue = composer.rememberedValue();
            if (tabRowKt$TabRowImpl$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                tabRowKt$TabRowImpl$1$2$1RememberedValue = new TabRowKt$TabRowImpl$1$2$1(tabRowKt$TabRowImpl$1$scope$1$1);
                composer.updateRememberedValue(tabRowKt$TabRowImpl$1$2$1RememberedValue);
            }
            MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) tabRowKt$TabRowImpl$1$2$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
            Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listListOf);
            ComposerKt.sourceInformationMarkerStart(composer, -290764973, "CC(remember):Layout.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                composer.updateRememberedValue(objRememberedValue2);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            function2CombineAsVirtualLayouts.invoke(composer, 0);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabRowImpl_DTcfvLk$lambda$0$1(Function3 function3, TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C440@21229L11:TabRow.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1333331860, i, -1, "androidx.compose.material3.TabRowImpl.<anonymous>.<anonymous> (TabRow.kt:440)");
            }
            function3.invoke(tabRowKt$TabRowImpl$1$scope$1$1, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: ScrollableTabRowImpl-xam5sdo, reason: not valid java name */
    private static final void m4390ScrollableTabRowImplxam5sdo(final int i, final Modifier modifier, final long j, final long j2, final float f, final float f2, final ScrollState scrollState, final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2) {
        int i3;
        ScrollState scrollState2;
        Function2<? super Composer, ? super Integer, Unit> function5;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(414860860);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScrollableTabRowImpl)N(selectedTabIndex,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,minTabWidth:c#ui.unit.Dp,scrollState,indicator,divider,tabs)522@24245L5677,522@24163L5759:TabRow.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(j2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(f2) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            scrollState2 = scrollState;
            i3 |= composerStartRestartGroup.changed(scrollState2) ? 1048576 : 524288;
        } else {
            scrollState2 = scrollState;
        }
        if ((i2 & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
        }
        if ((100663296 & i2) == 0) {
            function5 = function2;
            i3 |= composerStartRestartGroup.changedInstance(function5) ? 67108864 : 33554432;
        } else {
            function5 = function2;
        }
        if ((i2 & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function4) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(414860860, i3, -1, "androidx.compose.material3.ScrollableTabRowImpl (TabRow.kt:521)");
            }
            final ScrollState scrollState3 = scrollState2;
            final Function2<? super Composer, ? super Integer, Unit> function6 = function5;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4323SurfaceT9BRK9s(modifier, null, j, j2, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1878374785, true, new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.ScrollableTabRowImpl_xam5sdo$lambda$0(scrollState3, function6, function4, f, f2, i, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ((i3 >> 3) & 14) | 12582912 | (i3 & 896) | (i3 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.ScrollableTabRowImpl_xam5sdo$lambda$1(i, modifier, j, j2, f, f2, scrollState, function3, function2, function4, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableTabRowImpl_xam5sdo$lambda$0(ScrollState scrollState, Function2 function2, Function2 function3, float f, float f2, int i, final Function3 function4, Composer composer, int i2) {
        int i3;
        String str;
        ComposerKt.sourceInformation(composer, "C523@24276L24,525@24448L14,527@24577L7,529@24629L263,537@24914L1219,568@26142L3774:TabRow.kt#uh7d8r");
        if (composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1878374785, i2, -1, "androidx.compose.material3.ScrollableTabRowImpl.<anonymous> (TabRow.kt:523)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
                composer.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer, 6);
            FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, 1231916616, "CC(remember):TabRow.kt#9igjgp");
            boolean zChanged = composer.changed(scrollState) | composer.changed(coroutineScope);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new ScrollableTabData(scrollState, coroutineScope, finiteAnimationSpecValue);
                composer.updateRememberedValue(objRememberedValue2);
            }
            ScrollableTabData scrollableTabData = (ScrollableTabData) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1231926692, "CC(remember):TabRow.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new TabRowKt$ScrollableTabRowImpl$1$scope$1$1(finiteAnimationSpecValue2);
                composer.updateRememberedValue(objRememberedValue3);
            }
            final TabRowKt$ScrollableTabRowImpl$1$scope$1$1 tabRowKt$ScrollableTabRowImpl$1$scope$1$1 = (TabRowKt$ScrollableTabRowImpl$1$scope$1$1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            Alignment bottomStart = Alignment.INSTANCE.getBottomStart();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(bottomStart, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 738154596, "C569@26202L9,571@26272L21,578@26592L3314,570@26224L3682:TabRow.kt#uh7d8r");
            function2.invoke(composer, 0);
            List listListOf = CollectionsKt.listOf((Object[]) new Function2[]{function3, ComposableLambdaKt.rememberComposableLambda(509386037, true, new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.ScrollableTabRowImpl_xam5sdo$lambda$0$2$0(function4, tabRowKt$ScrollableTabRowImpl$1$scope$1$1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54)});
            Modifier modifierClipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), scrollState, false, null, false, 14, null)));
            ComposerKt.sourceInformationMarkerStart(composer, 578012857, "CC(remember):TabRow.kt#9igjgp");
            boolean zChanged2 = composer.changed(f) | composer.changed(f2) | composer.changed(i) | composer.changedInstance(scrollableTabData);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                i3 = -1323940314;
                str = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                objRememberedValue4 = (MultiContentMeasurePolicy) new TabRowKt$ScrollableTabRowImpl$1$1$2$1(f, f2, tabRowKt$ScrollableTabRowImpl$1$scope$1$1, i, scrollableTabData);
                composer.updateRememberedValue(objRememberedValue4);
            } else {
                i3 = -1323940314;
                str = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            }
            MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
            Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listListOf);
            ComposerKt.sourceInformationMarkerStart(composer, -290764973, "CC(remember):Layout.kt#9igjgp");
            boolean zChanged3 = composer.changed(multiContentMeasurePolicy);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                composer.updateRememberedValue(objRememberedValue5);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, i3, str);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierClipToBounds);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            function2CombineAsVirtualLayouts.invoke(composer, 0);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableTabRowImpl_xam5sdo$lambda$0$2$0(Function3 function3, TabRowKt$ScrollableTabRowImpl$1$scope$1$1 tabRowKt$ScrollableTabRowImpl$1$scope$1$1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C571@26280L11:TabRow.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(509386037, i, -1, "androidx.compose.material3.ScrollableTabRowImpl.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:571)");
            }
            function3.invoke(tabRowKt$ScrollableTabRowImpl$1$scope$1$1, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: TabRowWithSubcomposeImpl-DTcfvLk, reason: not valid java name */
    private static final void m4397TabRowWithSubcomposeImplDTcfvLk(Modifier modifier, final long j, final long j2, final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer composer, final int i) {
        Modifier modifier2;
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(148841506);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabRowWithSubcomposeImpl)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,indicator,divider,tabs)768@33827L2218,764@33696L2349:TabRow.kt#uh7d8r");
        if ((i & 6) == 0) {
            modifier2 = modifier;
            i2 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function4) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(148841506, i2, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl (TabRow.kt:763)");
            }
            int i3 = i2 << 3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4323SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, j, j2, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1815327065, true, new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.TabRowWithSubcomposeImpl_DTcfvLk$lambda$0(function4, function2, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, (i3 & 896) | 12582912 | (i3 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.TabRowWithSubcomposeImpl_DTcfvLk$lambda$1(modifier3, j, j2, function3, function2, function4, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabRowWithSubcomposeImpl_DTcfvLk$lambda$0(final Function2 function2, final Function2 function3, final Function3 function4, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C769@33879L2160,769@33837L2202:TabRow.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1815327065, i, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:769)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, -772583465, "CC(remember):TabRow.kt#9igjgp");
            boolean zChanged = composer.changed(function2) | composer.changed(function3) | composer.changed(function4);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.TabRowWithSubcomposeImpl_DTcfvLk$lambda$0$0$0(function2, function3, function4, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SubcomposeLayoutKt.SubcomposeLayout(modifierFillMaxWidth$default, (Function2) objRememberedValue, composer, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult TabRowWithSubcomposeImpl_DTcfvLk$lambda$0$0$0(Function2 function2, final Function2 function3, final Function3 function4, final SubcomposeMeasureScope subcomposeMeasureScope, final Constraints constraints) {
        final int iM9640getMaxWidthimpl = Constraints.m9640getMaxWidthimpl(constraints.getValue());
        List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function2);
        int size = listSubcompose.size();
        final Ref.IntRef intRef = new Ref.IntRef();
        if (size > 0) {
            intRef.element = iM9640getMaxWidthimpl / size;
        }
        int iValueOf = 0;
        List<Measurable> list = listSubcompose;
        int size2 = list.size();
        for (int i = 0; i < size2; i++) {
            iValueOf = Integer.valueOf(Math.max(listSubcompose.get(i).maxIntrinsicHeight(intRef.element), iValueOf.intValue()));
        }
        final int iIntValue = iValueOf.intValue();
        ArrayList arrayList = new ArrayList(listSubcompose.size());
        int size3 = list.size();
        for (int i2 = 0; i2 < size3; i2++) {
            arrayList.add(listSubcompose.get(i2).mo8265measureBRTryo0(Constraints.m9629copyZbe2FdA(constraints.getValue(), intRef.element, intRef.element, iIntValue, iIntValue)));
        }
        final ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3.add(new TabPosition(Dp.m9687constructorimpl(subcomposeMeasureScope.mo751toDpu2uoSUM(intRef.element) * i3), subcomposeMeasureScope.mo751toDpu2uoSUM(intRef.element), ((Dp) ComparisonsKt.maxOf(Dp.m9685boximpl(Dp.m9687constructorimpl(subcomposeMeasureScope.mo751toDpu2uoSUM(Math.min(listSubcompose.get(i3).maxIntrinsicWidth(iIntValue), intRef.element)) - Dp.m9687constructorimpl(TabKt.getHorizontalTextPadding() * 2))), Dp.m9685boximpl(Dp.m9687constructorimpl(24)))).m9701unboximpl(), null));
        }
        final ArrayList arrayList4 = arrayList3;
        return MeasureScope.layout$default(subcomposeMeasureScope, iM9640getMaxWidthimpl, iIntValue, null, new Function1() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TabRowKt.TabRowWithSubcomposeImpl_DTcfvLk$lambda$0$0$0$3(arrayList2, subcomposeMeasureScope, function3, intRef, constraints, iIntValue, function4, arrayList4, iM9640getMaxWidthimpl, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabRowWithSubcomposeImpl_DTcfvLk$lambda$0$0$0$3$2(Function3 function3, List list, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C815@35832L23:TabRow.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1918742627, i, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:815)");
            }
            function3.invoke(list, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0128 A[PHI: r3 r6 r7 r9 r13
      0x0128: PHI (r3v23 int) = (r3v16 int), (r3v24 int), (r3v25 int) binds: [B:116:0x015e, B:102:0x0125, B:103:0x0127] A[DONT_GENERATE, DONT_INLINE]
      0x0128: PHI (r6v12 androidx.compose.ui.Modifier) = (r6v5 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier) binds: [B:116:0x015e, B:102:0x0125, B:103:0x0127] A[DONT_GENERATE, DONT_INLINE]
      0x0128: PHI (r7v13 long) = (r7v7 long), (r7v6 long), (r7v6 long) binds: [B:116:0x015e, B:102:0x0125, B:103:0x0127] A[DONT_GENERATE, DONT_INLINE]
      0x0128: PHI (r9v8 long) = (r9v5 long), (r9v2 long), (r9v2 long) binds: [B:116:0x015e, B:102:0x0125, B:103:0x0127] A[DONT_GENERATE, DONT_INLINE]
      0x0128: PHI (r13v8 float) = (r13v5 float), (r13v3 float), (r13v3 float) binds: [B:116:0x015e, B:102:0x0125, B:103:0x0127] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:106:0x0134 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x0136  */
    /* JADX WARN: Code duplicated, block: B:110:0x0140  */
    /* JADX WARN: Code duplicated, block: B:113:0x014c  */
    /* JADX WARN: Code duplicated, block: B:115:0x0157  */
    /* JADX WARN: Code duplicated, block: B:117:0x0160  */
    /* JADX WARN: Code duplicated, block: B:120:0x0174  */
    /* JADX WARN: Code duplicated, block: B:123:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:125:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:128:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:44:0x0078  */
    /* JADX WARN: Code duplicated, block: B:46:0x0080  */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:53:0x0091  */
    /* JADX WARN: Code duplicated, block: B:54:0x0093  */
    /* JADX WARN: Code duplicated, block: B:56:0x0096  */
    /* JADX WARN: Code duplicated, block: B:58:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:65:0x00af  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:93:0x0104  */
    /* JADX WARN: Code duplicated, block: B:95:0x0113  */
    /* JADX INFO: renamed from: ScrollableTabRowWithSubcomposeImpl-qhFBPw4, reason: not valid java name */
    private static final void m4391ScrollableTabRowWithSubcomposeImplqhFBPw4(final int i, final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, long j, long j2, float f, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, final ScrollState scrollState, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long primaryContainerColor;
        long primaryContentColor;
        int i5;
        float fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function5;
        int i8;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final long j3;
        final long j4;
        final float f2;
        final Function2<? super Composer, ? super Integer, Unit> function6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> lambda$2075817209$material3;
        long j5;
        float f3;
        int i9;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(901781420);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScrollableTabRowWithSubcomposeImpl)N(selectedTabIndex,indicator,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,divider,tabs,scrollState)837@36714L4172,837@36632L4254:TabRow.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        int i11 = i3 & 4;
        if (i11 == 0) {
            if ((i2 & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i2 & 3072) == 0) {
                if ((i3 & 8) == 0) {
                    primaryContainerColor = j;
                    int i12 = composerStartRestartGroup.changed(primaryContainerColor) ? 2048 : 1024;
                    i4 |= i12;
                } else {
                    primaryContainerColor = j;
                }
                i4 |= i12;
            } else {
                primaryContainerColor = j;
            }
            if ((i2 & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    primaryContentColor = j2;
                    int i13 = composerStartRestartGroup.changed(primaryContentColor) ? 16384 : 8192;
                    i4 |= i13;
                } else {
                    primaryContentColor = j2;
                }
                i4 |= i13;
            } else {
                primaryContentColor = j2;
            }
            i5 = i3 & 32;
            if (i5 != 0) {
                if ((196608 & i2) == 0) {
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
                    if (composerStartRestartGroup.changed(fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                    if ((1572864 & i2) == 0) {
                        function5 = function2;
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i8 = 1048576;
                        } else {
                            i8 = 524288;
                        }
                        i4 |= i8;
                    }
                    if ((i2 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 8388608;
                        } else {
                            i10 = 4194304;
                        }
                        i4 |= i10;
                    }
                    if ((i2 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(scrollState)) {
                            i9 = 67108864;
                        } else {
                            i9 = 33554432;
                        }
                        i4 |= i9;
                    }
                    if ((i4 & 38347923) != 38347922) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "830@36329L21,831@36393L19");
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 8) != 0) {
                                primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            }
                            if ((i3 & 16) != 0) {
                                primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            }
                            if (i5 != 0) {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                            }
                            if (i7 != 0) {
                                lambda$2075817209$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$2075817209$material3();
                                j5 = primaryContentColor;
                                f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            }
                            Modifier modifier4 = modifier2;
                            long j6 = primaryContainerColor;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(901781420, i4, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl (TabRow.kt:836)");
                            }
                            final float f4 = f3;
                            final Function2<? super Composer, ? super Integer, Unit> function7 = lambda$2075817209$material3;
                            int i14 = ((i4 >> 6) & 14) | 12582912;
                            int i15 = i4 >> 3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m4323SurfaceT9BRK9s(modifier4, null, j6, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(2077251399, true, new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabRowKt.ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$0(scrollState, f4, function4, function7, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composer2, i14 | (i15 & 896) | (i15 & 7168), 114);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            f2 = f4;
                            function6 = function7;
                            modifier3 = modifier4;
                            j3 = j6;
                            j4 = j5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 8) != 0) {
                                i4 &= -7169;
                            }
                            if ((i3 & 16) != 0) {
                                i4 &= -57345;
                            }
                        }
                        j5 = primaryContentColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        lambda$2075817209$material3 = function5;
                        Modifier modifier5 = modifier2;
                        long j7 = primaryContainerColor;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(901781420, i4, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl (TabRow.kt:836)");
                        }
                        final float f5 = f3;
                        final Function2 function8 = lambda$2075817209$material3;
                        int i16 = ((i4 >> 6) & 14) | 12582912;
                        int i17 = i4 >> 3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m4323SurfaceT9BRK9s(modifier5, null, j7, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(2077251399, true, new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$0(scrollState, f5, function4, function8, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, i16 | (i17 & 896) | (i17 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f2 = f5;
                        function6 = function8;
                        modifier3 = modifier5;
                        j3 = j7;
                        j4 = j5;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        j3 = primaryContainerColor;
                        j4 = primaryContentColor;
                        f2 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        function6 = function5;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$1(i, function3, modifier3, j3, j4, f2, function6, function4, scrollState, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 1572864;
                function5 = function2;
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
                if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(scrollState)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                    i4 |= i9;
                }
                if ((i4 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "830@36329L21,831@36393L19");
                    if ((i2 & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        }
                        if ((i3 & 16) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        }
                        if (i7 != 0) {
                            lambda$2075817209$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$2075817209$material3();
                            j5 = primaryContentColor;
                            f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        } else {
                            j5 = primaryContentColor;
                            f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            lambda$2075817209$material3 = function5;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        }
                        if ((i3 & 16) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        }
                        if (i7 != 0) {
                            lambda$2075817209$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$2075817209$material3();
                            j5 = primaryContentColor;
                            f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        } else {
                            j5 = primaryContentColor;
                            f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            lambda$2075817209$material3 = function5;
                        }
                    }
                    Modifier modifier6 = modifier2;
                    long j8 = primaryContainerColor;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(901781420, i4, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl (TabRow.kt:836)");
                    }
                    final float f6 = f3;
                    final Function2 function9 = lambda$2075817209$material3;
                    int i18 = ((i4 >> 6) & 14) | 12582912;
                    int i19 = i4 >> 3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4323SurfaceT9BRK9s(modifier6, null, j8, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(2077251399, true, new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$0(scrollState, f6, function4, function9, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, i18 | (i19 & 896) | (i19 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f2 = f6;
                    function6 = function9;
                    modifier3 = modifier6;
                    j3 = j8;
                    j4 = j5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j3 = primaryContainerColor;
                    j4 = primaryContentColor;
                    f2 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    function6 = function5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$1(i, function3, modifier3, j3, j4, f2, function6, function4, scrollState, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
            i7 = i3 & 64;
            if (i7 != 0) {
                if ((1572864 & i2) == 0) {
                    function5 = function2;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i4 |= i8;
                }
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
                if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(scrollState)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                    i4 |= i9;
                }
                if ((i4 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "830@36329L21,831@36393L19");
                    if ((i2 & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        }
                        if ((i3 & 16) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        }
                        if (i7 != 0) {
                            lambda$2075817209$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$2075817209$material3();
                            j5 = primaryContentColor;
                            f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        } else {
                            j5 = primaryContentColor;
                            f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            lambda$2075817209$material3 = function5;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        }
                        if ((i3 & 16) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        }
                        if (i7 != 0) {
                            lambda$2075817209$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$2075817209$material3();
                            j5 = primaryContentColor;
                            f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        } else {
                            j5 = primaryContentColor;
                            f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            lambda$2075817209$material3 = function5;
                        }
                    }
                    Modifier modifier7 = modifier2;
                    long j9 = primaryContainerColor;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(901781420, i4, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl (TabRow.kt:836)");
                    }
                    final float f7 = f3;
                    final Function2 function10 = lambda$2075817209$material3;
                    int i110 = ((i4 >> 6) & 14) | 12582912;
                    int i111 = i4 >> 3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4323SurfaceT9BRK9s(modifier7, null, j9, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(2077251399, true, new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$0(scrollState, f7, function4, function10, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, i110 | (i111 & 896) | (i111 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f2 = f7;
                    function6 = function10;
                    modifier3 = modifier7;
                    j3 = j9;
                    j4 = j5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j3 = primaryContainerColor;
                    j4 = primaryContentColor;
                    f2 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    function6 = function5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$1(i, function3, modifier3, j3, j4, f2, function6, function4, scrollState, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 1572864;
            function5 = function2;
            if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i4 |= i10;
            }
            if ((i2 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(scrollState)) {
                    i9 = 67108864;
                } else {
                    i9 = 33554432;
                }
                i4 |= i9;
            }
            if ((i4 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "830@36329L21,831@36393L19");
                if ((i2 & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    }
                    if (i7 != 0) {
                        lambda$2075817209$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$2075817209$material3();
                        j5 = primaryContentColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    } else {
                        j5 = primaryContentColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        lambda$2075817209$material3 = function5;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    }
                    if (i7 != 0) {
                        lambda$2075817209$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$2075817209$material3();
                        j5 = primaryContentColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    } else {
                        j5 = primaryContentColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        lambda$2075817209$material3 = function5;
                    }
                }
                Modifier modifier8 = modifier2;
                long j10 = primaryContainerColor;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(901781420, i4, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl (TabRow.kt:836)");
                }
                final float f8 = f3;
                final Function2 function11 = lambda$2075817209$material3;
                int i112 = ((i4 >> 6) & 14) | 12582912;
                int i113 = i4 >> 3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4323SurfaceT9BRK9s(modifier8, null, j10, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(2077251399, true, new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$0(scrollState, f8, function4, function11, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, i112 | (i113 & 896) | (i113 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f2 = f8;
                function6 = function11;
                modifier3 = modifier8;
                j3 = j10;
                j4 = j5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = primaryContainerColor;
                j4 = primaryContentColor;
                f2 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                function6 = function5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$1(i, function3, modifier3, j3, j4, f2, function6, function4, scrollState, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        modifier2 = modifier;
        if ((i2 & 3072) == 0) {
            if ((i3 & 8) == 0) {
                primaryContainerColor = j;
                if (composerStartRestartGroup.changed(primaryContainerColor)) {
                }
                i4 |= i12;
            } else {
                primaryContainerColor = j;
            }
            i4 |= i12;
        } else {
            primaryContainerColor = j;
        }
        if ((i2 & 24576) == 0) {
            if ((i3 & 16) == 0) {
                primaryContentColor = j2;
                if (composerStartRestartGroup.changed(primaryContentColor)) {
                }
                i4 |= i13;
            } else {
                primaryContentColor = j2;
            }
            i4 |= i13;
        } else {
            primaryContentColor = j2;
        }
        i5 = i3 & 32;
        if (i5 != 0) {
            if ((196608 & i2) == 0) {
                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
                if (composerStartRestartGroup.changed(fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
            i7 = i3 & 64;
            if (i7 != 0) {
                if ((1572864 & i2) == 0) {
                    function5 = function2;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i4 |= i8;
                }
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
                if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(scrollState)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                    i4 |= i9;
                }
                if ((i4 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "830@36329L21,831@36393L19");
                    if ((i2 & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        }
                        if ((i3 & 16) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        }
                        if (i7 != 0) {
                            lambda$2075817209$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$2075817209$material3();
                            j5 = primaryContentColor;
                            f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        } else {
                            j5 = primaryContentColor;
                            f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            lambda$2075817209$material3 = function5;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        }
                        if ((i3 & 16) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        }
                        if (i7 != 0) {
                            lambda$2075817209$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$2075817209$material3();
                            j5 = primaryContentColor;
                            f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        } else {
                            j5 = primaryContentColor;
                            f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            lambda$2075817209$material3 = function5;
                        }
                    }
                    Modifier modifier9 = modifier2;
                    long j11 = primaryContainerColor;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(901781420, i4, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl (TabRow.kt:836)");
                    }
                    final float f9 = f3;
                    final Function2 function12 = lambda$2075817209$material3;
                    int i114 = ((i4 >> 6) & 14) | 12582912;
                    int i115 = i4 >> 3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4323SurfaceT9BRK9s(modifier9, null, j11, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(2077251399, true, new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$0(scrollState, f9, function4, function12, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, i114 | (i115 & 896) | (i115 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f2 = f9;
                    function6 = function12;
                    modifier3 = modifier9;
                    j3 = j11;
                    j4 = j5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j3 = primaryContainerColor;
                    j4 = primaryContentColor;
                    f2 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    function6 = function5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$1(i, function3, modifier3, j3, j4, f2, function6, function4, scrollState, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 1572864;
            function5 = function2;
            if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i4 |= i10;
            }
            if ((i2 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(scrollState)) {
                    i9 = 67108864;
                } else {
                    i9 = 33554432;
                }
                i4 |= i9;
            }
            if ((i4 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "830@36329L21,831@36393L19");
                if ((i2 & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    }
                    if (i7 != 0) {
                        lambda$2075817209$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$2075817209$material3();
                        j5 = primaryContentColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    } else {
                        j5 = primaryContentColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        lambda$2075817209$material3 = function5;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    }
                    if (i7 != 0) {
                        lambda$2075817209$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$2075817209$material3();
                        j5 = primaryContentColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    } else {
                        j5 = primaryContentColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        lambda$2075817209$material3 = function5;
                    }
                }
                Modifier modifier10 = modifier2;
                long j12 = primaryContainerColor;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(901781420, i4, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl (TabRow.kt:836)");
                }
                final float f10 = f3;
                final Function2 function13 = lambda$2075817209$material3;
                int i116 = ((i4 >> 6) & 14) | 12582912;
                int i117 = i4 >> 3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4323SurfaceT9BRK9s(modifier10, null, j12, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(2077251399, true, new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$0(scrollState, f10, function4, function13, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, i116 | (i117 & 896) | (i117 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f2 = f10;
                function6 = function13;
                modifier3 = modifier10;
                j3 = j12;
                j4 = j5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = primaryContainerColor;
                j4 = primaryContentColor;
                f2 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                function6 = function5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$1(i, function3, modifier3, j3, j4, f2, function6, function4, scrollState, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
        i7 = i3 & 64;
        if (i7 != 0) {
            if ((1572864 & i2) == 0) {
                function5 = function2;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i4 |= i8;
            }
            if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i4 |= i10;
            }
            if ((i2 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(scrollState)) {
                    i9 = 67108864;
                } else {
                    i9 = 33554432;
                }
                i4 |= i9;
            }
            if ((i4 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "830@36329L21,831@36393L19");
                if ((i2 & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    }
                    if (i7 != 0) {
                        lambda$2075817209$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$2075817209$material3();
                        j5 = primaryContentColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    } else {
                        j5 = primaryContentColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        lambda$2075817209$material3 = function5;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    }
                    if (i7 != 0) {
                        lambda$2075817209$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$2075817209$material3();
                        j5 = primaryContentColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    } else {
                        j5 = primaryContentColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        lambda$2075817209$material3 = function5;
                    }
                }
                Modifier modifier11 = modifier2;
                long j13 = primaryContainerColor;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(901781420, i4, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl (TabRow.kt:836)");
                }
                final float f11 = f3;
                final Function2 function14 = lambda$2075817209$material3;
                int i118 = ((i4 >> 6) & 14) | 12582912;
                int i119 = i4 >> 3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4323SurfaceT9BRK9s(modifier11, null, j13, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(2077251399, true, new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$0(scrollState, f11, function4, function14, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, i118 | (i119 & 896) | (i119 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f2 = f11;
                function6 = function14;
                modifier3 = modifier11;
                j3 = j13;
                j4 = j5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = primaryContainerColor;
                j4 = primaryContentColor;
                f2 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                function6 = function5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$1(i, function3, modifier3, j3, j4, f2, function6, function4, scrollState, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 1572864;
        function5 = function2;
        if ((i2 & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i10 = 8388608;
            } else {
                i10 = 4194304;
            }
            i4 |= i10;
        }
        if ((i2 & 100663296) == 0) {
            if (composerStartRestartGroup.changed(scrollState)) {
                i9 = 67108864;
            } else {
                i9 = 33554432;
            }
            i4 |= i9;
        }
        if ((i4 & 38347923) != 38347922) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "830@36329L21,831@36393L19");
            if ((i2 & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i3 & 8) != 0) {
                    primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                }
                if ((i3 & 16) != 0) {
                    primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                    i4 &= -57345;
                }
                if (i5 != 0) {
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                }
                if (i7 != 0) {
                    lambda$2075817209$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$2075817209$material3();
                    j5 = primaryContentColor;
                    f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                } else {
                    j5 = primaryContentColor;
                    f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    lambda$2075817209$material3 = function5;
                }
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i3 & 8) != 0) {
                    primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                }
                if ((i3 & 16) != 0) {
                    primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                    i4 &= -57345;
                }
                if (i5 != 0) {
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                }
                if (i7 != 0) {
                    lambda$2075817209$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$2075817209$material3();
                    j5 = primaryContentColor;
                    f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                } else {
                    j5 = primaryContentColor;
                    f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    lambda$2075817209$material3 = function5;
                }
            }
            Modifier modifier12 = modifier2;
            long j14 = primaryContainerColor;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(901781420, i4, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl (TabRow.kt:836)");
            }
            final float f12 = f3;
            final Function2 function15 = lambda$2075817209$material3;
            int i1110 = ((i4 >> 6) & 14) | 12582912;
            int i1111 = i4 >> 3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4323SurfaceT9BRK9s(modifier12, null, j14, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(2077251399, true, new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$0(scrollState, f12, function4, function15, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, i1110 | (i1111 & 896) | (i1111 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f2 = f12;
            function6 = function15;
            modifier3 = modifier12;
            j3 = j14;
            j4 = j5;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = primaryContainerColor;
            j4 = primaryContentColor;
            f2 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
            function6 = function5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$1(i, function3, modifier3, j3, j4, f2, function6, function4, scrollState, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$0(ScrollState scrollState, final float f, final Function2 function2, final Function2 function3, final Function3 function4, final int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C838@36745L24,840@36917L14,842@36976L263,855@37490L3390,849@37248L3632:TabRow.kt#uh7d8r");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2077251399, i2, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:838)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
                composer.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -921189554, "CC(remember):TabRow.kt#9igjgp");
            boolean zChanged = composer.changed(scrollState) | composer.changed(coroutineScope);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new ScrollableTabData(scrollState, coroutineScope, finiteAnimationSpecValue);
                composer.updateRememberedValue(objRememberedValue2);
            }
            final ScrollableTabData scrollableTabData = (ScrollableTabData) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierClipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), scrollState, false, null, false, 14, null)));
            ComposerKt.sourceInformationMarkerStart(composer, -921169979, "CC(remember):TabRow.kt#9igjgp");
            boolean zChanged2 = composer.changed(f) | composer.changed(function2) | composer.changed(function3) | composer.changed(function4) | composer.changedInstance(scrollableTabData) | composer.changed(i);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                Object obj = new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return TabRowKt.ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$0$1$0(f, function2, function3, scrollableTabData, i, function4, (SubcomposeMeasureScope) obj2, (Constraints) obj3);
                    }
                };
                composer.updateRememberedValue(obj);
                objRememberedValue3 = obj;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SubcomposeLayoutKt.SubcomposeLayout(modifierClipToBounds, (Function2) objRememberedValue3, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$0$1$0(float f, Function2 function2, final Function2 function3, final ScrollableTabData scrollableTabData, final int i, final Function3 function4, final SubcomposeMeasureScope subcomposeMeasureScope, final Constraints constraints) {
        int i2 = subcomposeMeasureScope.mo748roundToPx0680j_4(TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM());
        final int i3 = subcomposeMeasureScope.mo748roundToPx0680j_4(f);
        List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function2);
        int iValueOf = 0;
        List<Measurable> list = listSubcompose;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            iValueOf = Integer.valueOf(Math.max(iValueOf.intValue(), listSubcompose.get(i4).maxIntrinsicHeight(Integer.MAX_VALUE)));
        }
        final int iIntValue = iValueOf.intValue();
        long jM9630copyZbe2FdA$default = Constraints.m9630copyZbe2FdA$default(constraints.getValue(), i2, 0, iIntValue, iIntValue, 2, null);
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        int size2 = list.size();
        for (int i5 = 0; i5 < size2; i5++) {
            Measurable measurable = listSubcompose.get(i5);
            Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(jM9630copyZbe2FdA$default);
            float fM9687constructorimpl = Dp.m9687constructorimpl(subcomposeMeasureScope.mo751toDpu2uoSUM(Math.min(measurable.maxIntrinsicWidth(placeableMo8265measureBRTryo0.getHeight()), placeableMo8265measureBRTryo0.getWidth())) - Dp.m9687constructorimpl(TabKt.getHorizontalTextPadding() * 2));
            arrayList.add(placeableMo8265measureBRTryo0);
            arrayList2.add(Dp.m9685boximpl(fM9687constructorimpl));
        }
        Integer numValueOf = Integer.valueOf(i3 * 2);
        int size3 = arrayList.size();
        for (int i6 = 0; i6 < size3; i6++) {
            numValueOf = Integer.valueOf(numValueOf.intValue() + ((Placeable) arrayList.get(i6)).getWidth());
        }
        final int iIntValue2 = numValueOf.intValue();
        return MeasureScope.layout$default(subcomposeMeasureScope, iIntValue2, iIntValue, null, new Function1() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TabRowKt.ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$0$1$0$3(i3, arrayList, subcomposeMeasureScope, function3, scrollableTabData, i, arrayList2, constraints, iIntValue2, iIntValue, function4, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$0$1$0$3(int i, List list, SubcomposeMeasureScope subcomposeMeasureScope, Function2 function2, ScrollableTabData scrollableTabData, int i2, List list2, Constraints constraints, int i3, int i4, final Function3 function3, Placeable.PlacementScope placementScope) {
        final ArrayList arrayList = new ArrayList();
        int size = list.size();
        int width = i;
        for (int i5 = 0; i5 < size; i5++) {
            Placeable placeable = (Placeable) list.get(i5);
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, width, 0, 0.0f, 4, null);
            arrayList.add(new TabPosition(subcomposeMeasureScope.mo751toDpu2uoSUM(width), subcomposeMeasureScope.mo751toDpu2uoSUM(placeable.getWidth()), ((Dp) list2.get(i5)).m9701unboximpl(), null));
            width += placeable.getWidth();
        }
        List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(TabSlots.Divider, function2);
        int size2 = listSubcompose.size();
        for (int i6 = 0; i6 < size2; i6++) {
            Placeable placeableMo8265measureBRTryo0 = listSubcompose.get(i6).mo8265measureBRTryo0(Constraints.m9630copyZbe2FdA$default(constraints.getValue(), i3, i3, 0, 0, 8, null));
            Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo8265measureBRTryo0, 0, i4 - placeableMo8265measureBRTryo0.getHeight(), 0.0f, 4, null);
        }
        List<Measurable> listSubcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Indicator, ComposableLambdaKt.composableLambdaInstance(2125766411, true, new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return TabRowKt.ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$0$1$0$3$2(function3, arrayList, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        int size3 = listSubcompose2.size();
        for (int i7 = 0; i7 < size3; i7++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, listSubcompose2.get(i7).mo8265measureBRTryo0(Constraints.INSTANCE.m9650fixedJhjzzOo(i3, i4)), 0, 0, 0.0f, 4, null);
        }
        scrollableTabData.onLaidOut(subcomposeMeasureScope, i, arrayList, i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$0$1$0$3$2(Function3 function3, List list, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C922@40413L23:TabRow.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2125766411, i, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:922)");
            }
            function3.invoke(list, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrimaryScrollableTabRow_qhFBPw4$lambda$0(int i, TabIndicatorScope tabIndicatorScope, Composer composer, int i2) {
        int i3;
        ComposerKt.sourceInformation(composer, "C1199@51073L159:TabRow.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = ((i2 & 8) == 0 ? composer.changed(tabIndicatorScope) : composer.changedInstance(tabIndicatorScope) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if (!composer.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1872002465, i3, -1, "androidx.compose.material3.PrimaryScrollableTabRow.<anonymous> (TabRow.kt:1199)");
            }
            TabRowDefaults.INSTANCE.m4372PrimaryIndicator10LGxhE(tabIndicatorScope.tabIndicatorOffset(Modifier.INSTANCE, i, true), Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM(), 0.0f, 0L, null, composer, 196656, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0127  */
    /* JADX WARN: Code duplicated, block: B:113:0x014e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:114:0x0150  */
    /* JADX WARN: Code duplicated, block: B:117:0x0159  */
    /* JADX WARN: Code duplicated, block: B:120:0x0168  */
    /* JADX WARN: Code duplicated, block: B:123:0x0174  */
    /* JADX WARN: Code duplicated, block: B:125:0x017f  */
    /* JADX WARN: Code duplicated, block: B:127:0x0188  */
    /* JADX WARN: Code duplicated, block: B:128:0x0199  */
    /* JADX WARN: Code duplicated, block: B:130:0x019d  */
    /* JADX WARN: Code duplicated, block: B:131:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:134:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:137:0x0207  */
    /* JADX WARN: Code duplicated, block: B:139:0x0212  */
    /* JADX WARN: Code duplicated, block: B:142:0x0224  */
    /* JADX WARN: Code duplicated, block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0063  */
    /* JADX WARN: Code duplicated, block: B:38:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:45:0x007a  */
    /* JADX WARN: Code duplicated, block: B:47:0x007e  */
    /* JADX WARN: Code duplicated, block: B:49:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:53:0x008f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0097  */
    /* JADX WARN: Code duplicated, block: B:57:0x0099  */
    /* JADX WARN: Code duplicated, block: B:59:0x009c  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:70:0x00be  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:80:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:94:0x010d  */
    /* JADX WARN: Code duplicated, block: B:95:0x010f  */
    /* JADX WARN: Code duplicated, block: B:98:0x0118  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for Binary Compatibility.")
    /* JADX INFO: renamed from: PrimaryScrollableTabRow-qhFBPw4, reason: not valid java name */
    public static final /* synthetic */ void m4387PrimaryScrollableTabRowqhFBPw4(final int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3 function3, Function2 function2, final Function2 function4, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        ScrollState scrollStateRememberScrollState;
        long primaryContainerColor;
        long primaryContentColor;
        int i5;
        float fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z;
        final Modifier modifier3;
        final ScrollState scrollState2;
        final long j3;
        final long j4;
        final float f2;
        final Function3 function5;
        final Function2 function6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        ComposableLambda composableLambdaRememberComposableLambda;
        ScrollState scrollState3;
        Function2 function2M3110getLambda$306947391$material3;
        int i11;
        long j5;
        float f3;
        Function3 function7;
        Modifier modifier4;
        long j6;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(1501129198);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PrimaryScrollableTabRow)N(selectedTabIndex,modifier,scrollState,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,indicator,divider,tabs)1207@51361L397:TabRow.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i13 = i3 & 2;
        if (i13 == 0) {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                if ((i3 & 4) == 0) {
                    scrollStateRememberScrollState = scrollState;
                    int i14 = composerStartRestartGroup.changed(scrollStateRememberScrollState) ? 256 : 128;
                    i4 |= i14;
                } else {
                    scrollStateRememberScrollState = scrollState;
                }
                i4 |= i14;
            } else {
                scrollStateRememberScrollState = scrollState;
            }
            if ((i2 & 3072) == 0) {
                if ((i3 & 8) == 0) {
                    primaryContainerColor = j;
                    int i15 = composerStartRestartGroup.changed(primaryContainerColor) ? 2048 : 1024;
                    i4 |= i15;
                } else {
                    primaryContainerColor = j;
                }
                i4 |= i15;
            } else {
                primaryContainerColor = j;
            }
            if ((i2 & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    primaryContentColor = j2;
                    int i16 = composerStartRestartGroup.changed(primaryContentColor) ? 16384 : 8192;
                    i4 |= i16;
                } else {
                    primaryContentColor = j2;
                }
                i4 |= i16;
            } else {
                primaryContentColor = j2;
            }
            i5 = i3 & 32;
            if (i5 != 0) {
                if ((196608 & i2) == 0) {
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
                    if (composerStartRestartGroup.changed(fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 128;
                if (i9 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
                if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
                if ((i4 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1193@50744L21,1194@50810L21,1195@50874L19,1198@51044L198");
                    if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        }
                        if ((i3 & 8) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1872002465, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.PrimaryScrollableTabRow_qhFBPw4$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            long j7 = primaryContainerColor;
                            function7 = composableLambdaRememberComposableLambda;
                            modifier4 = modifier2;
                            f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            long j8 = primaryContentColor;
                            function2M3110getLambda$306947391$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3110getLambda$306947391$material3();
                            i11 = i4;
                            scrollState3 = scrollStateRememberScrollState;
                            j5 = j7;
                            j6 = j8;
                        } else {
                            scrollState3 = scrollStateRememberScrollState;
                            long j9 = primaryContentColor;
                            function2M3110getLambda$306947391$material3 = function2;
                            i11 = i4;
                            j5 = primaryContainerColor;
                            f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            function7 = composableLambdaRememberComposableLambda;
                            modifier4 = modifier2;
                            j6 = j9;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            i4 &= -7169;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                        }
                        modifier4 = modifier2;
                        scrollState3 = scrollStateRememberScrollState;
                        j6 = primaryContentColor;
                        function2M3110getLambda$306947391$material3 = function2;
                        i11 = i4;
                        j5 = primaryContainerColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        function7 = function3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1501129198, i11, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:1207)");
                    }
                    m4386PrimaryScrollableTabRowcx2KkNY(i, modifier4, scrollState3, j5, j6, f3, function7, function2M3110getLambda$306947391$material3, TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM(), function4, composerStartRestartGroup, (i11 & 14) | 100663296 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | (458752 & i11) | (3670016 & i11) | (29360128 & i11) | ((i11 << 3) & C.ENCODING_PCM_DOUBLE), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function6 = function2M3110getLambda$306947391$material3;
                    function5 = function7;
                    f2 = f3;
                    j4 = j6;
                    j3 = j5;
                    scrollState2 = scrollState3;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    scrollState2 = scrollStateRememberScrollState;
                    j3 = primaryContainerColor;
                    j4 = primaryContentColor;
                    f2 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    function5 = function3;
                    function6 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.PrimaryScrollableTabRow_qhFBPw4$lambda$1(i, modifier3, scrollState2, j3, j4, f2, function5, function6, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
            i7 = i3 & 64;
            if (i7 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i4 |= i8;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i4 |= 12582912;
            } else if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i4 |= i10;
            }
            if ((i2 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i4 |= i12;
            }
            if ((i4 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1193@50744L21,1194@50810L21,1195@50874L19,1198@51044L198");
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    }
                    if ((i3 & 8) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1872002465, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.PrimaryScrollableTabRow_qhFBPw4$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        long j10 = primaryContainerColor;
                        function7 = composableLambdaRememberComposableLambda;
                        modifier4 = modifier2;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        long j11 = primaryContentColor;
                        function2M3110getLambda$306947391$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3110getLambda$306947391$material3();
                        i11 = i4;
                        scrollState3 = scrollStateRememberScrollState;
                        j5 = j10;
                        j6 = j11;
                    } else {
                        scrollState3 = scrollStateRememberScrollState;
                        long j12 = primaryContentColor;
                        function2M3110getLambda$306947391$material3 = function2;
                        i11 = i4;
                        j5 = primaryContainerColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        function7 = composableLambdaRememberComposableLambda;
                        modifier4 = modifier2;
                        j6 = j12;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    }
                    if ((i3 & 8) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1872002465, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.PrimaryScrollableTabRow_qhFBPw4$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        long j13 = primaryContainerColor;
                        function7 = composableLambdaRememberComposableLambda;
                        modifier4 = modifier2;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        long j14 = primaryContentColor;
                        function2M3110getLambda$306947391$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3110getLambda$306947391$material3();
                        i11 = i4;
                        scrollState3 = scrollStateRememberScrollState;
                        j5 = j13;
                        j6 = j14;
                    } else {
                        scrollState3 = scrollStateRememberScrollState;
                        long j15 = primaryContentColor;
                        function2M3110getLambda$306947391$material3 = function2;
                        i11 = i4;
                        j5 = primaryContainerColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        function7 = composableLambdaRememberComposableLambda;
                        modifier4 = modifier2;
                        j6 = j15;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1501129198, i11, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:1207)");
                }
                m4386PrimaryScrollableTabRowcx2KkNY(i, modifier4, scrollState3, j5, j6, f3, function7, function2M3110getLambda$306947391$material3, TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM(), function4, composerStartRestartGroup, (i11 & 14) | 100663296 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | (458752 & i11) | (3670016 & i11) | (29360128 & i11) | ((i11 << 3) & C.ENCODING_PCM_DOUBLE), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = function2M3110getLambda$306947391$material3;
                function5 = function7;
                f2 = f3;
                j4 = j6;
                j3 = j5;
                scrollState2 = scrollState3;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                scrollState2 = scrollStateRememberScrollState;
                j3 = primaryContainerColor;
                j4 = primaryContentColor;
                f2 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                function5 = function3;
                function6 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.PrimaryScrollableTabRow_qhFBPw4$lambda$1(i, modifier3, scrollState2, j3, j4, f2, function5, function6, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i2 & 384) == 0) {
            if ((i3 & 4) == 0) {
                scrollStateRememberScrollState = scrollState;
                if (composerStartRestartGroup.changed(scrollStateRememberScrollState)) {
                }
                i4 |= i14;
            } else {
                scrollStateRememberScrollState = scrollState;
            }
            i4 |= i14;
        } else {
            scrollStateRememberScrollState = scrollState;
        }
        if ((i2 & 3072) == 0) {
            if ((i3 & 8) == 0) {
                primaryContainerColor = j;
                if (composerStartRestartGroup.changed(primaryContainerColor)) {
                }
                i4 |= i15;
            } else {
                primaryContainerColor = j;
            }
            i4 |= i15;
        } else {
            primaryContainerColor = j;
        }
        if ((i2 & 24576) == 0) {
            if ((i3 & 16) == 0) {
                primaryContentColor = j2;
                if (composerStartRestartGroup.changed(primaryContentColor)) {
                }
                i4 |= i16;
            } else {
                primaryContentColor = j2;
            }
            i4 |= i16;
        } else {
            primaryContentColor = j2;
        }
        i5 = i3 & 32;
        if (i5 != 0) {
            if ((196608 & i2) == 0) {
                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
                if (composerStartRestartGroup.changed(fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
            i7 = i3 & 64;
            if (i7 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i4 |= i8;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i4 |= 12582912;
            } else if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i4 |= i10;
            }
            if ((i2 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i4 |= i12;
            }
            if ((i4 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1193@50744L21,1194@50810L21,1195@50874L19,1198@51044L198");
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    }
                    if ((i3 & 8) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1872002465, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.PrimaryScrollableTabRow_qhFBPw4$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        long j16 = primaryContainerColor;
                        function7 = composableLambdaRememberComposableLambda;
                        modifier4 = modifier2;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        long j17 = primaryContentColor;
                        function2M3110getLambda$306947391$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3110getLambda$306947391$material3();
                        i11 = i4;
                        scrollState3 = scrollStateRememberScrollState;
                        j5 = j16;
                        j6 = j17;
                    } else {
                        scrollState3 = scrollStateRememberScrollState;
                        long j18 = primaryContentColor;
                        function2M3110getLambda$306947391$material3 = function2;
                        i11 = i4;
                        j5 = primaryContainerColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        function7 = composableLambdaRememberComposableLambda;
                        modifier4 = modifier2;
                        j6 = j18;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    }
                    if ((i3 & 8) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1872002465, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.PrimaryScrollableTabRow_qhFBPw4$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        long j19 = primaryContainerColor;
                        function7 = composableLambdaRememberComposableLambda;
                        modifier4 = modifier2;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        long j110 = primaryContentColor;
                        function2M3110getLambda$306947391$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3110getLambda$306947391$material3();
                        i11 = i4;
                        scrollState3 = scrollStateRememberScrollState;
                        j5 = j19;
                        j6 = j110;
                    } else {
                        scrollState3 = scrollStateRememberScrollState;
                        long j111 = primaryContentColor;
                        function2M3110getLambda$306947391$material3 = function2;
                        i11 = i4;
                        j5 = primaryContainerColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        function7 = composableLambdaRememberComposableLambda;
                        modifier4 = modifier2;
                        j6 = j111;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1501129198, i11, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:1207)");
                }
                m4386PrimaryScrollableTabRowcx2KkNY(i, modifier4, scrollState3, j5, j6, f3, function7, function2M3110getLambda$306947391$material3, TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM(), function4, composerStartRestartGroup, (i11 & 14) | 100663296 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | (458752 & i11) | (3670016 & i11) | (29360128 & i11) | ((i11 << 3) & C.ENCODING_PCM_DOUBLE), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = function2M3110getLambda$306947391$material3;
                function5 = function7;
                f2 = f3;
                j4 = j6;
                j3 = j5;
                scrollState2 = scrollState3;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                scrollState2 = scrollStateRememberScrollState;
                j3 = primaryContainerColor;
                j4 = primaryContentColor;
                f2 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                function5 = function3;
                function6 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.PrimaryScrollableTabRow_qhFBPw4$lambda$1(i, modifier3, scrollState2, j3, j4, f2, function5, function6, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
        i7 = i3 & 64;
        if (i7 != 0) {
            i4 |= 1572864;
        } else if ((i2 & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i8 = 1048576;
            } else {
                i8 = 524288;
            }
            i4 |= i8;
        }
        i9 = i3 & 128;
        if (i9 != 0) {
            i4 |= 12582912;
        } else if ((i2 & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i10 = 8388608;
            } else {
                i10 = 4194304;
            }
            i4 |= i10;
        }
        if ((i2 & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i12 = 67108864;
            } else {
                i12 = 33554432;
            }
            i4 |= i12;
        }
        if ((i4 & 38347923) != 38347922) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1193@50744L21,1194@50810L21,1195@50874L19,1198@51044L198");
            if ((i2 & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i3 & 4) != 0) {
                    i4 &= -897;
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                }
                if ((i3 & 8) != 0) {
                    primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                }
                if ((i3 & 16) != 0) {
                    i4 &= -57345;
                    primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                }
                if (i5 != 0) {
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                }
                if (i7 != 0) {
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1872002465, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabRowKt.PrimaryScrollableTabRow_qhFBPw4$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    composableLambdaRememberComposableLambda = function3;
                }
                if (i9 != 0) {
                    long j112 = primaryContainerColor;
                    function7 = composableLambdaRememberComposableLambda;
                    modifier4 = modifier2;
                    f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    long j113 = primaryContentColor;
                    function2M3110getLambda$306947391$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3110getLambda$306947391$material3();
                    i11 = i4;
                    scrollState3 = scrollStateRememberScrollState;
                    j5 = j112;
                    j6 = j113;
                } else {
                    scrollState3 = scrollStateRememberScrollState;
                    long j114 = primaryContentColor;
                    function2M3110getLambda$306947391$material3 = function2;
                    i11 = i4;
                    j5 = primaryContainerColor;
                    f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    function7 = composableLambdaRememberComposableLambda;
                    modifier4 = modifier2;
                    j6 = j114;
                }
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i3 & 4) != 0) {
                    i4 &= -897;
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                }
                if ((i3 & 8) != 0) {
                    primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                }
                if ((i3 & 16) != 0) {
                    i4 &= -57345;
                    primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                }
                if (i5 != 0) {
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                }
                if (i7 != 0) {
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1872002465, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabRowKt.PrimaryScrollableTabRow_qhFBPw4$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    composableLambdaRememberComposableLambda = function3;
                }
                if (i9 != 0) {
                    long j115 = primaryContainerColor;
                    function7 = composableLambdaRememberComposableLambda;
                    modifier4 = modifier2;
                    f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    long j116 = primaryContentColor;
                    function2M3110getLambda$306947391$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3110getLambda$306947391$material3();
                    i11 = i4;
                    scrollState3 = scrollStateRememberScrollState;
                    j5 = j115;
                    j6 = j116;
                } else {
                    scrollState3 = scrollStateRememberScrollState;
                    long j117 = primaryContentColor;
                    function2M3110getLambda$306947391$material3 = function2;
                    i11 = i4;
                    j5 = primaryContainerColor;
                    f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    function7 = composableLambdaRememberComposableLambda;
                    modifier4 = modifier2;
                    j6 = j117;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1501129198, i11, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:1207)");
            }
            m4386PrimaryScrollableTabRowcx2KkNY(i, modifier4, scrollState3, j5, j6, f3, function7, function2M3110getLambda$306947391$material3, TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM(), function4, composerStartRestartGroup, (i11 & 14) | 100663296 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | (458752 & i11) | (3670016 & i11) | (29360128 & i11) | ((i11 << 3) & C.ENCODING_PCM_DOUBLE), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function6 = function2M3110getLambda$306947391$material3;
            function5 = function7;
            f2 = f3;
            j4 = j6;
            j3 = j5;
            scrollState2 = scrollState3;
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            scrollState2 = scrollStateRememberScrollState;
            j3 = primaryContainerColor;
            j4 = primaryContentColor;
            f2 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
            function5 = function3;
            function6 = function2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.PrimaryScrollableTabRow_qhFBPw4$lambda$1(i, modifier3, scrollState2, j3, j4, f2, function5, function6, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SecondaryScrollableTabRow_qhFBPw4$lambda$0(int i, TabIndicatorScope tabIndicatorScope, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C1231@52324L121:TabRow.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i2 |= (i2 & 8) == 0 ? composer.changed(tabIndicatorScope) : composer.changedInstance(tabIndicatorScope) ? 4 : 2;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(407893741, i2, -1, "androidx.compose.material3.SecondaryScrollableTabRow.<anonymous> (TabRow.kt:1231)");
            }
            TabRowDefaults.INSTANCE.m4373SecondaryIndicator9IZ8Weo(tabIndicatorScope.tabIndicatorOffset(Modifier.INSTANCE, i, false), 0.0f, 0L, composer, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0127  */
    /* JADX WARN: Code duplicated, block: B:113:0x014e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:114:0x0150  */
    /* JADX WARN: Code duplicated, block: B:117:0x0159  */
    /* JADX WARN: Code duplicated, block: B:120:0x0168  */
    /* JADX WARN: Code duplicated, block: B:123:0x0174  */
    /* JADX WARN: Code duplicated, block: B:125:0x017f  */
    /* JADX WARN: Code duplicated, block: B:127:0x0188  */
    /* JADX WARN: Code duplicated, block: B:128:0x0199  */
    /* JADX WARN: Code duplicated, block: B:130:0x019d  */
    /* JADX WARN: Code duplicated, block: B:131:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:134:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:137:0x0207  */
    /* JADX WARN: Code duplicated, block: B:139:0x0212  */
    /* JADX WARN: Code duplicated, block: B:142:0x0224  */
    /* JADX WARN: Code duplicated, block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0063  */
    /* JADX WARN: Code duplicated, block: B:38:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:45:0x007a  */
    /* JADX WARN: Code duplicated, block: B:47:0x007e  */
    /* JADX WARN: Code duplicated, block: B:49:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:53:0x008f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0097  */
    /* JADX WARN: Code duplicated, block: B:57:0x0099  */
    /* JADX WARN: Code duplicated, block: B:59:0x009c  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:70:0x00be  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:80:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:94:0x010d  */
    /* JADX WARN: Code duplicated, block: B:95:0x010f  */
    /* JADX WARN: Code duplicated, block: B:98:0x0118  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for Binary Compatibility.")
    /* JADX INFO: renamed from: SecondaryScrollableTabRow-qhFBPw4, reason: not valid java name */
    public static final /* synthetic */ void m4393SecondaryScrollableTabRowqhFBPw4(final int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3 function3, Function2 function2, final Function2 function4, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        ScrollState scrollStateRememberScrollState;
        long secondaryContainerColor;
        long secondaryContentColor;
        int i5;
        float fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z;
        final Modifier modifier3;
        final ScrollState scrollState2;
        final long j3;
        final long j4;
        final float f2;
        final Function3 function5;
        final Function2 function6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        ComposableLambda composableLambdaRememberComposableLambda;
        ScrollState scrollState3;
        Function2 lambda$1187266255$material3;
        int i11;
        long j5;
        float f3;
        Function3 function7;
        Modifier modifier4;
        long j6;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(-712886596);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SecondaryScrollableTabRow)N(selectedTabIndex,modifier,scrollState,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,indicator,divider,tabs)1238@52574L399:TabRow.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i13 = i3 & 2;
        if (i13 == 0) {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                if ((i3 & 4) == 0) {
                    scrollStateRememberScrollState = scrollState;
                    int i14 = composerStartRestartGroup.changed(scrollStateRememberScrollState) ? 256 : 128;
                    i4 |= i14;
                } else {
                    scrollStateRememberScrollState = scrollState;
                }
                i4 |= i14;
            } else {
                scrollStateRememberScrollState = scrollState;
            }
            if ((i2 & 3072) == 0) {
                if ((i3 & 8) == 0) {
                    secondaryContainerColor = j;
                    int i15 = composerStartRestartGroup.changed(secondaryContainerColor) ? 2048 : 1024;
                    i4 |= i15;
                } else {
                    secondaryContainerColor = j;
                }
                i4 |= i15;
            } else {
                secondaryContainerColor = j;
            }
            if ((i2 & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    secondaryContentColor = j2;
                    int i16 = composerStartRestartGroup.changed(secondaryContentColor) ? 16384 : 8192;
                    i4 |= i16;
                } else {
                    secondaryContentColor = j2;
                }
                i4 |= i16;
            } else {
                secondaryContentColor = j2;
            }
            i5 = i3 & 32;
            if (i5 != 0) {
                if ((196608 & i2) == 0) {
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
                    if (composerStartRestartGroup.changed(fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 128;
                if (i9 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
                if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
                if ((i4 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1225@51991L21,1226@52057L23,1227@52123L21,1230@52295L160");
                    if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        }
                        if ((i3 & 8) != 0) {
                            secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(407893741, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda25
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.SecondaryScrollableTabRow_qhFBPw4$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function3;
                        }
                        if (i9 != 0) {
                            long j7 = secondaryContainerColor;
                            function7 = composableLambdaRememberComposableLambda;
                            modifier4 = modifier2;
                            f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            long j8 = secondaryContentColor;
                            lambda$1187266255$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$1187266255$material3();
                            i11 = i4;
                            scrollState3 = scrollStateRememberScrollState;
                            j5 = j7;
                            j6 = j8;
                        } else {
                            scrollState3 = scrollStateRememberScrollState;
                            long j9 = secondaryContentColor;
                            lambda$1187266255$material3 = function2;
                            i11 = i4;
                            j5 = secondaryContainerColor;
                            f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            function7 = composableLambdaRememberComposableLambda;
                            modifier4 = modifier2;
                            j6 = j9;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            i4 &= -7169;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                        }
                        modifier4 = modifier2;
                        scrollState3 = scrollStateRememberScrollState;
                        j6 = secondaryContentColor;
                        lambda$1187266255$material3 = function2;
                        i11 = i4;
                        j5 = secondaryContainerColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        function7 = function3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-712886596, i11, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:1238)");
                    }
                    m4392SecondaryScrollableTabRowcx2KkNY(i, modifier4, scrollState3, j5, j6, f3, function7, lambda$1187266255$material3, TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM(), function4, composerStartRestartGroup, (i11 & 14) | 100663296 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | (458752 & i11) | (3670016 & i11) | (29360128 & i11) | ((i11 << 3) & C.ENCODING_PCM_DOUBLE), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function6 = lambda$1187266255$material3;
                    function5 = function7;
                    f2 = f3;
                    j4 = j6;
                    j3 = j5;
                    scrollState2 = scrollState3;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    scrollState2 = scrollStateRememberScrollState;
                    j3 = secondaryContainerColor;
                    j4 = secondaryContentColor;
                    f2 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    function5 = function3;
                    function6 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda26
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.SecondaryScrollableTabRow_qhFBPw4$lambda$1(i, modifier3, scrollState2, j3, j4, f2, function5, function6, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
            i7 = i3 & 64;
            if (i7 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i4 |= i8;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i4 |= 12582912;
            } else if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i4 |= i10;
            }
            if ((i2 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i4 |= i12;
            }
            if ((i4 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1225@51991L21,1226@52057L23,1227@52123L21,1230@52295L160");
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    }
                    if ((i3 & 8) != 0) {
                        secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(407893741, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda25
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.SecondaryScrollableTabRow_qhFBPw4$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        long j10 = secondaryContainerColor;
                        function7 = composableLambdaRememberComposableLambda;
                        modifier4 = modifier2;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        long j11 = secondaryContentColor;
                        lambda$1187266255$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$1187266255$material3();
                        i11 = i4;
                        scrollState3 = scrollStateRememberScrollState;
                        j5 = j10;
                        j6 = j11;
                    } else {
                        scrollState3 = scrollStateRememberScrollState;
                        long j12 = secondaryContentColor;
                        lambda$1187266255$material3 = function2;
                        i11 = i4;
                        j5 = secondaryContainerColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        function7 = composableLambdaRememberComposableLambda;
                        modifier4 = modifier2;
                        j6 = j12;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    }
                    if ((i3 & 8) != 0) {
                        secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(407893741, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda25
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.SecondaryScrollableTabRow_qhFBPw4$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        long j13 = secondaryContainerColor;
                        function7 = composableLambdaRememberComposableLambda;
                        modifier4 = modifier2;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        long j14 = secondaryContentColor;
                        lambda$1187266255$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$1187266255$material3();
                        i11 = i4;
                        scrollState3 = scrollStateRememberScrollState;
                        j5 = j13;
                        j6 = j14;
                    } else {
                        scrollState3 = scrollStateRememberScrollState;
                        long j15 = secondaryContentColor;
                        lambda$1187266255$material3 = function2;
                        i11 = i4;
                        j5 = secondaryContainerColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        function7 = composableLambdaRememberComposableLambda;
                        modifier4 = modifier2;
                        j6 = j15;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-712886596, i11, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:1238)");
                }
                m4392SecondaryScrollableTabRowcx2KkNY(i, modifier4, scrollState3, j5, j6, f3, function7, lambda$1187266255$material3, TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM(), function4, composerStartRestartGroup, (i11 & 14) | 100663296 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | (458752 & i11) | (3670016 & i11) | (29360128 & i11) | ((i11 << 3) & C.ENCODING_PCM_DOUBLE), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = lambda$1187266255$material3;
                function5 = function7;
                f2 = f3;
                j4 = j6;
                j3 = j5;
                scrollState2 = scrollState3;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                scrollState2 = scrollStateRememberScrollState;
                j3 = secondaryContainerColor;
                j4 = secondaryContentColor;
                f2 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                function5 = function3;
                function6 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.SecondaryScrollableTabRow_qhFBPw4$lambda$1(i, modifier3, scrollState2, j3, j4, f2, function5, function6, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i2 & 384) == 0) {
            if ((i3 & 4) == 0) {
                scrollStateRememberScrollState = scrollState;
                if (composerStartRestartGroup.changed(scrollStateRememberScrollState)) {
                }
                i4 |= i14;
            } else {
                scrollStateRememberScrollState = scrollState;
            }
            i4 |= i14;
        } else {
            scrollStateRememberScrollState = scrollState;
        }
        if ((i2 & 3072) == 0) {
            if ((i3 & 8) == 0) {
                secondaryContainerColor = j;
                if (composerStartRestartGroup.changed(secondaryContainerColor)) {
                }
                i4 |= i15;
            } else {
                secondaryContainerColor = j;
            }
            i4 |= i15;
        } else {
            secondaryContainerColor = j;
        }
        if ((i2 & 24576) == 0) {
            if ((i3 & 16) == 0) {
                secondaryContentColor = j2;
                if (composerStartRestartGroup.changed(secondaryContentColor)) {
                }
                i4 |= i16;
            } else {
                secondaryContentColor = j2;
            }
            i4 |= i16;
        } else {
            secondaryContentColor = j2;
        }
        i5 = i3 & 32;
        if (i5 != 0) {
            if ((196608 & i2) == 0) {
                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
                if (composerStartRestartGroup.changed(fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
            i7 = i3 & 64;
            if (i7 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i4 |= i8;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i4 |= 12582912;
            } else if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i4 |= i10;
            }
            if ((i2 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i4 |= i12;
            }
            if ((i4 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1225@51991L21,1226@52057L23,1227@52123L21,1230@52295L160");
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    }
                    if ((i3 & 8) != 0) {
                        secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(407893741, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda25
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.SecondaryScrollableTabRow_qhFBPw4$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        long j16 = secondaryContainerColor;
                        function7 = composableLambdaRememberComposableLambda;
                        modifier4 = modifier2;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        long j17 = secondaryContentColor;
                        lambda$1187266255$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$1187266255$material3();
                        i11 = i4;
                        scrollState3 = scrollStateRememberScrollState;
                        j5 = j16;
                        j6 = j17;
                    } else {
                        scrollState3 = scrollStateRememberScrollState;
                        long j18 = secondaryContentColor;
                        lambda$1187266255$material3 = function2;
                        i11 = i4;
                        j5 = secondaryContainerColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        function7 = composableLambdaRememberComposableLambda;
                        modifier4 = modifier2;
                        j6 = j18;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    }
                    if ((i3 & 8) != 0) {
                        secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(407893741, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda25
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.SecondaryScrollableTabRow_qhFBPw4$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function3;
                    }
                    if (i9 != 0) {
                        long j19 = secondaryContainerColor;
                        function7 = composableLambdaRememberComposableLambda;
                        modifier4 = modifier2;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        long j110 = secondaryContentColor;
                        lambda$1187266255$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$1187266255$material3();
                        i11 = i4;
                        scrollState3 = scrollStateRememberScrollState;
                        j5 = j19;
                        j6 = j110;
                    } else {
                        scrollState3 = scrollStateRememberScrollState;
                        long j111 = secondaryContentColor;
                        lambda$1187266255$material3 = function2;
                        i11 = i4;
                        j5 = secondaryContainerColor;
                        f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                        function7 = composableLambdaRememberComposableLambda;
                        modifier4 = modifier2;
                        j6 = j111;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-712886596, i11, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:1238)");
                }
                m4392SecondaryScrollableTabRowcx2KkNY(i, modifier4, scrollState3, j5, j6, f3, function7, lambda$1187266255$material3, TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM(), function4, composerStartRestartGroup, (i11 & 14) | 100663296 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | (458752 & i11) | (3670016 & i11) | (29360128 & i11) | ((i11 << 3) & C.ENCODING_PCM_DOUBLE), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = lambda$1187266255$material3;
                function5 = function7;
                f2 = f3;
                j4 = j6;
                j3 = j5;
                scrollState2 = scrollState3;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                scrollState2 = scrollStateRememberScrollState;
                j3 = secondaryContainerColor;
                j4 = secondaryContentColor;
                f2 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                function5 = function3;
                function6 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.SecondaryScrollableTabRow_qhFBPw4$lambda$1(i, modifier3, scrollState2, j3, j4, f2, function5, function6, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
        i7 = i3 & 64;
        if (i7 != 0) {
            i4 |= 1572864;
        } else if ((i2 & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i8 = 1048576;
            } else {
                i8 = 524288;
            }
            i4 |= i8;
        }
        i9 = i3 & 128;
        if (i9 != 0) {
            i4 |= 12582912;
        } else if ((i2 & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i10 = 8388608;
            } else {
                i10 = 4194304;
            }
            i4 |= i10;
        }
        if ((i2 & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i12 = 67108864;
            } else {
                i12 = 33554432;
            }
            i4 |= i12;
        }
        if ((i4 & 38347923) != 38347922) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1225@51991L21,1226@52057L23,1227@52123L21,1230@52295L160");
            if ((i2 & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i3 & 4) != 0) {
                    i4 &= -897;
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                }
                if ((i3 & 8) != 0) {
                    secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                }
                if ((i3 & 16) != 0) {
                    i4 &= -57345;
                    secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                }
                if (i5 != 0) {
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                }
                if (i7 != 0) {
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(407893741, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda25
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabRowKt.SecondaryScrollableTabRow_qhFBPw4$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    composableLambdaRememberComposableLambda = function3;
                }
                if (i9 != 0) {
                    long j112 = secondaryContainerColor;
                    function7 = composableLambdaRememberComposableLambda;
                    modifier4 = modifier2;
                    f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    long j113 = secondaryContentColor;
                    lambda$1187266255$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$1187266255$material3();
                    i11 = i4;
                    scrollState3 = scrollStateRememberScrollState;
                    j5 = j112;
                    j6 = j113;
                } else {
                    scrollState3 = scrollStateRememberScrollState;
                    long j114 = secondaryContentColor;
                    lambda$1187266255$material3 = function2;
                    i11 = i4;
                    j5 = secondaryContainerColor;
                    f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    function7 = composableLambdaRememberComposableLambda;
                    modifier4 = modifier2;
                    j6 = j114;
                }
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i3 & 4) != 0) {
                    i4 &= -897;
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                }
                if ((i3 & 8) != 0) {
                    secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                }
                if ((i3 & 16) != 0) {
                    i4 &= -57345;
                    secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                }
                if (i5 != 0) {
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                }
                if (i7 != 0) {
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(407893741, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda25
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabRowKt.SecondaryScrollableTabRow_qhFBPw4$lambda$0(i, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    composableLambdaRememberComposableLambda = function3;
                }
                if (i9 != 0) {
                    long j115 = secondaryContainerColor;
                    function7 = composableLambdaRememberComposableLambda;
                    modifier4 = modifier2;
                    f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    long j116 = secondaryContentColor;
                    lambda$1187266255$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$1187266255$material3();
                    i11 = i4;
                    scrollState3 = scrollStateRememberScrollState;
                    j5 = j115;
                    j6 = j116;
                } else {
                    scrollState3 = scrollStateRememberScrollState;
                    long j117 = secondaryContentColor;
                    lambda$1187266255$material3 = function2;
                    i11 = i4;
                    j5 = secondaryContainerColor;
                    f3 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                    function7 = composableLambdaRememberComposableLambda;
                    modifier4 = modifier2;
                    j6 = j117;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-712886596, i11, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:1238)");
            }
            m4392SecondaryScrollableTabRowcx2KkNY(i, modifier4, scrollState3, j5, j6, f3, function7, lambda$1187266255$material3, TabRowDefaults.INSTANCE.m4375getScrollableTabRowMinTabWidthD9Ej5fM(), function4, composerStartRestartGroup, (i11 & 14) | 100663296 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | (458752 & i11) | (3670016 & i11) | (29360128 & i11) | ((i11 << 3) & C.ENCODING_PCM_DOUBLE), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function6 = lambda$1187266255$material3;
            function5 = function7;
            f2 = f3;
            j4 = j6;
            j3 = j5;
            scrollState2 = scrollState3;
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            scrollState2 = scrollStateRememberScrollState;
            j3 = secondaryContainerColor;
            j4 = secondaryContentColor;
            f2 = fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
            function5 = function3;
            function6 = function2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.SecondaryScrollableTabRow_qhFBPw4$lambda$1(i, modifier3, scrollState2, j3, j4, f2, function5, function6, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabRow_pAZo6Ak$lambda$0(int i, List list, Composer composer, int i2) {
        Composer composer2;
        ComposerKt.sourceInformation(composer, "CN(tabPositions):TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(906699528, i2, -1, "androidx.compose.material3.TabRow.<anonymous> (TabRow.kt:1342)");
        }
        if (i >= list.size()) {
            composer2 = composer;
            composer2.startReplaceGroup(379108442);
        } else {
            composer.startReplaceGroup(436390614);
            ComposerKt.sourceInformation(composer, "1343@57771L117");
            composer2 = composer;
            TabRowDefaults.INSTANCE.m4373SecondaryIndicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, (TabPosition) list.get(i)), 0.0f, 0L, composer2, 3072, 6);
        }
        composer2.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x012b  */
    /* JADX WARN: Code duplicated, block: B:102:0x012e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0140  */
    /* JADX WARN: Code duplicated, block: B:105:0x0143  */
    /* JADX WARN: Code duplicated, block: B:106:0x0154  */
    /* JADX WARN: Code duplicated, block: B:109:0x0167  */
    /* JADX WARN: Code duplicated, block: B:112:0x0181  */
    /* JADX WARN: Code duplicated, block: B:114:0x018c  */
    /* JADX WARN: Code duplicated, block: B:117:0x019d  */
    /* JADX WARN: Code duplicated, block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0061  */
    /* JADX WARN: Code duplicated, block: B:38:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0072  */
    /* JADX WARN: Code duplicated, block: B:45:0x0078  */
    /* JADX WARN: Code duplicated, block: B:46:0x007b  */
    /* JADX WARN: Code duplicated, block: B:48:0x007f  */
    /* JADX WARN: Code duplicated, block: B:50:0x0087  */
    /* JADX WARN: Code duplicated, block: B:51:0x008a  */
    /* JADX WARN: Code duplicated, block: B:56:0x0096  */
    /* JADX WARN: Code duplicated, block: B:57:0x0098  */
    /* JADX WARN: Code duplicated, block: B:59:0x009b  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:79:0x00da  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:91:0x0108 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x010a  */
    /* JADX WARN: Code duplicated, block: B:93:0x010f  */
    /* JADX WARN: Code duplicated, block: B:96:0x0116  */
    /* JADX WARN: Code duplicated, block: B:99:0x0122  */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Replaced with PrimaryTabRow and SecondaryTabRow.", replaceWith = @ReplaceWith(expression = "SecondaryTabRow(selectedTabIndex, modifier, containerColor, contentColor, indicator, divider, tabs)", imports = {}))
    /* JADX INFO: renamed from: TabRow-pAZo6Ak, reason: not valid java name */
    public static final void m4395TabRowpAZo6Ak(final int i, Modifier modifier, long j, long j2, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3) {
        int i4;
        long primaryContainerColor;
        long j3;
        int i5;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function5;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function6;
        int i8;
        boolean z;
        Composer composer2;
        final Modifier modifier2;
        final long j4;
        final long j5;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function7;
        final Function2<? super Composer, ? super Integer, Unit> function8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long primaryContentColor;
        ComposableLambda composableLambdaRememberComposableLambda;
        Modifier modifier3;
        long j6;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function9;
        Function2<? super Composer, ? super Integer, Unit> function2M3108getLambda$1132537920$material3;
        int i9;
        long j7;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(1445190381);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabRow)N(selectedTabIndex,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,indicator,divider,tabs)1351@58031L90:TabRow.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i11 = i3 & 2;
        if (i11 == 0) {
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                if ((i3 & 4) == 0) {
                    primaryContainerColor = j;
                    int i12 = composerStartRestartGroup.changed(primaryContainerColor) ? 256 : 128;
                    i4 |= i12;
                } else {
                    primaryContainerColor = j;
                }
                i4 |= i12;
            } else {
                primaryContainerColor = j;
            }
            if ((i2 & 3072) == 0) {
                if ((i3 & 8) == 0) {
                    j3 = j2;
                    int i13 = composerStartRestartGroup.changed(j3) ? 2048 : 1024;
                    i4 |= i13;
                } else {
                    j3 = j2;
                }
                i4 |= i13;
            } else {
                j3 = j2;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((i2 & 24576) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 32;
                if (i7 != 0) {
                    if ((196608 & i2) == 0) {
                        function6 = function2;
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                        i4 |= i8;
                    }
                    if ((1572864 & i2) != 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i4 |= i10;
                    }
                    if ((i4 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "1338@57490L21,1339@57554L19,1341@57666L246");
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                primaryContentColor = j3;
                            }
                            if (i5 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(906699528, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda16
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function5;
                            }
                            if (i7 != 0) {
                                modifier3 = companion;
                                j7 = primaryContentColor;
                                j6 = primaryContainerColor;
                                function9 = composableLambdaRememberComposableLambda;
                                function2M3108getLambda$1132537920$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3108getLambda$1132537920$material3();
                                i9 = 1445190381;
                            } else {
                                modifier3 = companion;
                                j6 = primaryContainerColor;
                                function9 = composableLambdaRememberComposableLambda;
                                function2M3108getLambda$1132537920$material3 = function6;
                                i9 = 1445190381;
                                j7 = primaryContentColor;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                i4 &= -7169;
                            }
                            modifier3 = modifier;
                            function9 = function5;
                            function2M3108getLambda$1132537920$material3 = function6;
                            i9 = 1445190381;
                            j6 = primaryContainerColor;
                            j7 = j3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.TabRow (TabRow.kt:1350)");
                        }
                        composer2 = composerStartRestartGroup;
                        m4397TabRowWithSubcomposeImplDTcfvLk(modifier3, j6, j7, function9, function2M3108getLambda$1132537920$material3, function4, composer2, (i4 >> 3) & 524286);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        j4 = j6;
                        j5 = j7;
                        function7 = function9;
                        function8 = function2M3108getLambda$1132537920$material3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = modifier;
                        j4 = primaryContainerColor;
                        j5 = j3;
                        function7 = function5;
                        function8 = function6;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.TabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function6 = function2;
                if ((1572864 & i2) != 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((i4 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1338@57490L21,1339@57554L19,1341@57666L246");
                    if ((i2 & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(906699528, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda16
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            modifier3 = companion;
                            j7 = primaryContentColor;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3108getLambda$1132537920$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3108getLambda$1132537920$material3();
                            i9 = 1445190381;
                        } else {
                            modifier3 = companion;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3108getLambda$1132537920$material3 = function6;
                            i9 = 1445190381;
                            j7 = primaryContentColor;
                        }
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(906699528, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda16
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            modifier3 = companion;
                            j7 = primaryContentColor;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3108getLambda$1132537920$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3108getLambda$1132537920$material3();
                            i9 = 1445190381;
                        } else {
                            modifier3 = companion;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3108getLambda$1132537920$material3 = function6;
                            i9 = 1445190381;
                            j7 = primaryContentColor;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.TabRow (TabRow.kt:1350)");
                    }
                    composer2 = composerStartRestartGroup;
                    m4397TabRowWithSubcomposeImplDTcfvLk(modifier3, j6, j7, function9, function2M3108getLambda$1132537920$material3, function4, composer2, (i4 >> 3) & 524286);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j4 = j6;
                    j5 = j7;
                    function7 = function9;
                    function8 = function2M3108getLambda$1132537920$material3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    j4 = primaryContainerColor;
                    j5 = j3;
                    function7 = function5;
                    function8 = function6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.TabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            function5 = function3;
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((196608 & i2) == 0) {
                    function6 = function2;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i4 |= i8;
                }
                if ((1572864 & i2) != 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((i4 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1338@57490L21,1339@57554L19,1341@57666L246");
                    if ((i2 & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(906699528, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda16
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            modifier3 = companion;
                            j7 = primaryContentColor;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3108getLambda$1132537920$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3108getLambda$1132537920$material3();
                            i9 = 1445190381;
                        } else {
                            modifier3 = companion;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3108getLambda$1132537920$material3 = function6;
                            i9 = 1445190381;
                            j7 = primaryContentColor;
                        }
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(906699528, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda16
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            modifier3 = companion;
                            j7 = primaryContentColor;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3108getLambda$1132537920$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3108getLambda$1132537920$material3();
                            i9 = 1445190381;
                        } else {
                            modifier3 = companion;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3108getLambda$1132537920$material3 = function6;
                            i9 = 1445190381;
                            j7 = primaryContentColor;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.TabRow (TabRow.kt:1350)");
                    }
                    composer2 = composerStartRestartGroup;
                    m4397TabRowWithSubcomposeImplDTcfvLk(modifier3, j6, j7, function9, function2M3108getLambda$1132537920$material3, function4, composer2, (i4 >> 3) & 524286);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j4 = j6;
                    j5 = j7;
                    function7 = function9;
                    function8 = function2M3108getLambda$1132537920$material3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    j4 = primaryContainerColor;
                    j5 = j3;
                    function7 = function5;
                    function8 = function6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.TabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function6 = function2;
            if ((1572864 & i2) != 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i4 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1338@57490L21,1339@57554L19,1341@57666L246");
                if ((i2 & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(906699528, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        modifier3 = companion;
                        j7 = primaryContentColor;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3108getLambda$1132537920$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3108getLambda$1132537920$material3();
                        i9 = 1445190381;
                    } else {
                        modifier3 = companion;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3108getLambda$1132537920$material3 = function6;
                        i9 = 1445190381;
                        j7 = primaryContentColor;
                    }
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(906699528, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        modifier3 = companion;
                        j7 = primaryContentColor;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3108getLambda$1132537920$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3108getLambda$1132537920$material3();
                        i9 = 1445190381;
                    } else {
                        modifier3 = companion;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3108getLambda$1132537920$material3 = function6;
                        i9 = 1445190381;
                        j7 = primaryContentColor;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.TabRow (TabRow.kt:1350)");
                }
                composer2 = composerStartRestartGroup;
                m4397TabRowWithSubcomposeImplDTcfvLk(modifier3, j6, j7, function9, function2M3108getLambda$1132537920$material3, function4, composer2, (i4 >> 3) & 524286);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j4 = j6;
                j5 = j7;
                function7 = function9;
                function8 = function2M3108getLambda$1132537920$material3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                j4 = primaryContainerColor;
                j5 = j3;
                function7 = function5;
                function8 = function6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.TabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        if ((i2 & 384) == 0) {
            if ((i3 & 4) == 0) {
                primaryContainerColor = j;
                if (composerStartRestartGroup.changed(primaryContainerColor)) {
                }
                i4 |= i12;
            } else {
                primaryContainerColor = j;
            }
            i4 |= i12;
        } else {
            primaryContainerColor = j;
        }
        if ((i2 & 3072) == 0) {
            if ((i3 & 8) == 0) {
                j3 = j2;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i4 |= i13;
            } else {
                j3 = j2;
            }
            i4 |= i13;
        } else {
            j3 = j2;
        }
        i5 = i3 & 16;
        if (i5 != 0) {
            if ((i2 & 24576) == 0) {
                function5 = function3;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i4 |= i6;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((196608 & i2) == 0) {
                    function6 = function2;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i4 |= i8;
                }
                if ((1572864 & i2) != 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((i4 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1338@57490L21,1339@57554L19,1341@57666L246");
                    if ((i2 & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(906699528, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda16
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            modifier3 = companion;
                            j7 = primaryContentColor;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3108getLambda$1132537920$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3108getLambda$1132537920$material3();
                            i9 = 1445190381;
                        } else {
                            modifier3 = companion;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3108getLambda$1132537920$material3 = function6;
                            i9 = 1445190381;
                            j7 = primaryContentColor;
                        }
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(906699528, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda16
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            modifier3 = companion;
                            j7 = primaryContentColor;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3108getLambda$1132537920$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3108getLambda$1132537920$material3();
                            i9 = 1445190381;
                        } else {
                            modifier3 = companion;
                            j6 = primaryContainerColor;
                            function9 = composableLambdaRememberComposableLambda;
                            function2M3108getLambda$1132537920$material3 = function6;
                            i9 = 1445190381;
                            j7 = primaryContentColor;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.TabRow (TabRow.kt:1350)");
                    }
                    composer2 = composerStartRestartGroup;
                    m4397TabRowWithSubcomposeImplDTcfvLk(modifier3, j6, j7, function9, function2M3108getLambda$1132537920$material3, function4, composer2, (i4 >> 3) & 524286);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j4 = j6;
                    j5 = j7;
                    function7 = function9;
                    function8 = function2M3108getLambda$1132537920$material3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    j4 = primaryContainerColor;
                    j5 = j3;
                    function7 = function5;
                    function8 = function6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.TabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function6 = function2;
            if ((1572864 & i2) != 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i4 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1338@57490L21,1339@57554L19,1341@57666L246");
                if ((i2 & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(906699528, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        modifier3 = companion;
                        j7 = primaryContentColor;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3108getLambda$1132537920$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3108getLambda$1132537920$material3();
                        i9 = 1445190381;
                    } else {
                        modifier3 = companion;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3108getLambda$1132537920$material3 = function6;
                        i9 = 1445190381;
                        j7 = primaryContentColor;
                    }
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(906699528, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        modifier3 = companion;
                        j7 = primaryContentColor;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3108getLambda$1132537920$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3108getLambda$1132537920$material3();
                        i9 = 1445190381;
                    } else {
                        modifier3 = companion;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3108getLambda$1132537920$material3 = function6;
                        i9 = 1445190381;
                        j7 = primaryContentColor;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.TabRow (TabRow.kt:1350)");
                }
                composer2 = composerStartRestartGroup;
                m4397TabRowWithSubcomposeImplDTcfvLk(modifier3, j6, j7, function9, function2M3108getLambda$1132537920$material3, function4, composer2, (i4 >> 3) & 524286);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j4 = j6;
                j5 = j7;
                function7 = function9;
                function8 = function2M3108getLambda$1132537920$material3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                j4 = primaryContainerColor;
                j5 = j3;
                function7 = function5;
                function8 = function6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.TabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        function5 = function3;
        i7 = i3 & 32;
        if (i7 != 0) {
            if ((196608 & i2) == 0) {
                function6 = function2;
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i4 |= i8;
            }
            if ((1572864 & i2) != 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i4 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1338@57490L21,1339@57554L19,1341@57666L246");
                if ((i2 & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(906699528, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        modifier3 = companion;
                        j7 = primaryContentColor;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3108getLambda$1132537920$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3108getLambda$1132537920$material3();
                        i9 = 1445190381;
                    } else {
                        modifier3 = companion;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3108getLambda$1132537920$material3 = function6;
                        i9 = 1445190381;
                        j7 = primaryContentColor;
                    }
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(906699528, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        modifier3 = companion;
                        j7 = primaryContentColor;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3108getLambda$1132537920$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3108getLambda$1132537920$material3();
                        i9 = 1445190381;
                    } else {
                        modifier3 = companion;
                        j6 = primaryContainerColor;
                        function9 = composableLambdaRememberComposableLambda;
                        function2M3108getLambda$1132537920$material3 = function6;
                        i9 = 1445190381;
                        j7 = primaryContentColor;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.TabRow (TabRow.kt:1350)");
                }
                composer2 = composerStartRestartGroup;
                m4397TabRowWithSubcomposeImplDTcfvLk(modifier3, j6, j7, function9, function2M3108getLambda$1132537920$material3, function4, composer2, (i4 >> 3) & 524286);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j4 = j6;
                j5 = j7;
                function7 = function9;
                function8 = function2M3108getLambda$1132537920$material3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                j4 = primaryContainerColor;
                j5 = j3;
                function7 = function5;
                function8 = function6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.TabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function6 = function2;
        if ((1572864 & i2) != 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i10 = 1048576;
            } else {
                i10 = 524288;
            }
            i4 |= i10;
        }
        if ((i4 & 599187) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1338@57490L21,1339@57554L19,1341@57666L246");
            if ((i2 & 1) != 0) {
                if (i11 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i3 & 4) != 0) {
                    primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    primaryContentColor = j3;
                }
                if (i5 != 0) {
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(906699528, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    composableLambdaRememberComposableLambda = function5;
                }
                if (i7 != 0) {
                    modifier3 = companion;
                    j7 = primaryContentColor;
                    j6 = primaryContainerColor;
                    function9 = composableLambdaRememberComposableLambda;
                    function2M3108getLambda$1132537920$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3108getLambda$1132537920$material3();
                    i9 = 1445190381;
                } else {
                    modifier3 = companion;
                    j6 = primaryContainerColor;
                    function9 = composableLambdaRememberComposableLambda;
                    function2M3108getLambda$1132537920$material3 = function6;
                    i9 = 1445190381;
                    j7 = primaryContentColor;
                }
            } else {
                if (i11 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i3 & 4) != 0) {
                    primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    primaryContentColor = j3;
                }
                if (i5 != 0) {
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(906699528, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    composableLambdaRememberComposableLambda = function5;
                }
                if (i7 != 0) {
                    modifier3 = companion;
                    j7 = primaryContentColor;
                    j6 = primaryContainerColor;
                    function9 = composableLambdaRememberComposableLambda;
                    function2M3108getLambda$1132537920$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3108getLambda$1132537920$material3();
                    i9 = 1445190381;
                } else {
                    modifier3 = companion;
                    j6 = primaryContainerColor;
                    function9 = composableLambdaRememberComposableLambda;
                    function2M3108getLambda$1132537920$material3 = function6;
                    i9 = 1445190381;
                    j7 = primaryContentColor;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.TabRow (TabRow.kt:1350)");
            }
            composer2 = composerStartRestartGroup;
            m4397TabRowWithSubcomposeImplDTcfvLk(modifier3, j6, j7, function9, function2M3108getLambda$1132537920$material3, function4, composer2, (i4 >> 3) & 524286);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            j4 = j6;
            j5 = j7;
            function7 = function9;
            function8 = function2M3108getLambda$1132537920$material3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier2 = modifier;
            j4 = primaryContainerColor;
            j5 = j3;
            function7 = function5;
            function8 = function6;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.TabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableTabRow_sKfQg0A$lambda$0(int i, List list, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "CN(tabPositions)1409@61286L109:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-720441215, i2, -1, "androidx.compose.material3.ScrollableTabRow.<anonymous> (TabRow.kt:1409)");
        }
        TabRowDefaults.INSTANCE.m4373SecondaryIndicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, (TabPosition) list.get(i)), 0.0f, 0L, composer, 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0123 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x0125  */
    /* JADX WARN: Code duplicated, block: B:103:0x012a  */
    /* JADX WARN: Code duplicated, block: B:106:0x0131  */
    /* JADX WARN: Code duplicated, block: B:109:0x013d  */
    /* JADX WARN: Code duplicated, block: B:110:0x0146  */
    /* JADX WARN: Code duplicated, block: B:112:0x0149  */
    /* JADX WARN: Code duplicated, block: B:113:0x0150  */
    /* JADX WARN: Code duplicated, block: B:115:0x0153  */
    /* JADX WARN: Code duplicated, block: B:116:0x0165  */
    /* JADX WARN: Code duplicated, block: B:118:0x0168  */
    /* JADX WARN: Code duplicated, block: B:119:0x017b  */
    /* JADX WARN: Code duplicated, block: B:122:0x018d  */
    /* JADX WARN: Code duplicated, block: B:125:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:127:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:130:0x01df  */
    /* JADX WARN: Code duplicated, block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0061  */
    /* JADX WARN: Code duplicated, block: B:38:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0072  */
    /* JADX WARN: Code duplicated, block: B:45:0x0078  */
    /* JADX WARN: Code duplicated, block: B:46:0x007b  */
    /* JADX WARN: Code duplicated, block: B:48:0x007f  */
    /* JADX WARN: Code duplicated, block: B:50:0x0087  */
    /* JADX WARN: Code duplicated, block: B:51:0x008a  */
    /* JADX WARN: Code duplicated, block: B:56:0x0096  */
    /* JADX WARN: Code duplicated, block: B:57:0x0098  */
    /* JADX WARN: Code duplicated, block: B:59:0x009b  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:80:0x00db  */
    /* JADX WARN: Code duplicated, block: B:84:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:90:0x0102  */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Replaced with PrimaryScrollableTabRow and SecondaryScrollableTabRow tab variants.", replaceWith = @ReplaceWith(expression = "SecondaryScrollableTabRow(selectedTabIndex, modifier, containerColor, contentColor, edgePadding, indicator, divider, tabs)", imports = {}))
    /* JADX INFO: renamed from: ScrollableTabRow-sKfQg0A, reason: not valid java name */
    public static final void m4389ScrollableTabRowsKfQg0A(final int i, Modifier modifier, long j, long j2, float f, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3) {
        int i4;
        long primaryContainerColor;
        long j3;
        int i5;
        float f2;
        int i6;
        int i7;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function5;
        int i8;
        int i9;
        int i10;
        boolean z;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function6;
        final long j4;
        final long j5;
        final float fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long primaryContentColor;
        ComposableLambda composableLambdaRememberComposableLambda;
        int i11;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function8;
        Function2<? super Composer, ? super Integer, Unit> function2M3111getLambda$358046007$material3;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(847049916);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScrollableTabRow)N(selectedTabIndex,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,indicator,divider,tabs)1425@61848L21,1416@61524L352:TabRow.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i13 = i3 & 2;
        if (i13 == 0) {
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                if ((i3 & 4) == 0) {
                    primaryContainerColor = j;
                    int i14 = composerStartRestartGroup.changed(primaryContainerColor) ? 256 : 128;
                    i4 |= i14;
                } else {
                    primaryContainerColor = j;
                }
                i4 |= i14;
            } else {
                primaryContainerColor = j;
            }
            if ((i2 & 3072) == 0) {
                if ((i3 & 8) == 0) {
                    j3 = j2;
                    int i15 = composerStartRestartGroup.changed(j3) ? 2048 : 1024;
                    i4 |= i15;
                } else {
                    j3 = j2;
                }
                i4 |= i15;
            } else {
                j3 = j2;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((i2 & 24576) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 32;
                if (i7 != 0) {
                    if ((196608 & i2) == 0) {
                        function5 = function3;
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                        i4 |= i8;
                    }
                    i9 = i3 & 64;
                    if (i9 != 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i4 |= i10;
                    }
                    if ((i2 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i4 |= i12;
                    }
                    if ((i4 & 4793491) != 4793490) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "1404@60994L21,1405@61058L19,1408@61241L164");
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                primaryContentColor = j3;
                            }
                            if (i5 != 0) {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                            } else {
                                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                            }
                            if (i7 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-720441215, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda23
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function5;
                            }
                            if (i9 != 0) {
                                int i16 = i4;
                                modifier2 = companion;
                                function8 = composableLambdaRememberComposableLambda;
                                function2M3111getLambda$358046007$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3111getLambda$358046007$material3();
                                i11 = i16;
                                long j6 = primaryContainerColor;
                                j5 = primaryContentColor;
                                j4 = j6;
                            } else {
                                long j7 = primaryContainerColor;
                                j5 = primaryContentColor;
                                j4 = j7;
                                i11 = i4;
                                modifier2 = companion;
                                function8 = composableLambdaRememberComposableLambda;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(847049916, i11, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:1415)");
                            }
                            int i17 = i11 << 3;
                            m4391ScrollableTabRowWithSubcomposeImplqhFBPw4(i, function8, modifier2, j4, j5, fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM, function2M3111getLambda$358046007$material3, function4, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), composerStartRestartGroup, (i11 & 14) | ((i11 >> 12) & 112) | (i17 & 896) | (i17 & 7168) | (57344 & i17) | (i17 & 458752) | (3670016 & i11) | (i11 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function6 = function2M3111getLambda$358046007$material3;
                            function7 = function8;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                i4 &= -7169;
                            }
                            i11 = i4;
                            j4 = primaryContainerColor;
                            j5 = j3;
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                            function8 = function5;
                            modifier2 = modifier;
                        }
                        function2M3111getLambda$358046007$material3 = function2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(847049916, i11, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:1415)");
                        }
                        int i18 = i11 << 3;
                        m4391ScrollableTabRowWithSubcomposeImplqhFBPw4(i, function8, modifier2, j4, j5, fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM, function2M3111getLambda$358046007$material3, function4, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), composerStartRestartGroup, (i11 & 14) | ((i11 >> 12) & 112) | (i18 & 896) | (i18 & 7168) | (57344 & i18) | (i18 & 458752) | (3670016 & i11) | (i11 & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function6 = function2M3111getLambda$358046007$material3;
                        function7 = function8;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        function6 = function2;
                        j4 = primaryContainerColor;
                        j5 = j3;
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                        function7 = function5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda24
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1(i, modifier2, j4, j5, fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM, function7, function6, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function5 = function3;
                i9 = i3 & 64;
                if (i9 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i4 |= i12;
                }
                if ((i4 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1404@60994L21,1405@61058L19,1408@61241L164");
                    if ((i2 & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-720441215, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda23
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i9 != 0) {
                            int i19 = i4;
                            modifier2 = companion;
                            function8 = composableLambdaRememberComposableLambda;
                            function2M3111getLambda$358046007$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3111getLambda$358046007$material3();
                            i11 = i19;
                            long j8 = primaryContainerColor;
                            j5 = primaryContentColor;
                            j4 = j8;
                        } else {
                            long j9 = primaryContainerColor;
                            j5 = primaryContentColor;
                            j4 = j9;
                            i11 = i4;
                            modifier2 = companion;
                            function8 = composableLambdaRememberComposableLambda;
                            function2M3111getLambda$358046007$material3 = function2;
                        }
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-720441215, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda23
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i9 != 0) {
                            int i110 = i4;
                            modifier2 = companion;
                            function8 = composableLambdaRememberComposableLambda;
                            function2M3111getLambda$358046007$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3111getLambda$358046007$material3();
                            i11 = i110;
                            long j10 = primaryContainerColor;
                            j5 = primaryContentColor;
                            j4 = j10;
                        } else {
                            long j11 = primaryContainerColor;
                            j5 = primaryContentColor;
                            j4 = j11;
                            i11 = i4;
                            modifier2 = companion;
                            function8 = composableLambdaRememberComposableLambda;
                            function2M3111getLambda$358046007$material3 = function2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(847049916, i11, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:1415)");
                    }
                    int i111 = i11 << 3;
                    m4391ScrollableTabRowWithSubcomposeImplqhFBPw4(i, function8, modifier2, j4, j5, fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM, function2M3111getLambda$358046007$material3, function4, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), composerStartRestartGroup, (i11 & 14) | ((i11 >> 12) & 112) | (i111 & 896) | (i111 & 7168) | (57344 & i111) | (i111 & 458752) | (3670016 & i11) | (i11 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function6 = function2M3111getLambda$358046007$material3;
                    function7 = function8;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    function6 = function2;
                    j4 = primaryContainerColor;
                    j5 = j3;
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                    function7 = function5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1(i, modifier2, j4, j5, fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM, function7, function6, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            f2 = f;
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((196608 & i2) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i4 |= i12;
                }
                if ((i4 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1404@60994L21,1405@61058L19,1408@61241L164");
                    if ((i2 & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-720441215, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda23
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i9 != 0) {
                            int i112 = i4;
                            modifier2 = companion;
                            function8 = composableLambdaRememberComposableLambda;
                            function2M3111getLambda$358046007$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3111getLambda$358046007$material3();
                            i11 = i112;
                            long j12 = primaryContainerColor;
                            j5 = primaryContentColor;
                            j4 = j12;
                        } else {
                            long j13 = primaryContainerColor;
                            j5 = primaryContentColor;
                            j4 = j13;
                            i11 = i4;
                            modifier2 = companion;
                            function8 = composableLambdaRememberComposableLambda;
                            function2M3111getLambda$358046007$material3 = function2;
                        }
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-720441215, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda23
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i9 != 0) {
                            int i113 = i4;
                            modifier2 = companion;
                            function8 = composableLambdaRememberComposableLambda;
                            function2M3111getLambda$358046007$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3111getLambda$358046007$material3();
                            i11 = i113;
                            long j14 = primaryContainerColor;
                            j5 = primaryContentColor;
                            j4 = j14;
                        } else {
                            long j15 = primaryContainerColor;
                            j5 = primaryContentColor;
                            j4 = j15;
                            i11 = i4;
                            modifier2 = companion;
                            function8 = composableLambdaRememberComposableLambda;
                            function2M3111getLambda$358046007$material3 = function2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(847049916, i11, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:1415)");
                    }
                    int i114 = i11 << 3;
                    m4391ScrollableTabRowWithSubcomposeImplqhFBPw4(i, function8, modifier2, j4, j5, fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM, function2M3111getLambda$358046007$material3, function4, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), composerStartRestartGroup, (i11 & 14) | ((i11 >> 12) & 112) | (i114 & 896) | (i114 & 7168) | (57344 & i114) | (i114 & 458752) | (3670016 & i11) | (i11 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function6 = function2M3111getLambda$358046007$material3;
                    function7 = function8;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    function6 = function2;
                    j4 = primaryContainerColor;
                    j5 = j3;
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                    function7 = function5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1(i, modifier2, j4, j5, fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM, function7, function6, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function5 = function3;
            i9 = i3 & 64;
            if (i9 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i4 |= i12;
            }
            if ((i4 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1404@60994L21,1405@61058L19,1408@61241L164");
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-720441215, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda23
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i9 != 0) {
                        int i115 = i4;
                        modifier2 = companion;
                        function8 = composableLambdaRememberComposableLambda;
                        function2M3111getLambda$358046007$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3111getLambda$358046007$material3();
                        i11 = i115;
                        long j16 = primaryContainerColor;
                        j5 = primaryContentColor;
                        j4 = j16;
                    } else {
                        long j17 = primaryContainerColor;
                        j5 = primaryContentColor;
                        j4 = j17;
                        i11 = i4;
                        modifier2 = companion;
                        function8 = composableLambdaRememberComposableLambda;
                        function2M3111getLambda$358046007$material3 = function2;
                    }
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-720441215, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda23
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i9 != 0) {
                        int i116 = i4;
                        modifier2 = companion;
                        function8 = composableLambdaRememberComposableLambda;
                        function2M3111getLambda$358046007$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3111getLambda$358046007$material3();
                        i11 = i116;
                        long j18 = primaryContainerColor;
                        j5 = primaryContentColor;
                        j4 = j18;
                    } else {
                        long j19 = primaryContainerColor;
                        j5 = primaryContentColor;
                        j4 = j19;
                        i11 = i4;
                        modifier2 = companion;
                        function8 = composableLambdaRememberComposableLambda;
                        function2M3111getLambda$358046007$material3 = function2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(847049916, i11, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:1415)");
                }
                int i117 = i11 << 3;
                m4391ScrollableTabRowWithSubcomposeImplqhFBPw4(i, function8, modifier2, j4, j5, fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM, function2M3111getLambda$358046007$material3, function4, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), composerStartRestartGroup, (i11 & 14) | ((i11 >> 12) & 112) | (i117 & 896) | (i117 & 7168) | (57344 & i117) | (i117 & 458752) | (3670016 & i11) | (i11 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = function2M3111getLambda$358046007$material3;
                function7 = function8;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                function6 = function2;
                j4 = primaryContainerColor;
                j5 = j3;
                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                function7 = function5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1(i, modifier2, j4, j5, fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM, function7, function6, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        if ((i2 & 384) == 0) {
            if ((i3 & 4) == 0) {
                primaryContainerColor = j;
                if (composerStartRestartGroup.changed(primaryContainerColor)) {
                }
                i4 |= i14;
            } else {
                primaryContainerColor = j;
            }
            i4 |= i14;
        } else {
            primaryContainerColor = j;
        }
        if ((i2 & 3072) == 0) {
            if ((i3 & 8) == 0) {
                j3 = j2;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i4 |= i15;
            } else {
                j3 = j2;
            }
            i4 |= i15;
        } else {
            j3 = j2;
        }
        i5 = i3 & 16;
        if (i5 != 0) {
            if ((i2 & 24576) == 0) {
                f2 = f;
                if (composerStartRestartGroup.changed(f2)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i4 |= i6;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((196608 & i2) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i4 |= i12;
                }
                if ((i4 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1404@60994L21,1405@61058L19,1408@61241L164");
                    if ((i2 & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-720441215, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda23
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i9 != 0) {
                            int i118 = i4;
                            modifier2 = companion;
                            function8 = composableLambdaRememberComposableLambda;
                            function2M3111getLambda$358046007$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3111getLambda$358046007$material3();
                            i11 = i118;
                            long j110 = primaryContainerColor;
                            j5 = primaryContentColor;
                            j4 = j110;
                        } else {
                            long j111 = primaryContainerColor;
                            j5 = primaryContentColor;
                            j4 = j111;
                            i11 = i4;
                            modifier2 = companion;
                            function8 = composableLambdaRememberComposableLambda;
                            function2M3111getLambda$358046007$material3 = function2;
                        }
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            primaryContentColor = j3;
                        }
                        if (i5 != 0) {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                        } else {
                            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-720441215, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda23
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i9 != 0) {
                            int i119 = i4;
                            modifier2 = companion;
                            function8 = composableLambdaRememberComposableLambda;
                            function2M3111getLambda$358046007$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3111getLambda$358046007$material3();
                            i11 = i119;
                            long j112 = primaryContainerColor;
                            j5 = primaryContentColor;
                            j4 = j112;
                        } else {
                            long j113 = primaryContainerColor;
                            j5 = primaryContentColor;
                            j4 = j113;
                            i11 = i4;
                            modifier2 = companion;
                            function8 = composableLambdaRememberComposableLambda;
                            function2M3111getLambda$358046007$material3 = function2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(847049916, i11, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:1415)");
                    }
                    int i1110 = i11 << 3;
                    m4391ScrollableTabRowWithSubcomposeImplqhFBPw4(i, function8, modifier2, j4, j5, fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM, function2M3111getLambda$358046007$material3, function4, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), composerStartRestartGroup, (i11 & 14) | ((i11 >> 12) & 112) | (i1110 & 896) | (i1110 & 7168) | (57344 & i1110) | (i1110 & 458752) | (3670016 & i11) | (i11 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function6 = function2M3111getLambda$358046007$material3;
                    function7 = function8;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    function6 = function2;
                    j4 = primaryContainerColor;
                    j5 = j3;
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                    function7 = function5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1(i, modifier2, j4, j5, fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM, function7, function6, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function5 = function3;
            i9 = i3 & 64;
            if (i9 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i4 |= i12;
            }
            if ((i4 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1404@60994L21,1405@61058L19,1408@61241L164");
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-720441215, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda23
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i9 != 0) {
                        int i1111 = i4;
                        modifier2 = companion;
                        function8 = composableLambdaRememberComposableLambda;
                        function2M3111getLambda$358046007$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3111getLambda$358046007$material3();
                        i11 = i1111;
                        long j114 = primaryContainerColor;
                        j5 = primaryContentColor;
                        j4 = j114;
                    } else {
                        long j115 = primaryContainerColor;
                        j5 = primaryContentColor;
                        j4 = j115;
                        i11 = i4;
                        modifier2 = companion;
                        function8 = composableLambdaRememberComposableLambda;
                        function2M3111getLambda$358046007$material3 = function2;
                    }
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-720441215, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda23
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i9 != 0) {
                        int i1112 = i4;
                        modifier2 = companion;
                        function8 = composableLambdaRememberComposableLambda;
                        function2M3111getLambda$358046007$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3111getLambda$358046007$material3();
                        i11 = i1112;
                        long j116 = primaryContainerColor;
                        j5 = primaryContentColor;
                        j4 = j116;
                    } else {
                        long j117 = primaryContainerColor;
                        j5 = primaryContentColor;
                        j4 = j117;
                        i11 = i4;
                        modifier2 = companion;
                        function8 = composableLambdaRememberComposableLambda;
                        function2M3111getLambda$358046007$material3 = function2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(847049916, i11, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:1415)");
                }
                int i1113 = i11 << 3;
                m4391ScrollableTabRowWithSubcomposeImplqhFBPw4(i, function8, modifier2, j4, j5, fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM, function2M3111getLambda$358046007$material3, function4, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), composerStartRestartGroup, (i11 & 14) | ((i11 >> 12) & 112) | (i1113 & 896) | (i1113 & 7168) | (57344 & i1113) | (i1113 & 458752) | (3670016 & i11) | (i11 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = function2M3111getLambda$358046007$material3;
                function7 = function8;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                function6 = function2;
                j4 = primaryContainerColor;
                j5 = j3;
                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                function7 = function5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1(i, modifier2, j4, j5, fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM, function7, function6, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        f2 = f;
        i7 = i3 & 32;
        if (i7 != 0) {
            if ((196608 & i2) == 0) {
                function5 = function3;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i4 |= i8;
            }
            i9 = i3 & 64;
            if (i9 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i4 |= i12;
            }
            if ((i4 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1404@60994L21,1405@61058L19,1408@61241L164");
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-720441215, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda23
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i9 != 0) {
                        int i1114 = i4;
                        modifier2 = companion;
                        function8 = composableLambdaRememberComposableLambda;
                        function2M3111getLambda$358046007$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3111getLambda$358046007$material3();
                        i11 = i1114;
                        long j118 = primaryContainerColor;
                        j5 = primaryContentColor;
                        j4 = j118;
                    } else {
                        long j119 = primaryContainerColor;
                        j5 = primaryContentColor;
                        j4 = j119;
                        i11 = i4;
                        modifier2 = companion;
                        function8 = composableLambdaRememberComposableLambda;
                        function2M3111getLambda$358046007$material3 = function2;
                    }
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        primaryContentColor = j3;
                    }
                    if (i5 != 0) {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                    } else {
                        fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-720441215, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda23
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i9 != 0) {
                        int i1115 = i4;
                        modifier2 = companion;
                        function8 = composableLambdaRememberComposableLambda;
                        function2M3111getLambda$358046007$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3111getLambda$358046007$material3();
                        i11 = i1115;
                        long j1110 = primaryContainerColor;
                        j5 = primaryContentColor;
                        j4 = j1110;
                    } else {
                        long j1111 = primaryContainerColor;
                        j5 = primaryContentColor;
                        j4 = j1111;
                        i11 = i4;
                        modifier2 = companion;
                        function8 = composableLambdaRememberComposableLambda;
                        function2M3111getLambda$358046007$material3 = function2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(847049916, i11, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:1415)");
                }
                int i1116 = i11 << 3;
                m4391ScrollableTabRowWithSubcomposeImplqhFBPw4(i, function8, modifier2, j4, j5, fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM, function2M3111getLambda$358046007$material3, function4, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), composerStartRestartGroup, (i11 & 14) | ((i11 >> 12) & 112) | (i1116 & 896) | (i1116 & 7168) | (57344 & i1116) | (i1116 & 458752) | (3670016 & i11) | (i11 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = function2M3111getLambda$358046007$material3;
                function7 = function8;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                function6 = function2;
                j4 = primaryContainerColor;
                j5 = j3;
                fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                function7 = function5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1(i, modifier2, j4, j5, fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM, function7, function6, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function5 = function3;
        i9 = i3 & 64;
        if (i9 != 0) {
            i4 |= 1572864;
        } else if ((i2 & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i10 = 1048576;
            } else {
                i10 = 524288;
            }
            i4 |= i10;
        }
        if ((i2 & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i12 = 8388608;
            } else {
                i12 = 4194304;
            }
            i4 |= i12;
        }
        if ((i4 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1404@60994L21,1405@61058L19,1408@61241L164");
            if ((i2 & 1) != 0) {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i3 & 4) != 0) {
                    primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    primaryContentColor = j3;
                }
                if (i5 != 0) {
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                } else {
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                }
                if (i7 != 0) {
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-720441215, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda23
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    composableLambdaRememberComposableLambda = function5;
                }
                if (i9 != 0) {
                    int i1117 = i4;
                    modifier2 = companion;
                    function8 = composableLambdaRememberComposableLambda;
                    function2M3111getLambda$358046007$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3111getLambda$358046007$material3();
                    i11 = i1117;
                    long j1112 = primaryContainerColor;
                    j5 = primaryContentColor;
                    j4 = j1112;
                } else {
                    long j1113 = primaryContainerColor;
                    j5 = primaryContentColor;
                    j4 = j1113;
                    i11 = i4;
                    modifier2 = companion;
                    function8 = composableLambdaRememberComposableLambda;
                    function2M3111getLambda$358046007$material3 = function2;
                }
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i3 & 4) != 0) {
                    primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    primaryContentColor = j3;
                }
                if (i5 != 0) {
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                } else {
                    fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                }
                if (i7 != 0) {
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-720441215, true, new Function3() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda23
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    composableLambdaRememberComposableLambda = function5;
                }
                if (i9 != 0) {
                    int i1118 = i4;
                    modifier2 = companion;
                    function8 = composableLambdaRememberComposableLambda;
                    function2M3111getLambda$358046007$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3111getLambda$358046007$material3();
                    i11 = i1118;
                    long j1114 = primaryContainerColor;
                    j5 = primaryContentColor;
                    j4 = j1114;
                } else {
                    long j1115 = primaryContainerColor;
                    j5 = primaryContentColor;
                    j4 = j1115;
                    i11 = i4;
                    modifier2 = companion;
                    function8 = composableLambdaRememberComposableLambda;
                    function2M3111getLambda$358046007$material3 = function2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(847049916, i11, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:1415)");
            }
            int i1119 = i11 << 3;
            m4391ScrollableTabRowWithSubcomposeImplqhFBPw4(i, function8, modifier2, j4, j5, fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM, function2M3111getLambda$358046007$material3, function4, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), composerStartRestartGroup, (i11 & 14) | ((i11 >> 12) & 112) | (i1119 & 896) | (i1119 & 7168) | (57344 & i1119) | (i1119 & 458752) | (3670016 & i11) | (i11 & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function6 = function2M3111getLambda$358046007$material3;
            function7 = function8;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            function6 = function2;
            j4 = primaryContainerColor;
            j5 = j3;
            fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
            function7 = function5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1(i, modifier2, j4, j5, fM4374getScrollableTabRowEdgeStartPaddingD9Ej5fM, function7, function6, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabRowWithSubcomposeImpl_DTcfvLk$lambda$0$0$0$3(List list, SubcomposeMeasureScope subcomposeMeasureScope, Function2 function2, Ref.IntRef intRef, Constraints constraints, int i, final Function3 function3, final List list2, int i2, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list.get(i3), i3 * intRef.element, 0, 0.0f, 4, null);
        }
        List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(TabSlots.Divider, function2);
        int size2 = listSubcompose.size();
        for (int i4 = 0; i4 < size2; i4++) {
            Placeable placeableMo8265measureBRTryo0 = listSubcompose.get(i4).mo8265measureBRTryo0(Constraints.m9630copyZbe2FdA$default(constraints.getValue(), 0, 0, 0, 0, 11, null));
            Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo8265measureBRTryo0, 0, i - placeableMo8265measureBRTryo0.getHeight(), 0.0f, 4, null);
        }
        List<Measurable> listSubcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Indicator, ComposableLambdaKt.composableLambdaInstance(1918742627, true, new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return TabRowKt.TabRowWithSubcomposeImpl_DTcfvLk$lambda$0$0$0$3$2(function3, list2, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        int size3 = listSubcompose2.size();
        for (int i5 = 0; i5 < size3; i5++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, listSubcompose2.get(i5).mo8265measureBRTryo0(Constraints.INSTANCE.m9650fixedJhjzzOo(i2, i)), 0, 0, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
