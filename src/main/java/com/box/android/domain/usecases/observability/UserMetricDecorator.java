package com.box.android.domain.usecases.observability;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.observability.Gen204Event;
import com.box.android.domain.models.observability.UserMetric;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsDecorator.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/box/android/domain/usecases/observability/UserMetricDecorator;", "Lcom/box/android/domain/usecases/observability/MetricDecorator;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "decorate", "Lcom/box/android/domain/models/observability/Gen204Event;", "event", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UserMetricDecorator implements MetricDecorator {
    private final IUserContextManager userContextManager;

    @Inject
    public UserMetricDecorator(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.userContextManager = userContextManager;
    }

    @Override // com.box.android.domain.usecases.observability.MetricDecorator
    public Gen204Event decorate(Gen204Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        UserMetric user = event.getUser();
        if (user == null) {
            user = UserMetric.INSTANCE.from(this.userContextManager.getUserInfo());
        }
        event.setUser(user);
        return event;
    }
}
