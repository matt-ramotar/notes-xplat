package com.taaggg.notes.android.app

import android.app.Activity
import android.app.Application
import com.squareup.anvil.annotations.ContributesBinding
import com.taaggg.notes.android.app.wiring.AppComponent
import com.taaggg.notes.android.app.wiring.AppDependencies
import com.taaggg.notes.android.app.wiring.DaggerAppComponent
import com.taaggg.notes.android.app.wiring.UserComponent
import com.taaggg.notes.android.common.scoping.AppScope
import com.taaggg.notes.android.common.scoping.ComponentHolder
import com.taaggg.notes.android.common.scoping.SingleIn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SingleIn(AppScope::class)
@ContributesBinding(AppScope::class, boundType = Application::class)
class NotesApp : Application(), ComponentHolder {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    override lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        val application = this
        coroutineScope.launch {
            component = DaggerAppComponent.factory().create(
                application = application,
                applicationContext = applicationContext
            )
        }
    }
}

internal fun AppComponent.userComponentFactory() = (this as UserComponent.ParentBindings).userComponentFactory()
internal fun AppComponent.appDependencies() = this as AppDependencies
fun Activity.notesApp(): NotesApp = application as NotesApp
