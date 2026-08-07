package io.split.android.engine.matchers.semver;

import io.split.android.client.Evaluator;
import io.split.android.client.utils.logger.Logger;
import io.split.android.engine.matchers.Matcher;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class EqualToSemverMatcher implements Matcher {
    private final Semver mTarget;

    public EqualToSemverMatcher(String target) {
        this.mTarget = Semver.build(target);
    }

    @Override // io.split.android.engine.matchers.Matcher
    public boolean match(Object key, String bucketingKey, Map<String, Object> attributes, Evaluator evaluator) {
        Semver semverBuild;
        if (key == null || this.mTarget == null || !(key instanceof String) || (semverBuild = Semver.build((String) key)) == null) {
            return false;
        }
        boolean zEquals = semverBuild.equals(this.mTarget);
        Logger.d(semverBuild.getVersion() + " == " + this.mTarget.getVersion() + " | Result: " + zEquals);
        return zEquals;
    }
}
