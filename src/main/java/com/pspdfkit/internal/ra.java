package com.pspdfkit.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ra {
    public static final Json a = JsonKt.Json$default(null, new Function1() { // from class: com.pspdfkit.internal.ra$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return ra.a((JsonBuilder) obj);
        }
    }, 1, null);

    public static final Unit a(JsonBuilder jsonBuilder) {
        jsonBuilder.getClass();
        jsonBuilder.setIgnoreUnknownKeys(true);
        return Unit.INSTANCE;
    }
}
