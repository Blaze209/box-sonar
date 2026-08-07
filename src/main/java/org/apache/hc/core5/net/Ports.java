package org.apache.hc.core5.net;

import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class Ports {
    public static final int MAX_VALUE = 65535;
    public static final int MIN_VALUE = 0;
    public static final int SCHEME_DEFAULT = -1;

    public static int checkWithDefault(int i) {
        return Args.checkRange(i, -1, 65535, "Port number(Use -1 to specify the scheme default port)");
    }

    public static int check(int i) {
        return Args.checkRange(i, 0, 65535, "Port number");
    }
}
