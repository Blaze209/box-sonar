package io.split.android.engine.matchers.semver;

import io.split.android.client.Evaluator;
import io.split.android.engine.matchers.Matcher;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class InListSemverMatcher implements Matcher {
    private final Set<Semver> mTargetList = new HashSet();

    public InListSemverMatcher(List<String> targetList) {
        if (targetList != null) {
            Iterator<String> it = targetList.iterator();
            while (it.hasNext()) {
                Semver semverBuild = Semver.build(it.next());
                if (semverBuild != null) {
                    this.mTargetList.add(semverBuild);
                }
            }
        }
    }

    @Override // io.split.android.engine.matchers.Matcher
    public boolean match(Object key, String bucketingKey, Map<String, Object> attributes, Evaluator evaluator) {
        Semver semverBuild;
        if (key == null || this.mTargetList.isEmpty() || !(key instanceof String) || (semverBuild = Semver.build((String) key)) == null) {
            return false;
        }
        Iterator<Semver> it = this.mTargetList.iterator();
        while (it.hasNext()) {
            if (semverBuild.equals(it.next())) {
                return true;
            }
        }
        return false;
    }
}
