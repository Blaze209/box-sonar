package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.OutlinedSegmentedButtonTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SegmentedButton.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u009b\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0013\b\u0002\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0018\u001a\u0095\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0013\b\u0002\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001c\u001a\u0091\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0013\b\u0002\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001d\u001a\u008b\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0013\b\u0002\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001e\u001aA\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020!2\u001c\u0010\"\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0016¢\u0006\u0002\b#H\u0007¢\u0006\u0004\b$\u0010%\u001aA\u0010&\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020!2\u001c\u0010\"\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0016¢\u0006\u0002\b#H\u0007¢\u0006\u0004\b'\u0010%\u001a;\u0010(\u001a\u00020\u00012\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\"\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0006\u0010\u0010\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010)\u001a\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+*\u00020-H\u0003¢\u0006\u0002\u0010.\u001a\"\u0010/\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00042\f\u00100\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002\"\u000e\u00101\u001a\u000202X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00103\u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u00104¨\u00065"}, d2 = {"SegmentedButton", "", "Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "shape", "Landroidx/compose/ui/graphics/Shape;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/SegmentedButtonColors;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", HubsObservability.HUB_ASSET_ICON, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "label", "(Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;", "selected", ViewProps.ON_CLICK, "(Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "SingleChoiceSegmentedButtonRow", "space", "Landroidx/compose/ui/unit/Dp;", "content", "Lkotlin/ExtensionFunctionType;", "SingleChoiceSegmentedButtonRow-uFdPcIQ", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "MultiChoiceSegmentedButtonRow", "MultiChoiceSegmentedButtonRow-uFdPcIQ", "SegmentedButtonContent", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "interactionCountAsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "interactionZIndex", "interactionCount", "CheckedZIndexFactor", "", "IconSpacing", "F", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SegmentedButtonKt {
    private static final float CheckedZIndexFactor = 5.0f;
    private static final float IconSpacing = Dp.m9687constructorimpl(8);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiChoiceSegmentedButtonRow_uFdPcIQ$lambda$1(Modifier modifier, float f, Function3 function3, int i, int i2, Composer composer, int i3) {
        m4143MultiChoiceSegmentedButtonRowuFdPcIQ(modifier, f, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SegmentedButton$lambda$10(MultiChoiceSegmentedButtonRowScope multiChoiceSegmentedButtonRowScope, boolean z, Function1 function1, Shape shape, Modifier modifier, boolean z2, SegmentedButtonColors segmentedButtonColors, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function2 function2, Function2 function3, int i, int i2, int i3, Composer composer, int i4) {
        SegmentedButton(multiChoiceSegmentedButtonRowScope, z, function1, shape, modifier, z2, segmentedButtonColors, borderStroke, mutableInteractionSource, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SegmentedButton$lambda$12(SingleChoiceSegmentedButtonRowScope singleChoiceSegmentedButtonRowScope, boolean z, Function0 function0, Shape shape, Modifier modifier, boolean z2, SegmentedButtonColors segmentedButtonColors, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function2 function2, Function2 function3, int i, int i2, int i3, Composer composer, int i4) {
        SegmentedButton(singleChoiceSegmentedButtonRowScope, z, function0, shape, modifier, z2, segmentedButtonColors, borderStroke, mutableInteractionSource, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SegmentedButton$lambda$3(MultiChoiceSegmentedButtonRowScope multiChoiceSegmentedButtonRowScope, boolean z, Function1 function1, Shape shape, Modifier modifier, boolean z2, SegmentedButtonColors segmentedButtonColors, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function2 function2, Function2 function3, int i, int i2, int i3, Composer composer, int i4) {
        SegmentedButton(multiChoiceSegmentedButtonRowScope, z, (Function1<? super Boolean, Unit>) function1, shape, modifier, z2, segmentedButtonColors, borderStroke, paddingValues, mutableInteractionSource, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SegmentedButton$lambda$8(SingleChoiceSegmentedButtonRowScope singleChoiceSegmentedButtonRowScope, boolean z, Function0 function0, Shape shape, Modifier modifier, boolean z2, SegmentedButtonColors segmentedButtonColors, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function2 function2, Function2 function3, int i, int i2, int i3, Composer composer, int i4) {
        SegmentedButton(singleChoiceSegmentedButtonRowScope, z, (Function0<Unit>) function0, shape, modifier, z2, segmentedButtonColors, borderStroke, paddingValues, mutableInteractionSource, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SegmentedButtonContent$lambda$1(Function2 function2, Function2 function3, PaddingValues paddingValues, int i, Composer composer, int i2) {
        SegmentedButtonContent(function2, function3, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SingleChoiceSegmentedButtonRow_uFdPcIQ$lambda$1(Modifier modifier, float f, Function3 function3, int i, int i2, Composer composer, int i3) {
        m4144SingleChoiceSegmentedButtonRowuFdPcIQ(modifier, f, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SegmentedButton$lambda$0(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C140@7105L13:SegmentedButton.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1181873313, i, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:140)");
            }
            SegmentedButtonDefaults.INSTANCE.Icon(z, null, null, composer, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0125  */
    /* JADX WARN: Code duplicated, block: B:102:0x012f  */
    /* JADX WARN: Code duplicated, block: B:103:0x0132  */
    /* JADX WARN: Code duplicated, block: B:105:0x0137  */
    /* JADX WARN: Code duplicated, block: B:108:0x0141  */
    /* JADX WARN: Code duplicated, block: B:110:0x0147  */
    /* JADX WARN: Code duplicated, block: B:111:0x014a  */
    /* JADX WARN: Code duplicated, block: B:115:0x015b  */
    /* JADX WARN: Code duplicated, block: B:119:0x0164  */
    /* JADX WARN: Code duplicated, block: B:122:0x016d  */
    /* JADX WARN: Code duplicated, block: B:124:0x0180  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:136:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:137:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:139:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:145:0x01be  */
    /* JADX WARN: Code duplicated, block: B:147:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:148:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:150:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:151:0x01df  */
    /* JADX WARN: Code duplicated, block: B:153:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:154:0x0201  */
    /* JADX WARN: Code duplicated, block: B:157:0x0216  */
    /* JADX WARN: Code duplicated, block: B:159:0x0220  */
    /* JADX WARN: Code duplicated, block: B:161:0x023f  */
    /* JADX WARN: Code duplicated, block: B:163:0x0250  */
    /* JADX WARN: Code duplicated, block: B:166:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:168:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:171:0x030c  */
    /* JADX WARN: Code duplicated, block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0085  */
    /* JADX WARN: Code duplicated, block: B:47:0x008a  */
    /* JADX WARN: Code duplicated, block: B:49:0x0090  */
    /* JADX WARN: Code duplicated, block: B:51:0x0096  */
    /* JADX WARN: Code duplicated, block: B:52:0x0099  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:76:0x00db  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:89:0x0100  */
    /* JADX WARN: Code duplicated, block: B:91:0x010a  */
    /* JADX WARN: Code duplicated, block: B:92:0x010d  */
    /* JADX WARN: Code duplicated, block: B:97:0x011a  */
    /* JADX WARN: Code duplicated, block: B:98:0x0121  */
    public static final void SegmentedButton(final MultiChoiceSegmentedButtonRowScope multiChoiceSegmentedButtonRowScope, final boolean z, final Function1<? super Boolean, Unit> function1, final Shape shape, Modifier modifier, boolean z2, SegmentedButtonColors segmentedButtonColors, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        SegmentedButtonColors segmentedButtonColorsColors;
        BorderStroke borderStrokeM4137borderStrokel07J4OM$default;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z4;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z5;
        final SegmentedButtonColors segmentedButtonColors2;
        final BorderStroke borderStroke2;
        final Modifier modifier3;
        final PaddingValues paddingValues2;
        final Function2<? super Composer, ? super Integer, Unit> function4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        PaddingValues contentPadding;
        MutableInteractionSource mutableInteractionSource3;
        SegmentedButtonColors segmentedButtonColors3;
        BorderStroke borderStroke3;
        final PaddingValues paddingValues3;
        MutableInteractionSource mutableInteractionSource4;
        int i15;
        final Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        MutableInteractionSource mutableInteractionSource5;
        Object objRememberedValue;
        int i16;
        int i17;
        int i18;
        Composer composerStartRestartGroup = composer.startRestartGroup(697872538);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SegmentedButton)N(checked,onCheckedChange,shape,modifier,enabled,colors,border,contentPadding,interactionSource,icon,label)147@7453L25,166@8056L101,149@7484L673:SegmentedButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(multiChoiceSegmentedButtonRowScope) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(shape) ? 2048 : 1024;
        }
        int i19 = i3 & 8;
        if (i19 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z3 = z2;
            } else {
                z3 = z2;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                    i4 |= i6;
                }
            }
            if ((i & 1572864) == 0) {
                segmentedButtonColorsColors = segmentedButtonColors;
                if ((i3 & 32) == 0 || !composerStartRestartGroup.changed(segmentedButtonColorsColors)) {
                    i18 = 524288;
                } else {
                    i18 = 1048576;
                }
                i4 |= i18;
            } else {
                segmentedButtonColorsColors = segmentedButtonColors;
            }
            if ((i & 12582912) == 0) {
                borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
                if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(borderStrokeM4137borderStrokel07J4OM$default)) {
                    i17 = 4194304;
                } else {
                    i17 = 8388608;
                }
                i4 |= i17;
            } else {
                borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
            }
            i7 = i3 & 128;
            if (i7 != 0) {
                i4 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i8 = 67108864;
                } else {
                    i8 = 33554432;
                }
                i4 |= i8;
            }
            i9 = i3 & 256;
            if (i9 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i10 = 268435456;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 512;
                if (i11 != 0) {
                    i12 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i13 = 4;
                    } else {
                        i13 = 2;
                    }
                    i12 = i2 | i13;
                } else {
                    i12 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i16 = 32;
                    } else {
                        i16 = 16;
                    }
                    i12 |= i16;
                }
                i14 = i12;
                if ((i4 & 306783379) == 306783378 || (i14 & 19) != 18) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "135@6790L8,140@7079L41");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i19 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 32) != 0) {
                            segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        }
                        if ((i3 & 64) != 0) {
                            borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                            i4 &= -29360129;
                        }
                        if (i7 != 0) {
                            contentPadding = SegmentedButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if (i11 != 0) {
                            modifier2 = companion;
                            segmentedButtonColors3 = segmentedButtonColorsColors;
                            borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            i15 = i4;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1181873313, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SegmentedButtonKt.SegmentedButton$lambda$0(z, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            paddingValues3 = contentPadding;
                        } else {
                            modifier2 = companion;
                            segmentedButtonColors3 = segmentedButtonColorsColors;
                            borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                            paddingValues3 = contentPadding;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(697872538, i15, i14, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:142)");
                        }
                        if (mutableInteractionSource4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1615192863);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "144@7242L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 640633665, "CC(remember):SegmentedButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(640633014);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource5 = mutableInteractionSource4;
                        }
                        int i20 = i15;
                        Modifier modifier4 = modifier2;
                        int i21 = ((i20 >> 3) & 126) | ((i20 >> 6) & 7168) | (57344 & (i20 << 3)) | (1879048192 & (i20 << 6));
                        Function2<? super Composer, ? super Integer, Unit> function5 = function2RememberComposableLambda;
                        boolean z6 = z3;
                        SegmentedButtonColors segmentedButtonColors4 = segmentedButtonColors3;
                        PaddingValues paddingValues4 = paddingValues3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m4325Surfaced85dljk(z, function1, SizeKt.m1250defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(multiChoiceSegmentedButtonRowScope, modifier4, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource5, composerStartRestartGroup, 0)), ButtonDefaults.INSTANCE.m2872getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m2871getMinHeightD9Ej5fM()), z6, shape, segmentedButtonColors3.m4120containerColorWaAFU9c$material3(z3, z), segmentedButtonColors3.m4121contentColorWaAFU9c$material3(z3, z), 0.0f, 0.0f, borderStroke3, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(1717860164, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$2(function2RememberComposableLambda, function3, paddingValues3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, i21, 48, 384);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        segmentedButtonColors2 = segmentedButtonColors4;
                        paddingValues2 = paddingValues4;
                        z5 = z6;
                        borderStroke2 = borderStroke3;
                        modifier3 = modifier4;
                        mutableInteractionSource2 = mutableInteractionSource4;
                        function4 = function5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 32) != 0) {
                            i4 &= -3670017;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -29360129;
                        }
                        mutableInteractionSource4 = mutableInteractionSource;
                        segmentedButtonColors3 = segmentedButtonColorsColors;
                        borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                        paddingValues3 = paddingValues;
                    }
                    i15 = i4;
                    function2RememberComposableLambda = function2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(697872538, i15, i14, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:142)");
                    }
                    if (mutableInteractionSource4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1615192863);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "144@7242L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 640633665, "CC(remember):SegmentedButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(640633014);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource5 = mutableInteractionSource4;
                    }
                    int i22 = i15;
                    Modifier modifier5 = modifier2;
                    int i23 = ((i22 >> 3) & 126) | ((i22 >> 6) & 7168) | (57344 & (i22 << 3)) | (1879048192 & (i22 << 6));
                    Function2<? super Composer, ? super Integer, Unit> function6 = function2RememberComposableLambda;
                    boolean z7 = z3;
                    SegmentedButtonColors segmentedButtonColors5 = segmentedButtonColors3;
                    PaddingValues paddingValues5 = paddingValues3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4325Surfaced85dljk(z, function1, SizeKt.m1250defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(multiChoiceSegmentedButtonRowScope, modifier5, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource5, composerStartRestartGroup, 0)), ButtonDefaults.INSTANCE.m2872getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m2871getMinHeightD9Ej5fM()), z7, shape, segmentedButtonColors3.m4120containerColorWaAFU9c$material3(z3, z), segmentedButtonColors3.m4121contentColorWaAFU9c$material3(z3, z), 0.0f, 0.0f, borderStroke3, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(1717860164, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SegmentedButtonKt.SegmentedButton$lambda$2(function2RememberComposableLambda, function3, paddingValues3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, i23, 48, 384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    segmentedButtonColors2 = segmentedButtonColors5;
                    paddingValues2 = paddingValues5;
                    z5 = z7;
                    borderStroke2 = borderStroke3;
                    modifier3 = modifier5;
                    mutableInteractionSource2 = mutableInteractionSource4;
                    function4 = function6;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    z5 = z3;
                    segmentedButtonColors2 = segmentedButtonColorsColors;
                    borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
                    modifier3 = modifier2;
                    paddingValues2 = paddingValues;
                    function4 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SegmentedButtonKt.SegmentedButton$lambda$3(multiChoiceSegmentedButtonRowScope, z, function1, shape, modifier3, z5, segmentedButtonColors2, borderStroke2, paddingValues2, mutableInteractionSource2, function4, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            i11 = i3 & 512;
            if (i11 != 0) {
                i12 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i13 = 4;
                } else {
                    i13 = 2;
                }
                i12 = i2 | i13;
            } else {
                i12 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i16 = 32;
                } else {
                    i16 = 16;
                }
                i12 |= i16;
            }
            i14 = i12;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "135@6790L8,140@7079L41");
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if ((i3 & 64) != 0) {
                        borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                        i4 &= -29360129;
                    }
                    if (i7 != 0) {
                        contentPadding = SegmentedButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (i11 != 0) {
                        modifier2 = companion;
                        segmentedButtonColors3 = segmentedButtonColorsColors;
                        borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        i15 = i4;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1181873313, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$0(z, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        paddingValues3 = contentPadding;
                    } else {
                        modifier2 = companion;
                        segmentedButtonColors3 = segmentedButtonColorsColors;
                        borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                        paddingValues3 = contentPadding;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        i15 = i4;
                        function2RememberComposableLambda = function2;
                    }
                } else {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if ((i3 & 64) != 0) {
                        borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                        i4 &= -29360129;
                    }
                    if (i7 != 0) {
                        contentPadding = SegmentedButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (i11 != 0) {
                        modifier2 = companion;
                        segmentedButtonColors3 = segmentedButtonColorsColors;
                        borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        i15 = i4;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1181873313, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$0(z, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        paddingValues3 = contentPadding;
                    } else {
                        modifier2 = companion;
                        segmentedButtonColors3 = segmentedButtonColorsColors;
                        borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                        paddingValues3 = contentPadding;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        i15 = i4;
                        function2RememberComposableLambda = function2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(697872538, i15, i14, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:142)");
                }
                if (mutableInteractionSource4 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1615192863);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "144@7242L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 640633665, "CC(remember):SegmentedButton.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue;
                } else {
                    composerStartRestartGroup.startReplaceGroup(640633014);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource5 = mutableInteractionSource4;
                }
                int i24 = i15;
                Modifier modifier6 = modifier2;
                int i25 = ((i24 >> 3) & 126) | ((i24 >> 6) & 7168) | (57344 & (i24 << 3)) | (1879048192 & (i24 << 6));
                Function2<? super Composer, ? super Integer, Unit> function7 = function2RememberComposableLambda;
                boolean z8 = z3;
                SegmentedButtonColors segmentedButtonColors6 = segmentedButtonColors3;
                PaddingValues paddingValues6 = paddingValues3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4325Surfaced85dljk(z, function1, SizeKt.m1250defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(multiChoiceSegmentedButtonRowScope, modifier6, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource5, composerStartRestartGroup, 0)), ButtonDefaults.INSTANCE.m2872getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m2871getMinHeightD9Ej5fM()), z8, shape, segmentedButtonColors3.m4120containerColorWaAFU9c$material3(z3, z), segmentedButtonColors3.m4121contentColorWaAFU9c$material3(z3, z), 0.0f, 0.0f, borderStroke3, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(1717860164, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SegmentedButtonKt.SegmentedButton$lambda$2(function2RememberComposableLambda, function3, paddingValues3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, i25, 48, 384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                segmentedButtonColors2 = segmentedButtonColors6;
                paddingValues2 = paddingValues6;
                z5 = z8;
                borderStroke2 = borderStroke3;
                modifier3 = modifier6;
                mutableInteractionSource2 = mutableInteractionSource4;
                function4 = function7;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                z5 = z3;
                segmentedButtonColors2 = segmentedButtonColorsColors;
                borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
                modifier3 = modifier2;
                paddingValues2 = paddingValues;
                function4 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SegmentedButtonKt.SegmentedButton$lambda$3(multiChoiceSegmentedButtonRowScope, z, function1, shape, modifier3, z5, segmentedButtonColors2, borderStroke2, paddingValues2, mutableInteractionSource2, function4, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        modifier2 = modifier;
        i5 = i3 & 16;
        if (i5 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z3 = z2;
        } else {
            z3 = z2;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
        }
        if ((i & 1572864) == 0) {
            segmentedButtonColorsColors = segmentedButtonColors;
            if ((i3 & 32) == 0) {
                i18 = 524288;
            } else {
                i18 = 524288;
            }
            i4 |= i18;
        } else {
            segmentedButtonColorsColors = segmentedButtonColors;
        }
        if ((i & 12582912) == 0) {
            borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
            if ((i3 & 64) == 0) {
                i17 = 4194304;
            } else {
                i17 = 4194304;
            }
            i4 |= i17;
        } else {
            borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
        }
        i7 = i3 & 128;
        if (i7 != 0) {
            i4 |= 100663296;
        } else if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changed(paddingValues)) {
                i8 = 67108864;
            } else {
                i8 = 33554432;
            }
            i4 |= i8;
        }
        i9 = i3 & 256;
        if (i9 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i10 = 268435456;
                }
                i4 |= i10;
            }
            i11 = i3 & 512;
            if (i11 != 0) {
                i12 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i13 = 4;
                } else {
                    i13 = 2;
                }
                i12 = i2 | i13;
            } else {
                i12 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i16 = 32;
                } else {
                    i16 = 16;
                }
                i12 |= i16;
            }
            i14 = i12;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "135@6790L8,140@7079L41");
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if ((i3 & 64) != 0) {
                        borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                        i4 &= -29360129;
                    }
                    if (i7 != 0) {
                        contentPadding = SegmentedButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (i11 != 0) {
                        modifier2 = companion;
                        segmentedButtonColors3 = segmentedButtonColorsColors;
                        borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        i15 = i4;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1181873313, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$0(z, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        paddingValues3 = contentPadding;
                    } else {
                        modifier2 = companion;
                        segmentedButtonColors3 = segmentedButtonColorsColors;
                        borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                        paddingValues3 = contentPadding;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        i15 = i4;
                        function2RememberComposableLambda = function2;
                    }
                } else {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if ((i3 & 64) != 0) {
                        borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                        i4 &= -29360129;
                    }
                    if (i7 != 0) {
                        contentPadding = SegmentedButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (i11 != 0) {
                        modifier2 = companion;
                        segmentedButtonColors3 = segmentedButtonColorsColors;
                        borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        i15 = i4;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1181873313, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$0(z, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        paddingValues3 = contentPadding;
                    } else {
                        modifier2 = companion;
                        segmentedButtonColors3 = segmentedButtonColorsColors;
                        borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                        paddingValues3 = contentPadding;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        i15 = i4;
                        function2RememberComposableLambda = function2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(697872538, i15, i14, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:142)");
                }
                if (mutableInteractionSource4 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1615192863);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "144@7242L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 640633665, "CC(remember):SegmentedButton.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue;
                } else {
                    composerStartRestartGroup.startReplaceGroup(640633014);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource5 = mutableInteractionSource4;
                }
                int i26 = i15;
                Modifier modifier7 = modifier2;
                int i27 = ((i26 >> 3) & 126) | ((i26 >> 6) & 7168) | (57344 & (i26 << 3)) | (1879048192 & (i26 << 6));
                Function2<? super Composer, ? super Integer, Unit> function8 = function2RememberComposableLambda;
                boolean z9 = z3;
                SegmentedButtonColors segmentedButtonColors7 = segmentedButtonColors3;
                PaddingValues paddingValues7 = paddingValues3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4325Surfaced85dljk(z, function1, SizeKt.m1250defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(multiChoiceSegmentedButtonRowScope, modifier7, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource5, composerStartRestartGroup, 0)), ButtonDefaults.INSTANCE.m2872getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m2871getMinHeightD9Ej5fM()), z9, shape, segmentedButtonColors3.m4120containerColorWaAFU9c$material3(z3, z), segmentedButtonColors3.m4121contentColorWaAFU9c$material3(z3, z), 0.0f, 0.0f, borderStroke3, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(1717860164, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SegmentedButtonKt.SegmentedButton$lambda$2(function2RememberComposableLambda, function3, paddingValues3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, i27, 48, 384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                segmentedButtonColors2 = segmentedButtonColors7;
                paddingValues2 = paddingValues7;
                z5 = z9;
                borderStroke2 = borderStroke3;
                modifier3 = modifier7;
                mutableInteractionSource2 = mutableInteractionSource4;
                function4 = function8;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                z5 = z3;
                segmentedButtonColors2 = segmentedButtonColorsColors;
                borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
                modifier3 = modifier2;
                paddingValues2 = paddingValues;
                function4 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SegmentedButtonKt.SegmentedButton$lambda$3(multiChoiceSegmentedButtonRowScope, z, function1, shape, modifier3, z5, segmentedButtonColors2, borderStroke2, paddingValues2, mutableInteractionSource2, function4, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 805306368;
        i11 = i3 & 512;
        if (i11 != 0) {
            i12 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i2 | i13;
        } else {
            i12 = i2;
        }
        if ((i2 & 48) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i16 = 32;
            } else {
                i16 = 16;
            }
            i12 |= i16;
        }
        i14 = i12;
        if ((i4 & 306783379) == 306783378) {
            z4 = true;
        } else {
            z4 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "135@6790L8,140@7079L41");
            if ((i & 1) != 0) {
                if (i19 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if ((i3 & 32) != 0) {
                    segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i4 &= -3670017;
                }
                if ((i3 & 64) != 0) {
                    borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                    i4 &= -29360129;
                }
                if (i7 != 0) {
                    contentPadding = SegmentedButtonDefaults.INSTANCE.getContentPadding();
                } else {
                    contentPadding = paddingValues;
                }
                if (i9 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if (i11 != 0) {
                    modifier2 = companion;
                    segmentedButtonColors3 = segmentedButtonColorsColors;
                    borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    i15 = i4;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1181873313, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SegmentedButtonKt.SegmentedButton$lambda$0(z, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    paddingValues3 = contentPadding;
                } else {
                    modifier2 = companion;
                    segmentedButtonColors3 = segmentedButtonColorsColors;
                    borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                    paddingValues3 = contentPadding;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    i15 = i4;
                    function2RememberComposableLambda = function2;
                }
            } else {
                if (i19 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if ((i3 & 32) != 0) {
                    segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i4 &= -3670017;
                }
                if ((i3 & 64) != 0) {
                    borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                    i4 &= -29360129;
                }
                if (i7 != 0) {
                    contentPadding = SegmentedButtonDefaults.INSTANCE.getContentPadding();
                } else {
                    contentPadding = paddingValues;
                }
                if (i9 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if (i11 != 0) {
                    modifier2 = companion;
                    segmentedButtonColors3 = segmentedButtonColorsColors;
                    borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    i15 = i4;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1181873313, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SegmentedButtonKt.SegmentedButton$lambda$0(z, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    paddingValues3 = contentPadding;
                } else {
                    modifier2 = companion;
                    segmentedButtonColors3 = segmentedButtonColorsColors;
                    borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                    paddingValues3 = contentPadding;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    i15 = i4;
                    function2RememberComposableLambda = function2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(697872538, i15, i14, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:142)");
            }
            if (mutableInteractionSource4 == null) {
                composerStartRestartGroup.startReplaceGroup(-1615192863);
                ComposerKt.sourceInformation(composerStartRestartGroup, "144@7242L39");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 640633665, "CC(remember):SegmentedButton.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue;
            } else {
                composerStartRestartGroup.startReplaceGroup(640633014);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource5 = mutableInteractionSource4;
            }
            int i28 = i15;
            Modifier modifier8 = modifier2;
            int i29 = ((i28 >> 3) & 126) | ((i28 >> 6) & 7168) | (57344 & (i28 << 3)) | (1879048192 & (i28 << 6));
            Function2<? super Composer, ? super Integer, Unit> function9 = function2RememberComposableLambda;
            boolean z10 = z3;
            SegmentedButtonColors segmentedButtonColors8 = segmentedButtonColors3;
            PaddingValues paddingValues8 = paddingValues3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4325Surfaced85dljk(z, function1, SizeKt.m1250defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(multiChoiceSegmentedButtonRowScope, modifier8, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource5, composerStartRestartGroup, 0)), ButtonDefaults.INSTANCE.m2872getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m2871getMinHeightD9Ej5fM()), z10, shape, segmentedButtonColors3.m4120containerColorWaAFU9c$material3(z3, z), segmentedButtonColors3.m4121contentColorWaAFU9c$material3(z3, z), 0.0f, 0.0f, borderStroke3, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(1717860164, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SegmentedButtonKt.SegmentedButton$lambda$2(function2RememberComposableLambda, function3, paddingValues3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, i29, 48, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            segmentedButtonColors2 = segmentedButtonColors8;
            paddingValues2 = paddingValues8;
            z5 = z10;
            borderStroke2 = borderStroke3;
            modifier3 = modifier8;
            mutableInteractionSource2 = mutableInteractionSource4;
            function4 = function9;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            mutableInteractionSource2 = mutableInteractionSource;
            z5 = z3;
            segmentedButtonColors2 = segmentedButtonColorsColors;
            borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
            modifier3 = modifier2;
            paddingValues2 = paddingValues;
            function4 = function2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SegmentedButtonKt.SegmentedButton$lambda$3(multiChoiceSegmentedButtonRowScope, z, function1, shape, modifier3, z5, segmentedButtonColors2, borderStroke2, paddingValues2, mutableInteractionSource2, function4, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SegmentedButton$lambda$2(Function2 function2, Function2 function3, PaddingValues paddingValues, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C167@8066L85:SegmentedButton.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1717860164, i, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:167)");
            }
            SegmentedButtonContent(function2, function3, paddingValues, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SegmentedButton$lambda$4(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C220@10863L14:SegmentedButton.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-643804033, i, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:220)");
            }
            SegmentedButtonDefaults.INSTANCE.Icon(z, null, null, composer, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0125  */
    /* JADX WARN: Code duplicated, block: B:102:0x012f  */
    /* JADX WARN: Code duplicated, block: B:103:0x0132  */
    /* JADX WARN: Code duplicated, block: B:105:0x0137  */
    /* JADX WARN: Code duplicated, block: B:108:0x0141  */
    /* JADX WARN: Code duplicated, block: B:110:0x0147  */
    /* JADX WARN: Code duplicated, block: B:111:0x014a  */
    /* JADX WARN: Code duplicated, block: B:115:0x015b  */
    /* JADX WARN: Code duplicated, block: B:119:0x0164  */
    /* JADX WARN: Code duplicated, block: B:122:0x016d  */
    /* JADX WARN: Code duplicated, block: B:124:0x0180  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:136:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:137:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:139:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:145:0x01be  */
    /* JADX WARN: Code duplicated, block: B:147:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:148:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:150:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:151:0x01df  */
    /* JADX WARN: Code duplicated, block: B:153:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:154:0x0203  */
    /* JADX WARN: Code duplicated, block: B:157:0x0218  */
    /* JADX WARN: Code duplicated, block: B:160:0x0224  */
    /* JADX WARN: Code duplicated, block: B:162:0x0241  */
    /* JADX WARN: Code duplicated, block: B:164:0x0252  */
    /* JADX WARN: Code duplicated, block: B:167:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:170:0x030f  */
    /* JADX WARN: Code duplicated, block: B:172:0x031e  */
    /* JADX WARN: Code duplicated, block: B:175:0x0333  */
    /* JADX WARN: Code duplicated, block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0085  */
    /* JADX WARN: Code duplicated, block: B:47:0x008a  */
    /* JADX WARN: Code duplicated, block: B:49:0x0090  */
    /* JADX WARN: Code duplicated, block: B:51:0x0096  */
    /* JADX WARN: Code duplicated, block: B:52:0x0099  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:76:0x00db  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:89:0x0100  */
    /* JADX WARN: Code duplicated, block: B:91:0x010a  */
    /* JADX WARN: Code duplicated, block: B:92:0x010d  */
    /* JADX WARN: Code duplicated, block: B:97:0x011a  */
    /* JADX WARN: Code duplicated, block: B:98:0x0121  */
    public static final void SegmentedButton(final SingleChoiceSegmentedButtonRowScope singleChoiceSegmentedButtonRowScope, final boolean z, final Function0<Unit> function0, final Shape shape, Modifier modifier, boolean z2, SegmentedButtonColors segmentedButtonColors, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        SegmentedButtonColors segmentedButtonColorsColors;
        BorderStroke borderStrokeM4137borderStrokel07J4OM$default;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z4;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z5;
        final SegmentedButtonColors segmentedButtonColors2;
        final BorderStroke borderStroke2;
        final Modifier modifier3;
        final PaddingValues paddingValues2;
        final Function2<? super Composer, ? super Integer, Unit> function4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        PaddingValues contentPadding;
        MutableInteractionSource mutableInteractionSource3;
        SegmentedButtonColors segmentedButtonColors3;
        BorderStroke borderStroke3;
        final PaddingValues paddingValues3;
        MutableInteractionSource mutableInteractionSource4;
        final Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        int i15;
        MutableInteractionSource mutableInteractionSource5;
        Object objRememberedValue;
        Object objRememberedValue2;
        int i16;
        int i17;
        int i18;
        Composer composerStartRestartGroup = composer.startRestartGroup(1532041126);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SegmentedButton)N(selected,onClick,shape,modifier,enabled,colors,border,contentPadding,interactionSource,icon,label)227@11214L25,238@11577L27,247@11859L67,229@11245L681:SegmentedButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(singleChoiceSegmentedButtonRowScope) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(shape) ? 2048 : 1024;
        }
        int i19 = i3 & 8;
        if (i19 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z3 = z2;
            } else {
                z3 = z2;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                    i4 |= i6;
                }
            }
            if ((i & 1572864) == 0) {
                segmentedButtonColorsColors = segmentedButtonColors;
                if ((i3 & 32) == 0 || !composerStartRestartGroup.changed(segmentedButtonColorsColors)) {
                    i18 = 524288;
                } else {
                    i18 = 1048576;
                }
                i4 |= i18;
            } else {
                segmentedButtonColorsColors = segmentedButtonColors;
            }
            if ((i & 12582912) == 0) {
                borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
                if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(borderStrokeM4137borderStrokel07J4OM$default)) {
                    i17 = 4194304;
                } else {
                    i17 = 8388608;
                }
                i4 |= i17;
            } else {
                borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
            }
            i7 = i3 & 128;
            if (i7 != 0) {
                i4 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i8 = 67108864;
                } else {
                    i8 = 33554432;
                }
                i4 |= i8;
            }
            i9 = i3 & 256;
            if (i9 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i10 = 268435456;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 512;
                if (i11 != 0) {
                    i12 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i13 = 4;
                    } else {
                        i13 = 2;
                    }
                    i12 = i2 | i13;
                } else {
                    i12 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i16 = 32;
                    } else {
                        i16 = 16;
                    }
                    i12 |= i16;
                }
                i14 = i12;
                if ((i4 & 306783379) == 306783378 || (i14 & 19) != 18) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "215@10547L8,220@10837L42");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i19 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 32) != 0) {
                            segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        }
                        if ((i3 & 64) != 0) {
                            borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                            i4 &= -29360129;
                        }
                        if (i7 != 0) {
                            contentPadding = SegmentedButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if (i11 != 0) {
                            Modifier modifier4 = companion;
                            int i20 = i4;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-643804033, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SegmentedButtonKt.SegmentedButton$lambda$4(z, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            segmentedButtonColors3 = segmentedButtonColorsColors;
                            i15 = i20;
                            modifier2 = modifier4;
                            borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                            paddingValues3 = contentPadding;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        } else {
                            modifier2 = companion;
                            segmentedButtonColors3 = segmentedButtonColorsColors;
                            borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                            paddingValues3 = contentPadding;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1532041126, i15, i14, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:222)");
                        }
                        if (mutableInteractionSource4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1579573323);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "224@11001L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -882237971, "CC(remember):SegmentedButton.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-882238622);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource5 = mutableInteractionSource4;
                        }
                        long jM4120containerColorWaAFU9c$material3 = segmentedButtonColors3.m4120containerColorWaAFU9c$material3(z3, z);
                        int i21 = i15;
                        long jM4121contentColorWaAFU9c$material3 = segmentedButtonColors3.m4121contentColorWaAFU9c$material3(z3, z);
                        SegmentedButtonColors segmentedButtonColors4 = segmentedButtonColors3;
                        Modifier modifier5 = modifier2;
                        Modifier modifierM1250defaultMinSizeVpY3zN4 = SizeKt.m1250defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(singleChoiceSegmentedButtonRowScope, modifier5, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource5, composerStartRestartGroup, 0)), ButtonDefaults.INSTANCE.m2872getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m2871getMinHeightD9Ej5fM());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -882219551, "CC(remember):SegmentedButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SegmentedButtonKt.SegmentedButton$lambda$6$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Function2<? super Composer, ? super Integer, Unit> function5 = function2RememberComposableLambda;
                        boolean z6 = z3;
                        PaddingValues paddingValues4 = paddingValues3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m4324Surfaced85dljk(z, function0, SemanticsModifierKt.semantics$default(modifierM1250defaultMinSizeVpY3zN4, false, (Function1) objRememberedValue, 1, null), z6, shape, jM4120containerColorWaAFU9c$material3, jM4121contentColorWaAFU9c$material3, 0.0f, 0.0f, borderStroke3, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-1208080836, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$7(function2RememberComposableLambda, function3, paddingValues3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, ((i21 >> 3) & 126) | ((i21 >> 6) & 7168) | (57344 & (i21 << 3)) | (1879048192 & (i21 << 6)), 48, 384);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function4 = function5;
                        z5 = z6;
                        borderStroke2 = borderStroke3;
                        segmentedButtonColors2 = segmentedButtonColors4;
                        mutableInteractionSource2 = mutableInteractionSource4;
                        modifier3 = modifier5;
                        paddingValues2 = paddingValues4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 32) != 0) {
                            i4 &= -3670017;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -29360129;
                        }
                        mutableInteractionSource4 = mutableInteractionSource;
                        segmentedButtonColors3 = segmentedButtonColorsColors;
                        borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                        paddingValues3 = paddingValues;
                    }
                    i15 = i4;
                    function2RememberComposableLambda = function2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1532041126, i15, i14, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:222)");
                    }
                    if (mutableInteractionSource4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1579573323);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "224@11001L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -882237971, "CC(remember):SegmentedButton.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-882238622);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource5 = mutableInteractionSource4;
                    }
                    long jM4120containerColorWaAFU9c$material4 = segmentedButtonColors3.m4120containerColorWaAFU9c$material3(z3, z);
                    int i22 = i15;
                    long jM4121contentColorWaAFU9c$material4 = segmentedButtonColors3.m4121contentColorWaAFU9c$material3(z3, z);
                    SegmentedButtonColors segmentedButtonColors5 = segmentedButtonColors3;
                    Modifier modifier6 = modifier2;
                    Modifier modifierM1250defaultMinSizeVpY3zN5 = SizeKt.m1250defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(singleChoiceSegmentedButtonRowScope, modifier6, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource5, composerStartRestartGroup, 0)), ButtonDefaults.INSTANCE.m2872getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m2871getMinHeightD9Ej5fM());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -882219551, "CC(remember):SegmentedButton.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SegmentedButtonKt.SegmentedButton$lambda$6$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function2<? super Composer, ? super Integer, Unit> function6 = function2RememberComposableLambda;
                    boolean z7 = z3;
                    PaddingValues paddingValues5 = paddingValues3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4324Surfaced85dljk(z, function0, SemanticsModifierKt.semantics$default(modifierM1250defaultMinSizeVpY3zN5, false, (Function1) objRememberedValue, 1, null), z7, shape, jM4120containerColorWaAFU9c$material4, jM4121contentColorWaAFU9c$material4, 0.0f, 0.0f, borderStroke3, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-1208080836, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SegmentedButtonKt.SegmentedButton$lambda$7(function2RememberComposableLambda, function3, paddingValues3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, ((i22 >> 3) & 126) | ((i22 >> 6) & 7168) | (57344 & (i22 << 3)) | (1879048192 & (i22 << 6)), 48, 384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function4 = function6;
                    z5 = z7;
                    borderStroke2 = borderStroke3;
                    segmentedButtonColors2 = segmentedButtonColors5;
                    mutableInteractionSource2 = mutableInteractionSource4;
                    modifier3 = modifier6;
                    paddingValues2 = paddingValues5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    z5 = z3;
                    segmentedButtonColors2 = segmentedButtonColorsColors;
                    borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
                    modifier3 = modifier2;
                    paddingValues2 = paddingValues;
                    function4 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SegmentedButtonKt.SegmentedButton$lambda$8(singleChoiceSegmentedButtonRowScope, z, function0, shape, modifier3, z5, segmentedButtonColors2, borderStroke2, paddingValues2, mutableInteractionSource2, function4, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            i11 = i3 & 512;
            if (i11 != 0) {
                i12 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i13 = 4;
                } else {
                    i13 = 2;
                }
                i12 = i2 | i13;
            } else {
                i12 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i16 = 32;
                } else {
                    i16 = 16;
                }
                i12 |= i16;
            }
            i14 = i12;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "215@10547L8,220@10837L42");
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if ((i3 & 64) != 0) {
                        borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                        i4 &= -29360129;
                    }
                    if (i7 != 0) {
                        contentPadding = SegmentedButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (i11 != 0) {
                        Modifier modifier7 = companion;
                        int i23 = i4;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-643804033, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$4(z, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        segmentedButtonColors3 = segmentedButtonColorsColors;
                        i15 = i23;
                        modifier2 = modifier7;
                        borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                        paddingValues3 = contentPadding;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        modifier2 = companion;
                        segmentedButtonColors3 = segmentedButtonColorsColors;
                        borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                        paddingValues3 = contentPadding;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        i15 = i4;
                        function2RememberComposableLambda = function2;
                    }
                } else {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if ((i3 & 64) != 0) {
                        borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                        i4 &= -29360129;
                    }
                    if (i7 != 0) {
                        contentPadding = SegmentedButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (i11 != 0) {
                        Modifier modifier8 = companion;
                        int i24 = i4;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-643804033, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$4(z, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        segmentedButtonColors3 = segmentedButtonColorsColors;
                        i15 = i24;
                        modifier2 = modifier8;
                        borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                        paddingValues3 = contentPadding;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        modifier2 = companion;
                        segmentedButtonColors3 = segmentedButtonColorsColors;
                        borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                        paddingValues3 = contentPadding;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        i15 = i4;
                        function2RememberComposableLambda = function2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1532041126, i15, i14, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:222)");
                }
                if (mutableInteractionSource4 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1579573323);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "224@11001L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -882237971, "CC(remember):SegmentedButton.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-882238622);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource5 = mutableInteractionSource4;
                }
                long jM4120containerColorWaAFU9c$material5 = segmentedButtonColors3.m4120containerColorWaAFU9c$material3(z3, z);
                int i25 = i15;
                long jM4121contentColorWaAFU9c$material5 = segmentedButtonColors3.m4121contentColorWaAFU9c$material3(z3, z);
                SegmentedButtonColors segmentedButtonColors6 = segmentedButtonColors3;
                Modifier modifier9 = modifier2;
                Modifier modifierM1250defaultMinSizeVpY3zN6 = SizeKt.m1250defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(singleChoiceSegmentedButtonRowScope, modifier9, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource5, composerStartRestartGroup, 0)), ButtonDefaults.INSTANCE.m2872getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m2871getMinHeightD9Ej5fM());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -882219551, "CC(remember):SegmentedButton.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SegmentedButtonKt.SegmentedButton$lambda$6$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Function2<? super Composer, ? super Integer, Unit> function7 = function2RememberComposableLambda;
                boolean z8 = z3;
                PaddingValues paddingValues6 = paddingValues3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4324Surfaced85dljk(z, function0, SemanticsModifierKt.semantics$default(modifierM1250defaultMinSizeVpY3zN6, false, (Function1) objRememberedValue, 1, null), z8, shape, jM4120containerColorWaAFU9c$material5, jM4121contentColorWaAFU9c$material5, 0.0f, 0.0f, borderStroke3, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-1208080836, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SegmentedButtonKt.SegmentedButton$lambda$7(function2RememberComposableLambda, function3, paddingValues3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i25 >> 3) & 126) | ((i25 >> 6) & 7168) | (57344 & (i25 << 3)) | (1879048192 & (i25 << 6)), 48, 384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function7;
                z5 = z8;
                borderStroke2 = borderStroke3;
                segmentedButtonColors2 = segmentedButtonColors6;
                mutableInteractionSource2 = mutableInteractionSource4;
                modifier3 = modifier9;
                paddingValues2 = paddingValues6;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                z5 = z3;
                segmentedButtonColors2 = segmentedButtonColorsColors;
                borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
                modifier3 = modifier2;
                paddingValues2 = paddingValues;
                function4 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SegmentedButtonKt.SegmentedButton$lambda$8(singleChoiceSegmentedButtonRowScope, z, function0, shape, modifier3, z5, segmentedButtonColors2, borderStroke2, paddingValues2, mutableInteractionSource2, function4, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        modifier2 = modifier;
        i5 = i3 & 16;
        if (i5 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z3 = z2;
        } else {
            z3 = z2;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
        }
        if ((i & 1572864) == 0) {
            segmentedButtonColorsColors = segmentedButtonColors;
            if ((i3 & 32) == 0) {
                i18 = 524288;
            } else {
                i18 = 524288;
            }
            i4 |= i18;
        } else {
            segmentedButtonColorsColors = segmentedButtonColors;
        }
        if ((i & 12582912) == 0) {
            borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
            if ((i3 & 64) == 0) {
                i17 = 4194304;
            } else {
                i17 = 4194304;
            }
            i4 |= i17;
        } else {
            borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
        }
        i7 = i3 & 128;
        if (i7 != 0) {
            i4 |= 100663296;
        } else if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changed(paddingValues)) {
                i8 = 67108864;
            } else {
                i8 = 33554432;
            }
            i4 |= i8;
        }
        i9 = i3 & 256;
        if (i9 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i10 = 268435456;
                }
                i4 |= i10;
            }
            i11 = i3 & 512;
            if (i11 != 0) {
                i12 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i13 = 4;
                } else {
                    i13 = 2;
                }
                i12 = i2 | i13;
            } else {
                i12 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i16 = 32;
                } else {
                    i16 = 16;
                }
                i12 |= i16;
            }
            i14 = i12;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "215@10547L8,220@10837L42");
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if ((i3 & 64) != 0) {
                        borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                        i4 &= -29360129;
                    }
                    if (i7 != 0) {
                        contentPadding = SegmentedButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (i11 != 0) {
                        Modifier modifier10 = companion;
                        int i26 = i4;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-643804033, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$4(z, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        segmentedButtonColors3 = segmentedButtonColorsColors;
                        i15 = i26;
                        modifier2 = modifier10;
                        borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                        paddingValues3 = contentPadding;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        modifier2 = companion;
                        segmentedButtonColors3 = segmentedButtonColorsColors;
                        borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                        paddingValues3 = contentPadding;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        i15 = i4;
                        function2RememberComposableLambda = function2;
                    }
                } else {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if ((i3 & 64) != 0) {
                        borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                        i4 &= -29360129;
                    }
                    if (i7 != 0) {
                        contentPadding = SegmentedButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (i11 != 0) {
                        Modifier modifier11 = companion;
                        int i27 = i4;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-643804033, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$4(z, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        segmentedButtonColors3 = segmentedButtonColorsColors;
                        i15 = i27;
                        modifier2 = modifier11;
                        borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                        paddingValues3 = contentPadding;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        modifier2 = companion;
                        segmentedButtonColors3 = segmentedButtonColorsColors;
                        borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                        paddingValues3 = contentPadding;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        i15 = i4;
                        function2RememberComposableLambda = function2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1532041126, i15, i14, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:222)");
                }
                if (mutableInteractionSource4 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1579573323);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "224@11001L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -882237971, "CC(remember):SegmentedButton.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-882238622);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource5 = mutableInteractionSource4;
                }
                long jM4120containerColorWaAFU9c$material6 = segmentedButtonColors3.m4120containerColorWaAFU9c$material3(z3, z);
                int i28 = i15;
                long jM4121contentColorWaAFU9c$material6 = segmentedButtonColors3.m4121contentColorWaAFU9c$material3(z3, z);
                SegmentedButtonColors segmentedButtonColors7 = segmentedButtonColors3;
                Modifier modifier12 = modifier2;
                Modifier modifierM1250defaultMinSizeVpY3zN7 = SizeKt.m1250defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(singleChoiceSegmentedButtonRowScope, modifier12, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource5, composerStartRestartGroup, 0)), ButtonDefaults.INSTANCE.m2872getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m2871getMinHeightD9Ej5fM());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -882219551, "CC(remember):SegmentedButton.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SegmentedButtonKt.SegmentedButton$lambda$6$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Function2<? super Composer, ? super Integer, Unit> function8 = function2RememberComposableLambda;
                boolean z9 = z3;
                PaddingValues paddingValues7 = paddingValues3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4324Surfaced85dljk(z, function0, SemanticsModifierKt.semantics$default(modifierM1250defaultMinSizeVpY3zN7, false, (Function1) objRememberedValue, 1, null), z9, shape, jM4120containerColorWaAFU9c$material6, jM4121contentColorWaAFU9c$material6, 0.0f, 0.0f, borderStroke3, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-1208080836, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SegmentedButtonKt.SegmentedButton$lambda$7(function2RememberComposableLambda, function3, paddingValues3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i28 >> 3) & 126) | ((i28 >> 6) & 7168) | (57344 & (i28 << 3)) | (1879048192 & (i28 << 6)), 48, 384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function8;
                z5 = z9;
                borderStroke2 = borderStroke3;
                segmentedButtonColors2 = segmentedButtonColors7;
                mutableInteractionSource2 = mutableInteractionSource4;
                modifier3 = modifier12;
                paddingValues2 = paddingValues7;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                z5 = z3;
                segmentedButtonColors2 = segmentedButtonColorsColors;
                borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
                modifier3 = modifier2;
                paddingValues2 = paddingValues;
                function4 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SegmentedButtonKt.SegmentedButton$lambda$8(singleChoiceSegmentedButtonRowScope, z, function0, shape, modifier3, z5, segmentedButtonColors2, borderStroke2, paddingValues2, mutableInteractionSource2, function4, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 805306368;
        i11 = i3 & 512;
        if (i11 != 0) {
            i12 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i2 | i13;
        } else {
            i12 = i2;
        }
        if ((i2 & 48) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i16 = 32;
            } else {
                i16 = 16;
            }
            i12 |= i16;
        }
        i14 = i12;
        if ((i4 & 306783379) == 306783378) {
            z4 = true;
        } else {
            z4 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "215@10547L8,220@10837L42");
            if ((i & 1) != 0) {
                if (i19 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if ((i3 & 32) != 0) {
                    segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i4 &= -3670017;
                }
                if ((i3 & 64) != 0) {
                    borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                    i4 &= -29360129;
                }
                if (i7 != 0) {
                    contentPadding = SegmentedButtonDefaults.INSTANCE.getContentPadding();
                } else {
                    contentPadding = paddingValues;
                }
                if (i9 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if (i11 != 0) {
                    Modifier modifier13 = companion;
                    int i29 = i4;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-643804033, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SegmentedButtonKt.SegmentedButton$lambda$4(z, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    segmentedButtonColors3 = segmentedButtonColorsColors;
                    i15 = i29;
                    modifier2 = modifier13;
                    borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                    paddingValues3 = contentPadding;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    modifier2 = companion;
                    segmentedButtonColors3 = segmentedButtonColorsColors;
                    borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                    paddingValues3 = contentPadding;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    i15 = i4;
                    function2RememberComposableLambda = function2;
                }
            } else {
                if (i19 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if ((i3 & 32) != 0) {
                    segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i4 &= -3670017;
                }
                if ((i3 & 64) != 0) {
                    borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                    i4 &= -29360129;
                }
                if (i7 != 0) {
                    contentPadding = SegmentedButtonDefaults.INSTANCE.getContentPadding();
                } else {
                    contentPadding = paddingValues;
                }
                if (i9 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if (i11 != 0) {
                    Modifier modifier14 = companion;
                    int i210 = i4;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-643804033, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SegmentedButtonKt.SegmentedButton$lambda$4(z, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    segmentedButtonColors3 = segmentedButtonColorsColors;
                    i15 = i210;
                    modifier2 = modifier14;
                    borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                    paddingValues3 = contentPadding;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    modifier2 = companion;
                    segmentedButtonColors3 = segmentedButtonColorsColors;
                    borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                    paddingValues3 = contentPadding;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    i15 = i4;
                    function2RememberComposableLambda = function2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1532041126, i15, i14, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:222)");
            }
            if (mutableInteractionSource4 == null) {
                composerStartRestartGroup.startReplaceGroup(-1579573323);
                ComposerKt.sourceInformation(composerStartRestartGroup, "224@11001L39");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -882237971, "CC(remember):SegmentedButton.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
            } else {
                composerStartRestartGroup.startReplaceGroup(-882238622);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource5 = mutableInteractionSource4;
            }
            long jM4120containerColorWaAFU9c$material7 = segmentedButtonColors3.m4120containerColorWaAFU9c$material3(z3, z);
            int i211 = i15;
            long jM4121contentColorWaAFU9c$material7 = segmentedButtonColors3.m4121contentColorWaAFU9c$material3(z3, z);
            SegmentedButtonColors segmentedButtonColors8 = segmentedButtonColors3;
            Modifier modifier15 = modifier2;
            Modifier modifierM1250defaultMinSizeVpY3zN8 = SizeKt.m1250defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(singleChoiceSegmentedButtonRowScope, modifier15, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource5, composerStartRestartGroup, 0)), ButtonDefaults.INSTANCE.m2872getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m2871getMinHeightD9Ej5fM());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -882219551, "CC(remember):SegmentedButton.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SegmentedButtonKt.SegmentedButton$lambda$6$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function2<? super Composer, ? super Integer, Unit> function9 = function2RememberComposableLambda;
            boolean z10 = z3;
            PaddingValues paddingValues8 = paddingValues3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4324Surfaced85dljk(z, function0, SemanticsModifierKt.semantics$default(modifierM1250defaultMinSizeVpY3zN8, false, (Function1) objRememberedValue, 1, null), z10, shape, jM4120containerColorWaAFU9c$material7, jM4121contentColorWaAFU9c$material7, 0.0f, 0.0f, borderStroke3, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-1208080836, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SegmentedButtonKt.SegmentedButton$lambda$7(function2RememberComposableLambda, function3, paddingValues3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ((i211 >> 3) & 126) | ((i211 >> 6) & 7168) | (57344 & (i211 << 3)) | (1879048192 & (i211 << 6)), 48, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function4 = function9;
            z5 = z10;
            borderStroke2 = borderStroke3;
            segmentedButtonColors2 = segmentedButtonColors8;
            mutableInteractionSource2 = mutableInteractionSource4;
            modifier3 = modifier15;
            paddingValues2 = paddingValues8;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            mutableInteractionSource2 = mutableInteractionSource;
            z5 = z3;
            segmentedButtonColors2 = segmentedButtonColorsColors;
            borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
            modifier3 = modifier2;
            paddingValues2 = paddingValues;
            function4 = function2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SegmentedButtonKt.SegmentedButton$lambda$8(singleChoiceSegmentedButtonRowScope, z, function0, shape, modifier3, z5, segmentedButtonColors2, borderStroke2, paddingValues2, mutableInteractionSource2, function4, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SegmentedButton$lambda$6$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8851setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8837getRadioButtono7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SegmentedButton$lambda$7(Function2 function2, Function2 function3, PaddingValues paddingValues, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C248@11869L51:SegmentedButton.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1208080836, i, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:248)");
            }
            SegmentedButtonContent(function2, function3, paddingValues, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SegmentedButton$lambda$9(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C264@12529L13:SegmentedButton.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1867102712, i, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:264)");
            }
            SegmentedButtonDefaults.INSTANCE.Icon(z, null, null, composer, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0120  */
    /* JADX WARN: Code duplicated, block: B:102:0x0123  */
    /* JADX WARN: Code duplicated, block: B:104:0x012a  */
    /* JADX WARN: Code duplicated, block: B:107:0x0139  */
    /* JADX WARN: Code duplicated, block: B:111:0x0141  */
    /* JADX WARN: Code duplicated, block: B:114:0x014a  */
    /* JADX WARN: Code duplicated, block: B:116:0x015c  */
    /* JADX WARN: Code duplicated, block: B:127:0x017b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:128:0x017d  */
    /* JADX WARN: Code duplicated, block: B:129:0x0182  */
    /* JADX WARN: Code duplicated, block: B:131:0x0185  */
    /* JADX WARN: Code duplicated, block: B:134:0x018a  */
    /* JADX WARN: Code duplicated, block: B:135:0x0194  */
    /* JADX WARN: Code duplicated, block: B:138:0x0199  */
    /* JADX WARN: Code duplicated, block: B:140:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:141:0x01af  */
    /* JADX WARN: Code duplicated, block: B:143:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:144:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:147:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:150:0x0226  */
    /* JADX WARN: Code duplicated, block: B:152:0x022e  */
    /* JADX WARN: Code duplicated, block: B:155:0x023e  */
    /* JADX WARN: Code duplicated, block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0084  */
    /* JADX WARN: Code duplicated, block: B:47:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x0091  */
    /* JADX WARN: Code duplicated, block: B:52:0x0094  */
    /* JADX WARN: Code duplicated, block: B:57:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:79:0x00de  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:93:0x0108  */
    /* JADX WARN: Code duplicated, block: B:94:0x010b  */
    /* JADX WARN: Code duplicated, block: B:99:0x011a  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "kept for binary compatibility")
    public static final /* synthetic */ void SegmentedButton(final MultiChoiceSegmentedButtonRowScope multiChoiceSegmentedButtonRowScope, final boolean z, final Function1 function1, final Shape shape, Modifier modifier, boolean z2, SegmentedButtonColors segmentedButtonColors, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function2 function2, final Function2 function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function1 function4;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        SegmentedButtonColors segmentedButtonColors2;
        BorderStroke borderStrokeM4137borderStrokel07J4OM$default;
        int i7;
        MutableInteractionSource mutableInteractionSource2;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z4;
        final Function2 function2RememberComposableLambda;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource3;
        final Modifier modifier3;
        final boolean z5;
        final SegmentedButtonColors segmentedButtonColors3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        SegmentedButtonColors segmentedButtonColorsColors;
        MutableInteractionSource mutableInteractionSource4;
        Modifier modifier4;
        int i12;
        SegmentedButtonColors segmentedButtonColors4;
        int i13;
        int i14;
        Composer composerStartRestartGroup = composer.startRestartGroup(2065856961);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SegmentedButton)N(checked,onCheckedChange,shape,modifier,enabled,colors,border,interactionSource,icon,label)267@12589L377:SegmentedButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(multiChoiceSegmentedButtonRowScope) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            function4 = function1;
            i4 |= composerStartRestartGroup.changedInstance(function4) ? 256 : 128;
        } else {
            function4 = function1;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(shape) ? 2048 : 1024;
        }
        int i15 = i3 & 8;
        if (i15 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((196608 & i) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                    i4 |= i6;
                }
                if ((1572864 & i) == 0) {
                    if ((i3 & 32) == 0) {
                        segmentedButtonColors2 = segmentedButtonColors;
                        int i16 = composerStartRestartGroup.changed(segmentedButtonColors2) ? 1048576 : 524288;
                        i4 |= i16;
                    } else {
                        segmentedButtonColors2 = segmentedButtonColors;
                    }
                    i4 |= i16;
                } else {
                    segmentedButtonColors2 = segmentedButtonColors;
                }
                if ((i & 12582912) == 0) {
                    borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
                    if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(borderStrokeM4137borderStrokel07J4OM$default)) {
                        i14 = 4194304;
                    } else {
                        i14 = 8388608;
                    }
                    i4 |= i14;
                } else {
                    borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 100663296;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i8 = 67108864;
                        } else {
                            i8 = 33554432;
                        }
                        i4 |= i8;
                    }
                }
                i9 = i3 & 256;
                if (i9 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i10 = 268435456;
                        }
                        i4 |= i10;
                    }
                    if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i13 = 4;
                        } else {
                            i13 = 2;
                        }
                        i11 = i2 | i13;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 306783379) == 306783378 || (i11 & 3) != 2) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "260@12290L8,264@12503L41");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i15 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if ((i3 & 32) != 0) {
                                segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i4 &= -3670017;
                            } else {
                                segmentedButtonColorsColors = segmentedButtonColors2;
                            }
                            if ((i3 & 64) != 0) {
                                borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                                i4 = (-29360129) & i4;
                            }
                            if (i7 != 0) {
                                mutableInteractionSource4 = null;
                            } else {
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = mutableInteractionSource4;
                                segmentedButtonColors4 = segmentedButtonColorsColors;
                                function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1867102712, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SegmentedButtonKt.SegmentedButton$lambda$9(z, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                modifier4 = companion;
                                i12 = i4;
                            } else {
                                modifier4 = companion;
                                mutableInteractionSource3 = mutableInteractionSource4;
                                i12 = i4;
                                segmentedButtonColors4 = segmentedButtonColorsColors;
                                function2RememberComposableLambda = function2;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 32) != 0) {
                                i4 &= -3670017;
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -29360129;
                            }
                            function2RememberComposableLambda = function2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            i12 = i4;
                            modifier4 = modifier2;
                            segmentedButtonColors4 = segmentedButtonColors2;
                        }
                        BorderStroke borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                        boolean z6 = z3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2065856961, i12, i11, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:266)");
                        }
                        SegmentedButton(multiChoiceSegmentedButtonRowScope, z, (Function1<? super Boolean, Unit>) function4, shape, modifier4, z6, segmentedButtonColors4, borderStroke3, SegmentedButtonDefaults.INSTANCE.getContentPadding(), mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) function2RememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, ((i12 << 3) & C.ENCODING_PCM_DOUBLE) | (i12 & 14) | 100663296 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12), ((i12 >> 27) & 14) | ((i11 << 3) & 112), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        borderStroke2 = borderStroke3;
                        segmentedButtonColors3 = segmentedButtonColors4;
                        z5 = z6;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        function2RememberComposableLambda = function2;
                        borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier3 = modifier2;
                        z5 = z3;
                        segmentedButtonColors3 = segmentedButtonColors2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$10(multiChoiceSegmentedButtonRowScope, z, function1, shape, modifier3, z5, segmentedButtonColors3, borderStroke2, mutableInteractionSource3, function2RememberComposableLambda, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 805306368;
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i13 = 4;
                    } else {
                        i13 = 2;
                    }
                    i11 = i2 | i13;
                } else {
                    i11 = i2;
                }
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "260@12290L8,264@12503L41");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 32) != 0) {
                            segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        } else {
                            segmentedButtonColorsColors = segmentedButtonColors2;
                        }
                        if ((i3 & 64) != 0) {
                            borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                            i4 = (-29360129) & i4;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = mutableInteractionSource4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1867102712, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SegmentedButtonKt.SegmentedButton$lambda$9(z, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            modifier4 = companion;
                            i12 = i4;
                        } else {
                            modifier4 = companion;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            i12 = i4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = function2;
                        }
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 32) != 0) {
                            segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        } else {
                            segmentedButtonColorsColors = segmentedButtonColors2;
                        }
                        if ((i3 & 64) != 0) {
                            borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                            i4 = (-29360129) & i4;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = mutableInteractionSource4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1867102712, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SegmentedButtonKt.SegmentedButton$lambda$9(z, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            modifier4 = companion;
                            i12 = i4;
                        } else {
                            modifier4 = companion;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            i12 = i4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = function2;
                        }
                    }
                    BorderStroke borderStroke4 = borderStrokeM4137borderStrokel07J4OM$default;
                    boolean z7 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2065856961, i12, i11, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:266)");
                    }
                    SegmentedButton(multiChoiceSegmentedButtonRowScope, z, (Function1<? super Boolean, Unit>) function4, shape, modifier4, z7, segmentedButtonColors4, borderStroke4, SegmentedButtonDefaults.INSTANCE.getContentPadding(), mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) function2RememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, ((i12 << 3) & C.ENCODING_PCM_DOUBLE) | (i12 & 14) | 100663296 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12), ((i12 >> 27) & 14) | ((i11 << 3) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    borderStroke2 = borderStroke4;
                    segmentedButtonColors3 = segmentedButtonColors4;
                    z5 = z7;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function2RememberComposableLambda = function2;
                    borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier3 = modifier2;
                    z5 = z3;
                    segmentedButtonColors3 = segmentedButtonColors2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SegmentedButtonKt.SegmentedButton$lambda$10(multiChoiceSegmentedButtonRowScope, z, function1, shape, modifier3, z5, segmentedButtonColors3, borderStroke2, mutableInteractionSource3, function2RememberComposableLambda, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z3 = z2;
            if ((1572864 & i) == 0) {
                if ((i3 & 32) == 0) {
                    segmentedButtonColors2 = segmentedButtonColors;
                    if (composerStartRestartGroup.changed(segmentedButtonColors2)) {
                    }
                    i4 |= i16;
                } else {
                    segmentedButtonColors2 = segmentedButtonColors;
                }
                i4 |= i16;
            } else {
                segmentedButtonColors2 = segmentedButtonColors;
            }
            if ((i & 12582912) == 0) {
                borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
                if ((i3 & 64) == 0) {
                    i14 = 4194304;
                } else {
                    i14 = 4194304;
                }
                i4 |= i14;
            } else {
                borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
            }
            i7 = i3 & 128;
            if (i7 != 0) {
                i4 |= 100663296;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i8 = 67108864;
                    } else {
                        i8 = 33554432;
                    }
                    i4 |= i8;
                }
            }
            i9 = i3 & 256;
            if (i9 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i10 = 268435456;
                    }
                    i4 |= i10;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i13 = 4;
                    } else {
                        i13 = 2;
                    }
                    i11 = i2 | i13;
                } else {
                    i11 = i2;
                }
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "260@12290L8,264@12503L41");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 32) != 0) {
                            segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        } else {
                            segmentedButtonColorsColors = segmentedButtonColors2;
                        }
                        if ((i3 & 64) != 0) {
                            borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                            i4 = (-29360129) & i4;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = mutableInteractionSource4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1867102712, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SegmentedButtonKt.SegmentedButton$lambda$9(z, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            modifier4 = companion;
                            i12 = i4;
                        } else {
                            modifier4 = companion;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            i12 = i4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = function2;
                        }
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 32) != 0) {
                            segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        } else {
                            segmentedButtonColorsColors = segmentedButtonColors2;
                        }
                        if ((i3 & 64) != 0) {
                            borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                            i4 = (-29360129) & i4;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = mutableInteractionSource4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1867102712, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SegmentedButtonKt.SegmentedButton$lambda$9(z, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            modifier4 = companion;
                            i12 = i4;
                        } else {
                            modifier4 = companion;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            i12 = i4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = function2;
                        }
                    }
                    BorderStroke borderStroke5 = borderStrokeM4137borderStrokel07J4OM$default;
                    boolean z8 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2065856961, i12, i11, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:266)");
                    }
                    SegmentedButton(multiChoiceSegmentedButtonRowScope, z, (Function1<? super Boolean, Unit>) function4, shape, modifier4, z8, segmentedButtonColors4, borderStroke5, SegmentedButtonDefaults.INSTANCE.getContentPadding(), mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) function2RememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, ((i12 << 3) & C.ENCODING_PCM_DOUBLE) | (i12 & 14) | 100663296 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12), ((i12 >> 27) & 14) | ((i11 << 3) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    borderStroke2 = borderStroke5;
                    segmentedButtonColors3 = segmentedButtonColors4;
                    z5 = z8;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function2RememberComposableLambda = function2;
                    borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier3 = modifier2;
                    z5 = z3;
                    segmentedButtonColors3 = segmentedButtonColors2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SegmentedButtonKt.SegmentedButton$lambda$10(multiChoiceSegmentedButtonRowScope, z, function1, shape, modifier3, z5, segmentedButtonColors3, borderStroke2, mutableInteractionSource3, function2RememberComposableLambda, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i13 = 4;
                } else {
                    i13 = 2;
                }
                i11 = i2 | i13;
            } else {
                i11 = i2;
            }
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "260@12290L8,264@12503L41");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    } else {
                        segmentedButtonColorsColors = segmentedButtonColors2;
                    }
                    if ((i3 & 64) != 0) {
                        borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                        i4 = (-29360129) & i4;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = mutableInteractionSource4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1867102712, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$9(z, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        modifier4 = companion;
                        i12 = i4;
                    } else {
                        modifier4 = companion;
                        mutableInteractionSource3 = mutableInteractionSource4;
                        i12 = i4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = function2;
                    }
                } else {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    } else {
                        segmentedButtonColorsColors = segmentedButtonColors2;
                    }
                    if ((i3 & 64) != 0) {
                        borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                        i4 = (-29360129) & i4;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = mutableInteractionSource4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1867102712, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$9(z, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        modifier4 = companion;
                        i12 = i4;
                    } else {
                        modifier4 = companion;
                        mutableInteractionSource3 = mutableInteractionSource4;
                        i12 = i4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = function2;
                    }
                }
                BorderStroke borderStroke6 = borderStrokeM4137borderStrokel07J4OM$default;
                boolean z9 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2065856961, i12, i11, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:266)");
                }
                SegmentedButton(multiChoiceSegmentedButtonRowScope, z, (Function1<? super Boolean, Unit>) function4, shape, modifier4, z9, segmentedButtonColors4, borderStroke6, SegmentedButtonDefaults.INSTANCE.getContentPadding(), mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) function2RememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, ((i12 << 3) & C.ENCODING_PCM_DOUBLE) | (i12 & 14) | 100663296 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12), ((i12 >> 27) & 14) | ((i11 << 3) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                borderStroke2 = borderStroke6;
                segmentedButtonColors3 = segmentedButtonColors4;
                z5 = z9;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function2RememberComposableLambda = function2;
                borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier3 = modifier2;
                z5 = z3;
                segmentedButtonColors3 = segmentedButtonColors2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SegmentedButtonKt.SegmentedButton$lambda$10(multiChoiceSegmentedButtonRowScope, z, function1, shape, modifier3, z5, segmentedButtonColors3, borderStroke2, mutableInteractionSource3, function2RememberComposableLambda, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        modifier2 = modifier;
        i5 = i3 & 16;
        if (i5 != 0) {
            if ((196608 & i) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
            if ((1572864 & i) == 0) {
                if ((i3 & 32) == 0) {
                    segmentedButtonColors2 = segmentedButtonColors;
                    if (composerStartRestartGroup.changed(segmentedButtonColors2)) {
                    }
                    i4 |= i16;
                } else {
                    segmentedButtonColors2 = segmentedButtonColors;
                }
                i4 |= i16;
            } else {
                segmentedButtonColors2 = segmentedButtonColors;
            }
            if ((i & 12582912) == 0) {
                borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
                if ((i3 & 64) == 0) {
                    i14 = 4194304;
                } else {
                    i14 = 4194304;
                }
                i4 |= i14;
            } else {
                borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
            }
            i7 = i3 & 128;
            if (i7 != 0) {
                i4 |= 100663296;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i8 = 67108864;
                    } else {
                        i8 = 33554432;
                    }
                    i4 |= i8;
                }
            }
            i9 = i3 & 256;
            if (i9 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i10 = 268435456;
                    }
                    i4 |= i10;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i13 = 4;
                    } else {
                        i13 = 2;
                    }
                    i11 = i2 | i13;
                } else {
                    i11 = i2;
                }
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "260@12290L8,264@12503L41");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 32) != 0) {
                            segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        } else {
                            segmentedButtonColorsColors = segmentedButtonColors2;
                        }
                        if ((i3 & 64) != 0) {
                            borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                            i4 = (-29360129) & i4;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = mutableInteractionSource4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1867102712, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SegmentedButtonKt.SegmentedButton$lambda$9(z, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            modifier4 = companion;
                            i12 = i4;
                        } else {
                            modifier4 = companion;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            i12 = i4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = function2;
                        }
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 32) != 0) {
                            segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        } else {
                            segmentedButtonColorsColors = segmentedButtonColors2;
                        }
                        if ((i3 & 64) != 0) {
                            borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                            i4 = (-29360129) & i4;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = mutableInteractionSource4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1867102712, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SegmentedButtonKt.SegmentedButton$lambda$9(z, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            modifier4 = companion;
                            i12 = i4;
                        } else {
                            modifier4 = companion;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            i12 = i4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = function2;
                        }
                    }
                    BorderStroke borderStroke7 = borderStrokeM4137borderStrokel07J4OM$default;
                    boolean z10 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2065856961, i12, i11, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:266)");
                    }
                    SegmentedButton(multiChoiceSegmentedButtonRowScope, z, (Function1<? super Boolean, Unit>) function4, shape, modifier4, z10, segmentedButtonColors4, borderStroke7, SegmentedButtonDefaults.INSTANCE.getContentPadding(), mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) function2RememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, ((i12 << 3) & C.ENCODING_PCM_DOUBLE) | (i12 & 14) | 100663296 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12), ((i12 >> 27) & 14) | ((i11 << 3) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    borderStroke2 = borderStroke7;
                    segmentedButtonColors3 = segmentedButtonColors4;
                    z5 = z10;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function2RememberComposableLambda = function2;
                    borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier3 = modifier2;
                    z5 = z3;
                    segmentedButtonColors3 = segmentedButtonColors2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SegmentedButtonKt.SegmentedButton$lambda$10(multiChoiceSegmentedButtonRowScope, z, function1, shape, modifier3, z5, segmentedButtonColors3, borderStroke2, mutableInteractionSource3, function2RememberComposableLambda, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i13 = 4;
                } else {
                    i13 = 2;
                }
                i11 = i2 | i13;
            } else {
                i11 = i2;
            }
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "260@12290L8,264@12503L41");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    } else {
                        segmentedButtonColorsColors = segmentedButtonColors2;
                    }
                    if ((i3 & 64) != 0) {
                        borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                        i4 = (-29360129) & i4;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = mutableInteractionSource4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1867102712, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$9(z, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        modifier4 = companion;
                        i12 = i4;
                    } else {
                        modifier4 = companion;
                        mutableInteractionSource3 = mutableInteractionSource4;
                        i12 = i4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = function2;
                    }
                } else {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    } else {
                        segmentedButtonColorsColors = segmentedButtonColors2;
                    }
                    if ((i3 & 64) != 0) {
                        borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                        i4 = (-29360129) & i4;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = mutableInteractionSource4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1867102712, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$9(z, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        modifier4 = companion;
                        i12 = i4;
                    } else {
                        modifier4 = companion;
                        mutableInteractionSource3 = mutableInteractionSource4;
                        i12 = i4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = function2;
                    }
                }
                BorderStroke borderStroke8 = borderStrokeM4137borderStrokel07J4OM$default;
                boolean z11 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2065856961, i12, i11, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:266)");
                }
                SegmentedButton(multiChoiceSegmentedButtonRowScope, z, (Function1<? super Boolean, Unit>) function4, shape, modifier4, z11, segmentedButtonColors4, borderStroke8, SegmentedButtonDefaults.INSTANCE.getContentPadding(), mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) function2RememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, ((i12 << 3) & C.ENCODING_PCM_DOUBLE) | (i12 & 14) | 100663296 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12), ((i12 >> 27) & 14) | ((i11 << 3) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                borderStroke2 = borderStroke8;
                segmentedButtonColors3 = segmentedButtonColors4;
                z5 = z11;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function2RememberComposableLambda = function2;
                borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier3 = modifier2;
                z5 = z3;
                segmentedButtonColors3 = segmentedButtonColors2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SegmentedButtonKt.SegmentedButton$lambda$10(multiChoiceSegmentedButtonRowScope, z, function1, shape, modifier3, z5, segmentedButtonColors3, borderStroke2, mutableInteractionSource3, function2RememberComposableLambda, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z3 = z2;
        if ((1572864 & i) == 0) {
            if ((i3 & 32) == 0) {
                segmentedButtonColors2 = segmentedButtonColors;
                if (composerStartRestartGroup.changed(segmentedButtonColors2)) {
                }
                i4 |= i16;
            } else {
                segmentedButtonColors2 = segmentedButtonColors;
            }
            i4 |= i16;
        } else {
            segmentedButtonColors2 = segmentedButtonColors;
        }
        if ((i & 12582912) == 0) {
            borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
            if ((i3 & 64) == 0) {
                i14 = 4194304;
            } else {
                i14 = 4194304;
            }
            i4 |= i14;
        } else {
            borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
        }
        i7 = i3 & 128;
        if (i7 != 0) {
            i4 |= 100663296;
            mutableInteractionSource2 = mutableInteractionSource;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i8 = 67108864;
                } else {
                    i8 = 33554432;
                }
                i4 |= i8;
            }
        }
        i9 = i3 & 256;
        if (i9 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i10 = 268435456;
                }
                i4 |= i10;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i13 = 4;
                } else {
                    i13 = 2;
                }
                i11 = i2 | i13;
            } else {
                i11 = i2;
            }
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "260@12290L8,264@12503L41");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    } else {
                        segmentedButtonColorsColors = segmentedButtonColors2;
                    }
                    if ((i3 & 64) != 0) {
                        borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                        i4 = (-29360129) & i4;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = mutableInteractionSource4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1867102712, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$9(z, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        modifier4 = companion;
                        i12 = i4;
                    } else {
                        modifier4 = companion;
                        mutableInteractionSource3 = mutableInteractionSource4;
                        i12 = i4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = function2;
                    }
                } else {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    } else {
                        segmentedButtonColorsColors = segmentedButtonColors2;
                    }
                    if ((i3 & 64) != 0) {
                        borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                        i4 = (-29360129) & i4;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = mutableInteractionSource4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1867102712, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$9(z, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        modifier4 = companion;
                        i12 = i4;
                    } else {
                        modifier4 = companion;
                        mutableInteractionSource3 = mutableInteractionSource4;
                        i12 = i4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = function2;
                    }
                }
                BorderStroke borderStroke9 = borderStrokeM4137borderStrokel07J4OM$default;
                boolean z12 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2065856961, i12, i11, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:266)");
                }
                SegmentedButton(multiChoiceSegmentedButtonRowScope, z, (Function1<? super Boolean, Unit>) function4, shape, modifier4, z12, segmentedButtonColors4, borderStroke9, SegmentedButtonDefaults.INSTANCE.getContentPadding(), mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) function2RememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, ((i12 << 3) & C.ENCODING_PCM_DOUBLE) | (i12 & 14) | 100663296 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12), ((i12 >> 27) & 14) | ((i11 << 3) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                borderStroke2 = borderStroke9;
                segmentedButtonColors3 = segmentedButtonColors4;
                z5 = z12;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function2RememberComposableLambda = function2;
                borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier3 = modifier2;
                z5 = z3;
                segmentedButtonColors3 = segmentedButtonColors2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SegmentedButtonKt.SegmentedButton$lambda$10(multiChoiceSegmentedButtonRowScope, z, function1, shape, modifier3, z5, segmentedButtonColors3, borderStroke2, mutableInteractionSource3, function2RememberComposableLambda, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 805306368;
        if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i11 = i2 | i13;
        } else {
            i11 = i2;
        }
        if ((i4 & 306783379) == 306783378) {
            z4 = true;
        } else {
            z4 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "260@12290L8,264@12503L41");
            if ((i & 1) != 0) {
                if (i15 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if ((i3 & 32) != 0) {
                    segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i4 &= -3670017;
                } else {
                    segmentedButtonColorsColors = segmentedButtonColors2;
                }
                if ((i3 & 64) != 0) {
                    borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                    i4 = (-29360129) & i4;
                }
                if (i7 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                if (i9 != 0) {
                    mutableInteractionSource3 = mutableInteractionSource4;
                    segmentedButtonColors4 = segmentedButtonColorsColors;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1867102712, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SegmentedButtonKt.SegmentedButton$lambda$9(z, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    modifier4 = companion;
                    i12 = i4;
                } else {
                    modifier4 = companion;
                    mutableInteractionSource3 = mutableInteractionSource4;
                    i12 = i4;
                    segmentedButtonColors4 = segmentedButtonColorsColors;
                    function2RememberComposableLambda = function2;
                }
            } else {
                if (i15 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if ((i3 & 32) != 0) {
                    segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i4 &= -3670017;
                } else {
                    segmentedButtonColorsColors = segmentedButtonColors2;
                }
                if ((i3 & 64) != 0) {
                    borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                    i4 = (-29360129) & i4;
                }
                if (i7 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                if (i9 != 0) {
                    mutableInteractionSource3 = mutableInteractionSource4;
                    segmentedButtonColors4 = segmentedButtonColorsColors;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1867102712, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SegmentedButtonKt.SegmentedButton$lambda$9(z, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    modifier4 = companion;
                    i12 = i4;
                } else {
                    modifier4 = companion;
                    mutableInteractionSource3 = mutableInteractionSource4;
                    i12 = i4;
                    segmentedButtonColors4 = segmentedButtonColorsColors;
                    function2RememberComposableLambda = function2;
                }
            }
            BorderStroke borderStroke10 = borderStrokeM4137borderStrokel07J4OM$default;
            boolean z13 = z3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2065856961, i12, i11, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:266)");
            }
            SegmentedButton(multiChoiceSegmentedButtonRowScope, z, (Function1<? super Boolean, Unit>) function4, shape, modifier4, z13, segmentedButtonColors4, borderStroke10, SegmentedButtonDefaults.INSTANCE.getContentPadding(), mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) function2RememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, ((i12 << 3) & C.ENCODING_PCM_DOUBLE) | (i12 & 14) | 100663296 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12), ((i12 >> 27) & 14) | ((i11 << 3) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            borderStroke2 = borderStroke10;
            segmentedButtonColors3 = segmentedButtonColors4;
            z5 = z13;
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function2RememberComposableLambda = function2;
            borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
            mutableInteractionSource3 = mutableInteractionSource2;
            modifier3 = modifier2;
            z5 = z3;
            segmentedButtonColors3 = segmentedButtonColors2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SegmentedButtonKt.SegmentedButton$lambda$10(multiChoiceSegmentedButtonRowScope, z, function1, shape, modifier3, z5, segmentedButtonColors3, borderStroke2, mutableInteractionSource3, function2RememberComposableLambda, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SegmentedButton$lambda$11(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C294@13557L14:SegmentedButton.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(61121126, i, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:294)");
            }
            SegmentedButtonDefaults.INSTANCE.Icon(z, null, null, composer, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0120  */
    /* JADX WARN: Code duplicated, block: B:102:0x0123  */
    /* JADX WARN: Code duplicated, block: B:104:0x012a  */
    /* JADX WARN: Code duplicated, block: B:107:0x0139  */
    /* JADX WARN: Code duplicated, block: B:111:0x0141  */
    /* JADX WARN: Code duplicated, block: B:114:0x014a  */
    /* JADX WARN: Code duplicated, block: B:116:0x015c  */
    /* JADX WARN: Code duplicated, block: B:127:0x017b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:128:0x017d  */
    /* JADX WARN: Code duplicated, block: B:129:0x0182  */
    /* JADX WARN: Code duplicated, block: B:131:0x0185  */
    /* JADX WARN: Code duplicated, block: B:134:0x018a  */
    /* JADX WARN: Code duplicated, block: B:135:0x0194  */
    /* JADX WARN: Code duplicated, block: B:138:0x0199  */
    /* JADX WARN: Code duplicated, block: B:140:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:141:0x01af  */
    /* JADX WARN: Code duplicated, block: B:143:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:144:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:147:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:150:0x0226  */
    /* JADX WARN: Code duplicated, block: B:152:0x022e  */
    /* JADX WARN: Code duplicated, block: B:155:0x023e  */
    /* JADX WARN: Code duplicated, block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0084  */
    /* JADX WARN: Code duplicated, block: B:47:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x0091  */
    /* JADX WARN: Code duplicated, block: B:52:0x0094  */
    /* JADX WARN: Code duplicated, block: B:57:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:79:0x00de  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:93:0x0108  */
    /* JADX WARN: Code duplicated, block: B:94:0x010b  */
    /* JADX WARN: Code duplicated, block: B:99:0x011a  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "kept for binary compatibility")
    public static final /* synthetic */ void SegmentedButton(final SingleChoiceSegmentedButtonRowScope singleChoiceSegmentedButtonRowScope, final boolean z, final Function0 function0, final Shape shape, Modifier modifier, boolean z2, SegmentedButtonColors segmentedButtonColors, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function2 function2, final Function2 function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function0 function1;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        SegmentedButtonColors segmentedButtonColors2;
        BorderStroke borderStrokeM4137borderStrokel07J4OM$default;
        int i7;
        MutableInteractionSource mutableInteractionSource2;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z4;
        final Function2 function2RememberComposableLambda;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource3;
        final Modifier modifier3;
        final boolean z5;
        final SegmentedButtonColors segmentedButtonColors3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        SegmentedButtonColors segmentedButtonColorsColors;
        MutableInteractionSource mutableInteractionSource4;
        Modifier modifier4;
        int i12;
        SegmentedButtonColors segmentedButtonColors4;
        int i13;
        int i14;
        Composer composerStartRestartGroup = composer.startRestartGroup(1723786701);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SegmentedButton)N(selected,onClick,shape,modifier,enabled,colors,border,interactionSource,icon,label)297@13618L363:SegmentedButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(singleChoiceSegmentedButtonRowScope) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            function1 = function0;
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        } else {
            function1 = function0;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(shape) ? 2048 : 1024;
        }
        int i15 = i3 & 8;
        if (i15 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((196608 & i) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                    i4 |= i6;
                }
                if ((1572864 & i) == 0) {
                    if ((i3 & 32) == 0) {
                        segmentedButtonColors2 = segmentedButtonColors;
                        int i16 = composerStartRestartGroup.changed(segmentedButtonColors2) ? 1048576 : 524288;
                        i4 |= i16;
                    } else {
                        segmentedButtonColors2 = segmentedButtonColors;
                    }
                    i4 |= i16;
                } else {
                    segmentedButtonColors2 = segmentedButtonColors;
                }
                if ((i & 12582912) == 0) {
                    borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
                    if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(borderStrokeM4137borderStrokel07J4OM$default)) {
                        i14 = 4194304;
                    } else {
                        i14 = 8388608;
                    }
                    i4 |= i14;
                } else {
                    borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 100663296;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i8 = 67108864;
                        } else {
                            i8 = 33554432;
                        }
                        i4 |= i8;
                    }
                }
                i9 = i3 & 256;
                if (i9 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i10 = 268435456;
                        }
                        i4 |= i10;
                    }
                    if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i13 = 4;
                        } else {
                            i13 = 2;
                        }
                        i11 = i2 | i13;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 306783379) == 306783378 || (i11 & 3) != 2) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "290@13317L8,294@13531L42");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i15 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if ((i3 & 32) != 0) {
                                segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i4 &= -3670017;
                            } else {
                                segmentedButtonColorsColors = segmentedButtonColors2;
                            }
                            if ((i3 & 64) != 0) {
                                borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                                i4 = (-29360129) & i4;
                            }
                            if (i7 != 0) {
                                mutableInteractionSource4 = null;
                            } else {
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = mutableInteractionSource4;
                                segmentedButtonColors4 = segmentedButtonColorsColors;
                                function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(61121126, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SegmentedButtonKt.SegmentedButton$lambda$11(z, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                modifier4 = companion;
                                i12 = i4;
                            } else {
                                modifier4 = companion;
                                mutableInteractionSource3 = mutableInteractionSource4;
                                i12 = i4;
                                segmentedButtonColors4 = segmentedButtonColorsColors;
                                function2RememberComposableLambda = function2;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 32) != 0) {
                                i4 &= -3670017;
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -29360129;
                            }
                            function2RememberComposableLambda = function2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            i12 = i4;
                            modifier4 = modifier2;
                            segmentedButtonColors4 = segmentedButtonColors2;
                        }
                        BorderStroke borderStroke3 = borderStrokeM4137borderStrokel07J4OM$default;
                        boolean z6 = z3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1723786701, i12, i11, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:296)");
                        }
                        SegmentedButton(singleChoiceSegmentedButtonRowScope, z, (Function0<Unit>) function1, shape, modifier4, z6, segmentedButtonColors4, borderStroke3, SegmentedButtonDefaults.INSTANCE.getContentPadding(), mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) function2RememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, ((i12 << 3) & C.ENCODING_PCM_DOUBLE) | (i12 & 14) | 100663296 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12), ((i12 >> 27) & 14) | ((i11 << 3) & 112), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        borderStroke2 = borderStroke3;
                        segmentedButtonColors3 = segmentedButtonColors4;
                        z5 = z6;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        function2RememberComposableLambda = function2;
                        borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier3 = modifier2;
                        z5 = z3;
                        segmentedButtonColors3 = segmentedButtonColors2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$12(singleChoiceSegmentedButtonRowScope, z, function0, shape, modifier3, z5, segmentedButtonColors3, borderStroke2, mutableInteractionSource3, function2RememberComposableLambda, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 805306368;
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i13 = 4;
                    } else {
                        i13 = 2;
                    }
                    i11 = i2 | i13;
                } else {
                    i11 = i2;
                }
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "290@13317L8,294@13531L42");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 32) != 0) {
                            segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        } else {
                            segmentedButtonColorsColors = segmentedButtonColors2;
                        }
                        if ((i3 & 64) != 0) {
                            borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                            i4 = (-29360129) & i4;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = mutableInteractionSource4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(61121126, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SegmentedButtonKt.SegmentedButton$lambda$11(z, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            modifier4 = companion;
                            i12 = i4;
                        } else {
                            modifier4 = companion;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            i12 = i4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = function2;
                        }
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 32) != 0) {
                            segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        } else {
                            segmentedButtonColorsColors = segmentedButtonColors2;
                        }
                        if ((i3 & 64) != 0) {
                            borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                            i4 = (-29360129) & i4;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = mutableInteractionSource4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(61121126, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SegmentedButtonKt.SegmentedButton$lambda$11(z, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            modifier4 = companion;
                            i12 = i4;
                        } else {
                            modifier4 = companion;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            i12 = i4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = function2;
                        }
                    }
                    BorderStroke borderStroke4 = borderStrokeM4137borderStrokel07J4OM$default;
                    boolean z7 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1723786701, i12, i11, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:296)");
                    }
                    SegmentedButton(singleChoiceSegmentedButtonRowScope, z, (Function0<Unit>) function1, shape, modifier4, z7, segmentedButtonColors4, borderStroke4, SegmentedButtonDefaults.INSTANCE.getContentPadding(), mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) function2RememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, ((i12 << 3) & C.ENCODING_PCM_DOUBLE) | (i12 & 14) | 100663296 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12), ((i12 >> 27) & 14) | ((i11 << 3) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    borderStroke2 = borderStroke4;
                    segmentedButtonColors3 = segmentedButtonColors4;
                    z5 = z7;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function2RememberComposableLambda = function2;
                    borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier3 = modifier2;
                    z5 = z3;
                    segmentedButtonColors3 = segmentedButtonColors2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SegmentedButtonKt.SegmentedButton$lambda$12(singleChoiceSegmentedButtonRowScope, z, function0, shape, modifier3, z5, segmentedButtonColors3, borderStroke2, mutableInteractionSource3, function2RememberComposableLambda, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z3 = z2;
            if ((1572864 & i) == 0) {
                if ((i3 & 32) == 0) {
                    segmentedButtonColors2 = segmentedButtonColors;
                    if (composerStartRestartGroup.changed(segmentedButtonColors2)) {
                    }
                    i4 |= i16;
                } else {
                    segmentedButtonColors2 = segmentedButtonColors;
                }
                i4 |= i16;
            } else {
                segmentedButtonColors2 = segmentedButtonColors;
            }
            if ((i & 12582912) == 0) {
                borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
                if ((i3 & 64) == 0) {
                    i14 = 4194304;
                } else {
                    i14 = 4194304;
                }
                i4 |= i14;
            } else {
                borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
            }
            i7 = i3 & 128;
            if (i7 != 0) {
                i4 |= 100663296;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i8 = 67108864;
                    } else {
                        i8 = 33554432;
                    }
                    i4 |= i8;
                }
            }
            i9 = i3 & 256;
            if (i9 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i10 = 268435456;
                    }
                    i4 |= i10;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i13 = 4;
                    } else {
                        i13 = 2;
                    }
                    i11 = i2 | i13;
                } else {
                    i11 = i2;
                }
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "290@13317L8,294@13531L42");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 32) != 0) {
                            segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        } else {
                            segmentedButtonColorsColors = segmentedButtonColors2;
                        }
                        if ((i3 & 64) != 0) {
                            borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                            i4 = (-29360129) & i4;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = mutableInteractionSource4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(61121126, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SegmentedButtonKt.SegmentedButton$lambda$11(z, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            modifier4 = companion;
                            i12 = i4;
                        } else {
                            modifier4 = companion;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            i12 = i4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = function2;
                        }
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 32) != 0) {
                            segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        } else {
                            segmentedButtonColorsColors = segmentedButtonColors2;
                        }
                        if ((i3 & 64) != 0) {
                            borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                            i4 = (-29360129) & i4;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = mutableInteractionSource4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(61121126, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SegmentedButtonKt.SegmentedButton$lambda$11(z, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            modifier4 = companion;
                            i12 = i4;
                        } else {
                            modifier4 = companion;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            i12 = i4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = function2;
                        }
                    }
                    BorderStroke borderStroke5 = borderStrokeM4137borderStrokel07J4OM$default;
                    boolean z8 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1723786701, i12, i11, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:296)");
                    }
                    SegmentedButton(singleChoiceSegmentedButtonRowScope, z, (Function0<Unit>) function1, shape, modifier4, z8, segmentedButtonColors4, borderStroke5, SegmentedButtonDefaults.INSTANCE.getContentPadding(), mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) function2RememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, ((i12 << 3) & C.ENCODING_PCM_DOUBLE) | (i12 & 14) | 100663296 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12), ((i12 >> 27) & 14) | ((i11 << 3) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    borderStroke2 = borderStroke5;
                    segmentedButtonColors3 = segmentedButtonColors4;
                    z5 = z8;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function2RememberComposableLambda = function2;
                    borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier3 = modifier2;
                    z5 = z3;
                    segmentedButtonColors3 = segmentedButtonColors2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SegmentedButtonKt.SegmentedButton$lambda$12(singleChoiceSegmentedButtonRowScope, z, function0, shape, modifier3, z5, segmentedButtonColors3, borderStroke2, mutableInteractionSource3, function2RememberComposableLambda, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i13 = 4;
                } else {
                    i13 = 2;
                }
                i11 = i2 | i13;
            } else {
                i11 = i2;
            }
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "290@13317L8,294@13531L42");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    } else {
                        segmentedButtonColorsColors = segmentedButtonColors2;
                    }
                    if ((i3 & 64) != 0) {
                        borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                        i4 = (-29360129) & i4;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = mutableInteractionSource4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(61121126, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$11(z, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        modifier4 = companion;
                        i12 = i4;
                    } else {
                        modifier4 = companion;
                        mutableInteractionSource3 = mutableInteractionSource4;
                        i12 = i4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = function2;
                    }
                } else {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    } else {
                        segmentedButtonColorsColors = segmentedButtonColors2;
                    }
                    if ((i3 & 64) != 0) {
                        borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                        i4 = (-29360129) & i4;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = mutableInteractionSource4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(61121126, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$11(z, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        modifier4 = companion;
                        i12 = i4;
                    } else {
                        modifier4 = companion;
                        mutableInteractionSource3 = mutableInteractionSource4;
                        i12 = i4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = function2;
                    }
                }
                BorderStroke borderStroke6 = borderStrokeM4137borderStrokel07J4OM$default;
                boolean z9 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1723786701, i12, i11, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:296)");
                }
                SegmentedButton(singleChoiceSegmentedButtonRowScope, z, (Function0<Unit>) function1, shape, modifier4, z9, segmentedButtonColors4, borderStroke6, SegmentedButtonDefaults.INSTANCE.getContentPadding(), mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) function2RememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, ((i12 << 3) & C.ENCODING_PCM_DOUBLE) | (i12 & 14) | 100663296 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12), ((i12 >> 27) & 14) | ((i11 << 3) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                borderStroke2 = borderStroke6;
                segmentedButtonColors3 = segmentedButtonColors4;
                z5 = z9;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function2RememberComposableLambda = function2;
                borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier3 = modifier2;
                z5 = z3;
                segmentedButtonColors3 = segmentedButtonColors2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SegmentedButtonKt.SegmentedButton$lambda$12(singleChoiceSegmentedButtonRowScope, z, function0, shape, modifier3, z5, segmentedButtonColors3, borderStroke2, mutableInteractionSource3, function2RememberComposableLambda, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        modifier2 = modifier;
        i5 = i3 & 16;
        if (i5 != 0) {
            if ((196608 & i) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
            if ((1572864 & i) == 0) {
                if ((i3 & 32) == 0) {
                    segmentedButtonColors2 = segmentedButtonColors;
                    if (composerStartRestartGroup.changed(segmentedButtonColors2)) {
                    }
                    i4 |= i16;
                } else {
                    segmentedButtonColors2 = segmentedButtonColors;
                }
                i4 |= i16;
            } else {
                segmentedButtonColors2 = segmentedButtonColors;
            }
            if ((i & 12582912) == 0) {
                borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
                if ((i3 & 64) == 0) {
                    i14 = 4194304;
                } else {
                    i14 = 4194304;
                }
                i4 |= i14;
            } else {
                borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
            }
            i7 = i3 & 128;
            if (i7 != 0) {
                i4 |= 100663296;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i8 = 67108864;
                    } else {
                        i8 = 33554432;
                    }
                    i4 |= i8;
                }
            }
            i9 = i3 & 256;
            if (i9 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i10 = 268435456;
                    }
                    i4 |= i10;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i13 = 4;
                    } else {
                        i13 = 2;
                    }
                    i11 = i2 | i13;
                } else {
                    i11 = i2;
                }
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "290@13317L8,294@13531L42");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 32) != 0) {
                            segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        } else {
                            segmentedButtonColorsColors = segmentedButtonColors2;
                        }
                        if ((i3 & 64) != 0) {
                            borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                            i4 = (-29360129) & i4;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = mutableInteractionSource4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(61121126, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SegmentedButtonKt.SegmentedButton$lambda$11(z, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            modifier4 = companion;
                            i12 = i4;
                        } else {
                            modifier4 = companion;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            i12 = i4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = function2;
                        }
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 32) != 0) {
                            segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        } else {
                            segmentedButtonColorsColors = segmentedButtonColors2;
                        }
                        if ((i3 & 64) != 0) {
                            borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                            i4 = (-29360129) & i4;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = mutableInteractionSource4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(61121126, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SegmentedButtonKt.SegmentedButton$lambda$11(z, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            modifier4 = companion;
                            i12 = i4;
                        } else {
                            modifier4 = companion;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            i12 = i4;
                            segmentedButtonColors4 = segmentedButtonColorsColors;
                            function2RememberComposableLambda = function2;
                        }
                    }
                    BorderStroke borderStroke7 = borderStrokeM4137borderStrokel07J4OM$default;
                    boolean z10 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1723786701, i12, i11, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:296)");
                    }
                    SegmentedButton(singleChoiceSegmentedButtonRowScope, z, (Function0<Unit>) function1, shape, modifier4, z10, segmentedButtonColors4, borderStroke7, SegmentedButtonDefaults.INSTANCE.getContentPadding(), mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) function2RememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, ((i12 << 3) & C.ENCODING_PCM_DOUBLE) | (i12 & 14) | 100663296 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12), ((i12 >> 27) & 14) | ((i11 << 3) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    borderStroke2 = borderStroke7;
                    segmentedButtonColors3 = segmentedButtonColors4;
                    z5 = z10;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function2RememberComposableLambda = function2;
                    borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier3 = modifier2;
                    z5 = z3;
                    segmentedButtonColors3 = segmentedButtonColors2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SegmentedButtonKt.SegmentedButton$lambda$12(singleChoiceSegmentedButtonRowScope, z, function0, shape, modifier3, z5, segmentedButtonColors3, borderStroke2, mutableInteractionSource3, function2RememberComposableLambda, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i13 = 4;
                } else {
                    i13 = 2;
                }
                i11 = i2 | i13;
            } else {
                i11 = i2;
            }
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "290@13317L8,294@13531L42");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    } else {
                        segmentedButtonColorsColors = segmentedButtonColors2;
                    }
                    if ((i3 & 64) != 0) {
                        borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                        i4 = (-29360129) & i4;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = mutableInteractionSource4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(61121126, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$11(z, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        modifier4 = companion;
                        i12 = i4;
                    } else {
                        modifier4 = companion;
                        mutableInteractionSource3 = mutableInteractionSource4;
                        i12 = i4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = function2;
                    }
                } else {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    } else {
                        segmentedButtonColorsColors = segmentedButtonColors2;
                    }
                    if ((i3 & 64) != 0) {
                        borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                        i4 = (-29360129) & i4;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = mutableInteractionSource4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(61121126, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$11(z, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        modifier4 = companion;
                        i12 = i4;
                    } else {
                        modifier4 = companion;
                        mutableInteractionSource3 = mutableInteractionSource4;
                        i12 = i4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = function2;
                    }
                }
                BorderStroke borderStroke8 = borderStrokeM4137borderStrokel07J4OM$default;
                boolean z11 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1723786701, i12, i11, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:296)");
                }
                SegmentedButton(singleChoiceSegmentedButtonRowScope, z, (Function0<Unit>) function1, shape, modifier4, z11, segmentedButtonColors4, borderStroke8, SegmentedButtonDefaults.INSTANCE.getContentPadding(), mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) function2RememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, ((i12 << 3) & C.ENCODING_PCM_DOUBLE) | (i12 & 14) | 100663296 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12), ((i12 >> 27) & 14) | ((i11 << 3) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                borderStroke2 = borderStroke8;
                segmentedButtonColors3 = segmentedButtonColors4;
                z5 = z11;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function2RememberComposableLambda = function2;
                borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier3 = modifier2;
                z5 = z3;
                segmentedButtonColors3 = segmentedButtonColors2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SegmentedButtonKt.SegmentedButton$lambda$12(singleChoiceSegmentedButtonRowScope, z, function0, shape, modifier3, z5, segmentedButtonColors3, borderStroke2, mutableInteractionSource3, function2RememberComposableLambda, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z3 = z2;
        if ((1572864 & i) == 0) {
            if ((i3 & 32) == 0) {
                segmentedButtonColors2 = segmentedButtonColors;
                if (composerStartRestartGroup.changed(segmentedButtonColors2)) {
                }
                i4 |= i16;
            } else {
                segmentedButtonColors2 = segmentedButtonColors;
            }
            i4 |= i16;
        } else {
            segmentedButtonColors2 = segmentedButtonColors;
        }
        if ((i & 12582912) == 0) {
            borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
            if ((i3 & 64) == 0) {
                i14 = 4194304;
            } else {
                i14 = 4194304;
            }
            i4 |= i14;
        } else {
            borderStrokeM4137borderStrokel07J4OM$default = borderStroke;
        }
        i7 = i3 & 128;
        if (i7 != 0) {
            i4 |= 100663296;
            mutableInteractionSource2 = mutableInteractionSource;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i8 = 67108864;
                } else {
                    i8 = 33554432;
                }
                i4 |= i8;
            }
        }
        i9 = i3 & 256;
        if (i9 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i10 = 268435456;
                }
                i4 |= i10;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i13 = 4;
                } else {
                    i13 = 2;
                }
                i11 = i2 | i13;
            } else {
                i11 = i2;
            }
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "290@13317L8,294@13531L42");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    } else {
                        segmentedButtonColorsColors = segmentedButtonColors2;
                    }
                    if ((i3 & 64) != 0) {
                        borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                        i4 = (-29360129) & i4;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = mutableInteractionSource4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(61121126, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$11(z, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        modifier4 = companion;
                        i12 = i4;
                    } else {
                        modifier4 = companion;
                        mutableInteractionSource3 = mutableInteractionSource4;
                        i12 = i4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = function2;
                    }
                } else {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    } else {
                        segmentedButtonColorsColors = segmentedButtonColors2;
                    }
                    if ((i3 & 64) != 0) {
                        borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                        i4 = (-29360129) & i4;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = mutableInteractionSource4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(61121126, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SegmentedButtonKt.SegmentedButton$lambda$11(z, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        modifier4 = companion;
                        i12 = i4;
                    } else {
                        modifier4 = companion;
                        mutableInteractionSource3 = mutableInteractionSource4;
                        i12 = i4;
                        segmentedButtonColors4 = segmentedButtonColorsColors;
                        function2RememberComposableLambda = function2;
                    }
                }
                BorderStroke borderStroke9 = borderStrokeM4137borderStrokel07J4OM$default;
                boolean z12 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1723786701, i12, i11, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:296)");
                }
                SegmentedButton(singleChoiceSegmentedButtonRowScope, z, (Function0<Unit>) function1, shape, modifier4, z12, segmentedButtonColors4, borderStroke9, SegmentedButtonDefaults.INSTANCE.getContentPadding(), mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) function2RememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, ((i12 << 3) & C.ENCODING_PCM_DOUBLE) | (i12 & 14) | 100663296 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12), ((i12 >> 27) & 14) | ((i11 << 3) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                borderStroke2 = borderStroke9;
                segmentedButtonColors3 = segmentedButtonColors4;
                z5 = z12;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function2RememberComposableLambda = function2;
                borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier3 = modifier2;
                z5 = z3;
                segmentedButtonColors3 = segmentedButtonColors2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SegmentedButtonKt.SegmentedButton$lambda$12(singleChoiceSegmentedButtonRowScope, z, function0, shape, modifier3, z5, segmentedButtonColors3, borderStroke2, mutableInteractionSource3, function2RememberComposableLambda, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 805306368;
        if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i11 = i2 | i13;
        } else {
            i11 = i2;
        }
        if ((i4 & 306783379) == 306783378) {
            z4 = true;
        } else {
            z4 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "290@13317L8,294@13531L42");
            if ((i & 1) != 0) {
                if (i15 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if ((i3 & 32) != 0) {
                    segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i4 &= -3670017;
                } else {
                    segmentedButtonColorsColors = segmentedButtonColors2;
                }
                if ((i3 & 64) != 0) {
                    borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                    i4 = (-29360129) & i4;
                }
                if (i7 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                if (i9 != 0) {
                    mutableInteractionSource3 = mutableInteractionSource4;
                    segmentedButtonColors4 = segmentedButtonColorsColors;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(61121126, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SegmentedButtonKt.SegmentedButton$lambda$11(z, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    modifier4 = companion;
                    i12 = i4;
                } else {
                    modifier4 = companion;
                    mutableInteractionSource3 = mutableInteractionSource4;
                    i12 = i4;
                    segmentedButtonColors4 = segmentedButtonColorsColors;
                    function2RememberComposableLambda = function2;
                }
            } else {
                if (i15 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if ((i3 & 32) != 0) {
                    segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i4 &= -3670017;
                } else {
                    segmentedButtonColorsColors = segmentedButtonColors2;
                }
                if ((i3 & 64) != 0) {
                    borderStrokeM4137borderStrokel07J4OM$default = SegmentedButtonDefaults.m4137borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4119borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                    i4 = (-29360129) & i4;
                }
                if (i7 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                if (i9 != 0) {
                    mutableInteractionSource3 = mutableInteractionSource4;
                    segmentedButtonColors4 = segmentedButtonColorsColors;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(61121126, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SegmentedButtonKt.SegmentedButton$lambda$11(z, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    modifier4 = companion;
                    i12 = i4;
                } else {
                    modifier4 = companion;
                    mutableInteractionSource3 = mutableInteractionSource4;
                    i12 = i4;
                    segmentedButtonColors4 = segmentedButtonColorsColors;
                    function2RememberComposableLambda = function2;
                }
            }
            BorderStroke borderStroke10 = borderStrokeM4137borderStrokel07J4OM$default;
            boolean z13 = z3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1723786701, i12, i11, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:296)");
            }
            SegmentedButton(singleChoiceSegmentedButtonRowScope, z, (Function0<Unit>) function1, shape, modifier4, z13, segmentedButtonColors4, borderStroke10, SegmentedButtonDefaults.INSTANCE.getContentPadding(), mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) function2RememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, ((i12 << 3) & C.ENCODING_PCM_DOUBLE) | (i12 & 14) | 100663296 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12), ((i12 >> 27) & 14) | ((i11 << 3) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            borderStroke2 = borderStroke10;
            segmentedButtonColors3 = segmentedButtonColors4;
            z5 = z13;
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function2RememberComposableLambda = function2;
            borderStroke2 = borderStrokeM4137borderStrokel07J4OM$default;
            mutableInteractionSource3 = mutableInteractionSource2;
            modifier3 = modifier2;
            z5 = z3;
            segmentedButtonColors3 = segmentedButtonColors2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SegmentedButtonKt.SegmentedButton$lambda$12(singleChoiceSegmentedButtonRowScope, z, function0, shape, modifier3, z5, segmentedButtonColors3, borderStroke2, mutableInteractionSource3, function2RememberComposableLambda, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: SingleChoiceSegmentedButtonRow-uFdPcIQ, reason: not valid java name */
    public static final void m4144SingleChoiceSegmentedButtonRowuFdPcIQ(Modifier modifier, float f, final Function3<? super SingleChoiceSegmentedButtonRowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(2041406825);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SingleChoiceSegmentedButtonRow)N(modifier,space:c#ui.unit.Dp,content)332@14963L448:SegmentedButton.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i5 != 0) {
                f = SegmentedButtonDefaults.INSTANCE.m4140getBorderWidthD9Ej5fM();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2041406825, i3, -1, "androidx.compose.material3.SingleChoiceSegmentedButtonRow (SegmentedButton.kt:331)");
            }
            Modifier modifierWidth = IntrinsicKt.width(SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableGroupKt.selectableGroup(modifier), 0.0f, OutlinedSegmentedButtonTokens.INSTANCE.m5608getContainerHeightD9Ej5fM(), 1, null), IntrinsicSize.Min);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(-f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_4, centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWidth);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1183792256, "C341@15323L58,342@15396L9:SegmentedButton.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 176734527, "CC(remember):SegmentedButton.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SingleChoiceSegmentedButtonScopeWrapper(rowScopeInstance);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            function3.invoke((SingleChoiceSegmentedButtonScopeWrapper) objRememberedValue, composerStartRestartGroup, Integer.valueOf(((i3 >> 3) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        final float f2 = f;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SegmentedButtonKt.SingleChoiceSegmentedButtonRow_uFdPcIQ$lambda$1(modifier2, f2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: MultiChoiceSegmentedButtonRow-uFdPcIQ, reason: not valid java name */
    public static final void m4143MultiChoiceSegmentedButtonRowuFdPcIQ(Modifier modifier, float f, final Function3<? super MultiChoiceSegmentedButtonRowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1844783038);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MultiChoiceSegmentedButtonRow)N(modifier,space:c#ui.unit.Dp,content)368@16414L412:SegmentedButton.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i5 != 0) {
                f = SegmentedButtonDefaults.INSTANCE.m4140getBorderWidthD9Ej5fM();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1844783038, i3, -1, "androidx.compose.material3.MultiChoiceSegmentedButtonRow (SegmentedButton.kt:367)");
            }
            Modifier modifierWidth = IntrinsicKt.width(SizeKt.m1251defaultMinSizeVpY3zN4$default(modifier, 0.0f, OutlinedSegmentedButtonTokens.INSTANCE.m5608getContainerHeightD9Ej5fM(), 1, null), IntrinsicSize.Min);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(-f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_4, centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWidth);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 714807460, "C376@16739L57,377@16811L9:SegmentedButton.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2101268635, "CC(remember):SegmentedButton.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new MultiChoiceSegmentedButtonScopeWrapper(rowScopeInstance);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            function3.invoke((MultiChoiceSegmentedButtonScopeWrapper) objRememberedValue, composerStartRestartGroup, Integer.valueOf(((i3 >> 3) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        final float f2 = f;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SegmentedButtonKt.MultiChoiceSegmentedButtonRow_uFdPcIQ$lambda$1(modifier2, f2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void SegmentedButtonContent(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final PaddingValues paddingValues, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1069265073);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SegmentedButtonContent)N(icon,content,contentPadding)387@16992L743:SegmentedButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(paddingValues) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1069265073, i2, -1, "androidx.compose.material3.SegmentedButtonContent (SegmentedButton.kt:386)");
            }
            Alignment center = Alignment.INSTANCE.getCenter();
            Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, paddingValues);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPadding);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 314731321, "C388@17149L5,390@17293L12,391@17343L386,391@17314L415:SegmentedButton.kt#uh7d8r");
            TextStyle value = TypographyKt.getValue(OutlinedSegmentedButtonTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6);
            final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6);
            TextKt.ProvideTextStyle(value, ComposableLambdaKt.rememberComposableLambda(-1372614088, true, new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SegmentedButtonKt.SegmentedButtonContent$lambda$0$0(function2, function3, finiteAnimationSpecValue, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SegmentedButtonKt.SegmentedButtonContent$lambda$1(function2, function3, paddingValues, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SegmentedButtonContent$lambda$0$0(Function2 function2, Function2 function3, FiniteAnimationSpec finiteAnimationSpec, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C392@17369L24,393@17426L98,397@17538L181:SegmentedButton.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1372614088, i, -1, "androidx.compose.material3.SegmentedButtonContent.<anonymous>.<anonymous> (SegmentedButton.kt:392)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -527175942, "CC(remember):SegmentedButton.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new SegmentedButtonContentMeasurePolicy(coroutineScope, finiteAnimationSpec);
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierHeight = IntrinsicKt.height(Modifier.INSTANCE, IntrinsicSize.Min);
            List listListOf = CollectionsKt.listOf((Object[]) new Function2[]{function2, function3});
            SegmentedButtonContentMeasurePolicy segmentedButtonContentMeasurePolicy = (SegmentedButtonContentMeasurePolicy) objRememberedValue2;
            ComposerKt.sourceInformationMarkerStart(composer, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
            Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listListOf);
            ComposerKt.sourceInformationMarkerStart(composer, -290764973, "CC(remember):Layout.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(segmentedButtonContentMeasurePolicy);
                composer.updateRememberedValue(objRememberedValue3);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierHeight);
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

    private static final State<Integer> interactionCountAsState(InteractionSource interactionSource, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 281890131, "C(interactionCountAsState)460@19902L33,461@19961L499,461@19940L520:SegmentedButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(281890131, i, -1, "androidx.compose.material3.interactionCountAsState (SegmentedButton.kt:459)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 313479124, "CC(remember):SegmentedButton.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
            composer.updateRememberedValue(objRememberedValue);
        }
        MutableIntState mutableIntState = (MutableIntState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 313481478, "CC(remember):SegmentedButton.kt#9igjgp");
        int i2 = i & 14;
        boolean z = ((i2 ^ 6) > 4 && composer.changed(interactionSource)) || (i & 6) == 4;
        SegmentedButtonKt$interactionCountAsState$1$1 segmentedButtonKt$interactionCountAsState$1$1RememberedValue = composer.rememberedValue();
        if (z || segmentedButtonKt$interactionCountAsState$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
            segmentedButtonKt$interactionCountAsState$1$1RememberedValue = new SegmentedButtonKt$interactionCountAsState$1$1(interactionSource, mutableIntState, null);
            composer.updateRememberedValue(segmentedButtonKt$interactionCountAsState$1$1RememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) segmentedButtonKt$interactionCountAsState$1$1RememberedValue, composer, i2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mutableIntState;
    }

    private static final Modifier interactionZIndex(Modifier modifier, final boolean z, final State<Integer> state) {
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SegmentedButtonKt.interactionZIndex$lambda$0(state, z, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult interactionZIndex$lambda$0(final State state, final boolean z, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(constraints.getValue());
        return MeasureScope.layout$default(measureScope, placeableMo8265measureBRTryo0.getWidth(), placeableMo8265measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SegmentedButtonKt.interactionZIndex$lambda$0$0(state, z, placeableMo8265measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit interactionZIndex$lambda$0$0(State state, boolean z, Placeable placeable, Placeable.PlacementScope placementScope) {
        placementScope.place(placeable, 0, 0, ((Number) state.getValue()).floatValue() + (z ? CheckedZIndexFactor : 0.0f));
        return Unit.INSTANCE;
    }
}
