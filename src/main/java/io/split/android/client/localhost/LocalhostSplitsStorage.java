package io.split.android.client.localhost;

import android.content.Context;
import io.split.android.client.dtos.Split;
import io.split.android.client.events.EventsManagerCoordinator;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.storage.legacy.FileStorage;
import io.split.android.client.storage.splits.ProcessedSplitChange;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.utils.FileUtils;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class LocalhostSplitsStorage implements SplitsStorage {
    private final Context mContext;
    private final EventsManagerCoordinator mEventsManager;
    private final FileStorage mFileStorage;
    private String mLocalhostFileName;
    private LocalhostFileParser mParser;
    private final Map<String, Split> mInMemorySplits = new ConcurrentHashMap();
    private final Map<String, Set<String>> mFlagSets = new ConcurrentHashMap();
    private final FileUtils mFileUtils = new FileUtils();
    private String mLastContentLoaded = "";

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public long getTill() {
        return 1L;
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public long getUpdateTimestamp() {
        return 1L;
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public boolean isValidTrafficType(String name) {
        return true;
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public boolean update(ProcessedSplitChange splitChange) {
        return false;
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public void updateFlagsSpec(String flagsSpec) {
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public void updateSplitsFilterQueryString(String queryString) {
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public void updateWithoutChecks(Split split) {
    }

    public LocalhostSplitsStorage(String fileName, Context context, FileStorage fileStorage, EventsManagerCoordinator eventsManager) throws Throwable {
        this.mLocalhostFileName = fileName;
        this.mContext = (Context) Utils.checkNotNull(context);
        this.mFileStorage = (FileStorage) Utils.checkNotNull(fileStorage);
        this.mEventsManager = (EventsManagerCoordinator) Utils.checkNotNull(eventsManager);
        setup();
    }

    @Override // io.split.android.client.storage.RolloutDefinitionsCache
    public void loadLocal() {
        loadSplits();
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public Split get(String name) {
        return this.mInMemorySplits.get(name);
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public Map<String, Split> getMany(List<String> splitNames) {
        HashMap map = new HashMap();
        synchronized (this) {
            if (splitNames != null) {
                if (!splitNames.isEmpty()) {
                    for (String str : splitNames) {
                        Split split = this.mInMemorySplits.get(str);
                        if (split != null) {
                            map.put(str, split);
                        }
                    }
                    return map;
                }
            }
            map.putAll(this.mInMemorySplits);
            return map;
        }
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public Map<String, Split> getAll() {
        HashMap map = new HashMap();
        synchronized (this) {
            map.putAll(this.mInMemorySplits);
        }
        return map;
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public String getSplitsFilterQueryString() {
        return "";
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public String getFlagsSpec() {
        return "";
    }

    @Override // io.split.android.client.storage.RolloutDefinitionsCache
    public void clear() {
        this.mInMemorySplits.clear();
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public Set<String> getNamesByFlagSets(Collection<String> sets) {
        HashSet hashSet = new HashSet();
        if (sets != null && !sets.isEmpty()) {
            Iterator<String> it = sets.iterator();
            while (it.hasNext()) {
                Set<String> set = this.mFlagSets.get(it.next());
                if (set != null) {
                    hashSet.addAll(set);
                }
            }
        }
        return hashSet;
    }

    private void setup() throws Throwable {
        if (this.mLocalhostFileName == null) {
            String yamlFileName = getYamlFileName(this.mContext);
            if (yamlFileName != null) {
                this.mLocalhostFileName = yamlFileName;
            } else {
                this.mLocalhostFileName = "splits.properties";
                Logger.w("Localhost mode: .split mocks will be deprecated soon in favor of YAML files, which provide more targeting power. Take a look in our documentation.");
            }
        }
        if (this.mFileUtils.isPropertiesFileName(this.mLocalhostFileName)) {
            this.mParser = new LocalhostPropertiesFileParser();
        } else {
            this.mParser = new LocalhostYamlFileParser();
        }
        copyFileResourceToDataFolder(this.mLocalhostFileName, this.mFileStorage, this.mContext);
    }

    private void loadSplits() {
        try {
            String str = this.mFileStorage.read(this.mLocalhostFileName);
            Logger.i("Localhost file reloaded: " + this.mLocalhostFileName);
            if (str == null) {
                return;
            }
            synchronized (this) {
                this.mInMemorySplits.clear();
                Map<String, Split> map = this.mParser.parse(str);
                if (map != null) {
                    this.mInMemorySplits.putAll(map);
                    for (Split split : map.values()) {
                        Set<String> set = split.sets;
                        if (set != null) {
                            for (String str2 : set) {
                                Set<String> hashSet = this.mFlagSets.get(str2);
                                if (hashSet == null) {
                                    hashSet = new HashSet<>();
                                    this.mFlagSets.put(str2, hashSet);
                                }
                                hashSet.add(split.name);
                            }
                        }
                    }
                }
                if (!str.equals(this.mLastContentLoaded)) {
                    this.mEventsManager.notifyInternalEvent(SplitInternalEvent.SPLITS_LOADED_FROM_STORAGE);
                    this.mEventsManager.notifyInternalEvent(SplitInternalEvent.SPLITS_FETCHED);
                    this.mEventsManager.notifyInternalEvent(SplitInternalEvent.SPLITS_UPDATED);
                }
                this.mLastContentLoaded = str;
            }
        } catch (IOException unused) {
            Logger.e("Error reading localhost yaml file");
        }
    }

    private String getYamlFileName(Context context) {
        Iterator it = Arrays.asList(ServiceConstants.YAML_EXTENSION, ServiceConstants.YML_EXTENSION).iterator();
        while (it.hasNext()) {
            String strCheckFileType = checkFileType(context, this.mFileUtils, (String) it.next());
            if (strCheckFileType != null) {
                return strCheckFileType;
            }
        }
        return null;
    }

    private String checkFileType(Context context, FileUtils fileUtils, String extension) {
        String str = "splits." + extension;
        if (fileUtils.fileExists(str, context)) {
            return str;
        }
        return null;
    }

    private void copyFileResourceToDataFolder(String fileName, FileStorage fileStorage, Context context) throws Throwable {
        try {
            String strLoadFileContent = new FileUtils().loadFileContent(fileName, context);
            if (strLoadFileContent != null) {
                fileStorage.write(fileName, strLoadFileContent);
                Logger.i("LOCALHOST MODE: File location is: " + this.mFileStorage.getRootPath() + "/" + fileName);
            }
        } catch (IOException e) {
            Logger.e(e.getLocalizedMessage());
        }
    }
}
