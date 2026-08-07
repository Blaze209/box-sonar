package org.yaml.snakeyaml.constructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.util.EnumUtils;

/* JADX INFO: loaded from: classes5.dex */
public class Constructor extends SafeConstructor {
    public Constructor(LoaderOptions loaderOptions) {
        this((Class<? extends Object>) Object.class, loaderOptions);
    }

    public Constructor(Class<? extends Object> cls, LoaderOptions loaderOptions) {
        this(new TypeDescription(checkRoot(cls)), null, loaderOptions);
    }

    private static Class<? extends Object> checkRoot(Class<? extends Object> cls) {
        if (cls != null) {
            return cls;
        }
        throw new NullPointerException("Root class must be provided.");
    }

    public Constructor(TypeDescription typeDescription, LoaderOptions loaderOptions) {
        this(typeDescription, null, loaderOptions);
    }

    public Constructor(TypeDescription typeDescription, Collection<TypeDescription> collection, LoaderOptions loaderOptions) {
        super(loaderOptions);
        if (typeDescription == null) {
            throw new NullPointerException("Root type must be provided.");
        }
        this.yamlConstructors.put(null, new ConstructYamlObject());
        if (!Object.class.equals(typeDescription.getType())) {
            this.rootTag = new Tag(typeDescription.getType());
        }
        this.yamlClassConstructors.put(NodeId.scalar, new ConstructScalar());
        this.yamlClassConstructors.put(NodeId.mapping, new ConstructMapping());
        this.yamlClassConstructors.put(NodeId.sequence, new ConstructSequence());
        addTypeDescription(typeDescription);
        if (collection != null) {
            Iterator<TypeDescription> it = collection.iterator();
            while (it.hasNext()) {
                addTypeDescription(it.next());
            }
        }
    }

    public Constructor(String str, LoaderOptions loaderOptions) throws ClassNotFoundException {
        this((Class<? extends Object>) Class.forName(check(str)), loaderOptions);
    }

