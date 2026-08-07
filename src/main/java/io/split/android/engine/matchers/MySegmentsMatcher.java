package io.split.android.engine.matchers;

import io.split.android.client.Evaluator;
import io.split.android.client.storage.mysegments.MySegmentsStorage;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentsMatcher implements Matcher {
    private final MySegmentsStorage mMySegmentsStorage;
    private final String mSegmentName;

    public MySegmentsMatcher(MySegmentsStorage mySegmentsStorage, String segmentName) {
        this.mMySegmentsStorage = mySegmentsStorage;
        this.mSegmentName = segmentName;
    }

    @Override // io.split.android.engine.matchers.Matcher
    public boolean match(Object matchValue, String bucketingKey, Map<String, Object> attributes, Evaluator evaluator) {
        return this.mMySegmentsStorage.getAll().contains(this.mSegmentName);
    }
}
