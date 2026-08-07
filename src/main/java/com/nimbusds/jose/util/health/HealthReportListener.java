package com.nimbusds.jose.util.health;

import com.nimbusds.jose.proc.SecurityContext;

/* JADX INFO: loaded from: classes3.dex */
public interface HealthReportListener<S, C extends SecurityContext> {
    void notify(HealthReport<S, C> healthReport);
}
