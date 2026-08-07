package io.split.android.client;

import android.content.Context;
import io.split.android.client.api.Key;
import io.split.android.client.exceptions.SplitInstantiationException;
import io.split.android.client.localhost.LocalhostSplitFactory;

/* JADX INFO: loaded from: classes4.dex */
public class SplitFactoryBuilder {
    public static SplitFactory build(String sdkKey, String matchingKey, Context context) throws SplitInstantiationException {
        if (matchingKey == null) {
            throw new SplitInstantiationException("Could not instantiate SplitFactory. Matching key cannot be null");
        }
        return build(sdkKey, new Key(matchingKey, null), context);
    }

    public static SplitFactory build(String sdkKey, Key key, Context context) throws SplitInstantiationException {
        return build(sdkKey, key, SplitClientConfig.builder().build(), context);
    }

    public static synchronized SplitFactory build(String sdkKey, Key key, SplitClientConfig config, Context context) throws SplitInstantiationException {
        try {
            checkPreconditions(sdkKey, key, config, context);
            if ("localhost".equals(sdkKey)) {
                return new LocalhostSplitFactory(key.matchingKey(), context, config);
            }
            return new SplitFactoryImpl(sdkKey, key, config, context);
        } catch (Exception e) {
            throw new SplitInstantiationException("Could not instantiate SplitFactory", e);
        }
    }

    public static SplitFactory local(String key, Context context) {
        return new LocalhostSplitFactory(key, context, SplitClientConfig.builder().build());
    }

    private static void checkPreconditions(String sdkKey, Key key, SplitClientConfig config, Context context) throws SplitInstantiationException {
        if (sdkKey == null) {
            throw new SplitInstantiationException("Could not instantiate SplitFactory. SDK key cannot be null");
        }
        if (key == null) {
            throw new SplitInstantiationException("Could not instantiate SplitFactory. Matching key cannot be null");
        }
        if (config == null) {
            throw new SplitInstantiationException("Could not instantiate SplitFactory. Config cannot be null");
        }
        if (context == null) {
            throw new SplitInstantiationException("Could not instantiate SplitFactory. Context cannot be null");
        }
    }
}
