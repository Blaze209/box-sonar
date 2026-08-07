package external.sdk.pendo.io.mozilla.javascript;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.capture.documentscanning.logic.TextRecognitionConverter;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import java.io.IOException;
import java.io.Reader;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
class TokenStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final char BYTE_ORDER_MARK = 65279;
    private static final int EOF_CHAR = -1;
    Token.CommentType commentType;
    int cursor;
    private boolean dirtyLine;
    private boolean isBinary;
    private boolean isHex;
    private boolean isOctal;
    private boolean isOldOctal;
    int lineno;
    private double number;
    private Parser parser;
    private int quoteChar;
    String regExpFlags;
    private char[] sourceBuffer;
    int sourceCursor;
    private int sourceEnd;
    private Reader sourceReader;
    private String sourceString;
    private int stringBufferTop;
    int tokenBeg;
    int tokenEnd;
    private int ungetCursor;
    private boolean xmlIsAttribute;
    private boolean xmlIsTagContent;
    private int xmlOpenTagsCount;
    private String string = "";
    private char[] stringBuffer = new char[128];
    private ObjToIntMap allStrings = new ObjToIntMap(50);
    private final int[] ungetBuffer = new int[3];
    private boolean hitEOF = false;
    private int lineStart = 0;
    private int lineEndChar = -1;
    private String commentPrefix = "";
    private int commentCursor = -1;

    TokenStream(Parser parser, Reader reader, String str, int i) {
        this.parser = parser;
        this.lineno = i;
        if (reader != null) {
            if (str != null) {
                Kit.codeBug();
            }
            this.sourceReader = reader;
            this.sourceBuffer = new char[512];
            this.sourceEnd = 0;
        } else {
            if (str == null) {
                Kit.codeBug();
            }
            this.sourceString = str;
            this.sourceEnd = str.length();
        }
        this.cursor = 0;
        this.sourceCursor = 0;
    }

    private void addToString(int i) {
        int i2 = this.stringBufferTop;
        char[] cArr = this.stringBuffer;
        if (i2 == cArr.length) {
            char[] cArr2 = new char[cArr.length * 2];
            System.arraycopy(cArr, 0, cArr2, 0, i2);
            this.stringBuffer = cArr2;
        }
        this.stringBuffer[i2] = (char) i;
        this.stringBufferTop = i2 + 1;
    }

    private boolean canUngetChar() {
        int i = this.ungetCursor;
        return i == 0 || this.ungetBuffer[i - 1] != 10;
    }

    private final int charAt(int i) {
        if (i < 0) {
            return -1;
        }
        String str = this.sourceString;
        if (str != null) {
            if (i >= this.sourceEnd) {
                return -1;
            }
            return str.charAt(i);
        }
        if (i >= this.sourceEnd) {
            int i2 = this.sourceCursor;
            try {
                if (!fillSourceBuffer()) {
                    return -1;
                }
                i -= i2 - this.sourceCursor;
            } catch (IOException unused) {
                return -1;
            }
        }
        return this.sourceBuffer[i];
    }

    private static String convertLastCharToHex(String str) {
        int length = str.length() - 1;
        StringBuilder sb = new StringBuilder(str.substring(0, length));
        sb.append("\\u");
        String hexString = Integer.toHexString(str.charAt(length));
        for (int i = 0; i < 4 - hexString.length(); i++) {
            sb.append('0');
        }
        sb.append(hexString);
        return sb.toString();
    }

    private boolean fillSourceBuffer() throws IOException {
        if (this.sourceString != null) {
            Kit.codeBug();
        }
        if (this.sourceEnd == this.sourceBuffer.length) {
            if (this.lineStart == 0 || isMarkingComment()) {
                char[] cArr = this.sourceBuffer;
                char[] cArr2 = new char[cArr.length * 2];
                System.arraycopy(cArr, 0, cArr2, 0, this.sourceEnd);
                this.sourceBuffer = cArr2;
            } else {
                char[] cArr3 = this.sourceBuffer;
                int i = this.lineStart;
                System.arraycopy(cArr3, i, cArr3, 0, this.sourceEnd - i);
                int i2 = this.sourceEnd;
                int i3 = this.lineStart;
                this.sourceEnd = i2 - i3;
                this.sourceCursor -= i3;
                this.lineStart = 0;
            }
        }
        Reader reader = this.sourceReader;
        char[] cArr4 = this.sourceBuffer;
        int i4 = this.sourceEnd;
        int i5 = reader.read(cArr4, i4, cArr4.length - i4);
        if (i5 < 0) {
            return false;
        }
        this.sourceEnd += i5;
        return true;
    }

    private int getChar() {
        return getChar(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
    
        if (r0 != '\r') goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006a, code lost:
    
        if (external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.isJSLineTerminator(r0) != false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int getCharIgnoreLineEnd() {
        /*
            r5 = this;
            int r0 = r5.ungetCursor
            r1 = 1
            if (r0 == 0) goto L12
            int r2 = r5.cursor
            int r2 = r2 + r1
            r5.cursor = r2
            int[] r2 = r5.ungetBuffer
            int r0 = r0 - r1
            r5.ungetCursor = r0
            r5 = r2[r0]
            return r5
        L12:
            java.lang.String r0 = r5.sourceString
            r2 = -1
            if (r0 == 0) goto L2e
            int r3 = r5.sourceCursor
            int r4 = r5.sourceEnd
            if (r3 != r4) goto L20
            r5.hitEOF = r1
            return r2
        L20:
            int r2 = r5.cursor
            int r2 = r2 + r1
            r5.cursor = r2
            int r2 = r3 + 1
            r5.sourceCursor = r2
            char r0 = r0.charAt(r3)
            goto L4c
        L2e:
            int r0 = r5.sourceCursor
            int r3 = r5.sourceEnd
            if (r0 != r3) goto L3d
            boolean r0 = r5.fillSourceBuffer()
            if (r0 != 0) goto L3d
            r5.hitEOF = r1
            return r2
        L3d:
            int r0 = r5.cursor
            int r0 = r0 + r1
            r5.cursor = r0
            char[] r0 = r5.sourceBuffer
            int r2 = r5.sourceCursor
            int r3 = r2 + 1
            r5.sourceCursor = r3
            char r0 = r0[r2]
        L4c:
            r2 = 127(0x7f, float:1.78E-43)
            r3 = 10
            if (r0 > r2) goto L59
            if (r0 == r3) goto L6c
            r1 = 13
            if (r0 != r1) goto L6f
            goto L6c
        L59:
            r2 = 65279(0xfeff, float:9.1475E-41)
            if (r0 != r2) goto L5f
            goto L6f
        L5f:
            boolean r2 = isJSFormatChar(r0)
            if (r2 == 0) goto L66
            goto L12
        L66:
            boolean r1 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.isJSLineTerminator(r0)
            if (r1 == 0) goto L6f
        L6c:
            r5.lineEndChar = r0
            return r3
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.TokenStream.getCharIgnoreLineEnd():int");
    }

    private String getStringFromBuffer() {
        this.tokenEnd = this.cursor;
        return new String(this.stringBuffer, 0, this.stringBufferTop);
    }

    private static boolean isAlpha(int i) {
        if (i <= 90) {
            return 65 <= i;
        }
        return 97 <= i && i <= 122;
    }

    static boolean isDigit(int i) {
        return 48 <= i && i <= 57;
    }

    private static boolean isJSFormatChar(int i) {
        return i > 127 && Character.getType((char) i) == 16;
    }

    static boolean isJSSpace(int i) {
        if (i <= 127) {
            return i == 32 || i == 9 || i == 12 || i == 11;
        }
        return i == 160 || i == 65279 || Character.getType((char) i) == 12;
    }

    static boolean isKeyword(String str, int i, boolean z) {
        return stringToKeyword(str, i, z) != 0;
    }

    private boolean isMarkingComment() {
        return this.commentCursor != -1;
    }

    private void markCommentStart() {
        markCommentStart("");
    }

    private boolean matchChar(int i) {
        int charIgnoreLineEnd = getCharIgnoreLineEnd();
        if (charIgnoreLineEnd == i) {
            this.tokenEnd = this.cursor;
            return true;
        }
        ungetCharIgnoreLineEnd(charIgnoreLineEnd);
        return false;
    }

    private int peekChar() {
        int i = getChar();
        ungetChar(i);
        return i;
    }

    private boolean readCDATA() {
        while (true) {
            int i = getChar();
            while (i != -1) {
                addToString(i);
                if (i == 93 && peekChar() == 93) {
                    i = getChar();
                    addToString(i);
                    if (peekChar() == 62) {
                        addToString(getChar());
                        return true;
                    }
                }
            }
            this.stringBufferTop = 0;
            this.string = null;
            this.parser.addError("msg.XML.bad.form");
            return false;
        }
    }

    private boolean readEntity() {
        int i = getChar();
        int i2 = 1;
        while (i != -1) {
            addToString(i);
            if (i == 60) {
                i2++;
            } else if (i == 62 && (i2 = i2 - 1) == 0) {
                return true;
            }
            i = getChar();
        }
        this.stringBufferTop = 0;
        this.string = null;
        this.parser.addError("msg.XML.bad.form");
        return false;
    }

    private boolean readPI() {
        while (true) {
            int i = getChar();
            if (i == -1) {
                this.stringBufferTop = 0;
                this.string = null;
                this.parser.addError("msg.XML.bad.form");
                return false;
            }
            addToString(i);
            if (i == 63 && peekChar() == 62) {
                addToString(getChar());
                return true;
            }
        }
    }

    private boolean readQuotedString(int i) {
        int i2;
        do {
            i2 = getChar();
            if (i2 == -1) {
                this.stringBufferTop = 0;
                this.string = null;
                this.parser.addError("msg.XML.bad.form");
                return false;
            }
            addToString(i2);
        } while (i2 != i);
        return true;
    }

    private boolean readXmlComment() {
        while (true) {
            int i = getChar();
            while (i != -1) {
                addToString(i);
                if (i == 45 && peekChar() == 45) {
                    i = getChar();
                    addToString(i);
                    if (peekChar() == 62) {
                        addToString(getChar());
                        return true;
                    }
                }
            }
            this.stringBufferTop = 0;
            this.string = null;
            this.parser.addError("msg.XML.bad.form");
            return false;
        }
    }

    private void skipLine() {
        int i;
        do {
            i = getChar();
            if (i == -1) {
                break;
            }
        } while (i != 10);
        ungetChar(i);
        this.tokenEnd = this.cursor;
    }

    private static int stringToKeyword(String str, int i, boolean z) {
        return i < 200 ? stringToKeywordForJS(str) : stringToKeywordForES(str, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:186:0x0277  */
    /* JADX WARN: Code duplicated, block: B:188:0x027b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:40:0x0095  */
    /* JADX WARN: Code duplicated, block: B:52:0x00bd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c4  */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01b5, code lost:
    
        if (r16.charAt(1) == 'l') goto L192;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int stringToKeywordForES(java.lang.String r16, boolean r17) {
        /*
            Method dump skipped, instruction units count: 682
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.TokenStream.stringToKeywordForES(java.lang.String, boolean):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:201:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:219:0x02ed A[PHI: r2
      0x02ed: PHI (r2v4 int) = (r2v1 int), (r2v0 int) binds: [B:218:0x02eb, B:157:0x0231] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:220:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:222:0x02f3 A[ADDED_TO_REGION] */
    private static int stringToKeywordForJS(String str) {
        String str2;
        int i;
        int i2;
        int i3 = 116;
        switch (str.length()) {
            case 2:
                i3 = 119;
                char cCharAt = str.charAt(1);
                if (cCharAt != 'f') {
                    if (cCharAt == 'n') {
                        if (str.charAt(0) == 'i') {
                            i = 52;
                        }
                        break;
                    } else if (cCharAt == 'o' && str.charAt(0) == 'd') {
                        i = i3;
                        break;
                    }
                    str2 = null;
                    i = 0;
                    if (str2 != null) {
                        i = 0;
                    }
                } else if (str.charAt(0) != 'i') {
                    str2 = null;
                    i = 0;
                    if (str2 != null && str2 != str && !str2.equals(str)) {
                        i = 0;
                    }
                } else {
                    i = 113;
                }
                break;
            case 3:
                char cCharAt2 = str.charAt(0);
                if (cCharAt2 != 'f') {
                    if (cCharAt2 != 'i') {
                        if (cCharAt2 != 'l') {
                            if (cCharAt2 != 'n') {
                                if (cCharAt2 != 't') {
                                    if (cCharAt2 == 'v' && str.charAt(2) == 'r' && str.charAt(1) == 'a') {
                                        i = 123;
                                    }
                                    break;
                                } else if (str.charAt(2) == 'y' && str.charAt(1) == 'r') {
                                    i = 82;
                                    break;
                                }
                            } else if (str.charAt(2) == 'w' && str.charAt(1) == 'e') {
                                i = 30;
                                break;
                            }
                        } else if (str.charAt(2) == 't' && str.charAt(1) == 'e') {
                            i = Token.LET;
                            break;
                        }
                    } else if (str.charAt(2) == 't' && str.charAt(1) == 'n') {
                        i = 128;
                        break;
                    }
                    str2 = null;
                    i = 0;
                    if (str2 != null) {
                        i = 0;
                    }
                } else if (str.charAt(2) == 'r' && str.charAt(1) == 'o') {
                    i = 120;
                } else {
                    str2 = null;
                    i = 0;
                    if (str2 != null) {
                        i = 0;
                    }
                }
                break;
            case 4:
                char cCharAt3 = str.charAt(0);
                if (cCharAt3 == 'b') {
                    str2 = "byte";
                } else if (cCharAt3 == 'c') {
                    char cCharAt4 = str.charAt(3);
                    if (cCharAt4 != 'e') {
                        if (cCharAt4 == 'r' && str.charAt(2) == 'a' && str.charAt(1) == 'h') {
                            i = 128;
                            break;
                        }
                    } else if (str.charAt(2) == 's' && str.charAt(1) == 'a') {
                        i = i3;
                        break;
                    }
                    str2 = null;
                    i = 0;
                    if (str2 != null) {
                        i = 0;
                    }
                } else if (cCharAt3 == 'e') {
                    char cCharAt5 = str.charAt(3);
                    if (cCharAt5 != 'e') {
                        if (cCharAt5 == 'm' && str.charAt(2) == 'u' && str.charAt(1) == 'n') {
                            i = 128;
                            break;
                        }
                    } else if (str.charAt(2) == 's' && str.charAt(1) == 'l') {
                        i = 114;
                        break;
                    }
                    str2 = null;
                    i = 0;
                    if (str2 != null) {
                        i = 0;
                    }
                } else if (cCharAt3 == 'g') {
                    str2 = "goto";
                } else if (cCharAt3 != 'l') {
                    if (cCharAt3 != 'n') {
                        if (cCharAt3 != 't') {
                            if (cCharAt3 != 'v') {
                                if (cCharAt3 == 'w') {
                                    str2 = "with";
                                    i2 = 124;
                                }
                                if (str2 != null) {
                                    i = 0;
                                }
                            } else {
                                str2 = "void";
                                i2 = 127;
                            }
                            break;
                        } else {
                            char cCharAt6 = str.charAt(3);
                            if (cCharAt6 != 'e') {
                                if (cCharAt6 == 's' && str.charAt(2) == 'i' && str.charAt(1) == 'h') {
                                    i = 43;
                                    break;
                                }
                            } else if (str.charAt(2) == 'u' && str.charAt(1) == 'r') {
                                i = 45;
                                break;
                            }
                        }
                        str2 = null;
                        i = 0;
                        if (str2 != null) {
                            i = 0;
                        }
                    } else {
                        str2 = AbstractJsonLexerKt.NULL;
                        i2 = 42;
                    }
                    i = i2;
                    if (str2 != null) {
                        i = 0;
                    }
                } else {
                    str2 = "long";
                }
                i2 = 128;
                i = i2;
                if (str2 != null) {
                    i = 0;
                }
                break;
            case 5:
                char cCharAt7 = str.charAt(2);
                if (cCharAt7 != 'a') {
                    if (cCharAt7 != 'e') {
                        if (cCharAt7 == 'i') {
                            str2 = "while";
                            i2 = 118;
                        } else if (cCharAt7 == 'l') {
                            str2 = "false";
                            i2 = 44;
                        } else if (cCharAt7 == 'r') {
                            str2 = "throw";
                            i2 = 50;
                        } else if (cCharAt7 != 't') {
                            switch (cCharAt7) {
                                case 'n':
                                    char cCharAt8 = str.charAt(0);
                                    if (cCharAt8 == 'c') {
                                        str2 = "const";
                                        i2 = Token.CONST;
                                    } else if (cCharAt8 != 'f') {
                                        str2 = null;
                                        i = 0;
                                    } else {
                                        str2 = "final";
                                    }
                                    break;
                                case 'o':
                                    char cCharAt9 = str.charAt(0);
                                    if (cCharAt9 == 'f') {
                                        str2 = TypedValues.Custom.S_FLOAT;
                                    } else if (cCharAt9 != 's') {
                                        str2 = null;
                                        i = 0;
                                    } else {
                                        str2 = "short";
                                    }
                                    break;
                                case 'p':
                                    str2 = "super";
                                    break;
                                default:
                                    str2 = null;
                                    i = 0;
                                    break;
                            }
                        } else {
                            str2 = "catch";
                            i2 = 125;
                        }
                        i = i2;
                    } else {
                        char cCharAt10 = str.charAt(0);
                        if (cCharAt10 == 'b') {
                            str2 = "break";
                            i2 = 121;
                        } else if (cCharAt10 == 'y') {
                            str2 = "yield";
                            i2 = 73;
                        } else {
                            str2 = null;
                            i = 0;
                        }
                        i = i2;
                    }
                    if (str2 != null) {
                        i = 0;
                    }
                } else {
                    str2 = TextRecognitionConverter.Attributes.CLASS;
                }
                i2 = 128;
                i = i2;
                if (str2 != null) {
                    i = 0;
                }
                break;
            case 6:
                char cCharAt11 = str.charAt(1);
                if (cCharAt11 != 'a') {
                    if (cCharAt11 == 'e') {
                        char cCharAt12 = str.charAt(0);
                        if (cCharAt12 == 'd') {
                            str2 = "delete";
                            i2 = 31;
                        } else if (cCharAt12 == 'r') {
                            str2 = "return";
                            i2 = 4;
                        } else {
                            str2 = null;
                            i = 0;
                        }
                        i = i2;
                    } else if (cCharAt11 == 'h') {
                        str2 = "throws";
                    } else if (cCharAt11 == 'm') {
                        str2 = "import";
                    } else if (cCharAt11 == 'o') {
                        str2 = "double";
                    } else if (cCharAt11 == 't') {
                        str2 = "static";
                    } else if (cCharAt11 != 'u') {
                        switch (cCharAt11) {
                            case 'w':
                                str2 = "switch";
                                i2 = 115;
                                i = i2;
                                break;
                            case 'x':
                                str2 = "export";
                                break;
                            case 'y':
                                str2 = "typeof";
                                i2 = 32;
                                i = i2;
                                break;
                            default:
                                str2 = null;
                                i = 0;
                                break;
                        }
                    } else {
                        str2 = HeaderConstants.PUBLIC;
                    }
                    if (str2 != null) {
                        i = 0;
                    }
                } else {
                    str2 = "native";
                }
                i2 = 128;
                i = i2;
                if (str2 != null) {
                    i = 0;
                }
                break;
            case 7:
                char cCharAt13 = str.charAt(1);
                if (cCharAt13 != 'a') {
                    if (cCharAt13 == 'e') {
                        str2 = "default";
                        i2 = 117;
                    } else if (cCharAt13 == 'i') {
                        str2 = "finally";
                        i2 = 126;
                    } else if (cCharAt13 == 'o') {
                        str2 = TypedValues.Custom.S_BOOLEAN;
                    } else if (cCharAt13 != 'r') {
                        if (cCharAt13 != 'x') {
                            str2 = null;
                            i = 0;
                        } else {
                            str2 = "extends";
                        }
                        if (str2 != null) {
                            i = 0;
                        }
                    } else {
                        str2 = HeaderConstants.PRIVATE;
                    }
                    i = i2;
                    if (str2 != null) {
                        i = 0;
                    }
                } else {
                    str2 = "package";
                }
                i2 = 128;
                i = i2;
                if (str2 != null) {
                    i = 0;
                }
                break;
            case 8:
                char cCharAt14 = str.charAt(0);
                if (cCharAt14 != 'a') {
                    if (cCharAt14 == 'f') {
                        str2 = "function";
                        i2 = 110;
                    } else if (cCharAt14 == 'v') {
                        str2 = "volatile";
                    } else if (cCharAt14 != 'c') {
                        if (cCharAt14 != 'd') {
                            str2 = null;
                            i = 0;
                        } else {
                            str2 = "debugger";
                            i2 = Token.DEBUGGER;
                        }
                        if (str2 != null) {
                            i = 0;
                        }
                    } else {
                        str2 = "continue";
                        i2 = 122;
                    }
                    i = i2;
                    if (str2 != null) {
                        i = 0;
                    }
                } else {
                    str2 = "abstract";
                }
                i2 = 128;
                i = i2;
                if (str2 != null) {
                    i = 0;
                }
                break;
            case 9:
                char cCharAt15 = str.charAt(0);
                if (cCharAt15 == 'i') {
                    str2 = "interface";
                } else if (cCharAt15 != 'p') {
                    if (cCharAt15 == 't') {
                        str2 = "transient";
                    } else {
                        str2 = null;
                        i = 0;
                    }
                    if (str2 != null) {
                        i = 0;
                    }
                } else {
                    str2 = "protected";
                }
                i2 = 128;
                i = i2;
                if (str2 != null) {
                    i = 0;
                }
                break;
            case 10:
                char cCharAt16 = str.charAt(1);
                if (cCharAt16 != 'm') {
                    if (cCharAt16 == 'n') {
                        str2 = "instanceof";
                        i2 = 53;
                    } else {
                        str2 = null;
                        i = 0;
                    }
                    if (str2 != null) {
                        i = 0;
                    }
                } else {
                    str2 = "implements";
                    i2 = 128;
                }
                i = i2;
                if (str2 != null) {
                    i = 0;
                }
                break;
            case 11:
            default:
                str2 = null;
                i = 0;
                if (str2 != null) {
                    i = 0;
                }
                break;
            case 12:
                str2 = "synchronized";
                i2 = 128;
                i = i2;
                if (str2 != null) {
                    i = 0;
                }
                break;
        }
        if (i == 0) {
            return 0;
        }
        return i & 255;
    }

    private final String substring(int i, int i2) {
        String str = this.sourceString;
        if (str != null) {
            return str.substring(i, i2);
        }
        return new String(this.sourceBuffer, i, i2 - i);
    }

    private void ungetChar(int i) {
        int i2 = this.ungetCursor;
        if (i2 != 0 && this.ungetBuffer[i2 - 1] == 10) {
            Kit.codeBug();
        }
        int[] iArr = this.ungetBuffer;
        int i3 = this.ungetCursor;
        this.ungetCursor = i3 + 1;
        iArr[i3] = i;
        this.cursor--;
    }

    private void ungetCharIgnoreLineEnd(int i) {
        int[] iArr = this.ungetBuffer;
        int i2 = this.ungetCursor;
        this.ungetCursor = i2 + 1;
        iArr[i2] = i;
        this.cursor--;
    }

    final boolean eof() {
        return this.hitEOF;
    }

    final String getAndResetCurrentComment() {
        if (this.sourceString != null) {
            if (isMarkingComment()) {
                Kit.codeBug();
            }
            return this.sourceString.substring(this.tokenBeg, this.tokenEnd);
        }
        if (!isMarkingComment()) {
            Kit.codeBug();
        }
        StringBuilder sb = new StringBuilder(this.commentPrefix);
        sb.append(this.sourceBuffer, this.commentCursor, getTokenLength() - this.commentPrefix.length());
        this.commentCursor = -1;
        return sb.toString();
    }

    public Token.CommentType getCommentType() {
        return this.commentType;
    }

    public int getCursor() {
        return this.cursor;
    }

    int getFirstXMLToken() {
        this.xmlOpenTagsCount = 0;
        this.xmlIsAttribute = false;
        this.xmlIsTagContent = false;
        if (!canUngetChar()) {
            return -1;
        }
        ungetChar(60);
        return getNextXMLToken();
    }

    final String getLine() {
        int i;
        int i2 = this.sourceCursor;
        int i3 = this.lineEndChar;
        if (i3 >= 0) {
            i = i2 - 1;
            if (i3 == 10 && charAt(i2 - 2) == 13) {
                i = i2 - 2;
            }
        } else {
            int i4 = i2 - this.lineStart;
            while (true) {
                int iCharAt = charAt(this.lineStart + i4);
                if (iCharAt == -1 || ScriptRuntime.isJSLineTerminator(iCharAt)) {
                    break;
                }
                i4++;
            }
            i = this.lineStart + i4;
        }
        return substring(this.lineStart, i);
    }

    final int getLineno() {
        return this.lineno;
    }

    int getNextXMLToken() {
        int i;
        this.tokenBeg = this.cursor;
        this.stringBufferTop = 0;
        while (true) {
            int i2 = getChar();
            if (i2 == -1) {
                this.tokenEnd = this.cursor;
                break;
            }
            if (!this.xmlIsTagContent) {
                if (i2 == 60) {
                    addToString(i2);
                    int iPeekChar = peekChar();
                    if (iPeekChar == 33) {
                        addToString(getChar());
                        int iPeekChar2 = peekChar();
                        if (iPeekChar2 == 45) {
                            addToString(getChar());
                            int i3 = getChar();
                            if (i3 != 45) {
                                break;
                            }
                            addToString(i3);
                            if (!readXmlComment()) {
                                return -1;
                            }
                        } else if (iPeekChar2 == 91) {
                            addToString(getChar());
                            if (getChar() != 67 || getChar() != 68 || getChar() != 65 || getChar() != 84 || getChar() != 65 || getChar() != 91) {
                                break;
                            }
                            addToString(67);
                            addToString(68);
                            addToString(65);
                            addToString(84);
                            addToString(65);
                            addToString(91);
                            if (!readCDATA()) {
                                return -1;
                            }
                        } else if (!readEntity()) {
                            return -1;
                        }
                    } else {
                        if (iPeekChar == 47) {
                            addToString(getChar());
                            int i4 = this.xmlOpenTagsCount;
                            if (i4 == 0) {
                                break;
                            }
                            this.xmlIsTagContent = true;
                            i = i4 - 1;
                        } else if (iPeekChar != 63) {
                            this.xmlIsTagContent = true;
                            i = this.xmlOpenTagsCount + 1;
                        } else {
                            addToString(getChar());
                            if (!readPI()) {
                                return -1;
                            }
                        }
                        this.xmlOpenTagsCount = i;
                    }
                } else {
                    if (i2 == 123) {
                        ungetChar(i2);
                        this.string = getStringFromBuffer();
                        return Token.XML;
                    }
                    addToString(i2);
                }
            } else {
                if (i2 == 9 || i2 == 10 || i2 == 13 || i2 == 32) {
                    addToString(i2);
                } else if (i2 == 34 || i2 == 39) {
                    addToString(i2);
                    if (!readQuotedString(i2)) {
                        return -1;
                    }
                } else if (i2 == 47) {
                    addToString(i2);
                    if (peekChar() == 62) {
                        addToString(getChar());
                        this.xmlIsTagContent = false;
                        this.xmlOpenTagsCount--;
                    }
                } else {
                    if (i2 == 123) {
                        ungetChar(i2);
                        this.string = getStringFromBuffer();
                        return Token.XML;
                    }
                    addToString(i2);
                    if (i2 != 61) {
                        if (i2 == 62) {
                            this.xmlIsTagContent = false;
                        }
                        this.xmlIsAttribute = false;
                    } else {
                        this.xmlIsAttribute = true;
                    }
                }
                if (!this.xmlIsTagContent && this.xmlOpenTagsCount == 0) {
                    this.string = getStringFromBuffer();
                    return Token.XMLEND;
                }
            }
        }
        this.stringBufferTop = 0;
        this.string = null;
        this.parser.addError("msg.XML.bad.form");
        return -1;
    }

    final double getNumber() {
        return this.number;
    }

    final int getOffset() {
        int i = this.sourceCursor - this.lineStart;
        return this.lineEndChar >= 0 ? i - 1 : i;
    }

    final char getQuoteChar() {
        return (char) this.quoteChar;
    }

    final String getSourceString() {
        return this.sourceString;
    }

    final String getString() {
        return this.string;
    }

    /* JADX WARN: Code duplicated, block: B:133:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:136:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:489:0x01d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:490:0x01ff A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:491:0x01fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:492:0x01f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:495:0x01db A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:134:0x01f1 -> B:126:0x01d4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    final int getToken() {
        /*
            Method dump skipped, instruction units count: 1518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.TokenStream.getToken():int");
    }

    public int getTokenBeg() {
        return this.tokenBeg;
    }

    public int getTokenEnd() {
        return this.tokenEnd;
    }

    public int getTokenLength() {
        return this.tokenEnd - this.tokenBeg;
    }

    final boolean isNumberBinary() {
        return this.isBinary;
    }

    final boolean isNumberHex() {
        return this.isHex;
    }

    final boolean isNumberOctal() {
        return this.isOctal;
    }

    final boolean isNumberOldOctal() {
        return this.isOldOctal;
    }

    boolean isXMLAttribute() {
        return this.xmlIsAttribute;
    }

    String readAndClearRegExpFlags() {
        String str = this.regExpFlags;
        this.regExpFlags = null;
        return str;
    }

    void readRegExp(int i) {
        int i2;
        int i3 = this.tokenBeg;
        this.stringBufferTop = 0;
        if (i == 101) {
            addToString(61);
        } else {
            if (i != 24) {
                Kit.codeBug();
            }
            if (peekChar() == 42) {
                this.tokenEnd = this.cursor - 1;
                this.string = new String(this.stringBuffer, 0, this.stringBufferTop);
                this.parser.reportError("msg.unterminated.re.lit");
                return;
            }
        }
        boolean z = false;
        while (true) {
            i2 = getChar();
            if (i2 == 47 && !z) {
                int i4 = this.stringBufferTop;
                while (true) {
                    int i5 = 103;
                    if (!matchChar(103)) {
                        i5 = 105;
                        if (!matchChar(105)) {
                            i5 = 109;
                            if (!matchChar(109)) {
                                i5 = 121;
                                if (!matchChar(121)) {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }
                    addToString(i5);
                }
                this.tokenEnd = i3 + this.stringBufferTop + 2;
                if (isAlpha(peekChar())) {
                    this.parser.reportError("msg.invalid.re.flag");
                }
                this.string = new String(this.stringBuffer, 0, i4);
                this.regExpFlags = new String(this.stringBuffer, i4, this.stringBufferTop - i4);
                return;
            }
            if (i2 == 10 || i2 == -1) {
                break;
            }
            if (i2 == 92) {
                addToString(i2);
                i2 = getChar();
                if (i2 == 10 || i2 == -1) {
                    ungetChar(i2);
                    this.tokenEnd = this.cursor - 1;
                    this.string = new String(this.stringBuffer, 0, this.stringBufferTop);
                    this.parser.reportError("msg.unterminated.re.lit");
                    return;
                }
            } else if (i2 == 91) {
                z = true;
            } else if (i2 == 93) {
                z = false;
            }
            addToString(i2);
        }
        ungetChar(i2);
        this.tokenEnd = this.cursor - 1;
        this.string = new String(this.stringBuffer, 0, this.stringBufferTop);
        this.parser.reportError("msg.unterminated.re.lit");
    }

    String tokenToString(int i) {
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
    
        if (r0 != '\r') goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0083, code lost:
    
        if (external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.isJSLineTerminator(r0) != false) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int getChar(boolean r7) {
        /*
            r6 = this;
            int r0 = r6.ungetCursor
            r1 = 1
            if (r0 == 0) goto L12
            int r7 = r6.cursor
            int r7 = r7 + r1
            r6.cursor = r7
            int[] r7 = r6.ungetBuffer
            int r0 = r0 - r1
            r6.ungetCursor = r0
            r6 = r7[r0]
            return r6
        L12:
            java.lang.String r0 = r6.sourceString
            r2 = -1
            if (r0 == 0) goto L2e
            int r3 = r6.sourceCursor
            int r4 = r6.sourceEnd
            if (r3 != r4) goto L20
            r6.hitEOF = r1
            return r2
        L20:
            int r4 = r6.cursor
            int r4 = r4 + r1
            r6.cursor = r4
            int r4 = r3 + 1
            r6.sourceCursor = r4
            char r0 = r0.charAt(r3)
            goto L4c
        L2e:
            int r0 = r6.sourceCursor
            int r3 = r6.sourceEnd
            if (r0 != r3) goto L3d
            boolean r0 = r6.fillSourceBuffer()
            if (r0 != 0) goto L3d
            r6.hitEOF = r1
            return r2
        L3d:
            int r0 = r6.cursor
            int r0 = r0 + r1
            r6.cursor = r0
            char[] r0 = r6.sourceBuffer
            int r3 = r6.sourceCursor
            int r4 = r3 + 1
            r6.sourceCursor = r4
            char r0 = r0[r3]
        L4c:
            int r3 = r6.lineEndChar
            r4 = 13
            r5 = 10
            if (r3 < 0) goto L67
            if (r3 != r4) goto L5b
            if (r0 != r5) goto L5b
            r6.lineEndChar = r5
            goto L12
        L5b:
            r6.lineEndChar = r2
            int r2 = r6.sourceCursor
            int r2 = r2 - r1
            r6.lineStart = r2
            int r2 = r6.lineno
            int r2 = r2 + r1
            r6.lineno = r2
        L67:
            r2 = 127(0x7f, float:1.78E-43)
            if (r0 > r2) goto L70
            if (r0 == r5) goto L85
            if (r0 != r4) goto L88
            goto L85
        L70:
            r2 = 65279(0xfeff, float:9.1475E-41)
            if (r0 != r2) goto L76
            goto L88
        L76:
            if (r7 == 0) goto L7f
            boolean r2 = isJSFormatChar(r0)
            if (r2 == 0) goto L7f
            goto L12
        L7f:
            boolean r7 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.isJSLineTerminator(r0)
            if (r7 == 0) goto L88
        L85:
            r6.lineEndChar = r0
            return r5
        L88:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.TokenStream.getChar(boolean):int");
    }

    private void markCommentStart(String str) {
        if (!this.parser.compilerEnv.isRecordingComments() || this.sourceReader == null) {
            return;
        }
        this.commentPrefix = str;
        this.commentCursor = this.sourceCursor - 1;
    }

    final String getLine(int i, int[] iArr) {
        int i2 = (this.cursor + this.ungetCursor) - i;
        int i3 = this.sourceCursor;
        if (i2 > i3) {
            return null;
        }
        int i4 = 0;
        int i5 = 0;
        while (i2 > 0) {
            int iCharAt = charAt(i3 - 1);
            if (ScriptRuntime.isJSLineTerminator(iCharAt)) {
                if (iCharAt == 10 && charAt(i3 - 2) == 13) {
                    i2--;
                    i3--;
                }
                i4++;
                i5 = i3 - 1;
            }
            i2--;
            i3--;
        }
        int i6 = 0;
        while (true) {
            if (i3 <= 0) {
                i3 = 0;
                break;
            }
            if (ScriptRuntime.isJSLineTerminator(charAt(i3 - 1))) {
                break;
            }
            i3--;
            i6++;
        }
        iArr[0] = (this.lineno - i4) + (this.lineEndChar >= 0 ? 1 : 0);
        iArr[1] = i6;
        return i4 == 0 ? getLine() : substring(i3, i5);
    }
}
