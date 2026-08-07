package com.eclipsesource.json;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes13.dex */
public class PrettyPrint extends WriterConfig {
    private final char[] indentChars;

    protected PrettyPrint(char[] cArr) {
        this.indentChars = cArr;
    }

    public static PrettyPrint singleLine() {
        return new PrettyPrint(null);
    }

    public static PrettyPrint indentWithSpaces(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("number is negative");
        }
        char[] cArr = new char[i];
        Arrays.fill(cArr, ' ');
        return new PrettyPrint(cArr);
    }

    public static PrettyPrint indentWithTabs() {
        return new PrettyPrint(new char[]{'\t'});
    }

    @Override // com.eclipsesource.json.WriterConfig
    protected JsonWriter createWriter(Writer writer) {
        return new PrettyPrintWriter(writer, this.indentChars);
    }

    private static class PrettyPrintWriter extends JsonWriter {
        private int indent;
        private final char[] indentChars;

        private PrettyPrintWriter(Writer writer, char[] cArr) {
            super(writer);
            this.indentChars = cArr;
        }

        @Override // com.eclipsesource.json.JsonWriter
        protected void writeArrayOpen() throws IOException {
            this.indent++;
            this.writer.write(91);
            writeNewLine();
        }

        @Override // com.eclipsesource.json.JsonWriter
        protected void writeArrayClose() throws IOException {
            this.indent--;
            writeNewLine();
            this.writer.write(93);
        }

        @Override // com.eclipsesource.json.JsonWriter
        protected void writeArraySeparator() throws IOException {
            this.writer.write(44);
            if (writeNewLine()) {
                return;
            }
            this.writer.write(32);
        }

        @Override // com.eclipsesource.json.JsonWriter
        protected void writeObjectOpen() throws IOException {
            this.indent++;
            this.writer.write(123);
            writeNewLine();
        }

        @Override // com.eclipsesource.json.JsonWriter
        protected void writeObjectClose() throws IOException {
            this.indent--;
            writeNewLine();
            this.writer.write(125);
        }

        @Override // com.eclipsesource.json.JsonWriter
        protected void writeMemberSeparator() throws IOException {
            this.writer.write(58);
            this.writer.write(32);
        }

        @Override // com.eclipsesource.json.JsonWriter
        protected void writeObjectSeparator() throws IOException {
            this.writer.write(44);
            if (writeNewLine()) {
                return;
            }
            this.writer.write(32);
        }

        private boolean writeNewLine() throws IOException {
            if (this.indentChars == null) {
                return false;
            }
            this.writer.write(10);
            for (int i = 0; i < this.indent; i++) {
                this.writer.write(this.indentChars);
            }
            return true;
        }
    }
}
