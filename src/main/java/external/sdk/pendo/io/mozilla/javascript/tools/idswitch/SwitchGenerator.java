package external.sdk.pendo.io.mozilla.javascript.tools.idswitch;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import external.sdk.pendo.io.mozilla.javascript.EvaluatorException;
import external.sdk.pendo.io.mozilla.javascript.tools.ToolErrorReporter;

/* JADX INFO: loaded from: classes4.dex */
public class SwitchGenerator {
    private CodePrinter P;
    private ToolErrorReporter R;
    private boolean c_was_defined;
    private int[] columns;
    private String default_value;
    private IdValuePair[] pairs;
    private String source_file;
    String v_switch_label = "L0";
    String v_label = "L";
    String v_s = "s";
    String v_c = "c";
    String v_guess = "X";
    String v_id = "id";
    String v_length_suffix = "_length";
    int use_if_threshold = 3;
    int char_tail_test_threshold = 2;

    private static boolean bigger(IdValuePair idValuePair, IdValuePair idValuePair2, int i) {
        if (i >= 0) {
            return idValuePair.id.charAt(i) > idValuePair2.id.charAt(i);
        }
        int i2 = idValuePair.idLength - idValuePair2.idLength;
        if (i2 != 0) {
            return i2 > 0;
        }
        return idValuePair.id.compareTo(idValuePair2.id) > 0;
    }

    private void check_all_is_different(int i, int i2) {
        if (i == i2) {
            return;
        }
        IdValuePair idValuePair = this.pairs[i];
        while (true) {
            i++;
            if (i == i2) {
                return;
            }
            IdValuePair idValuePair2 = this.pairs[i];
            if (idValuePair.id.equals(idValuePair2.id)) {
                throw on_same_pair_fail(idValuePair, idValuePair2);
            }
            idValuePair = idValuePair2;
        }
    }

    private int count_different_chars(int i, int i2, int i3) {
        int i4 = 0;
        byte b = -1;
        while (i != i2) {
            char cCharAt = this.pairs[i].id.charAt(i3);
            if (cCharAt != b) {
                i4++;
                b = cCharAt;
            }
            i++;
        }
        return i4;
    }

    private int count_different_lengths(int i, int i2) {
        int i3 = 0;
        int i4 = -1;
        while (i != i2) {
            int i5 = this.pairs[i].idLength;
            if (i4 != i5) {
                i3++;
                i4 = i5;
            }
            i++;
        }
        return i3;
    }

