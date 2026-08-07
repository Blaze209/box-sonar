package com.box.android.coreservices.modelcontroller;

import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.domain.utils.BoxTypeIdPair;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public interface IMoCoBatchOperations {
    void deleteTypeIdPairs(List<BoxTypeIdPair> list, ProgressReporter.ProgressListener progressListener);
}
