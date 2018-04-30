package countDownLatchM;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author Lenovo
 */
public class ControllThread extends Thread {

    private MFrame fra;
    private final CountDownLatch latch;

    public ControllThread(MFrame fra) {
        this.fra = fra;
        latch = new CountDownLatch(3);
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            new PrThread1To3(fra, i, latch).start();
        }
        new PrThread4(fra, latch).start();
    }

}