    private int find_max_different_column(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 != i3; i6++) {
            int i7 = this.columns[i6];
            sort_pairs(i, i2, i7);
            int iCount_different_chars = count_different_chars(i, i2, i7);
            if (iCount_different_chars == i2 - i) {
                return i6;
            }
            if (i5 < iCount_different_chars) {
                i4 = i6;
                i5 = iCount_different_chars;
            }
        }
        if (i4 != i3 - 1) {
            sort_pairs(i, i2, this.columns[i4]);
        }
        return i4;
    }

    private void generate_body(int i, int i2, int i3) {
        this.P.indent(i3);
        this.P.p(this.v_switch_label);
        this.P.p(": { ");
        this.P.p(this.v_id);
        this.P.p(" = ");
        this.P.p(this.default_value);
        this.P.p("; String ");
        this.P.p(this.v_guess);
        this.P.p(" = null;");
        this.c_was_defined = false;
        int offset = this.P.getOffset();
        this.P.p(" int ");
        this.P.p(this.v_c);
        this.P.p(';');
        int offset2 = this.P.getOffset();
        this.P.nl();
        int i4 = i3 + 1;
        generate_length_switch(i, i2, i4);
        if (!this.c_was_defined) {
            this.P.erase(offset, offset2);
        }
        this.P.indent(i4);
        this.P.p("if (");
        this.P.p(this.v_guess);
        this.P.p("!=null && ");
        this.P.p(this.v_guess);
        this.P.p("!=");
        this.P.p(this.v_s);
        this.P.p(" && !");
        this.P.p(this.v_guess);
        this.P.p(".equals(");
        this.P.p(this.v_s);
        this.P.p(")) ");
        this.P.p(this.v_id);
        this.P.p(" = ");
        this.P.p(this.default_value);
        this.P.p(AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER);
        this.P.nl();
        this.P.indent(i4);
        this.P.p("break ");
        this.P.p(this.v_switch_label);
        this.P.p(AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER);
        this.P.nl();
        this.P.line(i3, "}");
    }

    private void generate_length_switch(int i, int i2, int i3) {
        boolean z;
        int i4;
        CodePrinter codePrinter;
        String str;
        SwitchGenerator switchGenerator;
        String str2;
        sort_pairs(i, i2, -1);
        check_all_is_different(i, i2);
        int iCount_different_lengths = count_different_lengths(i, i2);
        this.columns = new int[this.pairs[i2 - 1].idLength];
        int i5 = 0;
        if (iCount_different_lengths <= this.use_if_threshold) {
            if (iCount_different_lengths != 1) {
                this.P.indent(i3);
                this.P.p("int ");
                this.P.p(this.v_s);
                this.P.p(this.v_length_suffix);
                this.P.p(" = ");
                this.P.p(this.v_s);
                this.P.p(".length();");
                this.P.nl();
            }
            z = true;
        } else {
            this.P.indent(i3);
            this.P.p(this.v_label);
            this.P.p(": switch (");
            this.P.p(this.v_s);
            this.P.p(".length()) {");
            this.P.nl();
            z = false;
        }
        int i6 = this.pairs[i].idLength;
        int i7 = i;
        while (true) {
            int i8 = i7;
            while (true) {
                i4 = i7 + 1;
                if (i4 == i2 || (i5 = this.pairs[i4].idLength) != i6) {
                    break;
                } else {
                    i7 = i4;
                }
            }
            this.P.indent(i3);
            if (z) {
                if (i8 != i) {
                    this.P.p("else ");
                }
                this.P.p("if (");
                this.P.p(this.v_s);
                CodePrinter codePrinter2 = this.P;
                if (iCount_different_lengths == 1) {
                    str2 = ".length()==";
                } else {
                    codePrinter2.p(this.v_length_suffix);
                    codePrinter2 = this.P;
                    str2 = "==";
                }
                codePrinter2.p(str2);
                this.P.p(i6);
                codePrinter = this.P;
                str = ") {";
            } else {
                this.P.p("case ");
                this.P.p(i6);
                codePrinter = this.P;
                str = ":";
            }
            codePrinter.p(str);
            switchGenerator = this;
            switchGenerator.generate_letter_switch(i8, i4, i3 + 1, !z, z);
            CodePrinter codePrinter3 = switchGenerator.P;
            if (z) {
                codePrinter3.p("}");
            } else {
                codePrinter3.p("break ");
                switchGenerator.P.p(switchGenerator.v_label);
                switchGenerator.P.p(AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER);
            }
            switchGenerator.P.nl();
            if (i4 == i2) {
                break;
            }
            i6 = i5;
            this = switchGenerator;
            i7 = i4;
        }
        if (z) {
            return;
        }
        switchGenerator.P.indent(i3);
        switchGenerator.P.p("}");
        switchGenerator.P.nl();
    }

    private void generate_letter_switch(int i, int i2, int i3, boolean z, boolean z2) {
        int i4 = this.pairs[i].idLength;
        for (int i5 = 0; i5 != i4; i5++) {
            this.columns[i5] = i5;
        }
        generate_letter_switch_r(i, i2, i4, i3, z, z2);
    }

    private boolean generate_letter_switch_r(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        int i5;
        boolean z6 = false;
        int i6 = 1;
        if (i + 1 == i2) {
            this.P.p(' ');
            IdValuePair idValuePair = this.pairs[i];
            if (i3 > this.char_tail_test_threshold) {
                this.P.p(this.v_guess);
                this.P.p(SimpleComparison.EQUAL_TO_OPERATION);
                this.P.qstring(idValuePair.id);
                this.P.p(AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER);
                this.P.p(this.v_id);
                this.P.p(SimpleComparison.EQUAL_TO_OPERATION);
                this.P.p(idValuePair.value);
                this.P.p(AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER);
            } else if (i3 == 0) {
                this.P.p(this.v_id);
                this.P.p(SimpleComparison.EQUAL_TO_OPERATION);
                this.P.p(idValuePair.value);
                this.P.p("; break ");
                this.P.p(this.v_switch_label);
                this.P.p(AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER);
                z6 = true;
            } else {
                this.P.p("if (");
                int i7 = this.columns[0];
                this.P.p(this.v_s);
                this.P.p(".charAt(");
                this.P.p(i7);
                this.P.p(")==");
                this.P.qchar(idValuePair.id.charAt(i7));
                while (i6 != i3) {
                    this.P.p(" && ");
                    int i8 = this.columns[i6];
                    this.P.p(this.v_s);
                    this.P.p(".charAt(");
                    this.P.p(i8);
                    this.P.p(")==");
                    this.P.qchar(idValuePair.id.charAt(i8));
                    i6++;
                }
                this.P.p(") {");
                this.P.p(this.v_id);
                this.P.p(SimpleComparison.EQUAL_TO_OPERATION);
                this.P.p(idValuePair.value);
                this.P.p("; break ");
                this.P.p(this.v_switch_label);
                this.P.p(";}");
            }
            this.P.p(' ');
            return z6;
        }
        int iFind_max_different_column = find_max_different_column(i, i2, i3);
        int i9 = this.columns[iFind_max_different_column];
        int iCount_different_chars = count_different_chars(i, i2, i9);
        int[] iArr = this.columns;
        int i10 = i3 - 1;
        iArr[iFind_max_different_column] = iArr[i10];
        CodePrinter codePrinter = this.P;
        if (z2) {
            codePrinter.nl();
            this.P.indent(i4);
        } else {
            codePrinter.p(' ');
        }
        if (iCount_different_chars <= this.use_if_threshold) {
            this.c_was_defined = true;
            this.P.p(this.v_c);
            this.P.p(SimpleComparison.EQUAL_TO_OPERATION);
            this.P.p(this.v_s);
            this.P.p(".charAt(");
            this.P.p(i9);
            this.P.p(");");
            z4 = z;
            z5 = true;
        } else {
            if (z) {
                z3 = z;
            } else {
                this.P.p(this.v_label);
                this.P.p(": ");
                z3 = true;
            }
            this.P.p("switch (");
            this.P.p(this.v_s);
            this.P.p(".charAt(");
            this.P.p(i9);
            this.P.p(")) {");
            z4 = z3;
            z5 = false;
        }
        char cCharAt = this.pairs[i].id.charAt(i9);
        int i11 = i10;
        int i12 = i;
        int i13 = i12;
        char c = 0;
        while (true) {
            i13 += i6;
            z6 = z6;
            if (i13 != i2) {
                char cCharAt2 = this.pairs[i13].id.charAt(i9);
                c = cCharAt2;
                if (cCharAt2 != cCharAt) {
                }
            }
            if (z5) {
                this.P.nl();
                this.P.indent(i4);
                if (i12 != i) {
                    this.P.p("else ");
                }
                this.P.p("if (");
                this.P.p(this.v_c);
                this.P.p("==");
                this.P.qchar(cCharAt);
                this.P.p(") {");
            } else {
                i6 = i6;
                this.P.nl();
                this.P.indent(i4);
                this.P.p("case ");
                this.P.qchar(cCharAt);
                this.P.p(":");
            }
            i5 = i9;
            int i14 = i11;
            boolean zGenerate_letter_switch_r = generate_letter_switch_r(i12, i13, i14, i4 + 1, z4, z5);
            i11 = i14;
            if (z5) {
                this.P.p("}");
            } else if (!zGenerate_letter_switch_r) {
                this.P.p("break ");
                this.P.p(this.v_label);
                this.P.p(AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER);
            }
            if (i13 == i2) {
                break;
            }
            i12 = i13;
            i13 = i12;
            i9 = i5;
            cCharAt = c;
            i6 = i6;
        }
        this.P.nl();
        CodePrinter codePrinter2 = this.P;
        if (!z5) {
            codePrinter2.indent(i4);
            this.P.p("}");
            CodePrinter codePrinter3 = this.P;
            if (z2) {
                codePrinter3.nl();
                codePrinter2 = this.P;
                codePrinter2.indent(i4 - 1);
            } else {
                codePrinter3.p(' ');
            }
        } else if (z2) {
            codePrinter2.indent(i4 - 1);
        } else {
            codePrinter2.indent(i4);
        }
        this.columns[iFind_max_different_column] = i5;
        return z6;
    }

    private static void heap4Sort(IdValuePair[] idValuePairArr, int i, int i2, int i3) {
        if (i2 <= 1) {
            return;
        }
        makeHeap4(idValuePairArr, i, i2, i3);
        while (i2 > 1) {
            i2--;
            int i4 = i + i2;
            IdValuePair idValuePair = idValuePairArr[i4];
            idValuePairArr[i4] = idValuePairArr[i];
            idValuePairArr[i] = idValuePair;
            heapify4(idValuePairArr, i, i2, 0, i3);
        }
    }

    private static void heapify4(IdValuePair[] idValuePairArr, int i, int i2, int i3, int i4) {
        IdValuePair idValuePair = idValuePairArr[i + i3];
        while (true) {
            int i5 = i3 << 2;
            int i6 = i5 | 1;
            int i7 = i5 | 2;
            int i8 = i5 | 3;
            int i9 = i5 + 4;
            if (i9 >= i2) {
                if (i6 < i2) {
                    IdValuePair idValuePair2 = idValuePairArr[i + i6];
                    if (i7 != i2) {
                        IdValuePair idValuePair3 = idValuePairArr[i + i7];
                        if (bigger(idValuePair3, idValuePair2, i4)) {
                            i6 = i7;
                            idValuePair2 = idValuePair3;
                        }
                        if (i8 != i2) {
                            IdValuePair idValuePair4 = idValuePairArr[i + i8];
                            if (bigger(idValuePair4, idValuePair2, i4)) {
                                idValuePair2 = idValuePair4;
                                i6 = i8;
                            }
                        }
                    }
                    if (bigger(idValuePair2, idValuePair, i4)) {
                        idValuePairArr[i3 + i] = idValuePair2;
                        idValuePairArr[i + i6] = idValuePair;
                        return;
                    }
                    return;
                }
                return;
            }
            IdValuePair idValuePair5 = idValuePairArr[i + i6];
            IdValuePair idValuePair6 = idValuePairArr[i + i7];
            IdValuePair idValuePair7 = idValuePairArr[i + i8];
            IdValuePair idValuePair8 = idValuePairArr[i + i9];
            if (bigger(idValuePair6, idValuePair5, i4)) {
                i6 = i7;
                idValuePair5 = idValuePair6;
            }
            if (bigger(idValuePair8, idValuePair7, i4)) {
                i8 = i9;
                idValuePair7 = idValuePair8;
            }
            if (bigger(idValuePair7, idValuePair5, i4)) {
                i6 = i8;
                idValuePair5 = idValuePair7;
            }
            if (bigger(idValuePair, idValuePair5, i4)) {
                return;
            }
            idValuePairArr[i3 + i] = idValuePair5;
            idValuePairArr[i + i6] = idValuePair;
            i3 = i6;
        }
    }

    private static void makeHeap4(IdValuePair[] idValuePairArr, int i, int i2, int i3) {
        int i4 = (i2 + 2) >> 2;
        while (i4 != 0) {
            i4--;
            heapify4(idValuePairArr, i, i2, i4, i3);
        }
    }

    private EvaluatorException on_same_pair_fail(IdValuePair idValuePair, IdValuePair idValuePair2) {
        int i;
        int lineNumber = idValuePair.getLineNumber();
        int lineNumber2 = idValuePair2.getLineNumber();
        if (lineNumber2 > lineNumber) {
            i = lineNumber2;
        } else {
            i = lineNumber;
            lineNumber = lineNumber2;
        }
        return this.R.runtimeError(ToolErrorReporter.getMessage("msg.idswitch.same_string", idValuePair.id, Integer.valueOf(lineNumber)), this.source_file, i, null, 0);
    }

    private void sort_pairs(int i, int i2, int i3) {
        heap4Sort(this.pairs, i, i2 - i, i3);
    }

    public void generateSwitch(IdValuePair[] idValuePairArr, String str) {
        int length = idValuePairArr.length;
        if (length == 0) {
            return;
        }
        this.pairs = idValuePairArr;
        this.default_value = str;
        generate_body(0, length, 2);
    }

    public CodePrinter getCodePrinter() {
        return this.P;
    }

    public ToolErrorReporter getReporter() {
        return this.R;
    }

    public String getSourceFileName() {
        return this.source_file;
    }

    public void setCodePrinter(CodePrinter codePrinter) {
        this.P = codePrinter;
    }

    public void setReporter(ToolErrorReporter toolErrorReporter) {
        this.R = toolErrorReporter;
    }

    public void setSourceFileName(String str) {
        this.source_file = str;
    }

    public void generateSwitch(String[] strArr, String str) {
        int length = strArr.length / 2;
        IdValuePair[] idValuePairArr = new IdValuePair[length];
        for (int i = 0; i != length; i++) {
            int i2 = i * 2;
            idValuePairArr[i] = new IdValuePair(strArr[i2], strArr[i2 + 1]);
        }
        generateSwitch(idValuePairArr, str);
    }
}
