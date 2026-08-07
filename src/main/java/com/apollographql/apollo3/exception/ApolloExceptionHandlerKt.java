package com.apollographql.apollo3.exception;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApolloExceptionHandler.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\b\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"0\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"DEFAULT_EXCEPTION_HANDLER", "Lkotlin/Function1;", "", "", "apolloExceptionHandler", "getApolloExceptionHandler$annotations", "()V", "getApolloExceptionHandler", "()Lkotlin/jvm/functions/Function1;", "setApolloExceptionHandler", "(Lkotlin/jvm/functions/Function1;)V", "apollo-api"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ApolloExceptionHandlerKt {
    private static final Function1<Throwable, Unit> DEFAULT_EXCEPTION_HANDLER;
    private static Function1<? super Throwable, Unit> apolloExceptionHandler;

    public static /* synthetic */ void getApolloExceptionHandler$annotations() {
    }

    static {
        ApolloExceptionHandlerKt$DEFAULT_EXCEPTION_HANDLER$1 apolloExceptionHandlerKt$DEFAULT_EXCEPTION_HANDLER$1 = new Function1<Throwable, Unit>() { // from class: com.apollographql.apollo3.exception.ApolloExceptionHandlerKt$DEFAULT_EXCEPTION_HANDLER$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                System.out.println((Object) "Apollo: unhandled exception");
                it.printStackTrace();
            }
        };
        DEFAULT_EXCEPTION_HANDLER = apolloExceptionHandlerKt$DEFAULT_EXCEPTION_HANDLER$1;
        apolloExceptionHandler = apolloExceptionHandlerKt$DEFAULT_EXCEPTION_HANDLER$1;
    }

    public static final Function1<Throwable, Unit> getApolloExceptionHandler() {
        return apolloExceptionHandler;
    }

    public static final void setApolloExceptionHandler(Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        apolloExceptionHandler = function1;
    }
}
