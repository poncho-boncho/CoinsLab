class CircularList<T> : Iterable<T> {
    private var head : Node<T>? = null
    private var tail : Node<T>? = null
    var size = 0
    private set
    private var p =0

    fun push (value: T) {
        head = Node(value = value)
        head!!.next = head
        if (tail == null){
            tail = head
        }
        size++
    }

    override fun iterator(): Iterator<T> {
        return LinkedListIterator(this)
    }
    fun append (value: T){
        if (isEmpty()){
            push(value)
            return
        }
        tail?.next = Node(value = value)

        tail = tail?.next
        size++
    }

    fun nodeAt (index: Int): Node<T>?{
        var currentNode = head
        var currentIndex = 0
        tail?.next = head

        while (currentNode !=null && currentIndex < index){
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }
    fun downTails(){
       // var currentNode = head
       // var i = 0
      //  while (nodeAt(i)?.value!=1)
       //     i++
       // nodeAt(i)?.value = 0
    }

    fun getCountCoin(coin : Int): Int{
        var currentNode = head
        var currentIndex = 0
        var count = 0

        while (currentIndex !=size){
            if (currentNode?.value ==coin)
                count++
            currentIndex++
            currentNode = currentNode!!.next
        }
        return count
    }

    fun qwerty(){
        var currentNode = head
        var currentIndex = 0

        while (currentIndex !=size){
            if (currentNode?.value==1)
                p++
            currentIndex++
            currentNode = currentNode!!.next
        }
    }
    fun getP(): Int {
        return p
    }

    fun isEmpty(): Boolean {
        return size == 0
    }
    fun printList(){
        var currentNode = head
        while (currentNode != null){
            println("Значение : ${currentNode.value}, следующий элемент имеет значение : ${currentNode.next?.value}")
            currentNode = currentNode.next
            if (currentNode == head){
                break
            }
        }
    }
}