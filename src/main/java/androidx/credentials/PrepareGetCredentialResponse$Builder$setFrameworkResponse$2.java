package androidx.credentials;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: PrepareGetCredentialResponse.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class PrepareGetCredentialResponse$Builder$setFrameworkResponse$2 extends FunctionReferenceImpl implements Function0<Boolean> {
    PrepareGetCredentialResponse$Builder$setFrameworkResponse$2(Object obj) {
        super(0, obj, PrepareGetCredentialResponse.Builder.class, "hasAuthenticationResults", "hasAuthenticationResults()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Boolean.valueOf(((PrepareGetCredentialResponse.Builder) this.receiver).hasAuthenticationResults());
    }
}
