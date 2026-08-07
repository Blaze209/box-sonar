package com.microsoft.identity.common.java.opentelemetry;

import com.microsoft.identity.common.java.logging.Logger;
import io.opentelemetry.context.Context;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes14.dex */
public class OtelContextExtension {
    private static final String TAG = "OtelContextExtension";

    public static Runnable wrap(Runnable runnable) {
        try {
            return Context.current().wrap(runnable);
        } catch (NoSuchMethodError e) {
            Logger.error(TAG + ":wrapRunnableWithCurrentTelemetryContext", e.getMessage(), e);
            return runnable;
        }
    }

    @Nullable
    public static Context current() {
        try {
            return Context.current();
        } catch (NoSuchMethodError e) {
            Logger.error(TAG + ":current", e.getMessage(), e);
            return null;
        }
    }
}
