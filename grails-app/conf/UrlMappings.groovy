class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/index")
        "500"(view: '/error')

        "/login"(controller: 'login', action: 'index', method: 'GET')
        "/login"(controller: 'login', action: 'doLogin', method: 'POST')
        "/message"(controller: 'message', action: 'index', method: 'GET')
        "/message/broadcast"(controller: 'message', action: 'broadcast', method: 'GET')
    }
}
