package external.sdk.pendo.io.mozilla.javascript.tools.idswitch;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/* JADX INFO: loaded from: classes4.dex */
public class FileBody {
    private char[] buffer = new char[16384];
    private int bufferEnd;
    ReplaceItem firstReplace;
    ReplaceItem lastReplace;
    private int lineBegin;
    private int lineEnd;
    private int lineNumber;
    private int nextLineStart;

    private static class ReplaceItem {
        int begin;
        int end;
        ReplaceItem next;
        String replacement;

        ReplaceItem(int i, int i2, String str) {
            this.begin = i;
            this.end = i2;
            this.replacement = str;
        }
    }

    private static boolean equals(String str, char[] cArr, int i, int i2) {
        if (str.length() != i2 - i) {
            return false;
        }
        int i3 = 0;
        while (i != i2) {
            if (cArr[i] != str.charAt(i3)) {
                return false;
            }
            i++;
            i3++;
        }
        return true;
    }

    public char[] getBuffer() {
        return this.buffer;
    }

    public int getLineBegin() {
        return this.lineBegin;
    }

    public int getLineEnd() {
        return this.lineEnd;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public boolean nextLine() {
        int i;
        int i2;
        int i3 = this.nextLineStart;
        char c = 0;
        if (i3 == this.bufferEnd) {
            this.lineNumber = 0;
            return false;
        }
        while (true) {
            i = this.bufferEnd;
            if (i3 == i || (c = this.buffer[i3]) == '\n' || c == '\r') {
                break;
            }
            i3++;
        }
        this.lineBegin = this.nextLineStart;
        this.lineEnd = i3;
        if (i3 != i) {
            i3 = (c == '\r' && (i2 = i3 + 1) != i && this.buffer[i2] == '\n') ? i3 + 2 : i3 + 1;
        }
        this.nextLineStart = i3;
        this.lineNumber++;
        return true;
    }

    public void readData(Reader reader) throws IOException {
        int length = this.buffer.length;
        int i = 0;
        while (true) {
            int i2 = reader.read(this.buffer, i, length - i);
            if (i2 < 0) {
                this.bufferEnd = i;
                return;
            }
            i += i2;
            if (length == i) {
                length *= 2;
                char[] cArr = new char[length];
                System.arraycopy(this.buffer, 0, cArr, 0, i);
                this.buffer = cArr;
            }
        }
    }

    public boolean setReplacement(int i, int i2, String str) {
        ReplaceItem replaceItem;
        if (equals(str, this.buffer, i, i2)) {
            return false;
        }
        ReplaceItem replaceItem2 = new ReplaceItem(i, i2, str);
        ReplaceItem replaceItem3 = this.firstReplace;
        if (replaceItem3 == null) {
            this.lastReplace = replaceItem2;
        } else {
            if (i >= replaceItem3.begin) {
                while (true) {
                    replaceItem = replaceItem3.next;
                    if (replaceItem == null) {
                        break;
                    }
                    if (i < replaceItem.begin) {
                        replaceItem2.next = replaceItem;
                        replaceItem3.next = replaceItem2;
                        break;
                    }
                    replaceItem3 = replaceItem;
                }
                if (replaceItem != null) {
                    return true;
                }
                this.lastReplace.next = replaceItem2;
                return true;
            }
            replaceItem2.next = replaceItem3;
        }
        this.firstReplace = replaceItem2;
        return true;
    }

    public void startLineLoop() {
        this.lineNumber = 0;
        this.nextLineStart = 0;
        this.lineEnd = 0;
        this.lineBegin = 0;
    }

    public boolean wasModified() {
        return this.firstReplace != null;
    }

    public void writeData(Writer writer) throws IOException {
        int i = 0;
        for (ReplaceItem replaceItem = this.firstReplace; replaceItem != null; replaceItem = replaceItem.next) {
            int i2 = replaceItem.begin - i;
            if (i2 > 0) {
                writer.write(this.buffer, i, i2);
            }
            writer.write(replaceItem.replacement);
            i = replaceItem.end;
        }
        int i3 = this.bufferEnd - i;
        if (i3 != 0) {
            writer.write(this.buffer, i, i3);
        }
    }

    public void writeInitialData(Writer writer) throws IOException {
        writer.write(this.buffer, 0, this.bufferEnd);
    }
}
