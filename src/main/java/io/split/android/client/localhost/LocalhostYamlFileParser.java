package io.split.android.client.localhost;

import io.split.android.client.dtos.Split;
import io.split.android.client.utils.YamlParser;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class LocalhostYamlFileParser implements LocalhostFileParser {
    private static final String CONFIG_FIELD = "config";
    private static final String KEYS_FIELD = "keys";
    private static final String TREATMENT_FIELD = "treatment";

    @Override // io.split.android.client.localhost.LocalhostFileParser
    public Map<String, Split> parse(String content) {
        HashMap map = null;
        try {
            List list = (List) new YamlParser().parse(content);
            if (list == null) {
                Logger.e("Feature flag file could not be parsed because it is not in the correct format.");
                return null;
            }
            HashMap map2 = new HashMap();
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    try {
                        addLoadedSplitToParsedSplits(map2, (Map) next);
                    } catch (Exception unused) {
                        Logger.e("An error has occurred while parsing a feature flag" + (next != null ? ", source: '" + next + "'" : ""));
                    }
                }
                return map2;
            } catch (Exception unused2) {
                map = map2;
                Logger.e("An error has occurred while parsing localhost feature flags content");
                return map;
            }
        } catch (Exception unused3) {
        }
    }

    private void addLoadedSplitToParsedSplits(Map<String, Split> splits, Map<String, Object> loadedSplit) {
        String str;
        Map<String, String> map;
        Object[] array = loadedSplit.keySet().toArray();
        if (array.length <= 0 || (str = (String) array[0]) == null || (map = (Map) loadedSplit.get(str)) == null || map.get(TREATMENT_FIELD) == null) {
            return;
        }
        Split orCreateSplit = getOrCreateSplit(splits, str);
        String str2 = map.get(TREATMENT_FIELD);
        addConditionsToSplit(orCreateSplit, str2, parseKeys(map.get("keys")));
        addConfigToSplit(orCreateSplit, map, str2);
        splits.put(orCreateSplit.name, orCreateSplit);
    }

    private void addConfigToSplit(Split split, Map<String, String> splitMap, String treatment) {
        String str = splitMap.get(CONFIG_FIELD);
        if (str != null) {
            if (split.configurations == null) {
                split.configurations = new HashMap();
            }
            split.configurations.put(treatment, str);
        }
    }

    private void addConditionsToSplit(Split split, String treatment, List<String> keys) {
        if (keys.size() > 0) {
            split.conditions.add(0, SplitHelper.createWhiteListCondition(keys, treatment));
        } else {
            split.conditions.add(SplitHelper.createRolloutCondition(treatment));
        }
    }

    private List<String> parseKeys(Object keysContent) {
        if (keysContent == null) {
            return new ArrayList();
        }
        try {
            if (keysContent instanceof List) {
                return (ArrayList) keysContent;
            }
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add((String) keysContent);
                return arrayList;
            } catch (ClassCastException unused) {
                return arrayList;
            }
        } catch (ClassCastException unused2) {
            return new ArrayList();
        }
    }

    private Split getOrCreateSplit(Map<String, Split> splits, String splitName) {
        Split split = splits.get(splitName);
        return split == null ? SplitHelper.createDefaultSplit(splitName) : split;
    }
}
