package androidx.compose.ui.graphics;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: Path.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, d2 = {BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "Landroidx/compose/ui/graphics/Path;", "ui-graphics"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PathKt {
    public static final Path copy(Path path) {
        Path Path = AndroidPath_androidKt.Path();
        Path.m7100addPathUv8p0NA$default(Path, path, 0L, 2, null);
        return Path;
    }
}
