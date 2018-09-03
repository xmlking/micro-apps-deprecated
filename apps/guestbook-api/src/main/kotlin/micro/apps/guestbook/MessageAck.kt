package micro.apps.guestbook

data class MessageAck(val id: String, val received: String, val ack: String)
