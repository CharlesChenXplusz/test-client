package example

class LoginController {

    def index() {
        render(view: 'login')
    }

    def doLogin() {
        def username = params.username

        //Mock login from api
        if ("usera".equalsIgnoreCase(username)) {
            session.token = '111'
            redirect(uri: '/message')
        } else if ("userb".equalsIgnoreCase(username)) {
            session.token = '222'
            redirect(uri: '/message')
        } else {
            redirect(uri: '/login')
        }
    }
}
