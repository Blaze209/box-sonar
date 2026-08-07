package io.split.android.client;

import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public interface FeatureFlagFilter {
    boolean intersect(String values);

    boolean intersect(Set<String> values);
}
