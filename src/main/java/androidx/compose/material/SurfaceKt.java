package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.selection.ToggleableKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Surface.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a`\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0084\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u008c\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00142\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0092\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00142\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u001a\u0010\u001f\u001a5\u0010 \u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0004\b\"\u0010#\u001a)\u0010$\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\fH\u0003¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2 = {"Surface", "", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Surface-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", ViewProps.ON_CLICK, "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Surface-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-Ny5ogXk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surface", "backgroundColor", "surface-8ww4TTg", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "surfaceColorAtElevation", "elevationOverlay", "Landroidx/compose/material/ElevationOverlay;", "absoluteElevation", "surfaceColorAtElevation-cq6XJ1M", "(JLandroidx/compose/material/ElevationOverlay;FLandroidx/compose/runtime/Composer;I)J", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SurfaceKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_F_jzlyU$lambda$1(Modifier modifier, Shape shape, long j, long j2, BorderStroke borderStroke, float f, Function2 function2, int i, int i2, Composer composer, int i3) {
        m2584SurfaceFjzlyU(modifier, shape, j, j2, borderStroke, f, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_LPr_se0$lambda$1(Function0 function0, Modifier modifier, boolean z, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        m2585SurfaceLPr_se0(function0, modifier, z, shape, j, j2, borderStroke, f, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_Ny5ogXk$lambda$1(boolean z, Function0 function0, Modifier modifier, boolean z2, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, int i3, Composer composer, int i4) {
        m2586SurfaceNy5ogXk(z, (Function0<Unit>) function0, modifier, z2, shape, j, j2, borderStroke, f, mutableInteractionSource, (Function2<? super Composer, ? super Integer, Unit>) function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_Ny5ogXk$lambda$3(boolean z, Function1 function1, Modifier modifier, boolean z2, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, int i3, Composer composer, int i4) {
        m2587SurfaceNy5ogXk(z, (Function1<? super Boolean, Unit>) function1, modifier, z2, shape, j, j2, borderStroke, f, mutableInteractionSource, (Function2<? super Composer, ? super Integer, Unit>) function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0135  */
    /* JADX WARN: Code duplicated, block: B:104:0x0142  */
    /* JADX WARN: Code duplicated, block: B:106:0x0146  */
    /* JADX WARN: Code duplicated, block: B:109:0x0158  */
    /* JADX WARN: Code duplicated, block: B:112:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:114:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:117:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x006d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:51:0x008b  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:76:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:77:0x00de  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:91:0x0109 A[PHI: r4 r5 r7 r8 r11 r14
      0x0109: PHI (r4v10 androidx.compose.ui.Modifier) = (r4v5 androidx.compose.ui.Modifier), (r4v3 androidx.compose.ui.Modifier), (r4v3 androidx.compose.ui.Modifier) binds: [B:105:0x0144, B:89:0x0105, B:90:0x0107] A[DONT_GENERATE, DONT_INLINE]
      0x0109: PHI (r5v26 int) = (r5v18 int), (r5v27 int), (r5v28 int) binds: [B:105:0x0144, B:89:0x0105, B:90:0x0107] A[DONT_GENERATE, DONT_INLINE]
      0x0109: PHI (r7v9 androidx.compose.ui.graphics.Shape) = 
      (r7v5 androidx.compose.ui.graphics.Shape)
      (r7v2 androidx.compose.ui.graphics.Shape)
      (r7v2 androidx.compose.ui.graphics.Shape)
     binds: [B:105:0x0144, B:89:0x0105, B:90:0x0107] A[DONT_GENERATE, DONT_INLINE]
      0x0109: PHI (r8v13 long) = (r8v9 long), (r8v6 long), (r8v6 long) binds: [B:105:0x0144, B:89:0x0105, B:90:0x0107] A[DONT_GENERATE, DONT_INLINE]
      0x0109: PHI (r11v8 long) = (r11v5 long), (r11v2 long), (r11v2 long) binds: [B:105:0x0144, B:89:0x0105, B:90:0x0107] A[DONT_GENERATE, DONT_INLINE]
      0x0109: PHI (r14v6 androidx.compose.foundation.BorderStroke) = 
      (r14v3 androidx.compose.foundation.BorderStroke)
      (r14v2 androidx.compose.foundation.BorderStroke)
      (r14v2 androidx.compose.foundation.BorderStroke)
     binds: [B:105:0x0144, B:89:0x0105, B:90:0x0107] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:93:0x0112 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x0114  */
    /* JADX WARN: Code duplicated, block: B:96:0x011b  */
    /* JADX WARN: Code duplicated, block: B:99:0x0124  */
    /* JADX INFO: renamed from: Surface-F-jzlyU, reason: not valid java name */
    public static final void m2584SurfaceFjzlyU(Modifier modifier, Shape shape, long j, long j2, BorderStroke borderStroke, float f, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape rectangleShape;
        long jM2346getSurface0d7_KjU;
        long jM2360contentColorForek8zF_U;
        int i4;
        BorderStroke borderStroke2;
        int i5;
        int i6;
        int i7;
        boolean z;
        final Shape shape2;
        final long j3;
        final BorderStroke borderStroke3;
        final float f2;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final float fM9687constructorimpl;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(174096871);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Surface)N(modifier,shape,color:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,border,elevation:c#ui.unit.Dp,content)102@5257L7,106@5421L878,103@5281L1018:Surface.kt#jmzs0o");
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 48) == 0) {
                rectangleShape = shape;
                i3 |= composerStartRestartGroup.changed(rectangleShape) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    jM2346getSurface0d7_KjU = j;
                    int i11 = composerStartRestartGroup.changed(jM2346getSurface0d7_KjU) ? 256 : 128;
                    i3 |= i11;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                i3 |= i11;
            } else {
                jM2346getSurface0d7_KjU = j;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    jM2360contentColorForek8zF_U = j2;
                    int i12 = composerStartRestartGroup.changed(jM2360contentColorForek8zF_U) ? 2048 : 1024;
                    i3 |= i12;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                i3 |= i12;
            } else {
                jM2360contentColorForek8zF_U = j2;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    borderStroke2 = borderStroke;
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i3 |= i8;
                }
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "96@5039L6,97@5081L22");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i10 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            borderStroke2 = null;
                        }
                        if (i6 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        }
                        final Shape shape3 = rectangleShape;
                        j3 = jM2346getSurface0d7_KjU;
                        final BorderStroke borderStroke4 = borderStroke2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(174096871, i3, -1, "androidx.compose.material.Surface (Surface.kt:101)");
                        }
                        ProvidableCompositionLocal<Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localAbsoluteElevation);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fM9687constructorimpl2 = Dp.m9687constructorimpl(((Dp) objConsume).m9701unboximpl() + fM9687constructorimpl);
                        final Modifier modifier3 = modifier2;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl2))}, ComposableLambdaKt.rememberComposableLambda(-2004281689, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_F_jzlyU$lambda$0(modifier3, shape3, j3, fM9687constructorimpl2, borderStroke4, fM9687constructorimpl, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        shape2 = shape3;
                        borderStroke3 = borderStroke4;
                        f2 = fM9687constructorimpl;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                    }
                    fM9687constructorimpl = f;
                    final Shape shape4 = rectangleShape;
                    j3 = jM2346getSurface0d7_KjU;
                    final BorderStroke borderStroke5 = borderStroke2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(174096871, i3, -1, "androidx.compose.material.Surface (Surface.kt:101)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation2 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localAbsoluteElevation2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl3 = Dp.m9687constructorimpl(((Dp) objConsume2).m9701unboximpl() + fM9687constructorimpl);
                    final Modifier modifier4 = modifier2;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl3))}, ComposableLambdaKt.rememberComposableLambda(-2004281689, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_F_jzlyU$lambda$0(modifier4, shape4, j3, fM9687constructorimpl3, borderStroke5, fM9687constructorimpl, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier4;
                    shape2 = shape4;
                    borderStroke3 = borderStroke5;
                    f2 = fM9687constructorimpl;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    shape2 = rectangleShape;
                    j3 = jM2346getSurface0d7_KjU;
                    borderStroke3 = borderStroke2;
                    f2 = f;
                }
                j4 = jM2360contentColorForek8zF_U;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier5 = modifier2;
                    final long j5 = j3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_F_jzlyU$lambda$1(modifier5, shape2, j5, j4, borderStroke3, f2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            borderStroke2 = borderStroke;
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i3 |= i8;
            }
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "96@5039L6,97@5081L22");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i10 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        borderStroke2 = null;
                    }
                    if (i6 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i10 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        borderStroke2 = null;
                    }
                    if (i6 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                }
                final Shape shape5 = rectangleShape;
                j3 = jM2346getSurface0d7_KjU;
                final BorderStroke borderStroke6 = borderStroke2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(174096871, i3, -1, "androidx.compose.material.Surface (Surface.kt:101)");
                }
                ProvidableCompositionLocal<Dp> localAbsoluteElevation3 = ElevationOverlayKt.getLocalAbsoluteElevation();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localAbsoluteElevation3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float fM9687constructorimpl4 = Dp.m9687constructorimpl(((Dp) objConsume3).m9701unboximpl() + fM9687constructorimpl);
                final Modifier modifier6 = modifier2;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl4))}, ComposableLambdaKt.rememberComposableLambda(-2004281689, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_F_jzlyU$lambda$0(modifier6, shape5, j3, fM9687constructorimpl4, borderStroke6, fM9687constructorimpl, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier6;
                shape2 = shape5;
                borderStroke3 = borderStroke6;
                f2 = fM9687constructorimpl;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                shape2 = rectangleShape;
                j3 = jM2346getSurface0d7_KjU;
                borderStroke3 = borderStroke2;
                f2 = f;
            }
            j4 = jM2360contentColorForek8zF_U;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier7 = modifier2;
                final long j6 = j3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_F_jzlyU$lambda$1(modifier7, shape2, j6, j4, borderStroke3, f2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        rectangleShape = shape;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                jM2346getSurface0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                }
                i3 |= i11;
            } else {
                jM2346getSurface0d7_KjU = j;
            }
            i3 |= i11;
        } else {
            jM2346getSurface0d7_KjU = j;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                jM2360contentColorForek8zF_U = j2;
                if (composerStartRestartGroup.changed(jM2360contentColorForek8zF_U)) {
                }
                i3 |= i12;
            } else {
                jM2360contentColorForek8zF_U = j2;
            }
            i3 |= i12;
        } else {
            jM2360contentColorForek8zF_U = j2;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                borderStroke2 = borderStroke;
                if (composerStartRestartGroup.changed(borderStroke2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i3 |= i8;
            }
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "96@5039L6,97@5081L22");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i10 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        borderStroke2 = null;
                    }
                    if (i6 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i10 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        borderStroke2 = null;
                    }
                    if (i6 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                }
                final Shape shape6 = rectangleShape;
                j3 = jM2346getSurface0d7_KjU;
                final BorderStroke borderStroke7 = borderStroke2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(174096871, i3, -1, "androidx.compose.material.Surface (Surface.kt:101)");
                }
                ProvidableCompositionLocal<Dp> localAbsoluteElevation4 = ElevationOverlayKt.getLocalAbsoluteElevation();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume4 = composerStartRestartGroup.consume(localAbsoluteElevation4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float fM9687constructorimpl5 = Dp.m9687constructorimpl(((Dp) objConsume4).m9701unboximpl() + fM9687constructorimpl);
                final Modifier modifier8 = modifier2;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl5))}, ComposableLambdaKt.rememberComposableLambda(-2004281689, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_F_jzlyU$lambda$0(modifier8, shape6, j3, fM9687constructorimpl5, borderStroke7, fM9687constructorimpl, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier8;
                shape2 = shape6;
                borderStroke3 = borderStroke7;
                f2 = fM9687constructorimpl;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                shape2 = rectangleShape;
                j3 = jM2346getSurface0d7_KjU;
                borderStroke3 = borderStroke2;
                f2 = f;
            }
            j4 = jM2360contentColorForek8zF_U;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier9 = modifier2;
                final long j7 = j3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_F_jzlyU$lambda$1(modifier9, shape2, j7, j4, borderStroke3, f2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        borderStroke2 = borderStroke;
        i6 = i2 & 32;
        if (i6 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i7 = 131072;
            } else {
                i7 = 65536;
            }
            i3 |= i7;
        }
        if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i8 = 1048576;
            } else {
                i8 = 524288;
            }
            i3 |= i8;
        }
        if ((i3 & 599187) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "96@5039L6,97@5081L22");
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i10 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 4) != 0) {
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    borderStroke2 = null;
                }
                if (i6 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl = f;
                }
            } else {
                if (i9 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i10 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 4) != 0) {
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    borderStroke2 = null;
                }
                if (i6 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl = f;
                }
            }
            final Shape shape7 = rectangleShape;
            j3 = jM2346getSurface0d7_KjU;
            final BorderStroke borderStroke8 = borderStroke2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(174096871, i3, -1, "androidx.compose.material.Surface (Surface.kt:101)");
            }
            ProvidableCompositionLocal<Dp> localAbsoluteElevation5 = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume5 = composerStartRestartGroup.consume(localAbsoluteElevation5);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final float fM9687constructorimpl6 = Dp.m9687constructorimpl(((Dp) objConsume5).m9701unboximpl() + fM9687constructorimpl);
            final Modifier modifier10 = modifier2;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl6))}, ComposableLambdaKt.rememberComposableLambda(-2004281689, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SurfaceKt.Surface_F_jzlyU$lambda$0(modifier10, shape7, j3, fM9687constructorimpl6, borderStroke8, fM9687constructorimpl, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier10;
            shape2 = shape7;
            borderStroke3 = borderStroke8;
            f2 = fM9687constructorimpl;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            shape2 = rectangleShape;
            j3 = jM2346getSurface0d7_KjU;
            borderStroke3 = borderStroke2;
            f2 = f;
        }
        j4 = jM2360contentColorForek8zF_U;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier11 = modifier2;
            final long j8 = j3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SurfaceKt.Surface_F_jzlyU$lambda$1(modifier11, shape2, j8, j4, borderStroke3, f2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_F_jzlyU$lambda$0(Modifier modifier, Shape shape, long j, float f, BorderStroke borderStroke, float f2, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C115@5768L7,113@5623L254,121@6046L115,125@6202L2,107@5431L862:Surface.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2004281689, i, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:107)");
            }
            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localElevationOverlay);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierM2588surface8ww4TTg = m2588surface8ww4TTg(modifier, shape, m2589surfaceColorAtElevationcq6XJ1M(j, (ElevationOverlay) objConsume, f, composer, 0), borderStroke, f2);
            ComposerKt.sourceInformationMarkerStart(composer, -1969334406, "CC(remember):Surface.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SurfaceKt.Surface_F_jzlyU$lambda$0$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierM2588surface8ww4TTg, false, (Function1) objRememberedValue);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1969329527, "CC(remember):Surface.kt#9igjgp");
            SurfaceKt$Surface$1$2$1 surfaceKt$Surface$1$2$1RememberedValue = composer.rememberedValue();
            if (surfaceKt$Surface$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                surfaceKt$Surface$1$2$1RememberedValue = new PointerInputEventHandler() { // from class: androidx.compose.material.SurfaceKt$Surface$1$2$1
                    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(surfaceKt$Surface$1$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierSemantics, unit, (PointerInputEventHandler) surfaceKt$Surface$1$2$1RememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPointerInput);
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
            ComposerKt.sourceInformationMarkerStart(composer, -305383667, "C128@6274L9:Surface.kt#jmzs0o");
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
    public static final Unit Surface_F_jzlyU$lambda$0$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0127  */
    /* JADX WARN: Code duplicated, block: B:102:0x012a  */
    /* JADX WARN: Code duplicated, block: B:106:0x013a  */
    /* JADX WARN: Code duplicated, block: B:107:0x013c  */
    /* JADX WARN: Code duplicated, block: B:110:0x0145  */
    /* JADX WARN: Code duplicated, block: B:112:0x0157  */
    /* JADX WARN: Code duplicated, block: B:122:0x0181 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:123:0x0183  */
    /* JADX WARN: Code duplicated, block: B:125:0x018a  */
    /* JADX WARN: Code duplicated, block: B:127:0x018d  */
    /* JADX WARN: Code duplicated, block: B:130:0x0196  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:134:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:137:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:138:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:140:0x01be  */
    /* JADX WARN: Code duplicated, block: B:141:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:143:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:144:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:148:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:151:0x024e  */
    /* JADX WARN: Code duplicated, block: B:153:0x0261  */
    /* JADX WARN: Code duplicated, block: B:156:0x0276  */
    /* JADX WARN: Code duplicated, block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0046  */
    /* JADX WARN: Code duplicated, block: B:24:0x0049  */
    /* JADX WARN: Code duplicated, block: B:26:0x004d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:29:0x0058  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:40:0x0074  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:49:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x009e  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:78:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:89:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:91:0x0103  */
    /* JADX WARN: Code duplicated, block: B:93:0x010d  */
    /* JADX WARN: Code duplicated, block: B:94:0x0110  */
    /* JADX WARN: Code duplicated, block: B:99:0x0121  */
    /* JADX INFO: renamed from: Surface-LPr_se0, reason: not valid java name */
    public static final void m2585SurfaceLPr_se0(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        int i6;
        Shape rectangleShape;
        int i7;
        long jM2346getSurface0d7_KjU;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z3;
        final BorderStroke borderStroke2;
        final Modifier modifier3;
        final boolean z4;
        final Shape shape2;
        final long j3;
        final long j4;
        final float f2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM2360contentColorForek8zF_U;
        BorderStroke borderStroke3;
        float fM9687constructorimpl;
        final MutableInteractionSource mutableInteractionSource3;
        final float f3;
        final Modifier modifier4;
        final boolean z5;
        final Shape shape3;
        final long j5;
        long j6;
        int i15;
        final BorderStroke borderStroke4;
        int i16;
        int i17;
        Composer composerStartRestartGroup = composer.startRestartGroup(2141308794);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Surface)N(onClick,modifier,enabled,shape,color:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,border,elevation:c#ui.unit.Dp,interactionSource,content)208@11026L7,212@11190L967,209@11050L1107:Surface.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i18 = i2 & 2;
        if (i18 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        rectangleShape = shape;
                        if (composerStartRestartGroup.changed(rectangleShape)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((i & 24576) == 0) {
                        if ((i2 & 16) == 0) {
                            jM2346getSurface0d7_KjU = j;
                            int i19 = composerStartRestartGroup.changed(jM2346getSurface0d7_KjU) ? 16384 : 8192;
                            i3 |= i19;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        i3 |= i19;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((196608 & i) == 0) {
                        if ((i2 & 32) == 0) {
                            i17 = i3;
                            int i20 = composerStartRestartGroup.changed(j2) ? 131072 : 65536;
                            i8 = i17 | i20;
                        } else {
                            i17 = i3;
                        }
                        i8 = i17 | i20;
                    } else {
                        i8 = i3;
                    }
                    i9 = i2 & 64;
                    if (i9 != 0) {
                        i8 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i8 |= i10;
                    }
                    i11 = i2 & 128;
                    if (i11 != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changed(f)) {
                                i12 = 8388608;
                            } else {
                                i12 = 4194304;
                            }
                            i8 |= i12;
                        }
                        i13 = i2 & 256;
                        if (i13 != 0) {
                            if ((i & 100663296) == 0) {
                                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                    i14 = 67108864;
                                } else {
                                    i14 = 33554432;
                                }
                                i8 |= i14;
                            }
                            if ((i & 805306368) == 0) {
                                if (composerStartRestartGroup.changedInstance(function2)) {
                                    i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                                } else {
                                    i16 = 268435456;
                                }
                                i8 |= i16;
                            }
                            if ((i8 & 306783379) != 306783378) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i18 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        z2 = true;
                                    }
                                    if (i6 != 0) {
                                        rectangleShape = RectangleShapeKt.getRectangleShape();
                                    }
                                    if ((i2 & 16) != 0) {
                                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                        i8 &= -57345;
                                    }
                                    if ((i2 & 32) != 0) {
                                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                        i8 &= -458753;
                                    } else {
                                        jM2360contentColorForek8zF_U = j2;
                                    }
                                    if (i9 != 0) {
                                        borderStroke3 = null;
                                    } else {
                                        borderStroke3 = borderStroke;
                                    }
                                    if (i11 != 0) {
                                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                                    } else {
                                        fM9687constructorimpl = f;
                                    }
                                    if (i13 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    f3 = fM9687constructorimpl;
                                    modifier4 = modifier2;
                                    z5 = z2;
                                    shape3 = rectangleShape;
                                    j5 = jM2346getSurface0d7_KjU;
                                    j6 = jM2360contentColorForek8zF_U;
                                    i15 = 2141308794;
                                    borderStroke4 = borderStroke3;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 16) != 0) {
                                        i8 &= -57345;
                                    }
                                    if ((i2 & 32) != 0) {
                                        i8 &= -458753;
                                    }
                                    borderStroke4 = borderStroke;
                                    f3 = f;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    modifier4 = modifier2;
                                    z5 = z2;
                                    shape3 = rectangleShape;
                                    j5 = jM2346getSurface0d7_KjU;
                                    i15 = 2141308794;
                                    j6 = j2;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                                }
                                ProvidableCompositionLocal<Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume = composerStartRestartGroup.consume(localAbsoluteElevation);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                final float fM9687constructorimpl2 = Dp.m9687constructorimpl(((Dp) objConsume).m9701unboximpl() + f3);
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl2))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl2, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                j4 = j6;
                                modifier3 = modifier4;
                                shape2 = shape3;
                                j3 = j5;
                                borderStroke2 = borderStroke4;
                                f2 = f3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                                z4 = z5;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                borderStroke2 = borderStroke;
                                modifier3 = modifier2;
                                z4 = z2;
                                shape2 = rectangleShape;
                                j3 = jM2346getSurface0d7_KjU;
                                j4 = j2;
                                f2 = f;
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i8 |= 100663296;
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i16 = 268435456;
                            }
                            i8 |= i16;
                        }
                        if ((i8 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                            if ((i & 1) != 0) {
                                if (i18 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if (i6 != 0) {
                                    rectangleShape = RectangleShapeKt.getRectangleShape();
                                }
                                if ((i2 & 16) != 0) {
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                    i8 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                    i8 &= -458753;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i9 != 0) {
                                    borderStroke3 = null;
                                } else {
                                    borderStroke3 = borderStroke;
                                }
                                if (i11 != 0) {
                                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                                } else {
                                    fM9687constructorimpl = f;
                                }
                                if (i13 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                f3 = fM9687constructorimpl;
                                modifier4 = modifier2;
                                z5 = z2;
                                shape3 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                j6 = jM2360contentColorForek8zF_U;
                                i15 = 2141308794;
                                borderStroke4 = borderStroke3;
                            } else {
                                if (i18 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if (i6 != 0) {
                                    rectangleShape = RectangleShapeKt.getRectangleShape();
                                }
                                if ((i2 & 16) != 0) {
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                    i8 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                    i8 &= -458753;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i9 != 0) {
                                    borderStroke3 = null;
                                } else {
                                    borderStroke3 = borderStroke;
                                }
                                if (i11 != 0) {
                                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                                } else {
                                    fM9687constructorimpl = f;
                                }
                                if (i13 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                f3 = fM9687constructorimpl;
                                modifier4 = modifier2;
                                z5 = z2;
                                shape3 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                j6 = jM2360contentColorForek8zF_U;
                                i15 = 2141308794;
                                borderStroke4 = borderStroke3;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                            }
                            ProvidableCompositionLocal<Dp> localAbsoluteElevation2 = ElevationOverlayKt.getLocalAbsoluteElevation();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composerStartRestartGroup.consume(localAbsoluteElevation2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final float fM9687constructorimpl3 = Dp.m9687constructorimpl(((Dp) objConsume2).m9701unboximpl() + f3);
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl3))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl3, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j4 = j6;
                            modifier3 = modifier4;
                            shape2 = shape3;
                            j3 = j5;
                            borderStroke2 = borderStroke4;
                            f2 = f3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            z4 = z5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            borderStroke2 = borderStroke;
                            modifier3 = modifier2;
                            z4 = z2;
                            shape2 = rectangleShape;
                            j3 = jM2346getSurface0d7_KjU;
                            j4 = j2;
                            f2 = f;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i8 |= 12582912;
                    i13 = i2 & 256;
                    if (i13 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i14 = 67108864;
                            } else {
                                i14 = 33554432;
                            }
                            i8 |= i14;
                        }
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i16 = 268435456;
                            }
                            i8 |= i16;
                        }
                        if ((i8 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                            if ((i & 1) != 0) {
                                if (i18 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if (i6 != 0) {
                                    rectangleShape = RectangleShapeKt.getRectangleShape();
                                }
                                if ((i2 & 16) != 0) {
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                    i8 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                    i8 &= -458753;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i9 != 0) {
                                    borderStroke3 = null;
                                } else {
                                    borderStroke3 = borderStroke;
                                }
                                if (i11 != 0) {
                                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                                } else {
                                    fM9687constructorimpl = f;
                                }
                                if (i13 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                f3 = fM9687constructorimpl;
                                modifier4 = modifier2;
                                z5 = z2;
                                shape3 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                j6 = jM2360contentColorForek8zF_U;
                                i15 = 2141308794;
                                borderStroke4 = borderStroke3;
                            } else {
                                if (i18 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if (i6 != 0) {
                                    rectangleShape = RectangleShapeKt.getRectangleShape();
                                }
                                if ((i2 & 16) != 0) {
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                    i8 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                    i8 &= -458753;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i9 != 0) {
                                    borderStroke3 = null;
                                } else {
                                    borderStroke3 = borderStroke;
                                }
                                if (i11 != 0) {
                                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                                } else {
                                    fM9687constructorimpl = f;
                                }
                                if (i13 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                f3 = fM9687constructorimpl;
                                modifier4 = modifier2;
                                z5 = z2;
                                shape3 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                j6 = jM2360contentColorForek8zF_U;
                                i15 = 2141308794;
                                borderStroke4 = borderStroke3;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                            }
                            ProvidableCompositionLocal<Dp> localAbsoluteElevation3 = ElevationOverlayKt.getLocalAbsoluteElevation();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composerStartRestartGroup.consume(localAbsoluteElevation3);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final float fM9687constructorimpl4 = Dp.m9687constructorimpl(((Dp) objConsume3).m9701unboximpl() + f3);
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl4))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl4, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j4 = j6;
                            modifier3 = modifier4;
                            shape2 = shape3;
                            j3 = j5;
                            borderStroke2 = borderStroke4;
                            f2 = f3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            z4 = z5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            borderStroke2 = borderStroke;
                            modifier3 = modifier2;
                            z4 = z2;
                            shape2 = rectangleShape;
                            j3 = jM2346getSurface0d7_KjU;
                            j4 = j2;
                            f2 = f;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i8 |= 100663296;
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i16 = 268435456;
                        }
                        i8 |= i16;
                    }
                    if ((i8 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                        if ((i & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 16) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i8 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                i8 &= -458753;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            f3 = fM9687constructorimpl;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            j6 = jM2360contentColorForek8zF_U;
                            i15 = 2141308794;
                            borderStroke4 = borderStroke3;
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 16) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i8 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                i8 &= -458753;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            f3 = fM9687constructorimpl;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            j6 = jM2360contentColorForek8zF_U;
                            i15 = 2141308794;
                            borderStroke4 = borderStroke3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                        }
                        ProvidableCompositionLocal<Dp> localAbsoluteElevation4 = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume4 = composerStartRestartGroup.consume(localAbsoluteElevation4);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fM9687constructorimpl5 = Dp.m9687constructorimpl(((Dp) objConsume4).m9701unboximpl() + f3);
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl5))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl5, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = j6;
                        modifier3 = modifier4;
                        shape2 = shape3;
                        j3 = j5;
                        borderStroke2 = borderStroke4;
                        f2 = f3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        z4 = z5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        borderStroke2 = borderStroke;
                        modifier3 = modifier2;
                        z4 = z2;
                        shape2 = rectangleShape;
                        j3 = jM2346getSurface0d7_KjU;
                        j4 = j2;
                        f2 = f;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                rectangleShape = shape;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        jM2346getSurface0d7_KjU = j;
                        if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                        }
                        i3 |= i19;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    i3 |= i19;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        i17 = i3;
                        if (composerStartRestartGroup.changed(j2)) {
                        }
                        i8 = i17 | i20;
                    } else {
                        i17 = i3;
                    }
                    i8 = i17 | i20;
                } else {
                    i8 = i3;
                }
                i9 = i2 & 64;
                if (i9 != 0) {
                    i8 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i8 |= i10;
                }
                i11 = i2 & 128;
                if (i11 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i8 |= i12;
                    }
                    i13 = i2 & 256;
                    if (i13 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i14 = 67108864;
                            } else {
                                i14 = 33554432;
                            }
                            i8 |= i14;
                        }
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i16 = 268435456;
                            }
                            i8 |= i16;
                        }
                        if ((i8 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                            if ((i & 1) != 0) {
                                if (i18 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if (i6 != 0) {
                                    rectangleShape = RectangleShapeKt.getRectangleShape();
                                }
                                if ((i2 & 16) != 0) {
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                    i8 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                    i8 &= -458753;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i9 != 0) {
                                    borderStroke3 = null;
                                } else {
                                    borderStroke3 = borderStroke;
                                }
                                if (i11 != 0) {
                                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                                } else {
                                    fM9687constructorimpl = f;
                                }
                                if (i13 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                f3 = fM9687constructorimpl;
                                modifier4 = modifier2;
                                z5 = z2;
                                shape3 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                j6 = jM2360contentColorForek8zF_U;
                                i15 = 2141308794;
                                borderStroke4 = borderStroke3;
                            } else {
                                if (i18 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if (i6 != 0) {
                                    rectangleShape = RectangleShapeKt.getRectangleShape();
                                }
                                if ((i2 & 16) != 0) {
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                    i8 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                    i8 &= -458753;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i9 != 0) {
                                    borderStroke3 = null;
                                } else {
                                    borderStroke3 = borderStroke;
                                }
                                if (i11 != 0) {
                                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                                } else {
                                    fM9687constructorimpl = f;
                                }
                                if (i13 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                f3 = fM9687constructorimpl;
                                modifier4 = modifier2;
                                z5 = z2;
                                shape3 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                j6 = jM2360contentColorForek8zF_U;
                                i15 = 2141308794;
                                borderStroke4 = borderStroke3;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                            }
                            ProvidableCompositionLocal<Dp> localAbsoluteElevation5 = ElevationOverlayKt.getLocalAbsoluteElevation();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume5 = composerStartRestartGroup.consume(localAbsoluteElevation5);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final float fM9687constructorimpl6 = Dp.m9687constructorimpl(((Dp) objConsume5).m9701unboximpl() + f3);
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl6))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl6, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j4 = j6;
                            modifier3 = modifier4;
                            shape2 = shape3;
                            j3 = j5;
                            borderStroke2 = borderStroke4;
                            f2 = f3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            z4 = z5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            borderStroke2 = borderStroke;
                            modifier3 = modifier2;
                            z4 = z2;
                            shape2 = rectangleShape;
                            j3 = jM2346getSurface0d7_KjU;
                            j4 = j2;
                            f2 = f;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i8 |= 100663296;
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i16 = 268435456;
                        }
                        i8 |= i16;
                    }
                    if ((i8 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                        if ((i & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 16) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i8 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                i8 &= -458753;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            f3 = fM9687constructorimpl;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            j6 = jM2360contentColorForek8zF_U;
                            i15 = 2141308794;
                            borderStroke4 = borderStroke3;
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 16) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i8 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                i8 &= -458753;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            f3 = fM9687constructorimpl;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            j6 = jM2360contentColorForek8zF_U;
                            i15 = 2141308794;
                            borderStroke4 = borderStroke3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                        }
                        ProvidableCompositionLocal<Dp> localAbsoluteElevation6 = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume6 = composerStartRestartGroup.consume(localAbsoluteElevation6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fM9687constructorimpl7 = Dp.m9687constructorimpl(((Dp) objConsume6).m9701unboximpl() + f3);
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl7))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl7, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = j6;
                        modifier3 = modifier4;
                        shape2 = shape3;
                        j3 = j5;
                        borderStroke2 = borderStroke4;
                        f2 = f3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        z4 = z5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        borderStroke2 = borderStroke;
                        modifier3 = modifier2;
                        z4 = z2;
                        shape2 = rectangleShape;
                        j3 = jM2346getSurface0d7_KjU;
                        j4 = j2;
                        f2 = f;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i8 |= 12582912;
                i13 = i2 & 256;
                if (i13 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i14 = 67108864;
                        } else {
                            i14 = 33554432;
                        }
                        i8 |= i14;
                    }
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i16 = 268435456;
                        }
                        i8 |= i16;
                    }
                    if ((i8 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                        if ((i & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 16) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i8 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                i8 &= -458753;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            f3 = fM9687constructorimpl;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            j6 = jM2360contentColorForek8zF_U;
                            i15 = 2141308794;
                            borderStroke4 = borderStroke3;
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 16) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i8 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                i8 &= -458753;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            f3 = fM9687constructorimpl;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            j6 = jM2360contentColorForek8zF_U;
                            i15 = 2141308794;
                            borderStroke4 = borderStroke3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                        }
                        ProvidableCompositionLocal<Dp> localAbsoluteElevation7 = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume7 = composerStartRestartGroup.consume(localAbsoluteElevation7);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fM9687constructorimpl8 = Dp.m9687constructorimpl(((Dp) objConsume7).m9701unboximpl() + f3);
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl8))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl8, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = j6;
                        modifier3 = modifier4;
                        shape2 = shape3;
                        j3 = j5;
                        borderStroke2 = borderStroke4;
                        f2 = f3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        z4 = z5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        borderStroke2 = borderStroke;
                        modifier3 = modifier2;
                        z4 = z2;
                        shape2 = rectangleShape;
                        j3 = jM2346getSurface0d7_KjU;
                        j4 = j2;
                        f2 = f;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i8 |= 100663296;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i16 = 268435456;
                    }
                    i8 |= i16;
                }
                if ((i8 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 16) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                            i8 &= -458753;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        f3 = fM9687constructorimpl;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        j6 = jM2360contentColorForek8zF_U;
                        i15 = 2141308794;
                        borderStroke4 = borderStroke3;
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 16) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                            i8 &= -458753;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        f3 = fM9687constructorimpl;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        j6 = jM2360contentColorForek8zF_U;
                        i15 = 2141308794;
                        borderStroke4 = borderStroke3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation8 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume8 = composerStartRestartGroup.consume(localAbsoluteElevation8);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl9 = Dp.m9687constructorimpl(((Dp) objConsume8).m9701unboximpl() + f3);
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl9))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl9, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j6;
                    modifier3 = modifier4;
                    shape2 = shape3;
                    j3 = j5;
                    borderStroke2 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z4 = z5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    borderStroke2 = borderStroke;
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = rectangleShape;
                    j3 = jM2346getSurface0d7_KjU;
                    j4 = j2;
                    f2 = f;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            z2 = z;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    rectangleShape = shape;
                    if (composerStartRestartGroup.changed(rectangleShape)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        jM2346getSurface0d7_KjU = j;
                        if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                        }
                        i3 |= i19;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    i3 |= i19;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        i17 = i3;
                        if (composerStartRestartGroup.changed(j2)) {
                        }
                        i8 = i17 | i20;
                    } else {
                        i17 = i3;
                    }
                    i8 = i17 | i20;
                } else {
                    i8 = i3;
                }
                i9 = i2 & 64;
                if (i9 != 0) {
                    i8 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i8 |= i10;
                }
                i11 = i2 & 128;
                if (i11 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i8 |= i12;
                    }
                    i13 = i2 & 256;
                    if (i13 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i14 = 67108864;
                            } else {
                                i14 = 33554432;
                            }
                            i8 |= i14;
                        }
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i16 = 268435456;
                            }
                            i8 |= i16;
                        }
                        if ((i8 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                            if ((i & 1) != 0) {
                                if (i18 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if (i6 != 0) {
                                    rectangleShape = RectangleShapeKt.getRectangleShape();
                                }
                                if ((i2 & 16) != 0) {
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                    i8 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                    i8 &= -458753;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i9 != 0) {
                                    borderStroke3 = null;
                                } else {
                                    borderStroke3 = borderStroke;
                                }
                                if (i11 != 0) {
                                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                                } else {
                                    fM9687constructorimpl = f;
                                }
                                if (i13 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                f3 = fM9687constructorimpl;
                                modifier4 = modifier2;
                                z5 = z2;
                                shape3 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                j6 = jM2360contentColorForek8zF_U;
                                i15 = 2141308794;
                                borderStroke4 = borderStroke3;
                            } else {
                                if (i18 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if (i6 != 0) {
                                    rectangleShape = RectangleShapeKt.getRectangleShape();
                                }
                                if ((i2 & 16) != 0) {
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                    i8 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                    i8 &= -458753;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i9 != 0) {
                                    borderStroke3 = null;
                                } else {
                                    borderStroke3 = borderStroke;
                                }
                                if (i11 != 0) {
                                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                                } else {
                                    fM9687constructorimpl = f;
                                }
                                if (i13 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                f3 = fM9687constructorimpl;
                                modifier4 = modifier2;
                                z5 = z2;
                                shape3 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                j6 = jM2360contentColorForek8zF_U;
                                i15 = 2141308794;
                                borderStroke4 = borderStroke3;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                            }
                            ProvidableCompositionLocal<Dp> localAbsoluteElevation9 = ElevationOverlayKt.getLocalAbsoluteElevation();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume9 = composerStartRestartGroup.consume(localAbsoluteElevation9);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final float fM9687constructorimpl10 = Dp.m9687constructorimpl(((Dp) objConsume9).m9701unboximpl() + f3);
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl10))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl10, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j4 = j6;
                            modifier3 = modifier4;
                            shape2 = shape3;
                            j3 = j5;
                            borderStroke2 = borderStroke4;
                            f2 = f3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            z4 = z5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            borderStroke2 = borderStroke;
                            modifier3 = modifier2;
                            z4 = z2;
                            shape2 = rectangleShape;
                            j3 = jM2346getSurface0d7_KjU;
                            j4 = j2;
                            f2 = f;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i8 |= 100663296;
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i16 = 268435456;
                        }
                        i8 |= i16;
                    }
                    if ((i8 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                        if ((i & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 16) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i8 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                i8 &= -458753;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            f3 = fM9687constructorimpl;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            j6 = jM2360contentColorForek8zF_U;
                            i15 = 2141308794;
                            borderStroke4 = borderStroke3;
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 16) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i8 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                i8 &= -458753;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            f3 = fM9687constructorimpl;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            j6 = jM2360contentColorForek8zF_U;
                            i15 = 2141308794;
                            borderStroke4 = borderStroke3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                        }
                        ProvidableCompositionLocal<Dp> localAbsoluteElevation10 = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume10 = composerStartRestartGroup.consume(localAbsoluteElevation10);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fM9687constructorimpl11 = Dp.m9687constructorimpl(((Dp) objConsume10).m9701unboximpl() + f3);
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl11))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl11, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = j6;
                        modifier3 = modifier4;
                        shape2 = shape3;
                        j3 = j5;
                        borderStroke2 = borderStroke4;
                        f2 = f3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        z4 = z5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        borderStroke2 = borderStroke;
                        modifier3 = modifier2;
                        z4 = z2;
                        shape2 = rectangleShape;
                        j3 = jM2346getSurface0d7_KjU;
                        j4 = j2;
                        f2 = f;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i8 |= 12582912;
                i13 = i2 & 256;
                if (i13 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i14 = 67108864;
                        } else {
                            i14 = 33554432;
                        }
                        i8 |= i14;
                    }
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i16 = 268435456;
                        }
                        i8 |= i16;
                    }
                    if ((i8 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                        if ((i & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 16) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i8 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                i8 &= -458753;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            f3 = fM9687constructorimpl;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            j6 = jM2360contentColorForek8zF_U;
                            i15 = 2141308794;
                            borderStroke4 = borderStroke3;
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 16) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i8 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                i8 &= -458753;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            f3 = fM9687constructorimpl;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            j6 = jM2360contentColorForek8zF_U;
                            i15 = 2141308794;
                            borderStroke4 = borderStroke3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                        }
                        ProvidableCompositionLocal<Dp> localAbsoluteElevation11 = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume11 = composerStartRestartGroup.consume(localAbsoluteElevation11);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fM9687constructorimpl12 = Dp.m9687constructorimpl(((Dp) objConsume11).m9701unboximpl() + f3);
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl12))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl12, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = j6;
                        modifier3 = modifier4;
                        shape2 = shape3;
                        j3 = j5;
                        borderStroke2 = borderStroke4;
                        f2 = f3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        z4 = z5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        borderStroke2 = borderStroke;
                        modifier3 = modifier2;
                        z4 = z2;
                        shape2 = rectangleShape;
                        j3 = jM2346getSurface0d7_KjU;
                        j4 = j2;
                        f2 = f;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i8 |= 100663296;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i16 = 268435456;
                    }
                    i8 |= i16;
                }
                if ((i8 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 16) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                            i8 &= -458753;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        f3 = fM9687constructorimpl;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        j6 = jM2360contentColorForek8zF_U;
                        i15 = 2141308794;
                        borderStroke4 = borderStroke3;
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 16) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                            i8 &= -458753;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        f3 = fM9687constructorimpl;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        j6 = jM2360contentColorForek8zF_U;
                        i15 = 2141308794;
                        borderStroke4 = borderStroke3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation12 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume12 = composerStartRestartGroup.consume(localAbsoluteElevation12);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl13 = Dp.m9687constructorimpl(((Dp) objConsume12).m9701unboximpl() + f3);
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl13))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl13, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j6;
                    modifier3 = modifier4;
                    shape2 = shape3;
                    j3 = j5;
                    borderStroke2 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z4 = z5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    borderStroke2 = borderStroke;
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = rectangleShape;
                    j3 = jM2346getSurface0d7_KjU;
                    j4 = j2;
                    f2 = f;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            rectangleShape = shape;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    jM2346getSurface0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                    }
                    i3 |= i19;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                i3 |= i19;
            } else {
                jM2346getSurface0d7_KjU = j;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    i17 = i3;
                    if (composerStartRestartGroup.changed(j2)) {
                    }
                    i8 = i17 | i20;
                } else {
                    i17 = i3;
                }
                i8 = i17 | i20;
            } else {
                i8 = i3;
            }
            i9 = i2 & 64;
            if (i9 != 0) {
                i8 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i8 |= i10;
            }
            i11 = i2 & 128;
            if (i11 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i8 |= i12;
                }
                i13 = i2 & 256;
                if (i13 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i14 = 67108864;
                        } else {
                            i14 = 33554432;
                        }
                        i8 |= i14;
                    }
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i16 = 268435456;
                        }
                        i8 |= i16;
                    }
                    if ((i8 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                        if ((i & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 16) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i8 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                i8 &= -458753;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            f3 = fM9687constructorimpl;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            j6 = jM2360contentColorForek8zF_U;
                            i15 = 2141308794;
                            borderStroke4 = borderStroke3;
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 16) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i8 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                i8 &= -458753;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            f3 = fM9687constructorimpl;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            j6 = jM2360contentColorForek8zF_U;
                            i15 = 2141308794;
                            borderStroke4 = borderStroke3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                        }
                        ProvidableCompositionLocal<Dp> localAbsoluteElevation13 = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume13 = composerStartRestartGroup.consume(localAbsoluteElevation13);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fM9687constructorimpl14 = Dp.m9687constructorimpl(((Dp) objConsume13).m9701unboximpl() + f3);
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl14))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl14, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = j6;
                        modifier3 = modifier4;
                        shape2 = shape3;
                        j3 = j5;
                        borderStroke2 = borderStroke4;
                        f2 = f3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        z4 = z5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        borderStroke2 = borderStroke;
                        modifier3 = modifier2;
                        z4 = z2;
                        shape2 = rectangleShape;
                        j3 = jM2346getSurface0d7_KjU;
                        j4 = j2;
                        f2 = f;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i8 |= 100663296;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i16 = 268435456;
                    }
                    i8 |= i16;
                }
                if ((i8 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 16) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                            i8 &= -458753;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        f3 = fM9687constructorimpl;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        j6 = jM2360contentColorForek8zF_U;
                        i15 = 2141308794;
                        borderStroke4 = borderStroke3;
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 16) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                            i8 &= -458753;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        f3 = fM9687constructorimpl;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        j6 = jM2360contentColorForek8zF_U;
                        i15 = 2141308794;
                        borderStroke4 = borderStroke3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation14 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume14 = composerStartRestartGroup.consume(localAbsoluteElevation14);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl15 = Dp.m9687constructorimpl(((Dp) objConsume14).m9701unboximpl() + f3);
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl15))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl15, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j6;
                    modifier3 = modifier4;
                    shape2 = shape3;
                    j3 = j5;
                    borderStroke2 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z4 = z5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    borderStroke2 = borderStroke;
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = rectangleShape;
                    j3 = jM2346getSurface0d7_KjU;
                    j4 = j2;
                    f2 = f;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i8 |= 12582912;
            i13 = i2 & 256;
            if (i13 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = 67108864;
                    } else {
                        i14 = 33554432;
                    }
                    i8 |= i14;
                }
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i16 = 268435456;
                    }
                    i8 |= i16;
                }
                if ((i8 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 16) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                            i8 &= -458753;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        f3 = fM9687constructorimpl;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        j6 = jM2360contentColorForek8zF_U;
                        i15 = 2141308794;
                        borderStroke4 = borderStroke3;
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 16) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                            i8 &= -458753;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        f3 = fM9687constructorimpl;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        j6 = jM2360contentColorForek8zF_U;
                        i15 = 2141308794;
                        borderStroke4 = borderStroke3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation15 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume15 = composerStartRestartGroup.consume(localAbsoluteElevation15);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl16 = Dp.m9687constructorimpl(((Dp) objConsume15).m9701unboximpl() + f3);
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl16))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl16, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j6;
                    modifier3 = modifier4;
                    shape2 = shape3;
                    j3 = j5;
                    borderStroke2 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z4 = z5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    borderStroke2 = borderStroke;
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = rectangleShape;
                    j3 = jM2346getSurface0d7_KjU;
                    j4 = j2;
                    f2 = f;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i8 |= 100663296;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i16 = 268435456;
                }
                i8 |= i16;
            }
            if ((i8 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                if ((i & 1) != 0) {
                    if (i18 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 16) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i8 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                        i8 &= -458753;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    f3 = fM9687constructorimpl;
                    modifier4 = modifier2;
                    z5 = z2;
                    shape3 = rectangleShape;
                    j5 = jM2346getSurface0d7_KjU;
                    j6 = jM2360contentColorForek8zF_U;
                    i15 = 2141308794;
                    borderStroke4 = borderStroke3;
                } else {
                    if (i18 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 16) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i8 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                        i8 &= -458753;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    f3 = fM9687constructorimpl;
                    modifier4 = modifier2;
                    z5 = z2;
                    shape3 = rectangleShape;
                    j5 = jM2346getSurface0d7_KjU;
                    j6 = jM2360contentColorForek8zF_U;
                    i15 = 2141308794;
                    borderStroke4 = borderStroke3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                }
                ProvidableCompositionLocal<Dp> localAbsoluteElevation16 = ElevationOverlayKt.getLocalAbsoluteElevation();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume16 = composerStartRestartGroup.consume(localAbsoluteElevation16);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float fM9687constructorimpl17 = Dp.m9687constructorimpl(((Dp) objConsume16).m9701unboximpl() + f3);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl17))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl17, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = j6;
                modifier3 = modifier4;
                shape2 = shape3;
                j3 = j5;
                borderStroke2 = borderStroke4;
                f2 = f3;
                mutableInteractionSource2 = mutableInteractionSource3;
                z4 = z5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                borderStroke2 = borderStroke;
                modifier3 = modifier2;
                z4 = z2;
                shape2 = rectangleShape;
                j3 = jM2346getSurface0d7_KjU;
                j4 = j2;
                f2 = f;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    rectangleShape = shape;
                    if (composerStartRestartGroup.changed(rectangleShape)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        jM2346getSurface0d7_KjU = j;
                        if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                        }
                        i3 |= i19;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    i3 |= i19;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        i17 = i3;
                        if (composerStartRestartGroup.changed(j2)) {
                        }
                        i8 = i17 | i20;
                    } else {
                        i17 = i3;
                    }
                    i8 = i17 | i20;
                } else {
                    i8 = i3;
                }
                i9 = i2 & 64;
                if (i9 != 0) {
                    i8 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i8 |= i10;
                }
                i11 = i2 & 128;
                if (i11 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i8 |= i12;
                    }
                    i13 = i2 & 256;
                    if (i13 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i14 = 67108864;
                            } else {
                                i14 = 33554432;
                            }
                            i8 |= i14;
                        }
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i16 = 268435456;
                            }
                            i8 |= i16;
                        }
                        if ((i8 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                            if ((i & 1) != 0) {
                                if (i18 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if (i6 != 0) {
                                    rectangleShape = RectangleShapeKt.getRectangleShape();
                                }
                                if ((i2 & 16) != 0) {
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                    i8 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                    i8 &= -458753;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i9 != 0) {
                                    borderStroke3 = null;
                                } else {
                                    borderStroke3 = borderStroke;
                                }
                                if (i11 != 0) {
                                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                                } else {
                                    fM9687constructorimpl = f;
                                }
                                if (i13 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                f3 = fM9687constructorimpl;
                                modifier4 = modifier2;
                                z5 = z2;
                                shape3 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                j6 = jM2360contentColorForek8zF_U;
                                i15 = 2141308794;
                                borderStroke4 = borderStroke3;
                            } else {
                                if (i18 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if (i6 != 0) {
                                    rectangleShape = RectangleShapeKt.getRectangleShape();
                                }
                                if ((i2 & 16) != 0) {
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                    i8 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                    i8 &= -458753;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i9 != 0) {
                                    borderStroke3 = null;
                                } else {
                                    borderStroke3 = borderStroke;
                                }
                                if (i11 != 0) {
                                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                                } else {
                                    fM9687constructorimpl = f;
                                }
                                if (i13 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                f3 = fM9687constructorimpl;
                                modifier4 = modifier2;
                                z5 = z2;
                                shape3 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                j6 = jM2360contentColorForek8zF_U;
                                i15 = 2141308794;
                                borderStroke4 = borderStroke3;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                            }
                            ProvidableCompositionLocal<Dp> localAbsoluteElevation17 = ElevationOverlayKt.getLocalAbsoluteElevation();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume17 = composerStartRestartGroup.consume(localAbsoluteElevation17);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final float fM9687constructorimpl18 = Dp.m9687constructorimpl(((Dp) objConsume17).m9701unboximpl() + f3);
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl18))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl18, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j4 = j6;
                            modifier3 = modifier4;
                            shape2 = shape3;
                            j3 = j5;
                            borderStroke2 = borderStroke4;
                            f2 = f3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            z4 = z5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            borderStroke2 = borderStroke;
                            modifier3 = modifier2;
                            z4 = z2;
                            shape2 = rectangleShape;
                            j3 = jM2346getSurface0d7_KjU;
                            j4 = j2;
                            f2 = f;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i8 |= 100663296;
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i16 = 268435456;
                        }
                        i8 |= i16;
                    }
                    if ((i8 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                        if ((i & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 16) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i8 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                i8 &= -458753;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            f3 = fM9687constructorimpl;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            j6 = jM2360contentColorForek8zF_U;
                            i15 = 2141308794;
                            borderStroke4 = borderStroke3;
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 16) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i8 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                i8 &= -458753;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            f3 = fM9687constructorimpl;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            j6 = jM2360contentColorForek8zF_U;
                            i15 = 2141308794;
                            borderStroke4 = borderStroke3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                        }
                        ProvidableCompositionLocal<Dp> localAbsoluteElevation18 = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume18 = composerStartRestartGroup.consume(localAbsoluteElevation18);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fM9687constructorimpl19 = Dp.m9687constructorimpl(((Dp) objConsume18).m9701unboximpl() + f3);
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl19))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl19, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = j6;
                        modifier3 = modifier4;
                        shape2 = shape3;
                        j3 = j5;
                        borderStroke2 = borderStroke4;
                        f2 = f3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        z4 = z5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        borderStroke2 = borderStroke;
                        modifier3 = modifier2;
                        z4 = z2;
                        shape2 = rectangleShape;
                        j3 = jM2346getSurface0d7_KjU;
                        j4 = j2;
                        f2 = f;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i8 |= 12582912;
                i13 = i2 & 256;
                if (i13 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i14 = 67108864;
                        } else {
                            i14 = 33554432;
                        }
                        i8 |= i14;
                    }
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i16 = 268435456;
                        }
                        i8 |= i16;
                    }
                    if ((i8 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                        if ((i & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 16) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i8 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                i8 &= -458753;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            f3 = fM9687constructorimpl;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            j6 = jM2360contentColorForek8zF_U;
                            i15 = 2141308794;
                            borderStroke4 = borderStroke3;
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 16) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i8 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                i8 &= -458753;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            f3 = fM9687constructorimpl;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            j6 = jM2360contentColorForek8zF_U;
                            i15 = 2141308794;
                            borderStroke4 = borderStroke3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                        }
                        ProvidableCompositionLocal<Dp> localAbsoluteElevation19 = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume19 = composerStartRestartGroup.consume(localAbsoluteElevation19);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fM9687constructorimpl110 = Dp.m9687constructorimpl(((Dp) objConsume19).m9701unboximpl() + f3);
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl110))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl110, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = j6;
                        modifier3 = modifier4;
                        shape2 = shape3;
                        j3 = j5;
                        borderStroke2 = borderStroke4;
                        f2 = f3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        z4 = z5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        borderStroke2 = borderStroke;
                        modifier3 = modifier2;
                        z4 = z2;
                        shape2 = rectangleShape;
                        j3 = jM2346getSurface0d7_KjU;
                        j4 = j2;
                        f2 = f;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i8 |= 100663296;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i16 = 268435456;
                    }
                    i8 |= i16;
                }
                if ((i8 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 16) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                            i8 &= -458753;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        f3 = fM9687constructorimpl;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        j6 = jM2360contentColorForek8zF_U;
                        i15 = 2141308794;
                        borderStroke4 = borderStroke3;
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 16) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                            i8 &= -458753;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        f3 = fM9687constructorimpl;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        j6 = jM2360contentColorForek8zF_U;
                        i15 = 2141308794;
                        borderStroke4 = borderStroke3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation110 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume110 = composerStartRestartGroup.consume(localAbsoluteElevation110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl111 = Dp.m9687constructorimpl(((Dp) objConsume110).m9701unboximpl() + f3);
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl111))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl111, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j6;
                    modifier3 = modifier4;
                    shape2 = shape3;
                    j3 = j5;
                    borderStroke2 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z4 = z5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    borderStroke2 = borderStroke;
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = rectangleShape;
                    j3 = jM2346getSurface0d7_KjU;
                    j4 = j2;
                    f2 = f;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            rectangleShape = shape;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    jM2346getSurface0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                    }
                    i3 |= i19;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                i3 |= i19;
            } else {
                jM2346getSurface0d7_KjU = j;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    i17 = i3;
                    if (composerStartRestartGroup.changed(j2)) {
                    }
                    i8 = i17 | i20;
                } else {
                    i17 = i3;
                }
                i8 = i17 | i20;
            } else {
                i8 = i3;
            }
            i9 = i2 & 64;
            if (i9 != 0) {
                i8 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i8 |= i10;
            }
            i11 = i2 & 128;
            if (i11 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i8 |= i12;
                }
                i13 = i2 & 256;
                if (i13 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i14 = 67108864;
                        } else {
                            i14 = 33554432;
                        }
                        i8 |= i14;
                    }
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i16 = 268435456;
                        }
                        i8 |= i16;
                    }
                    if ((i8 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                        if ((i & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 16) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i8 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                i8 &= -458753;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            f3 = fM9687constructorimpl;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            j6 = jM2360contentColorForek8zF_U;
                            i15 = 2141308794;
                            borderStroke4 = borderStroke3;
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 16) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i8 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                i8 &= -458753;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            f3 = fM9687constructorimpl;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            j6 = jM2360contentColorForek8zF_U;
                            i15 = 2141308794;
                            borderStroke4 = borderStroke3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                        }
                        ProvidableCompositionLocal<Dp> localAbsoluteElevation111 = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume111 = composerStartRestartGroup.consume(localAbsoluteElevation111);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fM9687constructorimpl112 = Dp.m9687constructorimpl(((Dp) objConsume111).m9701unboximpl() + f3);
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl112))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl112, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = j6;
                        modifier3 = modifier4;
                        shape2 = shape3;
                        j3 = j5;
                        borderStroke2 = borderStroke4;
                        f2 = f3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        z4 = z5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        borderStroke2 = borderStroke;
                        modifier3 = modifier2;
                        z4 = z2;
                        shape2 = rectangleShape;
                        j3 = jM2346getSurface0d7_KjU;
                        j4 = j2;
                        f2 = f;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i8 |= 100663296;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i16 = 268435456;
                    }
                    i8 |= i16;
                }
                if ((i8 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 16) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                            i8 &= -458753;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        f3 = fM9687constructorimpl;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        j6 = jM2360contentColorForek8zF_U;
                        i15 = 2141308794;
                        borderStroke4 = borderStroke3;
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 16) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                            i8 &= -458753;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        f3 = fM9687constructorimpl;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        j6 = jM2360contentColorForek8zF_U;
                        i15 = 2141308794;
                        borderStroke4 = borderStroke3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation112 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume112 = composerStartRestartGroup.consume(localAbsoluteElevation112);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl113 = Dp.m9687constructorimpl(((Dp) objConsume112).m9701unboximpl() + f3);
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl113))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl113, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j6;
                    modifier3 = modifier4;
                    shape2 = shape3;
                    j3 = j5;
                    borderStroke2 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z4 = z5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    borderStroke2 = borderStroke;
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = rectangleShape;
                    j3 = jM2346getSurface0d7_KjU;
                    j4 = j2;
                    f2 = f;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i8 |= 12582912;
            i13 = i2 & 256;
            if (i13 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = 67108864;
                    } else {
                        i14 = 33554432;
                    }
                    i8 |= i14;
                }
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i16 = 268435456;
                    }
                    i8 |= i16;
                }
                if ((i8 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 16) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                            i8 &= -458753;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        f3 = fM9687constructorimpl;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        j6 = jM2360contentColorForek8zF_U;
                        i15 = 2141308794;
                        borderStroke4 = borderStroke3;
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 16) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                            i8 &= -458753;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        f3 = fM9687constructorimpl;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        j6 = jM2360contentColorForek8zF_U;
                        i15 = 2141308794;
                        borderStroke4 = borderStroke3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation113 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume113 = composerStartRestartGroup.consume(localAbsoluteElevation113);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl114 = Dp.m9687constructorimpl(((Dp) objConsume113).m9701unboximpl() + f3);
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl114))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl114, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j6;
                    modifier3 = modifier4;
                    shape2 = shape3;
                    j3 = j5;
                    borderStroke2 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z4 = z5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    borderStroke2 = borderStroke;
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = rectangleShape;
                    j3 = jM2346getSurface0d7_KjU;
                    j4 = j2;
                    f2 = f;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i8 |= 100663296;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i16 = 268435456;
                }
                i8 |= i16;
            }
            if ((i8 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                if ((i & 1) != 0) {
                    if (i18 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 16) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i8 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                        i8 &= -458753;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    f3 = fM9687constructorimpl;
                    modifier4 = modifier2;
                    z5 = z2;
                    shape3 = rectangleShape;
                    j5 = jM2346getSurface0d7_KjU;
                    j6 = jM2360contentColorForek8zF_U;
                    i15 = 2141308794;
                    borderStroke4 = borderStroke3;
                } else {
                    if (i18 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 16) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i8 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                        i8 &= -458753;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    f3 = fM9687constructorimpl;
                    modifier4 = modifier2;
                    z5 = z2;
                    shape3 = rectangleShape;
                    j5 = jM2346getSurface0d7_KjU;
                    j6 = jM2360contentColorForek8zF_U;
                    i15 = 2141308794;
                    borderStroke4 = borderStroke3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                }
                ProvidableCompositionLocal<Dp> localAbsoluteElevation114 = ElevationOverlayKt.getLocalAbsoluteElevation();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume114 = composerStartRestartGroup.consume(localAbsoluteElevation114);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float fM9687constructorimpl115 = Dp.m9687constructorimpl(((Dp) objConsume114).m9701unboximpl() + f3);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl115))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl115, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = j6;
                modifier3 = modifier4;
                shape2 = shape3;
                j3 = j5;
                borderStroke2 = borderStroke4;
                f2 = f3;
                mutableInteractionSource2 = mutableInteractionSource3;
                z4 = z5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                borderStroke2 = borderStroke;
                modifier3 = modifier2;
                z4 = z2;
                shape2 = rectangleShape;
                j3 = jM2346getSurface0d7_KjU;
                j4 = j2;
                f2 = f;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                rectangleShape = shape;
                if (composerStartRestartGroup.changed(rectangleShape)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    jM2346getSurface0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                    }
                    i3 |= i19;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                i3 |= i19;
            } else {
                jM2346getSurface0d7_KjU = j;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    i17 = i3;
                    if (composerStartRestartGroup.changed(j2)) {
                    }
                    i8 = i17 | i20;
                } else {
                    i17 = i3;
                }
                i8 = i17 | i20;
            } else {
                i8 = i3;
            }
            i9 = i2 & 64;
            if (i9 != 0) {
                i8 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i8 |= i10;
            }
            i11 = i2 & 128;
            if (i11 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i8 |= i12;
                }
                i13 = i2 & 256;
                if (i13 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i14 = 67108864;
                        } else {
                            i14 = 33554432;
                        }
                        i8 |= i14;
                    }
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i16 = 268435456;
                        }
                        i8 |= i16;
                    }
                    if ((i8 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                        if ((i & 1) != 0) {
                            if (i18 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 16) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i8 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                i8 &= -458753;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            f3 = fM9687constructorimpl;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            j6 = jM2360contentColorForek8zF_U;
                            i15 = 2141308794;
                            borderStroke4 = borderStroke3;
                        } else {
                            if (i18 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 16) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i8 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                                i8 &= -458753;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            f3 = fM9687constructorimpl;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            j6 = jM2360contentColorForek8zF_U;
                            i15 = 2141308794;
                            borderStroke4 = borderStroke3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                        }
                        ProvidableCompositionLocal<Dp> localAbsoluteElevation115 = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume115 = composerStartRestartGroup.consume(localAbsoluteElevation115);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fM9687constructorimpl116 = Dp.m9687constructorimpl(((Dp) objConsume115).m9701unboximpl() + f3);
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl116))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl116, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = j6;
                        modifier3 = modifier4;
                        shape2 = shape3;
                        j3 = j5;
                        borderStroke2 = borderStroke4;
                        f2 = f3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        z4 = z5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        borderStroke2 = borderStroke;
                        modifier3 = modifier2;
                        z4 = z2;
                        shape2 = rectangleShape;
                        j3 = jM2346getSurface0d7_KjU;
                        j4 = j2;
                        f2 = f;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i8 |= 100663296;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i16 = 268435456;
                    }
                    i8 |= i16;
                }
                if ((i8 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 16) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                            i8 &= -458753;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        f3 = fM9687constructorimpl;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        j6 = jM2360contentColorForek8zF_U;
                        i15 = 2141308794;
                        borderStroke4 = borderStroke3;
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 16) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                            i8 &= -458753;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        f3 = fM9687constructorimpl;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        j6 = jM2360contentColorForek8zF_U;
                        i15 = 2141308794;
                        borderStroke4 = borderStroke3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation116 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume116 = composerStartRestartGroup.consume(localAbsoluteElevation116);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl117 = Dp.m9687constructorimpl(((Dp) objConsume116).m9701unboximpl() + f3);
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl117))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl117, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j6;
                    modifier3 = modifier4;
                    shape2 = shape3;
                    j3 = j5;
                    borderStroke2 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z4 = z5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    borderStroke2 = borderStroke;
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = rectangleShape;
                    j3 = jM2346getSurface0d7_KjU;
                    j4 = j2;
                    f2 = f;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i8 |= 12582912;
            i13 = i2 & 256;
            if (i13 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = 67108864;
                    } else {
                        i14 = 33554432;
                    }
                    i8 |= i14;
                }
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i16 = 268435456;
                    }
                    i8 |= i16;
                }
                if ((i8 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 16) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                            i8 &= -458753;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        f3 = fM9687constructorimpl;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        j6 = jM2360contentColorForek8zF_U;
                        i15 = 2141308794;
                        borderStroke4 = borderStroke3;
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 16) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                            i8 &= -458753;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        f3 = fM9687constructorimpl;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        j6 = jM2360contentColorForek8zF_U;
                        i15 = 2141308794;
                        borderStroke4 = borderStroke3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation117 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume117 = composerStartRestartGroup.consume(localAbsoluteElevation117);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl118 = Dp.m9687constructorimpl(((Dp) objConsume117).m9701unboximpl() + f3);
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl118))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl118, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j6;
                    modifier3 = modifier4;
                    shape2 = shape3;
                    j3 = j5;
                    borderStroke2 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z4 = z5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    borderStroke2 = borderStroke;
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = rectangleShape;
                    j3 = jM2346getSurface0d7_KjU;
                    j4 = j2;
                    f2 = f;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i8 |= 100663296;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i16 = 268435456;
                }
                i8 |= i16;
            }
            if ((i8 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                if ((i & 1) != 0) {
                    if (i18 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 16) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i8 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                        i8 &= -458753;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    f3 = fM9687constructorimpl;
                    modifier4 = modifier2;
                    z5 = z2;
                    shape3 = rectangleShape;
                    j5 = jM2346getSurface0d7_KjU;
                    j6 = jM2360contentColorForek8zF_U;
                    i15 = 2141308794;
                    borderStroke4 = borderStroke3;
                } else {
                    if (i18 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 16) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i8 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                        i8 &= -458753;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    f3 = fM9687constructorimpl;
                    modifier4 = modifier2;
                    z5 = z2;
                    shape3 = rectangleShape;
                    j5 = jM2346getSurface0d7_KjU;
                    j6 = jM2360contentColorForek8zF_U;
                    i15 = 2141308794;
                    borderStroke4 = borderStroke3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                }
                ProvidableCompositionLocal<Dp> localAbsoluteElevation118 = ElevationOverlayKt.getLocalAbsoluteElevation();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume118 = composerStartRestartGroup.consume(localAbsoluteElevation118);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float fM9687constructorimpl119 = Dp.m9687constructorimpl(((Dp) objConsume118).m9701unboximpl() + f3);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl119))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl119, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = j6;
                modifier3 = modifier4;
                shape2 = shape3;
                j3 = j5;
                borderStroke2 = borderStroke4;
                f2 = f3;
                mutableInteractionSource2 = mutableInteractionSource3;
                z4 = z5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                borderStroke2 = borderStroke;
                modifier3 = modifier2;
                z4 = z2;
                shape2 = rectangleShape;
                j3 = jM2346getSurface0d7_KjU;
                j4 = j2;
                f2 = f;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        rectangleShape = shape;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                jM2346getSurface0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                }
                i3 |= i19;
            } else {
                jM2346getSurface0d7_KjU = j;
            }
            i3 |= i19;
        } else {
            jM2346getSurface0d7_KjU = j;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                i17 = i3;
                if (composerStartRestartGroup.changed(j2)) {
                }
                i8 = i17 | i20;
            } else {
                i17 = i3;
            }
            i8 = i17 | i20;
        } else {
            i8 = i3;
        }
        i9 = i2 & 64;
        if (i9 != 0) {
            i8 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changed(borderStroke)) {
                i10 = 1048576;
            } else {
                i10 = 524288;
            }
            i8 |= i10;
        }
        i11 = i2 & 128;
        if (i11 != 0) {
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i8 |= i12;
            }
            i13 = i2 & 256;
            if (i13 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = 67108864;
                    } else {
                        i14 = 33554432;
                    }
                    i8 |= i14;
                }
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i16 = 268435456;
                    }
                    i8 |= i16;
                }
                if ((i8 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 16) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                            i8 &= -458753;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        f3 = fM9687constructorimpl;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        j6 = jM2360contentColorForek8zF_U;
                        i15 = 2141308794;
                        borderStroke4 = borderStroke3;
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 16) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                            i8 &= -458753;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        f3 = fM9687constructorimpl;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        j6 = jM2360contentColorForek8zF_U;
                        i15 = 2141308794;
                        borderStroke4 = borderStroke3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation119 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume119 = composerStartRestartGroup.consume(localAbsoluteElevation119);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl1110 = Dp.m9687constructorimpl(((Dp) objConsume119).m9701unboximpl() + f3);
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl1110))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl1110, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j6;
                    modifier3 = modifier4;
                    shape2 = shape3;
                    j3 = j5;
                    borderStroke2 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z4 = z5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    borderStroke2 = borderStroke;
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = rectangleShape;
                    j3 = jM2346getSurface0d7_KjU;
                    j4 = j2;
                    f2 = f;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i8 |= 100663296;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i16 = 268435456;
                }
                i8 |= i16;
            }
            if ((i8 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                if ((i & 1) != 0) {
                    if (i18 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 16) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i8 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                        i8 &= -458753;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    f3 = fM9687constructorimpl;
                    modifier4 = modifier2;
                    z5 = z2;
                    shape3 = rectangleShape;
                    j5 = jM2346getSurface0d7_KjU;
                    j6 = jM2360contentColorForek8zF_U;
                    i15 = 2141308794;
                    borderStroke4 = borderStroke3;
                } else {
                    if (i18 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 16) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i8 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                        i8 &= -458753;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    f3 = fM9687constructorimpl;
                    modifier4 = modifier2;
                    z5 = z2;
                    shape3 = rectangleShape;
                    j5 = jM2346getSurface0d7_KjU;
                    j6 = jM2360contentColorForek8zF_U;
                    i15 = 2141308794;
                    borderStroke4 = borderStroke3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                }
                ProvidableCompositionLocal<Dp> localAbsoluteElevation1110 = ElevationOverlayKt.getLocalAbsoluteElevation();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume1110 = composerStartRestartGroup.consume(localAbsoluteElevation1110);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float fM9687constructorimpl1111 = Dp.m9687constructorimpl(((Dp) objConsume1110).m9701unboximpl() + f3);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl1111))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl1111, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = j6;
                modifier3 = modifier4;
                shape2 = shape3;
                j3 = j5;
                borderStroke2 = borderStroke4;
                f2 = f3;
                mutableInteractionSource2 = mutableInteractionSource3;
                z4 = z5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                borderStroke2 = borderStroke;
                modifier3 = modifier2;
                z4 = z2;
                shape2 = rectangleShape;
                j3 = jM2346getSurface0d7_KjU;
                j4 = j2;
                f2 = f;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i8 |= 12582912;
        i13 = i2 & 256;
        if (i13 != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i14 = 67108864;
                } else {
                    i14 = 33554432;
                }
                i8 |= i14;
            }
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i16 = 268435456;
                }
                i8 |= i16;
            }
            if ((i8 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
                if ((i & 1) != 0) {
                    if (i18 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 16) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i8 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                        i8 &= -458753;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    f3 = fM9687constructorimpl;
                    modifier4 = modifier2;
                    z5 = z2;
                    shape3 = rectangleShape;
                    j5 = jM2346getSurface0d7_KjU;
                    j6 = jM2360contentColorForek8zF_U;
                    i15 = 2141308794;
                    borderStroke4 = borderStroke3;
                } else {
                    if (i18 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 16) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i8 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                        i8 &= -458753;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    f3 = fM9687constructorimpl;
                    modifier4 = modifier2;
                    z5 = z2;
                    shape3 = rectangleShape;
                    j5 = jM2346getSurface0d7_KjU;
                    j6 = jM2360contentColorForek8zF_U;
                    i15 = 2141308794;
                    borderStroke4 = borderStroke3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
                }
                ProvidableCompositionLocal<Dp> localAbsoluteElevation1111 = ElevationOverlayKt.getLocalAbsoluteElevation();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume1111 = composerStartRestartGroup.consume(localAbsoluteElevation1111);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float fM9687constructorimpl1112 = Dp.m9687constructorimpl(((Dp) objConsume1111).m9701unboximpl() + f3);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl1112))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl1112, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = j6;
                modifier3 = modifier4;
                shape2 = shape3;
                j3 = j5;
                borderStroke2 = borderStroke4;
                f2 = f3;
                mutableInteractionSource2 = mutableInteractionSource3;
                z4 = z5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                borderStroke2 = borderStroke;
                modifier3 = modifier2;
                z4 = z2;
                shape2 = rectangleShape;
                j3 = jM2346getSurface0d7_KjU;
                j4 = j2;
                f2 = f;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i8 |= 100663296;
        if ((i & 805306368) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i16 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i16 = 268435456;
            }
            i8 |= i16;
        }
        if ((i8 & 306783379) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "201@10751L6,202@10793L22");
            if ((i & 1) != 0) {
                if (i18 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if (i6 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 16) != 0) {
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    i8 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                    i8 &= -458753;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                if (i9 != 0) {
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke;
                }
                if (i11 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl = f;
                }
                if (i13 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                f3 = fM9687constructorimpl;
                modifier4 = modifier2;
                z5 = z2;
                shape3 = rectangleShape;
                j5 = jM2346getSurface0d7_KjU;
                j6 = jM2360contentColorForek8zF_U;
                i15 = 2141308794;
                borderStroke4 = borderStroke3;
            } else {
                if (i18 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if (i6 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 16) != 0) {
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    i8 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 12) & 14);
                    i8 &= -458753;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                if (i9 != 0) {
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke;
                }
                if (i11 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl = f;
                }
                if (i13 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                f3 = fM9687constructorimpl;
                modifier4 = modifier2;
                z5 = z2;
                shape3 = rectangleShape;
                j5 = jM2346getSurface0d7_KjU;
                j6 = jM2360contentColorForek8zF_U;
                i15 = 2141308794;
                borderStroke4 = borderStroke3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i15, i8, -1, "androidx.compose.material.Surface (Surface.kt:207)");
            }
            ProvidableCompositionLocal<Dp> localAbsoluteElevation1112 = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume1112 = composerStartRestartGroup.consume(localAbsoluteElevation1112);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final float fM9687constructorimpl1113 = Dp.m9687constructorimpl(((Dp) objConsume1112).m9701unboximpl() + f3);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j6)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl1113))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SurfaceKt.Surface_LPr_se0$lambda$0(modifier4, shape3, j5, fM9687constructorimpl1113, borderStroke4, f3, mutableInteractionSource3, z5, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j4 = j6;
            modifier3 = modifier4;
            shape2 = shape3;
            j3 = j5;
            borderStroke2 = borderStroke4;
            f2 = f3;
            mutableInteractionSource2 = mutableInteractionSource3;
            z4 = z5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            borderStroke2 = borderStroke;
            modifier3 = modifier2;
            z4 = z2;
            shape2 = rectangleShape;
            j3 = jM2346getSurface0d7_KjU;
            j4 = j2;
            f2 = f;
            mutableInteractionSource2 = mutableInteractionSource;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SurfaceKt.Surface_LPr_se0$lambda$1(function0, modifier3, z4, shape2, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_LPr_se0$lambda$0(Modifier modifier, Shape shape, long j, float f, BorderStroke borderStroke, float f2, MutableInteractionSource mutableInteractionSource, boolean z, Function0 function0, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C222@11592L7,220@11447L254,213@11200L951:Surface.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1766606150, i, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:213)");
            }
            Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier);
            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localElevationOverlay);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierM628clickableO2vRcR0$default = ClickableKt.m628clickableO2vRcR0$default(m2588surface8ww4TTg(modifierMinimumInteractiveComponentSize, shape, m2589surfaceColorAtElevationcq6XJ1M(j, (ElevationOverlay) objConsume, f, composer, 0), borderStroke, f2), mutableInteractionSource, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, 0L, 7, null), z, null, null, function0, 24, null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM628clickableO2vRcR0$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -2077913498, "C236@12132L9:Surface.kt#jmzs0o");
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

    /* JADX WARN: Code duplicated, block: B:100:0x0120  */
    /* JADX WARN: Code duplicated, block: B:104:0x012a  */
    /* JADX WARN: Code duplicated, block: B:106:0x0130  */
    /* JADX WARN: Code duplicated, block: B:107:0x0133  */
    /* JADX WARN: Code duplicated, block: B:109:0x013a  */
    /* JADX WARN: Code duplicated, block: B:112:0x0149  */
    /* JADX WARN: Code duplicated, block: B:116:0x0151  */
    /* JADX WARN: Code duplicated, block: B:119:0x015a  */
    /* JADX WARN: Code duplicated, block: B:121:0x016c  */
    /* JADX WARN: Code duplicated, block: B:131:0x0195 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:132:0x0197  */
    /* JADX WARN: Code duplicated, block: B:133:0x019c  */
    /* JADX WARN: Code duplicated, block: B:135:0x019f  */
    /* JADX WARN: Code duplicated, block: B:137:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:138:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:141:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:142:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:145:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:146:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:148:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:150:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:151:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:153:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:154:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:157:0x0205  */
    /* JADX WARN: Code duplicated, block: B:160:0x0270  */
    /* JADX WARN: Code duplicated, block: B:162:0x0283  */
    /* JADX WARN: Code duplicated, block: B:165:0x0298  */
    /* JADX WARN: Code duplicated, block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:32:0x005e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:43:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0086  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:55:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:78:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:79:0x00df  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:94:0x010c  */
    /* JADX WARN: Code duplicated, block: B:95:0x0111  */
    /* JADX WARN: Code duplicated, block: B:97:0x0117  */
    /* JADX WARN: Code duplicated, block: B:99:0x011d  */
    /* JADX INFO: renamed from: Surface-Ny5ogXk, reason: not valid java name */
    public static final void m2586SurfaceNy5ogXk(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function0<Unit> function1;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        int i7;
        Shape shape2;
        int i8;
        int i9;
        BorderStroke borderStroke2;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z4;
        final long j3;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final boolean z5;
        final Shape shape3;
        final BorderStroke borderStroke3;
        final long j4;
        final float f2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Shape rectangleShape;
        long jM2346getSurface0d7_KjU;
        long jM2360contentColorForek8zF_U;
        float fM9687constructorimpl;
        final MutableInteractionSource mutableInteractionSource3;
        final float f3;
        final Shape shape4;
        final long j5;
        final boolean z6;
        final BorderStroke borderStroke4;
        int i16;
        int i17;
        int i18;
        int i19;
        Composer composerStartRestartGroup = composer.startRestartGroup(-258978402);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Surface)N(selected,onClick,modifier,enabled,shape,color:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,border,elevation:c#ui.unit.Dp,interactionSource,content)318@16972L7,322@17136L1013,319@16996L1153:Surface.kt#jmzs0o");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            function1 = function0;
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        int i20 = i3 & 4;
        if (i20 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i & 3072) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 16;
                if (i7 != 0) {
                    if ((i & 24576) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i4 |= i8;
                    }
                    if ((196608 & i) != 0) {
                        if ((i3 & 32) == 0 || !composerStartRestartGroup.changed(j)) {
                            i19 = 65536;
                        } else {
                            i19 = 131072;
                        }
                        i4 |= i19;
                    }
                    if ((i & 1572864) != 0) {
                        if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(j2)) {
                            i18 = 524288;
                        } else {
                            i18 = 1048576;
                        }
                        i4 |= i18;
                    }
                    i9 = i3 & 128;
                    if (i9 != 0) {
                        i4 |= 12582912;
                        borderStroke2 = borderStroke;
                    } else {
                        borderStroke2 = borderStroke;
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changed(borderStroke2)) {
                                i10 = 8388608;
                            } else {
                                i10 = 4194304;
                            }
                            i4 |= i10;
                        }
                    }
                    i11 = i3 & 256;
                    if (i11 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(f)) {
                                i12 = 67108864;
                            } else {
                                i12 = 33554432;
                            }
                            i4 |= i12;
                        }
                        i13 = i3 & 512;
                        if (i13 != 0) {
                            i4 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i14 = 268435456;
                            }
                            i4 |= i14;
                        }
                        if ((i2 & 6) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i17 = 4;
                            } else {
                                i17 = 2;
                            }
                            i15 = i2 | i17;
                        } else {
                            i15 = i2;
                        }
                        if ((i4 & 306783379) == 306783378 || (i15 & 3) != 2) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "311@16697L6,312@16739L22");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i20 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier2;
                                }
                                if (i5 != 0) {
                                    z3 = true;
                                }
                                if (i7 != 0) {
                                    rectangleShape = RectangleShapeKt.getRectangleShape();
                                } else {
                                    rectangleShape = shape2;
                                }
                                if ((i3 & 32) != 0) {
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                    i4 &= -458753;
                                } else {
                                    jM2346getSurface0d7_KjU = j;
                                }
                                if ((i3 & 64) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                                    i4 = (-3670017) & i4;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i9 != 0) {
                                    borderStroke2 = null;
                                }
                                if (i11 != 0) {
                                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                                } else {
                                    fM9687constructorimpl = f;
                                }
                                if (i13 != 0) {
                                    f3 = fM9687constructorimpl;
                                    shape4 = rectangleShape;
                                    j5 = jM2346getSurface0d7_KjU;
                                    z6 = z3;
                                    borderStroke4 = borderStroke2;
                                    i16 = -258978402;
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    f3 = fM9687constructorimpl;
                                    shape4 = rectangleShape;
                                    j5 = jM2346getSurface0d7_KjU;
                                    z6 = z3;
                                    borderStroke4 = borderStroke2;
                                    i16 = -258978402;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                j5 = j;
                                f3 = f;
                                mutableInteractionSource3 = mutableInteractionSource;
                                companion = modifier2;
                                z6 = z3;
                                shape4 = shape2;
                                borderStroke4 = borderStroke2;
                                i16 = -258978402;
                                jM2360contentColorForek8zF_U = j2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:317)");
                            }
                            ProvidableCompositionLocal<Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localAbsoluteElevation);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final float fM9687constructorimpl2 = Dp.m9687constructorimpl(((Dp) objConsume).m9701unboximpl() + f3);
                            final Modifier modifier4 = companion;
                            final Function0<Unit> function3 = function1;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl2))}, ComposableLambdaKt.rememberComposableLambda(1830486238, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SurfaceKt.Surface_Ny5ogXk$lambda$0(modifier4, shape4, j5, fM9687constructorimpl2, borderStroke4, f3, z, mutableInteractionSource3, z6, function3, function2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j4 = jM2360contentColorForek8zF_U;
                            modifier3 = modifier4;
                            shape3 = shape4;
                            j3 = j5;
                            borderStroke3 = borderStroke4;
                            f2 = f3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            z5 = z6;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            j3 = j;
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            z5 = z3;
                            shape3 = shape2;
                            borderStroke3 = borderStroke2;
                            j4 = j2;
                            f2 = f;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SurfaceKt.Surface_Ny5ogXk$lambda$1(z, function0, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i4 |= 100663296;
                    i13 = i3 & 512;
                    if (i13 != 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i17 = 4;
                        } else {
                            i17 = 2;
                        }
                        i15 = i2 | i17;
                    } else {
                        i15 = i2;
                    }
                    if ((i4 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "311@16697L6,312@16739L22");
                        if ((i & 1) != 0) {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            } else {
                                rectangleShape = shape2;
                            }
                            if ((i3 & 32) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i4 &= -458753;
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 = (-3670017) & i4;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke2 = null;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -258978402;
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -258978402;
                            }
                        } else {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            } else {
                                rectangleShape = shape2;
                            }
                            if ((i3 & 32) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i4 &= -458753;
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 = (-3670017) & i4;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke2 = null;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -258978402;
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -258978402;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:317)");
                        }
                        ProvidableCompositionLocal<Dp> localAbsoluteElevation2 = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localAbsoluteElevation2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fM9687constructorimpl3 = Dp.m9687constructorimpl(((Dp) objConsume2).m9701unboximpl() + f3);
                        final Modifier modifier5 = companion;
                        final Function0 function4 = function1;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl3))}, ComposableLambdaKt.rememberComposableLambda(1830486238, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_Ny5ogXk$lambda$0(modifier5, shape4, j5, fM9687constructorimpl3, borderStroke4, f3, z, mutableInteractionSource3, z6, function4, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = jM2360contentColorForek8zF_U;
                        modifier3 = modifier5;
                        shape3 = shape4;
                        j3 = j5;
                        borderStroke3 = borderStroke4;
                        f2 = f3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        z5 = z6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j3 = j;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z5 = z3;
                        shape3 = shape2;
                        borderStroke3 = borderStroke2;
                        j4 = j2;
                        f2 = f;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_Ny5ogXk$lambda$1(z, function0, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 24576;
                shape2 = shape;
                if ((196608 & i) != 0) {
                    if ((i3 & 32) == 0) {
                        i19 = 65536;
                    } else {
                        i19 = 65536;
                    }
                    i4 |= i19;
                }
                if ((i & 1572864) != 0) {
                    if ((i3 & 64) == 0) {
                        i18 = 524288;
                    } else {
                        i18 = 524288;
                    }
                    i4 |= i18;
                }
                i9 = i3 & 128;
                if (i9 != 0) {
                    i4 |= 12582912;
                    borderStroke2 = borderStroke;
                } else {
                    borderStroke2 = borderStroke;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke2)) {
                            i10 = 8388608;
                        } else {
                            i10 = 4194304;
                        }
                        i4 |= i10;
                    }
                }
                i11 = i3 & 256;
                if (i11 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                        i4 |= i12;
                    }
                    i13 = i3 & 512;
                    if (i13 != 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i17 = 4;
                        } else {
                            i17 = 2;
                        }
                        i15 = i2 | i17;
                    } else {
                        i15 = i2;
                    }
                    if ((i4 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "311@16697L6,312@16739L22");
                        if ((i & 1) != 0) {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            } else {
                                rectangleShape = shape2;
                            }
                            if ((i3 & 32) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i4 &= -458753;
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 = (-3670017) & i4;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke2 = null;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -258978402;
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -258978402;
                            }
                        } else {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            } else {
                                rectangleShape = shape2;
                            }
                            if ((i3 & 32) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i4 &= -458753;
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 = (-3670017) & i4;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke2 = null;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -258978402;
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -258978402;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:317)");
                        }
                        ProvidableCompositionLocal<Dp> localAbsoluteElevation3 = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composerStartRestartGroup.consume(localAbsoluteElevation3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fM9687constructorimpl4 = Dp.m9687constructorimpl(((Dp) objConsume3).m9701unboximpl() + f3);
                        final Modifier modifier6 = companion;
                        final Function0 function5 = function1;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl4))}, ComposableLambdaKt.rememberComposableLambda(1830486238, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_Ny5ogXk$lambda$0(modifier6, shape4, j5, fM9687constructorimpl4, borderStroke4, f3, z, mutableInteractionSource3, z6, function5, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = jM2360contentColorForek8zF_U;
                        modifier3 = modifier6;
                        shape3 = shape4;
                        j3 = j5;
                        borderStroke3 = borderStroke4;
                        f2 = f3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        z5 = z6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j3 = j;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z5 = z3;
                        shape3 = shape2;
                        borderStroke3 = borderStroke2;
                        j4 = j2;
                        f2 = f;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_Ny5ogXk$lambda$1(z, function0, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 100663296;
                i13 = i3 & 512;
                if (i13 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i15 = i2 | i17;
                } else {
                    i15 = i2;
                }
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "311@16697L6,312@16739L22");
                    if ((i & 1) != 0) {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                        }
                    } else {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:317)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation4 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localAbsoluteElevation4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl5 = Dp.m9687constructorimpl(((Dp) objConsume4).m9701unboximpl() + f3);
                    final Modifier modifier7 = companion;
                    final Function0 function6 = function1;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl5))}, ComposableLambdaKt.rememberComposableLambda(1830486238, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$0(modifier7, shape4, j5, fM9687constructorimpl5, borderStroke4, f3, z, mutableInteractionSource3, z6, function6, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = jM2360contentColorForek8zF_U;
                    modifier3 = modifier7;
                    shape3 = shape4;
                    j3 = j5;
                    borderStroke3 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z5 = z6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j3 = j;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    j4 = j2;
                    f2 = f;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$1(z, function0, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            z3 = z2;
            i7 = i3 & 16;
            if (i7 != 0) {
                if ((i & 24576) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                if ((196608 & i) != 0) {
                    if ((i3 & 32) == 0) {
                        i19 = 65536;
                    } else {
                        i19 = 65536;
                    }
                    i4 |= i19;
                }
                if ((i & 1572864) != 0) {
                    if ((i3 & 64) == 0) {
                        i18 = 524288;
                    } else {
                        i18 = 524288;
                    }
                    i4 |= i18;
                }
                i9 = i3 & 128;
                if (i9 != 0) {
                    i4 |= 12582912;
                    borderStroke2 = borderStroke;
                } else {
                    borderStroke2 = borderStroke;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke2)) {
                            i10 = 8388608;
                        } else {
                            i10 = 4194304;
                        }
                        i4 |= i10;
                    }
                }
                i11 = i3 & 256;
                if (i11 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                        i4 |= i12;
                    }
                    i13 = i3 & 512;
                    if (i13 != 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i17 = 4;
                        } else {
                            i17 = 2;
                        }
                        i15 = i2 | i17;
                    } else {
                        i15 = i2;
                    }
                    if ((i4 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "311@16697L6,312@16739L22");
                        if ((i & 1) != 0) {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            } else {
                                rectangleShape = shape2;
                            }
                            if ((i3 & 32) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i4 &= -458753;
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 = (-3670017) & i4;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke2 = null;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -258978402;
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -258978402;
                            }
                        } else {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            } else {
                                rectangleShape = shape2;
                            }
                            if ((i3 & 32) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i4 &= -458753;
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 = (-3670017) & i4;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke2 = null;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -258978402;
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -258978402;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:317)");
                        }
                        ProvidableCompositionLocal<Dp> localAbsoluteElevation5 = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume5 = composerStartRestartGroup.consume(localAbsoluteElevation5);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fM9687constructorimpl6 = Dp.m9687constructorimpl(((Dp) objConsume5).m9701unboximpl() + f3);
                        final Modifier modifier8 = companion;
                        final Function0 function7 = function1;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl6))}, ComposableLambdaKt.rememberComposableLambda(1830486238, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_Ny5ogXk$lambda$0(modifier8, shape4, j5, fM9687constructorimpl6, borderStroke4, f3, z, mutableInteractionSource3, z6, function7, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = jM2360contentColorForek8zF_U;
                        modifier3 = modifier8;
                        shape3 = shape4;
                        j3 = j5;
                        borderStroke3 = borderStroke4;
                        f2 = f3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        z5 = z6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j3 = j;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z5 = z3;
                        shape3 = shape2;
                        borderStroke3 = borderStroke2;
                        j4 = j2;
                        f2 = f;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_Ny5ogXk$lambda$1(z, function0, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 100663296;
                i13 = i3 & 512;
                if (i13 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i15 = i2 | i17;
                } else {
                    i15 = i2;
                }
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "311@16697L6,312@16739L22");
                    if ((i & 1) != 0) {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                        }
                    } else {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:317)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation6 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume6 = composerStartRestartGroup.consume(localAbsoluteElevation6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl7 = Dp.m9687constructorimpl(((Dp) objConsume6).m9701unboximpl() + f3);
                    final Modifier modifier9 = companion;
                    final Function0 function8 = function1;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl7))}, ComposableLambdaKt.rememberComposableLambda(1830486238, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$0(modifier9, shape4, j5, fM9687constructorimpl7, borderStroke4, f3, z, mutableInteractionSource3, z6, function8, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = jM2360contentColorForek8zF_U;
                    modifier3 = modifier9;
                    shape3 = shape4;
                    j3 = j5;
                    borderStroke3 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z5 = z6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j3 = j;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    j4 = j2;
                    f2 = f;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$1(z, function0, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            shape2 = shape;
            if ((196608 & i) != 0) {
                if ((i3 & 32) == 0) {
                    i19 = 65536;
                } else {
                    i19 = 65536;
                }
                i4 |= i19;
            }
            if ((i & 1572864) != 0) {
                if ((i3 & 64) == 0) {
                    i18 = 524288;
                } else {
                    i18 = 524288;
                }
                i4 |= i18;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i4 |= 12582912;
                borderStroke2 = borderStroke;
            } else {
                borderStroke2 = borderStroke;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
            }
            i11 = i3 & 256;
            if (i11 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
                i13 = i3 & 512;
                if (i13 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i15 = i2 | i17;
                } else {
                    i15 = i2;
                }
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "311@16697L6,312@16739L22");
                    if ((i & 1) != 0) {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                        }
                    } else {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:317)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation7 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume7 = composerStartRestartGroup.consume(localAbsoluteElevation7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl8 = Dp.m9687constructorimpl(((Dp) objConsume7).m9701unboximpl() + f3);
                    final Modifier modifier10 = companion;
                    final Function0 function9 = function1;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl8))}, ComposableLambdaKt.rememberComposableLambda(1830486238, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$0(modifier10, shape4, j5, fM9687constructorimpl8, borderStroke4, f3, z, mutableInteractionSource3, z6, function9, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = jM2360contentColorForek8zF_U;
                    modifier3 = modifier10;
                    shape3 = shape4;
                    j3 = j5;
                    borderStroke3 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z5 = z6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j3 = j;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    j4 = j2;
                    f2 = f;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$1(z, function0, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            i13 = i3 & 512;
            if (i13 != 0) {
                i4 |= 805306368;
            } else if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i15 = i2 | i17;
            } else {
                i15 = i2;
            }
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "311@16697L6,312@16739L22");
                if ((i & 1) != 0) {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i3 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i4 &= -458753;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 = (-3670017) & i4;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -258978402;
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -258978402;
                    }
                } else {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i3 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i4 &= -458753;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 = (-3670017) & i4;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -258978402;
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -258978402;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:317)");
                }
                ProvidableCompositionLocal<Dp> localAbsoluteElevation8 = ElevationOverlayKt.getLocalAbsoluteElevation();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume8 = composerStartRestartGroup.consume(localAbsoluteElevation8);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float fM9687constructorimpl9 = Dp.m9687constructorimpl(((Dp) objConsume8).m9701unboximpl() + f3);
                final Modifier modifier11 = companion;
                final Function0 function10 = function1;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl9))}, ComposableLambdaKt.rememberComposableLambda(1830486238, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_Ny5ogXk$lambda$0(modifier11, shape4, j5, fM9687constructorimpl9, borderStroke4, f3, z, mutableInteractionSource3, z6, function10, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = jM2360contentColorForek8zF_U;
                modifier3 = modifier11;
                shape3 = shape4;
                j3 = j5;
                borderStroke3 = borderStroke4;
                f2 = f3;
                mutableInteractionSource2 = mutableInteractionSource3;
                z5 = z6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                j3 = j;
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                shape3 = shape2;
                borderStroke3 = borderStroke2;
                j4 = j2;
                f2 = f;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_Ny5ogXk$lambda$1(z, function0, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i & 3072) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            i7 = i3 & 16;
            if (i7 != 0) {
                if ((i & 24576) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                if ((196608 & i) != 0) {
                    if ((i3 & 32) == 0) {
                        i19 = 65536;
                    } else {
                        i19 = 65536;
                    }
                    i4 |= i19;
                }
                if ((i & 1572864) != 0) {
                    if ((i3 & 64) == 0) {
                        i18 = 524288;
                    } else {
                        i18 = 524288;
                    }
                    i4 |= i18;
                }
                i9 = i3 & 128;
                if (i9 != 0) {
                    i4 |= 12582912;
                    borderStroke2 = borderStroke;
                } else {
                    borderStroke2 = borderStroke;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke2)) {
                            i10 = 8388608;
                        } else {
                            i10 = 4194304;
                        }
                        i4 |= i10;
                    }
                }
                i11 = i3 & 256;
                if (i11 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                        i4 |= i12;
                    }
                    i13 = i3 & 512;
                    if (i13 != 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i17 = 4;
                        } else {
                            i17 = 2;
                        }
                        i15 = i2 | i17;
                    } else {
                        i15 = i2;
                    }
                    if ((i4 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "311@16697L6,312@16739L22");
                        if ((i & 1) != 0) {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            } else {
                                rectangleShape = shape2;
                            }
                            if ((i3 & 32) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i4 &= -458753;
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 = (-3670017) & i4;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke2 = null;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -258978402;
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -258978402;
                            }
                        } else {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            } else {
                                rectangleShape = shape2;
                            }
                            if ((i3 & 32) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i4 &= -458753;
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 = (-3670017) & i4;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke2 = null;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -258978402;
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -258978402;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:317)");
                        }
                        ProvidableCompositionLocal<Dp> localAbsoluteElevation9 = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume9 = composerStartRestartGroup.consume(localAbsoluteElevation9);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fM9687constructorimpl10 = Dp.m9687constructorimpl(((Dp) objConsume9).m9701unboximpl() + f3);
                        final Modifier modifier12 = companion;
                        final Function0 function11 = function1;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl10))}, ComposableLambdaKt.rememberComposableLambda(1830486238, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_Ny5ogXk$lambda$0(modifier12, shape4, j5, fM9687constructorimpl10, borderStroke4, f3, z, mutableInteractionSource3, z6, function11, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = jM2360contentColorForek8zF_U;
                        modifier3 = modifier12;
                        shape3 = shape4;
                        j3 = j5;
                        borderStroke3 = borderStroke4;
                        f2 = f3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        z5 = z6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j3 = j;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z5 = z3;
                        shape3 = shape2;
                        borderStroke3 = borderStroke2;
                        j4 = j2;
                        f2 = f;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_Ny5ogXk$lambda$1(z, function0, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 100663296;
                i13 = i3 & 512;
                if (i13 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i15 = i2 | i17;
                } else {
                    i15 = i2;
                }
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "311@16697L6,312@16739L22");
                    if ((i & 1) != 0) {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                        }
                    } else {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:317)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation10 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume10 = composerStartRestartGroup.consume(localAbsoluteElevation10);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl11 = Dp.m9687constructorimpl(((Dp) objConsume10).m9701unboximpl() + f3);
                    final Modifier modifier13 = companion;
                    final Function0 function12 = function1;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl11))}, ComposableLambdaKt.rememberComposableLambda(1830486238, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$0(modifier13, shape4, j5, fM9687constructorimpl11, borderStroke4, f3, z, mutableInteractionSource3, z6, function12, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = jM2360contentColorForek8zF_U;
                    modifier3 = modifier13;
                    shape3 = shape4;
                    j3 = j5;
                    borderStroke3 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z5 = z6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j3 = j;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    j4 = j2;
                    f2 = f;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$1(z, function0, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            shape2 = shape;
            if ((196608 & i) != 0) {
                if ((i3 & 32) == 0) {
                    i19 = 65536;
                } else {
                    i19 = 65536;
                }
                i4 |= i19;
            }
            if ((i & 1572864) != 0) {
                if ((i3 & 64) == 0) {
                    i18 = 524288;
                } else {
                    i18 = 524288;
                }
                i4 |= i18;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i4 |= 12582912;
                borderStroke2 = borderStroke;
            } else {
                borderStroke2 = borderStroke;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
            }
            i11 = i3 & 256;
            if (i11 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
                i13 = i3 & 512;
                if (i13 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i15 = i2 | i17;
                } else {
                    i15 = i2;
                }
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "311@16697L6,312@16739L22");
                    if ((i & 1) != 0) {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                        }
                    } else {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:317)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation11 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume11 = composerStartRestartGroup.consume(localAbsoluteElevation11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl12 = Dp.m9687constructorimpl(((Dp) objConsume11).m9701unboximpl() + f3);
                    final Modifier modifier14 = companion;
                    final Function0 function13 = function1;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl12))}, ComposableLambdaKt.rememberComposableLambda(1830486238, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$0(modifier14, shape4, j5, fM9687constructorimpl12, borderStroke4, f3, z, mutableInteractionSource3, z6, function13, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = jM2360contentColorForek8zF_U;
                    modifier3 = modifier14;
                    shape3 = shape4;
                    j3 = j5;
                    borderStroke3 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z5 = z6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j3 = j;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    j4 = j2;
                    f2 = f;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$1(z, function0, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            i13 = i3 & 512;
            if (i13 != 0) {
                i4 |= 805306368;
            } else if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i15 = i2 | i17;
            } else {
                i15 = i2;
            }
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "311@16697L6,312@16739L22");
                if ((i & 1) != 0) {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i3 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i4 &= -458753;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 = (-3670017) & i4;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -258978402;
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -258978402;
                    }
                } else {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i3 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i4 &= -458753;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 = (-3670017) & i4;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -258978402;
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -258978402;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:317)");
                }
                ProvidableCompositionLocal<Dp> localAbsoluteElevation12 = ElevationOverlayKt.getLocalAbsoluteElevation();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume12 = composerStartRestartGroup.consume(localAbsoluteElevation12);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float fM9687constructorimpl13 = Dp.m9687constructorimpl(((Dp) objConsume12).m9701unboximpl() + f3);
                final Modifier modifier15 = companion;
                final Function0 function14 = function1;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl13))}, ComposableLambdaKt.rememberComposableLambda(1830486238, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_Ny5ogXk$lambda$0(modifier15, shape4, j5, fM9687constructorimpl13, borderStroke4, f3, z, mutableInteractionSource3, z6, function14, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = jM2360contentColorForek8zF_U;
                modifier3 = modifier15;
                shape3 = shape4;
                j3 = j5;
                borderStroke3 = borderStroke4;
                f2 = f3;
                mutableInteractionSource2 = mutableInteractionSource3;
                z5 = z6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                j3 = j;
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                shape3 = shape2;
                borderStroke3 = borderStroke2;
                j4 = j2;
                f2 = f;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_Ny5ogXk$lambda$1(z, function0, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        z3 = z2;
        i7 = i3 & 16;
        if (i7 != 0) {
            if ((i & 24576) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i4 |= i8;
            }
            if ((196608 & i) != 0) {
                if ((i3 & 32) == 0) {
                    i19 = 65536;
                } else {
                    i19 = 65536;
                }
                i4 |= i19;
            }
            if ((i & 1572864) != 0) {
                if ((i3 & 64) == 0) {
                    i18 = 524288;
                } else {
                    i18 = 524288;
                }
                i4 |= i18;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i4 |= 12582912;
                borderStroke2 = borderStroke;
            } else {
                borderStroke2 = borderStroke;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
            }
            i11 = i3 & 256;
            if (i11 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
                i13 = i3 & 512;
                if (i13 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i15 = i2 | i17;
                } else {
                    i15 = i2;
                }
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "311@16697L6,312@16739L22");
                    if ((i & 1) != 0) {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                        }
                    } else {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -258978402;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:317)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation13 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume13 = composerStartRestartGroup.consume(localAbsoluteElevation13);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl14 = Dp.m9687constructorimpl(((Dp) objConsume13).m9701unboximpl() + f3);
                    final Modifier modifier16 = companion;
                    final Function0 function15 = function1;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl14))}, ComposableLambdaKt.rememberComposableLambda(1830486238, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$0(modifier16, shape4, j5, fM9687constructorimpl14, borderStroke4, f3, z, mutableInteractionSource3, z6, function15, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = jM2360contentColorForek8zF_U;
                    modifier3 = modifier16;
                    shape3 = shape4;
                    j3 = j5;
                    borderStroke3 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z5 = z6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j3 = j;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    j4 = j2;
                    f2 = f;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$1(z, function0, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            i13 = i3 & 512;
            if (i13 != 0) {
                i4 |= 805306368;
            } else if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i15 = i2 | i17;
            } else {
                i15 = i2;
            }
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "311@16697L6,312@16739L22");
                if ((i & 1) != 0) {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i3 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i4 &= -458753;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 = (-3670017) & i4;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -258978402;
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -258978402;
                    }
                } else {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i3 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i4 &= -458753;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 = (-3670017) & i4;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -258978402;
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -258978402;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:317)");
                }
                ProvidableCompositionLocal<Dp> localAbsoluteElevation14 = ElevationOverlayKt.getLocalAbsoluteElevation();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume14 = composerStartRestartGroup.consume(localAbsoluteElevation14);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float fM9687constructorimpl15 = Dp.m9687constructorimpl(((Dp) objConsume14).m9701unboximpl() + f3);
                final Modifier modifier17 = companion;
                final Function0 function16 = function1;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl15))}, ComposableLambdaKt.rememberComposableLambda(1830486238, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_Ny5ogXk$lambda$0(modifier17, shape4, j5, fM9687constructorimpl15, borderStroke4, f3, z, mutableInteractionSource3, z6, function16, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = jM2360contentColorForek8zF_U;
                modifier3 = modifier17;
                shape3 = shape4;
                j3 = j5;
                borderStroke3 = borderStroke4;
                f2 = f3;
                mutableInteractionSource2 = mutableInteractionSource3;
                z5 = z6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                j3 = j;
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                shape3 = shape2;
                borderStroke3 = borderStroke2;
                j4 = j2;
                f2 = f;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_Ny5ogXk$lambda$1(z, function0, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        shape2 = shape;
        if ((196608 & i) != 0) {
            if ((i3 & 32) == 0) {
                i19 = 65536;
            } else {
                i19 = 65536;
            }
            i4 |= i19;
        }
        if ((i & 1572864) != 0) {
            if ((i3 & 64) == 0) {
                i18 = 524288;
            } else {
                i18 = 524288;
            }
            i4 |= i18;
        }
        i9 = i3 & 128;
        if (i9 != 0) {
            i4 |= 12582912;
            borderStroke2 = borderStroke;
        } else {
            borderStroke2 = borderStroke;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(borderStroke2)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i4 |= i10;
            }
        }
        i11 = i3 & 256;
        if (i11 != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i4 |= i12;
            }
            i13 = i3 & 512;
            if (i13 != 0) {
                i4 |= 805306368;
            } else if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i15 = i2 | i17;
            } else {
                i15 = i2;
            }
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "311@16697L6,312@16739L22");
                if ((i & 1) != 0) {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i3 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i4 &= -458753;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 = (-3670017) & i4;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -258978402;
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -258978402;
                    }
                } else {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i3 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i4 &= -458753;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 = (-3670017) & i4;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -258978402;
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -258978402;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:317)");
                }
                ProvidableCompositionLocal<Dp> localAbsoluteElevation15 = ElevationOverlayKt.getLocalAbsoluteElevation();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume15 = composerStartRestartGroup.consume(localAbsoluteElevation15);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float fM9687constructorimpl16 = Dp.m9687constructorimpl(((Dp) objConsume15).m9701unboximpl() + f3);
                final Modifier modifier18 = companion;
                final Function0 function17 = function1;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl16))}, ComposableLambdaKt.rememberComposableLambda(1830486238, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_Ny5ogXk$lambda$0(modifier18, shape4, j5, fM9687constructorimpl16, borderStroke4, f3, z, mutableInteractionSource3, z6, function17, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = jM2360contentColorForek8zF_U;
                modifier3 = modifier18;
                shape3 = shape4;
                j3 = j5;
                borderStroke3 = borderStroke4;
                f2 = f3;
                mutableInteractionSource2 = mutableInteractionSource3;
                z5 = z6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                j3 = j;
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                shape3 = shape2;
                borderStroke3 = borderStroke2;
                j4 = j2;
                f2 = f;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_Ny5ogXk$lambda$1(z, function0, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 100663296;
        i13 = i3 & 512;
        if (i13 != 0) {
            i4 |= 805306368;
        } else if ((i & 805306368) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i14 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i14 = 268435456;
            }
            i4 |= i14;
        }
        if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i17 = 4;
            } else {
                i17 = 2;
            }
            i15 = i2 | i17;
        } else {
            i15 = i2;
        }
        if ((i4 & 306783379) == 306783378) {
            z4 = true;
        } else {
            z4 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "311@16697L6,312@16739L22");
            if ((i & 1) != 0) {
                if (i20 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if (i7 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape2;
                }
                if ((i3 & 32) != 0) {
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    i4 &= -458753;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                if ((i3 & 64) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                    i4 = (-3670017) & i4;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                if (i9 != 0) {
                    borderStroke2 = null;
                }
                if (i11 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl = f;
                }
                if (i13 != 0) {
                    f3 = fM9687constructorimpl;
                    shape4 = rectangleShape;
                    j5 = jM2346getSurface0d7_KjU;
                    z6 = z3;
                    borderStroke4 = borderStroke2;
                    i16 = -258978402;
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                    f3 = fM9687constructorimpl;
                    shape4 = rectangleShape;
                    j5 = jM2346getSurface0d7_KjU;
                    z6 = z3;
                    borderStroke4 = borderStroke2;
                    i16 = -258978402;
                }
            } else {
                if (i20 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if (i7 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape2;
                }
                if ((i3 & 32) != 0) {
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    i4 &= -458753;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                if ((i3 & 64) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                    i4 = (-3670017) & i4;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                if (i9 != 0) {
                    borderStroke2 = null;
                }
                if (i11 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl = f;
                }
                if (i13 != 0) {
                    f3 = fM9687constructorimpl;
                    shape4 = rectangleShape;
                    j5 = jM2346getSurface0d7_KjU;
                    z6 = z3;
                    borderStroke4 = borderStroke2;
                    i16 = -258978402;
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                    f3 = fM9687constructorimpl;
                    shape4 = rectangleShape;
                    j5 = jM2346getSurface0d7_KjU;
                    z6 = z3;
                    borderStroke4 = borderStroke2;
                    i16 = -258978402;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:317)");
            }
            ProvidableCompositionLocal<Dp> localAbsoluteElevation16 = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume16 = composerStartRestartGroup.consume(localAbsoluteElevation16);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final float fM9687constructorimpl17 = Dp.m9687constructorimpl(((Dp) objConsume16).m9701unboximpl() + f3);
            final Modifier modifier19 = companion;
            final Function0 function18 = function1;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl17))}, ComposableLambdaKt.rememberComposableLambda(1830486238, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SurfaceKt.Surface_Ny5ogXk$lambda$0(modifier19, shape4, j5, fM9687constructorimpl17, borderStroke4, f3, z, mutableInteractionSource3, z6, function18, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j4 = jM2360contentColorForek8zF_U;
            modifier3 = modifier19;
            shape3 = shape4;
            j3 = j5;
            borderStroke3 = borderStroke4;
            f2 = f3;
            mutableInteractionSource2 = mutableInteractionSource3;
            z5 = z6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            j3 = j;
            mutableInteractionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
            z5 = z3;
            shape3 = shape2;
            borderStroke3 = borderStroke2;
            j4 = j2;
            f2 = f;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SurfaceKt.Surface_Ny5ogXk$lambda$1(z, function0, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_Ny5ogXk$lambda$0(Modifier modifier, Shape shape, long j, float f, BorderStroke borderStroke, float f2, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function0 function0, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C332@17538L7,330@17393L254,323@17146L997:Surface.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1830486238, i, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:323)");
            }
            Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier);
            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localElevationOverlay);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierM1534selectableO2vRcR0$default = SelectableKt.m1534selectableO2vRcR0$default(m2588surface8ww4TTg(modifierMinimumInteractiveComponentSize, shape, m2589surfaceColorAtElevationcq6XJ1M(j, (ElevationOverlay) objConsume, f, composer, 0), borderStroke, f2), z, mutableInteractionSource, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, 0L, 7, null), z2, null, function0, 16, null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1534selectableO2vRcR0$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1999142974, "C347@18124L9:Surface.kt#jmzs0o");
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

    /* JADX WARN: Code duplicated, block: B:100:0x0120  */
    /* JADX WARN: Code duplicated, block: B:104:0x012a  */
    /* JADX WARN: Code duplicated, block: B:106:0x0130  */
    /* JADX WARN: Code duplicated, block: B:107:0x0133  */
    /* JADX WARN: Code duplicated, block: B:109:0x013a  */
    /* JADX WARN: Code duplicated, block: B:112:0x0149  */
    /* JADX WARN: Code duplicated, block: B:116:0x0151  */
    /* JADX WARN: Code duplicated, block: B:119:0x015a  */
    /* JADX WARN: Code duplicated, block: B:121:0x016c  */
    /* JADX WARN: Code duplicated, block: B:131:0x0195 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:132:0x0197  */
    /* JADX WARN: Code duplicated, block: B:133:0x019c  */
    /* JADX WARN: Code duplicated, block: B:135:0x019f  */
    /* JADX WARN: Code duplicated, block: B:137:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:138:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:141:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:142:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:145:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:146:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:148:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:150:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:151:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:153:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:154:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:157:0x0205  */
    /* JADX WARN: Code duplicated, block: B:160:0x0270  */
    /* JADX WARN: Code duplicated, block: B:162:0x0283  */
    /* JADX WARN: Code duplicated, block: B:165:0x0298  */
    /* JADX WARN: Code duplicated, block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:32:0x005e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:43:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0086  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:55:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:78:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:79:0x00df  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:94:0x010c  */
    /* JADX WARN: Code duplicated, block: B:95:0x0111  */
    /* JADX WARN: Code duplicated, block: B:97:0x0117  */
    /* JADX WARN: Code duplicated, block: B:99:0x011d  */
    /* JADX INFO: renamed from: Surface-Ny5ogXk, reason: not valid java name */
    public static final void m2587SurfaceNy5ogXk(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function1<? super Boolean, Unit> function3;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        int i7;
        Shape shape2;
        int i8;
        int i9;
        BorderStroke borderStroke2;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z4;
        final long j3;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final boolean z5;
        final Shape shape3;
        final BorderStroke borderStroke3;
        final long j4;
        final float f2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Shape rectangleShape;
        long jM2346getSurface0d7_KjU;
        long jM2360contentColorForek8zF_U;
        float fM9687constructorimpl;
        final MutableInteractionSource mutableInteractionSource3;
        final float f3;
        final Shape shape4;
        final long j5;
        final boolean z6;
        final BorderStroke borderStroke4;
        int i16;
        int i17;
        int i18;
        int i19;
        Composer composerStartRestartGroup = composer.startRestartGroup(-391302147);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Surface)N(checked,onCheckedChange,modifier,enabled,shape,color:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,border,elevation:c#ui.unit.Dp,interactionSource,content)429@23038L7,433@23202L1023,430@23062L1163:Surface.kt#jmzs0o");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            function3 = function1;
            i4 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        } else {
            function3 = function1;
        }
        int i20 = i3 & 4;
        if (i20 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i & 3072) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 16;
                if (i7 != 0) {
                    if ((i & 24576) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i4 |= i8;
                    }
                    if ((196608 & i) != 0) {
                        if ((i3 & 32) == 0 || !composerStartRestartGroup.changed(j)) {
                            i19 = 65536;
                        } else {
                            i19 = 131072;
                        }
                        i4 |= i19;
                    }
                    if ((i & 1572864) != 0) {
                        if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(j2)) {
                            i18 = 524288;
                        } else {
                            i18 = 1048576;
                        }
                        i4 |= i18;
                    }
                    i9 = i3 & 128;
                    if (i9 != 0) {
                        i4 |= 12582912;
                        borderStroke2 = borderStroke;
                    } else {
                        borderStroke2 = borderStroke;
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changed(borderStroke2)) {
                                i10 = 8388608;
                            } else {
                                i10 = 4194304;
                            }
                            i4 |= i10;
                        }
                    }
                    i11 = i3 & 256;
                    if (i11 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(f)) {
                                i12 = 67108864;
                            } else {
                                i12 = 33554432;
                            }
                            i4 |= i12;
                        }
                        i13 = i3 & 512;
                        if (i13 != 0) {
                            i4 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i14 = 268435456;
                            }
                            i4 |= i14;
                        }
                        if ((i2 & 6) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i17 = 4;
                            } else {
                                i17 = 2;
                            }
                            i15 = i2 | i17;
                        } else {
                            i15 = i2;
                        }
                        if ((i4 & 306783379) == 306783378 || (i15 & 3) != 2) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "422@22763L6,423@22805L22");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i20 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier2;
                                }
                                if (i5 != 0) {
                                    z3 = true;
                                }
                                if (i7 != 0) {
                                    rectangleShape = RectangleShapeKt.getRectangleShape();
                                } else {
                                    rectangleShape = shape2;
                                }
                                if ((i3 & 32) != 0) {
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                    i4 &= -458753;
                                } else {
                                    jM2346getSurface0d7_KjU = j;
                                }
                                if ((i3 & 64) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                                    i4 = (-3670017) & i4;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i9 != 0) {
                                    borderStroke2 = null;
                                }
                                if (i11 != 0) {
                                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                                } else {
                                    fM9687constructorimpl = f;
                                }
                                if (i13 != 0) {
                                    f3 = fM9687constructorimpl;
                                    shape4 = rectangleShape;
                                    j5 = jM2346getSurface0d7_KjU;
                                    z6 = z3;
                                    borderStroke4 = borderStroke2;
                                    i16 = -391302147;
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    f3 = fM9687constructorimpl;
                                    shape4 = rectangleShape;
                                    j5 = jM2346getSurface0d7_KjU;
                                    z6 = z3;
                                    borderStroke4 = borderStroke2;
                                    i16 = -391302147;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                j5 = j;
                                f3 = f;
                                mutableInteractionSource3 = mutableInteractionSource;
                                companion = modifier2;
                                z6 = z3;
                                shape4 = shape2;
                                borderStroke4 = borderStroke2;
                                i16 = -391302147;
                                jM2360contentColorForek8zF_U = j2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:428)");
                            }
                            ProvidableCompositionLocal<Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localAbsoluteElevation);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final float fM9687constructorimpl2 = Dp.m9687constructorimpl(((Dp) objConsume).m9701unboximpl() + f3);
                            final Modifier modifier4 = companion;
                            final Function1<? super Boolean, Unit> function4 = function3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl2))}, ComposableLambdaKt.rememberComposableLambda(1698162493, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SurfaceKt.Surface_Ny5ogXk$lambda$2(modifier4, shape4, j5, fM9687constructorimpl2, borderStroke4, f3, z, mutableInteractionSource3, z6, function4, function2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j4 = jM2360contentColorForek8zF_U;
                            modifier3 = modifier4;
                            shape3 = shape4;
                            j3 = j5;
                            borderStroke3 = borderStroke4;
                            f2 = f3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            z5 = z6;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            j3 = j;
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            z5 = z3;
                            shape3 = shape2;
                            borderStroke3 = borderStroke2;
                            j4 = j2;
                            f2 = f;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SurfaceKt.Surface_Ny5ogXk$lambda$3(z, function1, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i4 |= 100663296;
                    i13 = i3 & 512;
                    if (i13 != 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i17 = 4;
                        } else {
                            i17 = 2;
                        }
                        i15 = i2 | i17;
                    } else {
                        i15 = i2;
                    }
                    if ((i4 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "422@22763L6,423@22805L22");
                        if ((i & 1) != 0) {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            } else {
                                rectangleShape = shape2;
                            }
                            if ((i3 & 32) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i4 &= -458753;
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 = (-3670017) & i4;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke2 = null;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -391302147;
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -391302147;
                            }
                        } else {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            } else {
                                rectangleShape = shape2;
                            }
                            if ((i3 & 32) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i4 &= -458753;
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 = (-3670017) & i4;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke2 = null;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -391302147;
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -391302147;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:428)");
                        }
                        ProvidableCompositionLocal<Dp> localAbsoluteElevation2 = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localAbsoluteElevation2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fM9687constructorimpl3 = Dp.m9687constructorimpl(((Dp) objConsume2).m9701unboximpl() + f3);
                        final Modifier modifier5 = companion;
                        final Function1 function5 = function3;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl3))}, ComposableLambdaKt.rememberComposableLambda(1698162493, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_Ny5ogXk$lambda$2(modifier5, shape4, j5, fM9687constructorimpl3, borderStroke4, f3, z, mutableInteractionSource3, z6, function5, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = jM2360contentColorForek8zF_U;
                        modifier3 = modifier5;
                        shape3 = shape4;
                        j3 = j5;
                        borderStroke3 = borderStroke4;
                        f2 = f3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        z5 = z6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j3 = j;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z5 = z3;
                        shape3 = shape2;
                        borderStroke3 = borderStroke2;
                        j4 = j2;
                        f2 = f;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_Ny5ogXk$lambda$3(z, function1, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 24576;
                shape2 = shape;
                if ((196608 & i) != 0) {
                    if ((i3 & 32) == 0) {
                        i19 = 65536;
                    } else {
                        i19 = 65536;
                    }
                    i4 |= i19;
                }
                if ((i & 1572864) != 0) {
                    if ((i3 & 64) == 0) {
                        i18 = 524288;
                    } else {
                        i18 = 524288;
                    }
                    i4 |= i18;
                }
                i9 = i3 & 128;
                if (i9 != 0) {
                    i4 |= 12582912;
                    borderStroke2 = borderStroke;
                } else {
                    borderStroke2 = borderStroke;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke2)) {
                            i10 = 8388608;
                        } else {
                            i10 = 4194304;
                        }
                        i4 |= i10;
                    }
                }
                i11 = i3 & 256;
                if (i11 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                        i4 |= i12;
                    }
                    i13 = i3 & 512;
                    if (i13 != 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i17 = 4;
                        } else {
                            i17 = 2;
                        }
                        i15 = i2 | i17;
                    } else {
                        i15 = i2;
                    }
                    if ((i4 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "422@22763L6,423@22805L22");
                        if ((i & 1) != 0) {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            } else {
                                rectangleShape = shape2;
                            }
                            if ((i3 & 32) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i4 &= -458753;
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 = (-3670017) & i4;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke2 = null;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -391302147;
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -391302147;
                            }
                        } else {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            } else {
                                rectangleShape = shape2;
                            }
                            if ((i3 & 32) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i4 &= -458753;
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 = (-3670017) & i4;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke2 = null;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -391302147;
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -391302147;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:428)");
                        }
                        ProvidableCompositionLocal<Dp> localAbsoluteElevation3 = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composerStartRestartGroup.consume(localAbsoluteElevation3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fM9687constructorimpl4 = Dp.m9687constructorimpl(((Dp) objConsume3).m9701unboximpl() + f3);
                        final Modifier modifier6 = companion;
                        final Function1 function6 = function3;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl4))}, ComposableLambdaKt.rememberComposableLambda(1698162493, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_Ny5ogXk$lambda$2(modifier6, shape4, j5, fM9687constructorimpl4, borderStroke4, f3, z, mutableInteractionSource3, z6, function6, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = jM2360contentColorForek8zF_U;
                        modifier3 = modifier6;
                        shape3 = shape4;
                        j3 = j5;
                        borderStroke3 = borderStroke4;
                        f2 = f3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        z5 = z6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j3 = j;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z5 = z3;
                        shape3 = shape2;
                        borderStroke3 = borderStroke2;
                        j4 = j2;
                        f2 = f;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_Ny5ogXk$lambda$3(z, function1, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 100663296;
                i13 = i3 & 512;
                if (i13 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i15 = i2 | i17;
                } else {
                    i15 = i2;
                }
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "422@22763L6,423@22805L22");
                    if ((i & 1) != 0) {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                        }
                    } else {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:428)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation4 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localAbsoluteElevation4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl5 = Dp.m9687constructorimpl(((Dp) objConsume4).m9701unboximpl() + f3);
                    final Modifier modifier7 = companion;
                    final Function1 function7 = function3;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl5))}, ComposableLambdaKt.rememberComposableLambda(1698162493, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$2(modifier7, shape4, j5, fM9687constructorimpl5, borderStroke4, f3, z, mutableInteractionSource3, z6, function7, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = jM2360contentColorForek8zF_U;
                    modifier3 = modifier7;
                    shape3 = shape4;
                    j3 = j5;
                    borderStroke3 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z5 = z6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j3 = j;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    j4 = j2;
                    f2 = f;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$3(z, function1, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            z3 = z2;
            i7 = i3 & 16;
            if (i7 != 0) {
                if ((i & 24576) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                if ((196608 & i) != 0) {
                    if ((i3 & 32) == 0) {
                        i19 = 65536;
                    } else {
                        i19 = 65536;
                    }
                    i4 |= i19;
                }
                if ((i & 1572864) != 0) {
                    if ((i3 & 64) == 0) {
                        i18 = 524288;
                    } else {
                        i18 = 524288;
                    }
                    i4 |= i18;
                }
                i9 = i3 & 128;
                if (i9 != 0) {
                    i4 |= 12582912;
                    borderStroke2 = borderStroke;
                } else {
                    borderStroke2 = borderStroke;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke2)) {
                            i10 = 8388608;
                        } else {
                            i10 = 4194304;
                        }
                        i4 |= i10;
                    }
                }
                i11 = i3 & 256;
                if (i11 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                        i4 |= i12;
                    }
                    i13 = i3 & 512;
                    if (i13 != 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i17 = 4;
                        } else {
                            i17 = 2;
                        }
                        i15 = i2 | i17;
                    } else {
                        i15 = i2;
                    }
                    if ((i4 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "422@22763L6,423@22805L22");
                        if ((i & 1) != 0) {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            } else {
                                rectangleShape = shape2;
                            }
                            if ((i3 & 32) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i4 &= -458753;
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 = (-3670017) & i4;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke2 = null;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -391302147;
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -391302147;
                            }
                        } else {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            } else {
                                rectangleShape = shape2;
                            }
                            if ((i3 & 32) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i4 &= -458753;
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 = (-3670017) & i4;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke2 = null;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -391302147;
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -391302147;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:428)");
                        }
                        ProvidableCompositionLocal<Dp> localAbsoluteElevation5 = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume5 = composerStartRestartGroup.consume(localAbsoluteElevation5);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fM9687constructorimpl6 = Dp.m9687constructorimpl(((Dp) objConsume5).m9701unboximpl() + f3);
                        final Modifier modifier8 = companion;
                        final Function1 function8 = function3;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl6))}, ComposableLambdaKt.rememberComposableLambda(1698162493, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_Ny5ogXk$lambda$2(modifier8, shape4, j5, fM9687constructorimpl6, borderStroke4, f3, z, mutableInteractionSource3, z6, function8, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = jM2360contentColorForek8zF_U;
                        modifier3 = modifier8;
                        shape3 = shape4;
                        j3 = j5;
                        borderStroke3 = borderStroke4;
                        f2 = f3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        z5 = z6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j3 = j;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z5 = z3;
                        shape3 = shape2;
                        borderStroke3 = borderStroke2;
                        j4 = j2;
                        f2 = f;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_Ny5ogXk$lambda$3(z, function1, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 100663296;
                i13 = i3 & 512;
                if (i13 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i15 = i2 | i17;
                } else {
                    i15 = i2;
                }
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "422@22763L6,423@22805L22");
                    if ((i & 1) != 0) {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                        }
                    } else {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:428)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation6 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume6 = composerStartRestartGroup.consume(localAbsoluteElevation6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl7 = Dp.m9687constructorimpl(((Dp) objConsume6).m9701unboximpl() + f3);
                    final Modifier modifier9 = companion;
                    final Function1 function9 = function3;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl7))}, ComposableLambdaKt.rememberComposableLambda(1698162493, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$2(modifier9, shape4, j5, fM9687constructorimpl7, borderStroke4, f3, z, mutableInteractionSource3, z6, function9, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = jM2360contentColorForek8zF_U;
                    modifier3 = modifier9;
                    shape3 = shape4;
                    j3 = j5;
                    borderStroke3 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z5 = z6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j3 = j;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    j4 = j2;
                    f2 = f;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$3(z, function1, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            shape2 = shape;
            if ((196608 & i) != 0) {
                if ((i3 & 32) == 0) {
                    i19 = 65536;
                } else {
                    i19 = 65536;
                }
                i4 |= i19;
            }
            if ((i & 1572864) != 0) {
                if ((i3 & 64) == 0) {
                    i18 = 524288;
                } else {
                    i18 = 524288;
                }
                i4 |= i18;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i4 |= 12582912;
                borderStroke2 = borderStroke;
            } else {
                borderStroke2 = borderStroke;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
            }
            i11 = i3 & 256;
            if (i11 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
                i13 = i3 & 512;
                if (i13 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i15 = i2 | i17;
                } else {
                    i15 = i2;
                }
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "422@22763L6,423@22805L22");
                    if ((i & 1) != 0) {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                        }
                    } else {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:428)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation7 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume7 = composerStartRestartGroup.consume(localAbsoluteElevation7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl8 = Dp.m9687constructorimpl(((Dp) objConsume7).m9701unboximpl() + f3);
                    final Modifier modifier10 = companion;
                    final Function1 function10 = function3;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl8))}, ComposableLambdaKt.rememberComposableLambda(1698162493, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$2(modifier10, shape4, j5, fM9687constructorimpl8, borderStroke4, f3, z, mutableInteractionSource3, z6, function10, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = jM2360contentColorForek8zF_U;
                    modifier3 = modifier10;
                    shape3 = shape4;
                    j3 = j5;
                    borderStroke3 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z5 = z6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j3 = j;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    j4 = j2;
                    f2 = f;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$3(z, function1, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            i13 = i3 & 512;
            if (i13 != 0) {
                i4 |= 805306368;
            } else if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i15 = i2 | i17;
            } else {
                i15 = i2;
            }
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "422@22763L6,423@22805L22");
                if ((i & 1) != 0) {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i3 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i4 &= -458753;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 = (-3670017) & i4;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -391302147;
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -391302147;
                    }
                } else {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i3 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i4 &= -458753;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 = (-3670017) & i4;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -391302147;
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -391302147;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:428)");
                }
                ProvidableCompositionLocal<Dp> localAbsoluteElevation8 = ElevationOverlayKt.getLocalAbsoluteElevation();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume8 = composerStartRestartGroup.consume(localAbsoluteElevation8);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float fM9687constructorimpl9 = Dp.m9687constructorimpl(((Dp) objConsume8).m9701unboximpl() + f3);
                final Modifier modifier11 = companion;
                final Function1 function11 = function3;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl9))}, ComposableLambdaKt.rememberComposableLambda(1698162493, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_Ny5ogXk$lambda$2(modifier11, shape4, j5, fM9687constructorimpl9, borderStroke4, f3, z, mutableInteractionSource3, z6, function11, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = jM2360contentColorForek8zF_U;
                modifier3 = modifier11;
                shape3 = shape4;
                j3 = j5;
                borderStroke3 = borderStroke4;
                f2 = f3;
                mutableInteractionSource2 = mutableInteractionSource3;
                z5 = z6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                j3 = j;
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                shape3 = shape2;
                borderStroke3 = borderStroke2;
                j4 = j2;
                f2 = f;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_Ny5ogXk$lambda$3(z, function1, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i & 3072) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            i7 = i3 & 16;
            if (i7 != 0) {
                if ((i & 24576) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                if ((196608 & i) != 0) {
                    if ((i3 & 32) == 0) {
                        i19 = 65536;
                    } else {
                        i19 = 65536;
                    }
                    i4 |= i19;
                }
                if ((i & 1572864) != 0) {
                    if ((i3 & 64) == 0) {
                        i18 = 524288;
                    } else {
                        i18 = 524288;
                    }
                    i4 |= i18;
                }
                i9 = i3 & 128;
                if (i9 != 0) {
                    i4 |= 12582912;
                    borderStroke2 = borderStroke;
                } else {
                    borderStroke2 = borderStroke;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke2)) {
                            i10 = 8388608;
                        } else {
                            i10 = 4194304;
                        }
                        i4 |= i10;
                    }
                }
                i11 = i3 & 256;
                if (i11 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                        i4 |= i12;
                    }
                    i13 = i3 & 512;
                    if (i13 != 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i17 = 4;
                        } else {
                            i17 = 2;
                        }
                        i15 = i2 | i17;
                    } else {
                        i15 = i2;
                    }
                    if ((i4 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "422@22763L6,423@22805L22");
                        if ((i & 1) != 0) {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            } else {
                                rectangleShape = shape2;
                            }
                            if ((i3 & 32) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i4 &= -458753;
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 = (-3670017) & i4;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke2 = null;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -391302147;
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -391302147;
                            }
                        } else {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            } else {
                                rectangleShape = shape2;
                            }
                            if ((i3 & 32) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i4 &= -458753;
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 = (-3670017) & i4;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                borderStroke2 = null;
                            }
                            if (i11 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f;
                            }
                            if (i13 != 0) {
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -391302147;
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                f3 = fM9687constructorimpl;
                                shape4 = rectangleShape;
                                j5 = jM2346getSurface0d7_KjU;
                                z6 = z3;
                                borderStroke4 = borderStroke2;
                                i16 = -391302147;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:428)");
                        }
                        ProvidableCompositionLocal<Dp> localAbsoluteElevation9 = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume9 = composerStartRestartGroup.consume(localAbsoluteElevation9);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fM9687constructorimpl10 = Dp.m9687constructorimpl(((Dp) objConsume9).m9701unboximpl() + f3);
                        final Modifier modifier12 = companion;
                        final Function1 function12 = function3;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl10))}, ComposableLambdaKt.rememberComposableLambda(1698162493, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_Ny5ogXk$lambda$2(modifier12, shape4, j5, fM9687constructorimpl10, borderStroke4, f3, z, mutableInteractionSource3, z6, function12, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = jM2360contentColorForek8zF_U;
                        modifier3 = modifier12;
                        shape3 = shape4;
                        j3 = j5;
                        borderStroke3 = borderStroke4;
                        f2 = f3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        z5 = z6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j3 = j;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z5 = z3;
                        shape3 = shape2;
                        borderStroke3 = borderStroke2;
                        j4 = j2;
                        f2 = f;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SurfaceKt.Surface_Ny5ogXk$lambda$3(z, function1, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 100663296;
                i13 = i3 & 512;
                if (i13 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i15 = i2 | i17;
                } else {
                    i15 = i2;
                }
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "422@22763L6,423@22805L22");
                    if ((i & 1) != 0) {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                        }
                    } else {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:428)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation10 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume10 = composerStartRestartGroup.consume(localAbsoluteElevation10);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl11 = Dp.m9687constructorimpl(((Dp) objConsume10).m9701unboximpl() + f3);
                    final Modifier modifier13 = companion;
                    final Function1 function13 = function3;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl11))}, ComposableLambdaKt.rememberComposableLambda(1698162493, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$2(modifier13, shape4, j5, fM9687constructorimpl11, borderStroke4, f3, z, mutableInteractionSource3, z6, function13, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = jM2360contentColorForek8zF_U;
                    modifier3 = modifier13;
                    shape3 = shape4;
                    j3 = j5;
                    borderStroke3 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z5 = z6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j3 = j;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    j4 = j2;
                    f2 = f;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$3(z, function1, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            shape2 = shape;
            if ((196608 & i) != 0) {
                if ((i3 & 32) == 0) {
                    i19 = 65536;
                } else {
                    i19 = 65536;
                }
                i4 |= i19;
            }
            if ((i & 1572864) != 0) {
                if ((i3 & 64) == 0) {
                    i18 = 524288;
                } else {
                    i18 = 524288;
                }
                i4 |= i18;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i4 |= 12582912;
                borderStroke2 = borderStroke;
            } else {
                borderStroke2 = borderStroke;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
            }
            i11 = i3 & 256;
            if (i11 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
                i13 = i3 & 512;
                if (i13 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i15 = i2 | i17;
                } else {
                    i15 = i2;
                }
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "422@22763L6,423@22805L22");
                    if ((i & 1) != 0) {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                        }
                    } else {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:428)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation11 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume11 = composerStartRestartGroup.consume(localAbsoluteElevation11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl12 = Dp.m9687constructorimpl(((Dp) objConsume11).m9701unboximpl() + f3);
                    final Modifier modifier14 = companion;
                    final Function1 function14 = function3;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl12))}, ComposableLambdaKt.rememberComposableLambda(1698162493, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$2(modifier14, shape4, j5, fM9687constructorimpl12, borderStroke4, f3, z, mutableInteractionSource3, z6, function14, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = jM2360contentColorForek8zF_U;
                    modifier3 = modifier14;
                    shape3 = shape4;
                    j3 = j5;
                    borderStroke3 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z5 = z6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j3 = j;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    j4 = j2;
                    f2 = f;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$3(z, function1, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            i13 = i3 & 512;
            if (i13 != 0) {
                i4 |= 805306368;
            } else if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i15 = i2 | i17;
            } else {
                i15 = i2;
            }
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "422@22763L6,423@22805L22");
                if ((i & 1) != 0) {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i3 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i4 &= -458753;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 = (-3670017) & i4;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -391302147;
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -391302147;
                    }
                } else {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i3 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i4 &= -458753;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 = (-3670017) & i4;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -391302147;
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -391302147;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:428)");
                }
                ProvidableCompositionLocal<Dp> localAbsoluteElevation12 = ElevationOverlayKt.getLocalAbsoluteElevation();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume12 = composerStartRestartGroup.consume(localAbsoluteElevation12);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float fM9687constructorimpl13 = Dp.m9687constructorimpl(((Dp) objConsume12).m9701unboximpl() + f3);
                final Modifier modifier15 = companion;
                final Function1 function15 = function3;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl13))}, ComposableLambdaKt.rememberComposableLambda(1698162493, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_Ny5ogXk$lambda$2(modifier15, shape4, j5, fM9687constructorimpl13, borderStroke4, f3, z, mutableInteractionSource3, z6, function15, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = jM2360contentColorForek8zF_U;
                modifier3 = modifier15;
                shape3 = shape4;
                j3 = j5;
                borderStroke3 = borderStroke4;
                f2 = f3;
                mutableInteractionSource2 = mutableInteractionSource3;
                z5 = z6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                j3 = j;
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                shape3 = shape2;
                borderStroke3 = borderStroke2;
                j4 = j2;
                f2 = f;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_Ny5ogXk$lambda$3(z, function1, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        z3 = z2;
        i7 = i3 & 16;
        if (i7 != 0) {
            if ((i & 24576) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i4 |= i8;
            }
            if ((196608 & i) != 0) {
                if ((i3 & 32) == 0) {
                    i19 = 65536;
                } else {
                    i19 = 65536;
                }
                i4 |= i19;
            }
            if ((i & 1572864) != 0) {
                if ((i3 & 64) == 0) {
                    i18 = 524288;
                } else {
                    i18 = 524288;
                }
                i4 |= i18;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i4 |= 12582912;
                borderStroke2 = borderStroke;
            } else {
                borderStroke2 = borderStroke;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
            }
            i11 = i3 & 256;
            if (i11 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
                i13 = i3 & 512;
                if (i13 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i15 = i2 | i17;
                } else {
                    i15 = i2;
                }
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "422@22763L6,423@22805L22");
                    if ((i & 1) != 0) {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                        }
                    } else {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i3 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i4 &= -458753;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 = (-3670017) & i4;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            borderStroke2 = null;
                        }
                        if (i11 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i13 != 0) {
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            f3 = fM9687constructorimpl;
                            shape4 = rectangleShape;
                            j5 = jM2346getSurface0d7_KjU;
                            z6 = z3;
                            borderStroke4 = borderStroke2;
                            i16 = -391302147;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:428)");
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation13 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume13 = composerStartRestartGroup.consume(localAbsoluteElevation13);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl14 = Dp.m9687constructorimpl(((Dp) objConsume13).m9701unboximpl() + f3);
                    final Modifier modifier16 = companion;
                    final Function1 function16 = function3;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl14))}, ComposableLambdaKt.rememberComposableLambda(1698162493, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$2(modifier16, shape4, j5, fM9687constructorimpl14, borderStroke4, f3, z, mutableInteractionSource3, z6, function16, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = jM2360contentColorForek8zF_U;
                    modifier3 = modifier16;
                    shape3 = shape4;
                    j3 = j5;
                    borderStroke3 = borderStroke4;
                    f2 = f3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z5 = z6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j3 = j;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    j4 = j2;
                    f2 = f;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_Ny5ogXk$lambda$3(z, function1, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            i13 = i3 & 512;
            if (i13 != 0) {
                i4 |= 805306368;
            } else if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i15 = i2 | i17;
            } else {
                i15 = i2;
            }
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "422@22763L6,423@22805L22");
                if ((i & 1) != 0) {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i3 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i4 &= -458753;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 = (-3670017) & i4;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -391302147;
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -391302147;
                    }
                } else {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i3 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i4 &= -458753;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 = (-3670017) & i4;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -391302147;
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -391302147;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:428)");
                }
                ProvidableCompositionLocal<Dp> localAbsoluteElevation14 = ElevationOverlayKt.getLocalAbsoluteElevation();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume14 = composerStartRestartGroup.consume(localAbsoluteElevation14);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float fM9687constructorimpl15 = Dp.m9687constructorimpl(((Dp) objConsume14).m9701unboximpl() + f3);
                final Modifier modifier17 = companion;
                final Function1 function17 = function3;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl15))}, ComposableLambdaKt.rememberComposableLambda(1698162493, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_Ny5ogXk$lambda$2(modifier17, shape4, j5, fM9687constructorimpl15, borderStroke4, f3, z, mutableInteractionSource3, z6, function17, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = jM2360contentColorForek8zF_U;
                modifier3 = modifier17;
                shape3 = shape4;
                j3 = j5;
                borderStroke3 = borderStroke4;
                f2 = f3;
                mutableInteractionSource2 = mutableInteractionSource3;
                z5 = z6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                j3 = j;
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                shape3 = shape2;
                borderStroke3 = borderStroke2;
                j4 = j2;
                f2 = f;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_Ny5ogXk$lambda$3(z, function1, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        shape2 = shape;
        if ((196608 & i) != 0) {
            if ((i3 & 32) == 0) {
                i19 = 65536;
            } else {
                i19 = 65536;
            }
            i4 |= i19;
        }
        if ((i & 1572864) != 0) {
            if ((i3 & 64) == 0) {
                i18 = 524288;
            } else {
                i18 = 524288;
            }
            i4 |= i18;
        }
        i9 = i3 & 128;
        if (i9 != 0) {
            i4 |= 12582912;
            borderStroke2 = borderStroke;
        } else {
            borderStroke2 = borderStroke;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(borderStroke2)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i4 |= i10;
            }
        }
        i11 = i3 & 256;
        if (i11 != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i4 |= i12;
            }
            i13 = i3 & 512;
            if (i13 != 0) {
                i4 |= 805306368;
            } else if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i15 = i2 | i17;
            } else {
                i15 = i2;
            }
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "422@22763L6,423@22805L22");
                if ((i & 1) != 0) {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i3 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i4 &= -458753;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 = (-3670017) & i4;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -391302147;
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -391302147;
                    }
                } else {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i3 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i4 &= -458753;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 = (-3670017) & i4;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        borderStroke2 = null;
                    }
                    if (i11 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i13 != 0) {
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -391302147;
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                        f3 = fM9687constructorimpl;
                        shape4 = rectangleShape;
                        j5 = jM2346getSurface0d7_KjU;
                        z6 = z3;
                        borderStroke4 = borderStroke2;
                        i16 = -391302147;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:428)");
                }
                ProvidableCompositionLocal<Dp> localAbsoluteElevation15 = ElevationOverlayKt.getLocalAbsoluteElevation();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume15 = composerStartRestartGroup.consume(localAbsoluteElevation15);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float fM9687constructorimpl16 = Dp.m9687constructorimpl(((Dp) objConsume15).m9701unboximpl() + f3);
                final Modifier modifier18 = companion;
                final Function1 function18 = function3;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl16))}, ComposableLambdaKt.rememberComposableLambda(1698162493, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_Ny5ogXk$lambda$2(modifier18, shape4, j5, fM9687constructorimpl16, borderStroke4, f3, z, mutableInteractionSource3, z6, function18, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = jM2360contentColorForek8zF_U;
                modifier3 = modifier18;
                shape3 = shape4;
                j3 = j5;
                borderStroke3 = borderStroke4;
                f2 = f3;
                mutableInteractionSource2 = mutableInteractionSource3;
                z5 = z6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                j3 = j;
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                shape3 = shape2;
                borderStroke3 = borderStroke2;
                j4 = j2;
                f2 = f;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_Ny5ogXk$lambda$3(z, function1, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 100663296;
        i13 = i3 & 512;
        if (i13 != 0) {
            i4 |= 805306368;
        } else if ((i & 805306368) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i14 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i14 = 268435456;
            }
            i4 |= i14;
        }
        if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i17 = 4;
            } else {
                i17 = 2;
            }
            i15 = i2 | i17;
        } else {
            i15 = i2;
        }
        if ((i4 & 306783379) == 306783378) {
            z4 = true;
        } else {
            z4 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "422@22763L6,423@22805L22");
            if ((i & 1) != 0) {
                if (i20 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if (i7 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape2;
                }
                if ((i3 & 32) != 0) {
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    i4 &= -458753;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                if ((i3 & 64) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                    i4 = (-3670017) & i4;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                if (i9 != 0) {
                    borderStroke2 = null;
                }
                if (i11 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl = f;
                }
                if (i13 != 0) {
                    f3 = fM9687constructorimpl;
                    shape4 = rectangleShape;
                    j5 = jM2346getSurface0d7_KjU;
                    z6 = z3;
                    borderStroke4 = borderStroke2;
                    i16 = -391302147;
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                    f3 = fM9687constructorimpl;
                    shape4 = rectangleShape;
                    j5 = jM2346getSurface0d7_KjU;
                    z6 = z3;
                    borderStroke4 = borderStroke2;
                    i16 = -391302147;
                }
            } else {
                if (i20 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if (i7 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape2;
                }
                if ((i3 & 32) != 0) {
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    i4 &= -458753;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                if ((i3 & 64) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 15) & 14);
                    i4 = (-3670017) & i4;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                if (i9 != 0) {
                    borderStroke2 = null;
                }
                if (i11 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl = f;
                }
                if (i13 != 0) {
                    f3 = fM9687constructorimpl;
                    shape4 = rectangleShape;
                    j5 = jM2346getSurface0d7_KjU;
                    z6 = z3;
                    borderStroke4 = borderStroke2;
                    i16 = -391302147;
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                    f3 = fM9687constructorimpl;
                    shape4 = rectangleShape;
                    j5 = jM2346getSurface0d7_KjU;
                    z6 = z3;
                    borderStroke4 = borderStroke2;
                    i16 = -391302147;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i16, i4, i15, "androidx.compose.material.Surface (Surface.kt:428)");
            }
            ProvidableCompositionLocal<Dp> localAbsoluteElevation16 = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume16 = composerStartRestartGroup.consume(localAbsoluteElevation16);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final float fM9687constructorimpl17 = Dp.m9687constructorimpl(((Dp) objConsume16).m9701unboximpl() + f3);
            final Modifier modifier19 = companion;
            final Function1 function19 = function3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM2360contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m9685boximpl(fM9687constructorimpl17))}, ComposableLambdaKt.rememberComposableLambda(1698162493, true, new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SurfaceKt.Surface_Ny5ogXk$lambda$2(modifier19, shape4, j5, fM9687constructorimpl17, borderStroke4, f3, z, mutableInteractionSource3, z6, function19, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j4 = jM2360contentColorForek8zF_U;
            modifier3 = modifier19;
            shape3 = shape4;
            j3 = j5;
            borderStroke3 = borderStroke4;
            f2 = f3;
            mutableInteractionSource2 = mutableInteractionSource3;
            z5 = z6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            j3 = j;
            mutableInteractionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
            z5 = z3;
            shape3 = shape2;
            borderStroke3 = borderStroke2;
            j4 = j2;
            f2 = f;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SurfaceKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SurfaceKt.Surface_Ny5ogXk$lambda$3(z, function1, modifier3, z5, shape3, j3, j4, borderStroke3, f2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_Ny5ogXk$lambda$2(Modifier modifier, Shape shape, long j, float f, BorderStroke borderStroke, float f2, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function1 function1, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C443@23604L7,441@23459L254,434@23212L1007:Surface.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1698162493, i, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:434)");
            }
            Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier);
            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localElevationOverlay);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierM1541toggleableO2vRcR0$default = ToggleableKt.m1541toggleableO2vRcR0$default(m2588surface8ww4TTg(modifierMinimumInteractiveComponentSize, shape, m2589surfaceColorAtElevationcq6XJ1M(j, (ElevationOverlay) objConsume, f, composer, 0), borderStroke, f2), z, mutableInteractionSource, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, 0L, 7, null), z2, null, function1, 16, null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1541toggleableO2vRcR0$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1275852541, "C458@24200L9:Surface.kt#jmzs0o");
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

    /* JADX INFO: renamed from: surface-8ww4TTg, reason: not valid java name */
    private static final Modifier m2588surface8ww4TTg(Modifier modifier, Shape shape, long j, BorderStroke borderStroke, float f) {
        Modifier modifierM6412shadows4CzXII$default = ShadowKt.m6412shadows4CzXII$default(modifier, f, shape, false, 0L, 0L, 24, null);
        Modifier.Companion companionBorder = Modifier.INSTANCE;
        if (borderStroke != null) {
            companionBorder = BorderKt.border(companionBorder, borderStroke, shape);
        }
        return ClipKt.clip(BackgroundKt.m588backgroundbw27NRU(modifierM6412shadows4CzXII$default.then(companionBorder), j, shape), shape);
    }

    /* JADX INFO: renamed from: surfaceColorAtElevation-cq6XJ1M, reason: not valid java name */
    private static final long m2589surfaceColorAtElevationcq6XJ1M(long j, ElevationOverlay elevationOverlay, float f, Composer composer, int i) {
        Composer composer2;
        long jMo2378apply7g2Lkgo;
        ComposerKt.sourceInformationMarkerStart(composer, 1561611256, "C(surfaceColorAtElevation)N(color:c#ui.graphics.Color,elevationOverlay,absoluteElevation:c#ui.unit.Dp)480@24749L6:Surface.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1561611256, i, -1, "androidx.compose.material.surfaceColorAtElevation (Surface.kt:479)");
        }
        if (Color.m6815equalsimpl0(j, MaterialTheme.INSTANCE.getColors(composer, 6).m2346getSurface0d7_KjU()) && elevationOverlay != null) {
            composer.startReplaceGroup(-1124614454);
            ComposerKt.sourceInformation(composer, "481@24820L31");
            composer2 = composer;
            jMo2378apply7g2Lkgo = elevationOverlay.mo2378apply7g2Lkgo(j, f, composer2, (i & 14) | ((i >> 3) & 112) | ((i << 3) & 896));
            composer2.endReplaceGroup();
        } else {
            composer2 = composer;
            composer2.startReplaceGroup(-1124546347);
            composer2.endReplaceGroup();
            jMo2378apply7g2Lkgo = j;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return jMo2378apply7g2Lkgo;
    }
}
