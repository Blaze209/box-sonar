package external.sdk.pendo.io.mozilla.javascript.typedarrays;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.IdFunctionObject;
import external.sdk.pendo.io.mozilla.javascript.IdScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes4.dex */
public class NativeInt16Array extends NativeTypedArrayView<Short> {
    private static final int BYTES_PER_ELEMENT = 2;
    private static final String CLASS_NAME = "Int16Array";
    private static final long serialVersionUID = -8592870435287581398L;

    public NativeInt16Array() {
    }

    public NativeInt16Array(int i) {
        this(new NativeArrayBuffer(((double) i) * 2.0d), 0, i);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeInt16Array().exportAsJSClass(6, scriptable, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* JADX INFO: renamed from: construct */
    public NativeTypedArrayView<Short> construct2(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        return new NativeInt16Array(nativeArrayBuffer, i, i2);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    public int getBytesPerElement() {
        return 2;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    protected Object js_get(int i) {
        return checkIndex(i) ? Undefined.instance : ByteIo.readInt16(this.arrayBuffer.buffer, (i * 2) + this.offset, NativeArrayBufferView.useLittleEndian());
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    protected Object js_set(int i, Object obj) {
        if (checkIndex(i)) {
            return Undefined.instance;
        }
        ByteIo.writeInt16(this.arrayBuffer.buffer, (i * 2) + this.offset, Conversions.toInt16(obj), NativeArrayBufferView.useLittleEndian());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* JADX INFO: renamed from: realThis */
    public NativeTypedArrayView<Short> realThis2(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeInt16Array) {
            return (NativeInt16Array) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    public NativeInt16Array(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2, i2 * 2);
    }

    @Override // java.util.List
    public Short get(int i) {
        if (checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Short) js_get(i);
    }

    @Override // java.util.List
    public Short set(int i, Short sh) {
        if (checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Short) js_set(i, sh);
    }
}
