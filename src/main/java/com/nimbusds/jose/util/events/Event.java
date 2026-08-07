package com.nimbusds.jose.util.events;

import com.nimbusds.jose.proc.SecurityContext;

/* JADX INFO: loaded from: classes3.dex */
public interface Event<S, C extends SecurityContext> {
    C getContext();

    S getSource();
}
