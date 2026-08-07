package org.apache.hc.core5.http.impl.routing;

import java.util.Objects;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public final class PathRoute<T, H> {
    public final H handler;
    public final T pattern;

    public PathRoute(T t, H h) {
        this.pattern = (T) Args.notNull(t, "Pattern");
        this.handler = (H) Args.notNull(h, "Handler");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.pattern, ((PathRoute) obj).pattern);
    }

    public int hashCode() {
        return this.pattern.hashCode();
    }

    public String toString() {
        return this.pattern + " -> " + this.handler;
    }
}
