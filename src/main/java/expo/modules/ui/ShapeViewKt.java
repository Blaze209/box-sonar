package expo.modules.ui;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.graphics.shapes.CornerRounding;
import androidx.graphics.shapes.RoundedPolygon;
import androidx.graphics.shapes.RoundedPolygonKt;
import androidx.graphics.shapes.ShapesKt;
import androidx.graphics.shapes.Shapes_androidKt;
import androidx.window.core.layout.WindowSizeClass;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ShapeView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004\u001a?\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a7\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001f\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a/\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a'\u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001f\u0010 \u001a)\u0010!\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%H\u0002¢\u0006\u0004\b&\u0010'\u001a%\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%¢\u0006\u0004\b+\u0010,\u001a\u0012\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010*\u001a\u0019\u00100\u001a\u000201*\u0002022\u0006\u00103\u001a\u000204H\u0007¢\u0006\u0002\u00105¨\u00066"}, d2 = {"centerX", "", "Landroidx/compose/ui/geometry/Size;", "centerX-uvyYCjk", "(J)F", "centerY", "centerY-uvyYCjk", "createStarPath", "Landroidx/compose/ui/graphics/Path;", "size", "cornerRounding", "smoothing", "innerRadius", "radius", "verticesCount", "", "createStarPath-LjSzlW0", "(JFFFFI)Landroidx/compose/ui/graphics/Path;", "createPillStarPath", "createPillStarPath-_93gMUo", "(JFFFI)Landroidx/compose/ui/graphics/Path;", "createPillPath", "createPillPath-TmRCtEA", "(JF)Landroidx/compose/ui/graphics/Path;", "createPolygonPath", "createPolygonPath-Cqks5Fs", "(JFFI)Landroidx/compose/ui/graphics/Path;", "createCirclePath", "createCirclePath-Pq9zytI", "(JFI)Landroidx/compose/ui/graphics/Path;", "createRectanglePath", "createRectanglePath-Pq9zytI", "(JFF)Landroidx/compose/ui/graphics/Path;", "createRoundedCornerPath", "cornerRadii", "Lexpo/modules/ui/CornerRadii;", "density", "Landroidx/compose/ui/unit/Density;", "createRoundedCornerPath-Pq9zytI", "(JLexpo/modules/ui/CornerRadii;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Path;", "pathFromShapeRecord", "record", "Lexpo/modules/ui/ShapeRecord;", "pathFromShapeRecord-12SF9DM", "(Lexpo/modules/ui/ShapeRecord;JLandroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Path;", "shapeFromShapeRecord", "Landroidx/compose/ui/graphics/Shape;", "shapeRecord", "ShapeContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/ShapeProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/ShapeProps;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ShapeViewKt {

    /* JADX INFO: compiled from: ShapeView.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ShapeType.values().length];
            try {
                iArr[ShapeType.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ShapeType.PILL_STAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ShapeType.PILL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ShapeType.CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ShapeType.RECTANGLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ShapeType.POLYGON.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ShapeType.ROUNDED_CORNER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShapeContent$lambda$6(FunctionalComposableScope functionalComposableScope, ShapeProps shapeProps, int i, Composer composer, int i2) {
        ShapeContent(functionalComposableScope, shapeProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: createStarPath-LjSzlW0, reason: not valid java name */
    private static final Path m14670createStarPathLjSzlW0(long j, float f, float f2, float f3, float f4, int i) {
        CornerRounding cornerRounding = new CornerRounding(Size.m6637getMinDimensionimpl(j) * f, f2);
        return AndroidPath_androidKt.asComposePath(Shapes_androidKt.toPath$default(ShapesKt.star$default(RoundedPolygon.INSTANCE, i, Size.m6637getMinDimensionimpl(j) * 0.5f * RangesKt.coerceAtLeast(f4, 0.002f), Size.m6637getMinDimensionimpl(j) * 0.5f * RangesKt.coerceAtLeast(RangesKt.coerceAtMost(f3, f4 - 0.001f), 0.001f), cornerRounding, null, null, m14662centerXuvyYCjk(j), m14663centerYuvyYCjk(j), 48, null), null, 1, null));
    }

    /* JADX INFO: renamed from: createPillStarPath-_93gMUo, reason: not valid java name */
    private static final Path m14666createPillStarPath_93gMUo(long j, float f, float f2, float f3, int i) {
        float f4 = 2;
        return AndroidPath_androidKt.asComposePath(Shapes_androidKt.toPath$default(ShapesKt.pillStar$default(RoundedPolygon.INSTANCE, Float.intBitsToFloat((int) (j >> 32)) / f4, Float.intBitsToFloat((int) (4294967295L & j)) / f4, i, RangesKt.coerceAtLeast(RangesKt.coerceAtMost(f3, 0.999f), 0.001f), new CornerRounding(Size.m6637getMinDimensionimpl(j) * f, f2), null, null, 0.0f, 0.0f, m14662centerXuvyYCjk(j), m14663centerYuvyYCjk(j), WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null), null, 1, null));
    }

    /* JADX INFO: renamed from: createPillPath-TmRCtEA, reason: not valid java name */
    private static final Path m14665createPillPathTmRCtEA(long j, float f) {
        return AndroidPath_androidKt.asComposePath(Shapes_androidKt.toPath$default(ShapesKt.pill(RoundedPolygon.INSTANCE, Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), f, m14662centerXuvyYCjk(j), m14663centerYuvyYCjk(j)), null, 1, null));
    }

    /* JADX INFO: renamed from: createPolygonPath-Cqks5Fs, reason: not valid java name */
    private static final Path m14667createPolygonPathCqks5Fs(long j, float f, float f2, int i) {
        return AndroidPath_androidKt.asComposePath(Shapes_androidKt.toPath$default(RoundedPolygonKt.RoundedPolygon$default(RangesKt.coerceAtLeast(i, 3), Size.m6637getMinDimensionimpl(j) / 2, m14662centerXuvyYCjk(j), m14663centerYuvyYCjk(j), new CornerRounding(Size.m6637getMinDimensionimpl(j) * f, f2), null, 32, null), null, 1, null));
    }

    /* JADX INFO: renamed from: createCirclePath-Pq9zytI, reason: not valid java name */
    private static final Path m14664createCirclePathPq9zytI(long j, float f, int i) {
        RoundedPolygon.Companion companion = RoundedPolygon.INSTANCE;
        float fM14662centerXuvyYCjk = m14662centerXuvyYCjk(j);
        float fM14663centerYuvyYCjk = m14663centerYuvyYCjk(j);
        return AndroidPath_androidKt.asComposePath(Shapes_androidKt.toPath$default(ShapesKt.circle(companion, RangesKt.coerceAtLeast(i, 3), Size.m6637getMinDimensionimpl(j) * 0.5f * RangesKt.coerceAtLeast(f, 0.002f), fM14662centerXuvyYCjk, fM14663centerYuvyYCjk), null, 1, null));
    }

    /* JADX INFO: renamed from: createRectanglePath-Pq9zytI, reason: not valid java name */
    private static final Path m14668createRectanglePathPq9zytI(long j, float f, float f2) {
        CornerRounding cornerRounding = new CornerRounding(Size.m6637getMinDimensionimpl(j) * f, f2);
        return AndroidPath_androidKt.asComposePath(Shapes_androidKt.toPath$default(ShapesKt.rectangle$default(RoundedPolygon.INSTANCE, Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), cornerRounding, null, m14662centerXuvyYCjk(j), m14663centerYuvyYCjk(j), 8, null), null, 1, null));
    }

    /* JADX INFO: renamed from: createRoundedCornerPath-Pq9zytI, reason: not valid java name */
    private static final Path m14669createRoundedCornerPathPq9zytI(long j, CornerRadii cornerRadii, Density density) {
        if (cornerRadii == null) {
            cornerRadii = new CornerRadii(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
        }
        Outline outline = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(cornerRadii.getTopStart()), Dp.m9687constructorimpl(cornerRadii.getTopEnd()), Dp.m9687constructorimpl(cornerRadii.getBottomEnd()), Dp.m9687constructorimpl(cornerRadii.getBottomStart())).mo655createOutlinePq9zytI(j, LayoutDirection.Ltr, density);
        if (outline instanceof Outline.Rectangle) {
            Path Path = AndroidPath_androidKt.Path();
            Path.addRect$default(Path, ((Outline.Rectangle) outline).getRect(), null, 2, null);
            return Path;
        }
        if (outline instanceof Outline.Rounded) {
            Path Path2 = AndroidPath_androidKt.Path();
            Path.addRoundRect$default(Path2, ((Outline.Rounded) outline).getRoundRect(), null, 2, null);
            return Path2;
        }
        if (outline instanceof Outline.Generic) {
            return ((Outline.Generic) outline).getPath();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: pathFromShapeRecord-12SF9DM, reason: not valid java name */
    public static final Path m14671pathFromShapeRecord12SF9DM(ShapeRecord record, long j, Density density) {
        Object objM14780constructorimpl;
        Path pathM14670createStarPathLjSzlW0;
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(density, "density");
        try {
            Result.Companion companion = Result.INSTANCE;
            switch (WhenMappings.$EnumSwitchMapping$0[record.getType().ordinal()]) {
                case 1:
                    pathM14670createStarPathLjSzlW0 = m14670createStarPathLjSzlW0(j, record.getCornerRounding(), record.getSmoothing(), record.getInnerRadius(), record.getRadius(), record.getVerticesCount());
                    break;
                case 2:
                    pathM14670createStarPathLjSzlW0 = m14666createPillStarPath_93gMUo(j, record.getCornerRounding(), record.getSmoothing(), record.getInnerRadius(), record.getVerticesCount());
                    break;
                case 3:
                    pathM14670createStarPathLjSzlW0 = m14665createPillPathTmRCtEA(j, record.getSmoothing());
                    break;
                case 4:
                    pathM14670createStarPathLjSzlW0 = m14664createCirclePathPq9zytI(j, record.getRadius(), record.getVerticesCount());
                    break;
                case 5:
                    pathM14670createStarPathLjSzlW0 = m14668createRectanglePathPq9zytI(j, record.getCornerRounding(), record.getSmoothing());
                    break;
                case 6:
                    pathM14670createStarPathLjSzlW0 = m14667createPolygonPathCqks5Fs(j, record.getCornerRounding(), record.getSmoothing(), record.getVerticesCount());
                    break;
                case 7:
                    pathM14670createStarPathLjSzlW0 = m14669createRoundedCornerPathPq9zytI(j, record.getCornerRadii(), density);
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            objM14780constructorimpl = Result.m14780constructorimpl(pathM14670createStarPathLjSzlW0);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m14786isFailureimpl(objM14780constructorimpl)) {
            objM14780constructorimpl = null;
        }
        Path path = (Path) objM14780constructorimpl;
        return path == null ? AndroidPath_androidKt.Path() : path;
    }

    public static final Shape shapeFromShapeRecord(final ShapeRecord shapeRecord) {
        if (shapeRecord == null) {
            return null;
        }
        return new Shape() { // from class: expo.modules.ui.ShapeViewKt.shapeFromShapeRecord.1
            @Override // androidx.compose.ui.graphics.Shape
            /* JADX INFO: renamed from: createOutline-Pq9zytI */
            public Outline mo655createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
                Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
                Intrinsics.checkNotNullParameter(density, "density");
                return new Outline.Generic(ShapeViewKt.m14671pathFromShapeRecord12SF9DM(shapeRecord, size, density));
            }
        };
    }

    public static final void ShapeContent(final FunctionalComposableScope functionalComposableScope, final ShapeProps props, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(534848992);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ShapeContent)188@7279L83,189@7384L537,187@7242L704:ShapeView.kt#v15e7d");
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
                ComposerKt.traceEventStart(534848992, i2, -1, "expo.modules.ui.ShapeContent (ShapeView.kt:186)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | (ComposableScope.$stable << 6));
            composerStartRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ShapeView.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(props);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.ShapeViewKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ShapeViewKt.ShapeContent$lambda$5$lambda$4(props, (CacheDrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            BoxKt.Box(SizeKt.fillMaxSize$default(DrawModifierKt.drawWithCache(modifierApplyModifiers, (Function1) objRememberedValue), 0.0f, 1, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ShapeViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ShapeViewKt.ShapeContent$lambda$6(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult ShapeContent$lambda$5$lambda$4(final ShapeProps shapeProps, CacheDrawScope drawWithCache) {
        Intrinsics.checkNotNullParameter(drawWithCache, "$this$drawWithCache");
        final Path pathM14671pathFromShapeRecord12SF9DM = m14671pathFromShapeRecord12SF9DM(new ShapeRecord(shapeProps.getCornerRounding(), shapeProps.getSmoothing(), shapeProps.getVerticesCount(), shapeProps.getInnerRadius(), shapeProps.getRadius(), shapeProps.getCornerRadii(), shapeProps.getType()), drawWithCache.m6349getSizeNHjbRc(), drawWithCache);
        return drawWithCache.onDrawBehind(new Function1() { // from class: expo.modules.ui.ShapeViewKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ShapeViewKt.ShapeContent$lambda$5$lambda$4$lambda$3(pathM14671pathFromShapeRecord12SF9DM, shapeProps, (DrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShapeContent$lambda$5$lambda$4$lambda$3(Path path, ShapeProps shapeProps, DrawScope onDrawBehind) {
        Intrinsics.checkNotNullParameter(onDrawBehind, "$this$onDrawBehind");
        Color composeOrNull = UtilsKt.getComposeOrNull(shapeProps.getColor());
        DrawScope.m7385drawPathLG529CI$default(onDrawBehind, path, composeOrNull != null ? composeOrNull.m6824unboximpl() : Color.INSTANCE.m6849getTransparent0d7_KjU(), 0.0f, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: centerX-uvyYCjk, reason: not valid java name */
    private static final float m14662centerXuvyYCjk(long j) {
        return Float.intBitsToFloat((int) (j >> 32)) / 2;
    }

    /* JADX INFO: renamed from: centerY-uvyYCjk, reason: not valid java name */
    private static final float m14663centerYuvyYCjk(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L)) / 2;
    }
}
