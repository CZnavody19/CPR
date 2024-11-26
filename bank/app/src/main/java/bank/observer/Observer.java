package bank.observer;

public interface Observer {
    void update();

    void setSubject(Subject subject);
}
