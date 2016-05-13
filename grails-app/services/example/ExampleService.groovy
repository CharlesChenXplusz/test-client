package example
/**
 * Created by charles.chen on 5/9/16.
 */
class ExampleService {

    def brokerMessagingTemplate

    void hello(String flag = "1") {
        for (int i = 0; i < 20; ++i) {
            brokerMessagingTemplate.convertAndSend "/topic/hello${flag}".toString(), "hello${flag} from service ${i}!".toString()
            Thread.sleep(1000L)
        }
    }

}
