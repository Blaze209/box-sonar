package com.box.android.domain.services;

import com.box.android.domain.models.observability.ApdexScore;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: IApdexScoreProvider.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J7\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IApdexScoreProvider;", "", FirebaseAnalytics.Param.SCORE, "Lcom/box/android/domain/models/observability/ApdexScore;", "apdexType", "", "duration", "", "magnitude", "secondaryMeasurement", "(Ljava/lang/String;DLjava/lang/Double;Ljava/lang/Double;)Lcom/box/android/domain/models/observability/ApdexScore;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IApdexScoreProvider {
    ApdexScore score(String apdexType, double duration, Double magnitude, Double secondaryMeasurement);

    /* JADX INFO: compiled from: IApdexScoreProvider.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ ApdexScore score$default(IApdexScoreProvider iApdexScoreProvider, String str, double d, Double d2, Double d3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: score");
        }
        if ((i & 4) != 0) {
            d2 = null;
        }
        if ((i & 8) != 0) {
            d3 = null;
        }
        return iApdexScoreProvider.score(str, d, d2, d3);
    }
}
