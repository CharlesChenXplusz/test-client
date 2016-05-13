package filters

class WebSocketFilterFilters {

    def filters = {
        webSocket(uri: '/stomp/info', uriExclude: '/|/login|/index.gsp', regex: true) {
            before = {
                if (!session.token) {
                    redirect(uri: '/login')
                    return false
                }

                return true
            }
        }

        denyFilter(uri: '/app/**') {
            before = {
                return false
            }
        }
    }
}
