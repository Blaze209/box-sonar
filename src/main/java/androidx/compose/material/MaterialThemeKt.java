package androidx.compose.material;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MaterialTheme.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"MaterialTheme", "", "colors", "Landroidx/compose/material/Colors;", "typography", "Landroidx/compose/material/Typography;", "shapes", "Landroidx/compose/material/Shapes;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material/Colors;Landroidx/compose/material/Typography;Landroidx/compose/material/Shapes;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MaterialThemeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MaterialTheme$lambda$3(Colors colors, Typography typography, Shapes shapes, Function2 function2, int i, int i2, Composer composer, int i3) {
        MaterialTheme(colors, typography, shapes, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void MaterialTheme(Colors colors, Typography typography, Shapes shapes, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Colors colors2;
        int i3;
        final Typography typography2;
        Shapes shapes2;
        Colors colors3;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(53836214);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MaterialTheme)N(colors,typography,shapes,content)64@2936L216,71@3263L45,74@3434L4,79@3638L93,72@3313L418:MaterialTheme.kt#jmzs0o");
        if ((i & 6) == 0) {
            if ((i2 & 1) == 0) {
                colors2 = colors;
                if (composerStartRestartGroup.changed(colors2)) {
                    i4 = 4;
                }
                i3 = i4 | i;
            } else {
                colors2 = colors;
            }
            i4 = 2;
            i3 = i4 | i;
        } else {
            colors2 = colors;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                typography2 = typography;
                int i5 = composerStartRestartGroup.changed(typography2) ? 32 : 16;
                i3 |= i5;
            } else {
                typography2 = typography;
            }
            i3 |= i5;
        } else {
            typography2 = typography;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                shapes2 = shapes;
                int i6 = composerStartRestartGroup.changed(shapes2) ? 256 : 128;
                i3 |= i6;
            } else {
                shapes2 = shapes;
            }
            i3 |= i6;
        } else {
            shapes2 = shapes;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "58@2754L6,59@2805L10,60@2852L6");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    colors2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6);
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    typography2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    shapes2 = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
            }
            colors3 = colors2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(53836214, i3, -1, "androidx.compose.material.MaterialTheme (MaterialTheme.kt:62)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 197001870, "CC(remember):MaterialTheme.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = colors3.m2334copypvPzIIM((8191 & 1) != 0 ? colors3.m2342getPrimary0d7_KjU() : 0L, (8191 & 2) != 0 ? colors3.m2343getPrimaryVariant0d7_KjU() : 0L, (8191 & 4) != 0 ? colors3.m2344getSecondary0d7_KjU() : 0L, (8191 & 8) != 0 ? colors3.m2345getSecondaryVariant0d7_KjU() : 0L, (8191 & 16) != 0 ? colors3.m2335getBackground0d7_KjU() : 0L, (8191 & 32) != 0 ? colors3.m2346getSurface0d7_KjU() : 0L, (8191 & 64) != 0 ? colors3.m2336getError0d7_KjU() : 0L, (8191 & 128) != 0 ? colors3.m2339getOnPrimary0d7_KjU() : 0L, (8191 & 256) != 0 ? colors3.m2340getOnSecondary0d7_KjU() : 0L, (8191 & 512) != 0 ? colors3.m2337getOnBackground0d7_KjU() : 0L, (8191 & 1024) != 0 ? colors3.m2341getOnSurface0d7_KjU() : 0L, (8191 & 2048) != 0 ? colors3.m2338getOnError0d7_KjU() : 0L, (8191 & 4096) != 0 ? colors3.isLight() : false);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Colors colors4 = (Colors) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ColorsKt.updateColorsFrom(colors4, colors3);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ColorsKt.getLocalColors().provides(colors4), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6))), IndicationKt.getLocalIndication().provides(RippleKt.m2523rippleH2RKhps$default(false, 0.0f, 0L, 7, null)), ShapesKt.getLocalShapes().provides(shapes2), TextSelectionColorsKt.getLocalTextSelectionColors().provides(MaterialTextSelectionColorsKt.rememberTextSelectionColors(colors4, composerStartRestartGroup, 0)), TypographyKt.getLocalTypography().provides(typography2)}, ComposableLambdaKt.rememberComposableLambda(496803446, true, new Function2() { // from class: androidx.compose.material.MaterialThemeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MaterialThemeKt.MaterialTheme$lambda$2(typography2, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            colors3 = colors2;
        }
        final Typography typography3 = typography2;
        final Shapes shapes3 = shapes2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Colors colors5 = colors3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.MaterialThemeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MaterialThemeKt.MaterialTheme$lambda$3(colors5, typography3, shapes3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MaterialTheme$lambda$2(Typography typography, final Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C80@3691L34,80@3648L77:MaterialTheme.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(496803446, i, -1, "androidx.compose.material.MaterialTheme.<anonymous> (MaterialTheme.kt:80)");
            }
            TextKt.ProvideTextStyle(typography.getBody1(), ComposableLambdaKt.rememberComposableLambda(905505767, true, new Function2() { // from class: androidx.compose.material.MaterialThemeKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MaterialThemeKt.MaterialTheme$lambda$2$0(function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MaterialTheme$lambda$2$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C80@3693L30:MaterialTheme.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(905505767, i, -1, "androidx.compose.material.MaterialTheme.<anonymous>.<anonymous> (MaterialTheme.kt:80)");
            }
            MaterialTheme_androidKt.PlatformMaterialTheme(function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
