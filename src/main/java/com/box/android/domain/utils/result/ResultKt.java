package com.box.android.domain.utils.result;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a0\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0086\bø\u0001\u0000\u001aN\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\t*\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\t0\u00012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\b0\fH\u0086\bø\u0001\u0000\u001aZ\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\t*\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\t0\u00012\u001e\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u0002H\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u00010\fH\u0086\bø\u0001\u0000\u001aZ\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000f0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0010\"\u0004\b\u0002\u0010\u000f*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00100\u00012\u001e\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u0002H\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000f0\u00010\fH\u0086\bø\u0001\u0000\u001aN\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000f0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0010\"\u0004\b\u0002\u0010\u000f*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00100\u00012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u000f0\fH\u0086\bø\u0001\u0000\u001aH\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00130\fH\u0086\bø\u0001\u0000\u001aH\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00130\fH\u0086\bø\u0001\u0000\u001a)\u0010\u0015\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u0001¢\u0006\u0002\u0010\u0016\u001a'\u0010\u0017\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u0001¢\u0006\u0002\u0010\u0016\u001a$\u0010\u0018\u001a\u0004\u0018\u00010\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u0001\u001aA\u0010\u001a\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u00020\fH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001a\u001b\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001d\"\u0004\b\u0000\u0010\u0002*\u0002H\u0002¢\u0006\u0002\u0010\u001e\u001a:\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u00010 \"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t*\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020 \u0012\u0004\u0012\u0002H\t0\u0001\u001a:\u0010\u001f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020 \u0012\u0004\u0012\u0002H\t0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u00010 \u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, d2 = {"resultOf", "Lcom/box/android/domain/utils/result/Result;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Exception;", "Lkotlin/Exception;", "block", "Lkotlin/Function0;", "map", "T2", ExifInterface.LONGITUDE_EAST, "T1", ViewProps.TRANSFORM, "Lkotlin/Function1;", "flatMap", "flatMapError", "E2", "E1", "mapError", "onSuccess", "", "onError", "getOrNull", "(Lcom/box/android/domain/utils/result/Result;)Ljava/lang/Object;", "getOrThrow", PasskeyWebListener.GET_UNIQUE_KEY, "", "getOr", "(Lcom/box/android/domain/utils/result/Result;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toResultSuccess", "Lcom/box/android/domain/utils/result/Result$Success;", "(Ljava/lang/Object;)Lcom/box/android/domain/utils/result/Result$Success;", "transpose", "", "domain_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ResultKt {
    public static final <T> Result<T, Exception> resultOf(Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return new Result.Success(block.invoke());
        } catch (Exception e) {
            return new Result.Error(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T1, T2, E> Result<T2, E> map(Result<? extends T1, ? extends E> result, Function1<? super T1, ? extends T2> transform) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (result instanceof Result.Success) {
            return new Result.Success(transform.invoke((Object) ((Result.Success) result).getValue()));
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T1, T2, E> Result<T2, E> flatMap(Result<? extends T1, ? extends E> result, Function1<? super T1, ? extends Result<? extends T2, ? extends E>> block) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (result instanceof Result.Success) {
            return block.invoke((Object) ((Result.Success) result).getValue());
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, E1, E2> Result<T, E2> flatMapError(Result<? extends T, ? extends E1> result, Function1<? super E1, ? extends Result<? extends T, ? extends E2>> block) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (result instanceof Result.Success) {
            return result;
        }
        if (result instanceof Result.Error) {
            return block.invoke((Object) ((Result.Error) result).getValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, E1, E2> Result<T, E2> mapError(Result<? extends T, ? extends E1> result, Function1<? super E1, ? extends E2> transform) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (result instanceof Result.Success) {
            return result;
        }
        if (result instanceof Result.Error) {
            return new Result.Error(transform.invoke((Object) ((Result.Error) result).getValue()));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, E> Result<T, E> onSuccess(Result<? extends T, ? extends E> result, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (result instanceof Result.Success) {
            block.invoke((Object) ((Result.Success) result).getValue());
            return result;
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, E> Result<T, E> onError(Result<? extends T, ? extends E> result, Function1<? super E, Unit> block) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (result instanceof Result.Success) {
            return result;
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        block.invoke((Object) ((Result.Error) result).getValue());
        return result;
    }

    public static final <T, E> T getOrNull(Result<? extends T, ? extends E> result) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        if (result instanceof Result.Success) {
            return (T) ((Result.Success) result).getValue();
        }
        if (result instanceof Result.Error) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <T, E> T getOrThrow(Result<? extends T, ? extends E> result) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        if (result instanceof Result.Success) {
            return (T) ((Result.Success) result).getValue();
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException("Cannot unwrap Result.Error: " + ((Result.Error) result).getValue());
    }

    public static final <T, E> Object get(Result<? extends T, ? extends E> result) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        if (result instanceof Result.Success) {
            return ((Result.Success) result).getValue();
        }
        if (result instanceof Result.Error) {
            return ((Result.Error) result).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <T, E> T getOr(Result<? extends T, ? extends E> result, Function1<? super E, ? extends T> onError) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (result instanceof Result.Success) {
            return (T) ((Result.Success) result).getValue();
        }
        if (result instanceof Result.Error) {
            return onError.invoke((Object) ((Result.Error) result).getValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <T> Result.Success<T> toResultSuccess(T t) {
        return new Result.Success<>(t);
    }

    public static final <T, E> List<Result<T, E>> transpose(Result<? extends List<? extends T>, ? extends E> result) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        if (!(result instanceof Result.Success)) {
            if (result instanceof Result.Error) {
                return CollectionsKt.listOf(new Result.Error(((Result.Error) result).getValue()));
            }
            throw new NoWhenBranchMatchedException();
        }
        Iterable iterable = (Iterable) ((Result.Success) result).getValue();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(new Result.Success(it.next()));
        }
        return arrayList;
    }

    public static final <T, E> Result<List<T>, E> transpose(List<? extends Result<? extends T, ? extends E>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Result<List<T>, E> success = new Result.Success<>(CollectionsKt.emptyList());
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Result.Success success2 = (Result) it.next();
            success = success;
            if (success instanceof Result.Success) {
                List list2 = (List) ((Result.Success) success).getValue();
                if (success2 instanceof Result.Success) {
                    success2 = new Result.Success(CollectionsKt.plus((Collection<? extends Object>) list2, ((Result.Success) success2).getValue()));
                } else if (!(success2 instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                success = success2;
            } else if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return success;
    }
}
