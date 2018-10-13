class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {

        val failureRateArray = getFailure(stages, N)
        val stageAndFailureRateMap2: HashMap<Double, ArrayList<Int>> = HashMap()

        for (i in 1..failureRateArray.lastIndex) {
            if (stageAndFailureRateMap2.containsKey(failureRateArray[i])) {
                stageAndFailureRateMap2.getValue(failureRateArray[i]).add(i)
            } else {
                stageAndFailureRateMap2.put(failureRateArray[i], arrayListOf(i))
            }
        }


        val sortedFailureRateList = mutableListOf<Int>()

//        println(stageAndFailureRateMap2.toSortedMap())

        for (i in stageAndFailureRateMap2.toSortedMap().keys.reversed()) {
//            println(stageAndFailureRateMap2[i])
            sortedFailureRateList.addAll(stageAndFailureRateMap2[i]!!.toList())
        }
        println(sortedFailureRateList)

        return sortedFailureRateList.toIntArray()
    }

    private fun getFailure(stages: IntArray, numOfStages: Int): DoubleArray {

        val stageStopped = IntArray(numOfStages + 1) { 0 }
        val failureRateArray = DoubleArray(numOfStages + 1) { 0.0 }

        for (it in stages) {
            if (it <= stageStopped.lastIndex) {
                stageStopped[it]++
            }
        }

        var stayedPeople = stages.size.toDouble()
        for (i in 1..stageStopped.lastIndex) {
            if(stayedPeople != 0.0) {
                stayedPeople -= stageStopped[i - 1].toDouble()
                if(stayedPeople != 0.0) {
                    failureRateArray[i] = stageStopped[i].toDouble() / stayedPeople
                } else {
                    failureRateArray[i] = 0.0
                }
            } else {
                failureRateArray[i] = 0.0
            }

        }

        return failureRateArray
    }

}


fun main(args: Array<String>) {
    val solution = Solution()
    println(solution.solution(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)))
    println(solution.solution(4, intArrayOf(4, 4, 4, 4, 4)))
    println(solution.solution(3, intArrayOf(3, 2, 4, 1, 2, 3)))
    println(solution.solution(3, intArrayOf(3, 2, 4, 2, 2, 3)))
    println(solution.solution(2, intArrayOf(1, 1, 1, 2, 2, 1, 1)))
}