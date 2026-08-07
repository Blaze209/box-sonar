package expo.modules.kotlin.sharedobjects;

import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.exception.InvalidSharedObjectIdException;
import expo.modules.kotlin.exception.UsingReleasedSharedObjectException;
import expo.modules.kotlin.jni.JavaScriptObject;
import expo.modules.kotlin.jni.JavaScriptWeakObject;
import expo.modules.kotlin.runtime.Runtime;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedObjectRegistry.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\tH\u0000¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\tH\u0000¢\u0006\u0004\b$\u0010%J\u0019\u0010&\u001a\u0004\u0018\u00010\u000e2\u0006\u0010 \u001a\u00020\tH\u0000¢\u0006\u0004\b'\u0010%J\u0017\u0010&\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b(J\u0017\u0010)\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0019\u001a\u00020\u000eH\u0000¢\u0006\u0002\b*J\u0017\u0010+\u001a\u0004\u0018\u00010\u000f2\u0006\u0010,\u001a\u00020\u000eH\u0000¢\u0006\u0002\b-J\u0013\u0010.\u001a\u00020\t*\u00020\tH\u0002¢\u0006\u0004\b/\u00100R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR6\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u00100\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u00061"}, d2 = {"Lexpo/modules/kotlin/sharedobjects/SharedObjectRegistry;", "", "runtime", "Lexpo/modules/kotlin/runtime/Runtime;", "<init>", "(Lexpo/modules/kotlin/runtime/Runtime;)V", "runtimeContextHolder", "Ljava/lang/ref/WeakReference;", "currentId", "Lexpo/modules/kotlin/sharedobjects/SharedObjectId;", "I", "pairs", "", "Lkotlin/Pair;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "Lexpo/modules/kotlin/jni/JavaScriptWeakObject;", "Lexpo/modules/kotlin/sharedobjects/SharedObjectPair;", "getPairs$expo_modules_core_release", "()Ljava/util/Map;", "setPairs$expo_modules_core_release", "(Ljava/util/Map;)V", "pullNextId", "pullNextId-HSeVr_g", "()I", "add", "native", "js", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "add-5WKnsLU$expo_modules_core_release", "(Lexpo/modules/kotlin/sharedobjects/SharedObject;Lexpo/modules/kotlin/jni/JavaScriptObject;)I", "delete", "", "id", "delete-kyJHjyY$expo_modules_core_release", "(I)V", "toNativeObject", "toNativeObject-kyJHjyY$expo_modules_core_release", "(I)Lexpo/modules/kotlin/sharedobjects/SharedObject;", "toNativeObjectOrNull", "toNativeObjectOrNull-kyJHjyY$expo_modules_core_release", "toNativeObjectOrNull$expo_modules_core_release", "toJavaScriptObjectOrNull", "toJavaScriptObjectOrNull$expo_modules_core_release", "toWeakJavaScriptObjectOrNull", "nativeObject", "toWeakJavaScriptObjectOrNull$expo_modules_core_release", "ensureWasNotRelease", "ensureWasNotRelease-tuC-2VU", "(I)I", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SharedObjectRegistry {
    public static final int $stable = 8;
    private int currentId;
    private Map<SharedObjectId, Pair<SharedObject, JavaScriptWeakObject>> pairs;
    private final WeakReference<Runtime> runtimeContextHolder;

    public SharedObjectRegistry(Runtime runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        this.runtimeContextHolder = UtilsKt.weak(runtime);
        this.currentId = SharedObjectId.m14568constructorimpl(1);
        this.pairs = new LinkedHashMap();
    }

    public final Map<SharedObjectId, Pair<SharedObject, JavaScriptWeakObject>> getPairs$expo_modules_core_release() {
        return this.pairs;
    }

    public final void setPairs$expo_modules_core_release(Map<SharedObjectId, Pair<SharedObject, JavaScriptWeakObject>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.pairs = map;
    }

    /* JADX INFO: renamed from: pullNextId-HSeVr_g, reason: not valid java name */
    private final int m14579pullNextIdHSeVr_g() {
        int i;
        synchronized (this) {
            i = this.currentId;
            this.currentId = SharedObjectId.m14568constructorimpl(i + 1);
        }
        return i;
    }

    /* JADX INFO: renamed from: add-5WKnsLU$expo_modules_core_release, reason: not valid java name */
    public final int m14580add5WKnsLU$expo_modules_core_release(SharedObject sharedObject, JavaScriptObject js) throws Exceptions.AppContextLost {
        Intrinsics.checkNotNullParameter(sharedObject, "native");
        Intrinsics.checkNotNullParameter(js, "js");
        int iM14579pullNextIdHSeVr_g = m14579pullNextIdHSeVr_g();
        sharedObject.m14566setSharedObjectIdkyJHjyY$expo_modules_core_release(iM14579pullNextIdHSeVr_g);
        JavaScriptObject.defineProperty$default(js, SharedObjectRegistryKt.sharedObjectIdPropertyName, iM14579pullNextIdHSeVr_g, (List) null, 4, (Object) null);
        Runtime runtime = this.runtimeContextHolder.get();
        if (runtime == null) {
            throw new Exceptions.AppContextLost();
        }
        runtime.getJsiContext().setNativeStateForSharedObject(iM14579pullNextIdHSeVr_g, js);
        int additionalMemoryPressure = sharedObject.getAdditionalMemoryPressure();
        if (additionalMemoryPressure > 0) {
            js.setExternalMemoryPressure(additionalMemoryPressure);
        }
        if (sharedObject instanceof SharedRef) {
            JavaScriptObject.defineProperty$default(js, "nativeRefType", ((SharedRef) sharedObject).getNativeRefType(), (List) null, 4, (Object) null);
        }
        JavaScriptWeakObject javaScriptWeakObjectCreateWeak = js.createWeak();
        synchronized (this) {
            this.pairs.put(SharedObjectId.m14567boximpl(iM14579pullNextIdHSeVr_g), TuplesKt.to(sharedObject, javaScriptWeakObjectCreateWeak));
            Unit unit = Unit.INSTANCE;
        }
        if (sharedObject.getRuntimeContextHolder().get() == null) {
            sharedObject.setRuntimeContextHolder(UtilsKt.weak(runtime));
        }
        return iM14579pullNextIdHSeVr_g;
    }

    /* JADX INFO: renamed from: delete-kyJHjyY$expo_modules_core_release, reason: not valid java name */
    public final void m14581deletekyJHjyY$expo_modules_core_release(int id) {
        Pair<SharedObject, JavaScriptWeakObject> pairRemove;
        synchronized (this) {
            pairRemove = this.pairs.remove(SharedObjectId.m14567boximpl(id));
        }
        if (pairRemove != null) {
            SharedObject sharedObjectComponent1 = pairRemove.component1();
            sharedObjectComponent1.m14566setSharedObjectIdkyJHjyY$expo_modules_core_release(SharedObjectId.m14568constructorimpl(0));
            sharedObjectComponent1.sharedObjectDidRelease();
        }
    }

    /* JADX INFO: renamed from: toNativeObject-kyJHjyY$expo_modules_core_release, reason: not valid java name */
    public final SharedObject m14582toNativeObjectkyJHjyY$expo_modules_core_release(int id) throws InvalidSharedObjectIdException {
        Pair<SharedObject, JavaScriptWeakObject> pair = this.pairs.get(SharedObjectId.m14567boximpl(m14578ensureWasNotReleasetuC2VU(id)));
        SharedObject first = pair != null ? pair.getFirst() : null;
        if (first != null) {
            return first;
        }
        throw new InvalidSharedObjectIdException();
    }

    /* JADX INFO: renamed from: toNativeObjectOrNull-kyJHjyY$expo_modules_core_release, reason: not valid java name */
    public final SharedObject m14583toNativeObjectOrNullkyJHjyY$expo_modules_core_release(int id) {
        SharedObject first;
        synchronized (this) {
            Pair<SharedObject, JavaScriptWeakObject> pair = this.pairs.get(SharedObjectId.m14567boximpl(id));
            first = pair != null ? pair.getFirst() : null;
        }
        return first;
    }

    public final SharedObject toNativeObjectOrNull$expo_modules_core_release(JavaScriptObject js) {
        Intrinsics.checkNotNullParameter(js, "js");
        if (!js.hasProperty(SharedObjectRegistryKt.sharedObjectIdPropertyName)) {
            return null;
        }
        Pair<SharedObject, JavaScriptWeakObject> pair = this.pairs.get(SharedObjectId.m14567boximpl(SharedObjectId.m14568constructorimpl(js.getProperty(SharedObjectRegistryKt.sharedObjectIdPropertyName).getInt())));
        if (pair != null) {
            return pair.getFirst();
        }
        return null;
    }

    public final JavaScriptObject toJavaScriptObjectOrNull$expo_modules_core_release(SharedObject sharedObject) {
        JavaScriptObject javaScriptObjectLock;
        JavaScriptWeakObject second;
        Intrinsics.checkNotNullParameter(sharedObject, "native");
        synchronized (this) {
            Pair<SharedObject, JavaScriptWeakObject> pair = this.pairs.get(SharedObjectId.m14567boximpl(sharedObject.m14565getSharedObjectIdHSeVr_g$expo_modules_core_release()));
            javaScriptObjectLock = (pair == null || (second = pair.getSecond()) == null) ? null : second.lock();
        }
        return javaScriptObjectLock;
    }

    public final JavaScriptWeakObject toWeakJavaScriptObjectOrNull$expo_modules_core_release(SharedObject nativeObject) {
        JavaScriptWeakObject second;
        Intrinsics.checkNotNullParameter(nativeObject, "nativeObject");
        synchronized (this) {
            Pair<SharedObject, JavaScriptWeakObject> pair = this.pairs.get(SharedObjectId.m14567boximpl(nativeObject.m14565getSharedObjectIdHSeVr_g$expo_modules_core_release()));
            second = pair != null ? pair.getSecond() : null;
        }
        return second;
    }

    /* JADX INFO: renamed from: ensureWasNotRelease-tuC-2VU, reason: not valid java name */
    private final int m14578ensureWasNotReleasetuC2VU(int i) throws UsingReleasedSharedObjectException {
        if (this.pairs.containsKey(SharedObjectId.m14567boximpl(i)) || i == 0 || i >= this.currentId) {
            return i;
        }
        throw new UsingReleasedSharedObjectException();
    }
}
