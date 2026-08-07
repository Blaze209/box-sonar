package io.opentelemetry.extension.kotlin;

import io.opentelemetry.context.Context;
import io.opentelemetry.context.ImplicitContextKeyed;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0005"}, d2 = {"asContextElement", "Lkotlin/coroutines/CoroutineContext;", "Lio/opentelemetry/context/Context;", "Lio/opentelemetry/context/ImplicitContextKeyed;", "getOpenTelemetryContext", "opentelemetry-extension-kotlin"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ContextExtensionsKt {
    public static final CoroutineContext asContextElement(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return new KotlinContextElement(context);
    }

    public static final CoroutineContext asContextElement(ImplicitContextKeyed implicitContextKeyed) {
        Intrinsics.checkNotNullParameter(implicitContextKeyed, "<this>");
        return new KotlinContextElement(Context.current().with(implicitContextKeyed));
    }

    public static final Context getOpenTelemetryContext(CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        CoroutineContext.Key<KotlinContextElement> KEY = KotlinContextElement.KEY;
        Intrinsics.checkNotNullExpressionValue(KEY, "KEY");
        KotlinContextElement kotlinContextElement = (KotlinContextElement) coroutineContext.get(KEY);
        if (kotlinContextElement != null) {
            Context context = kotlinContextElement.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "element.context");
            return context;
        }
        Context contextRoot = Context.root();
        Intrinsics.checkNotNullExpressionValue(contextRoot, "root()");
        return contextRoot;
    }
}
