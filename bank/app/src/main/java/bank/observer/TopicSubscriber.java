package bank.observer;

public class TopicSubscriber implements Observer {
    private String name;
    private Subject topic;

    public TopicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        String message = (String) topic.getUpdate(this);
        if (message == null) {
            System.out.println(name + " No new message");
        } else {
            System.out.println(name + " Consuming message: " + message);
        }
    }

    @Override
    public void setSubject(Subject subject) {
        this.topic = subject;
    }
}
