package ru.grigoreva.springserver.dao;

import org.springframework.stereotype.Component;
import ru.grigoreva.springserver.models.Message;
import ru.grigoreva.springserver.models.Request;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component //Для создания bean  и внедрения его в Controller
public class ClientResponseDAO {
    //  @Autowired
    // private final Response response;

    // public ClientResponseDAO(Response response) {
    //      this.response = response;
    //  }


    public Message getResponseMessage(Request request) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        return new Message("Бла - бла " + request.getUser().getSurname() + " " + request.getUser().getName() + " ", dateFormat.format(date));


    }
}