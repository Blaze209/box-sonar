package external.sdk.pendo.io.mozilla.javascript.xmlimpl;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.requests.BoxRequestsSearch;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.pspdfkit.analytics.Analytics;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.IdFunctionObject;
import external.sdk.pendo.io.mozilla.javascript.IdScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.Kit;
import external.sdk.pendo.io.mozilla.javascript.NativeWith;
import external.sdk.pendo.io.mozilla.javascript.Ref;
import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.Undefined;
import external.sdk.pendo.io.mozilla.javascript.xml.XMLObject;

/* JADX INFO: loaded from: classes4.dex */
abstract class XMLObjectImpl extends XMLObject {
    private static final int Id_addNamespace = 2;
    private static final int Id_appendChild = 3;
    private static final int Id_attribute = 4;
    private static final int Id_attributes = 5;
    private static final int Id_child = 6;
    private static final int Id_childIndex = 7;
    private static final int Id_children = 8;
    private static final int Id_comments = 9;
    private static final int Id_constructor = 1;
    private static final int Id_contains = 10;
    private static final int Id_copy = 11;
    private static final int Id_descendants = 12;
    private static final int Id_elements = 13;
    private static final int Id_hasComplexContent = 18;
    private static final int Id_hasOwnProperty = 17;
    private static final int Id_hasSimpleContent = 19;
    private static final int Id_inScopeNamespaces = 14;
    private static final int Id_insertChildAfter = 15;
    private static final int Id_insertChildBefore = 16;
    private static final int Id_length = 20;
    private static final int Id_localName = 21;
    private static final int Id_name = 22;
    private static final int Id_namespace = 23;
    private static final int Id_namespaceDeclarations = 24;
    private static final int Id_nodeKind = 25;
    private static final int Id_normalize = 26;
    private static final int Id_parent = 27;
    private static final int Id_prependChild = 28;
    private static final int Id_processingInstructions = 29;
    private static final int Id_propertyIsEnumerable = 30;
    private static final int Id_removeNamespace = 31;
    private static final int Id_replace = 32;
    private static final int Id_setChildren = 33;
    private static final int Id_setLocalName = 34;
    private static final int Id_setName = 35;
    private static final int Id_setNamespace = 36;
    private static final int Id_text = 37;
    private static final int Id_toSource = 39;
    private static final int Id_toString = 38;
    private static final int Id_toXMLString = 40;
    private static final int Id_valueOf = 41;
    private static final int MAX_PROTOTYPE_ID = 41;
    private static final Object XMLOBJECT_TAG = "XMLObject";
    private static final long serialVersionUID = -2553684605738101761L;
    private XMLLibImpl lib;
    private boolean prototypeFlag;

    protected XMLObjectImpl(XMLLibImpl xMLLibImpl, Scriptable scriptable, XMLObject xMLObject) {
        initialize(xMLLibImpl, scriptable, xMLObject);
    }

    private static Object arg(Object[] objArr, int i) {
        return i < objArr.length ? objArr[i] : Undefined.instance;
    }

    private XMLList getMatches(XMLName xMLName) {
        XMLList xMLListNewXMLList = newXMLList();
        addMatches(xMLListNewXMLList, xMLName);
        return xMLListNewXMLList;
    }

    private Object[] toObjectArray(Object[] objArr) {
        int length = objArr.length;
        Object[] objArr2 = new Object[length];
        for (int i = 0; i < length; i++) {
            objArr2[i] = objArr[i];
        }
        return objArr2;
    }

    private void xmlMethodNotFound(Object obj, String str) {
        throw ScriptRuntime.notFunctionError(obj, str);
    }

    abstract void addMatches(XMLList xMLList, XMLName xMLName);

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLObject
    public final Object addValues(Context context, boolean z, Object obj) {
        XMLObject xMLObject;
        if (!(obj instanceof XMLObject)) {
            return obj == Undefined.instance ? ScriptRuntime.toString(this) : super.addValues(context, z, obj);
        }
        XMLObject xMLObject2 = (XMLObject) obj;
        if (z) {
            xMLObject = xMLObject2;
            xMLObject2 = this;
        } else {
            xMLObject = this;
        }
        return this.lib.addXMLObjects(context, xMLObject2, xMLObject);
    }

