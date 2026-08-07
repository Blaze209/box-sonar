package external.sdk.pendo.io.mozilla.javascript.xmlimpl;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;

/* JADX INFO: loaded from: classes4.dex */
class XmlProcessor implements Serializable {
    private static final long serialVersionUID = 6903514433204808713L;
    private transient LinkedBlockingDeque<DocumentBuilder> documentBuilderPool;
    private transient DocumentBuilderFactory dom;
    private RhinoSAXErrorHandler errorHandler = new RhinoSAXErrorHandler();
    private boolean ignoreComments;
    private boolean ignoreProcessingInstructions;
    private boolean ignoreWhitespace;
    private int prettyIndent;
    private boolean prettyPrint;
    private transient TransformerFactory xform;

    private static class RhinoSAXErrorHandler implements ErrorHandler, Serializable {
        private static final long serialVersionUID = 6918417235413084055L;

        private RhinoSAXErrorHandler() {
        }

        private void throwError(SAXParseException sAXParseException) {
            throw ScriptRuntime.constructError("TypeError", sAXParseException.getMessage(), sAXParseException.getLineNumber() - 1);
        }

        @Override // org.xml.sax.ErrorHandler
        public void error(SAXParseException sAXParseException) {
            throwError(sAXParseException);
        }

        @Override // org.xml.sax.ErrorHandler
        public void fatalError(SAXParseException sAXParseException) {
            throwError(sAXParseException);
        }

        @Override // org.xml.sax.ErrorHandler
        public void warning(SAXParseException sAXParseException) {
            Context.reportWarning(sAXParseException.getMessage());
        }
    }

    XmlProcessor() {
        setDefault();
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        this.dom = documentBuilderFactoryNewInstance;
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        this.dom.setIgnoringComments(false);
        this.xform = TransformerFactory.newInstance();
        Context currentContext = Context.getCurrentContext();
        if (currentContext == null || currentContext.hasFeature(20)) {
            configureSecureDBF(this.dom);
            configureSecureTF(this.xform);
        }
        this.documentBuilderPool = new LinkedBlockingDeque<>(Runtime.getRuntime().availableProcessors() * 2);
    }

