package com.microsoft.identity.common.java.commands.parameters;

import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public interface IHasExtraParameters {
    Iterable<Map.Entry<String, String>> getExtraParameters();

    void setExtraParameters(Iterable<Map.Entry<String, String>> iterable);
}
