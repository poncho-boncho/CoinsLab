

fun main(args: Array<String>) {
    val coinN = 5
    val coinM = 5
    val s = 6
    var k = 3
    var karetka = -1;


    val list = CircularList()

   for (i in 1..coinM+coinN)
       list.append(0)



    while (k > 0){
        k--
        karetka=karetka+s
        list.swap(karetka)
    }

    println(list.printList())



}


