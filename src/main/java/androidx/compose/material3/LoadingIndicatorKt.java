package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.internal.ShapeUtilKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.graphics.shapes.Morph;
import androidx.graphics.shapes.RoundedPolygon;
import androidx.media3.extractor.WavUtil;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LoadingIndicator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u001aA\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b\f\u0010\r\u001a3\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001aU\u0010\u0010\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001aG\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001aK\u0010\u0019\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0003¢\u0006\u0004\b\u001b\u0010\u001c\u001a=\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0003¢\u0006\u0004\b\u001d\u0010\u001e\u001a$\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010!\u001a\u00020\"H\u0002\u001a\u0016\u0010#\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002\u001a\f\u0010$\u001a\u00020\u0004*\u00020%H\u0002\u001a\f\u0010&\u001a\u00020\u0004*\u00020%H\u0002\u001a1\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00042\b\b\u0002\u0010-\u001a\u00020.H\u0002¢\u0006\u0004\b/\u00100\"\u000e\u00101\u001a\u000202X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00103\u001a\u000204X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00105\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00106\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u00067²\u0006\n\u00108\u001a\u00020\u0004X\u008a\u008e\u0002²\u0006\n\u00109\u001a\u000202X\u008a\u008e\u0002"}, d2 = {"LoadingIndicator", "", "progress", "Lkotlin/Function0;", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "polygons", "", "Landroidx/graphics/shapes/RoundedPolygon;", "LoadingIndicator-cf5BqRc", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLjava/util/List;Landroidx/compose/runtime/Composer;II)V", "LoadingIndicator-3IgeMak", "(Landroidx/compose/ui/Modifier;JLjava/util/List;Landroidx/compose/runtime/Composer;II)V", "ContainedLoadingIndicator", "containerColor", "indicatorColor", "containerShape", "Landroidx/compose/ui/graphics/Shape;", "ContainedLoadingIndicator-Y0xEhic", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;Ljava/util/List;Landroidx/compose/runtime/Composer;II)V", "ContainedLoadingIndicator-DTcfvLk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;Ljava/util/List;Landroidx/compose/runtime/Composer;II)V", "LoadingIndicatorImpl", "indicatorPolygons", "LoadingIndicatorImpl-t6yy7ic", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "LoadingIndicatorImpl-eopBjH0", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "morphSequence", "Landroidx/graphics/shapes/Morph;", "circularSequence", "", "calculateScaleFactor", "width", "", "height", "processPath", "Landroidx/compose/ui/graphics/Path;", "path", "size", "Landroidx/compose/ui/geometry/Size;", "scaleFactor", "scaleMatrix", "Landroidx/compose/ui/graphics/Matrix;", "processPath-3rZdNqA", "(Landroidx/compose/ui/graphics/Path;JF[F)Landroidx/compose/ui/graphics/Path;", "GlobalRotationDurationMillis", "", "MorphIntervalMillis", "", "FullRotation", "QuarterRotation", "material3", "morphRotationTargetAngle", "currentMorphIndex"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LoadingIndicatorKt {
    private static final float FullRotation = 360.0f;
    private static final int GlobalRotationDurationMillis = 4666;
    private static final long MorphIntervalMillis = 650;
    private static final float QuarterRotation = 90.0f;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContainedLoadingIndicator_DTcfvLk$lambda$0(Modifier modifier, long j, long j2, Shape shape, List list, int i, int i2, Composer composer, int i3) {
        m3728ContainedLoadingIndicatorDTcfvLk(modifier, j, j2, shape, list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContainedLoadingIndicator_Y0xEhic$lambda$0(Function0 function0, Modifier modifier, long j, long j2, Shape shape, List list, int i, int i2, Composer composer, int i3) {
        m3729ContainedLoadingIndicatorY0xEhic(function0, modifier, j, j2, shape, list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingIndicatorImpl_eopBjH0$lambda$15(Modifier modifier, long j, long j2, Shape shape, List list, int i, Composer composer, int i2) {
        m3732LoadingIndicatorImpleopBjH0(modifier, j, j2, shape, list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingIndicatorImpl_t6yy7ic$lambda$8(Function0 function0, Modifier modifier, long j, long j2, Shape shape, List list, int i, Composer composer, int i2) {
        m3733LoadingIndicatorImplt6yy7ic(function0, modifier, j, j2, shape, list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingIndicator_3IgeMak$lambda$0(Modifier modifier, long j, List list, int i, int i2, Composer composer, int i3) {
        m3730LoadingIndicator3IgeMak(modifier, j, list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingIndicator_cf5BqRc$lambda$0(Function0 function0, Modifier modifier, long j, List list, int i, int i2, Composer composer, int i3) {
        m3731LoadingIndicatorcf5BqRc(function0, modifier, j, list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:30:0x0057  */
    /* JADX WARN: Code duplicated, block: B:33:0x005d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0061  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:44:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x007d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:76:0x0111  */
    /* JADX WARN: Code duplicated, block: B:78:0x0118  */
    /* JADX WARN: Code duplicated, block: B:81:0x0123  */
    /* JADX WARN: Code duplicated, block: B:83:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: LoadingIndicator-cf5BqRc, reason: not valid java name */
    public static final void m3731LoadingIndicatorcf5BqRc(final Function0<Float> function0, Modifier modifier, long j, List<RoundedPolygon> list, Composer composer, final int i, final int i2) {
        Function0<Float> function1;
        int i3;
        Modifier modifier2;
        long indicatorColor;
        final List<RoundedPolygon> list2;
        boolean z;
        final Modifier modifier3;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i4;
        List<RoundedPolygon> determinateIndicatorPolygons;
        Modifier modifier4;
        long j3;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1086049965);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadingIndicator)N(progress,modifier,color:c#ui.graphics.Color,polygons)106@4647L14,101@4441L265:LoadingIndicator.kt#uh7d8r");
        if ((i & 6) == 0) {
            function1 = function0;
            i3 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            function1 = function0;
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                indicatorColor = j;
                if ((i2 & 4) == 0 || !composerStartRestartGroup.changed(indicatorColor)) {
                    i5 = 128;
                } else {
                    i5 = 256;
                }
                i3 |= i5;
            } else {
                indicatorColor = j;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    list2 = list;
                    int i7 = composerStartRestartGroup.changedInstance(list2) ? 2048 : 1024;
                    i3 |= i7;
                } else {
                    list2 = list;
                }
                i3 |= i7;
            } else {
                list2 = list;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "98@4325L14");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        indicatorColor = LoadingIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        determinateIndicatorPolygons = LoadingIndicatorDefaults.INSTANCE.getDeterminateIndicatorPolygons();
                        i4 = i3 & (-7169);
                    } else {
                        i4 = i3;
                        determinateIndicatorPolygons = list2;
                    }
                    modifier4 = companion;
                    j3 = indicatorColor;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    Modifier modifier5 = modifier2;
                    i4 = i3;
                    j3 = indicatorColor;
                    modifier4 = modifier5;
                    determinateIndicatorPolygons = list2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1086049965, i4, -1, "androidx.compose.material3.LoadingIndicator (LoadingIndicator.kt:101)");
                }
                long j4 = j3;
                m3733LoadingIndicatorImplt6yy7ic(function1, modifier4, Color.INSTANCE.m6850getUnspecified0d7_KjU(), j4, LoadingIndicatorDefaults.INSTANCE.getContainerShape(composerStartRestartGroup, 0), determinateIndicatorPolygons, composerStartRestartGroup, (i4 & 14) | 384 | (i4 & 112) | ((i4 << 3) & 7168) | ((i4 << 6) & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                j2 = j4;
                list2 = determinateIndicatorPolygons;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j2 = indicatorColor;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.LoadingIndicatorKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LoadingIndicatorKt.LoadingIndicator_cf5BqRc$lambda$0(function0, modifier3, j2, list2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            indicatorColor = j;
            if ((i2 & 4) == 0) {
                i5 = 128;
            } else {
                i5 = 128;
            }
            i3 |= i5;
        } else {
            indicatorColor = j;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                list2 = list;
                if (composerStartRestartGroup.changedInstance(list2)) {
                }
                i3 |= i7;
            } else {
                list2 = list;
            }
            i3 |= i7;
        } else {
            list2 = list;
        }
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "98@4325L14");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    indicatorColor = LoadingIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    determinateIndicatorPolygons = LoadingIndicatorDefaults.INSTANCE.getDeterminateIndicatorPolygons();
                    i4 = i3 & (-7169);
                } else {
                    i4 = i3;
                    determinateIndicatorPolygons = list2;
                }
                modifier4 = companion;
                j3 = indicatorColor;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    indicatorColor = LoadingIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    determinateIndicatorPolygons = LoadingIndicatorDefaults.INSTANCE.getDeterminateIndicatorPolygons();
                    i4 = i3 & (-7169);
                } else {
                    i4 = i3;
                    determinateIndicatorPolygons = list2;
                }
                modifier4 = companion;
                j3 = indicatorColor;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1086049965, i4, -1, "androidx.compose.material3.LoadingIndicator (LoadingIndicator.kt:101)");
            }
            long j5 = j3;
            m3733LoadingIndicatorImplt6yy7ic(function1, modifier4, Color.INSTANCE.m6850getUnspecified0d7_KjU(), j5, LoadingIndicatorDefaults.INSTANCE.getContainerShape(composerStartRestartGroup, 0), determinateIndicatorPolygons, composerStartRestartGroup, (i4 & 14) | 384 | (i4 & 112) | ((i4 << 3) & 7168) | ((i4 << 6) & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            j2 = j5;
            list2 = determinateIndicatorPolygons;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            j2 = indicatorColor;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.LoadingIndicatorKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LoadingIndicatorKt.LoadingIndicator_cf5BqRc$lambda$0(function0, modifier3, j2, list2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:65:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:68:0x00f8  */
    /* JADX INFO: renamed from: LoadingIndicator-3IgeMak, reason: not valid java name */
    public static final void m3730LoadingIndicator3IgeMak(Modifier modifier, long j, List<RoundedPolygon> list, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long indicatorColor;
        final List<RoundedPolygon> list2;
        final Modifier modifier3;
        final long j2;
        long j3;
        Modifier modifier4;
        List<RoundedPolygon> indeterminateIndicatorPolygons;
        long j4;
        Composer composerStartRestartGroup = composer.startRestartGroup(387862047);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadingIndicator)N(modifier,color:c#ui.graphics.Color,polygons)140@6031L14,136@5854L236:LoadingIndicator.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            indicatorColor = j;
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(indicatorColor)) ? 32 : 16;
        } else {
            indicatorColor = j;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                list2 = list;
                int i5 = composerStartRestartGroup.changedInstance(list2) ? 256 : 128;
                i3 |= i5;
            } else {
                list2 = list;
            }
            i3 |= i5;
        } else {
            list2 = list;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "133@5736L14");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                j3 = indicatorColor;
                modifier4 = modifier2;
            } else {
                Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i2 & 2) != 0) {
                    indicatorColor = LoadingIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    indeterminateIndicatorPolygons = LoadingIndicatorDefaults.INSTANCE.getIndeterminateIndicatorPolygons();
                    long j5 = indicatorColor;
                    modifier4 = companion;
                    j4 = j5;
                } else {
                    j3 = indicatorColor;
                    modifier4 = companion;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(387862047, i3, -1, "androidx.compose.material3.LoadingIndicator (LoadingIndicator.kt:136)");
                }
                long j6 = j4;
                m3732LoadingIndicatorImpleopBjH0(modifier4, Color.INSTANCE.m6850getUnspecified0d7_KjU(), j6, LoadingIndicatorDefaults.INSTANCE.getContainerShape(composerStartRestartGroup, 0), indeterminateIndicatorPolygons, composerStartRestartGroup, (i3 & 14) | 48 | ((i3 << 3) & 896) | ((i3 << 6) & 57344));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                j2 = j6;
                list2 = indeterminateIndicatorPolygons;
            }
            j4 = j3;
            indeterminateIndicatorPolygons = list2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(387862047, i3, -1, "androidx.compose.material3.LoadingIndicator (LoadingIndicator.kt:136)");
            }
            long j7 = j4;
            m3732LoadingIndicatorImpleopBjH0(modifier4, Color.INSTANCE.m6850getUnspecified0d7_KjU(), j7, LoadingIndicatorDefaults.INSTANCE.getContainerShape(composerStartRestartGroup, 0), indeterminateIndicatorPolygons, composerStartRestartGroup, (i3 & 14) | 48 | ((i3 << 3) & 896) | ((i3 << 6) & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            j2 = j7;
            list2 = indeterminateIndicatorPolygons;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            j2 = indicatorColor;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.LoadingIndicatorKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LoadingIndicatorKt.LoadingIndicator_3IgeMak$lambda$0(modifier3, j2, list2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x011f  */
    /* JADX WARN: Code duplicated, block: B:103:0x012c  */
    /* JADX WARN: Code duplicated, block: B:104:0x013b  */
    /* JADX WARN: Code duplicated, block: B:108:0x014b  */
    /* JADX WARN: Code duplicated, block: B:111:0x0161  */
    /* JADX WARN: Code duplicated, block: B:113:0x016c  */
    /* JADX WARN: Code duplicated, block: B:116:0x017c  */
    /* JADX WARN: Code duplicated, block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0061  */
    /* JADX WARN: Code duplicated, block: B:38:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0072  */
    /* JADX WARN: Code duplicated, block: B:45:0x0078  */
    /* JADX WARN: Code duplicated, block: B:47:0x007c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0084  */
    /* JADX WARN: Code duplicated, block: B:50:0x0087  */
    /* JADX WARN: Code duplicated, block: B:53:0x008d  */
    /* JADX WARN: Code duplicated, block: B:56:0x0094  */
    /* JADX WARN: Code duplicated, block: B:58:0x0098  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:91:0x0101  */
    /* JADX WARN: Code duplicated, block: B:94:0x0106  */
    /* JADX WARN: Code duplicated, block: B:97:0x0113  */
    /* JADX INFO: renamed from: ContainedLoadingIndicator-Y0xEhic, reason: not valid java name */
    public static final void m3729ContainedLoadingIndicatorY0xEhic(final Function0<Float> function0, Modifier modifier, long j, long j2, Shape shape, List<RoundedPolygon> list, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long containedContainerColor;
        long containedIndicatorColor;
        Shape containerShape;
        List<RoundedPolygon> determinateIndicatorPolygons;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final long j3;
        final long j4;
        final Shape shape2;
        final List<RoundedPolygon> list2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long j5;
        Shape shape3;
        Modifier modifier4;
        long j6;
        Composer composerStartRestartGroup = composer.startRestartGroup(1484812328);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ContainedLoadingIndicator)N(progress,modifier,containerColor:c#ui.graphics.Color,indicatorColor:c#ui.graphics.Color,containerShape,polygons)184@8191L246:LoadingIndicator.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    containedContainerColor = j;
                    int i5 = composerStartRestartGroup.changed(containedContainerColor) ? 256 : 128;
                    i3 |= i5;
                } else {
                    containedContainerColor = j;
                }
                i3 |= i5;
            } else {
                containedContainerColor = j;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    containedIndicatorColor = j2;
                    int i6 = composerStartRestartGroup.changed(containedIndicatorColor) ? 2048 : 1024;
                    i3 |= i6;
                } else {
                    containedIndicatorColor = j2;
                }
                i3 |= i6;
            } else {
                containedIndicatorColor = j2;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    containerShape = shape;
                    int i7 = composerStartRestartGroup.changed(containerShape) ? 16384 : 8192;
                    i3 |= i7;
                } else {
                    containerShape = shape;
                }
                i3 |= i7;
            } else {
                containerShape = shape;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    determinateIndicatorPolygons = list;
                    int i8 = composerStartRestartGroup.changedInstance(determinateIndicatorPolygons) ? 131072 : 65536;
                    i3 |= i8;
                } else {
                    determinateIndicatorPolygons = list;
                }
                i3 |= i8;
            } else {
                determinateIndicatorPolygons = list;
            }
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "179@7919L23,180@7997L23,181@8075L14");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i4 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        containedContainerColor = LoadingIndicatorDefaults.INSTANCE.getContainedContainerColor(composerStartRestartGroup, 0);
                    }
                    if ((i2 & 8) != 0) {
                        containedIndicatorColor = LoadingIndicatorDefaults.INSTANCE.getContainedIndicatorColor(composerStartRestartGroup, 0);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        containerShape = LoadingIndicatorDefaults.INSTANCE.getContainerShape(composerStartRestartGroup, 0);
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        determinateIndicatorPolygons = LoadingIndicatorDefaults.INSTANCE.getDeterminateIndicatorPolygons();
                        j6 = containedContainerColor;
                        j5 = containedIndicatorColor;
                        shape3 = containerShape;
                        modifier4 = companion;
                    } else {
                        j5 = containedIndicatorColor;
                        shape3 = containerShape;
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1484812328, i3, -1, "androidx.compose.material3.ContainedLoadingIndicator (LoadingIndicator.kt:184)");
                    }
                    composer2 = composerStartRestartGroup;
                    m3733LoadingIndicatorImplt6yy7ic(function0, modifier4, j6, j5, shape3, determinateIndicatorPolygons, composer2, i3 & 524286);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    j3 = j6;
                    j4 = j5;
                    shape2 = shape3;
                    list2 = determinateIndicatorPolygons;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    j5 = containedIndicatorColor;
                    shape3 = containerShape;
                    modifier4 = modifier2;
                }
                j6 = containedContainerColor;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1484812328, i3, -1, "androidx.compose.material3.ContainedLoadingIndicator (LoadingIndicator.kt:184)");
                }
                composer2 = composerStartRestartGroup;
                m3733LoadingIndicatorImplt6yy7ic(function0, modifier4, j6, j5, shape3, determinateIndicatorPolygons, composer2, i3 & 524286);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                j3 = j6;
                j4 = j5;
                shape2 = shape3;
                list2 = determinateIndicatorPolygons;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = containedContainerColor;
                j4 = containedIndicatorColor;
                shape2 = containerShape;
                list2 = determinateIndicatorPolygons;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.LoadingIndicatorKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LoadingIndicatorKt.ContainedLoadingIndicator_Y0xEhic$lambda$0(function0, modifier3, j3, j4, shape2, list2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                containedContainerColor = j;
                if (composerStartRestartGroup.changed(containedContainerColor)) {
                }
                i3 |= i5;
            } else {
                containedContainerColor = j;
            }
            i3 |= i5;
        } else {
            containedContainerColor = j;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                containedIndicatorColor = j2;
                if (composerStartRestartGroup.changed(containedIndicatorColor)) {
                }
                i3 |= i6;
            } else {
                containedIndicatorColor = j2;
            }
            i3 |= i6;
        } else {
            containedIndicatorColor = j2;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                containerShape = shape;
                if (composerStartRestartGroup.changed(containerShape)) {
                }
                i3 |= i7;
            } else {
                containerShape = shape;
            }
            i3 |= i7;
        } else {
            containerShape = shape;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                determinateIndicatorPolygons = list;
                if (composerStartRestartGroup.changedInstance(determinateIndicatorPolygons)) {
                }
                i3 |= i8;
            } else {
                determinateIndicatorPolygons = list;
            }
            i3 |= i8;
        } else {
            determinateIndicatorPolygons = list;
        }
        if ((74899 & i3) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "179@7919L23,180@7997L23,181@8075L14");
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    containedContainerColor = LoadingIndicatorDefaults.INSTANCE.getContainedContainerColor(composerStartRestartGroup, 0);
                }
                if ((i2 & 8) != 0) {
                    containedIndicatorColor = LoadingIndicatorDefaults.INSTANCE.getContainedIndicatorColor(composerStartRestartGroup, 0);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    containerShape = LoadingIndicatorDefaults.INSTANCE.getContainerShape(composerStartRestartGroup, 0);
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    determinateIndicatorPolygons = LoadingIndicatorDefaults.INSTANCE.getDeterminateIndicatorPolygons();
                    j6 = containedContainerColor;
                    j5 = containedIndicatorColor;
                    shape3 = containerShape;
                    modifier4 = companion;
                } else {
                    j5 = containedIndicatorColor;
                    shape3 = containerShape;
                    modifier4 = companion;
                    j6 = containedContainerColor;
                }
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    containedContainerColor = LoadingIndicatorDefaults.INSTANCE.getContainedContainerColor(composerStartRestartGroup, 0);
                }
                if ((i2 & 8) != 0) {
                    containedIndicatorColor = LoadingIndicatorDefaults.INSTANCE.getContainedIndicatorColor(composerStartRestartGroup, 0);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    containerShape = LoadingIndicatorDefaults.INSTANCE.getContainerShape(composerStartRestartGroup, 0);
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    determinateIndicatorPolygons = LoadingIndicatorDefaults.INSTANCE.getDeterminateIndicatorPolygons();
                    j6 = containedContainerColor;
                    j5 = containedIndicatorColor;
                    shape3 = containerShape;
                    modifier4 = companion;
                } else {
                    j5 = containedIndicatorColor;
                    shape3 = containerShape;
                    modifier4 = companion;
                    j6 = containedContainerColor;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1484812328, i3, -1, "androidx.compose.material3.ContainedLoadingIndicator (LoadingIndicator.kt:184)");
            }
            composer2 = composerStartRestartGroup;
            m3733LoadingIndicatorImplt6yy7ic(function0, modifier4, j6, j5, shape3, determinateIndicatorPolygons, composer2, i3 & 524286);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            j3 = j6;
            j4 = j5;
            shape2 = shape3;
            list2 = determinateIndicatorPolygons;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = containedContainerColor;
            j4 = containedIndicatorColor;
            shape2 = containerShape;
            list2 = determinateIndicatorPolygons;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.LoadingIndicatorKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LoadingIndicatorKt.ContainedLoadingIndicator_Y0xEhic$lambda$0(function0, modifier3, j3, j4, shape2, list2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: ContainedLoadingIndicator-DTcfvLk, reason: not valid java name */
    public static final void m3728ContainedLoadingIndicatorDTcfvLk(Modifier modifier, long j, long j2, Shape shape, List<RoundedPolygon> list, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long containedContainerColor;
        long containedIndicatorColor;
        Shape containerShape;
        List<RoundedPolygon> list2;
        Composer composer2;
        final Modifier modifier3;
        final long j3;
        final Shape shape2;
        final long j4;
        final List<RoundedPolygon> list3;
        List<RoundedPolygon> indeterminateIndicatorPolygons;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(663218740);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ContainedLoadingIndicator)N(modifier,containerColor:c#ui.graphics.Color,indicatorColor:c#ui.graphics.Color,containerShape,polygons)224@10018L217:LoadingIndicator.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                containedContainerColor = j;
                int i5 = composerStartRestartGroup.changed(containedContainerColor) ? 32 : 16;
                i3 |= i5;
            } else {
                containedContainerColor = j;
            }
            i3 |= i5;
        } else {
            containedContainerColor = j;
        }
        if ((i & 384) == 0) {
            containedIndicatorColor = j2;
            i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(containedIndicatorColor)) ? 256 : 128;
        } else {
            containedIndicatorColor = j2;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                containerShape = shape;
                int i6 = composerStartRestartGroup.changed(containerShape) ? 2048 : 1024;
                i3 |= i6;
            } else {
                containerShape = shape;
            }
            i3 |= i6;
        } else {
            containerShape = shape;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                list2 = list;
                int i7 = composerStartRestartGroup.changedInstance(list2) ? 16384 : 8192;
                i3 |= i7;
            } else {
                list2 = list;
            }
            i3 |= i7;
        } else {
            list2 = list;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "219@9744L23,220@9822L23,221@9900L14");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                }
                containerShape = containerShape;
                containedIndicatorColor = containedIndicatorColor;
                indeterminateIndicatorPolygons = list2;
                modifier4 = modifier2;
            } else {
                Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i2 & 2) != 0) {
                    containedContainerColor = LoadingIndicatorDefaults.INSTANCE.getContainedContainerColor(composerStartRestartGroup, 0);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    containedIndicatorColor = LoadingIndicatorDefaults.INSTANCE.getContainedIndicatorColor(composerStartRestartGroup, 0);
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    containerShape = LoadingIndicatorDefaults.INSTANCE.getContainerShape(composerStartRestartGroup, 0);
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    indeterminateIndicatorPolygons = LoadingIndicatorDefaults.INSTANCE.getIndeterminateIndicatorPolygons();
                } else {
                    indeterminateIndicatorPolygons = list2;
                }
                modifier4 = companion;
            }
            long j5 = containedContainerColor;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(663218740, i3, -1, "androidx.compose.material3.ContainedLoadingIndicator (LoadingIndicator.kt:224)");
            }
            composer2 = composerStartRestartGroup;
            m3732LoadingIndicatorImpleopBjH0(modifier4, j5, containedIndicatorColor, containerShape, indeterminateIndicatorPolygons, composer2, i3 & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            j3 = j5;
            j4 = containedIndicatorColor;
            shape2 = containerShape;
            list3 = indeterminateIndicatorPolygons;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = containedContainerColor;
            shape2 = containerShape;
            j4 = containedIndicatorColor;
            list3 = list2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.LoadingIndicatorKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LoadingIndicatorKt.ContainedLoadingIndicator_DTcfvLk$lambda$0(modifier3, j3, j4, shape2, list3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: LoadingIndicatorImpl-t6yy7ic, reason: not valid java name */
    private static final void m3733LoadingIndicatorImplt6yy7ic(final Function0<Float> function0, final Modifier modifier, final long j, final long j2, final Shape shape, final List<RoundedPolygon> list, Composer composer, final int i) {
        int i2;
        Object objMorphSequence;
        Composer composerStartRestartGroup = composer.startRestartGroup(-227757249);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadingIndicatorImpl)N(progress,modifier,containerColor:c#ui.graphics.Color,indicatorColor:c#ui.graphics.Color,containerShape,indicatorPolygons)261@11621L35,262@11672L19,263@11714L21,265@11768L121,269@11925L567,280@12594L340,277@12497L3214:LoadingIndicator.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(list) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-227757249, i2, -1, "androidx.compose.material3.LoadingIndicatorImpl (LoadingIndicator.kt:257)");
            }
            if (list.size() <= 1) {
                throw new IllegalArgumentException("indicatorPolygons should have, at least, two RoundedPolygons".toString());
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 168627106, "CC(remember):LoadingIndicator.kt#9igjgp");
            boolean z = (i2 & 14) == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.LoadingIndicatorKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(LoadingIndicatorKt.LoadingIndicatorImpl_t6yy7ic$lambda$1$0(function0));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final Function0 function1 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 168628722, "CC(remember):LoadingIndicator.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = AndroidPath_androidKt.Path();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final Path path = (Path) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 168630068, "CC(remember):LoadingIndicator.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = Matrix.m7058boximpl(Matrix.m7060constructorimpl$default(null, 1, null));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final float[] fArrM7083unboximpl = ((Matrix) objRememberedValue3).m7083unboximpl();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 168631896, "CC(remember):LoadingIndicator.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(list);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objMorphSequence = morphSequence(list, false);
                composerStartRestartGroup.updateRememberedValue(objMorphSequence);
            } else {
                objMorphSequence = objRememberedValue4;
            }
            final List list2 = (List) objMorphSequence;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 168637366, "CC(remember):LoadingIndicator.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(list2);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = Float.valueOf(calculateScaleFactor(list) * LoadingIndicatorDefaults.INSTANCE.getActiveIndicatorScale$material3());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final float fFloatValue = ((Number) objRememberedValue5).floatValue();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 168658547, "CC(remember):LoadingIndicator.kt#9igjgp");
            boolean zChanged3 = composerStartRestartGroup.changed(function1);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: androidx.compose.material3.LoadingIndicatorKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LoadingIndicatorKt.LoadingIndicatorImpl_t6yy7ic$lambda$6$0(function1, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxSize$default(SizeKt.m1268sizeVpY3zN4(SemanticsModifierKt.semantics(modifier, true, (Function1) objRememberedValue6), LoadingIndicatorDefaults.INSTANCE.m3723getContainerWidthD9Ej5fM(), LoadingIndicatorDefaults.INSTANCE.m3722getContainerHeightD9Ej5fM()), 0.0f, 1, null), shape), j, null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1102839029, "C302@13599L2096,299@13446L2259:LoadingIndicator.kt#uh7d8r");
            Modifier modifierAspectRatio = AspectRatioKt.aspectRatio(Modifier.INSTANCE, 1.0f, true);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 657165941, "CC(remember):LoadingIndicator.kt#9igjgp");
            boolean zChanged4 = composerStartRestartGroup.changed(function1) | composerStartRestartGroup.changedInstance(list2) | composerStartRestartGroup.changedInstance(path) | composerStartRestartGroup.changed(fFloatValue) | composerStartRestartGroup.changedInstance(fArrM7083unboximpl) | ((i2 & 7168) == 2048);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChanged4 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                Function1 function2 = new Function1() { // from class: androidx.compose.material3.LoadingIndicatorKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LoadingIndicatorKt.LoadingIndicatorImpl_t6yy7ic$lambda$7$0$0(function1, list2, path, fFloatValue, fArrM7083unboximpl, j2, (ContentDrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function2);
                objRememberedValue7 = function2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(DrawModifierKt.drawWithContent(modifierAspectRatio, (Function1) objRememberedValue7), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.LoadingIndicatorKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LoadingIndicatorKt.LoadingIndicatorImpl_t6yy7ic$lambda$8(function0, modifier, j, j2, shape, list, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LoadingIndicatorImpl_t6yy7ic$lambda$1$0(Function0 function0) {
        float fFloatValue = ((Number) function0.invoke()).floatValue();
        if (fFloatValue < 0.0f) {
            fFloatValue = 0.0f;
        }
        if (fFloatValue > 1.0f) {
            return 1.0f;
        }
        return fFloatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingIndicatorImpl_t6yy7ic$lambda$6$0(Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Object objInvoke = function0.invoke();
        if (Float.isNaN(((Number) objInvoke).floatValue())) {
            objInvoke = null;
        }
        Float f = (Float) objInvoke;
        SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(f != null ? f.floatValue() : 0.0f, RangesKt.rangeTo(0.0f, 1.0f), 0, 4, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingIndicatorImpl_t6yy7ic$lambda$7$0$0(Function0 function0, List list, Path path, float f, float[] fArr, long j, ContentDrawScope contentDrawScope) throws Throwable {
        long j2;
        float fFloatValue = ((Number) function0.invoke()).floatValue();
        int iCoerceAtMost = RangesKt.coerceAtMost((int) (list.size() * fFloatValue), list.size() - 1);
        float size = (fFloatValue == 1.0f && iCoerceAtMost == list.size() + (-1)) ? 1.0f : (list.size() * fFloatValue) % 1.0f;
        float f2 = (-fFloatValue) * 180;
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        long jMo7394getCenterF1C5BW0 = contentDrawScope2.mo7394getCenterF1C5BW0();
        DrawContext drawContext = contentDrawScope2.getDrawContext();
        long jMo7316getSizeNHjbRc = drawContext.mo7316getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo7322rotateUv8p0NA(f2, jMo7394getCenterF1C5BW0);
            j2 = jMo7316getSizeNHjbRc;
            try {
                DrawScope.m7385drawPathLG529CI$default(contentDrawScope2, m3734processPath3rZdNqA(ShapeUtilKt.toPath((Morph) list.get(iCoerceAtMost), size, (20 & 2) != 0 ? AndroidPath_androidKt.Path() : path, (20 & 4) != 0 ? 270 : 0, (20 & 8) != 0 ? false : false, (20 & 16) != 0, (20 & 32) != 0 ? 0.0f : 0.0f, (20 & 64) != 0 ? 0.0f : 0.0f), contentDrawScope2.mo7395getSizeNHjbRc(), f, fArr), j, 0.0f, Fill.INSTANCE, null, 0, 52, null);
                drawContext.getCanvas().restore();
                drawContext.mo7317setSizeuvyYCjk(j2);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                th = th;
                drawContext.getCanvas().restore();
                drawContext.mo7317setSizeuvyYCjk(j2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            j2 = jMo7316getSizeNHjbRc;
        }
    }

    /* JADX INFO: renamed from: LoadingIndicatorImpl-eopBjH0, reason: not valid java name */
    private static final void m3732LoadingIndicatorImpleopBjH0(final Modifier modifier, final long j, final long j2, final Shape shape, final List<RoundedPolygon> list, Composer composer, final int i) {
        int i2;
        Animatable animatable;
        List list2;
        MutableIntState mutableIntState;
        LoadingIndicatorKt$LoadingIndicatorImpl$6$1 loadingIndicatorKt$LoadingIndicatorImpl$6$1;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1776169461);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadingIndicatorImpl)N(modifier,containerColor:c#ui.graphics.Color,indicatorColor:c#ui.graphics.Color,containerShape,indicatorPolygons)369@16714L120,373@16871L571,381@17467L27,382@17531L49,383@17606L27,384@17663L52,385@17754L2412,385@17720L2446,443@20183L19,444@20225L21,445@20251L1882:LoadingIndicator.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(list) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1776169461, i2, -1, "androidx.compose.material3.LoadingIndicatorImpl (LoadingIndicator.kt:364)");
            }
            if (list.size() <= 1) {
                throw new IllegalArgumentException("indicatorPolygons should have, at least, two RoundedPolygons".toString());
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1796824797, "CC(remember):LoadingIndicator.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(list);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = morphSequence(list, true);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            List list3 = (List) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1796819322, "CC(remember):LoadingIndicator.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(list);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = Float.valueOf(calculateScaleFactor(list) * LoadingIndicatorDefaults.INSTANCE.getActiveIndicatorScale$material3());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final float fFloatValue = ((Number) objRememberedValue2).floatValue();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1796800794, "CC(remember):LoadingIndicator.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Animatable animatable2 = (Animatable) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1796798724, "CC(remember):LoadingIndicator.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = PrimitiveSnapshotStateKt.mutableFloatStateOf(QuarterRotation);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableFloatState mutableFloatState = (MutableFloatState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1796796346, "CC(remember):LoadingIndicator.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                Animatable animatableAnimatable$default = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(animatableAnimatable$default);
                objRememberedValue5 = animatableAnimatable$default;
            }
            final Animatable animatable3 = (Animatable) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1796794497, "CC(remember):LoadingIndicator.kt#9igjgp");
            boolean zChanged3 = composerStartRestartGroup.changed(list);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            MutableIntState mutableIntState2 = (MutableIntState) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1796789225, "CC(remember):LoadingIndicator.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(animatable2) | composerStartRestartGroup.changed(mutableIntState2) | composerStartRestartGroup.changedInstance(list3) | composerStartRestartGroup.changedInstance(animatable3);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                LoadingIndicatorKt$LoadingIndicatorImpl$6$1 loadingIndicatorKt$LoadingIndicatorImpl$6$2 = new LoadingIndicatorKt$LoadingIndicatorImpl$6$1(animatable2, list3, mutableIntState2, mutableFloatState, animatable3, null);
                animatable = animatable2;
                list2 = list3;
                mutableIntState = mutableIntState2;
                mutableFloatState = mutableFloatState;
                loadingIndicatorKt$LoadingIndicatorImpl$6$1 = loadingIndicatorKt$LoadingIndicatorImpl$6$2;
                composerStartRestartGroup.updateRememberedValue(loadingIndicatorKt$LoadingIndicatorImpl$6$1);
            } else {
                loadingIndicatorKt$LoadingIndicatorImpl$6$1 = objRememberedValue7;
                list2 = list3;
                mutableIntState = mutableIntState2;
                animatable = animatable2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(list, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) loadingIndicatorKt$LoadingIndicatorImpl$6$1, composerStartRestartGroup, (i2 >> 12) & 14);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1796713890, "CC(remember):LoadingIndicator.kt#9igjgp");
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = AndroidPath_androidKt.Path();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            final Path path = (Path) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1796712544, "CC(remember):LoadingIndicator.kt#9igjgp");
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = Matrix.m7058boximpl(Matrix.m7060constructorimpl$default(null, 1, null));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            final float[] fArrM7083unboximpl = ((Matrix) objRememberedValue9).m7083unboximpl();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableIntState mutableIntState3 = mutableIntState;
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxSize$default(SizeKt.m1268sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(modifier), LoadingIndicatorDefaults.INSTANCE.m3723getContainerWidthD9Ej5fM(), LoadingIndicatorDefaults.INSTANCE.m3722getContainerHeightD9Ej5fM()), 0.0f, 1, null), shape), j, null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 706521396, "C460@20813L1304,458@20689L1438:LoadingIndicator.kt#uh7d8r");
            Modifier modifierAspectRatio = AspectRatioKt.aspectRatio(Modifier.INSTANCE, 1.0f, true);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1778320471, "CC(remember):LoadingIndicator.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(animatable) | composerStartRestartGroup.changedInstance(r21) | composerStartRestartGroup.changedInstance(list2) | composerStartRestartGroup.changed(mutableIntState3) | composerStartRestartGroup.changedInstance(path) | composerStartRestartGroup.changed(fFloatValue) | composerStartRestartGroup.changedInstance(fArrM7083unboximpl) | ((i2 & 896) == 256);
            Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                final List list4 = list2;
                final Animatable animatable4 = animatable;
                objRememberedValue10 = new Function1() { // from class: androidx.compose.material3.LoadingIndicatorKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LoadingIndicatorKt.LoadingIndicatorImpl_eopBjH0$lambda$14$0$0(animatable4, animatable3, mutableFloatState, list4, path, fFloatValue, fArrM7083unboximpl, j2, mutableIntState3, (ContentDrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(DrawModifierKt.drawWithContent(modifierAspectRatio, (Function1) objRememberedValue10), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.LoadingIndicatorKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LoadingIndicatorKt.LoadingIndicatorImpl_eopBjH0$lambda$15(modifier, j, j2, shape, list, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LoadingIndicatorImpl_eopBjH0$lambda$5(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int LoadingIndicatorImpl_eopBjH0$lambda$9(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingIndicatorImpl_eopBjH0$lambda$14$0$0(Animatable animatable, Animatable animatable2, MutableFloatState mutableFloatState, List list, Path path, float f, float[] fArr, long j, MutableIntState mutableIntState, ContentDrawScope contentDrawScope) {
        float fFloatValue = ((Number) animatable.getValue()).floatValue();
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        float fLoadingIndicatorImpl_eopBjH0$lambda$5 = (90 * fFloatValue) + LoadingIndicatorImpl_eopBjH0$lambda$5(mutableFloatState) + ((Number) animatable2.getValue()).floatValue();
        long jMo7394getCenterF1C5BW0 = contentDrawScope2.mo7394getCenterF1C5BW0();
        DrawContext drawContext = contentDrawScope2.getDrawContext();
        long jMo7316getSizeNHjbRc = drawContext.mo7316getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo7322rotateUv8p0NA(fLoadingIndicatorImpl_eopBjH0$lambda$5, jMo7394getCenterF1C5BW0);
            DrawScope.m7385drawPathLG529CI$default(contentDrawScope2, m3734processPath3rZdNqA(ShapeUtilKt.toPath((Morph) list.get(LoadingIndicatorImpl_eopBjH0$lambda$9(mutableIntState)), fFloatValue, (20 & 2) != 0 ? AndroidPath_androidKt.Path() : path, (20 & 4) != 0 ? 270 : 0, (20 & 8) != 0 ? false : false, (20 & 16) != 0, (20 & 32) != 0 ? 0.0f : 0.0f, (20 & 64) != 0 ? 0.0f : 0.0f), contentDrawScope2.mo7395getSizeNHjbRc(), f, fArr), j, 0.0f, Fill.INSTANCE, null, 0, 52, null);
            return Unit.INSTANCE;
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo7317setSizeuvyYCjk(jMo7316getSizeNHjbRc);
        }
    }

    private static final List<Morph> morphSequence(List<RoundedPolygon> list, boolean z) {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            if (i2 < list.size()) {
                listCreateListBuilder.add(new Morph(list.get(i).normalized(), list.get(i2).normalized()));
            } else if (z) {
                listCreateListBuilder.add(new Morph(list.get(i).normalized(), list.get(0).normalized()));
            }
            i = i2;
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    private static final float calculateScaleFactor(List<RoundedPolygon> list) {
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        int size = list.size();
        float fMin = 1.0f;
        for (int i = 0; i < size; i++) {
            RoundedPolygon roundedPolygon = list.get(i);
            RoundedPolygon.calculateBounds$default(roundedPolygon, fArr, false, 2, null);
            roundedPolygon.calculateMaxBounds(fArr2);
            fMin = Math.min(fMin, Math.max(width(fArr) / width(fArr2), height(fArr) / height(fArr2)));
        }
        return fMin;
    }

    private static final float width(float[] fArr) {
        return fArr[2] - fArr[0];
    }

    private static final float height(float[] fArr) {
        return fArr[3] - fArr[1];
    }

    /* JADX INFO: renamed from: processPath-3rZdNqA$default, reason: not valid java name */
    static /* synthetic */ Path m3735processPath3rZdNqA$default(Path path, long j, float f, float[] fArr, int i, Object obj) {
        if ((i & 8) != 0) {
            fArr = Matrix.m7060constructorimpl$default(null, 1, null);
        }
        return m3734processPath3rZdNqA(path, j, f, fArr);
    }

    /* JADX INFO: renamed from: processPath-3rZdNqA, reason: not valid java name */
    private static final Path m3734processPath3rZdNqA(Path path, long j, float f, float[] fArr) {
        Matrix.m7069resetimpl(fArr);
        Matrix.m7076scaleimpl$default(fArr, Float.intBitsToFloat((int) (j >> 32)) * f, Float.intBitsToFloat((int) (4294967295L & j)) * f, 0.0f, 4, null);
        path.mo6705transform58bKbWc(fArr);
        path.mo6706translatek4lQ0M(Offset.m6573minusMKHz9U(androidx.compose.ui.geometry.SizeKt.m6648getCenteruvyYCjk(j), path.getBounds().m6599getCenterF1C5BW0()));
        return path;
    }
}
