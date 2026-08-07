package external.sdk.pendo.io.mozilla.javascript.typedarrays;

import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.IdFunctionObject;
import external.sdk.pendo.io.mozilla.javascript.IdScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes4.dex */
public class NativeArrayBuffer extends IdScriptableObject {
    public static final String CLASS_NAME = "ArrayBuffer";
    private static final int ConstructorId_isView = -1;
    private static final byte[] EMPTY_BUF = new byte[0];
    private static final int Id_byteLength = 1;
    private static final int Id_constructor = 1;
    private static final int Id_slice = 2;
    private static final int MAX_INSTANCE_ID = 1;
    private static final int MAX_PROTOTYPE_ID = 2;
    private static final long serialVersionUID = 3110411773054879549L;
    final byte[] buffer;

    public NativeArrayBuffer() {
        this.buffer = EMPTY_BUF;
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeArrayBuffer().exportAsJSClass(2, scriptable, z);
    }

    private static boolean isArg(Object[] objArr, int i) {
        return objArr.length > i && !Undefined.instance.equals(objArr[i]);
    }

    private static NativeArrayBuffer realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeArrayBuffer) {
            return (NativeArrayBuffer) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(CLASS_NAME)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == -1) {
            return Boolean.valueOf(isArg(objArr, 0) && (objArr[0] instanceof NativeArrayBufferView));
        }
        if (iMethodId == 1) {
            return new NativeArrayBuffer(isArg(objArr, 0) ? ScriptRuntime.toNumber(objArr[0]) : 0.0d);
        }
        if (iMethodId != 2) {
            throw new IllegalArgumentException(String.valueOf(iMethodId));
        }
        NativeArrayBuffer nativeArrayBufferRealThis = realThis(scriptable2, idFunctionObject);
        return nativeArrayBufferRealThis.slice(isArg(objArr, 0) ? ScriptRuntime.toNumber(objArr[0]) : 0.0d, isArg(objArr, 1) ? ScriptRuntime.toNumber(objArr[1]) : nativeArrayBufferRealThis.buffer.length);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        addIdFunctionProperty(idFunctionObject, CLASS_NAME, -1, "isView", 1);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findInstanceIdInfo(String str) {
        return "byteLength".equals(str) ? IdScriptableObject.instanceIdInfo(5, 1) : super.findInstanceIdInfo(str);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 5) {
            str2 = AzureActiveDirectorySlice.SLICE_PARAMETER;
            i = 2;
        } else if (length == 11) {
            str2 = "constructor";
            i = 1;
        } else {
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected String getInstanceIdName(int i) {
        return i == 1 ? "byteLength" : super.getInstanceIdName(i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected Object getInstanceIdValue(int i) {
        return i == 1 ? ScriptRuntime.wrapInt(this.buffer.length) : super.getInstanceIdValue(i);
    }

    public int getLength() {
        return this.buffer.length;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int getMaxInstanceId() {
        return 1;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                throw new IllegalArgumentException(String.valueOf(i));
            }
            str = AzureActiveDirectorySlice.SLICE_PARAMETER;
        } else {
            str = "constructor";
        }
        initPrototypeMethod(CLASS_NAME, i, str, i2);
    }

    public NativeArrayBuffer slice(double d, double d2) {
        byte[] bArr = this.buffer;
        double length = bArr.length;
        if (d2 < 0.0d) {
            d2 += (double) bArr.length;
        }
        int int32 = ScriptRuntime.toInt32(Math.max(0.0d, Math.min(length, d2)));
        double d3 = int32;
        if (d < 0.0d) {
            d += (double) this.buffer.length;
        }
        int int33 = ScriptRuntime.toInt32(Math.min(d3, Math.max(0.0d, d)));
        int i = int32 - int33;
        NativeArrayBuffer nativeArrayBuffer = new NativeArrayBuffer(i);
        System.arraycopy(this.buffer, int33, nativeArrayBuffer.buffer, 0, i);
        return nativeArrayBuffer;
    }

    public NativeArrayBuffer(double d) {
        if (d >= 2.147483647E9d) {
            throw ScriptRuntime.rangeError("length parameter (" + d + ") is too large ");
        }
        if (d == Double.NEGATIVE_INFINITY) {
            throw ScriptRuntime.rangeError("Negative array length " + d);
        }
        if (d <= -1.0d) {
            throw ScriptRuntime.rangeError("Negative array length " + d);
        }
        int int32 = ScriptRuntime.toInt32(d);
        if (int32 < 0) {
            throw ScriptRuntime.rangeError("Negative array length " + d);
        }
        if (int32 == 0) {
            this.buffer = EMPTY_BUF;
        } else {
            this.buffer = new byte[int32];
        }
    }
}
