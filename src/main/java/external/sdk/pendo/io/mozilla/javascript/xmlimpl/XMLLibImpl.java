package external.sdk.pendo.io.mozilla.javascript.xmlimpl;

import com.j256.ormlite.stmt.query.SimpleComparison;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Kit;
import external.sdk.pendo.io.mozilla.javascript.Ref;
import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.Undefined;
import external.sdk.pendo.io.mozilla.javascript.Wrapper;
import external.sdk.pendo.io.mozilla.javascript.xml.XMLLib;
import external.sdk.pendo.io.mozilla.javascript.xml.XMLObject;
import java.io.Serializable;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes4.dex */
public final class XMLLibImpl extends XMLLib implements Serializable {
    private static final long serialVersionUID = 1;
    private Scriptable globalScope;
    private Namespace namespacePrototype;
    private XmlProcessor options = new XmlProcessor();
    private QName qnamePrototype;
    private XMLList xmlListPrototype;
    private XML xmlPrototype;

    private XMLLibImpl(Scriptable scriptable) {
        this.globalScope = scriptable;
    }

    private static RuntimeException badXMLName(Object obj) {
        String str;
        if (obj instanceof Number) {
            str = "Can not construct XML name from number: ";
        } else if (obj instanceof Boolean) {
            str = "Can not construct XML name from boolean: ";
        } else {
            if (obj != Undefined.instance && obj != null) {
                throw new IllegalArgumentException(obj.toString());
            }
            str = "Can not construct XML name from ";
        }
        return ScriptRuntime.typeError(str + ScriptRuntime.toString(obj));
    }

    private void exportToScope(boolean z) {
        this.xmlPrototype = newXML(XmlNode.createText(this.options, ""));
        this.xmlListPrototype = newXMLList();
        this.namespacePrototype = Namespace.create(this.globalScope, null, XmlNode.Namespace.GLOBAL);
        this.qnamePrototype = QName.create(this, this.globalScope, null, XmlNode.QName.create(XmlNode.Namespace.create(""), ""));
        this.xmlPrototype.exportAsJSClass(z);
        this.xmlListPrototype.exportAsJSClass(z);
        this.namespacePrototype.exportAsJSClass(z);
        this.qnamePrototype.exportAsJSClass(z);
    }

    private String getDefaultNamespaceURI(Context context) {
        return getDefaultNamespace(context).uri();
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        XMLLibImpl xMLLibImpl = new XMLLibImpl(scriptable);
        if (xMLLibImpl.bindToScope(scriptable) == xMLLibImpl) {
            xMLLibImpl.exportToScope(z);
        }
    }

    private XML parse(String str) {
        try {
            return newXML(XmlNode.createElement(this.options, getDefaultNamespaceURI(Context.getCurrentContext()), str));
        } catch (SAXException e) {
            throw ScriptRuntime.typeError("Cannot parse XML: " + e.getMessage());
        }
    }

    public static Node toDomNode(Object obj) {
        if (obj instanceof XML) {
            return ((XML) obj).toDomNode();
        }
        throw new IllegalArgumentException("xmlObject is not an XML object in JavaScript.");
    }

    /* JADX WARN: Code duplicated, block: B:17:0x001b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:18:? A[LOOP:0: B:3:0x0001->B:18:?, LOOP_END, SYNTHETIC] */
    private Ref xmlPrimaryReference(Context context, XMLName xMLName, Scriptable scriptable) {
        XMLObjectImpl xMLObjectImpl;
        XMLObjectImpl xMLObjectImpl2 = null;
        while (true) {
            if (scriptable instanceof XMLWithScope) {
                xMLObjectImpl = (XMLObjectImpl) scriptable.getPrototype();
                if (xMLObjectImpl.hasXMLProperty(xMLName)) {
                    break;
                }
                if (xMLObjectImpl2 == null) {
                    xMLObjectImpl2 = xMLObjectImpl;
                }
                scriptable = scriptable.getParentScope();
                if (scriptable == null) {
                    xMLObjectImpl = xMLObjectImpl2;
                    break;
                }
            } else {
                scriptable = scriptable.getParentScope();
                if (scriptable == null) {
                    xMLObjectImpl = xMLObjectImpl2;
                    break;
                }
            }
        }
        if (xMLObjectImpl != null) {
            xMLName.initXMLObject(xMLObjectImpl);
        }
        return xMLName;
    }

