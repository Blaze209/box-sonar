package external.sdk.pendo.io.mozilla.javascript.tools.debugger;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Segment;

/* JADX INFO: loaded from: classes4.dex */
class EvalTextArea extends JTextArea implements KeyListener, DocumentListener {
    private static final long serialVersionUID = -3918033649601064194L;
    private SwingGui debugGui;
    private int outputMark;
    private int historyIndex = -1;
    private List<String> history = Collections.synchronizedList(new ArrayList());

    public EvalTextArea(SwingGui swingGui) {
        this.debugGui = swingGui;
        Document document = getDocument();
        document.addDocumentListener(this);
        addKeyListener(this);
        setLineWrap(true);
        setFont(new Font("Monospaced", 0, Math.max(12, UIManager.getFont("Label.font").getSize())));
        append("% ");
        this.outputMark = document.getLength();
    }

    private synchronized void returnPressed() {
        Document document = getDocument();
        int length = document.getLength();
        Segment segment = new Segment();
        try {
            int i = this.outputMark;
            document.getText(i, length - i, segment);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        String string = segment.toString();
        if (this.debugGui.dim.stringIsCompilableUnit(string)) {
            if (string.trim().length() > 0) {
                this.history.add(string);
                this.historyIndex = this.history.size();
            }
            append("\n");
            String strEval = this.debugGui.dim.eval(string);
            if (strEval.length() > 0) {
                append(strEval);
                append("\n");
            }
            append("% ");
            this.outputMark = document.getLength();
        } else {
            append("\n");
        }
    }

    public synchronized void changedUpdate(DocumentEvent documentEvent) {
    }

    public synchronized void insertUpdate(DocumentEvent documentEvent) {
        int length = documentEvent.getLength();
        int offset = documentEvent.getOffset();
        int i = this.outputMark;
        if (i > offset) {
            this.outputMark = i + length;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0085 A[PHI: r0
      0x0085: PHI (r0v11 int) = (r0v10 int), (r0v13 int) binds: [B:27:0x004d, B:32:0x0063] A[DONT_GENERATE, DONT_INLINE]] */
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 8 || keyCode == 37) {
            if (this.outputMark != getCaretPosition()) {
                return;
            }
        } else {
            if (keyCode != 36) {
                if (keyCode == 10) {
                    returnPressed();
                } else if (keyCode == 38) {
                    int i = this.historyIndex - 1;
                    this.historyIndex = i;
                    if (i < 0) {
                        this.historyIndex = i + 1;
                    } else {
                        if (i >= this.history.size()) {
                            this.historyIndex = this.history.size() - 1;
                        }
                        i = this.historyIndex;
                        if (i >= 0) {
                            String str = this.history.get(i);
                            replaceRange(str, this.outputMark, getDocument().getLength());
                            int length = this.outputMark + str.length();
                            select(length, length);
                        } else {
                            this.historyIndex = i + 1;
                        }
                    }
                } else {
                    if (keyCode != 40) {
                        return;
                    }
                    int length2 = this.outputMark;
                    if (this.history.size() > 0) {
                        int i2 = this.historyIndex + 1;
                        this.historyIndex = i2;
                        if (i2 < 0) {
                            this.historyIndex = 0;
                        }
                        int length3 = getDocument().getLength();
                        if (this.historyIndex < this.history.size()) {
                            String str2 = this.history.get(this.historyIndex);
                            replaceRange(str2, this.outputMark, length3);
                            length2 = str2.length() + this.outputMark;
                        } else {
                            this.historyIndex = this.history.size();
                            replaceRange("", this.outputMark, length3);
                        }
                    }
                    select(length2, length2);
                }
                keyEvent.consume();
                return;
            }
            int caretPosition = getCaretPosition();
            int i3 = this.outputMark;
            if (caretPosition != i3) {
                if (caretPosition <= i3 || keyEvent.isControlDown()) {
                    return;
                }
                if (keyEvent.isShiftDown()) {
                    moveCaretPosition(this.outputMark);
                } else {
                    setCaretPosition(this.outputMark);
                }
            }
        }
        keyEvent.consume();
    }

    public synchronized void keyReleased(KeyEvent keyEvent) {
    }

    public void keyTyped(KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() == '\b') {
            if (this.outputMark == getCaretPosition()) {
                keyEvent.consume();
            }
        } else {
            int caretPosition = getCaretPosition();
            int i = this.outputMark;
            if (caretPosition < i) {
                setCaretPosition(i);
            }
        }
    }

    public synchronized void postUpdateUI() {
        setCaret(getCaret());
        int i = this.outputMark;
        select(i, i);
    }

    public synchronized void removeUpdate(DocumentEvent documentEvent) {
        int length = documentEvent.getLength();
        int offset = documentEvent.getOffset();
        int i = this.outputMark;
        if (i > offset) {
            if (i >= offset + length) {
                this.outputMark = i - length;
            } else {
                this.outputMark = offset;
            }
        }
    }

    public void select(int i, int i2) {
        super.select(i, i2);
    }

    public synchronized void write(String str) {
        insert(str, this.outputMark);
        int length = this.outputMark + str.length();
        this.outputMark = length;
        select(length, length);
    }
}
