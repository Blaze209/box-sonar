package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.ImageBitmap;
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
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Icon.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000e\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u0011\u001a\u0014\u0010\u0012\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u0013\u0010\u0013\u001a\u00020\u0014*\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\"\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Icon", "", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "tint", "Landroidx/compose/ui/graphics/Color;", "Icon-ww6aTOc", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "defaultSizeFor", "isInfinite", "", "Landroidx/compose/ui/geometry/Size;", "isInfinite-uvyYCjk", "(J)Z", "DefaultIconSizeModifier", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IconKt {
    private static final Modifier DefaultIconSizeModifier = SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24));

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Icon_ww6aTOc$lambda$3(Painter painter, String str, Modifier modifier, long j, int i, int i2, Composer composer, int i3) {
        m2439Iconww6aTOc(painter, str, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m2440Iconww6aTOc(ImageVector imageVector, String str, Modifier modifier, long j, Composer composer, int i, int i2) {
        long jM6813copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, -800853103, "C(Icon)N(imageVector,contentDescription,modifier,tint:c#ui.graphics.Color)65@3157L7,65@3196L7,68@3238L34,67@3214L164:Icon.kt#jmzs0o");
        Modifier.Companion companion = (i2 & 4) != 0 ? Modifier.INSTANCE : modifier;
        if ((i2 & 8) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            long jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ((Number) objConsume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM6813copywmQWz5c$default = j;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-800853103, i, -1, "androidx.compose.material.Icon (Icon.kt:66)");
        }
        m2439Iconww6aTOc(VectorPainterKt.rememberVectorPainter(imageVector, composer, i & 14), str, companion, jM6813copywmQWz5c$default, composer, VectorPainter.$stable | (i & 112) | (i & 896) | (i & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m2438Iconww6aTOc(ImageBitmap imageBitmap, String str, Modifier modifier, long j, Composer composer, int i, int i2) {
        long jM6813copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, -554892675, "C(Icon)N(bitmap,contentDescription,modifier,tint:c#ui.graphics.Color)99@4818L7,99@4857L7,101@4889L42,102@4936L137:Icon.kt#jmzs0o");
        Modifier.Companion companion = (i2 & 4) != 0 ? Modifier.INSTANCE : modifier;
        if ((i2 & 8) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            long jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ((Number) objConsume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM6813copywmQWz5c$default = j;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-554892675, i, -1, "androidx.compose.material.Icon (Icon.kt:100)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -675909209, "CC(remember):Icon.kt#9igjgp");
        boolean zChanged = composer.changed(imageBitmap);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            BitmapPainter bitmapPainter = new BitmapPainter(imageBitmap, 0L, 0L, 6, null);
            composer.updateRememberedValue(bitmapPainter);
            objRememberedValue = bitmapPainter;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        m2439Iconww6aTOc((BitmapPainter) objRememberedValue, str, companion, jM6813copywmQWz5c$default, composer, i & 8176, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:103:0x01dc  */
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
    /* JADX WARN: Code duplicated, block: B:59:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:78:0x012c  */
    /* JADX WARN: Code duplicated, block: B:80:0x0138  */
    /* JADX WARN: Code duplicated, block: B:81:0x013c  */
    /* JADX WARN: Code duplicated, block: B:85:0x0155  */
    /* JADX WARN: Code duplicated, block: B:87:0x016e  */
    /* JADX WARN: Code duplicated, block: B:88:0x0170  */
    /* JADX WARN: Code duplicated, block: B:93:0x017f  */
    /* JADX WARN: Code duplicated, block: B:95:0x0196  */
    /* JADX WARN: Code duplicated, block: B:98:0x01ca  */
    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m2439Iconww6aTOc(final Painter painter, final String str, Modifier modifier, long j, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long j2;
        boolean z;
        final Modifier modifier3;
        final long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long jM6813copywmQWz5c$default;
        Modifier modifier4;
        boolean z2;
        long j4;
        Object objM6855tintxETnrds$default;
        Modifier.Companion companionSemantics$default;
        boolean z3;
        Object objRememberedValue;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1142959010);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Icon)N(painter,contentDescription,modifier,tint:c#ui.graphics.Color)136@6567L82,146@6911L217:Icon.kt#jmzs0o");
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
                ComposerKt.sourceInformation(composerStartRestartGroup, "133@6484L7,133@6523L7");
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
                        long jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
                        ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localContentAlpha);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ((Number) objConsume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -7169;
                    } else {
                        jM6813copywmQWz5c$default = j2;
                    }
                    modifier4 = companion;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    long j5 = j2;
                    modifier4 = modifier2;
                    jM6813copywmQWz5c$default = j5;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1142959010, i3, -1, "androidx.compose.material.Icon (Icon.kt:134)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128026256, "CC(remember):Icon.kt#9igjgp");
                z2 = (((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(jM6813copywmQWz5c$default)) || (i3 & 3072) == 2048;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    if (Color.m6815equalsimpl0(jM6813copywmQWz5c$default, Color.INSTANCE.m6850getUnspecified0d7_KjU())) {
                        j4 = jM6813copywmQWz5c$default;
                        objM6855tintxETnrds$default = null;
                    } else {
                        j4 = jM6813copywmQWz5c$default;
                        objM6855tintxETnrds$default = ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, j4, 0, 2, null);
                    }
                    composerStartRestartGroup.updateRememberedValue(objM6855tintxETnrds$default);
                } else {
                    j4 = jM6813copywmQWz5c$default;
                    objM6855tintxETnrds$default = objRememberedValue2;
                }
                ColorFilter colorFilter = (ColorFilter) objM6855tintxETnrds$default;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (str != null) {
                    composerStartRestartGroup.startReplaceGroup(609219782);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "139@6743L115");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128031921, "CC(remember):Icon.kt#9igjgp");
                    if ((i3 & 112) == 32) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.IconKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return IconKt.Icon_ww6aTOc$lambda$2$0(str, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    companionSemantics$default = SemanticsModifierKt.semantics$default(companion2, false, (Function1) objRememberedValue, 1, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(609378564);
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
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.IconKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return IconKt.Icon_ww6aTOc$lambda$3(painter, str, modifier3, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            ComposerKt.sourceInformation(composerStartRestartGroup, "133@6484L7,133@6523L7");
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 8) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localContentColor2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long jM6824unboximpl2 = ((Color) objConsume3).m6824unboximpl();
                    ProvidableCompositionLocal<Float> localContentAlpha2 = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localContentAlpha2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl2, ((Number) objConsume4).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                    i3 &= -7169;
                } else {
                    jM6813copywmQWz5c$default = j2;
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
                    Object objConsume5 = composerStartRestartGroup.consume(localContentColor3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long jM6824unboximpl3 = ((Color) objConsume5).m6824unboximpl();
                    ProvidableCompositionLocal<Float> localContentAlpha3 = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume6 = composerStartRestartGroup.consume(localContentAlpha3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl3, ((Number) objConsume6).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                    i3 &= -7169;
                } else {
                    jM6813copywmQWz5c$default = j2;
                }
                modifier4 = companion;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1142959010, i3, -1, "androidx.compose.material.Icon (Icon.kt:134)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128026256, "CC(remember):Icon.kt#9igjgp");
            if (((i3 & 7168) ^ 3072) <= 2048) {
            }
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z2) {
                if (Color.m6815equalsimpl0(jM6813copywmQWz5c$default, Color.INSTANCE.m6850getUnspecified0d7_KjU())) {
                    j4 = jM6813copywmQWz5c$default;
                    objM6855tintxETnrds$default = null;
                } else {
                    j4 = jM6813copywmQWz5c$default;
                    objM6855tintxETnrds$default = ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, j4, 0, 2, null);
                }
                composerStartRestartGroup.updateRememberedValue(objM6855tintxETnrds$default);
            } else {
                if (Color.m6815equalsimpl0(jM6813copywmQWz5c$default, Color.INSTANCE.m6850getUnspecified0d7_KjU())) {
                    j4 = jM6813copywmQWz5c$default;
                    objM6855tintxETnrds$default = null;
                } else {
                    j4 = jM6813copywmQWz5c$default;
                    objM6855tintxETnrds$default = ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, j4, 0, 2, null);
                }
                composerStartRestartGroup.updateRememberedValue(objM6855tintxETnrds$default);
            }
            ColorFilter colorFilter2 = (ColorFilter) objM6855tintxETnrds$default;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (str != null) {
                composerStartRestartGroup.startReplaceGroup(609219782);
                ComposerKt.sourceInformation(composerStartRestartGroup, "139@6743L115");
                Modifier.Companion companion3 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128031921, "CC(remember):Icon.kt#9igjgp");
                if ((i3 & 112) == 32) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.IconKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return IconKt.Icon_ww6aTOc$lambda$2$0(str, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.IconKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return IconKt.Icon_ww6aTOc$lambda$2$0(str, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                companionSemantics$default = SemanticsModifierKt.semantics$default(companion3, false, (Function1) objRememberedValue, 1, null);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(609378564);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.IconKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconKt.Icon_ww6aTOc$lambda$3(painter, str, modifier3, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Icon_ww6aTOc$lambda$2$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.m8851setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8836getImageo7Vup1c());
        return Unit.INSTANCE;
    }

    private static final Modifier defaultSizeFor(Modifier modifier, Painter painter) {
        Modifier.Companion companion;
        if (Size.m6634equalsimpl0(painter.getDrawableIntrinsicSize(), Size.INSTANCE.m6646getUnspecifiedNHjbRc()) || m2441isInfiniteuvyYCjk(painter.getDrawableIntrinsicSize())) {
            companion = DefaultIconSizeModifier;
        } else {
            companion = Modifier.INSTANCE;
        }
        return modifier.then(companion);
    }

    /* JADX INFO: renamed from: isInfinite-uvyYCjk, reason: not valid java name */
    private static final boolean m2441isInfiniteuvyYCjk(long j) {
        return Float.isInfinite(Float.intBitsToFloat((int) (j >> 32))) && Float.isInfinite(Float.intBitsToFloat((int) (j & 4294967295L)));
    }
}