    Object addXMLObjects(Context context, XMLObject xMLObject, XMLObject xMLObject2) {
        XMLList xMLListNewXMLList = newXMLList();
        if (xMLObject instanceof XMLList) {
            XMLList xMLList = (XMLList) xMLObject;
            if (xMLList.length() == 1) {
                xMLListNewXMLList.addToList(xMLList.item(0));
            } else {
                xMLListNewXMLList = newXMLListFrom(xMLObject);
            }
        } else {
            xMLListNewXMLList.addToList(xMLObject);
        }
        if (xMLObject2 instanceof XMLList) {
            XMLList xMLList2 = (XMLList) xMLObject2;
            for (int i = 0; i < xMLList2.length(); i++) {
                xMLListNewXMLList.addToList(xMLList2.item(i));
            }
        } else if (xMLObject2 instanceof XML) {
            xMLListNewXMLList.addToList(xMLObject2);
        }
        return xMLListNewXMLList;
    }

    Namespace castToNamespace(Context context, Object obj) {
        return this.namespacePrototype.castToNamespace(obj);
    }

    QName castToQName(Context context, Object obj) {
        return this.qnamePrototype.castToQName(this, context, obj);
    }

    QName constructQName(Context context, Object obj) {
        return this.qnamePrototype.constructQName(this, context, obj);
    }

    Namespace[] createNamespaces(XmlNode.Namespace[] namespaceArr) {
        Namespace[] namespaceArr2 = new Namespace[namespaceArr.length];
        for (int i = 0; i < namespaceArr.length; i++) {
            namespaceArr2[i] = this.namespacePrototype.newNamespace(namespaceArr[i].getPrefix(), namespaceArr[i].getUri());
        }
        return namespaceArr2;
    }

