package org.yaml.snakeyaml.serializer;

import java.text.NumberFormat;
import org.yaml.snakeyaml.nodes.Node;

/* JADX INFO: loaded from: classes5.dex */
public class NumberAnchorGenerator implements AnchorGenerator {
    private int lastAnchorId;

    public NumberAnchorGenerator(int i) {
        this.lastAnchorId = i;
    }

    @Override // org.yaml.snakeyaml.serializer.AnchorGenerator
    public String nextAnchor(Node node) {
        this.lastAnchorId++;
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMinimumIntegerDigits(3);
        numberInstance.setMaximumFractionDigits(0);
        numberInstance.setGroupingUsed(false);
        return "id" + numberInstance.format(this.lastAnchorId);
    }
}
