package ru.grigoreva.springserver.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.grigoreva.springserver.dao.ClientResponseDAO;
import ru.grigoreva.springserver.models.Request;
import ru.grigoreva.springserver.models.Response;

@RestController
@RequestMapping("/api")
public class ClientMessageExchangeController {
    static Logger logger = Logger.getLogger(ClientMessageExchangeController.class.getName());


    private final ClientResponseDAO clientResponseDAO;

    @Autowired
    public ClientMessageExchangeController(ClientResponseDAO clientResponseDAO) {
        this.clientResponseDAO = clientResponseDAO;
    }

    @GetMapping("/getCheck")  //Возвращает страницу new.html  пользователю при переходе /userinfo/new, метод get
    public String newCheck() { //В контроллер внедряется модель данных User
        return "api/getCheck";
    }


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
            "application/vnd.example.todo_payload+json"})
    @ResponseBody
    public Response receiveMessages(@RequestBody Request request) {
        System.out.println("Ураа! Сообщение дошло" + request.getUser().getSurname());
        logger.info("Принято сообщение от клиента "
                + request.getUser().getName()
                + " " + request.getUser().getSurname() + ": "
                + request.getMessage().getBody() + ": "
                + request.getMessage().getTimestamp());

        return new Response(clientResponseDAO.getResponseMessage(request)); //передали json  ответе


    }

}
