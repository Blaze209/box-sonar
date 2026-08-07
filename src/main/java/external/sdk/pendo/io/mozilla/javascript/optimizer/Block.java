package external.sdk.pendo.io.mozilla.javascript.optimizer;

import external.sdk.pendo.io.mozilla.javascript.Node;
import external.sdk.pendo.io.mozilla.javascript.ObjArray;
import external.sdk.pendo.io.mozilla.javascript.ObjToIntMap;
import external.sdk.pendo.io.mozilla.javascript.ast.Jump;
import java.util.BitSet;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
class Block {
    static final boolean DEBUG = false;
    private static int debug_blockCount;
    private int itsBlockID;
    private int itsEndNodeIndex;
    private BitSet itsLiveOnEntrySet;
    private BitSet itsLiveOnExitSet;
    private BitSet itsNotDefSet;
    private Block[] itsPredecessors;
    private int itsStartNodeIndex;
    private Block[] itsSuccessors;
    private BitSet itsUseBeforeDefSet;

    private static class FatBlock {
        private ObjToIntMap predecessors;
        Block realBlock;
        private ObjToIntMap successors;

        private FatBlock() {
            this.successors = new ObjToIntMap();
            this.predecessors = new ObjToIntMap();
        }

        private static Block[] reduceToArray(ObjToIntMap objToIntMap) {
            if (objToIntMap.isEmpty()) {
                return null;
            }
            Block[] blockArr = new Block[objToIntMap.size()];
            ObjToIntMap.Iterator iteratorNewIterator = objToIntMap.newIterator();
            iteratorNewIterator.start();
            int i = 0;
            while (!iteratorNewIterator.done()) {
                blockArr[i] = ((FatBlock) iteratorNewIterator.getKey()).realBlock;
                iteratorNewIterator.next();
                i++;
            }
            return blockArr;
        }

        void addPredecessor(FatBlock fatBlock) {
            this.predecessors.put(fatBlock, 0);
        }

        void addSuccessor(FatBlock fatBlock) {
            this.successors.put(fatBlock, 0);
        }

        Block[] getPredecessors() {
            return reduceToArray(this.predecessors);
        }

        Block[] getSuccessors() {
            return reduceToArray(this.successors);
        }
    }

    Block(int i, int i2) {
        this.itsStartNodeIndex = i;
        this.itsEndNodeIndex = i2;
    }

    private static boolean assignType(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        int i4 = i2 | i3;
        iArr[i] = i4;
        return i3 != i4;
    }

    private static Block[] buildBlocks(Node[] nodeArr) {
        HashMap map = new HashMap();
        ObjArray objArray = new ObjArray();
        int i = 0;
        for (int i2 = 0; i2 < nodeArr.length; i2++) {
            int type = nodeArr[i2].getType();
            if (type != 132) {
                if (type == 5 || type == 6 || type == 7) {
                    FatBlock fatBlockNewFatBlock = newFatBlock(i, i2);
                    if (nodeArr[i].getType() == 132) {
                        map.put(nodeArr[i], fatBlockNewFatBlock);
                    }
                    objArray.add(fatBlockNewFatBlock);
                    i = i2 + 1;
                }
            } else if (i2 != i) {
                FatBlock fatBlockNewFatBlock2 = newFatBlock(i, i2 - 1);
                if (nodeArr[i].getType() == 132) {
                    map.put(nodeArr[i], fatBlockNewFatBlock2);
                }
                objArray.add(fatBlockNewFatBlock2);
                i = i2;
            }
        }
        if (i != nodeArr.length) {
            FatBlock fatBlockNewFatBlock3 = newFatBlock(i, nodeArr.length - 1);
            if (nodeArr[i].getType() == 132) {
                map.put(nodeArr[i], fatBlockNewFatBlock3);
            }
            objArray.add(fatBlockNewFatBlock3);
        }
        for (int i3 = 0; i3 < objArray.size(); i3++) {
            FatBlock fatBlock = (FatBlock) objArray.get(i3);
            Node node = nodeArr[fatBlock.realBlock.itsEndNodeIndex];
            int type2 = node.getType();
            if (type2 != 5 && i3 < objArray.size() - 1) {
                FatBlock fatBlock2 = (FatBlock) objArray.get(i3 + 1);
                fatBlock.addSuccessor(fatBlock2);
                fatBlock2.addPredecessor(fatBlock);
            }
            if (type2 == 7 || type2 == 6 || type2 == 5) {
                Node node2 = ((Jump) node).target;
                FatBlock fatBlock3 = (FatBlock) map.get(node2);
                node2.putProp(6, fatBlock3.realBlock);
                fatBlock.addSuccessor(fatBlock3);
                fatBlock3.addPredecessor(fatBlock);
            }
        }
        Block[] blockArr = new Block[objArray.size()];
        for (int i4 = 0; i4 < objArray.size(); i4++) {
            FatBlock fatBlock4 = (FatBlock) objArray.get(i4);
            Block block = fatBlock4.realBlock;
            block.itsSuccessors = fatBlock4.getSuccessors();
            block.itsPredecessors = fatBlock4.getPredecessors();
            block.itsBlockID = i4;
            blockArr[i4] = block;
        }
        return blockArr;
    }

