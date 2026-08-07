package com.margelo.nitro.boxcontext;

import com.margelo.nitro.boxcontext.providers.AnalyticsProvider;
import com.margelo.nitro.core.AnyMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnalyticsService.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/margelo/nitro/boxcontext/AnalyticsService;", "Lcom/margelo/nitro/boxcontext/HybridAnalyticsServiceSpec;", "<init>", "()V", "trackEvent", "", "name", "", "properties", "Lcom/margelo/nitro/core/AnyMap;", "logEvent", "Lcom/margelo/nitro/boxcontext/LogEventProperties;", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnalyticsService extends HybridAnalyticsServiceSpec {
    /* JADX INFO: Access modifiers changed from: private */
    public static final AnalyticsProvider trackEvent$lambda$0(BoxContext.Dependencies require) {
        Intrinsics.checkNotNullParameter(require, "$this$require");
        return require.getAnalyticsProvider();
    }

    @Override // com.margelo.nitro.boxcontext.HybridAnalyticsServiceSpec
    public void trackEvent(String name, AnyMap properties) {
        Intrinsics.checkNotNullParameter(name, "name");
        ((AnalyticsProvider) BoxContext.INSTANCE.require(new Function1() { // from class: com.margelo.nitro.boxcontext.AnalyticsService$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AnalyticsService.trackEvent$lambda$0((BoxContext.Dependencies) obj);
            }
        })).trackEvent(name, properties);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnalyticsProvider logEvent$lambda$1(BoxContext.Dependencies require) {
        Intrinsics.checkNotNullParameter(require, "$this$require");
        return require.getAnalyticsProvider();
    }

    @Override // com.margelo.nitro.boxcontext.HybridAnalyticsServiceSpec
    public void logEvent(String name, LogEventProperties properties) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(properties, "properties");
        ((AnalyticsProvider) BoxContext.INSTANCE.require(new Function1() { // from class: com.margelo.nitro.boxcontext.AnalyticsService$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AnalyticsService.logEvent$lambda$1((BoxContext.Dependencies) obj);
            }
        })).logEvent(name, properties);
    }
}
