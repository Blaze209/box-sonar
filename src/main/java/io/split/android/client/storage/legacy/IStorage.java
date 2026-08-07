package io.split.android.client.storage.legacy;

import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface IStorage {
    void delete(String elementId);

    void delete(List<String> files);

    boolean exists(String elementId);

    long fileSize(String elementId);

    List<String> getAllIds(String fileNamePrefix);

    String[] getAllIds();

    String getRootPath();

    long lastModified(String elementId);

    String read(String elementId) throws IOException;

    boolean rename(String currentId, String newId);

    boolean write(String elementId, String content) throws IOException;
}
