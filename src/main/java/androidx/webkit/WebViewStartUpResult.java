package androidx.webkit;

import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public interface WebViewStartUpResult {
    Long getMaxTimePerTaskInUiThreadMillis();

    List<StartUpLocation> getNonUiThreadBlockingStartUpLocations();

    Long getTotalTimeInUiThreadMillis();

    List<StartUpLocation> getUiThreadBlockingStartUpLocations();
}
