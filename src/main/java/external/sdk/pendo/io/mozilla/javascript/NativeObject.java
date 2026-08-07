package external.sdk.pendo.io.mozilla.javascript;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class NativeObject extends IdScriptableObject implements Map {
    private static final int ConstructorId_assign = -15;
    private static final int ConstructorId_create = -9;
    private static final int ConstructorId_defineProperties = -8;
    private static final int ConstructorId_defineProperty = -5;
    private static final int ConstructorId_freeze = -13;
    private static final int ConstructorId_getOwnPropertyDescriptor = -4;
    private static final int ConstructorId_getOwnPropertyNames = -3;
    private static final int ConstructorId_getOwnPropertySymbols = -14;
    private static final int ConstructorId_getPrototypeOf = -1;
    private static final int ConstructorId_is = -16;
    private static final int ConstructorId_isExtensible = -6;
    private static final int ConstructorId_isFrozen = -11;
    private static final int ConstructorId_isSealed = -10;
    private static final int ConstructorId_keys = -2;
    private static final int ConstructorId_preventExtensions = -7;
    private static final int ConstructorId_seal = -12;
    private static final int ConstructorId_setPrototypeOf = -17;
    private static final int Id___defineGetter__ = 9;
    private static final int Id___defineSetter__ = 10;
    private static final int Id___lookupGetter__ = 11;
    private static final int Id___lookupSetter__ = 12;
    private static final int Id_constructor = 1;
    private static final int Id_hasOwnProperty = 5;
    private static final int Id_isPrototypeOf = 7;
    private static final int Id_propertyIsEnumerable = 6;
    private static final int Id_toLocaleString = 3;
    private static final int Id_toSource = 8;
    private static final int Id_toString = 2;
    private static final int Id_valueOf = 4;
    private static final int MAX_PROTOTYPE_ID = 12;
    private static final Object OBJECT_TAG = "Object";
    private static final long serialVersionUID = -6345305608474346996L;

    class EntrySet extends AbstractSet<Map.Entry<Object, Object>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Object, Object>> iterator() {
            return new Iterator<Map.Entry<Object, Object>>() { // from class: external.sdk.pendo.io.mozilla.javascript.NativeObject.EntrySet.1
                Object[] ids;
                Object key = null;
                int index = 0;

                {
                    this.ids = NativeObject.this.getIds();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.index < this.ids.length;
                }

                @Override // java.util.Iterator
                public void remove() {
                    Object obj = this.key;
                    if (obj == null) {
                        throw new IllegalStateException();
                    }
                    NativeObject.this.remove(obj);
                    this.key = null;
                }

                @Override // java.util.Iterator
                public Map.Entry<Object, Object> next() {
                    Object[] objArr = this.ids;
                    int i = this.index;
                    this.index = i + 1;
                    final Object obj = objArr[i];
                    this.key = obj;
                    final Object obj2 = NativeObject.this.get(obj);
                    return new Map.Entry<Object, Object>() { // from class: external.sdk.pendo.io.mozilla.javascript.NativeObject.EntrySet.1.1
                        @Override // java.util.Map.Entry
                        public boolean equals(Object obj3) {
                            if (!(obj3 instanceof Map.Entry)) {
                                return false;
                            }
                            Map.Entry entry = (Map.Entry) obj3;
                            Object obj4 = obj;
                            if (obj4 != null ? obj4.equals(entry.getKey()) : entry.getKey() == null) {
                                Object obj5 = obj2;
                                if (obj5 == null) {
                                    if (entry.getValue() == null) {
                                        return true;
                                    }
                                } else if (obj5.equals(entry.getValue())) {
                                    return true;
                                }
                            }
                            return false;
                        }

                        @Override // java.util.Map.Entry
                        public Object getKey() {
                            return obj;
                        }

                        @Override // java.util.Map.Entry
                        public Object getValue() {
                            return obj2;
                        }

                        @Override // java.util.Map.Entry
                        public int hashCode() {
                            Object obj3 = obj;
                            int iHashCode = obj3 == null ? 0 : obj3.hashCode();
                            Object obj4 = obj2;
                            return iHashCode ^ (obj4 != null ? obj4.hashCode() : 0);
                        }

                        @Override // java.util.Map.Entry
                        public Object setValue(Object obj3) {
                            throw new UnsupportedOperationException();
                        }

                        public String toString() {
                            return obj + SimpleComparison.EQUAL_TO_OPERATION + obj2;
                        }
                    };
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return NativeObject.this.size();
        }
    }

    class KeySet extends AbstractSet<Object> {
        KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return NativeObject.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Object> iterator() {
            return new Iterator<Object>() { // from class: external.sdk.pendo.io.mozilla.javascript.NativeObject.KeySet.1
                Object[] ids;
                int index = 0;
                Object key;

                {
                    this.ids = NativeObject.this.getIds();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.index < this.ids.length;
                }

                @Override // java.util.Iterator
                public Object next() {
                    try {
                        Object[] objArr = this.ids;
                        int i = this.index;
                        this.index = i + 1;
                        Object obj = objArr[i];
                        this.key = obj;
                        return obj;
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        this.key = null;
                        throw new NoSuchElementException();
                    }
                }

                @Override // java.util.Iterator
                public void remove() {
                    Object obj = this.key;
                    if (obj == null) {
                        throw new IllegalStateException();
                    }
                    NativeObject.this.remove(obj);
                    this.key = null;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return NativeObject.this.size();
        }
    }

    class ValueCollection extends AbstractCollection<Object> {
        ValueCollection() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return new Iterator<Object>() { // from class: external.sdk.pendo.io.mozilla.javascript.NativeObject.ValueCollection.1
                Object[] ids;
                int index = 0;
                Object key;

                {
                    this.ids = NativeObject.this.getIds();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.index < this.ids.length;
                }

                @Override // java.util.Iterator
                public Object next() {
                    NativeObject nativeObject = NativeObject.this;
                    Object[] objArr = this.ids;
                    int i = this.index;
                    this.index = i + 1;
                    Object obj = objArr[i];
                    this.key = obj;
                    return nativeObject.get(obj);
                }

                @Override // java.util.Iterator
                public void remove() {
                    Object obj = this.key;
                    if (obj == null) {
                        throw new IllegalStateException();
                    }
                    NativeObject.this.remove(obj);
                    this.key = null;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return NativeObject.this.size();
        }
    }

    private static Scriptable getCompatibleObject(Context context, Scriptable scriptable, Object obj) {
        return context.getLanguageVersion() >= 200 ? ScriptableObject.ensureScriptable(ScriptRuntime.toObject(context, scriptable, obj)) : ScriptableObject.ensureScriptable(obj);
    }

    static void init(Scriptable scriptable, boolean z) {
        new NativeObject().exportAsJSClass(12, scriptable, z);
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return has((String) obj, this);
        }
        if (obj instanceof Number) {
            return has(((Number) obj).intValue(), this);
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        for (Object obj2 : values()) {
            if (obj == obj2) {
                return true;
            }
            if (obj != null && obj.equals(obj2)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        return new EntrySet();
    }

    /* JADX WARN: Code duplicated, block: B:116:0x017f  */
    /* JADX WARN: Code duplicated, block: B:136:0x01bb A[PHI: r0
      0x01bb: PHI (r0v165 boolean) = (r0v160 boolean), (r0v160 boolean), (r0v167 boolean), (r0v167 boolean) binds: [B:129:0x01a8, B:131:0x01ac, B:122:0x0191, B:124:0x0195] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:90:0x0128  */
    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        int int32;
        Object obj;
        boolean z;
        Object obj2;
        Object obj3;
        boolean zHas;
        boolean zHas2;
        Object getterOrSetter;
        Scriptable prototype;
        if (!idFunctionObject.hasTag(OBJECT_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        String name = AbstractJsonLexerKt.NULL;
        boolean z2 = true;
        z = true;
        z = true;
        boolean z3 = true;
        switch (iMethodId) {
            case -17:
                if (objArr.length < 2) {
                    throw ScriptRuntime.typeError1("msg.incompat.call", "setPrototypeOf");
                }
                Object obj4 = objArr[1];
                Scriptable scriptableEnsureScriptable = obj4 == null ? null : ScriptableObject.ensureScriptable(obj4);
                if (scriptableEnsureScriptable instanceof Symbol) {
                    throw ScriptRuntime.typeError1("msg.arg.not.object", ScriptRuntime.typeof(scriptableEnsureScriptable));
                }
                Object obj5 = objArr[0];
                if (context.getLanguageVersion() >= 200) {
                    ScriptRuntimeES6.requireObjectCoercible(context, obj5, idFunctionObject);
                }
                if (!(obj5 instanceof ScriptableObject)) {
                    return obj5;
                }
                ScriptableObject scriptableObject = (ScriptableObject) obj5;
                if (!scriptableObject.isExtensible()) {
                    throw ScriptRuntime.typeError0("msg.not.extensible");
                }
                for (Scriptable prototype2 = scriptableEnsureScriptable; prototype2 != null; prototype2 = prototype2.getPrototype()) {
                    if (prototype2 == scriptableObject) {
                        throw ScriptRuntime.typeError1("msg.object.cyclic.prototype", scriptableObject.getClass().getSimpleName());
                    }
                }
                scriptableObject.setPrototype(scriptableEnsureScriptable);
                return scriptableObject;
            case -16:
                return ScriptRuntime.wrapBoolean(ScriptRuntime.same(objArr.length < 1 ? Undefined.instance : objArr[0], objArr.length < 2 ? Undefined.instance : objArr[1]));
            case -15:
                if (objArr.length < 1) {
                    throw ScriptRuntime.typeError1("msg.incompat.call", "assign");
                }
                Scriptable object = ScriptRuntime.toObject(context, scriptable2, objArr[0]);
                for (int i = 1; i < objArr.length; i++) {
                    Object obj6 = objArr[i];
                    if (obj6 != null && !Undefined.isUndefined(obj6)) {
                        Scriptable object2 = ScriptRuntime.toObject(context, scriptable2, objArr[i]);
                        for (Object obj7 : object2.getIds()) {
                            if (obj7 instanceof String) {
                                String str = (String) obj7;
                                Object obj8 = object2.get(str, object2);
                                if (obj8 != Scriptable.NOT_FOUND && !Undefined.isUndefined(obj8)) {
                                    object.put(str, object, obj8);
                                }
                            } else if ((obj7 instanceof Number) && (obj = object2.get((int32 = ScriptRuntime.toInt32(obj7)), object2)) != Scriptable.NOT_FOUND && !Undefined.isUndefined(obj)) {
                                object.put(int32, object, obj);
                            }
                        }
                    }
                }
                return object;
            case -14:
                Object[] ids = ScriptableObject.ensureScriptableObject(getCompatibleObject(context, scriptable, objArr.length < 1 ? Undefined.instance : objArr[0])).getIds(true, true);
                ArrayList arrayList = new ArrayList();
                for (Object obj9 : ids) {
                    if (obj9 instanceof Symbol) {
                        arrayList.add(obj9);
                    }
                }
                return context.newArray(scriptable, arrayList.toArray());
            case -13:
                Object obj10 = objArr.length < 1 ? Undefined.instance : objArr[0];
                if (context.getLanguageVersion() >= 200 && !(obj10 instanceof ScriptableObject)) {
                    return obj10;
                }
                ScriptableObject scriptableObjectEnsureScriptableObject = ScriptableObject.ensureScriptableObject(obj10);
                for (Object obj11 : scriptableObjectEnsureScriptableObject.getIds(true, true)) {
                    ScriptableObject ownPropertyDescriptor = scriptableObjectEnsureScriptableObject.getOwnPropertyDescriptor(context, obj11);
                    if (isDataDescriptor(ownPropertyDescriptor) && Boolean.TRUE.equals(ownPropertyDescriptor.get("writable"))) {
                        ownPropertyDescriptor.put("writable", ownPropertyDescriptor, Boolean.FALSE);
                    }
                    if (Boolean.TRUE.equals(ownPropertyDescriptor.get("configurable"))) {
                        ownPropertyDescriptor.put("configurable", ownPropertyDescriptor, Boolean.FALSE);
                    }
                    scriptableObjectEnsureScriptableObject.defineOwnProperty(context, obj11, ownPropertyDescriptor, false);
                }
                scriptableObjectEnsureScriptableObject.preventExtensions();
                return scriptableObjectEnsureScriptableObject;
            case -12:
                Object obj12 = objArr.length < 1 ? Undefined.instance : objArr[0];
                if (context.getLanguageVersion() >= 200 && !(obj12 instanceof ScriptableObject)) {
                    return obj12;
                }
                ScriptableObject scriptableObjectEnsureScriptableObject2 = ScriptableObject.ensureScriptableObject(obj12);
                for (Object obj13 : scriptableObjectEnsureScriptableObject2.getAllIds()) {
                    ScriptableObject ownPropertyDescriptor2 = scriptableObjectEnsureScriptableObject2.getOwnPropertyDescriptor(context, obj13);
                    if (Boolean.TRUE.equals(ownPropertyDescriptor2.get("configurable"))) {
                        ownPropertyDescriptor2.put("configurable", ownPropertyDescriptor2, Boolean.FALSE);
                        scriptableObjectEnsureScriptableObject2.defineOwnProperty(context, obj13, ownPropertyDescriptor2, false);
                    }
                }
                scriptableObjectEnsureScriptableObject2.preventExtensions();
                return scriptableObjectEnsureScriptableObject2;
            case -11:
                Object obj14 = objArr.length < 1 ? Undefined.instance : objArr[0];
                if (context.getLanguageVersion() >= 200 && !(obj14 instanceof ScriptableObject)) {
                    return Boolean.TRUE;
                }
                ScriptableObject scriptableObjectEnsureScriptableObject3 = ScriptableObject.ensureScriptableObject(obj14);
                if (scriptableObjectEnsureScriptableObject3.isExtensible()) {
                    return Boolean.FALSE;
                }
                for (Object obj15 : scriptableObjectEnsureScriptableObject3.getAllIds()) {
                    ScriptableObject ownPropertyDescriptor3 = scriptableObjectEnsureScriptableObject3.getOwnPropertyDescriptor(context, obj15);
                    Boolean bool = Boolean.TRUE;
                    if (bool.equals(ownPropertyDescriptor3.get("configurable"))) {
                        return Boolean.FALSE;
                    }
                    if (isDataDescriptor(ownPropertyDescriptor3) && bool.equals(ownPropertyDescriptor3.get("writable"))) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            case -10:
                Object obj16 = objArr.length < 1 ? Undefined.instance : objArr[0];
                if (context.getLanguageVersion() >= 200 && !(obj16 instanceof ScriptableObject)) {
                    return Boolean.TRUE;
                }
                ScriptableObject scriptableObjectEnsureScriptableObject4 = ScriptableObject.ensureScriptableObject(obj16);
                if (scriptableObjectEnsureScriptableObject4.isExtensible()) {
                    return Boolean.FALSE;
                }
                for (Object obj17 : scriptableObjectEnsureScriptableObject4.getAllIds()) {
                    if (Boolean.TRUE.equals(scriptableObjectEnsureScriptableObject4.getOwnPropertyDescriptor(context, obj17).get("configurable"))) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            case -9:
                Object obj18 = objArr.length < 1 ? Undefined.instance : objArr[0];
                Scriptable scriptableEnsureScriptable2 = obj18 == null ? null : ScriptableObject.ensureScriptable(obj18);
                NativeObject nativeObject = new NativeObject();
                nativeObject.setParentScope(scriptable);
                nativeObject.setPrototype(scriptableEnsureScriptable2);
                if (objArr.length > 1 && !Undefined.isUndefined(objArr[1])) {
                    nativeObject.defineOwnProperties(context, ScriptableObject.ensureScriptableObject(Context.toObject(objArr[1], scriptable)));
                }
                return nativeObject;
            case -8:
                ScriptableObject scriptableObjectEnsureScriptableObject5 = ScriptableObject.ensureScriptableObject(objArr.length < 1 ? Undefined.instance : objArr[0]);
                scriptableObjectEnsureScriptableObject5.defineOwnProperties(context, ScriptableObject.ensureScriptableObject(Context.toObject(objArr.length < 2 ? Undefined.instance : objArr[1], scriptable)));
                return scriptableObjectEnsureScriptableObject5;
            case -7:
                Object obj19 = objArr.length < 1 ? Undefined.instance : objArr[0];
                if (context.getLanguageVersion() >= 200 && !(obj19 instanceof ScriptableObject)) {
                    return obj19;
                }
                ScriptableObject scriptableObjectEnsureScriptableObject6 = ScriptableObject.ensureScriptableObject(obj19);
                scriptableObjectEnsureScriptableObject6.preventExtensions();
                return scriptableObjectEnsureScriptableObject6;
            case -6:
                Object obj20 = objArr.length < 1 ? Undefined.instance : objArr[0];
                return (context.getLanguageVersion() < 200 || (obj20 instanceof ScriptableObject)) ? Boolean.valueOf(ScriptableObject.ensureScriptableObject(obj20).isExtensible()) : Boolean.FALSE;
            case -5:
                ScriptableObject scriptableObjectEnsureScriptableObject7 = ScriptableObject.ensureScriptableObject(objArr.length < 1 ? Undefined.instance : objArr[0]);
                scriptableObjectEnsureScriptableObject7.defineOwnProperty(context, objArr.length < 2 ? Undefined.instance : objArr[1], ScriptableObject.ensureScriptableObject(objArr.length < 3 ? Undefined.instance : objArr[2]));
                return scriptableObjectEnsureScriptableObject7;
            case -4:
                ScriptableObject ownPropertyDescriptor4 = ScriptableObject.ensureScriptableObject(getCompatibleObject(context, scriptable, objArr.length < 1 ? Undefined.instance : objArr[0])).getOwnPropertyDescriptor(context, objArr.length < 2 ? Undefined.instance : objArr[1]);
                return ownPropertyDescriptor4 == null ? Undefined.instance : ownPropertyDescriptor4;
            case -3:
                if (objArr.length < 1) {
                    obj2 = Undefined.instance;
                    z = false;
                } else {
                    z = false;
                    obj2 = objArr[0];
                }
                Object[] ids2 = ScriptableObject.ensureScriptableObject(getCompatibleObject(context, scriptable, obj2)).getIds(true, z);
                for (int i2 = 0; i2 < ids2.length; i2++) {
                    ids2[i2] = ScriptRuntime.toString(ids2[i2]);
                }
                return context.newArray(scriptable, ids2);
            case -2:
                Object[] ids3 = getCompatibleObject(context, scriptable, objArr.length < 1 ? Undefined.instance : objArr[0]).getIds();
                for (int i3 = 0; i3 < ids3.length; i3++) {
                    ids3[i3] = ScriptRuntime.toString(ids3[i3]);
                }
                return context.newArray(scriptable, ids3);
            case -1:
                return getCompatibleObject(context, scriptable, objArr.length < 1 ? Undefined.instance : objArr[0]).getPrototype();
            case 0:
            default:
                throw new IllegalArgumentException(String.valueOf(iMethodId));
            case 1:
                if (scriptable2 != null) {
                    return idFunctionObject.construct(context, scriptable, objArr);
                }
                return (objArr.length == 0 || (obj3 = objArr[0]) == null || Undefined.isUndefined(obj3)) ? new NativeObject() : ScriptRuntime.toObject(context, scriptable, objArr[0]);
            case 2:
                if (!context.hasFeature(4)) {
                    return ScriptRuntime.defaultObjectToString(scriptable2);
                }
                String strDefaultObjectToSource = ScriptRuntime.defaultObjectToSource(context, scriptable, scriptable2, objArr);
                int length = strDefaultObjectToSource.length();
                if (length == 0 || strDefaultObjectToSource.charAt(0) != '(') {
                    return strDefaultObjectToSource;
                }
                int i4 = length - 1;
                return strDefaultObjectToSource.charAt(i4) == ')' ? strDefaultObjectToSource.substring(1, i4) : strDefaultObjectToSource;
            case 3:
                Object property = ScriptableObject.getProperty(scriptable2, "toString");
                if (property instanceof Callable) {
                    return ((Callable) property).call(context, scriptable, scriptable2, ScriptRuntime.emptyArgs);
                }
                throw ScriptRuntime.notFunctionError(property);
            case 4:
                if (context.getLanguageVersion() < 180 || !(scriptable2 == null || Undefined.isUndefined(scriptable2))) {
                    return scriptable2;
                }
                throw ScriptRuntime.typeError0("msg." + (scriptable2 == null ? AbstractJsonLexerKt.NULL : "undef") + ".to.object");
            case 5:
                if (context.getLanguageVersion() >= 180 && (scriptable2 == null || Undefined.isUndefined(scriptable2))) {
                    throw ScriptRuntime.typeError0("msg." + (scriptable2 == null ? AbstractJsonLexerKt.NULL : "undef") + ".to.object");
                }
                Object obj21 = objArr.length < 1 ? Undefined.instance : objArr[0];
                if (obj21 instanceof Symbol) {
                    zHas = ScriptableObject.ensureSymbolScriptable(scriptable2).has((Symbol) obj21, scriptable2);
                } else {
                    ScriptRuntime.StringIdOrIndex stringIdOrIndex = ScriptRuntime.toStringIdOrIndex(context, obj21);
                    String str2 = stringIdOrIndex.stringId;
                    zHas = str2 == null ? scriptable2.has(stringIdOrIndex.index, scriptable2) : scriptable2.has(str2, scriptable2);
                }
                return ScriptRuntime.wrapBoolean(zHas);
            case 6:
                if (context.getLanguageVersion() >= 180 && (scriptable2 == null || Undefined.isUndefined(scriptable2))) {
                    throw ScriptRuntime.typeError0("msg." + (scriptable2 == null ? AbstractJsonLexerKt.NULL : "undef") + ".to.object");
                }
                Object obj22 = objArr.length < 1 ? Undefined.instance : objArr[0];
                if (!(obj22 instanceof Symbol)) {
                    ScriptRuntime.StringIdOrIndex stringIdOrIndex2 = ScriptRuntime.toStringIdOrIndex(context, obj22);
                    try {
                        String str3 = stringIdOrIndex2.stringId;
                        if (str3 == null) {
                            zHas2 = scriptable2.has(stringIdOrIndex2.index, scriptable2);
                            if (!zHas2 || !(scriptable2 instanceof ScriptableObject)) {
                                z3 = zHas2;
                            } else if ((((ScriptableObject) scriptable2).getAttributes(stringIdOrIndex2.index) & 2) != 0) {
                                z3 = false;
                            }
                        } else {
                            zHas2 = scriptable2.has(str3, scriptable2);
                            if (!zHas2 || !(scriptable2 instanceof ScriptableObject)) {
                                z3 = zHas2;
                            } else if ((((ScriptableObject) scriptable2).getAttributes(stringIdOrIndex2.stringId) & 2) != 0) {
                                z3 = false;
                            }
                        }
                    } catch (EvaluatorException e) {
                        String message = e.getMessage();
                        String string = stringIdOrIndex2.stringId;
                        if (string == null) {
                            string = Integer.toString(stringIdOrIndex2.index);
                        }
                        if (!message.startsWith(ScriptRuntime.getMessage1("msg.prop.not.found", string))) {
                            throw e;
                        }
                    }
                    break;
                } else {
                    Symbol symbol = (Symbol) obj22;
                    boolean zHas3 = ((SymbolScriptable) scriptable2).has(symbol, scriptable2);
                    if (!zHas3 || !(scriptable2 instanceof ScriptableObject)) {
                        z3 = zHas3;
                    } else if ((((ScriptableObject) scriptable2).getAttributes(symbol) & 2) != 0) {
                        z3 = false;
                    }
                }
                return ScriptRuntime.wrapBoolean(z3);
            case 7:
                if (context.getLanguageVersion() >= 180 && (scriptable2 == null || Undefined.isUndefined(scriptable2))) {
                    throw ScriptRuntime.typeError0("msg." + (scriptable2 == null ? AbstractJsonLexerKt.NULL : "undef") + ".to.object");
                }
                if (objArr.length != 0) {
                    Object obj23 = objArr[0];
                    if (obj23 instanceof Scriptable) {
                        Scriptable prototype3 = (Scriptable) obj23;
                        do {
                            prototype3 = prototype3.getPrototype();
                            if (prototype3 == scriptable2) {
                            }
                        } while (prototype3 != null);
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                return ScriptRuntime.wrapBoolean(z2);
            case 8:
                return ScriptRuntime.defaultObjectToSource(context, scriptable, scriptable2, objArr);
            case 9:
            case 10:
                if (objArr.length < 2 || !(objArr[1] instanceof Callable)) {
                    throw ScriptRuntime.notFunctionError(objArr.length >= 2 ? objArr[1] : Undefined.instance);
                }
                if (!(scriptable2 instanceof ScriptableObject)) {
                    if (scriptable2 != null) {
                        name = scriptable2.getClass().getName();
                    }
                    throw Context.reportRuntimeError2("msg.extend.scriptable", name, String.valueOf(objArr[0]));
                }
                ScriptableObject scriptableObject2 = (ScriptableObject) scriptable2;
                ScriptRuntime.StringIdOrIndex stringIdOrIndex3 = ScriptRuntime.toStringIdOrIndex(context, objArr[0]);
                String str4 = stringIdOrIndex3.stringId;
                scriptableObject2.setGetterOrSetter(str4, str4 != null ? 0 : stringIdOrIndex3.index, (Callable) objArr[1], iMethodId == 10);
                if (scriptableObject2 instanceof NativeArray) {
                    ((NativeArray) scriptableObject2).setDenseOnly(false);
                }
                return Undefined.instance;
            case 11:
            case 12:
                if (objArr.length < 1 || !(scriptable2 instanceof ScriptableObject)) {
                    return Undefined.instance;
                }
                ScriptableObject scriptableObject3 = (ScriptableObject) scriptable2;
                ScriptRuntime.StringIdOrIndex stringIdOrIndex4 = ScriptRuntime.toStringIdOrIndex(context, objArr[0]);
                int i5 = stringIdOrIndex4.stringId != null ? 0 : stringIdOrIndex4.index;
                boolean z4 = iMethodId == 12;
                while (true) {
                    getterOrSetter = scriptableObject3.getGetterOrSetter(stringIdOrIndex4.stringId, i5, z4);
                    if (getterOrSetter == null && (prototype = scriptableObject3.getPrototype()) != null && (prototype instanceof ScriptableObject)) {
                        scriptableObject3 = (ScriptableObject) prototype;
                    }
                }
                return getterOrSetter != null ? getterOrSetter : Undefined.instance;
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        Object obj = OBJECT_TAG;
        addIdFunctionProperty(idFunctionObject, obj, -1, "getPrototypeOf", 1);
        if (Context.getCurrentContext().version >= 200) {
            addIdFunctionProperty(idFunctionObject, obj, -17, "setPrototypeOf", 2);
        }
        addIdFunctionProperty(idFunctionObject, obj, -2, "keys", 1);
        addIdFunctionProperty(idFunctionObject, obj, -3, "getOwnPropertyNames", 1);
        addIdFunctionProperty(idFunctionObject, obj, -14, "getOwnPropertySymbols", 1);
        addIdFunctionProperty(idFunctionObject, obj, -4, "getOwnPropertyDescriptor", 2);
        addIdFunctionProperty(idFunctionObject, obj, -5, "defineProperty", 3);
        addIdFunctionProperty(idFunctionObject, obj, -6, "isExtensible", 1);
        addIdFunctionProperty(idFunctionObject, obj, -7, "preventExtensions", 1);
        addIdFunctionProperty(idFunctionObject, obj, -8, "defineProperties", 2);
        addIdFunctionProperty(idFunctionObject, obj, -9, PasskeyWebListener.CREATE_UNIQUE_KEY, 2);
        addIdFunctionProperty(idFunctionObject, obj, -10, "isSealed", 1);
        addIdFunctionProperty(idFunctionObject, obj, -11, "isFrozen", 1);
        addIdFunctionProperty(idFunctionObject, obj, -12, "seal", 1);
        addIdFunctionProperty(idFunctionObject, obj, -13, "freeze", 1);
        addIdFunctionProperty(idFunctionObject, obj, -15, "assign", 2);
        addIdFunctionProperty(idFunctionObject, obj, -16, "is", 2);
        super.fillConstructorProperties(idFunctionObject);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x008d  */
    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 7;
        if (length == 7) {
            str2 = "valueOf";
            i = 4;
        } else if (length == 8) {
            char cCharAt = str.charAt(3);
            if (cCharAt == 'o') {
                str2 = "toSource";
                i = 8;
            } else if (cCharAt == 't') {
                str2 = "toString";
                i = 2;
            } else {
                str2 = null;
                i = 0;
            }
        } else if (length == 11) {
            str2 = "constructor";
            i = 1;
        } else if (length == 16) {
            char cCharAt2 = str.charAt(2);
            if (cCharAt2 == 'd') {
                char cCharAt3 = str.charAt(8);
                if (cCharAt3 == 'G') {
                    str2 = "__defineGetter__";
                    i = 9;
                } else if (cCharAt3 == 'S') {
                    str2 = "__defineSetter__";
                    i = 10;
                } else {
                    str2 = null;
                    i = 0;
                }
            } else if (cCharAt2 != 'l') {
                str2 = null;
                i = 0;
            } else {
                char cCharAt4 = str.charAt(8);
                if (cCharAt4 == 'G') {
                    str2 = "__lookupGetter__";
                    i = 11;
                } else if (cCharAt4 == 'S') {
                    str2 = "__lookupSetter__";
                    i = 12;
                } else {
                    str2 = null;
                    i = 0;
                }
            }
        } else if (length == 20) {
            str2 = "propertyIsEnumerable";
            i = 6;
        } else if (length == 13) {
            str2 = "isPrototypeOf";
        } else if (length == 14) {
            char cCharAt5 = str.charAt(0);
            if (cCharAt5 == 'h') {
                str2 = "hasOwnProperty";
                i = 5;
            } else if (cCharAt5 == 't') {
                str2 = "toLocaleString";
                i = 3;
            } else {
                str2 = null;
                i = 0;
            }
        } else {
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Object";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 1;
        switch (i) {
            case 1:
                str = "constructor";
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                return;
            case 2:
                str = "toString";
                i2 = 0;
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                return;
            case 3:
                str = "toLocaleString";
                i2 = 0;
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                return;
            case 4:
                str = "valueOf";
                i2 = 0;
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                return;
            case 5:
                str = "hasOwnProperty";
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                return;
            case 6:
                str = "propertyIsEnumerable";
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                return;
            case 7:
                str = "isPrototypeOf";
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                return;
            case 8:
                str = "toSource";
                i2 = 0;
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                return;
            case 9:
                str2 = "__defineGetter__";
                i2 = 2;
                str = str2;
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                return;
            case 10:
                str2 = "__defineSetter__";
                i2 = 2;
                str = str2;
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                return;
            case 11:
                str = "__lookupGetter__";
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                return;
            case 12:
                str = "__lookupSetter__";
                initPrototypeMethod(OBJECT_TAG, i, str, i2);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    @Override // java.util.Map
    public Set<Object> keySet() {
        return new KeySet();
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        Object obj2 = get(obj);
        if (obj instanceof String) {
            delete((String) obj);
            return obj2;
        }
        if (obj instanceof Number) {
            delete(((Number) obj).intValue());
        }
        return obj2;
    }

    public String toString() {
        return ScriptRuntime.defaultObjectToString(this);
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return new ValueCollection();
    }
}
