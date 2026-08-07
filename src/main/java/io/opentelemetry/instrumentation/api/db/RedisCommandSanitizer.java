package io.opentelemetry.instrumentation.api.db;

import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class RedisCommandSanitizer {
    private static final CommandSanitizer DEFAULT = new CommandAndNumArgs(0);
    private static final Map<String, CommandSanitizer> SANITIZERS;
    private final boolean statementSanitizationEnabled;

    interface CommandSanitizer {
        String sanitize(String str, List<?> list);
    }

    static {
        HashMap map = new HashMap();
        boolean z = true;
        CommandAndNumArgs commandAndNumArgs = new CommandAndNumArgs(1);
        CommandAndNumArgs commandAndNumArgs2 = new CommandAndNumArgs(2);
        MultiKeyValue multiKeyValue = new MultiKeyValue(1);
        MultiKeyValue multiKeyValue2 = new MultiKeyValue(0);
        char c = 3;
        Iterator it = Arrays.asList("CLUSTER", "FAILOVER", "READONLY", "READWRITE").iterator();
        while (it.hasNext()) {
            map.put((String) it.next(), KeepAllArgs.INSTANCE);
        }
        map.put("AUTH", DEFAULT);
        map.put(AuthenticationConstants.BrokerAccountManagerOperation.HELLO, commandAndNumArgs2);
        Iterator it2 = Arrays.asList("CLIENT", "ECHO", "PING", "QUIT", "RESET", "SELECT").iterator();
        while (it2.hasNext()) {
            map.put((String) it2.next(), KeepAllArgs.INSTANCE);
        }
        char c2 = '\n';
        Iterator it3 = Arrays.asList("GEOADD", "GEODIST", "GEOHASH", "GEOPOS", "GEORADIUS", "GEORADIUS_RO", "GEORADIUSBYMEMBER", "GEORADIUSBYMEMBER_RO", "GEOSEARCH", "GEOSEARCHSTORE").iterator();
        while (it3.hasNext()) {
            map.put((String) it3.next(), KeepAllArgs.INSTANCE);
            z = z;
        }
        boolean z2 = z;
        map.put("HMSET", multiKeyValue);
        map.put("HSET", multiKeyValue);
        map.put("HSETNX", commandAndNumArgs2);
        String[] strArr = new String[13];
        strArr[0] = "HDEL";
        strArr[z2 ? 1 : 0] = "HEXISTS";
        strArr[2] = "HGET";
        strArr[3] = "HGETALL";
        strArr[4] = "HINCRBY";
        strArr[5] = "HINCRBYFLOAT";
        strArr[6] = "HKEYS";
        strArr[7] = "HLEN";
        strArr[8] = "HMGET";
        strArr[9] = "HRANDFIELD";
        strArr[10] = "HSCAN";
        strArr[11] = "HSTRLEN";
        strArr[12] = "HVALS";
        Iterator it4 = Arrays.asList(strArr).iterator();
        while (it4.hasNext()) {
            map.put((String) it4.next(), KeepAllArgs.INSTANCE);
            c2 = c2;
        }
        char c3 = c2;
        map.put("PFADD", commandAndNumArgs);
        String[] strArr2 = new String[2];
        strArr2[0] = "PFCOUNT";
        strArr2[z2 ? 1 : 0] = "PFMERGE";
        Iterator it5 = Arrays.asList(strArr2).iterator();
        while (it5.hasNext()) {
            map.put((String) it5.next(), KeepAllArgs.INSTANCE);
        }
        map.put("MIGRATE", new CommandAndNumArgs(6));
        map.put("RESTORE", commandAndNumArgs2);
        String[] strArr3 = new String[26];
        strArr3[0] = "COPY";
        strArr3[z2 ? 1 : 0] = "DEL";
        strArr3[2] = "DUMP";
        strArr3[3] = "EXISTS";
        strArr3[4] = "EXPIRE";
        strArr3[5] = "EXPIREAT";
        strArr3[6] = "EXPIRETIME";
        strArr3[7] = "KEYS";
        strArr3[8] = "MOVE";
        strArr3[9] = "OBJECT";
        strArr3[c3] = "PERSIST";
        strArr3[11] = "PEXPIRE";
        strArr3[12] = "PEXPIREAT";
        strArr3[13] = "PEXPIRETIME";
        strArr3[14] = "PTTL";
        strArr3[15] = "RANDOMKEY";
        strArr3[16] = "RENAME";
        strArr3[17] = "RENAMENX";
        strArr3[18] = "SCAN";
        strArr3[19] = "SORT";
        strArr3[20] = "SORT_RO";
        strArr3[21] = "TOUCH";
        strArr3[22] = "TTL";
        strArr3[23] = CredentialProviderBaseController.TYPE_TAG;
        strArr3[24] = "UNLINK";
        strArr3[25] = "WAIT";
        Iterator it6 = Arrays.asList(strArr3).iterator();
        while (it6.hasNext()) {
            map.put((String) it6.next(), KeepAllArgs.INSTANCE);
            c = c;
        }
        char c4 = c;
        map.put("LINSERT", commandAndNumArgs2);
        map.put("LPOS", commandAndNumArgs);
        map.put("LPUSH", commandAndNumArgs);
        map.put("LPUSHX", commandAndNumArgs);
        map.put("LREM", commandAndNumArgs);
        map.put("LSET", commandAndNumArgs);
        map.put("RPUSH", commandAndNumArgs);
        map.put("RPUSHX", commandAndNumArgs);
        String[] strArr4 = new String[14];
        strArr4[0] = "BLMOVE";
        strArr4[z2 ? 1 : 0] = "BLMPOP";
        strArr4[2] = "BLPOP";
        strArr4[c4] = "BRPOP";
        strArr4[4] = "BRPOPLPUSH";
        strArr4[5] = "LINDEX";
        strArr4[6] = "LLEN";
        strArr4[7] = "LMOVE";
        strArr4[8] = "LMPOP";
        strArr4[9] = "LPOP";
        strArr4[c3] = "LRANGE";
        strArr4[11] = "LTRIM";
        strArr4[12] = "RPOP";
        strArr4[13] = "RPOPLPUSH";
        Iterator it7 = Arrays.asList(strArr4).iterator();
        while (it7.hasNext()) {
            map.put((String) it7.next(), KeepAllArgs.INSTANCE);
        }
        map.put("PUBLISH", commandAndNumArgs);
        String[] strArr5 = new String[8];
        strArr5[0] = "PSUBSCRIBE";
        strArr5[z2 ? 1 : 0] = "PUBSUB";
        strArr5[2] = "PUNSUBSCRIBE";
        strArr5[c4] = "SPUBLISH";
        strArr5[4] = "SSUBSCRIBE";
        strArr5[5] = "SUBSCRIBE";
        strArr5[6] = "SUNSUBSCRIBE";
        strArr5[7] = "UNSUBSCRIBE";
        Iterator it8 = Arrays.asList(strArr5).iterator();
        while (it8.hasNext()) {
            map.put((String) it8.next(), KeepAllArgs.INSTANCE);
        }
        map.put("EVAL", Eval.INSTANCE);
        map.put("EVAL_RO", Eval.INSTANCE);
        map.put("EVALSHA", Eval.INSTANCE);
        map.put("EVALSHA_RO", Eval.INSTANCE);
        map.put("SCRIPT", KeepAllArgs.INSTANCE);
        map.put("CONFIG", commandAndNumArgs2);
        String[] strArr6 = new String[25];
        strArr6[0] = "ACL";
        strArr6[z2 ? 1 : 0] = "BGREWRITEAOF";
        strArr6[2] = "BGSAVE";
        strArr6[c4] = "COMMAND";
        strArr6[4] = "DBSIZE";
        strArr6[5] = "DEBUG";
        strArr6[6] = "FLUSHALL";
        strArr6[7] = "FLUSHDB";
        strArr6[8] = "INFO";
        strArr6[9] = "LASTSAVE";
        strArr6[c3] = "LATENCY";
        strArr6[11] = "LOLWUT";
        strArr6[12] = "MEMORY";
        strArr6[13] = "MODULE";
        strArr6[14] = "MONITOR";
        strArr6[15] = "PSYNC";
        strArr6[16] = "REPLICAOF";
        strArr6[17] = "ROLE";
        strArr6[18] = "SAVE";
        strArr6[19] = "SHUTDOWN";
        strArr6[20] = "SLAVEOF";
        strArr6[21] = "SLOWLOG";
        strArr6[22] = "SWAPDB";
        strArr6[23] = "SYNC";
        strArr6[24] = "TIME";
        Iterator it9 = Arrays.asList(strArr6).iterator();
        while (it9.hasNext()) {
            map.put((String) it9.next(), KeepAllArgs.INSTANCE);
        }
        map.put("SADD", commandAndNumArgs);
        map.put("SISMEMBER", commandAndNumArgs);
        map.put("SMISMEMBER", commandAndNumArgs);
        map.put("SMOVE", commandAndNumArgs2);
        map.put("SREM", commandAndNumArgs);
        String[] strArr7 = new String[12];
        strArr7[0] = "SCARD";
        strArr7[z2 ? 1 : 0] = "SDIFF";
        strArr7[2] = "SDIFFSTORE";
        strArr7[c4] = "SINTER";
        strArr7[4] = "SINTERCARD";
        strArr7[5] = "SINTERSTORE";
        strArr7[6] = "SMEMBERS";
        strArr7[7] = "SPOP";
        strArr7[8] = "SRANDMEMBER";
        strArr7[9] = "SSCAN";
        strArr7[c3] = "SUNION";
        strArr7[11] = "SUNIONSTORE";
        Iterator it10 = Arrays.asList(strArr7).iterator();
        while (it10.hasNext()) {
            map.put((String) it10.next(), KeepAllArgs.INSTANCE);
        }
        map.put("ZADD", commandAndNumArgs);
        map.put("ZCOUNT", commandAndNumArgs);
        map.put("ZINCRBY", commandAndNumArgs);
        map.put("ZLEXCOUNT", commandAndNumArgs);
        map.put("ZMSCORE", commandAndNumArgs);
        map.put("ZRANGEBYLEX", commandAndNumArgs);
        map.put("ZRANGEBYSCORE", commandAndNumArgs);
        map.put("ZRANK", commandAndNumArgs);
        map.put("ZREM", commandAndNumArgs);
        map.put("ZREMRANGEBYLEX", commandAndNumArgs);
        map.put("ZREMRANGEBYSCORE", commandAndNumArgs);
        map.put("ZREVRANGEBYLEX", commandAndNumArgs);
        map.put("ZREVRANGEBYSCORE", commandAndNumArgs);
        map.put("ZREVRANK", commandAndNumArgs);
        map.put("ZSCORE", commandAndNumArgs);
        String[] strArr8 = new String[20];
        strArr8[0] = "BZMPOP";
        strArr8[z2 ? 1 : 0] = "BZPOPMAX";
        strArr8[2] = "BZPOPMIN";
        strArr8[c4] = "ZCARD";
        strArr8[4] = "ZDIFF";
        strArr8[5] = "ZDIFFSTORE";
        strArr8[6] = "ZINTER";
        strArr8[7] = "ZINTERCARD";
        strArr8[8] = "ZINTERSTORE";
        strArr8[9] = "ZMPOP";
        strArr8[c3] = "ZPOPMAX";
        strArr8[11] = "ZPOPMIN";
        strArr8[12] = "ZRANDMEMBER";
        strArr8[13] = "ZRANGE";
        strArr8[14] = "ZRANGESTORE";
        strArr8[15] = "ZREMRANGEBYRANK";
        strArr8[16] = "ZREVRANGE";
        strArr8[17] = "ZSCAN";
        strArr8[18] = "ZUNION";
        strArr8[19] = "ZUNIONSTORE";
        Iterator it11 = Arrays.asList(strArr8).iterator();
        while (it11.hasNext()) {
            map.put((String) it11.next(), KeepAllArgs.INSTANCE);
        }
        map.put("XADD", new MultiKeyValue(2));
        String[] strArr9 = new String[13];
        strArr9[0] = "XACK";
        strArr9[z2 ? 1 : 0] = "XAUTOCLAIM";
        strArr9[2] = "XCLAIM";
        strArr9[c4] = "XDEL";
        strArr9[4] = "XGROUP";
        strArr9[5] = "XINFO";
        strArr9[6] = "XLEN";
        strArr9[7] = "XPENDING";
        strArr9[8] = "XRANGE";
        strArr9[9] = "XREAD";
        strArr9[c3] = "XREADGROUP";
        strArr9[11] = "XREVRANGE";
        strArr9[12] = "XTRIM";
        Iterator it12 = Arrays.asList(strArr9).iterator();
        while (it12.hasNext()) {
            map.put((String) it12.next(), KeepAllArgs.INSTANCE);
        }
        map.put("APPEND", commandAndNumArgs);
        map.put("GETSET", commandAndNumArgs);
        map.put("MSET", multiKeyValue2);
        map.put("MSETNX", multiKeyValue2);
        map.put("PSETEX", commandAndNumArgs2);
        map.put("SET", commandAndNumArgs);
        map.put("SETEX", commandAndNumArgs2);
        map.put("SETNX", commandAndNumArgs);
        map.put("SETRANGE", commandAndNumArgs);
        String[] strArr10 = new String[20];
        strArr10[0] = "BITCOUNT";
        strArr10[z2 ? 1 : 0] = "BITFIELD";
        strArr10[2] = "BITFIELD_RO";
        strArr10[c4] = "BITOP";
        strArr10[4] = "BITPOS";
        strArr10[5] = "DECR";
        strArr10[6] = "DECRBY";
        strArr10[7] = "GET";
        strArr10[8] = "GETBIT";
        strArr10[9] = "GETDEL";
        strArr10[c3] = "GETEX";
        strArr10[11] = "GETRANGE";
        strArr10[12] = "INCR";
        strArr10[13] = "INCRBY";
        strArr10[14] = "INCRBYFLOAT";
        strArr10[15] = "LCS";
        strArr10[16] = "MGET";
        strArr10[17] = "SETBIT";
        strArr10[18] = "STRALGO";
        strArr10[19] = "STRLEN";
        Iterator it13 = Arrays.asList(strArr10).iterator();
        while (it13.hasNext()) {
            map.put((String) it13.next(), KeepAllArgs.INSTANCE);
        }
        String[] strArr11 = new String[5];
        strArr11[0] = "DISCARD";
        strArr11[z2 ? 1 : 0] = "EXEC";
        strArr11[2] = "MULTI";
        strArr11[c4] = "UNWATCH";
        strArr11[4] = "WATCH";
        Iterator it14 = Arrays.asList(strArr11).iterator();
        while (it14.hasNext()) {
            map.put((String) it14.next(), KeepAllArgs.INSTANCE);
        }
        SANITIZERS = Collections.unmodifiableMap(map);
    }

    public static RedisCommandSanitizer create(boolean z) {
        return new RedisCommandSanitizer(z);
    }

    private RedisCommandSanitizer(boolean z) {
        this.statementSanitizationEnabled = z;
    }

    public String sanitize(String str, List<?> list) {
        if (!this.statementSanitizationEnabled) {
            return KeepAllArgs.INSTANCE.sanitize(str, list);
        }
        return SANITIZERS.getOrDefault(str.toUpperCase(Locale.ROOT), DEFAULT).sanitize(str, list);
    }

    enum KeepAllArgs implements CommandSanitizer {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.db.RedisCommandSanitizer.CommandSanitizer
        public String sanitize(String str, List<?> list) {
            StringBuilder sb = new StringBuilder(str);
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                sb.append(" ").append(RedisCommandSanitizer.argToString(it.next()));
            }
            return sb.toString();
        }
    }

    static final class CommandAndNumArgs implements CommandSanitizer {
        private final int numOfArgsToKeep;

        CommandAndNumArgs(int i) {
            this.numOfArgsToKeep = i;
        }

        @Override // io.opentelemetry.instrumentation.api.db.RedisCommandSanitizer.CommandSanitizer
        public String sanitize(String str, List<?> list) {
            StringBuilder sb = new StringBuilder(str);
            for (int i = 0; i < this.numOfArgsToKeep && i < list.size(); i++) {
                sb.append(" ").append(RedisCommandSanitizer.argToString(list.get(i)));
            }
            for (int i2 = this.numOfArgsToKeep; i2 < list.size(); i2++) {
                sb.append(" ?");
            }
            return sb.toString();
        }
    }

    static final class MultiKeyValue implements CommandSanitizer {
        private final int numOfArgsBeforeKeyValue;

        MultiKeyValue(int i) {
            this.numOfArgsBeforeKeyValue = i;
        }

        @Override // io.opentelemetry.instrumentation.api.db.RedisCommandSanitizer.CommandSanitizer
        public String sanitize(String str, List<?> list) {
            StringBuilder sb = new StringBuilder(str);
            for (int i = 0; i < this.numOfArgsBeforeKeyValue && i < list.size(); i++) {
                sb.append(" ").append(RedisCommandSanitizer.argToString(list.get(i)));
            }
            for (int i2 = this.numOfArgsBeforeKeyValue; i2 < list.size(); i2 += 2) {
                sb.append(" ").append(RedisCommandSanitizer.argToString(list.get(i2))).append(" ?");
            }
            return sb.toString();
        }
    }

    enum Eval implements CommandSanitizer {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.db.RedisCommandSanitizer.CommandSanitizer
        public String sanitize(String str, List<?> list) {
            int i;
            StringBuilder sb = new StringBuilder(str);
            int i2 = 0;
            if (list.size() > 2) {
                try {
                    i = Integer.parseInt(RedisCommandSanitizer.argToString(list.get(1)));
                } catch (NumberFormatException unused) {
                    i = 0;
                }
            } else {
                i = 0;
            }
            while (i2 < i + 2 && i2 < list.size()) {
                sb.append(" ").append(RedisCommandSanitizer.argToString(list.get(i2)));
                i2++;
            }
            while (i2 < list.size()) {
                sb.append(" ?");
                i2++;
            }
            return sb.toString();
        }
    }

    static String argToString(Object obj) {
        if (obj instanceof byte[]) {
            return new String((byte[]) obj, StandardCharsets.UTF_8);
        }
        return String.valueOf(obj);
    }
}
