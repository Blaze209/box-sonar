package com.nimbusds.jose;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface CriticalHeaderParamsAware {
    Set<String> getDeferredCriticalHeaderParams();

    Set<String> getProcessedCriticalHeaderParams();
}
