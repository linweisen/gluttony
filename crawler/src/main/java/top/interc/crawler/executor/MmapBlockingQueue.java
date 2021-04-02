package top.interc.crawler.executor;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mapdb.Serializer;
import top.interc.crawler.controller.CrawlerConfig;
import top.interc.crawler.storage.EmbeddedQueue;
import top.interc.crawler.storage.PreCrawlUrlQueue;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：linweisen
 * @date ：Created in 2021/4/2 11:40
 * @description：${description}
 * @modified By：
 * @version: 1.0
 */
public class MmapBlockingQueue<E> extends AbstractQueue<E>
        implements BlockingQueue<E>, java.io.Serializable {

    private EmbeddedQueue<E> queues;

    private CrawlerConfig config;

    public MmapBlockingQueue(CrawlerConfig config, Serializer<E> serializer) {
        this.config = config;
        queues = new PreCrawlUrlQueue<>(config, serializer);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return queues.size();
    }

    public boolean add(E e) {
        return super.add(e);
    }

    @Override
    public void put(@NotNull E e) throws InterruptedException {
        checkNotNull(e);
        enqueue(e);

    }

    @Override
    public boolean offer(E e, long timeout, @NotNull TimeUnit unit) throws InterruptedException {
        checkNotNull(e);
        return enqueue(e);

    }

    @NotNull
    @Override
    public E take() throws InterruptedException {
        return null;
    }

    @Nullable
    @Override
    public E poll(long timeout, @NotNull TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public int remainingCapacity() {
        return -1;
    }

    @Override
    public int drainTo(@NotNull Collection<? super E> c) {
        return 0;
    }

    @Override
    public int drainTo(@NotNull Collection<? super E> c, int maxElements) {
        return 0;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    private boolean enqueue(E x) {
        return queues.put(x);
    }

    private static void checkNotNull(Object v) {
        if (v == null)
            throw new NullPointerException();
    }
}