package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.SmallIconButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Icon.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000e\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u0011\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u00122\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0013\u001a\u0014\u0010\u0014\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u0013\u0010\u0015\u001a\u00020\u0016*\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\"\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Icon", "", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "tint", "Landroidx/compose/ui/graphics/Color;", "Icon-ww6aTOc", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/graphics/ColorProducer;", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/ColorProducer;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "defaultSizeFor", "isInfinite", "", "Landroidx/compose/ui/geometry/Size;", "isInfinite-uvyYCjk", "(J)Z", "DefaultIconSizeModifier", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IconKt {
    private static final Modifier DefaultIconSizeModifier = SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, SmallIconButtonTokens.INSTANCE.m5775getIconSizeD9Ej5fM());

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Icon$lambda$1(Painter painter, ColorProducer colorProducer, String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        Icon(painter, colorProducer, str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Icon_ww6aTOc$lambda$0(ImageVector imageVector, String str, Modifier modifier, long j, int i, int i2, Composer composer, int i3) {
        m3576Iconww6aTOc(imageVector, str, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Icon_ww6aTOc$lambda$2(ImageBitmap imageBitmap, String str, Modifier modifier, long j, int i, int i2, Composer composer, int i3) {
        m3574Iconww6aTOc(imageBitmap, str, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Icon_ww6aTOc$lambda$5(Painter painter, String str, Modifier modifier, long j, int i, int i2, Composer composer, int i3) {
        m3575Iconww6aTOc(painter, str, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0052  */
    /* JADX WARN: Code duplicated, block: B:32:0x0056  */
    /* JADX WARN: Code duplicated, block: B:34:0x005e  */
    /* JADX WARN: Code duplicated, block: B:35:0x0061  */
    /* JADX WARN: Code duplicated, block: B:38:0x0067  */
    /* JADX WARN: Code duplicated, block: B:41:0x006f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0071  */
    /* JADX WARN: Code duplicated, block: B:45:0x007a  */
    /* JADX WARN: Code duplicated, block: B:54:0x0098 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x009a  */
    /* JADX WARN: Code duplicated, block: B:56:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:67:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:69:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:72:0x0103  */
    /* JADX WARN: Code duplicated, block: B:74:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m3576Iconww6aTOc(final ImageVector imageVector, final String str, Modifier modifier, long j, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        final long j2;
        boolean z;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Modifier modifier3;
        long jM6824unboximpl;
        Composer composerStartRestartGroup = composer.startRestartGroup(-126890956);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Icon)N(imageVector,contentDescription,modifier,tint:c#ui.graphics.Color)71@3410L34,70@3386L164:Icon.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(imageVector) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    j2 = j;
                    int i5 = composerStartRestartGroup.changed(j2) ? 2048 : 1024;
                    i3 |= i5;
                } else {
                    j2 = j;
                }
                i3 |= i5;
            } else {
                j2 = j;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "68@3369L7");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i4 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localContentColor);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -7169;
                        modifier3 = companion;
                        jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
                    } else {
                        modifier3 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-126890956, i3, -1, "androidx.compose.material3.Icon (Icon.kt:69)");
                    }
                    m3575Iconww6aTOc(VectorPainterKt.rememberVectorPainter(imageVector, composerStartRestartGroup, i3 & 14), str, modifier3, jM6824unboximpl, composerStartRestartGroup, VectorPainter.$stable | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j2 = jM6824unboximpl;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    modifier3 = modifier2;
                }
                jM6824unboximpl = j2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-126890956, i3, -1, "androidx.compose.material3.Icon (Icon.kt:69)");
                }
                m3575Iconww6aTOc(VectorPainterKt.rememberVectorPainter(imageVector, composerStartRestartGroup, i3 & 14), str, modifier3, jM6824unboximpl, composerStartRestartGroup, VectorPainter.$stable | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j2 = jM6824unboximpl;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return IconKt.Icon_ww6aTOc$lambda$0(imageVector, str, modifier2, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                j2 = j;
                if (composerStartRestartGroup.changed(j2)) {
                }
                i3 |= i5;
            } else {
                j2 = j;
            }
            i3 |= i5;
        } else {
            j2 = j;
        }
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "68@3369L7");
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 8) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localContentColor2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 &= -7169;
                    modifier3 = companion;
                    jM6824unboximpl = ((Color) objConsume2).m6824unboximpl();
                } else {
                    modifier3 = companion;
                    jM6824unboximpl = j2;
                }
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 8) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor3 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localContentColor3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 &= -7169;
                    modifier3 = companion;
                    jM6824unboximpl = ((Color) objConsume3).m6824unboximpl();
                } else {
                    modifier3 = companion;
                    jM6824unboximpl = j2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-126890956, i3, -1, "androidx.compose.material3.Icon (Icon.kt:69)");
            }
            m3575Iconww6aTOc(VectorPainterKt.rememberVectorPainter(imageVector, composerStartRestartGroup, i3 & 14), str, modifier3, jM6824unboximpl, composerStartRestartGroup, VectorPainter.$stable | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            j2 = jM6824unboximpl;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconKt.Icon_ww6aTOc$lambda$0(imageVector, str, modifier2, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0054  */
    /* JADX WARN: Code duplicated, block: B:32:0x0058  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:38:0x0069  */
    /* JADX WARN: Code duplicated, block: B:41:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0073  */
    /* JADX WARN: Code duplicated, block: B:45:0x007c  */
    /* JADX WARN: Code duplicated, block: B:54:0x009b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x009d  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:69:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:72:0x0118  */
    /* JADX WARN: Code duplicated, block: B:74:0x011e  */
    /* JADX WARN: Code duplicated, block: B:77:0x0129  */
    /* JADX WARN: Code duplicated, block: B:79:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m3574Iconww6aTOc(final ImageBitmap imageBitmap, final String str, Modifier modifier, long j, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long j2;
        boolean z;
        final Modifier modifier3;
        final long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i4;
        Modifier modifier4;
        long jM6824unboximpl;
        boolean zChanged;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1092052280);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Icon)N(bitmap,contentDescription,modifier,tint:c#ui.graphics.Color)106@5114L42,107@5161L137:Icon.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(imageBitmap) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    j2 = j;
                    int i6 = composerStartRestartGroup.changed(j2) ? 2048 : 1024;
                    i3 |= i6;
                } else {
                    j2 = j;
                }
                i3 |= i6;
            } else {
                j2 = j;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "104@5083L7");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localContentColor);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i4 = i3 & (-7169);
                        modifier4 = companion;
                        jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
                    } else {
                        i4 = i3;
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1092052280, i4, -1, "androidx.compose.material3.Icon (Icon.kt:105)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1490215374, "CC(remember):Icon.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(imageBitmap);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        BitmapPainter bitmapPainter = new BitmapPainter(imageBitmap, 0L, 0L, 6, null);
                        composerStartRestartGroup.updateRememberedValue(bitmapPainter);
                        objRememberedValue = bitmapPainter;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    m3575Iconww6aTOc((BitmapPainter) objRememberedValue, str, modifier4, jM6824unboximpl, composerStartRestartGroup, i4 & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    j3 = jM6824unboximpl;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    i4 = i3;
                    modifier4 = modifier2;
                }
                jM6824unboximpl = j2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1092052280, i4, -1, "androidx.compose.material3.Icon (Icon.kt:105)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1490215374, "CC(remember):Icon.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(imageBitmap);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    BitmapPainter bitmapPainter2 = new BitmapPainter(imageBitmap, 0L, 0L, 6, null);
                    composerStartRestartGroup.updateRememberedValue(bitmapPainter2);
                    objRememberedValue = bitmapPainter2;
                } else {
                    BitmapPainter bitmapPainter3 = new BitmapPainter(imageBitmap, 0L, 0L, 6, null);
                    composerStartRestartGroup.updateRememberedValue(bitmapPainter3);
                    objRememberedValue = bitmapPainter3;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                m3575Iconww6aTOc((BitmapPainter) objRememberedValue, str, modifier4, jM6824unboximpl, composerStartRestartGroup, i4 & 8176, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                j3 = jM6824unboximpl;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return IconKt.Icon_ww6aTOc$lambda$2(imageBitmap, str, modifier3, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                j2 = j;
                if (composerStartRestartGroup.changed(j2)) {
                }
                i3 |= i6;
            } else {
                j2 = j;
            }
            i3 |= i6;
        } else {
            j2 = j;
        }
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "104@5083L7");
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 8) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localContentColor2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i4 = i3 & (-7169);
                    modifier4 = companion;
                    jM6824unboximpl = ((Color) objConsume2).m6824unboximpl();
                } else {
                    i4 = i3;
                    modifier4 = companion;
                    jM6824unboximpl = j2;
                }
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 8) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor3 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localContentColor3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i4 = i3 & (-7169);
                    modifier4 = companion;
                    jM6824unboximpl = ((Color) objConsume3).m6824unboximpl();
                } else {
                    i4 = i3;
                    modifier4 = companion;
                    jM6824unboximpl = j2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1092052280, i4, -1, "androidx.compose.material3.Icon (Icon.kt:105)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1490215374, "CC(remember):Icon.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(imageBitmap);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                BitmapPainter bitmapPainter4 = new BitmapPainter(imageBitmap, 0L, 0L, 6, null);
                composerStartRestartGroup.updateRememberedValue(bitmapPainter4);
                objRememberedValue = bitmapPainter4;
            } else {
                BitmapPainter bitmapPainter5 = new BitmapPainter(imageBitmap, 0L, 0L, 6, null);
                composerStartRestartGroup.updateRememberedValue(bitmapPainter5);
                objRememberedValue = bitmapPainter5;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            m3575Iconww6aTOc((BitmapPainter) objRememberedValue, str, modifier4, jM6824unboximpl, composerStartRestartGroup, i4 & 8176, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            j3 = jM6824unboximpl;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = j2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconKt.Icon_ww6aTOc$lambda$2(imageBitmap, str, modifier3, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:103:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0057  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    /* JADX WARN: Code duplicated, block: B:44:0x007c  */
    /* JADX WARN: Code duplicated, block: B:53:0x009e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:58:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:78:0x0108  */
    /* JADX WARN: Code duplicated, block: B:80:0x0114  */
    /* JADX WARN: Code duplicated, block: B:81:0x0118  */
    /* JADX WARN: Code duplicated, block: B:85:0x0131  */
    /* JADX WARN: Code duplicated, block: B:87:0x014a  */
    /* JADX WARN: Code duplicated, block: B:88:0x014c  */
    /* JADX WARN: Code duplicated, block: B:93:0x015b  */
    /* JADX WARN: Code duplicated, block: B:95:0x0172  */
    /* JADX WARN: Code duplicated, block: B:98:0x01a6  */
    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m3575Iconww6aTOc(final Painter painter, final String str, Modifier modifier, long j, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long j2;
        boolean z;
        final Modifier modifier3;
        final long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long jM6824unboximpl;
        Modifier modifier4;
        boolean z2;
        long j4;
        Object objM6855tintxETnrds$default;
        Modifier.Companion companionSemantics$default;
        boolean z3;
        Object objRememberedValue;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2142239481);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Icon)N(painter,contentDescription,modifier,tint:c#ui.graphics.Color)144@6871L82,154@7215L217:Icon.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(painter) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                j2 = j;
                if ((i2 & 8) == 0 || !composerStartRestartGroup.changed(j2)) {
                    i4 = 1024;
                } else {
                    i4 = 2048;
                }
                i3 |= i4;
            } else {
                j2 = j;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "141@6828L7");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localContentColor);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
                        i3 &= -7169;
                    } else {
                        jM6824unboximpl = j2;
                    }
                    modifier4 = companion;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    long j5 = j2;
                    modifier4 = modifier2;
                    jM6824unboximpl = j5;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2142239481, i3, -1, "androidx.compose.material3.Icon (Icon.kt:142)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1402800647, "CC(remember):Icon.kt#9igjgp");
                z2 = (((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(jM6824unboximpl)) || (i3 & 3072) == 2048;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    if (Color.m6815equalsimpl0(jM6824unboximpl, Color.INSTANCE.m6850getUnspecified0d7_KjU())) {
                        j4 = jM6824unboximpl;
                        objM6855tintxETnrds$default = null;
                    } else {
                        j4 = jM6824unboximpl;
                        objM6855tintxETnrds$default = ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, j4, 0, 2, null);
                    }
                    composerStartRestartGroup.updateRememberedValue(objM6855tintxETnrds$default);
                } else {
                    j4 = jM6824unboximpl;
                    objM6855tintxETnrds$default = objRememberedValue2;
                }
                ColorFilter colorFilter = (ColorFilter) objM6855tintxETnrds$default;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (str != null) {
                    composerStartRestartGroup.startReplaceGroup(-537002883);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "147@7047L115");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1402794982, "CC(remember):Icon.kt#9igjgp");
                    if ((i3 & 112) == 32) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.IconKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return IconKt.Icon_ww6aTOc$lambda$4$0(str, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    companionSemantics$default = SemanticsModifierKt.semantics$default(companion2, false, (Function1) objRememberedValue, 1, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-536844101);
                    composerStartRestartGroup.endReplaceGroup();
                    companionSemantics$default = Modifier.INSTANCE;
                }
                BoxKt.Box(PainterModifierKt.paint$default(defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(modifier4), painter), painter, false, null, ContentScale.INSTANCE.getFit(), 0.0f, colorFilter, 22, null).then(companionSemantics$default), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                j3 = j4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return IconKt.Icon_ww6aTOc$lambda$5(painter, str, modifier3, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            j2 = j;
            if ((i2 & 8) == 0) {
                i4 = 1024;
            } else {
                i4 = 1024;
            }
            i3 |= i4;
        } else {
            j2 = j;
        }
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "141@6828L7");
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 8) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localContentColor2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM6824unboximpl = ((Color) objConsume2).m6824unboximpl();
                    i3 &= -7169;
                } else {
                    jM6824unboximpl = j2;
                }
                modifier4 = companion;
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 8) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor3 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localContentColor3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM6824unboximpl = ((Color) objConsume3).m6824unboximpl();
                    i3 &= -7169;
                } else {
                    jM6824unboximpl = j2;
                }
                modifier4 = companion;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2142239481, i3, -1, "androidx.compose.material3.Icon (Icon.kt:142)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1402800647, "CC(remember):Icon.kt#9igjgp");
            if (((i3 & 7168) ^ 3072) <= 2048) {
            }
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z2) {
                if (Color.m6815equalsimpl0(jM6824unboximpl, Color.INSTANCE.m6850getUnspecified0d7_KjU())) {
                    j4 = jM6824unboximpl;
                    objM6855tintxETnrds$default = null;
                } else {
                    j4 = jM6824unboximpl;
                    objM6855tintxETnrds$default = ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, j4, 0, 2, null);
                }
                composerStartRestartGroup.updateRememberedValue(objM6855tintxETnrds$default);
            } else {
                if (Color.m6815equalsimpl0(jM6824unboximpl, Color.INSTANCE.m6850getUnspecified0d7_KjU())) {
                    j4 = jM6824unboximpl;
                    objM6855tintxETnrds$default = null;
                } else {
                    j4 = jM6824unboximpl;
                    objM6855tintxETnrds$default = ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, j4, 0, 2, null);
                }
                composerStartRestartGroup.updateRememberedValue(objM6855tintxETnrds$default);
            }
            ColorFilter colorFilter2 = (ColorFilter) objM6855tintxETnrds$default;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (str != null) {
                composerStartRestartGroup.startReplaceGroup(-537002883);
                ComposerKt.sourceInformation(composerStartRestartGroup, "147@7047L115");
                Modifier.Companion companion3 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1402794982, "CC(remember):Icon.kt#9igjgp");
                if ((i3 & 112) == 32) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.IconKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return IconKt.Icon_ww6aTOc$lambda$4$0(str, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.IconKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return IconKt.Icon_ww6aTOc$lambda$4$0(str, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                companionSemantics$default = SemanticsModifierKt.semantics$default(companion3, false, (Function1) objRememberedValue, 1, null);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-536844101);
                composerStartRestartGroup.endReplaceGroup();
                companionSemantics$default = Modifier.INSTANCE;
            }
            BoxKt.Box(PainterModifierKt.paint$default(defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(modifier4), painter), painter, false, null, ContentScale.INSTANCE.getFit(), 0.0f, colorFilter2, 22, null).then(companionSemantics$default), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            j3 = j4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = j2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconKt.Icon_ww6aTOc$lambda$5(painter, str, modifier3, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Icon_ww6aTOc$lambda$4$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.m8851setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8836getImageo7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0064  */
    /* JADX WARN: Code duplicated, block: B:38:0x0066  */
    /* JADX WARN: Code duplicated, block: B:41:0x006f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0071  */
    /* JADX WARN: Code duplicated, block: B:43:0x0076  */
    /* JADX WARN: Code duplicated, block: B:46:0x007d  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:56:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:61:? A[RETURN, SYNTHETIC] */
    public static final void Icon(final Painter painter, final ColorProducer colorProducer, final String str, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        boolean z;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean zChangedInstance;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(1755070997);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Icon)N(painter,tint,contentDescription,modifier)195@9038L311,190@8868L488:Icon.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(painter) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(colorProducer) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1755070997, i3, -1, "androidx.compose.material3.Icon (Icon.kt:189)");
                }
                long jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1298909172, "CC(remember):Icon.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(colorProducer);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.IconKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return IconKt.Icon$lambda$0$0(colorProducer, (CacheDrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                m3575Iconww6aTOc(painter, str, DrawModifierKt.drawWithCache(companion, (Function1) objRememberedValue), jM6850getUnspecified0d7_KjU, composerStartRestartGroup, (i3 & 14) | 3072 | ((i3 >> 3) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return IconKt.Icon$lambda$1(painter, colorProducer, str, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1755070997, i3, -1, "androidx.compose.material3.Icon (Icon.kt:189)");
            }
            long jM6850getUnspecified0d7_KjU2 = Color.INSTANCE.m6850getUnspecified0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1298909172, "CC(remember):Icon.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(colorProducer);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.IconKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IconKt.Icon$lambda$0$0(colorProducer, (CacheDrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.IconKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IconKt.Icon$lambda$0$0(colorProducer, (CacheDrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            m3575Iconww6aTOc(painter, str, DrawModifierKt.drawWithCache(companion, (Function1) objRememberedValue), jM6850getUnspecified0d7_KjU2, composerStartRestartGroup, (i3 & 14) | 3072 | ((i3 >> 3) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = companion;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconKt.Icon$lambda$1(painter, colorProducer, str, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult Icon$lambda$0$0(ColorProducer colorProducer, CacheDrawScope cacheDrawScope) {
        final GraphicsLayer graphicsLayerObtainGraphicsLayer = cacheDrawScope.obtainGraphicsLayer();
        CacheDrawScope.m6348recordTdoYBX4$default(cacheDrawScope, graphicsLayerObtainGraphicsLayer, null, null, 0L, new Function1() { // from class: androidx.compose.material3.IconKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IconKt.Icon$lambda$0$0$0$0((ContentDrawScope) obj);
            }
        }, 7, null);
        if (colorProducer != null) {
            graphicsLayerObtainGraphicsLayer.setColorFilter(ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, colorProducer.mo2379invoke0d7_KjU(), 0, 2, null));
        }
        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.material3.IconKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IconKt.Icon$lambda$0$0$1(graphicsLayerObtainGraphicsLayer, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Icon$lambda$0$0$0$0(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Icon$lambda$0$0$1(GraphicsLayer graphicsLayer, ContentDrawScope contentDrawScope) {
        GraphicsLayerKt.drawLayer(contentDrawScope, graphicsLayer);
        return Unit.INSTANCE;
    }

    private static final Modifier defaultSizeFor(Modifier modifier, Painter painter) {
        Modifier.Companion companion;
        if (Size.m6634equalsimpl0(painter.getDrawableIntrinsicSize(), Size.INSTANCE.m6646getUnspecifiedNHjbRc()) || m3577isInfiniteuvyYCjk(painter.getDrawableIntrinsicSize())) {
            companion = DefaultIconSizeModifier;
        } else {
            companion = Modifier.INSTANCE;
        }
        return modifier.then(companion);
    }

    /* JADX INFO: renamed from: isInfinite-uvyYCjk, reason: not valid java name */
    private static final boolean m3577isInfiniteuvyYCjk(long j) {
        return Float.isInfinite(Float.intBitsToFloat((int) (j >> 32))) && Float.isInfinite(Float.intBitsToFloat((int) (j & 4294967295L)));
    }
}
