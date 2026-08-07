package com.box.android.boxai.homescreen;

import com.box.android.boxai.AiCenterSessionInfoProviderImpl;
import com.box.android.boxai.BoxAiAnalytics;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiHomeReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/homescreen/BoxAiHomeEnvironment;", "", "analytics", "Lcom/box/android/boxai/BoxAiAnalytics;", "boxAiCenterSessionInfoProviderImpl", "Lcom/box/android/boxai/AiCenterSessionInfoProviderImpl;", "<init>", "(Lcom/box/android/boxai/BoxAiAnalytics;Lcom/box/android/boxai/AiCenterSessionInfoProviderImpl;)V", "getAnalytics", "()Lcom/box/android/boxai/BoxAiAnalytics;", "getBoxAiCenterSessionInfoProviderImpl", "()Lcom/box/android/boxai/AiCenterSessionInfoProviderImpl;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAiHomeEnvironment {
    public static final int $stable = 8;
    private final BoxAiAnalytics analytics;
    private final AiCenterSessionInfoProviderImpl boxAiCenterSessionInfoProviderImpl;

    @Inject
    public BoxAiHomeEnvironment(BoxAiAnalytics analytics, AiCenterSessionInfoProviderImpl boxAiCenterSessionInfoProviderImpl) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(boxAiCenterSessionInfoProviderImpl, "boxAiCenterSessionInfoProviderImpl");
        this.analytics = analytics;
        this.boxAiCenterSessionInfoProviderImpl = boxAiCenterSessionInfoProviderImpl;
    }

    public final BoxAiAnalytics getAnalytics() {
        return this.analytics;
    }

    public final AiCenterSessionInfoProviderImpl getBoxAiCenterSessionInfoProviderImpl() {
        return this.boxAiCenterSessionInfoProviderImpl;
    }
}
