package org.yaml.snakeyaml.constructor;

import java.lang.reflect.Array;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.composer.Composer;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.nodes.CollectionNode;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseConstructor {
    protected static final Object NOT_INSTANTIATED_OBJECT = new Object();
    protected Composer composer;
    final Map<Node, Object> constructedObjects;
    private boolean explicitPropertyUtils;
    protected LoaderOptions loadingConfig;
    private final ArrayList<RecursiveTuple<Map<Object, Object>, RecursiveTuple<Object, Object>>> maps2fill;
    private PropertyUtils propertyUtils;
    private final Set<Node> recursiveObjects;
    protected Tag rootTag;
    private final ArrayList<RecursiveTuple<Set<Object>, Object>> sets2fill;
    protected final Map<Class<? extends Object>, TypeDescription> typeDefinitions;
    protected final Map<Tag, Class<? extends Object>> typeTags;
    protected final Map<NodeId, Construct> yamlClassConstructors = new EnumMap(NodeId.class);
    protected final Map<Tag, Construct> yamlConstructors = new HashMap();
    protected final Map<String, Construct> yamlMultiConstructors = new HashMap();
    private boolean allowDuplicateKeys = true;
    private boolean wrappedToRootException = false;
    private boolean enumCaseSensitive = false;

    public BaseConstructor(LoaderOptions loaderOptions) {
        if (loaderOptions == null) {
            throw new NullPointerException("LoaderOptions must be provided.");
        }
        this.constructedObjects = new HashMap();
        this.recursiveObjects = new HashSet();
        this.maps2fill = new ArrayList<>();
        this.sets2fill = new ArrayList<>();
        HashMap map = new HashMap();
        this.typeDefinitions = map;
        this.typeTags = new HashMap();
        this.rootTag = null;
        this.explicitPropertyUtils = false;
        map.put(SortedMap.class, new TypeDescription(SortedMap.class, Tag.OMAP, TreeMap.class));
        map.put(SortedSet.class, new TypeDescription(SortedSet.class, Tag.SET, TreeSet.class));
        this.loadingConfig = loaderOptions;
    }

    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    public boolean checkData() {
        return this.composer.checkNode();
    }

    public Object getData() throws NoSuchElementException {
        if (!this.composer.checkNode()) {
            throw new NoSuchElementException("No document is available.");
        }
        Node node = this.composer.getNode();
        Tag tag = this.rootTag;
        if (tag != null) {
            node.setTag(tag);
        }
        return constructDocument(node);
    }

    public Object getSingleData(Class<?> cls) {
        Node singleNode = this.composer.getSingleNode();
        if (singleNode != null && !Tag.NULL.equals(singleNode.getTag())) {
            if (Object.class != cls) {
                singleNode.setTag(new Tag((Class<? extends Object>) cls));
            } else {
                Tag tag = this.rootTag;
                if (tag != null) {
                    singleNode.setTag(tag);
                }
            }
            return constructDocument(singleNode);
        }
        return this.yamlConstructors.get(Tag.NULL).construct(singleNode);
    }

    protected final Object constructDocument(Node node) {
        try {
            try {
                Object objConstructObject = constructObject(node);
                fillRecursive();
                this.constructedObjects.clear();
                this.recursiveObjects.clear();
                return objConstructObject;
            } catch (RuntimeException e) {
                if (this.wrappedToRootException && !(e instanceof YAMLException)) {
                    throw new YAMLException(e);
                }
                throw e;
            }
        } catch (Throwable th) {
            this.constructedObjects.clear();
            this.recursiveObjects.clear();
            throw th;
        }
    }

    private void fillRecursive() {
        if (!this.maps2fill.isEmpty()) {
            for (RecursiveTuple<Map<Object, Object>, RecursiveTuple<Object, Object>> recursiveTuple : this.maps2fill) {
                RecursiveTuple<Object, Object> recursiveTuple_2 = recursiveTuple._2();
                recursiveTuple._1().put(recursiveTuple_2._1(), recursiveTuple_2._2());
            }
            this.maps2fill.clear();
        }
        if (this.sets2fill.isEmpty()) {
            return;
        }
        for (RecursiveTuple<Set<Object>, Object> recursiveTuple2 : this.sets2fill) {
            recursiveTuple2._1().add(recursiveTuple2._2());
        }
        this.sets2fill.clear();
    }

    protected Object constructObject(Node node) {
        if (this.constructedObjects.containsKey(node)) {
            return this.constructedObjects.get(node);
        }
        return constructObjectNoCheck(node);
    }

    protected Object constructObjectNoCheck(Node node) {
        if (this.recursiveObjects.contains(node)) {
            throw new ConstructorException(null, null, "found unconstructable recursive node", node.getStartMark());
        }
        this.recursiveObjects.add(node);
        Construct constructor = getConstructor(node);
        Object objConstruct = this.constructedObjects.containsKey(node) ? this.constructedObjects.get(node) : constructor.construct(node);
        finalizeConstruction(node, objConstruct);
        this.constructedObjects.put(node, objConstruct);
        this.recursiveObjects.remove(node);
        if (node.isTwoStepsConstruction()) {
            constructor.construct2ndStep(node, objConstruct);
        }
        return objConstruct;
    }

    protected Construct getConstructor(Node node) {
        if (node.useClassConstructor()) {
            return this.yamlClassConstructors.get(node.getNodeId());
        }
        Tag tag = node.getTag();
        Construct construct = this.yamlConstructors.get(tag);
        if (construct != null) {
            return construct;
        }
        for (String str : this.yamlMultiConstructors.keySet()) {
            if (tag.startsWith(str)) {
                return this.yamlMultiConstructors.get(str);
            }
        }
        return this.yamlConstructors.get(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String constructScalar(ScalarNode scalarNode) {
        return scalarNode.getValue();
    }

    protected List<Object> createDefaultList(int i) {
        return new ArrayList(i);
    }

    protected Set<Object> createDefaultSet(int i) {
        return new LinkedHashSet(i);
    }

    protected Map<Object, Object> createDefaultMap(int i) {
        return new LinkedHashMap(i);
    }

    protected Object createArray(Class<?> cls, int i) {
        return Array.newInstance(cls.getComponentType(), i);
    }

    protected Object finalizeConstruction(Node node, Object obj) {
        Class<? extends Object> type = node.getType();
        return this.typeDefinitions.containsKey(type) ? this.typeDefinitions.get(type).finalizeConstruction(obj) : obj;
    }

    protected Object newInstance(Node node) {
        return newInstance(Object.class, node);
    }

    protected final Object newInstance(Class<?> cls, Node node) {
        return newInstance(cls, node, true);
    }

    protected Object newInstance(Class<?> cls, Node node, boolean z) {
        Object objNewInstance;
        try {
            Class<? extends Object> type = node.getType();
            if (this.typeDefinitions.containsKey(type) && (objNewInstance = this.typeDefinitions.get(type).newInstance(node)) != null) {
                return objNewInstance;
            }
            if (z && cls.isAssignableFrom(type) && !Modifier.isAbstract(type.getModifiers())) {
                java.lang.reflect.Constructor<? extends Object> declaredConstructor = type.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(new Object[0]);
            }
            return NOT_INSTANTIATED_OBJECT;
        } catch (Exception e) {
            throw new YAMLException(e);
        }
    }

    protected Set<Object> newSet(CollectionNode<?> collectionNode) {
        Object objNewInstance = newInstance(Set.class, collectionNode);
        if (objNewInstance != NOT_INSTANTIATED_OBJECT) {
            return (Set) objNewInstance;
        }
        return createDefaultSet(collectionNode.getValue().size());
    }

    protected List<Object> newList(SequenceNode sequenceNode) {
        Object objNewInstance = newInstance(List.class, sequenceNode);
        if (objNewInstance != NOT_INSTANTIATED_OBJECT) {
            return (List) objNewInstance;
        }
        return createDefaultList(sequenceNode.getValue().size());
    }

    protected Map<Object, Object> newMap(MappingNode mappingNode) {
        Object objNewInstance = newInstance(Map.class, mappingNode);
        if (objNewInstance != NOT_INSTANTIATED_OBJECT) {
            return (Map) objNewInstance;
        }
        return createDefaultMap(mappingNode.getValue().size());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<? extends Object> constructSequence(SequenceNode sequenceNode) {
        List<? extends Object> listNewList = newList(sequenceNode);
        constructSequenceStep2(sequenceNode, listNewList);
        return listNewList;
    }

    protected Set<? extends Object> constructSet(SequenceNode sequenceNode) {
        Set<? extends Object> setNewSet = newSet(sequenceNode);
        constructSequenceStep2(sequenceNode, setNewSet);
        return setNewSet;
    }

    protected Object constructArray(SequenceNode sequenceNode) {
        return constructArrayStep2(sequenceNode, createArray(sequenceNode.getType(), sequenceNode.getValue().size()));
    }

    protected void constructSequenceStep2(SequenceNode sequenceNode, Collection<Object> collection) {
        Iterator<Node> it = sequenceNode.getValue().iterator();
        while (it.hasNext()) {
            collection.add(constructObject(it.next()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected Object constructArrayStep2(SequenceNode sequenceNode, Object obj) {
        Class<?> componentType = sequenceNode.getType().getComponentType();
        int i = 0;
        for (Node node : sequenceNode.getValue()) {
            if (node.getType() == Object.class) {
                node.setType(componentType);
            }
            Object objConstructObject = constructObject(node);
            if (componentType.isPrimitive()) {
                if (objConstructObject == null) {
                    throw new NullPointerException("Unable to construct element value for " + node);
                }
                if (Byte.TYPE.equals(componentType)) {
                    Array.setByte(obj, i, ((Number) objConstructObject).byteValue());
                } else if (Short.TYPE.equals(componentType)) {
                    Array.setShort(obj, i, ((Number) objConstructObject).shortValue());
                } else if (Integer.TYPE.equals(componentType)) {
                    Array.setInt(obj, i, ((Number) objConstructObject).intValue());
                } else if (Long.TYPE.equals(componentType)) {
                    Array.setLong(obj, i, ((Number) objConstructObject).longValue());
                } else if (Float.TYPE.equals(componentType)) {
                    Array.setFloat(obj, i, ((Number) objConstructObject).floatValue());
                } else if (Double.TYPE.equals(componentType)) {
                    Array.setDouble(obj, i, ((Number) objConstructObject).doubleValue());
                } else if (Character.TYPE.equals(componentType)) {
                    Array.setChar(obj, i, ((Character) objConstructObject).charValue());
                } else if (Boolean.TYPE.equals(componentType)) {
                    Array.setBoolean(obj, i, ((Boolean) objConstructObject).booleanValue());
                } else {
                    throw new YAMLException("unexpected primitive type");
                }
            } else {
                Array.set(obj, i, objConstructObject);
            }
            i++;
        }
        return obj;
    }

    protected Set<Object> constructSet(MappingNode mappingNode) {
        Set<Object> setNewSet = newSet(mappingNode);
        constructSet2ndStep(mappingNode, setNewSet);
        return setNewSet;
    }

    protected Map<Object, Object> constructMapping(MappingNode mappingNode) {
        Map<Object, Object> mapNewMap = newMap(mappingNode);
        constructMapping2ndStep(mappingNode, mapNewMap);
        return mapNewMap;
    }

    protected void constructMapping2ndStep(MappingNode mappingNode, Map<Object, Object> map) {
        for (NodeTuple nodeTuple : mappingNode.getValue()) {
            Node keyNode = nodeTuple.getKeyNode();
            Node valueNode = nodeTuple.getValueNode();
            Object objConstructObject = constructObject(keyNode);
            if (objConstructObject != null) {
                try {
                    objConstructObject.hashCode();
                } catch (Exception e) {
                    throw new ConstructorException("while constructing a mapping", mappingNode.getStartMark(), "found unacceptable key " + objConstructObject, nodeTuple.getKeyNode().getStartMark(), e);
                }
            }
            Object objConstructObject2 = constructObject(valueNode);
            if (keyNode.isTwoStepsConstruction()) {
                if (this.loadingConfig.getAllowRecursiveKeys()) {
                    postponeMapFilling(map, objConstructObject, objConstructObject2);
                } else {
                    throw new YAMLException("Recursive key for mapping is detected but it is not configured to be allowed.");
                }
            } else {
                map.put(objConstructObject, objConstructObject2);
            }
        }
    }

    protected void postponeMapFilling(Map<Object, Object> map, Object obj, Object obj2) {
        this.maps2fill.add(0, new RecursiveTuple<>(map, new RecursiveTuple(obj, obj2)));
    }

    protected void constructSet2ndStep(MappingNode mappingNode, Set<Object> set) {
        for (NodeTuple nodeTuple : mappingNode.getValue()) {
            Node keyNode = nodeTuple.getKeyNode();
            Object objConstructObject = constructObject(keyNode);
            if (objConstructObject != null) {
                try {
                    objConstructObject.hashCode();
                } catch (Exception e) {
                    throw new ConstructorException("while constructing a Set", mappingNode.getStartMark(), "found unacceptable key " + objConstructObject, nodeTuple.getKeyNode().getStartMark(), e);
                }
            }
            if (keyNode.isTwoStepsConstruction()) {
                postponeSetFilling(set, objConstructObject);
            } else {
                set.add(objConstructObject);
            }
        }
    }

    protected void postponeSetFilling(Set<Object> set, Object obj) {
        this.sets2fill.add(0, new RecursiveTuple<>(set, obj));
    }

    public void setPropertyUtils(PropertyUtils propertyUtils) {
        this.propertyUtils = propertyUtils;
        this.explicitPropertyUtils = true;
        Iterator<TypeDescription> it = this.typeDefinitions.values().iterator();
        while (it.hasNext()) {
            it.next().setPropertyUtils(propertyUtils);
        }
    }

    public final PropertyUtils getPropertyUtils() {
        if (this.propertyUtils == null) {
            this.propertyUtils = new PropertyUtils();
        }
        return this.propertyUtils;
    }

    public TypeDescription addTypeDescription(TypeDescription typeDescription) {
        if (typeDescription == null) {
            throw new NullPointerException("TypeDescription is required.");
        }
        this.typeTags.put(typeDescription.getTag(), typeDescription.getType());
        typeDescription.setPropertyUtils(getPropertyUtils());
        return this.typeDefinitions.put(typeDescription.getType(), typeDescription);
    }

    private static class RecursiveTuple<T, K> {
        private final T _1;
        private final K _2;

        public RecursiveTuple(T t, K k) {
            this._1 = t;
            this._2 = k;
        }

        public K _2() {
            return this._2;
        }

        public T _1() {
            return this._1;
        }
    }

    public final boolean isExplicitPropertyUtils() {
        return this.explicitPropertyUtils;
    }

    public boolean isAllowDuplicateKeys() {
        return this.allowDuplicateKeys;
    }

    public void setAllowDuplicateKeys(boolean z) {
        this.allowDuplicateKeys = z;
    }

    public boolean isWrappedToRootException() {
        return this.wrappedToRootException;
    }

    public void setWrappedToRootException(boolean z) {
        this.wrappedToRootException = z;
    }

    public boolean isEnumCaseSensitive() {
        return this.enumCaseSensitive;
    }

    public void setEnumCaseSensitive(boolean z) {
        this.enumCaseSensitive = z;
    }

    public LoaderOptions getLoadingConfig() {
        return this.loadingConfig;
    }
}
