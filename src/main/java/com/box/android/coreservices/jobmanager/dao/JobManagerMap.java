package com.box.android.coreservices.jobmanager.dao;

import com.box.android.coreservices.jobmanager.JobItem;
import com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.jobmanager.tasks.BoxTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes9.dex */
public class JobManagerMap extends HashMap<String, JobItem> {
    private static final long serialVersionUID = 1;
    private HashSetMap mClassTypeMap = new HashSetMap();
    private HashSetMap mBoxItemIdMap = new HashSetMap();
    private HashSetMap mTitleMap = new HashSetMap();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public JobItem put(String str, JobItem jobItem) {
        this.mClassTypeMap.put(jobItem.getClass().toString(), str);
        this.mTitleMap.put(jobItem.getTitle(), str);
        if (jobItem instanceof JobItem.BoxItemJobItem) {
            this.mBoxItemIdMap.put(((JobItem.BoxItemJobItem) jobItem).getItemId(), str);
        }
        return (JobItem) super.put(str, jobItem);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public JobItem remove(Object obj) {
        JobItem jobItem;
        if (obj instanceof JobItem) {
            jobItem = (JobItem) obj;
        } else {
            jobItem = get(obj);
        }
        if (jobItem != null) {
            this.mClassTypeMap.remove(jobItem.getClass().toString(), jobItem.getId());
            this.mTitleMap.remove(jobItem.getTitle(), jobItem.getId());
            if (jobItem instanceof JobItem.BoxItemJobItem) {
                this.mBoxItemIdMap.remove(((JobItem.BoxItemJobItem) jobItem).getItemId(), jobItem.getId());
            }
        }
        if (jobItem != null) {
            return (JobItem) super.remove((Object) jobItem.getId());
        }
        return null;
    }

    public void addAllTasksInCollection(BoxJobCollection boxJobCollection) {
        Iterator<BoxJob> it = boxJobCollection.getChildJobItems().iterator();
        while (it.hasNext()) {
            Iterator<BoxTask> it2 = it.next().getChildJobItems().iterator();
            while (it2.hasNext()) {
                put(it2.next());
            }
        }
    }

    public void removeAllInCollection(BoxJobCollection boxJobCollection) {
        for (BoxJob boxJob : boxJobCollection.getChildJobItems()) {
            Iterator<BoxTask> it = boxJob.getChildJobItems().iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            remove((Object) boxJob);
        }
        remove((Object) boxJobCollection);
    }

    public JobItem put(JobItem jobItem) {
        return put(jobItem.getId(), jobItem);
    }

    public ArrayList<JobItem> getItemsWith(Class<? extends JobItem> cls, String str, String str2) {
        JobItem jobItem;
        ArrayList<HashSet> arrayList = new ArrayList(3);
        if (cls != null) {
            arrayList.add(this.mClassTypeMap.get(cls.toString()));
        }
        if (str != null) {
            arrayList.add(this.mBoxItemIdMap.get(str));
        }
        if (str2 != null) {
            arrayList.add(this.mTitleMap.get(str2));
        }
        HashSet<String> hashSet = null;
        for (HashSet hashSet2 : arrayList) {
            if (hashSet2 == null) {
                return new ArrayList<>(0);
            }
            if (hashSet == null || hashSet2.size() < hashSet.size()) {
                hashSet = hashSet2;
            }
        }
        arrayList.remove(hashSet);
        ArrayList<JobItem> arrayList2 = new ArrayList<>(hashSet.size());
        for (String str3 : hashSet) {
            Iterator it = arrayList.iterator();
            boolean zContains = true;
            while (it.hasNext()) {
                zContains &= ((HashSet) it.next()).contains(str3);
            }
            if (zContains && (jobItem = get(str3)) != null) {
                arrayList2.add(jobItem);
            }
        }
        return arrayList2;
    }

    protected class HashSetMap extends HashMap<String, HashSet<String>> {
        private static final long serialVersionUID = 1;

        protected HashSetMap() {
        }

        public HashSet<String> put(String str, String str2) {
            HashSet<String> hashSet = get(str);
            if (hashSet != null) {
                hashSet.add(str2);
                return hashSet;
            }
            HashSet<String> hashSet2 = new HashSet<>();
            hashSet2.add(str2);
            super.put(str, hashSet2);
            return hashSet2;
        }

        public HashSet<String> remove(String str, String str2) {
            HashSet<String> hashSet = get(str);
            if (hashSet == null) {
                return null;
            }
            hashSet.remove(str2);
            return hashSet.size() > 0 ? hashSet : (HashSet) super.remove(str);
        }
    }
}
