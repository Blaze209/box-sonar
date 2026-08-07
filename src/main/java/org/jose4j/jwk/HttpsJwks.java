package org.jose4j.jwk;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.lang3.time.TimeZones;
import org.jose4j.http.Get;
import org.jose4j.http.SimpleGet;
import org.jose4j.http.SimpleResponse;
import org.jose4j.lang.ExceptionHelp;
import org.jose4j.lang.JoseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class HttpsJwks {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) HttpsJwks.class);
    private final String location;
    private volatile long defaultCacheDuration = 3600;
    private volatile SimpleGet simpleHttpGet = new Get();
    private volatile long retainCacheOnErrorDurationMills = 0;
    private volatile Cache cache = new Cache(Collections.emptyList(), 0);
    private final ReentrantLock refreshLock = new ReentrantLock();
    private long refreshReprieveThreshold = 300;

    public HttpsJwks(String str) {
        this.location = str;
    }

    public void setDefaultCacheDuration(long j) {
        this.defaultCacheDuration = j;
    }

    public void setRetainCacheOnErrorDuration(long j) {
        this.retainCacheOnErrorDurationMills = j * 1000;
    }

    public void setSimpleHttpGet(SimpleGet simpleGet) {
        this.simpleHttpGet = simpleGet;
    }

    public String getLocation() {
        return this.location;
    }

    public void setRefreshReprieveThreshold(long j) {
        this.refreshReprieveThreshold = j;
    }

    public List<JsonWebKey> getJsonWebKeys() throws IOException, JoseException {
        Cache cache;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Cache cache2 = this.cache;
        if (cache2.exp <= jCurrentTimeMillis) {
            if (!this.refreshLock.tryLock()) {
                if (cache2.keys.isEmpty()) {
                    this.refreshLock.lock();
                } else {
                    return cache2.keys;
                }
            }
            try {
                try {
                    refresh();
                    cache = this.cache;
                    this.refreshLock.unlock();
                } catch (Exception e) {
                    if (this.retainCacheOnErrorDurationMills > 0 && !cache2.keys.isEmpty()) {
                        Cache cache3 = new Cache(cache2.keys, jCurrentTimeMillis + this.retainCacheOnErrorDurationMills);
                        this.cache = cache3;
                        log.info("Because of {} unable to refresh JWKS content from {} so will continue to use cached keys for more {} seconds until about {} -> {}", ExceptionHelp.toStringWithCauses(e), this.location, Long.valueOf(this.retainCacheOnErrorDurationMills / 1000), new Date(cache3.exp), cache3.keys);
                        this.refreshLock.unlock();
                        cache = cache3;
                    } else {
                        throw e;
                    }
                }
                return cache.keys;
            } catch (Throwable th) {
                this.refreshLock.unlock();
                throw th;
            }
        }
        return cache2.keys;
    }

    public void refresh() throws IOException, JoseException {
        this.refreshLock.lock();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.cache.created;
            if (jCurrentTimeMillis < this.refreshReprieveThreshold && !this.cache.keys.isEmpty()) {
                log.debug("NOT refreshing/loading JWKS from {} because it just happened {} mills ago", this.location, Long.valueOf(jCurrentTimeMillis));
            } else {
                Logger logger = log;
                logger.debug("Refreshing/loading JWKS from {}", this.location);
                SimpleResponse simpleResponse = this.simpleHttpGet.get(this.location);
                List<JsonWebKey> jsonWebKeys = new JsonWebKeySet(simpleResponse.getBody()).getJsonWebKeys();
                long cacheLife = getCacheLife(simpleResponse);
                if (cacheLife <= 0) {
                    logger.debug("Will use default cache duration of {} seconds for content from {}", Long.valueOf(this.defaultCacheDuration), this.location);
                    cacheLife = this.defaultCacheDuration;
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis() + (1000 * cacheLife);
                logger.debug("Updated JWKS content from {} will be cached for {} seconds until about {} -> {}", this.location, Long.valueOf(cacheLife), new Date(jCurrentTimeMillis2), jsonWebKeys);
                this.cache = new Cache(jsonWebKeys, jCurrentTimeMillis2);
            }
        } finally {
            this.refreshLock.unlock();
        }
    }

    static long getDateHeaderValue(SimpleResponse simpleResponse, String str, long j) {
        Iterator<String> it = getHeaderValues(simpleResponse, str).iterator();
        while (it.hasNext()) {
            String next = it.next();
            try {
                if (!next.endsWith(TimeZones.GMT_ID)) {
                    next = next + " GMT";
                }
                return Date.parse(next);
            } catch (Exception unused) {
            }
        }
        return j;
    }

    private static List<String> getHeaderValues(SimpleResponse simpleResponse, String str) {
        List<String> headerValues = simpleResponse.getHeaderValues(str);
        return headerValues == null ? Collections.emptyList() : headerValues;
    }

    static long getExpires(SimpleResponse simpleResponse) {
        return getDateHeaderValue(simpleResponse, "expires", 0L);
    }

    static long getCacheLife(SimpleResponse simpleResponse) {
        return getCacheLife(simpleResponse, System.currentTimeMillis());
    }

    static long getCacheLife(SimpleResponse simpleResponse, long j) {
        String lowerCase;
        long expires = (getExpires(simpleResponse) - j) / 1000;
        for (String str : getHeaderValues(simpleResponse, "cache-control")) {
            if (str == null) {
                lowerCase = "";
            } else {
                try {
                    lowerCase = str.toLowerCase();
                } catch (Exception unused) {
                }
            }
            int iIndexOf = lowerCase.indexOf("max-age");
            int iIndexOf2 = lowerCase.indexOf(44, iIndexOf);
            if (iIndexOf2 == -1) {
                iIndexOf2 = lowerCase.length();
            }
            String strSubstring = lowerCase.substring(iIndexOf, iIndexOf2);
            expires = Long.parseLong(strSubstring.substring(strSubstring.indexOf(61) + 1).trim());
        }
        return expires;
    }

    private static class Cache {
        private final long created;
        private final long exp;
        private final List<JsonWebKey> keys;

        private Cache(List<JsonWebKey> list, long j) {
            this.created = System.currentTimeMillis();
            this.keys = list;
            this.exp = j;
        }
    }
}
