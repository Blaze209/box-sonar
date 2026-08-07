package expo.modules.ui;

import android.graphics.Color;
import androidx.compose.material3.ProgressIndicatorDefaults;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.WavyProgressIndicatorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProgressView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"ProgressContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/ProgressProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/ProgressProps;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ProgressViewKt {

    /* JADX INFO: compiled from: ProgressView.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProgressVariant.values().length];
            try {
                iArr[ProgressVariant.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProgressVariant.CIRCULAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProgressVariant.LINEAR_WAVY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProgressVariant.CIRCULAR_WAVY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProgressContent$lambda$10(FunctionalComposableScope functionalComposableScope, ProgressProps progressProps, int i, Composer composer, int i2) {
        ProgressContent(functionalComposableScope, progressProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ProgressContent(final FunctionalComposableScope functionalComposableScope, final ProgressProps props, Composer composer, final int i) {
        int i2;
        long jM6824unboximpl;
        long jM6824unboximpl2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(1591927070);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ProgressContent)43@1476L83:ProgressView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
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
                ComposerKt.traceEventStart(1591927070, i2, -1, "expo.modules.ui.ProgressContent (ProgressView.kt:39)");
            }
            final Float progress = props.getProgress();
            Color color = props.getColor();
            ProgressColors elementColors = props.getElementColors();
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | (ComposableScope.$stable << 6));
            int i3 = WhenMappings.$EnumSwitchMapping$0[props.getVariant().ordinal()];
            if (i3 == 1) {
                composerStartRestartGroup.startReplaceGroup(70824624);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                androidx.compose.ui.graphics.Color composeOrNull = UtilsKt.getComposeOrNull(color);
                composerStartRestartGroup.startReplaceGroup(833568986);
                ComposerKt.sourceInformation(composerStartRestartGroup, "47@1692L11");
                if (composeOrNull == null) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    jM6824unboximpl = ProgressIndicatorDefaults.INSTANCE.getLinearColor(composerStartRestartGroup, ProgressIndicatorDefaults.$stable);
                } else {
                    composerStartRestartGroup = composerStartRestartGroup;
                    jM6824unboximpl = composeOrNull.m6824unboximpl();
                }
                composerStartRestartGroup.endReplaceGroup();
                androidx.compose.ui.graphics.Color composeOrNull2 = UtilsKt.getComposeOrNull(elementColors.getTrackColor());
                composerStartRestartGroup.startReplaceGroup(833571691);
                ComposerKt.sourceInformation(composerStartRestartGroup, "48@1788L16");
                long linearTrackColor = composeOrNull2 == null ? ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(composerStartRestartGroup, ProgressIndicatorDefaults.$stable) : composeOrNull2.m6824unboximpl();
                composerStartRestartGroup.endReplaceGroup();
                if (progress != null) {
                    composerStartRestartGroup.startReplaceGroup(71028170);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "51@1889L12,54@2000L2,50@1843L200");
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ProgressView.kt#9igjgp");
                    boolean zChanged = composerStartRestartGroup.changed(progress);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: expo.modules.ui.ProgressViewKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(progress.floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(1849434622);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ProgressView.kt#9igjgp");
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: expo.modules.ui.ProgressViewKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ProgressViewKt.ProgressContent$lambda$3$lambda$2((DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ProgressIndicatorKt.m4001LinearProgressIndicatorGJbTh5U(function0, modifierApplyModifiers, jM6824unboximpl, linearTrackColor, 0, 0.0f, (Function1) objRememberedValue2, composerStartRestartGroup, 1572864, 48);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(71248239);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "58@2067L131");
                    ProgressIndicatorKt.m4006LinearProgressIndicatorrIrjwxo(modifierApplyModifiers, jM6824unboximpl, linearTrackColor, 0, 0.0f, composerStartRestartGroup, 0, 24);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            } else if (i3 == 2) {
                composerStartRestartGroup.startReplaceGroup(71449615);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                androidx.compose.ui.graphics.Color composeOrNull3 = UtilsKt.getComposeOrNull(color);
                composerStartRestartGroup.startReplaceGroup(833589116);
                ComposerKt.sourceInformation(composerStartRestartGroup, "66@2321L13");
                if (composeOrNull3 == null) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    jM6824unboximpl2 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(composerStartRestartGroup, ProgressIndicatorDefaults.$stable);
                } else {
                    composerStartRestartGroup = composerStartRestartGroup;
                    jM6824unboximpl2 = composeOrNull3.m6824unboximpl();
                }
                composerStartRestartGroup.endReplaceGroup();
                if (progress != null) {
                    composerStartRestartGroup.startReplaceGroup(71555418);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "69@2421L12,68@2373L248");
                    androidx.compose.ui.graphics.Color composeOrNull4 = UtilsKt.getComposeOrNull(elementColors.getTrackColor());
                    composerStartRestartGroup.startReplaceGroup(833596120);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "71@2551L29");
                    long circularDeterminateTrackColor = composeOrNull4 == null ? ProgressIndicatorDefaults.INSTANCE.getCircularDeterminateTrackColor(composerStartRestartGroup, ProgressIndicatorDefaults.$stable) : composeOrNull4.m6824unboximpl();
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ProgressView.kt#9igjgp");
                    boolean zChanged2 = composerStartRestartGroup.changed(progress);
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: expo.modules.ui.ProgressViewKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(progress.floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ProgressIndicatorKt.m3996CircularProgressIndicatorIyT6zlY((Function0) objRememberedValue3, modifierApplyModifiers, jM6824unboximpl2, 0.0f, circularDeterminateTrackColor, 0, 0.0f, composerStartRestartGroup, 0, 104);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    long j = jM6824unboximpl2;
                    composerStartRestartGroup.startReplaceGroup(71824219);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "75@2645L215");
                    androidx.compose.ui.graphics.Color composeOrNull5 = UtilsKt.getComposeOrNull(elementColors.getTrackColor());
                    composerStartRestartGroup.startReplaceGroup(833603706);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@2788L31");
                    long circularIndeterminateTrackColor = composeOrNull5 == null ? ProgressIndicatorDefaults.INSTANCE.getCircularIndeterminateTrackColor(composerStartRestartGroup, ProgressIndicatorDefaults.$stable) : composeOrNull5.m6824unboximpl();
                    composerStartRestartGroup.endReplaceGroup();
                    ProgressIndicatorKt.m3993CircularProgressIndicator4lLiAd8(modifierApplyModifiers, j, 0.0f, circularIndeterminateTrackColor, 0, 0.0f, composerStartRestartGroup, 0, 52);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            } else if (i3 == 3) {
                composerStartRestartGroup.startReplaceGroup(72107466);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                androidx.compose.ui.graphics.Color composeOrNull6 = UtilsKt.getComposeOrNull(color);
                composerStartRestartGroup.startReplaceGroup(833610394);
                ComposerKt.sourceInformation(composerStartRestartGroup, "83@2986L11");
                long linearColor = composeOrNull6 == null ? ProgressIndicatorDefaults.INSTANCE.getLinearColor(composerStartRestartGroup, ProgressIndicatorDefaults.$stable) : composeOrNull6.m6824unboximpl();
                composerStartRestartGroup.endReplaceGroup();
                androidx.compose.ui.graphics.Color composeOrNull7 = UtilsKt.getComposeOrNull(elementColors.getTrackColor());
                composerStartRestartGroup.startReplaceGroup(833613099);
                ComposerKt.sourceInformation(composerStartRestartGroup, "84@3082L16");
                long linearTrackColor2 = composeOrNull7 == null ? ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(composerStartRestartGroup, ProgressIndicatorDefaults.$stable) : composeOrNull7.m6824unboximpl();
                composerStartRestartGroup.endReplaceGroup();
                if (progress != null) {
                    composerStartRestartGroup.startReplaceGroup(72310888);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "87@3187L12,86@3137L170");
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ProgressView.kt#9igjgp");
                    boolean zChanged3 = composerStartRestartGroup.changed(progress);
                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function0() { // from class: expo.modules.ui.ProgressViewKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(progress.floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    WavyProgressIndicatorKt.m4821LinearWavyProgressIndicator1YwxWKA((Function0) objRememberedValue4, modifierApplyModifiers, linearColor, linearTrackColor2, null, null, 0.0f, 0.0f, null, 0.0f, 0.0f, composerStartRestartGroup, 0, 0, 2032);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(72502251);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "93@3331L135");
                    WavyProgressIndicatorKt.m4822LinearWavyProgressIndicatorhvuEXSk(modifierApplyModifiers, linearColor, linearTrackColor2, null, null, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 0, 504);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (i3 != 4) {
                    composerStartRestartGroup.startReplaceGroup(833568960);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(72712617);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                androidx.compose.ui.graphics.Color composeOrNull8 = UtilsKt.getComposeOrNull(color);
                composerStartRestartGroup.startReplaceGroup(833629852);
                ComposerKt.sourceInformation(composerStartRestartGroup, "101@3594L13");
                long circularColor = composeOrNull8 == null ? ProgressIndicatorDefaults.INSTANCE.getCircularColor(composerStartRestartGroup, ProgressIndicatorDefaults.$stable) : composeOrNull8.m6824unboximpl();
                composerStartRestartGroup.endReplaceGroup();
                if (progress != null) {
                    composerStartRestartGroup.startReplaceGroup(72818358);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@3698L12,103@3646L252");
                    androidx.compose.ui.graphics.Color composeOrNull9 = UtilsKt.getComposeOrNull(elementColors.getTrackColor());
                    composerStartRestartGroup.startReplaceGroup(833636984);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "106@3828L29");
                    long circularDeterminateTrackColor2 = composeOrNull9 == null ? ProgressIndicatorDefaults.INSTANCE.getCircularDeterminateTrackColor(composerStartRestartGroup, ProgressIndicatorDefaults.$stable) : composeOrNull9.m6824unboximpl();
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ProgressView.kt#9igjgp");
                    boolean zChanged4 = composerStartRestartGroup.changed(progress);
                    Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (zChanged4 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function0() { // from class: expo.modules.ui.ProgressViewKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(progress.floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    WavyProgressIndicatorKt.m4819CircularWavyProgressIndicatorL8eD4gc((Function0) objRememberedValue5, modifierApplyModifiers, circularColor, circularDeterminateTrackColor2, null, null, 0.0f, null, 0.0f, 0.0f, composerStartRestartGroup, 0, 1008);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    long j2 = circularColor;
                    composerStartRestartGroup.startReplaceGroup(73091065);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "110@3922L217");
                    androidx.compose.ui.graphics.Color composeOrNull10 = UtilsKt.getComposeOrNull(elementColors.getTrackColor());
                    composerStartRestartGroup.startReplaceGroup(833644696);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "112@4069L29");
                    long circularDeterminateTrackColor3 = composeOrNull10 == null ? ProgressIndicatorDefaults.INSTANCE.getCircularDeterminateTrackColor(composerStartRestartGroup, ProgressIndicatorDefaults.$stable) : composeOrNull10.m6824unboximpl();
                    composerStartRestartGroup.endReplaceGroup();
                    WavyProgressIndicatorKt.m4820CircularWavyProgressIndicatorhvuEXSk(modifierApplyModifiers, j2, circularDeterminateTrackColor3, null, null, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 0, 504);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ProgressViewKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProgressViewKt.ProgressContent$lambda$10(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProgressContent$lambda$3$lambda$2(DrawScope LinearProgressIndicator) {
        Intrinsics.checkNotNullParameter(LinearProgressIndicator, "$this$LinearProgressIndicator");
        return Unit.INSTANCE;
    }
}
