public class HospitalEmergencyMonitoring {
    private static class MonitoringTask extends Thread {
        private final String activity;

        MonitoringTask(String name, int priority, String activity) {
            super(name);
            this.activity = activity;
            setPriority(priority);
        }

        @Override
        public void run() {
            for (int check = 1; check <= 3; check++) {
                System.out.println(getName() + " | Priority: " + getPriority()
                        + " | " + activity + " (check " + check + ")");
            }
        }
    }

    public static void main(String[] args) {
        Thread emergencyAlert = new MonitoringTask("EmergencyAlert", Thread.MAX_PRIORITY,
                "Responding to critical patient alerts");
        Thread vitalMonitor = new MonitoringTask("VitalMonitor", Thread.NORM_PRIORITY,
                "Checking patient vital signs");
        Thread reportGenerator = new MonitoringTask("ReportGenerator", Thread.MIN_PRIORITY,
                "Preparing routine reports");

        emergencyAlert.start();
        vitalMonitor.start();
        reportGenerator.start();
    }
}