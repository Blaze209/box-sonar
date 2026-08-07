package io.split.android.client.storage.legacy;

import com.google.gson.JsonSyntaxException;
import io.split.android.client.dtos.ChunkHeader;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.MemoryUtils;
import io.split.android.client.utils.MemoryUtilsImpl;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public class FileStorageHelper {
    public static final String LINE_SEPARATOR;
    private static final int MEMORY_ALLOCATION_TIMES = 2;
    private final MemoryUtils mMemoryUtils;

    static {
        LINE_SEPARATOR = System.getProperty("line.separator") != null ? System.getProperty("line.separator") : "\n";
    }

    public FileStorageHelper() {
        this(new MemoryUtilsImpl());
    }

    public FileStorageHelper(MemoryUtils memoryUtils) {
        this.mMemoryUtils = memoryUtils;
    }

    public List<ChunkHeader> readAndParseChunkHeadersFile(String fileName, IStorage storage) {
        if (isOutdated(storage.lastModified(fileName))) {
            return new ArrayList();
        }
        try {
            String str = storage.read(fileName);
            if (str != null) {
                return (List) Json.fromJson(str, ChunkHeader.CHUNK_HEADER_TYPE);
            }
            return null;
        } catch (JsonSyntaxException e) {
            Logger.e(e, "Unable to parse saved chunks headers: " + e.getLocalizedMessage(), new Object[0]);
            return null;
        } catch (IOException e2) {
            Logger.e(e2, "Unable chunks headers information from disk: " + e2.getLocalizedMessage(), new Object[0]);
            return null;
        } catch (Exception e3) {
            Logger.e(e3, "Error loading chunk headers from disk: " + e3.getLocalizedMessage(), new Object[0]);
            return null;
        }
    }

    public ChunkHeader chunkFromLine(String jsonChunk) {
        if (Utils.isNullOrEmpty(jsonChunk)) {
            return newHeaderChunk();
        }
        try {
            return (ChunkHeader) Json.fromJson(jsonChunk, ChunkHeader.class);
        } catch (JsonSyntaxException unused) {
            return newHeaderChunk();
        }
    }

    public FileWriter fileWriterFrom(File dataFolder, String fileName) throws IOException {
        return new FileWriter(new File(dataFolder, fileName));
    }

    public void closeFileInputStream(FileInputStream stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                Logger.w("Error closing file input stream: " + e.getLocalizedMessage());
            }
        }
    }

    public void closeScanner(Scanner scanner) {
        if (scanner != null) {
            scanner.close();
        }
    }

    public void closeFileWriter(FileWriter fileWriter) {
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                Logger.w("Error closing file writer: " + e.getLocalizedMessage());
            }
        }
    }

    public void logIfScannerException(Scanner scanner, String message) {
        if (scanner.ioException() != null) {
            Logger.e(message + scanner.ioException().getLocalizedMessage());
        }
    }

    public void writeChunkHeaderLine(ChunkHeader chunkHeader, FileWriter fileWriter) throws IOException {
        fileWriter.write(Json.toJson(chunkHeader));
        fileWriter.write(LINE_SEPARATOR);
    }

    public String checkMemoryAndReadFile(String name, IStorage storage) {
        if (isOutdated(storage.lastModified(name))) {
            return null;
        }
        long jFileSize = storage.fileSize(name);
        if (jFileSize > 0 && this.mMemoryUtils.isMemoryAvailableToAllocate(jFileSize, 2)) {
            try {
                return storage.read(name);
            } catch (IOException e) {
                Logger.e(e, "Unable to load file from disk: " + name + " error: " + e.getLocalizedMessage(), new Object[0]);
            }
        } else {
            Logger.w("Unable to parse file " + name + ". Memory not available");
        }
        return null;
    }

    private ChunkHeader newHeaderChunk() {
        return new ChunkHeader(UUID.randomUUID().toString(), 1);
    }

    public boolean isOutdated(long timestamp) {
        return (System.currentTimeMillis() / 1000) - ServiceConstants.RECORDED_DATA_EXPIRATION_PERIOD > timestamp;
    }
}
