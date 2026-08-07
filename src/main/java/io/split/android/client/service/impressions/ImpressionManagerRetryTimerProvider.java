package io.split.android.client.service.impressions;

import io.split.android.client.service.sseclient.sseclient.RetryBackoffCounterTimer;

/* JADX INFO: loaded from: classes4.dex */
interface ImpressionManagerRetryTimerProvider {
    RetryBackoffCounterTimer getImpressionsCountTimer();

    RetryBackoffCounterTimer getImpressionsTimer();

    RetryBackoffCounterTimer getUniqueKeysTimer();
}
