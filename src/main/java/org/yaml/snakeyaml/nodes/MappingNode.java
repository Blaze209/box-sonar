package org.yaml.snakeyaml.nodes;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Iterator;
import java.util.List;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;

/* JADX INFO: loaded from: classes5.dex */
public class MappingNode extends CollectionNode<NodeTuple> {
    private boolean merged;
    private List<NodeTuple> value;

    public MappingNode(Tag tag, boolean z, List<NodeTuple> list, Mark mark, Mark mark2, DumperOptions.FlowStyle flowStyle) {
        super(tag, mark, mark2, flowStyle);
        this.merged = false;
        if (list == null) {
            throw new NullPointerException("value in a Node is required.");
        }
        this.value = list;
        this.resolved = z;
    }

    public MappingNode(Tag tag, List<NodeTuple> list, DumperOptions.FlowStyle flowStyle) {
        this(tag, true, list, null, null, flowStyle);
    }

    @Override // org.yaml.snakeyaml.nodes.Node
    public NodeId getNodeId() {
        return NodeId.mapping;
    }

    @Override // org.yaml.snakeyaml.nodes.CollectionNode
    public List<NodeTuple> getValue() {
        return this.value;
    }

    public void setValue(List<NodeTuple> list) {
        this.value = list;
    }

    public void setOnlyKeyType(Class<? extends Object> cls) {
        Iterator<NodeTuple> it = this.value.iterator();
        while (it.hasNext()) {
            it.next().getKeyNode().setType(cls);
        }
    }

    public void setTypes(Class<? extends Object> cls, Class<? extends Object> cls2) {
        for (NodeTuple nodeTuple : this.value) {
            nodeTuple.getValueNode().setType(cls2);
            nodeTuple.getKeyNode().setType(cls);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (NodeTuple nodeTuple : getValue()) {
            sb.append("{ key=");
            sb.append(nodeTuple.getKeyNode());
            sb.append("; value=");
            if (nodeTuple.getValueNode() instanceof CollectionNode) {
                sb.append(System.identityHashCode(nodeTuple.getValueNode()));
            } else {
                sb.append(nodeTuple);
            }
            sb.append(" }");
        }
        return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + " (tag=" + getTag() + ", values=" + sb.toString() + ")>";
    }

    public void setMerged(boolean z) {
        this.merged = z;
    }

    public boolean isMerged() {
        return this.merged;
    }
}
