package org.yaml.snakeyaml.parser;

import java.util.Map;
import org.yaml.snakeyaml.DumperOptions;

/* JADX INFO: loaded from: classes5.dex */
class VersionTagsTuple {
    private final Map<String, String> tags;
    private final DumperOptions.Version version;

    public VersionTagsTuple(DumperOptions.Version version, Map<String, String> map) {
        this.version = version;
        this.tags = map;
    }

    public DumperOptions.Version getVersion() {
        return this.version;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public String toString() {
        return String.format("VersionTagsTuple<%s, %s>", this.version, this.tags);
    }
}
