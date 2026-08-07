package androidx.compose.material3;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MaterialTheme.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a>\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aH\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000e\u001aP\u0010\u000f\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000e\u001a\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0017\"\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u000e\u0010\u0018\u001a\u00020\u0019X\u0080T¢\u0006\u0002\n\u0000\"\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"MaterialTheme", "", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "shapes", "Landroidx/compose/material3/Shapes;", "typography", "Landroidx/compose/material3/Typography;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "motionScheme", "Landroidx/compose/material3/MotionScheme;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/MotionScheme;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "MaterialExpressiveTheme", "LocalUsingExpressiveTheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalUsingExpressiveTheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "TextSelectionBackgroundOpacity", "", "_localMotionScheme", "get_localMotionScheme$annotations", "()V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MaterialThemeKt {
    public static final float TextSelectionBackgroundOpacity = 0.4f;
    private static final ProvidableCompositionLocal<Boolean> LocalUsingExpressiveTheme = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(MaterialThemeKt.LocalUsingExpressiveTheme$lambda$0());
        }
    });
    private static final ProvidableCompositionLocal<MotionScheme> _localMotionScheme = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MaterialThemeKt._localMotionScheme$lambda$0();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean LocalUsingExpressiveTheme$lambda$0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MaterialExpressiveTheme$lambda$1(ColorScheme colorScheme, MotionScheme motionScheme, Shapes shapes, Typography typography, Function2 function2, int i, int i2, Composer composer, int i3) {
        MaterialExpressiveTheme(colorScheme, motionScheme, shapes, typography, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MaterialTheme$lambda$0(ColorScheme colorScheme, Shapes shapes, Typography typography, Function2 function2, int i, int i2, Composer composer, int i3) {
        MaterialTheme(colorScheme, shapes, typography, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MaterialTheme$lambda$2(ColorScheme colorScheme, MotionScheme motionScheme, Shapes shapes, Typography typography, Function2 function2, int i, int i2, Composer composer, int i3) {
        MaterialTheme(colorScheme, motionScheme, shapes, typography, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static /* synthetic */ void get_localMotionScheme$annotations() {
    }

    public static final void MaterialTheme(ColorScheme colorScheme, Shapes shapes, Typography typography, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        final Function2<? super Composer, ? super Integer, Unit> function3;
        final Typography typography2;
        final Shapes shapes2;
        final ColorScheme colorScheme2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-449719819);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MaterialTheme)N(colorScheme,shapes,typography,content)61@2821L12,59@2734L191:MaterialTheme.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (((i2 & 1) == 0 && composerStartRestartGroup.changed(colorScheme)) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(shapes)) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(typography)) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "54@2578L11,55@2626L6,56@2677L10");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    colorScheme = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6);
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    shapes = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    typography = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
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
            ColorScheme colorScheme3 = colorScheme;
            Shapes shapes3 = shapes;
            Typography typography3 = typography;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-449719819, i3, -1, "androidx.compose.material3.MaterialTheme (MaterialTheme.kt:59)");
            }
            int i4 = i3 << 3;
            MaterialTheme(colorScheme3, MaterialTheme.INSTANCE.getMotionScheme(composerStartRestartGroup, 6), shapes3, typography3, function2, composerStartRestartGroup, (i3 & 14) | (i4 & 896) | (i4 & 7168) | (i4 & 57344), 0);
            function3 = function2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colorScheme2 = colorScheme3;
            shapes2 = shapes3;
            typography2 = typography3;
        } else {
            function3 = function2;
            composerStartRestartGroup.skipToGroupEnd();
            typography2 = typography;
            shapes2 = shapes;
            colorScheme2 = colorScheme;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MaterialThemeKt.MaterialTheme$lambda$0(colorScheme2, shapes2, typography2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void MaterialTheme(ColorScheme colorScheme, MotionScheme motionScheme, Shapes shapes, Typography typography, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        ColorScheme colorScheme2;
        int i3;
        MotionScheme motionScheme2;
        Shapes shapes2;
        final Typography typography2;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(904511636);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MaterialTheme)N(colorScheme,motionScheme,shapes,typography,content)98@4507L40,106@4873L147,99@4552L468:MaterialTheme.kt#uh7d8r");
        if ((i & 6) == 0) {
            if ((i2 & 1) == 0) {
                colorScheme2 = colorScheme;
                if (composerStartRestartGroup.changed(colorScheme2)) {
                    i4 = 4;
                }
                i3 = i4 | i;
            } else {
                colorScheme2 = colorScheme;
            }
            i4 = 2;
            i3 = i4 | i;
        } else {
            colorScheme2 = colorScheme;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                motionScheme2 = motionScheme;
                int i5 = composerStartRestartGroup.changed(motionScheme2) ? 32 : 16;
                i3 |= i5;
            } else {
                motionScheme2 = motionScheme;
            }
            i3 |= i5;
        } else {
            motionScheme2 = motionScheme;
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
            if ((i2 & 8) == 0) {
                typography2 = typography;
                int i7 = composerStartRestartGroup.changed(typography2) ? 2048 : 1024;
                i3 |= i7;
            } else {
                typography2 = typography;
            }
            i3 |= i7;
        } else {
            typography2 = typography;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "91@4232L11,92@4292L12,93@4341L6,94@4392L10");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    colorScheme2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6);
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    motionScheme2 = MaterialTheme.INSTANCE.getMotionScheme(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    shapes2 = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    typography2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    i3 &= -7169;
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
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(904511636, i3, -1, "androidx.compose.material3.MaterialTheme (MaterialTheme.kt:96)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ColorSchemeKt.getLocalColorScheme().provides(colorScheme2), _localMotionScheme.provides(motionScheme2), IndicationKt.getLocalIndication().provides(RippleKt.m4031rippleH2RKhps$default(false, 0.0f, 0L, 7, null)), ShapesKt.getLocalShapes().provides(shapes2), TextSelectionColorsKt.getLocalTextSelectionColors().provides(rememberTextSelectionColors(colorScheme2, composerStartRestartGroup, i3 & 14)), TypographyKt.getLocalTypography().provides(typography2)}, ComposableLambdaKt.rememberComposableLambda(-1750539308, true, new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MaterialThemeKt.MaterialTheme$lambda$1(typography2, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Shapes shapes3 = shapes2;
        final Typography typography3 = typography2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final ColorScheme colorScheme3 = colorScheme2;
            final MotionScheme motionScheme3 = motionScheme2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MaterialThemeKt.MaterialTheme$lambda$2(colorScheme3, motionScheme3, shapes3, typography3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MaterialTheme$lambda$1(final Typography typography, final Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C107@4925L89,107@4883L131:MaterialTheme.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1750539308, i, -1, "androidx.compose.material3.MaterialTheme.<anonymous> (MaterialTheme.kt:107)");
            }
            PrecisionPointer_androidKt.EnsurePrecisionPointerListenersRegistered(ComposableLambdaKt.rememberComposableLambda(-241536773, true, new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MaterialThemeKt.MaterialTheme$lambda$1$0(typography, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MaterialTheme$lambda$1$0(Typography typography, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C108@4939L65:MaterialTheme.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-241536773, i, -1, "androidx.compose.material3.MaterialTheme.<anonymous>.<anonymous> (MaterialTheme.kt:108)");
            }
            TextKt.ProvideTextStyle(typography.getBodyLarge(), function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01da  */
    /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:43:0x007c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:51:0x0091  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:56:0x009e  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:71:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:75:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:81:0x010d  */
    /* JADX WARN: Code duplicated, block: B:83:0x0119  */
    /* JADX WARN: Code duplicated, block: B:84:0x012f  */
    /* JADX WARN: Code duplicated, block: B:86:0x013b  */
    /* JADX WARN: Code duplicated, block: B:87:0x0151  */
    /* JADX WARN: Code duplicated, block: B:89:0x015e  */
    /* JADX WARN: Code duplicated, block: B:90:0x0174  */
    /* JADX WARN: Code duplicated, block: B:92:0x018d  */
    /* JADX WARN: Code duplicated, block: B:95:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:97:0x01cd  */
    public static final void MaterialExpressiveTheme(ColorScheme colorScheme, MotionScheme motionScheme, Shapes shapes, Typography typography, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        ColorScheme colorScheme2;
        int i3;
        MotionScheme motionScheme2;
        int i4;
        Shapes shapes2;
        int i5;
        int i6;
        Typography typography2;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function3;
        boolean z;
        final ColorScheme colorScheme3;
        final MotionScheme motionScheme3;
        final Shapes shapes3;
        final Typography typography3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final MotionScheme motionScheme4;
        final Shapes shapes4;
        final Typography typography4;
        ProvidableCompositionLocal<Boolean> providableCompositionLocal;
        Object objConsume;
        final ColorScheme colorScheme4;
        ColorScheme colorScheme5;
        MotionScheme motionScheme5;
        Typography typography5;
        Shapes shapes5;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(1317329884);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MaterialExpressiveTheme)N(colorScheme,motionScheme,shapes,typography,content)198@8705L7:MaterialTheme.kt#uh7d8r");
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
            colorScheme2 = colorScheme;
        } else if ((i & 6) == 0) {
            colorScheme2 = colorScheme;
            i3 = (composerStartRestartGroup.changed(colorScheme2) ? 4 : 2) | i;
        } else {
            colorScheme2 = colorScheme;
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 48) == 0) {
                motionScheme2 = motionScheme;
                i3 |= composerStartRestartGroup.changed(motionScheme2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    shapes2 = shapes;
                    if (composerStartRestartGroup.changed(shapes2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        typography2 = typography;
                        if (composerStartRestartGroup.changed(typography2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((i & 24576) == 0) {
                        function3 = function2;
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i3 |= i8;
                    } else {
                        function3 = function2;
                    }
                    if ((i3 & 9363) != 9362) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        colorScheme3 = colorScheme2;
                        motionScheme3 = motionScheme2;
                        shapes3 = shapes2;
                        typography3 = typography2;
                    } else {
                        if (i9 != 0) {
                            colorScheme2 = null;
                        }
                        if (i10 != 0) {
                            motionScheme4 = null;
                        } else {
                            motionScheme4 = motionScheme2;
                        }
                        if (i4 != 0) {
                            shapes4 = null;
                        } else {
                            shapes4 = shapes2;
                        }
                        if (i6 != 0) {
                            typography4 = null;
                        } else {
                            typography4 = typography2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1317329884, i3, -1, "androidx.compose.material3.MaterialExpressiveTheme (MaterialTheme.kt:197)");
                        }
                        providableCompositionLocal = LocalUsingExpressiveTheme;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (((Boolean) objConsume).booleanValue()) {
                            composerStartRestartGroup.startReplaceGroup(1458663246);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "199@8724L312");
                            if (colorScheme2 == null) {
                                composerStartRestartGroup.startReplaceGroup(-1061323065);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "200@8794L11");
                                ColorScheme colorScheme6 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6);
                                composerStartRestartGroup.endReplaceGroup();
                                colorScheme5 = colorScheme6;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1061323964);
                                composerStartRestartGroup.endReplaceGroup();
                                colorScheme5 = colorScheme2;
                            }
                            if (motionScheme4 == null) {
                                composerStartRestartGroup.startReplaceGroup(-1061320824);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "201@8864L12");
                                MotionScheme motionScheme6 = MaterialTheme.INSTANCE.getMotionScheme(composerStartRestartGroup, 6);
                                composerStartRestartGroup.endReplaceGroup();
                                motionScheme5 = motionScheme6;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1061321754);
                                composerStartRestartGroup.endReplaceGroup();
                                motionScheme5 = motionScheme4;
                            }
                            if (typography4 == null) {
                                composerStartRestartGroup.startReplaceGroup(-1061318682);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "202@8931L10");
                                Typography typography6 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                                composerStartRestartGroup.endReplaceGroup();
                                typography5 = typography6;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1061319550);
                                composerStartRestartGroup.endReplaceGroup();
                                typography5 = typography4;
                            }
                            if (shapes4 == null) {
                                composerStartRestartGroup.startReplaceGroup(-1061316862);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "203@8988L6");
                                Shapes shapes6 = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6);
                                composerStartRestartGroup.endReplaceGroup();
                                shapes5 = shapes6;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1061317606);
                                composerStartRestartGroup.endReplaceGroup();
                                shapes5 = shapes4;
                            }
                            MaterialTheme(colorScheme5, motionScheme5, shapes5, typography5, function3, composerStartRestartGroup, i3 & 57344, 0);
                            composerStartRestartGroup.endReplaceGroup();
                            colorScheme4 = colorScheme2;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1458990389);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "207@9124L415,207@9058L481");
                            colorScheme4 = colorScheme2;
                            CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal.provides(true), ComposableLambdaKt.rememberComposableLambda(1535649272, true, new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return MaterialThemeKt.MaterialExpressiveTheme$lambda$0(colorScheme4, motionScheme4, shapes4, typography4, function2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        colorScheme3 = colorScheme4;
                        motionScheme3 = motionScheme4;
                        shapes3 = shapes4;
                        typography3 = typography4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MaterialThemeKt.MaterialExpressiveTheme$lambda$1(colorScheme3, motionScheme3, shapes3, typography3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                typography2 = typography;
                if ((i & 24576) == 0) {
                    function3 = function2;
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                } else {
                    function3 = function2;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    colorScheme3 = colorScheme2;
                    motionScheme3 = motionScheme2;
                    shapes3 = shapes2;
                    typography3 = typography2;
                } else {
                    if (i9 != 0) {
                        colorScheme2 = null;
                    }
                    if (i10 != 0) {
                        motionScheme4 = null;
                    } else {
                        motionScheme4 = motionScheme2;
                    }
                    if (i4 != 0) {
                        shapes4 = null;
                    } else {
                        shapes4 = shapes2;
                    }
                    if (i6 != 0) {
                        typography4 = null;
                    } else {
                        typography4 = typography2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1317329884, i3, -1, "androidx.compose.material3.MaterialExpressiveTheme (MaterialTheme.kt:197)");
                    }
                    providableCompositionLocal = LocalUsingExpressiveTheme;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (((Boolean) objConsume).booleanValue()) {
                        composerStartRestartGroup.startReplaceGroup(1458663246);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "199@8724L312");
                        if (colorScheme2 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1061323065);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "200@8794L11");
                            ColorScheme colorScheme7 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                            colorScheme5 = colorScheme7;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1061323964);
                            composerStartRestartGroup.endReplaceGroup();
                            colorScheme5 = colorScheme2;
                        }
                        if (motionScheme4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1061320824);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "201@8864L12");
                            MotionScheme motionScheme7 = MaterialTheme.INSTANCE.getMotionScheme(composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                            motionScheme5 = motionScheme7;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1061321754);
                            composerStartRestartGroup.endReplaceGroup();
                            motionScheme5 = motionScheme4;
                        }
                        if (typography4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1061318682);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "202@8931L10");
                            Typography typography7 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                            typography5 = typography7;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1061319550);
                            composerStartRestartGroup.endReplaceGroup();
                            typography5 = typography4;
                        }
                        if (shapes4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1061316862);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "203@8988L6");
                            Shapes shapes7 = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                            shapes5 = shapes7;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1061317606);
                            composerStartRestartGroup.endReplaceGroup();
                            shapes5 = shapes4;
                        }
                        MaterialTheme(colorScheme5, motionScheme5, shapes5, typography5, function3, composerStartRestartGroup, i3 & 57344, 0);
                        composerStartRestartGroup.endReplaceGroup();
                        colorScheme4 = colorScheme2;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1458990389);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "207@9124L415,207@9058L481");
                        colorScheme4 = colorScheme2;
                        CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal.provides(true), ComposableLambdaKt.rememberComposableLambda(1535649272, true, new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MaterialThemeKt.MaterialExpressiveTheme$lambda$0(colorScheme4, motionScheme4, shapes4, typography4, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    colorScheme3 = colorScheme4;
                    motionScheme3 = motionScheme4;
                    shapes3 = shapes4;
                    typography3 = typography4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MaterialThemeKt.MaterialExpressiveTheme$lambda$1(colorScheme3, motionScheme3, shapes3, typography3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            shapes2 = shapes;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    typography2 = typography;
                    if (composerStartRestartGroup.changed(typography2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    function3 = function2;
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                } else {
                    function3 = function2;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    colorScheme3 = colorScheme2;
                    motionScheme3 = motionScheme2;
                    shapes3 = shapes2;
                    typography3 = typography2;
                } else {
                    if (i9 != 0) {
                        colorScheme2 = null;
                    }
                    if (i10 != 0) {
                        motionScheme4 = null;
                    } else {
                        motionScheme4 = motionScheme2;
                    }
                    if (i4 != 0) {
                        shapes4 = null;
                    } else {
                        shapes4 = shapes2;
                    }
                    if (i6 != 0) {
                        typography4 = null;
                    } else {
                        typography4 = typography2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1317329884, i3, -1, "androidx.compose.material3.MaterialExpressiveTheme (MaterialTheme.kt:197)");
                    }
                    providableCompositionLocal = LocalUsingExpressiveTheme;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (((Boolean) objConsume).booleanValue()) {
                        composerStartRestartGroup.startReplaceGroup(1458663246);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "199@8724L312");
                        if (colorScheme2 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1061323065);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "200@8794L11");
                            ColorScheme colorScheme8 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                            colorScheme5 = colorScheme8;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1061323964);
                            composerStartRestartGroup.endReplaceGroup();
                            colorScheme5 = colorScheme2;
                        }
                        if (motionScheme4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1061320824);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "201@8864L12");
                            MotionScheme motionScheme8 = MaterialTheme.INSTANCE.getMotionScheme(composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                            motionScheme5 = motionScheme8;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1061321754);
                            composerStartRestartGroup.endReplaceGroup();
                            motionScheme5 = motionScheme4;
                        }
                        if (typography4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1061318682);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "202@8931L10");
                            Typography typography8 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                            typography5 = typography8;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1061319550);
                            composerStartRestartGroup.endReplaceGroup();
                            typography5 = typography4;
                        }
                        if (shapes4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1061316862);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "203@8988L6");
                            Shapes shapes8 = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                            shapes5 = shapes8;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1061317606);
                            composerStartRestartGroup.endReplaceGroup();
                            shapes5 = shapes4;
                        }
                        MaterialTheme(colorScheme5, motionScheme5, shapes5, typography5, function3, composerStartRestartGroup, i3 & 57344, 0);
                        composerStartRestartGroup.endReplaceGroup();
                        colorScheme4 = colorScheme2;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1458990389);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "207@9124L415,207@9058L481");
                        colorScheme4 = colorScheme2;
                        CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal.provides(true), ComposableLambdaKt.rememberComposableLambda(1535649272, true, new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MaterialThemeKt.MaterialExpressiveTheme$lambda$0(colorScheme4, motionScheme4, shapes4, typography4, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    colorScheme3 = colorScheme4;
                    motionScheme3 = motionScheme4;
                    shapes3 = shapes4;
                    typography3 = typography4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MaterialThemeKt.MaterialExpressiveTheme$lambda$1(colorScheme3, motionScheme3, shapes3, typography3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            typography2 = typography;
            if ((i & 24576) == 0) {
                function3 = function2;
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            } else {
                function3 = function2;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                colorScheme3 = colorScheme2;
                motionScheme3 = motionScheme2;
                shapes3 = shapes2;
                typography3 = typography2;
            } else {
                if (i9 != 0) {
                    colorScheme2 = null;
                }
                if (i10 != 0) {
                    motionScheme4 = null;
                } else {
                    motionScheme4 = motionScheme2;
                }
                if (i4 != 0) {
                    shapes4 = null;
                } else {
                    shapes4 = shapes2;
                }
                if (i6 != 0) {
                    typography4 = null;
                } else {
                    typography4 = typography2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1317329884, i3, -1, "androidx.compose.material3.MaterialExpressiveTheme (MaterialTheme.kt:197)");
                }
                providableCompositionLocal = LocalUsingExpressiveTheme;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (((Boolean) objConsume).booleanValue()) {
                    composerStartRestartGroup.startReplaceGroup(1458663246);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "199@8724L312");
                    if (colorScheme2 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1061323065);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "200@8794L11");
                        ColorScheme colorScheme9 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                        colorScheme5 = colorScheme9;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1061323964);
                        composerStartRestartGroup.endReplaceGroup();
                        colorScheme5 = colorScheme2;
                    }
                    if (motionScheme4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1061320824);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@8864L12");
                        MotionScheme motionScheme9 = MaterialTheme.INSTANCE.getMotionScheme(composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                        motionScheme5 = motionScheme9;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1061321754);
                        composerStartRestartGroup.endReplaceGroup();
                        motionScheme5 = motionScheme4;
                    }
                    if (typography4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1061318682);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "202@8931L10");
                        Typography typography9 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                        typography5 = typography9;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1061319550);
                        composerStartRestartGroup.endReplaceGroup();
                        typography5 = typography4;
                    }
                    if (shapes4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1061316862);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "203@8988L6");
                        Shapes shapes9 = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                        shapes5 = shapes9;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1061317606);
                        composerStartRestartGroup.endReplaceGroup();
                        shapes5 = shapes4;
                    }
                    MaterialTheme(colorScheme5, motionScheme5, shapes5, typography5, function3, composerStartRestartGroup, i3 & 57344, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    colorScheme4 = colorScheme2;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1458990389);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "207@9124L415,207@9058L481");
                    colorScheme4 = colorScheme2;
                    CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal.provides(true), ComposableLambdaKt.rememberComposableLambda(1535649272, true, new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MaterialThemeKt.MaterialExpressiveTheme$lambda$0(colorScheme4, motionScheme4, shapes4, typography4, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                colorScheme3 = colorScheme4;
                motionScheme3 = motionScheme4;
                shapes3 = shapes4;
                typography3 = typography4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MaterialThemeKt.MaterialExpressiveTheme$lambda$1(colorScheme3, motionScheme3, shapes3, typography3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        motionScheme2 = motionScheme;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                shapes2 = shapes;
                if (composerStartRestartGroup.changed(shapes2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    typography2 = typography;
                    if (composerStartRestartGroup.changed(typography2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    function3 = function2;
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                } else {
                    function3 = function2;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    colorScheme3 = colorScheme2;
                    motionScheme3 = motionScheme2;
                    shapes3 = shapes2;
                    typography3 = typography2;
                } else {
                    if (i9 != 0) {
                        colorScheme2 = null;
                    }
                    if (i10 != 0) {
                        motionScheme4 = null;
                    } else {
                        motionScheme4 = motionScheme2;
                    }
                    if (i4 != 0) {
                        shapes4 = null;
                    } else {
                        shapes4 = shapes2;
                    }
                    if (i6 != 0) {
                        typography4 = null;
                    } else {
                        typography4 = typography2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1317329884, i3, -1, "androidx.compose.material3.MaterialExpressiveTheme (MaterialTheme.kt:197)");
                    }
                    providableCompositionLocal = LocalUsingExpressiveTheme;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (((Boolean) objConsume).booleanValue()) {
                        composerStartRestartGroup.startReplaceGroup(1458663246);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "199@8724L312");
                        if (colorScheme2 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1061323065);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "200@8794L11");
                            ColorScheme colorScheme10 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                            colorScheme5 = colorScheme10;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1061323964);
                            composerStartRestartGroup.endReplaceGroup();
                            colorScheme5 = colorScheme2;
                        }
                        if (motionScheme4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1061320824);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "201@8864L12");
                            MotionScheme motionScheme10 = MaterialTheme.INSTANCE.getMotionScheme(composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                            motionScheme5 = motionScheme10;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1061321754);
                            composerStartRestartGroup.endReplaceGroup();
                            motionScheme5 = motionScheme4;
                        }
                        if (typography4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1061318682);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "202@8931L10");
                            Typography typography10 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                            typography5 = typography10;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1061319550);
                            composerStartRestartGroup.endReplaceGroup();
                            typography5 = typography4;
                        }
                        if (shapes4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1061316862);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "203@8988L6");
                            Shapes shapes10 = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                            shapes5 = shapes10;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1061317606);
                            composerStartRestartGroup.endReplaceGroup();
                            shapes5 = shapes4;
                        }
                        MaterialTheme(colorScheme5, motionScheme5, shapes5, typography5, function3, composerStartRestartGroup, i3 & 57344, 0);
                        composerStartRestartGroup.endReplaceGroup();
                        colorScheme4 = colorScheme2;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1458990389);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "207@9124L415,207@9058L481");
                        colorScheme4 = colorScheme2;
                        CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal.provides(true), ComposableLambdaKt.rememberComposableLambda(1535649272, true, new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MaterialThemeKt.MaterialExpressiveTheme$lambda$0(colorScheme4, motionScheme4, shapes4, typography4, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    colorScheme3 = colorScheme4;
                    motionScheme3 = motionScheme4;
                    shapes3 = shapes4;
                    typography3 = typography4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MaterialThemeKt.MaterialExpressiveTheme$lambda$1(colorScheme3, motionScheme3, shapes3, typography3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            typography2 = typography;
            if ((i & 24576) == 0) {
                function3 = function2;
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            } else {
                function3 = function2;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                colorScheme3 = colorScheme2;
                motionScheme3 = motionScheme2;
                shapes3 = shapes2;
                typography3 = typography2;
            } else {
                if (i9 != 0) {
                    colorScheme2 = null;
                }
                if (i10 != 0) {
                    motionScheme4 = null;
                } else {
                    motionScheme4 = motionScheme2;
                }
                if (i4 != 0) {
                    shapes4 = null;
                } else {
                    shapes4 = shapes2;
                }
                if (i6 != 0) {
                    typography4 = null;
                } else {
                    typography4 = typography2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1317329884, i3, -1, "androidx.compose.material3.MaterialExpressiveTheme (MaterialTheme.kt:197)");
                }
                providableCompositionLocal = LocalUsingExpressiveTheme;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (((Boolean) objConsume).booleanValue()) {
                    composerStartRestartGroup.startReplaceGroup(1458663246);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "199@8724L312");
                    if (colorScheme2 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1061323065);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "200@8794L11");
                        ColorScheme colorScheme11 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                        colorScheme5 = colorScheme11;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1061323964);
                        composerStartRestartGroup.endReplaceGroup();
                        colorScheme5 = colorScheme2;
                    }
                    if (motionScheme4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1061320824);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@8864L12");
                        MotionScheme motionScheme11 = MaterialTheme.INSTANCE.getMotionScheme(composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                        motionScheme5 = motionScheme11;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1061321754);
                        composerStartRestartGroup.endReplaceGroup();
                        motionScheme5 = motionScheme4;
                    }
                    if (typography4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1061318682);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "202@8931L10");
                        Typography typography11 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                        typography5 = typography11;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1061319550);
                        composerStartRestartGroup.endReplaceGroup();
                        typography5 = typography4;
                    }
                    if (shapes4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1061316862);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "203@8988L6");
                        Shapes shapes11 = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                        shapes5 = shapes11;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1061317606);
                        composerStartRestartGroup.endReplaceGroup();
                        shapes5 = shapes4;
                    }
                    MaterialTheme(colorScheme5, motionScheme5, shapes5, typography5, function3, composerStartRestartGroup, i3 & 57344, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    colorScheme4 = colorScheme2;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1458990389);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "207@9124L415,207@9058L481");
                    colorScheme4 = colorScheme2;
                    CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal.provides(true), ComposableLambdaKt.rememberComposableLambda(1535649272, true, new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MaterialThemeKt.MaterialExpressiveTheme$lambda$0(colorScheme4, motionScheme4, shapes4, typography4, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                colorScheme3 = colorScheme4;
                motionScheme3 = motionScheme4;
                shapes3 = shapes4;
                typography3 = typography4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MaterialThemeKt.MaterialExpressiveTheme$lambda$1(colorScheme3, motionScheme3, shapes3, typography3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        shapes2 = shapes;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                typography2 = typography;
                if (composerStartRestartGroup.changed(typography2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i & 24576) == 0) {
                function3 = function2;
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            } else {
                function3 = function2;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                colorScheme3 = colorScheme2;
                motionScheme3 = motionScheme2;
                shapes3 = shapes2;
                typography3 = typography2;
            } else {
                if (i9 != 0) {
                    colorScheme2 = null;
                }
                if (i10 != 0) {
                    motionScheme4 = null;
                } else {
                    motionScheme4 = motionScheme2;
                }
                if (i4 != 0) {
                    shapes4 = null;
                } else {
                    shapes4 = shapes2;
                }
                if (i6 != 0) {
                    typography4 = null;
                } else {
                    typography4 = typography2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1317329884, i3, -1, "androidx.compose.material3.MaterialExpressiveTheme (MaterialTheme.kt:197)");
                }
                providableCompositionLocal = LocalUsingExpressiveTheme;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (((Boolean) objConsume).booleanValue()) {
                    composerStartRestartGroup.startReplaceGroup(1458663246);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "199@8724L312");
                    if (colorScheme2 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1061323065);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "200@8794L11");
                        ColorScheme colorScheme12 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                        colorScheme5 = colorScheme12;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1061323964);
                        composerStartRestartGroup.endReplaceGroup();
                        colorScheme5 = colorScheme2;
                    }
                    if (motionScheme4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1061320824);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@8864L12");
                        MotionScheme motionScheme12 = MaterialTheme.INSTANCE.getMotionScheme(composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                        motionScheme5 = motionScheme12;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1061321754);
                        composerStartRestartGroup.endReplaceGroup();
                        motionScheme5 = motionScheme4;
                    }
                    if (typography4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1061318682);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "202@8931L10");
                        Typography typography12 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                        typography5 = typography12;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1061319550);
                        composerStartRestartGroup.endReplaceGroup();
                        typography5 = typography4;
                    }
                    if (shapes4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1061316862);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "203@8988L6");
                        Shapes shapes12 = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                        shapes5 = shapes12;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1061317606);
                        composerStartRestartGroup.endReplaceGroup();
                        shapes5 = shapes4;
                    }
                    MaterialTheme(colorScheme5, motionScheme5, shapes5, typography5, function3, composerStartRestartGroup, i3 & 57344, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    colorScheme4 = colorScheme2;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1458990389);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "207@9124L415,207@9058L481");
                    colorScheme4 = colorScheme2;
                    CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal.provides(true), ComposableLambdaKt.rememberComposableLambda(1535649272, true, new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MaterialThemeKt.MaterialExpressiveTheme$lambda$0(colorScheme4, motionScheme4, shapes4, typography4, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                colorScheme3 = colorScheme4;
                motionScheme3 = motionScheme4;
                shapes3 = shapes4;
                typography3 = typography4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MaterialThemeKt.MaterialExpressiveTheme$lambda$1(colorScheme3, motionScheme3, shapes3, typography3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        typography2 = typography;
        if ((i & 24576) == 0) {
            function3 = function2;
            if (composerStartRestartGroup.changedInstance(function3)) {
                i8 = 16384;
            } else {
                i8 = 8192;
            }
            i3 |= i8;
        } else {
            function3 = function2;
        }
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            colorScheme3 = colorScheme2;
            motionScheme3 = motionScheme2;
            shapes3 = shapes2;
            typography3 = typography2;
        } else {
            if (i9 != 0) {
                colorScheme2 = null;
            }
            if (i10 != 0) {
                motionScheme4 = null;
            } else {
                motionScheme4 = motionScheme2;
            }
            if (i4 != 0) {
                shapes4 = null;
            } else {
                shapes4 = shapes2;
            }
            if (i6 != 0) {
                typography4 = null;
            } else {
                typography4 = typography2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1317329884, i3, -1, "androidx.compose.material3.MaterialExpressiveTheme (MaterialTheme.kt:197)");
            }
            providableCompositionLocal = LocalUsingExpressiveTheme;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (((Boolean) objConsume).booleanValue()) {
                composerStartRestartGroup.startReplaceGroup(1458663246);
                ComposerKt.sourceInformation(composerStartRestartGroup, "199@8724L312");
                if (colorScheme2 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1061323065);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "200@8794L11");
                    ColorScheme colorScheme13 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                    colorScheme5 = colorScheme13;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1061323964);
                    composerStartRestartGroup.endReplaceGroup();
                    colorScheme5 = colorScheme2;
                }
                if (motionScheme4 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1061320824);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "201@8864L12");
                    MotionScheme motionScheme13 = MaterialTheme.INSTANCE.getMotionScheme(composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                    motionScheme5 = motionScheme13;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1061321754);
                    composerStartRestartGroup.endReplaceGroup();
                    motionScheme5 = motionScheme4;
                }
                if (typography4 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1061318682);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "202@8931L10");
                    Typography typography13 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                    typography5 = typography13;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1061319550);
                    composerStartRestartGroup.endReplaceGroup();
                    typography5 = typography4;
                }
                if (shapes4 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1061316862);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "203@8988L6");
                    Shapes shapes13 = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                    shapes5 = shapes13;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1061317606);
                    composerStartRestartGroup.endReplaceGroup();
                    shapes5 = shapes4;
                }
                MaterialTheme(colorScheme5, motionScheme5, shapes5, typography5, function3, composerStartRestartGroup, i3 & 57344, 0);
                composerStartRestartGroup.endReplaceGroup();
                colorScheme4 = colorScheme2;
            } else {
                composerStartRestartGroup.startReplaceGroup(1458990389);
                ComposerKt.sourceInformation(composerStartRestartGroup, "207@9124L415,207@9058L481");
                colorScheme4 = colorScheme2;
                CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal.provides(true), ComposableLambdaKt.rememberComposableLambda(1535649272, true, new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MaterialThemeKt.MaterialExpressiveTheme$lambda$0(colorScheme4, motionScheme4, shapes4, typography4, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colorScheme3 = colorScheme4;
            motionScheme3 = motionScheme4;
            shapes3 = shapes4;
            typography3 = typography4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MaterialThemeKt.MaterialExpressiveTheme$lambda$1(colorScheme3, motionScheme3, shapes3, typography3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MaterialExpressiveTheme$lambda$0(ColorScheme colorScheme, MotionScheme motionScheme, Shapes shapes, Typography typography, Function2 function2, Composer composer, int i) {
        Shapes shapes2;
        Typography typography2;
        ComposerKt.sourceInformation(composer, "C208@9138L391:MaterialTheme.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1535649272, i, -1, "androidx.compose.material3.MaterialExpressiveTheme.<anonymous> (MaterialTheme.kt:208)");
            }
            ColorScheme colorSchemeExpressiveLightColorScheme = colorScheme == null ? ColorSchemeKt.expressiveLightColorScheme() : colorScheme;
            MotionScheme motionSchemeExpressive = motionScheme == null ? MotionScheme.INSTANCE.expressive() : motionScheme;
            if (shapes == null) {
                shapes2 = new Shapes(null, null, null, null, null, 31, null);
            } else {
                shapes2 = shapes;
            }
            if (typography == null) {
                typography2 = new Typography(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
            } else {
                typography2 = typography;
            }
            MaterialTheme(colorSchemeExpressiveLightColorScheme, motionSchemeExpressive, shapes2, typography2, function2, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalUsingExpressiveTheme() {
        return LocalUsingExpressiveTheme;
    }

    public static final TextSelectionColors rememberTextSelectionColors(ColorScheme colorScheme, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1866455512, "C(rememberTextSelectionColors)N(colorScheme)226@9805L198:MaterialTheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1866455512, i, -1, "androidx.compose.material3.rememberTextSelectionColors (MaterialTheme.kt:224)");
        }
        long primary = colorScheme.getPrimary();
        ComposerKt.sourceInformationMarkerStart(composer, -1632578178, "CC(remember):MaterialTheme.kt#9igjgp");
        boolean zChanged = composer.changed(primary);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            TextSelectionColors textSelectionColors = new TextSelectionColors(primary, Color.m6813copywmQWz5c$default(primary, 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null);
            composer.updateRememberedValue(textSelectionColors);
            objRememberedValue = textSelectionColors;
        }
        TextSelectionColors textSelectionColors2 = (TextSelectionColors) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textSelectionColors2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MotionScheme _localMotionScheme$lambda$0() {
        return MotionScheme.INSTANCE.standard();
    }
}
