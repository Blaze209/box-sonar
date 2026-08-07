package io.split.android.client;

import io.split.android.client.api.SplitView;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface SplitManager {
    void destroy();

    SplitView split(String featureFlagName);

    List<String> splitNames();

    List<SplitView> splits();
}