    final XML ecmaToXml(Object obj) {
        XmlNode xmlNodeCreateText;
        if (obj == null || obj == Undefined.instance) {
            throw ScriptRuntime.typeError("Cannot convert " + obj + " to XML");
        }
        if (obj instanceof XML) {
            return (XML) obj;
        }
        if (obj instanceof XMLList) {
            XMLList xMLList = (XMLList) obj;
            if (xMLList.getXML() != null) {
                return xMLList.getXML();
            }
            throw ScriptRuntime.typeError("Cannot convert list of >1 element to XML");
        }
        if (obj instanceof Wrapper) {
            obj = ((Wrapper) obj).unwrap();
        }
        if (obj instanceof Node) {
            xmlNodeCreateText = XmlNode.createElementFromNode((Node) obj);
        } else {
            String string = ScriptRuntime.toString(obj);
            if (string.length() > 0 && string.charAt(0) == '<') {
                return parse(string);
            }
            xmlNodeCreateText = XmlNode.createText(this.options, string);
        }
        return newXML(xmlNodeCreateText);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public String escapeAttributeValue(Object obj) {
        return this.options.escapeAttributeValue(obj);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public String escapeTextValue(Object obj) {
        return this.options.escapeTextValue(obj);
    }

    Namespace getDefaultNamespace(Context context) {
        Object objSearchDefaultNamespace;
        if ((context != null || (context = Context.getCurrentContext()) != null) && (objSearchDefaultNamespace = ScriptRuntime.searchDefaultNamespace(context)) != null && (objSearchDefaultNamespace instanceof Namespace)) {
            return (Namespace) objSearchDefaultNamespace;
        }
        return this.namespacePrototype;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public int getPrettyIndent() {
        return this.options.getPrettyIndent();
    }

    XmlProcessor getProcessor() {
        return this.options;
    }

    @Deprecated
    Scriptable globalScope() {
        return this.globalScope;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public boolean isIgnoreComments() {
        return this.options.isIgnoreComments();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public boolean isIgnoreProcessingInstructions() {
        return this.options.isIgnoreProcessingInstructions();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public boolean isIgnoreWhitespace() {
        return this.options.isIgnoreWhitespace();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public boolean isPrettyPrinting() {
        return this.options.isPrettyPrinting();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public boolean isXMLName(Context context, Object obj) {
        return XMLName.accept(obj);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public Ref nameRef(Context context, Object obj, Scriptable scriptable, int i) {
        if ((i & 2) != 0) {
            return xmlPrimaryReference(context, toAttributeName(context, obj), scriptable);
        }
        throw Kit.codeBug();
    }

    Namespace newNamespace(String str) {
        return this.namespacePrototype.newNamespace(str);
    }

    QName newQName(XmlNode.QName qName) {
        return QName.create(this, this.globalScope, this.qnamePrototype, qName);
    }

    final XML newTextElementXML(XmlNode xmlNode, XmlNode.QName qName, String str) {
        return newXML(XmlNode.newElementWithText(this.options, xmlNode, qName, str));
    }

    XML newXML(XmlNode xmlNode) {
        return new XML(this, this.globalScope, this.xmlPrototype, xmlNode);
    }

    final XML newXMLFromJs(Object obj) {
        String xMLString;
        if (obj == null || obj == Undefined.instance) {
            xMLString = "";
        } else {
            xMLString = obj instanceof XMLObjectImpl ? ((XMLObjectImpl) obj).toXMLString() : ScriptRuntime.toString(obj);
        }
        if (xMLString.trim().startsWith(SimpleComparison.NOT_EQUAL_TO_OPERATION)) {
            throw ScriptRuntime.typeError("Invalid use of XML object anonymous tags <></>.");
        }
        return xMLString.indexOf(SimpleComparison.LESS_THAN_OPERATION) == -1 ? newXML(XmlNode.createText(this.options, xMLString)) : parse(xMLString);
    }

    XMLList newXMLList() {
        return new XMLList(this, this.globalScope, this.xmlListPrototype);
    }

    final XMLList newXMLListFrom(Object obj) {
        XMLList xMLListNewXMLList = newXMLList();
        if (obj != null && !(obj instanceof Undefined)) {
            if (obj instanceof XML) {
                xMLListNewXMLList.getNodeList().add((XML) obj);
                return xMLListNewXMLList;
            }
            if (obj instanceof XMLList) {
                xMLListNewXMLList.getNodeList().add(((XMLList) obj).getNodeList());
                return xMLListNewXMLList;
            }
            String strTrim = ScriptRuntime.toString(obj).trim();
            if (!strTrim.startsWith(SimpleComparison.NOT_EQUAL_TO_OPERATION)) {
                strTrim = SimpleComparison.NOT_EQUAL_TO_OPERATION + strTrim + "</>";
            }
            String str = "<fragment>" + strTrim.substring(2);
            if (!str.endsWith("</>")) {
                throw ScriptRuntime.typeError("XML with anonymous tag missing end anonymous tag");
            }
            XMLList xMLListChildren = newXMLFromJs(str.substring(0, str.length() - 3) + "</fragment>").children();
            for (int i = 0; i < xMLListChildren.getNodeList().length(); i++) {
                xMLListNewXMLList.getNodeList().add((XML) xMLListChildren.item(i).copy());
            }
        }
        return xMLListNewXMLList;
    }

    @Deprecated
    QName qnamePrototype() {
        return this.qnamePrototype;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public void setIgnoreComments(boolean z) {
        this.options.setIgnoreComments(z);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public void setIgnoreProcessingInstructions(boolean z) {
        this.options.setIgnoreProcessingInstructions(z);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public void setIgnoreWhitespace(boolean z) {
        this.options.setIgnoreWhitespace(z);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public void setPrettyIndent(int i) {
        this.options.setPrettyIndent(i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public void setPrettyPrinting(boolean z) {
        this.options.setPrettyPrinting(z);
    }

    @Deprecated
    XMLName toAttributeName(Context context, Object obj) {
        XmlNode.QName qNameCreate;
        if (obj instanceof XMLName) {
            return (XMLName) obj;
        }
        if (obj instanceof QName) {
            qNameCreate = ((QName) obj).getDelegate();
        } else {
            if ((obj instanceof Boolean) || (obj instanceof Number) || obj == Undefined.instance || obj == null) {
                throw badXMLName(obj);
            }
            String string = obj instanceof String ? (String) obj : ScriptRuntime.toString(obj);
            if (string != null && string.equals("*")) {
                string = null;
            }
            qNameCreate = XmlNode.QName.create(XmlNode.Namespace.create(""), string);
        }
        return XMLName.create(qNameCreate, true, false);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public Object toDefaultXmlNamespace(Context context, Object obj) {
        return this.namespacePrototype.constructNamespace(obj);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0028  */
    XmlNode.QName toNodeQName(Context context, Object obj, Object obj2) {
        Namespace namespaceConstructNamespace;
        XmlNode.Namespace delegate;
        String strLocalName = obj2 instanceof QName ? ((QName) obj2).localName() : ScriptRuntime.toString(obj2);
        if (obj == Undefined.instance) {
            if ("*".equals(strLocalName)) {
                delegate = null;
            } else {
                namespaceConstructNamespace = getDefaultNamespace(context);
                delegate = namespaceConstructNamespace.getDelegate();
            }
        } else if (obj == null) {
            delegate = null;
        } else if (obj instanceof Namespace) {
            delegate = ((Namespace) obj).getDelegate();
        } else {
            namespaceConstructNamespace = this.namespacePrototype.constructNamespace(obj);
            delegate = namespaceConstructNamespace.getDelegate();
        }
        if (strLocalName != null && strLocalName.equals("*")) {
            strLocalName = null;
        }
        return XmlNode.QName.create(delegate, strLocalName);
    }

    XMLName toXMLName(Context context, Object obj) {
        if (obj instanceof XMLName) {
            return (XMLName) obj;
        }
        if (obj instanceof QName) {
            QName qName = (QName) obj;
            return XMLName.formProperty(qName.uri(), qName.localName());
        }
        if (obj instanceof String) {
            return toXMLNameFromString(context, (String) obj);
        }
        if ((obj instanceof Boolean) || (obj instanceof Number) || obj == Undefined.instance || obj == null) {
            throw badXMLName(obj);
        }
        return toXMLNameFromString(context, ScriptRuntime.toString(obj));
    }

    XMLName toXMLNameFromString(Context context, String str) {
        return XMLName.create(getDefaultNamespaceURI(context), str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x007b, code lost:
    
        if (r4 >= 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007d, code lost:
    
        external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.storeUint32Result(r11, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0080, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0085, code lost:
    
        return toXMLNameFromString(r11, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if (r4 >= 0) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLName toXMLNameOrIndex(external.sdk.pendo.io.mozilla.javascript.Context r11, java.lang.Object r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLName
            if (r0 == 0) goto L7
            external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLName r12 = (external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLName) r12
            return r12
        L7:
            boolean r0 = r12 instanceof java.lang.String
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L19
            java.lang.String r12 = (java.lang.String) r12
            long r4 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.testUint32String(r12)
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 < 0) goto L81
            goto L7d
        L19:
            boolean r0 = r12 instanceof java.lang.Number
            if (r0 == 0) goto L40
            r10 = r12
            java.lang.Number r10 = (java.lang.Number) r10
            double r4 = r10.doubleValue()
            long r6 = (long) r4
            double r8 = (double) r6
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 != 0) goto L3b
            int r10 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r10 > 0) goto L3b
            r2 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r10 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r10 > 0) goto L3b
            external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.storeUint32Result(r11, r6)
            return r1
        L3b:
            java.lang.RuntimeException r10 = badXMLName(r12)
            throw r10
        L40:
            boolean r0 = r12 instanceof external.sdk.pendo.io.mozilla.javascript.xmlimpl.QName
            if (r0 == 0) goto L67
            external.sdk.pendo.io.mozilla.javascript.xmlimpl.QName r12 = (external.sdk.pendo.io.mozilla.javascript.xmlimpl.QName) r12
            java.lang.String r10 = r12.uri()
            if (r10 == 0) goto L5e
            int r0 = r10.length()
            if (r0 != 0) goto L5e
            long r4 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.testUint32String(r10)
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 < 0) goto L5e
            external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.storeUint32Result(r11, r4)
            return r1
        L5e:
            java.lang.String r11 = r12.localName()
            external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLName r10 = external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLName.formProperty(r10, r11)
            return r10
        L67:
            boolean r0 = r12 instanceof java.lang.Boolean
            if (r0 != 0) goto L86
            java.lang.Object r0 = external.sdk.pendo.io.mozilla.javascript.Undefined.instance
            if (r12 == r0) goto L86
            if (r12 == 0) goto L86
            java.lang.String r12 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.toString(r12)
            long r4 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.testUint32String(r12)
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 < 0) goto L81
        L7d:
            external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.storeUint32Result(r11, r4)
            return r1
        L81:
            external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLName r10 = r10.toXMLNameFromString(r11, r12)
            return r10
        L86:
            java.lang.RuntimeException r10 = badXMLName(r12)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLLibImpl.toXMLNameOrIndex(external.sdk.pendo.io.mozilla.javascript.Context, java.lang.Object):external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLName");
    }

    QName constructQName(Context context, Object obj, Object obj2) {
        return this.qnamePrototype.constructQName(this, context, obj, obj2);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public Ref nameRef(Context context, Object obj, Object obj2, Scriptable scriptable, int i) {
        XMLName xMLNameCreate = XMLName.create(toNodeQName(context, obj, obj2), false, false);
        if ((i & 2) != 0 && !xMLNameCreate.isAttributeName()) {
            xMLNameCreate.setAttributeName();
        }
        return xmlPrimaryReference(context, xMLNameCreate, scriptable);
    }

    QName newQName(String str, String str2, String str3) {
        return this.qnamePrototype.newQName(this, str, str2, str3);
    }

    XmlNode.QName toNodeQName(Context context, Object obj, boolean z) {
        if (obj instanceof XMLName) {
            return ((XMLName) obj).toQname();
        }
        if (obj instanceof QName) {
            return ((QName) obj).getDelegate();
        }
        if ((obj instanceof Boolean) || (obj instanceof Number) || obj == Undefined.instance || obj == null) {
            throw badXMLName(obj);
        }
        return toNodeQName(context, obj instanceof String ? (String) obj : ScriptRuntime.toString(obj), z);
    }

    XmlNode.QName toNodeQName(Context context, String str, boolean z) {
        XmlNode.Namespace delegate = getDefaultNamespace(context).getDelegate();
        if (str == null || !str.equals("*")) {
            return z ? XmlNode.QName.create(XmlNode.Namespace.GLOBAL, str) : XmlNode.QName.create(delegate, str);
        }
        return XmlNode.QName.create(null, null);
    }
}
