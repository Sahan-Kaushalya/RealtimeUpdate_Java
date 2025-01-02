package Models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import javax.swing.Timer;

/**
 *
 * This class handles real-time updates for online users.
 *
 * It uses a Timer to periodically invoke a specified method.
 *
 *
 *
 * @author Yohan Silva
 *
 */
public class RealtimeUpdate {

    private Timer timer;

    /**
     *
     * Starts the timer to update online users.
     *
     *
     *
     * @param ok The method to be invoked every 5 seconds.
     *
     * @param target The object on which the method should be invoked.
     *
     */
    public void startOnlineUserUpdates(Method ok, Object target) {

        timer = new Timer(5000, new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                try {

                    // Invoke the method passed as a parameter
                    ok.invoke(target);

                } catch (Exception ex) {

                    ex.printStackTrace(); // Handle exceptions appropriately

                }

            }

        });

        timer.start();

    }

}
// We can access this model configuration
//-------------------------------------------------------
// private void startOnlineUserUpdates() {
//         rt = new RealtimeUpdate();

//         try {
//             // Get the method reference for onlineUser 
//             Method onlineUserMethod;
//             onlineUserMethod = AdminMainDash.class.getDeclaredMethod("onlineUser");
//             // Start online user updates
//             rt.startOnlineUserUpdates(onlineUserMethod, this);
//         } catch (NoSuchMethodException e) {
//             e.printStackTrace();
//         }
//     }  

