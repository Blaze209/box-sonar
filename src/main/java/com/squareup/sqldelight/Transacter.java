package com.squareup.sqldelight;

import com.squareup.sqldelight.internal.FunctionsJvmKt;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Transacter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ+\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\b\tH&J<\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001d\u0010\f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\r\u0012\u0004\u0012\u0002H\u000b0\u0007¢\u0006\u0002\b\tH&¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/squareup/sqldelight/Transacter;", "", SemanticAttributes.MessagingRocketmqMessageTypeValues.TRANSACTION, "", "noEnclosing", "", "body", "Lkotlin/Function1;", "Lcom/squareup/sqldelight/TransactionWithoutReturn;", "Lkotlin/ExtensionFunctionType;", "transactionWithResult", "R", "bodyWithReturn", "Lcom/squareup/sqldelight/TransactionWithReturn;", "(ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Transaction", "runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface Transacter {
    void transaction(boolean noEnclosing, Function1<? super TransactionWithoutReturn, Unit> body);

    <R> R transactionWithResult(boolean noEnclosing, Function1<? super TransactionWithReturn<R>, ? extends R> bodyWithReturn);

    /* JADX INFO: compiled from: Transacter.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object transactionWithResult$default(Transacter transacter, boolean z, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transactionWithResult");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            return transacter.transactionWithResult(z, function1);
        }

        public static /* synthetic */ void transaction$default(Transacter transacter, boolean z, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transaction");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            transacter.transaction(z, function1);
        }
    }

    /* JADX INFO: compiled from: Transacter.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010&\u001a\u00020\u00112\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0016\u0010(\u001a\u00020\u00112\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\r\u0010)\u001a\u00020\u0011H\u0000¢\u0006\u0002\b*J\u000f\u0010\t\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0002\b+J\r\u0010,\u001a\u00020\u0011H\u0000¢\u0006\u0002\b-J\u0010\u0010,\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0004H$R\u001a\u0010\u0003\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\u0000X¤\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R0\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\u00190\u00100\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006."}, d2 = {"Lcom/squareup/sqldelight/Transacter$Transaction;", "Lcom/squareup/sqldelight/TransactionCallbacks;", "()V", "childrenSuccessful", "", "getChildrenSuccessful$runtime", "()Z", "setChildrenSuccessful$runtime", "(Z)V", "enclosingTransaction", "getEnclosingTransaction", "()Lcom/squareup/sqldelight/Transacter$Transaction;", "ownerThreadId", "", "postCommitHooks", "", "Lkotlin/Function0;", "", "getPostCommitHooks$runtime", "()Ljava/util/List;", "postRollbackHooks", "getPostRollbackHooks$runtime", "queriesFuncs", "", "", "", "Lcom/squareup/sqldelight/Query;", "getQueriesFuncs$runtime", "()Ljava/util/Map;", "successful", "getSuccessful$runtime", "setSuccessful$runtime", "transacter", "Lcom/squareup/sqldelight/Transacter;", "getTransacter$runtime", "()Lcom/squareup/sqldelight/Transacter;", "setTransacter$runtime", "(Lcom/squareup/sqldelight/Transacter;)V", "afterCommit", "function", "afterRollback", "checkThreadConfinement", "checkThreadConfinement$runtime", "enclosingTransaction$runtime", "endTransaction", "endTransaction$runtime", "runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class Transaction implements TransactionCallbacks {
        private boolean successful;
        private Transacter transacter;
        private final long ownerThreadId = FunctionsJvmKt.currentThreadId();
        private final List<Function0<Unit>> postCommitHooks = new ArrayList();
        private final List<Function0<Unit>> postRollbackHooks = new ArrayList();
        private final Map<Integer, Function0<List<Query<?>>>> queriesFuncs = new LinkedHashMap();
        private boolean childrenSuccessful = true;

        protected abstract void endTransaction(boolean successful);

        protected abstract Transaction getEnclosingTransaction();

        public final List<Function0<Unit>> getPostCommitHooks$runtime() {
            return this.postCommitHooks;
        }

        public final List<Function0<Unit>> getPostRollbackHooks$runtime() {
            return this.postRollbackHooks;
        }

        public final Map<Integer, Function0<List<Query<?>>>> getQueriesFuncs$runtime() {
            return this.queriesFuncs;
        }

        /* JADX INFO: renamed from: getSuccessful$runtime, reason: from getter */
        public final boolean getSuccessful() {
            return this.successful;
        }

        public final void setSuccessful$runtime(boolean z) {
            this.successful = z;
        }

        /* JADX INFO: renamed from: getChildrenSuccessful$runtime, reason: from getter */
        public final boolean getChildrenSuccessful() {
            return this.childrenSuccessful;
        }

        public final void setChildrenSuccessful$runtime(boolean z) {
            this.childrenSuccessful = z;
        }

        /* JADX INFO: renamed from: getTransacter$runtime, reason: from getter */
        public final Transacter getTransacter() {
            return this.transacter;
        }

        public final void setTransacter$runtime(Transacter transacter) {
            this.transacter = transacter;
        }

        public final Transaction enclosingTransaction$runtime() {
            return getEnclosingTransaction();
        }

        public final void endTransaction$runtime() {
            checkThreadConfinement$runtime();
            endTransaction(this.successful && this.childrenSuccessful);
        }

        @Override // com.squareup.sqldelight.TransactionCallbacks
        public void afterCommit(Function0<Unit> function) {
            Intrinsics.checkNotNullParameter(function, "function");
            checkThreadConfinement$runtime();
            this.postCommitHooks.add(function);
        }

        @Override // com.squareup.sqldelight.TransactionCallbacks
        public void afterRollback(Function0<Unit> function) {
            Intrinsics.checkNotNullParameter(function, "function");
            checkThreadConfinement$runtime();
            this.postRollbackHooks.add(function);
        }

        public final void checkThreadConfinement$runtime() {
            if (!(this.ownerThreadId == FunctionsJvmKt.currentThreadId())) {
                throw new IllegalStateException("Transaction objects (`TransactionWithReturn` and `TransactionWithoutReturn`) must be used\nonly within the transaction lambda scope.".toString());
            }
        }
    }
}
