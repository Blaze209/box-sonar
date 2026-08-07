package external.sdk.pendo.io.mozilla.javascript.optimizer;

import external.sdk.pendo.io.mozilla.javascript.Kit;
import external.sdk.pendo.io.mozilla.javascript.Node;
import external.sdk.pendo.io.mozilla.javascript.NodeTransformer;
import external.sdk.pendo.io.mozilla.javascript.ObjArray;
import external.sdk.pendo.io.mozilla.javascript.ast.ScriptNode;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
class OptTransformer extends NodeTransformer {
    private ObjArray directCallTargets;
    private Map<String, OptFunctionNode> possibleDirectCalls;

    OptTransformer(Map<String, OptFunctionNode> map, ObjArray objArray) {
        this.possibleDirectCalls = map;
        this.directCallTargets = objArray;
    }

    private void detectDirectCall(Node node, ScriptNode scriptNode) {
        String string;
        OptFunctionNode optFunctionNode;
        if (scriptNode.getType() == 110) {
            Node firstChild = node.getFirstChild();
            Node next = firstChild.getNext();
            int i = 0;
            while (next != null) {
                next = next.getNext();
                i++;
            }
            if (i == 0) {
                OptFunctionNode.get(scriptNode).itsContainsCalls0 = true;
            }
            if (this.possibleDirectCalls != null) {
                if (firstChild.getType() == 39) {
                    string = firstChild.getString();
                } else if (firstChild.getType() == 33) {
                    string = firstChild.getFirstChild().getNext().getString();
                } else {
                    if (firstChild.getType() == 34) {
                        throw Kit.codeBug();
                    }
                    string = null;
                }
                if (string == null || (optFunctionNode = this.possibleDirectCalls.get(string)) == null || i != optFunctionNode.fnode.getParamCount() || optFunctionNode.fnode.requiresActivation() || i > 32) {
                    return;
                }
                node.putProp(9, optFunctionNode);
                if (optFunctionNode.isTargetOfDirectCall()) {
                    return;
                }
                int size = this.directCallTargets.size();
                this.directCallTargets.add(optFunctionNode);
                optFunctionNode.setDirectTargetIndex(size);
            }
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NodeTransformer
    protected void visitCall(Node node, ScriptNode scriptNode) {
        detectDirectCall(node, scriptNode);
        super.visitCall(node, scriptNode);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NodeTransformer
    protected void visitNew(Node node, ScriptNode scriptNode) {
        detectDirectCall(node, scriptNode);
        super.visitNew(node, scriptNode);
    }
}
