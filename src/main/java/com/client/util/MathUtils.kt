package com.client.util

object MathUtilss {

    fun getPixelAmt(current : Int, pixels : Int) = (pixels * .01 * current).toInt()

}