    private static String check(String str) {
        if (str == null) {
            throw new NullPointerException("Root type must be provided.");
        }
        if (str.trim().length() != 0) {
            return str;
        }
        throw new YAMLException("Root type must be provided.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public class ConstructMapping implements Construct {
        protected ConstructMapping() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            MappingNode mappingNode = (MappingNode) node;
            if (Map.class.isAssignableFrom(node.getType())) {
                if (node.isTwoStepsConstruction()) {
                    return Constructor.this.newMap(mappingNode);
                }
                return Constructor.this.constructMapping(mappingNode);
            }
            if (Collection.class.isAssignableFrom(node.getType())) {
                if (node.isTwoStepsConstruction()) {
                    return Constructor.this.newSet(mappingNode);
                }
                return Constructor.this.constructSet(mappingNode);
            }
            Object objNewInstance = Constructor.this.newInstance(mappingNode);
            if (objNewInstance != BaseConstructor.NOT_INSTANTIATED_OBJECT) {
                return node.isTwoStepsConstruction() ? objNewInstance : constructJavaBean2ndStep(mappingNode, objNewInstance);
            }
            throw new ConstructorException(null, null, "Can't create an instance for " + mappingNode.getTag(), node.getStartMark());
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public void construct2ndStep(Node node, Object obj) {
            if (Map.class.isAssignableFrom(node.getType())) {
                Constructor.this.constructMapping2ndStep((MappingNode) node, (Map) obj);
            } else if (Set.class.isAssignableFrom(node.getType())) {
                Constructor.this.constructSet2ndStep((MappingNode) node, (Set) obj);
            } else {
                constructJavaBean2ndStep((MappingNode) node, obj);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected Object constructJavaBean2ndStep(MappingNode mappingNode, Object obj) {
            Property property;
            Class<?>[] actualTypeArguments;
            Object objConstructObject;
            Constructor.this.flattenMapping(mappingNode, true);
            Class<? extends Object> type = mappingNode.getType();
            for (NodeTuple nodeTuple : mappingNode.getValue()) {
                Node valueNode = nodeTuple.getValueNode();
                String str = (String) Constructor.this.constructObject(nodeTuple.getKeyNode());
                try {
                    TypeDescription typeDescription = Constructor.this.typeDefinitions.get(type);
                    if (typeDescription == null) {
                        property = getProperty(type, str);
                    } else {
                        property = typeDescription.getProperty(str);
                    }
                    if (!property.isWritable()) {
                        throw new YAMLException("No writable property '" + str + "' on class: " + type.getName());
                    }
                    valueNode.setType(property.getType());
                    if ((typeDescription == null || !typeDescription.setupPropertyType(str, valueNode)) && valueNode.getNodeId() != NodeId.scalar && (actualTypeArguments = property.getActualTypeArguments()) != null && actualTypeArguments.length > 0) {
                        if (valueNode.getNodeId() == NodeId.sequence) {
                            ((SequenceNode) valueNode).setListType(actualTypeArguments[0]);
                        } else if (Map.class.isAssignableFrom(valueNode.getType())) {
                            MappingNode mappingNode2 = (MappingNode) valueNode;
                            mappingNode2.setTypes(actualTypeArguments[0], actualTypeArguments[1]);
                            mappingNode2.setUseClassConstructor(true);
                        } else if (Collection.class.isAssignableFrom(valueNode.getType())) {
                            MappingNode mappingNode3 = (MappingNode) valueNode;
                            mappingNode3.setOnlyKeyType(actualTypeArguments[0]);
                            mappingNode3.setUseClassConstructor(true);
                        }
                    }
                    if (typeDescription != null) {
                        objConstructObject = newInstance(typeDescription, str, valueNode);
                    } else {
                        objConstructObject = Constructor.this.constructObject(valueNode);
                    }
                    if ((property.getType() == Float.TYPE || property.getType() == Float.class) && (objConstructObject instanceof Double)) {
                        objConstructObject = Float.valueOf(((Double) objConstructObject).floatValue());
                    }
                    if (property.getType() == String.class && Tag.BINARY.equals(valueNode.getTag()) && (objConstructObject instanceof byte[])) {
                        objConstructObject = new String((byte[]) objConstructObject);
                    }
                    if (typeDescription == null || !typeDescription.setProperty(obj, str, objConstructObject)) {
                        property.set(obj, objConstructObject);
                    }
                } catch (DuplicateKeyException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new ConstructorException("Cannot create property=" + str + " for JavaBean=" + obj, mappingNode.getStartMark(), e2.getMessage(), valueNode.getStartMark(), e2);
                }
            }
            return obj;
        }

        private Object newInstance(TypeDescription typeDescription, String str, Node node) {
            Object objNewInstance = typeDescription.newInstance(str, node);
            if (objNewInstance != null) {
                Constructor.this.constructedObjects.put(node, objNewInstance);
                return Constructor.this.constructObjectNoCheck(node);
            }
            return Constructor.this.constructObject(node);
        }

        protected Property getProperty(Class<? extends Object> cls, String str) {
            return Constructor.this.getPropertyUtils().getProperty(cls, str);
        }
    }

    protected class ConstructYamlObject implements Construct {
        protected ConstructYamlObject() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Construct getConstructor(Node node) {
            node.setType(Constructor.this.getClassForNode(node));
            return Constructor.this.yamlClassConstructors.get(node.getNodeId());
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            try {
                return getConstructor(node).construct(node);
            } catch (ConstructorException e) {
                throw e;
            } catch (Exception e2) {
                throw new ConstructorException(null, null, "Can't construct a java object for " + node.getTag() + "; exception=" + e2.getMessage(), node.getStartMark(), e2);
            }
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public void construct2ndStep(Node node, Object obj) {
            try {
                getConstructor(node).construct2ndStep(node, obj);
            } catch (Exception e) {
                throw new ConstructorException(null, null, "Can't construct a second step for a java object for " + node.getTag() + "; exception=" + e.getMessage(), node.getStartMark(), e);
            }
        }
    }

    protected class ConstructScalar extends AbstractConstruct {
        protected ConstructScalar() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            Object objConstructScalar;
            ScalarNode scalarNode = (ScalarNode) node;
            Class<? extends Object> type = scalarNode.getType();
            Object objNewInstance = Constructor.this.newInstance(type, scalarNode, false);
            if (objNewInstance != BaseConstructor.NOT_INSTANTIATED_OBJECT) {
                return objNewInstance;
            }
            if (type.isPrimitive() || type == String.class || Number.class.isAssignableFrom(type) || type == Boolean.class || Date.class.isAssignableFrom(type) || type == Character.class || type == BigInteger.class || type == BigDecimal.class || Enum.class.isAssignableFrom(type) || Tag.BINARY.equals(scalarNode.getTag()) || Calendar.class.isAssignableFrom(type) || type == UUID.class) {
                return constructStandardJavaInstance(type, scalarNode);
            }
            java.lang.reflect.Constructor<?> declaredConstructor = null;
            int i = 0;
            for (java.lang.reflect.Constructor<?> constructor : type.getDeclaredConstructors()) {
                if (constructor.getParameterTypes().length == 1) {
                    i++;
                    declaredConstructor = constructor;
                }
            }
            if (declaredConstructor == null) {
                throw new YAMLException("No single argument constructor found for " + type);
            }
            if (i == 1) {
                objConstructScalar = constructStandardJavaInstance(declaredConstructor.getParameterTypes()[0], scalarNode);
            } else {
                objConstructScalar = Constructor.this.constructScalar(scalarNode);
                try {
                    declaredConstructor = type.getDeclaredConstructor(String.class);
                } catch (Exception e) {
                    throw new YAMLException("Can't construct a java object for scalar " + scalarNode.getTag() + "; No String constructor found. Exception=" + e.getMessage(), e);
                }
            }
            try {
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(objConstructScalar);
            } catch (Exception e2) {
                throw new ConstructorException(null, null, "Can't construct a java object for scalar " + scalarNode.getTag() + "; exception=" + e2.getMessage(), scalarNode.getStartMark(), e2);
            }
        }

        private Object constructStandardJavaInstance(Class cls, ScalarNode scalarNode) {
            if (cls == String.class) {
                return Constructor.this.yamlConstructors.get(Tag.STR).construct(scalarNode);
            }
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                return Constructor.this.yamlConstructors.get(Tag.BOOL).construct(scalarNode);
            }
            if (cls == Character.class || cls == Character.TYPE) {
                String str = (String) Constructor.this.yamlConstructors.get(Tag.STR).construct(scalarNode);
                if (str.length() == 0) {
                    return null;
                }
                if (str.length() != 1) {
                    throw new YAMLException("Invalid node Character: '" + str + "'; length: " + str.length());
                }
                return Character.valueOf(str.charAt(0));
            }
            if (Date.class.isAssignableFrom(cls)) {
                Date date = (Date) Constructor.this.yamlConstructors.get(Tag.TIMESTAMP).construct(scalarNode);
                if (cls == Date.class) {
                    return date;
                }
                try {
                    return cls.getConstructor(Long.TYPE).newInstance(Long.valueOf(date.getTime()));
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception unused) {
                    throw new YAMLException("Cannot construct: '" + cls + "'");
                }
            }
            if (cls == Float.class || cls == Double.class || cls == Float.TYPE || cls == Double.TYPE || cls == BigDecimal.class) {
                if (cls == BigDecimal.class) {
                    return new BigDecimal(scalarNode.getValue());
                }
                Object objConstruct = Constructor.this.yamlConstructors.get(Tag.FLOAT).construct(scalarNode);
                return (cls == Float.class || cls == Float.TYPE) ? Float.valueOf(((Double) objConstruct).floatValue()) : objConstruct;
            }
            if (cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == BigInteger.class || cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Long.TYPE) {
                Object objConstruct2 = Constructor.this.yamlConstructors.get(Tag.INT).construct(scalarNode);
                if (cls == Byte.class || cls == Byte.TYPE) {
                    return Byte.valueOf(Integer.valueOf(objConstruct2.toString()).byteValue());
                }
                if (cls == Short.class || cls == Short.TYPE) {
                    return Short.valueOf(Integer.valueOf(objConstruct2.toString()).shortValue());
                }
                if (cls == Integer.class || cls == Integer.TYPE) {
                    return Integer.valueOf(Integer.parseInt(objConstruct2.toString()));
                }
                if (cls == Long.class || cls == Long.TYPE) {
                    return Long.valueOf(objConstruct2.toString());
                }
                return new BigInteger(objConstruct2.toString());
            }
            if (Enum.class.isAssignableFrom(cls)) {
                String value = scalarNode.getValue();
                try {
                    if (Constructor.this.loadingConfig.isEnumCaseSensitive()) {
                        return Enum.valueOf(cls, value);
                    }
                    return EnumUtils.findEnumInsensitiveCase(cls, value);
                } catch (Exception unused2) {
                    throw new YAMLException("Unable to find enum value '" + value + "' for enum class: " + cls.getName());
                }
            }
            if (Calendar.class.isAssignableFrom(cls)) {
                SafeConstructor.ConstructYamlTimestamp constructYamlTimestamp = new SafeConstructor.ConstructYamlTimestamp();
                constructYamlTimestamp.construct(scalarNode);
                return constructYamlTimestamp.getCalendar();
            }
            if (Number.class.isAssignableFrom(cls)) {
                return new SafeConstructor.ConstructYamlFloat().construct(scalarNode);
            }
            if (UUID.class == cls) {
                return UUID.fromString(scalarNode.getValue());
            }
            if (Constructor.this.yamlConstructors.containsKey(scalarNode.getTag())) {
                return Constructor.this.yamlConstructors.get(scalarNode.getTag()).construct(scalarNode);
            }
            throw new YAMLException("Unsupported class: " + cls);
        }
    }

    protected class ConstructSequence implements Construct {
        protected ConstructSequence() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            SequenceNode sequenceNode = (SequenceNode) node;
            if (Set.class.isAssignableFrom(node.getType())) {
                if (node.isTwoStepsConstruction()) {
                    throw new YAMLException("Set cannot be recursive.");
                }
                return Constructor.this.constructSet(sequenceNode);
            }
            if (Collection.class.isAssignableFrom(node.getType())) {
                if (node.isTwoStepsConstruction()) {
                    return Constructor.this.newList(sequenceNode);
                }
                return Constructor.this.constructSequence(sequenceNode);
            }
            if (node.getType().isArray()) {
                if (node.isTwoStepsConstruction()) {
                    return Constructor.this.createArray(node.getType(), sequenceNode.getValue().size());
                }
                return Constructor.this.constructArray(sequenceNode);
            }
            ArrayList<java.lang.reflect.Constructor> arrayList = new ArrayList(sequenceNode.getValue().size());
            int i = 0;
            for (java.lang.reflect.Constructor<?> constructor : node.getType().getDeclaredConstructors()) {
                if (sequenceNode.getValue().size() == constructor.getParameterTypes().length) {
                    arrayList.add(constructor);
                }
            }
            if (!arrayList.isEmpty()) {
                if (arrayList.size() == 1) {
                    Object[] objArr = new Object[sequenceNode.getValue().size()];
                    java.lang.reflect.Constructor constructor2 = (java.lang.reflect.Constructor) arrayList.get(0);
                    for (Node node2 : sequenceNode.getValue()) {
                        node2.setType(constructor2.getParameterTypes()[i]);
                        objArr[i] = Constructor.this.constructObject(node2);
                        i++;
                    }
                    try {
                        constructor2.setAccessible(true);
                        return constructor2.newInstance(objArr);
                    } catch (Exception e) {
                        throw new YAMLException(e);
                    }
                }
                List<? extends Object> listConstructSequence = Constructor.this.constructSequence(sequenceNode);
                Class<?>[] clsArr = new Class[listConstructSequence.size()];
                Iterator<? extends Object> it = listConstructSequence.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    clsArr[i2] = it.next().getClass();
                    i2++;
                }
                for (java.lang.reflect.Constructor constructor3 : arrayList) {
                    Class<?>[] parameterTypes = constructor3.getParameterTypes();
                    int i3 = 0;
                    while (true) {
                        if (i3 < parameterTypes.length) {
                            if (!wrapIfPrimitive(parameterTypes[i3]).isAssignableFrom(clsArr[i3])) {
                                break;
                            }
                            i3++;
                        } else {
                            try {
                                constructor3.setAccessible(true);
                                return constructor3.newInstance(listConstructSequence.toArray());
                            } catch (Exception e2) {
                                throw new YAMLException(e2);
                            }
                        }
                    }
                }
            }
            throw new YAMLException("No suitable constructor with " + sequenceNode.getValue().size() + " arguments found for " + node.getType());
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Class<? extends Object> wrapIfPrimitive(Class<?> cls) {
            if (!cls.isPrimitive()) {
                return cls;
            }
            if (cls == Integer.TYPE) {
                return Integer.class;
            }
            if (cls == Float.TYPE) {
                return Float.class;
            }
            if (cls == Double.TYPE) {
                return Double.class;
            }
            if (cls == Boolean.TYPE) {
                return Boolean.class;
            }
            if (cls == Long.TYPE) {
                return Long.class;
            }
            if (cls == Character.TYPE) {
                return Character.class;
            }
            if (cls == Short.TYPE) {
                return Short.class;
            }
            if (cls == Byte.TYPE) {
                return Byte.class;
            }
            throw new YAMLException("Unexpected primitive " + cls);
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public void construct2ndStep(Node node, Object obj) {
            SequenceNode sequenceNode = (SequenceNode) node;
            if (List.class.isAssignableFrom(node.getType())) {
                Constructor.this.constructSequenceStep2(sequenceNode, (List) obj);
            } else {
                if (node.getType().isArray()) {
                    Constructor.this.constructArrayStep2(sequenceNode, obj);
                    return;
                }
                throw new YAMLException("Immutable objects cannot be recursive.");
            }
        }
    }

    protected Class<?> getClassForNode(Node node) {
        Class<? extends Object> cls = this.typeTags.get(node.getTag());
        if (cls != null) {
            return cls;
        }
        String className = node.getTag().getClassName();
        try {
            Class<?> classForName = getClassForName(className);
            this.typeTags.put(node.getTag(), (Class<? extends Object>) classForName);
            return classForName;
        } catch (ClassNotFoundException unused) {
            throw new YAMLException("Class not found: " + className);
        }
    }

    protected Class<?> getClassForName(String str) throws ClassNotFoundException {
        try {
            return Class.forName(str, true, Thread.currentThread().getContextClassLoader());
        } catch (ClassNotFoundException unused) {
            return Class.forName(str);
        }
    }
}
