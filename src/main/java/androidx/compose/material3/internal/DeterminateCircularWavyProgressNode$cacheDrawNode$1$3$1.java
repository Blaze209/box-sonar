package androidx.compose.material3.internal;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: CircularWavyProgressModifiers.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class DeterminateCircularWavyProgressNode$cacheDrawNode$1$3$1 extends FunctionReferenceImpl implements Function6<Float, Float, Float, Size, Boolean, Path, Path> {
    DeterminateCircularWavyProgressNode$cacheDrawNode$1$3$1(Object obj) {
        super(6, obj, DeterminateCircularWavyProgressNode.class, "progressPathProvider", "progressPathProvider-wzdHmys(FFFJZLandroidx/compose/ui/graphics/Path;)Landroidx/compose/ui/graphics/Path;", 0);
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ Path invoke(Float f, Float f2, Float f3, Size size, Boolean bool, Path path) {
        return m4966invokewzdHmys(f.floatValue(), f2.floatValue(), f3.floatValue(), size.m6643unboximpl(), bool.booleanValue(), path);
    }

    /* JADX INFO: renamed from: invoke-wzdHmys, reason: not valid java name */
    public final Path m4966invokewzdHmys(float f, float f2, float f3, long j, boolean z, Path path) {
        return ((DeterminateCircularWavyProgressNode) this.receiver).m4919progressPathProviderwzdHmys(f, f2, f3, j, z, path);
    }
}
