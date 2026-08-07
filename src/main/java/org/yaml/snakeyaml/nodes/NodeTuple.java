package org.yaml.snakeyaml.nodes;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* JADX INFO: loaded from: classes5.dex */
public final class NodeTuple {
    private final Node keyNode;
    private final Node valueNode;

    public NodeTuple(Node node, Node node2) {
        if (node == null || node2 == null) {
            throw new NullPointerException("Nodes must be provided.");
        }
        this.keyNode = node;
        this.valueNode = node2;
    }

    public Node getKeyNode() {
        return this.keyNode;
    }

    public Node getValueNode() {
        return this.valueNode;
    }

    public String toString() {
        return "<NodeTuple keyNode=" + this.keyNode + "; valueNode=" + this.valueNode + SimpleComparison.GREATER_THAN_OPERATION;
    }
}
