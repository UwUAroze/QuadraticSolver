import kotlin.math.sqrt

fun main(args: Array<String>) {


    val a = input("a")
    val b = input("b")
    val c = input("c")

    println("\nAttempting to solve: ${a}x^2 + ${b}x + ${c} = 0...")

    val turn = turningPoint(a, b, c)
    val discrimination = (b*b) - (4*a*c)

    println("\nTurning Point:")
    println("(${turn.first}, ${turn.second})")

    println("\nDiscriminator:")
    println("b^2 - 4ac = ${discrimination}")
    if (discrimination < 0) println("Discriminator is negative, so there are no (real) solutions for x.")
    else {
        val solved = solve(a, b, c)

        if (discrimination == 0.0) println("Discriminator is zero, so there is a singular solution.")
        else println("Discriminator is positive, so there are two real solutions.")

        println("\nFactorisation:")
        println("(x+${solved.first})(x+${solved.second}) = 0".replace("+-", "-"))

        println("\nRoots:")
        println("(+) x = ${solved.first}")
        println("(-) x = ${solved.second}")
    }

}

fun input(x: String) : Double {
    print("Value $x: " )
    var input = readln()
    while (input.toDoubleOrNull() == null) {
        println("Not a number, try again: ")
        input = readln()
    }
    return input.toDouble()
}

fun solve(a: Number = 0, b: Number = 0, c: Number = 0) : Pair<Double, Double> {

    val n = sqrt(((b * b) - (4 * a * c)).toDouble())
    val d = 2 * a
    return Pair((-b+n)/d, (-b-n)/d)

}

fun turningPoint(a: Number = 0, b: Number = 0, c: Number = 0) : Pair<Double, Double> {

    val x = (-b/(2*a))
    val y = (c-((b*b)/(4*a)))
    return Pair(x, y)

}

private operator fun Number.minus(d: Number): Double {
    return this.toDouble() - d.toDouble()
}

private operator fun Number.unaryMinus(): Double {
    return -this.toDouble()
}

private operator fun Number.times(b: Number): Double {
    return this.toDouble() * b.toDouble()
}
