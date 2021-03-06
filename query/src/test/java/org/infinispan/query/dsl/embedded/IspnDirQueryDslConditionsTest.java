package org.infinispan.query.dsl.embedded;

import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.EmbeddedCacheManager;
import org.infinispan.test.fwk.CleanupAfterTest;
import org.infinispan.test.fwk.TestCacheManagerFactory;
import org.testng.annotations.Test;

/**
 * Tests the functionality of Query DSL for Infinispan directory provider.
 *
 * @author Anna Manukyan
 */
@Test(groups = "functional", testName = "query.dsl.embedded.IspnDirQueryDslConditionsTest")
@CleanupAfterTest
public class IspnDirQueryDslConditionsTest extends QueryDslConditionsTest {

   @Override
   protected EmbeddedCacheManager createCacheManager() throws Exception {
      ConfigurationBuilder defaultConfig = getDefaultStandaloneCacheConfig(true);

      ConfigurationBuilder cfg = getDefaultStandaloneCacheConfig(true);
      cfg.indexing().enable()
            .addProperty("default.directory_provider", "infinispan")
            .addProperty("lucene_version", "LUCENE_48");
      cacheManager =  TestCacheManagerFactory.createCacheManager(defaultConfig);
      cacheManager.defineConfiguration("custom", cfg.build());

      cache = cacheManager.getCache("custom");
      return cacheManager;
   }

}
