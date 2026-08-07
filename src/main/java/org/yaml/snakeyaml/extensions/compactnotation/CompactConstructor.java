package org.yaml.snakeyaml.extensions.compactnotation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.constructor.Construct;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;

/* JADX INFO: loaded from: classes5.dex */
public class CompactConstructor extends Constructor {
    private Construct compactConstruct;
    private static final Pattern GUESS_COMPACT = Pattern.compile("\\p{Alpha}.*\\s*\\((?:,?\\s*(?:(?:\\w*)|(?:\\p{Alpha}\\w*\\s*=.+))\\s*)+\\)");
    private static final Pattern FIRST_PATTERN = Pattern.compile("(\\p{Alpha}.*)(\\s*)\\((.*?)\\)");
    private static final Pattern PROPERTY_NAME_PATTERN = Pattern.compile("\\s*(\\p{Alpha}\\w*)\\s*=(.+)");

    public CompactConstructor(LoaderOptions loaderOptions) {
        super(loaderOptions);
    }

    public CompactConstructor() {
        super(new LoaderOptions());
    }

    protected Object constructCompactFormat(ScalarNode scalarNode, CompactData compactData) {
        try {
            Object objCreateInstance = createInstance(scalarNode, compactData);
            setProperties(objCreateInstance, new HashMap(compactData.getProperties()));
            return objCreateInstance;
        } catch (Exception e) {
            throw new YAMLException(e);
        }
    }

    protected Object createInstance(ScalarNode scalarNode, CompactData compactData) throws Exception {
        Class<?> classForName = getClassForName(compactData.getPrefix());
        int size = compactData.getArguments().size();
        Class<?>[] clsArr = new Class[size];
        for (int i = 0; i < size; i++) {
            clsArr[i] = String.class;
        }
        java.lang.reflect.Constructor<?> declaredConstructor = classForName.getDeclaredConstructor(clsArr);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(compactData.getArguments().toArray());
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void setProperties(Object obj, Map<String, Object> map) throws Exception {
        if (map == null) {
            throw new NullPointerException("Data for Compact Object Notation cannot be null.");
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            try {
                getPropertyUtils().getProperty(obj.getClass(), key).set(obj, entry.getValue());
            } catch (IllegalArgumentException unused) {
                throw new YAMLException("Cannot set property='" + key + "' with value='" + map.get(key) + "' (" + map.get(key).getClass() + ") in " + obj);
            }
        }
    }

    public CompactData getCompactData(String str) {
        if (!str.endsWith(")") || str.indexOf(40) < 0) {
            return null;
        }
        Matcher matcher = FIRST_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String strTrim = matcher.group(1).trim();
        String strGroup = matcher.group(3);
        CompactData compactData = new CompactData(strTrim);
        if (strGroup.length() != 0) {
            for (String str2 : strGroup.split("\\s*,\\s*")) {
                if (str2.indexOf(61) < 0) {
                    compactData.getArguments().add(str2);
                } else {
                    Matcher matcher2 = PROPERTY_NAME_PATTERN.matcher(str2);
                    if (!matcher2.matches()) {
                        return null;
                    }
                    compactData.getProperties().put(matcher2.group(1), matcher2.group(2).trim());
                }
            }
        }
        return compactData;
    }

    private Construct getCompactConstruct() {
        if (this.compactConstruct == null) {
            this.compactConstruct = createCompactConstruct();
        }
        return this.compactConstruct;
    }

    protected Construct createCompactConstruct() {
        return new ConstructCompactObject();
    }

    @Override // org.yaml.snakeyaml.constructor.BaseConstructor
    protected Construct getConstructor(Node node) {
        if (node instanceof MappingNode) {
            List<NodeTuple> value = ((MappingNode) node).getValue();
            if (value.size() == 1) {
                Node keyNode = value.get(0).getKeyNode();
                if ((keyNode instanceof ScalarNode) && GUESS_COMPACT.matcher(((ScalarNode) keyNode).getValue()).matches()) {
                    return getCompactConstruct();
                }
            }
        } else if ((node instanceof ScalarNode) && GUESS_COMPACT.matcher(((ScalarNode) node).getValue()).matches()) {
            return getCompactConstruct();
        }
        return super.getConstructor(node);
    }

    public class ConstructCompactObject extends Constructor.ConstructMapping {
        public ConstructCompactObject() {
            super();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.yaml.snakeyaml.constructor.Constructor.ConstructMapping, org.yaml.snakeyaml.constructor.Construct
        public void construct2ndStep(Node node, Object obj) {
            Node valueNode = ((MappingNode) node).getValue().iterator().next().getValueNode();
            if (valueNode instanceof MappingNode) {
                valueNode.setType(obj.getClass());
                constructJavaBean2ndStep((MappingNode) valueNode, obj);
            } else {
                CompactConstructor compactConstructor = CompactConstructor.this;
                compactConstructor.applySequence(obj, compactConstructor.constructSequence((SequenceNode) valueNode));
            }
        }

        @Override // org.yaml.snakeyaml.constructor.Constructor.ConstructMapping, org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            ScalarNode scalarNode;
            if (node instanceof MappingNode) {
                NodeTuple next = ((MappingNode) node).getValue().iterator().next();
                node.setTwoStepsConstruction(true);
                scalarNode = (ScalarNode) next.getKeyNode();
            } else {
                scalarNode = (ScalarNode) node;
            }
            CompactData compactData = CompactConstructor.this.getCompactData(scalarNode.getValue());
            if (compactData == null) {
                return CompactConstructor.this.constructScalar(scalarNode);
            }
            return CompactConstructor.this.constructCompactFormat(scalarNode, compactData);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void applySequence(Object obj, List<?> list) {
        try {
            getPropertyUtils().getProperty(obj.getClass(), getSequencePropertyName(obj.getClass())).set(obj, list);
        } catch (Exception e) {
            throw new YAMLException(e);
        }
    }

    protected String getSequencePropertyName(Class<?> cls) {
        Set<Property> properties = getPropertyUtils().getProperties(cls);
        Iterator<Property> it = properties.iterator();
        while (it.hasNext()) {
            if (!List.class.isAssignableFrom(it.next().getType())) {
                it.remove();
            }
        }
        if (properties.size() == 0) {
            throw new YAMLException("No list property found in " + cls);
        }
        if (properties.size() > 1) {
            throw new YAMLException("Many list properties found in " + cls + "; Please override getSequencePropertyName() to specify which property to use.");
        }
        return properties.iterator().next().getName();
    }
}
