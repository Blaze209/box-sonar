package androidx.compose.material3.internal;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: CircularWavyProgressModifiers.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class IndeterminateCircularWavyProgressNode$cacheDrawNode$1$1$1 extends FunctionReferenceImpl implements Function6<Float, Float, Float, Size, Boolean, Path, Path> {
    IndeterminateCircularWavyProgressNode$cacheDrawNode$1$1$1(Object obj) {
        super(6, obj, IndeterminateCircularWavyProgressNode.class, "progressPathProvider", "progressPathProvider-wzdHmys(FFFJZLandroidx/compose/ui/graphics/Path;)Landroidx/compose/ui/graphics/Path;", 0);
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ Path invoke(Float f, Float f2, Float f3, Size size, Boolean bool, Path path) {
        return m4986invokewzdHmys(f.floatValue(), f2.floatValue(), f3.floatValue(), size.m6643unboximpl(), bool.booleanValue(), path);
    }

    /* JADX INFO: renamed from: invoke-wzdHmys, reason: not valid java name */
    public final Path m4986invokewzdHmys(float f, float f2, float f3, long j, boolean z, Path path) {
        return ((IndeterminateCircularWavyProgressNode) this.receiver).m4919progressPathProviderwzdHmys(f, f2, f3, j, z, path);
    }
}
