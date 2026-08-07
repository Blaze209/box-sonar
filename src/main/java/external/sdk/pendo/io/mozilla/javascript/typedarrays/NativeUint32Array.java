package external.sdk.pendo.io.mozilla.javascript.typedarrays;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.IdFunctionObject;
import external.sdk.pendo.io.mozilla.javascript.IdScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes4.dex */
public class NativeUint32Array extends NativeTypedArrayView<Long> {
    private static final int BYTES_PER_ELEMENT = 4;
    private static final String CLASS_NAME = "Uint32Array";
    private static final long serialVersionUID = -7987831421954144244L;

    public NativeUint32Array() {
    }

    public NativeUint32Array(int i) {
        this(new NativeArrayBuffer(((double) i) * 4.0d), 0, i);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeUint32Array().exportAsJSClass(6, scriptable, z);
    }

    @Override // java.util.List
    public Long get(int i) {
        if (checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Long) js_get(i);
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
        return checkIndex(i) ? Undefined.instance : ByteIo.readUint32(this.arrayBuffer.buffer, (i * 4) + this.offset, NativeArrayBufferView.useLittleEndian());
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    protected Object js_set(int i, Object obj) {
        if (checkIndex(i)) {
            return Undefined.instance;
        }
        ByteIo.writeUint32(this.arrayBuffer.buffer, (i * 4) + this.offset, Conversions.toUint32(obj), NativeArrayBufferView.useLittleEndian());
        return null;
    }

    @Override // java.util.List
    public Long set(int i, Long l) {
        if (checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Long) js_set(i, l);
    }

    public NativeUint32Array(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2, i2 * 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* JADX INFO: renamed from: construct, reason: avoid collision after fix types in other method */
    public NativeTypedArrayView<Long> construct2(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        return new NativeUint32Array(nativeArrayBuffer, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* JADX INFO: renamed from: realThis, reason: avoid collision after fix types in other method */
    public NativeTypedArrayView<Long> realThis2(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeUint32Array) {
            return (NativeUint32Array) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }
}
