package example

import org.springframework.http.HttpStatus
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.http.server.ServletServerHttpRequest
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.server.HandshakeFailureException
import org.springframework.web.socket.server.HandshakeHandler
import org.springframework.web.socket.server.support.DefaultHandshakeHandler

import javax.servlet.http.HttpSession

/**
 * Created by charles.chen on 5/13/16.
 */
class UserHandshakeHandler implements HandshakeHandler {

    @Override
    boolean doHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws HandshakeFailureException {
        ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
        HttpSession session = servletRequest.getServletRequest().getSession(false);
        println session?.token
        if (!session || !session.token) {
            response.setStatusCode(HttpStatus.FORBIDDEN)
            return false
        }
        new DefaultHandshakeHandler().doHandshake(request, response, wsHandler, attributes)
    }
}
