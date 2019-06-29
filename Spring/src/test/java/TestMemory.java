import java.util.ArrayList;
import java.util.List;

public class TestMemory {

    public byte[] b1 = new byte[1024 * 1024];

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread start");
        Thread.sleep(10000);
        allocate(10000);
    }

    public static void allocate(int n) {
        List<TestMemory> jconsoleVmList = new ArrayList<TestMemory>();
        for (int i = 0; i < n; i++) {
            try {
                System.out.println("sleep"+ i);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("create TestMemory");
            jconsoleVmList.add(new TestMemory());
        }
    }

}
