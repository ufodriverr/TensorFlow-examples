package org.tensorflow.lite.examples.poseestimation
import android.util.Log
import io.socket.client.IO
import io.socket.client.Socket
import io.socket.client.SocketOptionBuilder
import java.net.URISyntaxException

object SocketHandler {

    lateinit var mSocket: Socket

    @Synchronized
    fun setSocket() {
        try {
// "http://10.0.2.2:3000" is the network your Android emulator must use to join the localhost network on your computer
// "http://localhost:3000/" will not work
// If you want to use your physical phone you could use your ip address plus :3000
// This will allow your Android Emulator and physical device at your home to connect to the server
            var builder = SocketOptionBuilder.builder();
            builder.setAuth(
                mapOf(
                    "token" to "!23#kk32!j43h%1",
                    "name" to "VI-GalaxyS7",
                    "type" to "sensor",
                    "pin" to ""
                )
            )
            builder.setReconnection(false);
            mSocket = IO.socket("http://192.168.77.135:3000", builder.build())
        } catch (e: URISyntaxException) {
            Log.d("Unity", e.toString())
        }
    }

    @Synchronized
    fun getSocket(): Socket {
        return mSocket
    }

    @Synchronized
    fun establishConnection() {
        Log.d("Unity","establishConnection");
        mSocket.connect()
    }

    @Synchronized
    fun closeConnection() {
        mSocket.disconnect()
    }
}