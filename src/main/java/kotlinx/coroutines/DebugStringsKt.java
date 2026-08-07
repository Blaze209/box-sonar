package kotlinx.coroutines;

import com.box.android.base.presentation.components.commentbar.CommentBarInputBoxKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;

/* JADX INFO: compiled from: DebugStrings.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0005\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0006H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0007\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006\t"}, d2 = {"hexAddress", "", "", "getHexAddress", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "Lkotlin/coroutines/Continuation;", "classSimpleName", "getClassSimpleName", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DebugStringsKt {
    public static final String getHexAddress(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String toDebugString(Continuation<?> continuation) {
        Object objM14780constructorimpl;
        if (continuation instanceof DispatchedContinuation) {
            return ((DispatchedContinuation) continuation).toString();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(continuation + CommentBarInputBoxKt.MENTION_SYMBOL + getHexAddress(continuation));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m14783exceptionOrNullimpl(objM14780constructorimpl) != null) {
            objM14780constructorimpl = continuation.getClass().getName() + CommentBarInputBoxKt.MENTION_SYMBOL + getHexAddress(continuation);
        }
        return (String) objM14780constructorimpl;
    }

    public static final String getClassSimpleName(Object obj) {
        return obj.getClass().getSimpleName();
    }
}
