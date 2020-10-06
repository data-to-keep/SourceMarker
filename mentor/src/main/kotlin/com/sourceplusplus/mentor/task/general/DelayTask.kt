package com.sourceplusplus.mentor.task.general

import com.sourceplusplus.mentor.MentorJob
import com.sourceplusplus.mentor.MentorTask
import io.vertx.core.Future
import io.vertx.core.Promise
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * todo: description.
 *
 * @since 0.0.1
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class DelayTask(private val delay: Long) : MentorTask(true) {

    private lateinit var completionPromise: Promise<Nothing>

    override suspend fun executeTask(job: MentorJob) {
        completionPromise =  Promise.promise()
        GlobalScope.launch(job.vertx.dispatcher()) {
            delay(delay)
            completionPromise.complete()
        }
    }

    override fun getAsyncFuture(): Future<Nothing> = completionPromise.future()
}