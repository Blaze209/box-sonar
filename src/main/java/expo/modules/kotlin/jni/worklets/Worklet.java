package expo.modules.kotlin.jni.worklets;

import expo.modules.kotlin.runtime.WorkletRuntime;
import expo.modules.kotlin.types.JSTypeConverterProvider;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Worklet.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ+\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0010\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0011J+\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0010\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0011J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J.\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010H\u0082 ¢\u0006\u0002\u0010\u0014J\u0019\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J.\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010H\u0082 ¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lexpo/modules/kotlin/jni/worklets/Worklet;", "", "serializable", "Lexpo/modules/kotlin/jni/worklets/Serializable;", "<init>", "(Lexpo/modules/kotlin/jni/worklets/Serializable;)V", "enforceHolder", "Lexpo/modules/kotlin/jni/worklets/WorkletNativeRuntime;", "Lexpo/modules/kotlin/runtime/WorkletRuntime;", "getEnforceHolder", "(Lexpo/modules/kotlin/runtime/WorkletRuntime;)Lexpo/modules/kotlin/jni/worklets/WorkletNativeRuntime;", "schedule", "", "runtime", "execute", "arguments", "", "(Lexpo/modules/kotlin/runtime/WorkletRuntime;[Ljava/lang/Object;)V", "workletNativeRuntime", "args", "(Lexpo/modules/kotlin/jni/worklets/WorkletNativeRuntime;Lexpo/modules/kotlin/jni/worklets/Serializable;[Ljava/lang/Object;)V", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Worklet {
    public static final int $stable = 8;
    private final Serializable serializable;

    private final native void execute(WorkletNativeRuntime workletNativeRuntime, Serializable serializable);

    private final native void execute(WorkletNativeRuntime workletNativeRuntime, Serializable serializable, Object[] args);

    private final native void schedule(WorkletNativeRuntime workletNativeRuntime, Serializable serializable);

    private final native void schedule(WorkletNativeRuntime workletNativeRuntime, Serializable serializable, Object[] args);

    public Worklet(Serializable serializable) {
        Intrinsics.checkNotNullParameter(serializable, "serializable");
        this.serializable = serializable;
    }

    private final WorkletNativeRuntime getEnforceHolder(WorkletRuntime workletRuntime) {
        WorkletNativeRuntime mWorkletNativeRuntime = workletRuntime.getMWorkletNativeRuntime();
        if (mWorkletNativeRuntime != null) {
            return mWorkletNativeRuntime;
        }
        throw new IllegalStateException("Worklet runtime is not installed.");
    }

    public final void schedule(WorkletRuntime runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        schedule(getEnforceHolder(runtime), this.serializable);
    }

    public final void execute(WorkletRuntime runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        execute(getEnforceHolder(runtime), this.serializable);
    }

    public final void schedule(WorkletRuntime runtime, Object... arguments) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        WorkletNativeRuntime enforceHolder = getEnforceHolder(runtime);
        ArrayList arrayList = new ArrayList(arguments.length);
        for (Object obj : arguments) {
            arrayList.add(JSTypeConverterProvider.convertToJSValue$default(JSTypeConverterProvider.INSTANCE, obj, null, true, 2, null));
        }
        schedule(enforceHolder, this.serializable, arrayList.toArray(new Object[0]));
    }

    public final void execute(WorkletRuntime runtime, Object... arguments) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        WorkletNativeRuntime enforceHolder = getEnforceHolder(runtime);
        ArrayList arrayList = new ArrayList(arguments.length);
        for (Object obj : arguments) {
            arrayList.add(JSTypeConverterProvider.convertToJSValue$default(JSTypeConverterProvider.INSTANCE, obj, null, true, 2, null));
        }
        execute(enforceHolder, this.serializable, arrayList.toArray(new Object[0]));
    }
}
