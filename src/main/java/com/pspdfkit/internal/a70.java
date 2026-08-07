package com.pspdfkit.internal;

import com.box.android.common.utilities.BoxCommonConstants;
import com.pspdfkit.undo.OnAddNewEditListener;
import com.pspdfkit.undo.OnUndoHistoryChangeListener;
import com.pspdfkit.undo.UndoManager;
import com.pspdfkit.undo.edit.Edit;
import com.pspdfkit.undo.exceptions.RedoEditFailedException;
import com.pspdfkit.undo.exceptions.UndoEditFailedException;
import com.pspdfkit.utils.PdfLog;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import java.util.ArrayDeque;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.enums.EnumEntriesKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a70 implements UndoManager, at {
    public final z60 d;
    public OnAddNewEditListener f;
    public final go<OnUndoHistoryChangeListener> e = new go<>();
    public boolean g = true;
    public boolean h = true;
    public final Mutex i = MutexKt.Mutex$default(false, 1, null);
    public final int c = 100;
    public final ArrayDeque a = new ArrayDeque(101);
    public final ArrayDeque b = new ArrayDeque(101);

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.pspdfkit.internal.a70$a[], still in use, count: 1, list:
      (r0v1 com.pspdfkit.internal.a70$a[]) from 0x0024: INVOKE (r0v1 com.pspdfkit.internal.a70$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class a {
        NONE,
        ONLY_UNDO,
        UNDO_AND_REDO;

        static {
            EnumEntriesKt.enumEntries(aVarArr);
        }

        public a() {
            super(str, i);
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) d.clone();
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.undo.UndoManagerImpl", f = "UndoManagerImpl.kt", i = {0, 0, 1, 1, 1, 1, 1}, l = {293, BoxCommonConstants.REQUEST_DELETE_CURRENT_FOLDER}, m = "redo", n = {"$this$withLock_u24default$iv", "$i$f$withLock", "$this$withLock_u24default$iv", SemanticAttributes.FaasDocumentOperationValues.EDIT, "trace", "$i$f$withLock", "$i$a$-withLock$default-UndoManagerImpl$redo$2"}, nl = {BoxCommonConstants.REQUEST_OPEN_FILE, 223}, s = {"L$0", "I$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 2)
    public static final class b extends ContinuationImpl {
        public Mutex a;
        public Edit b;
        public ew.a c;
        public int d;
        public /* synthetic */ Object e;
        public int g;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return a70.this.redo(this);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.undo.UndoManagerImpl", f = "UndoManagerImpl.kt", i = {0, 0, 1, 1, 1, 1, 1}, l = {293, 191}, m = "undo", n = {"$this$withLock_u24default$iv", "$i$f$withLock", "$this$withLock_u24default$iv", SemanticAttributes.FaasDocumentOperationValues.EDIT, "trace", "$i$f$withLock", "$i$a$-withLock$default-UndoManagerImpl$undo$2"}, nl = {BoxCommonConstants.REQUEST_OPEN_FILE, 192}, s = {"L$0", "I$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 2)
    public static final class c extends ContinuationImpl {
        public Mutex a;
        public Edit b;
        public ew.a c;
        public int d;
        public /* synthetic */ Object e;
        public int g;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return a70.this.undo(this);
        }
    }

    public a70() {
        z60 z60Var = new z60();
        this.d = z60Var;
        ba baVar = new ba(z60Var);
        z60Var.a.put(baVar.a, baVar);
    }

    public final void a(a aVar) {
        this.g = aVar != a.NONE;
        this.h = aVar == a.UNDO_AND_REDO;
    }

    @Override // com.pspdfkit.undo.UndoManager
    public final void addOnUndoHistoryChangeListener(OnUndoHistoryChangeListener onUndoHistoryChangeListener) {
        onUndoHistoryChangeListener.getClass();
        this.e.a(onUndoHistoryChangeListener);
    }

    public final synchronized void b(Edit edit) {
        edit.getClass();
        OnAddNewEditListener onAddNewEditListener = this.f;
        if (onAddNewEditListener != null && !onAddNewEditListener.onAddNewEdit(edit)) {
            PdfLog.i("Nutri.UndoManagerImpl", "Refusing to add " + edit.getClass().getSimpleName() + " to the undo stack.", new Object[0]);
            return;
        }
        this.a.add(edit);
        PdfLog.d("Nutri.UndoManagerImpl", "Inserted Edit into the history stack. Edit = " + edit, new Object[0]);
        this.b.clear();
        PdfLog.d("Nutri.UndoManagerImpl", "Redo history has been discarded since new Edit was added.", new Object[0]);
        if (this.a.size() > this.c) {
            this.a.removeFirst();
            PdfLog.d("Nutri.UndoManagerImpl", "New Edit was added to the history stack, increasing the size of the stack over the max allowed value. The oldest Edit was discarded to make space.", new Object[0]);
        }
        Observable.fromIterable(this.e).observeOn(AndroidSchedulers.mainThread()).subscribe(new b70(this));
    }

    public final synchronized boolean c(Edit edit) {
        z60 z60Var;
        z60Var = this.d;
        z60Var.getClass();
        edit.getClass();
        return z60Var.a(edit.getClass()).b(edit);
    }

    @Override // com.pspdfkit.undo.UndoManager
    public final synchronized boolean canRedo() {
        if (this.h && !this.b.isEmpty()) {
            Object objPeekLast = this.b.peekLast();
            objPeekLast.getClass();
            if (c((Edit) objPeekLast)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.pspdfkit.undo.UndoManager
    public final synchronized boolean canUndo() {
        if (this.g && !this.a.isEmpty()) {
            Object objPeekLast = this.a.peekLast();
            objPeekLast.getClass();
            if (d((Edit) objPeekLast)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.pspdfkit.undo.UndoManager
    public final synchronized void clearHistory() {
        this.a.clear();
        this.b.clear();
        Observable.fromIterable(this.e).observeOn(AndroidSchedulers.mainThread()).subscribe(new b70(this));
    }

    public final synchronized boolean d(Edit edit) {
        z60 z60Var;
        z60Var = this.d;
        z60Var.getClass();
        edit.getClass();
        return z60Var.a(edit.getClass()).a(edit);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v2, types: [com.pspdfkit.internal.ew$a] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v4, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v6, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [kotlinx.coroutines.sync.Mutex] */
    @Override // com.pspdfkit.undo.UndoManager
    public final Object redo(Continuation<? super Unit> continuation) throws Throwable {
        b bVar;
        ?? aVar;
        int i;
        ew ewVar;
        RedoEditFailedException e;
        ?? r2;
        Edit edit;
        ?? r0;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i2 = bVar.g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                bVar.g = i2 - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        ?? r12 = bVar.e;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = bVar.g;
        try {
            try {
                try {
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(r12);
                        Mutex mutex = this.i;
                        bVar.a = mutex;
                        bVar.d = 0;
                        bVar.g = 1;
                        if (mutex.lock(null, bVar) != coroutine_suspended) {
                            i = 0;
                            r12 = mutex;
                        }
                        return coroutine_suspended;
                    }
                    if (i3 != 1) {
                        if (i3 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ew.a aVar2 = bVar.c;
                        edit = bVar.b;
                        Mutex mutex2 = bVar.a;
                        try {
                            ResultKt.throwOnFailure(r12);
                            r0 = aVar2;
                            r2 = mutex2;
                            this.a.add(edit);
                            Observable.fromIterable(this.e).observeOn(AndroidSchedulers.mainThread()).subscribe(new b70(this));
                            try {
                                r0.getClass();
                                Unit unit = Unit.INSTANCE;
                                r2.unlock(null);
                                return unit;
                            } catch (Throwable th) {
                                th = th;
                                r12 = r2;
                                r12.unlock(null);
                                throw th;
                            }
                        } catch (RedoEditFailedException e2) {
                            e = e2;
                            clearHistory();
                            throw e;
                        }
                    }
                    i = bVar.d;
                    Mutex mutex3 = bVar.a;
                    ResultKt.throwOnFailure(r12);
                    r12 = mutex3;
                    Edit edit2 = (Edit) this.b.peekLast();
                    if (edit2 == null) {
                        throw new RedoEditFailedException("There are no Edits scheduled for redo action.");
                    }
                    if (!c(edit2)) {
                        throw new RedoEditFailedException("Trying to invoke redo action on Edit that's not redoable. Edit = " + edit2);
                    }
                    this.b.removeLast();
                    PdfLog.d("Nutri.UndoManagerImpl", "Redoing edit: " + edit2, new Object[0]);
                    z60 z60Var = this.d;
                    z60Var.getClass();
                    y60 y60VarA = z60Var.a(edit2.getClass());
                    bVar.a = r12;
                    bVar.b = edit2;
                    bVar.c = aVar;
                    bVar.d = i;
                    bVar.g = 2;
                    if (y60VarA.a(edit2, bVar) != coroutine_suspended) {
                        r2 = r12;
                        edit = edit2;
                        r0 = aVar;
                        this.a.add(edit);
                        Observable.fromIterable(this.e).observeOn(AndroidSchedulers.mainThread()).subscribe(new b70(this));
                        r0.getClass();
                        Unit unit2 = Unit.INSTANCE;
                        r2.unlock(null);
                        return unit2;
                    }
                    return coroutine_suspended;
                } catch (RedoEditFailedException e3) {
                    e = e3;
                    clearHistory();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    aVar.getClass();
                    throw th;
                }
                synchronized (ar.class) {
                    if (ar.d == null) {
                        ar.d = new ew();
                    }
                    ewVar = ar.d;
                }
                ewVar.getClass();
                aVar = new ew.a(ewVar, "redo");
            } catch (Throwable th3) {
                th = th3;
                aVar = "Redoing edit: ";
            }
        } catch (Throwable th4) {
            th = th4;
            r12.unlock(null);
            throw th;
        }
    }

    @Override // com.pspdfkit.undo.UndoManager
    public final void removeOnUndoHistoryChangeListener(OnUndoHistoryChangeListener onUndoHistoryChangeListener) {
        onUndoHistoryChangeListener.getClass();
        this.e.b(onUndoHistoryChangeListener);
    }

    @Override // com.pspdfkit.undo.UndoManager
    public final void setOnAddNewEditListener(OnAddNewEditListener onAddNewEditListener) {
        this.f = onAddNewEditListener;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    @Override // com.pspdfkit.undo.UndoManager
    public final Object undo(Continuation<? super Unit> continuation) throws Throwable {
        c cVar;
        Mutex mutex;
        int i;
        ew ewVar;
        ew.a aVar;
        Mutex mutex2;
        UndoEditFailedException e;
        ew.a aVar2;
        Edit edit;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i2 = cVar.g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                cVar.g = i2 - Integer.MIN_VALUE;
            } else {
                cVar = new c(continuation);
            }
        } else {
            cVar = new c(continuation);
        }
        Object obj = cVar.e;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = cVar.g;
        try {
            try {
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = this.i;
                    cVar.a = mutex;
                    cVar.d = 0;
                    cVar.g = 1;
                    if (mutex.lock(null, cVar) != coroutine_suspended) {
                        i = 0;
                    }
                    return coroutine_suspended;
                }
                if (i3 != 1) {
                    if (i3 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar2 = cVar.c;
                    edit = cVar.b;
                    mutex2 = cVar.a;
                    try {
                        try {
                            ResultKt.throwOnFailure(obj);
                            this.b.add(edit);
                            Observable.fromIterable(this.e).observeOn(AndroidSchedulers.mainThread()).subscribe(new b70(this));
                            try {
                                aVar2.getClass();
                                Unit unit = Unit.INSTANCE;
                                mutex2.unlock(null);
                                return unit;
                            } catch (Throwable th) {
                                th = th;
                                mutex = mutex2;
                                mutex.unlock(null);
                                throw th;
                            }
                        } catch (UndoEditFailedException e2) {
                            e = e2;
                            clearHistory();
                            throw e;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        aVar = aVar2;
                        aVar.getClass();
                        throw th;
                    }
                }
                i = cVar.d;
                Mutex mutex3 = cVar.a;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                Edit edit2 = (Edit) this.a.peekLast();
                if (edit2 == null) {
                    throw new UndoEditFailedException("There are no Edits scheduled for undo action.");
                }
                if (!d(edit2)) {
                    throw new UndoEditFailedException("Trying to invoke undo action on Edit that's not undoable. Edit = " + edit2);
                }
                this.a.removeLast();
                PdfLog.d("Nutri.UndoManagerImpl", "Undoing edit: " + edit2, new Object[0]);
                z60 z60Var = this.d;
                z60Var.getClass();
                y60 y60VarA = z60Var.a(edit2.getClass());
                cVar.a = mutex;
                cVar.b = edit2;
                cVar.c = aVar;
                cVar.d = i;
                cVar.g = 2;
                if (y60VarA.b(edit2, cVar) != coroutine_suspended) {
                    mutex2 = mutex;
                    edit = edit2;
                    aVar2 = aVar;
                    this.b.add(edit);
                    Observable.fromIterable(this.e).observeOn(AndroidSchedulers.mainThread()).subscribe(new b70(this));
                    aVar2.getClass();
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return unit2;
                }
                return coroutine_suspended;
            } catch (UndoEditFailedException e3) {
                mutex2 = mutex;
                e = e3;
                aVar2 = aVar;
                clearHistory();
                throw e;
            } catch (Throwable th3) {
                th = th3;
                aVar.getClass();
                throw th;
            }
            synchronized (ar.class) {
                if (ar.d == null) {
                    ar.d = new ew();
                }
                ewVar = ar.d;
            }
            ewVar.getClass();
            aVar = new ew.a(ewVar, "undo");
        } catch (Throwable th4) {
            th = th4;
            mutex.unlock(null);
            throw th;
        }
    }

    public final synchronized void a(q7 q7Var) {
        z60 z60Var = this.d;
        z60Var.getClass();
        z60Var.a.put(q7Var.a, q7Var);
    }

    @Override // com.pspdfkit.internal.at
    public final void a(Edit edit) {
        edit.getClass();
        b(edit);
    }
}
