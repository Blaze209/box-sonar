package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001an\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0085\u0001\u0010\u0013\u001a\u00020\u00012\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00102\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\"\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a\"\u0010\u0010\u001b\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a\"\u0010\u0010\u001c\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a\"\u0010\u0010\u001d\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006\u001e"}, d2 = {"FloatingActionButton", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material/FloatingActionButtonElevation;", "content", "Landroidx/compose/runtime/Composable;", "FloatingActionButton-bogVsAg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ExtendedFloatingActionButton", "text", HubsObservability.HUB_ASSET_ICON, "ExtendedFloatingActionButton-wqdebIU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Landroidx/compose/runtime/Composer;II)V", "FabSize", "Landroidx/compose/ui/unit/Dp;", "F", "ExtendedFabSize", "ExtendedFabIconPadding", "ExtendedFabTextPadding", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FloatingActionButtonKt {
    private static final float FabSize = Dp.m9687constructorimpl(56);
    private static final float ExtendedFabSize = Dp.m9687constructorimpl(48);
    private static final float ExtendedFabIconPadding = Dp.m9687constructorimpl(12);
    private static final float ExtendedFabTextPadding = Dp.m9687constructorimpl(20);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExtendedFloatingActionButton_wqdebIU$lambda$1(Function2 function2, Function0 function0, Modifier modifier, Function2 function3, MutableInteractionSource mutableInteractionSource, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, int i, int i2, Composer composer, int i3) {
        m2435ExtendedFloatingActionButtonwqdebIU(function2, function0, modifier, function3, mutableInteractionSource, shape, j, j2, floatingActionButtonElevation, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButton_bogVsAg$lambda$3(Function0 function0, Modifier modifier, MutableInteractionSource mutableInteractionSource, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, Function2 function2, int i, int i2, Composer composer, int i3) {
        m2436FloatingActionButtonbogVsAg(function0, modifier, mutableInteractionSource, shape, j, j2, floatingActionButtonElevation, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x013a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x013c  */
    /* JADX WARN: Code duplicated, block: B:110:0x0141  */
    /* JADX WARN: Code duplicated, block: B:112:0x0145  */
    /* JADX WARN: Code duplicated, block: B:115:0x014b  */
    /* JADX WARN: Code duplicated, block: B:116:0x0164  */
    /* JADX WARN: Code duplicated, block: B:119:0x0169  */
    /* JADX WARN: Code duplicated, block: B:120:0x0176  */
    /* JADX WARN: Code duplicated, block: B:123:0x017b  */
    /* JADX WARN: Code duplicated, block: B:126:0x0189  */
    /* JADX WARN: Code duplicated, block: B:127:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:130:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:133:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:135:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:137:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:140:0x021c  */
    /* JADX WARN: Code duplicated, block: B:143:0x027c  */
    /* JADX WARN: Code duplicated, block: B:145:0x028a  */
    /* JADX WARN: Code duplicated, block: B:148:0x029d  */
    /* JADX WARN: Code duplicated, block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:26:0x004b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:36:0x0064  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075  */
    /* JADX WARN: Code duplicated, block: B:45:0x007b  */
    /* JADX WARN: Code duplicated, block: B:47:0x007f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:53:0x0090  */
    /* JADX WARN: Code duplicated, block: B:56:0x0097  */
    /* JADX WARN: Code duplicated, block: B:58:0x009b  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:71:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:75:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:80:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:81:0x00da  */
    /* JADX WARN: Code duplicated, block: B:85:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:91:0x010b  */
    /* JADX INFO: renamed from: FloatingActionButton-bogVsAg, reason: not valid java name */
    public static final void m2436FloatingActionButtonbogVsAg(final Function0<Unit> function0, Modifier modifier, MutableInteractionSource mutableInteractionSource, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        MutableInteractionSource mutableInteractionSource2;
        int i5;
        Shape shape2;
        long j3;
        final long jM2360contentColorForek8zF_U;
        FloatingActionButtonElevation floatingActionButtonElevation2;
        boolean z;
        final Modifier modifier2;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource3;
        final Shape shape3;
        final long j4;
        final long j5;
        final FloatingActionButtonElevation floatingActionButtonElevation3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        CornerBasedShape cornerBasedShapeCopy;
        long jM2344getSecondary0d7_KjU;
        Composer composer3;
        long j6;
        FloatingActionButtonElevation floatingActionButtonElevationM2427elevationxZ9QkE;
        int i6;
        Shape shape4;
        boolean z2;
        MutableInteractionSource mutableInteractionSource4;
        Object objRememberedValue;
        Object objRememberedValue2;
        int i7;
        Composer composerStartRestartGroup = composer.startRestartGroup(-482679837);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FloatingActionButton)N(onClick,modifier,interactionSource,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,content)95@4354L22,99@4501L28,101@4590L420,93@4280L730:FloatingActionButton.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i9 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i3 |= i9;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        j3 = j;
                        int i10 = composerStartRestartGroup.changed(j3) ? 16384 : 8192;
                        i3 |= i10;
                    } else {
                        j3 = j;
                    }
                    i3 |= i10;
                } else {
                    j3 = j;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        jM2360contentColorForek8zF_U = j2;
                        int i11 = composerStartRestartGroup.changed(jM2360contentColorForek8zF_U) ? 131072 : 65536;
                        i3 |= i11;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    i3 |= i11;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                        int i12 = composerStartRestartGroup.changed(floatingActionButtonElevation2) ? 1048576 : 524288;
                        i3 |= i12;
                    } else {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                    }
                    i3 |= i12;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i7 = 8388608;
                    } else {
                        i7 = 4194304;
                    }
                    i3 |= i7;
                }
                if ((i3 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "85@3859L6,86@3947L6,87@3991L32,88@4101L11");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 8) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -7169;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                            i3 &= -57345;
                        } else {
                            jM2344getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            composer3 = composerStartRestartGroup;
                            i3 &= -3670017;
                            shape4 = cornerBasedShapeCopy;
                            j6 = jM2344getSecondary0d7_KjU;
                            z2 = false;
                        } else {
                            composer3 = composerStartRestartGroup;
                            j6 = jM2344getSecondary0d7_KjU;
                            floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                            i6 = -482679837;
                            shape4 = cornerBasedShapeCopy;
                            z2 = false;
                        }
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:90)");
                        }
                        if (mutableInteractionSource2 == null) {
                            composer3.startReplaceGroup(36032728);
                            ComposerKt.sourceInformation(composer3, "92@4236L39");
                            ComposerKt.sourceInformationMarkerStart(composer3, 1162346, "CC(remember):FloatingActionButton.kt#9igjgp");
                            objRememberedValue2 = composer3.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                composer3.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceGroup();
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                        } else {
                            composer3.startReplaceGroup(1161695);
                            composer3.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        ComposerKt.sourceInformationMarkerStart(composer3, 1166105, "CC(remember):FloatingActionButton.kt#9igjgp");
                        objRememberedValue = composer3.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$1$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        long j7 = jM2360contentColorForek8zF_U;
                        SurfaceKt.m2585SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(companion, z2, (Function1) objRememberedValue, 1, null), false, shape4, j6, j7, null, floatingActionButtonElevationM2427elevationxZ9QkE.elevation(mutableInteractionSource4, composer3, (i3 >> 15) & 112).getValue().m9701unboximpl(), mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1823447062, true, new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$2(jM2360contentColorForek8zF_U, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54), composer3, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (i3 & 458752), 68);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = companion;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM2427elevationxZ9QkE;
                        composer2 = composer3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape3 = shape4;
                        j4 = j6;
                        j5 = j7;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                        }
                        companion = modifier;
                        composer3 = composerStartRestartGroup;
                        j6 = j3;
                        floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                        z2 = false;
                        shape4 = shape2;
                    }
                    i6 = -482679837;
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:90)");
                    }
                    if (mutableInteractionSource2 == null) {
                        composer3.startReplaceGroup(36032728);
                        ComposerKt.sourceInformation(composer3, "92@4236L39");
                        ComposerKt.sourceInformationMarkerStart(composer3, 1162346, "CC(remember):FloatingActionButton.kt#9igjgp");
                        objRememberedValue2 = composer3.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                    } else {
                        composer3.startReplaceGroup(1161695);
                        composer3.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    ComposerKt.sourceInformationMarkerStart(composer3, 1166105, "CC(remember):FloatingActionButton.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$1$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    long j8 = jM2360contentColorForek8zF_U;
                    SurfaceKt.m2585SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(companion, z2, (Function1) objRememberedValue, 1, null), false, shape4, j6, j8, null, floatingActionButtonElevationM2427elevationxZ9QkE.elevation(mutableInteractionSource4, composer3, (i3 >> 15) & 112).getValue().m9701unboximpl(), mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1823447062, true, new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$2(jM2360contentColorForek8zF_U, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54), composer3, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (i3 & 458752), 68);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = companion;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM2427elevationxZ9QkE;
                    composer2 = composer3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = shape4;
                    j4 = j6;
                    j5 = j8;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    composer2 = composerStartRestartGroup;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = shape2;
                    j4 = j3;
                    j5 = jM2360contentColorForek8zF_U;
                    floatingActionButtonElevation3 = floatingActionButtonElevation2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$3(function0, modifier2, mutableInteractionSource3, shape3, j4, j5, floatingActionButtonElevation3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i10;
                } else {
                    j3 = j;
                }
                i3 |= i10;
            } else {
                j3 = j;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    jM2360contentColorForek8zF_U = j2;
                    if (composerStartRestartGroup.changed(jM2360contentColorForek8zF_U)) {
                    }
                    i3 |= i11;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                i3 |= i11;
            } else {
                jM2360contentColorForek8zF_U = j2;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                    if (composerStartRestartGroup.changed(floatingActionButtonElevation2)) {
                    }
                    i3 |= i12;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                i3 |= i12;
            } else {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "85@3859L6,86@3947L6,87@3991L32,88@4101L11");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 8) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -7169;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                        i3 &= -57345;
                    } else {
                        jM2344getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        composer3 = composerStartRestartGroup;
                        i3 &= -3670017;
                        shape4 = cornerBasedShapeCopy;
                        j6 = jM2344getSecondary0d7_KjU;
                        z2 = false;
                        i6 = -482679837;
                    } else {
                        composer3 = composerStartRestartGroup;
                        j6 = jM2344getSecondary0d7_KjU;
                        floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                        i6 = -482679837;
                        shape4 = cornerBasedShapeCopy;
                        z2 = false;
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 8) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -7169;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                        i3 &= -57345;
                    } else {
                        jM2344getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        composer3 = composerStartRestartGroup;
                        i3 &= -3670017;
                        shape4 = cornerBasedShapeCopy;
                        j6 = jM2344getSecondary0d7_KjU;
                        z2 = false;
                        i6 = -482679837;
                    } else {
                        composer3 = composerStartRestartGroup;
                        j6 = jM2344getSecondary0d7_KjU;
                        floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                        i6 = -482679837;
                        shape4 = cornerBasedShapeCopy;
                        z2 = false;
                    }
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:90)");
                }
                if (mutableInteractionSource2 == null) {
                    composer3.startReplaceGroup(36032728);
                    ComposerKt.sourceInformation(composer3, "92@4236L39");
                    ComposerKt.sourceInformationMarkerStart(composer3, 1162346, "CC(remember):FloatingActionButton.kt#9igjgp");
                    objRememberedValue2 = composer3.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                } else {
                    composer3.startReplaceGroup(1161695);
                    composer3.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                ComposerKt.sourceInformationMarkerStart(composer3, 1166105, "CC(remember):FloatingActionButton.kt#9igjgp");
                objRememberedValue = composer3.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$1$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                long j9 = jM2360contentColorForek8zF_U;
                SurfaceKt.m2585SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(companion, z2, (Function1) objRememberedValue, 1, null), false, shape4, j6, j9, null, floatingActionButtonElevationM2427elevationxZ9QkE.elevation(mutableInteractionSource4, composer3, (i3 >> 15) & 112).getValue().m9701unboximpl(), mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1823447062, true, new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$2(jM2360contentColorForek8zF_U, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), composer3, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (i3 & 458752), 68);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
                floatingActionButtonElevation3 = floatingActionButtonElevationM2427elevationxZ9QkE;
                composer2 = composer3;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape3 = shape4;
                j4 = j6;
                j5 = j9;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                composer2 = composerStartRestartGroup;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape3 = shape2;
                j4 = j3;
                j5 = jM2360contentColorForek8zF_U;
                floatingActionButtonElevation3 = floatingActionButtonElevation2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$3(function0, modifier2, mutableInteractionSource3, shape3, j4, j5, floatingActionButtonElevation3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i10;
                } else {
                    j3 = j;
                }
                i3 |= i10;
            } else {
                j3 = j;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    jM2360contentColorForek8zF_U = j2;
                    if (composerStartRestartGroup.changed(jM2360contentColorForek8zF_U)) {
                    }
                    i3 |= i11;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                i3 |= i11;
            } else {
                jM2360contentColorForek8zF_U = j2;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                    if (composerStartRestartGroup.changed(floatingActionButtonElevation2)) {
                    }
                    i3 |= i12;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                i3 |= i12;
            } else {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "85@3859L6,86@3947L6,87@3991L32,88@4101L11");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 8) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -7169;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                        i3 &= -57345;
                    } else {
                        jM2344getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        composer3 = composerStartRestartGroup;
                        i3 &= -3670017;
                        shape4 = cornerBasedShapeCopy;
                        j6 = jM2344getSecondary0d7_KjU;
                        z2 = false;
                        i6 = -482679837;
                    } else {
                        composer3 = composerStartRestartGroup;
                        j6 = jM2344getSecondary0d7_KjU;
                        floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                        i6 = -482679837;
                        shape4 = cornerBasedShapeCopy;
                        z2 = false;
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 8) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -7169;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                        i3 &= -57345;
                    } else {
                        jM2344getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        composer3 = composerStartRestartGroup;
                        i3 &= -3670017;
                        shape4 = cornerBasedShapeCopy;
                        j6 = jM2344getSecondary0d7_KjU;
                        z2 = false;
                        i6 = -482679837;
                    } else {
                        composer3 = composerStartRestartGroup;
                        j6 = jM2344getSecondary0d7_KjU;
                        floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                        i6 = -482679837;
                        shape4 = cornerBasedShapeCopy;
                        z2 = false;
                    }
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:90)");
                }
                if (mutableInteractionSource2 == null) {
                    composer3.startReplaceGroup(36032728);
                    ComposerKt.sourceInformation(composer3, "92@4236L39");
                    ComposerKt.sourceInformationMarkerStart(composer3, 1162346, "CC(remember):FloatingActionButton.kt#9igjgp");
                    objRememberedValue2 = composer3.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                } else {
                    composer3.startReplaceGroup(1161695);
                    composer3.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                ComposerKt.sourceInformationMarkerStart(composer3, 1166105, "CC(remember):FloatingActionButton.kt#9igjgp");
                objRememberedValue = composer3.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$1$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                long j10 = jM2360contentColorForek8zF_U;
                SurfaceKt.m2585SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(companion, z2, (Function1) objRememberedValue, 1, null), false, shape4, j6, j10, null, floatingActionButtonElevationM2427elevationxZ9QkE.elevation(mutableInteractionSource4, composer3, (i3 >> 15) & 112).getValue().m9701unboximpl(), mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1823447062, true, new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$2(jM2360contentColorForek8zF_U, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), composer3, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (i3 & 458752), 68);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
                floatingActionButtonElevation3 = floatingActionButtonElevationM2427elevationxZ9QkE;
                composer2 = composer3;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape3 = shape4;
                j4 = j6;
                j5 = j10;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                composer2 = composerStartRestartGroup;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape3 = shape2;
                j4 = j3;
                j5 = jM2360contentColorForek8zF_U;
                floatingActionButtonElevation3 = floatingActionButtonElevation2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$3(function0, modifier2, mutableInteractionSource3, shape3, j4, j5, floatingActionButtonElevation3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            i3 |= i9;
        } else {
            shape2 = shape;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                j3 = j;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i3 |= i10;
            } else {
                j3 = j;
            }
            i3 |= i10;
        } else {
            j3 = j;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                jM2360contentColorForek8zF_U = j2;
                if (composerStartRestartGroup.changed(jM2360contentColorForek8zF_U)) {
                }
                i3 |= i11;
            } else {
                jM2360contentColorForek8zF_U = j2;
            }
            i3 |= i11;
        } else {
            jM2360contentColorForek8zF_U = j2;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
                if (composerStartRestartGroup.changed(floatingActionButtonElevation2)) {
                }
                i3 |= i12;
            } else {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            i3 |= i12;
        } else {
            floatingActionButtonElevation2 = floatingActionButtonElevation;
        }
        if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i7 = 8388608;
            } else {
                i7 = 4194304;
            }
            i3 |= i7;
        }
        if ((i3 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "85@3859L6,86@3947L6,87@3991L32,88@4101L11");
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    mutableInteractionSource2 = null;
                }
                if ((i2 & 8) != 0) {
                    cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i3 &= -7169;
                } else {
                    cornerBasedShapeCopy = shape2;
                }
                if ((i2 & 16) != 0) {
                    jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                    i3 &= -57345;
                } else {
                    jM2344getSecondary0d7_KjU = j3;
                }
                if ((i2 & 32) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    composer3 = composerStartRestartGroup;
                    i3 &= -3670017;
                    shape4 = cornerBasedShapeCopy;
                    j6 = jM2344getSecondary0d7_KjU;
                    z2 = false;
                    i6 = -482679837;
                } else {
                    composer3 = composerStartRestartGroup;
                    j6 = jM2344getSecondary0d7_KjU;
                    floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                    i6 = -482679837;
                    shape4 = cornerBasedShapeCopy;
                    z2 = false;
                }
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    mutableInteractionSource2 = null;
                }
                if ((i2 & 8) != 0) {
                    cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i3 &= -7169;
                } else {
                    cornerBasedShapeCopy = shape2;
                }
                if ((i2 & 16) != 0) {
                    jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                    i3 &= -57345;
                } else {
                    jM2344getSecondary0d7_KjU = j3;
                }
                if ((i2 & 32) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    composer3 = composerStartRestartGroup;
                    i3 &= -3670017;
                    shape4 = cornerBasedShapeCopy;
                    j6 = jM2344getSecondary0d7_KjU;
                    z2 = false;
                    i6 = -482679837;
                } else {
                    composer3 = composerStartRestartGroup;
                    j6 = jM2344getSecondary0d7_KjU;
                    floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                    i6 = -482679837;
                    shape4 = cornerBasedShapeCopy;
                    z2 = false;
                }
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:90)");
            }
            if (mutableInteractionSource2 == null) {
                composer3.startReplaceGroup(36032728);
                ComposerKt.sourceInformation(composer3, "92@4236L39");
                ComposerKt.sourceInformationMarkerStart(composer3, 1162346, "CC(remember):FloatingActionButton.kt#9igjgp");
                objRememberedValue2 = composer3.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composer3.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endReplaceGroup();
                mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
            } else {
                composer3.startReplaceGroup(1161695);
                composer3.endReplaceGroup();
                mutableInteractionSource4 = mutableInteractionSource2;
            }
            ComposerKt.sourceInformationMarkerStart(composer3, 1166105, "CC(remember):FloatingActionButton.kt#9igjgp");
            objRememberedValue = composer3.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$1$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            long j11 = jM2360contentColorForek8zF_U;
            SurfaceKt.m2585SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(companion, z2, (Function1) objRememberedValue, 1, null), false, shape4, j6, j11, null, floatingActionButtonElevationM2427elevationxZ9QkE.elevation(mutableInteractionSource4, composer3, (i3 >> 15) & 112).getValue().m9701unboximpl(), mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1823447062, true, new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$2(jM2360contentColorForek8zF_U, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer3, 54), composer3, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (i3 & 458752), 68);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = companion;
            floatingActionButtonElevation3 = floatingActionButtonElevationM2427elevationxZ9QkE;
            composer2 = composer3;
            mutableInteractionSource3 = mutableInteractionSource2;
            shape3 = shape4;
            j4 = j6;
            j5 = j11;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            composer2 = composerStartRestartGroup;
            mutableInteractionSource3 = mutableInteractionSource2;
            shape3 = shape2;
            j4 = j3;
            j5 = jM2360contentColorForek8zF_U;
            floatingActionButtonElevation3 = floatingActionButtonElevation2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$3(function0, modifier2, mutableInteractionSource3, shape3, j4, j5, floatingActionButtonElevation3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButton_bogVsAg$lambda$1$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8851setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8832getButtono7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButton_bogVsAg$lambda$2(long j, final Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C102@4672L332,102@4600L404:FloatingActionButton.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1823447062, i, -1, "androidx.compose.material.FloatingActionButton.<anonymous> (FloatingActionButton.kt:102)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m6816getAlphaimpl(j))), ComposableLambdaKt.rememberComposableLambda(-1072292694, true, new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$2$0(function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButton_bogVsAg$lambda$2$0(final Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C103@4717L10,103@4736L258,103@4686L308:FloatingActionButton.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1072292694, i, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:103)");
            }
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer, 6).getButton(), ComposableLambdaKt.rememberComposableLambda(-1686273317, true, new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$2$0$0(function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButton_bogVsAg$lambda$2$0$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C104@4754L226:FloatingActionButton.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1686273317, i, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:104)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f = FabSize;
            Modifier modifierM1250defaultMinSizeVpY3zN4 = SizeKt.m1250defaultMinSizeVpY3zN4(companion, f, f);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1250defaultMinSizeVpY3zN4);
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
            ComposerKt.sourceInformationMarkerStart(composer, -344600103, "C108@4953L9:FloatingActionButton.kt#jmzs0o");
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

    /* JADX WARN: Code duplicated, block: B:100:0x0129  */
    /* JADX WARN: Code duplicated, block: B:117:0x015a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:118:0x015c  */
    /* JADX WARN: Code duplicated, block: B:121:0x0164  */
    /* JADX WARN: Code duplicated, block: B:123:0x0167  */
    /* JADX WARN: Code duplicated, block: B:126:0x016c  */
    /* JADX WARN: Code duplicated, block: B:129:0x0189  */
    /* JADX WARN: Code duplicated, block: B:130:0x0199  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:134:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:137:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:138:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:142:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:145:0x0251  */
    /* JADX WARN: Code duplicated, block: B:147:0x0263  */
    /* JADX WARN: Code duplicated, block: B:150:0x0279  */
    /* JADX WARN: Code duplicated, block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x0079  */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0093  */
    /* JADX WARN: Code duplicated, block: B:56:0x009b  */
    /* JADX WARN: Code duplicated, block: B:57:0x009e  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:70:0x00be  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:80:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:87:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:88:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:91:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:94:0x0105  */
    /* JADX WARN: Code duplicated, block: B:95:0x0107  */
    /* JADX WARN: Code duplicated, block: B:98:0x0110  */
    /* JADX INFO: renamed from: ExtendedFloatingActionButton-wqdebIU, reason: not valid java name */
    public static final void m2435ExtendedFloatingActionButtonwqdebIU(final Function2<? super Composer, ? super Integer, Unit> function2, final Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, MutableInteractionSource mutableInteractionSource, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final Function2<? super Composer, ? super Integer, Unit> function4;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        Shape shapeCopy;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        boolean z;
        final Modifier modifier3;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        final MutableInteractionSource mutableInteractionSource3;
        final Shape shape2;
        final long j3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        long jM2344getSecondary0d7_KjU;
        long jM2360contentColorForek8zF_U;
        Composer composer3;
        FloatingActionButtonElevation floatingActionButtonElevationM2427elevationxZ9QkE;
        long j5;
        long j6;
        int i9;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1506973027);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExtendedFloatingActionButton)N(text,onClick,modifier,icon,interactionSource,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation)168@7792L442,160@7463L771:FloatingActionButton.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i11 = i2 & 4;
        if (i11 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    function4 = function3;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((196608 & i) == 0) {
                        if ((i2 & 32) == 0) {
                            shapeCopy = shape;
                            int i12 = composerStartRestartGroup.changed(shapeCopy) ? 131072 : 65536;
                            i3 |= i12;
                        } else {
                            shapeCopy = shape;
                        }
                        i3 |= i12;
                    } else {
                        shapeCopy = shape;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(j)) {
                            i10 = 524288;
                        } else {
                            i10 = 1048576;
                        }
                        i3 |= i10;
                    }
                    if ((i & 12582912) != 0) {
                        if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) {
                            i9 = 4194304;
                        } else {
                            i9 = 8388608;
                        }
                        i3 |= i9;
                    }
                    if ((100663296 & i) == 0) {
                        if ((i2 & 256) == 0) {
                            floatingActionButtonElevation2 = floatingActionButtonElevation;
                            int i13 = composerStartRestartGroup.changed(floatingActionButtonElevation2) ? 67108864 : 33554432;
                            i3 |= i13;
                        } else {
                            floatingActionButtonElevation2 = floatingActionButtonElevation;
                        }
                        i3 |= i13;
                    } else {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                    }
                    if ((i3 & 38347923) != 38347922) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "155@7200L6,156@7288L6,157@7332L32,158@7442L11");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function4 = null;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource2 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            }
                            if ((i2 & 64) != 0) {
                                i8 = i3 & (-3670017);
                                jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                            } else {
                                i8 = i3;
                                jM2344getSecondary0d7_KjU = j;
                            }
                            if ((i2 & 128) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                                i8 &= -29360129;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if ((i2 & 256) != 0) {
                                composer3 = composerStartRestartGroup;
                                i8 &= -234881025;
                                floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            } else {
                                composer3 = composerStartRestartGroup;
                                floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                            }
                            j5 = jM2360contentColorForek8zF_U;
                            j6 = jM2344getSecondary0d7_KjU;
                            i3 = i8;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i3 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                            }
                            j6 = j;
                            j5 = j2;
                            composer3 = composerStartRestartGroup;
                            mutableInteractionSource2 = mutableInteractionSource2;
                            floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                        }
                        Shape shape3 = shapeCopy;
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1506973027, i3, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:159)");
                        }
                        float f = ExtendedFabSize;
                        int i14 = i3 >> 6;
                        m2436FloatingActionButtonbogVsAg(function0, SizeKt.m1270sizeInqDBjuR0$default(modifier2, f, f, 0.0f, 0.0f, 12, null), mutableInteractionSource2, shape3, j6, j5, floatingActionButtonElevationM2427elevationxZ9QkE, ComposableLambdaKt.rememberComposableLambda(-555697957, true, new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FloatingActionButtonKt.ExtendedFloatingActionButton_wqdebIU$lambda$0(function4, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54), composer3, 12582912 | ((i3 >> 3) & 14) | (i14 & 896) | (i14 & 7168) | (57344 & i14) | (458752 & i14) | (i14 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        composer2 = composer3;
                        function5 = function4;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = shape3;
                        j3 = j6;
                        j4 = j5;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM2427elevationxZ9QkE;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        composer2 = composerStartRestartGroup;
                        function5 = function4;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = shapeCopy;
                        j3 = j;
                        j4 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FloatingActionButtonKt.ExtendedFloatingActionButton_wqdebIU$lambda$1(function2, function0, modifier3, function5, mutableInteractionSource3, shape2, j3, j4, floatingActionButtonElevation2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        shapeCopy = shape;
                        if (composerStartRestartGroup.changed(shapeCopy)) {
                        }
                        i3 |= i12;
                    } else {
                        shapeCopy = shape;
                    }
                    i3 |= i12;
                } else {
                    shapeCopy = shape;
                }
                if ((1572864 & i) != 0) {
                    if ((i2 & 64) == 0) {
                        i10 = 524288;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((i & 12582912) != 0) {
                    if ((i2 & 128) == 0) {
                        i9 = 4194304;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((100663296 & i) == 0) {
                    if ((i2 & 256) == 0) {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                        if (composerStartRestartGroup.changed(floatingActionButtonElevation2)) {
                        }
                        i3 |= i13;
                    } else {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                    }
                    i3 |= i13;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                if ((i3 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "155@7200L6,156@7288L6,157@7332L32,158@7442L11");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        }
                        if ((i2 & 64) != 0) {
                            i8 = i3 & (-3670017);
                            jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                        } else {
                            i8 = i3;
                            jM2344getSecondary0d7_KjU = j;
                        }
                        if ((i2 & 128) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            composer3 = composerStartRestartGroup;
                            i8 &= -234881025;
                            floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        } else {
                            composer3 = composerStartRestartGroup;
                            floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                        }
                        j5 = jM2360contentColorForek8zF_U;
                        j6 = jM2344getSecondary0d7_KjU;
                        i3 = i8;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        }
                        if ((i2 & 64) != 0) {
                            i8 = i3 & (-3670017);
                            jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                        } else {
                            i8 = i3;
                            jM2344getSecondary0d7_KjU = j;
                        }
                        if ((i2 & 128) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            composer3 = composerStartRestartGroup;
                            i8 &= -234881025;
                            floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        } else {
                            composer3 = composerStartRestartGroup;
                            floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                        }
                        j5 = jM2360contentColorForek8zF_U;
                        j6 = jM2344getSecondary0d7_KjU;
                        i3 = i8;
                    }
                    Shape shape4 = shapeCopy;
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1506973027, i3, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:159)");
                    }
                    float f2 = ExtendedFabSize;
                    int i15 = i3 >> 6;
                    m2436FloatingActionButtonbogVsAg(function0, SizeKt.m1270sizeInqDBjuR0$default(modifier2, f2, f2, 0.0f, 0.0f, 12, null), mutableInteractionSource2, shape4, j6, j5, floatingActionButtonElevationM2427elevationxZ9QkE, ComposableLambdaKt.rememberComposableLambda(-555697957, true, new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.ExtendedFloatingActionButton_wqdebIU$lambda$0(function4, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54), composer3, 12582912 | ((i3 >> 3) & 14) | (i15 & 896) | (i15 & 7168) | (57344 & i15) | (458752 & i15) | (i15 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    composer2 = composer3;
                    function5 = function4;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape2 = shape4;
                    j3 = j6;
                    j4 = j5;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM2427elevationxZ9QkE;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    composer2 = composerStartRestartGroup;
                    function5 = function4;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape2 = shapeCopy;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.ExtendedFloatingActionButton_wqdebIU$lambda$1(function2, function0, modifier3, function5, mutableInteractionSource3, shape2, j3, j4, floatingActionButtonElevation2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            function4 = function3;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        shapeCopy = shape;
                        if (composerStartRestartGroup.changed(shapeCopy)) {
                        }
                        i3 |= i12;
                    } else {
                        shapeCopy = shape;
                    }
                    i3 |= i12;
                } else {
                    shapeCopy = shape;
                }
                if ((1572864 & i) != 0) {
                    if ((i2 & 64) == 0) {
                        i10 = 524288;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((i & 12582912) != 0) {
                    if ((i2 & 128) == 0) {
                        i9 = 4194304;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((100663296 & i) == 0) {
                    if ((i2 & 256) == 0) {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                        if (composerStartRestartGroup.changed(floatingActionButtonElevation2)) {
                        }
                        i3 |= i13;
                    } else {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                    }
                    i3 |= i13;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                if ((i3 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "155@7200L6,156@7288L6,157@7332L32,158@7442L11");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        }
                        if ((i2 & 64) != 0) {
                            i8 = i3 & (-3670017);
                            jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                        } else {
                            i8 = i3;
                            jM2344getSecondary0d7_KjU = j;
                        }
                        if ((i2 & 128) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            composer3 = composerStartRestartGroup;
                            i8 &= -234881025;
                            floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        } else {
                            composer3 = composerStartRestartGroup;
                            floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                        }
                        j5 = jM2360contentColorForek8zF_U;
                        j6 = jM2344getSecondary0d7_KjU;
                        i3 = i8;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        }
                        if ((i2 & 64) != 0) {
                            i8 = i3 & (-3670017);
                            jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                        } else {
                            i8 = i3;
                            jM2344getSecondary0d7_KjU = j;
                        }
                        if ((i2 & 128) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            composer3 = composerStartRestartGroup;
                            i8 &= -234881025;
                            floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        } else {
                            composer3 = composerStartRestartGroup;
                            floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                        }
                        j5 = jM2360contentColorForek8zF_U;
                        j6 = jM2344getSecondary0d7_KjU;
                        i3 = i8;
                    }
                    Shape shape5 = shapeCopy;
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1506973027, i3, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:159)");
                    }
                    float f3 = ExtendedFabSize;
                    int i16 = i3 >> 6;
                    m2436FloatingActionButtonbogVsAg(function0, SizeKt.m1270sizeInqDBjuR0$default(modifier2, f3, f3, 0.0f, 0.0f, 12, null), mutableInteractionSource2, shape5, j6, j5, floatingActionButtonElevationM2427elevationxZ9QkE, ComposableLambdaKt.rememberComposableLambda(-555697957, true, new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.ExtendedFloatingActionButton_wqdebIU$lambda$0(function4, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54), composer3, 12582912 | ((i3 >> 3) & 14) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (i16 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    composer2 = composer3;
                    function5 = function4;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape2 = shape5;
                    j3 = j6;
                    j4 = j5;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM2427elevationxZ9QkE;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    composer2 = composerStartRestartGroup;
                    function5 = function4;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape2 = shapeCopy;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.ExtendedFloatingActionButton_wqdebIU$lambda$1(function2, function0, modifier3, function5, mutableInteractionSource3, shape2, j3, j4, floatingActionButtonElevation2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    shapeCopy = shape;
                    if (composerStartRestartGroup.changed(shapeCopy)) {
                    }
                    i3 |= i12;
                } else {
                    shapeCopy = shape;
                }
                i3 |= i12;
            } else {
                shapeCopy = shape;
            }
            if ((1572864 & i) != 0) {
                if ((i2 & 64) == 0) {
                    i10 = 524288;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((i & 12582912) != 0) {
                if ((i2 & 128) == 0) {
                    i9 = 4194304;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((100663296 & i) == 0) {
                if ((i2 & 256) == 0) {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                    if (composerStartRestartGroup.changed(floatingActionButtonElevation2)) {
                    }
                    i3 |= i13;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                i3 |= i13;
            } else {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            if ((i3 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "155@7200L6,156@7288L6,157@7332L32,158@7442L11");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    }
                    if ((i2 & 64) != 0) {
                        i8 = i3 & (-3670017);
                        jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                    } else {
                        i8 = i3;
                        jM2344getSecondary0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        composer3 = composerStartRestartGroup;
                        i8 &= -234881025;
                        floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    } else {
                        composer3 = composerStartRestartGroup;
                        floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                    }
                    j5 = jM2360contentColorForek8zF_U;
                    j6 = jM2344getSecondary0d7_KjU;
                    i3 = i8;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    }
                    if ((i2 & 64) != 0) {
                        i8 = i3 & (-3670017);
                        jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                    } else {
                        i8 = i3;
                        jM2344getSecondary0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        composer3 = composerStartRestartGroup;
                        i8 &= -234881025;
                        floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    } else {
                        composer3 = composerStartRestartGroup;
                        floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                    }
                    j5 = jM2360contentColorForek8zF_U;
                    j6 = jM2344getSecondary0d7_KjU;
                    i3 = i8;
                }
                Shape shape6 = shapeCopy;
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1506973027, i3, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:159)");
                }
                float f4 = ExtendedFabSize;
                int i17 = i3 >> 6;
                m2436FloatingActionButtonbogVsAg(function0, SizeKt.m1270sizeInqDBjuR0$default(modifier2, f4, f4, 0.0f, 0.0f, 12, null), mutableInteractionSource2, shape6, j6, j5, floatingActionButtonElevationM2427elevationxZ9QkE, ComposableLambdaKt.rememberComposableLambda(-555697957, true, new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.ExtendedFloatingActionButton_wqdebIU$lambda$0(function4, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), composer3, 12582912 | ((i3 >> 3) & 14) | (i17 & 896) | (i17 & 7168) | (57344 & i17) | (458752 & i17) | (i17 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                composer2 = composer3;
                function5 = function4;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape2 = shape6;
                j3 = j6;
                j4 = j5;
                floatingActionButtonElevation2 = floatingActionButtonElevationM2427elevationxZ9QkE;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
                function5 = function4;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape2 = shapeCopy;
                j3 = j;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.ExtendedFloatingActionButton_wqdebIU$lambda$1(function2, function0, modifier3, function5, mutableInteractionSource3, shape2, j3, j4, floatingActionButtonElevation2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                function4 = function3;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        shapeCopy = shape;
                        if (composerStartRestartGroup.changed(shapeCopy)) {
                        }
                        i3 |= i12;
                    } else {
                        shapeCopy = shape;
                    }
                    i3 |= i12;
                } else {
                    shapeCopy = shape;
                }
                if ((1572864 & i) != 0) {
                    if ((i2 & 64) == 0) {
                        i10 = 524288;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((i & 12582912) != 0) {
                    if ((i2 & 128) == 0) {
                        i9 = 4194304;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((100663296 & i) == 0) {
                    if ((i2 & 256) == 0) {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                        if (composerStartRestartGroup.changed(floatingActionButtonElevation2)) {
                        }
                        i3 |= i13;
                    } else {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                    }
                    i3 |= i13;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                if ((i3 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "155@7200L6,156@7288L6,157@7332L32,158@7442L11");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        }
                        if ((i2 & 64) != 0) {
                            i8 = i3 & (-3670017);
                            jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                        } else {
                            i8 = i3;
                            jM2344getSecondary0d7_KjU = j;
                        }
                        if ((i2 & 128) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            composer3 = composerStartRestartGroup;
                            i8 &= -234881025;
                            floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        } else {
                            composer3 = composerStartRestartGroup;
                            floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                        }
                        j5 = jM2360contentColorForek8zF_U;
                        j6 = jM2344getSecondary0d7_KjU;
                        i3 = i8;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        }
                        if ((i2 & 64) != 0) {
                            i8 = i3 & (-3670017);
                            jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                        } else {
                            i8 = i3;
                            jM2344getSecondary0d7_KjU = j;
                        }
                        if ((i2 & 128) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            composer3 = composerStartRestartGroup;
                            i8 &= -234881025;
                            floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        } else {
                            composer3 = composerStartRestartGroup;
                            floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                        }
                        j5 = jM2360contentColorForek8zF_U;
                        j6 = jM2344getSecondary0d7_KjU;
                        i3 = i8;
                    }
                    Shape shape7 = shapeCopy;
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1506973027, i3, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:159)");
                    }
                    float f5 = ExtendedFabSize;
                    int i18 = i3 >> 6;
                    m2436FloatingActionButtonbogVsAg(function0, SizeKt.m1270sizeInqDBjuR0$default(modifier2, f5, f5, 0.0f, 0.0f, 12, null), mutableInteractionSource2, shape7, j6, j5, floatingActionButtonElevationM2427elevationxZ9QkE, ComposableLambdaKt.rememberComposableLambda(-555697957, true, new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.ExtendedFloatingActionButton_wqdebIU$lambda$0(function4, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54), composer3, 12582912 | ((i3 >> 3) & 14) | (i18 & 896) | (i18 & 7168) | (57344 & i18) | (458752 & i18) | (i18 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    composer2 = composer3;
                    function5 = function4;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape2 = shape7;
                    j3 = j6;
                    j4 = j5;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM2427elevationxZ9QkE;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    composer2 = composerStartRestartGroup;
                    function5 = function4;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape2 = shapeCopy;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.ExtendedFloatingActionButton_wqdebIU$lambda$1(function2, function0, modifier3, function5, mutableInteractionSource3, shape2, j3, j4, floatingActionButtonElevation2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    shapeCopy = shape;
                    if (composerStartRestartGroup.changed(shapeCopy)) {
                    }
                    i3 |= i12;
                } else {
                    shapeCopy = shape;
                }
                i3 |= i12;
            } else {
                shapeCopy = shape;
            }
            if ((1572864 & i) != 0) {
                if ((i2 & 64) == 0) {
                    i10 = 524288;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((i & 12582912) != 0) {
                if ((i2 & 128) == 0) {
                    i9 = 4194304;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((100663296 & i) == 0) {
                if ((i2 & 256) == 0) {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                    if (composerStartRestartGroup.changed(floatingActionButtonElevation2)) {
                    }
                    i3 |= i13;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                i3 |= i13;
            } else {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            if ((i3 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "155@7200L6,156@7288L6,157@7332L32,158@7442L11");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    }
                    if ((i2 & 64) != 0) {
                        i8 = i3 & (-3670017);
                        jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                    } else {
                        i8 = i3;
                        jM2344getSecondary0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        composer3 = composerStartRestartGroup;
                        i8 &= -234881025;
                        floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    } else {
                        composer3 = composerStartRestartGroup;
                        floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                    }
                    j5 = jM2360contentColorForek8zF_U;
                    j6 = jM2344getSecondary0d7_KjU;
                    i3 = i8;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    }
                    if ((i2 & 64) != 0) {
                        i8 = i3 & (-3670017);
                        jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                    } else {
                        i8 = i3;
                        jM2344getSecondary0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        composer3 = composerStartRestartGroup;
                        i8 &= -234881025;
                        floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    } else {
                        composer3 = composerStartRestartGroup;
                        floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                    }
                    j5 = jM2360contentColorForek8zF_U;
                    j6 = jM2344getSecondary0d7_KjU;
                    i3 = i8;
                }
                Shape shape8 = shapeCopy;
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1506973027, i3, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:159)");
                }
                float f6 = ExtendedFabSize;
                int i19 = i3 >> 6;
                m2436FloatingActionButtonbogVsAg(function0, SizeKt.m1270sizeInqDBjuR0$default(modifier2, f6, f6, 0.0f, 0.0f, 12, null), mutableInteractionSource2, shape8, j6, j5, floatingActionButtonElevationM2427elevationxZ9QkE, ComposableLambdaKt.rememberComposableLambda(-555697957, true, new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.ExtendedFloatingActionButton_wqdebIU$lambda$0(function4, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), composer3, 12582912 | ((i3 >> 3) & 14) | (i19 & 896) | (i19 & 7168) | (57344 & i19) | (458752 & i19) | (i19 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                composer2 = composer3;
                function5 = function4;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape2 = shape8;
                j3 = j6;
                j4 = j5;
                floatingActionButtonElevation2 = floatingActionButtonElevationM2427elevationxZ9QkE;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
                function5 = function4;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape2 = shapeCopy;
                j3 = j;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.ExtendedFloatingActionButton_wqdebIU$lambda$1(function2, function0, modifier3, function5, mutableInteractionSource3, shape2, j3, j4, floatingActionButtonElevation2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        function4 = function3;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    shapeCopy = shape;
                    if (composerStartRestartGroup.changed(shapeCopy)) {
                    }
                    i3 |= i12;
                } else {
                    shapeCopy = shape;
                }
                i3 |= i12;
            } else {
                shapeCopy = shape;
            }
            if ((1572864 & i) != 0) {
                if ((i2 & 64) == 0) {
                    i10 = 524288;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((i & 12582912) != 0) {
                if ((i2 & 128) == 0) {
                    i9 = 4194304;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((100663296 & i) == 0) {
                if ((i2 & 256) == 0) {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                    if (composerStartRestartGroup.changed(floatingActionButtonElevation2)) {
                    }
                    i3 |= i13;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                i3 |= i13;
            } else {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            if ((i3 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "155@7200L6,156@7288L6,157@7332L32,158@7442L11");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    }
                    if ((i2 & 64) != 0) {
                        i8 = i3 & (-3670017);
                        jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                    } else {
                        i8 = i3;
                        jM2344getSecondary0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        composer3 = composerStartRestartGroup;
                        i8 &= -234881025;
                        floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    } else {
                        composer3 = composerStartRestartGroup;
                        floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                    }
                    j5 = jM2360contentColorForek8zF_U;
                    j6 = jM2344getSecondary0d7_KjU;
                    i3 = i8;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    }
                    if ((i2 & 64) != 0) {
                        i8 = i3 & (-3670017);
                        jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                    } else {
                        i8 = i3;
                        jM2344getSecondary0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        composer3 = composerStartRestartGroup;
                        i8 &= -234881025;
                        floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    } else {
                        composer3 = composerStartRestartGroup;
                        floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                    }
                    j5 = jM2360contentColorForek8zF_U;
                    j6 = jM2344getSecondary0d7_KjU;
                    i3 = i8;
                }
                Shape shape9 = shapeCopy;
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1506973027, i3, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:159)");
                }
                float f7 = ExtendedFabSize;
                int i110 = i3 >> 6;
                m2436FloatingActionButtonbogVsAg(function0, SizeKt.m1270sizeInqDBjuR0$default(modifier2, f7, f7, 0.0f, 0.0f, 12, null), mutableInteractionSource2, shape9, j6, j5, floatingActionButtonElevationM2427elevationxZ9QkE, ComposableLambdaKt.rememberComposableLambda(-555697957, true, new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.ExtendedFloatingActionButton_wqdebIU$lambda$0(function4, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), composer3, 12582912 | ((i3 >> 3) & 14) | (i110 & 896) | (i110 & 7168) | (57344 & i110) | (458752 & i110) | (i110 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                composer2 = composer3;
                function5 = function4;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape2 = shape9;
                j3 = j6;
                j4 = j5;
                floatingActionButtonElevation2 = floatingActionButtonElevationM2427elevationxZ9QkE;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
                function5 = function4;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape2 = shapeCopy;
                j3 = j;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.ExtendedFloatingActionButton_wqdebIU$lambda$1(function2, function0, modifier3, function5, mutableInteractionSource3, shape2, j3, j4, floatingActionButtonElevation2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                shapeCopy = shape;
                if (composerStartRestartGroup.changed(shapeCopy)) {
                }
                i3 |= i12;
            } else {
                shapeCopy = shape;
            }
            i3 |= i12;
        } else {
            shapeCopy = shape;
        }
        if ((1572864 & i) != 0) {
            if ((i2 & 64) == 0) {
                i10 = 524288;
            } else {
                i10 = 524288;
            }
            i3 |= i10;
        }
        if ((i & 12582912) != 0) {
            if ((i2 & 128) == 0) {
                i9 = 4194304;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        if ((100663296 & i) == 0) {
            if ((i2 & 256) == 0) {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
                if (composerStartRestartGroup.changed(floatingActionButtonElevation2)) {
                }
                i3 |= i13;
            } else {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            i3 |= i13;
        } else {
            floatingActionButtonElevation2 = floatingActionButtonElevation;
        }
        if ((i3 & 38347923) != 38347922) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "155@7200L6,156@7288L6,157@7332L32,158@7442L11");
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    function4 = null;
                }
                if (i6 != 0) {
                    mutableInteractionSource2 = null;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                }
                if ((i2 & 64) != 0) {
                    i8 = i3 & (-3670017);
                    jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                } else {
                    i8 = i3;
                    jM2344getSecondary0d7_KjU = j;
                }
                if ((i2 & 128) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                    i8 &= -29360129;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    composer3 = composerStartRestartGroup;
                    i8 &= -234881025;
                    floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                } else {
                    composer3 = composerStartRestartGroup;
                    floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                }
                j5 = jM2360contentColorForek8zF_U;
                j6 = jM2344getSecondary0d7_KjU;
                i3 = i8;
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    function4 = null;
                }
                if (i6 != 0) {
                    mutableInteractionSource2 = null;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                }
                if ((i2 & 64) != 0) {
                    i8 = i3 & (-3670017);
                    jM2344getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2344getSecondary0d7_KjU();
                } else {
                    i8 = i3;
                    jM2344getSecondary0d7_KjU = j;
                }
                if ((i2 & 128) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2344getSecondary0d7_KjU, composerStartRestartGroup, (i8 >> 18) & 14);
                    i8 &= -29360129;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    composer3 = composerStartRestartGroup;
                    i8 &= -234881025;
                    floatingActionButtonElevationM2427elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m2427elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                } else {
                    composer3 = composerStartRestartGroup;
                    floatingActionButtonElevationM2427elevationxZ9QkE = floatingActionButtonElevation2;
                }
                j5 = jM2360contentColorForek8zF_U;
                j6 = jM2344getSecondary0d7_KjU;
                i3 = i8;
            }
            Shape shape10 = shapeCopy;
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1506973027, i3, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:159)");
            }
            float f8 = ExtendedFabSize;
            int i111 = i3 >> 6;
            m2436FloatingActionButtonbogVsAg(function0, SizeKt.m1270sizeInqDBjuR0$default(modifier2, f8, f8, 0.0f, 0.0f, 12, null), mutableInteractionSource2, shape10, j6, j5, floatingActionButtonElevationM2427elevationxZ9QkE, ComposableLambdaKt.rememberComposableLambda(-555697957, true, new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.ExtendedFloatingActionButton_wqdebIU$lambda$0(function4, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer3, 54), composer3, 12582912 | ((i3 >> 3) & 14) | (i111 & 896) | (i111 & 7168) | (57344 & i111) | (458752 & i111) | (i111 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            composer2 = composer3;
            function5 = function4;
            mutableInteractionSource3 = mutableInteractionSource2;
            shape2 = shape10;
            j3 = j6;
            j4 = j5;
            floatingActionButtonElevation2 = floatingActionButtonElevationM2427elevationxZ9QkE;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            composer2 = composerStartRestartGroup;
            function5 = function4;
            mutableInteractionSource3 = mutableInteractionSource2;
            shape2 = shapeCopy;
            j3 = j;
            j4 = j2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.ExtendedFloatingActionButton_wqdebIU$lambda$1(function2, function0, modifier3, function5, mutableInteractionSource3, shape2, j3, j4, floatingActionButtonElevation2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExtendedFloatingActionButton_wqdebIU$lambda$0(Function2 function2, Function2 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C170@7898L330:FloatingActionButton.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-555697957, i, -1, "androidx.compose.material.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:169)");
            }
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, function2 == null ? ExtendedFabTextPadding : ExtendedFabIconPadding, 0.0f, ExtendedFabTextPadding, 0.0f, 10, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1222paddingqDBjuR0$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 185594530, "C178@8212L6:FloatingActionButton.kt#jmzs0o");
            if (function2 != null) {
                composer.startReplaceGroup(185611238);
                ComposerKt.sourceInformation(composer, "175@8116L6,176@8139L46");
                function2.invoke(composer, 0);
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, ExtendedFabIconPadding), composer, 6);
            } else {
                composer.startReplaceGroup(177573899);
            }
            composer.endReplaceGroup();
            function3.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
