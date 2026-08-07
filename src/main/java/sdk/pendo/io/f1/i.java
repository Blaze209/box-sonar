package sdk.pendo.io.f1;

import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import com.j256.ormlite.stmt.query.SimpleComparison;
import org.apache.commons.codec.language.bm.Rule;

/* JADX INFO: loaded from: classes4.dex */
public enum i {
    GTE(SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION),
    LTE(SimpleComparison.LESS_THAN_EQUAL_TO_OPERATION),
    EQ("=="),
    TSEQ("==="),
    NE("!="),
    TSNE("!=="),
    LT(SimpleComparison.LESS_THAN_OPERATION),
    GT(SimpleComparison.GREATER_THAN_OPERATION),
    REGEX("=~"),
    NIN("NIN"),
    IN("IN"),
    CONTAINS("CONTAINS"),
    ALL(Rule.ALL),
    SIZE("SIZE"),
    EXISTS("EXISTS"),
    TYPE(CredentialProviderBaseController.TYPE_TAG),
    MATCHES("MATCHES"),
    EMPTY("EMPTY"),
    SUBSETOF("SUBSETOF"),
    ANYOF("ANYOF"),
    NONEOF("NONEOF");

    private final String operatorString;

    i(String str) {
        this.operatorString = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.operatorString;
    }

    public static i a(String str) {
        for (i iVar : values()) {
            if (iVar.operatorString.equals(str.toUpperCase())) {
                return iVar;
            }
        }
        throw new sdk.pendo.io.d1.f("Filter operator " + str + " is not supported!");
    }
}
