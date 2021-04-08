package top.interc.crawler.executor;

import top.interc.crawler.connect.HttpResult;
import top.interc.crawler.controller.CrawlConfig;

/**
 * @author ：linweisen
 * @date ：Created in 2021/4/6 17:02
 * @description：${description}
 * @modified By：
 * @version: 1.0
 */
public class SimpleCrawlTask extends CrawlTask {

    public SimpleCrawlTask(String url, CrawlConfig config) {
        super(url, config);
    }



    @Override
    public void save(HttpResult data) {
        System.out.println("保存...");
    }

    @Override
    public void filter(String url) {
        System.out.println("过滤...");
    }
}
