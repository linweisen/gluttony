package top.interc.crawler.parser;

import java.util.List;

/**
 * @author ：linweisen
 * @date ：Created in 2021/4/8 10:13
 * @description：${description}
 * @modified By：
 * @version: 1.0
 */
public interface CrawlRule {

    List<String> getNextUrls();
}