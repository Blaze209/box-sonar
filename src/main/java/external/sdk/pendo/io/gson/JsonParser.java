package external.sdk.pendo.io.gson;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import sdk.pendo.io.a0.i;
import sdk.pendo.io.a0.j;
import sdk.pendo.io.a0.m;
import sdk.pendo.io.a0.q;
import sdk.pendo.io.c0.k;
import sdk.pendo.io.h0.b;
import sdk.pendo.io.h0.d;

/* JADX INFO: loaded from: classes4.dex */
public final class JsonParser {
    @Deprecated
    public JsonParser() {
    }

    public static i a(Reader reader) {
        try {
            sdk.pendo.io.h0.a aVar = new sdk.pendo.io.h0.a(reader);
            i iVarA = a(aVar);
            if (!iVarA.i() && aVar.t() != b.END_DOCUMENT) {
                throw new q("Did not consume the entire document.");
            }
            return iVarA;
        } catch (d e) {
            throw new q(e);
        } catch (IOException e2) {
            throw new j(e2);
        } catch (NumberFormatException e3) {
            throw new q(e3);
        }
    }

    public static i a(sdk.pendo.io.h0.a aVar) {
        boolean zJ = aVar.j();
        aVar.c(true);
        try {
            try {
                i iVarA = k.a(aVar);
                aVar.c(zJ);
                return iVarA;
            } catch (OutOfMemoryError e) {
                throw new m("Failed parsing JSON source: " + aVar + " to Json", e);
            } catch (StackOverflowError e2) {
                throw new m("Failed parsing JSON source: " + aVar + " to Json", e2);
            }
        } catch (Throwable th) {
            aVar.c(zJ);
            throw th;
        }
    }

    public static i a(String str) {
        return a(new StringReader(str));
    }
}
