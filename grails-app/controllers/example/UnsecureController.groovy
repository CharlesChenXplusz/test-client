package example

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo

class UnsecureController {

    def exampleService

    def index() {
        render(view: 'unsecure')
    }

    @MessageMapping("/hello2")
    @SendTo("/topic/hello2")
    protected String hello(String world) {
        new Thread(new Runnable() {
            @Override
            void run() {
                exampleService.hello("2")
            }
        }).start()
        return "hello2 from controller, ${world}!"
    }
}
