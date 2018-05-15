package nl.jovmit.navigation


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_notification_details.*
import kotlin.LazyThreadSafetyMode.NONE

class NotificationDetails : Fragment() {

    private val notificationId by lazy(NONE) { arguments?.getString(NOTIFICATION_ID) }

    companion object {

        private const val NOTIFICATION_ID = "notificationId"

        @JvmStatic
        fun newInstance(notificationId: String) = NotificationDetails().apply {
            arguments = Bundle().apply {
                putString(NOTIFICATION_ID, notificationId)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_notification_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        notificationDetailsLabel.text = notificationId
    }
}
