package sdk.pendo.io.b;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GlobalEventPropertiesKt;
import sdk.pendo.io.models.PersonalizationDefVal;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lsdk/pendo/io/b/b;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class b {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Pattern b = Pattern.compile("\\<\\%\\=(.*?)\\%\\>");

    /* JADX INFO: renamed from: sdk.pendo.io.b.b$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b#\u0010$J4\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J(\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J*\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006H\u0002J&\u0010\t\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u001c\u0010\u001c\u001a\n \u001b*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u0017R\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u0017¨\u0006%"}, d2 = {"Lsdk/pendo/io/b/b$a;", "", "", "originalText", "", "personalizedStringsList", "", "Lsdk/pendo/io/models/PersonalizationDefVal;", "defaultValuesMap", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "propertyKey", "c", "text", "Ljava/util/regex/Pattern;", "pattern", "", "groupIndex", "propertySections", "b", "key", "dataMap", "textToSet", "ACCOUNT", "Ljava/lang/String;", "AGENT", "DOT_DELIMITER", "EMPTY_STRING", "kotlin.jvm.PlatformType", "PERSONALIZED_STRING_REGEX", "Ljava/util/regex/Pattern;", "PERSONALIZED_STRING_REGEX_GROUP_INDEX", "I", "PERSONAL_DATA_MAP_LEVELS", "TAG", "VISITOR", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List<String> a(String text, Pattern pattern, int groupIndex) {
            ArrayList arrayList = new ArrayList();
            if (pattern != null) {
                Matcher matcher = pattern.matcher(text);
                while (matcher.find()) {
                    try {
                        String strGroup = matcher.group(groupIndex);
                        if (strGroup != null) {
                            Intrinsics.checkNotNull(strGroup);
                            arrayList.add(strGroup);
                        }
                    } catch (Exception e) {
                        PendoLogger.e(e, "Failed to get the string from matcher's pattern group", new Object[0]);
                    }
                }
            }
            return arrayList;
        }

        private final String b(List<String> propertySections) {
            String str;
            Map<String, ? extends Object> mapJ;
            if (!Intrinsics.areEqual(propertySections.get(1), "agent")) {
                return null;
            }
            String str2 = propertySections.get(0);
            if (Intrinsics.areEqual(str2, GlobalEventPropertiesKt.VISITOR_KEY)) {
                str = propertySections.get(2);
                mapJ = PendoInternal.E();
            } else {
                if (!Intrinsics.areEqual(str2, "account")) {
                    return null;
                }
                str = propertySections.get(2);
                mapJ = PendoInternal.j();
            }
            return b(str, mapJ);
        }

        private final String c(String propertyKey, Map<String, PersonalizationDefVal> defaultValuesMap) {
            PersonalizationDefVal personalizationDefVal;
            PendoLogger.d("DynamicHelperTextParser, propertyKey is " + propertyKey, new Object[0]);
            List<String> listSplit$default = StringsKt.split$default((CharSequence) propertyKey, new String[]{"."}, false, 0, 6, (Object) null);
            if (listSplit$default != null && !listSplit$default.isEmpty() && listSplit$default.size() == 3) {
                String strB = b(listSplit$default);
                if (strB != null && strB.length() != 0) {
                    return strB;
                }
                String strA = a(listSplit$default);
                if (strA != null && strA.length() != 0) {
                    return strA;
                }
                if (defaultValuesMap != null && (personalizationDefVal = defaultValuesMap.get(propertyKey)) != null) {
                    return personalizationDefVal.getDefaultValue();
                }
            }
            return null;
        }

        private final String a(String originalText, List<String> personalizedStringsList, Map<String, PersonalizationDefVal> defaultValuesMap) {
            String strReplace$default = originalText;
            for (String str : personalizedStringsList) {
                PendoLogger.d("DynamicHelperTextParser, personalizedString: " + str, new Object[0]);
                String str2 = "";
                if (str.length() > 0) {
                    String strC = c(str, defaultValuesMap);
                    str2 = strC != null ? strC : "";
                    PendoLogger.d("DynamicHelperTextParser, propertyValue: " + strC + " personalizedValue: " + ((Object) str2), new Object[0]);
                }
                String str3 = "<%=" + str + "%>";
                PendoLogger.d("DynamicHelperTextParser, stringToReplace: " + str3, new Object[0]);
                strReplace$default = StringsKt.replace$default(strReplace$default, str3, str2, false, 4, (Object) null);
            }
            return strReplace$default;
        }

        private final String b(String key, Map<String, ? extends Object> dataMap) {
            if (dataMap != null) {
                try {
                    Object obj = dataMap.get(key);
                    if (obj != null) {
                        return obj.toString();
                    }
                } catch (Exception e) {
                    PendoLogger.w(e, "DynamicHelperTextParser.getValueFromMapAsString: error while trying to find key = " + key + ", returning null", new Object[0]);
                }
            }
            return null;
        }

        private final String a(List<String> propertySections) {
            Map<String, Map<String, Object>> mapK;
            String str = propertySections.get(0);
            return b(propertySections.get(2), (!Intrinsics.areEqual(str, GlobalEventPropertiesKt.VISITOR_KEY) ? !(!Intrinsics.areEqual(str, "account") || (mapK = PendoInternal.k()) == null) : (mapK = PendoInternal.F()) != null) ? null : (Map) mapK.get(propertySections.get(1)));
        }

        public final String a(String textToSet, Map<String, PersonalizationDefVal> defaultValuesMap) {
            if (textToSet == null) {
                return "";
            }
            Companion companion = b.INSTANCE;
            List<String> listA = companion.a(textToSet, b.b, 1);
            return listA.isEmpty() ? textToSet : companion.a(textToSet, listA, defaultValuesMap);
        }
    }
}
