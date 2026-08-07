package external.sdk.pendo.io.mozilla.javascript;

/* JADX INFO: loaded from: classes4.dex */
public class NativeJavaConstructor extends BaseFunction {
    private static final long serialVersionUID = -8149253217482668463L;
    MemberBox ctor;

    public NativeJavaConstructor(MemberBox memberBox) {
        this.ctor = memberBox;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.Function, external.sdk.pendo.io.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return NativeJavaClass.constructSpecific(context, scriptable, objArr, this.ctor);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction
    public String getFunctionName() {
        return "<init>".concat(JavaMembers.liveConnectSignature(this.ctor.argTypes));
    }

    public String toString() {
        return "[JavaConstructor " + this.ctor.getName() + "]";
    }
}
