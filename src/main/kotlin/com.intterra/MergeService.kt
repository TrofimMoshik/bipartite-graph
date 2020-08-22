package com.intterra

import java.util.HashMap

class MergeService {

    fun merge(input: MutableSet<User>): MutableSet<User> {
        val uniqueMails = HashMap<String, User?>()
        val output = HashSet<User>()
        var isMerged = false

        for (user in input) {
            for (mail in user.emails) {
                if (!uniqueMails.containsKey(mail)) {
                    uniqueMails[mail] = user
                    output.add(user)
                } else {
                    uniqueMails[mail]!!.emails.addAll(user.emails)
                    isMerged = true
                    break
                }
            }
        }

        if (isMerged) {
           return merge(output)
        }

        return output

    }

}