package androidx.compose.runtime.snapshots;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.exifinterface.media.ExifInterface;
import com.box.android.observability.DiagnosisParams;
import com.box.androidsdk.content.requests.BoxRequestEvent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: SnapshotStateObserver.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001:\u0001<B0\u0012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\u0016\u0010\u0017\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0002J\u0010\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u001d\u0010#\u001a\u00020\u00052\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\bJ\u001d\u0010%\u001a\u00020\u00052\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00100\u0003H\u0082\bJ?\u0010,\u001a\u00020\u0005\"\b\b\u0000\u0010-*\u00020\u00012\u0006\u0010.\u001a\u0002H-2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u00100J\u0016\u00101\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007J\u000e\u00102\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0001J)\u00103\u001a\u00020\u00052!\u00104\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00100\u0003J\u0006\u00105\u001a\u00020\u0005J\u0006\u00106\u001a\u00020\u0005J\u001e\u00107\u001a\u00020\u00052\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u00109\u001a\u00020\u0014H\u0007J\u0006\u00102\u001a\u00020\u0005J&\u0010:\u001a\u00020\u001f\"\b\b\u0000\u0010-*\u00020\u00012\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00050\u0003H\u0002R/\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00060\u0001j\u0002`!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "callback", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "pendingChanges", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/internal/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "sendingNotifications", "", "applyObserver", "Lkotlin/Function2;", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "drainChanges", "sendNotifications", "addChanges", "set", "removeChanges", "report", "", "readObserver", "observedScopeMaps", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "observedScopeMapsLock", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "forEachScopeMap", "block", "removeScopeMapIf", "applyUnsubscribe", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "isPaused", "currentMap", "currentMapThreadId", "", "observeReads", ExifInterface.GPS_DIRECTION_TRUE, "scope", "onValueChangedForScope", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "withNoObservations", DiagnosisParams.CLEAR_ON_LOGOUT, "clearIf", IdentificationData.PREDICATE, "start", "stop", "notifyChanges", BoxRequestEvent.STREAM_TYPE_CHANGES, "snapshot", "ensureMap", "onChanged", "ObservedScopeMap", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnapshotStateObserver {
    public static final int $stable = 8;
    private ObserverHandle applyUnsubscribe;
    private ObservedScopeMap currentMap;
    private boolean isPaused;
    private final Function1<Function0<Unit>, Unit> onChangedExecutor;
    private boolean sendingNotifications;
    private final AtomicReference<Object> pendingChanges = new AtomicReference<>(null);
    private final Function2<Set<? extends Object>, Snapshot, Unit> applyObserver = new Function2() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SnapshotStateObserver.applyObserver$lambda$0(this.f$0, (Set) obj, (Snapshot) obj2);
        }
    };
    private final Function1<Object, Unit> readObserver = new Function1() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SnapshotStateObserver.readObserver$lambda$0(this.f$0, obj);
        }
    };
    private final MutableVector<ObservedScopeMap> observedScopeMaps = new MutableVector<>(new ObservedScopeMap[16], 0);
    private final Object observedScopeMapsLock = new Object();
    private long currentMapThreadId = -1;

    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateObserver(Function1<? super Function0<Unit>, Unit> function1) {
        this.onChangedExecutor = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyObserver$lambda$0(SnapshotStateObserver snapshotStateObserver, Set set, Snapshot snapshot) {
        snapshotStateObserver.addChanges(set);
        if (snapshotStateObserver.drainChanges()) {
            snapshotStateObserver.sendNotifications();
        }
        return Unit.INSTANCE;
    }

    private final boolean drainChanges() {
        boolean z;
        synchronized (this.observedScopeMapsLock) {
            z = this.sendingNotifications;
        }
        if (z) {
            return false;
        }
        boolean z2 = false;
        while (true) {
            Set<? extends Object> setRemoveChanges = removeChanges();
            if (setRemoveChanges == null) {
                return z2;
            }
            synchronized (this.observedScopeMapsLock) {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                ObservedScopeMap[] observedScopeMapArr = mutableVector.content;
                int size = mutableVector.getSize();
                for (int i = 0; i < size; i++) {
                    z2 = observedScopeMapArr[i].recordInvalidation(setRemoveChanges) || z2;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void sendNotifications() {
        this.onChangedExecutor.invoke(new Function0() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SnapshotStateObserver.sendNotifications$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendNotifications$lambda$0(SnapshotStateObserver snapshotStateObserver) {
        do {
            synchronized (snapshotStateObserver.observedScopeMapsLock) {
                if (!snapshotStateObserver.sendingNotifications) {
                    snapshotStateObserver.sendingNotifications = true;
                    try {
                        MutableVector<ObservedScopeMap> mutableVector = snapshotStateObserver.observedScopeMaps;
                        ObservedScopeMap[] observedScopeMapArr = mutableVector.content;
                        int size = mutableVector.getSize();
                        for (int i = 0; i < size; i++) {
                            observedScopeMapArr[i].notifyInvalidatedScopes();
                        }
                        snapshotStateObserver.sendingNotifications = false;
                    } catch (Throwable th) {
                        snapshotStateObserver.sendingNotifications = false;
                        throw th;
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        } while (snapshotStateObserver.drainChanges());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void addChanges(Set<? extends Object> set) {
        Object obj;
        List listPlus;
        do {
            obj = this.pendingChanges.get();
            if (obj == null) {
                listPlus = set;
            } else if (obj instanceof Set) {
                listPlus = CollectionsKt.listOf((Object[]) new Set[]{obj, set});
            } else {
                if (!(obj instanceof List)) {
                    report();
                    throw new KotlinNothingValueException();
                }
                listPlus = CollectionsKt.plus((Collection) obj, (Iterable) CollectionsKt.listOf(set));
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, obj, listPlus));
    }

    private final Set<Object> removeChanges() {
        Object obj;
        Object objSubList;
        Set<Object> set;
        do {
            obj = this.pendingChanges.get();
            objSubList = null;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Set) {
                set = (Set) obj;
            } else if (obj instanceof List) {
                List list = (List) obj;
                Set<Object> set2 = (Set) list.get(0);
                if (list.size() == 2) {
                    objSubList = list.get(1);
                } else if (list.size() > 2) {
                    objSubList = list.subList(1, list.size());
                }
                set = set2;
            } else {
                report();
                throw new KotlinNothingValueException();
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, obj, objSubList));
        return set;
    }

    private final Void report() {
        ComposerKt.composeRuntimeError("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit readObserver$lambda$0(SnapshotStateObserver snapshotStateObserver, Object obj) {
        if (!snapshotStateObserver.isPaused) {
            synchronized (snapshotStateObserver.observedScopeMapsLock) {
                ObservedScopeMap observedScopeMap = snapshotStateObserver.currentMap;
                Intrinsics.checkNotNull(observedScopeMap);
                observedScopeMap.recordRead(obj);
                Unit unit = Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    private final void forEachScopeMap(Function1<? super ObservedScopeMap, Unit> block) {
        synchronized (this.observedScopeMapsLock) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            ObservedScopeMap[] observedScopeMapArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                block.invoke(observedScopeMapArr[i]);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void removeScopeMapIf(Function1<? super ObservedScopeMap, Boolean> block) {
        synchronized (this.observedScopeMapsLock) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (block.invoke(mutableVector.content[i2]).booleanValue()) {
                    i++;
                } else if (i > 0) {
                    mutableVector.content[i2 - i] = mutableVector.content[i2];
                }
            }
            int i3 = size - i;
            ArraysKt.fill(mutableVector.content, (Object) null, i3, size);
            mutableVector.setSize(i3);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x012d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0141 A[Catch: all -> 0x01a3, TryCatch #2 {all -> 0x01a3, blocks: (B:31:0x0101, B:36:0x0116, B:37:0x0121, B:44:0x0134, B:47:0x0139, B:49:0x0141, B:51:0x0147), top: B:97:0x00c4 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0147 A[Catch: all -> 0x01a3, TRY_LEAVE, TryCatch #2 {all -> 0x01a3, blocks: (B:31:0x0101, B:36:0x0116, B:37:0x0121, B:44:0x0134, B:47:0x0139, B:49:0x0141, B:51:0x0147), top: B:97:0x00c4 }] */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void observeReads(T scope, Function1<? super T, Unit> onValueChangedForScope, Function0<Unit> block) {
        ObservedScopeMap observedScopeMapEnsureMap;
        long j;
        MutableVector<DerivedStateObserver> mutableVector;
        TransparentObserverMutableSnapshot transparentObserverMutableSnapshot;
        Snapshot snapshot;
        Snapshot snapshotMakeCurrent;
        synchronized (this.observedScopeMapsLock) {
            observedScopeMapEnsureMap = ensureMap(onValueChangedForScope);
        }
        boolean z = this.isPaused;
        ObservedScopeMap observedScopeMap = this.currentMap;
        long j2 = this.currentMapThreadId;
        if (j2 != -1) {
            if (!(j2 == Thread_jvmKt.currentThreadId())) {
                PreconditionsKt.throwIllegalArgumentException("Detected multithreaded access to SnapshotStateObserver: previousThreadId=" + j2 + "), currentThread={id=" + Thread_jvmKt.currentThreadId() + ", name=" + Thread_jvmKt.currentThreadName() + "}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
            }
        }
        try {
            this.isPaused = false;
            this.currentMap = observedScopeMapEnsureMap;
            this.currentMapThreadId = Thread_jvmKt.currentThreadId();
            Function1<Object, Unit> function1 = this.readObserver;
            Object obj = observedScopeMapEnsureMap.currentScope;
            MutableObjectIntMap mutableObjectIntMap = observedScopeMapEnsureMap.currentScopeReads;
            int i = observedScopeMapEnsureMap.currentToken;
            observedScopeMapEnsureMap.currentScope = scope;
            observedScopeMapEnsureMap.currentScopeReads = (MutableObjectIntMap) observedScopeMapEnsureMap.scopeToValues.get(scope);
            if (observedScopeMapEnsureMap.currentToken == -1) {
                observedScopeMapEnsureMap.currentToken = Long.hashCode(SnapshotKt.currentSnapshot().getSnapshotId());
            }
            DerivedStateObserver derivedStateObserver = observedScopeMapEnsureMap.getDerivedStateObserver();
            MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
            try {
                mutableVectorDerivedStateObservers.add(derivedStateObserver);
                Snapshot.Companion companion = Snapshot.INSTANCE;
                if (function1 == null) {
                    block.invoke();
                    j = j2;
                    mutableVector = mutableVectorDerivedStateObservers;
                } else {
                    Snapshot snapshot2 = (Snapshot) SnapshotKt.threadSnapshot.get();
                    try {
                        if (!(snapshot2 instanceof TransparentObserverMutableSnapshot)) {
                            j = j2;
                            if (snapshot2 != null) {
                                mutableVector = mutableVectorDerivedStateObservers;
                                transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot2 instanceof MutableSnapshot ? (MutableSnapshot) snapshot2 : null, function1, null, true, false);
                                snapshot = transparentObserverMutableSnapshot;
                                snapshotMakeCurrent = snapshot.makeCurrent();
                                block.invoke();
                                snapshot.restoreCurrent(snapshotMakeCurrent);
                                snapshot.dispose();
                            } else {
                                mutableVector = mutableVectorDerivedStateObservers;
                                transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot2 instanceof MutableSnapshot ? (MutableSnapshot) snapshot2 : null, function1, null, true, false);
                                snapshot = transparentObserverMutableSnapshot;
                                snapshotMakeCurrent = snapshot.makeCurrent();
                                block.invoke();
                                snapshot.restoreCurrent(snapshotMakeCurrent);
                                snapshot.dispose();
                            }
                            this.currentMap = observedScopeMap;
                            this.isPaused = z;
                            this.currentMapThreadId = j;
                            throw th;
                        }
                        try {
                            if (((TransparentObserverMutableSnapshot) snapshot2).getThreadId() == Thread_jvmKt.currentThreadId()) {
                                Function1<Object, Unit> readObserver = ((TransparentObserverMutableSnapshot) snapshot2).getReadObserver();
                                Function1<Object, Unit> writeObserver$runtime = ((TransparentObserverMutableSnapshot) snapshot2).getWriteObserver$runtime();
                                try {
                                    j = j2;
                                    try {
                                        ((TransparentObserverMutableSnapshot) snapshot2).setReadObserver$runtime(SnapshotKt.mergedReadObserver$default(function1, readObserver, false, 4, null));
                                        ((TransparentObserverMutableSnapshot) snapshot2).setWriteObserver$runtime(SnapshotKt.mergedWriteObserver(null, writeObserver$runtime));
                                        block.invoke();
                                        ((TransparentObserverMutableSnapshot) snapshot2).setReadObserver$runtime(readObserver);
                                        ((TransparentObserverMutableSnapshot) snapshot2).setWriteObserver$runtime(writeObserver$runtime);
                                        mutableVector = mutableVectorDerivedStateObservers;
                                    } catch (Throwable th) {
                                        th = th;
                                        ((TransparentObserverMutableSnapshot) snapshot2).setReadObserver$runtime(readObserver);
                                        ((TransparentObserverMutableSnapshot) snapshot2).setWriteObserver$runtime(writeObserver$runtime);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } else {
                                j = j2;
                                if (snapshot2 != null || (snapshot2 instanceof MutableSnapshot)) {
                                    mutableVector = mutableVectorDerivedStateObservers;
                                    try {
                                        transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot2 instanceof MutableSnapshot ? (MutableSnapshot) snapshot2 : null, function1, null, true, false);
                                    } catch (Throwable th3) {
                                        th = th3;
                                        j = j;
                                        try {
                                            mutableVector.removeAt(mutableVector.getSize() - 1);
                                            throw th;
                                        } catch (Throwable th4) {
                                            th = th4;
                                        }
                                    }
                                } else {
                                    transparentObserverMutableSnapshot = snapshot2.takeNestedSnapshot(function1);
                                    mutableVector = mutableVectorDerivedStateObservers;
                                }
                                snapshot = transparentObserverMutableSnapshot;
                                try {
                                    snapshotMakeCurrent = snapshot.makeCurrent();
                                    try {
                                        block.invoke();
                                        snapshot.restoreCurrent(snapshotMakeCurrent);
                                        snapshot.dispose();
                                    } catch (Throwable th5) {
                                        try {
                                            snapshot.restoreCurrent(snapshotMakeCurrent);
                                            throw th5;
                                        } catch (Throwable th6) {
                                            th = th6;
                                            try {
                                                snapshot.dispose();
                                                throw th;
                                            } catch (Throwable th7) {
                                                th = th7;
                                                mutableVector.removeAt(mutableVector.getSize() - 1);
                                                throw th;
                                            }
                                        }
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                }
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            j = j2;
                            mutableVector = mutableVectorDerivedStateObservers;
                            j = j;
                            mutableVector.removeAt(mutableVector.getSize() - 1);
                            throw th;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                    }
                }
                try {
                    mutableVector.removeAt(mutableVector.getSize() - 1);
                    Object obj2 = observedScopeMapEnsureMap.currentScope;
                    Intrinsics.checkNotNull(obj2);
                    observedScopeMapEnsureMap.clearObsoleteStateReads(obj2);
                    observedScopeMapEnsureMap.currentScope = obj;
                    observedScopeMapEnsureMap.currentScopeReads = mutableObjectIntMap;
                    observedScopeMapEnsureMap.currentToken = i;
                    this.currentMap = observedScopeMap;
                    this.isPaused = z;
                    this.currentMapThreadId = j;
                } catch (Throwable th11) {
                    th = th11;
                    j = j;
                }
            } catch (Throwable th12) {
                th = th12;
                j = j2;
                mutableVector = mutableVectorDerivedStateObservers;
            }
        } catch (Throwable th13) {
            th = th13;
            j = j2;
        }
    }

    @Deprecated(message = "Replace with Snapshot.withoutReadObservation()", replaceWith = @ReplaceWith(expression = "Snapshot.withoutReadObservation(block)", imports = {"androidx.compose.runtime.snapshots.Snapshot"}))
    public final void withNoObservations(Function0<Unit> block) {
        boolean z = this.isPaused;
        this.isPaused = true;
        try {
            block.invoke();
        } finally {
            this.isPaused = z;
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.INSTANCE.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    public final void notifyChanges(Set<? extends Object> changes, Snapshot snapshot) {
        this.applyObserver.invoke(changes, snapshot);
    }

    private final <T> ObservedScopeMap ensureMap(Function1<? super T, Unit> onChanged) {
        ObservedScopeMap observedScopeMap;
        MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
        ObservedScopeMap[] observedScopeMapArr = mutableVector.content;
        int size = mutableVector.getSize();
        int i = 0;
        while (true) {
            if (i >= size) {
                observedScopeMap = null;
                break;
            }
            observedScopeMap = observedScopeMapArr[i];
            if (observedScopeMap.getOnChanged() == onChanged) {
                break;
            }
            i++;
        }
        ObservedScopeMap observedScopeMap2 = observedScopeMap;
        if (observedScopeMap2 != null) {
            return observedScopeMap2;
        }
        Intrinsics.checkNotNull(onChanged, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
        ObservedScopeMap observedScopeMap3 = new ObservedScopeMap((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(onChanged, 1));
        this.observedScopeMaps.add(observedScopeMap3);
        return observedScopeMap3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SnapshotStateObserver.kt */
    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0001J.\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0002J7\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00012\u0014\b\b\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\b\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040.H\u0086\bJ\u0010\u0010/\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0001H\u0002J\u000e\u00100\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0001J)\u00101\u001a\u00020\u00042!\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u001d0\u0003J\u0006\u00105\u001a\u00020\u001dJ\u0018\u00106\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u0001H\u0002J\u0006\u00107\u001a\u00020\u0004J\u0014\u00108\u001a\u00020\u001d2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00010:J\u0012\u0010;\u001a\u00020\u00042\n\u0010<\u001a\u0006\u0012\u0002\b\u00030\u0017J\u0006\u0010=\u001a\u00020\u0004R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R \u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R6\u0010$\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010%j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0001`&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "", "onChanged", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "currentScope", "currentScopeReads", "Landroidx/collection/MutableObjectIntMap;", "currentToken", "", "valueToScopes", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/collection/MutableScatterMap;", "scopeToValues", "Landroidx/collection/MutableScatterMap;", "invalidated", "Landroidx/collection/MutableScatterSet;", "statesToReread", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/DerivedState;", "derivedStateObserver", "Landroidx/compose/runtime/DerivedStateObserver;", "getDerivedStateObserver", "()Landroidx/compose/runtime/DerivedStateObserver;", "readingDerivedStates", "", "getReadingDerivedStates", "()Z", "setReadingDerivedStates", "(Z)V", "deriveStateScopeCount", "dependencyToDerivedStates", "recordedDerivedStateValues", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "recordRead", "value", "recordedValues", "observe", "scope", "readObserver", "block", "Lkotlin/Function0;", "clearObsoleteStateReads", "clearScopeObservations", "removeScopeIf", IdentificationData.PREDICATE, "Lkotlin/ParameterName;", "name", "hasScopeObservations", "removeObservation", DiagnosisParams.CLEAR_ON_LOGOUT, "recordInvalidation", BoxRequestEvent.STREAM_TYPE_CHANGES, "", "rereadDerivedState", "derivedState", "notifyInvalidatedScopes", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    static final class ObservedScopeMap {
        private Object currentScope;
        private MutableObjectIntMap<Object> currentScopeReads;
        private int deriveStateScopeCount;
        private final MutableScatterSet<Object> invalidated;
        private final Function1<Object, Unit> onChanged;
        private boolean readingDerivedStates;
        private final MutableScatterMap<Object, MutableObjectIntMap<Object>> scopeToValues;
        private int currentToken = -1;
        private final MutableScatterMap<Object, Object> valueToScopes = ScopeMap.m6167constructorimpl$default(null, 1, null);
        private final MutableVector<DerivedState<?>> statesToReread = new MutableVector<>(new DerivedState[16], 0);
        private final DerivedStateObserver derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public void start(DerivedState<?> derivedState) {
                this.this$0.deriveStateScopeCount++;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public void done(DerivedState<?> derivedState) {
                this.this$0.deriveStateScopeCount--;
            }
        };
        private final MutableScatterMap<Object, Object> dependencyToDerivedStates = ScopeMap.m6167constructorimpl$default(null, 1, null);
        private final HashMap<DerivedState<?>, Object> recordedDerivedStateValues = new HashMap<>();

        public ObservedScopeMap(Function1<Object, Unit> function1) {
            this.onChanged = function1;
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i = 1;
            int i2 = 0;
            this.scopeToValues = new MutableScatterMap<>(i2, i, defaultConstructorMarker);
            this.invalidated = new MutableScatterSet<>(i2, i, defaultConstructorMarker);
        }

        public final Function1<Object, Unit> getOnChanged() {
            return this.onChanged;
        }

        public final DerivedStateObserver getDerivedStateObserver() {
            return this.derivedStateObserver;
        }

        public final boolean getReadingDerivedStates() {
            return this.readingDerivedStates;
        }

        public final void setReadingDerivedStates(boolean z) {
            this.readingDerivedStates = z;
        }

        public final void recordRead(Object value) {
            Object obj = this.currentScope;
            Intrinsics.checkNotNull(obj);
            int i = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
                this.currentScopeReads = mutableObjectIntMap;
                this.scopeToValues.set(obj, mutableObjectIntMap);
                Unit unit = Unit.INSTANCE;
            }
            recordRead(value, i, obj, mutableObjectIntMap);
        }

        private final void recordRead(Object value, int currentToken, Object currentScope, MutableObjectIntMap<Object> recordedValues) {
            int i;
            int i2;
            int i3;
            if (this.deriveStateScopeCount > 0) {
                return;
            }
            int iPut = recordedValues.put(value, currentToken, -1);
            int i4 = 2;
            if (!(value instanceof DerivedState) || iPut == currentToken) {
                i = 2;
                i2 = -1;
            } else {
                DerivedState.Record currentRecord = ((DerivedState) value).getCurrentRecord();
                this.recordedDerivedStateValues.put(value, currentRecord.getCurrentValue());
                ObjectIntMap<StateObject> dependencies = currentRecord.getDependencies();
                MutableScatterMap<Object, Object> mutableScatterMap = this.dependencyToDerivedStates;
                ScopeMap.m6176removeScopeimpl(mutableScatterMap, value);
                Object[] objArr = dependencies.keys;
                long[] jArr = dependencies.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i5 = 0;
                    while (true) {
                        long j = jArr[i5];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i6 = 8 - ((~(i5 - length)) >>> 31);
                            int i7 = 0;
                            while (i7 < i6) {
                                if ((j & 255) < 128) {
                                    i3 = i4;
                                    StateObject stateObject = (StateObject) objArr[(i5 << 3) + i7];
                                    if (stateObject instanceof StateObjectImpl) {
                                        ReaderKind.Companion companion = ReaderKind.INSTANCE;
                                        ((StateObjectImpl) stateObject).m6275recordReadInh_f27i8$runtime(ReaderKind.m6258constructorimpl(i3));
                                    }
                                    ScopeMap.m6161addimpl(mutableScatterMap, stateObject, value);
                                } else {
                                    i3 = i4;
                                }
                                j >>= 8;
                                i7++;
                                i4 = i3;
                            }
                            i = i4;
                            if (i6 != 8) {
                                break;
                            }
                        } else {
                            i = i4;
                        }
                        if (i5 == length) {
                            break;
                        }
                        i5++;
                        i4 = i;
                    }
                } else {
                    i = 2;
                }
                i2 = -1;
            }
            if (iPut == i2) {
                if (value instanceof StateObjectImpl) {
                    ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                    ((StateObjectImpl) value).m6275recordReadInh_f27i8$runtime(ReaderKind.m6258constructorimpl(i));
                }
                ScopeMap.m6161addimpl(this.valueToScopes, value, currentScope);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void observe(Object scope, Function1<Object, Unit> readObserver, Function0<Unit> block) {
            TransparentObserverMutableSnapshot transparentObserverMutableSnapshot;
            Object obj = this.currentScope;
            MutableObjectIntMap mutableObjectIntMap = this.currentScopeReads;
            int i = this.currentToken;
            this.currentScope = scope;
            this.currentScopeReads = (MutableObjectIntMap) this.scopeToValues.get(scope);
            if (this.currentToken == -1) {
                this.currentToken = Long.hashCode(SnapshotKt.currentSnapshot().getSnapshotId());
            }
            DerivedStateObserver derivedStateObserver = getDerivedStateObserver();
            MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
            try {
                mutableVectorDerivedStateObservers.add(derivedStateObserver);
                Snapshot.Companion companion = Snapshot.INSTANCE;
                if (readObserver != null) {
                    Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
                    if ((snapshot instanceof TransparentObserverMutableSnapshot) && ((TransparentObserverMutableSnapshot) snapshot).getThreadId() == Thread_jvmKt.currentThreadId()) {
                        Function1<Object, Unit> readObserver2 = ((TransparentObserverMutableSnapshot) snapshot).getReadObserver();
                        Function1<Object, Unit> writeObserver$runtime = ((TransparentObserverMutableSnapshot) snapshot).getWriteObserver$runtime();
                        try {
                            ((TransparentObserverMutableSnapshot) snapshot).setReadObserver$runtime(SnapshotKt.mergedReadObserver$default(readObserver, readObserver2, false, 4, null));
                            ((TransparentObserverMutableSnapshot) snapshot).setWriteObserver$runtime(SnapshotKt.mergedWriteObserver(null, writeObserver$runtime));
                            block.invoke();
                            ((TransparentObserverMutableSnapshot) snapshot).setReadObserver$runtime(readObserver2);
                            ((TransparentObserverMutableSnapshot) snapshot).setWriteObserver$runtime(writeObserver$runtime);
                        } catch (Throwable th) {
                            ((TransparentObserverMutableSnapshot) snapshot).setReadObserver$runtime(readObserver2);
                            ((TransparentObserverMutableSnapshot) snapshot).setWriteObserver$runtime(writeObserver$runtime);
                            throw th;
                        }
                    } else {
                        if (snapshot == null || (snapshot instanceof MutableSnapshot)) {
                            transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null, readObserver, null, true, false);
                        } else {
                            transparentObserverMutableSnapshot = snapshot.takeNestedSnapshot(readObserver);
                        }
                        try {
                            Snapshot snapshotMakeCurrent = transparentObserverMutableSnapshot.makeCurrent();
                            try {
                                block.invoke();
                                transparentObserverMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                                transparentObserverMutableSnapshot.dispose();
                            } catch (Throwable th2) {
                                transparentObserverMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                                throw th2;
                            }
                        } catch (Throwable th3) {
                            transparentObserverMutableSnapshot.dispose();
                            throw th3;
                        }
                    }
                } else {
                    block.invoke();
                }
                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                Object obj2 = this.currentScope;
                Intrinsics.checkNotNull(obj2);
                clearObsoleteStateReads(obj2);
                this.currentScope = obj;
                this.currentScopeReads = mutableObjectIntMap;
                this.currentToken = i;
            } catch (Throwable th4) {
                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                throw th4;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void clearObsoleteStateReads(Object scope) {
            int i = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                return;
            }
            long[] jArr = mutableObjectIntMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i2 << 3) + i4;
                            Object obj = mutableObjectIntMap.keys[i5];
                            boolean z = mutableObjectIntMap.values[i5] != i;
                            if (z) {
                                removeObservation(scope, obj);
                            }
                            if (z) {
                                mutableObjectIntMap.removeValueAt(i5);
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        return;
                    }
                }
                if (i2 == length) {
                    return;
                } else {
                    i2++;
                }
            }
        }

        public final void clearScopeObservations(Object scope) {
            MutableObjectIntMap<Object> mutableObjectIntMapRemove = this.scopeToValues.remove(scope);
            if (mutableObjectIntMapRemove == null) {
                return;
            }
            MutableObjectIntMap<Object> mutableObjectIntMap = mutableObjectIntMapRemove;
            Object[] objArr = mutableObjectIntMap.keys;
            int[] iArr = mutableObjectIntMap.values;
            long[] jArr = mutableObjectIntMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            Object obj = objArr[i4];
                            int i5 = iArr[i4];
                            removeObservation(scope, obj);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:27:0x00a2 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:28:0x00a4 A[LOOP:2: B:16:0x006b->B:28:0x00a4, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:29:0x00ad  */
        /* JADX WARN: Code duplicated, block: B:49:0x00b1 A[EDGE_INSN: B:49:0x00b1->B:30:0x00b1 BREAK  A[LOOP:2: B:16:0x006b->B:28:0x00a4], SYNTHETIC] */
        public final void removeScopeIf(Function1<Object, Boolean> predicate) {
            long[] jArr;
            long[] jArr2;
            long j;
            char c;
            long j2;
            int i;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> mutableScatterMap = this.scopeToValues;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length < 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                long j3 = jArr3[i2];
                char c2 = 7;
                long j4 = -9187201950435737472L;
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8;
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((j3 & 255) < 128) {
                            int i6 = (i2 << 3) + i5;
                            c = c2;
                            Object obj = mutableScatterMap.keys[i6];
                            j2 = j4;
                            MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) mutableScatterMap.values[i6];
                            Boolean boolInvoke = predicate.invoke(obj);
                            if (boolInvoke.booleanValue()) {
                                MutableObjectIntMap mutableObjectIntMap2 = mutableObjectIntMap;
                                Object[] objArr = mutableObjectIntMap2.keys;
                                int[] iArr = mutableObjectIntMap2.values;
                                long[] jArr4 = mutableObjectIntMap2.metadata;
                                int i7 = i3;
                                int length2 = jArr4.length - 2;
                                if (length2 >= 0) {
                                    jArr2 = jArr3;
                                    j = j3;
                                    int i8 = 0;
                                    while (true) {
                                        long j5 = jArr4[i8];
                                        long[] jArr5 = jArr4;
                                        if ((((~j5) << c) & j5 & j2) != j2) {
                                            int i9 = 8 - ((~(i8 - length2)) >>> 31);
                                            for (int i10 = 0; i10 < i9; i10++) {
                                                if ((j5 & 255) < 128) {
                                                    int i11 = (i8 << 3) + i10;
                                                    Object obj2 = objArr[i11];
                                                    int i12 = iArr[i11];
                                                    removeObservation(obj, obj2);
                                                }
                                                j5 >>= i7;
                                            }
                                            if (i9 != i7) {
                                                break;
                                            }
                                            if (i8 != length2) {
                                                break;
                                            }
                                            i8++;
                                            jArr4 = jArr5;
                                            i7 = 8;
                                        } else if (i8 != length2) {
                                            break;
                                            break;
                                        } else {
                                            i8++;
                                            jArr4 = jArr5;
                                            i7 = 8;
                                        }
                                    }
                                } else {
                                    jArr2 = jArr3;
                                    j = j3;
                                }
                            } else {
                                jArr2 = jArr3;
                                j = j3;
                            }
                            if (boolInvoke.booleanValue()) {
                                mutableScatterMap.removeValueAt(i6);
                            }
                            i = 8;
                        } else {
                            jArr2 = jArr3;
                            j = j3;
                            c = c2;
                            j2 = j4;
                            i = i3;
                        }
                        i5++;
                        i3 = i;
                        j3 = j >> i;
                        c2 = c;
                        j4 = j2;
                        jArr3 = jArr2;
                    }
                    jArr = jArr3;
                    if (i4 != i3) {
                        return;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i2 == length) {
                    return;
                }
                i2++;
                jArr3 = jArr;
            }
        }

        public final boolean hasScopeObservations() {
            return this.scopeToValues.isNotEmpty();
        }

        private final void removeObservation(Object scope, Object value) {
            ScopeMap.m6174removeimpl(this.valueToScopes, value, scope);
            if (!(value instanceof DerivedState) || ScopeMap.m6168containsimpl(this.valueToScopes, value)) {
                return;
            }
            ScopeMap.m6176removeScopeimpl(this.dependencyToDerivedStates, value);
            this.recordedDerivedStateValues.remove(value);
        }

        public final void clear() {
            ScopeMap.m6165clearimpl(this.valueToScopes);
            this.scopeToValues.clear();
            ScopeMap.m6165clearimpl(this.dependencyToDerivedStates);
            this.recordedDerivedStateValues.clear();
        }

        /* JADX WARN: Code duplicated, block: B:109:0x0263  */
        /* JADX WARN: Code duplicated, block: B:112:0x0275  */
        /* JADX WARN: Code duplicated, block: B:114:0x0279  */
        /* JADX WARN: Code duplicated, block: B:116:0x0286  */
        /* JADX WARN: Code duplicated, block: B:119:0x0294  */
        /* JADX WARN: Code duplicated, block: B:121:0x02a0  */
        /* JADX WARN: Code duplicated, block: B:123:0x02a6  */
        /* JADX WARN: Code duplicated, block: B:127:0x02ba A[DONT_INVERT, PHI: r21
          0x02ba: PHI (r21v34 boolean) = (r21v33 boolean), (r21v35 boolean) binds: [B:118:0x0292, B:126:0x02b8] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:128:0x02bc A[LOOP:6: B:117:0x0287->B:128:0x02bc, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:129:0x02c0  */
        /* JADX WARN: Code duplicated, block: B:149:0x034b  */
        /* JADX WARN: Code duplicated, block: B:151:0x034f  */
        /* JADX WARN: Code duplicated, block: B:153:0x0357  */
        /* JADX WARN: Code duplicated, block: B:156:0x0360 A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:158:0x0364 A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:160:0x0371  */
        /* JADX WARN: Code duplicated, block: B:163:0x037f A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:165:0x038b A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:167:0x0391 A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:169:0x03ae A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:172:0x03c6 A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:174:0x03cc A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:176:0x03d0 A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:178:0x03dd  */
        /* JADX WARN: Code duplicated, block: B:181:0x03f0 A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:183:0x03fc A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:185:0x0402 A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:186:0x0410  */
        /* JADX WARN: Code duplicated, block: B:18:0x007b  */
        /* JADX WARN: Code duplicated, block: B:190:0x041e A[DONT_INVERT, PHI: r26
          0x041e: PHI (r26v19 boolean) = (r26v18 boolean), (r26v20 boolean) binds: [B:180:0x03ee, B:189:0x041c] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:191:0x0420 A[Catch: all -> 0x0534, LOOP:14: B:179:0x03e0->B:191:0x0420, LOOP_END, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:192:0x0427 A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:193:0x0431  */
        /* JADX WARN: Code duplicated, block: B:195:0x0438 A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:196:0x0446  */
        /* JADX WARN: Code duplicated, block: B:200:0x0478  */
        /* JADX WARN: Code duplicated, block: B:201:0x0479  */
        /* JADX WARN: Code duplicated, block: B:203:0x0487 A[Catch: all -> 0x0534, LOOP:12: B:161:0x0372->B:203:0x0487, LOOP_END, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:204:0x0499 A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:206:0x04af A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:209:0x04c1 A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:211:0x04c7 A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:213:0x04cb A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:215:0x04d8  */
        /* JADX WARN: Code duplicated, block: B:218:0x04e5 A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:220:0x04f1 A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:222:0x04f7 A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:226:0x050b A[DONT_INVERT, PHI: r26
          0x050b: PHI (r26v8 boolean) = (r26v7 boolean), (r26v9 boolean) binds: [B:217:0x04e3, B:225:0x0509] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:227:0x050d A[Catch: all -> 0x0534, LOOP:18: B:216:0x04d9->B:227:0x050d, LOOP_END, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:228:0x0510 A[Catch: all -> 0x0534, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:229:0x0515 A[EDGE_INSN: B:325:0x0515->B:229:0x0515 BREAK  A[LOOP:18: B:216:0x04d9->B:227:0x050d], EDGE_INSN: B:326:0x0515->B:229:0x0515 BREAK  A[LOOP:18: B:216:0x04d9->B:227:0x050d], PHI: r26
          0x0515: PHI (r26v5 boolean) = (r26v1 boolean), (r26v1 boolean), (r26v8 boolean), (r26v9 boolean) binds: [B:210:0x04c5, B:214:0x04d6, B:326:0x0515, B:325:0x0515] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:231:0x051c A[Catch: all -> 0x0534, TRY_LEAVE, TryCatch #0 {all -> 0x0534, blocks: (B:154:0x035a, B:156:0x0360, B:158:0x0364, B:161:0x0372, B:163:0x037f, B:165:0x038b, B:167:0x0391, B:169:0x03ae, B:170:0x03b2, B:172:0x03c6, B:174:0x03cc, B:176:0x03d0, B:179:0x03e0, B:181:0x03f0, B:183:0x03fc, B:185:0x0402, B:187:0x0412, B:194:0x0435, B:197:0x0454, B:191:0x0420, B:192:0x0427, B:195:0x0438, B:203:0x0487, B:204:0x0499, B:206:0x04af, B:207:0x04b3, B:209:0x04c1, B:211:0x04c7, B:213:0x04cb, B:216:0x04d9, B:218:0x04e5, B:220:0x04f1, B:222:0x04f7, B:223:0x0501, B:227:0x050d, B:228:0x0510, B:230:0x0517, B:231:0x051c), top: B:275:0x035a }] */
        /* JADX WARN: Code duplicated, block: B:233:0x0526  */
        /* JADX WARN: Code duplicated, block: B:238:0x0539  */
        /* JADX WARN: Code duplicated, block: B:239:0x053b A[PHI: r40
          0x053b: PHI (r40v2 androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object>) = 
          (r40v1 androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object>)
          (r40v4 androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object>)
         binds: [B:150:0x034d, B:238:0x0539] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:242:0x054e  */
        /* JADX WARN: Code duplicated, block: B:244:0x0552  */
        /* JADX WARN: Code duplicated, block: B:246:0x055f  */
        /* JADX WARN: Code duplicated, block: B:249:0x056c  */
        /* JADX WARN: Code duplicated, block: B:251:0x0578  */
        /* JADX WARN: Code duplicated, block: B:253:0x057e  */
        /* JADX WARN: Code duplicated, block: B:258:0x0592  */
        /* JADX WARN: Code duplicated, block: B:260:0x0596 A[LOOP:16: B:247:0x0560->B:260:0x0596, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:261:0x0599  */
        /* JADX WARN: Code duplicated, block: B:262:0x05a0  */
        /* JADX WARN: Code duplicated, block: B:291:0x0164 A[EDGE_INSN: B:291:0x0164->B:63:0x0164 BREAK  A[LOOP:4: B:48:0x0113->B:60:0x014e], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:295:0x02c5 A[EDGE_INSN: B:295:0x02c5->B:130:0x02c5 BREAK  A[LOOP:6: B:117:0x0287->B:128:0x02bc], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:296:0x02c5 A[EDGE_INSN: B:296:0x02c5->B:130:0x02c5 BREAK  A[LOOP:6: B:117:0x0287->B:128:0x02bc], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:299:0x02b0 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:300:0x023f A[EDGE_INSN: B:300:0x023f->B:100:0x023f BREAK  A[LOOP:8: B:86:0x01f8->B:97:0x022f], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:309:0x0530 A[EDGE_INSN: B:309:0x0530->B:234:0x0530 BREAK  A[LOOP:12: B:161:0x0372->B:203:0x0487], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:310:0x0530 A[EDGE_INSN: B:310:0x0530->B:234:0x0530 BREAK  A[LOOP:12: B:161:0x0372->B:203:0x0487], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:315:0x0435 A[EDGE_INSN: B:315:0x0435->B:194:0x0435 BREAK  A[LOOP:14: B:179:0x03e0->B:191:0x0420], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:316:0x0435 A[EDGE_INSN: B:316:0x0435->B:194:0x0435 BREAK  A[LOOP:14: B:179:0x03e0->B:191:0x0420], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:320:0x05a2 A[EDGE_INSN: B:320:0x05a2->B:263:0x05a2 BREAK  A[LOOP:16: B:247:0x0560->B:260:0x0596], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:321:0x05a2 A[EDGE_INSN: B:321:0x05a2->B:263:0x05a2 BREAK  A[LOOP:16: B:247:0x0560->B:260:0x0596], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:324:0x0587 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:325:0x0515 A[EDGE_INSN: B:325:0x0515->B:229:0x0515 BREAK  A[LOOP:18: B:216:0x04d9->B:227:0x050d], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:326:0x0515 A[EDGE_INSN: B:326:0x0515->B:229:0x0515 BREAK  A[LOOP:18: B:216:0x04d9->B:227:0x050d], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:329:0x0501 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:59:0x014c A[DONT_INVERT, PHI: r21
          0x014c: PHI (r21v53 boolean) = (r21v52 boolean), (r21v54 boolean) binds: [B:49:0x0121, B:58:0x014a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:60:0x014e A[Catch: all -> 0x025e, LOOP:4: B:48:0x0113->B:60:0x014e, LOOP_END, TryCatch #1 {all -> 0x025e, blocks: (B:23:0x0088, B:25:0x008e, B:27:0x0092, B:30:0x00a8, B:32:0x00b6, B:34:0x00c0, B:36:0x00c6, B:38:0x00df, B:39:0x00e3, B:41:0x00f7, B:43:0x00fd, B:45:0x0101, B:48:0x0113, B:50:0x0123, B:52:0x012d, B:54:0x0133, B:56:0x0143, B:64:0x0166, B:67:0x0183, B:60:0x014e, B:61:0x0157, B:65:0x016b, B:73:0x01a6, B:74:0x01b4, B:76:0x01ce, B:77:0x01d2, B:79:0x01e0, B:81:0x01e6, B:83:0x01ea, B:86:0x01f8, B:88:0x0207, B:90:0x0213, B:92:0x0219, B:93:0x0223, B:100:0x023f, B:97:0x022f, B:98:0x0235, B:101:0x0242), top: B:277:0x0088 }] */
        /* JADX WARN: Code duplicated, block: B:62:0x0160  */
        /* JADX WARN: Code duplicated, block: B:96:0x022d A[DONT_INVERT, PHI: r21
          0x022d: PHI (r21v42 boolean) = (r21v41 boolean), (r21v43 boolean) binds: [B:87:0x0205, B:95:0x022b] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:97:0x022f A[Catch: all -> 0x025e, LOOP:8: B:86:0x01f8->B:97:0x022f, LOOP_END, TryCatch #1 {all -> 0x025e, blocks: (B:23:0x0088, B:25:0x008e, B:27:0x0092, B:30:0x00a8, B:32:0x00b6, B:34:0x00c0, B:36:0x00c6, B:38:0x00df, B:39:0x00e3, B:41:0x00f7, B:43:0x00fd, B:45:0x0101, B:48:0x0113, B:50:0x0123, B:52:0x012d, B:54:0x0133, B:56:0x0143, B:64:0x0166, B:67:0x0183, B:60:0x014e, B:61:0x0157, B:65:0x016b, B:73:0x01a6, B:74:0x01b4, B:76:0x01ce, B:77:0x01d2, B:79:0x01e0, B:81:0x01e6, B:83:0x01ea, B:86:0x01f8, B:88:0x0207, B:90:0x0213, B:92:0x0219, B:93:0x0223, B:100:0x023f, B:97:0x022f, B:98:0x0235, B:101:0x0242), top: B:277:0x0088 }] */
        /* JADX WARN: Code duplicated, block: B:99:0x023d  */
        public final boolean recordInvalidation(Set<? extends Object> changes) {
            boolean z;
            Iterator it;
            Object obj;
            String str;
            HashMap<DerivedState<?>, Object> map;
            int i;
            boolean z2;
            Object obj2;
            Object[] objArr;
            long[] jArr;
            int length;
            int i2;
            long j;
            int i3;
            int i4;
            MutableScatterMap<Object, Object> mutableScatterMap;
            Object obj3;
            DerivedState<?> derivedState;
            Object obj4;
            SnapshotMutationPolicy<?> policy;
            Object obj5;
            boolean z3;
            Object[] objArr2;
            long[] jArr2;
            int length2;
            int i5;
            long j2;
            int i6;
            int i7;
            Object[] objArr3;
            long[] jArr3;
            int length3;
            int i8;
            long j3;
            Object[] objArr4;
            long[] jArr4;
            int i9;
            int i10;
            Iterator it2;
            Object obj6;
            MutableScatterMap<Object, Object> mutableScatterMap2;
            long[] jArr5;
            String str2;
            long j4;
            HashMap<DerivedState<?>, Object> map2;
            DerivedState<?> derivedState2;
            Object obj7;
            SnapshotMutationPolicy<?> policy2;
            Object obj8;
            Object[] objArr5;
            long[] jArr6;
            int length4;
            int i11;
            long j5;
            long[] jArr7;
            int i12;
            int i13;
            long[] jArr8;
            MutableScatterMap<Object, Object> mutableScatterMap3;
            HashMap<DerivedState<?>, Object> map3;
            Object[] objArr6;
            long[] jArr9;
            MutableScatterMap<Object, Object> mutableScatterMap4;
            HashMap<DerivedState<?>, Object> map4;
            Object[] objArr7;
            int i14;
            long j6;
            int i15;
            Object obj9;
            Object[] objArr8;
            long[] jArr10;
            int length5;
            int i16;
            long j7;
            Object[] objArr9;
            int i17;
            int i18;
            MutableScatterMap<Object, Object> mutableScatterMap5;
            HashMap<DerivedState<?>, Object> map5;
            long j8;
            int i19;
            int i20;
            boolean z4;
            MutableScatterMap<Object, Object> mutableScatterMap6 = this.dependencyToDerivedStates;
            HashMap<DerivedState<?>, Object> map6 = this.recordedDerivedStateValues;
            MutableScatterMap<Object, Object> mutableScatterMap7 = this.valueToScopes;
            MutableScatterSet<Object> mutableScatterSet = this.invalidated;
            String str3 = "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>";
            int i21 = 8;
            if (changes instanceof ScatterSetWrapper) {
                ScatterSet set$runtime = ((ScatterSetWrapper) changes).getSet$runtime();
                Object[] objArr10 = set$runtime.elements;
                long[] jArr11 = set$runtime.metadata;
                int length6 = jArr11.length - 2;
                if (length6 >= 0) {
                    int i22 = 0;
                    z = false;
                    while (true) {
                        long j9 = jArr11[i22];
                        int i23 = length6;
                        if ((((~j9) << 7) & j9 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i24 = 8 - ((~(i22 - i23)) >>> 31);
                            int i25 = 0;
                            while (i25 < i24) {
                                if ((j9 & 255) < 128) {
                                    Object obj10 = objArr10[(i22 << 3) + i25];
                                    int i26 = i21;
                                    if (obj10 instanceof StateObjectImpl) {
                                        ReaderKind.Companion companion = ReaderKind.INSTANCE;
                                        if (((StateObjectImpl) obj10).m6274isReadInh_f27i8$runtime(ReaderKind.m6258constructorimpl(2))) {
                                            if (this.readingDerivedStates && ScopeMap.m6168containsimpl(mutableScatterMap6, obj10)) {
                                                this.readingDerivedStates = true;
                                                try {
                                                    Object obj11 = mutableScatterMap6.get(obj10);
                                                    if (obj11 != null) {
                                                        if (obj11 instanceof MutableScatterSet) {
                                                            MutableScatterSet mutableScatterSet2 = (MutableScatterSet) obj11;
                                                            Object[] objArr11 = mutableScatterSet2.elements;
                                                            long[] jArr12 = mutableScatterSet2.metadata;
                                                            jArr9 = jArr11;
                                                            int length7 = jArr12.length - 2;
                                                            if (length7 >= 0) {
                                                                objArr7 = objArr10;
                                                                int i27 = 0;
                                                                while (true) {
                                                                    long j10 = jArr12[i27];
                                                                    j6 = j9;
                                                                    if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                        int i28 = 8 - ((~(i27 - length7)) >>> 31);
                                                                        int i29 = 0;
                                                                        while (i29 < i28) {
                                                                            if ((j10 & 255) < 128) {
                                                                                j8 = j10;
                                                                                DerivedState<?> derivedState3 = (DerivedState) objArr11[(i27 << 3) + i29];
                                                                                Intrinsics.checkNotNull(derivedState3, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
                                                                                Object obj12 = map6.get(derivedState3);
                                                                                SnapshotMutationPolicy<?> policy3 = derivedState3.getPolicy();
                                                                                if (policy3 == null) {
                                                                                    policy3 = SnapshotStateKt.structuralEqualityPolicy();
                                                                                }
                                                                                i19 = i25;
                                                                                i20 = i29;
                                                                                if (policy3.equivalent(derivedState3.getCurrentRecord().getCurrentValue(), obj12)) {
                                                                                    mutableScatterMap5 = mutableScatterMap6;
                                                                                    map5 = map6;
                                                                                    Boolean.valueOf(this.statesToReread.add(derivedState3));
                                                                                } else {
                                                                                    Object obj13 = mutableScatterMap7.get(derivedState3);
                                                                                    if (obj13 == null) {
                                                                                        mutableScatterMap5 = mutableScatterMap6;
                                                                                        map5 = map6;
                                                                                        z4 = z;
                                                                                    } else if (obj13 instanceof MutableScatterSet) {
                                                                                        MutableScatterSet mutableScatterSet3 = (MutableScatterSet) obj13;
                                                                                        Object[] objArr12 = mutableScatterSet3.elements;
                                                                                        long[] jArr13 = mutableScatterSet3.metadata;
                                                                                        int length8 = jArr13.length - 2;
                                                                                        if (length8 >= 0) {
                                                                                            int i30 = 0;
                                                                                            while (true) {
                                                                                                long j11 = jArr13[i30];
                                                                                                mutableScatterMap5 = mutableScatterMap6;
                                                                                                map5 = map6;
                                                                                                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) == -9187201950435737472L) {
                                                                                                    if (i30 != length8) {
                                                                                                        break;
                                                                                                        break;
                                                                                                    }
                                                                                                    i30++;
                                                                                                    mutableScatterMap6 = mutableScatterMap5;
                                                                                                    map6 = map5;
                                                                                                    i26 = 8;
                                                                                                } else {
                                                                                                    int i31 = 8 - ((~(i30 - length8)) >>> 31);
                                                                                                    for (int i32 = 0; i32 < i31; i32++) {
                                                                                                        if ((j11 & 255) < 128) {
                                                                                                            mutableScatterSet.add(objArr12[(i30 << 3) + i32]);
                                                                                                            z = true;
                                                                                                        }
                                                                                                        j11 >>= i26;
                                                                                                    }
                                                                                                    if (i31 != i26) {
                                                                                                        break;
                                                                                                    }
                                                                                                    if (i30 != length8) {
                                                                                                        break;
                                                                                                    }
                                                                                                    i30++;
                                                                                                    mutableScatterMap6 = mutableScatterMap5;
                                                                                                    map6 = map5;
                                                                                                    i26 = 8;
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            mutableScatterMap5 = mutableScatterMap6;
                                                                                            map5 = map6;
                                                                                        }
                                                                                        z4 = z;
                                                                                    } else {
                                                                                        mutableScatterMap5 = mutableScatterMap6;
                                                                                        map5 = map6;
                                                                                        mutableScatterSet.add(obj13);
                                                                                        z4 = true;
                                                                                    }
                                                                                    Unit unit = Unit.INSTANCE;
                                                                                    z = z4;
                                                                                }
                                                                            } else {
                                                                                mutableScatterMap5 = mutableScatterMap6;
                                                                                map5 = map6;
                                                                                j8 = j10;
                                                                                i19 = i25;
                                                                                i20 = i29;
                                                                            }
                                                                            j10 = j8 >> 8;
                                                                            i29 = i20 + 1;
                                                                            i26 = 8;
                                                                            i25 = i19;
                                                                            mutableScatterMap6 = mutableScatterMap5;
                                                                            map6 = map5;
                                                                        }
                                                                        mutableScatterMap4 = mutableScatterMap6;
                                                                        map4 = map6;
                                                                        i14 = i25;
                                                                        if (i28 != i26) {
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        mutableScatterMap4 = mutableScatterMap6;
                                                                        map4 = map6;
                                                                        i14 = i25;
                                                                    }
                                                                    if (i27 == length7) {
                                                                        break;
                                                                    }
                                                                    i27++;
                                                                    j9 = j6;
                                                                    i25 = i14;
                                                                    mutableScatterMap6 = mutableScatterMap4;
                                                                    map6 = map4;
                                                                    i26 = 8;
                                                                }
                                                            }
                                                        } else {
                                                            jArr9 = jArr11;
                                                            mutableScatterMap4 = mutableScatterMap6;
                                                            objArr7 = objArr10;
                                                            i14 = i25;
                                                            j6 = j9;
                                                            DerivedState<?> derivedState4 = (DerivedState) obj11;
                                                            HashMap<DerivedState<?>, Object> map7 = map6;
                                                            Object obj14 = map7.get(derivedState4);
                                                            SnapshotMutationPolicy<?> policy4 = derivedState4.getPolicy();
                                                            if (policy4 == null) {
                                                                policy4 = SnapshotStateKt.structuralEqualityPolicy();
                                                            }
                                                            if (policy4.equivalent(derivedState4.getCurrentRecord().getCurrentValue(), obj14)) {
                                                                map4 = map7;
                                                                Boolean.valueOf(this.statesToReread.add(derivedState4));
                                                            } else {
                                                                Object obj15 = mutableScatterMap7.get(derivedState4);
                                                                if (obj15 == null) {
                                                                    map4 = map7;
                                                                } else if (obj15 instanceof MutableScatterSet) {
                                                                    MutableScatterSet mutableScatterSet4 = (MutableScatterSet) obj15;
                                                                    Object[] objArr13 = mutableScatterSet4.elements;
                                                                    long[] jArr14 = mutableScatterSet4.metadata;
                                                                    int length9 = jArr14.length - 2;
                                                                    if (length9 >= 0) {
                                                                        int i33 = 0;
                                                                        while (true) {
                                                                            long j12 = jArr14[i33];
                                                                            map4 = map7;
                                                                            Object[] objArr14 = objArr13;
                                                                            if ((((~j12) << 7) & j12 & (-9187201950435737472L)) == -9187201950435737472L) {
                                                                                if (i33 != length9) {
                                                                                    break;
                                                                                    break;
                                                                                }
                                                                                i33++;
                                                                                objArr13 = objArr14;
                                                                                map7 = map4;
                                                                            } else {
                                                                                int i34 = 8 - ((~(i33 - length9)) >>> 31);
                                                                                for (int i35 = 0; i35 < i34; i35++) {
                                                                                    if ((j12 & 255) < 128) {
                                                                                        mutableScatterSet.add(objArr14[(i33 << 3) + i35]);
                                                                                        z = true;
                                                                                    }
                                                                                    j12 >>= 8;
                                                                                }
                                                                                if (i34 != 8) {
                                                                                    break;
                                                                                }
                                                                                if (i33 != length9) {
                                                                                    break;
                                                                                }
                                                                                i33++;
                                                                                objArr13 = objArr14;
                                                                                map7 = map4;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        map4 = map7;
                                                                    }
                                                                } else {
                                                                    map4 = map7;
                                                                    mutableScatterSet.add(obj15);
                                                                    z = true;
                                                                }
                                                                Unit unit2 = Unit.INSTANCE;
                                                            }
                                                        }
                                                        this.readingDerivedStates = false;
                                                    } else {
                                                        jArr9 = jArr11;
                                                    }
                                                    mutableScatterMap4 = mutableScatterMap6;
                                                    map4 = map6;
                                                    objArr7 = objArr10;
                                                    i14 = i25;
                                                    j6 = j9;
                                                    this.readingDerivedStates = false;
                                                } catch (Throwable th) {
                                                    this.readingDerivedStates = false;
                                                    throw th;
                                                }
                                            } else {
                                                jArr9 = jArr11;
                                                mutableScatterMap4 = mutableScatterMap6;
                                                map4 = map6;
                                                objArr7 = objArr10;
                                                i14 = i25;
                                                j6 = j9;
                                            }
                                            obj9 = mutableScatterMap7.get(obj10);
                                            if (obj9 != null) {
                                                if (obj9 instanceof MutableScatterSet) {
                                                    MutableScatterSet mutableScatterSet5 = (MutableScatterSet) obj9;
                                                    objArr8 = mutableScatterSet5.elements;
                                                    jArr10 = mutableScatterSet5.metadata;
                                                    length5 = jArr10.length - 2;
                                                    if (length5 >= 0) {
                                                        i16 = 0;
                                                        while (true) {
                                                            j7 = jArr10[i16];
                                                            objArr9 = objArr8;
                                                            if ((((~j7) << 7) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                if (i16 != length5) {
                                                                    break;
                                                                    break;
                                                                }
                                                                i16++;
                                                                objArr8 = objArr9;
                                                            } else {
                                                                i17 = 8 - ((~(i16 - length5)) >>> 31);
                                                                for (i18 = 0; i18 < i17; i18++) {
                                                                    if ((j7 & 255) < 128) {
                                                                        mutableScatterSet.add(objArr9[(i16 << 3) + i18]);
                                                                        z = true;
                                                                    }
                                                                    j7 >>= 8;
                                                                }
                                                                if (i17 == 8) {
                                                                    break;
                                                                }
                                                                if (i16 != length5) {
                                                                    break;
                                                                }
                                                                i16++;
                                                                objArr8 = objArr9;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    mutableScatterSet.add(obj9);
                                                    z = true;
                                                }
                                            }
                                        } else {
                                            jArr9 = jArr11;
                                            mutableScatterMap4 = mutableScatterMap6;
                                            map4 = map6;
                                            objArr7 = objArr10;
                                            i14 = i25;
                                            j6 = j9;
                                        }
                                    } else {
                                        if (this.readingDerivedStates) {
                                            jArr9 = jArr11;
                                            mutableScatterMap4 = mutableScatterMap6;
                                            map4 = map6;
                                            objArr7 = objArr10;
                                            i14 = i25;
                                            j6 = j9;
                                        } else {
                                            jArr9 = jArr11;
                                            mutableScatterMap4 = mutableScatterMap6;
                                            map4 = map6;
                                            objArr7 = objArr10;
                                            i14 = i25;
                                            j6 = j9;
                                        }
                                        obj9 = mutableScatterMap7.get(obj10);
                                        if (obj9 != null) {
                                            if (obj9 instanceof MutableScatterSet) {
                                                MutableScatterSet mutableScatterSet6 = (MutableScatterSet) obj9;
                                                objArr8 = mutableScatterSet6.elements;
                                                jArr10 = mutableScatterSet6.metadata;
                                                length5 = jArr10.length - 2;
                                                if (length5 >= 0) {
                                                    i16 = 0;
                                                    while (true) {
                                                        j7 = jArr10[i16];
                                                        objArr9 = objArr8;
                                                        if ((((~j7) << 7) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                            if (i16 != length5) {
                                                                break;
                                                                break;
                                                            }
                                                            i16++;
                                                            objArr8 = objArr9;
                                                        } else {
                                                            i17 = 8 - ((~(i16 - length5)) >>> 31);
                                                            while (i18 < i17) {
                                                                if ((j7 & 255) < 128) {
                                                                    mutableScatterSet.add(objArr9[(i16 << 3) + i18]);
                                                                    z = true;
                                                                }
                                                                j7 >>= 8;
                                                            }
                                                            if (i17 == 8) {
                                                                break;
                                                                break;
                                                            }
                                                            if (i16 != length5) {
                                                                break;
                                                                break;
                                                            }
                                                            i16++;
                                                            objArr8 = objArr9;
                                                        }
                                                    }
                                                }
                                            } else {
                                                mutableScatterSet.add(obj9);
                                                z = true;
                                            }
                                        }
                                    }
                                    i15 = 8;
                                } else {
                                    jArr9 = jArr11;
                                    mutableScatterMap4 = mutableScatterMap6;
                                    map4 = map6;
                                    objArr7 = objArr10;
                                    i14 = i25;
                                    j6 = j9;
                                    i15 = i21;
                                }
                                j9 = j6 >> i15;
                                i25 = i14 + 1;
                                i21 = i15;
                                jArr11 = jArr9;
                                objArr10 = objArr7;
                                mutableScatterMap6 = mutableScatterMap4;
                                map6 = map4;
                            }
                            jArr8 = jArr11;
                            mutableScatterMap3 = mutableScatterMap6;
                            map3 = map6;
                            objArr6 = objArr10;
                            if (i24 != i21) {
                                break;
                            }
                        } else {
                            jArr8 = jArr11;
                            mutableScatterMap3 = mutableScatterMap6;
                            map3 = map6;
                            objArr6 = objArr10;
                        }
                        length6 = i23;
                        if (i22 == length6) {
                            break;
                        }
                        i22++;
                        jArr11 = jArr8;
                        objArr10 = objArr6;
                        mutableScatterMap6 = mutableScatterMap3;
                        map6 = map3;
                        i21 = 8;
                    }
                } else {
                    z = false;
                }
            } else {
                MutableScatterMap<Object, Object> mutableScatterMap8 = mutableScatterMap6;
                HashMap<DerivedState<?>, Object> map8 = map6;
                Iterator it3 = changes.iterator();
                boolean z5 = false;
                while (it3.hasNext()) {
                    Object next = it3.next();
                    if (next instanceof StateObjectImpl) {
                        ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                        if (((StateObjectImpl) next).m6274isReadInh_f27i8$runtime(ReaderKind.m6258constructorimpl(2))) {
                            if (this.readingDerivedStates) {
                                it = it3;
                                obj = next;
                                str = str3;
                                map = map8;
                                i = 0;
                            } else {
                                mutableScatterMap = mutableScatterMap8;
                                if (ScopeMap.m6168containsimpl(mutableScatterMap, next)) {
                                    this.readingDerivedStates = true;
                                    try {
                                        obj3 = mutableScatterMap.get(next);
                                        if (obj3 == null) {
                                            it = it3;
                                            obj = next;
                                            mutableScatterMap8 = mutableScatterMap;
                                            str = str3;
                                            map = map8;
                                        } else if (obj3 instanceof MutableScatterSet) {
                                            MutableScatterSet mutableScatterSet7 = (MutableScatterSet) obj3;
                                            objArr3 = mutableScatterSet7.elements;
                                            jArr3 = mutableScatterSet7.metadata;
                                            length3 = jArr3.length - 2;
                                            if (length3 >= 0) {
                                                i8 = 0;
                                                while (true) {
                                                    j3 = jArr3[i8];
                                                    objArr4 = objArr3;
                                                    if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                        i9 = 8 - ((~(i8 - length3)) >>> 31);
                                                        i10 = 0;
                                                        while (i10 < i9) {
                                                            if ((j3 & 255) < 128) {
                                                                derivedState2 = (DerivedState) objArr4[(i8 << 3) + i10];
                                                                Intrinsics.checkNotNull(derivedState2, str3);
                                                                it2 = it3;
                                                                mutableScatterMap2 = mutableScatterMap;
                                                                map2 = map8;
                                                                obj7 = map2.get(derivedState2);
                                                                policy2 = derivedState2.getPolicy();
                                                                if (policy2 == null) {
                                                                    policy2 = SnapshotStateKt.structuralEqualityPolicy();
                                                                }
                                                                jArr5 = jArr3;
                                                                str2 = str3;
                                                                if (policy2.equivalent(derivedState2.getCurrentRecord().getCurrentValue(), obj7)) {
                                                                    obj6 = next;
                                                                    j4 = j3;
                                                                    Boolean.valueOf(this.statesToReread.add(derivedState2));
                                                                } else {
                                                                    obj8 = mutableScatterMap7.get(derivedState2);
                                                                    if (obj8 == null) {
                                                                        obj6 = next;
                                                                        j4 = j3;
                                                                    } else if (obj8 instanceof MutableScatterSet) {
                                                                        MutableScatterSet mutableScatterSet8 = (MutableScatterSet) obj8;
                                                                        objArr5 = mutableScatterSet8.elements;
                                                                        jArr6 = mutableScatterSet8.metadata;
                                                                        length4 = jArr6.length - 2;
                                                                        if (length4 >= 0) {
                                                                            j4 = j3;
                                                                            i11 = 0;
                                                                            while (true) {
                                                                                j5 = jArr6[i11];
                                                                                obj6 = next;
                                                                                jArr7 = jArr6;
                                                                                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                                    if (i11 != length4) {
                                                                                        break;
                                                                                        break;
                                                                                    }
                                                                                    i11++;
                                                                                    next = obj6;
                                                                                    jArr6 = jArr7;
                                                                                } else {
                                                                                    i12 = 8 - ((~(i11 - length4)) >>> 31);
                                                                                    for (i13 = 0; i13 < i12; i13++) {
                                                                                        if ((j5 & 255) < 128) {
                                                                                            mutableScatterSet.add(objArr5[(i11 << 3) + i13]);
                                                                                            z5 = true;
                                                                                        }
                                                                                        j5 >>= 8;
                                                                                    }
                                                                                    if (i12 == 8) {
                                                                                        break;
                                                                                    }
                                                                                    if (i11 != length4) {
                                                                                        break;
                                                                                    }
                                                                                    i11++;
                                                                                    next = obj6;
                                                                                    jArr6 = jArr7;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            obj6 = next;
                                                                            j4 = j3;
                                                                        }
                                                                    } else {
                                                                        obj6 = next;
                                                                        j4 = j3;
                                                                        mutableScatterSet.add(obj8);
                                                                        z5 = true;
                                                                    }
                                                                    Unit unit3 = Unit.INSTANCE;
                                                                }
                                                            } else {
                                                                it2 = it3;
                                                                obj6 = next;
                                                                mutableScatterMap2 = mutableScatterMap;
                                                                jArr5 = jArr3;
                                                                str2 = str3;
                                                                j4 = j3;
                                                                map2 = map8;
                                                            }
                                                            j3 = j4 >> 8;
                                                            i10++;
                                                            map8 = map2;
                                                            next = obj6;
                                                            jArr3 = jArr5;
                                                            str3 = str2;
                                                            mutableScatterMap = mutableScatterMap2;
                                                            it3 = it2;
                                                        }
                                                        it = it3;
                                                        obj = next;
                                                        mutableScatterMap8 = mutableScatterMap;
                                                        jArr4 = jArr3;
                                                        str = str3;
                                                        map = map8;
                                                        if (i9 == 8) {
                                                            break;
                                                        }
                                                    } else {
                                                        it = it3;
                                                        obj = next;
                                                        mutableScatterMap8 = mutableScatterMap;
                                                        jArr4 = jArr3;
                                                        str = str3;
                                                        map = map8;
                                                    }
                                                    if (i8 != length3) {
                                                        break;
                                                    }
                                                    i8++;
                                                    map8 = map;
                                                    objArr3 = objArr4;
                                                    next = obj;
                                                    jArr3 = jArr4;
                                                    str3 = str;
                                                    mutableScatterMap = mutableScatterMap8;
                                                    it3 = it;
                                                }
                                            } else {
                                                it = it3;
                                                obj = next;
                                                mutableScatterMap8 = mutableScatterMap;
                                                str = str3;
                                                map = map8;
                                            }
                                        } else {
                                            it = it3;
                                            obj = next;
                                            mutableScatterMap8 = mutableScatterMap;
                                            str = str3;
                                            map = map8;
                                            derivedState = (DerivedState) obj3;
                                            obj4 = map.get(derivedState);
                                            policy = derivedState.getPolicy();
                                            if (policy == null) {
                                                policy = SnapshotStateKt.structuralEqualityPolicy();
                                            }
                                            if (policy.equivalent(derivedState.getCurrentRecord().getCurrentValue(), obj4)) {
                                                Boolean.valueOf(this.statesToReread.add(derivedState));
                                            } else {
                                                obj5 = mutableScatterMap7.get(derivedState);
                                                if (obj5 == null) {
                                                    z3 = z5;
                                                } else if (obj5 instanceof MutableScatterSet) {
                                                    MutableScatterSet mutableScatterSet9 = (MutableScatterSet) obj5;
                                                    objArr2 = mutableScatterSet9.elements;
                                                    jArr2 = mutableScatterSet9.metadata;
                                                    length2 = jArr2.length - 2;
                                                    if (length2 >= 0) {
                                                        i5 = 0;
                                                        while (true) {
                                                            j2 = jArr2[i5];
                                                            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                if (i5 != length2) {
                                                                    break;
                                                                    break;
                                                                }
                                                                i5++;
                                                            } else {
                                                                i6 = 8 - ((~(i5 - length2)) >>> 31);
                                                                for (i7 = 0; i7 < i6; i7++) {
                                                                    if ((j2 & 255) < 128) {
                                                                        mutableScatterSet.add(objArr2[(i5 << 3) + i7]);
                                                                        z5 = true;
                                                                    }
                                                                    j2 >>= 8;
                                                                }
                                                                if (i6 == 8) {
                                                                    break;
                                                                }
                                                                if (i5 != length2) {
                                                                    break;
                                                                }
                                                                i5++;
                                                            }
                                                        }
                                                    }
                                                    z3 = z5;
                                                } else {
                                                    mutableScatterSet.add(obj5);
                                                    z3 = true;
                                                }
                                                Unit unit4 = Unit.INSTANCE;
                                                z5 = z3;
                                            }
                                        }
                                        i = 0;
                                        this.readingDerivedStates = false;
                                    } catch (Throwable th2) {
                                        this.readingDerivedStates = false;
                                        throw th2;
                                    }
                                } else {
                                    mutableScatterMap8 = mutableScatterMap;
                                    it = it3;
                                    obj = next;
                                    str = str3;
                                    map = map8;
                                    i = 0;
                                }
                            }
                            z2 = z5;
                            obj2 = mutableScatterMap7.get(obj);
                            if (obj2 == null) {
                                if (obj2 instanceof MutableScatterSet) {
                                    MutableScatterSet mutableScatterSet10 = (MutableScatterSet) obj2;
                                    objArr = mutableScatterSet10.elements;
                                    jArr = mutableScatterSet10.metadata;
                                    length = jArr.length - 2;
                                    if (length >= 0) {
                                        i2 = i;
                                        while (true) {
                                            j = jArr[i2];
                                            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                                i3 = 8 - ((~(i2 - length)) >>> 31);
                                                for (i4 = i; i4 < i3; i4++) {
                                                    if ((j & 255) < 128) {
                                                        mutableScatterSet.add(objArr[(i2 << 3) + i4]);
                                                        z2 = true;
                                                    }
                                                    j >>= 8;
                                                }
                                                if (i3 == 8) {
                                                    break;
                                                }
                                            }
                                            if (i2 != length) {
                                                break;
                                            }
                                            i2++;
                                        }
                                    }
                                } else {
                                    mutableScatterSet.add(obj2);
                                    z2 = true;
                                }
                            }
                            z5 = z2;
                        } else {
                            it = it3;
                            str = str3;
                            map = map8;
                        }
                    } else {
                        if (this.readingDerivedStates) {
                            mutableScatterMap = mutableScatterMap8;
                            if (ScopeMap.m6168containsimpl(mutableScatterMap, next)) {
                                this.readingDerivedStates = true;
                                obj3 = mutableScatterMap.get(next);
                                if (obj3 == null) {
                                    it = it3;
                                    obj = next;
                                    mutableScatterMap8 = mutableScatterMap;
                                    str = str3;
                                    map = map8;
                                } else if (obj3 instanceof MutableScatterSet) {
                                    MutableScatterSet mutableScatterSet11 = (MutableScatterSet) obj3;
                                    objArr3 = mutableScatterSet11.elements;
                                    jArr3 = mutableScatterSet11.metadata;
                                    length3 = jArr3.length - 2;
                                    if (length3 >= 0) {
                                        i8 = 0;
                                        while (true) {
                                            j3 = jArr3[i8];
                                            objArr4 = objArr3;
                                            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                i9 = 8 - ((~(i8 - length3)) >>> 31);
                                                i10 = 0;
                                                while (i10 < i9) {
                                                    if ((j3 & 255) < 128) {
                                                        derivedState2 = (DerivedState) objArr4[(i8 << 3) + i10];
                                                        Intrinsics.checkNotNull(derivedState2, str3);
                                                        it2 = it3;
                                                        mutableScatterMap2 = mutableScatterMap;
                                                        map2 = map8;
                                                        obj7 = map2.get(derivedState2);
                                                        policy2 = derivedState2.getPolicy();
                                                        if (policy2 == null) {
                                                            policy2 = SnapshotStateKt.structuralEqualityPolicy();
                                                        }
                                                        jArr5 = jArr3;
                                                        str2 = str3;
                                                        if (policy2.equivalent(derivedState2.getCurrentRecord().getCurrentValue(), obj7)) {
                                                            obj8 = mutableScatterMap7.get(derivedState2);
                                                            if (obj8 == null) {
                                                                obj6 = next;
                                                                j4 = j3;
                                                            } else if (obj8 instanceof MutableScatterSet) {
                                                                MutableScatterSet mutableScatterSet12 = (MutableScatterSet) obj8;
                                                                objArr5 = mutableScatterSet12.elements;
                                                                jArr6 = mutableScatterSet12.metadata;
                                                                length4 = jArr6.length - 2;
                                                                if (length4 >= 0) {
                                                                    j4 = j3;
                                                                    i11 = 0;
                                                                    while (true) {
                                                                        j5 = jArr6[i11];
                                                                        obj6 = next;
                                                                        jArr7 = jArr6;
                                                                        if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                            if (i11 != length4) {
                                                                                break;
                                                                                break;
                                                                            }
                                                                            i11++;
                                                                            next = obj6;
                                                                            jArr6 = jArr7;
                                                                        } else {
                                                                            i12 = 8 - ((~(i11 - length4)) >>> 31);
                                                                            while (i13 < i12) {
                                                                                if ((j5 & 255) < 128) {
                                                                                    mutableScatterSet.add(objArr5[(i11 << 3) + i13]);
                                                                                    z5 = true;
                                                                                }
                                                                                j5 >>= 8;
                                                                            }
                                                                            if (i12 == 8) {
                                                                                break;
                                                                                break;
                                                                            }
                                                                            if (i11 != length4) {
                                                                                break;
                                                                                break;
                                                                            }
                                                                            i11++;
                                                                            next = obj6;
                                                                            jArr6 = jArr7;
                                                                        }
                                                                    }
                                                                } else {
                                                                    obj6 = next;
                                                                    j4 = j3;
                                                                }
                                                            } else {
                                                                obj6 = next;
                                                                j4 = j3;
                                                                mutableScatterSet.add(obj8);
                                                                z5 = true;
                                                            }
                                                            Unit unit5 = Unit.INSTANCE;
                                                        } else {
                                                            obj6 = next;
                                                            j4 = j3;
                                                            Boolean.valueOf(this.statesToReread.add(derivedState2));
                                                        }
                                                    } else {
                                                        it2 = it3;
                                                        obj6 = next;
                                                        mutableScatterMap2 = mutableScatterMap;
                                                        jArr5 = jArr3;
                                                        str2 = str3;
                                                        j4 = j3;
                                                        map2 = map8;
                                                    }
                                                    j3 = j4 >> 8;
                                                    i10++;
                                                    map8 = map2;
                                                    next = obj6;
                                                    jArr3 = jArr5;
                                                    str3 = str2;
                                                    mutableScatterMap = mutableScatterMap2;
                                                    it3 = it2;
                                                }
                                                it = it3;
                                                obj = next;
                                                mutableScatterMap8 = mutableScatterMap;
                                                jArr4 = jArr3;
                                                str = str3;
                                                map = map8;
                                                if (i9 == 8) {
                                                    break;
                                                    break;
                                                }
                                            } else {
                                                it = it3;
                                                obj = next;
                                                mutableScatterMap8 = mutableScatterMap;
                                                jArr4 = jArr3;
                                                str = str3;
                                                map = map8;
                                            }
                                            if (i8 != length3) {
                                                break;
                                                break;
                                            }
                                            i8++;
                                            map8 = map;
                                            objArr3 = objArr4;
                                            next = obj;
                                            jArr3 = jArr4;
                                            str3 = str;
                                            mutableScatterMap = mutableScatterMap8;
                                            it3 = it;
                                        }
                                    } else {
                                        it = it3;
                                        obj = next;
                                        mutableScatterMap8 = mutableScatterMap;
                                        str = str3;
                                        map = map8;
                                    }
                                } else {
                                    it = it3;
                                    obj = next;
                                    mutableScatterMap8 = mutableScatterMap;
                                    str = str3;
                                    map = map8;
                                    derivedState = (DerivedState) obj3;
                                    obj4 = map.get(derivedState);
                                    policy = derivedState.getPolicy();
                                    if (policy == null) {
                                        policy = SnapshotStateKt.structuralEqualityPolicy();
                                    }
                                    if (policy.equivalent(derivedState.getCurrentRecord().getCurrentValue(), obj4)) {
                                        obj5 = mutableScatterMap7.get(derivedState);
                                        if (obj5 == null) {
                                            z3 = z5;
                                        } else if (obj5 instanceof MutableScatterSet) {
                                            MutableScatterSet mutableScatterSet13 = (MutableScatterSet) obj5;
                                            objArr2 = mutableScatterSet13.elements;
                                            jArr2 = mutableScatterSet13.metadata;
                                            length2 = jArr2.length - 2;
                                            if (length2 >= 0) {
                                                i5 = 0;
                                                while (true) {
                                                    j2 = jArr2[i5];
                                                    if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                        if (i5 != length2) {
                                                            break;
                                                            break;
                                                        }
                                                        i5++;
                                                    } else {
                                                        i6 = 8 - ((~(i5 - length2)) >>> 31);
                                                        while (i7 < i6) {
                                                            if ((j2 & 255) < 128) {
                                                                mutableScatterSet.add(objArr2[(i5 << 3) + i7]);
                                                                z5 = true;
                                                            }
                                                            j2 >>= 8;
                                                        }
                                                        if (i6 == 8) {
                                                            break;
                                                            break;
                                                        }
                                                        if (i5 != length2) {
                                                            break;
                                                            break;
                                                        }
                                                        i5++;
                                                    }
                                                }
                                            }
                                            z3 = z5;
                                        } else {
                                            mutableScatterSet.add(obj5);
                                            z3 = true;
                                        }
                                        Unit unit6 = Unit.INSTANCE;
                                        z5 = z3;
                                    } else {
                                        Boolean.valueOf(this.statesToReread.add(derivedState));
                                    }
                                }
                                i = 0;
                                this.readingDerivedStates = false;
                            } else {
                                mutableScatterMap8 = mutableScatterMap;
                                it = it3;
                                obj = next;
                                str = str3;
                                map = map8;
                                i = 0;
                            }
                        } else {
                            it = it3;
                            obj = next;
                            str = str3;
                            map = map8;
                            i = 0;
                        }
                        z2 = z5;
                        obj2 = mutableScatterMap7.get(obj);
                        if (obj2 == null) {
                            if (obj2 instanceof MutableScatterSet) {
                                MutableScatterSet mutableScatterSet14 = (MutableScatterSet) obj2;
                                objArr = mutableScatterSet14.elements;
                                jArr = mutableScatterSet14.metadata;
                                length = jArr.length - 2;
                                if (length >= 0) {
                                    i2 = i;
                                    while (true) {
                                        j = jArr[i2];
                                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                            i3 = 8 - ((~(i2 - length)) >>> 31);
                                            while (i4 < i3) {
                                                if ((j & 255) < 128) {
                                                    mutableScatterSet.add(objArr[(i2 << 3) + i4]);
                                                    z2 = true;
                                                }
                                                j >>= 8;
                                            }
                                            if (i3 == 8) {
                                                break;
                                                break;
                                            }
                                        }
                                        if (i2 != length) {
                                            break;
                                            break;
                                        }
                                        i2++;
                                    }
                                }
                            } else {
                                mutableScatterSet.add(obj2);
                                z2 = true;
                            }
                        }
                        z5 = z2;
                    }
                    map8 = map;
                    str3 = str;
                    it3 = it;
                }
                z = z5;
            }
            if (!this.readingDerivedStates && this.statesToReread.getSize() != 0) {
                MutableVector<DerivedState<?>> mutableVector = this.statesToReread;
                DerivedState<?>[] derivedStateArr = mutableVector.content;
                int size = mutableVector.getSize();
                for (int i36 = 0; i36 < size; i36++) {
                    rereadDerivedState(derivedStateArr[i36]);
                }
                this.statesToReread.clear();
            }
            return z;
        }

        public final void rereadDerivedState(DerivedState<?> derivedState) {
            long[] jArr;
            MutableObjectIntMap<Object> mutableObjectIntMap;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> mutableScatterMap = this.scopeToValues;
            int iHashCode = Long.hashCode(SnapshotKt.currentSnapshot().getSnapshotId());
            Object obj = this.valueToScopes.get(derivedState);
            if (obj == null) {
                return;
            }
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i = 1;
            int i2 = 0;
            if (!(obj instanceof MutableScatterSet)) {
                MutableObjectIntMap<Object> mutableObjectIntMap2 = mutableScatterMap.get(obj);
                if (mutableObjectIntMap2 == null) {
                    mutableObjectIntMap2 = new MutableObjectIntMap<>(i2, i, defaultConstructorMarker);
                    mutableScatterMap.set(obj, mutableObjectIntMap2);
                    Unit unit = Unit.INSTANCE;
                }
                recordRead(derivedState, iHashCode, obj, mutableObjectIntMap2);
                return;
            }
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr2 = mutableScatterSet.metadata;
            int length = jArr2.length - 2;
            if (length < 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                long j = jArr2[i3];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8;
                    int i5 = 8 - ((~(i3 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j & 255) < 128) {
                            Object obj2 = objArr[(i3 << 3) + i6];
                            MutableObjectIntMap<Object> mutableObjectIntMap3 = mutableScatterMap.get(obj2);
                            if (mutableObjectIntMap3 == null) {
                                mutableObjectIntMap = new MutableObjectIntMap<>(i2, i, defaultConstructorMarker);
                                mutableScatterMap.set(obj2, mutableObjectIntMap);
                                Unit unit2 = Unit.INSTANCE;
                            } else {
                                mutableObjectIntMap = mutableObjectIntMap3;
                            }
                            recordRead(derivedState, iHashCode, obj2, mutableObjectIntMap);
                        }
                        j >>= i4;
                        i6++;
                        i4 = i4;
                        jArr2 = jArr2;
                    }
                    jArr = jArr2;
                    if (i5 != i4) {
                        return;
                    }
                } else {
                    jArr = jArr2;
                }
                if (i3 == length) {
                    return;
                }
                i3++;
                jArr2 = jArr;
            }
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0045 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:15:0x0047 A[LOOP:0: B:5:0x0012->B:15:0x0047, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:19:0x004a A[EDGE_INSN: B:19:0x004a->B:16:0x004a BREAK  A[LOOP:0: B:5:0x0012->B:15:0x0047], SYNTHETIC] */
        public final void notifyInvalidatedScopes() {
            MutableScatterSet<Object> mutableScatterSet = this.invalidated;
            MutableScatterSet<Object> mutableScatterSet2 = mutableScatterSet;
            Function1<Object, Unit> function1 = this.onChanged;
            Object[] objArr = mutableScatterSet2.elements;
            long[] jArr = mutableScatterSet2.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i != length) {
                            break;
                            break;
                        }
                        i++;
                    } else {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                function1.invoke(objArr[(i << 3) + i3]);
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        } else if (i != length) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            mutableScatterSet.clear();
        }
    }

    public final void clear(Object scope) {
        synchronized (this.observedScopeMapsLock) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                ObservedScopeMap observedScopeMap = mutableVector.content[i2];
                observedScopeMap.clearScopeObservations(scope);
                if (!observedScopeMap.hasScopeObservations()) {
                    i++;
                } else if (i > 0) {
                    mutableVector.content[i2 - i] = mutableVector.content[i2];
                }
            }
            int i3 = size - i;
            ArraysKt.fill(mutableVector.content, (Object) null, i3, size);
            mutableVector.setSize(i3);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clearIf(Function1<Object, Boolean> predicate) {
        synchronized (this.observedScopeMapsLock) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                ObservedScopeMap observedScopeMap = mutableVector.content[i2];
                observedScopeMap.removeScopeIf(predicate);
                if (!observedScopeMap.hasScopeObservations()) {
                    i++;
                } else if (i > 0) {
                    mutableVector.content[i2 - i] = mutableVector.content[i2];
                }
            }
            int i3 = size - i;
            ArraysKt.fill(mutableVector.content, (Object) null, i3, size);
            mutableVector.setSize(i3);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clear() {
        synchronized (this.observedScopeMapsLock) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            ObservedScopeMap[] observedScopeMapArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                observedScopeMapArr[i].clear();
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
