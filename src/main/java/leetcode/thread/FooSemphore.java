package leetcode.thread;

import java.util.concurrent.Semaphore;

public class FooSemphore {

  Semaphore a;
  Semaphore b;
  Semaphore c;
  public FooSemphore() {
    a=new Semaphore(1);
    b=new Semaphore(0);
    c=new Semaphore(0);
  }

  public void first(Runnable printFirst) throws InterruptedException {

      a.acquire();
      // printFirst.run() outputs "first". Do not change or remove this line.
      printFirst.run();
      b.release();

  }

  public void second(Runnable printSecond) throws InterruptedException {
      b.acquire();
      // printSecond.run() outputs "second". Do not change or remove this line.
      printSecond.run();
      c.release();

  }

  public void third(Runnable printThird) throws InterruptedException {
     c.acquire();
      // printThird.run() outputs "third". Do not change or remove this line.
      printThird.run();
     a.release();

  }

  public static void main(String[] args) throws Exception{
    Semaphore semaphore=new Semaphore(0);
    semaphore.acquire();
    semaphore.acquire();
    semaphore.acquire();
  }
}
