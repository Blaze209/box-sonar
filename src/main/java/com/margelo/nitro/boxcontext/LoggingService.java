package com.margelo.nitro.boxcontext;

import com.margelo.nitro.boxcontext.providers.LoggingProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoggingService.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/margelo/nitro/boxcontext/LoggingService;", "Lcom/margelo/nitro/boxcontext/HybridLoggingServiceSpec;", "<init>", "()V", "log", "", "severity", "Lcom/margelo/nitro/boxcontext/LoggingSeverity;", "message", "", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoggingService extends HybridLoggingServiceSpec {
    /* JADX INFO: Access modifiers changed from: private */
    public static final LoggingProvider log$lambda$0(BoxContext.Dependencies require) {
        Intrinsics.checkNotNullParameter(require, "$this$require");
        return require.getLoggingProvider();
    }

    @Override // com.margelo.nitro.boxcontext.HybridLoggingServiceSpec
    public void log(LoggingSeverity severity, String message) {
        Intrinsics.checkNotNullParameter(severity, "severity");
        Intrinsics.checkNotNullParameter(message, "message");
        ((LoggingProvider) BoxContext.INSTANCE.require(new Function1() { // from class: com.margelo.nitro.boxcontext.LoggingService$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LoggingService.log$lambda$0((BoxContext.Dependencies) obj);
            }
        })).log(severity, message);
    }
}
