package io.split.android.engine.experiments;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface SplitFetcher {
    ParsedSplit fetch(String splitName);

    List<ParsedSplit> fetchAll();

    void forceRefresh();
}
