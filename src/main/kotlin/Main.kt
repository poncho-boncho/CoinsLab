import kotlin.random.Random
import kotlin.random.nextInt

fun main(args: Array<String>){
   // var coinN = 6
    println("kolvo monet orlom vverh (N)")
    var coinN = readln().toInt()
    println("kolvo monet reshkoi vverh (M)")
    //5
    var coinM = readln().toInt()
    //3
    println("shag (S)")
    var s = readln().toInt()
    //3
    println("kolvo hodov (K)")
    var k = readln().toInt()
    var karetka = 0;
    //5
    println("itog orlov (L)")
    var l = readln().toInt()
    var v : Int

    var difference = l - coinN





    val list = CircularList<Int>()
    val list2 = CircularList<String>()

   for (i in 1..coinM+coinN)
       list.append(0)

    fun swap(index: Int){
        if(list.nodeAt(index)?.value==1)
            list.nodeAt(index)?.value=0
        else {
            list.nodeAt(index)?.value = 1
        }
    }

    fun minusCoin(_coin: Int): Int {
        var coin = _coin
        return coin--
    }


    fun fullWay(){
        while (k > 0) {
            k--
            karetka = karetka + s
            swap(karetka)
        }
    }
    fullWay()
    list.qwerty()

    if(l>=coinN)
        v = (list.getP()-(l-coinN))/2
    else
        v = (list.getP()-(coinN-l)/2)

    fun downTails(){
         var i = 0
          while (list.nodeAt(i)?.value!=1)
             i++
         list.nodeAt(i)?.value = 2
    }

    fun flipHalfMarked() {
        while (v != 0) {
            v--
            downTails()
        }
    }

    fun flipTheDifference(qw: Int){
        var qww = qw
        while (qww>0){
            qww--
            downTails()
        }
    }
    fun orelIsTrue():Boolean{
        var orel = false
        for (item in list){
            if (item==1)
                orel = true
        }
        return orel
    }
    flipTheDifference(difference)
    flipHalfMarked()

    var pullCoinN =coinN-list.getCountCoin(1)
    var pullCoinM =coinM-list.getCountCoin(2)

    //for (item in list)
    //    println(item)

    if(list.getP()<(l-coinN)){
        println("p malo p = ${list.getP()}")
    }else{
        if (((v*2)%2==0 && v>=0)){
            if((v<=coinN && (v+(l-coinN))<=coinM) || ((v<l && v+(coinN-l)<=coinM))){
                //println("ok")
                if(list.nodeAt(0)?.value==0 && pullCoinN>0 || list.nodeAt(1)?.value==1 && orelIsTrue() ){
                    for (item in list){
                        when (item){

                            0 -> {
                                if (pullCoinM>0 && pullCoinN>0) {
                                    when (Random.nextInt(1..2)) {
                                        1 ->
                                        {list2.append("orel")
                                            pullCoinN--}
                                        2 ->
                                        {list2.append("reshka")
                                            pullCoinM--}
                                    }

                                }else if (pullCoinM > 0){
                                    list2.append("reshka")
                                }else
                                    list2.append("orel")
                            }
                            1 -> list2.append("orel")
                            2 -> list2.append("reshka")
                        }
                    }
                }
                else{
                    println("nevozmojno \n Prichina: s takimi vvodnimi otchet ne mojet nachinatsy s orla")
                }
            }else println("nevozmojno")
        }else println("конфигурация не возможна по присине 2v не четное")
    }
    for (item in list2){
        println(item)
    }
   // }


    //println(list.printList())
   // println(" i = ${list.getP()}")
   // println("L-N = ${l-coinN}")
   // println("2v = ${list.getP()-(l-coinN)}")
   // println((list.getP()-(l-coinN))%2==0)
   // println("0 = ${list.getCountCoin(0)}")
   // println("1 = ${list.getCountCoin(1)}")
   // println("2 = ${list.getCountCoin(2)}")
}


