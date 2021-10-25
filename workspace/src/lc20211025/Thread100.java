package lc20211025;

//两个线程交替打印1-100
public class Thread100 implements Runnable{
	int i = 1;
	//测试方法
	public static void main(String[] args){
		//创建线程对象
		Thread100 t = new Thread100();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		while(true){
			synchronized(this){
				notify();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(i <= 100){
					//Thread.currentThread()获得当前线程对象
					System.out.println(Thread.currentThread().getName()+":"+i);
					i++;
					//打印完之后就等待被另一个线程唤醒
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
