package micro.apps.guestbook

data class Message(var id: String?, val payload: String, val delay: Long)
