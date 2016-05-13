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

    @MessageMapping("/hello1")
    @SendTo("/topic/hello1")
    protected String hello(String world) {
        new Thread(new Runnable() {
            @Override
            void run() {
                exampleService.hello()
            }
        }).start()
        return "hello from controller, ${world}!"
    }
}