    abstract XMLList child(int i);

    abstract XMLList child(XMLName xMLName);

    abstract XMLList children();

    abstract XMLList comments();

    abstract boolean contains(Object obj);

    abstract XMLObjectImpl copy();

    final XML createEmptyXML() {
        return newXML(XmlNode.createEmpty(getProcessor()));
    }

    final Namespace createNamespace(XmlNode.Namespace namespace) {
        if (namespace == null) {
            return null;
        }
        return this.lib.createNamespaces(new XmlNode.Namespace[]{namespace})[0];
    }

    final Namespace[] createNamespaces(XmlNode.Namespace[] namespaceArr) {
        return this.lib.createNamespaces(namespaceArr);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void delete(String str) {
        deleteXMLProperty(this.lib.toXMLNameFromString(Context.getCurrentContext(), str));
    }

    abstract void deleteXMLProperty(XMLName xMLName);

    final String ecmaEscapeAttributeValue(String str) {
        String strEscapeAttributeValue = this.lib.escapeAttributeValue(str);
        return strEscapeAttributeValue.substring(1, strEscapeAttributeValue.length() - 1);
    }

    final XML ecmaToXml(Object obj) {
        return this.lib.ecmaToXml(obj);
    }

    abstract XMLList elements(XMLName xMLName);

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLObject
    public NativeWith enterDotQuery(Scriptable scriptable) {
        XMLWithScope xMLWithScope = new XMLWithScope(this.lib, scriptable, this);
        xMLWithScope.initAsDotQuery();
        return xMLWithScope;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLObject
    public NativeWith enterWith(Scriptable scriptable) {
        return new XMLWithScope(this.lib, scriptable, this);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject
    protected final Object equivalentValues(Object obj) {
        return equivalentXml(obj) ? Boolean.TRUE : Boolean.FALSE;
    }

    abstract boolean equivalentXml(Object obj);

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(XMLOBJECT_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == 1) {
            return jsConstructor(context, scriptable2 == null, objArr);
        }
        if (!(scriptable2 instanceof XMLObjectImpl)) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        }
        XMLObjectImpl xMLObjectImpl = (XMLObjectImpl) scriptable2;
        XML xml = xMLObjectImpl.getXML();
        switch (iMethodId) {
            case 2:
                if (xml == null) {
                    xmlMethodNotFound(xMLObjectImpl, "addNamespace");
                }
                return xml.addNamespace(this.lib.castToNamespace(context, arg(objArr, 0)));
            case 3:
                if (xml == null) {
                    xmlMethodNotFound(xMLObjectImpl, "appendChild");
                }
                return xml.appendChild(arg(objArr, 0));
            case 4:
                return xMLObjectImpl.getMatches(XMLName.create(this.lib.toNodeQName(context, arg(objArr, 0), true), true, false));
            case 5:
                return xMLObjectImpl.getMatches(XMLName.create(XmlNode.QName.create(null, null), true, false));
            case 6:
                XMLName xMLNameOrIndex = this.lib.toXMLNameOrIndex(context, arg(objArr, 0));
                return xMLNameOrIndex == null ? xMLObjectImpl.child((int) ScriptRuntime.lastUint32Result(context)) : xMLObjectImpl.child(xMLNameOrIndex);
            case 7:
                if (xml == null) {
                    xmlMethodNotFound(xMLObjectImpl, "childIndex");
                }
                return ScriptRuntime.wrapInt(xml.childIndex());
            case 8:
                return xMLObjectImpl.children();
            case 9:
                return xMLObjectImpl.comments();
            case 10:
                return ScriptRuntime.wrapBoolean(xMLObjectImpl.contains(arg(objArr, 0)));
            case 11:
                return xMLObjectImpl.copy();
            case 12:
                return xMLObjectImpl.getMatches(XMLName.create(objArr.length == 0 ? XmlNode.QName.create(null, null) : this.lib.toNodeQName(context, objArr[0], false), false, true));
            case 13:
                return xMLObjectImpl.elements(objArr.length == 0 ? XMLName.formStar() : this.lib.toXMLName(context, objArr[0]));
            case 14:
                if (xml == null) {
                    xmlMethodNotFound(xMLObjectImpl, "inScopeNamespaces");
                }
                return context.newArray(scriptable, toObjectArray(xml.inScopeNamespaces()));
            case 15:
                if (xml == null) {
                    xmlMethodNotFound(xMLObjectImpl, "insertChildAfter");
                }
                Object objArg = arg(objArr, 0);
                return (objArg == null || (objArg instanceof XML)) ? xml.insertChildAfter((XML) objArg, arg(objArr, 1)) : Undefined.instance;
            case 16:
                if (xml == null) {
                    xmlMethodNotFound(xMLObjectImpl, "insertChildBefore");
                }
                Object objArg2 = arg(objArr, 0);
                return (objArg2 == null || (objArg2 instanceof XML)) ? xml.insertChildBefore((XML) objArg2, arg(objArr, 1)) : Undefined.instance;
            case 17:
                return ScriptRuntime.wrapBoolean(xMLObjectImpl.hasOwnProperty(this.lib.toXMLName(context, arg(objArr, 0))));
            case 18:
                return ScriptRuntime.wrapBoolean(xMLObjectImpl.hasComplexContent());
            case 19:
                return ScriptRuntime.wrapBoolean(xMLObjectImpl.hasSimpleContent());
            case 20:
                return ScriptRuntime.wrapInt(xMLObjectImpl.length());
            case 21:
                if (xml == null) {
                    xmlMethodNotFound(xMLObjectImpl, "localName");
                }
                return xml.localName();
            case 22:
                if (xml == null) {
                    xmlMethodNotFound(xMLObjectImpl, "name");
                }
                return xml.name();
            case 23:
                if (xml == null) {
                    xmlMethodNotFound(xMLObjectImpl, "namespace");
                }
                Namespace namespace = xml.namespace(objArr.length > 0 ? ScriptRuntime.toString(objArr[0]) : null);
                return namespace == null ? Undefined.instance : namespace;
            case 24:
                if (xml == null) {
                    xmlMethodNotFound(xMLObjectImpl, "namespaceDeclarations");
                }
                return context.newArray(scriptable, toObjectArray(xml.namespaceDeclarations()));
            case 25:
                if (xml == null) {
                    xmlMethodNotFound(xMLObjectImpl, "nodeKind");
                }
                return xml.nodeKind();
            case 26:
                xMLObjectImpl.normalize();
                return Undefined.instance;
            case 27:
                return xMLObjectImpl.parent();
            case 28:
                if (xml == null) {
                    xmlMethodNotFound(xMLObjectImpl, "prependChild");
                }
                return xml.prependChild(arg(objArr, 0));
            case 29:
                return xMLObjectImpl.processingInstructions(objArr.length > 0 ? this.lib.toXMLName(context, objArr[0]) : XMLName.formStar());
            case 30:
                return ScriptRuntime.wrapBoolean(xMLObjectImpl.propertyIsEnumerable(arg(objArr, 0)));
            case 31:
                if (xml == null) {
                    xmlMethodNotFound(xMLObjectImpl, "removeNamespace");
                }
                return xml.removeNamespace(this.lib.castToNamespace(context, arg(objArr, 0)));
            case 32:
                if (xml == null) {
                    xmlMethodNotFound(xMLObjectImpl, "replace");
                }
                XMLName xMLNameOrIndex2 = this.lib.toXMLNameOrIndex(context, arg(objArr, 0));
                Object objArg3 = arg(objArr, 1);
                return xMLNameOrIndex2 == null ? xml.replace((int) ScriptRuntime.lastUint32Result(context), objArg3) : xml.replace(xMLNameOrIndex2, objArg3);
            case 33:
                if (xml == null) {
                    xmlMethodNotFound(xMLObjectImpl, "setChildren");
                }
                return xml.setChildren(arg(objArr, 0));
            case 34:
                if (xml == null) {
                    xmlMethodNotFound(xMLObjectImpl, "setLocalName");
                }
                Object objArg4 = arg(objArr, 0);
                xml.setLocalName(objArg4 instanceof QName ? ((QName) objArg4).localName() : ScriptRuntime.toString(objArg4));
                return Undefined.instance;
            case 35:
                if (xml == null) {
                    xmlMethodNotFound(xMLObjectImpl, "setName");
                }
                xml.setName(this.lib.constructQName(context, objArr.length != 0 ? objArr[0] : Undefined.instance));
                return Undefined.instance;
            case 36:
                if (xml == null) {
                    xmlMethodNotFound(xMLObjectImpl, "setNamespace");
                }
                xml.setNamespace(this.lib.castToNamespace(context, arg(objArr, 0)));
                return Undefined.instance;
            case 37:
                return xMLObjectImpl.text();
            case 38:
                return xMLObjectImpl.toString();
            case 39:
                return xMLObjectImpl.toSource(ScriptRuntime.toInt32(objArr, 0));
            case 40:
                return xMLObjectImpl.toXMLString();
            case 41:
                return xMLObjectImpl.valueOf();
            default:
                throw new IllegalArgumentException(String.valueOf(iMethodId));
        }
    }

    final void exportAsJSClass(boolean z) {
        this.prototypeFlag = true;
        exportAsJSClass(41, getParentScope(), z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:101:0x0199  */
    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int i;
        switch (str.length()) {
            case 4:
                char cCharAt = str.charAt(0);
                if (cCharAt == 'c') {
                    str2 = BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB;
                    i = 11;
                } else if (cCharAt == 'n') {
                    str2 = "name";
                    i = 22;
                } else if (cCharAt != 't') {
                    str2 = null;
                    i = 0;
                } else {
                    str2 = "text";
                    i = 37;
                }
                break;
            case 5:
                str2 = "child";
                i = 6;
                break;
            case 6:
                char cCharAt2 = str.charAt(0);
                if (cCharAt2 == 'l') {
                    str2 = Analytics.Data.LENGTH;
                    i = 20;
                } else if (cCharAt2 != 'p') {
                    str2 = null;
                    i = 0;
                } else {
                    str2 = "parent";
                    i = 27;
                }
                break;
            case 7:
                char cCharAt3 = str.charAt(0);
                if (cCharAt3 == 'r') {
                    str2 = "replace";
                    i = 32;
                } else if (cCharAt3 == 's') {
                    str2 = "setName";
                    i = 35;
                } else if (cCharAt3 != 'v') {
                    str2 = null;
                    i = 0;
                } else {
                    str2 = "valueOf";
                    i = 41;
                }
                break;
            case 8:
                char cCharAt4 = str.charAt(2);
                if (cCharAt4 == 'S') {
                    char cCharAt5 = str.charAt(7);
                    if (cCharAt5 == 'e') {
                        str2 = "toSource";
                        i = 39;
                    } else if (cCharAt5 != 'g') {
                        str2 = null;
                        i = 0;
                    } else {
                        str2 = "toString";
                        i = 38;
                    }
                } else if (cCharAt4 == 'i') {
                    str2 = "children";
                    i = 8;
                } else if (cCharAt4 == 'd') {
                    str2 = "nodeKind";
                    i = 25;
                } else if (cCharAt4 == 'e') {
                    str2 = "elements";
                    i = 13;
                } else if (cCharAt4 == 'm') {
                    str2 = BoxRequestsSearch.Search.CONTENT_TYPE_COMMENTS;
                    i = 9;
                } else if (cCharAt4 == 'n') {
                    str2 = "contains";
                    i = 10;
                } else {
                    str2 = null;
                    i = 0;
                }
                break;
            case 9:
                char cCharAt6 = str.charAt(2);
                if (cCharAt6 == 'c') {
                    str2 = "localName";
                    i = 21;
                } else if (cCharAt6 == 'm') {
                    str2 = "namespace";
                    i = 23;
                } else if (cCharAt6 == 'r') {
                    str2 = "normalize";
                    i = 26;
                } else if (cCharAt6 == 't') {
                    str2 = "attribute";
                    i = 4;
                } else {
                    str2 = null;
                    i = 0;
                }
                break;
            case 10:
                char cCharAt7 = str.charAt(0);
                if (cCharAt7 == 'a') {
                    str2 = NativeAuthConstants.GrantType.ATTRIBUTES;
                    i = 5;
                } else if (cCharAt7 != 'c') {
                    str2 = null;
                    i = 0;
                } else {
                    str2 = "childIndex";
                    i = 7;
                }
                break;
            case 11:
                char cCharAt8 = str.charAt(0);
                if (cCharAt8 == 'a') {
                    str2 = "appendChild";
                    i = 3;
                } else if (cCharAt8 == 'c') {
                    str2 = "constructor";
                    i = 1;
                } else if (cCharAt8 == 'd') {
                    str2 = "descendants";
                    i = 12;
                } else if (cCharAt8 == 's') {
                    str2 = "setChildren";
                    i = 33;
                } else if (cCharAt8 == 't') {
                    str2 = "toXMLString";
                    i = 40;
                } else {
                    str2 = null;
                    i = 0;
                }
                break;
            case 12:
                char cCharAt9 = str.charAt(0);
                if (cCharAt9 == 'a') {
                    str2 = "addNamespace";
                    i = 2;
                } else if (cCharAt9 == 'p') {
                    str2 = "prependChild";
                    i = 28;
                } else if (cCharAt9 == 's') {
                    char cCharAt10 = str.charAt(3);
                    if (cCharAt10 == 'L') {
                        str2 = "setLocalName";
                        i = 34;
                    } else if (cCharAt10 != 'N') {
                        str2 = null;
                        i = 0;
                    } else {
                        str2 = "setNamespace";
                        i = 36;
                    }
                } else {
                    str2 = null;
                    i = 0;
                }
                break;
            case 13:
            case 18:
            case 19:
            default:
                str2 = null;
                i = 0;
                break;
            case 14:
                str2 = "hasOwnProperty";
                i = 17;
                break;
            case 15:
                str2 = "removeNamespace";
                i = 31;
                break;
            case 16:
                char cCharAt11 = str.charAt(0);
                if (cCharAt11 == 'h') {
                    str2 = "hasSimpleContent";
                    i = 19;
                } else if (cCharAt11 != 'i') {
                    str2 = null;
                    i = 0;
                } else {
                    str2 = "insertChildAfter";
                    i = 15;
                }
                break;
            case 17:
                char cCharAt12 = str.charAt(3);
                if (cCharAt12 == 'C') {
                    str2 = "hasComplexContent";
                    i = 18;
                } else if (cCharAt12 == 'c') {
                    str2 = "inScopeNamespaces";
                    i = 14;
                } else if (cCharAt12 != 'e') {
                    str2 = null;
                    i = 0;
                } else {
                    str2 = "insertChildBefore";
                    i = 16;
                }
                break;
            case 20:
                str2 = "propertyIsEnumerable";
                i = 30;
                break;
            case 21:
                str2 = "namespaceDeclarations";
                i = 24;
                break;
            case 22:
                str2 = "processingInstructions";
                i = 29;
                break;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLObject
    public final Object get(Context context, Object obj) {
        if (context == null) {
            context = Context.getCurrentContext();
        }
        XMLName xMLNameOrIndex = this.lib.toXMLNameOrIndex(context, obj);
        if (xMLNameOrIndex != null) {
            return getXMLProperty(xMLNameOrIndex);
        }
        Object obj2 = get((int) ScriptRuntime.lastUint32Result(context), this);
        return obj2 == Scriptable.NOT_FOUND ? Undefined.instance : obj2;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public final Object getDefaultValue(Class<?> cls) {
        return toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLObject
    public Object getFunctionProperty(Context context, int i) {
        if (isPrototype()) {
            return super.get(i, this);
        }
        Scriptable prototype = getPrototype();
        return prototype instanceof XMLObject ? ((XMLObject) prototype).getFunctionProperty(context, i) : Scriptable.NOT_FOUND;
    }

    XMLLibImpl getLib() {
        return this.lib;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public final Scriptable getParentScope() {
        return super.getParentScope();
    }

    final XmlProcessor getProcessor() {
        return this.lib.getProcessor();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public final Scriptable getPrototype() {
        return super.getPrototype();
    }

    abstract XML getXML();

    abstract Object getXMLProperty(XMLName xMLName);

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLObject
    public final boolean has(Context context, Object obj) {
        if (context == null) {
            context = Context.getCurrentContext();
        }
        XMLName xMLNameOrIndex = this.lib.toXMLNameOrIndex(context, obj);
        return xMLNameOrIndex == null ? has((int) ScriptRuntime.lastUint32Result(context), this) : hasXMLProperty(xMLNameOrIndex);
    }

    abstract boolean hasComplexContent();

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public final boolean hasInstance(Scriptable scriptable) {
        return super.hasInstance(scriptable);
    }

    abstract boolean hasOwnProperty(XMLName xMLName);

    abstract boolean hasSimpleContent();

    abstract boolean hasXMLProperty(XMLName xMLName);

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 1;
        switch (i) {
            case 1:
                initPrototypeConstructor(this instanceof XML ? new XMLCtor((XML) this, XMLOBJECT_TAG, i, 1) : new IdFunctionObject(this, XMLOBJECT_TAG, i, 1));
                return;
            case 2:
                str = "addNamespace";
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 3:
                str = "appendChild";
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 4:
                str = "attribute";
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 5:
                str = NativeAuthConstants.GrantType.ATTRIBUTES;
                i2 = 0;
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 6:
                str = "child";
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 7:
                str = "childIndex";
                i2 = 0;
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 8:
                str = "children";
                i2 = 0;
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 9:
                str = BoxRequestsSearch.Search.CONTENT_TYPE_COMMENTS;
                i2 = 0;
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 10:
                str = "contains";
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 11:
                str = BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB;
                i2 = 0;
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 12:
                str = "descendants";
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 13:
                str = "elements";
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 14:
                str = "inScopeNamespaces";
                i2 = 0;
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 15:
                str2 = "insertChildAfter";
                i2 = 2;
                str = str2;
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 16:
                str2 = "insertChildBefore";
                i2 = 2;
                str = str2;
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 17:
                str = "hasOwnProperty";
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 18:
                str = "hasComplexContent";
                i2 = 0;
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 19:
                str = "hasSimpleContent";
                i2 = 0;
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 20:
                str = Analytics.Data.LENGTH;
                i2 = 0;
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 21:
                str = "localName";
                i2 = 0;
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 22:
                str = "name";
                i2 = 0;
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 23:
                str = "namespace";
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 24:
                str = "namespaceDeclarations";
                i2 = 0;
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 25:
                str = "nodeKind";
                i2 = 0;
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 26:
                str = "normalize";
                i2 = 0;
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 27:
                str = "parent";
                i2 = 0;
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 28:
                str = "prependChild";
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 29:
                str = "processingInstructions";
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 30:
                str = "propertyIsEnumerable";
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 31:
                str = "removeNamespace";
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 32:
                str2 = "replace";
                i2 = 2;
                str = str2;
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 33:
                str = "setChildren";
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 34:
                str = "setLocalName";
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 35:
                str = "setName";
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 36:
                str = "setNamespace";
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 37:
                str = "text";
                i2 = 0;
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 38:
                str = "toString";
                i2 = 0;
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 39:
                str = "toSource";
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 40:
                str = "toXMLString";
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            case 41:
                str = "valueOf";
                i2 = 0;
                initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    final void initialize(XMLLibImpl xMLLibImpl, Scriptable scriptable, XMLObject xMLObject) {
        setParentScope(scriptable);
        setPrototype(xMLObject);
        this.prototypeFlag = xMLObject == null;
        this.lib = xMLLibImpl;
    }

    final boolean isPrototype() {
        return this.prototypeFlag;
    }

    protected abstract Object jsConstructor(Context context, boolean z, Object[] objArr);

    abstract int length();

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLObject
    public Ref memberRef(Context context, Object obj, int i) {
        boolean z = (i & 2) != 0;
        boolean z2 = (i & 4) != 0;
        if (!z && !z2) {
            throw Kit.codeBug();
        }
        XMLName xMLNameCreate = XMLName.create(this.lib.toNodeQName(context, obj, z), z, z2);
        xMLNameCreate.initXMLObject(this);
        return xMLNameCreate;
    }

    final QName newQName(XmlNode.QName qName) {
        return this.lib.newQName(qName);
    }

    final XML newTextElementXML(XmlNode xmlNode, XmlNode.QName qName, String str) {
        return this.lib.newTextElementXML(xmlNode, qName, str);
    }

    final XML newXML(XmlNode xmlNode) {
        return this.lib.newXML(xmlNode);
    }

    final XML newXMLFromJs(Object obj) {
        return this.lib.newXMLFromJs(obj);
    }

    final XMLList newXMLList() {
        return this.lib.newXMLList();
    }

    final XMLList newXMLListFrom(Object obj) {
        return this.lib.newXMLListFrom(obj);
    }

    abstract void normalize();

    abstract Object parent();

    abstract XMLList processingInstructions(XMLName xMLName);

    abstract boolean propertyIsEnumerable(Object obj);

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLObject
    public final void put(Context context, Object obj, Object obj2) {
        if (context == null) {
            context = Context.getCurrentContext();
        }
        XMLName xMLNameOrIndex = this.lib.toXMLNameOrIndex(context, obj);
        if (xMLNameOrIndex == null) {
            put((int) ScriptRuntime.lastUint32Result(context), this, obj2);
        } else {
            putXMLProperty(xMLNameOrIndex, obj2);
        }
    }

    abstract void putXMLProperty(XMLName xMLName, Object obj);

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public final void setParentScope(Scriptable scriptable) {
        super.setParentScope(scriptable);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public final void setPrototype(Scriptable scriptable) {
        super.setPrototype(scriptable);
    }

    abstract XMLList text();

    abstract String toSource(int i);

    public abstract String toString();

    abstract String toXMLString();

    abstract Object valueOf();

    XML xmlFromNode(XmlNode xmlNode) {
        if (xmlNode.getXml() == null) {
            xmlNode.setXml(newXML(xmlNode));
        }
        return xmlNode.getXml();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLObject
    public final boolean delete(Context context, Object obj) {
        if (context == null) {
            context = Context.getCurrentContext();
        }
        XMLName xMLNameOrIndex = this.lib.toXMLNameOrIndex(context, obj);
        if (xMLNameOrIndex == null) {
            delete((int) ScriptRuntime.lastUint32Result(context));
            return true;
        }
        deleteXMLProperty(xMLNameOrIndex);
        return true;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        return getXMLProperty(this.lib.toXMLNameFromString(Context.getCurrentContext(), str));
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLObject
    public Object getFunctionProperty(Context context, String str) {
        if (isPrototype()) {
            return super.get(str, this);
        }
        Scriptable prototype = getPrototype();
        return prototype instanceof XMLObject ? ((XMLObject) prototype).getFunctionProperty(context, str) : Scriptable.NOT_FOUND;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return hasXMLProperty(this.lib.toXMLNameFromString(Context.getCurrentContext(), str));
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLObject
    public Ref memberRef(Context context, Object obj, Object obj2, int i) {
        XMLName xMLNameCreate = XMLName.create(this.lib.toNodeQName(context, obj, obj2), (i & 2) != 0, (i & 4) != 0);
        xMLNameCreate.initXMLObject(this);
        return xMLNameCreate;
    }

    final QName newQName(String str, String str2, String str3) {
        return this.lib.newQName(str, str2, str3);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        putXMLProperty(this.lib.toXMLNameFromString(Context.getCurrentContext(), str), obj);
    }
}
