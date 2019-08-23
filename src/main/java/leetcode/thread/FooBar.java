package leetcode.thread;

/**
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 * 请设计修改程序，以确保 “foobar” 被输出 n 次。
 */
public class FooBar {
  private int n;

  public FooBar(int n) {
    this.n = n;
  }

  private Object object=new Object();
  private static volatile  int count=0;

  public void foo(Runnable printFoo) throws InterruptedException {

    for (int i = 0; i < n; i++) {

      synchronized (object){
        if(count%2==1){
          object.wait();
        }

        // printFoo.run() outputs "foo". Do not change or remove this line.
        printFoo.run();
        count++;
        object.notify();
      }

    }
  }

  public void bar(Runnable printBar) throws InterruptedException {

    for (int i = 0; i < n; i++) {
      synchronized (object) {
        if (count % 2 == 0) {
          object.wait();
        }

        // printBar.run() outputs "bar". Do not change or remove this line.
        printBar.run();
        count++;
        object.notify();
      }

    }
  }
}
