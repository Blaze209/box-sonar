package com.microsoft.identity.common.java.opentelemetry;

import com.microsoft.identity.common.java.logging.Logger;
import io.opentelemetry.api.baggage.Baggage;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;

/* JADX INFO: loaded from: classes14.dex */
public class BaggageExtension {
    private static final String TAG = "BaggageExtension";

    private BaggageExtension() {
    }

    public static Scope makeBaggageCurrent(Baggage baggage) {
        try {
            if (baggage == null) {
                return SpanExtension.NoopScope.INSTANCE;
            }
            return baggage.storeInContext(Context.current()).makeCurrent();
        } catch (Exception | NoSuchMethodError e) {
            Logger.error(TAG + ":makeBaggageCurrent", "Failed to make baggage current", e);
            return SpanExtension.NoopScope.INSTANCE;
        }
    }

    public static Baggage fromContext(Context context) {
        try {
            return Baggage.fromContext(context);
        } catch (Exception | NoSuchMethodError e) {
            Logger.error(TAG + ":fromContext", "Failed to get baggage from context", e);
            return new NoopBaggage();
        }
    }
}
