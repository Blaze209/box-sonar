package external.sdk.pendo.io.mozilla.javascript.typedarrays;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.IdFunctionObject;
import external.sdk.pendo.io.mozilla.javascript.IdScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes4.dex */
public class NativeInt8Array extends NativeTypedArrayView<Byte> {
    private static final String CLASS_NAME = "Int8Array";
    private static final long serialVersionUID = -3349419704390398895L;

    public NativeInt8Array() {
    }

    public NativeInt8Array(int i) {
        this(new NativeArrayBuffer(i), 0, i);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeInt8Array().exportAsJSClass(6, scriptable, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* JADX INFO: renamed from: construct, reason: merged with bridge method [inline-methods] */
    public NativeTypedArrayView<Byte> construct2(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        return new NativeInt8Array(nativeArrayBuffer, i, i2);
    }

    @Override // java.util.List
    public Byte get(int i) {
        if (checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Byte) js_get(i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    public int getBytesPerElement() {
        return 1;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    protected Object js_get(int i) {
        return checkIndex(i) ? Undefined.instance : ByteIo.readInt8(this.arrayBuffer.buffer, i + this.offset);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    protected Object js_set(int i, Object obj) {
        if (checkIndex(i)) {
            return Undefined.instance;
        }
        ByteIo.writeInt8(this.arrayBuffer.buffer, i + this.offset, Conversions.toInt8(obj));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* JADX INFO: renamed from: realThis, reason: merged with bridge method [inline-methods] */
    public NativeTypedArrayView<Byte> realThis2(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeInt8Array) {
            return (NativeInt8Array) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // java.util.List
    public Byte set(int i, Byte b) {
        if (checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Byte) js_set(i, b);
    }

    public NativeInt8Array(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2, i2);
    }
}
