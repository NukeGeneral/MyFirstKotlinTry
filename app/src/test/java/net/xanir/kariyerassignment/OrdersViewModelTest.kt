package net.xanir.kariyerassignment

import net.xanir.kariyerassignment.orders.OrdersViewModel

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class OrdersViewModelTest {

    private lateinit var viewModel: OrdersViewModel

    @Before
    fun setup(){
        viewModel = OrdersViewModel()
    }

    @Test
    fun isMonthCorrect() {
        assertEquals("Oca", viewModel.findMonthFromInt("0"))
        assertNotEquals("Ara",viewModel.findMonthFromInt("13"))
        assertEquals("May",viewModel.findMonthFromInt("100"))
    }

    @Test
    fun checkColors(){
        assertEquals(R.color.squareYellow,viewModel.determineColor("Hazırlanıyor"))
        assertEquals(R.color.squareGreen,viewModel.determineColor("Yolda"))
        assertEquals(R.color.colorAccent,viewModel.determineColor("Merhaba"))
        assertEquals(R.color.colorAccent,viewModel.determineColor("Onay Bekliyor"))
        assertNotEquals(R.color.squareYellow,viewModel.determineColor("hazırlanıyor"))
    }

    @Test
    fun checkDrawables(){
        assertEquals(R.drawable.square_yellow,viewModel.determineDrawable("Hazırlanıyor"))
        assertEquals(R.drawable.square_green,viewModel.determineDrawable("Yolda"))
        assertEquals(R.drawable.square_red,viewModel.determineDrawable("Merhaba"))
        assertEquals(R.drawable.square_red,viewModel.determineDrawable("Onay Bekliyor"))
        assertNotEquals(R.drawable.square_yellow,viewModel.determineDrawable("hazırlanıyor"))
    }
}