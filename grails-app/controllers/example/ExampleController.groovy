package example

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo

/**
 * Created by charles.chen on 5/9/16.
 */
class ExampleController extends BaseController {

    def beforeInterceptor = [action: this.&auth]

    def exampleService

    def index() {
        render(view: 'example')
    }

    @MessageMapping("/hello")
    @SendTo("/topic/hello")
    protected String hello(String world) {
        return "hello from controller, ${world}!"
    }

}
