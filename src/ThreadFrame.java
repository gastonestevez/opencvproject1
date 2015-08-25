
public class ThreadFrame extends Thread{
	
	private Handler handler;
	
	public ThreadFrame(Handler h){
		handler = h;
	}
	
	@Override
    public void run() {
        for (;;){
            handler.getMenu().repaintAll();
//            try { 
//            	Thread.sleep(100);
//            } catch (InterruptedException e) {    }
        }
	}

}
