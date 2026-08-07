package androidx.datastore.core;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: SingleProcessDataStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001JD\u0010\u0002\u001a\u00028\u000021\u0010\u0003\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"androidx/datastore/core/SingleProcessDataStore$readAndInit$api$1", "Landroidx/datastore/core/InitializerApi;", "updateData", ViewProps.TRANSFORM, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "t", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SingleProcessDataStore$readAndInit$api$1<T> implements InitializerApi<T> {
    final /* synthetic */ Ref.ObjectRef<T> $initData;
    final /* synthetic */ Ref.BooleanRef $initializationComplete;
    final /* synthetic */ Mutex $updateLock;
    final /* synthetic */ SingleProcessDataStore<T> this$0;

    SingleProcessDataStore$readAndInit$api$1(Mutex mutex, Ref.BooleanRef booleanRef, Ref.ObjectRef<T> objectRef, SingleProcessDataStore<T> singleProcessDataStore) {
        this.$updateLock = mutex;
        this.$initializationComplete = booleanRef;
        this.$initData = objectRef;
        this.this$0 = singleProcessDataStore;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00b9 A[Catch: all -> 0x0057, TRY_LEAVE, TryCatch #0 {all -> 0x0057, blocks: (B:21:0x0053, B:35:0x00b1, B:37:0x00b9), top: B:52:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:42:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.datastore.core.InitializerApi
    public Object updateData(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) throws Throwable {
        SingleProcessDataStore$readAndInit$api$1$updateData$1 singleProcessDataStore$readAndInit$api$1$updateData$1;
        Mutex mutex;
        Ref.BooleanRef booleanRef;
        Ref.ObjectRef<T> objectRef;
        SingleProcessDataStore singleProcessDataStore;
        SingleProcessDataStore singleProcessDataStore2;
        Mutex mutex2;
        Mutex mutex3;
        Ref.ObjectRef<T> objectRef2;
        SingleProcessDataStore singleProcessDataStore3;
        T t;
        if (continuation instanceof SingleProcessDataStore$readAndInit$api$1$updateData$1) {
            singleProcessDataStore$readAndInit$api$1$updateData$1 = (SingleProcessDataStore$readAndInit$api$1$updateData$1) continuation;
            if ((singleProcessDataStore$readAndInit$api$1$updateData$1.label & Integer.MIN_VALUE) != 0) {
                singleProcessDataStore$readAndInit$api$1$updateData$1.label -= Integer.MIN_VALUE;
            } else {
                singleProcessDataStore$readAndInit$api$1$updateData$1 = new SingleProcessDataStore$readAndInit$api$1$updateData$1(this, continuation);
            }
        } else {
            singleProcessDataStore$readAndInit$api$1$updateData$1 = new SingleProcessDataStore$readAndInit$api$1$updateData$1(this, continuation);
        }
        Object obj = singleProcessDataStore$readAndInit$api$1$updateData$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = singleProcessDataStore$readAndInit$api$1$updateData$1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.$updateLock;
                booleanRef = this.$initializationComplete;
                objectRef = this.$initData;
                singleProcessDataStore = (SingleProcessDataStore<T>) this.this$0;
                singleProcessDataStore$readAndInit$api$1$updateData$1.L$0 = function2;
                singleProcessDataStore$readAndInit$api$1$updateData$1.L$1 = mutex;
                singleProcessDataStore$readAndInit$api$1$updateData$1.L$2 = booleanRef;
                singleProcessDataStore$readAndInit$api$1$updateData$1.L$3 = objectRef;
                singleProcessDataStore$readAndInit$api$1$updateData$1.L$4 = singleProcessDataStore;
                singleProcessDataStore$readAndInit$api$1$updateData$1.label = 1;
                if (mutex.lock(null, singleProcessDataStore$readAndInit$api$1$updateData$1) != coroutine_suspended) {
                }
                singleProcessDataStore2 = singleProcessDataStore;
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    t = (T) singleProcessDataStore$readAndInit$api$1$updateData$1.L$2;
                    objectRef2 = (Ref.ObjectRef) singleProcessDataStore$readAndInit$api$1$updateData$1.L$1;
                    mutex2 = (Mutex) singleProcessDataStore$readAndInit$api$1$updateData$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        objectRef2.element = t;
                        T t2 = objectRef2.element;
                        mutex2.unlock(null);
                        return t2;
                    } catch (Throwable th) {
                        th = th;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                SingleProcessDataStore singleProcessDataStore4 = (SingleProcessDataStore) singleProcessDataStore$readAndInit$api$1$updateData$1.L$2;
                objectRef2 = (Ref.ObjectRef) singleProcessDataStore$readAndInit$api$1$updateData$1.L$1;
                mutex3 = (Mutex) singleProcessDataStore$readAndInit$api$1$updateData$1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    singleProcessDataStore3 = singleProcessDataStore4;
                    if (!Intrinsics.areEqual(obj, objectRef2.element)) {
                        singleProcessDataStore$readAndInit$api$1$updateData$1.L$0 = mutex3;
                        singleProcessDataStore$readAndInit$api$1$updateData$1.L$1 = objectRef2;
                        singleProcessDataStore$readAndInit$api$1$updateData$1.L$2 = obj;
                        singleProcessDataStore$readAndInit$api$1$updateData$1.label = 3;
                        if (singleProcessDataStore3.writeData$datastore_core(obj, singleProcessDataStore$readAndInit$api$1$updateData$1) != coroutine_suspended) {
                            t = (T) obj;
                            mutex2 = mutex3;
                            objectRef2.element = t;
                        }
                        singleProcessDataStore2 = singleProcessDataStore;
                        return coroutine_suspended;
                    }
                    mutex2 = mutex3;
                    T t3 = objectRef2.element;
                    mutex2.unlock(null);
                    return t3;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2 = mutex3;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            SingleProcessDataStore singleProcessDataStore5 = (SingleProcessDataStore<T>) ((SingleProcessDataStore) singleProcessDataStore$readAndInit$api$1$updateData$1.L$4);
            Ref.ObjectRef<T> objectRef3 = (Ref.ObjectRef) singleProcessDataStore$readAndInit$api$1$updateData$1.L$3;
            booleanRef = (Ref.BooleanRef) singleProcessDataStore$readAndInit$api$1$updateData$1.L$2;
            Mutex mutex4 = (Mutex) singleProcessDataStore$readAndInit$api$1$updateData$1.L$1;
            Function2<? super T, ? super Continuation<? super T>, ? extends Object> function3 = (Function2) singleProcessDataStore$readAndInit$api$1$updateData$1.L$0;
            ResultKt.throwOnFailure(obj);
            objectRef = objectRef3;
            function2 = function3;
            mutex = mutex4;
            singleProcessDataStore2 = singleProcessDataStore5;
            singleProcessDataStore2 = singleProcessDataStore;
            if (booleanRef.element) {
                throw new IllegalStateException("InitializerApi.updateData should not be called after initialization is complete.");
            }
            T t4 = objectRef.element;
            singleProcessDataStore$readAndInit$api$1$updateData$1.L$0 = mutex;
            singleProcessDataStore$readAndInit$api$1$updateData$1.L$1 = objectRef;
            singleProcessDataStore$readAndInit$api$1$updateData$1.L$2 = singleProcessDataStore2;
            singleProcessDataStore$readAndInit$api$1$updateData$1.L$3 = null;
            singleProcessDataStore$readAndInit$api$1$updateData$1.L$4 = null;
            singleProcessDataStore$readAndInit$api$1$updateData$1.label = 2;
            Object objInvoke = function2.invoke(t4, singleProcessDataStore$readAndInit$api$1$updateData$1);
            if (objInvoke != coroutine_suspended) {
                mutex3 = mutex;
                obj = objInvoke;
                objectRef2 = objectRef;
                singleProcessDataStore3 = singleProcessDataStore2;
                if (!Intrinsics.areEqual(obj, objectRef2.element)) {
                    singleProcessDataStore$readAndInit$api$1$updateData$1.L$0 = mutex3;
                    singleProcessDataStore$readAndInit$api$1$updateData$1.L$1 = objectRef2;
                    singleProcessDataStore$readAndInit$api$1$updateData$1.L$2 = obj;
                    singleProcessDataStore$readAndInit$api$1$updateData$1.label = 3;
                    if (singleProcessDataStore3.writeData$datastore_core(obj, singleProcessDataStore$readAndInit$api$1$updateData$1) != coroutine_suspended) {
                        t = (T) obj;
                        mutex2 = mutex3;
                        objectRef2.element = t;
                    }
                } else {
                    mutex2 = mutex3;
                }
                T t5 = objectRef2.element;
                mutex2.unlock(null);
                return t5;
            }
            singleProcessDataStore2 = singleProcessDataStore;
            return coroutine_suspended;
        } catch (Throwable th3) {
            th = th3;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
    }
}
