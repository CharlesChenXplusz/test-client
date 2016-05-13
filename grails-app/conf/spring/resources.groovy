import grails.plugin.springwebsocket.GrailsSimpAnnotationMethodMessageHandler

// Place your Spring DSL code here
beans = {
    webSocketConfig example.UserWebSocketConfig

    grailsSimpAnnotationMethodMessageHandler(
            GrailsSimpAnnotationMethodMessageHandler,
            ref("clientInboundChannel"),
            ref("clientOutboundChannel"),
            ref("brokerMessagingTemplate")
    ) {
        destinationPrefixes = ["/app"]
    }
}
