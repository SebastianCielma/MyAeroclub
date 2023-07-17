package pl.sebastiancielma.MyAeroclub.common.mail;

public interface EmailSender {
    void send(String to, String subject, String msg);
}
