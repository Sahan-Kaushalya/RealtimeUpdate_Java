
# RealtimeUpdate Class Documentation

## Overview
The `RealtimeUpdate` class enables real-time updates for online users in a Java Swing application. It achieves this by using a `javax.swing.Timer` to periodically invoke a specified method on a target object. This is useful for tasks such as monitoring online users, refreshing data, or triggering periodic actions.

## Features
- **Real-Time Execution**: Invokes a specified method every 5 seconds.
- **Configurable Target**: Allows specifying the method and object to be invoked.
- **Exception Handling**: Handles and prints exceptions that occur during method invocation.

---

## Class: `RealtimeUpdate`

### Fields
- **`private Timer timer`**: The Swing Timer used to schedule periodic actions.

### Methods

#### `startOnlineUserUpdates(Method ok, Object target)`
Starts the timer to periodically invoke the specified method on the target object.

**Parameters:**
- `Method ok`: The method to be invoked every 5 seconds.
- `Object target`: The object on which the specified method will be invoked.

**Implementation Details:**
- Creates a `Timer` with a delay of 5000 milliseconds (5 seconds).
- Registers an `ActionListener` to the timer that invokes the specified method using Java Reflection.
- Starts the timer.

**Example Usage:**
```java
private void startOnlineUserUpdates() {
    RealtimeUpdate rt = new RealtimeUpdate();

    try {
        // Get the method reference for onlineUser
        Method onlineUserMethod = AdminMainDash.class.getDeclaredMethod("onlineUser");
        // Start online user updates
        rt.startOnlineUserUpdates(onlineUserMethod, this);
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    }
}
```

---

## Usage Example
The following example demonstrates how to integrate the `RealtimeUpdate` class into a project:

### Step 1: Define the Method to be Invoked
Ensure the method you want to invoke is defined in the target class. For example:
```java
public void onlineUser() {
    System.out.println("Updating online users...");
}
```

### Step 2: Instantiate and Configure `RealtimeUpdate`
Call the `startOnlineUserUpdates` method with the appropriate method and target object:
```java
RealtimeUpdate rt = new RealtimeUpdate();

try {
    // Get the method reference
    Method onlineUserMethod = YourClassName.class.getDeclaredMethod("onlineUser");
    // Start updates
    rt.startOnlineUserUpdates(onlineUserMethod, yourObjectInstance);
} catch (NoSuchMethodException e) {
    e.printStackTrace();
}
```

---

## Notes
- **Reflection**: This class uses Java Reflection (`java.lang.reflect.Method`) to invoke methods. Ensure the specified method is accessible and declared correctly.
- **Thread Safety**: The `javax.swing.Timer` executes actions on the Event Dispatch Thread (EDT). Avoid performing long-running tasks directly in the invoked method.
- **Error Handling**: Exceptions during method invocation are caught and printed. Consider enhancing the exception handling mechanism for production use.

---

## Contributors

Thanks to the following people for their contributions:

<table>
  <tr>
     <td align="center">
      <a href="https://github.com/Yohan3128">
        <img src="https://avatars.githubusercontent.com/Yohan3128" width="100px;" alt="Yohan Silva"/>
        <br />
        <sub style="text-decoration: none;"><b>Yohan Silva</b></sub>
      </a>
      <br />syncx.lk
    </td>
      <td align="center">
      <a href="https://github.com/Sahan-Kaushalya">
        <img src="https://avatars.githubusercontent.com/Sahan-Kaushalya" width="100px;" alt="Sahan Kaushalya"/>
        <br />
        <sub style="text-decoration: none;"><b>Sahan Kaushalya</b></sub>
      </a>
      <br />syncx.lk
    </td>
  </tr>
</table>

---

## License
Include appropriate licensing information here (e.g., MIT, Apache, etc.).
