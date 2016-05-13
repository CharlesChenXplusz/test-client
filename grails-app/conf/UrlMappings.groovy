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
        "/example"(controller: 'example', action: 'index', method: 'GET')
        "/unsecure"(controller: 'unsecure', action: 'index', method: 'GET')
    }
}
