package com.microsoft.identity.common.internal.fido;

import com.google.android.gms.fido.u2f.api.common.ClientData;
import io.opentelemetry.api.trace.Span;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IFidoManager.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JA\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/common/internal/fido/IFidoManager;", "", "authenticate", "", ClientData.KEY_CHALLENGE, "relyingPartyIdentifier", "allowedCredentials", "", "userVerificationPolicy", "span", "Lio/opentelemetry/api/trace/Span;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lio/opentelemetry/api/trace/Span;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IFidoManager {
    Object authenticate(String str, String str2, List<String> list, String str3, Span span, Continuation<? super String> continuation);
}
