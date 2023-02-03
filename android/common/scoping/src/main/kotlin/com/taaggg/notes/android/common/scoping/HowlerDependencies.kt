package com.taaggg.notes.android.common.scoping

import com.squareup.anvil.annotations.ContributesTo
import so.howl.common.storekit.entities.howler.output.Howlers
import so.howl.common.storekit.repository.HowlerRepository

@ContributesTo(HowlerScope::class)
interface HowlerDependencies {
    val howlers: Howlers
    val howlerRepository: HowlerRepository
}