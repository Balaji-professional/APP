public class FoodDeliveryTasks {
    private static Thread createTask(String name, int priority, String activity) {
        Thread task = new Thread(() -> {
            for (int update = 1; update <= 3; update++) {
                System.out.println(Thread.currentThread().getName() + " | Priority: "
                        + Thread.currentThread().getPriority() + " | " + activity
                        + " (update " + update + ")");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }, name);
        task.setPriority(priority);
        return task;
    }

    public static void main(String[] args) {
        Thread orderProcessing = createTask("OrderProcessing", Thread.MAX_PRIORITY,
                "Processing customer orders");
        Thread deliveryTracking = createTask("DeliveryTracking", Thread.NORM_PRIORITY,
                "Tracking delivery locations");
        Thread notification = createTask("Notification", Thread.MIN_PRIORITY,
                "Sending order-status notifications");

        orderProcessing.start();
        deliveryTracking.start();
        notification.start();
    }
}