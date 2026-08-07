package org.chromium.support_lib_boundary;

import java.util.List;
import org.jspecify.annotations.NullMarked;

/* JADX INFO: loaded from: classes5.dex */
@NullMarked
public interface WebViewStartUpResultBoundaryInterface {
    List<Throwable> getAsyncStartUpLocations();

    List<Throwable> getBlockingStartUpLocations();

    Long getMaxTimePerTaskInUiThreadMillis();

    Long getTotalTimeInUiThreadMillis();
}
