class CircularList {
    private var head : Node? = null
    private var tail : Node? = head
    private var size = 0

    fun push (value: Int) {
        head = Node(value = value)
        head!!.next = head
        if (tail == null){
            tail = head
        }
        size++
    }
    fun append (value: Int){
        if (isEmpty()){
            push(value)
            return
        }
        tail?.next = Node(value = value)

        tail = tail?.next
        size++
    }

    fun nodeAt (index: Int): Node?{
        var currentNode = head
        var currentIndex = 0
        tail?.next = head

        while (currentNode !=null && currentIndex < index){
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun swap(index: Int){
        if(nodeAt(index)?.value==1)
            nodeAt(index)?.value=0
        else nodeAt(index)?.value=1
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