package external.sdk.pendo.io.mozilla.javascript.typedarrays;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.IdFunctionObject;
import external.sdk.pendo.io.mozilla.javascript.IdScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes4.dex */
public class NativeDataView extends NativeArrayBufferView {
    public static final String CLASS_NAME = "DataView";
    private static final int Id_constructor = 1;
    private static final int Id_getFloat32 = 8;
    private static final int Id_getFloat64 = 9;
    private static final int Id_getInt16 = 4;
    private static final int Id_getInt32 = 6;
    private static final int Id_getInt8 = 2;
    private static final int Id_getUint16 = 5;
    private static final int Id_getUint32 = 7;
    private static final int Id_getUint8 = 3;
    private static final int Id_setFloat32 = 16;
    private static final int Id_setFloat64 = 17;
    private static final int Id_setInt16 = 12;
    private static final int Id_setInt32 = 14;
    private static final int Id_setInt8 = 10;
    private static final int Id_setUint16 = 13;
    private static final int Id_setUint32 = 15;
    private static final int Id_setUint8 = 11;
    private static final int MAX_PROTOTYPE_ID = 17;
    private static final long serialVersionUID = 1427967607557438968L;

    public NativeDataView() {
    }

    public NativeDataView(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2);
    }

    private static int determinePos(Object[] objArr) {
        if (!NativeArrayBufferView.isArg(objArr, 0)) {
            return 0;
        }
        double number = ScriptRuntime.toNumber(objArr[0]);
        if (Double.isInfinite(number)) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
        return ScriptRuntime.toInt32(number);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeDataView().exportAsJSClass(17, scriptable, z);
    }

    private static NativeDataView js_constructor(Object[] objArr) {
        int length;
        int int32 = 0;
        if (NativeArrayBufferView.isArg(objArr, 0)) {
            Object obj = objArr[0];
            if (obj instanceof NativeArrayBuffer) {
                NativeArrayBuffer nativeArrayBuffer = (NativeArrayBuffer) obj;
                if (NativeArrayBufferView.isArg(objArr, 1)) {
                    double number = ScriptRuntime.toNumber(objArr[1]);
                    if (Double.isInfinite(number)) {
                        throw ScriptRuntime.rangeError("offset out of range");
                    }
                    int32 = ScriptRuntime.toInt32(number);
                }
                if (NativeArrayBufferView.isArg(objArr, 2)) {
                    double number2 = ScriptRuntime.toNumber(objArr[2]);
                    if (Double.isInfinite(number2)) {
                        throw ScriptRuntime.rangeError("offset out of range");
                    }
                    length = ScriptRuntime.toInt32(number2);
                } else {
                    length = nativeArrayBuffer.getLength() - int32;
                }
                if (length < 0) {
                    throw ScriptRuntime.rangeError("length out of range");
                }
                if (int32 < 0 || int32 + length > nativeArrayBuffer.getLength()) {
                    throw ScriptRuntime.rangeError("offset out of range");
                }
                return new NativeDataView(nativeArrayBuffer, int32, length);
            }
        }
        throw ScriptRuntime.constructError("TypeError", "Missing parameters");
    }

    private Object js_getFloat(int i, Object[] objArr) {
        int iDeterminePos = determinePos(objArr);
        rangeCheck(iDeterminePos, i);
        boolean z = NativeArrayBufferView.isArg(objArr, 1) && i > 1 && ScriptRuntime.toBoolean(objArr[1]);
        if (i == 4) {
            return ByteIo.readFloat32(this.arrayBuffer.buffer, this.offset + iDeterminePos, z);
        }
        if (i == 8) {
            return ByteIo.readFloat64(this.arrayBuffer.buffer, this.offset + iDeterminePos, z);
        }
        throw new AssertionError();
    }

    private Object js_getInt(int i, boolean z, Object[] objArr) {
        int iDeterminePos = determinePos(objArr);
        rangeCheck(iDeterminePos, i);
        boolean z2 = NativeArrayBufferView.isArg(objArr, 1) && i > 1 && ScriptRuntime.toBoolean(objArr[1]);
        if (i == 1) {
            byte[] bArr = this.arrayBuffer.buffer;
            int i2 = this.offset + iDeterminePos;
            return z ? ByteIo.readInt8(bArr, i2) : ByteIo.readUint8(bArr, i2);
        }
        if (i == 2) {
            byte[] bArr2 = this.arrayBuffer.buffer;
            int i3 = this.offset + iDeterminePos;
            return z ? ByteIo.readInt16(bArr2, i3, z2) : ByteIo.readUint16(bArr2, i3, z2);
        }
        if (i != 4) {
            throw new AssertionError();
        }
        byte[] bArr3 = this.arrayBuffer.buffer;
        int i4 = this.offset + iDeterminePos;
        return z ? ByteIo.readInt32(bArr3, i4, z2) : ByteIo.readUint32(bArr3, i4, z2);
    }

    private void js_setFloat(int i, Object[] objArr) {
        int iDeterminePos = determinePos(objArr);
        if (iDeterminePos < 0) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
        boolean z = NativeArrayBufferView.isArg(objArr, 2) && i > 1 && ScriptRuntime.toBoolean(objArr[2]);
        double number = objArr.length > 1 ? ScriptRuntime.toNumber(objArr[1]) : Double.NaN;
        if (iDeterminePos + i > this.byteLength) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
        if (i == 4) {
            ByteIo.writeFloat32(this.arrayBuffer.buffer, this.offset + iDeterminePos, number, z);
        } else {
            if (i != 8) {
                throw new AssertionError();
            }
            ByteIo.writeFloat64(this.arrayBuffer.buffer, this.offset + iDeterminePos, number, z);
        }
    }

    private void js_setInt(int i, boolean z, Object[] objArr) {
        int iDeterminePos = determinePos(objArr);
        if (iDeterminePos < 0) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
        boolean z2 = NativeArrayBufferView.isArg(objArr, 2) && i > 1 && ScriptRuntime.toBoolean(objArr[2]);
        Object obj = ScriptRuntime.zeroObj;
        if (objArr.length > 1) {
            obj = objArr[1];
        }
        if (i == 1) {
            if (z) {
                int int8 = Conversions.toInt8(obj);
                if (i + iDeterminePos > this.byteLength) {
                    throw ScriptRuntime.rangeError("offset out of range");
                }
                ByteIo.writeInt8(this.arrayBuffer.buffer, this.offset + iDeterminePos, int8);
                return;
            }
            int uint8 = Conversions.toUint8(obj);
            if (i + iDeterminePos > this.byteLength) {
                throw ScriptRuntime.rangeError("offset out of range");
            }
            ByteIo.writeUint8(this.arrayBuffer.buffer, this.offset + iDeterminePos, uint8);
            return;
        }
        if (i == 2) {
            if (z) {
                int int16 = Conversions.toInt16(obj);
                if (i + iDeterminePos > this.byteLength) {
                    throw ScriptRuntime.rangeError("offset out of range");
                }
                ByteIo.writeInt16(this.arrayBuffer.buffer, this.offset + iDeterminePos, int16, z2);
                return;
            }
            int uint16 = Conversions.toUint16(obj);
            if (i + iDeterminePos > this.byteLength) {
                throw ScriptRuntime.rangeError("offset out of range");
            }
            ByteIo.writeUint16(this.arrayBuffer.buffer, this.offset + iDeterminePos, uint16, z2);
            return;
        }
        if (i != 4) {
            throw new AssertionError();
        }
        if (z) {
            int int32 = Conversions.toInt32(obj);
            if (i + iDeterminePos > this.byteLength) {
                throw ScriptRuntime.rangeError("offset out of range");
            }
            ByteIo.writeInt32(this.arrayBuffer.buffer, this.offset + iDeterminePos, int32, z2);
            return;
        }
        long uint32 = Conversions.toUint32(obj);
        if (i + iDeterminePos > this.byteLength) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
        ByteIo.writeUint32(this.arrayBuffer.buffer, this.offset + iDeterminePos, uint32, z2);
    }

    private void rangeCheck(int i, int i2) {
        if (i < 0 || i + i2 > this.byteLength) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
    }

    private static NativeDataView realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeDataView) {
            return (NativeDataView) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(getClassName())) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        switch (iMethodId) {
            case 1:
                return js_constructor(objArr);
            case 2:
                return realThis(scriptable2, idFunctionObject).js_getInt(1, true, objArr);
            case 3:
                return realThis(scriptable2, idFunctionObject).js_getInt(1, false, objArr);
            case 4:
                return realThis(scriptable2, idFunctionObject).js_getInt(2, true, objArr);
            case 5:
                return realThis(scriptable2, idFunctionObject).js_getInt(2, false, objArr);
            case 6:
                return realThis(scriptable2, idFunctionObject).js_getInt(4, true, objArr);
            case 7:
                return realThis(scriptable2, idFunctionObject).js_getInt(4, false, objArr);
            case 8:
                return realThis(scriptable2, idFunctionObject).js_getFloat(4, objArr);
            case 9:
                return realThis(scriptable2, idFunctionObject).js_getFloat(8, objArr);
            case 10:
                realThis(scriptable2, idFunctionObject).js_setInt(1, true, objArr);
                return Undefined.instance;
            case 11:
                realThis(scriptable2, idFunctionObject).js_setInt(1, false, objArr);
                return Undefined.instance;
            case 12:
                realThis(scriptable2, idFunctionObject).js_setInt(2, true, objArr);
                return Undefined.instance;
            case 13:
                realThis(scriptable2, idFunctionObject).js_setInt(2, false, objArr);
                return Undefined.instance;
            case 14:
                realThis(scriptable2, idFunctionObject).js_setInt(4, true, objArr);
                return Undefined.instance;
            case 15:
                realThis(scriptable2, idFunctionObject).js_setInt(4, false, objArr);
                return Undefined.instance;
            case 16:
                realThis(scriptable2, idFunctionObject).js_setFloat(4, objArr);
                return Undefined.instance;
            case 17:
                realThis(scriptable2, idFunctionObject).js_setFloat(8, objArr);
                return Undefined.instance;
            default:
                throw new IllegalArgumentException(String.valueOf(iMethodId));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:58:0x00ce  */
    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int i = 8;
        switch (str.length()) {
            case 7:
                char cCharAt = str.charAt(0);
                if (cCharAt == 'g') {
                    str2 = "getInt8";
                    i = 2;
                } else if (cCharAt != 's') {
                    str2 = null;
                    i = 0;
                } else {
                    str2 = "setInt8";
                    i = 10;
                }
                break;
            case 8:
                i = 6;
                char cCharAt2 = str.charAt(6);
                if (cCharAt2 == '1') {
                    char cCharAt3 = str.charAt(0);
                    if (cCharAt3 == 'g') {
                        str2 = "getInt16";
                        i = 4;
                    } else if (cCharAt3 != 's') {
                        str2 = null;
                        i = 0;
                    } else {
                        str2 = "setInt16";
                        i = 12;
                    }
                } else if (cCharAt2 == '3') {
                    char cCharAt4 = str.charAt(0);
                    if (cCharAt4 == 'g') {
                        str2 = "getInt32";
                    } else if (cCharAt4 != 's') {
                        str2 = null;
                        i = 0;
                    } else {
                        str2 = "setInt32";
                        i = 14;
                    }
                } else if (cCharAt2 == 't') {
                    char cCharAt5 = str.charAt(0);
                    if (cCharAt5 == 'g') {
                        str2 = "getUint8";
                        i = 3;
                    } else if (cCharAt5 != 's') {
                        str2 = null;
                        i = 0;
                    } else {
                        str2 = "setUint8";
                        i = 11;
                    }
                } else {
                    str2 = null;
                    i = 0;
                }
                break;
            case 9:
                char cCharAt6 = str.charAt(0);
                if (cCharAt6 == 'g') {
                    char cCharAt7 = str.charAt(8);
                    if (cCharAt7 == '2') {
                        str2 = "getUint32";
                        i = 7;
                    } else if (cCharAt7 != '6') {
                        str2 = null;
                        i = 0;
                    } else {
                        str2 = "getUint16";
                        i = 5;
                    }
                } else if (cCharAt6 == 's') {
                    char cCharAt8 = str.charAt(8);
                    if (cCharAt8 == '2') {
                        str2 = "setUint32";
                        i = 15;
                    } else if (cCharAt8 != '6') {
                        str2 = null;
                        i = 0;
                    } else {
                        str2 = "setUint16";
                        i = 13;
                    }
                } else {
                    str2 = null;
                    i = 0;
                }
                break;
            case 10:
                char cCharAt9 = str.charAt(0);
                if (cCharAt9 == 'g') {
                    char cCharAt10 = str.charAt(9);
                    if (cCharAt10 == '2') {
                        str2 = "getFloat32";
                    } else if (cCharAt10 != '4') {
                        str2 = null;
                        i = 0;
                    } else {
                        str2 = "getFloat64";
                        i = 9;
                    }
                } else if (cCharAt9 == 's') {
                    char cCharAt11 = str.charAt(9);
                    if (cCharAt11 == '2') {
                        str2 = "setFloat32";
                        i = 16;
                    } else if (cCharAt11 != '4') {
                        str2 = null;
                        i = 0;
                    } else {
                        str2 = "setFloat64";
                        i = 17;
                    }
                } else {
                    str2 = null;
                    i = 0;
                }
                break;
            case 11:
                str2 = "constructor";
                i = 1;
                break;
            default:
                str2 = null;
                i = 0;
                break;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 2;
        switch (i) {
            case 1:
                i2 = 3;
                str = "constructor";
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 2:
                str2 = "getInt8";
                str = str2;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 3:
                str2 = "getUint8";
                str = str2;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 4:
                str2 = "getInt16";
                str = str2;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 5:
                str2 = "getUint16";
                str = str2;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 6:
                str2 = "getInt32";
                str = str2;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 7:
                str2 = "getUint32";
                str = str2;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 8:
                str2 = "getFloat32";
                str = str2;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 9:
                str2 = "getFloat64";
                str = str2;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 10:
                str = "setInt8";
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 11:
                str = "setUint8";
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 12:
                str = "setInt16";
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 13:
                str = "setUint16";
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 14:
                str = "setInt32";
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 15:
                str = "setUint32";
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 16:
                str = "setFloat32";
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 17:
                str = "setFloat64";
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }
}
