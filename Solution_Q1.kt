class Solution {

    val UserList2 : HashMap<String, String> = hashMapOf()

    val result : ArrayList<String> = arrayListOf()
    var userArray = arrayListOf<String>()
    var inOutListArray = arrayListOf<Int>()

    fun solution(record: Array<String>): Array<String> {
        for(currentRecord in record) {
            checkCurrentRecord(currentRecord)
        }
        return changeResult().toTypedArray()
    }

    private fun checkCurrentRecord(thisRecord : String) {
        val words = thisRecord.split(" ")
        when(words[0]) {
            "Enter" -> {
                if(UserList2.containsKey(words[1])) {
                    UserList2[words[1]] = words[2]

                } else {
                    UserList2.put(words[1], words[2])

                }
                userArray.add(words[1])
                inOutListArray.add(0)
            }

            "Leave" -> {
                userArray.add(words[1])
                inOutListArray.add(1)
            }

            "Change" -> {
                UserList2[words[1]] = words[2]
            }
        }
    }

    private fun changeResult() : ArrayList<String> {

        for(i in 0 .. inOutListArray.lastIndex){

                var nickName = UserList2[userArray[i]]

                when(inOutListArray[i]) {
                    0 -> {
                        result.add("${nickName}님이 들어왔습니다.")
                    }
                    1 -> {
                        result.add("${nickName}님이 나갔습니다.")
                    }
                }


        }

        return result

    }

}

//테스트
fun main(args:Array<String>) {
    val testcase :Array<String> = arrayOf("Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan")
//    val testcase :Array<String> = arrayOf("Enter uid1234 Muzi",
//            "Enter uit4567 Prodo",
//            "Leave uid1234",
//            "Enter uid1234 Ryai",
//            "Leave uit4567")
    val solution = Solution()
    println(solution.solution(testcase).asList())
}

//Enter uid1234 Muzi, Enter uit4567 Prodo,Leave uid1234,Enter uid1234 Prodo,Cc]