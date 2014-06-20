package exposed;


import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import scala.Serializable;

import java.util.Date;

/**
 * Author: Osman Baskaya
 * E-mail: obaskaya@ku.edu.tr
 * Date: 18.Jun.2014 | 16:04
 */
public class Message implements Serializable {

    private final String message;
    public Message(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;

    }


}
