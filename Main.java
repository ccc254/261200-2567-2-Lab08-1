import java.util.Random;
public class Main {
    private static void print(int threadNum) {
        Random rand = new Random();
        for (int i = 1; i <= 50; i++) {
            System.out.println("thread #<" + threadNum + ">: <" + i + ">");
            try {
                Thread.sleep(rand.nextInt(10000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> print(1));
        Thread t2 = new Thread(() -> print(2));
        Thread t3 = new Thread(() -> print(3));

        t1.start();
        t2.start();
        t3.start();
    }
    // TODO ก่อนเติม Thread.sleep();
    // รันแบบไม่สนลำดับ แม้ Thread ยังนับ 1 ไม่ครบทุกตัว สามารถข้ามไปนับ2หรือเลขถัดๆไปก่อนได้
    // ทำงานเร็วมากๆ

    // TODO หลังเติม Thread.sleep();
    // รันแบบไม่สนลำดับ แม้ Thread ยังนับ 1 ไม่ครบทุกตัว สามารถข้ามไปนับ2หรือเลขถัดๆไปก่อนได้
    // มีการ sleep แบบสุ่ม ทำให้มีการทำงานช้ากว่าแบบไม่ใส่ Thread.sleep() และทำให้ Thread บางตัว sleep นานกว่าตัวอื่น ทำให้ทำงานช้า
}
