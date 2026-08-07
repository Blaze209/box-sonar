package io.split.android.engine.splitter;

import io.split.android.client.dtos.Partition;
import io.split.android.client.utils.MurmurHash3;
import io.split.android.grammar.Treatments;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class Splitter {
    private static final int ALGO_LEGACY = 1;
    private static final int ALGO_MURMUR = 2;

    public static String getTreatment(String key, int seed, List<Partition> partitions, int algo) {
        if (partitions.isEmpty()) {
            return Treatments.CONTROL;
        }
        if (hundredPercentOneTreatment(partitions)) {
            return partitions.get(0).treatment;
        }
        return getTreatment(bucket(hash(key, seed, algo)), partitions);
    }

    static long hash(String key, int seed, int algo) {
        if (algo == 2) {
            return murmur_hash(key, seed);
        }
        return legacy_hash(key, seed);
    }

    static long murmur_hash(String key, int seed) {
        return MurmurHash3.murmurhash3_x86_32(key, 0, key.length(), seed);
    }

    public static int getBucket(String key, int seed, int algo) {
        return bucket(hash(key, seed, algo));
    }

    static int legacy_hash(String key, int seed) {
        int iCharAt = 0;
        for (int i = 0; i < key.length(); i++) {
            iCharAt = (iCharAt * 31) + key.charAt(i);
        }
        return iCharAt ^ seed;
    }

    private static String getTreatment(int bucket, List<Partition> partitions) {
        int i = 0;
        for (Partition partition : partitions) {
            i += partition.size;
            if (i >= bucket) {
                return partition.treatment;
            }
        }
        return Treatments.CONTROL;
    }

    static int bucket(long hash) {
        return (int) (Math.abs(hash % 100) + 1);
    }

    private static boolean hundredPercentOneTreatment(List<Partition> partitions) {
        return partitions.size() == 1 && partitions.get(0).size == 100;
    }
}
