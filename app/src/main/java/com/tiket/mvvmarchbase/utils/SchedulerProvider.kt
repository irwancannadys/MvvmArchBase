package com.tiket.mvvmarchbase.utils

import io.reactivex.Scheduler

/**
 * Created by Steve on 16/05/18.
 */
interface SchedulerProvider {
    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}
