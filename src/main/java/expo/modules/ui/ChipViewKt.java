package expo.modules.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.AssistChipDefaults;
import androidx.compose.material3.ChipColors;
import androidx.compose.material3.ChipElevation;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.FilterChipDefaults;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SelectableChipColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import expo.modules.kotlin.views.FunctionalComposableScope;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChipView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aA\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\t\u001a\u001f\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0003¢\u0006\u0002\u0010\u000e\u001a5\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0003¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"ChipContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/ChipProps;", "onPress", "Lkotlin/Function1;", "Lexpo/modules/ui/ChipPressedEvent;", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/ChipProps;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ChipText", "label", "", "textStyle", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "ChipIcon", "iconName", "iconSize", "", "tint", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "ChipIcon-cf5BqRc", "(Ljava/lang/String;IJLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ChipViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChipContent$lambda$8(FunctionalComposableScope functionalComposableScope, ChipProps chipProps, Function1 function1, Function1 function2, int i, Composer composer, int i2) {
        ChipContent(functionalComposableScope, chipProps, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChipIcon_cf5BqRc$lambda$12(String str, int i, long j, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        m14624ChipIconcf5BqRc(str, i, j, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChipText$lambda$10(String str, String str2, int i, int i2, Composer composer, int i3) {
        ChipText(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:51:0x0110  */
    public static final void ChipContent(final FunctionalComposableScope functionalComposableScope, final ChipProps props, final Function1<? super ChipPressedEvent, Unit> onPress, final Function1<? super ChipPressedEvent, Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onPress, "onPress");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2074483461);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ChipContent)P(2,1):ChipView.kt#v15e7d");
        if ((i & 48) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(props) ? 32 : 16) | i;
        } else {
            i2 = i;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onPress) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismiss) ? 2048 : 1024;
        }
        if ((i2 & 1169) == 1168 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2074483461, i2, -1, "expo.modules.ui.ChipContent (ChipView.kt:47)");
            }
            Modifier modifierWrapContentSize$default = SizeKt.wrapContentSize$default(PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), Alignment.INSTANCE.getCenter(), false, 2, null);
            String lowerCase = props.getVariant().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            switch (lowerCase) {
                case "assist":
                    composerStartRestartGroup.startReplaceGroup(-713693103);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "137@4250L22");
                    ChipContent$AssistChipComposable(props, onPress, modifierWrapContentSize$default, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case "filter":
                    composerStartRestartGroup.startReplaceGroup(-713691855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "138@4289L22");
                    ChipContent$FilterChipComposable(props, onPress, modifierWrapContentSize$default, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case "input":
                    composerStartRestartGroup.startReplaceGroup(-713690640);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "139@4327L21");
                    ChipContent$InputChipComposable(props, onDismiss, modifierWrapContentSize$default, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case "suggestion":
                    composerStartRestartGroup.startReplaceGroup(-713689291);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "140@4369L26");
                    ChipContent$SuggestionChipComposable(onPress, modifierWrapContentSize$default, props, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                default:
                    composerStartRestartGroup.startReplaceGroup(-713688047);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "141@4408L22");
                    ChipContent$AssistChipComposable(props, onPress, modifierWrapContentSize$default, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ChipViewKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipViewKt.ChipContent$lambda$8(functionalComposableScope, props, onPress, onDismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChipContent$AssistChipComposable$lambda$1$lambda$0(Function1 function1) {
        function1.invoke(new ChipPressedEvent());
        return Unit.INSTANCE;
    }

    private static final void ChipContent$AssistChipComposable(final ChipProps chipProps, final Function1<? super ChipPressedEvent, Unit> function1, Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(342473857);
        ComposerKt.sourceInformation(composer, "C(AssistChipComposable)68@2326L18,69@2380L41,55@1878L31,56@1925L62,57@2009L113,62@2145L114,54@1850L608:ChipView.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(342473857, i, -1, "expo.modules.ui.ChipContent.AssistChipComposable (ChipView.kt:53)");
        }
        boolean enabled = chipProps.getEnabled();
        ChipColors chipColorsAssistChipColors = AssistChipDefaults.INSTANCE.assistChipColors(composer, AssistChipDefaults.$stable);
        BorderStroke borderStrokeM2797assistChipBorderh1eTWw = AssistChipDefaults.INSTANCE.m2797assistChipBorderh1eTWw(chipProps.getEnabled(), 0L, 0L, 0.0f, composer, AssistChipDefaults.$stable << 12, 14);
        composer.startReplaceGroup(5004770);
        ComposerKt.sourceInformation(composer, "CC(remember):ChipView.kt#9igjgp");
        boolean zChanged = composer.changed(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: expo.modules.ui.ChipViewKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ChipViewKt.ChipContent$AssistChipComposable$lambda$1$lambda$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceGroup();
        ChipKt.m2971AssistChipajgufuY((Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(270032382, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.ChipViewKt$ChipContent$AssistChipComposable$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                ComposerKt.sourceInformation(composer2, "C56@1927L58:ChipView.kt#v15e7d");
                if ((i2 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(270032382, i2, -1, "expo.modules.ui.ChipContent.AssistChipComposable.<anonymous> (ChipView.kt:56)");
                }
                ChipViewKt.ChipText(chipProps.getLabel(), chipProps.getTextStyle(), composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), modifier, enabled, ComposableLambdaKt.rememberComposableLambda(1125440091, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.ChipViewKt$ChipContent$AssistChipComposable$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                ComposerKt.sourceInformation(composer2, "C*59@2054L50:ChipView.kt#v15e7d");
                if ((i2 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1125440091, i2, -1, "expo.modules.ui.ChipContent.AssistChipComposable.<anonymous> (ChipView.kt:58)");
                }
                String leadingIcon = chipProps.getLeadingIcon();
                if (leadingIcon != null) {
                    ChipViewKt.m14624ChipIconcf5BqRc(leadingIcon, chipProps.getIconSize(), 0L, null, composer2, 0, 12);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), ComposableLambdaKt.rememberComposableLambda(1410575994, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.ChipViewKt$ChipContent$AssistChipComposable$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                ComposerKt.sourceInformation(composer2, "C*64@2191L50:ChipView.kt#v15e7d");
                if ((i2 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1410575994, i2, -1, "expo.modules.ui.ChipContent.AssistChipComposable.<anonymous> (ChipView.kt:63)");
                }
                String trailingIcon = chipProps.getTrailingIcon();
                if (trailingIcon != null) {
                    ChipViewKt.m14624ChipIconcf5BqRc(trailingIcon, chipProps.getIconSize(), 0L, null, composer2, 0, 12);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), null, chipColorsAssistChipColors, null, borderStrokeM2797assistChipBorderh1eTWw, 0.0f, null, null, composer, 221616, 0, 7488);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChipContent$FilterChipComposable$lambda$3$lambda$2(Function1 function1) {
        function1.invoke(new ChipPressedEvent());
        return Unit.INSTANCE;
    }

    private static final void ChipContent$FilterChipComposable(final ChipProps chipProps, final Function1<? super ChipPressedEvent, Unit> function1, Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(957926992);
        ComposerKt.sourceInformation(composer, "C(FilterChipComposable)93@3058L18,94@3112L68,77@2541L31,78@2588L62,87@2877L114,76@2513L704:ChipView.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(957926992, i, -1, "expo.modules.ui.ChipContent.FilterChipComposable (ChipView.kt:75)");
        }
        boolean selected = chipProps.getSelected();
        composer.startReplaceGroup(1444845765);
        ComposerKt.sourceInformation(composer, "81@2735L83");
        ComposableLambda composableLambdaRememberComposableLambda = chipProps.getSelected() ? ComposableLambdaKt.rememberComposableLambda(-1679095273, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.ChipViewKt$ChipContent$FilterChipComposable$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                ComposerKt.sourceInformation(composer2, "C82@2747L61:ChipView.kt#v15e7d");
                if ((i2 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1679095273, i2, -1, "expo.modules.ui.ChipContent.FilterChipComposable.<anonymous> (ChipView.kt:82)");
                }
                ChipViewKt.m14624ChipIconcf5BqRc("filled.Done", chipProps.getIconSize(), 0L, null, composer2, 6, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54) : null;
        composer.endReplaceGroup();
        boolean enabled = chipProps.getEnabled();
        SelectableChipColors selectableChipColorsFilterChipColors = FilterChipDefaults.INSTANCE.filterChipColors(composer, FilterChipDefaults.$stable);
        BorderStroke borderStrokeM3365filterChipBorder_7El2pE = FilterChipDefaults.INSTANCE.m3365filterChipBorder_7El2pE(chipProps.getEnabled(), chipProps.getSelected(), 0L, 0L, 0L, 0L, 0.0f, 0.0f, composer, FilterChipDefaults.$stable << 24, 252);
        composer.startReplaceGroup(5004770);
        ComposerKt.sourceInformation(composer, "CC(remember):ChipView.kt#9igjgp");
        boolean zChanged = composer.changed(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: expo.modules.ui.ChipViewKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ChipViewKt.ChipContent$FilterChipComposable$lambda$3$lambda$2(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceGroup();
        ChipKt.m2976FilterChipQi0uq5o(selected, (Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(1642428989, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.ChipViewKt$ChipContent$FilterChipComposable$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                ComposerKt.sourceInformation(composer2, "C78@2590L58:ChipView.kt#v15e7d");
                if ((i2 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1642428989, i2, -1, "expo.modules.ui.ChipContent.FilterChipComposable.<anonymous> (ChipView.kt:78)");
                }
                ChipViewKt.ChipText(chipProps.getLabel(), chipProps.getTextStyle(), composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), modifier, enabled, composableLambdaRememberComposableLambda, ComposableLambdaKt.rememberComposableLambda(-1511994695, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.ChipViewKt$ChipContent$FilterChipComposable$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                ComposerKt.sourceInformation(composer2, "C*89@2923L50:ChipView.kt#v15e7d");
                if ((i2 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1511994695, i2, -1, "expo.modules.ui.ChipContent.FilterChipComposable.<anonymous> (ChipView.kt:88)");
                }
                String trailingIcon = chipProps.getTrailingIcon();
                if (trailingIcon != null) {
                    ChipViewKt.m14624ChipIconcf5BqRc(trailingIcon, chipProps.getIconSize(), 0L, null, composer2, 0, 12);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), null, selectableChipColorsFilterChipColors, null, borderStrokeM3365filterChipBorder_7El2pE, 0.0f, null, null, composer, 1576320, 0, 14976);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    private static final void ChipContent$InputChipComposable(final ChipProps chipProps, final Function1<? super ChipPressedEvent, Unit> function1, Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(1632887814);
        ComposerKt.sourceInformation(composer, "C(InputChipComposable)103@3329L33,104@3378L62,107@3521L113,112@3657L132,102@3302L524:ChipView.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1632887814, i, -1, "expo.modules.ui.ChipContent.InputChipComposable (ChipView.kt:100)");
        }
        if (!chipProps.getEnabled()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return;
        }
        boolean enabled = chipProps.getEnabled();
        boolean selected = chipProps.getSelected();
        composer.startReplaceGroup(5004770);
        ComposerKt.sourceInformation(composer, "CC(remember):ChipView.kt#9igjgp");
        boolean zChanged = composer.changed(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: expo.modules.ui.ChipViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ChipViewKt.ChipContent$InputChipComposable$lambda$5$lambda$4(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceGroup();
        ChipKt.InputChip(selected, (Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(1626930383, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.ChipViewKt$ChipContent$InputChipComposable$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                ComposerKt.sourceInformation(composer2, "C104@3380L58:ChipView.kt#v15e7d");
                if ((i2 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1626930383, i2, -1, "expo.modules.ui.ChipContent.InputChipComposable.<anonymous> (ChipView.kt:104)");
                }
                ChipViewKt.ChipText(chipProps.getLabel(), chipProps.getTextStyle(), composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), modifier, enabled, null, ComposableLambdaKt.rememberComposableLambda(54934603, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.ChipViewKt$ChipContent$InputChipComposable$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                ComposerKt.sourceInformation(composer2, "C*109@3566L50:ChipView.kt#v15e7d");
                if ((i2 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(54934603, i2, -1, "expo.modules.ui.ChipContent.InputChipComposable.<anonymous> (ChipView.kt:108)");
                }
                String leadingIcon = chipProps.getLeadingIcon();
                if (leadingIcon != null) {
                    ChipViewKt.m14624ChipIconcf5BqRc(leadingIcon, chipProps.getIconSize(), 0L, null, composer2, 0, 12);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), ComposableLambdaKt.rememberComposableLambda(-338064342, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.ChipViewKt$ChipContent$InputChipComposable$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                ComposerKt.sourceInformation(composer2, "C113@3667L114:ChipView.kt#v15e7d");
                if ((i2 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-338064342, i2, -1, "expo.modules.ui.ChipContent.InputChipComposable.<anonymous> (ChipView.kt:113)");
                }
                String trailingIcon = chipProps.getTrailingIcon();
                if (trailingIcon == null) {
                    trailingIcon = "filled.Close";
                }
                ChipViewKt.m14624ChipIconcf5BqRc(trailingIcon, chipProps.getIconSize(), 0L, null, composer2, 0, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), null, null, null, null, null, composer, 14159232, 0, 7968);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChipContent$InputChipComposable$lambda$5$lambda$4(Function1 function1) {
        function1.invoke(new ChipPressedEvent());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChipContent$SuggestionChipComposable$lambda$7$lambda$6(Function1 function1) {
        function1.invoke(new ChipPressedEvent());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:30:0x0059  */
    /* JADX WARN: Code duplicated, block: B:32:0x005d  */
    /* JADX WARN: Code duplicated, block: B:33:0x005f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:42:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:47:0x0116  */
    /* JADX WARN: Code duplicated, block: B:50:0x0120  */
    /* JADX WARN: Code duplicated, block: B:51:0x013c  */
    /* JADX WARN: Code duplicated, block: B:54:0x0146  */
    /* JADX WARN: Code duplicated, block: B:55:0x0162  */
    /* JADX WARN: Code duplicated, block: B:58:0x016c  */
    /* JADX WARN: Code duplicated, block: B:59:0x0188  */
    /* JADX WARN: Code duplicated, block: B:62:0x0191  */
    /* JADX WARN: Code duplicated, block: B:63:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:66:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:70:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:71:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:74:0x0267  */
    /* JADX WARN: Code duplicated, block: B:78:0x0272  */
    /* JADX WARN: Code duplicated, block: B:80:? A[RETURN, SYNTHETIC] */
    public static final void ChipText(final String str, String str2, Composer composer, final int i, final int i2) {
        int i3;
        final String str3;
        String str4;
        Function0<ComposeUiNode> constructor;
        TextStyle labelSmall;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-252127173);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ChipText)147@4524L577:ChipView.kt#v15e7d");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = i | (composerStartRestartGroup.changed(str) ? 4 : 2);
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                str3 = str2;
                i3 |= composerStartRestartGroup.changed(str3) ? 32 : 16;
            }
            if ((i3 & 19) == 18 || !composerStartRestartGroup.getSkipping()) {
                if (i4 != 0) {
                    str4 = "labelSmall";
                } else {
                    str4 = str3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-252127173, i3, -1, "expo.modules.ui.ChipText (ChipView.kt:146)");
                }
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1491918232, "C150@4579L518:ChipView.kt#v15e7d");
                switch (str4) {
                    case "labelLarge":
                        composerStartRestartGroup.startReplaceGroup(1752995775);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "155@4798L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelLarge();
                        composerStartRestartGroup.endReplaceGroup();
                        break;
                    case "labelSmall":
                        composerStartRestartGroup.startReplaceGroup(1752991871);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "153@4676L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall();
                        composerStartRestartGroup.endReplaceGroup();
                        break;
                    case "bodyMedium":
                        composerStartRestartGroup.startReplaceGroup(1752999551);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "157@4916L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                        composerStartRestartGroup.endReplaceGroup();
                        break;
                    case "labelMedium":
                        composerStartRestartGroup.startReplaceGroup(1752993824);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "154@4737L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelMedium();
                        composerStartRestartGroup.endReplaceGroup();
                        break;
                    case "bodyLarge":
                        composerStartRestartGroup.startReplaceGroup(1753001438);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "158@4975L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
                        composerStartRestartGroup.endReplaceGroup();
                        break;
                    case "bodySmall":
                        composerStartRestartGroup.startReplaceGroup(1752997662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "156@4857L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall();
                        composerStartRestartGroup.endReplaceGroup();
                        break;
                    default:
                        composerStartRestartGroup.startReplaceGroup(1753003071);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "159@5026L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall();
                        composerStartRestartGroup.endReplaceGroup();
                        break;
                }
                composer2 = composerStartRestartGroup;
                String str5 = str4;
                TextKt.m4494TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, labelSmall, composer2, i3 & 14, 0, 130046);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str3 = str5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                composer2 = composerStartRestartGroup;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ChipViewKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChipViewKt.ChipText$lambda$10(str, str3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        str3 = str2;
        if ((i3 & 19) == 18) {
            if (i4 != 0) {
                str4 = "labelSmall";
            } else {
                str4 = str3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-252127173, i3, -1, "expo.modules.ui.ChipText (ChipView.kt:146)");
            }
            Alignment center2 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1491918232, "C150@4579L518:ChipView.kt#v15e7d");
            switch (str4) {
                case -1667595097:
                    if (!str4.equals("labelLarge")) {
                        composerStartRestartGroup.startReplaceGroup(1752995775);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "155@4798L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelLarge();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1753003071);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "159@5026L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    break;
                case -1660789133:
                    if (!str4.equals("labelSmall")) {
                        composerStartRestartGroup.startReplaceGroup(1752991871);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "153@4676L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1753003071);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "159@5026L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    break;
                case -340495433:
                    if (!str4.equals("bodyMedium")) {
                        composerStartRestartGroup.startReplaceGroup(1752999551);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "157@4916L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1753003071);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "159@5026L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    break;
                case -123931767:
                    if (!str4.equals("labelMedium")) {
                        composerStartRestartGroup.startReplaceGroup(1752993824);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "154@4737L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelMedium();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1753003071);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "159@5026L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    break;
                case 1234912953:
                    if (!str4.equals("bodyLarge")) {
                        composerStartRestartGroup.startReplaceGroup(1753001438);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "158@4975L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1753003071);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "159@5026L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    break;
                case 1241718917:
                    if (!str4.equals("bodySmall")) {
                        composerStartRestartGroup.startReplaceGroup(1752997662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "156@4857L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1753003071);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "159@5026L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    break;
                default:
                    composerStartRestartGroup.startReplaceGroup(1753003071);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "159@5026L10");
                    labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall();
                    composerStartRestartGroup.endReplaceGroup();
                    break;
            }
            composer2 = composerStartRestartGroup;
            String str6 = str4;
            TextKt.m4494TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, labelSmall, composer2, i3 & 14, 0, 130046);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str3 = str6;
        } else {
            if (i4 != 0) {
                str4 = "labelSmall";
            } else {
                str4 = str3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-252127173, i3, -1, "expo.modules.ui.ChipText (ChipView.kt:146)");
            }
            Alignment center3 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1491918232, "C150@4579L518:ChipView.kt#v15e7d");
            switch (str4) {
                case -1667595097:
                    if (!str4.equals("labelLarge")) {
                        composerStartRestartGroup.startReplaceGroup(1752995775);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "155@4798L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelLarge();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1753003071);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "159@5026L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    break;
                case -1660789133:
                    if (!str4.equals("labelSmall")) {
                        composerStartRestartGroup.startReplaceGroup(1752991871);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "153@4676L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1753003071);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "159@5026L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    break;
                case -340495433:
                    if (!str4.equals("bodyMedium")) {
                        composerStartRestartGroup.startReplaceGroup(1752999551);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "157@4916L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1753003071);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "159@5026L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    break;
                case -123931767:
                    if (!str4.equals("labelMedium")) {
                        composerStartRestartGroup.startReplaceGroup(1752993824);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "154@4737L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelMedium();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1753003071);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "159@5026L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    break;
                case 1234912953:
                    if (!str4.equals("bodyLarge")) {
                        composerStartRestartGroup.startReplaceGroup(1753001438);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "158@4975L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1753003071);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "159@5026L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    break;
                case 1241718917:
                    if (!str4.equals("bodySmall")) {
                        composerStartRestartGroup.startReplaceGroup(1752997662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "156@4857L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1753003071);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "159@5026L10");
                        labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    break;
                default:
                    composerStartRestartGroup.startReplaceGroup(1753003071);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "159@5026L10");
                    labelSmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall();
                    composerStartRestartGroup.endReplaceGroup();
                    break;
            }
            composer2 = composerStartRestartGroup;
            String str7 = str4;
            TextKt.m4494TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, labelSmall, composer2, i3 & 14, 0, 130046);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str3 = str7;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ChipViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipViewKt.ChipText$lambda$10(str, str3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x004c  */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:33:0x005f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x0068  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0074  */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:51:0x0092  */
    /* JADX WARN: Code duplicated, block: B:53:0x009e  */
    /* JADX WARN: Code duplicated, block: B:60:0x00af A[PHI: r1 r3 r9
      0x00af: PHI (r1v19 int) = (r1v16 int), (r1v20 int) binds: [B:68:0x00ca, B:59:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      0x00af: PHI (r3v6 int) = (r3v2 int), (r3v8 int) binds: [B:68:0x00ca, B:59:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      0x00af: PHI (r9v7 long) = (r9v2 long), (r9v1 long) binds: [B:68:0x00ca, B:59:0x00ae] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:62:0x00b2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00da  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:79:0x010f  */
    /* JADX WARN: Code duplicated, block: B:83:0x011b  */
    /* JADX WARN: Code duplicated, block: B:85:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: ChipIcon-cf5BqRc, reason: not valid java name */
    public static final void m14624ChipIconcf5BqRc(final String str, int i, long j, Modifier modifier, Composer composer, final int i2, final int i3) {
        String str2;
        int i4;
        int i5;
        long primary;
        int i6;
        Modifier modifier2;
        int i7;
        int i8;
        Modifier.Companion companion;
        long j2;
        ImageVector imageVector;
        final int i9;
        final Modifier modifier3;
        final long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1597994477);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ChipIcon)P(!2,3:c#ui.graphics.Color)*174@5321L182:ChipView.kt#v15e7d");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
            str2 = str;
        } else {
            str2 = str;
            if ((i2 & 6) == 0) {
                i4 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
        }
        int i11 = i3 & 2;
        if (i11 == 0) {
            if ((i2 & 48) == 0) {
                i5 = i;
                i4 |= composerStartRestartGroup.changed(i5) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                primary = j;
                if ((i3 & 4) == 0 || !composerStartRestartGroup.changed(primary)) {
                    i10 = 128;
                } else {
                    i10 = 256;
                }
                i4 |= i10;
            } else {
                primary = j;
            }
            i6 = i3 & 8;
            if (i6 != 0) {
                if ((i2 & 3072) == 0) {
                    modifier2 = modifier;
                    if (composerStartRestartGroup.changed(modifier2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i4 |= i7;
                }
                if ((i4 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "170@5211L11");
                    if ((i2 & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                        }
                        i8 = i5;
                    } else {
                        if (i11 != 0) {
                            i8 = 18;
                        } else {
                            i8 = i5;
                        }
                        if ((i3 & 4) != 0) {
                            primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                            i4 &= -897;
                        }
                        if (i6 != 0) {
                            companion = Modifier.INSTANCE;
                        }
                        j2 = primary;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1597994477, i4, -1, "expo.modules.ui.ChipIcon (ChipView.kt:172)");
                        }
                        imageVector = UtilsKt.getImageVector(str2);
                        if (imageVector != null) {
                            IconKt.m3576Iconww6aTOc(imageVector, str2, PaddingKt.m1222paddingqDBjuR0$default(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(i8)), 0.0f, 0.0f, Dp.m9687constructorimpl(4), 0.0f, 11, null), j2, composerStartRestartGroup, (i4 << 3) & 7280, 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i9 = i8;
                        modifier3 = companion;
                        j3 = j2;
                    }
                    companion = modifier2;
                    j2 = primary;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1597994477, i4, -1, "expo.modules.ui.ChipIcon (ChipView.kt:172)");
                    }
                    imageVector = UtilsKt.getImageVector(str2);
                    if (imageVector != null) {
                        IconKt.m3576Iconww6aTOc(imageVector, str2, PaddingKt.m1222paddingqDBjuR0$default(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(i8)), 0.0f, 0.0f, Dp.m9687constructorimpl(4), 0.0f, 11, null), j2, composerStartRestartGroup, (i4 << 3) & 7280, 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i9 = i8;
                    modifier3 = companion;
                    j3 = j2;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    i9 = i5;
                    modifier3 = modifier2;
                    j3 = primary;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ChipViewKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipViewKt.ChipIcon_cf5BqRc$lambda$12(str, i9, j3, modifier3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            modifier2 = modifier;
            if ((i4 & 1171) == 1170) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "170@5211L11");
                if ((i2 & 1) == 0) {
                    if (i11 != 0) {
                        i8 = 18;
                    } else {
                        i8 = i5;
                    }
                    if ((i3 & 4) != 0) {
                        primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                        i4 &= -897;
                    }
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                } else {
                    if (i11 != 0) {
                        i8 = 18;
                    } else {
                        i8 = i5;
                    }
                    if ((i3 & 4) != 0) {
                        primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                        i4 &= -897;
                    }
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                }
                j2 = primary;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1597994477, i4, -1, "expo.modules.ui.ChipIcon (ChipView.kt:172)");
                }
                imageVector = UtilsKt.getImageVector(str2);
                if (imageVector != null) {
                    IconKt.m3576Iconww6aTOc(imageVector, str2, PaddingKt.m1222paddingqDBjuR0$default(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(i8)), 0.0f, 0.0f, Dp.m9687constructorimpl(4), 0.0f, 11, null), j2, composerStartRestartGroup, (i4 << 3) & 7280, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i9 = i8;
                modifier3 = companion;
                j3 = j2;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "170@5211L11");
                if ((i2 & 1) == 0) {
                    if (i11 != 0) {
                        i8 = 18;
                    } else {
                        i8 = i5;
                    }
                    if ((i3 & 4) != 0) {
                        primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                        i4 &= -897;
                    }
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                } else {
                    if (i11 != 0) {
                        i8 = 18;
                    } else {
                        i8 = i5;
                    }
                    if ((i3 & 4) != 0) {
                        primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                        i4 &= -897;
                    }
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                }
                j2 = primary;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1597994477, i4, -1, "expo.modules.ui.ChipIcon (ChipView.kt:172)");
                }
                imageVector = UtilsKt.getImageVector(str2);
                if (imageVector != null) {
                    IconKt.m3576Iconww6aTOc(imageVector, str2, PaddingKt.m1222paddingqDBjuR0$default(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(i8)), 0.0f, 0.0f, Dp.m9687constructorimpl(4), 0.0f, 11, null), j2, composerStartRestartGroup, (i4 << 3) & 7280, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i9 = i8;
                modifier3 = companion;
                j3 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ChipViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChipViewKt.ChipIcon_cf5BqRc$lambda$12(str, i9, j3, modifier3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        i5 = i;
        if ((i2 & 384) == 0) {
            primary = j;
            if ((i3 & 4) == 0) {
                i10 = 128;
            } else {
                i10 = 128;
            }
            i4 |= i10;
        } else {
            primary = j;
        }
        i6 = i3 & 8;
        if (i6 != 0) {
            if ((i2 & 3072) == 0) {
                modifier2 = modifier;
                if (composerStartRestartGroup.changed(modifier2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i4 |= i7;
            }
            if ((i4 & 1171) == 1170) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "170@5211L11");
                if ((i2 & 1) == 0) {
                    if (i11 != 0) {
                        i8 = 18;
                    } else {
                        i8 = i5;
                    }
                    if ((i3 & 4) != 0) {
                        primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                        i4 &= -897;
                    }
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                } else {
                    if (i11 != 0) {
                        i8 = 18;
                    } else {
                        i8 = i5;
                    }
                    if ((i3 & 4) != 0) {
                        primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                        i4 &= -897;
                    }
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                }
                j2 = primary;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1597994477, i4, -1, "expo.modules.ui.ChipIcon (ChipView.kt:172)");
                }
                imageVector = UtilsKt.getImageVector(str2);
                if (imageVector != null) {
                    IconKt.m3576Iconww6aTOc(imageVector, str2, PaddingKt.m1222paddingqDBjuR0$default(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(i8)), 0.0f, 0.0f, Dp.m9687constructorimpl(4), 0.0f, 11, null), j2, composerStartRestartGroup, (i4 << 3) & 7280, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i9 = i8;
                modifier3 = companion;
                j3 = j2;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "170@5211L11");
                if ((i2 & 1) == 0) {
                    if (i11 != 0) {
                        i8 = 18;
                    } else {
                        i8 = i5;
                    }
                    if ((i3 & 4) != 0) {
                        primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                        i4 &= -897;
                    }
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                } else {
                    if (i11 != 0) {
                        i8 = 18;
                    } else {
                        i8 = i5;
                    }
                    if ((i3 & 4) != 0) {
                        primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                        i4 &= -897;
                    }
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                }
                j2 = primary;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1597994477, i4, -1, "expo.modules.ui.ChipIcon (ChipView.kt:172)");
                }
                imageVector = UtilsKt.getImageVector(str2);
                if (imageVector != null) {
                    IconKt.m3576Iconww6aTOc(imageVector, str2, PaddingKt.m1222paddingqDBjuR0$default(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(i8)), 0.0f, 0.0f, Dp.m9687constructorimpl(4), 0.0f, 11, null), j2, composerStartRestartGroup, (i4 << 3) & 7280, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i9 = i8;
                modifier3 = companion;
                j3 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ChipViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChipViewKt.ChipIcon_cf5BqRc$lambda$12(str, i9, j3, modifier3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        modifier2 = modifier;
        if ((i4 & 1171) == 1170) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "170@5211L11");
            if ((i2 & 1) == 0) {
                if (i11 != 0) {
                    i8 = 18;
                } else {
                    i8 = i5;
                }
                if ((i3 & 4) != 0) {
                    primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    i4 &= -897;
                }
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
            } else {
                if (i11 != 0) {
                    i8 = 18;
                } else {
                    i8 = i5;
                }
                if ((i3 & 4) != 0) {
                    primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    i4 &= -897;
                }
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
            }
            j2 = primary;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1597994477, i4, -1, "expo.modules.ui.ChipIcon (ChipView.kt:172)");
            }
            imageVector = UtilsKt.getImageVector(str2);
            if (imageVector != null) {
                IconKt.m3576Iconww6aTOc(imageVector, str2, PaddingKt.m1222paddingqDBjuR0$default(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(i8)), 0.0f, 0.0f, Dp.m9687constructorimpl(4), 0.0f, 11, null), j2, composerStartRestartGroup, (i4 << 3) & 7280, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            i9 = i8;
            modifier3 = companion;
            j3 = j2;
        } else {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "170@5211L11");
            if ((i2 & 1) == 0) {
                if (i11 != 0) {
                    i8 = 18;
                } else {
                    i8 = i5;
                }
                if ((i3 & 4) != 0) {
                    primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    i4 &= -897;
                }
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
            } else {
                if (i11 != 0) {
                    i8 = 18;
                } else {
                    i8 = i5;
                }
                if ((i3 & 4) != 0) {
                    primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    i4 &= -897;
                }
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
            }
            j2 = primary;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1597994477, i4, -1, "expo.modules.ui.ChipIcon (ChipView.kt:172)");
            }
            imageVector = UtilsKt.getImageVector(str2);
            if (imageVector != null) {
                IconKt.m3576Iconww6aTOc(imageVector, str2, PaddingKt.m1222paddingqDBjuR0$default(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(i8)), 0.0f, 0.0f, Dp.m9687constructorimpl(4), 0.0f, 11, null), j2, composerStartRestartGroup, (i4 << 3) & 7280, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            i9 = i8;
            modifier3 = companion;
            j3 = j2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ChipViewKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipViewKt.ChipIcon_cf5BqRc$lambda$12(str, i9, j3, modifier3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ChipContent$SuggestionChipComposable(final Function1<? super ChipPressedEvent, Unit> function1, Modifier modifier, final ChipProps chipProps, Composer composer, int i) {
        composer.startReplaceGroup(743730396);
        ComposerKt.sourceInformation(composer, "C(SuggestionChipComposable)125@3917L31,126@3964L62,127@4041L113,124@3885L306:ChipView.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(743730396, i, -1, "expo.modules.ui.ChipContent.SuggestionChipComposable (ChipView.kt:123)");
        }
        composer.startReplaceGroup(5004770);
        ComposerKt.sourceInformation(composer, "CC(remember):ChipView.kt#9igjgp");
        boolean zChanged = composer.changed(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: expo.modules.ui.ChipViewKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ChipViewKt.ChipContent$SuggestionChipComposable$lambda$7$lambda$6(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceGroup();
        ChipKt.SuggestionChip((Function0<Unit>) objRememberedValue, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(47786782, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.ChipViewKt$ChipContent$SuggestionChipComposable$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                ComposerKt.sourceInformation(composer2, "C126@3966L58:ChipView.kt#v15e7d");
                if ((i2 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(47786782, i2, -1, "expo.modules.ui.ChipContent.SuggestionChipComposable.<anonymous> (ChipView.kt:126)");
                }
                ChipViewKt.ChipText(chipProps.getLabel(), chipProps.getTextStyle(), composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), modifier, false, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(2088106619, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.ChipViewKt$ChipContent$SuggestionChipComposable$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                ComposerKt.sourceInformation(composer2, "C*129@4086L50:ChipView.kt#v15e7d");
                if ((i2 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2088106619, i2, -1, "expo.modules.ui.ChipContent.SuggestionChipComposable.<anonymous> (ChipView.kt:128)");
                }
                String leadingIcon = chipProps.getLeadingIcon();
                if (leadingIcon != null) {
                    ChipViewKt.m14624ChipIconcf5BqRc(leadingIcon, chipProps.getIconSize(), 0L, null, composer2, 0, 12);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), (Shape) null, (ChipColors) null, (ChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, composer, 25008, 1000);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }
}
