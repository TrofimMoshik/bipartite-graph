import com.intterra.MergeService
import com.intterra.User
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

class MergeServiceTest {

    private var input = HashSet<User>()

    @AfterEach
    fun after() {
        input.clear()
    }

    @Test
    fun testEmptyInput() {
        assert(MergeService().merge(HashSet()).isEmpty())
    }

    @Test
    fun testOneUserOneMail() {
        input.add(User("user1", hashSetOf("mail1")))
        assert(MergeService().merge(input).size == 1)
    }

    @Test
    fun testOneUserTwoMail() {
        input.add(User("user1", hashSetOf("mail1", "mail2")))
        assert(MergeService().merge(input).size == 1)
    }

    @Test
    fun testTwoUsersOneMail() {
        input.add(User("user1", hashSetOf("mail1")))
        input.add(User("user2", hashSetOf("mail1")))
        assert(MergeService().merge(input).size == 1)
    }

    @Test
    fun testTwoUsersTwoMails() {
        input.add(User("user1", hashSetOf("mail1")))
        input.add(User("user2", hashSetOf("mail2")))
        assert(MergeService().merge(input).size == 2)
    }

    @Test
    fun testThreeUsersChain() {
        input.add(User("user1", hashSetOf("mail1", "mail2")))
        input.add(User("user2", hashSetOf("mail3", "mail4")))
        input.add(User("user3", hashSetOf("mail2", "mail4")))
        assert(MergeService().merge(input).size == 1)
    }

    @Test
    fun testSixUsersChainTwoChains() {
        input.add(User("user1", hashSetOf("mail1", "mail2")))
        input.add(User("user2", hashSetOf("mail3", "mail4")))
        input.add(User("user5", hashSetOf("mail33", "mail44")))
        input.add(User("user3", hashSetOf("mail2", "mail4")))
        input.add(User("user4", hashSetOf("mail11", "mail22")))
        input.add(User("user6", hashSetOf("mail22", "mail44")))
        assert(MergeService().merge(input).size == 2)
    }

}