package adopet.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class EnviarEmailService {

    private JavaMailSender emailSender;

    public EnviarEmailService(JavaMailSender javaMailSender){
        this.emailSender = javaMailSender;
    }

    @Async
    public void enviarEmail(String para, String assunto, String mensagem){
        SimpleMailMessage email = new SimpleMailMessage();

        email.setTo(para);
        email.setSubject(assunto);
        email.setText(mensagem);

        emailSender.send(email);
    }
}
