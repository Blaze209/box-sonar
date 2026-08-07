package expo.modules.ui;

import android.graphics.Color;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.profileinstaller.ProfileVerifier;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeViewKt;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"CardContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/CardProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/CardProps;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CardViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CardContent$lambda$0(FunctionalComposableScope functionalComposableScope, CardProps cardProps, int i, Composer composer, int i2) {
        CardContent(functionalComposableScope, cardProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void CardContent(final FunctionalComposableScope functionalComposableScope, final CardProps props, Composer composer, final int i) {
        int i2;
        CardColors cardColors;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1121341611);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CardContent)30@1038L83,43@1638L84:CardView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1121341611, i2, -1, "expo.modules.ui.CardContent (CardView.kt:29)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | (ComposableScope.$stable << 6));
            if (props.getElementColors() != null) {
                composerStartRestartGroup.startReplaceGroup(427511789);
                ComposerKt.sourceInformation(composerStartRestartGroup, "33@1193L248");
                CardDefaults cardDefaults = CardDefaults.INSTANCE;
                Color containerColor = props.getElementColors().getContainerColor();
                long compose = containerColor != null ? UtilsKt.getCompose(containerColor) : androidx.compose.ui.graphics.Color.INSTANCE.m6850getUnspecified0d7_KjU();
                Color contentColor = props.getElementColors().getContentColor();
                cardColors = cardDefaults.m2903cardColorsro_MJ88(compose, contentColor != null ? UtilsKt.getCompose(contentColor) : androidx.compose.ui.graphics.Color.INSTANCE.m6850getUnspecified0d7_KjU(), 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 12);
                composerStartRestartGroup.endReplaceGroup();
            } else if (props.getColor() != null) {
                composerStartRestartGroup.startReplaceGroup(427520849);
                ComposerKt.sourceInformation(composerStartRestartGroup, "37@1482L60");
                cardColors = CardDefaults.INSTANCE.m2903cardColorsro_MJ88(UtilsKt.getCompose(props.getColor()), 0L, 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 14);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(427523553);
                ComposerKt.sourceInformation(composerStartRestartGroup, "40@1568L12");
                cardColors = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, CardDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            }
            CardColors cardColors2 = cardColors;
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1403231718, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: expo.modules.ui.CardViewKt$CardContent$content$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                    invoke(columnScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope columnScope, Composer composer2, int i3) {
                    Intrinsics.checkNotNullParameter(columnScope, "<this>");
                    ComposerKt.sourceInformation(composer2, "C45@1703L15:CardView.kt#v15e7d");
                    if ((i3 & 6) == 0) {
                        i3 |= composer2.changed(columnScope) ? 4 : 2;
                    }
                    if ((i3 & 19) == 18 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1403231718, i3, -1, "expo.modules.ui.CardContent.<anonymous> (CardView.kt:44)");
                    }
                    functionalComposableScope.Children(ExpoComposeViewKt.with(new ComposableScope(null, null, null, null, 15, null), columnScope), composer2, ComposableScope.$stable | (FunctionalComposableScope.$stable << 3));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54);
            String variant = props.getVariant();
            if (Intrinsics.areEqual(variant, "elevated")) {
                composerStartRestartGroup.startReplaceGroup(368528858);
                ComposerKt.sourceInformation(composerStartRestartGroup, "50@1775L101");
                CardKt.ElevatedCard(modifierApplyModifiers, null, cardColors2, null, composableLambdaRememberComposableLambda, composerStartRestartGroup, 24576, 10);
                composerStartRestartGroup.endReplaceGroup();
            } else if (Intrinsics.areEqual(variant, "outlined")) {
                composerStartRestartGroup.startReplaceGroup(368661786);
                ComposerKt.sourceInformation(composerStartRestartGroup, "57@1909L101");
                CardKt.OutlinedCard(modifierApplyModifiers, null, cardColors2, null, null, composableLambdaRememberComposableLambda, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 26);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(368788514);
                ComposerKt.sourceInformation(composerStartRestartGroup, "64@2037L93");
                CardKt.Card(modifierApplyModifiers, null, cardColors2, null, null, composableLambdaRememberComposableLambda, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 26);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.CardViewKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardViewKt.CardContent$lambda$0(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
