package org.yaml.snakeyaml.nodes;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Iterator;
import java.util.List;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;

/* JADX INFO: loaded from: classes5.dex */
public class SequenceNode extends CollectionNode<Node> {
    private final List<Node> value;

    public SequenceNode(Tag tag, boolean z, List<Node> list, Mark mark, Mark mark2, DumperOptions.FlowStyle flowStyle) {
        super(tag, mark, mark2, flowStyle);
        if (list == null) {
            throw new NullPointerException("value in a Node is required.");
        }
        this.value = list;
        this.resolved = z;
    }

    public SequenceNode(Tag tag, List<Node> list, DumperOptions.FlowStyle flowStyle) {
        this(tag, true, list, null, null, flowStyle);
    }

    @Override // org.yaml.snakeyaml.nodes.Node
    public NodeId getNodeId() {
        return NodeId.sequence;
    }

    @Override // org.yaml.snakeyaml.nodes.CollectionNode
    public List<Node> getValue() {
        return this.value;
    }

    public void setListType(Class<? extends Object> cls) {
        Iterator<Node> it = this.value.iterator();
        while (it.hasNext()) {
            it.next().setType(cls);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node node : getValue()) {
            if (node instanceof CollectionNode) {
                sb.append(System.identityHashCode(node));
            } else {
                sb.append(node.toString());
            }
            sb.append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + " (tag=" + getTag() + ", value=[" + ((Object) sb) + "])>";
    }
}
