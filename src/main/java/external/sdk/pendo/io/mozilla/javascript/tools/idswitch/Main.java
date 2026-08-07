package external.sdk.pendo.io.mozilla.javascript.tools.idswitch;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import external.sdk.pendo.io.mozilla.javascript.EvaluatorException;
import external.sdk.pendo.io.mozilla.javascript.tools.ToolErrorReporter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class Main {
    private static final int GENERATED_TAG = 2;
    private static final String GENERATED_TAG_STR = "generated";
    private static final int NORMAL_LINE = 0;
    private static final int STRING_TAG = 3;
    private static final String STRING_TAG_STR = "string";
    private static final int SWITCH_TAG = 1;
    private static final String SWITCH_TAG_STR = "string_id_map";
    private CodePrinter P;
    private ToolErrorReporter R;
    private final List<IdValuePair> all_pairs = new ArrayList();
    private FileBody body;
    private String source_file;
    private int tag_definition_end;
    private int tag_value_end;
    private int tag_value_start;

    private void add_id(char[] cArr, int i, int i2, int i3, int i4) {
        IdValuePair idValuePair = new IdValuePair(new String(cArr, i3, i4 - i3), new String(cArr, i, i2 - i));
        idValuePair.setLineNumber(this.body.getLineNumber());
        this.all_pairs.add(idValuePair);
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

    private int exec(String[] strArr) {
        this.R = new ToolErrorReporter(true, System.err);
        int iProcess_options = process_options(strArr);
        if (iProcess_options == 0) {
            option_error(ToolErrorReporter.getMessage("msg.idswitch.no_file_argument"));
            return -1;
        }
        if (iProcess_options > 1) {
            option_error(ToolErrorReporter.getMessage("msg.idswitch.too_many_arguments"));
            return -1;
        }
        CodePrinter codePrinter = new CodePrinter();
        this.P = codePrinter;
        codePrinter.setIndentStep(4);
        this.P.setIndentTabSize(0);
        try {
            process_file(strArr[0]);
            return 0;
        } catch (EvaluatorException unused) {
            return -1;
        } catch (IOException e) {
            print_error(ToolErrorReporter.getMessage("msg.idswitch.io_error", e.toString()));
            return -1;
        }
    }

    private int extract_line_tag_id(char[] cArr, int i, int i2) {
        boolean z;
        int iSkip_white_space;
        char c;
        char c2;
        int iSkip_white_space2 = skip_white_space(cArr, i, i2);
        int iLook_for_slash_slash = look_for_slash_slash(cArr, iSkip_white_space2, i2);
        if (iLook_for_slash_slash != i2) {
            boolean z2 = iSkip_white_space2 + 2 == iLook_for_slash_slash;
            int iSkip_white_space3 = skip_white_space(cArr, iLook_for_slash_slash, i2);
            if (iSkip_white_space3 != i2 && cArr[iSkip_white_space3] == '#') {
                int i3 = iSkip_white_space3 + 1;
                if (i3 == i2 || cArr[i3] != '/') {
                    z = false;
                } else {
                    i3 = iSkip_white_space3 + 2;
                    z = true;
                }
                int i4 = i3;
                while (i4 != i2 && (c2 = cArr[i4]) != '#' && c2 != '=' && !is_white_space(c2)) {
                    i4++;
                }
                if (i4 != i2 && (iSkip_white_space = skip_white_space(cArr, i4, i2)) != i2 && ((c = cArr[iSkip_white_space]) == '=' || c == '#')) {
                    int iExtract_tag_value = get_tag_id(cArr, i3, i4, z2);
                    if (iExtract_tag_value == 0) {
                        return iExtract_tag_value;
                    }
                    String str = null;
                    if (c == '#') {
                        if (z) {
                            iExtract_tag_value = -iExtract_tag_value;
                            if (is_value_type(iExtract_tag_value)) {
                                str = "msg.idswitch.no_end_usage";
                            }
                        }
                        this.tag_definition_end = iSkip_white_space + 1;
                    } else {
                        if (z) {
                            str = "msg.idswitch.no_end_with_value";
                        } else if (!is_value_type(iExtract_tag_value)) {
                            str = "msg.idswitch.no_value_allowed";
                        }
                        iExtract_tag_value = extract_tag_value(cArr, iSkip_white_space + 1, i2, iExtract_tag_value);
                    }
                    if (str == null) {
                        return iExtract_tag_value;
                    }
                    throw this.R.runtimeError(ToolErrorReporter.getMessage(str, tag_name(iExtract_tag_value)), this.source_file, this.body.getLineNumber(), null, 0);
                }
            }
        }
        return 0;
    }

    private int extract_tag_value(char[] cArr, int i, int i2, int i3) {
        int i4;
        int iSkip_white_space = skip_white_space(cArr, i, i2);
        if (iSkip_white_space == i2) {
            return 0;
        }
        int i5 = iSkip_white_space;
        while (true) {
            if (i5 == i2) {
                i4 = iSkip_white_space;
                break;
            }
            char c = cArr[i5];
            if (is_white_space(c)) {
                int iSkip_white_space2 = skip_white_space(cArr, i5 + 1, i2);
                if (iSkip_white_space2 != i2 && cArr[iSkip_white_space2] == '#') {
                    i4 = i5;
                    i5 = iSkip_white_space2;
                    break;
                }
                i5 = iSkip_white_space2 + 1;
            } else {
                if (c == '#') {
                    i4 = i5;
                    break;
                }
                i5++;
            }
        }
        if (i5 == i2) {
            return 0;
        }
        this.tag_value_start = iSkip_white_space;
        this.tag_value_end = i4;
        this.tag_definition_end = i5 + 1;
        return i3;
    }

    private void generate_java_code() {
        this.P.clear();
        IdValuePair[] idValuePairArr = new IdValuePair[this.all_pairs.size()];
        this.all_pairs.toArray(idValuePairArr);
        SwitchGenerator switchGenerator = new SwitchGenerator();
        switchGenerator.char_tail_test_threshold = 2;
        switchGenerator.setReporter(this.R);
        switchGenerator.setCodePrinter(this.P);
        switchGenerator.generateSwitch(idValuePairArr, "0");
    }

    private int get_tag_id(char[] cArr, int i, int i2, boolean z) {
        if (z) {
            if (equals(SWITCH_TAG_STR, cArr, i, i2)) {
                return 1;
            }
            if (equals(GENERATED_TAG_STR, cArr, i, i2)) {
                return 2;
            }
        }
        return equals("string", cArr, i, i2) ? 3 : 0;
    }

    private String get_time_stamp() {
        return new SimpleDateFormat(" 'Last update:' yyyy-MM-dd HH:mm:ss z").format(new Date());
    }

    private static boolean is_value_type(int i) {
        return i == 3;
    }

    private static boolean is_white_space(int i) {
        return i == 32 || i == 9;
    }

    private void look_for_id_definitions(char[] cArr, int i, int i2, boolean z) {
        int iSkip_name_char;
        int iSkip_white_space;
        int i3;
        int iSkip_white_space2 = skip_white_space(cArr, i, i2);
        int iSkip_matched_prefix = skip_matched_prefix("Id_", cArr, iSkip_white_space2, i2);
        if (iSkip_matched_prefix < 0 || iSkip_matched_prefix == (iSkip_name_char = skip_name_char(cArr, iSkip_matched_prefix, i2)) || (iSkip_white_space = skip_white_space(cArr, iSkip_name_char, i2)) == i2 || cArr[iSkip_white_space] != '=') {
            return;
        }
        if (z) {
            iSkip_matched_prefix = this.tag_value_start;
            i3 = this.tag_value_end;
        } else {
            i3 = iSkip_name_char;
        }
        add_id(cArr, iSkip_white_space2, iSkip_name_char, iSkip_matched_prefix, i3);
    }

    private int look_for_slash_slash(char[] cArr, int i, int i2) {
        while (i + 2 <= i2) {
            int i3 = i + 1;
            if (cArr[i] == '/') {
                i += 2;
                if (cArr[i3] == '/') {
                    return i;
                }
            } else {
                i = i3;
            }
        }
        return i2;
    }

    public static void main(String[] strArr) {
        System.exit(new Main().exec(strArr));
    }

    private void option_error(String str) {
        print_error(ToolErrorReporter.getMessage("msg.idswitch.bad_invocation", str));
    }

    private void print_error(String str) {
        System.err.println(str);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0092 A[PHI: r3 r4 r5
      0x0092: PHI (r3v4 int) = (r3v1 int), (r3v5 int), (r3v1 int), (r3v1 int), (r3v1 int), (r3v1 int) binds: [B:39:0x008f, B:38:0x008d, B:23:0x004d, B:20:0x0046, B:9:0x0030, B:12:0x0036] A[DONT_GENERATE, DONT_INLINE]
      0x0092: PHI (r4v4 int) = (r4v1 int), (r4v5 int), (r4v1 int), (r4v1 int), (r4v1 int), (r4v1 int) binds: [B:39:0x008f, B:38:0x008d, B:23:0x004d, B:20:0x0046, B:9:0x0030, B:12:0x0036] A[DONT_GENERATE, DONT_INLINE]
      0x0092: PHI (r5v3 int) = (r5v1 int), (r5v4 int), (r5v1 int), (r5v1 int), (r5v1 int), (r5v1 int) binds: [B:39:0x008f, B:38:0x008d, B:23:0x004d, B:20:0x0046, B:9:0x0030, B:12:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    private void process_file() {
        char[] buffer = this.body.getBuffer();
        this.body.startLineLoop();
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        while (this.body.nextLine()) {
            int lineBegin = this.body.getLineBegin();
            int lineEnd = this.body.getLineEnd();
            int iExtract_line_tag_id = extract_line_tag_id(buffer, lineBegin, lineEnd);
            boolean z = true;
            if (i != 0) {
                if (i == 1) {
                    if (iExtract_line_tag_id == 0) {
                        look_for_id_definitions(buffer, lineBegin, lineEnd, false);
                    } else if (iExtract_line_tag_id == 3) {
                        look_for_id_definitions(buffer, lineBegin, lineEnd, true);
                    } else if (iExtract_line_tag_id == 2) {
                        if (i2 < 0) {
                            i4 = this.tag_definition_end;
                            z = false;
                            i5 = lineEnd;
                            i = 2;
                        }
                    } else if (iExtract_line_tag_id == -1) {
                        if (i2 >= 0 && !this.all_pairs.isEmpty()) {
                            generate_java_code();
                            if (this.body.setReplacement(i2, i3, this.P.toString())) {
                                this.body.setReplacement(i4, i5, get_time_stamp());
                            }
                        }
                        i = 0;
                        z = false;
                    }
                    z = false;
                } else if (i != 2) {
                    z = false;
                } else if (iExtract_line_tag_id == 0) {
                    if (i2 < 0) {
                        z = false;
                        i2 = lineBegin;
                    } else {
                        z = false;
                    }
                } else if (iExtract_line_tag_id == -2) {
                    if (i2 < 0) {
                        i2 = lineBegin;
                    }
                    i3 = lineBegin;
                    i = 1;
                    z = false;
                }
            } else if (iExtract_line_tag_id == 1) {
                this.all_pairs.clear();
                i2 = -1;
                i = 1;
                z = false;
            } else if (iExtract_line_tag_id != -1) {
                z = false;
            }
            if (z) {
                throw this.R.runtimeError(ToolErrorReporter.getMessage("msg.idswitch.bad_tag_order", tag_name(iExtract_line_tag_id)), this.source_file, this.body.getLineNumber(), null, 0);
            }
        }
        if (i == 0) {
            return;
        }
        throw this.R.runtimeError(ToolErrorReporter.getMessage("msg.idswitch.file_end_in_switch", tag_name(i)), this.source_file, this.body.getLineNumber(), null, 0);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0066 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x0068  */
    /* JADX WARN: Code duplicated, block: B:34:0x006e  */
    /* JADX WARN: Code duplicated, block: B:35:0x0072 A[PHI: r11
      0x0072: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:30:0x0064, B:33:0x006c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:37:0x0075  */
    private int process_options(String[] strArr) {
        int i;
        String message;
        int length = strArr.length;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        while (true) {
            if (i3 != length) {
                String str = strArr[i3];
                int length2 = str.length();
                if (length2 >= 2 && str.charAt(0) == '-') {
                    i = -1;
                    if (str.charAt(1) != '-') {
                        int i4 = 1;
                        while (true) {
                            if (i4 == length2) {
                                strArr[i3] = null;
                            } else {
                                char cCharAt = str.charAt(i4);
                                if (cCharAt != 'h') {
                                    message = ToolErrorReporter.getMessage("msg.idswitch.bad_option_char", String.valueOf(cCharAt));
                                    option_error(message);
                                    if (i != 1) {
                                        i2 = i;
                                    } else {
                                        if (z) {
                                            show_usage();
                                            i = 0;
                                        }
                                        if (z2) {
                                            show_version();
                                        } else {
                                            i2 = i;
                                        }
                                    }
                                    if (i2 != 1) {
                                        System.exit(i2);
                                    }
                                    return remove_nulls(strArr);
                                }
                                i4++;
                                z = true;
                            }
                        }
                    } else if (length2 == 2) {
                        strArr[i3] = null;
                    } else {
                        if (str.equals("--help")) {
                            z = true;
                        } else {
                            if (!str.equals("--version")) {
                                message = ToolErrorReporter.getMessage("msg.idswitch.bad_option", str);
                                option_error(message);
                                if (i != 1) {
                                    i2 = i;
                                } else {
                                    if (z) {
                                        show_usage();
                                        i = 0;
                                    }
                                    if (z2) {
                                        show_version();
                                    } else {
                                        i2 = i;
                                    }
                                }
                                if (i2 != 1) {
                                    System.exit(i2);
                                }
                                return remove_nulls(strArr);
                            }
                            z2 = true;
                        }
                        strArr[i3] = null;
                    }
                }
                i3++;
            }
            i = 1;
            if (i != 1) {
                i2 = i;
            } else {
                if (z) {
                    show_usage();
                    i = 0;
                }
                if (z2) {
                    show_version();
                } else {
                    i2 = i;
                }
            }
            if (i2 != 1) {
                System.exit(i2);
            }
            return remove_nulls(strArr);
        }
    }

    private int remove_nulls(String[] strArr) {
        int length = strArr.length;
        int i = 0;
        while (i != length && strArr[i] != null) {
            i++;
        }
        if (i != length) {
            for (int i2 = i + 1; i2 != length; i2++) {
                String str = strArr[i2];
                if (str != null) {
                    strArr[i] = str;
                    i++;
                }
            }
        }
        return i;
    }

    private void show_usage() {
        System.out.println(ToolErrorReporter.getMessage("msg.idswitch.usage"));
        System.out.println();
    }

    private void show_version() {
        System.out.println(ToolErrorReporter.getMessage("msg.idswitch.version"));
    }

    private static int skip_matched_prefix(String str, char[] cArr, int i, int i2) {
        int length = str.length();
        if (length > i2 - i) {
            return -1;
        }
        int i3 = 0;
        while (i3 != length) {
            if (str.charAt(i3) != cArr[i]) {
                return -1;
            }
            i3++;
            i++;
        }
        return i;
    }

    private static int skip_name_char(char[] cArr, int i, int i2) {
        while (i != i2) {
            char c = cArr[i];
            if (('a' > c || c > 'z') && (('A' > c || c > 'Z') && (('0' > c || c > '9') && c != '_'))) {
                break;
            }
            i++;
        }
        return i;
    }

    private static int skip_white_space(char[] cArr, int i, int i2) {
        while (i != i2 && is_white_space(cArr[i])) {
            i++;
        }
        return i;
    }

    private static String tag_name(int i) {
        if (i == -2) {
            return "/generated";
        }
        if (i == -1) {
            return "/string_id_map";
        }
        if (i != 1) {
            return i != 2 ? "" : GENERATED_TAG_STR;
        }
        return SWITCH_TAG_STR;
    }

    void process_file(String str) throws IOException {
        this.source_file = str;
        this.body = new FileBody();
        InputStream fileInputStream = str.equals(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR) ? System.in : new FileInputStream(str);
        try {
            this.body.readData(new InputStreamReader(fileInputStream, "ASCII"));
            fileInputStream.close();
            process_file();
            if (this.body.wasModified()) {
                OutputStream fileOutputStream = str.equals(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR) ? System.out : new FileOutputStream(str);
                try {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    this.body.writeData(outputStreamWriter);
                    outputStreamWriter.flush();
                } finally {
                    fileOutputStream.close();
                }
            }
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }
}
