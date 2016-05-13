package example

/**
 * Created by charles.chen on 5/10/16.
 */
class BaseController {
    protected auth() {
        if (!session.token) {
            redirect(uri: "/login")
            return false
        }
    }
}
