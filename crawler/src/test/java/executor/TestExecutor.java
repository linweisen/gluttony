package executor;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import top.interc.crawler.controller.CrawlConfig;
import top.interc.crawler.executor.CrawlExecutor;
import top.interc.crawler.executor.CrawlTask;
import top.interc.crawler.executor.SimpleCrawlTask;


/**
 * @author ：linweisen
 * @date ：Created in 2021/4/2 20:24
 * @description：${description}
 * @modified By：
 * @version: 1.0
 */
public class TestExecutor {

    @Test
    public void test(){
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder("queue");
        config.setCrawlerNumber(1);
        CrawlExecutor executor = new CrawlExecutor(config, null);
        for(int i = 0; i < 10; i++){
            executor.execute(new SimpleCrawlTask(RandomStringUtils.randomAlphabetic(10), config));
        }
        try {
            Thread.sleep(3000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
