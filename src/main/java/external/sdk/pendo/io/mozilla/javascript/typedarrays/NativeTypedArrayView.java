package external.sdk.pendo.io.mozilla.javascript.typedarrays;

import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.pspdfkit.analytics.Analytics;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.ExternalArrayData;
import external.sdk.pendo.io.mozilla.javascript.IdFunctionObject;
import external.sdk.pendo.io.mozilla.javascript.IdScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.NativeArray;
import external.sdk.pendo.io.mozilla.javascript.NativeArrayIterator;
import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.Symbol;
import external.sdk.pendo.io.mozilla.javascript.SymbolKey;
import external.sdk.pendo.io.mozilla.javascript.Undefined;
import external.sdk.pendo.io.mozilla.javascript.Wrapper;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeTypedArrayView<T> extends NativeArrayBufferView implements List<T>, RandomAccess, ExternalArrayData {
    private static final int Id_BYTES_PER_ELEMENT = 5;
    private static final int Id_constructor = 1;
    private static final int Id_get = 3;
    private static final int Id_length = 4;
    private static final int Id_set = 4;
    private static final int Id_subarray = 5;
    private static final int Id_toString = 2;
    private static final int MAX_INSTANCE_ID = 5;
    protected static final int MAX_PROTOTYPE_ID = 6;
    private static final int SymbolId_iterator = 6;
    private static final long serialVersionUID = -4963053773152251274L;
    protected final int length;

    protected NativeTypedArrayView() {
        this.length = 0;
    }

    private NativeTypedArrayView<T> js_constructor(Context context, Scriptable scriptable, Object[] objArr) {
        Object obj;
        int int32 = 0;
        if (NativeArrayBufferView.isArg(objArr, 0) && (obj = objArr[0]) != null) {
            if ((obj instanceof Number) || (obj instanceof String)) {
                int int33 = ScriptRuntime.toInt32(obj);
                return construct(makeArrayBuffer(context, scriptable, int33), 0, int33);
            }
            if (obj instanceof NativeTypedArrayView) {
                NativeTypedArrayView nativeTypedArrayView = (NativeTypedArrayView) obj;
                NativeTypedArrayView<T> nativeTypedArrayViewConstruct = construct(makeArrayBuffer(context, scriptable, nativeTypedArrayView.length), 0, nativeTypedArrayView.length);
                while (int32 < nativeTypedArrayView.length) {
                    nativeTypedArrayViewConstruct.js_set(int32, nativeTypedArrayView.js_get(int32));
                    int32++;
                }
                return nativeTypedArrayViewConstruct;
            }
            if (obj instanceof NativeArrayBuffer) {
                NativeArrayBuffer nativeArrayBuffer = (NativeArrayBuffer) obj;
                int32 = NativeArrayBufferView.isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : 0;
                int int34 = NativeArrayBufferView.isArg(objArr, 2) ? ScriptRuntime.toInt32(objArr[2]) * getBytesPerElement() : nativeArrayBuffer.getLength() - int32;
                if (int32 >= 0) {
                    byte[] bArr = nativeArrayBuffer.buffer;
                    if (int32 <= bArr.length) {
                        if (int34 < 0 || int32 + int34 > bArr.length) {
                            throw ScriptRuntime.rangeError("length out of range");
                        }
                        if (int32 % getBytesPerElement() != 0) {
                            throw ScriptRuntime.rangeError("offset must be a multiple of the byte size");
                        }
                        if (int34 % getBytesPerElement() == 0) {
                            return construct(nativeArrayBuffer, int32, int34 / getBytesPerElement());
                        }
                        throw ScriptRuntime.rangeError("offset and buffer must be a multiple of the byte size");
                    }
                }
                throw ScriptRuntime.rangeError("offset out of range");
            }
            if (!(obj instanceof NativeArray)) {
                if (!ScriptRuntime.isArrayObject(obj)) {
                    throw ScriptRuntime.constructError("Error", "invalid argument");
                }
                Object[] arrayElements = ScriptRuntime.getArrayElements((Scriptable) obj);
                NativeTypedArrayView<T> nativeTypedArrayViewConstruct2 = construct(makeArrayBuffer(context, scriptable, arrayElements.length), 0, arrayElements.length);
                while (int32 < arrayElements.length) {
                    nativeTypedArrayViewConstruct2.js_set(int32, arrayElements[int32]);
                    int32++;
                }
                return nativeTypedArrayViewConstruct2;
            }
            NativeArray nativeArray = (NativeArray) obj;
            NativeTypedArrayView<T> nativeTypedArrayViewConstruct3 = construct(makeArrayBuffer(context, scriptable, nativeArray.size()), 0, nativeArray.size());
            while (int32 < nativeArray.size()) {
                Object objUnwrap = nativeArray.get(int32, nativeArray);
                if (objUnwrap == Scriptable.NOT_FOUND || objUnwrap == Undefined.instance) {
                    objUnwrap = ScriptRuntime.NaNobj;
                } else if (objUnwrap instanceof Wrapper) {
                    objUnwrap = ((Wrapper) objUnwrap).unwrap();
                }
                nativeTypedArrayViewConstruct3.js_set(int32, objUnwrap);
                int32++;
            }
            return nativeTypedArrayViewConstruct3;
        }
        return construct(new NativeArrayBuffer(), 0, 0);
    }

    private Object js_subarray(Context context, Scriptable scriptable, int i, int i2) {
        if (i < 0) {
            i += this.length;
        }
        if (i2 < 0) {
            i2 += this.length;
        }
        int iMax = Math.max(0, i);
        int iMax2 = Math.max(0, Math.min(this.length, i2) - iMax);
        return context.newObject(scriptable, getClassName(), new Object[]{this.arrayBuffer, Integer.valueOf(Math.min(iMax * getBytesPerElement(), this.arrayBuffer.getLength())), Integer.valueOf(iMax2)});
    }

    private NativeArrayBuffer makeArrayBuffer(Context context, Scriptable scriptable, int i) {
        return (NativeArrayBuffer) context.newObject(scriptable, NativeArrayBuffer.CLASS_NAME, new Object[]{Double.valueOf(((double) i) * ((double) getBytesPerElement()))});
    }

    private void setRange(NativeArray nativeArray, int i) {
        if (i > this.length) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
        if (nativeArray.size() + i > this.length) {
            throw ScriptRuntime.rangeError("offset + length out of range");
        }
        Iterator it = nativeArray.iterator();
        while (it.hasNext()) {
            js_set(i, it.next());
            i++;
        }
    }

    @Override // java.util.List
    public void add(int i, T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    protected boolean checkIndex(int i) {
        return i < 0 || i >= this.length;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    protected abstract NativeTypedArrayView<T> construct(NativeArrayBuffer nativeArrayBuffer, int i, int i2);

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void delete(int i) {
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            NativeTypedArrayView nativeTypedArrayView = (NativeTypedArrayView) obj;
            if (this.length != nativeTypedArrayView.length) {
                return false;
            }
            for (int i = 0; i < this.length; i++) {
                if (!js_get(i).equals(nativeTypedArrayView.js_get(i))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(getClassName())) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        switch (iMethodId) {
            case 1:
                if (scriptable2 == null || context.getLanguageVersion() < 200) {
                    return js_constructor(context, scriptable, objArr);
                }
                throw ScriptRuntime.typeError1("msg.only.from.new", getClassName());
            case 2:
                NativeTypedArrayView<T> nativeTypedArrayViewRealThis = realThis(scriptable2, idFunctionObject);
                int arrayLength = nativeTypedArrayViewRealThis.getArrayLength();
                StringBuilder sb = new StringBuilder();
                if (arrayLength > 0) {
                    sb.append(ScriptRuntime.toString(nativeTypedArrayViewRealThis.js_get(0)));
                }
                for (int i = 1; i < arrayLength; i++) {
                    sb.append(AbstractJsonLexerKt.COMMA);
                    sb.append(ScriptRuntime.toString(nativeTypedArrayViewRealThis.js_get(i)));
                }
                return sb.toString();
            case 3:
                if (objArr.length > 0) {
                    return realThis(scriptable2, idFunctionObject).js_get(ScriptRuntime.toInt32(objArr[0]));
                }
                throw ScriptRuntime.constructError("Error", "invalid arguments");
            case 4:
                if (objArr.length > 0) {
                    NativeTypedArrayView<T> nativeTypedArrayViewRealThis2 = realThis(scriptable2, idFunctionObject);
                    Object obj = objArr[0];
                    if (obj instanceof NativeTypedArrayView) {
                        nativeTypedArrayViewRealThis2.setRange((NativeTypedArrayView) objArr[0], NativeArrayBufferView.isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : 0);
                        return Undefined.instance;
                    }
                    if (obj instanceof NativeArray) {
                        nativeTypedArrayViewRealThis2.setRange((NativeArray) objArr[0], NativeArrayBufferView.isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : 0);
                        return Undefined.instance;
                    }
                    if (obj instanceof Scriptable) {
                        return Undefined.instance;
                    }
                    if (NativeArrayBufferView.isArg(objArr, 2)) {
                        return nativeTypedArrayViewRealThis2.js_set(ScriptRuntime.toInt32(objArr[0]), objArr[1]);
                    }
                }
                throw ScriptRuntime.constructError("Error", "invalid arguments");
            case 5:
                if (objArr.length <= 0) {
                    throw ScriptRuntime.constructError("Error", "invalid arguments");
                }
                NativeTypedArrayView<T> nativeTypedArrayViewRealThis3 = realThis(scriptable2, idFunctionObject);
                return nativeTypedArrayViewRealThis3.js_subarray(context, scriptable, ScriptRuntime.toInt32(objArr[0]), NativeArrayBufferView.isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : nativeTypedArrayViewRealThis3.length);
            case 6:
                return new NativeArrayIterator(scriptable, scriptable2, NativeArrayIterator.ARRAY_ITERATOR_TYPE.VALUES);
            default:
                throw new IllegalArgumentException(String.valueOf(iMethodId));
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        idFunctionObject.defineProperty("BYTES_PER_ELEMENT", ScriptRuntime.wrapInt(getBytesPerElement()), 7);
        super.fillConstructorProperties(idFunctionObject);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeArrayBufferView, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findInstanceIdInfo(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 6) {
            str2 = Analytics.Data.LENGTH;
            i = 4;
        } else if (length == 17) {
            str2 = "BYTES_PER_ELEMENT";
            i = 5;
        } else {
            str2 = null;
            i = 0;
        }
        int i2 = (str2 == null || str2 == str || str2.equals(str)) ? i : 0;
        if (i2 == 0) {
            return super.findInstanceIdInfo(str);
        }
        return i2 == 5 ? IdScriptableObject.instanceIdInfo(7, i2) : IdScriptableObject.instanceIdInfo(5, i2);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(Symbol symbol) {
        return SymbolKey.ITERATOR.equals(symbol) ? 6 : 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        return js_get(i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ExternalArrayData
    public Object getArrayElement(int i) {
        return js_get(i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ExternalArrayData
    public int getArrayLength() {
        return this.length;
    }

    public abstract int getBytesPerElement();

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object[] getIds() {
        Object[] objArr = new Object[this.length];
        for (int i = 0; i < this.length; i++) {
            objArr[i] = Integer.valueOf(i);
        }
        return objArr;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeArrayBufferView, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected String getInstanceIdName(int i) {
        if (i != 4) {
            return i != 5 ? super.getInstanceIdName(i) : "BYTES_PER_ELEMENT";
        }
        return Analytics.Data.LENGTH;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeArrayBufferView, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected Object getInstanceIdValue(int i) {
        int bytesPerElement;
        if (i == 4) {
            bytesPerElement = this.length;
        } else {
            if (i != 5) {
                return super.getInstanceIdValue(i);
            }
            bytesPerElement = getBytesPerElement();
        }
        return ScriptRuntime.wrapInt(bytesPerElement);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeArrayBufferView, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int getMaxInstanceId() {
        return 5;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        return !checkIndex(i);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        int iHashCode = 0;
        for (int i = 0; i < this.length; i++) {
            iHashCode += js_get(i).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        for (int i = 0; i < this.length; i++) {
            if (obj.equals(js_get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        int i2;
        String str2;
        String str3;
        if (i == 6) {
            initPrototypeMethod(getClassName(), i, SymbolKey.ITERATOR, "[Symbol.iterator]", 0);
            return;
        }
        int i3 = 3;
        if (i != 1) {
            if (i == 2) {
                i3 = 0;
                str = "toString";
            } else if (i != 3) {
                if (i == 4) {
                    str3 = "set";
                } else {
                    if (i != 5) {
                        throw new IllegalArgumentException(String.valueOf(i));
                    }
                    str3 = "subarray";
                }
                str2 = str3;
                i2 = 2;
            } else {
                str2 = PasskeyWebListener.GET_UNIQUE_KEY;
                i2 = 1;
            }
            initPrototypeMethod(getClassName(), i, str2, (String) null, i2);
        }
        str = "constructor";
        i2 = i3;
        str2 = str;
        initPrototypeMethod(getClassName(), i, str2, (String) null, i2);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new NativeTypedArrayIterator(this, 0);
    }

    protected abstract Object js_get(int i);

    protected abstract Object js_set(int i, Object obj);

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        for (int i = this.length - 1; i >= 0; i--) {
            if (obj.equals(js_get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return new NativeTypedArrayIterator(this, 0);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        js_set(i, obj);
    }

    protected abstract NativeTypedArrayView<T> realThis(Scriptable scriptable, IdFunctionObject idFunctionObject);

    @Override // java.util.List
    public T remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ExternalArrayData
    public void setArrayElement(int i, Object obj) {
        js_set(i, obj);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, java.util.List, java.util.Collection
    public int size() {
        return this.length;
    }

    @Override // java.util.List
    public List<T> subList(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        Object[] objArr = new Object[this.length];
        for (int i = 0; i < this.length; i++) {
            objArr[i] = js_get(i);
        }
        return objArr;
    }

    protected NativeTypedArrayView(NativeArrayBuffer nativeArrayBuffer, int i, int i2, int i3) {
        super(nativeArrayBuffer, i, i3);
        this.length = i2;
    }

    private void setRange(NativeTypedArrayView<T> nativeTypedArrayView, int i) {
        int i2 = this.length;
        if (i >= i2) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
        int i3 = nativeTypedArrayView.length;
        if (i3 > i2 - i) {
            throw ScriptRuntime.rangeError("source array too long");
        }
        int i4 = 0;
        if (nativeTypedArrayView.arrayBuffer != this.arrayBuffer) {
            while (i4 < nativeTypedArrayView.length) {
                js_set(i4 + i, nativeTypedArrayView.js_get(i4));
                i4++;
            }
            return;
        }
        Object[] objArr = new Object[i3];
        for (int i5 = 0; i5 < nativeTypedArrayView.length; i5++) {
            objArr[i5] = nativeTypedArrayView.js_get(i5);
        }
        while (i4 < nativeTypedArrayView.length) {
            js_set(i4 + i, objArr[i4]);
            i4++;
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 1;
        if (length != 3) {
            if (length == 8) {
                char cCharAt = str.charAt(0);
                if (cCharAt == 's') {
                    str2 = "subarray";
                    i = 5;
                } else if (cCharAt == 't') {
                    str2 = "toString";
                    i = 2;
                }
            } else if (length == 11) {
                str2 = "constructor";
            }
            if (str2 != null || str2 == str || str2.equals(str)) {
                return i;
            }
            return 0;
        }
        char cCharAt2 = str.charAt(0);
        if (cCharAt2 == 'g') {
            if (str.charAt(2) == 't' && str.charAt(1) == 'e') {
                return 3;
            }
        } else if (cCharAt2 == 's' && str.charAt(2) == 't' && str.charAt(1) == 'e') {
            return 4;
        }
        str2 = null;
        i = 0;
        if (str2 != null) {
        }
        return i;
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i) {
        if (checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return new NativeTypedArrayIterator(this, i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public <U> U[] toArray(U[] uArr) {
        if (uArr.length < this.length) {
            uArr = (U[]) ((Object[]) Array.newInstance(uArr.getClass().getComponentType(), this.length));
        }
        for (int i = 0; i < this.length; i++) {
            try {
                uArr[i] = js_get(i);
            } catch (ClassCastException unused) {
                throw new ArrayStoreException();
            }
        }
        return uArr;
    }
}
