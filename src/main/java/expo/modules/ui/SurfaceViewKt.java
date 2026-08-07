package expo.modules.ui;

import android.graphics.Color;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurfaceView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"SurfaceContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/SurfaceProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/SurfaceProps;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SurfaceViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SurfaceContent$lambda$0(FunctionalComposableScope functionalComposableScope, SurfaceProps surfaceProps, int i, Composer composer, int i2) {
        SurfaceContent(functionalComposableScope, surfaceProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SurfaceContent(final FunctionalComposableScope functionalComposableScope, final SurfaceProps props, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(-205465068);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SurfaceContent)22@761L83,32@1178L37,26@995L220:SurfaceView.kt#v15e7d");
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
                ComposerKt.traceEventStart(-205465068, i2, -1, "expo.modules.ui.SurfaceContent (SurfaceView.kt:21)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | (ComposableScope.$stable << 6));
            Color color = props.getColor();
            androidx.compose.ui.graphics.Color colorM6804boximpl = color != null ? androidx.compose.ui.graphics.Color.m6804boximpl(UtilsKt.getCompose(color)) : null;
            composerStartRestartGroup.startReplaceGroup(116572109);
            ComposerKt.sourceInformation(composerStartRestartGroup, "23@897L11");
            long surface = colorM6804boximpl == null ? MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface() : colorM6804boximpl.m6824unboximpl();
            composerStartRestartGroup.endReplaceGroup();
            Color contentColor = props.getContentColor();
            androidx.compose.ui.graphics.Color colorM6804boximpl2 = contentColor != null ? androidx.compose.ui.graphics.Color.m6804boximpl(UtilsKt.getCompose(contentColor)) : null;
            composerStartRestartGroup.startReplaceGroup(116574633);
            ComposerKt.sourceInformation(composerStartRestartGroup, "24@969L22");
            long jM3051contentColorForek8zF_U = colorM6804boximpl2 == null ? ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, 0) : colorM6804boximpl2.m6824unboximpl();
            composerStartRestartGroup.endReplaceGroup();
            SurfaceKt.m4323SurfaceT9BRK9s(modifierApplyModifiers, null, surface, jM3051contentColorForek8zF_U, Dp.m9687constructorimpl(props.getTonalElevation()), Dp.m9687constructorimpl(props.getShadowElevation()), null, ComposableLambdaKt.rememberComposableLambda(733738201, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.SurfaceViewKt.SurfaceContent.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C33@1184L27:SurfaceView.kt#v15e7d");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(733738201, i3, -1, "expo.modules.ui.SurfaceContent.<anonymous> (SurfaceView.kt:33)");
                    }
                    functionalComposableScope.Children(new ComposableScope(null, null, null, null, 15, null), composer2, ComposableScope.$stable | (FunctionalComposableScope.$stable << 3));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 66);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SurfaceViewKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SurfaceViewKt.SurfaceContent$lambda$0(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
