package io.split.android.client;

import io.split.android.client.api.Key;
import io.split.android.client.shared.UserConsent;

/* JADX INFO: loaded from: classes4.dex */
public interface SplitFactory {
    SplitClient client();

    SplitClient client(Key key);

    SplitClient client(String matchingKey);

    SplitClient client(String matchingKey, String bucketingKey);

    void destroy();

    void flush();

    UserConsent getUserConsent();

    SplitManager manager();

    void setUserConsent(boolean enabled);
}
