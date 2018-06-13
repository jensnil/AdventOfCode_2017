package lib

class CircularList<out T>(private val list: List<T>) : List<T> by list {

    override fun get(index: Int): T =
            list[index.safely()]

    // Other overrides removed for brevity.

    private fun Int.safely(): Int =
            if (this < 0) (this % size + size) % size
            else this % size

}

class MutableCircularList<T>(private val list: MutableList<T>) : MutableList<T> by list {

    override fun get(index: Int): T =
            list[index.safely()]

    // Other overrides removed for brevity.

    private fun Int.safely(): Int =
            if (this < 0) (this % size + size) % size
            else this % size

}

fun <T> List<T>.circular() : CircularList<T> = CircularList(this)
fun <T> MutableList<T>.circular() : MutableList<T> = MutableCircularList(this)


fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

