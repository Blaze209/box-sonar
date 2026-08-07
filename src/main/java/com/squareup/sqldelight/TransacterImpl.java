package com.squareup.sqldelight;

import com.squareup.sqldelight.db.SqlDriver;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Transacter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0004J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0016\u0010\f\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000e0\rH\u0004J)\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n0\u0014¢\u0006\u0002\b\u0016H\u0016J:\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u0011\u001a\u00020\u00122\u001d\u0010\u0019\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u001a\u0012\u0004\u0012\u0002H\u00180\u0014¢\u0006\u0002\b\u0016H\u0016¢\u0006\u0002\u0010\u001bJ:\u0010\u001c\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u0011\u001a\u00020\u00122\u001d\u0010\u001d\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u001e\u0012\u0004\u0012\u0002H\u00180\u0014¢\u0006\u0002\b\u0016H\u0002¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/squareup/sqldelight/TransacterImpl;", "Lcom/squareup/sqldelight/Transacter;", "driver", "Lcom/squareup/sqldelight/db/SqlDriver;", "(Lcom/squareup/sqldelight/db/SqlDriver;)V", "createArguments", "", "count", "", "notifyQueries", "", "identifier", "queryList", "Lkotlin/Function0;", "", "Lcom/squareup/sqldelight/Query;", SemanticAttributes.MessagingRocketmqMessageTypeValues.TRANSACTION, "noEnclosing", "", "body", "Lkotlin/Function1;", "Lcom/squareup/sqldelight/TransactionWithoutReturn;", "Lkotlin/ExtensionFunctionType;", "transactionWithResult", "R", "bodyWithReturn", "Lcom/squareup/sqldelight/TransactionWithReturn;", "(ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "transactionWithWrapper", "wrapperBody", "Lcom/squareup/sqldelight/TransactionWrapper;", "runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class TransacterImpl implements Transacter {
    private final SqlDriver driver;

    public TransacterImpl(SqlDriver driver) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        this.driver = driver;
    }

    protected final void notifyQueries(int identifier, Function0<? extends List<? extends Query<?>>> queryList) {
        Intrinsics.checkNotNullParameter(queryList, "queryList");
        Transacter.Transaction transactionCurrentTransaction = this.driver.currentTransaction();
        if (transactionCurrentTransaction != null) {
            if (transactionCurrentTransaction.getQueriesFuncs$runtime().containsKey(Integer.valueOf(identifier))) {
                return;
            }
            transactionCurrentTransaction.getQueriesFuncs$runtime().put(Integer.valueOf(identifier), queryList);
        } else {
            Iterator<T> it = queryList.invoke().iterator();
            while (it.hasNext()) {
                ((Query) it.next()).notifyDataChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String createArguments(int count) {
        if (count == 0) {
            return "()";
        }
        StringBuilder sb = new StringBuilder(count + 2);
        sb.append("(?");
        int i = count - 1;
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(",?");
        }
        sb.append(')');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    @Override // com.squareup.sqldelight.Transacter
    public void transaction(boolean noEnclosing, Function1<? super TransactionWithoutReturn, Unit> body) throws Throwable {
        Intrinsics.checkNotNullParameter(body, "body");
        transactionWithWrapper(noEnclosing, body);
    }

    @Override // com.squareup.sqldelight.Transacter
    public <R> R transactionWithResult(boolean noEnclosing, Function1<? super TransactionWithReturn<R>, ? extends R> bodyWithReturn) {
        Intrinsics.checkNotNullParameter(bodyWithReturn, "bodyWithReturn");
        return (R) transactionWithWrapper(noEnclosing, bodyWithReturn);
    }

    private final <R> R transactionWithWrapper(boolean noEnclosing, Function1<? super TransactionWrapper<R>, ? extends R> wrapperBody) throws Throwable {
        Transacter.Transaction transactionNewTransaction = this.driver.newTransaction();
        Transacter.Transaction transactionEnclosingTransaction$runtime = transactionNewTransaction.enclosingTransaction$runtime();
        boolean z = false;
        if (!(transactionEnclosingTransaction$runtime == null || !noEnclosing)) {
            throw new IllegalStateException("Already in a transaction".toString());
        }
        try {
            transactionNewTransaction.setTransacter$runtime(this);
            R rInvoke = wrapperBody.invoke(new TransactionWrapper(transactionNewTransaction));
            transactionNewTransaction.setSuccessful$runtime(true);
            transactionNewTransaction.endTransaction$runtime();
            if (transactionEnclosingTransaction$runtime != null) {
                if (transactionNewTransaction.getSuccessful() && transactionNewTransaction.getChildrenSuccessful()) {
                    z = true;
                }
                transactionEnclosingTransaction$runtime.setChildrenSuccessful$runtime(z);
                transactionEnclosingTransaction$runtime.getPostCommitHooks$runtime().addAll(transactionNewTransaction.getPostCommitHooks$runtime());
                transactionEnclosingTransaction$runtime.getPostRollbackHooks$runtime().addAll(transactionNewTransaction.getPostRollbackHooks$runtime());
                transactionEnclosingTransaction$runtime.getQueriesFuncs$runtime().putAll(transactionNewTransaction.getQueriesFuncs$runtime());
                return rInvoke;
            }
            if (!transactionNewTransaction.getSuccessful() || !transactionNewTransaction.getChildrenSuccessful()) {
                try {
                    Iterator<T> it = transactionNewTransaction.getPostRollbackHooks$runtime().iterator();
                    while (it.hasNext()) {
                        ((Function0) it.next()).invoke();
                    }
                    transactionNewTransaction.getPostRollbackHooks$runtime().clear();
                    return rInvoke;
                } catch (Throwable th) {
                    throw th;
                }
            }
            Map<Integer, Function0<List<Query<?>>>> queriesFuncs$runtime = transactionNewTransaction.getQueriesFuncs$runtime();
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<Integer, Function0<List<Query<?>>>>> it2 = queriesFuncs$runtime.entrySet().iterator();
            while (it2.hasNext()) {
                CollectionsKt.addAll(arrayList, it2.next().getValue().invoke());
            }
            Iterator it3 = CollectionsKt.distinct(arrayList).iterator();
            while (it3.hasNext()) {
                ((Query) it3.next()).notifyDataChanged();
            }
            transactionNewTransaction.getQueriesFuncs$runtime().clear();
            Iterator<T> it4 = transactionNewTransaction.getPostCommitHooks$runtime().iterator();
            while (it4.hasNext()) {
                ((Function0) it4.next()).invoke();
            }
            transactionNewTransaction.getPostCommitHooks$runtime().clear();
            return rInvoke;
        } catch (Throwable th2) {
            transactionNewTransaction.endTransaction$runtime();
            if (transactionEnclosingTransaction$runtime != null) {
                if (transactionNewTransaction.getSuccessful() && transactionNewTransaction.getChildrenSuccessful()) {
                    z = true;
                }
                transactionEnclosingTransaction$runtime.setChildrenSuccessful$runtime(z);
                transactionEnclosingTransaction$runtime.getPostCommitHooks$runtime().addAll(transactionNewTransaction.getPostCommitHooks$runtime());
                transactionEnclosingTransaction$runtime.getPostRollbackHooks$runtime().addAll(transactionNewTransaction.getPostRollbackHooks$runtime());
                transactionEnclosingTransaction$runtime.getQueriesFuncs$runtime().putAll(transactionNewTransaction.getQueriesFuncs$runtime());
            } else if (transactionNewTransaction.getSuccessful() && transactionNewTransaction.getChildrenSuccessful()) {
                Map<Integer, Function0<List<Query<?>>>> queriesFuncs$runtime2 = transactionNewTransaction.getQueriesFuncs$runtime();
                ArrayList arrayList2 = new ArrayList();
                Iterator<Map.Entry<Integer, Function0<List<Query<?>>>>> it5 = queriesFuncs$runtime2.entrySet().iterator();
                while (it5.hasNext()) {
                    CollectionsKt.addAll(arrayList2, it5.next().getValue().invoke());
                }
                Iterator it6 = CollectionsKt.distinct(arrayList2).iterator();
                while (it6.hasNext()) {
                    ((Query) it6.next()).notifyDataChanged();
                }
                transactionNewTransaction.getQueriesFuncs$runtime().clear();
                Iterator<T> it7 = transactionNewTransaction.getPostCommitHooks$runtime().iterator();
                while (it7.hasNext()) {
                    ((Function0) it7.next()).invoke();
                }
                transactionNewTransaction.getPostCommitHooks$runtime().clear();
            } else {
                try {
                    Iterator<T> it8 = transactionNewTransaction.getPostRollbackHooks$runtime().iterator();
                    while (it8.hasNext()) {
                        ((Function0) it8.next()).invoke();
                    }
                    transactionNewTransaction.getPostRollbackHooks$runtime().clear();
                } catch (Throwable th3) {
                    throw new Throwable("Exception while rolling back from an exception.\nOriginal exception: " + th2 + "\nwith cause " + th2.getCause() + "\n\nRollback exception: " + th3, th3);
                }
            }
            if (transactionEnclosingTransaction$runtime == null && (th2 instanceof RollbackException)) {
                return (R) th2.getValue();
            }
            throw th2;
        }
    }
}
