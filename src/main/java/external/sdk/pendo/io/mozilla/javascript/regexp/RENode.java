package external.sdk.pendo.io.mozilla.javascript.regexp;

/* JADX INFO: loaded from: classes4.dex */
class RENode {
    int bmsize;
    char chr;
    int flatIndex;
    boolean greedy;
    int index;
    RENode kid;
    RENode kid2;
    int kidlen;
    int length;
    int max;
    int min;
    RENode next;
    byte op;
    int parenCount;
    int parenIndex;
    boolean sense;
    int startIndex;

    RENode(byte b) {
        this.op = b;
    }
}
