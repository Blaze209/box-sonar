package io.split.android.client.storage.splits;

import io.split.android.client.dtos.Split;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
class MetadataHelper {
    MetadataHelper() {
    }

    static void increaseTrafficTypeCount(String name, Map<String, Integer> outputTrafficTypes) {
        if (name == null) {
            return;
        }
        String lowerCase = name.toLowerCase();
        outputTrafficTypes.put(lowerCase, Integer.valueOf(countForTrafficType(lowerCase, outputTrafficTypes) + 1));
    }

    static void decreaseTrafficTypeCount(String name, Map<String, Integer> outputTrafficTypes) {
        if (name == null) {
            return;
        }
        String lowerCase = name.toLowerCase();
        int iCountForTrafficType = countForTrafficType(lowerCase, outputTrafficTypes);
        if (iCountForTrafficType > 1) {
            outputTrafficTypes.put(lowerCase, Integer.valueOf(iCountForTrafficType - 1));
        } else {
            outputTrafficTypes.remove(lowerCase);
        }
    }

    static int countForTrafficType(String name, Map<String, Integer> outputTrafficTypes) {
        Integer num = outputTrafficTypes.get(name);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    static void addOrUpdateFlagSets(Split split, Map<String, Set<String>> outputFlagSets) {
        if (split.sets == null) {
            return;
        }
        for (String str : split.sets) {
            Set<String> hashSet = outputFlagSets.get(str);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                outputFlagSets.put(str, hashSet);
            }
            hashSet.add(split.name);
        }
        deleteFromFlagSetsIfNecessary(split, outputFlagSets);
    }

    static void deleteFromFlagSetsIfNecessary(Split featureFlag, Map<String, Set<String>> outputFlagSets) {
        Set<String> set;
        if (featureFlag.sets == null) {
            return;
        }
        for (String str : outputFlagSets.keySet()) {
            if (!featureFlag.sets.contains(str) && (set = outputFlagSets.get(str)) != null) {
                set.remove(featureFlag.name);
            }
        }
    }

    static void deleteFromFlagSets(Split featureFlag, Map<String, Set<String>> outputFlagSets) {
        Iterator<String> it = outputFlagSets.keySet().iterator();
        while (it.hasNext()) {
            Set<String> set = outputFlagSets.get(it.next());
            if (set != null) {
                set.remove(featureFlag.name);
            }
        }
    }
}
