package com.google.api.client.http;

import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Types;
import com.google.api.client.util.escape.CharEscapers;
import com.google.common.base.Splitter;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.pspdfkit.contentediting.models.serializer.ColorSerializer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes10.dex */
public class UriTemplate {
    private static final String COMPOSITE_NON_EXPLODE_JOINER = ",";
    private static final Map<Character, CompositeOutput> COMPOSITE_PREFIXES = new HashMap();

    static {
        CompositeOutput.values();
    }

    private enum CompositeOutput {
        PLUS('+', "", ",", false, true),
        HASH(Character.valueOf(ColorSerializer.PREFIX), "#", ",", false, true),
        DOT('.', ".", ".", false, false),
        FORWARD_SLASH('/', "/", "/", false, false),
        SEMI_COLON(';', AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER, AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER, true, false),
        QUERY('?', MsalUtils.QUERY_STRING_SYMBOL, MsalUtils.QUERY_STRING_DELIMITER, true, false),
        AMP(Character.valueOf(Typography.amp), MsalUtils.QUERY_STRING_DELIMITER, MsalUtils.QUERY_STRING_DELIMITER, true, false),
        SIMPLE(null, "", ",", false, false);

        private final String explodeJoiner;
        private final String outputPrefix;
        private final Character propertyPrefix;
        private final boolean requiresVarAssignment;
        private final boolean reservedExpansion;

        CompositeOutput(Character ch, String str, String str2, boolean z, boolean z2) {
            this.propertyPrefix = ch;
            this.outputPrefix = (String) Preconditions.checkNotNull(str);
            this.explodeJoiner = (String) Preconditions.checkNotNull(str2);
            this.requiresVarAssignment = z;
            this.reservedExpansion = z2;
            if (ch != null) {
                UriTemplate.COMPOSITE_PREFIXES.put(ch, this);
            }
        }

        String getOutputPrefix() {
            return this.outputPrefix;
        }

        String getExplodeJoiner() {
            return this.explodeJoiner;
        }

        boolean requiresVarAssignment() {
            return this.requiresVarAssignment;
        }

        int getVarNameStartIndex() {
            return this.propertyPrefix == null ? 0 : 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getEncodedValue(String str) {
            if (this.reservedExpansion) {
                return CharEscapers.escapeUriPathWithoutReserved(str);
            }
            return CharEscapers.escapeUriConformant(str);
        }
    }

    static CompositeOutput getCompositeOutput(String str) {
        CompositeOutput compositeOutput = COMPOSITE_PREFIXES.get(Character.valueOf(str.charAt(0)));
        return compositeOutput == null ? CompositeOutput.SIMPLE : compositeOutput;
    }

    private static Map<String, Object> getMap(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : Data.mapOf(obj).entrySet()) {
            Object value = entry.getValue();
            if (value != null && !Data.isNull(value)) {
                linkedHashMap.put(entry.getKey(), value);
            }
        }
        return linkedHashMap;
    }

    public static String expand(String str, String str2, Object obj, boolean z) {
        if (str2.startsWith("/")) {
            GenericUrl genericUrl = new GenericUrl(str);
            genericUrl.setRawPath(null);
            str2 = genericUrl.build() + str2;
        } else if (!str2.startsWith("http://") && !str2.startsWith(AuthenticationConstants.Broker.REDIRECT_SSL_PREFIX)) {
            str2 = str + str2;
        }
        return expand(str2, obj, z);
    }

