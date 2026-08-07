package androidx.compose.foundation;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.BitmapPainterKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Image.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a_\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0017\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Image", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "Image-5h-nEew", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ImageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Image$lambda$2(Painter painter, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, int i2, Composer composer, int i3) {
        Image(painter, str, modifier, alignment, contentScale, f, colorFilter, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Consider usage of the Image composable that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "Image(bitmap, contentDescription, modifier, alignment, contentScale, alpha, colorFilter, DefaultFilterQuality)", imports = {"androidx.compose.foundation", "androidx.compose.ui.graphics.DefaultAlpha", "androidx.compose.ui.Alignment", "androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultFilterQuality", "androidx.compose.ui.layout.ContentScale.Fit"}))
    public static final /* synthetic */ void Image(ImageBitmap imageBitmap, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -2123228673, "C(Image)N(bitmap,contentDescription,modifier,alignment,contentScale,alpha,colorFilter)99@4665L178:Image.kt#71ulvw");
        Modifier modifier2 = (i2 & 4) != 0 ? Modifier.INSTANCE : modifier;
        Alignment center = (i2 & 8) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i2 & 16) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f2 = (i2 & 32) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i2 & 64) != 0 ? null : colorFilter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2123228673, i, -1, "androidx.compose.foundation.Image (Image.kt:98)");
        }
        m656Image5hnEew(imageBitmap, str, modifier2, center, fit, f2, colorFilter2, FilterQuality.INSTANCE.m6916getLowfv9h1I(), composer, i & 4194302, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: renamed from: Image-5h-nEew, reason: not valid java name */
    public static final void m656Image5hnEew(ImageBitmap imageBitmap, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -1396260732, "C(Image)N(bitmap,contentDescription,modifier,alignment,contentScale,alpha,colorFilter,filterQuality:c#ui.graphics.FilterQuality)157@7327L73,158@7405L249:Image.kt#71ulvw");
        Modifier.Companion companion = (i3 & 4) != 0 ? Modifier.INSTANCE : modifier;
        Alignment center = (i3 & 8) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i3 & 16) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f2 = (i3 & 32) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i3 & 64) != 0 ? null : colorFilter;
        int iM7398getDefaultFilterQualityfv9h1I = (i3 & 128) != 0 ? DrawScope.INSTANCE.m7398getDefaultFilterQualityfv9h1I() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1396260732, i2, -1, "androidx.compose.foundation.Image (Image.kt:156)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1776755635, "CC(remember):Image.kt#9igjgp");
        boolean zChanged = composer.changed(imageBitmap);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = BitmapPainterKt.m7518BitmapPainterQZhYCtY$default(imageBitmap, 0L, 0L, iM7398getDefaultFilterQualityfv9h1I, 6, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Image((BitmapPainter) objRememberedValue, str, companion, center, fit, f2, colorFilter2, composer, (i2 & 3670016) | BitmapPainter.$stable | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (458752 & i2), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public static final void Image(ImageVector imageVector, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1595907091, "C(Image)N(imageVector,contentDescription,modifier,alignment,contentScale,alpha,colorFilter)203@9457L34,202@9432L270:Image.kt#71ulvw");
        if ((i2 & 4) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if ((i2 & 8) != 0) {
            alignment = Alignment.INSTANCE.getCenter();
        }
        Alignment alignment2 = alignment;
        if ((i2 & 16) != 0) {
            contentScale = ContentScale.INSTANCE.getFit();
        }
        ContentScale contentScale2 = contentScale;
        if ((i2 & 32) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        ColorFilter colorFilter2 = (i2 & 64) != 0 ? null : colorFilter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1595907091, i, -1, "androidx.compose.foundation.Image (Image.kt:202)");
        }
        Image(VectorPainterKt.rememberVectorPainter(imageVector, composer, i & 14), str, modifier, alignment2, contentScale2, f2, colorFilter2, composer, VectorPainter.$stable | (i & 112) | (i & 896) | (i & 7168) | (57344 & i) | (458752 & i) | (3670016 & i), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0122  */
    /* JADX WARN: Code duplicated, block: B:103:0x013d  */
    /* JADX WARN: Code duplicated, block: B:104:0x013f  */
    /* JADX WARN: Code duplicated, block: B:107:0x0146  */
    /* JADX WARN: Code duplicated, block: B:109:0x014e  */
    /* JADX WARN: Code duplicated, block: B:111:0x0163  */
    /* JADX WARN: Code duplicated, block: B:114:0x0199  */
    /* JADX WARN: Code duplicated, block: B:117:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:120:0x01df  */
    /* JADX WARN: Code duplicated, block: B:121:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:124:0x022a  */
    /* JADX WARN: Code duplicated, block: B:126:0x0233  */
    /* JADX WARN: Code duplicated, block: B:129:0x0243  */
    /* JADX WARN: Code duplicated, block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:36:0x0064  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:44:0x0079  */
    /* JADX WARN: Code duplicated, block: B:45:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0080  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b  */
    /* JADX WARN: Code duplicated, block: B:55:0x0097  */
    /* JADX WARN: Code duplicated, block: B:56:0x0099  */
    /* JADX WARN: Code duplicated, block: B:58:0x009c  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00be  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:77:0x00db  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:82:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:88:0x0101  */
    /* JADX WARN: Code duplicated, block: B:90:0x0104  */
    /* JADX WARN: Code duplicated, block: B:91:0x0107  */
    /* JADX WARN: Code duplicated, block: B:94:0x010b  */
    /* JADX WARN: Code duplicated, block: B:95:0x010d  */
    /* JADX WARN: Code duplicated, block: B:98:0x0115  */
    public static final void Image(final Painter painter, final String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        int i6;
        ContentScale contentScale2;
        int i7;
        int i8;
        float f2;
        int i9;
        int i10;
        int i11;
        boolean z;
        final Alignment alignment2;
        final ColorFilter colorFilter2;
        final Modifier modifier3;
        final ContentScale contentScale3;
        final float f3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Alignment center;
        ContentScale fit;
        float f4;
        ColorFilter colorFilter3;
        Modifier.Companion companionSemantics$default;
        ImageKt$Image$1$1 imageKt$Image$1$1RememberedValue;
        Function0<ComposeUiNode> constructor;
        boolean z2;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(1142754848);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Image)N(painter,contentDescription,modifier,alignment,contentScale,alpha,colorFilter)271@12440L88,260@12135L393:Image.kt#71ulvw");
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(painter) : composerStartRestartGroup.changedInstance(painter) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        int i12 = i2 & 4;
        if (i12 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changed(alignment)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        contentScale2 = contentScale;
                        if (composerStartRestartGroup.changed(contentScale2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        if ((196608 & i) == 0) {
                            f2 = f;
                            if (composerStartRestartGroup.changed(f2)) {
                                i9 = 131072;
                            } else {
                                i9 = 65536;
                            }
                            i3 |= i9;
                        }
                        i10 = i2 & 64;
                        if (i10 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(colorFilter)) {
                                i11 = 1048576;
                            } else {
                                i11 = 524288;
                            }
                            i3 |= i11;
                        }
                        if ((i3 & 599187) != 599186) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            alignment2 = alignment;
                            colorFilter2 = colorFilter;
                            modifier3 = modifier2;
                            contentScale3 = contentScale2;
                            f3 = f2;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                center = Alignment.INSTANCE.getCenter();
                            } else {
                                center = alignment;
                            }
                            if (i6 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            } else {
                                fit = contentScale2;
                            }
                            if (i8 != 0) {
                                f4 = 1.0f;
                            } else {
                                f4 = f2;
                            }
                            if (i10 != 0) {
                                colorFilter3 = null;
                            } else {
                                colorFilter3 = colorFilter;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1142754848, i3, -1, "androidx.compose.foundation.Image (Image.kt:247)");
                            }
                            if (str != null) {
                                composerStartRestartGroup.startReplaceGroup(1899222916);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "250@11847L115");
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324207053, "CC(remember):Image.kt#9igjgp");
                                if ((i3 & 112) == 32) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                companionSemantics$default = SemanticsModifierKt.semantics$default(companion2, false, (Function1) objRememberedValue, 1, null);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1899381698);
                                composerStartRestartGroup.endReplaceGroup();
                                companionSemantics$default = Modifier.INSTANCE;
                            }
                            ColorFilter colorFilter4 = colorFilter3;
                            Modifier modifier4 = companion;
                            Alignment alignment3 = center;
                            Modifier modifierPaint$default = PainterModifierKt.paint$default(ClipKt.clipToBounds(companion.then(companionSemantics$default)), painter, false, alignment3, fit, f4, colorFilter4, 2, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324188104, "CC(remember):Image.kt#9igjgp");
                            imageKt$Image$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (imageKt$Image$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                imageKt$Image$1$1RememberedValue = ImageKt$Image$1$1.INSTANCE;
                                composerStartRestartGroup.updateRememberedValue(imageKt$Image$1$1RememberedValue);
                            }
                            MeasurePolicy measurePolicy = (MeasurePolicy) imageKt$Image$1$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544976794, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
                            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPaint$default);
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
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
                            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            colorFilter2 = colorFilter4;
                            f3 = f4;
                            contentScale3 = fit;
                            alignment2 = alignment3;
                            modifier3 = modifier4;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ImageKt.Image$lambda$2(painter, str, modifier3, alignment2, contentScale3, f3, colorFilter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    f2 = f;
                    i10 = i2 & 64;
                    if (i10 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(colorFilter)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        alignment2 = alignment;
                        colorFilter2 = colorFilter;
                        modifier3 = modifier2;
                        contentScale3 = contentScale2;
                        f3 = f2;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        } else {
                            center = alignment;
                        }
                        if (i6 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        } else {
                            fit = contentScale2;
                        }
                        if (i8 != 0) {
                            f4 = 1.0f;
                        } else {
                            f4 = f2;
                        }
                        if (i10 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1142754848, i3, -1, "androidx.compose.foundation.Image (Image.kt:247)");
                        }
                        if (str != null) {
                            composerStartRestartGroup.startReplaceGroup(1899222916);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "250@11847L115");
                            Modifier.Companion companion3 = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324207053, "CC(remember):Image.kt#9igjgp");
                            if ((i3 & 112) == 32) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z2) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            companionSemantics$default = SemanticsModifierKt.semantics$default(companion3, false, (Function1) objRememberedValue, 1, null);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1899381698);
                            composerStartRestartGroup.endReplaceGroup();
                            companionSemantics$default = Modifier.INSTANCE;
                        }
                        ColorFilter colorFilter5 = colorFilter3;
                        Modifier modifier5 = companion;
                        Alignment alignment4 = center;
                        Modifier modifierPaint$default2 = PainterModifierKt.paint$default(ClipKt.clipToBounds(companion.then(companionSemantics$default)), painter, false, alignment4, fit, f4, colorFilter5, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324188104, "CC(remember):Image.kt#9igjgp");
                        imageKt$Image$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (imageKt$Image$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            imageKt$Image$1$1RememberedValue = ImageKt$Image$1$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(imageKt$Image$1$1RememberedValue);
                        }
                        MeasurePolicy measurePolicy2 = (MeasurePolicy) imageKt$Image$1$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544976794, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
                        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPaint$default2);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
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
                        Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        colorFilter2 = colorFilter5;
                        f3 = f4;
                        contentScale3 = fit;
                        alignment2 = alignment4;
                        modifier3 = modifier5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ImageKt.Image$lambda$2(painter, str, modifier3, alignment2, contentScale3, f3, colorFilter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                contentScale2 = contentScale;
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        f2 = f;
                        if (composerStartRestartGroup.changed(f2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 64;
                    if (i10 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(colorFilter)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        alignment2 = alignment;
                        colorFilter2 = colorFilter;
                        modifier3 = modifier2;
                        contentScale3 = contentScale2;
                        f3 = f2;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        } else {
                            center = alignment;
                        }
                        if (i6 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        } else {
                            fit = contentScale2;
                        }
                        if (i8 != 0) {
                            f4 = 1.0f;
                        } else {
                            f4 = f2;
                        }
                        if (i10 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1142754848, i3, -1, "androidx.compose.foundation.Image (Image.kt:247)");
                        }
                        if (str != null) {
                            composerStartRestartGroup.startReplaceGroup(1899222916);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "250@11847L115");
                            Modifier.Companion companion4 = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324207053, "CC(remember):Image.kt#9igjgp");
                            if ((i3 & 112) == 32) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z2) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            companionSemantics$default = SemanticsModifierKt.semantics$default(companion4, false, (Function1) objRememberedValue, 1, null);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1899381698);
                            composerStartRestartGroup.endReplaceGroup();
                            companionSemantics$default = Modifier.INSTANCE;
                        }
                        ColorFilter colorFilter6 = colorFilter3;
                        Modifier modifier6 = companion;
                        Alignment alignment5 = center;
                        Modifier modifierPaint$default3 = PainterModifierKt.paint$default(ClipKt.clipToBounds(companion.then(companionSemantics$default)), painter, false, alignment5, fit, f4, colorFilter6, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324188104, "CC(remember):Image.kt#9igjgp");
                        imageKt$Image$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (imageKt$Image$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            imageKt$Image$1$1RememberedValue = ImageKt$Image$1$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(imageKt$Image$1$1RememberedValue);
                        }
                        MeasurePolicy measurePolicy3 = (MeasurePolicy) imageKt$Image$1$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544976794, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
                        int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPaint$default3);
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
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
                        Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        colorFilter2 = colorFilter6;
                        f3 = f4;
                        contentScale3 = fit;
                        alignment2 = alignment5;
                        modifier3 = modifier6;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ImageKt.Image$lambda$2(painter, str, modifier3, alignment2, contentScale3, f3, colorFilter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                f2 = f;
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(colorFilter)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    alignment2 = alignment;
                    colorFilter2 = colorFilter;
                    modifier3 = modifier2;
                    contentScale3 = contentScale2;
                    f3 = f2;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        center = Alignment.INSTANCE.getCenter();
                    } else {
                        center = alignment;
                    }
                    if (i6 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    } else {
                        fit = contentScale2;
                    }
                    if (i8 != 0) {
                        f4 = 1.0f;
                    } else {
                        f4 = f2;
                    }
                    if (i10 != 0) {
                        colorFilter3 = null;
                    } else {
                        colorFilter3 = colorFilter;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1142754848, i3, -1, "androidx.compose.foundation.Image (Image.kt:247)");
                    }
                    if (str != null) {
                        composerStartRestartGroup.startReplaceGroup(1899222916);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "250@11847L115");
                        Modifier.Companion companion5 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324207053, "CC(remember):Image.kt#9igjgp");
                        if ((i3 & 112) == 32) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        companionSemantics$default = SemanticsModifierKt.semantics$default(companion5, false, (Function1) objRememberedValue, 1, null);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1899381698);
                        composerStartRestartGroup.endReplaceGroup();
                        companionSemantics$default = Modifier.INSTANCE;
                    }
                    ColorFilter colorFilter7 = colorFilter3;
                    Modifier modifier7 = companion;
                    Alignment alignment6 = center;
                    Modifier modifierPaint$default4 = PainterModifierKt.paint$default(ClipKt.clipToBounds(companion.then(companionSemantics$default)), painter, false, alignment6, fit, f4, colorFilter7, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324188104, "CC(remember):Image.kt#9igjgp");
                    imageKt$Image$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (imageKt$Image$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        imageKt$Image$1$1RememberedValue = ImageKt$Image$1$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(imageKt$Image$1$1RememberedValue);
                    }
                    MeasurePolicy measurePolicy4 = (MeasurePolicy) imageKt$Image$1$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544976794, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
                    int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPaint$default4);
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    colorFilter2 = colorFilter7;
                    f3 = f4;
                    contentScale3 = fit;
                    alignment2 = alignment6;
                    modifier3 = modifier7;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ImageKt.Image$lambda$2(painter, str, modifier3, alignment2, contentScale3, f3, colorFilter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    contentScale2 = contentScale;
                    if (composerStartRestartGroup.changed(contentScale2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        f2 = f;
                        if (composerStartRestartGroup.changed(f2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 64;
                    if (i10 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(colorFilter)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        alignment2 = alignment;
                        colorFilter2 = colorFilter;
                        modifier3 = modifier2;
                        contentScale3 = contentScale2;
                        f3 = f2;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        } else {
                            center = alignment;
                        }
                        if (i6 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        } else {
                            fit = contentScale2;
                        }
                        if (i8 != 0) {
                            f4 = 1.0f;
                        } else {
                            f4 = f2;
                        }
                        if (i10 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1142754848, i3, -1, "androidx.compose.foundation.Image (Image.kt:247)");
                        }
                        if (str != null) {
                            composerStartRestartGroup.startReplaceGroup(1899222916);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "250@11847L115");
                            Modifier.Companion companion6 = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324207053, "CC(remember):Image.kt#9igjgp");
                            if ((i3 & 112) == 32) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z2) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            companionSemantics$default = SemanticsModifierKt.semantics$default(companion6, false, (Function1) objRememberedValue, 1, null);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1899381698);
                            composerStartRestartGroup.endReplaceGroup();
                            companionSemantics$default = Modifier.INSTANCE;
                        }
                        ColorFilter colorFilter8 = colorFilter3;
                        Modifier modifier8 = companion;
                        Alignment alignment7 = center;
                        Modifier modifierPaint$default5 = PainterModifierKt.paint$default(ClipKt.clipToBounds(companion.then(companionSemantics$default)), painter, false, alignment7, fit, f4, colorFilter8, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324188104, "CC(remember):Image.kt#9igjgp");
                        imageKt$Image$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (imageKt$Image$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            imageKt$Image$1$1RememberedValue = ImageKt$Image$1$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(imageKt$Image$1$1RememberedValue);
                        }
                        MeasurePolicy measurePolicy5 = (MeasurePolicy) imageKt$Image$1$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544976794, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
                        int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPaint$default5);
                        CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM6062constructorimpl5 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl5, measurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                        Updater.m6066initimpl(composerM6062constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        colorFilter2 = colorFilter8;
                        f3 = f4;
                        contentScale3 = fit;
                        alignment2 = alignment7;
                        modifier3 = modifier8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ImageKt.Image$lambda$2(painter, str, modifier3, alignment2, contentScale3, f3, colorFilter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                f2 = f;
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(colorFilter)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    alignment2 = alignment;
                    colorFilter2 = colorFilter;
                    modifier3 = modifier2;
                    contentScale3 = contentScale2;
                    f3 = f2;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        center = Alignment.INSTANCE.getCenter();
                    } else {
                        center = alignment;
                    }
                    if (i6 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    } else {
                        fit = contentScale2;
                    }
                    if (i8 != 0) {
                        f4 = 1.0f;
                    } else {
                        f4 = f2;
                    }
                    if (i10 != 0) {
                        colorFilter3 = null;
                    } else {
                        colorFilter3 = colorFilter;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1142754848, i3, -1, "androidx.compose.foundation.Image (Image.kt:247)");
                    }
                    if (str != null) {
                        composerStartRestartGroup.startReplaceGroup(1899222916);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "250@11847L115");
                        Modifier.Companion companion7 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324207053, "CC(remember):Image.kt#9igjgp");
                        if ((i3 & 112) == 32) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        companionSemantics$default = SemanticsModifierKt.semantics$default(companion7, false, (Function1) objRememberedValue, 1, null);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1899381698);
                        composerStartRestartGroup.endReplaceGroup();
                        companionSemantics$default = Modifier.INSTANCE;
                    }
                    ColorFilter colorFilter9 = colorFilter3;
                    Modifier modifier9 = companion;
                    Alignment alignment8 = center;
                    Modifier modifierPaint$default6 = PainterModifierKt.paint$default(ClipKt.clipToBounds(companion.then(companionSemantics$default)), painter, false, alignment8, fit, f4, colorFilter9, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324188104, "CC(remember):Image.kt#9igjgp");
                    imageKt$Image$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (imageKt$Image$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        imageKt$Image$1$1RememberedValue = ImageKt$Image$1$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(imageKt$Image$1$1RememberedValue);
                    }
                    MeasurePolicy measurePolicy6 = (MeasurePolicy) imageKt$Image$1$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544976794, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
                    int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPaint$default6);
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl6 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl6, measurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    Updater.m6066initimpl(composerM6062constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    colorFilter2 = colorFilter9;
                    f3 = f4;
                    contentScale3 = fit;
                    alignment2 = alignment8;
                    modifier3 = modifier9;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ImageKt.Image$lambda$2(painter, str, modifier3, alignment2, contentScale3, f3, colorFilter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            contentScale2 = contentScale;
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(colorFilter)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    alignment2 = alignment;
                    colorFilter2 = colorFilter;
                    modifier3 = modifier2;
                    contentScale3 = contentScale2;
                    f3 = f2;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        center = Alignment.INSTANCE.getCenter();
                    } else {
                        center = alignment;
                    }
                    if (i6 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    } else {
                        fit = contentScale2;
                    }
                    if (i8 != 0) {
                        f4 = 1.0f;
                    } else {
                        f4 = f2;
                    }
                    if (i10 != 0) {
                        colorFilter3 = null;
                    } else {
                        colorFilter3 = colorFilter;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1142754848, i3, -1, "androidx.compose.foundation.Image (Image.kt:247)");
                    }
                    if (str != null) {
                        composerStartRestartGroup.startReplaceGroup(1899222916);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "250@11847L115");
                        Modifier.Companion companion8 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324207053, "CC(remember):Image.kt#9igjgp");
                        if ((i3 & 112) == 32) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        companionSemantics$default = SemanticsModifierKt.semantics$default(companion8, false, (Function1) objRememberedValue, 1, null);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1899381698);
                        composerStartRestartGroup.endReplaceGroup();
                        companionSemantics$default = Modifier.INSTANCE;
                    }
                    ColorFilter colorFilter10 = colorFilter3;
                    Modifier modifier10 = companion;
                    Alignment alignment9 = center;
                    Modifier modifierPaint$default7 = PainterModifierKt.paint$default(ClipKt.clipToBounds(companion.then(companionSemantics$default)), painter, false, alignment9, fit, f4, colorFilter10, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324188104, "CC(remember):Image.kt#9igjgp");
                    imageKt$Image$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (imageKt$Image$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        imageKt$Image$1$1RememberedValue = ImageKt$Image$1$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(imageKt$Image$1$1RememberedValue);
                    }
                    MeasurePolicy measurePolicy7 = (MeasurePolicy) imageKt$Image$1$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544976794, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
                    int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPaint$default7);
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl7 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl7, measurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                    Updater.m6066initimpl(composerM6062constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    colorFilter2 = colorFilter10;
                    f3 = f4;
                    contentScale3 = fit;
                    alignment2 = alignment9;
                    modifier3 = modifier10;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ImageKt.Image$lambda$2(painter, str, modifier3, alignment2, contentScale3, f3, colorFilter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            f2 = f;
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(colorFilter)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                alignment2 = alignment;
                colorFilter2 = colorFilter;
                modifier3 = modifier2;
                contentScale3 = contentScale2;
                f3 = f2;
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    center = Alignment.INSTANCE.getCenter();
                } else {
                    center = alignment;
                }
                if (i6 != 0) {
                    fit = ContentScale.INSTANCE.getFit();
                } else {
                    fit = contentScale2;
                }
                if (i8 != 0) {
                    f4 = 1.0f;
                } else {
                    f4 = f2;
                }
                if (i10 != 0) {
                    colorFilter3 = null;
                } else {
                    colorFilter3 = colorFilter;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1142754848, i3, -1, "androidx.compose.foundation.Image (Image.kt:247)");
                }
                if (str != null) {
                    composerStartRestartGroup.startReplaceGroup(1899222916);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "250@11847L115");
                    Modifier.Companion companion9 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324207053, "CC(remember):Image.kt#9igjgp");
                    if ((i3 & 112) == 32) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    companionSemantics$default = SemanticsModifierKt.semantics$default(companion9, false, (Function1) objRememberedValue, 1, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1899381698);
                    composerStartRestartGroup.endReplaceGroup();
                    companionSemantics$default = Modifier.INSTANCE;
                }
                ColorFilter colorFilter11 = colorFilter3;
                Modifier modifier11 = companion;
                Alignment alignment10 = center;
                Modifier modifierPaint$default8 = PainterModifierKt.paint$default(ClipKt.clipToBounds(companion.then(companionSemantics$default)), painter, false, alignment10, fit, f4, colorFilter11, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324188104, "CC(remember):Image.kt#9igjgp");
                imageKt$Image$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (imageKt$Image$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    imageKt$Image$1$1RememberedValue = ImageKt$Image$1$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(imageKt$Image$1$1RememberedValue);
                }
                MeasurePolicy measurePolicy8 = (MeasurePolicy) imageKt$Image$1$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544976794, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
                int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPaint$default8);
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl8 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl8, measurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6068reconcileimpl(composerM6062constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                Updater.m6066initimpl(composerM6062constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                colorFilter2 = colorFilter11;
                f3 = f4;
                contentScale3 = fit;
                alignment2 = alignment10;
                modifier3 = modifier11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ImageKt.Image$lambda$2(painter, str, modifier3, alignment2, contentScale3, f3, colorFilter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changed(alignment)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    contentScale2 = contentScale;
                    if (composerStartRestartGroup.changed(contentScale2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        f2 = f;
                        if (composerStartRestartGroup.changed(f2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 64;
                    if (i10 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(colorFilter)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        alignment2 = alignment;
                        colorFilter2 = colorFilter;
                        modifier3 = modifier2;
                        contentScale3 = contentScale2;
                        f3 = f2;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        } else {
                            center = alignment;
                        }
                        if (i6 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        } else {
                            fit = contentScale2;
                        }
                        if (i8 != 0) {
                            f4 = 1.0f;
                        } else {
                            f4 = f2;
                        }
                        if (i10 != 0) {
                            colorFilter3 = null;
                        } else {
                            colorFilter3 = colorFilter;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1142754848, i3, -1, "androidx.compose.foundation.Image (Image.kt:247)");
                        }
                        if (str != null) {
                            composerStartRestartGroup.startReplaceGroup(1899222916);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "250@11847L115");
                            Modifier.Companion companion10 = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324207053, "CC(remember):Image.kt#9igjgp");
                            if ((i3 & 112) == 32) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z2) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            companionSemantics$default = SemanticsModifierKt.semantics$default(companion10, false, (Function1) objRememberedValue, 1, null);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1899381698);
                            composerStartRestartGroup.endReplaceGroup();
                            companionSemantics$default = Modifier.INSTANCE;
                        }
                        ColorFilter colorFilter12 = colorFilter3;
                        Modifier modifier12 = companion;
                        Alignment alignment11 = center;
                        Modifier modifierPaint$default9 = PainterModifierKt.paint$default(ClipKt.clipToBounds(companion.then(companionSemantics$default)), painter, false, alignment11, fit, f4, colorFilter12, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324188104, "CC(remember):Image.kt#9igjgp");
                        imageKt$Image$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (imageKt$Image$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            imageKt$Image$1$1RememberedValue = ImageKt$Image$1$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(imageKt$Image$1$1RememberedValue);
                        }
                        MeasurePolicy measurePolicy9 = (MeasurePolicy) imageKt$Image$1$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544976794, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
                        int iHashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPaint$default9);
                        CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM6062constructorimpl9 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl9, measurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl9, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl9, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                        Updater.m6066initimpl(composerM6062constructorimpl9, Integer.valueOf(iHashCode9), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        colorFilter2 = colorFilter12;
                        f3 = f4;
                        contentScale3 = fit;
                        alignment2 = alignment11;
                        modifier3 = modifier12;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ImageKt.Image$lambda$2(painter, str, modifier3, alignment2, contentScale3, f3, colorFilter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                f2 = f;
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(colorFilter)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    alignment2 = alignment;
                    colorFilter2 = colorFilter;
                    modifier3 = modifier2;
                    contentScale3 = contentScale2;
                    f3 = f2;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        center = Alignment.INSTANCE.getCenter();
                    } else {
                        center = alignment;
                    }
                    if (i6 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    } else {
                        fit = contentScale2;
                    }
                    if (i8 != 0) {
                        f4 = 1.0f;
                    } else {
                        f4 = f2;
                    }
                    if (i10 != 0) {
                        colorFilter3 = null;
                    } else {
                        colorFilter3 = colorFilter;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1142754848, i3, -1, "androidx.compose.foundation.Image (Image.kt:247)");
                    }
                    if (str != null) {
                        composerStartRestartGroup.startReplaceGroup(1899222916);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "250@11847L115");
                        Modifier.Companion companion11 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324207053, "CC(remember):Image.kt#9igjgp");
                        if ((i3 & 112) == 32) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        companionSemantics$default = SemanticsModifierKt.semantics$default(companion11, false, (Function1) objRememberedValue, 1, null);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1899381698);
                        composerStartRestartGroup.endReplaceGroup();
                        companionSemantics$default = Modifier.INSTANCE;
                    }
                    ColorFilter colorFilter13 = colorFilter3;
                    Modifier modifier13 = companion;
                    Alignment alignment12 = center;
                    Modifier modifierPaint$default10 = PainterModifierKt.paint$default(ClipKt.clipToBounds(companion.then(companionSemantics$default)), painter, false, alignment12, fit, f4, colorFilter13, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324188104, "CC(remember):Image.kt#9igjgp");
                    imageKt$Image$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (imageKt$Image$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        imageKt$Image$1$1RememberedValue = ImageKt$Image$1$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(imageKt$Image$1$1RememberedValue);
                    }
                    MeasurePolicy measurePolicy10 = (MeasurePolicy) imageKt$Image$1$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544976794, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
                    int iHashCode10 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPaint$default10);
                    CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl10 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl10, measurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl10, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl10, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl10, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                    Updater.m6066initimpl(composerM6062constructorimpl10, Integer.valueOf(iHashCode10), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    colorFilter2 = colorFilter13;
                    f3 = f4;
                    contentScale3 = fit;
                    alignment2 = alignment12;
                    modifier3 = modifier13;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ImageKt.Image$lambda$2(painter, str, modifier3, alignment2, contentScale3, f3, colorFilter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            contentScale2 = contentScale;
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(colorFilter)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    alignment2 = alignment;
                    colorFilter2 = colorFilter;
                    modifier3 = modifier2;
                    contentScale3 = contentScale2;
                    f3 = f2;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        center = Alignment.INSTANCE.getCenter();
                    } else {
                        center = alignment;
                    }
                    if (i6 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    } else {
                        fit = contentScale2;
                    }
                    if (i8 != 0) {
                        f4 = 1.0f;
                    } else {
                        f4 = f2;
                    }
                    if (i10 != 0) {
                        colorFilter3 = null;
                    } else {
                        colorFilter3 = colorFilter;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1142754848, i3, -1, "androidx.compose.foundation.Image (Image.kt:247)");
                    }
                    if (str != null) {
                        composerStartRestartGroup.startReplaceGroup(1899222916);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "250@11847L115");
                        Modifier.Companion companion12 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324207053, "CC(remember):Image.kt#9igjgp");
                        if ((i3 & 112) == 32) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        companionSemantics$default = SemanticsModifierKt.semantics$default(companion12, false, (Function1) objRememberedValue, 1, null);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1899381698);
                        composerStartRestartGroup.endReplaceGroup();
                        companionSemantics$default = Modifier.INSTANCE;
                    }
                    ColorFilter colorFilter14 = colorFilter3;
                    Modifier modifier14 = companion;
                    Alignment alignment13 = center;
                    Modifier modifierPaint$default11 = PainterModifierKt.paint$default(ClipKt.clipToBounds(companion.then(companionSemantics$default)), painter, false, alignment13, fit, f4, colorFilter14, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324188104, "CC(remember):Image.kt#9igjgp");
                    imageKt$Image$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (imageKt$Image$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        imageKt$Image$1$1RememberedValue = ImageKt$Image$1$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(imageKt$Image$1$1RememberedValue);
                    }
                    MeasurePolicy measurePolicy11 = (MeasurePolicy) imageKt$Image$1$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544976794, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
                    int iHashCode11 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPaint$default11);
                    CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl11 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl11, measurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl11, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl11, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                    Updater.m6066initimpl(composerM6062constructorimpl11, Integer.valueOf(iHashCode11), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    colorFilter2 = colorFilter14;
                    f3 = f4;
                    contentScale3 = fit;
                    alignment2 = alignment13;
                    modifier3 = modifier14;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ImageKt.Image$lambda$2(painter, str, modifier3, alignment2, contentScale3, f3, colorFilter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            f2 = f;
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(colorFilter)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                alignment2 = alignment;
                colorFilter2 = colorFilter;
                modifier3 = modifier2;
                contentScale3 = contentScale2;
                f3 = f2;
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    center = Alignment.INSTANCE.getCenter();
                } else {
                    center = alignment;
                }
                if (i6 != 0) {
                    fit = ContentScale.INSTANCE.getFit();
                } else {
                    fit = contentScale2;
                }
                if (i8 != 0) {
                    f4 = 1.0f;
                } else {
                    f4 = f2;
                }
                if (i10 != 0) {
                    colorFilter3 = null;
                } else {
                    colorFilter3 = colorFilter;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1142754848, i3, -1, "androidx.compose.foundation.Image (Image.kt:247)");
                }
                if (str != null) {
                    composerStartRestartGroup.startReplaceGroup(1899222916);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "250@11847L115");
                    Modifier.Companion companion13 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324207053, "CC(remember):Image.kt#9igjgp");
                    if ((i3 & 112) == 32) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    companionSemantics$default = SemanticsModifierKt.semantics$default(companion13, false, (Function1) objRememberedValue, 1, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1899381698);
                    composerStartRestartGroup.endReplaceGroup();
                    companionSemantics$default = Modifier.INSTANCE;
                }
                ColorFilter colorFilter15 = colorFilter3;
                Modifier modifier15 = companion;
                Alignment alignment14 = center;
                Modifier modifierPaint$default12 = PainterModifierKt.paint$default(ClipKt.clipToBounds(companion.then(companionSemantics$default)), painter, false, alignment14, fit, f4, colorFilter15, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324188104, "CC(remember):Image.kt#9igjgp");
                imageKt$Image$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (imageKt$Image$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    imageKt$Image$1$1RememberedValue = ImageKt$Image$1$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(imageKt$Image$1$1RememberedValue);
                }
                MeasurePolicy measurePolicy12 = (MeasurePolicy) imageKt$Image$1$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544976794, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
                int iHashCode12 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPaint$default12);
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl12 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl12, measurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6068reconcileimpl(composerM6062constructorimpl12, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl12, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                Updater.m6066initimpl(composerM6062constructorimpl12, Integer.valueOf(iHashCode12), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                colorFilter2 = colorFilter15;
                f3 = f4;
                contentScale3 = fit;
                alignment2 = alignment14;
                modifier3 = modifier15;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ImageKt.Image$lambda$2(painter, str, modifier3, alignment2, contentScale3, f3, colorFilter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                contentScale2 = contentScale;
                if (composerStartRestartGroup.changed(contentScale2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(colorFilter)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    alignment2 = alignment;
                    colorFilter2 = colorFilter;
                    modifier3 = modifier2;
                    contentScale3 = contentScale2;
                    f3 = f2;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        center = Alignment.INSTANCE.getCenter();
                    } else {
                        center = alignment;
                    }
                    if (i6 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    } else {
                        fit = contentScale2;
                    }
                    if (i8 != 0) {
                        f4 = 1.0f;
                    } else {
                        f4 = f2;
                    }
                    if (i10 != 0) {
                        colorFilter3 = null;
                    } else {
                        colorFilter3 = colorFilter;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1142754848, i3, -1, "androidx.compose.foundation.Image (Image.kt:247)");
                    }
                    if (str != null) {
                        composerStartRestartGroup.startReplaceGroup(1899222916);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "250@11847L115");
                        Modifier.Companion companion14 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324207053, "CC(remember):Image.kt#9igjgp");
                        if ((i3 & 112) == 32) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        companionSemantics$default = SemanticsModifierKt.semantics$default(companion14, false, (Function1) objRememberedValue, 1, null);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1899381698);
                        composerStartRestartGroup.endReplaceGroup();
                        companionSemantics$default = Modifier.INSTANCE;
                    }
                    ColorFilter colorFilter16 = colorFilter3;
                    Modifier modifier16 = companion;
                    Alignment alignment15 = center;
                    Modifier modifierPaint$default13 = PainterModifierKt.paint$default(ClipKt.clipToBounds(companion.then(companionSemantics$default)), painter, false, alignment15, fit, f4, colorFilter16, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324188104, "CC(remember):Image.kt#9igjgp");
                    imageKt$Image$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (imageKt$Image$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        imageKt$Image$1$1RememberedValue = ImageKt$Image$1$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(imageKt$Image$1$1RememberedValue);
                    }
                    MeasurePolicy measurePolicy13 = (MeasurePolicy) imageKt$Image$1$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544976794, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
                    int iHashCode13 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPaint$default13);
                    CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl13 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl13, measurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl13, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl13, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                    Updater.m6066initimpl(composerM6062constructorimpl13, Integer.valueOf(iHashCode13), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    colorFilter2 = colorFilter16;
                    f3 = f4;
                    contentScale3 = fit;
                    alignment2 = alignment15;
                    modifier3 = modifier16;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ImageKt.Image$lambda$2(painter, str, modifier3, alignment2, contentScale3, f3, colorFilter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            f2 = f;
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(colorFilter)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                alignment2 = alignment;
                colorFilter2 = colorFilter;
                modifier3 = modifier2;
                contentScale3 = contentScale2;
                f3 = f2;
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    center = Alignment.INSTANCE.getCenter();
                } else {
                    center = alignment;
                }
                if (i6 != 0) {
                    fit = ContentScale.INSTANCE.getFit();
                } else {
                    fit = contentScale2;
                }
                if (i8 != 0) {
                    f4 = 1.0f;
                } else {
                    f4 = f2;
                }
                if (i10 != 0) {
                    colorFilter3 = null;
                } else {
                    colorFilter3 = colorFilter;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1142754848, i3, -1, "androidx.compose.foundation.Image (Image.kt:247)");
                }
                if (str != null) {
                    composerStartRestartGroup.startReplaceGroup(1899222916);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "250@11847L115");
                    Modifier.Companion companion15 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324207053, "CC(remember):Image.kt#9igjgp");
                    if ((i3 & 112) == 32) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    companionSemantics$default = SemanticsModifierKt.semantics$default(companion15, false, (Function1) objRememberedValue, 1, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1899381698);
                    composerStartRestartGroup.endReplaceGroup();
                    companionSemantics$default = Modifier.INSTANCE;
                }
                ColorFilter colorFilter17 = colorFilter3;
                Modifier modifier17 = companion;
                Alignment alignment16 = center;
                Modifier modifierPaint$default14 = PainterModifierKt.paint$default(ClipKt.clipToBounds(companion.then(companionSemantics$default)), painter, false, alignment16, fit, f4, colorFilter17, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324188104, "CC(remember):Image.kt#9igjgp");
                imageKt$Image$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (imageKt$Image$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    imageKt$Image$1$1RememberedValue = ImageKt$Image$1$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(imageKt$Image$1$1RememberedValue);
                }
                MeasurePolicy measurePolicy14 = (MeasurePolicy) imageKt$Image$1$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544976794, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
                int iHashCode14 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPaint$default14);
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl14 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl14, measurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl14, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6068reconcileimpl(composerM6062constructorimpl14, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl14, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                Updater.m6066initimpl(composerM6062constructorimpl14, Integer.valueOf(iHashCode14), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                colorFilter2 = colorFilter17;
                f3 = f4;
                contentScale3 = fit;
                alignment2 = alignment16;
                modifier3 = modifier17;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ImageKt.Image$lambda$2(painter, str, modifier3, alignment2, contentScale3, f3, colorFilter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        contentScale2 = contentScale;
        i8 = i2 & 32;
        if (i8 != 0) {
            if ((196608 & i) == 0) {
                f2 = f;
                if (composerStartRestartGroup.changed(f2)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(colorFilter)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                alignment2 = alignment;
                colorFilter2 = colorFilter;
                modifier3 = modifier2;
                contentScale3 = contentScale2;
                f3 = f2;
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    center = Alignment.INSTANCE.getCenter();
                } else {
                    center = alignment;
                }
                if (i6 != 0) {
                    fit = ContentScale.INSTANCE.getFit();
                } else {
                    fit = contentScale2;
                }
                if (i8 != 0) {
                    f4 = 1.0f;
                } else {
                    f4 = f2;
                }
                if (i10 != 0) {
                    colorFilter3 = null;
                } else {
                    colorFilter3 = colorFilter;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1142754848, i3, -1, "androidx.compose.foundation.Image (Image.kt:247)");
                }
                if (str != null) {
                    composerStartRestartGroup.startReplaceGroup(1899222916);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "250@11847L115");
                    Modifier.Companion companion16 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324207053, "CC(remember):Image.kt#9igjgp");
                    if ((i3 & 112) == 32) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    companionSemantics$default = SemanticsModifierKt.semantics$default(companion16, false, (Function1) objRememberedValue, 1, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1899381698);
                    composerStartRestartGroup.endReplaceGroup();
                    companionSemantics$default = Modifier.INSTANCE;
                }
                ColorFilter colorFilter18 = colorFilter3;
                Modifier modifier18 = companion;
                Alignment alignment17 = center;
                Modifier modifierPaint$default15 = PainterModifierKt.paint$default(ClipKt.clipToBounds(companion.then(companionSemantics$default)), painter, false, alignment17, fit, f4, colorFilter18, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324188104, "CC(remember):Image.kt#9igjgp");
                imageKt$Image$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (imageKt$Image$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    imageKt$Image$1$1RememberedValue = ImageKt$Image$1$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(imageKt$Image$1$1RememberedValue);
                }
                MeasurePolicy measurePolicy15 = (MeasurePolicy) imageKt$Image$1$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544976794, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
                int iHashCode15 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPaint$default15);
                CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl15 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl15, measurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl15, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6068reconcileimpl(composerM6062constructorimpl15, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl15, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                Updater.m6066initimpl(composerM6062constructorimpl15, Integer.valueOf(iHashCode15), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                colorFilter2 = colorFilter18;
                f3 = f4;
                contentScale3 = fit;
                alignment2 = alignment17;
                modifier3 = modifier18;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ImageKt.Image$lambda$2(painter, str, modifier3, alignment2, contentScale3, f3, colorFilter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        f2 = f;
        i10 = i2 & 64;
        if (i10 != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changed(colorFilter)) {
                i11 = 1048576;
            } else {
                i11 = 524288;
            }
            i3 |= i11;
        }
        if ((i3 & 599187) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            alignment2 = alignment;
            colorFilter2 = colorFilter;
            modifier3 = modifier2;
            contentScale3 = contentScale2;
            f3 = f2;
        } else {
            if (i12 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                center = Alignment.INSTANCE.getCenter();
            } else {
                center = alignment;
            }
            if (i6 != 0) {
                fit = ContentScale.INSTANCE.getFit();
            } else {
                fit = contentScale2;
            }
            if (i8 != 0) {
                f4 = 1.0f;
            } else {
                f4 = f2;
            }
            if (i10 != 0) {
                colorFilter3 = null;
            } else {
                colorFilter3 = colorFilter;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1142754848, i3, -1, "androidx.compose.foundation.Image (Image.kt:247)");
            }
            if (str != null) {
                composerStartRestartGroup.startReplaceGroup(1899222916);
                ComposerKt.sourceInformation(composerStartRestartGroup, "250@11847L115");
                Modifier.Companion companion17 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324207053, "CC(remember):Image.kt#9igjgp");
                if ((i3 & 112) == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                companionSemantics$default = SemanticsModifierKt.semantics$default(companion17, false, (Function1) objRememberedValue, 1, null);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1899381698);
                composerStartRestartGroup.endReplaceGroup();
                companionSemantics$default = Modifier.INSTANCE;
            }
            ColorFilter colorFilter19 = colorFilter3;
            Modifier modifier19 = companion;
            Alignment alignment18 = center;
            Modifier modifierPaint$default16 = PainterModifierKt.paint$default(ClipKt.clipToBounds(companion.then(companionSemantics$default)), painter, false, alignment18, fit, f4, colorFilter19, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324188104, "CC(remember):Image.kt#9igjgp");
            imageKt$Image$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (imageKt$Image$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                imageKt$Image$1$1RememberedValue = ImageKt$Image$1$1.INSTANCE;
                composerStartRestartGroup.updateRememberedValue(imageKt$Image$1$1RememberedValue);
            }
            MeasurePolicy measurePolicy16 = (MeasurePolicy) imageKt$Image$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544976794, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
            int iHashCode16 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPaint$default16);
            CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl16 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl16, measurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl16, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6068reconcileimpl(composerM6062constructorimpl16, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl16, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
            Updater.m6066initimpl(composerM6062constructorimpl16, Integer.valueOf(iHashCode16), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colorFilter2 = colorFilter19;
            f3 = f4;
            contentScale3 = fit;
            alignment2 = alignment18;
            modifier3 = modifier19;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImageKt.Image$lambda$2(painter, str, modifier3, alignment2, contentScale3, f3, colorFilter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Image$lambda$0$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.m8851setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8836getImageo7Vup1c());
        return Unit.INSTANCE;
    }
}
