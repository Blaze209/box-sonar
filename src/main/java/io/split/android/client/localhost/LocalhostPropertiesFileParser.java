package io.split.android.client.localhost;

import io.split.android.client.dtos.Split;
import io.split.android.client.utils.logger.Logger;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: classes4.dex */
public class LocalhostPropertiesFileParser implements LocalhostFileParser {
    @Override // io.split.android.client.localhost.LocalhostFileParser
    public Map<String, Split> parse(String content) {
        HashMap map = null;
        if (content == null) {
            return null;
        }
        try {
            Properties properties = new Properties();
            properties.load(new StringReader(content));
            HashMap map2 = new HashMap();
            try {
                for (Object obj : properties.keySet()) {
                    String str = (String) obj;
                    String property = properties.getProperty((String) obj);
                    if (str != null && property != null) {
                        Split splitCreateDefaultSplit = SplitHelper.createDefaultSplit(str);
                        splitCreateDefaultSplit.conditions = new ArrayList();
                        splitCreateDefaultSplit.conditions.add(SplitHelper.createRolloutCondition(property));
                        map2.put(splitCreateDefaultSplit.name, splitCreateDefaultSplit);
                    }
                }
                return map2;
            } catch (Exception unused) {
                map = map2;
                Logger.e("Error loading localhost property file");
                return map;
            }
        } catch (Exception unused2) {
        }
    }
}
