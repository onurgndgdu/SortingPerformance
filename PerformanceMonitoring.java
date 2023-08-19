import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
public class PerformanceMonitoring {
    public static void main(String[] args) {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        System.out.println("CPU Usage: " + operatingSystemMXBean.getSystemLoadAverage());
    }
}
