package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.ContextCustomizer;
import io.opentelemetry.instrumentation.api.instrumenter.LocalRootSpan;
import io.opentelemetry.instrumentation.api.internal.HttpRouteState;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class HttpRouteHolder {
    public static <REQUEST> ContextCustomizer<REQUEST> get() {
        return new ContextCustomizer() { // from class: io.opentelemetry.instrumentation.api.instrumenter.http.HttpRouteHolder$$ExternalSyntheticLambda0
            @Override // io.opentelemetry.instrumentation.api.instrumenter.ContextCustomizer
            public final Context onStart(Context context, Object obj, Attributes attributes) {
                return HttpRouteHolder.lambda$get$0(context, obj, attributes);
            }
        };
    }

    static /* synthetic */ Context lambda$get$0(Context context, Object obj, Attributes attributes) {
        return HttpRouteState.fromContextOrNull(context) != null ? context : context.with(HttpRouteState.create(0, null));
    }

    private HttpRouteHolder() {
    }

    public static void updateHttpRoute(Context context, HttpRouteSource httpRouteSource, @Nullable String str) {
        updateHttpRoute(context, httpRouteSource, ConstantAdapter.INSTANCE, str);
    }

    public static <T> void updateHttpRoute(Context context, HttpRouteSource httpRouteSource, HttpRouteGetter<T> httpRouteGetter, T t) {
        updateHttpRoute(context, httpRouteSource, OneArgAdapter.getInstance(), t, httpRouteGetter);
    }

    public static <T, U> void updateHttpRoute(Context context, HttpRouteSource httpRouteSource, HttpRouteBiGetter<T, U> httpRouteBiGetter, T t, U u) {
        String str;
        Span spanFromContextOrNull = LocalRootSpan.fromContextOrNull(context);
        if (spanFromContextOrNull == null) {
            return;
        }
        HttpRouteState httpRouteStateFromContextOrNull = HttpRouteState.fromContextOrNull(context);
        if (httpRouteStateFromContextOrNull == null) {
            String str2 = httpRouteBiGetter.get(context, t, u);
            if (str2 == null || str2.isEmpty()) {
                return;
            }
            spanFromContextOrNull.updateName(str2);
            spanFromContextOrNull.setAttribute(SemanticAttributes.HTTP_ROUTE, str2);
            return;
        }
        boolean z = !httpRouteSource.useFirst && httpRouteSource.order == httpRouteStateFromContextOrNull.getUpdatedBySourceOrder();
        if ((httpRouteSource.order <= httpRouteStateFromContextOrNull.getUpdatedBySourceOrder() && !z) || (str = httpRouteBiGetter.get(context, t, u)) == null || str.isEmpty()) {
            return;
        }
        if (!z || isBetterRoute(httpRouteStateFromContextOrNull, str)) {
            spanFromContextOrNull.updateName(str);
            httpRouteStateFromContextOrNull.update(context, httpRouteSource.order, str);
        }
    }

    private static boolean isBetterRoute(HttpRouteState httpRouteState, String str) {
        String route = httpRouteState.getRoute();
        return str.length() > (route == null ? 0 : route.length());
    }

    @Nullable
    static String getRoute(Context context) {
        HttpRouteState httpRouteStateFromContextOrNull = HttpRouteState.fromContextOrNull(context);
        if (httpRouteStateFromContextOrNull == null) {
            return null;
        }
        return httpRouteStateFromContextOrNull.getRoute();
    }

    private static final class OneArgAdapter<T> implements HttpRouteBiGetter<T, HttpRouteGetter<T>> {
        private static final OneArgAdapter<Object> INSTANCE = new OneArgAdapter<>();

        private OneArgAdapter() {
        }

        static <T> OneArgAdapter<T> getInstance() {
            return (OneArgAdapter<T>) INSTANCE;
        }

        @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpRouteBiGetter
        @Nullable
        public String get(Context context, T t, HttpRouteGetter<T> httpRouteGetter) {
            return httpRouteGetter.get(context, t);
        }
    }

    private static final class ConstantAdapter implements HttpRouteGetter<String> {
        private static final ConstantAdapter INSTANCE = new ConstantAdapter();

        @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpRouteGetter
        @Nullable
        public String get(Context context, String str) {
            return str;
        }

        private ConstantAdapter() {
        }
    }
}
