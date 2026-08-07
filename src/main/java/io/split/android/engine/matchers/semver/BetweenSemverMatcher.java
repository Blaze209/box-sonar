package io.split.android.engine.matchers.semver;

import io.split.android.client.Evaluator;
import io.split.android.client.utils.logger.Logger;
import io.split.android.engine.matchers.Matcher;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class BetweenSemverMatcher implements Matcher {
    private final Semver mEndTarget;
    private final Semver mStartTarget;

    public BetweenSemverMatcher(String start, String end) {
        this.mStartTarget = Semver.build(start);
        this.mEndTarget = Semver.build(end);
    }

    @Override // io.split.android.engine.matchers.Matcher
    public boolean match(Object key, String bucketingKey, Map<String, Object> attributes, Evaluator evaluator) {
        Semver semverBuild;
        boolean z = false;
        if (key != null && this.mStartTarget != null && this.mEndTarget != null) {
            if (!(key instanceof String) || (semverBuild = Semver.build((String) key)) == null) {
                return false;
            }
            if (semverBuild.compare(this.mStartTarget) >= 0 && semverBuild.compare(this.mEndTarget) <= 0) {
                z = true;
            }
            Logger.d(this.mStartTarget.getVersion() + " <= " + semverBuild.getVersion() + " <= " + this.mEndTarget.getVersion() + " | Result: " + z);
        }
        return z;
    }
}
