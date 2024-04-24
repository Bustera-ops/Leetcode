package org.example.mianshiTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class printHow {
    static int threadNum = 3;
    static Condition[] conditions = new Condition[threadNum];
    static ReentrantLock lock = new ReentrantLock();
    static {
        for (int i = 0; i < conditions.length; i++) conditions[i] = lock.newCondition();
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(()->{
            int id = Integer.parseInt(Thread.currentThread().getName());
            lock.lock();
            try {
                while (true){
                    conditions[id].await();
                    System.out.print("H");
                    conditions[id + 1].signal();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                lock.unlock();
            }
        },"0");

        Thread t1 = new Thread(()->{
            int id = Integer.parseInt(Thread.currentThread().getName());
            lock.lock();
            try {
                while (true){
                    conditions[id].await();
                    System.out.print("o");
                    conditions[id + 1].signal();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                lock.unlock();
            }
        },"1");

        Thread t2 = new Thread(()->{
            int id = Integer.parseInt(Thread.currentThread().getName());
            lock.lock();
            try {
                while (true){
                    conditions[id].await();
                    System.out.print("w");
                    System.out.println();
                    conditions[(id + 1) % threadNum].signal();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                lock.unlock();
            }
        },"2");

        t0.start();
        t1.start();
        t2.start();

        Thread.sleep(1000);
        lock.lock();
        try {
            conditions[0].signal(); // 先唤醒第一个线程
        } finally {
            lock.unlock();
        }
    }
}
