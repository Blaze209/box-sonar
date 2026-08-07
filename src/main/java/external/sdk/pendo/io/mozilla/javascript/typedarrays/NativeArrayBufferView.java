package external.sdk.pendo.io.mozilla.javascript.typedarrays;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.IdScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;
import external.sdk.pendo.io.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeArrayBufferView extends IdScriptableObject {
    private static final int Id_buffer = 1;
    private static final int Id_byteLength = 3;
    private static final int Id_byteOffset = 2;
    protected static final int MAX_INSTANCE_ID = 3;
    private static final long serialVersionUID = 6884475582973958419L;
    private static Boolean useLittleEndian;
    protected final NativeArrayBuffer arrayBuffer;
    protected final int byteLength;
    protected final int offset;

    public NativeArrayBufferView() {
        this.arrayBuffer = new NativeArrayBuffer();
        this.offset = 0;
        this.byteLength = 0;
    }

    protected static boolean isArg(Object[] objArr, int i) {
        return objArr.length > i && !Undefined.instance.equals(objArr[i]);
    }

    protected static boolean useLittleEndian() {
        if (useLittleEndian == null) {
            Context currentContext = Context.getCurrentContext();
            if (currentContext == null) {
                return false;
            }
            useLittleEndian = Boolean.valueOf(currentContext.hasFeature(19));
        }
        return useLittleEndian.booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0025  */
    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findInstanceIdInfo(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 6) {
            str2 = "buffer";
            i = 1;
        } else if (length != 10) {
            str2 = null;
            i = 0;
        } else {
            char cCharAt = str.charAt(4);
            if (cCharAt == 'L') {
                str2 = "byteLength";
                i = 3;
            } else if (cCharAt == 'O') {
                str2 = "byteOffset";
                i = 2;
            } else {
                str2 = null;
                i = 0;
            }
        }
        int i2 = (str2 == null || str2 == str || str2.equals(str)) ? i : 0;
        return i2 == 0 ? super.findInstanceIdInfo(str) : IdScriptableObject.instanceIdInfo(5, i2);
    }

    public NativeArrayBuffer getBuffer() {
        return this.arrayBuffer;
    }

    public int getByteLength() {
        return this.byteLength;
    }

    public int getByteOffset() {
        return this.offset;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected String getInstanceIdName(int i) {
        if (i == 1) {
            return "buffer";
        }
        if (i != 2) {
            return i != 3 ? super.getInstanceIdName(i) : "byteLength";
        }
        return "byteOffset";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected Object getInstanceIdValue(int i) {
        int i2;
        if (i == 1) {
            return this.arrayBuffer;
        }
        if (i == 2) {
            i2 = this.offset;
        } else {
            if (i != 3) {
                return super.getInstanceIdValue(i);
            }
            i2 = this.byteLength;
        }
        return ScriptRuntime.wrapInt(i2);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int getMaxInstanceId() {
        return 3;
    }

    protected NativeArrayBufferView(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        this.offset = i;
        this.byteLength = i2;
        this.arrayBuffer = nativeArrayBuffer;
    }
}
