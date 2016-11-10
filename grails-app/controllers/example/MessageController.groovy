package example

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo

/**
 * Created by charles.chen on 5/9/16.
 */
class MessageController extends BaseController {

    def beforeInterceptor = [action: this.&auth]

    def index() {
        render(view: 'message')
    }

    @MessageMapping("/hello")
    @SendTo("/topic/hello")
    protected String reply(String world) {
        return "hello from controller, ${world}!"
    }

}
