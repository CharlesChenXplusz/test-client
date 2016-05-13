package example

import org.springframework.context.annotation.Configuration
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.http.server.ServletServerHttpRequest
import org.springframework.messaging.simp.config.ChannelRegistration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.server.HandshakeHandler
import org.springframework.web.socket.server.HandshakeInterceptor

import javax.servlet.http.HttpSession

@Configuration
@EnableWebSocketMessageBroker
class UserWebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    final HandshakeHandler handler = new UserHandshakeHandler()

    final HandshakeInterceptor handshakeInterceptor = new HandshakeInterceptor() {
        @Override
        boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
            if (request instanceof ServletServerHttpRequest) {
                ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request
                HttpSession session = servletRequest.getServletRequest().getSession(false)
                if (!session || !session.token) {
                    return false
                }
            }

            true
        }

        @Override
        void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

        }
    }


    @Override
    void configureClientInboundChannel(ChannelRegistration cr) {
        cr.taskExecutor().corePoolSize(5).maxPoolSize(10)
    }

    @Override
    void configureClientOutboundChannel(ChannelRegistration cr) {
        cr.taskExecutor().corePoolSize(5).maxPoolSize(10)
    }

    @Override
    void configureMessageBroker(MessageBrokerRegistry mbr) {
        mbr.enableSimpleBroker("/queue", "/topic")
        mbr.setApplicationDestinationPrefixes('/app')
        mbr.setUserDestinationPrefix 'user'
    }

    @Override
    void registerStompEndpoints(StompEndpointRegistry ser) {
        for (String[] endpoint in [["/stomp"]]) {
//            ser.addEndpoint(endpoint).setHandshakeHandler(new UserHandshakeHandler()).withSockJS()
            ser.addEndpoint(endpoint).withSockJS().setInterceptors(handshakeInterceptor)
        }
    }

}
