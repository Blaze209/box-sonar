package org.yaml.snakeyaml.nodes;

/* JADX INFO: loaded from: classes5.dex */
public class AnchorNode extends Node {
    private final Node realNode;

    public AnchorNode(Node node) {
        super(node.getTag(), node.getStartMark(), node.getEndMark());
        this.realNode = node;
    }

    @Override // org.yaml.snakeyaml.nodes.Node
    public NodeId getNodeId() {
        return NodeId.anchor;
    }

    public Node getRealNode() {
        return this.realNode;
    }
}
