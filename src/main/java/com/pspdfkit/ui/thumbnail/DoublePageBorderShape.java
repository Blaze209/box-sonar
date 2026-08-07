package com.pspdfkit.ui.thumbnail;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/DoublePageBorderShape;", "Landroidx/compose/ui/graphics/Shape;", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "isFirstPage", "", "<init>", "(FZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", ViewProps.LAYOUT_DIRECTION, "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class DoublePageBorderShape implements Shape {
    private final float cornerRadius;
    private final boolean isFirstPage;

    public /* synthetic */ DoublePageBorderShape(float f, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, z);
    }

    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public Outline mo655createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
        layoutDirection.getClass();
        density.getClass();
        float fMo754toPx0680j_4 = density.mo754toPx0680j_4(this.cornerRadius);
        long jM6523constructorimpl = CornerRadius.m6523constructorimpl((((long) Float.floatToRawIntBits(fMo754toPx0680j_4)) << 32) | (((long) Float.floatToRawIntBits(fMo754toPx0680j_4)) & 4294967295L));
        Path Path = AndroidPath_androidKt.Path();
        if (this.isFirstPage) {
            float fIntBitsToFloat = Float.intBitsToFloat((int) (size >> 32));
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (size & 4294967295L));
            CornerRadius.Companion companion = CornerRadius.INSTANCE;
            Path.addRoundRect$default(Path, new RoundRect(0.0f, 0.0f, fIntBitsToFloat, fIntBitsToFloat2, jM6523constructorimpl, companion.m6541getZerokKHJgLs(), companion.m6541getZerokKHJgLs(), jM6523constructorimpl, null), null, 2, null);
        } else {
            float fIntBitsToFloat3 = Float.intBitsToFloat((int) (size >> 32));
            float fIntBitsToFloat4 = Float.intBitsToFloat((int) (size & 4294967295L));
            CornerRadius.Companion companion2 = CornerRadius.INSTANCE;
            Path.addRoundRect$default(Path, new RoundRect(0.0f, 0.0f, fIntBitsToFloat3, fIntBitsToFloat4, companion2.m6541getZerokKHJgLs(), jM6523constructorimpl, jM6523constructorimpl, companion2.m6541getZerokKHJgLs(), null), null, 2, null);
        }
        return new Outline.Generic(Path);
    }

    private DoublePageBorderShape(float f, boolean z) {
        this.cornerRadius = f;
        this.isFirstPage = z;
    }
}
