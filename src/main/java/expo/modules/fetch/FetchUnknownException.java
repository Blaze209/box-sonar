package expo.modules.fetch;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

/* JADX INFO: compiled from: FetchExceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/fetch/FetchUnknownException;", "Lexpo/modules/kotlin/exception/CodedException;", "<init>", "()V", "expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FetchUnknownException extends CodedException {
    /* JADX WARN: Multi-variable type inference failed */
    public FetchUnknownException() {
        super(MicrosoftAuthorizationErrorResponse.UNKNOWN_ERROR, null, 2, 0 == true ? 1 : 0);
    }
}
