package com.nimbusds.jose.jca;

import com.nimbusds.jose.jca.JCAContext;

/* JADX INFO: loaded from: classes3.dex */
public interface JCAAware<T extends JCAContext> {
    T getJCAContext();
}
