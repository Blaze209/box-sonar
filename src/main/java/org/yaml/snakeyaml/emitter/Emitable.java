package org.yaml.snakeyaml.emitter;

import java.io.IOException;
import org.yaml.snakeyaml.events.Event;

/* JADX INFO: loaded from: classes5.dex */
public interface Emitable {
    void emit(Event event) throws IOException;
}
