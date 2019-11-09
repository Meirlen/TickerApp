package kz.ticker.android.ext

import androidx.annotation.IdRes
import com.google.android.material.snackbar.Snackbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import android.view.View
import android.widget.Toast


inline fun androidx.fragment.app.FragmentManager.replaceOnce(
    @IdRes containerViewId: Int,
    fragmentTag: String,
    body: () -> androidx.fragment.app.Fragment,
    withBackStack: Boolean = false
): androidx.fragment.app.FragmentTransaction {

    val transaction = this.beginTransaction()
    val fragment = this.findFragmentByTag(fragmentTag)
    if (fragment == null) {
        transaction.replace(containerViewId, body(), fragmentTag)
        if (withBackStack) {
            transaction.addToBackStack(fragmentTag)
        }
    }
    return transaction

}

inline fun androidx.fragment.app.FragmentManager.replaceByTag(
    @IdRes containerViewId: Int,
    fragmentTag: String,
    body: () -> androidx.fragment.app.Fragment,
    withBackStack: Boolean = true
): androidx.fragment.app.FragmentTransaction {

    val transaction = this.beginTransaction()
    val fragment = this.findFragmentByTag(fragmentTag)
    if (fragment != null) {
        transaction.replace(containerViewId, fragment, fragmentTag)
    } else {
        transaction.replace(containerViewId, body(), fragmentTag)
    }
    if (withBackStack) {
        transaction.addToBackStack(fragmentTag)
    }
    return transaction
}

fun androidx.fragment.app.Fragment.toast(message: String) =
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()


fun androidx.fragment.app.Fragment.snacbar(view: View, message: String) = com.google.android.material.snackbar.Snackbar.make(
    view,
    message,
    com.google.android.material.snackbar.Snackbar.LENGTH_LONG
).show()