package io.nutrient.domain;

import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0004H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lio/nutrient/domain/ConnectivityObserver;", "", "isConnected", "Lkotlinx/coroutines/flow/Flow;", "", "()Lkotlinx/coroutines/flow/Flow;", "isConnectionAvailable", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ConnectivityObserver {
    Flow<Boolean> isConnected();

    boolean isConnectionAvailable();
}
