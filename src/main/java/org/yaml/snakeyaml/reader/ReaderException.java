package org.yaml.snakeyaml.reader;

import org.yaml.snakeyaml.error.YAMLException;

/* JADX INFO: loaded from: classes5.dex */
public class ReaderException extends YAMLException {
    private static final long serialVersionUID = 8710781187529689083L;
    private final int codePoint;
    private final String name;
    private final int position;

    public ReaderException(String str, int i, int i2, String str2) {
        super(str2);
        this.name = str;
        this.codePoint = i2;
        this.position = i;
    }

    public String getName() {
        return this.name;
    }

    public int getCodePoint() {
        return this.codePoint;
    }

    public int getPosition() {
        return this.position;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "unacceptable code point '" + new String(Character.toChars(this.codePoint)) + "' (0x" + Integer.toHexString(this.codePoint).toUpperCase() + ") " + getMessage() + "\nin \"" + this.name + "\", position " + this.position;
    }
}
