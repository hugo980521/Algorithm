package leetcode.thread;

public class Foo {

  private volatile boolean firstFininshed=false;
  private volatile boolean secondFininshed=false;
  private Object lock=new Object();

  public Foo() {
  }

  public void first(Runnable printFirst) throws InterruptedException {

    synchronized (lock){
      // printFirst.run() outputs "first". Do not change or remove this line.
      printFirst.run();
      firstFininshed=true;
      lock.notifyAll();
    }



  }

  public void second(Runnable printSecond) throws InterruptedException {

    synchronized (lock) {
      while (!firstFininshed) {
        lock.wait();
      }
      // printSecond.run() outputs "second". Do not change or remove this line.
      printSecond.run();
      secondFininshed=true;
      lock.notifyAll();
    }

  }

  public void third(Runnable printThird) throws InterruptedException {
    synchronized (lock){
      while (!secondFininshed){
        lock.wait();
      }
      // printThird.run() outputs "third". Do not change or remove this line.
      printThird.run();
    }

  }
}
