package example

class LoginController {

    def index() {
        render(view: 'login')
    }

    def doLogin() {
        def username = params.username
        def password = params.passwrod


        //Mock login from api
        if ("usera".equalsIgnoreCase(username)) {
            session.token = '111'
            redirect(uri: '/example')
        } else if ("userb".equalsIgnoreCase(username)) {
            session.token = '222'
            redirect(uri: '/example')
        } else {
            redirect(uri: '/login')
        }
    }
}
