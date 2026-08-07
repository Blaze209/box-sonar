package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.DialogProperties;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.domain.metrics.hubs.HubsObservability;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: AlertDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aB\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001aB\u0010\u000b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001aÄ\u0001\u0010\f\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a£\u0001\u0010\u001d\u001a\u00020\u00012\u0011\u0010\u001e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\t2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0001¢\u0006\u0004\b \u0010!\u001a2\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001a2\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\tH\u0001¢\u0006\u0004\b%\u0010&\u001a\f\u0010'\u001a\u00020(*\u00020(H\u0002\"\u0016\u0010)\u001a\u00020\u001aX\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+\"\u0016\u0010-\u001a\u00020\u001aX\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b.\u0010+\"\u0010\u0010/\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010,\"\u0010\u00100\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010,\"\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00103\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00104\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00105\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000\"\"\u00106\u001a\b\u0012\u0004\u0012\u000208078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010:\u001a\u0004\b;\u0010<¨\u0006="}, d2 = {"BasicAlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "AlertDialog", "AlertDialogImpl", "confirmButton", "dismissButton", HubsObservability.HUB_ASSET_ICON, "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "iconContentColor", "titleContentColor", "textContentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "AlertDialogImpl-wrnwzgE", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "AlertDialogContent", "buttons", "buttonContentColor", "AlertDialogContent-4hvqGtA", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JFJJJJLandroidx/compose/runtime/Composer;III)V", "AlertDialogFlowRow", "mainAxisSpacing", "crossAxisSpacing", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "flip", "Landroidx/compose/ui/unit/LayoutDirection;", "DialogMinWidth", "getDialogMinWidth", "()F", "F", "DialogMaxWidth", "getDialogMaxWidth", "ButtonsMainAxisSpacing", "ButtonsCrossAxisSpacing", "DialogPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "IconPadding", "TitlePadding", "TextPadding", "LocalBasicAlertDialogOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/BasicAlertDialogOverride;", "getLocalBasicAlertDialogOverride$annotations", "()V", "getLocalBasicAlertDialogOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AlertDialogKt {
    private static final float ButtonsCrossAxisSpacing;
    private static final float ButtonsMainAxisSpacing;
    private static final PaddingValues DialogPadding;
    private static final PaddingValues IconPadding;
    private static final PaddingValues TextPadding;
    private static final PaddingValues TitlePadding;
    private static final float DialogMinWidth = Dp.m9687constructorimpl(280);
    private static final float DialogMaxWidth = Dp.m9687constructorimpl(560);
    private static final ProvidableCompositionLocal<BasicAlertDialogOverride> LocalBasicAlertDialogOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AlertDialogKt.LocalBasicAlertDialogOverride$lambda$0();
        }
    }, 1, null);

    /* JADX INFO: compiled from: AlertDialog.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialog$lambda$0(Function0 function0, Modifier modifier, DialogProperties dialogProperties, Function2 function2, int i, int i2, Composer composer, int i3) {
        AlertDialog(function0, modifier, dialogProperties, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialogContent_4hvqGtA$lambda$1(Function2 function2, Modifier modifier, Function2 function3, Function2 function4, Function2 function5, Shape shape, long j, float f, long j2, long j3, long j4, long j5, int i, int i2, int i3, Composer composer, int i4) {
        m2724AlertDialogContent4hvqGtA(function2, modifier, function3, function4, function5, shape, j, f, j2, j3, j4, j5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialogFlowRow_ixp7dh8$lambda$1(float f, float f2, Function2 function2, int i, Composer composer, int i2) {
        m2725AlertDialogFlowRowixp7dh8(f, f2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialogImpl_wrnwzgE$lambda$1(Function0 function0, Function2 function2, Modifier modifier, Function2 function3, Function2 function4, Function2 function5, Function2 function6, Shape shape, long j, long j2, long j3, long j4, float f, DialogProperties dialogProperties, int i, int i2, Composer composer, int i3) {
        m2726AlertDialogImplwrnwzgE(function0, function2, modifier, function3, function4, function5, function6, shape, j, j2, j3, j4, f, dialogProperties, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicAlertDialog$lambda$1(Function0 function0, Modifier modifier, DialogProperties dialogProperties, Function2 function2, int i, int i2, Composer composer, int i3) {
        BasicAlertDialog(function0, modifier, dialogProperties, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getLocalBasicAlertDialogOverride$annotations() {
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:26:0x004b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x0080  */
    /* JADX WARN: Code duplicated, block: B:47:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:52:0x009c  */
    /* JADX WARN: Code duplicated, block: B:55:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:56:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:61:? A[RETURN, SYNTHETIC] */
    public static final void BasicAlertDialog(final Function0<Unit> function0, Modifier modifier, DialogProperties dialogProperties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        DialogProperties dialogProperties2;
        int i5;
        boolean z;
        Modifier.Companion companion;
        final DialogProperties dialogProperties3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(24925658);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicAlertDialog)N(onDismissRequest,modifier,properties,content)144@6936L7,*151@7179L18:AlertDialog.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    dialogProperties2 = dialogProperties;
                    if (composerStartRestartGroup.changed(dialogProperties2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i3 |= i6;
                }
                if ((i3 & 1171) != 1170) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                } else {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(24925658, i3, -1, "androidx.compose.material3.BasicAlertDialog (AlertDialog.kt:143)");
                    }
                    ProvidableCompositionLocal<BasicAlertDialogOverride> providableCompositionLocal = LocalBasicAlertDialogOverride;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ((BasicAlertDialogOverride) objConsume).BasicAlertDialog(new BasicAlertDialogOverrideScope(function0, companion, dialogProperties2, function2), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                dialogProperties3 = dialogProperties2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier3 = companion;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AlertDialogKt.BasicAlertDialog$lambda$1(function0, modifier3, dialogProperties3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            dialogProperties2 = dialogProperties;
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    dialogProperties2 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(24925658, i3, -1, "androidx.compose.material3.BasicAlertDialog (AlertDialog.kt:143)");
                }
                ProvidableCompositionLocal<BasicAlertDialogOverride> providableCompositionLocal2 = LocalBasicAlertDialogOverride;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(providableCompositionLocal2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ((BasicAlertDialogOverride) objConsume2).BasicAlertDialog(new BasicAlertDialogOverrideScope(function0, companion, dialogProperties2, function2), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            dialogProperties3 = dialogProperties2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier4 = companion;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AlertDialogKt.BasicAlertDialog$lambda$1(function0, modifier4, dialogProperties3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                dialogProperties2 = dialogProperties;
                if (composerStartRestartGroup.changed(dialogProperties2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    dialogProperties2 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(24925658, i3, -1, "androidx.compose.material3.BasicAlertDialog (AlertDialog.kt:143)");
                }
                ProvidableCompositionLocal<BasicAlertDialogOverride> providableCompositionLocal3 = LocalBasicAlertDialogOverride;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(providableCompositionLocal3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ((BasicAlertDialogOverride) objConsume3).BasicAlertDialog(new BasicAlertDialogOverrideScope(function0, companion, dialogProperties2, function2), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            dialogProperties3 = dialogProperties2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier5 = companion;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AlertDialogKt.BasicAlertDialog$lambda$1(function0, modifier5, dialogProperties3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        dialogProperties2 = dialogProperties;
        if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
        } else {
            if (i7 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                dialogProperties2 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(24925658, i3, -1, "androidx.compose.material3.BasicAlertDialog (AlertDialog.kt:143)");
            }
            ProvidableCompositionLocal<BasicAlertDialogOverride> providableCompositionLocal4 = LocalBasicAlertDialogOverride;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume4 = composerStartRestartGroup.consume(providableCompositionLocal4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ((BasicAlertDialogOverride) objConsume4).BasicAlertDialog(new BasicAlertDialogOverrideScope(function0, companion, dialogProperties2, function2), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        dialogProperties3 = dialogProperties2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = companion;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AlertDialogKt.BasicAlertDialog$lambda$1(function0, modifier6, dialogProperties3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:26:0x004b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0074  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:45:0x007f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:47:0x0087  */
    /* JADX WARN: Code duplicated, block: B:49:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0097  */
    /* JADX WARN: Code duplicated, block: B:53:0x009f  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:63:? A[RETURN, SYNTHETIC] */
    @Deprecated(message = "Use BasicAlertDialog instead", replaceWith = @ReplaceWith(expression = "BasicAlertDialog(onDismissRequest, modifier, properties, content)", imports = {}))
    public static final void AlertDialog(final Function0<Unit> function0, Modifier modifier, DialogProperties dialogProperties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function1;
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        boolean z;
        final DialogProperties dialogProperties2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        DialogProperties dialogProperties3;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(402506956);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialog)N(onDismissRequest,modifier,properties,content)216@9737L65:AlertDialog.kt#uh7d8r");
        if ((i & 6) == 0) {
            function1 = function0;
            i3 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            function1 = function0;
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    if (composerStartRestartGroup.changed(dialogProperties)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i3 |= i6;
                }
                if ((i3 & 1171) != 1170) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    dialogProperties2 = dialogProperties;
                    modifier3 = modifier2;
                } else {
                    if (i7 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(402506956, i3, -1, "androidx.compose.material3.AlertDialog (AlertDialog.kt:216)");
                    }
                    BasicAlertDialog(function1, modifier4, dialogProperties3, function2, composerStartRestartGroup, i3 & 8190, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    dialogProperties2 = dialogProperties3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AlertDialogKt.AlertDialog$lambda$0(function0, modifier3, dialogProperties2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                dialogProperties2 = dialogProperties;
                modifier3 = modifier2;
            } else {
                if (i7 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties3 = dialogProperties;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(402506956, i3, -1, "androidx.compose.material3.AlertDialog (AlertDialog.kt:216)");
                }
                BasicAlertDialog(function1, modifier4, dialogProperties3, function2, composerStartRestartGroup, i3 & 8190, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                dialogProperties2 = dialogProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AlertDialogKt.AlertDialog$lambda$0(function0, modifier3, dialogProperties2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                if (composerStartRestartGroup.changed(dialogProperties)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                dialogProperties2 = dialogProperties;
                modifier3 = modifier2;
            } else {
                if (i7 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties3 = dialogProperties;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(402506956, i3, -1, "androidx.compose.material3.AlertDialog (AlertDialog.kt:216)");
                }
                BasicAlertDialog(function1, modifier4, dialogProperties3, function2, composerStartRestartGroup, i3 & 8190, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                dialogProperties2 = dialogProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AlertDialogKt.AlertDialog$lambda$0(function0, modifier3, dialogProperties2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            dialogProperties2 = dialogProperties;
            modifier3 = modifier2;
        } else {
            if (i7 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
            } else {
                dialogProperties3 = dialogProperties;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(402506956, i3, -1, "androidx.compose.material3.AlertDialog (AlertDialog.kt:216)");
            }
            BasicAlertDialog(function1, modifier4, dialogProperties3, function2, composerStartRestartGroup, i3 & 8190, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            dialogProperties2 = dialogProperties3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AlertDialogKt.AlertDialog$lambda$0(function0, modifier3, dialogProperties2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: AlertDialogImpl-wrnwzgE, reason: not valid java name */
    public static final void m2726AlertDialogImplwrnwzgE(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final Function2<? super Composer, ? super Integer, Unit> function5, final Function2<? super Composer, ? super Integer, Unit> function6, final Shape shape, final long j, final long j2, final long j3, final long j4, final float f, final DialogProperties dialogProperties, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function7;
        Function2<? super Composer, ? super Integer, Unit> function8;
        Function2<? super Composer, ? super Integer, Unit> function9;
        int i4;
        float f2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-867616355);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,icon,title,text,shape,containerColor:c#ui.graphics.Color,iconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,textContentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,properties)266@11399L1463,262@11268L1594:AlertDialog.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            function7 = function2;
            i3 |= composerStartRestartGroup.changedInstance(function7) ? 32 : 16;
        } else {
            function7 = function2;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function8 = function3;
            i3 |= composerStartRestartGroup.changedInstance(function8) ? 2048 : 1024;
        } else {
            function8 = function3;
        }
        if ((i & 24576) == 0) {
            function9 = function4;
            i3 |= composerStartRestartGroup.changedInstance(function9) ? 16384 : 8192;
        } else {
            function9 = function4;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function5) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function6) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changed(shape) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changed(j2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(j3) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(j4) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            f2 = f;
            i4 |= composerStartRestartGroup.changed(f2) ? 256 : 128;
        } else {
            f2 = f;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
        }
        int i5 = i4;
        if (!composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i5 & 1171) == 1170) ? false : true, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-867616355, i3, i5, "androidx.compose.material3.AlertDialogImpl (AlertDialog.kt:261)");
            }
            final Function2<? super Composer, ? super Integer, Unit> function10 = function7;
            final Function2<? super Composer, ? super Integer, Unit> function11 = function8;
            final float f3 = f2;
            final Function2<? super Composer, ? super Integer, Unit> function12 = function9;
            BasicAlertDialog(function0, modifier, dialogProperties, ComposableLambdaKt.rememberComposableLambda(527420759, true, new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AlertDialogKt.AlertDialogImpl_wrnwzgE$lambda$0(function12, function5, function6, shape, j, f3, j2, j3, j4, function10, function11, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 3072 | ((i3 >> 3) & 112) | ((i5 >> 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AlertDialogKt.AlertDialogImpl_wrnwzgE$lambda$1(function0, function2, modifier, function3, function4, function5, function6, shape, j, j2, j3, j4, f, dialogProperties, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialogImpl_wrnwzgE$lambda$0(Function2 function2, Function2 function3, Function2 function4, Shape shape, long j, float f, long j2, long j3, long j4, final Function2 function5, final Function2 function6, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C268@11451L648,294@12691L5,267@11409L1447:AlertDialog.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(527420759, i, -1, "androidx.compose.material3.AlertDialogImpl.<anonymous> (AlertDialog.kt:267)");
            }
            m2724AlertDialogContent4hvqGtA(ComposableLambdaKt.rememberComposableLambda(1367541877, true, new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AlertDialogKt.AlertDialogImpl_wrnwzgE$lambda$0$0(function5, function6, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, function2, function3, function4, shape, j, f, ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer, 6), j2, j3, j4, composer, 6, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialogImpl_wrnwzgE$lambda$0$0(final Function2 function2, final Function2 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C270@11554L7,279@11986L99,272@11649L436:AlertDialog.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1367541877, i, -1, "androidx.compose.material3.AlertDialogImpl.<anonymous>.<anonymous> (AlertDialog.kt:269)");
            }
            ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localMinimumInteractiveComponentSize);
            ComposerKt.sourceInformationMarkerEnd(composer);
            float fM9701unboximpl = ((Dp) objConsume).m9701unboximpl();
            if (Float.isNaN(fM9701unboximpl)) {
                fM9701unboximpl = Dp.m9687constructorimpl(0);
            }
            float fM9687constructorimpl = Dp.m9687constructorimpl(fM9701unboximpl - ButtonDefaults.INSTANCE.m2871getMinHeightD9Ej5fM());
            float f = ButtonsMainAxisSpacing;
            float f2 = ButtonsCrossAxisSpacing;
            m2725AlertDialogFlowRowixp7dh8(f, ((Dp) RangesKt.coerceIn(Dp.m9685boximpl(Dp.m9687constructorimpl(f2 - fM9687constructorimpl)), Dp.m9685boximpl(Dp.m9687constructorimpl(0)), Dp.m9685boximpl(f2))).m9701unboximpl(), ComposableLambdaKt.rememberComposableLambda(-459506658, true, new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AlertDialogKt.AlertDialogImpl_wrnwzgE$lambda$0$0$1(function2, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 390);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialogImpl_wrnwzgE$lambda$0$0$1(Function2 function2, Function2 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C280@12008L15:AlertDialog.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-459506658, i, -1, "androidx.compose.material3.AlertDialogImpl.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:280)");
            }
            function2.invoke(composer, 0);
            if (function3 == null) {
                composer.startReplaceGroup(-1102003461);
            } else {
                composer.startReplaceGroup(795735494);
                ComposerKt.sourceInformation(composer, "281@12059L8");
                function3.invoke(composer, 0);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0121  */
    /* JADX WARN: Code duplicated, block: B:103:0x012a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:104:0x012c  */
    /* JADX WARN: Code duplicated, block: B:105:0x0131  */
    /* JADX WARN: Code duplicated, block: B:108:0x0139  */
    /* JADX WARN: Code duplicated, block: B:111:0x018b  */
    /* JADX WARN: Code duplicated, block: B:112:0x018f  */
    /* JADX WARN: Code duplicated, block: B:115:0x019a  */
    /* JADX WARN: Code duplicated, block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0046  */
    /* JADX WARN: Code duplicated, block: B:25:0x004c  */
    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x005e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0061  */
    /* JADX WARN: Code duplicated, block: B:37:0x0068  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0086  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0096  */
    /* JADX WARN: Code duplicated, block: B:55:0x009c  */
    /* JADX WARN: Code duplicated, block: B:56:0x009f  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:76:0x00db  */
    /* JADX WARN: Code duplicated, block: B:77:0x00de  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:91:0x0104  */
    /* JADX WARN: Code duplicated, block: B:92:0x0107  */
    /* JADX INFO: renamed from: AlertDialogContent-4hvqGtA, reason: not valid java name */
    public static final void m2724AlertDialogContent4hvqGtA(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final Function2<? super Composer, ? super Integer, Unit> function5, final Shape shape, final long j, final float f, final long j2, final long j3, final long j4, final long j5, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function6;
        Shape shape2;
        int i5;
        int i6;
        boolean z;
        final Modifier modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Composer composerStartRestartGroup = composer.startRestartGroup(1378716401);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialogContent)N(buttons,modifier,icon,title,text,shape,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,buttonContentColor:c#ui.graphics.Color,iconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,textContentColor:c#ui.graphics.Color)322@13431L2065,317@13291L2205:AlertDialog.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i17 = i3 & 2;
        if (i17 == 0) {
            if ((i & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i16 = 256;
                } else {
                    i16 = 128;
                }
                i4 |= i16;
            }
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i15 = 2048;
                } else {
                    i15 = 1024;
                }
                i4 |= i15;
            }
            if ((i & 24576) == 0) {
                function6 = function5;
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i14 = 16384;
                } else {
                    i14 = 8192;
                }
                i4 |= i14;
            } else {
                function6 = function5;
            }
            if ((196608 & i) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                    i13 = 131072;
                } else {
                    i13 = 65536;
                }
                i4 |= i13;
            } else {
                shape2 = shape;
            }
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changed(j)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i4 |= i12;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i4 |= i11;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(j2)) {
                    i10 = 67108864;
                } else {
                    i10 = 33554432;
                }
                i4 |= i10;
            }
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(j3)) {
                    i9 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i9 = 268435456;
                }
                i4 |= i9;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changed(j4)) {
                    i8 = 4;
                } else {
                    i8 = 2;
                }
                i5 = i2 | i8;
            } else {
                i5 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changed(j5)) {
                    i7 = 32;
                } else {
                    i7 = 16;
                }
                i5 |= i7;
            }
            i6 = i5;
            if ((i4 & 306783379) == 306783378 || (i6 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
            } else {
                if (i17 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1378716401, i4, i6, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:316)");
                }
                final Function2<? super Composer, ? super Integer, Unit> function7 = function6;
                int i18 = i4 >> 12;
                modifier2 = companion;
                SurfaceKt.m4323SurfaceT9BRK9s(modifier2, shape2, j, 0L, f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-652798794, true, new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AlertDialogKt.AlertDialogContent_4hvqGtA$lambda$0(function3, function4, function7, j3, j4, j5, j2, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i4 >> 3) & 14) | 12582912 | (i18 & 112) | (i18 & 896) | ((i4 >> 9) & 57344), 104);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AlertDialogKt.AlertDialogContent_4hvqGtA$lambda$1(function2, modifier2, function3, function4, function5, shape, j, f, j2, j3, j4, j5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        if ((i & 384) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i16 = 256;
            } else {
                i16 = 128;
            }
            i4 |= i16;
        }
        if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i15 = 2048;
            } else {
                i15 = 1024;
            }
            i4 |= i15;
        }
        if ((i & 24576) == 0) {
            function6 = function5;
            if (composerStartRestartGroup.changedInstance(function6)) {
                i14 = 16384;
            } else {
                i14 = 8192;
            }
            i4 |= i14;
        } else {
            function6 = function5;
        }
        if ((196608 & i) == 0) {
            shape2 = shape;
            if (composerStartRestartGroup.changed(shape2)) {
                i13 = 131072;
            } else {
                i13 = 65536;
            }
            i4 |= i13;
        } else {
            shape2 = shape;
        }
        if ((1572864 & i) == 0) {
            if (composerStartRestartGroup.changed(j)) {
                i12 = 1048576;
            } else {
                i12 = 524288;
            }
            i4 |= i12;
        }
        if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i11 = 8388608;
            } else {
                i11 = 4194304;
            }
            i4 |= i11;
        }
        if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changed(j2)) {
                i10 = 67108864;
            } else {
                i10 = 33554432;
            }
            i4 |= i10;
        }
        if ((i & 805306368) == 0) {
            if (composerStartRestartGroup.changed(j3)) {
                i9 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i9 = 268435456;
            }
            i4 |= i9;
        }
        if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changed(j4)) {
                i8 = 4;
            } else {
                i8 = 2;
            }
            i5 = i2 | i8;
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            if (composerStartRestartGroup.changed(j5)) {
                i7 = 32;
            } else {
                i7 = 16;
            }
            i5 |= i7;
        }
        i6 = i5;
        if ((i4 & 306783379) == 306783378) {
            z = true;
        } else {
            z = true;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            if (i17 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1378716401, i4, i6, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:316)");
            }
            final Function2 function8 = function6;
            int i19 = i4 >> 12;
            modifier2 = companion;
            SurfaceKt.m4323SurfaceT9BRK9s(modifier2, shape2, j, 0L, f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-652798794, true, new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AlertDialogKt.AlertDialogContent_4hvqGtA$lambda$0(function3, function4, function8, j3, j4, j5, j2, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i4 >> 3) & 14) | 12582912 | (i19 & 112) | (i19 & 896) | ((i4 >> 9) & 57344), 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AlertDialogKt.AlertDialogContent_4hvqGtA$lambda$1(function2, modifier2, function3, function4, function5, shape, j, f, j2, j3, j4, j5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialogContent_4hvqGtA$lambda$0(final Function2 function2, final Function2 function3, final Function2 function4, long j, long j2, long j3, long j4, Function2 function5, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C323@13441L2049:AlertDialog.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-652798794, i, -1, "androidx.compose.material3.AlertDialogContent.<anonymous> (AlertDialog.kt:323)");
            }
            Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, DialogPadding);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPadding);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            final ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 346139169, "C366@15147L333:AlertDialog.kt#uh7d8r");
            if (function2 == null) {
                composer.startReplaceGroup(346092326);
            } else {
                composer.startReplaceGroup(346092327);
                ComposerKt.sourceInformation(composer, "*325@13604L165,325@13534L235");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j)), ComposableLambdaKt.rememberComposableLambda(-1128150638, true, new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AlertDialogKt.AlertDialogContent_4hvqGtA$lambda$0$0$0$0(columnScopeInstance, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, ProvidedValue.$stable | 48);
            }
            composer.endReplaceGroup();
            if (function3 == null) {
                composer.startReplaceGroup(346396529);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(346396530);
                ComposerKt.sourceInformation(composer, "*334@13967L5,335@13992L569,332@13825L736");
                ProvideContentColorTextStyleKt.m4997ProvideContentColorTextStyle3JVO9M(j2, TypographyKt.getValue(DialogTokens.INSTANCE.getHeadlineFont(), composer, 6), ComposableLambdaKt.rememberComposableLambda(71284337, true, new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AlertDialogKt.AlertDialogContent_4hvqGtA$lambda$0$0$1$0(columnScopeInstance, function2, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, 384);
                composer.endReplaceGroup();
            }
            if (function4 == null) {
                composer.startReplaceGroup(347174009);
            } else {
                composer.startReplaceGroup(347174010);
                ComposerKt.sourceInformation(composer, "*352@14664L5,356@14830L290,353@14686L434");
                ProvideContentColorTextStyleKt.m4997ProvideContentColorTextStyle3JVO9M(j3, TypographyKt.getValue(DialogTokens.INSTANCE.getSupportingTextFont(), composer, r4), ComposableLambdaKt.rememberComposableLambda(705583346, true, new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AlertDialogKt.AlertDialogContent_4hvqGtA$lambda$0$0$2$0(columnScopeInstance, function4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, 384);
            }
            composer.endReplaceGroup();
            Modifier modifierAlign = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd());
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierAlign);
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
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 200047666, "C367@15260L5,368@15282L184:AlertDialog.kt#uh7d8r");
            ProvideContentColorTextStyleKt.m4997ProvideContentColorTextStyle3JVO9M(j4, TypographyKt.getValue(DialogTokens.INSTANCE.getActionLabelTextFont(), composer, 6), function5, composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
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
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialogContent_4hvqGtA$lambda$0$0$0$0(ColumnScope columnScope, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C326@13626L125:AlertDialog.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1128150638, i, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:326)");
            }
            Modifier modifierAlign = columnScope.align(PaddingKt.padding(Modifier.INSTANCE, IconPadding), Alignment.INSTANCE.getCenterHorizontally());
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierAlign);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1288652187, "C327@13723L6:AlertDialog.kt#uh7d8r");
            function2.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
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
    public static final Unit AlertDialogContent_4hvqGtA$lambda$0$0$1$0(ColumnScope columnScope, Function2 function2, Function2 function3, Composer composer, int i) {
        Alignment.Horizontal centerHorizontally;
        ComposerKt.sourceInformation(composer, "C336@14014L529:AlertDialog.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(71284337, i, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:336)");
            }
            Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, TitlePadding);
            if (function2 == null) {
                centerHorizontally = Alignment.INSTANCE.getStart();
            } else {
                centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            }
            Modifier modifierAlign = columnScope.align(modifierPadding, centerHorizontally);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierAlign);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1971616197, "C347@14514L7:AlertDialog.kt#uh7d8r");
            function3.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
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
    public static final Unit AlertDialogContent_4hvqGtA$lambda$0$0$2$0(ColumnScope columnScope, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C357@14852L250:AlertDialog.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(705583346, i, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:357)");
            }
            Modifier modifierAlign = columnScope.align(PaddingKt.padding(columnScope.weight(Modifier.INSTANCE, 1.0f, false), TextPadding), Alignment.INSTANCE.getStart());
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierAlign);
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
            ComposerKt.sourceInformationMarkerStart(composer, 517290885, "C362@15074L6:AlertDialog.kt#uh7d8r");
            function2.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
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

    /* JADX INFO: renamed from: AlertDialogFlowRow-ixp7dh8, reason: not valid java name */
    public static final void m2725AlertDialogFlowRowixp7dh8(final float f, final float f2, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-917637668);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialogFlowRow)N(mainAxisSpacing:c#ui.unit.Dp,crossAxisSpacing:c#ui.unit.Dp,content)387@15800L7,390@16045L353,390@15958L440:AlertDialog.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-917637668, i2, -1, "androidx.compose.material3.AlertDialogFlowRow (AlertDialog.kt:386)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final LayoutDirection layoutDirection = (LayoutDirection) objConsume;
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLayoutDirection().provides(flip(layoutDirection)), ComposableLambdaKt.rememberComposableLambda(-1986402020, true, new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AlertDialogKt.AlertDialogFlowRow_ixp7dh8$lambda$0(f, f2, layoutDirection, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AlertDialogKt.AlertDialogFlowRow_ixp7dh8$lambda$1(f, f2, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialogFlowRow_ixp7dh8$lambda$0(float f, float f2, final LayoutDirection layoutDirection, final Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C394@16223L169,391@16055L337:AlertDialog.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1986402020, i, -1, "androidx.compose.material3.AlertDialogFlowRow.<anonymous> (AlertDialog.kt:391)");
            }
            FlowLayoutKt.FlowRow(null, Arrangement.INSTANCE.m1073spacedBy0680j_4(f), Arrangement.INSTANCE.m1073spacedBy0680j_4(f2), null, 0, 0, ComposableLambdaKt.rememberComposableLambda(879927511, true, new Function3() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AlertDialogKt.AlertDialogFlowRow_ixp7dh8$lambda$0$0(layoutDirection, function2, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1572864, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialogFlowRow_ixp7dh8$lambda$0$0(LayoutDirection layoutDirection, Function2 function2, FlowRowScope flowRowScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C395@16237L145:AlertDialog.kt#uh7d8r");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(879927511, i, -1, "androidx.compose.material3.AlertDialogFlowRow.<anonymous>.<anonymous> (AlertDialog.kt:395)");
            }
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLayoutDirection().provides(layoutDirection), (Function2<? super Composer, ? super Integer, Unit>) function2, composer, ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final LayoutDirection flip(LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        if (i == 1) {
            return LayoutDirection.Rtl;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return LayoutDirection.Ltr;
    }

    public static final float getDialogMinWidth() {
        return DialogMinWidth;
    }

    public static final float getDialogMaxWidth() {
        return DialogMaxWidth;
    }

    public static final ProvidableCompositionLocal<BasicAlertDialogOverride> getLocalBasicAlertDialogOverride() {
        return LocalBasicAlertDialogOverride;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BasicAlertDialogOverride LocalBasicAlertDialogOverride$lambda$0() {
        return DefaultBasicAlertDialogOverride.INSTANCE;
    }

    static {
        float f = 8;
        ButtonsMainAxisSpacing = Dp.m9687constructorimpl(f);
        ButtonsCrossAxisSpacing = Dp.m9687constructorimpl(f);
        float f2 = 24;
        DialogPadding = PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(f2));
        float f3 = 16;
        IconPadding = PaddingKt.m1215PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(f3), 7, null);
        TitlePadding = PaddingKt.m1215PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(f3), 7, null);
        TextPadding = PaddingKt.m1215PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(f2), 7, null);
    }
}