    public static String expand(String str, Object obj, boolean z) {
        String listPropertyValue;
        Map<String, Object> map = getMap(obj);
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int iIndexOf = str.indexOf(123, i);
            if (iIndexOf == -1) {
                if (i == 0 && !z) {
                    return str;
                }
                sb.append(str.substring(i));
                break;
            }
            sb.append(str.substring(i, iIndexOf));
            int iIndexOf2 = str.indexOf(125, iIndexOf + 2);
            int i2 = iIndexOf2 + 1;
            String strSubstring = str.substring(iIndexOf + 1, iIndexOf2);
            CompositeOutput compositeOutput = getCompositeOutput(strSubstring);
            ListIterator<String> listIterator = Splitter.on(AbstractJsonLexerKt.COMMA).splitToList(strSubstring).listIterator();
            boolean z2 = true;
            while (listIterator.hasNext()) {
                String next = listIterator.next();
                boolean zEndsWith = next.endsWith("*");
                int varNameStartIndex = listIterator.nextIndex() == 1 ? compositeOutput.getVarNameStartIndex() : 0;
                int length2 = next.length();
                if (zEndsWith) {
                    length2--;
                }
                String strSubstring2 = next.substring(varNameStartIndex, length2);
                Object objRemove = map.remove(strSubstring2);
                if (objRemove != null) {
                    if (!z2) {
                        sb.append(compositeOutput.getExplodeJoiner());
                    } else {
                        sb.append(compositeOutput.getOutputPrefix());
                        z2 = false;
                    }
                    if (objRemove instanceof Iterator) {
                        listPropertyValue = getListPropertyValue(strSubstring2, (Iterator) objRemove, zEndsWith, compositeOutput);
                    } else if ((objRemove instanceof Iterable) || objRemove.getClass().isArray()) {
                        listPropertyValue = getListPropertyValue(strSubstring2, Types.iterableOf(objRemove).iterator(), zEndsWith, compositeOutput);
                    } else if (objRemove.getClass().isEnum()) {
                        String name = FieldInfo.of((Enum<?>) objRemove).getName();
                        if (name == null) {
                            name = objRemove.toString();
                        }
                        listPropertyValue = getSimpleValue(strSubstring2, name, compositeOutput);
                    } else if (!Data.isValueOfPrimitiveType(objRemove)) {
                        listPropertyValue = getMapPropertyValue(strSubstring2, getMap(objRemove), zEndsWith, compositeOutput);
                    } else {
                        listPropertyValue = getSimpleValue(strSubstring2, objRemove.toString(), compositeOutput);
                    }
                    sb.append((Object) listPropertyValue);
                }
            }
            i = i2;
        }
        if (z) {
            GenericUrl.addQueryParams(map.entrySet(), sb, false);
        }
        return sb.toString();
    }

    private static String getSimpleValue(String str, String str2, CompositeOutput compositeOutput) {
        return compositeOutput.requiresVarAssignment() ? String.format("%s=%s", str, compositeOutput.getEncodedValue(str2)) : compositeOutput.getEncodedValue(str2);
    }

    private static String getListPropertyValue(String str, Iterator<?> it, boolean z, CompositeOutput compositeOutput) {
        String explodeJoiner;
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            explodeJoiner = compositeOutput.getExplodeJoiner();
        } else {
            if (compositeOutput.requiresVarAssignment()) {
                sb.append(CharEscapers.escapeUriPath(str));
                sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            }
            explodeJoiner = ",";
        }
        while (it.hasNext()) {
            if (z && compositeOutput.requiresVarAssignment()) {
                sb.append(CharEscapers.escapeUriPath(str));
                sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            }
            sb.append(compositeOutput.getEncodedValue(it.next().toString()));
            if (it.hasNext()) {
                sb.append(explodeJoiner);
            }
        }
        return sb.toString();
    }

    private static String getMapPropertyValue(String str, Map<String, Object> map, boolean z, CompositeOutput compositeOutput) {
        String explodeJoiner;
        if (map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String str2 = SimpleComparison.EQUAL_TO_OPERATION;
        if (z) {
            explodeJoiner = compositeOutput.getExplodeJoiner();
        } else {
            if (compositeOutput.requiresVarAssignment()) {
                sb.append(CharEscapers.escapeUriPath(str));
                sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            }
            str2 = ",";
            explodeJoiner = ",";
        }
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> next = it.next();
            String encodedValue = compositeOutput.getEncodedValue(next.getKey());
            String encodedValue2 = compositeOutput.getEncodedValue(next.getValue().toString());
            sb.append(encodedValue);
            sb.append(str2);
            sb.append(encodedValue2);
            if (it.hasNext()) {
                sb.append(explodeJoiner);
            }
        }
        return sb.toString();
    }
}
