package nl.jovmit.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_notifications.*
import kotlin.LazyThreadSafetyMode.NONE

class Notifications : Fragment() {

    private val title by lazy(NONE) { arguments?.getString("title") ?: "" }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        notificationsFragmentLabel.text = title
        openNotificationDetailsButton.setOnClickListener {
            val action = NotificationsDirections.openNotificationDetailsAction()
            action.setNotificationId("Test")
            val navController = Navigation.findNavController(view)
            navController.navigate(action)
        }
    }
}