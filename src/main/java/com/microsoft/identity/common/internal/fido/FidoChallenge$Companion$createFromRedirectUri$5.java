package com.microsoft.identity.common.internal.fido;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FidoChallenge.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class FidoChallenge$Companion$createFromRedirectUri$5 extends FunctionReferenceImpl implements Function2<FidoRequestField, String, String> {
    FidoChallenge$Companion$createFromRedirectUri$5(Object obj) {
        super(2, obj, FidoChallengeField.Companion.class, "throwIfInvalidSubmitUrl", "throwIfInvalidSubmitUrl(Lcom/microsoft/identity/common/internal/fido/FidoRequestField;Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final String invoke(FidoRequestField p0, String str) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((FidoChallengeField.Companion) this.receiver).throwIfInvalidSubmitUrl(p0, str);
    }
}
