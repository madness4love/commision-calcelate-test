import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateCommission_maestroWithoutCommission() {
        val transferType = "Maestro"
        val transferAmount = 7_499_999
        val expected = 0

        val result = calculateCommission(
            transferType = transferType,
            transferAmount = transferAmount)

        assertEquals(expected, result)
    }

    @Test
    fun calculateCommission_maestroCommission() {
        val transferType = "Maestro"
        val transferAmount = 7_500_000
        val expected = 47_000

        val result = calculateCommission(
            transferType = transferType,
            transferAmount = transferAmount)

        assertEquals(expected, result)
    }

    @Test
    fun calculateCommission_visaCommission() {
        val transferType = "Visa"
        val transferAmount = 1_000_000
        val expected = 7_500

        val result = calculateCommission(
            transferType = transferType,
            transferAmount = transferAmount)

        assertEquals(expected, result)
    }

    @Test
    fun calculateCommission_visaMinCommission() {
        val transferType = "Visa"
        val transferAmount = 100_000
        val expected = 3_500

        val result = calculateCommission(
            transferType = transferType,
            transferAmount = transferAmount)

        assertEquals(expected, result)
    }

    @Test
    fun calculateCommission_VKPayCommission() {
        val transferType = "VK Pay"
        val transferAmount = 100_000
        val expected = 0

        val result = calculateCommission(
            transferType = transferType,
            transferAmount = transferAmount)

        assertEquals(expected, result)
    }

    @Test
    fun isInDayLimit_VKPayFalse() {
        val result = isInDayLimit(
            transferType = "VK Pay",
            transferAmount = 1_400_000,
            dayAmount = 100_000
        )

        assertFalse(result)
    }

    @Test
    fun isInMonthLimit_VKPayFalse() {
        val result = isInMonthLimit(
            transferType = "VK Pay",
            transferAmount = 500_000,
            monthAmount = 3_500_000
        )

        assertFalse(result)
    }

    @Test
    fun isInDayLimit_VKPayTrue() {
        val result = isInDayLimit(
            transferType = "VK Pay",
            transferAmount = 1_300_000,
            dayAmount = 100_000
        )

        assertTrue(result)
    }

    @Test
    fun isInMonthLimit_VKPayTrue() {
        val result = isInMonthLimit(
            transferType = "VK Pay",
            transferAmount = 400_000,
            monthAmount = 3_500_000
        )

        assertTrue(result)
    }

    @Test
    fun getDayLimit_visa() {
        val transferType = "Visa"
        val expected = 15_000_000

        val result = getDayLimit(transferType)

        assertEquals(expected, result)
    }

    @Test
    fun getDayLimit_maestro() {
        val transferType = "Maestro"
        val expected = 15_000_000

        val result = getDayLimit(transferType)

        assertEquals(expected, result)
    }

    @Test
    fun getDayLimit_master() {
        val transferType = "Mastercard"
        val expected = 15_000_000

        val result = getDayLimit(transferType)

        assertEquals(expected, result)
    }

    @Test
    fun getDayLimit_mir() {
        val transferType = "Мир"
        val expected = 15_000_000

        val result = getDayLimit(transferType)

        assertEquals(expected, result)
    }



    @Test
    fun getMonthLimit_cards() {
        val transferType = "Visa"
        val expected = 60_000_00

        val result = getMonthLimit(transferType)

        assertEquals(expected, result)
    }

    @Test
    fun getDayLimit_VKPay() {
        val transferType = "VK Pay"
        val expected = 1_500_000

        val result = getDayLimit(transferType)

        assertEquals(expected, result)
    }

    @Test
    fun getDayLimit_else() {
        val transferType = "VKSA"
        val expected = -1

        val result = getDayLimit(transferType)

        assertEquals(expected, result)
    }

    @Test
    fun getMonthLimit_VKPay() {
        val transferType = "VK Pay"
        val expected = 4_000_000

        val result = getMonthLimit(transferType)

        assertEquals(expected, result)
    }

    @Test
    fun getMonthLimit_else() {
        val transferType = "VKPy"
        val expected = -1

        val result = getMonthLimit(transferType)

        assertEquals(expected, result)
    }

    @Test
    fun getMasterMaestroCommission_withoutCommission() {
        val transferAmount = 7_499_999
        val expected = 0

        val result = getMasterMaestroCommission(transferAmount = transferAmount)

        assertEquals(expected, result)
    }

    @Test
    fun getMasterMaestroCommission_withCommission() {
        val transferAmount = 7_500_000
        val expected = 47_000

        val result = getMasterMaestroCommission(transferAmount = transferAmount)

        assertEquals(expected, result)
    }

    @Test
    fun getVisaMirCommission_standardCommission() {
        val transferAmount = 1_000_000
        val expected = 7_500

        val result = getVisaMirCommission(transferAmount)

        assertEquals(expected, result)
    }

    @Test
    fun getVisaMirCommission_minCommission() {
        val transferAmount = 100_000
        val expected = 3_500

        val result = getVisaMirCommission(transferAmount)

        assertEquals(expected, result)
    }

    @Test
    fun isCorrectTransferType_maestro() {
        val transferType = "Maestro"
        val result = isCorrectTransferType(transferType)

        assertTrue(result)
    }

    @Test
    fun isCorrectTransferType_master() {
        val transferType = "Mastercard"
        val result = isCorrectTransferType(transferType)

        assertTrue(result)
    }

    @Test
    fun isCorrectTransferType_visa() {
        val transferType = "Visa"
        val result = isCorrectTransferType(transferType)

        assertTrue(result)
    }

    @Test
    fun isCorrectTransferType_mir() {
        val transferType = "Мир"
        val result = isCorrectTransferType(transferType)

        assertTrue(result)
    }

    @Test
    fun isCorrectTransferType_vkPay() {
        val transferType = "VK Pay"
        val result = isCorrectTransferType(transferType)

        assertTrue(result)
    }





    @Test
    fun isCorrectTransferType_false() {
        val transferType = "VKPAY"
        val result = isCorrectTransferType(transferType)

        assertFalse(result)
    }







}