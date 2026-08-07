package org.yaml.snakeyaml.representer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.nodes.AnchorNode;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseRepresenter {
    protected Represent nullRepresenter;
    protected Object objectToRepresent;
    private PropertyUtils propertyUtils;
    protected final Map<Class<?>, Represent> representers = new HashMap();
    protected final Map<Class<?>, Represent> multiRepresenters = new LinkedHashMap();
    protected DumperOptions.ScalarStyle defaultScalarStyle = DumperOptions.ScalarStyle.PLAIN;
    protected DumperOptions.FlowStyle defaultFlowStyle = DumperOptions.FlowStyle.AUTO;
    protected final Map<Object, Node> representedObjects = new IdentityHashMap<Object, Node>() { // from class: org.yaml.snakeyaml.representer.BaseRepresenter.1
        private static final long serialVersionUID = -5576159264232131854L;

        @Override // java.util.IdentityHashMap, java.util.AbstractMap, java.util.Map
        public Node put(Object obj, Node node) {
            return (Node) super.put(obj, new AnchorNode(node));
        }
    };
    private boolean explicitPropertyUtils = false;

    public Node represent(Object obj) {
        Node nodeRepresentData = representData(obj);
        this.representedObjects.clear();
        this.objectToRepresent = null;
        return nodeRepresentData;
    }

    protected final Node representData(Object obj) {
        this.objectToRepresent = obj;
        if (this.representedObjects.containsKey(obj)) {
            return this.representedObjects.get(this.objectToRepresent);
        }
        if (obj == null) {
            return this.nullRepresenter.representData(null);
        }
        Class<?> cls = obj.getClass();
        if (this.representers.containsKey(cls)) {
            return this.representers.get(cls).representData(obj);
        }
        for (Class<?> cls2 : this.multiRepresenters.keySet()) {
            if (cls2 != null && cls2.isInstance(obj)) {
                return this.multiRepresenters.get(cls2).representData(obj);
            }
        }
        if (this.multiRepresenters.containsKey(null)) {
            return this.multiRepresenters.get(null).representData(obj);
        }
        return this.representers.get(null).representData(obj);
    }

    protected Node representScalar(Tag tag, String str, DumperOptions.ScalarStyle scalarStyle) {
        if (scalarStyle == null) {
            scalarStyle = this.defaultScalarStyle;
        }
        return new ScalarNode(tag, str, null, null, scalarStyle);
    }

    protected Node representScalar(Tag tag, String str) {
        return representScalar(tag, str, this.defaultScalarStyle);
    }

    protected Node representSequence(Tag tag, Iterable<?> iterable, DumperOptions.FlowStyle flowStyle) {
        ArrayList arrayList = new ArrayList(iterable instanceof List ? ((List) iterable).size() : 10);
        SequenceNode sequenceNode = new SequenceNode(tag, arrayList, flowStyle);
        this.representedObjects.put(this.objectToRepresent, sequenceNode);
        DumperOptions.FlowStyle flowStyle2 = DumperOptions.FlowStyle.FLOW;
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            Node nodeRepresentData = representData(it.next());
            if (!(nodeRepresentData instanceof ScalarNode) || !((ScalarNode) nodeRepresentData).isPlain()) {
                flowStyle2 = DumperOptions.FlowStyle.BLOCK;
            }
            arrayList.add(nodeRepresentData);
        }
        if (flowStyle == DumperOptions.FlowStyle.AUTO) {
            if (this.defaultFlowStyle != DumperOptions.FlowStyle.AUTO) {
                sequenceNode.setFlowStyle(this.defaultFlowStyle);
                return sequenceNode;
            }
            sequenceNode.setFlowStyle(flowStyle2);
        }
        return sequenceNode;
    }

    protected Node representMapping(Tag tag, Map<?, ?> map, DumperOptions.FlowStyle flowStyle) {
        ArrayList arrayList = new ArrayList(map.size());
        MappingNode mappingNode = new MappingNode(tag, arrayList, flowStyle);
        this.representedObjects.put(this.objectToRepresent, mappingNode);
        DumperOptions.FlowStyle flowStyle2 = DumperOptions.FlowStyle.FLOW;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Node nodeRepresentData = representData(entry.getKey());
            Node nodeRepresentData2 = representData(entry.getValue());
            if (!(nodeRepresentData instanceof ScalarNode) || !((ScalarNode) nodeRepresentData).isPlain()) {
                flowStyle2 = DumperOptions.FlowStyle.BLOCK;
            }
            if (!(nodeRepresentData2 instanceof ScalarNode) || !((ScalarNode) nodeRepresentData2).isPlain()) {
                flowStyle2 = DumperOptions.FlowStyle.BLOCK;
            }
            arrayList.add(new NodeTuple(nodeRepresentData, nodeRepresentData2));
        }
        if (flowStyle == DumperOptions.FlowStyle.AUTO) {
            if (this.defaultFlowStyle != DumperOptions.FlowStyle.AUTO) {
                mappingNode.setFlowStyle(this.defaultFlowStyle);
                return mappingNode;
            }
            mappingNode.setFlowStyle(flowStyle2);
        }
        return mappingNode;
    }

    public void setDefaultScalarStyle(DumperOptions.ScalarStyle scalarStyle) {
        this.defaultScalarStyle = scalarStyle;
    }

    public DumperOptions.ScalarStyle getDefaultScalarStyle() {
        DumperOptions.ScalarStyle scalarStyle = this.defaultScalarStyle;
        return scalarStyle == null ? DumperOptions.ScalarStyle.PLAIN : scalarStyle;
    }

    public void setDefaultFlowStyle(DumperOptions.FlowStyle flowStyle) {
        this.defaultFlowStyle = flowStyle;
    }

    public DumperOptions.FlowStyle getDefaultFlowStyle() {
        return this.defaultFlowStyle;
    }

    public void setPropertyUtils(PropertyUtils propertyUtils) {
        this.propertyUtils = propertyUtils;
        this.explicitPropertyUtils = true;
    }

    public final PropertyUtils getPropertyUtils() {
        if (this.propertyUtils == null) {
            this.propertyUtils = new PropertyUtils();
        }
        return this.propertyUtils;
    }

    public final boolean isExplicitPropertyUtils() {
        return this.explicitPropertyUtils;
    }
}
