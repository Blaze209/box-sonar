package external.sdk.pendo.io.mozilla.javascript.typedarrays;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.IdFunctionObject;
import external.sdk.pendo.io.mozilla.javascript.IdScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes4.dex */
public class NativeFloat32Array extends NativeTypedArrayView<Float> {
    private static final int BYTES_PER_ELEMENT = 4;
    private static final String CLASS_NAME = "Float32Array";
    private static final long serialVersionUID = -8963461831950499340L;

    public NativeFloat32Array() {
    }

    public NativeFloat32Array(int i) {
        this(new NativeArrayBuffer(((double) i) * 4.0d), 0, i);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeFloat32Array().exportAsJSClass(6, scriptable, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* JADX INFO: renamed from: construct */
    public NativeTypedArrayView<Float> construct2(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        return new NativeFloat32Array(nativeArrayBuffer, i, i2);
    }

    @Override // java.util.List
    public Float get(int i) {
        if (checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Float) js_get(i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    public int getBytesPerElement() {
        return 4;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    protected Object js_get(int i) {
        return checkIndex(i) ? Undefined.instance : ByteIo.readFloat32(this.arrayBuffer.buffer, (i * 4) + this.offset, NativeArrayBufferView.useLittleEndian());
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    protected Object js_set(int i, Object obj) {
        if (checkIndex(i)) {
            return Undefined.instance;
        }
        ByteIo.writeFloat32(this.arrayBuffer.buffer, (i * 4) + this.offset, ScriptRuntime.toNumber(obj), NativeArrayBufferView.useLittleEndian());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* JADX INFO: renamed from: realThis */
    public NativeTypedArrayView<Float> realThis2(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeFloat32Array) {
            return (NativeFloat32Array) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // java.util.List
    public Float set(int i, Float f) {
        if (checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Float) js_set(i, f);
    }

    public NativeFloat32Array(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2, i2 * 4);
    }
}
