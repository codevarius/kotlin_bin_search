import kotlin.random.Random
import kotlin.system.exitProcess

fun main() {
    val list = BinSearch.generateList(100)
    BinSearch.search(Random(1587693).nextInt(1000),list,0,list.size,0)
}

internal object BinSearch {

    fun search(searchedItem: Int, list: IntArray, vararg args: Int) {

        val startIndex = args[0]
        val endIndex = args[1]
        val midIndex = startIndex + (endIndex - startIndex) / 2
        args[2] += 1

        if (args[2] != list.size) {
            if (list[midIndex] < searchedItem && startIndex != midIndex) {
                search(searchedItem, list, midIndex, list.size, args[2])
            } else {
                if (list[midIndex] > searchedItem && startIndex != midIndex) {
                    search(searchedItem, list, 0, midIndex, args[2])
                } else {
                    if (list[midIndex] == searchedItem) {
                        println("searched item:$searchedItem in list:#{${list.hashCode()}} found\r")
                        exitProcess(0)
                    } else {
                        println("searched item:$searchedItem in list:#{${list.hashCode()}} not found\r")
                    }
                }
            }
        } else {
            println("searched item:$searchedItem in list:#${list.hashCode()} not found\r")
        }
    }

    fun generateList(length: Int): IntArray {
        val random = Random(777)
        val list = IntArray(length)

        for (i in 0 until length) {
            list[i] = random.nextInt(1000)
        }
        list.sort()

        return list
    }
}