package io.opentelemetry.instrumentation.okhttp.v3_0;

import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.instrumentation.api.instrumenter.Instrumenter;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes4.dex */
final class TracingInterceptor implements Interceptor {
    private final Instrumenter<Request, Response> instrumenter;
    private final ContextPropagators propagators;

    TracingInterceptor(Instrumenter<Request, Response> instrumenter, ContextPropagators contextPropagators) {
        this.instrumenter = instrumenter;
        this.propagators = contextPropagators;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        Request request = chain.request();
        Context callingContextForRequest = TracingCallFactory.getCallingContextForRequest(request);
        if (callingContextForRequest == null) {
            callingContextForRequest = Context.current();
        }
        if (!this.instrumenter.shouldStart(callingContextForRequest, request)) {
            return chain.proceed(chain.request());
        }
        Context contextStart = this.instrumenter.start(callingContextForRequest, request);
        Request requestInjectContextToRequest = injectContextToRequest(request, contextStart);
        try {
            Scope scopeMakeCurrent = contextStart.makeCurrent();
            try {
                Response responseProceed = chain.proceed(requestInjectContextToRequest);
                if (scopeMakeCurrent != null) {
                    scopeMakeCurrent.close();
                }
                this.instrumenter.end(contextStart, requestInjectContextToRequest, responseProceed, null);
                return responseProceed;
            } catch (Throwable th) {
                if (scopeMakeCurrent != null) {
                    try {
                        scopeMakeCurrent.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            this.instrumenter.end(contextStart, requestInjectContextToRequest, null, e);
            throw e;
        }
    }

    private Request injectContextToRequest(Request request, Context context) {
        Request.Builder builderNewBuilder = request.newBuilder();
        this.propagators.getTextMapPropagator().inject(context, builderNewBuilder, RequestHeaderSetter.INSTANCE);
        return builderNewBuilder.build();
    }
}
