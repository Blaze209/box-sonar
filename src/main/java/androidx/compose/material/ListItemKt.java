package androidx.compose.material;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.domain.metrics.hubs.HubsObservability;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0015\b\u0002\u0010\u0004\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\r\u001a8\u0010\u000e\u001a\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0013\u001a4\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0004\b\u0016\u0010\u0017\u001a?\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0013\u0010\u0004\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u0006H\u0002¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"ListItem", "", "modifier", "Landroidx/compose/ui/Modifier;", HubsObservability.HUB_ASSET_ICON, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "secondaryText", "singleLineSecondaryText", "", "overlineText", "trailing", "text", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BaselinesOffsetColumn", "offsets", "", "Landroidx/compose/ui/unit/Dp;", "content", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OffsetToBaselineOrCenter", "offset", "OffsetToBaselineOrCenter-Kz89ssw", "(FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "applyTextStyle", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "(Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ListItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BaselinesOffsetColumn$lambda$1(List list, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        BaselinesOffsetColumn(list, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListItem$lambda$1(Modifier modifier, Function2 function2, Function2 function3, boolean z, Function2 function4, Function2 function5, Function2 function6, int i, int i2, Composer composer, int i3) {
        ListItem(modifier, function2, function3, z, function4, function5, function6, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OffsetToBaselineOrCenter_Kz89ssw$lambda$1(float f, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        m2443OffsetToBaselineOrCenterKz89ssw(f, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0112  */
    /* JADX WARN: Code duplicated, block: B:104:0x0171  */
    /* JADX WARN: Code duplicated, block: B:107:0x0185 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:109:0x01a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:110:0x01a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:111:0x01a7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:116:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:118:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:121:0x0208  */
    /* JADX WARN: Code duplicated, block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:43:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0088  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:51:0x008f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:54:0x009a  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:76:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:77:0x00df  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:92:0x0100  */
    /* JADX WARN: Code duplicated, block: B:94:0x0104  */
    /* JADX WARN: Code duplicated, block: B:95:0x0106  */
    /* JADX WARN: Code duplicated, block: B:98:0x010a  */
    public static final void ListItem(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, boolean z, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, final Function2<? super Composer, ? super Integer, Unit> function6, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function7;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function8;
        int i5;
        int i6;
        int i7;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function9;
        int i9;
        int i10;
        int i11;
        boolean z2;
        final Modifier modifier2;
        final boolean z3;
        final Function2<? super Composer, ? super Integer, Unit> function10;
        final Function2<? super Composer, ? super Integer, Unit> function11;
        final Function2<? super Composer, ? super Integer, Unit> function12;
        final Function2<? super Composer, ? super Integer, Unit> function13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function14;
        Function2<? super Composer, ? super Integer, Unit> function15;
        boolean z4;
        Function2<? super Composer, ? super Integer, Unit> function16;
        Function2<Composer, Integer, Unit> function2ApplyTextStyle;
        Function2<Composer, Integer, Unit> function2ApplyTextStyle2;
        Function2<Composer, Integer, Unit> function2ApplyTextStyle3;
        Function2<Composer, Integer, Unit> function2ApplyTextStyle4;
        Object objRememberedValue;
        Modifier modifierSemantics;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(1618131318);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ListItem)N(modifier,icon,secondaryText,singleLineSecondaryText,overlineText,trailing,text)88@3495L10,90@3578L4,91@3668L6,92@3769L4,93@3862L4,95@3951L2:ListItem.kt#jmzs0o");
        int i13 = i2 & 1;
        if (i13 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 == 0) {
            if ((i & 48) == 0) {
                function7 = function2;
                i3 |= composerStartRestartGroup.changedInstance(function7) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    function8 = function3;
                    if (composerStartRestartGroup.changedInstance(function8)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        if (composerStartRestartGroup.changed(z)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((i & 24576) == 0) {
                            function9 = function4;
                            if (composerStartRestartGroup.changedInstance(function9)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        i10 = i2 & 32;
                        if (i10 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changedInstance(function5)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                        if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function6)) {
                                i12 = 1048576;
                            } else {
                                i12 = 524288;
                            }
                            i3 |= i12;
                        }
                        if ((i3 & 599187) != 599186) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            z3 = z;
                            function10 = function5;
                            function11 = function7;
                            function12 = function8;
                            function13 = function9;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i14 != 0) {
                                function14 = null;
                            } else {
                                function14 = function7;
                            }
                            if (i4 != 0) {
                                function15 = null;
                            } else {
                                function15 = function8;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i8 != 0) {
                                function16 = null;
                            } else {
                                function16 = function9;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function17 = i10 == 0 ? function5 : null;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1618131318, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:87)");
                            }
                            Typography typography = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            function2ApplyTextStyle = applyTextStyle(typography.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function6);
                            Intrinsics.checkNotNull(function2ApplyTextStyle);
                            function2ApplyTextStyle2 = applyTextStyle(typography.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function15);
                            function2ApplyTextStyle3 = applyTextStyle(typography.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                            function2ApplyTextStyle4 = applyTextStyle(typography.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function17);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 246061688, "CC(remember):ListItem.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ListItemKt.ListItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            modifierSemantics = SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue);
                            if (function2ApplyTextStyle2 != null && function2ApplyTextStyle3 == null) {
                                composerStartRestartGroup.startReplaceGroup(-961949257);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "98@4040L61");
                                OneLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 24576, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            } else if ((function2ApplyTextStyle3 != null && z4) || function2ApplyTextStyle2 == null) {
                                composerStartRestartGroup.startReplaceGroup(-961749989);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "102@4237L185");
                                TwoLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-961536647);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function12 = function15;
                            z3 = z4;
                            function13 = function16;
                            function11 = function14;
                            function10 = function17;
                            modifier2 = companion;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ListItemKt.ListItem$lambda$1(modifier2, function11, function12, z3, function13, function10, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 24576;
                    function9 = function4;
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 599187) != 599186) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        z3 = z;
                        function10 = function5;
                        function11 = function7;
                        function12 = function8;
                        function13 = function9;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function14 = null;
                        } else {
                            function14 = function7;
                        }
                        if (i4 != 0) {
                            function15 = null;
                        } else {
                            function15 = function8;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            function16 = null;
                        } else {
                            function16 = function9;
                        }
                        if (i10 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1618131318, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:87)");
                        }
                        Typography typography2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography2.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function6);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography2.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function15);
                        function2ApplyTextStyle3 = applyTextStyle(typography2.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        function2ApplyTextStyle4 = applyTextStyle(typography2.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function17);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 246061688, "CC(remember):ListItem.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ListItemKt.ListItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue);
                        if (function2ApplyTextStyle2 != null) {
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceGroup(-961536647);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-961536647);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        } else if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceGroup(-961536647);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-961536647);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function12 = function15;
                        z3 = z4;
                        function13 = function16;
                        function11 = function14;
                        function10 = function17;
                        modifier2 = companion;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ListItemKt.ListItem$lambda$1(modifier2, function11, function12, z3, function13, function10, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        function9 = function4;
                        if (composerStartRestartGroup.changedInstance(function9)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 599187) != 599186) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        z3 = z;
                        function10 = function5;
                        function11 = function7;
                        function12 = function8;
                        function13 = function9;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function14 = null;
                        } else {
                            function14 = function7;
                        }
                        if (i4 != 0) {
                            function15 = null;
                        } else {
                            function15 = function8;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            function16 = null;
                        } else {
                            function16 = function9;
                        }
                        if (i10 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1618131318, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:87)");
                        }
                        Typography typography3 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography3.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function6);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography3.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function15);
                        function2ApplyTextStyle3 = applyTextStyle(typography3.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        function2ApplyTextStyle4 = applyTextStyle(typography3.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function17);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 246061688, "CC(remember):ListItem.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ListItemKt.ListItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue);
                        if (function2ApplyTextStyle2 != null) {
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceGroup(-961536647);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-961536647);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        } else if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceGroup(-961536647);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-961536647);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function12 = function15;
                        z3 = z4;
                        function13 = function16;
                        function11 = function14;
                        function10 = function17;
                        modifier2 = companion;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ListItemKt.ListItem$lambda$1(modifier2, function11, function12, z3, function13, function10, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                function9 = function4;
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 599187) != 599186) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    z3 = z;
                    function10 = function5;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function14 = null;
                    } else {
                        function14 = function7;
                    }
                    if (i4 != 0) {
                        function15 = null;
                    } else {
                        function15 = function8;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        function16 = null;
                    } else {
                        function16 = function9;
                    }
                    if (i10 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1618131318, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:87)");
                    }
                    Typography typography4 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography4.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function6);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography4.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function15);
                    function2ApplyTextStyle3 = applyTextStyle(typography4.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    function2ApplyTextStyle4 = applyTextStyle(typography4.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function17);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 246061688, "CC(remember):ListItem.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ListItemKt.ListItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue);
                    if (function2ApplyTextStyle2 != null) {
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceGroup(-961536647);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-961536647);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    } else if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceGroup(-961536647);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-961536647);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function12 = function15;
                    z3 = z4;
                    function13 = function16;
                    function11 = function14;
                    function10 = function17;
                    modifier2 = companion;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ListItemKt.ListItem$lambda$1(modifier2, function11, function12, z3, function13, function10, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            function8 = function3;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        function9 = function4;
                        if (composerStartRestartGroup.changedInstance(function9)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 599187) != 599186) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        z3 = z;
                        function10 = function5;
                        function11 = function7;
                        function12 = function8;
                        function13 = function9;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function14 = null;
                        } else {
                            function14 = function7;
                        }
                        if (i4 != 0) {
                            function15 = null;
                        } else {
                            function15 = function8;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            function16 = null;
                        } else {
                            function16 = function9;
                        }
                        if (i10 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1618131318, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:87)");
                        }
                        Typography typography5 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography5.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function6);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography5.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function15);
                        function2ApplyTextStyle3 = applyTextStyle(typography5.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        function2ApplyTextStyle4 = applyTextStyle(typography5.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function17);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 246061688, "CC(remember):ListItem.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ListItemKt.ListItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue);
                        if (function2ApplyTextStyle2 != null) {
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceGroup(-961536647);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-961536647);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        } else if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceGroup(-961536647);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-961536647);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function12 = function15;
                        z3 = z4;
                        function13 = function16;
                        function11 = function14;
                        function10 = function17;
                        modifier2 = companion;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ListItemKt.ListItem$lambda$1(modifier2, function11, function12, z3, function13, function10, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                function9 = function4;
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 599187) != 599186) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    z3 = z;
                    function10 = function5;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function14 = null;
                    } else {
                        function14 = function7;
                    }
                    if (i4 != 0) {
                        function15 = null;
                    } else {
                        function15 = function8;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        function16 = null;
                    } else {
                        function16 = function9;
                    }
                    if (i10 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1618131318, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:87)");
                    }
                    Typography typography6 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography6.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function6);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography6.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function15);
                    function2ApplyTextStyle3 = applyTextStyle(typography6.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    function2ApplyTextStyle4 = applyTextStyle(typography6.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function17);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 246061688, "CC(remember):ListItem.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ListItemKt.ListItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue);
                    if (function2ApplyTextStyle2 != null) {
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceGroup(-961536647);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-961536647);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    } else if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceGroup(-961536647);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-961536647);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function12 = function15;
                    z3 = z4;
                    function13 = function16;
                    function11 = function14;
                    function10 = function17;
                    modifier2 = companion;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ListItemKt.ListItem$lambda$1(modifier2, function11, function12, z3, function13, function10, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    function9 = function4;
                    if (composerStartRestartGroup.changedInstance(function9)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 599187) != 599186) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    z3 = z;
                    function10 = function5;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function14 = null;
                    } else {
                        function14 = function7;
                    }
                    if (i4 != 0) {
                        function15 = null;
                    } else {
                        function15 = function8;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        function16 = null;
                    } else {
                        function16 = function9;
                    }
                    if (i10 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1618131318, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:87)");
                    }
                    Typography typography7 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography7.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function6);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography7.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function15);
                    function2ApplyTextStyle3 = applyTextStyle(typography7.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    function2ApplyTextStyle4 = applyTextStyle(typography7.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function17);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 246061688, "CC(remember):ListItem.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ListItemKt.ListItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue);
                    if (function2ApplyTextStyle2 != null) {
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceGroup(-961536647);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-961536647);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    } else if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceGroup(-961536647);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-961536647);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function12 = function15;
                    z3 = z4;
                    function13 = function16;
                    function11 = function14;
                    function10 = function17;
                    modifier2 = companion;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ListItemKt.ListItem$lambda$1(modifier2, function11, function12, z3, function13, function10, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function9 = function4;
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            if ((i3 & 599187) != 599186) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                z3 = z;
                function10 = function5;
                function11 = function7;
                function12 = function8;
                function13 = function9;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i14 != 0) {
                    function14 = null;
                } else {
                    function14 = function7;
                }
                if (i4 != 0) {
                    function15 = null;
                } else {
                    function15 = function8;
                }
                if (i6 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i8 != 0) {
                    function16 = null;
                } else {
                    function16 = function9;
                }
                if (i10 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1618131318, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:87)");
                }
                Typography typography8 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                function2ApplyTextStyle = applyTextStyle(typography8.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function6);
                Intrinsics.checkNotNull(function2ApplyTextStyle);
                function2ApplyTextStyle2 = applyTextStyle(typography8.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function15);
                function2ApplyTextStyle3 = applyTextStyle(typography8.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                function2ApplyTextStyle4 = applyTextStyle(typography8.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function17);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 246061688, "CC(remember):ListItem.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ListItemKt.ListItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                modifierSemantics = SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue);
                if (function2ApplyTextStyle2 != null) {
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceGroup(-961536647);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-961536647);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                } else if (function2ApplyTextStyle3 != null) {
                    composerStartRestartGroup.startReplaceGroup(-961536647);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-961536647);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function12 = function15;
                z3 = z4;
                function13 = function16;
                function11 = function14;
                function10 = function17;
                modifier2 = companion;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ListItemKt.ListItem$lambda$1(modifier2, function11, function12, z3, function13, function10, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        function7 = function2;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                function8 = function3;
                if (composerStartRestartGroup.changedInstance(function8)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        function9 = function4;
                        if (composerStartRestartGroup.changedInstance(function9)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 599187) != 599186) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        z3 = z;
                        function10 = function5;
                        function11 = function7;
                        function12 = function8;
                        function13 = function9;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function14 = null;
                        } else {
                            function14 = function7;
                        }
                        if (i4 != 0) {
                            function15 = null;
                        } else {
                            function15 = function8;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            function16 = null;
                        } else {
                            function16 = function9;
                        }
                        if (i10 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1618131318, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:87)");
                        }
                        Typography typography9 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography9.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function6);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography9.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function15);
                        function2ApplyTextStyle3 = applyTextStyle(typography9.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        function2ApplyTextStyle4 = applyTextStyle(typography9.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function17);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 246061688, "CC(remember):ListItem.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ListItemKt.ListItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue);
                        if (function2ApplyTextStyle2 != null) {
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceGroup(-961536647);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-961536647);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        } else if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceGroup(-961536647);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-961536647);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function12 = function15;
                        z3 = z4;
                        function13 = function16;
                        function11 = function14;
                        function10 = function17;
                        modifier2 = companion;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ListItemKt.ListItem$lambda$1(modifier2, function11, function12, z3, function13, function10, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                function9 = function4;
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 599187) != 599186) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    z3 = z;
                    function10 = function5;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function14 = null;
                    } else {
                        function14 = function7;
                    }
                    if (i4 != 0) {
                        function15 = null;
                    } else {
                        function15 = function8;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        function16 = null;
                    } else {
                        function16 = function9;
                    }
                    if (i10 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1618131318, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:87)");
                    }
                    Typography typography10 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography10.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function6);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography10.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function15);
                    function2ApplyTextStyle3 = applyTextStyle(typography10.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    function2ApplyTextStyle4 = applyTextStyle(typography10.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function17);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 246061688, "CC(remember):ListItem.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ListItemKt.ListItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue);
                    if (function2ApplyTextStyle2 != null) {
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceGroup(-961536647);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-961536647);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    } else if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceGroup(-961536647);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-961536647);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function12 = function15;
                    z3 = z4;
                    function13 = function16;
                    function11 = function14;
                    function10 = function17;
                    modifier2 = companion;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ListItemKt.ListItem$lambda$1(modifier2, function11, function12, z3, function13, function10, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    function9 = function4;
                    if (composerStartRestartGroup.changedInstance(function9)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 599187) != 599186) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    z3 = z;
                    function10 = function5;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function14 = null;
                    } else {
                        function14 = function7;
                    }
                    if (i4 != 0) {
                        function15 = null;
                    } else {
                        function15 = function8;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        function16 = null;
                    } else {
                        function16 = function9;
                    }
                    if (i10 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1618131318, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:87)");
                    }
                    Typography typography11 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography11.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function6);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography11.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function15);
                    function2ApplyTextStyle3 = applyTextStyle(typography11.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    function2ApplyTextStyle4 = applyTextStyle(typography11.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function17);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 246061688, "CC(remember):ListItem.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ListItemKt.ListItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue);
                    if (function2ApplyTextStyle2 != null) {
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceGroup(-961536647);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-961536647);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    } else if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceGroup(-961536647);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-961536647);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function12 = function15;
                    z3 = z4;
                    function13 = function16;
                    function11 = function14;
                    function10 = function17;
                    modifier2 = companion;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ListItemKt.ListItem$lambda$1(modifier2, function11, function12, z3, function13, function10, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function9 = function4;
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            if ((i3 & 599187) != 599186) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                z3 = z;
                function10 = function5;
                function11 = function7;
                function12 = function8;
                function13 = function9;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i14 != 0) {
                    function14 = null;
                } else {
                    function14 = function7;
                }
                if (i4 != 0) {
                    function15 = null;
                } else {
                    function15 = function8;
                }
                if (i6 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i8 != 0) {
                    function16 = null;
                } else {
                    function16 = function9;
                }
                if (i10 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1618131318, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:87)");
                }
                Typography typography12 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                function2ApplyTextStyle = applyTextStyle(typography12.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function6);
                Intrinsics.checkNotNull(function2ApplyTextStyle);
                function2ApplyTextStyle2 = applyTextStyle(typography12.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function15);
                function2ApplyTextStyle3 = applyTextStyle(typography12.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                function2ApplyTextStyle4 = applyTextStyle(typography12.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function17);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 246061688, "CC(remember):ListItem.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ListItemKt.ListItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                modifierSemantics = SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue);
                if (function2ApplyTextStyle2 != null) {
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceGroup(-961536647);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-961536647);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                } else if (function2ApplyTextStyle3 != null) {
                    composerStartRestartGroup.startReplaceGroup(-961536647);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-961536647);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function12 = function15;
                z3 = z4;
                function13 = function16;
                function11 = function14;
                function10 = function17;
                modifier2 = companion;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ListItemKt.ListItem$lambda$1(modifier2, function11, function12, z3, function13, function10, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        function8 = function3;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    function9 = function4;
                    if (composerStartRestartGroup.changedInstance(function9)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 599187) != 599186) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    z3 = z;
                    function10 = function5;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function14 = null;
                    } else {
                        function14 = function7;
                    }
                    if (i4 != 0) {
                        function15 = null;
                    } else {
                        function15 = function8;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        function16 = null;
                    } else {
                        function16 = function9;
                    }
                    if (i10 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1618131318, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:87)");
                    }
                    Typography typography13 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography13.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function6);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography13.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function15);
                    function2ApplyTextStyle3 = applyTextStyle(typography13.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    function2ApplyTextStyle4 = applyTextStyle(typography13.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function17);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 246061688, "CC(remember):ListItem.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ListItemKt.ListItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue);
                    if (function2ApplyTextStyle2 != null) {
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceGroup(-961536647);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-961536647);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    } else if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceGroup(-961536647);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-961536647);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function12 = function15;
                    z3 = z4;
                    function13 = function16;
                    function11 = function14;
                    function10 = function17;
                    modifier2 = companion;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ListItemKt.ListItem$lambda$1(modifier2, function11, function12, z3, function13, function10, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function9 = function4;
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            if ((i3 & 599187) != 599186) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                z3 = z;
                function10 = function5;
                function11 = function7;
                function12 = function8;
                function13 = function9;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i14 != 0) {
                    function14 = null;
                } else {
                    function14 = function7;
                }
                if (i4 != 0) {
                    function15 = null;
                } else {
                    function15 = function8;
                }
                if (i6 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i8 != 0) {
                    function16 = null;
                } else {
                    function16 = function9;
                }
                if (i10 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1618131318, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:87)");
                }
                Typography typography14 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                function2ApplyTextStyle = applyTextStyle(typography14.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function6);
                Intrinsics.checkNotNull(function2ApplyTextStyle);
                function2ApplyTextStyle2 = applyTextStyle(typography14.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function15);
                function2ApplyTextStyle3 = applyTextStyle(typography14.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                function2ApplyTextStyle4 = applyTextStyle(typography14.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function17);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 246061688, "CC(remember):ListItem.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ListItemKt.ListItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                modifierSemantics = SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue);
                if (function2ApplyTextStyle2 != null) {
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceGroup(-961536647);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-961536647);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                } else if (function2ApplyTextStyle3 != null) {
                    composerStartRestartGroup.startReplaceGroup(-961536647);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-961536647);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function12 = function15;
                z3 = z4;
                function13 = function16;
                function11 = function14;
                function10 = function17;
                modifier2 = companion;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ListItemKt.ListItem$lambda$1(modifier2, function11, function12, z3, function13, function10, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((i & 24576) == 0) {
                function9 = function4;
                if (composerStartRestartGroup.changedInstance(function9)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            if ((i3 & 599187) != 599186) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                z3 = z;
                function10 = function5;
                function11 = function7;
                function12 = function8;
                function13 = function9;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i14 != 0) {
                    function14 = null;
                } else {
                    function14 = function7;
                }
                if (i4 != 0) {
                    function15 = null;
                } else {
                    function15 = function8;
                }
                if (i6 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i8 != 0) {
                    function16 = null;
                } else {
                    function16 = function9;
                }
                if (i10 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1618131318, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:87)");
                }
                Typography typography15 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                function2ApplyTextStyle = applyTextStyle(typography15.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function6);
                Intrinsics.checkNotNull(function2ApplyTextStyle);
                function2ApplyTextStyle2 = applyTextStyle(typography15.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function15);
                function2ApplyTextStyle3 = applyTextStyle(typography15.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                function2ApplyTextStyle4 = applyTextStyle(typography15.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function17);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 246061688, "CC(remember):ListItem.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ListItemKt.ListItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                modifierSemantics = SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue);
                if (function2ApplyTextStyle2 != null) {
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceGroup(-961536647);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-961536647);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                } else if (function2ApplyTextStyle3 != null) {
                    composerStartRestartGroup.startReplaceGroup(-961536647);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-961536647);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function12 = function15;
                z3 = z4;
                function13 = function16;
                function11 = function14;
                function10 = function17;
                modifier2 = companion;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ListItemKt.ListItem$lambda$1(modifier2, function11, function12, z3, function13, function10, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function9 = function4;
        i10 = i2 & 32;
        if (i10 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(function5)) {
                i11 = 131072;
            } else {
                i11 = 65536;
            }
            i3 |= i11;
        }
        if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function6)) {
                i12 = 1048576;
            } else {
                i12 = 524288;
            }
            i3 |= i12;
        }
        if ((i3 & 599187) != 599186) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            z3 = z;
            function10 = function5;
            function11 = function7;
            function12 = function8;
            function13 = function9;
        } else {
            if (i13 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier;
            }
            if (i14 != 0) {
                function14 = null;
            } else {
                function14 = function7;
            }
            if (i4 != 0) {
                function15 = null;
            } else {
                function15 = function8;
            }
            if (i6 != 0) {
                z4 = true;
            } else {
                z4 = z;
            }
            if (i8 != 0) {
                function16 = null;
            } else {
                function16 = function9;
            }
            if (i10 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1618131318, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:87)");
            }
            Typography typography16 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
            function2ApplyTextStyle = applyTextStyle(typography16.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function6);
            Intrinsics.checkNotNull(function2ApplyTextStyle);
            function2ApplyTextStyle2 = applyTextStyle(typography16.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function15);
            function2ApplyTextStyle3 = applyTextStyle(typography16.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
            function2ApplyTextStyle4 = applyTextStyle(typography16.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function17);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 246061688, "CC(remember):ListItem.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ListItemKt.ListItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            modifierSemantics = SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue);
            if (function2ApplyTextStyle2 != null) {
                if (function2ApplyTextStyle3 != null) {
                    composerStartRestartGroup.startReplaceGroup(-961536647);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-961536647);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
            } else if (function2ApplyTextStyle3 != null) {
                composerStartRestartGroup.startReplaceGroup(-961536647);
                ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-961536647);
                ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                ThreeLine.INSTANCE.ListItem(modifierSemantics, function14, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function12 = function15;
            z3 = z4;
            function13 = function16;
            function11 = function14;
            function10 = function17;
            modifier2 = companion;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ListItemKt.ListItem$lambda$1(modifier2, function11, function12, z3, function13, function10, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListItem$lambda$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BaselinesOffsetColumn(final List<Dp> list, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(872528548);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BaselinesOffsetColumn)N(offsets,modifier,content)365@13317L1092,365@13291L1118:ListItem.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(872528548, i3, -1, "androidx.compose.material.BaselinesOffsetColumn (ListItem.kt:364)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 981317992, "CC(remember):ListItem.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(list);
            ListItemKt$BaselinesOffsetColumn$1$1 listItemKt$BaselinesOffsetColumn$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || listItemKt$BaselinesOffsetColumn$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                listItemKt$BaselinesOffsetColumn$1$1RememberedValue = new ListItemKt$BaselinesOffsetColumn$1$1(list);
                composerStartRestartGroup.updateRememberedValue(listItemKt$BaselinesOffsetColumn$1$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) listItemKt$BaselinesOffsetColumn$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i5 = ((i3 >> 6) & 14) | (i3 & 112);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i6 = ((i5 << 6) & 896) | 6;
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i6 >> 6) & 14));
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ListItemKt.BaselinesOffsetColumn$lambda$1(list, modifier2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: OffsetToBaselineOrCenter-Kz89ssw, reason: not valid java name */
    public static final void m2443OffsetToBaselineOrCenterKz89ssw(final float f, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(953221030);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OffsetToBaselineOrCenter)N(offset:c#ui.unit.Dp,modifier,content)404@14961L830,404@14935L856:ListItem.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(953221030, i3, -1, "androidx.compose.material.OffsetToBaselineOrCenter (ListItem.kt:403)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1217381476, "CC(remember):ListItem.kt#9igjgp");
            boolean z = (i3 & 14) == 4;
            ListItemKt$OffsetToBaselineOrCenter$1$1 listItemKt$OffsetToBaselineOrCenter$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || listItemKt$OffsetToBaselineOrCenter$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                listItemKt$OffsetToBaselineOrCenter$1$1RememberedValue = new ListItemKt$OffsetToBaselineOrCenter$1$1(f);
                composerStartRestartGroup.updateRememberedValue(listItemKt$OffsetToBaselineOrCenter$1$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) listItemKt$OffsetToBaselineOrCenter$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i5 = ((((i3 & 112) | ((i3 >> 6) & 14)) << 6) & 896) | 6;
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 6) & 14));
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ListItemKt.OffsetToBaselineOrCenter_Kz89ssw$lambda$1(f, modifier2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final Function2<Composer, Integer, Unit> applyTextStyle(final TextStyle textStyle, final float f, final Function2<? super Composer, ? super Integer, Unit> function2) {
        if (function2 == null) {
            return null;
        }
        final LineHeightStyle lineHeightStyle = new LineHeightStyle(LineHeightStyle.Alignment.INSTANCE.m9494getProportionalPIaL0Z0(), LineHeightStyle.Trim.INSTANCE.m9515getBothEVpEnUU(), (DefaultConstructorMarker) null);
        return ComposableLambdaKt.composableLambdaInstance(-1000595778, true, new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ListItemKt.applyTextStyle$lambda$0(f, textStyle, lineHeightStyle, function2, (Composer) obj, ((Integer) obj2).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyTextStyle$lambda$0(float f, final TextStyle textStyle, final LineHeightStyle lineHeightStyle, final Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C438@16234L97,438@16168L163:ListItem.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1000595778, i, -1, "androidx.compose.material.applyTextStyle.<anonymous> (ListItem.kt:438)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(f)), ComposableLambdaKt.rememberComposableLambda(-925826178, true, new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ListItemKt.applyTextStyle$lambda$0$0(textStyle, lineHeightStyle, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyTextStyle$lambda$0$0(TextStyle textStyle, LineHeightStyle lineHeightStyle, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C439@16248L73:ListItem.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-925826178, i, -1, "androidx.compose.material.applyTextStyle.<anonymous>.<anonymous> (ListItem.kt:439)");
            }
            TextKt.ProvideTextStyle(TextStyle.m9104copyp1EtxEg$default(textStyle, 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, lineHeightStyle, 0, 0, null, 15728639, null), function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
