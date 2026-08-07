package org.tinylog.configuration;

import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import org.tinylog.Level;
import org.tinylog.provider.InternalLogger;

/* JADX INFO: loaded from: classes5.dex */
final class InitialContextWrapper {
    private InitialContextWrapper() {
    }

    static String resolve(String str) {
        try {
            Object objDoLookup = InitialContext.doLookup(str);
            if (objDoLookup == null) {
                return null;
            }
            return objDoLookup.toString();
        } catch (NameNotFoundException unused) {
            return null;
        } catch (NamingException e) {
            InternalLogger.log(Level.ERROR, e, "Failed to look up \"" + str + "\"");
            return null;
        }
    }
}
