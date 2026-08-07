package org.chromium.support_lib_boundary;

import java.util.Set;
import java.util.concurrent.Executor;
import org.jspecify.annotations.NullMarked;

/* JADX INFO: loaded from: classes5.dex */
@NullMarked
public interface WebViewStartUpConfigBoundaryInterface {
    Executor getBackgroundExecutor();

    Set<String> getProfileNamesToLoad();

    boolean shouldRunUiThreadStartUpTasks();
}