    private boolean doReachedUseDataFlow() {
        this.itsLiveOnExitSet.clear();
        if (this.itsSuccessors != null) {
            int i = 0;
            while (true) {
                Block[] blockArr = this.itsSuccessors;
                if (i >= blockArr.length) {
                    break;
                }
                this.itsLiveOnExitSet.or(blockArr[i].itsLiveOnEntrySet);
                i++;
            }
        }
        return updateEntrySet(this.itsLiveOnEntrySet, this.itsLiveOnExitSet, this.itsUseBeforeDefSet, this.itsNotDefSet);
    }

    private boolean doTypeFlow(OptFunctionNode optFunctionNode, Node[] nodeArr, int[] iArr) {
        boolean zFindDefPoints = false;
        for (int i = this.itsStartNodeIndex; i <= this.itsEndNodeIndex; i++) {
            Node node = nodeArr[i];
            if (node != null) {
                zFindDefPoints |= findDefPoints(optFunctionNode, node, iArr);
            }
        }
        return zFindDefPoints;
    }

    private static boolean findDefPoints(OptFunctionNode optFunctionNode, Node node, int[] iArr) {
        boolean zAssignType;
        Node firstChild = node.getFirstChild();
        boolean zFindDefPoints = false;
        for (Node next = firstChild; next != null; next = next.getNext()) {
            zFindDefPoints |= findDefPoints(optFunctionNode, next, iArr);
        }
        int type = node.getType();
        if (type == 56 || type == 157) {
            int iFindExpressionType = findExpressionType(optFunctionNode, firstChild.getNext(), iArr);
            int varIndex = optFunctionNode.getVarIndex(node);
            if (node.getType() != 56 || !optFunctionNode.fnode.getParamAndVarConst()[varIndex]) {
                zAssignType = assignType(iArr, varIndex, iFindExpressionType);
                return zAssignType | zFindDefPoints;
            }
            return zFindDefPoints;
        }
        if ((type == 107 || type == 108) && firstChild.getType() == 55) {
            int varIndex2 = optFunctionNode.getVarIndex(firstChild);
            if (!optFunctionNode.fnode.getParamAndVarConst()[varIndex2]) {
                zAssignType = assignType(iArr, varIndex2, 1);
                return zAssignType | zFindDefPoints;
            }
        }
        return zFindDefPoints;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x0045 A[FALL_THROUGH, RETURN] */
    private static int findExpressionType(OptFunctionNode optFunctionNode, Node node, int[] iArr) {
        int type = node.getType();
        if (type != 35 && type != 37) {
            if (type == 40) {
                return 1;
            }
            if (type != 90) {
                if (type == 103) {
                    Node next = node.getFirstChild().getNext();
                    Node next2 = next.getNext();
                    return findExpressionType(optFunctionNode, next2, iArr) | findExpressionType(optFunctionNode, next, iArr);
                }
                if (type != 157) {
                    if (type == 55) {
                        return iArr[optFunctionNode.getVarIndex(node)];
                    }
                    if (type != 56) {
                        switch (type) {
                            case 8:
                                break;
                            default:
                                switch (type) {
                                    case 18:
                                    case 19:
                                    case 20:
                                    case 22:
                                    case 23:
                                    case 24:
                                    case 25:
                                        break;
                                    case 21:
                                        Node firstChild = node.getFirstChild();
                                        return findExpressionType(optFunctionNode, firstChild.getNext(), iArr) | findExpressionType(optFunctionNode, firstChild, iArr);
                                    default:
                                        switch (type) {
                                            default:
                                                switch (type) {
                                                    case 105:
                                                    case 106:
                                                        Node firstChild2 = node.getFirstChild();
                                                        return findExpressionType(optFunctionNode, firstChild2.getNext(), iArr) | findExpressionType(optFunctionNode, firstChild2, iArr);
                                                    case 107:
                                                    case 108:
                                                        break;
                                                    default:
                                                        return 3;
                                                }
                                            case 27:
                                            case 28:
                                            case 29:
                                                return 1;
                                        }
                                        break;
                                }
                            case 9:
                            case 10:
                            case 11:
                                return 1;
                        }
                    }
                }
            }
        }
        return findExpressionType(optFunctionNode, node.getLastChild(), iArr);
    }

    private void initLiveOnEntrySets(OptFunctionNode optFunctionNode, Node[] nodeArr) {
        int varCount = optFunctionNode.getVarCount();
        this.itsUseBeforeDefSet = new BitSet(varCount);
        this.itsNotDefSet = new BitSet(varCount);
        this.itsLiveOnEntrySet = new BitSet(varCount);
        this.itsLiveOnExitSet = new BitSet(varCount);
        for (int i = this.itsStartNodeIndex; i <= this.itsEndNodeIndex; i++) {
            lookForVariableAccess(optFunctionNode, nodeArr[i]);
        }
        this.itsNotDefSet.flip(0, varCount);
    }

    private void lookForVariableAccess(OptFunctionNode optFunctionNode, Node node) {
        int varIndex;
        BitSet bitSet;
        int type = node.getType();
        if (type != 55) {
            if (type == 56) {
                lookForVariableAccess(optFunctionNode, node.getFirstChild().getNext());
                bitSet = this.itsNotDefSet;
                varIndex = optFunctionNode.getVarIndex(node);
            } else if (type == 107 || type == 108) {
                Node firstChild = node.getFirstChild();
                if (firstChild.getType() != 55) {
                    lookForVariableAccess(optFunctionNode, firstChild);
                    return;
                }
                varIndex = optFunctionNode.getVarIndex(firstChild);
                if (!this.itsNotDefSet.get(varIndex)) {
                    this.itsUseBeforeDefSet.set(varIndex);
                }
                bitSet = this.itsNotDefSet;
            } else if (type != 138) {
                if (type != 157) {
                    for (Node firstChild2 = node.getFirstChild(); firstChild2 != null; firstChild2 = firstChild2.getNext()) {
                        lookForVariableAccess(optFunctionNode, firstChild2);
                    }
                    return;
                }
                lookForVariableAccess(optFunctionNode, node.getFirstChild().getNext());
                bitSet = this.itsNotDefSet;
                varIndex = optFunctionNode.getVarIndex(node);
            } else {
                varIndex = optFunctionNode.fnode.getIndexForNameNode(node);
                if (varIndex <= -1 || this.itsNotDefSet.get(varIndex)) {
                    return;
                }
            }
            bitSet.set(varIndex);
        }
        varIndex = optFunctionNode.getVarIndex(node);
        if (this.itsNotDefSet.get(varIndex)) {
            return;
        }
        bitSet = this.itsUseBeforeDefSet;
        bitSet.set(varIndex);
    }

    private void markAnyTypeVariables(int[] iArr) {
        for (int i = 0; i != iArr.length; i++) {
            if (this.itsLiveOnEntrySet.get(i)) {
                assignType(iArr, i, 3);
            }
        }
    }

    private static FatBlock newFatBlock(int i, int i2) {
        FatBlock fatBlock = new FatBlock();
        fatBlock.realBlock = new Block(i, i2);
        return fatBlock;
    }

    private void printLiveOnEntrySet(OptFunctionNode optFunctionNode) {
    }

    private static void reachingDefDataFlow(OptFunctionNode optFunctionNode, Node[] nodeArr, Block[] blockArr, int[] iArr) {
        Block[] blockArr2;
        for (Block block : blockArr) {
            block.initLiveOnEntrySets(optFunctionNode, nodeArr);
        }
        boolean[] zArr = new boolean[blockArr.length];
        boolean[] zArr2 = new boolean[blockArr.length];
        int length = blockArr.length - 1;
        zArr[length] = true;
        while (true) {
            boolean z = false;
            while (true) {
                if (zArr[length] || !zArr2[length]) {
                    zArr2[length] = true;
                    zArr[length] = false;
                    if (blockArr[length].doReachedUseDataFlow() && (blockArr2 = blockArr[length].itsPredecessors) != null) {
                        for (Block block2 : blockArr2) {
                            int i = block2.itsBlockID;
                            zArr[i] = true;
                            z |= i > length;
                        }
                    }
                }
                if (length == 0) {
                    break;
                } else {
                    length--;
                }
            }
            if (!z) {
                blockArr[0].markAnyTypeVariables(iArr);
                return;
            }
            length = blockArr.length - 1;
        }
    }

    static void runFlowAnalyzes(OptFunctionNode optFunctionNode, Node[] nodeArr) {
        int paramCount = optFunctionNode.fnode.getParamCount();
        int paramAndVarCount = optFunctionNode.fnode.getParamAndVarCount();
        int[] iArr = new int[paramAndVarCount];
        for (int i = 0; i != paramCount; i++) {
            iArr[i] = 3;
        }
        for (int i2 = paramCount; i2 != paramAndVarCount; i2++) {
            iArr[i2] = 0;
        }
        Block[] blockArrBuildBlocks = buildBlocks(nodeArr);
        reachingDefDataFlow(optFunctionNode, nodeArr, blockArrBuildBlocks, iArr);
        typeFlow(optFunctionNode, nodeArr, blockArrBuildBlocks, iArr);
        while (paramCount != paramAndVarCount) {
            if (iArr[paramCount] == 1) {
                optFunctionNode.setIsNumberVar(paramCount);
            }
            paramCount++;
        }
    }

    private static String toString(Block[] blockArr, Node[] nodeArr) {
        return null;
    }

    private static void typeFlow(OptFunctionNode optFunctionNode, Node[] nodeArr, Block[] blockArr, int[] iArr) {
        boolean z;
        Block[] blockArr2;
        boolean[] zArr = new boolean[blockArr.length];
        boolean[] zArr2 = new boolean[blockArr.length];
        zArr[0] = true;
        do {
            int i = 0;
            z = false;
            while (true) {
                if (zArr[i] || !zArr2[i]) {
                    zArr2[i] = true;
                    zArr[i] = false;
                    if (blockArr[i].doTypeFlow(optFunctionNode, nodeArr, iArr) && (blockArr2 = blockArr[i].itsSuccessors) != null) {
                        for (Block block : blockArr2) {
                            int i2 = block.itsBlockID;
                            zArr[i2] = true;
                            z |= i2 < i;
                        }
                    }
                }
                if (i == blockArr.length - 1) {
                    break;
                } else {
                    i++;
                }
            }
        } while (z);
    }

    private static boolean updateEntrySet(BitSet bitSet, BitSet bitSet2, BitSet bitSet3, BitSet bitSet4) {
        int iCardinality = bitSet.cardinality();
        bitSet.or(bitSet2);
        bitSet.and(bitSet4);
        bitSet.or(bitSet3);
        return bitSet.cardinality() != iCardinality;
    }
}
