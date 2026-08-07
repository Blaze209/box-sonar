package io.split.android.client.storage.legacy;

import io.split.android.client.utils.logger.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class FileStorage implements IStorage {
    protected final File mDataFolder;

    public FileStorage(File rootFolder, String folderName) {
        File file = new File(rootFolder, folderName);
        this.mDataFolder = file;
        if (file.exists() || file.mkdir()) {
            return;
        }
        Logger.e("There was a problem creating Split cache folder");
    }

    @Override // io.split.android.client.storage.legacy.IStorage
    public String getRootPath() {
        return this.mDataFolder.getAbsolutePath();
    }

    @Override // io.split.android.client.storage.legacy.IStorage
    public String read(String elementId) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(this.mDataFolder, elementId));
            StringBuilder sb = new StringBuilder();
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    int i = fileInputStream.read(bArr);
                    if (i != -1) {
                        sb.append(new String(bArr, 0, i));
                    } else {
                        return sb.toString();
                    }
                } catch (IOException e) {
                    Logger.e(e, "Can't read file", new Object[0]);
                    throw e;
                }
            }
        } catch (FileNotFoundException e2) {
            Logger.d(e2.getMessage());
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // io.split.android.client.storage.legacy.IStorage
    public boolean write(String elementId, String content) throws Throwable {
        Throwable th;
        IOException e;
        FileNotFoundException e2;
        File file = new File(this.mDataFolder, elementId);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(content.getBytes());
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (IOException e3) {
                        Logger.e(e3, "Failed to stop file", new Object[0]);
                        return true;
                    }
                } catch (FileNotFoundException e4) {
                    e2 = e4;
                    Logger.e(e2, "Failed to write content", new Object[0]);
                    throw e2;
                } catch (IOException e5) {
                    e = e5;
                    Logger.e(e, "Failed to write content", new Object[0]);
                    throw e;
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e6) {
                        Logger.e(e6, "Failed to stop file", new Object[0]);
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            e2 = e7;
        } catch (IOException e8) {
            e = e8;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    @Override // io.split.android.client.storage.legacy.IStorage
    public void delete(String elementId) {
        if (new File(this.mDataFolder, elementId).delete()) {
            return;
        }
        Logger.e("There was a problem removing Split cache file");
    }

    @Override // io.split.android.client.storage.legacy.IStorage
    public void delete(List<String> files) {
        Iterator<String> it = files.iterator();
        while (it.hasNext()) {
            delete(it.next());
        }
    }

    @Override // io.split.android.client.storage.legacy.IStorage
    public String[] getAllIds() {
        File[] fileArrListFiles = new File(this.mDataFolder, ".").listFiles();
        if (fileArrListFiles == null) {
            return new String[0];
        }
        String[] strArr = new String[fileArrListFiles.length];
        int i = 0;
        for (File file : fileArrListFiles) {
            strArr[i] = file.getName();
            i++;
        }
        return strArr;
    }

    @Override // io.split.android.client.storage.legacy.IStorage
    public List<String> getAllIds(String fileNamePrefix) {
        ArrayList arrayList = new ArrayList();
        for (String str : getAllIds()) {
            if (str.startsWith(fileNamePrefix)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    @Override // io.split.android.client.storage.legacy.IStorage
    public boolean rename(String currentId, String newId) {
        return new File(this.mDataFolder, currentId).renameTo(new File(this.mDataFolder, newId));
    }

    @Override // io.split.android.client.storage.legacy.IStorage
    public boolean exists(String elementId) {
        return new File(this.mDataFolder, elementId).exists();
    }

    @Override // io.split.android.client.storage.legacy.IStorage
    public long lastModified(String elementId) {
        File file = new File(this.mDataFolder, elementId);
        if (file.exists()) {
            return file.lastModified();
        }
        return 0L;
    }

    @Override // io.split.android.client.storage.legacy.IStorage
    public long fileSize(String elementId) {
        return new File(this.mDataFolder, elementId).length();
    }
}
