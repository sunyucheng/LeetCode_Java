package lc20211025;

//�����߳̽����ӡ1-100
public class Thread100 implements Runnable{
	int i = 1;
	//���Է���
	public static void main(String[] args){
		//�����̶߳���
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
					//Thread.currentThread()��õ�ǰ�̶߳���
					System.out.println(Thread.currentThread().getName()+":"+i);
					i++;
					//��ӡ��֮��͵ȴ�����һ���̻߳���
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
