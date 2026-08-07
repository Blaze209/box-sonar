package io.split.android.client.localhost;

import io.split.android.client.dtos.Split;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface LocalhostFileParser {
    Map<String, Split> parse(String content);
}
