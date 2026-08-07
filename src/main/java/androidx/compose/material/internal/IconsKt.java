package androidx.compose.material.internal;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Icons.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0082\b\u001aK\u0010\b\u001a\u00020\u0006*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\u0002\b\u0007H\u0082\b¢\u0006\u0004\b\u0011\u0010\u0012\"\u000e\u0010\u0013\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"materialIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "name", "", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "Lkotlin/ExtensionFunctionType;", "materialPath", "fillAlpha", "", "strokeAlpha", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "pathBuilder", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "", "materialPath-YwgOQQI", "(Landroidx/compose/ui/graphics/vector/ImageVector$Builder;FFILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "MaterialIconDimension", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IconsKt {
    private static final float MaterialIconDimension = 24.0f;

    private static final ImageVector materialIcon(String str, Function1<? super ImageVector.Builder, ImageVector.Builder> function1) {
        return function1.invoke(new ImageVector.Builder(str, Dp.m9687constructorimpl(24.0f), Dp.m9687constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 224, null)).build();
    }

    /* JADX INFO: renamed from: materialPath-YwgOQQI$default, reason: not valid java name */
    static /* synthetic */ ImageVector.Builder m2679materialPathYwgOQQI$default(ImageVector.Builder builder, float f, float f2, int i, Function1 function1, int i2, Object obj) {
        float f3 = (i2 & 1) != 0 ? 1.0f : f;
        float f4 = (i2 & 2) != 0 ? 1.0f : f2;
        int defaultFillType = (i2 & 4) != 0 ? VectorKt.getDefaultFillType() : i;
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m6840getBlack0d7_KjU(), null);
        int iM7190getButtKaPHkGw = StrokeCap.INSTANCE.m7190getButtKaPHkGw();
        int iM7200getBevelLxFBmk8 = StrokeJoin.INSTANCE.m7200getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        function1.invoke(pathBuilder);
        return ImageVector.Builder.m7552addPathoIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, f3, null, f4, 1.0f, iM7190getButtKaPHkGw, iM7200getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
    }

    /* JADX INFO: renamed from: materialPath-YwgOQQI, reason: not valid java name */
    private static final ImageVector.Builder m2678materialPathYwgOQQI(ImageVector.Builder builder, float f, float f2, int i, Function1<? super PathBuilder, Unit> function1) {
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m6840getBlack0d7_KjU(), null);
        int iM7190getButtKaPHkGw = StrokeCap.INSTANCE.m7190getButtKaPHkGw();
        int iM7200getBevelLxFBmk8 = StrokeJoin.INSTANCE.m7200getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        function1.invoke(pathBuilder);
        return ImageVector.Builder.m7552addPathoIyEayM$default(builder, pathBuilder.getNodes(), i, "", solidColor, f, null, f2, 1.0f, iM7190getButtKaPHkGw, iM7200getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
    }
}
