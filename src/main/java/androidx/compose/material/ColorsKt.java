package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.facebook.react.modules.appstate.AppStateModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Colors.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0085\u0001\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0010\u001a\u0019\u0010\u0016\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0014\u0010\u001c\u001a\u00020\u001d*\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0000\"\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010 X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"lightColors", "Landroidx/compose/material/Colors;", "primary", "Landroidx/compose/ui/graphics/Color;", "primaryVariant", "secondary", "secondaryVariant", AppStateModule.APP_STATE_BACKGROUND, "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onError", "lightColors-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material/Colors;", "darkColors", "darkColors-2qZNXz8", "primarySurface", "getPrimarySurface", "(Landroidx/compose/material/Colors;)J", "contentColorFor", "backgroundColor", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material/Colors;J)J", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "updateColorsFrom", "", "other", "LocalColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ColorsKt {
    private static final ProvidableCompositionLocal<Colors> LocalColors = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material.ColorsKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ColorsKt.LocalColors$lambda$0();
        }
    });

    /* JADX INFO: renamed from: lightColors-2qZNXz8$default, reason: not valid java name */
    public static /* synthetic */ Colors m2364lightColors2qZNXz8$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, int i, Object obj) {
        long jColor = (i & 1) != 0 ? ColorKt.Color(4284612846L) : j;
        long jColor2 = (i & 2) != 0 ? ColorKt.Color(4281794739L) : j2;
        long jColor3 = (i & 4) != 0 ? ColorKt.Color(4278442694L) : j3;
        long jColor4 = (i & 8) != 0 ? ColorKt.Color(4278290310L) : j4;
        long jM6851getWhite0d7_KjU = (i & 16) != 0 ? Color.INSTANCE.m6851getWhite0d7_KjU() : j5;
        long jM6851getWhite0d7_KjU2 = (i & 32) != 0 ? Color.INSTANCE.m6851getWhite0d7_KjU() : j6;
        long jColor5 = (i & 64) != 0 ? ColorKt.Color(4289724448L) : j7;
        long jM6851getWhite0d7_KjU3 = (i & 128) != 0 ? Color.INSTANCE.m6851getWhite0d7_KjU() : j8;
        long j13 = jColor;
        long jM6840getBlack0d7_KjU = (i & 256) != 0 ? Color.INSTANCE.m6840getBlack0d7_KjU() : j9;
        long jM6840getBlack0d7_KjU2 = (i & 512) != 0 ? Color.INSTANCE.m6840getBlack0d7_KjU() : j10;
        long jM6840getBlack0d7_KjU3 = (i & 1024) != 0 ? Color.INSTANCE.m6840getBlack0d7_KjU() : j11;
        if ((i & 2048) != 0) {
            j12 = Color.INSTANCE.m6851getWhite0d7_KjU();
        }
        return m2363lightColors2qZNXz8(j13, jColor2, jColor3, jColor4, jM6851getWhite0d7_KjU, jM6851getWhite0d7_KjU2, jColor5, jM6851getWhite0d7_KjU3, jM6840getBlack0d7_KjU, jM6840getBlack0d7_KjU2, jM6840getBlack0d7_KjU3, j12);
    }

    /* JADX INFO: renamed from: lightColors-2qZNXz8, reason: not valid java name */
    public static final Colors m2363lightColors2qZNXz8(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        return new Colors(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, true, null);
    }

    /* JADX INFO: renamed from: darkColors-2qZNXz8$default, reason: not valid java name */
    public static /* synthetic */ Colors m2362darkColors2qZNXz8$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, int i, Object obj) {
        long jColor = (i & 1) != 0 ? ColorKt.Color(4290479868L) : j;
        long jColor2 = (i & 2) != 0 ? ColorKt.Color(4281794739L) : j2;
        long jColor3 = (i & 4) != 0 ? ColorKt.Color(4278442694L) : j3;
        long j13 = (i & 8) != 0 ? jColor3 : j4;
        long jColor4 = (i & 16) != 0 ? ColorKt.Color(4279374354L) : j5;
        long jColor5 = (i & 32) != 0 ? ColorKt.Color(4279374354L) : j6;
        long jColor6 = (i & 64) != 0 ? ColorKt.Color(4291782265L) : j7;
        long jM6840getBlack0d7_KjU = (i & 128) != 0 ? Color.INSTANCE.m6840getBlack0d7_KjU() : j8;
        long jM6840getBlack0d7_KjU2 = (i & 256) != 0 ? Color.INSTANCE.m6840getBlack0d7_KjU() : j9;
        long jM6851getWhite0d7_KjU = (i & 512) != 0 ? Color.INSTANCE.m6851getWhite0d7_KjU() : j10;
        long jM6851getWhite0d7_KjU2 = (i & 1024) != 0 ? Color.INSTANCE.m6851getWhite0d7_KjU() : j11;
        if ((i & 2048) != 0) {
            j12 = Color.INSTANCE.m6840getBlack0d7_KjU();
        }
        return m2361darkColors2qZNXz8(jColor, jColor2, jColor3, j13, jColor4, jColor5, jColor6, jM6840getBlack0d7_KjU, jM6840getBlack0d7_KjU2, jM6851getWhite0d7_KjU, jM6851getWhite0d7_KjU2, j12);
    }

    /* JADX INFO: renamed from: darkColors-2qZNXz8, reason: not valid java name */
    public static final Colors m2361darkColors2qZNXz8(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        return new Colors(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, false, null);
    }

    public static final long getPrimarySurface(Colors colors) {
        return colors.isLight() ? colors.m2342getPrimary0d7_KjU() : colors.m2346getSurface0d7_KjU();
    }

    /* JADX INFO: renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m2359contentColorFor4WTKRHQ(Colors colors, long j) {
        if (!Color.m6815equalsimpl0(j, colors.m2342getPrimary0d7_KjU()) && !Color.m6815equalsimpl0(j, colors.m2343getPrimaryVariant0d7_KjU())) {
            if (!Color.m6815equalsimpl0(j, colors.m2344getSecondary0d7_KjU()) && !Color.m6815equalsimpl0(j, colors.m2345getSecondaryVariant0d7_KjU())) {
                if (Color.m6815equalsimpl0(j, colors.m2335getBackground0d7_KjU())) {
                    return colors.m2337getOnBackground0d7_KjU();
                }
                if (Color.m6815equalsimpl0(j, colors.m2346getSurface0d7_KjU())) {
                    return colors.m2341getOnSurface0d7_KjU();
                }
                return Color.m6815equalsimpl0(j, colors.m2336getError0d7_KjU()) ? colors.m2338getOnError0d7_KjU() : Color.INSTANCE.m6850getUnspecified0d7_KjU();
            }
            return colors.m2340getOnSecondary0d7_KjU();
        }
        return colors.m2339getOnPrimary0d7_KjU();
    }

    /* JADX INFO: renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m2360contentColorForek8zF_U(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 441849991, "C(contentColorFor)N(backgroundColor:c#ui.graphics.Color)310@11630L6:Colors.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(441849991, i, -1, "androidx.compose.material.contentColorFor (Colors.kt:310)");
        }
        composer.startReplaceGroup(-583917585);
        ComposerKt.sourceInformation(composer, "*310@11701L7");
        long jM2359contentColorFor4WTKRHQ = m2359contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColors(composer, 6), j);
        if (jM2359contentColorFor4WTKRHQ == 16) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM2359contentColorFor4WTKRHQ = ((Color) objConsume).m6824unboximpl();
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM2359contentColorFor4WTKRHQ;
    }

    public static final void updateColorsFrom(Colors colors, Colors colors2) {
        colors.m2354setPrimary8_81llA$material(colors2.m2342getPrimary0d7_KjU());
        colors.m2355setPrimaryVariant8_81llA$material(colors2.m2343getPrimaryVariant0d7_KjU());
        colors.m2356setSecondary8_81llA$material(colors2.m2344getSecondary0d7_KjU());
        colors.m2357setSecondaryVariant8_81llA$material(colors2.m2345getSecondaryVariant0d7_KjU());
        colors.m2347setBackground8_81llA$material(colors2.m2335getBackground0d7_KjU());
        colors.m2358setSurface8_81llA$material(colors2.m2346getSurface0d7_KjU());
        colors.m2348setError8_81llA$material(colors2.m2336getError0d7_KjU());
        colors.m2351setOnPrimary8_81llA$material(colors2.m2339getOnPrimary0d7_KjU());
        colors.m2352setOnSecondary8_81llA$material(colors2.m2340getOnSecondary0d7_KjU());
        colors.m2349setOnBackground8_81llA$material(colors2.m2337getOnBackground0d7_KjU());
        colors.m2353setOnSurface8_81llA$material(colors2.m2341getOnSurface0d7_KjU());
        colors.m2350setOnError8_81llA$material(colors2.m2338getOnError0d7_KjU());
        colors.setLight$material(colors2.isLight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Colors LocalColors$lambda$0() {
        return m2364lightColors2qZNXz8$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 4095, null);
    }

    public static final ProvidableCompositionLocal<Colors> getLocalColors() {
        return LocalColors;
    }
}
