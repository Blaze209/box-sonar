package org.apache.hc.core5.pool;

import java.util.Set;
import org.apache.hc.core5.util.TimeValue;

/* JADX INFO: loaded from: classes5.dex */
public interface ConnPoolControl<T> extends ConnPoolStats<T> {
    void closeExpired();

    void closeIdle(TimeValue timeValue);

    int getDefaultMaxPerRoute();

    int getMaxPerRoute(T t);

    int getMaxTotal();

    Set<T> getRoutes();

    void setDefaultMaxPerRoute(int i);

    void setMaxPerRoute(T t, int i);

    void setMaxTotal(int i);
}
