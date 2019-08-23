package leetcode.thread;

/**
 * 现在有两种线程，氢 oxygen 和氧 hydrogen，你的目标是组织这两种线程来产生水分子。
 * <p>
 * 存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。
 * <p>
 * 氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。
 * <p>
 * 这些线程应该三三成组突破屏障并能立即组合产生一个水分子。
 * <p>
 * 你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。
 * <p>
 * 换句话说:
 * <p>
 * 如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。
 * 如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。
 * 书写满足这些限制条件的氢、氧线程同步代码。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/building-h2o
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


import java.util.concurrent.Semaphore;

public class H2O {

  private Semaphore semaph1, semaph2, semaph3, semaph4;

  public H2O() {
    //用于保证输出两个H和一个O
    semaph1 = new Semaphore(2); // H线程信号量
    semaph2 = new Semaphore(1);  // O线程信号量

    //用于确认一次完整的打印是否已经完成
    semaph3 = new Semaphore(0);
    semaph4 = new Semaphore(0);
  }

  public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    semaph1.acquire();  //等待H原子释放
    semaph3.release();  // H原子释放完毕信号
    semaph4.acquire();  // 等待O原子释放H信号
    // releaseHydrogen.run() outputs "H". Do not change or remove this line.
    releaseHydrogen.run();
    semaph1.release();

  }

  public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    semaph2.acquire();
    semaph3.acquire(2); //等待H原子释放完毕信号
    semaph4.release(2); //释放两个H原子
    // releaseOxygen.run() outputs "O". Do not change or remove this line.
    releaseOxygen.run();
    semaph2.release();
  }
}

