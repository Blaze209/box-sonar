package io.split.android.client.utils;

import io.split.android.client.utils.logger.Logger;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YAMLException;

/* JADX INFO: loaded from: classes4.dex */
public class YamlParser {
    Yaml yaml = new Yaml();

    public <T> T parse(String str) {
        try {
            return (T) this.yaml.load(str);
        } catch (YAMLException e) {
            Logger.e("Error parsing yaml file: " + e.getLocalizedMessage());
            return null;
        } catch (Exception e2) {
            Logger.e("Unknown error while parsing yaml file: " + e2.getLocalizedMessage());
            return null;
        }
    }
}
