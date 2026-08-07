package org.yaml.snakeyaml.inspector;

import org.yaml.snakeyaml.nodes.Tag;

/* JADX INFO: loaded from: classes5.dex */
public final class UnTrustedTagInspector implements TagInspector {
    @Override // org.yaml.snakeyaml.inspector.TagInspector
    public boolean isGlobalTagAllowed(Tag tag) {
        return false;
    }
}
