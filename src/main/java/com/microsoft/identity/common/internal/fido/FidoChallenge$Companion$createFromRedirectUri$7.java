package com.microsoft.identity.common.internal.fido;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FidoChallenge.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class FidoChallenge$Companion$createFromRedirectUri$7 extends FunctionReferenceImpl implements Function2<FidoRequestField, List<? extends String>, List<? extends String>> {
    FidoChallenge$Companion$createFromRedirectUri$7(Object obj) {
        super(2, obj, FidoChallengeField.Companion.class, "throwIfInvalidOptionalListParameter", "throwIfInvalidOptionalListParameter(Lcom/microsoft/identity/common/internal/fido/FidoRequestField;Ljava/util/List;)Ljava/util/List;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ List<? extends String> invoke(FidoRequestField fidoRequestField, List<? extends String> list) {
        return invoke2(fidoRequestField, (List<String>) list);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<String> invoke2(FidoRequestField p0, List<String> list) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((FidoChallengeField.Companion) this.receiver).throwIfInvalidOptionalListParameter(p0, list);
    }
}
