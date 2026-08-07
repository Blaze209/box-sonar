package io.split.android.engine.matchers.semver;

import io.split.android.client.Evaluator;
import io.split.android.client.utils.logger.Logger;
import io.split.android.engine.matchers.Matcher;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class GreaterThanOrEqualToSemverMatcher implements Matcher {
    private final Semver mTarget;

    public GreaterThanOrEqualToSemverMatcher(String target) {
        this.mTarget = Semver.build(target);
    }

    @Override // io.split.android.engine.matchers.Matcher
    public boolean match(Object key, String bucketingKey, Map<String, Object> attributes, Evaluator evaluator) {
        Semver semverBuild;
        boolean z = false;
        if (key != null && this.mTarget != null) {
            if (!(key instanceof String) || (semverBuild = Semver.build((String) key)) == null) {
                return false;
            }
            z = semverBuild.compare(this.mTarget) >= 0;
            Logger.d(semverBuild.getVersion() + " >= " + this.mTarget.getVersion() + " | Result: " + z);
        }
        return z;
    }
}
