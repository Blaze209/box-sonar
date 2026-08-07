package io.split.android.client.dtos;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ChunkHeader {
    public static final Type CHUNK_HEADER_TYPE = new TypeToken<List<ChunkHeader>>() { // from class: io.split.android.client.dtos.ChunkHeader.1
    }.getType();
    private int attempt;
    private String id;
    private long timestamp;

    public ChunkHeader(String id, int attempt, long timestamp) {
        this.id = id;
        this.attempt = attempt;
        this.timestamp = timestamp;
    }

    public ChunkHeader(String id, int attempt) {
        this(id, attempt, 0L);
    }

    public String getId() {
        return this.id;
    }

    public int getAttempt() {
        return this.attempt;
    }

    public int getTimestamp() {
        return this.attempt;
    }
}