    private void addCommentsTo(List<Node> list, Node node) {
        if (node instanceof Comment) {
            list.add(node);
        }
        if (node.getChildNodes() != null) {
            for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                addProcessingInstructionsTo(list, node.getChildNodes().item(i));
            }
        }
    }

    private void addProcessingInstructionsTo(List<Node> list, Node node) {
        if (node instanceof ProcessingInstruction) {
            list.add(node);
        }
        if (node.getChildNodes() != null) {
            for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                addProcessingInstructionsTo(list, node.getChildNodes().item(i));
            }
        }
    }

    private void addTextNodesToRemoveAndTrim(List<Node> list, Node node) {
        if (node instanceof Text) {
            Text text = (Text) node;
            text.setData(text.getData().trim());
            if (text.getData().length() == 0) {
                list.add(node);
            }
        }
        if (node.getChildNodes() != null) {
            for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                addTextNodesToRemoveAndTrim(list, node.getChildNodes().item(i));
            }
        }
    }

    private void beautifyElement(Element element, int i) {
        StringBuilder sb = new StringBuilder("\n");
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(' ');
        }
        String string = sb.toString();
        for (int i3 = 0; i3 < this.prettyIndent; i3++) {
            sb.append(' ');
        }
        String string2 = sb.toString();
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (int i4 = 0; i4 < element.getChildNodes().getLength(); i4++) {
            if (i4 == 1) {
                z = true;
            }
            if (element.getChildNodes().item(i4) instanceof Text) {
                arrayList.add(element.getChildNodes().item(i4));
            } else {
                arrayList.add(element.getChildNodes().item(i4));
                z = true;
            }
        }
        if (z) {
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                element.insertBefore(element.getOwnerDocument().createTextNode(string2), (Node) arrayList.get(i5));
            }
        }
        NodeList childNodes = element.getChildNodes();
        ArrayList arrayList2 = new ArrayList();
        for (int i6 = 0; i6 < childNodes.getLength(); i6++) {
            if (childNodes.item(i6) instanceof Element) {
                arrayList2.add((Element) childNodes.item(i6));
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            beautifyElement((Element) it.next(), this.prettyIndent + i);
        }
        if (z) {
            element.appendChild(element.getOwnerDocument().createTextNode(string));
        }
    }

    private void configureSecureDBF(DocumentBuilderFactory documentBuilderFactory) {
        try {
            documentBuilderFactory.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
            documentBuilderFactory.setXIncludeAware(false);
            try {
                documentBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            } catch (ParserConfigurationException unused) {
            }
            try {
                documentBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            } catch (ParserConfigurationException unused2) {
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("XML parser (DocumentBuilderFactory) cannot be securely configured.", e);
        }
    }

    private void configureSecureTF(TransformerFactory transformerFactory) {
        try {
            transformerFactory.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
            try {
                transformerFactory.setAttribute("http://javax.xml.XMLConstants/property/accessExternalDTD", "");
            } catch (IllegalArgumentException unused) {
            }
            try {
                transformerFactory.setAttribute("http://javax.xml.XMLConstants/property/accessExternalStylesheet", "");
            } catch (IllegalArgumentException unused2) {
            }
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException("XML parser (TransformerFactory) cannot be securely configured.", e);
        }
    }

    private String elementToXmlString(Element element) {
        Element element2 = (Element) element.cloneNode(true);
        if (this.prettyPrint) {
            beautifyElement(element2, 0);
        }
        return toString(element2);
    }

    private String escapeElementValue(String str) {
        return escapeTextValue(str);
    }

    private DocumentBuilder getDocumentBuilderFromPool() throws ParserConfigurationException {
        DocumentBuilder documentBuilderPollFirst = this.documentBuilderPool.pollFirst();
        if (documentBuilderPollFirst == null) {
            documentBuilderPollFirst = getDomFactory().newDocumentBuilder();
        }
        documentBuilderPollFirst.setErrorHandler(this.errorHandler);
        return documentBuilderPollFirst;
    }

    private DocumentBuilderFactory getDomFactory() {
        return this.dom;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        this.dom = documentBuilderFactoryNewInstance;
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        this.dom.setIgnoringComments(false);
        this.xform = TransformerFactory.newInstance();
        Context currentContext = Context.getCurrentContext();
        if (currentContext == null || currentContext.hasFeature(20)) {
            configureSecureDBF(this.dom);
            configureSecureTF(this.xform);
        }
        this.documentBuilderPool = new LinkedBlockingDeque<>(Runtime.getRuntime().availableProcessors() * 2);
    }

    private void returnDocumentBuilderToPool(DocumentBuilder documentBuilder) {
        try {
            documentBuilder.reset();
            this.documentBuilderPool.offerFirst(documentBuilder);
        } catch (UnsupportedOperationException unused) {
        }
    }

    private String toString(Node node) {
        DOMSource dOMSource = new DOMSource(node);
        StringWriter stringWriter = new StringWriter();
        StreamResult streamResult = new StreamResult(stringWriter);
        try {
            Transformer transformerNewTransformer = this.xform.newTransformer();
            transformerNewTransformer.setOutputProperty("omit-xml-declaration", "yes");
            transformerNewTransformer.setOutputProperty(BoxNoteConstants.BOX_NOTE_STYLE_TYPE_INDENT, "no");
            transformerNewTransformer.setOutputProperty(FirebaseAnalytics.Param.METHOD, "xml");
            transformerNewTransformer.transform(dOMSource, streamResult);
            return toXmlNewlines(stringWriter.toString());
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e2) {
            throw new RuntimeException(e2);
        }
    }

    private String toXmlNewlines(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '\r') {
                sb.append(str.charAt(i));
            } else if (str.charAt(i + 1) != '\n') {
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    final String ecmaToXmlString(Node node) {
        String strElementToXmlString;
        StringBuilder sbAppend;
        String str;
        StringBuilder sb = new StringBuilder();
        if (node instanceof Text) {
            String data = ((Text) node).getData();
            if (this.prettyPrint) {
                data = data.trim();
            }
            strElementToXmlString = escapeElementValue(data);
        } else if (node instanceof Attr) {
            strElementToXmlString = escapeAttributeValue(((Attr) node).getValue());
        } else {
            if (node instanceof Comment) {
                sbAppend = new StringBuilder("<!--").append(((Comment) node).getNodeValue());
                str = "-->";
            } else if (node instanceof ProcessingInstruction) {
                ProcessingInstruction processingInstruction = (ProcessingInstruction) node;
                sbAppend = new StringBuilder("<?").append(processingInstruction.getTarget()).append(" ").append(processingInstruction.getData());
                str = "?>";
            } else {
                strElementToXmlString = elementToXmlString((Element) node);
            }
            strElementToXmlString = sbAppend.append(str).toString();
        }
        sb.append(strElementToXmlString);
        return sb.toString();
    }

    String escapeAttributeValue(Object obj) {
        String string = ScriptRuntime.toString(obj);
        if (string.length() == 0) {
            return "";
        }
        Element elementCreateElement = newDocument().createElement(CmcdData.OBJECT_TYPE_AUDIO_ONLY);
        elementCreateElement.setAttribute("b", string);
        String string2 = toString(elementCreateElement);
        return string2.substring(string2.indexOf(34) + 1, string2.lastIndexOf(34));
    }

    String escapeTextValue(Object obj) {
        if (obj instanceof XMLObjectImpl) {
            return ((XMLObjectImpl) obj).toXMLString();
        }
        String string = ScriptRuntime.toString(obj);
        if (string.length() == 0) {
            return string;
        }
        Element elementCreateElement = newDocument().createElement(CmcdData.OBJECT_TYPE_AUDIO_ONLY);
        elementCreateElement.setTextContent(string);
        String string2 = toString(elementCreateElement);
        int iIndexOf = string2.indexOf(62) + 1;
        int iLastIndexOf = string2.lastIndexOf(60);
        return iIndexOf < iLastIndexOf ? string2.substring(iIndexOf, iLastIndexOf) : "";
    }

    final int getPrettyIndent() {
        return this.prettyIndent;
    }

    final boolean isIgnoreComments() {
        return this.ignoreComments;
    }

    final boolean isIgnoreProcessingInstructions() {
        return this.ignoreProcessingInstructions;
    }

    final boolean isIgnoreWhitespace() {
        return this.ignoreWhitespace;
    }

    final boolean isPrettyPrinting() {
        return this.prettyPrint;
    }

    Document newDocument() {
        DocumentBuilder documentBuilderFromPool = null;
        try {
            try {
                documentBuilderFromPool = getDocumentBuilderFromPool();
                Document documentNewDocument = documentBuilderFromPool.newDocument();
                returnDocumentBuilderToPool(documentBuilderFromPool);
                return documentNewDocument;
            } catch (ParserConfigurationException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            if (documentBuilderFromPool != null) {
                returnDocumentBuilderToPool(documentBuilderFromPool);
            }
            throw th;
        }
    }

    final void setDefault() {
        setIgnoreComments(true);
        setIgnoreProcessingInstructions(true);
        setIgnoreWhitespace(true);
        setPrettyPrinting(true);
        setPrettyIndent(2);
    }

    final void setIgnoreComments(boolean z) {
        this.ignoreComments = z;
    }

    final void setIgnoreProcessingInstructions(boolean z) {
        this.ignoreProcessingInstructions = z;
    }

    final void setIgnoreWhitespace(boolean z) {
        this.ignoreWhitespace = z;
    }

    final void setPrettyIndent(int i) {
        this.prettyIndent = i;
    }

    final void setPrettyPrinting(boolean z) {
        this.prettyPrint = z;
    }

    final Node toXml(String str, String str2) {
        try {
            try {
                DocumentBuilder documentBuilderFromPool = getDocumentBuilderFromPool();
                Document document = documentBuilderFromPool.parse(new InputSource(new StringReader("<parent xmlns=\"" + str + "\">" + str2 + "</parent>")));
                if (this.ignoreProcessingInstructions) {
                    ArrayList arrayList = new ArrayList();
                    addProcessingInstructionsTo(arrayList, document);
                    for (Node node : arrayList) {
                        node.getParentNode().removeChild(node);
                    }
                }
                if (this.ignoreComments) {
                    ArrayList arrayList2 = new ArrayList();
                    addCommentsTo(arrayList2, document);
                    for (Node node2 : arrayList2) {
                        node2.getParentNode().removeChild(node2);
                    }
                }
                if (this.ignoreWhitespace) {
                    ArrayList arrayList3 = new ArrayList();
                    addTextNodesToRemoveAndTrim(arrayList3, document);
                    for (Node node3 : arrayList3) {
                        node3.getParentNode().removeChild(node3);
                    }
                }
                NodeList childNodes = document.getDocumentElement().getChildNodes();
                if (childNodes.getLength() > 1) {
                    throw ScriptRuntime.constructError("SyntaxError", "XML objects may contain at most one node.");
                }
                if (childNodes.getLength() == 0) {
                    Text textCreateTextNode = document.createTextNode("");
                    returnDocumentBuilderToPool(documentBuilderFromPool);
                    return textCreateTextNode;
                }
                Node nodeItem = childNodes.item(0);
                document.getDocumentElement().removeChild(nodeItem);
                returnDocumentBuilderToPool(documentBuilderFromPool);
                return nodeItem;
            } catch (IOException unused) {
                throw new RuntimeException("Unreachable.");
            } catch (ParserConfigurationException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            if (0 != 0) {
                returnDocumentBuilderToPool(null);
            }
            throw th;
        }
    }
}
